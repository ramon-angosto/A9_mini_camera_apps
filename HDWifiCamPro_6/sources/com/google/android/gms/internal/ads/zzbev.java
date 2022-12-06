package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbev {
    zzase zza;
    boolean zzb;
    /* access modifiers changed from: private */
    public final ExecutorService zzc = zzcge.zzb;

    public zzbev() {
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final void zzb(Context context) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzea)).booleanValue()) {
            try {
                this.zza = (zzase) zzcgt.zzb(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzber.zza);
                this.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzb = true;
            } catch (RemoteException | zzcgs | NullPointerException unused) {
                zzcgp.zze("Cannot dynamite load clearcut");
            }
        }
    }

    public zzbev(Context context) {
        zzbjc.zzc(context);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziG)).booleanValue()) {
            this.zzc.execute(new zzbeq(this, context));
        } else {
            zzb(context);
        }
    }
}
