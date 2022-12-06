package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeip implements zzdmp {
    public final /* synthetic */ zzchh zza;

    public /* synthetic */ zzeip(zzchh zzchh) {
        this.zza = zzchh;
    }

    public final void zza(boolean z, Context context, zzddn zzddn) {
        zzchh zzchh = this.zza;
        try {
            zzt.zzi();
            zzm.zza(context, (AdOverlayInfoParcel) zzchh.get(), true);
        } catch (Exception unused) {
        }
    }
}
