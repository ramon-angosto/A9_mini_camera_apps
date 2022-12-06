package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.internal.zznt;

public class zzok<O extends Api.ApiOptions> extends zzob {
    private final zzc<O> zzaoe;

    public zzok(zzc<O> zzc) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zzaoe = zzc;
    }

    public Looper getLooper() {
        return this.zzaoe.getLooper();
    }

    public void zza(zzpe zzpe) {
        this.zzaoe.zzrj();
    }

    public void zzb(zzpe zzpe) {
        this.zzaoe.zzrk();
    }

    public <A extends Api.zzb, R extends Result, T extends zznt.zza<R, A>> T zzc(@NonNull T t) {
        return this.zzaoe.zza(t);
    }

    public <A extends Api.zzb, T extends zznt.zza<? extends Result, A>> T zzd(@NonNull T t) {
        return this.zzaoe.zzb(t);
    }
}
