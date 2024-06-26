package o3.souse.server;

import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import o3.souse.producer.ResolveMessage;
import o3.souse.producer.SoUseProducerGrpc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

public class ProducerCall implements StreamObserver<ResolveMessage> {
    private static final Logger logger = LogManager.getLogger(ProducerCall.class);
    private final CompletableFuture<ResolveMessage> response = new CompletableFuture<>();
    private final String id;
    private final StreamObserver<ResolveMessage> requestStream;

    public ProducerCall(String id, ManagedChannel channel) {
        this.id = id;
        SoUseProducerGrpc.SoUseProducerStub stub = SoUseProducerGrpc.newStub(channel);
        this.requestStream = stub.resolveStream(new ResponseObserver());
    }

    public CompletableFuture<ResolveMessage> getResponse() {
        return response;
    }

    @Override
    public void onNext(ResolveMessage message) {
        requestStream.onNext(message);
    }

    @Override
    public void onError(Throwable t) {
        requestStream.onError(t);
    }

    @Override
    public void onCompleted() {
        requestStream.onCompleted();
    }

    private class ResponseObserver implements StreamObserver<ResolveMessage> {
        @Override
        public void onNext(ResolveMessage msg) {
            logger.info("{} stream received response: \n{}", id, msg);
            response.complete(msg);
        }

        @Override
        public void onError(Throwable t) {
            logger.error(id + " stream got error", t);
        }

        @Override
        public void onCompleted() {
            logger.info("{} stream completed", id);
        }
    }

}
