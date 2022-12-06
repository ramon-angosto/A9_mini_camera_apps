package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbtv extends zzcho {
    private final Object zza = new Object();
    private final zzbb zzb;
    private boolean zzc;
    private int zzd;

    public zzbtv(zzbb zzbb) {
        this.zzb = zzbb;
        this.zzc = false;
        this.zzd = 0;
    }

    public final zzbtq zza() {
        zzbtq zzbtq = new zzbtq(this);
        synchronized (this.zza) {
            zzi(new zzbtr(this, zzbtq), new zzbts(this, zzbtq));
            Preconditions.checkState(this.zzd >= 0);
            this.zzd++;
        }
        return zzbtq;
    }

    public final void zzb() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd >= 0);
            zze.zza("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzc();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd >= 0);
            if (!this.zzc || this.zzd != 0) {
                zze.zza("There are still references to the engine. Not destroying.");
            } else {
                zze.zza("No reference is left (including root). Cleaning up engine.");
                zzi(new zzbtu(this), new zzchk());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd > 0);
            zze.zza("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzc();
        }
    }
}
