package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgqe {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzgqf zzc;

    /* synthetic */ zzgqe(zzgqd zzgqd) {
    }

    public static int zzF(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzG(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static zzgqe zzH(InputStream inputStream, int i) {
        return new zzgqc(inputStream, 4096, (zzgqb) null);
    }

    static zzgqe zzI(byte[] bArr, int i, int i2, boolean z) {
        zzgpy zzgpy = new zzgpy(bArr, i, i2, z, (zzgpx) null);
        try {
            zzgpy.zze(i2);
            return zzgpy;
        } catch (zzgrq e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract void zzA(int i);

    public abstract boolean zzC() throws IOException;

    public abstract boolean zzD() throws IOException;

    public abstract boolean zzE(int i) throws IOException;

    public abstract double zzb() throws IOException;

    public abstract float zzc() throws IOException;

    public abstract int zzd();

    public abstract int zze(int i) throws zzgrq;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzk() throws IOException;

    public abstract int zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract long zzv() throws IOException;

    public abstract zzgpw zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i) throws zzgrq;
}
