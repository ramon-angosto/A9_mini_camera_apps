package com.google.android.gms.internal.measurement;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzkk {
    static final Charset zza = Charset.forName(C.ASCII_NAME);
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd = new byte[0];
    public static final ByteBuffer zze = ByteBuffer.wrap(zzd);
    public static final zzjf zzf;

    static {
        byte[] bArr = zzd;
        int i = zzjf.zza;
        int length = bArr.length;
        zzjd zzjd = new zzjd(bArr, 0, 0, false, (zzjc) null);
        try {
            zzjd.zza(0);
            zzf = zzjd;
        } catch (zzkm e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int zzd2 = zzd(length, bArr, 0, length);
        if (zzd2 == 0) {
            return 1;
        }
        return zzd2;
    }

    public static int zzc(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static int zzd(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zze(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw null;
    }

    static Object zzf(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    static Object zzg(Object obj, Object obj2) {
        return ((zzlj) obj).zzbJ().zzay((zzlj) obj2).zzaG();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zzb);
    }

    public static boolean zzi(byte[] bArr) {
        return zzna.zze(bArr);
    }
}
