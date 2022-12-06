package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.base.zaq;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean zaa;
    protected final AtomicReference<zam> zab = new AtomicReference<>((Object) null);
    protected final GoogleApiAvailability zac;
    private final Handler zad = new zaq(Looper.getMainLooper());

    zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zac = googleApiAvailability;
    }

    /* access modifiers changed from: private */
    public final void zaa(ConnectionResult connectionResult, int i) {
        this.zab.set((Object) null);
        zab(connectionResult, i);
    }

    /* access modifiers changed from: private */
    public final void zad() {
        this.zab.set((Object) null);
        zac();
    }

    private static final int zae(zam zam) {
        if (zam == null) {
            return -1;
        }
        return zam.zaa();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        zam zam = this.zab.get();
        if (i != 1) {
            if (i == 2) {
                int isGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable == 0) {
                    zad();
                    return;
                } else if (zam != null) {
                    if (zam.zab().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i2 == -1) {
            zad();
            return;
        } else if (i2 == 0) {
            if (zam != null) {
                int i3 = 13;
                if (intent != null) {
                    i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                zaa(new ConnectionResult(i3, (PendingIntent) null, zam.zab().toString()), zae(zam));
                return;
            }
            return;
        }
        if (zam != null) {
            zaa(zam.zab(), zam.zaa());
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zaa(new ConnectionResult(13, (PendingIntent) null), zae(this.zab.get()));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zab.set(bundle.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zam = this.zab.get();
        if (zam != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zam.zaa());
            bundle.putInt("failed_status", zam.zab().getErrorCode());
            bundle.putParcelable("failed_resolution", zam.zab().getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zab(ConnectionResult connectionResult, int i);

    /* access modifiers changed from: protected */
    public abstract void zac();

    public final void zah(ConnectionResult connectionResult, int i) {
        zam zam = new zam(connectionResult, i);
        if (this.zab.compareAndSet((Object) null, zam)) {
            this.zad.post(new zao(this, zam));
        }
    }
}
