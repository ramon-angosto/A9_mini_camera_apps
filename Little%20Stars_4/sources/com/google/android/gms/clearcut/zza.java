package com.google.android.gms.clearcut;

import android.content.Context;

public class zza {
    private static int zzajt = -1;
    public static final zza zzaju = new zza();

    protected zza() {
    }

    public int zzac(Context context) {
        if (zzajt < 0) {
            zzajt = context.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return zzajt;
    }
}
