package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzau implements DialogInterface.OnClickListener {
    final /* synthetic */ zzav zza;

    zzau(zzav zzav) {
        this.zza = zzav;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzt.zzp();
        zzs.zzQ(this.zza.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
