package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcop {
    private final zzcgv zza;
    private final Context zzb;
    private final WeakReference zzc;

    /* synthetic */ zzcop(zzcon zzcon, zzcoo zzcoo) {
        this.zza = zzcon.zza;
        this.zzb = zzcon.zzb;
        this.zzc = zzcon.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzb;
    }

    public final zzape zzb() {
        return new zzape(new zzi(this.zzb, this.zza));
    }

    /* access modifiers changed from: package-private */
    public final zzbll zzc() {
        return new zzbll(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final zzcgv zzd() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zze() {
        return zzt.zzp().zzc(this.zzb, this.zza.zza);
    }

    /* access modifiers changed from: package-private */
    public final WeakReference zzf() {
        return this.zzc;
    }
}
