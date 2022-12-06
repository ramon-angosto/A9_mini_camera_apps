package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbrw;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzec extends zzbrw {
    final /* synthetic */ zzed zza;

    /* synthetic */ zzec(zzed zzed, zzeb zzeb) {
        this.zza = zzed;
    }

    public final void zzb(List list) throws RemoteException {
        int i;
        ArrayList arrayList;
        synchronized (this.zza.zzb) {
            this.zza.zzd = false;
            this.zza.zze = true;
            arrayList = new ArrayList(this.zza.zzc);
            this.zza.zzc.clear();
        }
        InitializationStatus zzd = zzed.zzw(list);
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((OnInitializationCompleteListener) arrayList.get(i)).onInitializationComplete(zzd);
        }
    }
}
