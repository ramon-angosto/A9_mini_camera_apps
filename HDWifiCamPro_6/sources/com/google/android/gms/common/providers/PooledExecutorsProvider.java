package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zza;

    /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
    public interface PooledExecutorFactory {
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (zza == null) {
                zza = new zza();
            }
            pooledExecutorFactory = zza;
        }
        return pooledExecutorFactory;
    }
}
