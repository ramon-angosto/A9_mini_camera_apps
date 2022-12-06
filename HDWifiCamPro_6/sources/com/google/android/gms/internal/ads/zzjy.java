package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzjy extends zzgj {
    private final int zzc;
    private final int zzd;
    private final int[] zze;
    private final int[] zzf;
    private final zzcn[] zzg;
    private final Object[] zzh;
    private final HashMap zzi = new HashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjy(Collection collection, zzuc zzuc, byte[] bArr) {
        super(false, zzuc, (byte[]) null);
        int i = 0;
        int size = collection.size();
        this.zze = new int[size];
        this.zzf = new int[size];
        this.zzg = new zzcn[size];
        this.zzh = new Object[size];
        Iterator it = collection.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            zzjn zzjn = (zzjn) it.next();
            this.zzg[i3] = zzjn.zza();
            this.zzf[i3] = i;
            this.zze[i3] = i2;
            i += this.zzg[i3].zzc();
            i2 += this.zzg[i3].zzb();
            this.zzh[i3] = zzjn.zzb();
            this.zzi.put(this.zzh[i3], Integer.valueOf(i3));
            i3++;
        }
        this.zzc = i;
        this.zzd = i2;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final int zzp(Object obj) {
        Integer num = (Integer) this.zzi.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public final int zzq(int i) {
        return zzen.zzc(this.zze, i + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public final int zzr(int i) {
        return zzen.zzc(this.zzf, i + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public final int zzs(int i) {
        return this.zze[i];
    }

    /* access modifiers changed from: protected */
    public final int zzt(int i) {
        return this.zzf[i];
    }

    /* access modifiers changed from: protected */
    public final zzcn zzu(int i) {
        return this.zzg[i];
    }

    /* access modifiers changed from: protected */
    public final Object zzv(int i) {
        return this.zzh[i];
    }

    /* access modifiers changed from: package-private */
    public final List zzw() {
        return Arrays.asList(this.zzg);
    }
}
