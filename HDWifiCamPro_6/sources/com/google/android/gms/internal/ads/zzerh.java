package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzerh implements zzeve {
    private final zzfzq zza;
    private final Context zzb;

    zzerh(zzfzq zzfzq, Context context) {
        this.zza = zzfzq;
        this.zzb = context;
    }

    public final int zza() {
        return 14;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzerg(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeri zzc() throws Exception {
        Intent intent;
        double d;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zziE)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            intent = this.zzb.registerReceiver((BroadcastReceiver) null, intentFilter);
        } else {
            intent = this.zzb.registerReceiver((BroadcastReceiver) null, intentFilter, 4);
        }
        boolean z = false;
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            d = ((double) intent.getIntExtra("level", -1)) / ((double) intent.getIntExtra("scale", -1));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzeri(d, z);
    }
}
