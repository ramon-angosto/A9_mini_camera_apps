package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdzf implements zzdyp {
    /* access modifiers changed from: private */
    public final long zza;
    /* access modifiers changed from: private */
    public final zzdyu zzb;
    private final zzfdb zzc;

    zzdzf(long j, Context context, zzdyu zzdyu, zzcom zzcom, String str) {
        this.zza = j;
        this.zzb = zzdyu;
        zzfdd zzu = zzcom.zzu();
        zzu.zzb(context);
        zzu.zza(str);
        this.zzc = zzu.zzc().zza();
    }

    public final void zza() {
    }

    public final void zzb(zzl zzl) {
        try {
            this.zzc.zzf(zzl, new zzdzd(this));
        } catch (RemoteException e) {
            zze.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzc() {
        try {
            this.zzc.zzk(new zzdze(this));
            this.zzc.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zze.zzl("#007 Could not call remote method.", e);
        }
    }
}
