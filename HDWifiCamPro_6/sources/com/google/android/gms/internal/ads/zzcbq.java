package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcbq extends ContextWrapper {
    public static Context zza(Context context) {
        if (context instanceof zzcbq) {
            return ((zzcbq) context).getBaseContext();
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final Context getApplicationContext() {
        throw null;
    }

    public final synchronized ApplicationInfo getApplicationInfo() {
        throw null;
    }

    public final synchronized String getPackageName() {
        throw null;
    }

    public final synchronized String getPackageResourcePath() {
        throw null;
    }

    public final synchronized void startActivity(Intent intent) {
        throw null;
    }
}
