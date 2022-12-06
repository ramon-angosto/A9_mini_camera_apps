package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zztq extends zzrj implements zzth {
    private final zzbg zza;
    private final zzay zzb;
    private final zzew zzc;
    private final zzpq zzd;
    private final int zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;
    private zzfz zzj;
    private final zztn zzk;
    private final zzwm zzl;

    /* synthetic */ zztq(zzbg zzbg, zzew zzew, zztn zztn, zzpq zzpq, zzwm zzwm, int i, zztp zztp, byte[] bArr) {
        zzay zzay = zzbg.zzd;
        if (zzay != null) {
            this.zzb = zzay;
            this.zza = zzbg;
            this.zzc = zzew;
            this.zzk = zztn;
            this.zzd = zzpq;
            this.zzl = zzwm;
            this.zze = i;
            this.zzf = true;
            this.zzg = C.TIME_UNSET;
            return;
        }
        throw null;
    }

    private final void zzv() {
        long j = this.zzg;
        boolean z = this.zzh;
        boolean z2 = this.zzi;
        zzbg zzbg = this.zza;
        zzcn zzcn = r1;
        zzud zzud = new zzud(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j, j, 0, 0, z, false, false, (Object) null, zzbg, z2 ? zzbg.zzf : null);
        zzo(this.zzf ? new zztm(this, zzcn) : zzcn);
    }

    public final void zzB(zzsg zzsg) {
        ((zztl) zzsg).zzM();
    }

    public final zzsg zzD(zzsi zzsi, zzwi zzwi, long j) {
        zzex zza2 = this.zzc.zza();
        zzfz zzfz = this.zzj;
        if (zzfz != null) {
            zza2.zzf(zzfz);
        }
        Uri uri = this.zzb.zza;
        zztn zztn = this.zzk;
        zzb();
        zzrl zzrl = new zzrl(zztn.zza);
        zzpq zzpq = this.zzd;
        zzpk zzc2 = zzc(zzsi);
        zzwm zzwm = this.zzl;
        zzsr zze2 = zze(zzsi);
        String str = this.zzb.zzf;
        return new zztl(uri, zza2, zzrl, zzpq, zzc2, zzwm, zze2, this, zzwi, (String) null, this.zze, (byte[]) null);
    }

    public final void zza(long j, boolean z, boolean z2) {
        if (j == C.TIME_UNSET) {
            j = this.zzg;
        }
        if (this.zzf || this.zzg != j || this.zzh != z || this.zzi != z2) {
            this.zzg = j;
            this.zzh = z;
            this.zzi = z2;
            this.zzf = false;
            zzv();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzfz zzfz) {
        this.zzj = zzfz;
        if (Looper.myLooper() != null) {
            zzb();
            zzv();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
    }

    public final void zzw() {
    }

    public final zzbg zzz() {
        return this.zza;
    }
}
