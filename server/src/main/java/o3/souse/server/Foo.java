package o3.souse.server;

import io.grpc.stub.StreamObserver;
import o3.souse.producer.ResolveMessage;
import o3.souse.producer.SoUseProducerGrpc;

import java.util.ArrayList;
import java.util.List;

public class Foo extends SoUseProducerGrpc.SoUseProducerImplBase {


    @Override
    public StreamObserver<ResolveMessage> resolveStream(StreamObserver<ResolveMessage> responseObserver) {
        return new StreamObserver<>() {
            final List<ResolveMessage> parameters = new ArrayList<>();
            final List<ResolveMessage> answers = new ArrayList<>();

            @Override
            public void onNext(ResolveMessage resolveMessage) {
                parameters.add(resolveMessage);
                if (resolveMessage.hasRequested()) {
                    answers.add(process(resolveMessage.getName(), parameters));
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                try {
                    responseObserver.onNext(ResolveMessage.newBuilder().build());
                } finally {
                    responseObserver.onCompleted();
                }
            }
        };
    }

    private ResolveMessage process(String name, List<ResolveMessage> parameters) {
        return null;
    }
}
