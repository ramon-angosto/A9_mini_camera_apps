package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzpw;

public class zzy {
    private static boolean zzKm;
    private static String zzasi;
    private static int zzasj;
    private static Object zzrs = new Object();

    public static String zzaw(Context context) {
        zzay(context);
        return zzasi;
    }

    public static int zzax(Context context) {
        zzay(context);
        return zzasj;
    }

    private static void zzay(Context context) {
        synchronized (zzrs) {
            if (!zzKm) {
                zzKm = true;
                try {
                    Bundle bundle = zzpw.zzaH(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        zzasi = bundle.getString("com.google.app.id");
                        zzasj = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
