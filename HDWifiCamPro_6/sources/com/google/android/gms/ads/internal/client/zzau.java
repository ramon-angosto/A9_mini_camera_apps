package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzbqu;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzbyv;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.internal.ads.zzbzc;
import com.google.android.gms.internal.ads.zzcah;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzccx;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcgp;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzau {
    /* access modifiers changed from: private */
    public final zzk zza;
    /* access modifiers changed from: private */
    public final zzi zzb;
    /* access modifiers changed from: private */
    public final zzek zzc;
    /* access modifiers changed from: private */
    public final zzbod zzd;
    private final zzccx zze;
    /* access modifiers changed from: private */
    public final zzbyz zzf;
    /* access modifiers changed from: private */
    public final zzboe zzg;
    /* access modifiers changed from: private */
    public zzcah zzh;

    public zzau(zzk zzk, zzi zzi, zzek zzek, zzbod zzbod, zzccx zzccx, zzbyz zzbyz, zzboe zzboe) {
        this.zza = zzk;
        this.zzb = zzi;
        this.zzc = zzek;
        this.zzd = zzbod;
        this.zze = zzccx;
        this.zzf = zzbyz;
        this.zzg = zzboe;
    }

    static /* bridge */ /* synthetic */ void zzs(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzaw.zzb().zzm(context, zzaw.zzc().zza, "gmob-apps", bundle, true);
    }

    public final zzbo zzc(Context context, String str, zzbvk zzbvk) {
        return (zzbo) new zzam(this, context, str, zzbvk).zzd(context, false);
    }

    public final zzbs zzd(Context context, zzq zzq, String str, zzbvk zzbvk) {
        return (zzbs) new zzai(this, context, zzq, str, zzbvk).zzd(context, false);
    }

    public final zzbs zze(Context context, zzq zzq, String str, zzbvk zzbvk) {
        return (zzbs) new zzak(this, context, zzq, str, zzbvk).zzd(context, false);
    }

    public final zzbmi zzg(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbmi) new zzaq(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbmo zzh(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbmo) new zzas(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzbqu zzk(Context context, zzbvk zzbvk, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbqu) new zzag(this, context, zzbvk, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbyv zzl(Context context, zzbvk zzbvk) {
        return (zzbyv) new zzae(this, context, zzbvk).zzd(context, false);
    }

    public final zzbzc zzn(Activity activity) {
        zzaa zzaa = new zzaa(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzcgp.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbzc) zzaa.zzd(activity, z);
    }

    public final zzccl zzp(Context context, String str, zzbvk zzbvk) {
        return (zzccl) new zzat(this, context, str, zzbvk).zzd(context, false);
    }

    public final zzcfg zzq(Context context, zzbvk zzbvk) {
        return (zzcfg) new zzac(this, context, zzbvk).zzd(context, false);
    }
}
