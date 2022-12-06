package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzmu {
    final /* synthetic */ zzmv zza;
    /* access modifiers changed from: private */
    public final String zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public zzsi zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zzmu(zzmv zzmv, String str, int i, zzsi zzsi) {
        this.zza = zzmv;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzsi == null ? -1 : zzsi.zzd;
        if (zzsi != null && zzsi.zzb()) {
            this.zze = zzsi;
        }
    }

    public final void zzg(int i, zzsi zzsi) {
        if (this.zzd == -1 && i == this.zzc && zzsi != null) {
            this.zzd = zzsi.zzd;
        }
    }

    public final boolean zzj(int i, zzsi zzsi) {
        if (zzsi == null) {
            return i == this.zzc;
        }
        zzsi zzsi2 = this.zze;
        return zzsi2 == null ? !zzsi.zzb() && zzsi.zzd == this.zzd : zzsi.zzd == zzsi2.zzd && zzsi.zzb == zzsi2.zzb && zzsi.zzc == zzsi2.zzc;
    }

    public final boolean zzk(zzkp zzkp) {
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        zzsi zzsi = zzkp.zzd;
        if (zzsi == null) {
            return this.zzc != zzkp.zzc;
        }
        if (zzsi.zzd > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        int zza2 = zzkp.zzb.zza(zzsi.zza);
        int zza3 = zzkp.zzb.zza(this.zze.zza);
        zzsi zzsi2 = zzkp.zzd;
        if (zzsi2.zzd < this.zze.zzd || zza2 < zza3) {
            return false;
        }
        if (zza2 > zza3) {
            return true;
        }
        if (zzsi2.zzb()) {
            zzsi zzsi3 = zzkp.zzd;
            int i = zzsi3.zzb;
            int i2 = zzsi3.zzc;
            zzsi zzsi4 = this.zze;
            int i3 = zzsi4.zzb;
            if (i > i3) {
                return true;
            }
            if (i == i3) {
                return i2 > zzsi4.zzc;
            }
            return false;
        }
        int i4 = zzkp.zzd.zze;
        return i4 == -1 || i4 > this.zze.zzb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 < r8.zzc()) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzl(com.google.android.gms.internal.ads.zzcn r7, com.google.android.gms.internal.ads.zzcn r8) {
        /*
            r6 = this;
            int r0 = r6.zzc
            int r1 = r7.zzc()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L_0x0013
            int r7 = r8.zzc()
            if (r0 >= r7) goto L_0x0011
            goto L_0x004a
        L_0x0011:
            r0 = r3
            goto L_0x004a
        L_0x0013:
            com.google.android.gms.internal.ads.zzmv r1 = r6.zza
            com.google.android.gms.internal.ads.zzcm r1 = r1.zzc
            r4 = 0
            r7.zze(r0, r1, r4)
            com.google.android.gms.internal.ads.zzmv r0 = r6.zza
            com.google.android.gms.internal.ads.zzcm r0 = r0.zzc
            int r0 = r0.zzo
        L_0x0026:
            com.google.android.gms.internal.ads.zzmv r1 = r6.zza
            com.google.android.gms.internal.ads.zzcm r1 = r1.zzc
            int r1 = r1.zzp
            if (r0 > r1) goto L_0x0011
            java.lang.Object r1 = r7.zzf(r0)
            int r1 = r8.zza(r1)
            if (r1 == r3) goto L_0x0047
            com.google.android.gms.internal.ads.zzmv r7 = r6.zza
            com.google.android.gms.internal.ads.zzck r7 = r7.zzd
            com.google.android.gms.internal.ads.zzck r7 = r8.zzd(r1, r7, r2)
            int r0 = r7.zzd
            goto L_0x004a
        L_0x0047:
            int r0 = r0 + 1
            goto L_0x0026
        L_0x004a:
            r6.zzc = r0
            if (r0 != r3) goto L_0x004f
            return r2
        L_0x004f:
            com.google.android.gms.internal.ads.zzsi r7 = r6.zze
            r0 = 1
            if (r7 != 0) goto L_0x0055
            return r0
        L_0x0055:
            java.lang.Object r7 = r7.zza
            int r7 = r8.zza(r7)
            if (r7 == r3) goto L_0x005e
            return r0
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmu.zzl(com.google.android.gms.internal.ads.zzcn, com.google.android.gms.internal.ads.zzcn):boolean");
    }
}
