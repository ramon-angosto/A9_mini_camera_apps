package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcml implements DialogInterface.OnClickListener {
    final /* synthetic */ JsPromptResult zza;

    zzcml(JsPromptResult jsPromptResult) {
        this.zza = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.cancel();
    }
}
