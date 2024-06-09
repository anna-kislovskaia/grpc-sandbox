package o3.souse.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import o3.souse.producer.ResolveRequest;
import o3.souse.producer.ResolveResponse;
import o3.souse.producer.SoUseProducerGrpc;

import java.util.concurrent.CountDownLatch;

public class ProducerStreamApplication {
    private static final int port_1 = 8081;
    private static final int port_2 = 8082;
    private static final int count = 10_000;
    private static final boolean logEnabled = false;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Server serverX = startServer(port_1, latch);
        Server serverY = startServer(port_2, latch);
        latch.await();

        SoUseProducerGrpc.SoUseProducerStub stubX = getClientStub(port_1);
        SoUseProducerGrpc.SoUseProducerStub stubY = getClientStub(port_2);

        CountDownLatch pingPongLatch = new CountDownLatch(count);
        // Y
        StreamObserver<ResolveResponse> resolveYResponse = new StreamObserver<>() {
            @Override
            public void onNext(ResolveResponse value) {
                if (logEnabled) {
                    System.out.println("received " + value);
                }
                pingPongLatch.countDown();
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {

            }
        };
        StreamObserver<ResolveRequest> resolveYRequest = stubY.resolveStream(resolveYResponse);

        // X
        StreamObserver<ResolveResponse> resolveXResponse = new StreamObserver<>() {
            @Override
            public void onNext(ResolveResponse value) {
                if (logEnabled) {
                    System.out.println("received " + value);
                }
                ResolveRequest requestY = ResolveRequest.newBuilder()
                        .addNames("y")
                        .setRequestId(value.getRequestId())
                        .addPayloads(value.getPayloads(0))
                        .build();
                resolveYRequest.onNext(requestY);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {

            }
        };
       StreamObserver<ResolveRequest> resolveXRequest = stubX.resolveStream(resolveXResponse);

        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            ResolveRequest requestX = ResolveRequest.newBuilder()
                    .setRequestId(String.valueOf(i + 1))
                    .addNames("x")
                    .build();

            resolveXRequest.onNext(requestX);
        }

        pingPongLatch.await();
        double duration = System.nanoTime() - start;
        System.out.println("duration " + (duration / 1_000_000));

        resolveXRequest.onCompleted();
        resolveYRequest.onCompleted();
        serverX.shutdownNow();
        serverY.shutdownNow();
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

    public static SoUseProducerGrpc.SoUseProducerStub getClientStub(int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();

        return SoUseProducerGrpc.newStub(channel);
    }

}
