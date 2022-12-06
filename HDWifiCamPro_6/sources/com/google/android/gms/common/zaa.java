package com.google.android.gms.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final /* synthetic */ class zaa implements SuccessContinuation {
    public static final /* synthetic */ zaa zaa = new zaa();

    private /* synthetic */ zaa() {
    }

    public final Task then(Object obj) {
        Map map = (Map) obj;
        int i = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return Tasks.forResult(null);
    }
}
