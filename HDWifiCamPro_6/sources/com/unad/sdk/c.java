package com.unad.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.unad.sdk.util.b;
import java.util.UUID;

/* compiled from: AppInfoUtils */
public class c {
    protected static String a(Context context) {
        b bVar = new b(context);
        String b = bVar.b(b.e, "");
        if (!"".equals(b)) {
            return b;
        }
        String uuid = UUID.randomUUID().toString();
        bVar.a(b.e, uuid);
        return uuid;
    }

    protected static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
