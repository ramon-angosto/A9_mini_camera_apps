package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zaco {
    private static final ExecutorService zaa = zap.zaa().zaa(new NumberedThreadFactory("GAC_Transform"), 1);

    public static ExecutorService zaa() {
        return zaa;
    }
}
