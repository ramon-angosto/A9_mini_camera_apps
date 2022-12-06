package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfjt {
    public static void zza(zzfzp zzfzp, zzfju zzfju, zzfjj zzfjj) {
        zzg(zzfzp, zzfju, zzfjj, false);
    }

    public static void zzb(zzfzp zzfzp, zzfju zzfju, zzfjj zzfjj) {
        zzg(zzfzp, zzfju, zzfjj, true);
    }

    public static void zzc(zzfzp zzfzp, zzfju zzfju, zzfjj zzfjj) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            zzfzg.zzr(zzfyx.zzv(zzfzp), new zzfjs(zzfju, zzfjj), zzchc.zzf);
        }
    }

    public static void zzd(zzfzp zzfzp, zzfjj zzfjj) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            zzfzg.zzr(zzfyx.zzv(zzfzp), new zzfjq(zzfjj), zzchc.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) zzay.zzc().zzb(zzbjc.zzhA), str);
    }

    public static int zzf(zzfef zzfef) {
        int zzd = zzf.zzd(zzfef) - 1;
        return (zzd == 0 || zzd == 1) ? 7 : 23;
    }

    private static void zzg(zzfzp zzfzp, zzfju zzfju, zzfjj zzfjj, boolean z) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            zzfzg.zzr(zzfyx.zzv(zzfzp), new zzfjr(zzfju, zzfjj, z), zzchc.zzf);
        }
    }
}
