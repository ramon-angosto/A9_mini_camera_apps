package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdki extends zzdij implements zzbbq {
    private final Map zzb = new WeakHashMap(1);
    private final Context zzc;
    private final zzfdk zzd;

    public zzdki(Context context, Set set, zzfdk zzfdk) {
        super(set);
        this.zzc = context;
        this.zzd = zzfdk;
    }

    public final synchronized void zza(View view) {
        zzbbr zzbbr = (zzbbr) this.zzb.get(view);
        if (zzbbr == null) {
            zzbbr = new zzbbr(this.zzc, view);
            zzbbr.zzc(this);
            this.zzb.put(view, zzbbr);
        }
        if (this.zzd.zzY) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzbh)).booleanValue()) {
                zzbbr.zzg(((Long) zzay.zzc().zzb(zzbjc.zzbg)).longValue());
                return;
            }
        }
        zzbbr.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            ((zzbbr) this.zzb.get(view)).zze(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzc(zzbbp zzbbp) {
        zzo(new zzdkh(zzbbp));
    }
}
