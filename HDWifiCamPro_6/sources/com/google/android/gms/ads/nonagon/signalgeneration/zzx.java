package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfzc;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzx implements zzfzc {
    final /* synthetic */ zzbzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    zzx(zzaa zzaa, zzbzr zzbzr, boolean z) {
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
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzc.zzt || this.zzb) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (this.zzc.zzO(uri)) {
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
