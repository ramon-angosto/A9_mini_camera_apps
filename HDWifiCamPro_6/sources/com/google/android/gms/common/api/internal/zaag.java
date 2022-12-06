package com.google.android.gms.common.api.internal;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public class zaag extends GoogleApiClient {
    private final String zaa = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";

    public zaag(String str) {
    }

    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void connect() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void disconnect() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final boolean hasConnectedApi(Api<?> api) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final boolean isConnected() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final boolean isConnecting() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void reconnect() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.zaa);
    }
}
