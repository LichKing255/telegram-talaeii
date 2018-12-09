package org.telegram.messenger.exoplayer2.decoder;

public abstract class Buffer {
    private int flags;

    public final void addFlag(int i) {
        this.flags |= i;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i) {
        this.flags &= i ^ -1;
    }

    protected final boolean getFlag(int i) {
        return (this.flags & i) == i;
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }
}
