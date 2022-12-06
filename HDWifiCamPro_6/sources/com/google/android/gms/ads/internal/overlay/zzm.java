package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzdkn;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzm {
    public static final void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzk == 4 && adOverlayInfoParcel.zzc == null) {
            zza zza = adOverlayInfoParcel.zzb;
            if (zza != null) {
                zza.onAdClicked();
            }
            zzdkn zzdkn = adOverlayInfoParcel.zzy;
            if (zzdkn != null) {
                zzdkn.zzq();
            }
            Activity zzk = adOverlayInfoParcel.zzd.zzk();
            zzc zzc = adOverlayInfoParcel.zza;
            if (!(zzc == null || !zzc.zzj || zzk == null)) {
                context = zzk;
            }
            zzt.zzh();
            zzc zzc2 = adOverlayInfoParcel.zza;
            zza.zzb(context, zzc2, adOverlayInfoParcel.zzi, zzc2 != null ? zzc2.zzi : null);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzm.zzd);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzt.zzp();
        zzs.zzJ(context, intent);
    }
}
