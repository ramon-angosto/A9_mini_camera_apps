package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzelc extends zzemd {
    private final zzdkw zza;

    public zzelc(zzdcy zzdcy, zzdkl zzdkl, zzdds zzdds, zzdeh zzdeh, zzdem zzdem, zzddn zzddn, zzdht zzdht, zzdld zzdld, zzdfg zzdfg, zzdkw zzdkw, zzdhp zzdhp) {
        super(zzdcy, zzdkl, zzdds, zzdeh, zzdem, zzdht, zzdfg, zzdld, zzdhp, zzddn);
        this.zza = zzdkw;
    }

    public final void zzs(zzcce zzcce) {
        this.zza.zza(zzcce);
    }

    public final void zzt(zzcci zzcci) throws RemoteException {
        this.zza.zza(new zzcce(zzcci.zzf(), zzcci.zze()));
    }

    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    public final void zzv() {
        this.zza.zzb();
    }

    public final void zzy() {
        this.zza.zzc();
    }
}
