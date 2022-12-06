package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzc<O extends Api.ApiOptions> {
    private final Context mContext;
    private final int mId;
    private final zzov zzakS;
    private final Api<O> zzakT;
    private final O zzakU;
    private final zznq<O> zzakV;
    private final Looper zzakW;
    private final zzoj zzakX;
    private final GoogleApiClient zzakY;
    private final AtomicBoolean zzakZ;
    private final AtomicInteger zzala;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzc(@NonNull Context context, Api<O> api, O o) {
        this(context, api, o, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
    }

    public zzc(@NonNull Context context, Api<O> api, O o, Looper looper) {
        this.zzakZ = new AtomicBoolean(false);
        this.zzala = new AtomicInteger(0);
        zzaa.zzb(context, (Object) "Null context is not permitted.");
        zzaa.zzb(api, (Object) "Api must not be null.");
        zzaa.zzb(looper, (Object) "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.zzakT = api;
        this.zzakU = o;
        this.zzakW = looper;
        this.zzakS = new zzov();
        this.zzakV = new zznq<>(this.zzakT, this.zzakU);
        this.zzakY = new zzok(this);
        Pair<zzoj, Integer> zza = zzoj.zza(this.mContext, (zzc<?>) this);
        this.zzakX = (zzoj) zza.first;
        this.mId = ((Integer) zza.second).intValue();
    }

    private <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zza(int i, @NonNull T t) {
        t.zzrI();
        this.zzakX.zza(this, i, t);
        return t;
    }

    private <TResult, A extends Api.zzb> Task<TResult> zza(int i, @NonNull zzpd<A, TResult> zzpd) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzakX.zza(this, i, zzpd, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public int getInstanceId() {
        return this.mId;
    }

    public Looper getLooper() {
        return this.zzakW;
    }

    public void release() {
        boolean z = true;
        if (!this.zzakZ.getAndSet(true)) {
            this.zzakS.release();
            zzoj zzoj = this.zzakX;
            int i = this.mId;
            if (this.zzala.get() <= 0) {
                z = false;
            }
            zzoj.zzd(i, z);
        }
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zza(@NonNull T t) {
        return zza(0, t);
    }

    public <TResult, A extends Api.zzb> Task<TResult> zza(zzpd<A, TResult> zzpd) {
        return zza(0, zzpd);
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzb(@NonNull T t) {
        return zza(1, t);
    }

    public <TResult, A extends Api.zzb> Task<TResult> zzb(zzpd<A, TResult> zzpd) {
        return zza(1, zzpd);
    }

    public void zzrj() {
        this.zzala.incrementAndGet();
    }

    public void zzrk() {
        if (this.zzala.decrementAndGet() == 0 && this.zzakZ.get()) {
            this.zzakX.zzd(this.mId, false);
        }
    }

    public Api<O> zzrl() {
        return this.zzakT;
    }

    public O zzrm() {
        return this.zzakU;
    }

    public zznq<O> zzrn() {
        return this.zzakV;
    }

    public GoogleApiClient zzro() {
        return this.zzakY;
    }
}
