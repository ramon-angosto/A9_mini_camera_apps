package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzuf {
    private int zza;
    private final SparseArray zzb;
    private final zzdh zzc;

    public zzuf() {
        zzue zzue = zzue.zza;
        throw null;
    }

    public final Object zzb() {
        SparseArray sparseArray = this.zzb;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public final void zzc(int i, Object obj) {
        boolean z = true;
        if (this.zza == -1) {
            zzdd.zzf(this.zzb.size() == 0);
            this.zza = 0;
        }
        if (this.zzb.size() > 0) {
            SparseArray sparseArray = this.zzb;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i < keyAt) {
                z = false;
            }
            zzdd.zzd(z);
            if (keyAt == i) {
                SparseArray sparseArray2 = this.zzb;
                zzty.zzl((zztw) sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.zzb.append(i, obj);
    }

    public final void zzd() {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzty.zzl((zztw) this.zzb.valueAt(i));
        }
        this.zza = -1;
        this.zzb.clear();
    }

    public final void zze(int i) {
        int i2 = 0;
        while (i2 < this.zzb.size() - 1) {
            int i3 = i2 + 1;
            if (i >= this.zzb.keyAt(i3)) {
                zzty.zzl((zztw) this.zzb.valueAt(i2));
                this.zzb.removeAt(i2);
                int i4 = this.zza;
                if (i4 > 0) {
                    this.zza = i4 - 1;
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public final boolean zzf() {
        return this.zzb.size() == 0;
    }

    public zzuf(zzdh zzdh) {
        this.zzb = new SparseArray();
        this.zzc = zzdh;
        this.zza = -1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x001a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    public final java.lang.Object zza(int r4) {
        /*
            r3 = this;
            int r0 = r3.zza
            r1 = -1
            if (r0 == r1) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = 0
        L_0x0007:
            r3.zza = r0
        L_0x0009:
            int r0 = r3.zza
            if (r0 > 0) goto L_0x000e
            goto L_0x001a
        L_0x000e:
            android.util.SparseArray r2 = r3.zzb
            int r0 = r2.keyAt(r0)
            if (r4 >= r0) goto L_0x001a
            int r0 = r3.zza
            int r0 = r0 + r1
            goto L_0x0007
        L_0x001a:
            int r0 = r3.zza
            android.util.SparseArray r2 = r3.zzb
            int r2 = r2.size()
            int r2 = r2 + r1
            if (r0 >= r2) goto L_0x0038
            android.util.SparseArray r0 = r3.zzb
            int r2 = r3.zza
            int r2 = r2 + 1
            int r0 = r0.keyAt(r2)
            if (r4 < r0) goto L_0x0038
            int r0 = r3.zza
            int r0 = r0 + 1
            r3.zza = r0
            goto L_0x001a
        L_0x0038:
            android.util.SparseArray r4 = r3.zzb
            int r0 = r3.zza
            java.lang.Object r4 = r4.valueAt(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuf.zza(int):java.lang.Object");
    }
}
