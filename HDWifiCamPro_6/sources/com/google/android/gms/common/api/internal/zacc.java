package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zacc extends zap {
    private TaskCompletionSource<Void> zad = new TaskCompletionSource<>();

    private zacc(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
    }

    public static zacc zaa(Activity activity) {
        LifecycleFragment fragment = getFragment(activity);
        zacc zacc = (zacc) fragment.getCallbackOrNull("GmsAvailabilityHelper", zacc.class);
        if (zacc == null) {
            return new zacc(fragment);
        }
        if (zacc.zad.getTask().isComplete()) {
            zacc.zad = new TaskCompletionSource<>();
        }
        return zacc;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zad.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    /* access modifiers changed from: protected */
    public final void zab(ConnectionResult connectionResult, int i) {
        String errorMessage = connectionResult.getErrorMessage();
        if (errorMessage == null) {
            errorMessage = "Error connecting to Google Play services";
        }
        this.zad.setException(new ApiException(new Status(connectionResult, errorMessage, connectionResult.getErrorCode())));
    }

    /* access modifiers changed from: protected */
    public final void zac() {
        Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
        if (lifecycleActivity == null) {
            this.zad.trySetException(new ApiException(new Status(8)));
            return;
        }
        int isGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(lifecycleActivity);
        if (isGooglePlayServicesAvailable == 0) {
            this.zad.trySetResult(null);
        } else if (!this.zad.getTask().isComplete()) {
            zah(new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null), 0);
        }
    }

    public final Task<Void> zad() {
        return this.zad.getTask();
    }
}
