package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzef;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdrq {
    private final Context zza;
    private final zzdqz zzb;
    private final zzape zzc;
    private final zzcgv zzd;
    private final zza zze;
    private final zzbep zzf;
    private final Executor zzg;
    private final zzbls zzh;
    private final zzdsi zzi;
    private final zzduy zzj;
    private final ScheduledExecutorService zzk;
    private final zzdtt zzl;
    private final zzdxq zzm;
    private final zzfir zzn;
    private final zzfkm zzo;
    private final zzego zzp;

    public zzdrq(Context context, zzdqz zzdqz, zzape zzape, zzcgv zzcgv, zza zza2, zzbep zzbep, Executor executor, zzfef zzfef, zzdsi zzdsi, zzduy zzduy, ScheduledExecutorService scheduledExecutorService, zzdxq zzdxq, zzfir zzfir, zzfkm zzfkm, zzego zzego, zzdtt zzdtt) {
        this.zza = context;
        this.zzb = zzdqz;
        this.zzc = zzape;
        this.zzd = zzcgv;
        this.zze = zza2;
        this.zzf = zzbep;
        this.zzg = executor;
        this.zzh = zzfef.zzi;
        this.zzi = zzdsi;
        this.zzj = zzduy;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdxq;
        this.zzn = zzfir;
        this.zzo = zzfkm;
        this.zzp = zzego;
        this.zzl = zzdtt;
    }

    public static final zzef zzi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(optJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzfvn.zzo();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfvn.zzo();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzef zzr = zzr(optJSONArray.optJSONObject(i));
            if (zzr != null) {
                arrayList.add(zzr);
            }
        }
        return zzfvn.zzm(arrayList);
    }

    private static zzfzp zzl(zzfzp zzfzp, Object obj) {
        return zzfzg.zzg(zzfzp, Exception.class, new zzdrn((Object) null), zzchc.zzf);
    }

    private static zzfzp zzm(boolean z, zzfzp zzfzp, Object obj) {
        if (z) {
            return zzfzg.zzn(zzfzp, new zzdrl(zzfzp), zzchc.zzf);
        }
        return zzl(zzfzp, (Object) null);
    }

    private final zzfzp zzn(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzfzg.zzi((Object) null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzfzg.zzi((Object) null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzfzg.zzi(new zzblq((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzfzg.zzm(this.zzb.zzb(optString, optDouble, optBoolean), new zzdro(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    private final zzfzp zzo(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzfzg.zzi(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i), z));
        }
        return zzfzg.zzm(zzfzg.zze(arrayList), zzdrm.zza, this.zzg);
    }

    private final zzfzp zzp(JSONObject jSONObject, zzfdk zzfdk, zzfdn zzfdn) {
        zzfzp zzb2 = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfdk, zzfdn, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzfzg.zzn(zzb2, new zzdrp(zzb2), zzchc.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt(CampaignEx.JSON_KEY_AD_R), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final zzef zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(IronSourceConstants.EVENTS_ERROR_REASON);
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzef(optString, optString2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbln zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString(MimeTypes.BASE_TYPE_TEXT);
        Integer zzq = zzq(jSONObject, "bg_color");
        Integer zzq2 = zzq(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", PAGSdk.INIT_LOCAL_FAIL_CODE);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzbln(optString, list, zzq, zzq2, num, optInt3 + optInt2, this.zzh.zze, optBoolean);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzb(zzq zzq, zzfdk zzfdk, zzfdn zzfdn, String str, String str2, Object obj) throws Exception {
        zzcmp zza2 = this.zzj.zza(zzq, zzfdk, zzfdn);
        zzchg zza3 = zzchg.zza(zza2);
        zzdtq zzb2 = this.zzl.zzb();
        zzdtq zzdtq = zzb2;
        zzdtq zzdtq2 = zzb2;
        zzdtq zzdtq3 = zzb2;
        zzdtq zzdtq4 = zzb2;
        zzdtq zzdtq5 = zzb2;
        zzdtq zzdtq6 = zzb2;
        zzcoc zzP = zza2.zzP();
        zzb zzb3 = r3;
        zzb zzb4 = new zzb(this.zza, (zzcdq) null, (zzcaq) null);
        zzP.zzL(zzdtq, zzdtq5, zzdtq2, zzdtq4, zzdtq6, false, (zzbpx) null, zzb3, (zzbyg) null, (zzcdq) null, this.zzp, this.zzo, this.zzm, this.zzn, (zzbpv) null, zzdtq3, (zzbqm) null, (zzbqg) null);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcT)).booleanValue()) {
            zza2.zzaf("/getNativeAdViewSignals", zzbpt.zzs);
        }
        zza2.zzaf("/getNativeClickMeta", zzbpt.zzt);
        zza2.zzP().zzz(new zzdrk(zza3));
        zza2.zzad(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(String str, Object obj) throws Exception {
        zzt.zzz();
        zzcmp zza2 = zzcnb.zza(this.zza, zzcoe.zza(), "native-omid", false, false, this.zzc, (zzbkb) null, this.zzd, (zzbjr) null, (zzl) null, this.zze, this.zzf, (zzfdk) null, (zzfdn) null);
        zzchg zza3 = zzchg.zza(zza2);
        zza2.zzP().zzz(new zzdrg(zza3));
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzej)).booleanValue()) {
            zza2.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        } else {
            zza2.loadData(str, "text/html", "UTF-8");
        }
        return zza3;
    }

    public final zzfzp zzd(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzfzg.zzi((Object) null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzm(optJSONObject.optBoolean("require"), zzfzg.zzm(zzo(optJSONArray, false, true), new zzdrh(this, optJSONObject), this.zzg), (Object) null);
    }

    public final zzfzp zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final zzfzp zzf(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        zzbls zzbls = this.zzh;
        return zzo(optJSONArray, zzbls.zzb, zzbls.zzd);
    }

    public final zzfzp zzg(JSONObject jSONObject, String str, zzfdk zzfdk, zzfdn zzfdn) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzik)).booleanValue()) {
            return zzfzg.zzi((Object) null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfzg.zzi((Object) null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzfzg.zzi((Object) null);
        }
        String optString = optJSONObject.optString("base_url");
        String optString2 = optJSONObject.optString("html");
        zzq zzk2 = zzk(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzfzg.zzi((Object) null);
        }
        zzfzp zzn2 = zzfzg.zzn(zzfzg.zzi((Object) null), new zzdri(this, zzk2, zzfdk, zzfdn, optString, optString2), zzchc.zze);
        return zzfzg.zzn(zzn2, new zzdrj(zzn2), zzchc.zzf);
    }

    public final zzfzp zzh(JSONObject jSONObject, zzfdk zzfdk, zzfdn zzfdn) {
        zzfzp zzfzp;
        JSONObject zzg2 = zzbu.zzg(jSONObject, "html_containers", "instream");
        if (zzg2 != null) {
            return zzp(zzg2, zzfdk, zzfdn);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzfzg.zzi((Object) null);
        }
        String optString = optJSONObject.optString("vast_xml");
        boolean z = false;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzij)).booleanValue() && optJSONObject.has("html")) {
            z = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z) {
                zze.zzj("Required field 'vast_xml' or 'html' is missing");
                return zzfzg.zzi((Object) null);
            }
        } else if (!z) {
            zzfzp = this.zzi.zza(optJSONObject);
            return zzl(zzfzg.zzo(zzfzp, (long) ((Integer) zzay.zzc().zzb(zzbjc.zzcU)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
        }
        zzfzp = zzp(optJSONObject, zzfdk, zzfdn);
        return zzl(zzfzg.zzo(zzfzp, (long) ((Integer) zzay.zzc().zzb(zzbjc.zzcU)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
    }

    private final zzq zzk(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return zzq.zzc();
            }
            i = 0;
        }
        return new zzq(this.zza, new AdSize(i, i2));
    }
}
