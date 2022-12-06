package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzoh;

public class zzoc implements zzog {
    /* access modifiers changed from: private */
    public final zzoh zzamB;
    private boolean zzamC = false;

    public zzoc(zzoh zzoh) {
        this.zzamB = zzoh;
    }

    private <A extends Api.zzb> void zzf(zznt.zza<? extends Result, A> zza) throws DeadObjectException {
        this.zzamB.zzamm.zzant.zzg(zza);
        A zzb = this.zzamB.zzamm.zzb((Api.zzc<?>) zza.zzre());
        if (zzb.isConnected() || !this.zzamB.zzanC.containsKey(zza.zzre())) {
            if (zzb instanceof zzag) {
                zzb = ((zzag) zzb).zztX();
            }
            zza.zzb(zzb);
            return;
        }
        zza.zzx(new Status(17));
    }

    public void begin() {
    }

    public void connect() {
        if (this.zzamC) {
            this.zzamC = false;
            this.zzamB.zza((zzoh.zza) new zzoh.zza(this) {
                public void zzrX() {
                    zzoc.this.zzamB.zzanG.zzk((Bundle) null);
                }
            });
        }
    }

    public boolean disconnect() {
        if (this.zzamC) {
            return false;
        }
        if (this.zzamB.zzamm.zzsk()) {
            this.zzamC = true;
            for (zzpe zzsJ : this.zzamB.zzamm.zzans) {
                zzsJ.zzsJ();
            }
            return false;
        }
        this.zzamB.zzi((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.zzamB.zzi((ConnectionResult) null);
        this.zzamB.zzanG.zzc(i, this.zzamC);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(T t) {
        return zzd(t);
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(T t) {
        try {
            zzf(t);
        } catch (DeadObjectException unused) {
            this.zzamB.zza((zzoh.zza) new zzoh.zza(this) {
                public void zzrX() {
                    zzoc.this.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    public void zzrW() {
        if (this.zzamC) {
            this.zzamC = false;
            this.zzamB.zzamm.zzant.release();
            disconnect();
        }
    }
}
