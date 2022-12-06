package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzwf {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzwg zzwg) {
        zzc(zzwg);
        this.zza.add(new zzwe(handler, zzwg));
    }

    public final void zzb(int i, long j, long j2) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzwe zzwe = (zzwe) it.next();
            if (!zzwe.zzc) {
                zzwe.zza.post(new zzwd(zzwe, i, j, j2));
            }
        }
    }

    public final void zzc(zzwg zzwg) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzwe zzwe = (zzwe) it.next();
            if (zzwe.zzb == zzwg) {
                zzwe.zzc();
                this.zza.remove(zzwe);
            }
        }
    }
}
