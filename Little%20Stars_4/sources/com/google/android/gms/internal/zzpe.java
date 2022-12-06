package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzaa;
import java.lang.ref.WeakReference;

public class zzpe<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */
    public final Object zzalY = new Object();
    /* access modifiers changed from: private */
    public final WeakReference<GoogleApiClient> zzama;
    /* access modifiers changed from: private */
    public ResultTransform<? super R, ? extends Result> zzaoA = null;
    /* access modifiers changed from: private */
    public zzpe<? extends Result> zzaoB = null;
    private volatile ResultCallbacks<? super R> zzaoC = null;
    private PendingResult<R> zzaoD = null;
    private Status zzaoE = null;
    /* access modifiers changed from: private */
    public final zza zzaoF;
    private boolean zzaoG = false;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                PendingResult pendingResult = (PendingResult) message.obj;
                synchronized (zzpe.this.zzalY) {
                    if (pendingResult == null) {
                        zzpe.this.zzaoB.zzA(new Status(13, "Transform returned null"));
                    } else if (pendingResult instanceof zzoz) {
                        zzpe.this.zzaoB.zzA(((zzoz) pendingResult).getStatus());
                    } else {
                        zzpe.this.zzaoB.zza(pendingResult);
                    }
                }
            } else if (i != 1) {
                int i2 = message.what;
                StringBuilder sb = new StringBuilder(70);
                sb.append("TransformationResultHandler received unknown message type: ");
                sb.append(i2);
                Log.e("TransformedResultImpl", sb.toString());
            } else {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
                throw runtimeException;
            }
        }
    }

    public zzpe(WeakReference<GoogleApiClient> weakReference) {
        zzaa.zzb(weakReference, (Object) "GoogleApiClient reference must not be null");
        this.zzama = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zzama.get();
        this.zzaoF = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public void zzA(Status status) {
        synchronized (this.zzalY) {
            this.zzaoE = status;
            zzB(this.zzaoE);
        }
    }

    private void zzB(Status status) {
        synchronized (this.zzalY) {
            if (this.zzaoA != null) {
                Status onFailure = this.zzaoA.onFailure(status);
                zzaa.zzb(onFailure, (Object) "onFailure must not return null");
                this.zzaoB.zzA(onFailure);
            } else if (zzsK()) {
                this.zzaoC.onFailure(status);
            }
        }
    }

    /* access modifiers changed from: private */
    public void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e);
            }
        }
    }

    private void zzsI() {
        if (this.zzaoA != null || this.zzaoC != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzama.get();
            if (!(this.zzaoG || this.zzaoA == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.zzaoG = true;
            }
            Status status = this.zzaoE;
            if (status != null) {
                zzB(status);
                return;
            }
            PendingResult<R> pendingResult = this.zzaoD;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    private boolean zzsK() {
        return (this.zzaoC == null || ((GoogleApiClient) this.zzama.get()) == null) ? false : true;
    }

    public void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.zzalY) {
            boolean z = true;
            zzaa.zza(this.zzaoC == null, (Object) "Cannot call andFinally() twice.");
            if (this.zzaoA != null) {
                z = false;
            }
            zzaa.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzaoC = resultCallbacks;
            zzsI();
        }
    }

    public void onResult(final R r) {
        synchronized (this.zzalY) {
            if (!r.getStatus().isSuccess()) {
                zzA(r.getStatus());
                zzd((Result) r);
            } else if (this.zzaoA != null) {
                zzoy.zzsp().submit(new Runnable() {
                    @WorkerThread
                    public void run() {
                        GoogleApiClient googleApiClient;
                        try {
                            zznv.zzalX.set(true);
                            zzpe.this.zzaoF.sendMessage(zzpe.this.zzaoF.obtainMessage(0, zzpe.this.zzaoA.onSuccess(r)));
                            zznv.zzalX.set(false);
                            zzpe.this.zzd(r);
                            googleApiClient = (GoogleApiClient) zzpe.this.zzama.get();
                            if (googleApiClient == null) {
                                return;
                            }
                        } catch (RuntimeException e) {
                            zzpe.this.zzaoF.sendMessage(zzpe.this.zzaoF.obtainMessage(1, e));
                            zznv.zzalX.set(false);
                            zzpe.this.zzd(r);
                            googleApiClient = (GoogleApiClient) zzpe.this.zzama.get();
                            if (googleApiClient == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            zznv.zzalX.set(false);
                            zzpe.this.zzd(r);
                            GoogleApiClient googleApiClient2 = (GoogleApiClient) zzpe.this.zzama.get();
                            if (googleApiClient2 != null) {
                                googleApiClient2.zzb(zzpe.this);
                            }
                            throw th;
                        }
                        googleApiClient.zzb(zzpe.this);
                    }
                });
            } else if (zzsK()) {
                this.zzaoC.onSuccess(r);
            }
        }
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zzpe<? extends Result> zzpe;
        synchronized (this.zzalY) {
            boolean z = true;
            zzaa.zza(this.zzaoA == null, (Object) "Cannot call then() twice.");
            if (this.zzaoC != null) {
                z = false;
            }
            zzaa.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzaoA = resultTransform;
            zzpe = new zzpe<>(this.zzama);
            this.zzaoB = zzpe;
            zzsI();
        }
        return zzpe;
    }

    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.zzalY) {
            this.zzaoD = pendingResult;
            zzsI();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzsJ() {
        this.zzaoC = null;
    }
}
