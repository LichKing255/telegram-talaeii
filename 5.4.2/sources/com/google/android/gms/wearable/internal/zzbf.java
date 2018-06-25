package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzbf implements zzc<ChannelListener> {
    private final /* synthetic */ IntentFilter[] zzbr;
    private final /* synthetic */ String zzcs;

    zzbf(String str, IntentFilter[] intentFilterArr) {
        this.zzcs = str;
        this.zzbr = intentFilterArr;
    }

    public final /* synthetic */ void zza(zzhg zzhg, ResultHolder resultHolder, Object obj, ListenerHolder listenerHolder) {
        zzhg.zza(resultHolder, (ChannelListener) obj, listenerHolder, this.zzcs, this.zzbr);
    }
}
