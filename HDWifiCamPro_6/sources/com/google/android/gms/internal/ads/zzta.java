package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzta extends zzrr {
    private static final zzbg zza;
    private final zzsk[] zzb;
    private final zzcn[] zzc;
    private final ArrayList zzd;
    private final Map zze;
    private final zzfwj zzf;
    private int zzg = -1;
    private long[][] zzh;
    private zzsz zzi;
    private final zzrt zzj;

    static {
        zzaj zzaj = new zzaj();
        zzaj.zza("MergingMediaSource");
        zza = zzaj.zzc();
    }

    public zzta(boolean z, boolean z2, zzsk... zzskArr) {
        zzrt zzrt = new zzrt();
        this.zzb = zzskArr;
        this.zzj = zzrt;
        this.zzd = new ArrayList(Arrays.asList(zzskArr));
        this.zzc = new zzcn[zzskArr.length];
        this.zzh = new long[0][];
        this.zze = new HashMap();
        this.zzf = zzfwq.zzb(8).zzb(2).zza();
    }

    public final void zzB(zzsg zzsg) {
        zzsy zzsy = (zzsy) zzsg;
        int i = 0;
        while (true) {
            zzsk[] zzskArr = this.zzb;
            if (i < zzskArr.length) {
                zzskArr[i].zzB(zzsy.zzn(i));
                i++;
            } else {
                return;
            }
        }
    }

    public final zzsg zzD(zzsi zzsi, zzwi zzwi, long j) {
        zzsg[] zzsgArr = new zzsg[this.zzb.length];
        int zza2 = this.zzc[0].zza(zzsi.zza);
        for (int i = 0; i < zzsgArr.length; i++) {
            zzsgArr[i] = this.zzb[i].zzD(zzsi.zzc(this.zzc[i].zzf(zza2)), zzwi, j - this.zzh[zza2][i]);
        }
        return new zzsy(this.zzj, this.zzh[zza2], zzsgArr, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzfz zzfz) {
        super.zzn(zzfz);
        for (int i = 0; i < this.zzb.length; i++) {
            zzy(Integer.valueOf(i), this.zzb[i]);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzsi zzv(Object obj, zzsi zzsi) {
        if (((Integer) obj).intValue() == 0) {
            return zzsi;
        }
        return null;
    }

    public final void zzw() throws IOException {
        zzsz zzsz = this.zzi;
        if (zzsz == null) {
            super.zzw();
            return;
        }
        throw zzsz;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzx(Object obj, zzsk zzsk, zzcn zzcn) {
        int i;
        if (this.zzi == null) {
            if (this.zzg == -1) {
                i = zzcn.zzb();
                this.zzg = i;
            } else {
                int zzb2 = zzcn.zzb();
                int i2 = this.zzg;
                if (zzb2 == i2) {
                    i = i2;
                } else {
                    this.zzi = new zzsz(0);
                    return;
                }
            }
            if (this.zzh.length == 0) {
                this.zzh = (long[][]) Array.newInstance(long.class, new int[]{i, this.zzc.length});
            }
            this.zzd.remove(zzsk);
            this.zzc[((Integer) obj).intValue()] = zzcn;
            if (this.zzd.isEmpty()) {
                zzo(this.zzc[0]);
            }
        }
    }

    public final zzbg zzz() {
        zzsk[] zzskArr = this.zzb;
        return zzskArr.length > 0 ? zzskArr[0].zzz() : zza;
    }
}
