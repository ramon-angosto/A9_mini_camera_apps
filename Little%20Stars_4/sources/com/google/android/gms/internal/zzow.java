package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zzow extends zznu {
    private TaskCompletionSource<Void> zzalF = new TaskCompletionSource<>();

    private zzow(zzor zzor) {
        super(zzor);
        this.zzaop.zza("GmsAvailabilityHelper", (zzoq) this);
    }

    public static zzow zzu(Activity activity) {
        zzor zzs = zzs(activity);
        zzow zzow = (zzow) zzs.zza("GmsAvailabilityHelper", zzow.class);
        if (zzow == null) {
            return new zzow(zzs);
        }
        if (zzow.zzalF.getTask().isComplete()) {
            zzow.zzalF = new TaskCompletionSource<>();
        }
        return zzow;
    }

    public Task<Void> getTask() {
        return this.zzalF.getTask();
    }

    public void onStop() {
        super.onStop();
        this.zzalF.setException(new CancellationException());
    }

    /* access modifiers changed from: protected */
    public void zza(ConnectionResult connectionResult, int i) {
        this.zzalF.setException(new Exception());
    }

    public void zzk(ConnectionResult connectionResult) {
        zzb(connectionResult, 0);
    }

    /* access modifiers changed from: protected */
    public void zzrA() {
        int isGooglePlayServicesAvailable = this.zzaln.isGooglePlayServicesAvailable(this.zzaop.zzsF());
        if (isGooglePlayServicesAvailable == 0) {
            this.zzalF.setResult(null);
        } else {
            zzk(new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null));
        }
    }
}
