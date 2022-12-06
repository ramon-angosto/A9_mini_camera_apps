package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzsd;
import java.util.ArrayList;
import java.util.Collection;

public class zzse {
    private final Collection<zzsd> zzwS = new ArrayList();
    private final Collection<zzsd.zzd> zzwT = new ArrayList();
    private final Collection<zzsd.zzd> zzwU = new ArrayList();

    public static void initialize(Context context) {
        zzsh.zzyF().initialize(context);
    }

    public void zza(zzsd zzsd) {
        this.zzwS.add(zzsd);
    }
}
