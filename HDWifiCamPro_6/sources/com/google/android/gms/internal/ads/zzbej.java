package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbej implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbeb zza;
    final /* synthetic */ zzchh zzb;
    final /* synthetic */ zzbel zzc;

    zzbej(zzbel zzbel, zzbeb zzbeb, zzchh zzchh) {
        this.zzc = zzbel;
        this.zza = zzbeb;
        this.zzb = zzchh;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzbel zzbel = this.zzc;
            if (!zzbel.zzb) {
                zzbel.zzb = true;
                zzbea zza2 = this.zzc.zza;
                if (zza2 != null) {
                    zzfzp zza3 = zzchc.zza.zza(new zzbeg(this, zza2, this.zza, this.zzb));
                    zzchh zzchh = this.zzb;
                    zzchh.zzc(new zzbeh(zzchh, zza3), zzchc.zzf);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
