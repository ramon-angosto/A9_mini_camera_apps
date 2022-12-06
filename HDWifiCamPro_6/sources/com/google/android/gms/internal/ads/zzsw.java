package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzsw implements zzsg, zzsf {
    /* access modifiers changed from: private */
    public final zzsg zza;
    private final long zzb;
    private zzsf zzc;

    public zzsw(zzsg zzsg, long j) {
        this.zza = zzsg;
        this.zzb = j;
    }

    public final long zza(long j, zzkd zzkd) {
        return this.zza.zza(j - this.zzb, zzkd) + this.zzb;
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb2 + this.zzb;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc2 + this.zzb;
    }

    public final long zzd() {
        long zzd = this.zza.zzd();
        return zzd == C.TIME_UNSET ? C.TIME_UNSET : zzd + this.zzb;
    }

    public final long zze(long j) {
        return this.zza.zze(j - this.zzb) + this.zzb;
    }

    public final long zzf(zzvt[] zzvtArr, boolean[] zArr, zztz[] zztzArr, boolean[] zArr2, long j) {
        zztz[] zztzArr2 = zztzArr;
        zztz[] zztzArr3 = new zztz[zztzArr2.length];
        int i = 0;
        while (true) {
            zztz zztz = null;
            if (i >= zztzArr2.length) {
                break;
            }
            zzsx zzsx = (zzsx) zztzArr2[i];
            if (zzsx != null) {
                zztz = zzsx.zzc();
            }
            zztzArr3[i] = zztz;
            i++;
        }
        long zzf = this.zza.zzf(zzvtArr, zArr, zztzArr3, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zztzArr2.length; i2++) {
            zztz zztz2 = zztzArr3[i2];
            if (zztz2 == null) {
                zztzArr2[i2] = null;
            } else {
                zztz zztz3 = zztzArr2[i2];
                if (zztz3 == null || ((zzsx) zztz3).zzc() != zztz2) {
                    zztzArr2[i2] = new zzsx(zztz2, this.zzb);
                }
            }
        }
        return zzf + this.zzb;
    }

    public final /* bridge */ /* synthetic */ void zzg(zzub zzub) {
        zzsg zzsg = (zzsg) zzub;
        zzsf zzsf = this.zzc;
        if (zzsf != null) {
            zzsf.zzg(this);
            return;
        }
        throw null;
    }

    public final zzuh zzh() {
        return this.zza.zzh();
    }

    public final void zzj(long j, boolean z) {
        this.zza.zzj(j - this.zzb, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zzsf zzsf, long j) {
        this.zzc = zzsf;
        this.zza.zzl(this, j - this.zzb);
    }

    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final boolean zzo(long j) {
        return this.zza.zzo(j - this.zzb);
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }

    public final void zzi(zzsg zzsg) {
        zzsf zzsf = this.zzc;
        if (zzsf != null) {
            zzsf.zzi(this);
            return;
        }
        throw null;
    }
}
