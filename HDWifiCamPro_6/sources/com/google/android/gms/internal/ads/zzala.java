package com.google.android.gms.internal.ads;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.MBridgeConstans;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzala {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if (MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(str) || "-1".equals(str)) {
                zzakp.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzakp.zzc(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static zzajm zzb(zzajz zzajz) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        zzajz zzajz2 = zzajz;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = zzajz2.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get(HttpHeaders.DATE);
        long zza = str != null ? zza(str) : 0;
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z2 = false;
            j2 = 0;
            j = 0;
            for (String trim : split) {
                String trim2 = trim.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim2.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim2.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim2.substring(23));
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    z2 = true;
                }
            }
            z = true;
        } else {
            z2 = false;
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        long zza2 = str3 != null ? zza(str3) : 0;
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        long zza3 = str4 != null ? zza(str4) : 0;
        String str5 = (String) map.get("ETag");
        if (z) {
            long j5 = currentTimeMillis + (j2 * 1000);
            j4 = z2 ? j5 : (j * 1000) + j5;
            j3 = j5;
        } else {
            j3 = 0;
            if (zza <= 0 || zza2 < zza) {
                j4 = 0;
            } else {
                j4 = (zza2 - zza) + currentTimeMillis;
                j3 = j4;
            }
        }
        zzajm zzajm = new zzajm();
        zzajm.zza = zzajz2.zzb;
        zzajm.zzb = str5;
        zzajm.zzf = j3;
        zzajm.zze = j4;
        zzajm.zzc = zza;
        zzajm.zzd = zza3;
        zzajm.zzg = map;
        zzajm.zzh = zzajz2.zzd;
        return zzajm;
    }

    static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
