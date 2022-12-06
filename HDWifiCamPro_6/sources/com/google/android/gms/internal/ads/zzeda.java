package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeda extends zzecu {
    private String zzg;
    private int zzh = 1;

    zzeda(Context context) {
        this.zzf = new zzcan(context, zzt.zzt().zzb(), this, this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zze.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zze(new zzedj(1));
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i = this.zzh;
                    if (i == 2) {
                        this.zzf.zzp().zze(this.zze, new zzect(this));
                    } else if (i == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzect(this));
                    } else {
                        this.zza.zze(new zzedj(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zze(new zzedj(1));
                } catch (Throwable th) {
                    zzt.zzo().zzt(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zze(new zzedj(1));
                }
            }
        }
    }

    public final zzfzp zzb(zzcbc zzcbc) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 2) {
                zzfzp zzh2 = zzfzg.zzh(new zzedj(2));
                return zzh2;
            } else if (this.zzc) {
                zzchh zzchh = this.zza;
                return zzchh;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzcbc;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zzc(new zzecz(this), zzchc.zzf);
                zzchh zzchh2 = this.zza;
                return zzchh2;
            }
        }
    }

    public final zzfzp zzc(String str) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 3) {
                zzfzp zzh2 = zzfzg.zzh(new zzedj(2));
                return zzh2;
            } else if (this.zzc) {
                zzchh zzchh = this.zza;
                return zzchh;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zzc(new zzecy(this), zzchc.zzf);
                zzchh zzchh2 = this.zza;
                return zzchh2;
            }
        }
    }
}
