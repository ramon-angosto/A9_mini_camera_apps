package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzbyv;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class OfflineNotificationPoster extends Worker {
    private final zzbyv zza;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzaw.zza().zzl(context, new zzbvh());
    }

    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzg(ObjectWrapper.wrap(getApplicationContext()), getInputData().getString("uri"), getInputData().getString("gws_query_id"));
            return ListenableWorker.Result.success();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.failure();
        }
    }
}
