package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;

public class zzd {
    public static boolean zzm(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean zzmW() {
        return false;
    }
}
