package o3.souse.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import o3.souse.producer.ResolveMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerStreamApplication {
    private static final Logger logger = LogManager.getLogger(ProducerStreamApplication.class);
    private static final int port_1 = 8081;
    private static final int port_2 = 8082;
    private static final int count = 3;

    public static void main(String[] args) {
        Server producerX = startProducer(port_1).join();
        Server producerY = startProducer(port_2).join();

        ManagedChannel xChannel = createChannel(port_1);
        ManagedChannel yChannel = createChannel(port_2);

        long start = System.currentTimeMillis();
        AtomicInteger resultCounter = new AtomicInteger();
        for (int i = 0; i < count; i++) {
            var sample = i + 1;
            ProducerCall xCall = new ProducerCall(sample + "X", xChannel);
            ProducerCall yCall = new ProducerCall(sample + "Y", yChannel);

            // request X
            xCall.onNext(createRequest("x"));
            xCall.onCompleted();

            // pass X to get Y
            xCall.getResponse().thenAccept(msg -> {
                logger.info("{} X response:\n{}", sample, msg);
                if ("x".equals(msg.getName()) && msg.hasBlobValue()) {
                    yCall.onNext(msg);
                    yCall.onNext(createRequest("y"));
                    yCall.onCompleted();
                }
            });

            yCall.getResponse().thenAccept(msg -> {
                logger.info("{} Y response:\n{}", sample, msg);

                // shut down if completed
                if (resultCounter.incrementAndGet() == count) {
                    logger.warn("Test completed in {} millis. Shutting down", System.currentTimeMillis() - start);

                    producerX.shutdown();
                    producerY.shutdown();
                }
            });
        }

    }

    public static CompletableFuture<Server> startProducer(int port) {
        Server server = ServerBuilder
                .forPort(port)
                .addService(new SoUseProducerImpl()).build();
        CompletableFuture<Server> promise = new CompletableFuture<>();

        Thread thread = new Thread(() -> {
            try {
                server.start();
                promise.complete(server);
                server.awaitTermination();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        return promise;
    }

    public static ManagedChannel createChannel(int port) {
        return ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
    }

    private static ResolveMessage createRequest(String name) {
        return ResolveMessage.newBuilder()
                .setName(name)
                .setRequested(true)
                .build();
    }

}
