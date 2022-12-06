package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzegu implements DialogInterface.OnCancelListener {
    public final /* synthetic */ zzego zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzdxq zzc;
    public final /* synthetic */ Activity zzd;
    public final /* synthetic */ zzfir zze;
    public final /* synthetic */ zzl zzf;

    public /* synthetic */ zzegu(zzego zzego, String str, zzdxq zzdxq, Activity activity, zzfir zzfir, zzl zzl) {
        this.zza = zzego;
        this.zzb = str;
        this.zzc = zzdxq;
        this.zzd = activity;
        this.zze = zzfir;
        this.zzf = zzl;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zzego zzego = this.zza;
        String str = this.zzb;
        zzdxq zzdxq = this.zzc;
        Activity activity = this.zzd;
        zzfir zzfir = this.zze;
        zzl zzl = this.zzf;
        zzego.zzc(str);
        if (zzdxq != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzegw.zzd(activity, zzdxq, zzfir, zzego, str, "dialog_click", hashMap);
        }
        if (zzl != null) {
            zzl.zzb();
        }
    }
}
