package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfkm {
    private final Context zza;
    private final Executor zzb;
    private final zzcgu zzc;
    private final zzfjw zzd;

    zzfkm(Context context, Executor executor, zzcgu zzcgu, zzfjw zzfjw) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgu;
        this.zzd = zzfjw;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str, zzfju zzfju) {
        zzfjj zza2 = zzfji.zza(this.zza, 14);
        zza2.zzf();
        zza2.zze(this.zzc.zza(str));
        if (zzfju == null) {
            this.zzd.zzb(zza2.zzj());
            return;
        }
        zzfju.zza(zza2);
        zzfju.zzg();
    }

    public final void zzc(String str, zzfju zzfju) {
        if (!zzfjw.zza() || !((Boolean) zzbkl.zzd.zze()).booleanValue()) {
            this.zzb.execute(new zzfkk(this, str));
        } else {
            this.zzb.execute(new zzfkl(this, str, zzfju));
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), (zzfju) null);
        }
    }
}
