package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbkb {
    private MotionEvent zza = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzb = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
    private final Context zzc;
    private final ScheduledExecutorService zzd;
    private final zzfju zze;
    private final zzbkd zzf;

    public zzbkb(Context context, ScheduledExecutorService scheduledExecutorService, zzbkd zzbkd, zzfju zzfju, byte[] bArr) {
        this.zzc = context;
        this.zzd = scheduledExecutorService;
        this.zzf = zzbkd;
        this.zze = zzfju;
    }

    public final zzfzp zza() {
        return (zzfyx) zzfzg.zzo(zzfyx.zzv(zzfzg.zzi((Object) null)), ((Long) zzbkr.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd);
    }

    public final void zzb(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zza.getEventTime()) {
            this.zza = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.zzb.getEventTime()) {
            this.zzb = MotionEvent.obtain(motionEvent);
        }
    }
}
