package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;

public abstract class zznp {
    public final int zzagd;
    public final int zzalC;

    public static final class zza extends zznp {
        public final zznt.zza<? extends Result, Api.zzb> zzalD;

        public zza(int i, int i2, zznt.zza<? extends Result, Api.zzb> zza) {
            super(i, i2);
            this.zzalD = zza;
        }

        public boolean cancel() {
            return this.zzalD.zzrH();
        }

        public void zza(SparseArray<zzpf> sparseArray) {
            zzpf zzpf = sparseArray.get(this.zzalC);
            if (zzpf != null) {
                zzpf.zzg(this.zzalD);
            }
        }

        public void zzb(Api.zzb zzb) throws DeadObjectException {
            this.zzalD.zzb(zzb);
        }

        public void zzv(@NonNull Status status) {
            this.zzalD.zzx(status);
        }
    }

    public static final class zzb<TResult> extends zznp {
        private static final Status zzalG = new Status(8, "Connection to Google Play services was lost while executing the API call.");
        private final zzpd<Api.zzb, TResult> zzalE;
        private final TaskCompletionSource<TResult> zzalF;

        public zzb(int i, int i2, zzpd<Api.zzb, TResult> zzpd, TaskCompletionSource<TResult> taskCompletionSource) {
            super(i, i2);
            this.zzalF = taskCompletionSource;
            this.zzalE = zzpd;
        }

        public void zzb(Api.zzb zzb) throws DeadObjectException {
            try {
                this.zzalE.zza(zzb, this.zzalF);
            } catch (DeadObjectException e) {
                zzv(zzalG);
                throw e;
            } catch (RemoteException unused) {
                zzv(zzalG);
            }
        }

        public void zzv(@NonNull Status status) {
            Exception exc;
            TaskCompletionSource<TResult> taskCompletionSource;
            if (status.getStatusCode() == 8) {
                taskCompletionSource = this.zzalF;
                exc = new FirebaseException(status.getStatusMessage());
            } else {
                taskCompletionSource = this.zzalF;
                exc = new FirebaseApiNotAvailableException(status.getStatusMessage());
            }
            taskCompletionSource.setException(exc);
        }
    }

    public zznp(int i, int i2) {
        this.zzalC = i;
        this.zzagd = i2;
    }

    public boolean cancel() {
        return true;
    }

    public void zza(SparseArray<zzpf> sparseArray) {
    }

    public abstract void zzb(Api.zzb zzb2) throws DeadObjectException;

    public abstract void zzv(@NonNull Status status);
}
