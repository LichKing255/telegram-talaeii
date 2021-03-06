package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.Preconditions;

public final class CustomCap extends Cap {
    public final BitmapDescriptor bitmapDescriptor;
    public final float refWidth;

    public CustomCap(BitmapDescriptor bitmapDescriptor) {
        this(bitmapDescriptor, 10.0f);
    }

    public CustomCap(BitmapDescriptor bitmapDescriptor, float f) {
        BitmapDescriptor bitmapDescriptor2 = (BitmapDescriptor) Preconditions.checkNotNull(bitmapDescriptor, "bitmapDescriptor must not be null");
        String str = "refWidth must be positive";
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException(str);
        }
        super(bitmapDescriptor2, f);
        this.bitmapDescriptor = bitmapDescriptor;
        this.refWidth = f;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.bitmapDescriptor);
        return new StringBuilder(String.valueOf(valueOf).length() + 55).append("[CustomCap: bitmapDescriptor=").append(valueOf).append(" refWidth=").append(this.refWidth).append("]").toString();
    }
}
