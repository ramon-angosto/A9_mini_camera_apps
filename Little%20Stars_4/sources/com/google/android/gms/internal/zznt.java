package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzpf;
import java.util.concurrent.atomic.AtomicReference;

public class zznt {

    public static abstract class zza<R extends Result, A extends Api.zzb> extends zznv<R> implements zzb<R> {
        private final Api<?> zzakT;
        private final Api.zzc<A> zzalO;
        private AtomicReference<zzpf.zzb> zzalP = new AtomicReference<>();

        @Deprecated
        protected zza(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzaa.zzb(googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.zzalO = (Api.zzc) zzaa.zzz(zzc);
            this.zzakT = null;
        }

        protected zza(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzaa.zzb(googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.zzalO = api.zzre();
            this.zzakT = api;
        }

        private void zza(RemoteException remoteException) {
            zzx(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        public /* synthetic */ void setResult(Object obj) {
            super.zzb((Result) obj);
        }

        /* access modifiers changed from: protected */
        public abstract void zza(A a) throws RemoteException;

        /* access modifiers changed from: protected */
        public void zza(R r) {
        }

        public void zza(zzpf.zzb zzb) {
            this.zzalP.set(zzb);
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza(a);
            } catch (DeadObjectException e) {
                zza((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        public void zzrD() {
            setResultCallback((ResultCallback) null);
        }

        /* access modifiers changed from: protected */
        public void zzrE() {
            zzpf.zzb andSet = this.zzalP.getAndSet((Object) null);
            if (andSet != null) {
                andSet.zzh(this);
            }
        }

        public final Api.zzc<A> zzre() {
            return this.zzalO;
        }

        public final Api<?> zzrl() {
            return this.zzakT;
        }

        public final void zzx(Status status) {
            zzaa.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            Result zzc = zzc(status);
            zzb(zzc);
            zza(zzc);
        }
    }

    public interface zzb<R> {
        void setResult(R r);

        void zzx(Status status);
    }
}
