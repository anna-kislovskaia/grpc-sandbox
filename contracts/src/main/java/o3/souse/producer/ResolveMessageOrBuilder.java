// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: producer.proto

package o3.souse.producer;

public interface ResolveMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:producer.ResolveMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>bytes blobValue = 2;</code>
   * @return Whether the blobValue field is set.
   */
  boolean hasBlobValue();
  /**
   * <code>bytes blobValue = 2;</code>
   * @return The blobValue.
   */
  com.google.protobuf.ByteString getBlobValue();

  /**
   * <code>int32 intValue = 3;</code>
   * @return Whether the intValue field is set.
   */
  boolean hasIntValue();
  /**
   * <code>int32 intValue = 3;</code>
   * @return The intValue.
   */
  int getIntValue();

  /**
   * <code>float fpValue = 4;</code>
   * @return Whether the fpValue field is set.
   */
  boolean hasFpValue();
  /**
   * <code>float fpValue = 4;</code>
   * @return The fpValue.
   */
  float getFpValue();

  /**
   * <code>bool boolValue = 5;</code>
   * @return Whether the boolValue field is set.
   */
  boolean hasBoolValue();
  /**
   * <code>bool boolValue = 5;</code>
   * @return The boolValue.
   */
  boolean getBoolValue();

  /**
   * <code>bool requested = 6;</code>
   * @return Whether the requested field is set.
   */
  boolean hasRequested();
  /**
   * <code>bool requested = 6;</code>
   * @return The requested.
   */
  boolean getRequested();

  public o3.souse.producer.ResolveMessage.PayloadCase getPayloadCase();
}
