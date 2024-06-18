// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: producer.proto

package o3.souse.producer;

/**
 * Protobuf type {@code producer.ResolveMessage}
 */
public final class ResolveMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:producer.ResolveMessage)
    ResolveMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ResolveMessage.newBuilder() to construct.
  private ResolveMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ResolveMessage() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ResolveMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ResolveMessage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 18: {
            o3.souse.producer.Payload.Builder subBuilder = null;
            if (valueCase_ == 2) {
              subBuilder = ((o3.souse.producer.Payload) value_).toBuilder();
            }
            value_ =
                input.readMessage(o3.souse.producer.Payload.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((o3.souse.producer.Payload) value_);
              value_ = subBuilder.buildPartial();
            }
            valueCase_ = 2;
            break;
          }
          case 24: {
            valueCase_ = 3;
            value_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return o3.souse.producer.SoUseProducerService.internal_static_producer_ResolveMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return o3.souse.producer.SoUseProducerService.internal_static_producer_ResolveMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            o3.souse.producer.ResolveMessage.class, o3.souse.producer.ResolveMessage.Builder.class);
  }

  private int valueCase_ = 0;
  private java.lang.Object value_;
  public enum ValueCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    PAYLOADS(2),
    REQUESTED(3),
    VALUE_NOT_SET(0);
    private final int value;
    private ValueCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ValueCase valueOf(int value) {
      return forNumber(value);
    }

    public static ValueCase forNumber(int value) {
      switch (value) {
        case 2: return PAYLOADS;
        case 3: return REQUESTED;
        case 0: return VALUE_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public ValueCase
  getValueCase() {
    return ValueCase.forNumber(
        valueCase_);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PAYLOADS_FIELD_NUMBER = 2;
  /**
   * <code>.producer.Payload payloads = 2;</code>
   * @return Whether the payloads field is set.
   */
  @java.lang.Override
  public boolean hasPayloads() {
    return valueCase_ == 2;
  }
  /**
   * <code>.producer.Payload payloads = 2;</code>
   * @return The payloads.
   */
  @java.lang.Override
  public o3.souse.producer.Payload getPayloads() {
    if (valueCase_ == 2) {
       return (o3.souse.producer.Payload) value_;
    }
    return o3.souse.producer.Payload.getDefaultInstance();
  }
  /**
   * <code>.producer.Payload payloads = 2;</code>
   */
  @java.lang.Override
  public o3.souse.producer.PayloadOrBuilder getPayloadsOrBuilder() {
    if (valueCase_ == 2) {
       return (o3.souse.producer.Payload) value_;
    }
    return o3.souse.producer.Payload.getDefaultInstance();
  }

  public static final int REQUESTED_FIELD_NUMBER = 3;
  /**
   * <code>bool requested = 3;</code>
   * @return Whether the requested field is set.
   */
  @java.lang.Override
  public boolean hasRequested() {
    return valueCase_ == 3;
  }
  /**
   * <code>bool requested = 3;</code>
   * @return The requested.
   */
  @java.lang.Override
  public boolean getRequested() {
    if (valueCase_ == 3) {
      return (java.lang.Boolean) value_;
    }
    return false;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (valueCase_ == 2) {
      output.writeMessage(2, (o3.souse.producer.Payload) value_);
    }
    if (valueCase_ == 3) {
      output.writeBool(
          3, (boolean)((java.lang.Boolean) value_));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (valueCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (o3.souse.producer.Payload) value_);
    }
    if (valueCase_ == 3) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(
            3, (boolean)((java.lang.Boolean) value_));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof o3.souse.producer.ResolveMessage)) {
      return super.equals(obj);
    }
    o3.souse.producer.ResolveMessage other = (o3.souse.producer.ResolveMessage) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (!getValueCase().equals(other.getValueCase())) return false;
    switch (valueCase_) {
      case 2:
        if (!getPayloads()
            .equals(other.getPayloads())) return false;
        break;
      case 3:
        if (getRequested()
            != other.getRequested()) return false;
        break;
      case 0:
      default:
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    switch (valueCase_) {
      case 2:
        hash = (37 * hash) + PAYLOADS_FIELD_NUMBER;
        hash = (53 * hash) + getPayloads().hashCode();
        break;
      case 3:
        hash = (37 * hash) + REQUESTED_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
            getRequested());
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static o3.souse.producer.ResolveMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static o3.souse.producer.ResolveMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static o3.souse.producer.ResolveMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static o3.souse.producer.ResolveMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(o3.souse.producer.ResolveMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code producer.ResolveMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:producer.ResolveMessage)
      o3.souse.producer.ResolveMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return o3.souse.producer.SoUseProducerService.internal_static_producer_ResolveMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return o3.souse.producer.SoUseProducerService.internal_static_producer_ResolveMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              o3.souse.producer.ResolveMessage.class, o3.souse.producer.ResolveMessage.Builder.class);
    }

    // Construct using o3.souse.producer.ResolveMessage.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      name_ = "";

      valueCase_ = 0;
      value_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return o3.souse.producer.SoUseProducerService.internal_static_producer_ResolveMessage_descriptor;
    }

    @java.lang.Override
    public o3.souse.producer.ResolveMessage getDefaultInstanceForType() {
      return o3.souse.producer.ResolveMessage.getDefaultInstance();
    }

    @java.lang.Override
    public o3.souse.producer.ResolveMessage build() {
      o3.souse.producer.ResolveMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public o3.souse.producer.ResolveMessage buildPartial() {
      o3.souse.producer.ResolveMessage result = new o3.souse.producer.ResolveMessage(this);
      result.name_ = name_;
      if (valueCase_ == 2) {
        if (payloadsBuilder_ == null) {
          result.value_ = value_;
        } else {
          result.value_ = payloadsBuilder_.build();
        }
      }
      if (valueCase_ == 3) {
        result.value_ = value_;
      }
      result.valueCase_ = valueCase_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof o3.souse.producer.ResolveMessage) {
        return mergeFrom((o3.souse.producer.ResolveMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(o3.souse.producer.ResolveMessage other) {
      if (other == o3.souse.producer.ResolveMessage.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      switch (other.getValueCase()) {
        case PAYLOADS: {
          mergePayloads(other.getPayloads());
          break;
        }
        case REQUESTED: {
          setRequested(other.getRequested());
          break;
        }
        case VALUE_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      o3.souse.producer.ResolveMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (o3.souse.producer.ResolveMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int valueCase_ = 0;
    private java.lang.Object value_;
    public ValueCase
        getValueCase() {
      return ValueCase.forNumber(
          valueCase_);
    }

    public Builder clearValue() {
      valueCase_ = 0;
      value_ = null;
      onChanged();
      return this;
    }


    private java.lang.Object name_ = "";
    /**
     * <code>string name = 1;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        o3.souse.producer.Payload, o3.souse.producer.Payload.Builder, o3.souse.producer.PayloadOrBuilder> payloadsBuilder_;
    /**
     * <code>.producer.Payload payloads = 2;</code>
     * @return Whether the payloads field is set.
     */
    @java.lang.Override
    public boolean hasPayloads() {
      return valueCase_ == 2;
    }
    /**
     * <code>.producer.Payload payloads = 2;</code>
     * @return The payloads.
     */
    @java.lang.Override
    public o3.souse.producer.Payload getPayloads() {
      if (payloadsBuilder_ == null) {
        if (valueCase_ == 2) {
          return (o3.souse.producer.Payload) value_;
        }
        return o3.souse.producer.Payload.getDefaultInstance();
      } else {
        if (valueCase_ == 2) {
          return payloadsBuilder_.getMessage();
        }
        return o3.souse.producer.Payload.getDefaultInstance();
      }
    }
    /**
     * <code>.producer.Payload payloads = 2;</code>
     */
    public Builder setPayloads(o3.souse.producer.Payload value) {
      if (payloadsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        value_ = value;
        onChanged();
      } else {
        payloadsBuilder_.setMessage(value);
      }
      valueCase_ = 2;
      return this;
    }
    /**
     * <code>.producer.Payload payloads = 2;</code>
     */
    public Builder setPayloads(
        o3.souse.producer.Payload.Builder builderForValue) {
      if (payloadsBuilder_ == null) {
        value_ = builderForValue.build();
        onChanged();
      } else {
        payloadsBuilder_.setMessage(builderForValue.build());
      }
      valueCase_ = 2;
      return this;
    }
    /**
     * <code>.producer.Payload payloads = 2;</code>
     */
    public Builder mergePayloads(o3.souse.producer.Payload value) {
      if (payloadsBuilder_ == null) {
        if (valueCase_ == 2 &&
            value_ != o3.souse.producer.Payload.getDefaultInstance()) {
          value_ = o3.souse.producer.Payload.newBuilder((o3.souse.producer.Payload) value_)
              .mergeFrom(value).buildPartial();
        } else {
          value_ = value;
        }
        onChanged();
      } else {
        if (valueCase_ == 2) {
          payloadsBuilder_.mergeFrom(value);
        }
        payloadsBuilder_.setMessage(value);
      }
      valueCase_ = 2;
      return this;
    }
    /**
     * <code>.producer.Payload payloads = 2;</code>
     */
    public Builder clearPayloads() {
      if (payloadsBuilder_ == null) {
        if (valueCase_ == 2) {
          valueCase_ = 0;
          value_ = null;
          onChanged();
        }
      } else {
        if (valueCase_ == 2) {
          valueCase_ = 0;
          value_ = null;
        }
        payloadsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.producer.Payload payloads = 2;</code>
     */
    public o3.souse.producer.Payload.Builder getPayloadsBuilder() {
      return getPayloadsFieldBuilder().getBuilder();
    }
    /**
     * <code>.producer.Payload payloads = 2;</code>
     */
    @java.lang.Override
    public o3.souse.producer.PayloadOrBuilder getPayloadsOrBuilder() {
      if ((valueCase_ == 2) && (payloadsBuilder_ != null)) {
        return payloadsBuilder_.getMessageOrBuilder();
      } else {
        if (valueCase_ == 2) {
          return (o3.souse.producer.Payload) value_;
        }
        return o3.souse.producer.Payload.getDefaultInstance();
      }
    }
    /**
     * <code>.producer.Payload payloads = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        o3.souse.producer.Payload, o3.souse.producer.Payload.Builder, o3.souse.producer.PayloadOrBuilder> 
        getPayloadsFieldBuilder() {
      if (payloadsBuilder_ == null) {
        if (!(valueCase_ == 2)) {
          value_ = o3.souse.producer.Payload.getDefaultInstance();
        }
        payloadsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            o3.souse.producer.Payload, o3.souse.producer.Payload.Builder, o3.souse.producer.PayloadOrBuilder>(
                (o3.souse.producer.Payload) value_,
                getParentForChildren(),
                isClean());
        value_ = null;
      }
      valueCase_ = 2;
      onChanged();;
      return payloadsBuilder_;
    }

    /**
     * <code>bool requested = 3;</code>
     * @return Whether the requested field is set.
     */
    public boolean hasRequested() {
      return valueCase_ == 3;
    }
    /**
     * <code>bool requested = 3;</code>
     * @return The requested.
     */
    public boolean getRequested() {
      if (valueCase_ == 3) {
        return (java.lang.Boolean) value_;
      }
      return false;
    }
    /**
     * <code>bool requested = 3;</code>
     * @param value The requested to set.
     * @return This builder for chaining.
     */
    public Builder setRequested(boolean value) {
      valueCase_ = 3;
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool requested = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearRequested() {
      if (valueCase_ == 3) {
        valueCase_ = 0;
        value_ = null;
        onChanged();
      }
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:producer.ResolveMessage)
  }

  // @@protoc_insertion_point(class_scope:producer.ResolveMessage)
  private static final o3.souse.producer.ResolveMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new o3.souse.producer.ResolveMessage();
  }

  public static o3.souse.producer.ResolveMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ResolveMessage>
      PARSER = new com.google.protobuf.AbstractParser<ResolveMessage>() {
    @java.lang.Override
    public ResolveMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ResolveMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ResolveMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ResolveMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public o3.souse.producer.ResolveMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

