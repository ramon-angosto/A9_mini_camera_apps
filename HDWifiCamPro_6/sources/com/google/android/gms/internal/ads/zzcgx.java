package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcgx extends ScheduledThreadPoolExecutor {
    zzcgx(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
