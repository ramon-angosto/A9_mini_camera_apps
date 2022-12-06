package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgql extends zzgpl {
    private static final Logger zza = Logger.getLogger(zzgql.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzb = zzgui.zzA();
    zzgqm zze;

    private zzgql() {
    }

    /* synthetic */ zzgql(zzgqk zzgqk) {
    }

    static int zzA(zzgso zzgso, zzgth zzgth) {
        zzgpf zzgpf = (zzgpf) zzgso;
        int zzas = zzgpf.zzas();
        if (zzas == -1) {
            zzas = zzgth.zza(zzgpf);
            zzgpf.zzav(zzas);
        }
        return zzE(zzas) + zzas;
    }

    static int zzB(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzC(String str) {
        int i;
        try {
            i = zzgun.zze(str);
        } catch (zzgum unused) {
            i = str.getBytes(zzgro.zzb).length;
        }
        return zzE(i) + i;
    }

    public static int zzD(int i) {
        return zzE(i << 3);
    }

    public static int zzE(int i) {
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

    public static int zzF(long j) {
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

    public static zzgql zzG(byte[] bArr) {
        return new zzgqh(bArr, 0, bArr.length);
    }

    public static zzgql zzH(OutputStream outputStream, int i) {
        return new zzgqj(outputStream, i);
    }

    public static int zzw(zzgpw zzgpw) {
        int zzd = zzgpw.zzd();
        return zzE(zzd) + zzd;
    }

    @Deprecated
    static int zzx(int i, zzgso zzgso, zzgth zzgth) {
        int zzE = zzE(i << 3);
        int i2 = zzE + zzE;
        zzgpf zzgpf = (zzgpf) zzgso;
        int zzas = zzgpf.zzas();
        if (zzas == -1) {
            zzas = zzgth.zza(zzgpf);
            zzgpf.zzav(zzas);
        }
        return i2 + zzas;
    }

    public static int zzy(int i) {
        if (i >= 0) {
            return zzE(i);
        }
        return 10;
    }

    public static int zzz(zzgru zzgru) {
        int zza2 = zzgru.zza();
        return zzE(zza2) + zza2;
    }

    public final void zzI() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(String str, zzgum zzgum) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzgum);
        byte[] bytes = str.getBytes(zzgro.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgqi(e);
        }
    }

    public abstract void zzN() throws IOException;

    public abstract void zzO(byte b) throws IOException;

    public abstract void zzP(int i, boolean z) throws IOException;

    public abstract void zzQ(int i, zzgpw zzgpw) throws IOException;

    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzn(int i, zzgso zzgso, zzgth zzgth) throws IOException;

    public abstract void zzo(int i, String str) throws IOException;

    public abstract void zzq(int i, int i2) throws IOException;

    public abstract void zzr(int i, int i2) throws IOException;

    public abstract void zzs(int i) throws IOException;

    public abstract void zzt(int i, long j) throws IOException;

    public abstract void zzu(long j) throws IOException;
}
