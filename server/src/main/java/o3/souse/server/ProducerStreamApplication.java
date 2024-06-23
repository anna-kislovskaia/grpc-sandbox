package o3.souse.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import o3.souse.producer.ResolveMessage;
import o3.souse.producer.SoUseProducerGrpc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class ProducerStreamApplication {
    private static final Logger logger = LogManager.getLogger(ProducerStreamApplication.class);
    private static final int port_1 = 8081;
    private static final int port_2 = 8082;
    private static final int count = 3;
    private static final boolean logEnabled = true;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Server serverX = startServer(port_1, logEnabled, latch);
        Server serverY = startServer(port_2, logEnabled, latch);
        latch.await();

        SoUseProducerGrpc.SoUseProducerStub stubX = getClientStub(port_1);
        SoUseProducerGrpc.SoUseProducerStub stubY = getClientStub(port_2);

        for (int i = 0; i < count; i++) {
            var sample = i + 1;
            CompletableFuture<ResolveMessage> yFut = new CompletableFuture<>();
            StreamObserver<ResolveMessage> resolveYRequest = stubY.resolveStream(createResponseStream(sample + "Y", yFut));

            CompletableFuture<ResolveMessage> xFut = new CompletableFuture<>();
            StreamObserver<ResolveMessage> resolveXRequest = stubX.resolveStream(createResponseStream(sample + "X", xFut));

            resolveXRequest.onNext(createRequest("x"));
            resolveXRequest.onCompleted();

            xFut.thenAccept(msg -> {
                logger.info("{} X response:\n{}", sample, msg);
                if ("x".equals(msg.getName()) && msg.hasBlobValue()) {
                    resolveYRequest.onNext(msg);
                    resolveYRequest.onNext(createRequest("y"));
                    resolveYRequest.onCompleted();
                }
            });

            yFut.thenAccept(msg -> {
                logger.info("{} Y response:\n{}", sample, msg);
            });
        }

//        serverX.shutdown();
//        serverY.shutdown();
    }

    private static StreamObserver<ResolveMessage> createResponseStream(String id, CompletableFuture<ResolveMessage> fut) {
        return new StreamObserver<>() {
            @Override
            public void onNext(ResolveMessage msg) {
                if (logEnabled) {
                    logger.info("{} stream received response: \n{}", id, msg);
                }
                fut.complete(msg);
            }

            @Override
            public void onError(Throwable t) {
                logger.error(id + " stream got error", t);
            }

            @Override
            public void onCompleted() {
                logger.info("{} stream completed", id);
            }
        };
    }

    public static Server startServer(int port, boolean logEnabled, CountDownLatch latch) {
        Server server = ServerBuilder
                .forPort(port)
                .addService(new SoUseProducerImpl(logEnabled)).build();

        Thread thread = new Thread(() -> {
            try {
                server.start();
                latch.countDown();
                server.awaitTermination();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        return server;
    }

    public static SoUseProducerGrpc.SoUseProducerStub getClientStub(int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();

        return SoUseProducerGrpc.newStub(channel);
    }

    private static ResolveMessage createRequest(String name) {
        return ResolveMessage.newBuilder()
                .setName(name)
                .setRequested(true)
                .build();
    }

}
