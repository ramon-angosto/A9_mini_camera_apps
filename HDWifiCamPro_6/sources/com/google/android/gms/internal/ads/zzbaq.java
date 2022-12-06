package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbaq implements ThreadFactory {
    final /* synthetic */ String zza = "Loader:ExtractorMediaPeriod";

    zzbaq(String str) {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
