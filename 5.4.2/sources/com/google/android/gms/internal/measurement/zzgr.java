package com.google.android.gms.internal.measurement;

final class zzgr implements Runnable {
    private final /* synthetic */ zzdz zzano;
    private final /* synthetic */ zzgo zzanp;
    private final /* synthetic */ zzee zzanq;

    zzgr(zzgo zzgo, zzee zzee, zzdz zzdz) {
        this.zzanp = zzgo;
        this.zzanq = zzee;
        this.zzano = zzdz;
    }

    public final void run() {
        this.zzanp.zzajy.zzlg();
        this.zzanp.zzajy.zzb(this.zzanq, this.zzano);
    }
}
