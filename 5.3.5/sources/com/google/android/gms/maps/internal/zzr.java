package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Hide;

@Hide
public interface zzr extends IInterface {
    void onCameraMove() throws RemoteException;
}
