package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzakb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzakd zzc;

    zzakb(zzakd zzakd, String str, long j) {
        this.zzc = zzakd;
        this.zza = str;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzakd zzakd = this.zzc;
        zzakd.zza.zzb(zzakd.toString());
    }
}
