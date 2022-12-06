package com.google.android.gms.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.internal.zzb;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class zzx {
    public static String zza(Map<String, String> map) {
        return zzb(map, "ISO-8859-1");
    }

    public static zzb.zza zzb(zzi zzi) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        zzi zzi2 = zzi;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzi2.zzz;
        String str = map.get(HttpHeaders.DATE);
        long zzg = str != null ? zzg(str) : 0;
        String str2 = map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            j2 = 0;
            int i2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j2 = 0;
            j = 0;
            z = false;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        long zzg2 = str3 != null ? zzg(str3) : 0;
        String str4 = map.get(HttpHeaders.LAST_MODIFIED);
        long zzg3 = str4 != null ? zzg(str4) : 0;
        String str5 = map.get(HttpHeaders.ETAG);
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i == 0) {
                Long.signum(j);
                j3 = (j * 1000) + j4;
                zzb.zza zza = new zzb.zza();
                zza.data = zzi2.data;
                zza.zza = str5;
                zza.zze = j4;
                zza.zzd = j3;
                zza.zzb = zzg;
                zza.zzc = zzg3;
                zza.zzf = map;
                return zza;
            }
        } else if (zzg <= 0 || zzg2 < zzg) {
            j4 = 0;
        } else {
            j3 = (zzg2 - zzg) + currentTimeMillis;
            j4 = j3;
            zzb.zza zza2 = new zzb.zza();
            zza2.data = zzi2.data;
            zza2.zza = str5;
            zza2.zze = j4;
            zza2.zzd = j3;
            zza2.zzb = zzg;
            zza2.zzc = zzg3;
            zza2.zzf = map;
            return zza2;
        }
        j3 = j4;
        zzb.zza zza22 = new zzb.zza();
        zza22.data = zzi2.data;
        zza22.zza = str5;
        zza22.zze = j4;
        zza22.zzd = j3;
        zza22.zzb = zzg;
        zza22.zzc = zzg3;
        zza22.zzf = map;
        return zza22;
    }

    public static String zzb(Map<String, String> map, String str) {
        String str2 = map.get(HttpHeaders.CONTENT_TYPE);
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static long zzg(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0;
        }
    }
}
