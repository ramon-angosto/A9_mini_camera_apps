package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdqg implements zzbpu {
    public final /* synthetic */ zzdqj zza;
    public final /* synthetic */ WindowManager zzb;
    public final /* synthetic */ View zzc;

    public /* synthetic */ zzdqg(zzdqj zzdqj, WindowManager windowManager, View view) {
        this.zza = zzdqj;
        this.zzb = windowManager;
        this.zzc = view;
    }

    public final void zza(Object obj, Map map) {
        this.zza.zzc(this.zzb, this.zzc, (zzcmp) obj, map);
    }
}
