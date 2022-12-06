package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcin {
    private final Context zza;
    private final zzciy zzb;
    private final ViewGroup zzc;
    private zzcim zzd;

    public zzcin(Context context, ViewGroup viewGroup, zzcmp zzcmp) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcmp;
        this.zzd = null;
    }

    public final zzcim zza() {
        return this.zzd;
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcim zzcim = this.zzd;
        if (zzcim != null) {
            zzcim.zzF(i, i2, i3, i4);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4, int i5, boolean z, zzcix zzcix, Integer num) {
        if (this.zzd == null) {
            zzbjj.zza(this.zzb.zzo().zza(), this.zzb.zzn(), "vpr2");
            Context context = this.zza;
            zzciy zzciy = this.zzb;
            this.zzd = new zzcim(context, zzciy, i5, z, zzciy.zzo().zza(), zzcix, num);
            this.zzc.addView(this.zzd, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            this.zzd.zzF(i, i2, i3, i4);
            this.zzb.zzB(false);
        }
    }

    public final void zzd() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcim zzcim = this.zzd;
        if (zzcim != null) {
            zzcim.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcim zzcim = this.zzd;
        if (zzcim != null) {
            zzcim.zzu();
        }
    }

    public final void zzf(int i) {
        zzcim zzcim = this.zzd;
        if (zzcim != null) {
            zzcim.zzC(i);
        }
    }
}
