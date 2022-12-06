package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbzy {
    /* access modifiers changed from: private */
    @Nonnull
    public View zza;
    /* access modifiers changed from: private */
    public final Map zzb = new HashMap();

    public final zzbzy zzb(View view) {
        this.zza = view;
        return this;
    }

    public final zzbzy zzc(Map map) {
        this.zzb.clear();
        for (Map.Entry entry : map.entrySet()) {
            View view = (View) entry.getValue();
            if (view != null) {
                this.zzb.put((String) entry.getKey(), new WeakReference(view));
            }
        }
        return this;
    }
}
