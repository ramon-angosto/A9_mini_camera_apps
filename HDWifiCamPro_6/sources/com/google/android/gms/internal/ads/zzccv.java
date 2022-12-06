package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzccv implements RewardItem {
    private final zzcci zza;

    public zzccv(zzcci zzcci) {
        this.zza = zzcci;
    }

    public final int getAmount() {
        zzcci zzcci = this.zza;
        if (zzcci != null) {
            try {
                return zzcci.zze();
            } catch (RemoteException e) {
                zzcgp.zzk("Could not forward getAmount to RewardItem", e);
            }
        }
        return 0;
    }

    public final String getType() {
        zzcci zzcci = this.zza;
        if (zzcci != null) {
            try {
                return zzcci.zzf();
            } catch (RemoteException e) {
                zzcgp.zzk("Could not forward getType to RewardItem", e);
            }
        }
        return null;
    }
}
