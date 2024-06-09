package o3.souse.producer;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.1)",
    comments = "Source: producer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SoUseProducerGrpc {

  private SoUseProducerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "producer.SoUseProducer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<o3.souse.producer.ResolveRequest,
      o3.souse.producer.ResolveResponse> getResolveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resolve",
      requestType = o3.souse.producer.ResolveRequest.class,
      responseType = o3.souse.producer.ResolveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<o3.souse.producer.ResolveRequest,
      o3.souse.producer.ResolveResponse> getResolveMethod() {
    io.grpc.MethodDescriptor<o3.souse.producer.ResolveRequest, o3.souse.producer.ResolveResponse> getResolveMethod;
    if ((getResolveMethod = SoUseProducerGrpc.getResolveMethod) == null) {
      synchronized (SoUseProducerGrpc.class) {
        if ((getResolveMethod = SoUseProducerGrpc.getResolveMethod) == null) {
          SoUseProducerGrpc.getResolveMethod = getResolveMethod =
              io.grpc.MethodDescriptor.<o3.souse.producer.ResolveRequest, o3.souse.producer.ResolveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "resolve"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  o3.souse.producer.ResolveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  o3.souse.producer.ResolveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SoUseProducerMethodDescriptorSupplier("resolve"))
              .build();
        }
      }
    }
    return getResolveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<o3.souse.producer.ResolveRequest,
      o3.souse.producer.ResolveResponse> getResolveStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resolveStream",
      requestType = o3.souse.producer.ResolveRequest.class,
      responseType = o3.souse.producer.ResolveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<o3.souse.producer.ResolveRequest,
      o3.souse.producer.ResolveResponse> getResolveStreamMethod() {
    io.grpc.MethodDescriptor<o3.souse.producer.ResolveRequest, o3.souse.producer.ResolveResponse> getResolveStreamMethod;
    if ((getResolveStreamMethod = SoUseProducerGrpc.getResolveStreamMethod) == null) {
      synchronized (SoUseProducerGrpc.class) {
        if ((getResolveStreamMethod = SoUseProducerGrpc.getResolveStreamMethod) == null) {
          SoUseProducerGrpc.getResolveStreamMethod = getResolveStreamMethod =
              io.grpc.MethodDescriptor.<o3.souse.producer.ResolveRequest, o3.souse.producer.ResolveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "resolveStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  o3.souse.producer.ResolveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  o3.souse.producer.ResolveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SoUseProducerMethodDescriptorSupplier("resolveStream"))
              .build();
        }
      }
    }
    return getResolveStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SoUseProducerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoUseProducerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoUseProducerStub>() {
        @java.lang.Override
        public SoUseProducerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoUseProducerStub(channel, callOptions);
        }
      };
    return SoUseProducerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SoUseProducerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoUseProducerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoUseProducerBlockingStub>() {
        @java.lang.Override
        public SoUseProducerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoUseProducerBlockingStub(channel, callOptions);
        }
      };
    return SoUseProducerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SoUseProducerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoUseProducerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoUseProducerFutureStub>() {
        @java.lang.Override
        public SoUseProducerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoUseProducerFutureStub(channel, callOptions);
        }
      };
    return SoUseProducerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void resolve(o3.souse.producer.ResolveRequest request,
        io.grpc.stub.StreamObserver<o3.souse.producer.ResolveResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResolveMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<o3.souse.producer.ResolveRequest> resolveStream(
        io.grpc.stub.StreamObserver<o3.souse.producer.ResolveResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getResolveStreamMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SoUseProducer.
   */
  public static abstract class SoUseProducerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SoUseProducerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SoUseProducer.
   */
  public static final class SoUseProducerStub
      extends io.grpc.stub.AbstractAsyncStub<SoUseProducerStub> {
    private SoUseProducerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoUseProducerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoUseProducerStub(channel, callOptions);
    }

    /**
     */
    public void resolve(o3.souse.producer.ResolveRequest request,
        io.grpc.stub.StreamObserver<o3.souse.producer.ResolveResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResolveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<o3.souse.producer.ResolveRequest> resolveStream(
        io.grpc.stub.StreamObserver<o3.souse.producer.ResolveResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getResolveStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SoUseProducer.
   */
  public static final class SoUseProducerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SoUseProducerBlockingStub> {
    private SoUseProducerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoUseProducerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoUseProducerBlockingStub(channel, callOptions);
    }

    /**
     */
    public o3.souse.producer.ResolveResponse resolve(o3.souse.producer.ResolveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolveMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SoUseProducer.
   */
  public static final class SoUseProducerFutureStub
      extends io.grpc.stub.AbstractFutureStub<SoUseProducerFutureStub> {
    private SoUseProducerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoUseProducerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoUseProducerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<o3.souse.producer.ResolveResponse> resolve(
        o3.souse.producer.ResolveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResolveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESOLVE = 0;
  private static final int METHODID_RESOLVE_STREAM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RESOLVE:
          serviceImpl.resolve((o3.souse.producer.ResolveRequest) request,
              (io.grpc.stub.StreamObserver<o3.souse.producer.ResolveResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RESOLVE_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.resolveStream(
              (io.grpc.stub.StreamObserver<o3.souse.producer.ResolveResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getResolveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              o3.souse.producer.ResolveRequest,
              o3.souse.producer.ResolveResponse>(
                service, METHODID_RESOLVE)))
        .addMethod(
          getResolveStreamMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              o3.souse.producer.ResolveRequest,
              o3.souse.producer.ResolveResponse>(
                service, METHODID_RESOLVE_STREAM)))
        .build();
  }

  private static abstract class SoUseProducerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SoUseProducerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return o3.souse.producer.SoUseProducerService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SoUseProducer");
    }
  }

  private static final class SoUseProducerFileDescriptorSupplier
      extends SoUseProducerBaseDescriptorSupplier {
    SoUseProducerFileDescriptorSupplier() {}
  }

  private static final class SoUseProducerMethodDescriptorSupplier
      extends SoUseProducerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SoUseProducerMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SoUseProducerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SoUseProducerFileDescriptorSupplier())
              .addMethod(getResolveMethod())
              .addMethod(getResolveStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
