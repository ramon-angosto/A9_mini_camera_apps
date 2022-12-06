package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zae implements View.OnClickListener {
    final /* synthetic */ Context zaa;
    final /* synthetic */ Intent zab;

    zae(Context context, Intent intent) {
        this.zaa = context;
        this.zab = intent;
    }

    public final void onClick(View view) {
        try {
            this.zaa.startActivity(this.zab);
        } catch (ActivityNotFoundException e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
