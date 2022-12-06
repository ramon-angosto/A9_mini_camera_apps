package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdp implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzdq zzc;

    public /* synthetic */ zzdp(CopyOnWriteArraySet copyOnWriteArraySet, int i, zzdq zzdq) {
        this.zza = copyOnWriteArraySet;
        this.zzb = i;
        this.zzc = zzdq;
    }

    public final void run() {
        CopyOnWriteArraySet copyOnWriteArraySet = this.zza;
        int i = this.zzb;
        zzdq zzdq = this.zzc;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((zzds) it.next()).zza(i, zzdq);
        }
    }
}
