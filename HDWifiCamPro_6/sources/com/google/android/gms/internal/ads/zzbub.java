package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbub {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbuk zzc;
    private zzbuk zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbuk zza(Context context, zzcgv zzcgv, zzfjw zzfjw) {
        zzbuk zzbuk;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbuk(zzc(context), zzcgv, (String) zzay.zzc().zzb(zzbjc.zza), zzfjw);
            }
            zzbuk = this.zzc;
        }
        return zzbuk;
    }

    public final zzbuk zzb(Context context, zzcgv zzcgv, zzfjw zzfjw) {
        zzbuk zzbuk;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbuk(zzc(context), zzcgv, (String) zzblb.zzb.zze(), zzfjw);
            }
            zzbuk = this.zzd;
        }
        return zzbuk;
    }
}
