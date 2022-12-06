package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcgt {
    public static Context zza(Context context) throws zzcgs {
        return zzc(context).getModuleContext();
    }

    public static Object zzb(Context context, String str, zzcgr zzcgr) throws zzcgs {
        try {
            return zzcgr.zza(zzc(context).instantiate(str));
        } catch (Exception e) {
            throw new zzcgs(e);
        }
    }

    private static DynamiteModule zzc(Context context) throws zzcgs {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzcgs(e);
        }
    }
}
