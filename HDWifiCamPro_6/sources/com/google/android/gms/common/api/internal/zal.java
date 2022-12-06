package com.google.android.gms.common.api.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zal {
    private final ArrayMap<ApiKey<?>, ConnectionResult> zaa = new ArrayMap<>();
    private final ArrayMap<ApiKey<?>, String> zab = new ArrayMap<>();
    private final TaskCompletionSource<Map<ApiKey<?>, String>> zac = new TaskCompletionSource<>();
    private int zad;
    private boolean zae = false;

    public zal(Iterable<? extends HasApiKey<?>> iterable) {
        for (HasApiKey apiKey : iterable) {
            this.zaa.put(apiKey.getApiKey(), null);
        }
        this.zad = this.zaa.keySet().size();
    }

    public final Task<Map<ApiKey<?>, String>> zaa() {
        return this.zac.getTask();
    }

    public final Set<ApiKey<?>> zab() {
        return this.zaa.keySet();
    }

    public final void zac(ApiKey<?> apiKey, ConnectionResult connectionResult, String str) {
        this.zaa.put(apiKey, connectionResult);
        this.zab.put(apiKey, str);
        this.zad--;
        if (!connectionResult.isSuccess()) {
            this.zae = true;
        }
        if (this.zad != 0) {
            return;
        }
        if (this.zae) {
            this.zac.setException(new AvailabilityException(this.zaa));
            return;
        }
        this.zac.setResult(this.zab);
    }
}
