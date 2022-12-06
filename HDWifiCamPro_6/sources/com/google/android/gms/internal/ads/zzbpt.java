package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbpt {
    public static final zzbpu zza = zzbpa.zza;
    public static final zzbpu zzb = zzbpb.zza;
    public static final zzbpu zzc = zzbot.zza;
    public static final zzbpu zzd = new zzbpl();
    public static final zzbpu zze = new zzbpm();
    public static final zzbpu zzf = zzboz.zza;
    public static final zzbpu zzg = new zzbpn();
    public static final zzbpu zzh = new zzbpo();
    public static final zzbpu zzi = zzboy.zza;
    public static final zzbpu zzj = new zzbpp();
    public static final zzbpu zzk = new zzbpq();
    public static final zzbpu zzl = new zzckp();
    public static final zzbpu zzm = new zzckq();
    public static final zzbpu zzn = new zzbos();
    public static final zzbqj zzo = new zzbqj();
    public static final zzbpu zzp = new zzbpr();
    public static final zzbpu zzq = new zzbps();
    public static final zzbpu zzr = new zzbpc();
    public static final zzbpu zzs = new zzbpd();
    public static final zzbpu zzt = new zzbpe();
    public static final zzbpu zzu = new zzbpf();
    public static final zzbpu zzv = new zzbpg();
    public static final zzbpu zzw = new zzbph();
    public static final zzbpu zzx = new zzbpi();
    public static final zzbpu zzy = new zzbpj();

    public static zzbpu zza(zzdkn zzdkn) {
        return new zzbox(zzdkn);
    }

    public static zzfzp zzb(zzcmp zzcmp, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzape zzK = zzcmp.zzK();
            if (zzK != null && zzK.zzf(parse)) {
                parse = zzK.zza(parse, zzcmp.getContext(), zzcmp.zzH(), zzcmp.zzk());
            }
        } catch (zzapf unused) {
            zze.zzj("Unable to append parameter to URL: ".concat(str));
        }
        String zzb2 = zzcew.zzb(parse, zzcmp.getContext());
        long longValue = ((Long) zzbkr.zze.zze()).longValue();
        if (longValue <= 0 || longValue > 223104600) {
            return zzfzg.zzi(zzb2);
        }
        return zzfzg.zzf(zzfzg.zzm(zzfzg.zzf(zzfyx.zzv(zzcmp.zzT()), Throwable.class, zzbou.zza, zzchc.zzf), new zzbov(zzb2), zzchc.zzf), Throwable.class, new zzbow(zzb2), zzchc.zzf);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void zzc(com.google.android.gms.internal.ads.zzcnq r16, java.util.Map r17) {
        /*
            java.lang.String r1 = "openableIntents"
            android.content.Context r0 = r16.getContext()
            android.content.pm.PackageManager r2 = r0.getPackageManager()
            java.lang.String r0 = "data"
            r3 = r17
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0107 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0107 }
            java.lang.String r0 = "intents"
            org.json.JSONArray r3 = r3.getJSONArray(r0)     // Catch:{ JSONException -> 0x00fa }
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r5 = 0
            r6 = r5
        L_0x0026:
            int r0 = r3.length()
            if (r6 >= r0) goto L_0x00f2
            org.json.JSONObject r0 = r3.getJSONObject(r6)     // Catch:{ JSONException -> 0x00e7 }
            java.lang.String r7 = "id"
            java.lang.String r7 = r0.optString(r7)
            java.lang.String r8 = "u"
            java.lang.String r8 = r0.optString(r8)
            java.lang.String r9 = "i"
            java.lang.String r9 = r0.optString(r9)
            java.lang.String r10 = "m"
            java.lang.String r10 = r0.optString(r10)
            java.lang.String r11 = "p"
            java.lang.String r11 = r0.optString(r11)
            java.lang.String r12 = "c"
            java.lang.String r12 = r0.optString(r12)
            java.lang.String r13 = "intent_url"
            java.lang.String r13 = r0.optString(r13)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            r14 = 0
            if (r0 != 0) goto L_0x0075
            android.content.Intent r0 = android.content.Intent.parseUri(r13, r5)     // Catch:{ URISyntaxException -> 0x0066 }
            goto L_0x0076
        L_0x0066:
            r0 = move-exception
            r15 = r0
            java.lang.String r0 = java.lang.String.valueOf(r13)
            java.lang.String r13 = "Error parsing the url: "
            java.lang.String r0 = r13.concat(r0)
            com.google.android.gms.ads.internal.util.zze.zzh(r0, r15)
        L_0x0075:
            r0 = r14
        L_0x0076:
            r13 = 1
            if (r0 != 0) goto L_0x00c2
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            boolean r15 = android.text.TextUtils.isEmpty(r8)
            if (r15 != 0) goto L_0x008b
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r0.setData(r8)
        L_0x008b:
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 != 0) goto L_0x0094
            r0.setAction(r9)
        L_0x0094:
            boolean r8 = android.text.TextUtils.isEmpty(r10)
            if (r8 != 0) goto L_0x009d
            r0.setType(r10)
        L_0x009d:
            boolean r8 = android.text.TextUtils.isEmpty(r11)
            if (r8 != 0) goto L_0x00a6
            r0.setPackage(r11)
        L_0x00a6:
            boolean r8 = android.text.TextUtils.isEmpty(r12)
            if (r8 != 0) goto L_0x00c2
            r8 = 2
            java.lang.String r9 = "/"
            java.lang.String[] r9 = r12.split(r9, r8)
            int r10 = r9.length
            if (r10 != r8) goto L_0x00c2
            android.content.ComponentName r8 = new android.content.ComponentName
            r10 = r9[r5]
            r9 = r9[r13]
            r8.<init>(r10, r9)
            r0.setComponent(r8)
        L_0x00c2:
            r8 = r0
            r0 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r14 = r2.resolveActivity(r8, r0)     // Catch:{ NullPointerException -> 0x00ca }
            goto L_0x00d7
        L_0x00ca:
            r0 = move-exception
            r9 = r0
            com.google.android.gms.internal.ads.zzcfy r0 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r8 = r8.toString()
            r0.zzt(r9, r8)
        L_0x00d7:
            if (r14 == 0) goto L_0x00da
            goto L_0x00db
        L_0x00da:
            r13 = r5
        L_0x00db:
            r4.put(r7, r13)     // Catch:{ JSONException -> 0x00df }
            goto L_0x00ee
        L_0x00df:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Error constructing openable urls response."
            com.google.android.gms.ads.internal.util.zze.zzh(r0, r7)
            goto L_0x00ee
        L_0x00e7:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Error parsing the intent data."
            com.google.android.gms.ads.internal.util.zze.zzh(r0, r7)
        L_0x00ee:
            int r6 = r6 + 1
            goto L_0x0026
        L_0x00f2:
            r0 = r16
            com.google.android.gms.internal.ads.zzbsn r0 = (com.google.android.gms.internal.ads.zzbsn) r0
            r0.zze(r1, r4)
            return
        L_0x00fa:
            r0 = r16
            com.google.android.gms.internal.ads.zzbsn r0 = (com.google.android.gms.internal.ads.zzbsn) r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0.zze(r1, r2)
            return
        L_0x0107:
            r0 = r16
            com.google.android.gms.internal.ads.zzbsn r0 = (com.google.android.gms.internal.ads.zzbsn) r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0.zze(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpt.zzc(com.google.android.gms.internal.ads.zzcnq, java.util.Map):void");
    }

    public static void zzd(Map map, zzdkn zzdkn) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziv)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("1") && zzdkn != null) {
            zzdkn.zzq();
        }
    }
}
