package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfv {
    private static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(String str, String str2) {
        long j = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                zzdw.zzb("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j;
        }
        Matcher matcher = zza.matcher(str2);
        if (!matcher.matches()) {
            return j;
        }
        try {
            String group = matcher.group(2);
            if (group != null) {
                long parseLong = Long.parseLong(group);
                String group2 = matcher.group(1);
                if (group2 != null) {
                    long parseLong2 = (parseLong - Long.parseLong(group2)) + 1;
                    if (j < 0) {
                        return parseLong2;
                    }
                    if (j == parseLong2) {
                        return j;
                    }
                    zzdw.zze("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
                    return Math.max(j, parseLong2);
                }
                throw null;
            }
            throw null;
        } catch (NumberFormatException unused2) {
            zzdw.zzb("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j;
        }
    }

    public static long zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return -1;
        }
        String group = matcher.group(1);
        if (group != null) {
            return Long.parseLong(group);
        }
        throw null;
    }
}
