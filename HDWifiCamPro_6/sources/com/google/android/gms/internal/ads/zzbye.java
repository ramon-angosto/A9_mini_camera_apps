package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbye extends zzbyf implements zzbpu {
    DisplayMetrics zza;
    int zzb = -1;
    int zzc = -1;
    int zzd = -1;
    int zze = -1;
    int zzf = -1;
    int zzg = -1;
    private final zzcmp zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbim zzk;
    private float zzl;
    private int zzm;

    public zzbye(zzcmp zzcmp, Context context, zzbim zzbim) {
        super(zzcmp, "");
        this.zzh = zzcmp;
        this.zzi = context;
        this.zzk = zzbim;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObject;
        zzcmp zzcmp = (zzcmp) obj;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        zzaw.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzcgi.zzu(displayMetrics, displayMetrics.widthPixels);
        zzaw.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzcgi.zzu(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzk2 = this.zzh.zzk();
        if (zzk2 == null || zzk2.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            zzt.zzp();
            int[] zzN = zzs.zzN(zzk2);
            zzaw.zzb();
            this.zzd = zzcgi.zzu(this.zza, zzN[0]);
            zzaw.zzb();
            this.zze = zzcgi.zzu(this.zza, zzN[1]);
        }
        if (this.zzh.zzQ().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzi(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbyd zzbyd = new zzbyd();
        zzbim zzbim = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbyd.zze(zzbim.zza(intent));
        zzbim zzbim2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbyd.zzc(zzbim2.zza(intent2));
        zzbyd.zza(this.zzk.zzb());
        zzbyd.zzd(this.zzk.zzc());
        zzbyd.zzb(true);
        boolean zzh2 = zzbyd.zza;
        boolean zzj2 = zzbyd.zzb;
        boolean zzf2 = zzbyd.zzc;
        boolean zzi2 = zzbyd.zzd;
        boolean zzg2 = zzbyd.zze;
        zzcmp zzcmp2 = this.zzh;
        try {
            jSONObject = new JSONObject().put("sms", zzh2).put("tel", zzj2).put("calendar", zzf2).put("storePicture", zzi2).put("inlineVideo", zzg2);
        } catch (JSONException e) {
            zze.zzh("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObject = null;
        }
        zzcmp2.zze("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(zzaw.zzb().zzb(this.zzi, iArr[0]), zzaw.zzb().zzb(this.zzi, iArr[1]));
        if (zze.zzm(2)) {
            zze.zzi("Dispatching Ready Event.");
        }
        zzh(this.zzh.zzp().zza);
    }

    public final void zzb(int i, int i2) {
        int i3;
        int i4 = 0;
        if (this.zzi instanceof Activity) {
            zzt.zzp();
            i3 = zzs.zzO((Activity) this.zzi)[0];
        } else {
            i3 = 0;
        }
        if (this.zzh.zzQ() == null || !this.zzh.zzQ().zzi()) {
            int width = this.zzh.getWidth();
            int height = this.zzh.getHeight();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzP)).booleanValue()) {
                if (width == 0) {
                    width = this.zzh.zzQ() != null ? this.zzh.zzQ().zzb : 0;
                }
                if (height == 0) {
                    if (this.zzh.zzQ() != null) {
                        i4 = this.zzh.zzQ().zza;
                    }
                    this.zzf = zzaw.zzb().zzb(this.zzi, width);
                    this.zzg = zzaw.zzb().zzb(this.zzi, i4);
                }
            }
            i4 = height;
            this.zzf = zzaw.zzb().zzb(this.zzi, width);
            this.zzg = zzaw.zzb().zzb(this.zzi, i4);
        }
        zzf(i, i2 - i3, this.zzf, this.zzg);
        this.zzh.zzP().zzA(i, i2);
    }
}
