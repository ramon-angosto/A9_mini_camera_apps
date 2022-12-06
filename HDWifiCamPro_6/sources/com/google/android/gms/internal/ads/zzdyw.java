package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdyw extends zzbqt {
    private final zzdyz zza;
    private final zzdyu zzb;
    private final Map zzc = new HashMap();

    zzdyw(zzdyz zzdyz, zzdyu zzdyu) {
        this.zza = zzdyz;
        this.zzb = zzdyu;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.ads.internal.client.zzl zzc(java.util.Map r30) {
        /*
            com.google.android.gms.ads.internal.client.zzm r0 = new com.google.android.gms.ads.internal.client.zzm
            r0.<init>()
            java.lang.String r1 = "ad_request"
            r2 = r30
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0016
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zza()
            return r0
        L_0x0016:
            java.lang.String r1 = android.net.Uri.decode(r1)
            android.util.JsonReader r2 = new android.util.JsonReader
            java.io.StringReader r3 = new java.io.StringReader
            r3.<init>(r1)
            r2.<init>(r3)
            r2.beginObject()     // Catch:{ IOException -> 0x010e }
        L_0x0027:
            boolean r1 = r2.hasNext()     // Catch:{ IOException -> 0x010e }
            if (r1 == 0) goto L_0x010a
            java.lang.String r1 = r2.nextName()     // Catch:{ IOException -> 0x010e }
            int r3 = r1.hashCode()     // Catch:{ IOException -> 0x010e }
            r4 = 1
            r5 = 0
            switch(r3) {
                case -1289032093: goto L_0x0077;
                case -839117230: goto L_0x006d;
                case -733436947: goto L_0x0063;
                case -99890337: goto L_0x0059;
                case 523149226: goto L_0x004f;
                case 597632527: goto L_0x0045;
                case 1411582723: goto L_0x003b;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0081
        L_0x003b:
            java.lang.String r3 = "tagForChildDirectedTreatment"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 3
            goto L_0x0082
        L_0x0045:
            java.lang.String r3 = "maxAdContentRating"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 5
            goto L_0x0082
        L_0x004f:
            java.lang.String r3 = "keywords"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = r4
            goto L_0x0082
        L_0x0059:
            java.lang.String r3 = "httpTimeoutMillis"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 6
            goto L_0x0082
        L_0x0063:
            java.lang.String r3 = "tagForUnderAgeOfConsent"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 4
            goto L_0x0082
        L_0x006d:
            java.lang.String r3 = "isTestDevice"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = 2
            goto L_0x0082
        L_0x0077:
            java.lang.String r3 = "extras"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0081
            r1 = r5
            goto L_0x0082
        L_0x0081:
            r1 = -1
        L_0x0082:
            switch(r1) {
                case 0: goto L_0x00e8;
                case 1: goto L_0x00ca;
                case 2: goto L_0x00c1;
                case 3: goto L_0x00b1;
                case 4: goto L_0x00a1;
                case 5: goto L_0x0091;
                case 6: goto L_0x0089;
                default: goto L_0x0085;
            }
        L_0x0085:
            r2.skipValue()     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x0089:
            int r1 = r2.nextInt()     // Catch:{ IOException -> 0x010e }
            r0.zzc(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x0091:
            java.lang.String r1 = r2.nextString()     // Catch:{ IOException -> 0x010e }
            java.util.List r3 = com.google.android.gms.ads.RequestConfiguration.zza     // Catch:{ IOException -> 0x010e }
            boolean r3 = r3.contains(r1)     // Catch:{ IOException -> 0x010e }
            if (r3 == 0) goto L_0x0027
            r0.zzf(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00a1:
            boolean r1 = r2.nextBoolean()     // Catch:{ IOException -> 0x010e }
            if (r1 == 0) goto L_0x00ac
            r0.zzh(r4)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00ac:
            r0.zzh(r5)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00b1:
            boolean r1 = r2.nextBoolean()     // Catch:{ IOException -> 0x010e }
            if (r1 == 0) goto L_0x00bc
            r0.zzg(r4)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00bc:
            r0.zzg(r5)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00c1:
            boolean r1 = r2.nextBoolean()     // Catch:{ IOException -> 0x010e }
            r0.zzd(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00ca:
            r2.beginArray()     // Catch:{ IOException -> 0x010e }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ IOException -> 0x010e }
            r1.<init>()     // Catch:{ IOException -> 0x010e }
        L_0x00d2:
            boolean r3 = r2.hasNext()     // Catch:{ IOException -> 0x010e }
            if (r3 == 0) goto L_0x00e0
            java.lang.String r3 = r2.nextString()     // Catch:{ IOException -> 0x010e }
            r1.add(r3)     // Catch:{ IOException -> 0x010e }
            goto L_0x00d2
        L_0x00e0:
            r2.endArray()     // Catch:{ IOException -> 0x010e }
            r0.zze(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x00e8:
            r2.beginObject()     // Catch:{ IOException -> 0x010e }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ IOException -> 0x010e }
            r1.<init>()     // Catch:{ IOException -> 0x010e }
        L_0x00f0:
            boolean r3 = r2.hasNext()     // Catch:{ IOException -> 0x010e }
            if (r3 == 0) goto L_0x0102
            java.lang.String r3 = r2.nextName()     // Catch:{ IOException -> 0x010e }
            java.lang.String r4 = r2.nextString()     // Catch:{ IOException -> 0x010e }
            r1.putString(r3, r4)     // Catch:{ IOException -> 0x010e }
            goto L_0x00f0
        L_0x0102:
            r2.endObject()     // Catch:{ IOException -> 0x010e }
            r0.zzb(r1)     // Catch:{ IOException -> 0x010e }
            goto L_0x0027
        L_0x010a:
            r2.endObject()     // Catch:{ IOException -> 0x010e }
            goto L_0x0113
        L_0x010e:
            java.lang.String r1 = "Ad Request json was malformed, parsing ended early."
            com.google.android.gms.ads.internal.util.zze.zze(r1)
        L_0x0113:
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zza()
            android.os.Bundle r1 = r0.zzm
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            android.os.Bundle r1 = r1.getBundle(r2)
            if (r1 != 0) goto L_0x0128
            android.os.Bundle r1 = r0.zzc
            android.os.Bundle r3 = r0.zzm
            r3.putBundle(r2, r1)
        L_0x0128:
            r8 = r1
            com.google.android.gms.ads.internal.client.zzl r1 = new com.google.android.gms.ads.internal.client.zzl
            r4 = r1
            int r5 = r0.zza
            long r6 = r0.zzb
            int r9 = r0.zzd
            java.util.List r10 = r0.zze
            boolean r11 = r0.zzf
            int r12 = r0.zzg
            boolean r13 = r0.zzh
            java.lang.String r14 = r0.zzi
            com.google.android.gms.ads.internal.client.zzfb r15 = r0.zzj
            android.location.Location r2 = r0.zzk
            r16 = r2
            java.lang.String r2 = r0.zzl
            r17 = r2
            android.os.Bundle r2 = r0.zzm
            r18 = r2
            android.os.Bundle r2 = r0.zzn
            r19 = r2
            java.util.List r2 = r0.zzo
            r20 = r2
            java.lang.String r2 = r0.zzp
            r21 = r2
            java.lang.String r2 = r0.zzq
            r22 = r2
            boolean r2 = r0.zzr
            r23 = r2
            com.google.android.gms.ads.internal.client.zzc r2 = r0.zzs
            r24 = r2
            int r2 = r0.zzt
            r25 = r2
            java.lang.String r2 = r0.zzu
            r26 = r2
            java.util.List r2 = r0.zzv
            r27 = r2
            int r2 = r0.zzw
            r28 = r2
            java.lang.String r0 = r0.zzx
            r29 = r0
            r4.<init>(r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyw.zzc(java.util.Map):com.google.android.gms.ads.internal.client.zzl");
    }

    public final void zze() {
        this.zzc.clear();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        if (r0.equals("create_interstitial_ad") != false) goto L_0x00c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(java.lang.String r12) throws android.os.RemoteException {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzif
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r1 = "Received H5 gmsg: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            android.net.Uri r12 = android.net.Uri.parse(r12)
            com.google.android.gms.ads.internal.zzt.zzp()
            java.util.Map r12 = com.google.android.gms.ads.internal.util.zzs.zzL(r12)
            java.lang.String r0 = "action"
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x003f
            java.lang.String r12 = "H5 gmsg did not contain an action"
            com.google.android.gms.ads.internal.util.zze.zze(r12)
            return
        L_0x003f:
            int r1 = r0.hashCode()
            r2 = 579053441(0x2283a781, float:3.5684973E-18)
            r3 = 0
            r4 = -1
            r5 = 1
            if (r1 == r2) goto L_0x005b
            r2 = 871091088(0x33ebcb90, float:1.0980068E-7)
            if (r1 == r2) goto L_0x0051
            goto L_0x0065
        L_0x0051:
            java.lang.String r1 = "initialize"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0065
            r1 = r3
            goto L_0x0066
        L_0x005b:
            java.lang.String r1 = "dispose_all"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0065
            r1 = r5
            goto L_0x0066
        L_0x0065:
            r1 = r4
        L_0x0066:
            if (r1 == 0) goto L_0x02c1
            if (r1 == r5) goto L_0x02a1
            java.lang.String r1 = "obj_id"
            java.lang.Object r1 = r12.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r1.getClass()     // Catch:{ NullPointerException | NumberFormatException -> 0x0293 }
            long r1 = java.lang.Long.parseLong(r1)     // Catch:{ NullPointerException | NumberFormatException -> 0x0293 }
            int r6 = r0.hashCode()
            switch(r6) {
                case -1790951212: goto L_0x00bc;
                case -1266374734: goto L_0x00b2;
                case -257098725: goto L_0x00a8;
                case 393881811: goto L_0x009f;
                case 585513149: goto L_0x0095;
                case 1671767583: goto L_0x008b;
                case 2109237041: goto L_0x0081;
                default: goto L_0x0080;
            }
        L_0x0080:
            goto L_0x00c6
        L_0x0081:
            java.lang.String r3 = "create_rewarded_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00c6
            r3 = 3
            goto L_0x00c7
        L_0x008b:
            java.lang.String r3 = "dispose"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00c6
            r3 = 6
            goto L_0x00c7
        L_0x0095:
            java.lang.String r3 = "load_interstitial_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00c6
            r3 = r5
            goto L_0x00c7
        L_0x009f:
            java.lang.String r5 = "create_interstitial_ad"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x00c6
            goto L_0x00c7
        L_0x00a8:
            java.lang.String r3 = "load_rewarded_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00c6
            r3 = 4
            goto L_0x00c7
        L_0x00b2:
            java.lang.String r3 = "show_rewarded_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00c6
            r3 = 5
            goto L_0x00c7
        L_0x00bc:
            java.lang.String r3 = "show_interstitial_ad"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00c6
            r3 = 2
            goto L_0x00c7
        L_0x00c6:
            r3 = r4
        L_0x00c7:
            java.lang.String r4 = "Could not create H5 ad, missing ad unit id"
            java.lang.String r5 = " with ad unit "
            java.lang.String r6 = "Could not create H5 ad, object ID already exists"
            java.lang.String r7 = "ad_unit"
            java.lang.String r8 = "Could not show H5 ad, object ID does not exist"
            java.lang.String r9 = "Could not load H5 ad, object ID does not exist"
            java.lang.String r10 = "Could not create H5 ad, too many existing objects"
            switch(r3) {
                case 0: goto L_0x020f;
                case 1: goto L_0x01f0;
                case 2: goto L_0x01d5;
                case 3: goto L_0x0151;
                case 4: goto L_0x0132;
                case 5: goto L_0x0117;
                case 6: goto L_0x00e6;
                default: goto L_0x00d8;
            }
        L_0x00d8:
            java.lang.String r12 = java.lang.String.valueOf(r0)
            java.lang.String r0 = "H5 gmsg contained invalid action: "
            java.lang.String r12 = r0.concat(r12)
            com.google.android.gms.ads.internal.util.zze.zze(r12)
            return
        L_0x00e6:
            java.util.Map r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdyp r12 = (com.google.android.gms.internal.ads.zzdyp) r12
            if (r12 != 0) goto L_0x00fa
            java.lang.String r12 = "Could not dispose H5 ad, object ID does not exist"
            com.google.android.gms.ads.internal.util.zze.zze(r12)
            return
        L_0x00fa:
            r12.zza()
            java.util.Map r12 = r11.zzc
            r12.remove(r0)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Disposed H5 ad #"
            r12.append(r0)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x0117:
            java.util.Map r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdyp r12 = (com.google.android.gms.internal.ads.zzdyp) r12
            if (r12 != 0) goto L_0x012e
            com.google.android.gms.ads.internal.util.zze.zze(r8)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzq(r1)
            return
        L_0x012e:
            r12.zzc()
            return
        L_0x0132:
            java.util.Map r0 = r11.zzc
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.ads.zzdyp r0 = (com.google.android.gms.internal.ads.zzdyp) r0
            if (r0 != 0) goto L_0x0149
            com.google.android.gms.ads.internal.util.zze.zze(r9)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzq(r1)
            return
        L_0x0149:
            com.google.android.gms.ads.internal.client.zzl r12 = zzc(r12)
            r0.zzb(r12)
            return
        L_0x0151:
            java.util.Map r0 = r11.zzc
            int r0 = r0.size()
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzig
            com.google.android.gms.internal.ads.zzbja r8 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r3 = r8.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r0 < r3) goto L_0x0172
            com.google.android.gms.ads.internal.util.zze.zzj(r10)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzi(r1)
            return
        L_0x0172:
            java.util.Map r0 = r11.zzc
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x0187
            com.google.android.gms.ads.internal.util.zze.zze(r6)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzi(r1)
            return
        L_0x0187:
            java.lang.Object r12 = r12.get(r7)
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x019c
            com.google.android.gms.ads.internal.util.zze.zzj(r4)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzi(r1)
            return
        L_0x019c:
            com.google.android.gms.internal.ads.zzdyz r0 = r11.zza
            com.google.android.gms.internal.ads.zzdyq r0 = r0.zzb()
            r0.zzb(r1)
            r0.zza(r12)
            com.google.android.gms.internal.ads.zzdyr r0 = r0.zzc()
            com.google.android.gms.internal.ads.zzdzf r0 = r0.zzb()
            java.util.Map r4 = r11.zzc
            r4.put(r3, r0)
            com.google.android.gms.internal.ads.zzdyu r0 = r11.zzb
            r0.zzh(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Created H5 rewarded #"
            r0.append(r3)
            r0.append(r1)
            r0.append(r5)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x01d5:
            java.util.Map r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdyp r12 = (com.google.android.gms.internal.ads.zzdyp) r12
            if (r12 != 0) goto L_0x01ec
            com.google.android.gms.ads.internal.util.zze.zze(r8)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzf(r1)
            return
        L_0x01ec:
            r12.zzc()
            return
        L_0x01f0:
            java.util.Map r0 = r11.zzc
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.ads.zzdyp r0 = (com.google.android.gms.internal.ads.zzdyp) r0
            if (r0 != 0) goto L_0x0207
            com.google.android.gms.ads.internal.util.zze.zze(r9)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzf(r1)
            return
        L_0x0207:
            com.google.android.gms.ads.internal.client.zzl r12 = zzc(r12)
            r0.zzb(r12)
            return
        L_0x020f:
            java.util.Map r0 = r11.zzc
            int r0 = r0.size()
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzig
            com.google.android.gms.internal.ads.zzbja r8 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r3 = r8.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r0 < r3) goto L_0x0230
            com.google.android.gms.ads.internal.util.zze.zzj(r10)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzi(r1)
            return
        L_0x0230:
            java.util.Map r0 = r11.zzc
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x0245
            com.google.android.gms.ads.internal.util.zze.zze(r6)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzi(r1)
            return
        L_0x0245:
            java.lang.Object r12 = r12.get(r7)
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x025a
            com.google.android.gms.ads.internal.util.zze.zzj(r4)
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zzi(r1)
            return
        L_0x025a:
            com.google.android.gms.internal.ads.zzdyz r0 = r11.zza
            com.google.android.gms.internal.ads.zzdyq r0 = r0.zzb()
            r0.zzb(r1)
            r0.zza(r12)
            com.google.android.gms.internal.ads.zzdyr r0 = r0.zzc()
            com.google.android.gms.internal.ads.zzdzb r0 = r0.zza()
            java.util.Map r4 = r11.zzc
            r4.put(r3, r0)
            com.google.android.gms.internal.ads.zzdyu r0 = r11.zzb
            r0.zzh(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Created H5 interstitial #"
            r0.append(r3)
            r0.append(r1)
            r0.append(r5)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x0293:
            java.lang.String r12 = java.lang.String.valueOf(r1)
            java.lang.String r0 = "H5 gmsg did not contain a valid object id: "
            java.lang.String r12 = r0.concat(r12)
            com.google.android.gms.ads.internal.util.zze.zze(r12)
            return
        L_0x02a1:
            java.util.Map r12 = r11.zzc
            java.util.Collection r12 = r12.values()
            java.util.Iterator r12 = r12.iterator()
        L_0x02ab:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x02bb
            java.lang.Object r0 = r12.next()
            com.google.android.gms.internal.ads.zzdyp r0 = (com.google.android.gms.internal.ads.zzdyp) r0
            r0.zza()
            goto L_0x02ab
        L_0x02bb:
            java.util.Map r12 = r11.zzc
            r12.clear()
            return
        L_0x02c1:
            java.util.Map r12 = r11.zzc
            r12.clear()
            com.google.android.gms.internal.ads.zzdyu r12 = r11.zzb
            r12.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyw.zzf(java.lang.String):void");
    }
}
