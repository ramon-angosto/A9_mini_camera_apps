package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfvp {
    Object[] zza;
    int zzb;
    zzfvo zzc;

    public zzfvp() {
        this(4);
    }

    private final void zzd(int i) {
        int i2 = i + i;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzfvh.zzd(length, i2));
        }
    }

    public final zzfvp zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfum.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfvp zzb(java.lang.Iterable r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 == 0) goto L_0x000e
            int r0 = r2.zzb
            int r1 = r3.size()
            int r0 = r0 + r1
            r2.zzd(r0)
        L_0x000e:
            java.util.Iterator r3 = r3.iterator()
        L_0x0012:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            r2.zza(r1, r0)
            goto L_0x0012
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvp.zzb(java.lang.Iterable):com.google.android.gms.internal.ads.zzfvp");
    }

    public final zzfvq zzc() {
        zzfvo zzfvo = this.zzc;
        if (zzfvo == null) {
            zzfxb zzi = zzfxb.zzi(this.zzb, this.zza, this);
            zzfvo zzfvo2 = this.zzc;
            if (zzfvo2 == null) {
                return zzi;
            }
            throw zzfvo2.zza();
        }
        throw zzfvo.zza();
    }

    zzfvp(int i) {
        this.zza = new Object[(i + i)];
        this.zzb = 0;
    }
}
