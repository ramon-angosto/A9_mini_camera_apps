package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zze;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdqb {
    private final zzduy zza;
    private final zzdtn zzb;
    private final zzcvu zzc;
    private final zzdoy zzd;

    public zzdqb(zzduy zzduy, zzdtn zzdtn, zzcvu zzcvu, zzdoy zzdoy) {
        this.zza = zzduy;
        this.zzb = zzdtn;
        this.zzc = zzcvu;
        this.zzd = zzdoy;
    }

    public final View zza() throws zzcna {
        zzcmp zza2 = this.zza.zza(zzq.zzc(), (zzfdk) null, (zzfdn) null);
        View view = (View) zza2;
        view.setVisibility(8);
        zza2.zzaf("/sendMessageToSdk", new zzdpv(this));
        zza2.zzaf("/adMuted", new zzdpw(this));
        this.zzb.zzj(new WeakReference(zza2), "/loadHtml", new zzdpx(this));
        this.zzb.zzj(new WeakReference(zza2), "/showOverlay", new zzdpy(this));
        this.zzb.zzj(new WeakReference(zza2), "/hideOverlay", new zzdpz(this));
        return view;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcmp zzcmp, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcmp zzcmp, Map map) {
        this.zzd.zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzcmp zzcmp, Map map) {
        zze.zzi("Showing native ads overlay.");
        zzcmp.zzH().setVisibility(0);
        this.zzc.zze(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcmp zzcmp, Map map) {
        zze.zzi("Hiding native ads overlay.");
        zzcmp.zzH().setVisibility(8);
        this.zzc.zze(false);
    }
}
