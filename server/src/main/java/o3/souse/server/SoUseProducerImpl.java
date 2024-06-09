package o3.souse.server;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import o3.souse.producer.Payload;
import o3.souse.producer.ResolveRequest;
import o3.souse.producer.ResolveResponse;
import o3.souse.producer.SoUseProducerGrpc;

public class SoUseProducerImpl extends SoUseProducerGrpc.SoUseProducerImplBase {
    @Override
    public void resolve(ResolveRequest request, StreamObserver<ResolveResponse> responseObserver) {
//        System.out.println("received: " + request);
        doResolve(request, responseObserver);
        responseObserver.onCompleted();
//        System.out.println("completed");
    }

    private void doResolve(ResolveRequest request, StreamObserver<ResolveResponse> responseObserver) {
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

    private ResolveResponse createXResponse(String requestId) {
        return ResolveResponse.newBuilder()
                .setRequestId(requestId)
                .addPayloads(Payload.newBuilder()
                        .setName("x")
                        .setBody(ByteString.copyFromUtf8("true"))
                        .build())
                .build();
    }

    private ResolveResponse createYResponse(String requestId) {
        return ResolveResponse.newBuilder()
                .setRequestId(requestId)
                .addPayloads(Payload.newBuilder()
                        .setName("y")
                        .setBody(ByteString.copyFromUtf8("this is Y"))
                        .build())
                .build();
    }

    @Override
    public StreamObserver<ResolveRequest> resolveStream(StreamObserver<ResolveResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(ResolveRequest resolveRequest) {
                doResolve(resolveRequest, responseObserver);
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
}
