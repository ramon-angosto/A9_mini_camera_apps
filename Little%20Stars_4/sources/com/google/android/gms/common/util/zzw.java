package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzf;
import java.util.regex.Pattern;

public class zzw {
    private static final Pattern zzaup = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean zzdv(String str) {
        return str == null || zzf.zzaqS.zzb(str);
    }
}
