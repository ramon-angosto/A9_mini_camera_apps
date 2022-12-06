package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcmh implements DialogInterface.OnCancelListener {
    final /* synthetic */ JsResult zza;

    zzcmh(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.cancel();
    }
}
