package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzpk {
    public final int zza;
    public final zzsi zzb;
    private final CopyOnWriteArrayList zzc;

    public zzpk() {
        this(new CopyOnWriteArrayList(), 0, (zzsi) null);
    }

    private zzpk(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzsi zzsi) {
        this.zzc = copyOnWriteArrayList;
        this.zza = i;
        this.zzb = zzsi;
    }

    public final zzpk zza(int i, zzsi zzsi) {
        return new zzpk(this.zzc, i, zzsi);
    }

    public final void zzc(zzpl zzpl) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzpj zzpj = (zzpj) it.next();
            if (zzpj.zzb == zzpl) {
                this.zzc.remove(zzpj);
            }
        }
    }

    public final void zzb(Handler handler, zzpl zzpl) {
        if (zzpl != null) {
            this.zzc.add(new zzpj(handler, zzpl));
            return;
        }
        throw null;
    }
}
