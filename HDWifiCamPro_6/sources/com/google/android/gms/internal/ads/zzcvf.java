package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcvf {
    private final String zza;
    private final zzbut zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public zzcvk zzd;
    private final zzbpu zze = new zzcvc(this);
    private final zzbpu zzf = new zzcve(this);

    public zzcvf(String str, zzbut zzbut, Executor executor) {
        this.zza = str;
        this.zzb = zzbut;
        this.zzc = executor;
    }

    static /* bridge */ /* synthetic */ boolean zzg(zzcvf zzcvf, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(zzcvf.zza);
    }

    public final void zzc(zzcvk zzcvk) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcvk;
    }

    public final void zzd(zzcmp zzcmp) {
        zzcmp.zzaf("/updateActiveView", this.zze);
        zzcmp.zzaf("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzcmp zzcmp) {
        zzcmp.zzaw("/updateActiveView", this.zze);
        zzcmp.zzaw("/untrackActiveViewUnit", this.zzf);
    }
}
