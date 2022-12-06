package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdyn implements zzdfv, zza, zzdda, zzddu, zzddv, zzdeo, zzddd, zzasf, zzfii {
    private final List zza;
    private final zzdyb zzb;
    private long zzc;

    public zzdyn(zzdyb zzdyb, zzcom zzcom) {
        this.zzb = zzdyb;
        this.zza = Collections.singletonList(zzcom);
    }

    private final void zze(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(String.valueOf(cls.getSimpleName())), str, objArr);
    }

    public final void onAdClicked() {
        zze(zza.class, "onAdClicked", new Object[0]);
    }

    public final void zza(zze zze) {
        zze(zzddd.class, "onAdFailedToLoad", Integer.valueOf(zze.zza), zze.zzb, zze.zzc);
    }

    public final void zzb(zzfdw zzfdw) {
    }

    public final void zzbE(zzcbc zzcbc) {
        this.zzc = zzt.zzB().elapsedRealtime();
        zze(zzdfv.class, "onAdRequest", new Object[0]);
    }

    public final void zzbF(zzfib zzfib, String str) {
        zze(zzfia.class, "onTaskCreated", str);
    }

    public final void zzbG(zzfib zzfib, String str, Throwable th) {
        zze(zzfia.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzbq(Context context) {
        zze(zzddv.class, "onDestroy", context);
    }

    public final void zzbs(Context context) {
        zze(zzddv.class, "onPause", context);
    }

    public final void zzbt(Context context) {
        zze(zzddv.class, "onResume", context);
    }

    public final void zzbu(String str, String str2) {
        zze(zzasf.class, "onAppEvent", str, str2);
    }

    public final void zzbv() {
        zze(zzdda.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzc(zzfib zzfib, String str) {
        zze(zzfia.class, "onTaskStarted", str);
    }

    public final void zzd(zzfib zzfib, String str) {
        zze(zzfia.class, "onTaskSucceeded", str);
    }

    public final void zzj() {
        zze(zzdda.class, "onAdClosed", new Object[0]);
    }

    public final void zzl() {
        zze(zzddu.class, "onAdImpression", new Object[0]);
    }

    public final void zzm() {
        zze(zzdda.class, "onAdLeftApplication", new Object[0]);
    }

    public final void zzn() {
        long elapsedRealtime = zzt.zzB().elapsedRealtime();
        long j = this.zzc;
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + (elapsedRealtime - j));
        zze(zzdeo.class, "onAdLoaded", new Object[0]);
    }

    public final void zzo() {
        zze(zzdda.class, "onAdOpened", new Object[0]);
    }

    @ParametersAreNonnullByDefault
    public final void zzp(zzcbs zzcbs, String str, String str2) {
        zze(zzdda.class, "onRewarded", zzcbs, str, str2);
    }

    public final void zzr() {
        zze(zzdda.class, "onRewardedVideoStarted", new Object[0]);
    }
}
