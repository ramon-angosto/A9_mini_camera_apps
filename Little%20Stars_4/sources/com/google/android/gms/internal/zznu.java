package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzol;

public abstract class zznu extends zzoq implements DialogInterface.OnCancelListener {
    protected boolean mStarted;
    protected boolean zzalQ;
    /* access modifiers changed from: private */
    public ConnectionResult zzalR;
    /* access modifiers changed from: private */
    public int zzalS;
    private final Handler zzalT;
    protected final GoogleApiAvailability zzaln;

    private class zza implements Runnable {
        private zza() {
        }

        @MainThread
        public void run() {
            if (zznu.this.mStarted) {
                if (zznu.this.zzalR.hasResolution()) {
                    zznu.this.zzaop.startActivityForResult(GoogleApiActivity.zzb(zznu.this.getActivity(), zznu.this.zzalR.getResolution(), zznu.this.zzalS, false), 1);
                } else if (zznu.this.zzaln.isUserResolvableError(zznu.this.zzalR.getErrorCode())) {
                    zznu.this.zzaln.zza(zznu.this.getActivity(), zznu.this.zzaop, zznu.this.zzalR.getErrorCode(), 2, zznu.this);
                } else if (zznu.this.zzalR.getErrorCode() == 18) {
                    final Dialog zza = zznu.this.zzaln.zza(zznu.this.getActivity(), (DialogInterface.OnCancelListener) zznu.this);
                    zznu.this.zzaln.zza(zznu.this.getActivity().getApplicationContext(), (zzol.zza) new zzol.zza() {
                        public void zzrG() {
                            zznu.this.zzrF();
                            if (zza.isShowing()) {
                                zza.dismiss();
                            }
                        }
                    });
                } else {
                    zznu zznu = zznu.this;
                    zznu.zza(zznu.zzalR, zznu.this.zzalS);
                }
            }
        }
    }

    protected zznu(zzor zzor) {
        this(zzor, GoogleApiAvailability.getInstance());
    }

    zznu(zzor zzor, GoogleApiAvailability googleApiAvailability) {
        super(zzor);
        this.zzalS = -1;
        this.zzalT = new Handler(Looper.getMainLooper());
        this.zzaln = googleApiAvailability;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r3, int r4, android.content.Intent r5) {
        /*
            r2 = this;
            r0 = 1
            r1 = 0
            if (r3 == r0) goto L_0x0023
            r4 = 2
            if (r3 == r4) goto L_0x0008
            goto L_0x003b
        L_0x0008:
            com.google.android.gms.common.GoogleApiAvailability r3 = r2.zzaln
            android.app.Activity r4 = r2.getActivity()
            int r3 = r3.isGooglePlayServicesAvailable(r4)
            if (r3 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.common.ConnectionResult r4 = r2.zzalR
            int r4 = r4.getErrorCode()
            r5 = 18
            if (r4 != r5) goto L_0x003c
            if (r3 != r5) goto L_0x003c
            return
        L_0x0023:
            r3 = -1
            if (r4 != r3) goto L_0x0027
            goto L_0x003c
        L_0x0027:
            if (r4 != 0) goto L_0x003b
            r3 = 13
            if (r5 == 0) goto L_0x0033
            java.lang.String r4 = "<<ResolutionFailureErrorDetail>>"
            int r3 = r5.getIntExtra(r4, r3)
        L_0x0033:
            com.google.android.gms.common.ConnectionResult r4 = new com.google.android.gms.common.ConnectionResult
            r5 = 0
            r4.<init>(r3, r5)
            r2.zzalR = r4
        L_0x003b:
            r0 = 0
        L_0x003c:
            if (r0 == 0) goto L_0x0042
            r2.zzrF()
            goto L_0x0049
        L_0x0042:
            com.google.android.gms.common.ConnectionResult r3 = r2.zzalR
            int r4 = r2.zzalS
            r2.zza(r3, r4)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznu.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, (PendingIntent) null), this.zzalS);
        zzrF();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzalQ = bundle.getBoolean("resolving_error", false);
            if (this.zzalQ) {
                this.zzalS = bundle.getInt("failed_client_id", -1);
                this.zzalR = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.zzalQ);
        if (this.zzalQ) {
            bundle.putInt("failed_client_id", this.zzalS);
            bundle.putInt("failed_status", this.zzalR.getErrorCode());
            bundle.putParcelable("failed_resolution", this.zzalR.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ConnectionResult connectionResult, int i);

    public void zzb(ConnectionResult connectionResult, int i) {
        if (!this.zzalQ) {
            this.zzalQ = true;
            this.zzalS = i;
            this.zzalR = connectionResult;
            this.zzalT.post(new zza());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzrA();

    /* access modifiers changed from: protected */
    public void zzrF() {
        this.zzalS = -1;
        this.zzalQ = false;
        this.zzalR = null;
        zzrA();
    }
}
