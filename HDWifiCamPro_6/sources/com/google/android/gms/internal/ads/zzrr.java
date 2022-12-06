package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzrr extends zzrj {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzfz zzc;

    protected zzrr() {
    }

    /* access modifiers changed from: protected */
    public final void zzj() {
        for (zzrq zzrq : this.zza.values()) {
            zzrq.zza.zzi(zzrq.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl() {
        for (zzrq zzrq : this.zza.values()) {
            zzrq.zza.zzk(zzrq.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public void zzn(zzfz zzfz) {
        this.zzc = zzfz;
        this.zzb = zzen.zzD((Handler.Callback) null);
    }

    /* access modifiers changed from: protected */
    public void zzq() {
        for (zzrq zzrq : this.zza.values()) {
            zzrq.zza.zzp(zzrq.zzb);
            zzrq.zza.zzs(zzrq.zzc);
            zzrq.zza.zzr(zzrq.zzc);
        }
        this.zza.clear();
    }

    /* access modifiers changed from: protected */
    public zzsi zzv(Object obj, zzsi zzsi) {
        throw null;
    }

    public void zzw() throws IOException {
        for (zzrq zzrq : this.zza.values()) {
            zzrq.zza.zzw();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzx(Object obj, zzsk zzsk, zzcn zzcn);

    /* access modifiers changed from: protected */
    public final void zzy(Object obj, zzsk zzsk) {
        zzdd.zzd(!this.zza.containsKey(obj));
        zzro zzro = new zzro(this, obj);
        zzrp zzrp = new zzrp(this, obj);
        this.zza.put(obj, new zzrq(zzsk, zzro, zzrp));
        Handler handler = this.zzb;
        if (handler != null) {
            zzsk.zzh(handler, zzrp);
            Handler handler2 = this.zzb;
            if (handler2 != null) {
                zzsk.zzg(handler2, zzrp);
                zzsk.zzm(zzro, this.zzc, zzb());
                if (!zzt()) {
                    zzsk.zzi(zzro);
                    return;
                }
                return;
            }
            throw null;
        }
        throw null;
    }
}
