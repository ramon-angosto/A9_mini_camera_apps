package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcvg implements zzbud {
    private final Context zza;
    private final zzbbm zzb;
    private final PowerManager zzc;

    public zzcvg(Context context, zzbbm zzbbm) {
        this.zza = context;
        this.zzb = zzbbm;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzcvj zzcvj) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        Integer num;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzbbp zzbbp = zzcvj.zzf;
        if (zzbbp == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z2 = zzbbp.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzd()).put("timestamp", zzcvj.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzc()).put("isMraid", false);
            boolean z3 = zzcvj.zzc;
            JSONObject put2 = put.put("isStopped", false).put("isPaused", zzcvj.zzb).put("isNative", this.zzb.zze());
            if (Build.VERSION.SDK_INT >= 20) {
                z = this.zzc.isInteractive();
            } else {
                z = this.zzc.isScreenOn();
            }
            put2.put("isScreenOn", z).put("appMuted", zzt.zzr().zze()).put("appVolume", (double) zzt.zzr().zza()).put("deviceVolume", (double) zzab.zzb(this.zza.getApplicationContext()));
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzeN)).booleanValue()) {
                AudioManager audioManager = (AudioManager) this.zza.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                if (audioManager == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(audioManager.getMode());
                }
                if (num != null) {
                    jSONObject3.put("audioMode", num);
                }
            }
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzbbp.zzb).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put("top", zzbbp.zzc.top).put("bottom", zzbbp.zzc.bottom).put(TtmlNode.LEFT, zzbbp.zzc.left).put(TtmlNode.RIGHT, zzbbp.zzc.right)).put("adBox", new JSONObject().put("top", zzbbp.zzd.top).put("bottom", zzbbp.zzd.bottom).put(TtmlNode.LEFT, zzbbp.zzd.left).put(TtmlNode.RIGHT, zzbbp.zzd.right)).put("globalVisibleBox", new JSONObject().put("top", zzbbp.zze.top).put("bottom", zzbbp.zze.bottom).put(TtmlNode.LEFT, zzbbp.zze.left).put(TtmlNode.RIGHT, zzbbp.zze.right)).put("globalVisibleBoxVisible", zzbbp.zzf).put("localVisibleBox", new JSONObject().put("top", zzbbp.zzg.top).put("bottom", zzbbp.zzg.bottom).put(TtmlNode.LEFT, zzbbp.zzg.left).put(TtmlNode.RIGHT, zzbbp.zzg.right)).put("localVisibleBoxVisible", zzbbp.zzh).put("hitBox", new JSONObject().put("top", zzbbp.zzi.top).put("bottom", zzbbp.zzi.bottom).put(TtmlNode.LEFT, zzbbp.zzi.left).put(TtmlNode.RIGHT, zzbbp.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzcvj.zza);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzbi)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzbbp.zzk;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put(TtmlNode.LEFT, rect2.left).put(TtmlNode.RIGHT, rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcvj.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
