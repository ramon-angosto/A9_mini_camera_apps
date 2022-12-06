package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbeu {
    final /* synthetic */ zzbev zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzbeu(zzbev zzbev, byte[] bArr, zzbet zzbet) {
        this.zza = zzbev;
        this.zzb = bArr;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzbev zzbev = this.zza;
            if (zzbev.zzb) {
                zzbev.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            zzcgp.zzf("Clearcut log failed", e);
        }
    }

    public final zzbeu zza(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziG)).booleanValue()) {
            this.zza.zzc.execute(new zzbes(this));
        } else {
            zzd();
        }
    }
}
