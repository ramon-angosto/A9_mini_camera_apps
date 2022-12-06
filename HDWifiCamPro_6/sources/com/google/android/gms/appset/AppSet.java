package com.google.android.gms.appset;

import android.content.Context;
import com.google.android.gms.internal.appset.zzr;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class AppSet {
    private AppSet() {
    }

    public static AppSetIdClient getClient(Context context) {
        return new zzr(context);
    }
}
