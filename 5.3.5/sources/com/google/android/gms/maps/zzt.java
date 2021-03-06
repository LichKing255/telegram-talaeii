package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.model.CameraPosition;

final class zzt extends zzm {
    private /* synthetic */ OnCameraChangeListener zzjam;

    zzt(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
        this.zzjam = onCameraChangeListener;
    }

    public final void onCameraChange(CameraPosition cameraPosition) {
        this.zzjam.onCameraChange(cameraPosition);
    }
}
