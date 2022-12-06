package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcod extends MutableContextWrapper {
    private Activity zza;
    private Context zzb;
    private Context zzc;

    public zzcod(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Object getSystemService(String str) {
        return this.zzc.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.zzb = context.getApplicationContext();
        this.zza = context instanceof Activity ? (Activity) context : null;
        this.zzc = context;
        super.setBaseContext(this.zzb);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zza;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.zzb.startActivity(intent);
    }

    public final Activity zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzc;
    }
}
