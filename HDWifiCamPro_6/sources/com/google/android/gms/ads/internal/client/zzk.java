package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcah;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzk extends RemoteCreator {
    private zzcah zza;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzbt ? (zzbt) queryLocalInterface : new zzbt(iBinder);
    }

    public final zzbs zza(Context context, zzq zzq, String str, zzbvk zzbvk, int i) {
        zzbjc.zzc(context);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzis)).booleanValue()) {
            try {
                IBinder zze = ((zzbt) zzcgt.zzb(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", zzj.zza)).zze(ObjectWrapper.wrap(context), zzq, str, zzbvk, 223104000, i);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return queryLocalInterface instanceof zzbs ? (zzbs) queryLocalInterface : new zzbq(zze);
            } catch (RemoteException | zzcgs | NullPointerException e) {
                this.zza = zzcaf.zza(context);
                this.zza.zzd(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzcgp.zzl("#007 Could not call remote method.", e);
                return null;
            }
        } else {
            try {
                IBinder zze2 = ((zzbt) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzq, str, zzbvk, 223104000, i);
                if (zze2 == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = zze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return queryLocalInterface2 instanceof zzbs ? (zzbs) queryLocalInterface2 : new zzbq(zze2);
            } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
                zzcgp.zzf("Could not create remote AdManager.", e2);
                return null;
            }
        }
    }
}
