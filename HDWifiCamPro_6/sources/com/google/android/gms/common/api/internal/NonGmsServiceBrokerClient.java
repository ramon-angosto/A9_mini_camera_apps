package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class NonGmsServiceBrokerClient implements Api.Client, ServiceConnection {
    private static final String zaa = NonGmsServiceBrokerClient.class.getSimpleName();
    private final String zab;
    private final String zac;
    private final ComponentName zad;
    private final Context zae;
    private final ConnectionCallbacks zaf;
    private final Handler zag;
    private final OnConnectionFailedListener zah;
    private IBinder zai;
    private boolean zaj;
    private String zak;
    private String zal;

    public NonGmsServiceBrokerClient(Context context, Looper looper, ComponentName componentName, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, (String) null, (String) null, componentName, connectionCallbacks, onConnectionFailedListener);
    }

    private final void zad() {
        if (Thread.currentThread() != this.zag.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    private final void zae(String str) {
        String.valueOf(String.valueOf(this.zai)).length();
    }

    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        zad();
        zae("Connect started.");
        if (isConnected()) {
            try {
                disconnect("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.zad;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.zab).setAction(this.zac);
            }
            boolean bindService = this.zae.bindService(intent, this, GmsClientSupervisor.getDefaultBindFlags());
            this.zaj = bindService;
            if (!bindService) {
                this.zai = null;
                this.zah.onConnectionFailed(new ConnectionResult(16));
            }
            zae("Finished connect.");
        } catch (SecurityException e) {
            this.zaj = false;
            this.zai = null;
            throw e;
        }
    }

    public final void disconnect() {
        zad();
        zae("Disconnect called.");
        try {
            this.zae.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.zaj = false;
        this.zai = null;
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    public IBinder getBinder() {
        zad();
        return this.zai;
    }

    public final String getEndpointPackageName() {
        String str = this.zab;
        if (str != null) {
            return str;
        }
        Preconditions.checkNotNull(this.zad);
        return this.zad.getPackageName();
    }

    public final String getLastDisconnectMessage() {
        return this.zak;
    }

    public final int getMinApkVersion() {
        return 0;
    }

    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
    }

    public final Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    public final IBinder getServiceBrokerBinder() {
        return null;
    }

    public final Intent getSignInIntent() {
        return new Intent();
    }

    public final boolean isConnected() {
        zad();
        return this.zai != null;
    }

    public final boolean isConnecting() {
        zad();
        return this.zaj;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zag.post(new zacg(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zag.post(new zacf(this));
    }

    public final void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
    }

    public final boolean providesSignIn() {
        return false;
    }

    public final boolean requiresAccount() {
        return false;
    }

    public final boolean requiresGooglePlayServices() {
        return false;
    }

    public final boolean requiresSignIn() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zaa(IBinder iBinder) {
        this.zaj = false;
        this.zai = iBinder;
        zae("Connected.");
        this.zaf.onConnected(new Bundle());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zab() {
        this.zaj = false;
        this.zai = null;
        zae("Disconnected.");
        this.zaf.onConnectionSuspended(1);
    }

    public final void zac(String str) {
        this.zal = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r6 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private NonGmsServiceBrokerClient(android.content.Context r2, android.os.Looper r3, java.lang.String r4, java.lang.String r5, android.content.ComponentName r6, com.google.android.gms.common.api.internal.ConnectionCallbacks r7, com.google.android.gms.common.api.internal.OnConnectionFailedListener r8) {
        /*
            r1 = this;
            r1.<init>()
            r0 = 0
            r1.zaj = r0
            r0 = 0
            r1.zak = r0
            r1.zae = r2
            com.google.android.gms.internal.base.zaq r2 = new com.google.android.gms.internal.base.zaq
            r2.<init>(r3)
            r1.zag = r2
            r1.zaf = r7
            r1.zah = r8
            if (r4 == 0) goto L_0x001e
            if (r5 == 0) goto L_0x001e
            if (r6 != 0) goto L_0x0027
            r6 = r0
            goto L_0x0020
        L_0x001e:
            if (r6 == 0) goto L_0x0027
        L_0x0020:
            r1.zab = r4
            r1.zac = r5
            r1.zad = r6
            return
        L_0x0027:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            java.lang.String r3 = "Must specify either package or component, but not both"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient.<init>(android.content.Context, android.os.Looper, java.lang.String, java.lang.String, android.content.ComponentName, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):void");
    }

    public NonGmsServiceBrokerClient(Context context, Looper looper, String str, String str2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, str, str2, (ComponentName) null, connectionCallbacks, onConnectionFailedListener);
    }

    public final void disconnect(String str) {
        zad();
        this.zak = str;
        disconnect();
    }
}
