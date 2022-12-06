package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzazp {
    private final zzazj[] zza = new zzazj[1];
    private int zzb;
    private int zzc;
    private int zzd = 0;
    private zzazj[] zze = new zzazj[100];

    public zzazp(boolean z, int i) {
    }

    public final synchronized int zza() {
        return this.zzc * 65536;
    }

    public final synchronized zzazj zzb() {
        zzazj zzazj;
        this.zzc++;
        int i = this.zzd;
        if (i > 0) {
            zzazj[] zzazjArr = this.zze;
            int i2 = i - 1;
            this.zzd = i2;
            zzazj = zzazjArr[i2];
            zzazjArr[i2] = null;
        } else {
            zzazj = new zzazj(new byte[65536], 0);
        }
        return zzazj;
    }

    public final synchronized void zzc(zzazj zzazj) {
        zzazj[] zzazjArr = this.zza;
        zzazjArr[0] = zzazj;
        zzd(zzazjArr);
    }

    public final synchronized void zzd(zzazj[] zzazjArr) {
        int i = this.zzd;
        int i2 = i + r1;
        zzazj[] zzazjArr2 = this.zze;
        int length = zzazjArr2.length;
        if (i2 >= length) {
            this.zze = (zzazj[]) Arrays.copyOf(zzazjArr2, Math.max(length + length, i2));
        }
        for (zzazj zzazj : zzazjArr) {
            byte[] bArr = zzazj.zza;
            zzazj[] zzazjArr3 = this.zze;
            int i3 = this.zzd;
            this.zzd = i3 + 1;
            zzazjArr3[i3] = zzazj;
        }
        this.zzc -= zzazjArr.length;
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zzb;
        this.zzb = i;
        if (i < i2) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int max = Math.max(0, zzbar.zzd(this.zzb, 65536) - this.zzc);
        int i = this.zzd;
        if (max < i) {
            Arrays.fill(this.zze, max, i, (Object) null);
            this.zzd = max;
        }
    }
}
