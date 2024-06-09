package o3.souse.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import o3.souse.producer.ResolveRequest;
import o3.souse.producer.ResolveResponse;
import o3.souse.producer.SoUseProducerGrpc;

import java.util.concurrent.CountDownLatch;

public class ProducerUnaryCallApplication {
    private static final int port_1 = 8081;
    private static final int port_2 = 8082;
    private static final int count = 10_000;
    private static final boolean logEnabled = false;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Server s1 = startServer(port_1, latch);
        Server s2 = startServer(port_2, latch);
        latch.await();

        SoUseProducerGrpc.SoUseProducerBlockingStub stubX = getBlockingClientStub(port_1);
        SoUseProducerGrpc.SoUseProducerBlockingStub stubY = getBlockingClientStub(port_2);

        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            ResolveRequest requestX = ResolveRequest.newBuilder()
                    .setRequestId(String.valueOf(i + 1))
                    .addNames("x")
                    .build();

            ResolveResponse responseX = stubX.resolve(requestX);
            if (logEnabled) {
                System.out.println(responseX);
            }

            ResolveRequest requestY = ResolveRequest.newBuilder()
                    .addNames("y")
                    .addPayloads(responseX.getPayloads(0))
                    .build();
            ResolveResponse responseY = stubY.resolve(requestY);
            if (logEnabled) {
                System.out.println(responseY);
            }
        }
        double duration = System.nanoTime() - start;
        System.out.println("duration " + (duration / 1000_000));


        s1.shutdown();
        s2.shutdown();
    }

    public static Server startServer(int port, CountDownLatch latch) {
        Server server = ServerBuilder
                .forPort(port)
                .addService(new SoUseProducerImpl()).build();

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

    public static SoUseProducerGrpc.SoUseProducerBlockingStub getBlockingClientStub(int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();

        return SoUseProducerGrpc.newBlockingStub(channel);
    }

}
