package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public abstract class zzjj extends zzir {
    private static final Logger zzb = Logger.getLogger(zzjj.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzmv.zzx();
    zzjk zza;

    private zzjj() {
    }

    /* synthetic */ zzjj(zzji zzji) {
    }

    public static int zzA(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzB(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static zzjj zzC(byte[] bArr) {
        return new zzjg(bArr, 0, bArr.length);
    }

    public static int zzt(zzjb zzjb) {
        int zzd = zzjb.zzd();
        return zzA(zzd) + zzd;
    }

    @Deprecated
    static int zzu(int i, zzlj zzlj, zzlu zzlu) {
        int zzA = zzA(i << 3);
        int i2 = zzA + zzA;
        zzil zzil = (zzil) zzlj;
        int zzbu = zzil.zzbu();
        if (zzbu == -1) {
            zzbu = zzlu.zza(zzil);
            zzil.zzbx(zzbu);
        }
        return i2 + zzbu;
    }

    public static int zzv(int i) {
        if (i >= 0) {
            return zzA(i);
        }
        return 10;
    }

    public static int zzw(zzkp zzkp) {
        int zza2 = zzkp.zza();
        return zzA(zza2) + zza2;
    }

    static int zzx(zzlj zzlj, zzlu zzlu) {
        zzil zzil = (zzil) zzlj;
        int zzbu = zzil.zzbu();
        if (zzbu == -1) {
            zzbu = zzlu.zza(zzil);
            zzil.zzbx(zzbu);
        }
        return zzA(zzbu) + zzbu;
    }

    public static int zzy(String str) {
        int i;
        try {
            i = zzna.zzc(str);
        } catch (zzmz unused) {
            i = str.getBytes(zzkk.zzb).length;
        }
        return zzA(i) + i;
    }

    public static int zzz(int i) {
        return zzA(i << 3);
    }

    public final void zzD() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(String str, zzmz zzmz) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzmz);
        byte[] bytes = str.getBytes(zzkk.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzjh(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzd(int i, boolean z) throws IOException;

    public abstract void zze(int i, zzjb zzjb) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzm(int i, String str) throws IOException;

    public abstract void zzo(int i, int i2) throws IOException;

    public abstract void zzp(int i, int i2) throws IOException;

    public abstract void zzq(int i) throws IOException;

    public abstract void zzr(int i, long j) throws IOException;

    public abstract void zzs(long j) throws IOException;
}
