package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbel {
    /* access modifiers changed from: private */
    public zzbea zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Object zzd = new Object();

    zzbel(Context context) {
        this.zzc = context;
    }

    /* access modifiers changed from: package-private */
    public final Future zzc(zzbeb zzbeb) {
        zzbef zzbef = new zzbef(this);
        zzbej zzbej = new zzbej(this, zzbeb, zzbef);
        zzbek zzbek = new zzbek(this, zzbef);
        synchronized (this.zzd) {
            this.zza = new zzbea(this.zzc, zzt.zzt().zzb(), zzbej, zzbek);
            this.zza.checkAvailabilityAndConnect();
        }
        return zzbef;
    }

    static /* bridge */ /* synthetic */ void zze(zzbel zzbel) {
        synchronized (zzbel.zzd) {
            zzbea zzbea = zzbel.zza;
            if (zzbea != null) {
                zzbea.disconnect();
                zzbel.zza = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
