package com.google.android.gms.internal.ads;

import android.os.Build;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbar {
    public static final int zza;
    public static final String zzb = Build.DEVICE;
    public static final String zzc = Build.MANUFACTURER;
    public static final String zzd = Build.MODEL;
    public static final String zze;
    private static final Pattern zzf = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern zzg = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern zzh = Pattern.compile("%([A-Fa-f0-9]{2})");

    static {
        int i;
        if (Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i = 26;
        } else {
            i = Build.VERSION.SDK_INT;
        }
        zza = i;
        String str = zzb;
        String str2 = zzd;
        String str3 = zzc;
        int i2 = zza;
        zze = str + ", " + str2 + ", " + str3 + ", " + i2;
    }

    public static float zza(float f, float f2, float f3) {
        return Math.max(0.1f, Math.min(f, 8.0f));
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(long[] r3, long r4, boolean r6, boolean r7) {
        /*
            int r0 = java.util.Arrays.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x0008
            int r4 = ~r0
            goto L_0x0019
        L_0x0008:
            int r0 = r0 + 1
            int r1 = r3.length
            if (r0 >= r1) goto L_0x0013
            r1 = r3[r0]
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0008
        L_0x0013:
            if (r6 == 0) goto L_0x0018
            int r4 = r0 + -1
            goto L_0x0019
        L_0x0018:
            r4 = r0
        L_0x0019:
            if (r7 == 0) goto L_0x0023
            int r3 = r3.length
            int r3 = r3 + -1
            int r3 = java.lang.Math.min(r3, r4)
            return r3
        L_0x0023:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbar.zzb(long[], long, boolean, boolean):int");
    }

    public static int zzc(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j) {
                    i = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j);
            i = binarySearch + 1;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static int zzd(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int zze(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static int zzf(int i) {
        return i != 1 ? C.DEFAULT_VIDEO_BUFFER_SIZE : C.DEFAULT_AUDIO_BUFFER_SIZE;
    }

    public static int zzg(String str) {
        int length = str.length();
        zzbac.zzc(length <= 4);
        char c = 0;
        for (int i = 0; i < length; i++) {
            c = (c << 8) | str.charAt(i);
        }
        return c;
    }

    public static int zzh(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i != 24) {
            return i != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static int zzi(int i, int i2) {
        if (i == Integer.MIN_VALUE) {
            return i2 * 3;
        }
        if (i == 1073741824) {
            return i2 * 4;
        }
        if (i == 2) {
            return i2 + i2;
        }
        if (i == 3) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static long zzj(long j, long j2, long j3) {
        int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i < 0 || j3 % j2 != 0) {
            return (i >= 0 || j2 % j3 != 0) ? (long) (((double) j) * (((double) j2) / ((double) j3))) : j * (j2 / j3);
        }
        return j / (j3 / j2);
    }

    public static String zzk(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int length = objArr.length;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < length - 1) {
                sb.append(", ");
            }
            i++;
        }
    }

    public static ExecutorService zzl(String str) {
        return Executors.newSingleThreadExecutor(new zzbaq("Loader:ExtractorMediaPeriod"));
    }

    public static void zzm(zzazm zzazm) {
        if (zzazm != null) {
            try {
                zzazm.zzd();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean zzo(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static byte[] zzp(String str) {
        byte[] bArr = new byte[38];
        for (int i = 0; i < 38; i++) {
            int i2 = i + i;
            bArr[i] = (byte) ((Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i2), 16) << 4) + Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static byte[] zzq(String str) {
        return str.getBytes(Charset.defaultCharset());
    }

    public static void zzn(long[] jArr, long j, long j2) {
        int i = (j2 > 1000000 ? 1 : (j2 == 1000000 ? 0 : -1));
        int i2 = 0;
        if (i >= 0 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j3;
                i2++;
            }
        } else if (i >= 0 || 1000000 % j2 != 0) {
            double d = 1000000.0d / ((double) j2);
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) jArr[i2]) * d);
                i2++;
            }
        } else {
            long j4 = 1000000 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j4;
                i2++;
            }
        }
    }
}
