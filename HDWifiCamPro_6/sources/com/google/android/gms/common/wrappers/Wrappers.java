package com.google.android.gms.common.wrappers;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class Wrappers {
    private static Wrappers zza = new Wrappers();
    private PackageManagerWrapper zzb = null;

    public static PackageManagerWrapper packageManager(Context context) {
        return zza.zza(context);
    }

    public final synchronized PackageManagerWrapper zza(Context context) {
        if (this.zzb == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzb = new PackageManagerWrapper(context);
        }
        return this.zzb;
    }
}
