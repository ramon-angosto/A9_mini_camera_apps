package com.google.android.gms.internal;

import android.content.Context;

public class zzpw {
    private static zzpw zzauz = new zzpw();
    private zzpv zzauy = null;

    public static zzpv zzaH(Context context) {
        return zzauz.zzaG(context);
    }

    public synchronized zzpv zzaG(Context context) {
        if (this.zzauy == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzauy = new zzpv(context);
        }
        return this.zzauy;
    }
}
