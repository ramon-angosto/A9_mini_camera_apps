package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzpb;

public final class PendingResults {

    private static final class zza<R extends Result> extends zznv<R> {
        private final R zzalr;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzalr = r;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            if (status.getStatusCode() == this.zzalr.getStatus().getStatusCode()) {
                return this.zzalr;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends zznv<R> {
        private final R zzals;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzals = r;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            return this.zzals;
        }
    }

    private static final class zzc<R extends Result> extends zznv<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzpb zzpb = new zzpb(Looper.getMainLooper());
        zzpb.cancel();
        return zzpb;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzaa.zzb(r, (Object) "Result must not be null");
        zzaa.zzb(r.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        zza zza2 = new zza(r);
        zza2.cancel();
        return zza2;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzaa.zzb(r, (Object) "Result must not be null");
        zzc zzc2 = new zzc((GoogleApiClient) null);
        zzc2.zzb(r);
        return new zzox(zzc2);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzaa.zzb(status, (Object) "Result must not be null");
        zzpb zzpb = new zzpb(Looper.getMainLooper());
        zzpb.zzb(status);
        return zzpb;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzaa.zzb(r, (Object) "Result must not be null");
        zzaa.zzb(!r.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        zzb zzb2 = new zzb(googleApiClient, r);
        zzb2.zzb(r);
        return zzb2;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzaa.zzb(status, (Object) "Result must not be null");
        zzpb zzpb = new zzpb(googleApiClient);
        zzpb.zzb(status);
        return zzpb;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzaa.zzb(r, (Object) "Result must not be null");
        zzc zzc2 = new zzc(googleApiClient);
        zzc2.zzb(r);
        return new zzox(zzc2);
    }
}
