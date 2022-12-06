package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbyh extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbyh(zzblw zzblw) {
        try {
            this.zzb = zzblw.zzg();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            this.zzb = "";
        }
        try {
            for (Object next : zzblw.zzh()) {
                zzbme zzg = next instanceof IBinder ? zzbmd.zzg((IBinder) next) : null;
                if (zzg != null) {
                    this.zza.add(new zzbyj(zzg));
                }
            }
        } catch (RemoteException e2) {
            zzcgp.zzh("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
