package o3.souse.server;

import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import o3.souse.producer.ResolveMessage;
import o3.souse.producer.SoUseProducerGrpc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class SoUseProducerImpl extends SoUseProducerGrpc.SoUseProducerImplBase {
    private static final Logger logger = LogManager.getLogger(SoUseProducerImpl.class);
    private final Map<String, ResolveMessage> parameters = new HashMap<>();
    private final Set<String> requests = new HashSet<>();
    private final boolean enableLogging;

    public SoUseProducerImpl(boolean enableLogging) {
        this.enableLogging = enableLogging;
    }

    @Override
    public StreamObserver<ResolveMessage> resolveStream(StreamObserver<ResolveMessage> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(ResolveMessage msg) {
                if (msg.hasRequested()) {
                    requests.add(msg.getName());
                } else {
                    parameters.put(msg.getName(), msg);
                }
                if (enableLogging) {
                    logger.info("received {} {}", (msg.hasRequested() ? "request for " : "parameter "), msg.getName());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                for (String requested : requests) {
                    switch (requested) {
                        case "x" -> {
                            responseObserver.onNext(createResponse("x", "This is X"));
                        }
                        case "y" -> {
                            ResolveMessage x = parameters.get("x");
                            if (x == null || !x.hasBlobValue()) {
                                responseObserver.onError(new StatusException(Status.INVALID_ARGUMENT));
                            } else {
                                var value = x.getBlobValue().toStringUtf8();
                                responseObserver.onNext(createResponse("y", "This is Y for " + value));
                            }
                        }

                    }
                }
                responseObserver.onCompleted();
            }
        };
    }

    private ResolveMessage createResponse(String name, String text) {
        return ResolveMessage.newBuilder()
                .setName(name)
                .setBlobValue(ByteString.copyFromUtf8(text))
                .build();
    }

}


