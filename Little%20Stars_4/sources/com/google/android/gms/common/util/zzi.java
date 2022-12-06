package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzi {
    private static Boolean zzaub;
    private static Boolean zzauc;
    private static Boolean zzaud;
    private static Boolean zzaue;

    @TargetApi(20)
    public static boolean zzaB(Context context) {
        if (zzaud == null) {
            zzaud = Boolean.valueOf(zzs.zzvf() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzaud.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzaC(Context context) {
        if (zzaue == null) {
            zzaue = Boolean.valueOf(zzs.zzvg() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzaue.booleanValue();
    }

    public static boolean zzb(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (zzaub == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((zzs.zzuX() && z2) || zzc(resources)) {
                z = true;
            }
            zzaub = Boolean.valueOf(z);
        }
        return zzaub.booleanValue();
    }

    @TargetApi(13)
    private static boolean zzc(Resources resources) {
        if (zzauc == null) {
            Configuration configuration = resources.getConfiguration();
            zzauc = Boolean.valueOf(zzs.zzuZ() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
        }
        return zzauc.booleanValue();
    }
}
