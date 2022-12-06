package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzclc implements zzbpu {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zze.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: com.google.android.gms.internal.ads.zzckt} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zza(java.lang.Object r17, java.util.Map r18) {
        /*
            r16 = this;
            r0 = r18
            r1 = r17
            com.google.android.gms.internal.ads.zzciy r1 = (com.google.android.gms.internal.ads.zzciy) r1
            r2 = 3
            boolean r2 = com.google.android.gms.ads.internal.util.zze.zzm(r2)
            if (r2 == 0) goto L_0x0024
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r0)
            java.lang.String r3 = "google.afma.Notify_dt"
            r2.remove(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Precache GMSG: "
            java.lang.String r2 = r3.concat(r2)
            com.google.android.gms.ads.internal.util.zze.zze(r2)
        L_0x0024:
            com.google.android.gms.internal.ads.zzcku r2 = com.google.android.gms.ads.internal.zzt.zzy()
            java.lang.String r3 = "abort"
            boolean r3 = r0.containsKey(r3)
            if (r3 == 0) goto L_0x003c
            boolean r0 = r2.zzd(r1)
            if (r0 != 0) goto L_0x0183
            java.lang.String r0 = "Precache abort but no precache task running."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        L_0x003c:
            java.lang.String r3 = "src"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "periodicReportIntervalMs"
            java.lang.Integer r4 = zzb(r0, r4)
            java.lang.String r5 = "exoPlayerRenderingIntervalMs"
            java.lang.Integer r5 = zzb(r0, r5)
            java.lang.String r6 = "exoPlayerIdleIntervalMs"
            java.lang.Integer r6 = zzb(r0, r6)
            com.google.android.gms.internal.ads.zzcix r7 = new com.google.android.gms.internal.ads.zzcix
            java.lang.String r8 = "flags"
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r7.<init>(r8)
            boolean r8 = r7.zzn
            if (r3 == 0) goto L_0x013f
            r9 = 1
            java.lang.String[] r10 = new java.lang.String[r9]
            r11 = 0
            r10[r11] = r3
            java.lang.String r12 = "demuxed"
            java.lang.Object r12 = r0.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x009d
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0092 }
            r10.<init>(r12)     // Catch:{ JSONException -> 0x0092 }
            int r14 = r10.length()     // Catch:{ JSONException -> 0x0092 }
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ JSONException -> 0x0092 }
            r15 = r11
        L_0x0083:
            int r13 = r10.length()     // Catch:{ JSONException -> 0x0092 }
            if (r15 >= r13) goto L_0x009e
            java.lang.String r13 = r10.getString(r15)     // Catch:{ JSONException -> 0x0092 }
            r14[r15] = r13     // Catch:{ JSONException -> 0x0092 }
            int r15 = r15 + 1
            goto L_0x0083
        L_0x0092:
            java.lang.String r10 = "Malformed demuxed URL list for precache: "
            java.lang.String r10 = r10.concat(r12)
            com.google.android.gms.ads.internal.util.zze.zzj(r10)
            r14 = 0
            goto L_0x009e
        L_0x009d:
            r14 = r10
        L_0x009e:
            if (r14 != 0) goto L_0x00a4
            java.lang.String[] r14 = new java.lang.String[r9]
            r14[r11] = r3
        L_0x00a4:
            if (r8 == 0) goto L_0x00c8
            java.util.Iterator r2 = r2.iterator()
        L_0x00aa:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x00c6
            java.lang.Object r8 = r2.next()
            r13 = r8
            com.google.android.gms.internal.ads.zzckt r13 = (com.google.android.gms.internal.ads.zzckt) r13
            com.google.android.gms.internal.ads.zzciy r8 = r13.zza
            if (r8 != r1) goto L_0x00aa
            java.lang.String r8 = r13.zze()
            boolean r8 = r3.equals(r8)
            if (r8 == 0) goto L_0x00aa
            goto L_0x00cc
        L_0x00c6:
            r13 = 0
            goto L_0x00cc
        L_0x00c8:
            com.google.android.gms.internal.ads.zzckt r13 = r2.zza(r1)
        L_0x00cc:
            if (r13 == 0) goto L_0x00d4
            java.lang.String r0 = "Precache task is already running."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        L_0x00d4:
            com.google.android.gms.ads.internal.zza r2 = r1.zzm()
            if (r2 != 0) goto L_0x00e0
            java.lang.String r0 = "Precache requires a dependency provider."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        L_0x00e0:
            java.lang.String r2 = "player"
            java.lang.Integer r2 = zzb(r0, r2)
            if (r2 != 0) goto L_0x00ec
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
        L_0x00ec:
            if (r4 == 0) goto L_0x00f5
            int r4 = r4.intValue()
            r1.zzC(r4)
        L_0x00f5:
            if (r5 == 0) goto L_0x00fe
            int r4 = r5.intValue()
            r1.zzA(r4)
        L_0x00fe:
            if (r6 == 0) goto L_0x0107
            int r4 = r6.intValue()
            r1.zzz(r4)
        L_0x0107:
            int r2 = r2.intValue()
            com.google.android.gms.ads.internal.zza r4 = r1.zzm()
            com.google.android.gms.internal.ads.zzckn r4 = r4.zzb
            if (r2 <= 0) goto L_0x0131
            int r2 = com.google.android.gms.internal.ads.zzcip.zzu()
            int r4 = r7.zzh
            if (r2 >= r4) goto L_0x0121
            com.google.android.gms.internal.ads.zzclk r2 = new com.google.android.gms.internal.ads.zzclk
            r2.<init>(r1, r7)
            goto L_0x0136
        L_0x0121:
            int r4 = r7.zzb
            if (r2 >= r4) goto L_0x012b
            com.google.android.gms.internal.ads.zzclh r2 = new com.google.android.gms.internal.ads.zzclh
            r2.<init>(r1, r7)
            goto L_0x0136
        L_0x012b:
            com.google.android.gms.internal.ads.zzclf r2 = new com.google.android.gms.internal.ads.zzclf
            r2.<init>(r1)
            goto L_0x0136
        L_0x0131:
            com.google.android.gms.internal.ads.zzcle r2 = new com.google.android.gms.internal.ads.zzcle
            r2.<init>(r1)
        L_0x0136:
            com.google.android.gms.internal.ads.zzckt r4 = new com.google.android.gms.internal.ads.zzckt
            r4.<init>(r1, r2, r3, r14)
            r4.zzb()
            goto L_0x0147
        L_0x013f:
            com.google.android.gms.internal.ads.zzckt r1 = r2.zza(r1)
            if (r1 == 0) goto L_0x0184
            com.google.android.gms.internal.ads.zzclb r2 = r1.zzb
        L_0x0147:
            java.lang.String r1 = "minBufferMs"
            java.lang.Integer r1 = zzb(r0, r1)
            if (r1 == 0) goto L_0x0156
            int r1 = r1.intValue()
            r2.zzp(r1)
        L_0x0156:
            java.lang.String r1 = "maxBufferMs"
            java.lang.Integer r1 = zzb(r0, r1)
            if (r1 == 0) goto L_0x0165
            int r1 = r1.intValue()
            r2.zzo(r1)
        L_0x0165:
            java.lang.String r1 = "bufferForPlaybackMs"
            java.lang.Integer r1 = zzb(r0, r1)
            if (r1 == 0) goto L_0x0174
            int r1 = r1.intValue()
            r2.zzh(r1)
        L_0x0174:
            java.lang.String r1 = "bufferForPlaybackAfterRebufferMs"
            java.lang.Integer r0 = zzb(r0, r1)
            if (r0 == 0) goto L_0x0183
            int r0 = r0.intValue()
            r2.zzn(r0)
        L_0x0183:
            return
        L_0x0184:
            java.lang.String r0 = "Precache must specify a source."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclc.zza(java.lang.Object, java.util.Map):void");
    }
}
