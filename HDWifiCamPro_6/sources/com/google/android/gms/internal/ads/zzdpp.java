package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdpp implements zzblr {
    final /* synthetic */ zzdql zza;
    final /* synthetic */ ViewGroup zzb;

    zzdpp(zzdql zzdql, ViewGroup viewGroup) {
        this.zza = zzdql;
        this.zzb = viewGroup;
    }

    public final JSONObject zza() {
        return this.zza.zzo();
    }

    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    public final void zzc() {
        zzdql zzdql = this.zza;
        zzfvn zzfvn = zzdpm.zza;
        Map zzm = zzdql.zzm();
        if (zzm != null) {
            int size = zzfvn.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (zzm.get((String) zzfvn.get(i)) == null) {
                    i = i2;
                } else {
                    this.zza.onClick(this.zzb);
                    return;
                }
            }
        }
    }

    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch((View) null, motionEvent);
    }
}
