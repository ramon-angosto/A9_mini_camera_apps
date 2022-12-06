package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfzc;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzy implements zzfzc {
    final /* synthetic */ zzbzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    zzy(zzaa zzaa, zzbzr zzbzr, boolean z) {
        this.zzc = zzaa;
        this.zza = zzbzr;
        this.zzb = z;
    }

    public final void zza(Throwable th) {
        try {
            zzbzr zzbzr = this.zza;
            String message = th.getMessage();
            zzbzr.zze("Internal error: " + message);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        List<Uri> list = (List) obj;
        try {
            zzaa.zzF(this.zzc, list);
            this.zza.zzf(list);
            if (this.zzc.zzu || this.zzb) {
                for (Uri uri : list) {
                    if (this.zzc.zzN(uri)) {
                        zzaa zzaa = this.zzc;
                        this.zzc.zzs.zzc(zzaa.zzW(uri, zzaa.zzC, "1").toString(), (zzfju) null);
                    } else {
                        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgB)).booleanValue()) {
                            this.zzc.zzs.zzc(uri.toString(), (zzfju) null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }
}
