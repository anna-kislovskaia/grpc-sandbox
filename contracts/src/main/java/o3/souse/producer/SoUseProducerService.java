// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: producer.proto

package o3.souse.producer;

public final class SoUseProducerService {
  private SoUseProducerService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_producer_ResolveMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_producer_ResolveMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_producer_Payload_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_producer_Payload_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016producer.proto\022\010producer\"X\n\016ResolveMes" +
      "sage\022\022\n\nrequest_id\030\001 \001(\t\022\r\n\005names\030\002 \003(\t\022" +
      "#\n\010payloads\030\003 \003(\0132\021.producer.Payload\"%\n\007" +
      "Payload\022\014\n\004name\030\001 \001(\t\022\014\n\004body\030\002 \001(\0142\233\001\n\r" +
      "SoUseProducer\022?\n\007resolve\022\030.producer.Reso" +
      "lveMessage\032\030.producer.ResolveMessage\"\000\022I" +
      "\n\rresolveStream\022\030.producer.ResolveMessag" +
      "e\032\030.producer.ResolveMessage\"\000(\0010\001B+\n\021o3." +
      "souse.producerB\024SoUseProducerServiceP\001b\006" +
      "proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_producer_ResolveMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_producer_ResolveMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_producer_ResolveMessage_descriptor,
        new java.lang.String[] { "RequestId", "Names", "Payloads", });
    internal_static_producer_Payload_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_producer_Payload_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_producer_Payload_descriptor,
        new java.lang.String[] { "Name", "Body", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
