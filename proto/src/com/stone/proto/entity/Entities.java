// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Entity.proto

package com.stone.proto.entity;

public final class Entities {
  private Entities() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface HumanItemOrBuilder extends
      // @@protoc_insertion_point(interface_extends:HumanItem)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int64 humanGuid = 1;</code>
     */
    boolean hasHumanGuid();
    /**
     * <code>required int64 humanGuid = 1;</code>
     */
    long getHumanGuid();

    /**
     * <code>required .Item item = 2;</code>
     */
    boolean hasItem();
    /**
     * <code>required .Item item = 2;</code>
     */
    com.stone.proto.common.Commons.Item getItem();
    /**
     * <code>required .Item item = 2;</code>
     */
    com.stone.proto.common.Commons.ItemOrBuilder getItemOrBuilder();
  }
  /**
   * Protobuf type {@code HumanItem}
   *
   * <pre>
   * ItemEntity
   * </pre>
   */
  public static final class HumanItem extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:HumanItem)
      HumanItemOrBuilder {
    // Use HumanItem.newBuilder() to construct.
    private HumanItem(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private HumanItem(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final HumanItem defaultInstance;
    public static HumanItem getDefaultInstance() {
      return defaultInstance;
    }

    public HumanItem getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private HumanItem(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              humanGuid_ = input.readInt64();
              break;
            }
            case 18: {
              com.stone.proto.common.Commons.Item.Builder subBuilder = null;
              if (((bitField0_ & 0x00000002) == 0x00000002)) {
                subBuilder = item_.toBuilder();
              }
              item_ = input.readMessage(com.stone.proto.common.Commons.Item.PARSER, extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(item_);
                item_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000002;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.stone.proto.entity.Entities.internal_static_HumanItem_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.stone.proto.entity.Entities.internal_static_HumanItem_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.stone.proto.entity.Entities.HumanItem.class, com.stone.proto.entity.Entities.HumanItem.Builder.class);
    }

    public static com.google.protobuf.Parser<HumanItem> PARSER =
        new com.google.protobuf.AbstractParser<HumanItem>() {
      public HumanItem parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new HumanItem(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<HumanItem> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int HUMANGUID_FIELD_NUMBER = 1;
    private long humanGuid_;
    /**
     * <code>required int64 humanGuid = 1;</code>
     */
    public boolean hasHumanGuid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int64 humanGuid = 1;</code>
     */
    public long getHumanGuid() {
      return humanGuid_;
    }

    public static final int ITEM_FIELD_NUMBER = 2;
    private com.stone.proto.common.Commons.Item item_;
    /**
     * <code>required .Item item = 2;</code>
     */
    public boolean hasItem() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required .Item item = 2;</code>
     */
    public com.stone.proto.common.Commons.Item getItem() {
      return item_;
    }
    /**
     * <code>required .Item item = 2;</code>
     */
    public com.stone.proto.common.Commons.ItemOrBuilder getItemOrBuilder() {
      return item_;
    }

    private void initFields() {
      humanGuid_ = 0L;
      item_ = com.stone.proto.common.Commons.Item.getDefaultInstance();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasHumanGuid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasItem()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!getItem().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, humanGuid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeMessage(2, item_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, humanGuid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, item_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.stone.proto.entity.Entities.HumanItem parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.stone.proto.entity.Entities.HumanItem parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.stone.proto.entity.Entities.HumanItem prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code HumanItem}
     *
     * <pre>
     * ItemEntity
     * </pre>
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:HumanItem)
        com.stone.proto.entity.Entities.HumanItemOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.stone.proto.entity.Entities.internal_static_HumanItem_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.stone.proto.entity.Entities.internal_static_HumanItem_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.stone.proto.entity.Entities.HumanItem.class, com.stone.proto.entity.Entities.HumanItem.Builder.class);
      }

      // Construct using com.stone.proto.entity.Entities.HumanItem.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getItemFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        humanGuid_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        if (itemBuilder_ == null) {
          item_ = com.stone.proto.common.Commons.Item.getDefaultInstance();
        } else {
          itemBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.stone.proto.entity.Entities.internal_static_HumanItem_descriptor;
      }

      public com.stone.proto.entity.Entities.HumanItem getDefaultInstanceForType() {
        return com.stone.proto.entity.Entities.HumanItem.getDefaultInstance();
      }

      public com.stone.proto.entity.Entities.HumanItem build() {
        com.stone.proto.entity.Entities.HumanItem result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.stone.proto.entity.Entities.HumanItem buildPartial() {
        com.stone.proto.entity.Entities.HumanItem result = new com.stone.proto.entity.Entities.HumanItem(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.humanGuid_ = humanGuid_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        if (itemBuilder_ == null) {
          result.item_ = item_;
        } else {
          result.item_ = itemBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.stone.proto.entity.Entities.HumanItem) {
          return mergeFrom((com.stone.proto.entity.Entities.HumanItem)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.stone.proto.entity.Entities.HumanItem other) {
        if (other == com.stone.proto.entity.Entities.HumanItem.getDefaultInstance()) return this;
        if (other.hasHumanGuid()) {
          setHumanGuid(other.getHumanGuid());
        }
        if (other.hasItem()) {
          mergeItem(other.getItem());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasHumanGuid()) {
          
          return false;
        }
        if (!hasItem()) {
          
          return false;
        }
        if (!getItem().isInitialized()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.stone.proto.entity.Entities.HumanItem parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.stone.proto.entity.Entities.HumanItem) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private long humanGuid_ ;
      /**
       * <code>required int64 humanGuid = 1;</code>
       */
      public boolean hasHumanGuid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int64 humanGuid = 1;</code>
       */
      public long getHumanGuid() {
        return humanGuid_;
      }
      /**
       * <code>required int64 humanGuid = 1;</code>
       */
      public Builder setHumanGuid(long value) {
        bitField0_ |= 0x00000001;
        humanGuid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 humanGuid = 1;</code>
       */
      public Builder clearHumanGuid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        humanGuid_ = 0L;
        onChanged();
        return this;
      }

      private com.stone.proto.common.Commons.Item item_ = com.stone.proto.common.Commons.Item.getDefaultInstance();
      private com.google.protobuf.SingleFieldBuilder<
          com.stone.proto.common.Commons.Item, com.stone.proto.common.Commons.Item.Builder, com.stone.proto.common.Commons.ItemOrBuilder> itemBuilder_;
      /**
       * <code>required .Item item = 2;</code>
       */
      public boolean hasItem() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required .Item item = 2;</code>
       */
      public com.stone.proto.common.Commons.Item getItem() {
        if (itemBuilder_ == null) {
          return item_;
        } else {
          return itemBuilder_.getMessage();
        }
      }
      /**
       * <code>required .Item item = 2;</code>
       */
      public Builder setItem(com.stone.proto.common.Commons.Item value) {
        if (itemBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          item_ = value;
          onChanged();
        } else {
          itemBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>required .Item item = 2;</code>
       */
      public Builder setItem(
          com.stone.proto.common.Commons.Item.Builder builderForValue) {
        if (itemBuilder_ == null) {
          item_ = builderForValue.build();
          onChanged();
        } else {
          itemBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>required .Item item = 2;</code>
       */
      public Builder mergeItem(com.stone.proto.common.Commons.Item value) {
        if (itemBuilder_ == null) {
          if (((bitField0_ & 0x00000002) == 0x00000002) &&
              item_ != com.stone.proto.common.Commons.Item.getDefaultInstance()) {
            item_ =
              com.stone.proto.common.Commons.Item.newBuilder(item_).mergeFrom(value).buildPartial();
          } else {
            item_ = value;
          }
          onChanged();
        } else {
          itemBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>required .Item item = 2;</code>
       */
      public Builder clearItem() {
        if (itemBuilder_ == null) {
          item_ = com.stone.proto.common.Commons.Item.getDefaultInstance();
          onChanged();
        } else {
          itemBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }
      /**
       * <code>required .Item item = 2;</code>
       */
      public com.stone.proto.common.Commons.Item.Builder getItemBuilder() {
        bitField0_ |= 0x00000002;
        onChanged();
        return getItemFieldBuilder().getBuilder();
      }
      /**
       * <code>required .Item item = 2;</code>
       */
      public com.stone.proto.common.Commons.ItemOrBuilder getItemOrBuilder() {
        if (itemBuilder_ != null) {
          return itemBuilder_.getMessageOrBuilder();
        } else {
          return item_;
        }
      }
      /**
       * <code>required .Item item = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilder<
          com.stone.proto.common.Commons.Item, com.stone.proto.common.Commons.Item.Builder, com.stone.proto.common.Commons.ItemOrBuilder> 
          getItemFieldBuilder() {
        if (itemBuilder_ == null) {
          itemBuilder_ = new com.google.protobuf.SingleFieldBuilder<
              com.stone.proto.common.Commons.Item, com.stone.proto.common.Commons.Item.Builder, com.stone.proto.common.Commons.ItemOrBuilder>(
                  getItem(),
                  getParentForChildren(),
                  isClean());
          item_ = null;
        }
        return itemBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:HumanItem)
    }

    static {
      defaultInstance = new HumanItem(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:HumanItem)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HumanItem_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_HumanItem_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Entity.proto\032\014Common.proto\"3\n\tHumanIte" +
      "m\022\021\n\thumanGuid\030\001 \002(\003\022\023\n\004item\030\002 \002(\0132\005.Ite" +
      "mB\"\n\026com.stone.proto.entityB\010Entities"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.stone.proto.common.Commons.getDescriptor(),
        }, assigner);
    internal_static_HumanItem_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_HumanItem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_HumanItem_descriptor,
        new java.lang.String[] { "HumanGuid", "Item", });
    com.stone.proto.common.Commons.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
