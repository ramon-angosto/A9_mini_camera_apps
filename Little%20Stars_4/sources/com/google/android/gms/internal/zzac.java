package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;

public class zzac {
    public static zzl zza(Context context) {
        return zza(context, (zzy) null);
    }

    public static zzl zza(Context context, zzy zzy) {
        String str;
        File file = new File(context.getCacheDir(), "volley");
        try {
            String packageName = context.getPackageName();
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 12);
            sb.append(packageName);
            sb.append("/");
            sb.append(i);
            str = sb.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            str = "volley/0";
        }
        if (zzy == null) {
            zzy = Build.VERSION.SDK_INT >= 9 ? new zzz() : new zzw(AndroidHttpClient.newInstance(str));
        }
        zzl zzl = new zzl(new zzv(file), new zzt(zzy));
        zzl.start();
        return zzl;
    }
}
