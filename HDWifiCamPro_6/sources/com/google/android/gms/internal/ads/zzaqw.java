package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaqw extends zzarq {
    public zzaqw(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2) {
        super(zzaqe, "ysEnh8zkgcN8WwINs5FP7vGybZW2TtVSX36HO6emvdUrcCkVbC9hrF5Pe5ZSZx3i", "3LpdW89cIASEFv5WvS5ZDEWsiVGQitP33SL3WZgJ6zE=", zzamk, i, 24);
    }

    private final void zzc() {
        AdvertisingIdClient zzh = this.zzb.zzh();
        if (zzh != null) {
            try {
                AdvertisingIdClient.Info info = zzh.getInfo();
                String zzd = zzaqh.zzd(info.getId());
                if (zzd != null) {
                    synchronized (this.zze) {
                        this.zze.zzs(zzd);
                        this.zze.zzr(info.isLimitAdTrackingEnabled());
                        this.zze.zzab(6);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzk();
        return null;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (!this.zzb.zzq()) {
            synchronized (this.zze) {
                this.zze.zzs((String) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()}));
            }
            return;
        }
        zzc();
    }

    public final Void zzk() throws Exception {
        if (this.zzb.zzr()) {
            super.zzk();
            return null;
        }
        if (this.zzb.zzq()) {
            zzc();
        }
        return null;
    }
}
