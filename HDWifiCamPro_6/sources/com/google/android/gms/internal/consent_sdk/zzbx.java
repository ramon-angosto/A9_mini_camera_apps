package com.google.android.gms.internal.consent_sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.vungle.warren.VungleApiClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzbx {
    private static String zza;

    public static synchronized String zza(Context context) {
        String str;
        String str2;
        synchronized (zzbx.class) {
            if (zza == null) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    str2 = null;
                } else {
                    str2 = Settings.Secure.getString(contentResolver, VungleApiClient.ANDROID_ID);
                }
                if (str2 == null || zzb()) {
                    str2 = "emulator";
                }
                zza = zzc(str2);
            }
            str = zza;
        }
        return str;
    }

    public static boolean zzb() {
        if (Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }

    private static String zzc(String str) {
        int i = 0;
        while (i < 3) {
            try {
                MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
                instance.update(str.getBytes());
                return String.format("%032X", new Object[]{new BigInteger(1, instance.digest())});
            } catch (NoSuchAlgorithmException unused) {
                i++;
            } catch (ArithmeticException unused2) {
                return "";
            }
        }
        return "";
    }
}
