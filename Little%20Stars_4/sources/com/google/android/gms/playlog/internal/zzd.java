package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zztd;

public class zzd implements zzd.zzb, zzd.zzc {
    private zzf zzbkM = null;
    private final zztd.zza zzbkX;
    private boolean zzbkY = true;

    public zzd(zztd.zza zza) {
        this.zzbkX = zza;
    }

    public void onConnected(Bundle bundle) {
        zztd.zza zza;
        this.zzbkM.zzaB(false);
        if (this.zzbkY && (zza = this.zzbkX) != null) {
            zza.zzIe();
        }
        this.zzbkY = false;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzbkM.zzaB(true);
        if (this.zzbkY && this.zzbkX != null) {
            if (connectionResult.hasResolution()) {
                this.zzbkX.zzc(connectionResult.getResolution());
            } else {
                this.zzbkX.zzIf();
            }
        }
        this.zzbkY = false;
    }

    public void onConnectionSuspended(int i) {
        this.zzbkM.zzaB(true);
    }

    public void zza(zzf zzf) {
        this.zzbkM = zzf;
    }

    public void zzaA(boolean z) {
        this.zzbkY = z;
    }
}
