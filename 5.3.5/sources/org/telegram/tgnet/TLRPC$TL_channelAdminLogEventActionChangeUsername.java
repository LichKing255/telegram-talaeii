package org.telegram.tgnet;

public class TLRPC$TL_channelAdminLogEventActionChangeUsername extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1783299128;
    public String new_value;

    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_value = stream.readString(exception);
        this.new_value = stream.readString(exception);
    }

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.prev_value);
        stream.writeString(this.new_value);
    }
}
