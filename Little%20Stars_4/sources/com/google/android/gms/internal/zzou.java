package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzaa;

public final class zzou<L> {
    private volatile L mListener;
    private final zza zzaov;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            zzaa.zzaj(z);
            zzou.this.zzb((zzb) message.obj);
        }
    }

    public interface zzb<L> {
        void zzrV();

        void zzt(L l);
    }

    zzou(Looper looper, L l) {
        this.zzaov = new zza(looper);
        this.mListener = zzaa.zzb(l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzb2) {
        zzaa.zzb(zzb2, (Object) "Notifier must not be null");
        this.zzaov.sendMessage(this.zzaov.obtainMessage(1, zzb2));
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzb<? super L> zzb2) {
        L l = this.mListener;
        if (l == null) {
            zzb2.zzrV();
            return;
        }
        try {
            zzb2.zzt(l);
        } catch (RuntimeException e) {
            zzb2.zzrV();
            throw e;
        }
    }
}
