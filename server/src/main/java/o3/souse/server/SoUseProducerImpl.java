package o3.souse.server;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import o3.souse.producer.Payload;
import o3.souse.producer.ResolveMessage;
import o3.souse.producer.SoUseProducerGrpc;

public class SoUseProducerImpl extends SoUseProducerGrpc.SoUseProducerImplBase {
    @Override
    public void resolve(ResolveMessage request, StreamObserver<ResolveMessage> responseObserver) {
//        System.out.println("received: " + request);
        doResolve(request, responseObserver);
        responseObserver.onCompleted();
//        System.out.println("completed");
    }

    private void doResolve(ResolveMessage request, StreamObserver<ResolveMessage> responseObserver) {
        for (String name : request.getNamesList()) {
            switch (name) {
                case "x" -> {
                    responseObserver.onNext(createXResponse(request.getRequestId()));
                }
                case "y" -> {
                    Payload payload = request.getPayloads(0);
                    if (payload.getName().equals("x")) {
                        responseObserver.onNext(createYResponse(request.getRequestId()));
                    }
                }
            }
        }

    }

    private ResolveMessage createXResponse(String requestId) {
        return ResolveMessage.newBuilder()
                .setRequestId(requestId)
                .addPayloads(Payload.newBuilder()
                        .setName("x")
                        .setBody(ByteString.copyFromUtf8("true"))
                        .build())
                .build();
    }

    private ResolveMessage createYResponse(String requestId) {
        return ResolveMessage.newBuilder()
                .setRequestId(requestId)
                .addPayloads(Payload.newBuilder()
                        .setName("y")
                        .setBody(ByteString.copyFromUtf8("this is Y"))
                        .build())
                .build();
    }

    @Override
    public StreamObserver<ResolveMessage> resolveStream(StreamObserver<ResolveMessage> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(ResolveMessage ResolveMessage) {
                doResolve(ResolveMessage, responseObserver);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
               // responseObserver.onCompleted();
            }
        };
    }

    public static ResolveMessage createXRequest(int i) {
        return ResolveMessage.newBuilder()
                .setRequestId(String.valueOf(i))
                .addNames("x")
                .build();
    }

    public static ResolveMessage createYRequest(ResolveMessage responseX) {
        return ResolveMessage.newBuilder()
                .addNames("y")
                .setRequestId(responseX.getRequestId())
                .addPayloads(responseX.getPayloads(0))
                .build();
    }
}


