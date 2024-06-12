package o3.souse.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import o3.souse.producer.ResolveMessage;
import o3.souse.producer.SoUseProducerGrpc;

import java.util.concurrent.CountDownLatch;

import static o3.souse.server.SoUseProducerImpl.createXRequest;
import static o3.souse.server.SoUseProducerImpl.createYRequest;

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
        StreamObserver<ResolveMessage> resolveYResponse = createResolveYResponseStream(pingPongLatch);
        StreamObserver<ResolveMessage> resolveYRequest = stubY.resolveStream(resolveYResponse);
        // X
        StreamObserver<ResolveMessage> resolveXResponse = createResolveXResponseStream(resolveYRequest);
        StreamObserver<ResolveMessage> resolveXRequest = stubX.resolveStream(resolveXResponse);

        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            resolveXRequest.onNext(createXRequest(i + 1));
        }

        pingPongLatch.await();
        double duration = System.nanoTime() - start;
        System.out.println("duration " + (duration / 1_000_000));

        resolveXRequest.onCompleted();
        resolveYRequest.onCompleted();
        serverX.shutdownNow();
        serverY.shutdownNow();
    }

    private static StreamObserver<ResolveMessage> createResolveXResponseStream(StreamObserver<ResolveMessage> resolveYRequest) {
        return new StreamObserver<>() {
            @Override
            public void onNext(ResolveMessage value) {
                if (logEnabled) {
                    System.out.println("received " + value);
                }
                resolveYRequest.onNext(createYRequest(value));
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {

            }
        };
    }

    private static StreamObserver<ResolveMessage> createResolveYResponseStream(CountDownLatch pingPongLatch) {
        return new StreamObserver<>() {
            @Override
            public void onNext(ResolveMessage value) {
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
