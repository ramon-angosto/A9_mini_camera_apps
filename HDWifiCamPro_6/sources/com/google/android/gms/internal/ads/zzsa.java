package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzsa implements zzsg, zzsf {
    public final zzsi zza;
    private final long zzb;
    private zzsk zzc;
    private zzsg zzd;
    private zzsf zze;
    private long zzf = C.TIME_UNSET;
    private final zzwi zzg;

    public zzsa(zzsi zzsi, zzwi zzwi, long j, byte[] bArr) {
        this.zza = zzsi;
        this.zzg = zzwi;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != C.TIME_UNSET ? j2 : j;
    }

    public final long zza(long j, zzkd zzkd) {
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        return zzsg.zza(j, zzkd);
    }

    public final long zzb() {
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        return zzsg.zzb();
    }

    public final long zzc() {
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        return zzsg.zzc();
    }

    public final long zzd() {
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        return zzsg.zzd();
    }

    public final long zze(long j) {
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        return zzsg.zze(j);
    }

    public final long zzf(zzvt[] zzvtArr, boolean[] zArr, zztz[] zztzArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.zzf;
        if (j3 == C.TIME_UNSET || j != this.zzb) {
            j2 = j;
        } else {
            this.zzf = C.TIME_UNSET;
            j2 = j3;
        }
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        return zzsg.zzf(zzvtArr, zArr, zztzArr, zArr2, j2);
    }

    public final /* bridge */ /* synthetic */ void zzg(zzub zzub) {
        zzsg zzsg = (zzsg) zzub;
        zzsf zzsf = this.zze;
        int i = zzen.zza;
        zzsf.zzg(this);
    }

    public final zzuh zzh() {
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        return zzsg.zzh();
    }

    public final void zzi(zzsg zzsg) {
        zzsf zzsf = this.zze;
        int i = zzen.zza;
        zzsf.zzi(this);
    }

    public final void zzj(long j, boolean z) {
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        zzsg.zzj(j, false);
    }

    public final void zzk() throws IOException {
        try {
            zzsg zzsg = this.zzd;
            if (zzsg != null) {
                zzsg.zzk();
                return;
            }
            zzsk zzsk = this.zzc;
            if (zzsk != null) {
                zzsk.zzw();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public final void zzl(zzsf zzsf, long j) {
        this.zze = zzsf;
        zzsg zzsg = this.zzd;
        if (zzsg != null) {
            zzsg.zzl(this, zzv(this.zzb));
        }
    }

    public final void zzm(long j) {
        zzsg zzsg = this.zzd;
        int i = zzen.zza;
        zzsg.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    public final boolean zzo(long j) {
        zzsg zzsg = this.zzd;
        return zzsg != null && zzsg.zzo(j);
    }

    public final boolean zzp() {
        zzsg zzsg = this.zzd;
        return zzsg != null && zzsg.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzsi zzsi) {
        long zzv = zzv(this.zzb);
        zzsk zzsk = this.zzc;
        if (zzsk != null) {
            this.zzd = zzsk.zzD(zzsi, this.zzg, zzv);
            if (this.zze != null) {
                this.zzd.zzl(this, zzv);
                return;
            }
            return;
        }
        throw null;
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzu(zzsk zzsk) {
        zzdd.zzf(this.zzc == null);
        this.zzc = zzsk;
    }

    public final void zzt() {
        zzsg zzsg = this.zzd;
        if (zzsg != null) {
            zzsk zzsk = this.zzc;
            if (zzsk != null) {
                zzsk.zzB(zzsg);
                return;
            }
            throw null;
        }
    }
}
