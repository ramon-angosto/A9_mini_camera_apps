package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcku implements Iterable {
    private final List zza = new ArrayList();

    public final Iterator iterator() {
        return this.zza.iterator();
    }

    /* access modifiers changed from: package-private */
    public final zzckt zza(zzciy zzciy) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzckt zzckt = (zzckt) it.next();
            if (zzckt.zza == zzciy) {
                return zzckt;
            }
        }
        return null;
    }

    public final void zzb(zzckt zzckt) {
        this.zza.add(zzckt);
    }

    public final void zzc(zzckt zzckt) {
        this.zza.remove(zzckt);
    }

    public final boolean zzd(zzciy zzciy) {
        ArrayList<zzckt> arrayList = new ArrayList<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzckt zzckt = (zzckt) it.next();
            if (zzckt.zza == zzciy) {
                arrayList.add(zzckt);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (zzckt zzckt2 : arrayList) {
            zzckt2.zzb.zzb();
        }
        return true;
    }
}
