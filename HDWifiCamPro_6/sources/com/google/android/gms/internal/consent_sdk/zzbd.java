package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final /* synthetic */ class zzbd implements Runnable {
    public final /* synthetic */ zzbg zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbd(zzbg zzbg, String str) {
        this.zza = zzbg;
        this.zzb = str;
    }

    public final void run() {
        zzce.zza(this.zza, this.zzb);
    }
}
