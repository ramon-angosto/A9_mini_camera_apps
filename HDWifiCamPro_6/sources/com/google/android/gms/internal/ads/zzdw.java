package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdw {
    private static final Object zza = new Object();
    private static final zzdv zzb = zzdv.zza;

    @Pure
    public static void zza(String str, String str2) {
        synchronized (zza) {
            Log.d(str, str2);
        }
    }

    @Pure
    public static void zzb(String str, String str2) {
        synchronized (zza) {
            Log.e(str, str2);
        }
    }

    @Pure
    public static void zzc(String str, String str2, Throwable th) {
        zzb(str, zzg(str2, th));
    }

    @Pure
    public static void zzd(String str, String str2) {
        synchronized (zza) {
            Log.i(str, str2);
        }
    }

    @Pure
    public static void zze(String str, String str2) {
        synchronized (zza) {
            Log.w(str, str2);
        }
    }

    @Pure
    public static void zzf(String str, String str2, Throwable th) {
        zze(str, zzg(str2, th));
    }

    @Pure
    private static String zzg(String str, Throwable th) {
        String str2;
        synchronized (zza) {
            if (th != null) {
                Throwable th2 = th;
                while (true) {
                    if (th2 == null) {
                        str2 = Log.getStackTraceString(th).trim().replace("\t", "    ");
                        break;
                    } else if (th2 instanceof UnknownHostException) {
                        str2 = "UnknownHostException (no network)";
                        break;
                    } else {
                        th2 = th2.getCause();
                    }
                }
            } else {
                try {
                    str2 = null;
                } catch (Throwable th3) {
                    while (true) {
                        throw th3;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String replace = str2.replace("\n", "\n  ");
        return str + "\n  " + replace + "\n";
    }
}
