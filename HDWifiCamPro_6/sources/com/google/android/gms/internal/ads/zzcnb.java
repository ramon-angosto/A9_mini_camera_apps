package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcnb {
    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzcmp, java.lang.Object] */
    public static final zzcmp zza(Context context, zzcoe zzcoe, String str, boolean z, boolean z2, zzape zzape, zzbkb zzbkb, zzcgv zzcgv, zzbjr zzbjr, zzl zzl, zza zza, zzbep zzbep, zzfdk zzfdk, zzfdn zzfdn) throws zzcna {
        StrictMode.ThreadPolicy threadPolicy;
        zzbjc.zzc(context);
        try {
            zzcmx zzcmx = new zzcmx(context, zzcoe, str, z, z2, zzape, zzbkb, zzcgv, (zzbjr) null, zzl, zza, zzbep, zzfdk, zzfdn);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ? zza2 = zzcmx.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza2;
        } catch (Throwable th) {
            throw new zzcna("Webview initialization failed.", th);
        }
    }
}
