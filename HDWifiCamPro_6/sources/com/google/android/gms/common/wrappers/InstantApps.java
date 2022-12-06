package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class InstantApps {
    private static Context zza;
    private static Boolean zzb;

    public static synchronized boolean isInstantApp(Context context) {
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = zza;
            if (!(context2 == null || (bool = zzb) == null)) {
                if (context2 == applicationContext) {
                    boolean booleanValue = bool.booleanValue();
                    return booleanValue;
                }
            }
            zzb = null;
            if (PlatformVersion.isAtLeastO()) {
                zzb = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    zzb = true;
                } catch (ClassNotFoundException unused) {
                    zzb = false;
                }
            }
            zza = applicationContext;
            boolean booleanValue2 = zzb.booleanValue();
            return booleanValue2;
        }
    }
}
