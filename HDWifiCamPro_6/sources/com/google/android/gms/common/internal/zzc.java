package com.google.android.gms.common.internal;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public abstract class zzc<TListener> {
    private TListener zza;
    private boolean zzb = false;
    final /* synthetic */ BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient, TListener tlistener) {
        this.zzd = baseGmsClient;
        this.zza = tlistener;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(TListener tlistener);

    /* access modifiers changed from: protected */
    public abstract void zzc();

    public final void zze() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.zza;
            if (this.zzb) {
                String obj = toString();
                StringBuilder sb = new StringBuilder(obj.length() + 47);
                sb.append("Callback proxy ");
                sb.append(obj);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != null) {
            try {
                zza(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzb = true;
        }
        zzg();
    }

    public final void zzf() {
        synchronized (this) {
            this.zza = null;
        }
    }

    public final void zzg() {
        zzf();
        synchronized (this.zzd.zzt) {
            this.zzd.zzt.remove(this);
        }
    }
}
