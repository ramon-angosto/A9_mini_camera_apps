package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfoy {
    final /* synthetic */ zzfoz zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzfoy(zzfoz zzfoz, byte[] bArr, zzfox zzfox) {
        this.zza = zzfoz;
        this.zzb = bArr;
    }

    public final zzfoy zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzfoy zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzfoz zzfoz = this.zza;
            if (zzfoz.zzb) {
                zzfoz.zza.zzj(this.zzb);
                this.zza.zza.zzi(this.zzc);
                this.zza.zza.zzg(this.zzd);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }
}
