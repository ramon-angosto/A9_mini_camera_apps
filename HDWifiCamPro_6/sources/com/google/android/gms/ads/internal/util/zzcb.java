package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcgp;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcb {
    @Deprecated
    public static Object zza(Context context, Callable callable) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            Object call = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable th) {
            zzcgp.zzh("Unexpected exception.", th);
            zzcaf.zza(context).zzd(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }
}
