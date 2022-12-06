package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbqf implements zzbpu {
    private final zzb zza;
    private final zzdxq zzb;
    private final zzfir zzc;
    private final zzcgu zzd;
    private final zzbxz zze;
    private final zzego zzf;
    private zzx zzg = null;

    public zzbqf(zzb zzb2, zzbxz zzbxz, zzego zzego, zzdxq zzdxq, zzfir zzfir) {
        this.zza = zzb2;
        this.zze = zzbxz;
        this.zzf = zzego;
        this.zzb = zzdxq;
        this.zzc = zzfir;
        this.zzd = new zzcgu((String) null);
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if (TtmlNode.TAG_P.equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzc(Context context, zzape zzape, Uri uri, View view, Activity activity) {
        if (zzape == null) {
            return uri;
        }
        try {
            if (zzape.zze(uri)) {
                return zzape.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzapf unused) {
            return uri;
        } catch (Exception e) {
            zzt.zzo().zzt(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            zze.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: android.net.Uri} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r11v18 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00df, code lost:
        if (r3 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzh(com.google.android.gms.ads.internal.client.zza r18, java.util.Map r19, boolean r20, java.lang.String r21, boolean r22) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = 1
            r1.zzi(r3)
            r4 = r0
            com.google.android.gms.internal.ads.zzcmp r4 = (com.google.android.gms.internal.ads.zzcmp) r4
            android.content.Context r5 = r4.getContext()
            com.google.android.gms.internal.ads.zzape r6 = r4.zzK()
            android.view.View r7 = r4.zzH()
            java.lang.String r8 = "activity"
            java.lang.Object r8 = r5.getSystemService(r8)
            android.app.ActivityManager r8 = (android.app.ActivityManager) r8
            java.lang.String r9 = "u"
            java.lang.Object r9 = r2.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            r11 = 0
            if (r10 == 0) goto L_0x0032
            goto L_0x0133
        L_0x0032:
            android.net.Uri r9 = android.net.Uri.parse(r9)
            android.net.Uri r9 = zzc(r5, r6, r9, r7, r11)
            android.net.Uri r9 = zzd(r9)
            java.lang.String r10 = "use_first_package"
            java.lang.Object r10 = r2.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            boolean r10 = java.lang.Boolean.parseBoolean(r10)
            java.lang.String r12 = "use_running_process"
            java.lang.Object r12 = r2.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            java.lang.String r13 = "use_custom_tabs"
            java.lang.Object r2 = r2.get(r13)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            if (r2 != 0) goto L_0x0078
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzdF
            com.google.android.gms.internal.ads.zzbja r14 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r14.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r3 = 0
        L_0x0078:
            java.lang.String r2 = r9.getScheme()
            java.lang.String r14 = "http"
            boolean r2 = r14.equalsIgnoreCase(r2)
            java.lang.String r15 = "https"
            if (r2 == 0) goto L_0x0093
            android.net.Uri$Builder r2 = r9.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r15)
            android.net.Uri r11 = r2.build()
            goto L_0x00a9
        L_0x0093:
            java.lang.String r2 = r9.getScheme()
            boolean r2 = r15.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a9
            android.net.Uri$Builder r2 = r9.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r14)
            android.net.Uri r11 = r2.build()
        L_0x00a9:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.Intent r9 = com.google.android.gms.internal.ads.zzbqe.zza(r9, r5, r6, r7)
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqe.zza(r11, r5, r6, r7)
            if (r3 == 0) goto L_0x00c4
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.util.zzs.zzm(r5, r9)
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.util.zzs.zzm(r5, r11)
        L_0x00c4:
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbqe.zzd(r9, r2, r5, r6, r7)
            if (r3 == 0) goto L_0x00cf
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqe.zzb(r9, r3, r5, r6, r7)
            goto L_0x0133
        L_0x00cf:
            if (r11 == 0) goto L_0x00e1
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbqe.zzc(r11, r5, r6, r7)
            if (r3 == 0) goto L_0x00e1
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqe.zzb(r9, r3, r5, r6, r7)
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbqe.zzc(r11, r5, r6, r7)
            if (r3 != 0) goto L_0x0133
        L_0x00e1:
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x00e8
            goto L_0x0132
        L_0x00e8:
            if (r12 == 0) goto L_0x0124
            if (r8 == 0) goto L_0x0124
            java.util.List r3 = r8.getRunningAppProcesses()
            if (r3 == 0) goto L_0x0124
            int r8 = r2.size()
            r11 = 0
        L_0x00f7:
            if (r11 >= r8) goto L_0x0124
            java.lang.Object r12 = r2.get(r11)
            android.content.pm.ResolveInfo r12 = (android.content.pm.ResolveInfo) r12
            java.util.Iterator r14 = r3.iterator()
        L_0x0103:
            int r15 = r11 + 1
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x0122
            java.lang.Object r15 = r14.next()
            android.app.ActivityManager$RunningAppProcessInfo r15 = (android.app.ActivityManager.RunningAppProcessInfo) r15
            java.lang.String r15 = r15.processName
            android.content.pm.ActivityInfo r13 = r12.activityInfo
            java.lang.String r13 = r13.packageName
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0103
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqe.zzb(r9, r12, r5, r6, r7)
            goto L_0x0133
        L_0x0122:
            r11 = r15
            goto L_0x00f7
        L_0x0124:
            if (r10 == 0) goto L_0x0132
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbqe.zzb(r9, r2, r5, r6, r7)
            goto L_0x0133
        L_0x0132:
            r11 = r9
        L_0x0133:
            if (r20 == 0) goto L_0x0151
            com.google.android.gms.internal.ads.zzego r2 = r1.zzf
            if (r2 == 0) goto L_0x0151
            if (r11 == 0) goto L_0x0151
            android.content.Context r2 = r4.getContext()
            android.net.Uri r3 = r11.getData()
            java.lang.String r3 = r3.toString()
            r4 = r21
            boolean r2 = r1.zzj(r0, r2, r3, r4)
            if (r2 != 0) goto L_0x0150
            goto L_0x0151
        L_0x0150:
            return
        L_0x0151:
            com.google.android.gms.internal.ads.zzcnu r0 = (com.google.android.gms.internal.ads.zzcnu) r0     // Catch:{ ActivityNotFoundException -> 0x0160 }
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x0160 }
            com.google.android.gms.ads.internal.overlay.zzx r3 = r1.zzg     // Catch:{ ActivityNotFoundException -> 0x0160 }
            r2.<init>(r11, r3)     // Catch:{ ActivityNotFoundException -> 0x0160 }
            r3 = r22
            r0.zzaF(r2, r3)     // Catch:{ ActivityNotFoundException -> 0x0160 }
            return
        L_0x0160:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqf.zzh(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean):void");
    }

    private final void zzi(boolean z) {
        zzbxz zzbxz = this.zze;
        if (zzbxz != null) {
            zzbxz.zza(z);
        }
    }

    private final boolean zzj(zza zza2, Context context, String str, String str2) {
        String str3 = str2;
        Context context2 = context;
        boolean zzv = zzt.zzo().zzv(context);
        zzt.zzp();
        zzbr zzw = zzs.zzw(context);
        zzdxq zzdxq = this.zzb;
        if (zzdxq != null) {
            zzegw.zzc(context, zzdxq, this.zzc, this.zzf, str2, "offline_open");
        }
        zzcmp zzcmp = (zzcmp) zza2;
        boolean z = zzcmp.zzQ().zzi() && zzcmp.zzk() == null;
        if (zzv) {
            this.zzf.zzh(this.zzd, str3);
            return false;
        }
        zzt.zzp();
        if (NotificationManagerCompat.from(context).areNotificationsEnabled() && zzw != null && !z) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhk)).booleanValue()) {
                if (zzcmp.zzQ().zzi()) {
                    zzegw.zzh(zzcmp.zzk(), (zzl) null, zzw, this.zzf, this.zzb, this.zzc, str2, str);
                } else {
                    ((zzcnu) zza2).zzaG(zzw, this.zzf, this.zzb, this.zzc, str2, str, 14);
                }
                zzdxq zzdxq2 = this.zzb;
                if (zzdxq2 != null) {
                    zzegw.zzc(context, zzdxq2, this.zzc, this.zzf, str2, "dialog_impression");
                }
                zza2.onAdClicked();
                return true;
            }
        }
        this.zzf.zzc(str3);
        if (this.zzb != null) {
            HashMap hashMap = new HashMap();
            zzt.zzp();
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzw == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                if (!((Boolean) zzay.zzc().zzb(zzbjc.zzhk)).booleanValue()) {
                    hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
                } else if (z) {
                    hashMap.put("dialog_not_shown_reason", "fullscreen_no_activity");
                }
            }
            zzegw.zzd(context, this.zzb, this.zzc, this.zzf, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void zzk(int i) {
        if (this.zzb != null) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhs)).booleanValue()) {
                zzfir zzfir = this.zzc;
                zzfiq zzb2 = zzfiq.zzb("cct_action");
                zzb2.zza("cct_open_status", zzbjz.zza(i));
                zzfir.zzb(zzb2);
                return;
            }
            zzdxp zza2 = this.zzb.zza();
            zza2.zzb("action", "cct_action");
            zza2.zzb("cct_open_status", zzbjz.zza(i));
            zza2.zzg();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x039f  */
    /* renamed from: zze */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.ads.internal.client.zza r33, java.util.Map r34) {
        /*
            r32 = this;
            r7 = r32
            r8 = r33
            r9 = r34
            java.lang.String r0 = "u"
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r10 = r8
            com.google.android.gms.internal.ads.zzcmp r10 = (com.google.android.gms.internal.ads.zzcmp) r10
            android.content.Context r1 = r10.getContext()
            r2 = 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r2)
            java.lang.String r12 = com.google.android.gms.internal.ads.zzcew.zzc(r0, r1, r2)
            java.lang.String r0 = "a"
            java.lang.Object r0 = r9.get(r0)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x002f
            java.lang.String r0 = "Action missing from an open GMSG."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        L_0x002f:
            com.google.android.gms.ads.internal.zzb r0 = r7.zza
            if (r0 == 0) goto L_0x0040
            boolean r0 = r0.zzc()
            if (r0 == 0) goto L_0x003a
            goto L_0x0040
        L_0x003a:
            com.google.android.gms.ads.internal.zzb r0 = r7.zza
            r0.zzb(r12)
            return
        L_0x0040:
            com.google.android.gms.internal.ads.zzfdk r0 = r10.zzF()
            com.google.android.gms.internal.ads.zzfdn r3 = r10.zzR()
            r13 = 0
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0056
            if (r3 == 0) goto L_0x0056
            boolean r0 = r0.zzak
            java.lang.String r3 = r3.zzb
            r14 = r0
            r15 = r3
            goto L_0x0058
        L_0x0056:
            r15 = r4
            r14 = r13
        L_0x0058:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zziu
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0082
            java.lang.String r0 = "sc"
            boolean r3 = r9.containsKey(r0)
            if (r3 == 0) goto L_0x0082
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = "0"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0082
            r6 = r13
            goto L_0x0083
        L_0x0082:
            r6 = r2
        L_0x0083:
            java.lang.String r0 = "expand"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x00a9
            boolean r0 = r10.zzaC()
            if (r0 == 0) goto L_0x0097
            java.lang.String r0 = "Cannot expand WebView that is already expanded."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        L_0x0097:
            r7.zzi(r13)
            r0 = r8
            com.google.android.gms.internal.ads.zzcnu r0 = (com.google.android.gms.internal.ads.zzcnu) r0
            boolean r1 = zzf(r34)
            int r2 = zzb(r34)
            r0.zzaH(r1, r2, r6)
            return
        L_0x00a9:
            java.lang.String r0 = "webapp"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x00eb
            r7.zzi(r13)
            if (r12 == 0) goto L_0x00c5
            r0 = r8
            com.google.android.gms.internal.ads.zzcnu r0 = (com.google.android.gms.internal.ads.zzcnu) r0
            boolean r1 = zzf(r34)
            int r2 = zzb(r34)
            r0.zzaI(r1, r2, r12, r6)
            return
        L_0x00c5:
            r16 = r8
            com.google.android.gms.internal.ads.zzcnu r16 = (com.google.android.gms.internal.ads.zzcnu) r16
            boolean r17 = zzf(r34)
            int r18 = zzb(r34)
            java.lang.String r0 = "html"
            java.lang.Object r0 = r9.get(r0)
            r19 = r0
            java.lang.String r19 = (java.lang.String) r19
            java.lang.String r0 = "baseurl"
            java.lang.Object r0 = r9.get(r0)
            r20 = r0
            java.lang.String r20 = (java.lang.String) r20
            r21 = r6
            r16.zzaJ(r17, r18, r19, r20, r21)
            return
        L_0x00eb:
            java.lang.String r0 = "chrome_custom_tab"
            boolean r0 = r0.equalsIgnoreCase(r1)
            java.lang.String r3 = "true"
            if (r0 == 0) goto L_0x020d
            android.content.Context r0 = r10.getContext()
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzdH
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r4.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x010c
            goto L_0x0176
        L_0x010c:
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzdN
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r4.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0124
            java.lang.String r0 = "User opt out chrome custom tab."
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            goto L_0x0176
        L_0x0124:
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzdL
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r4.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0138
        L_0x0136:
            r13 = r2
            goto L_0x0176
        L_0x0138:
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzdM
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r4.zzb(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = r1.isEmpty()
            if (r4 != 0) goto L_0x0176
            if (r0 != 0) goto L_0x014d
            goto L_0x0176
        L_0x014d:
            java.lang.String r0 = r0.getPackageName()
            r4 = 59
            com.google.android.gms.internal.ads.zzfsj r4 = com.google.android.gms.internal.ads.zzfsj.zzc(r4)
            com.google.android.gms.internal.ads.zzftk r4 = com.google.android.gms.internal.ads.zzftk.zzc(r4)
            java.lang.Iterable r1 = r4.zzd(r1)
            java.util.Iterator r1 = r1.iterator()
        L_0x0163:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0176
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0163
            goto L_0x0136
        L_0x0176:
            android.content.Context r0 = r10.getContext()
            boolean r0 = com.google.android.gms.internal.ads.zzbka.zzg(r0)
            if (r13 == 0) goto L_0x01f7
            if (r0 != 0) goto L_0x0187
            r0 = 4
            r7.zzk(r0)
            goto L_0x01f7
        L_0x0187:
            r7.zzi(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x019a
            java.lang.String r0 = "Cannot open browser with null or empty url"
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            r0 = 7
            r7.zzk(r0)
            return
        L_0x019a:
            android.net.Uri r0 = android.net.Uri.parse(r12)
            android.content.Context r1 = r10.getContext()
            com.google.android.gms.internal.ads.zzape r2 = r10.zzK()
            android.view.View r3 = r10.zzH()
            android.app.Activity r4 = r10.zzk()
            android.net.Uri r0 = zzc(r1, r2, r0, r3, r4)
            android.net.Uri r0 = zzd(r0)
            if (r14 == 0) goto L_0x01cb
            com.google.android.gms.internal.ads.zzego r1 = r7.zzf
            if (r1 == 0) goto L_0x01cb
            android.content.Context r1 = r10.getContext()
            java.lang.String r2 = r0.toString()
            boolean r1 = r7.zzj(r8, r1, r2, r15)
            if (r1 == 0) goto L_0x01cb
            return
        L_0x01cb:
            com.google.android.gms.internal.ads.zzbqc r1 = new com.google.android.gms.internal.ads.zzbqc
            r1.<init>(r7)
            r7.zzg = r1
            r1 = r8
            com.google.android.gms.internal.ads.zzcnu r1 = (com.google.android.gms.internal.ads.zzcnu) r1
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc
            r9 = 0
            java.lang.String r10 = r0.toString()
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            com.google.android.gms.ads.internal.overlay.zzx r0 = r7.zzg
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r0)
            android.os.IBinder r17 = r0.asBinder()
            r18 = 1
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1.zzaF(r2, r6)
            return
        L_0x01f7:
            java.lang.String r0 = "use_first_package"
            r9.put(r0, r3)
            java.lang.String r0 = "use_running_process"
            r9.put(r0, r3)
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r14
            r5 = r15
            r1.zzh(r2, r3, r4, r5, r6)
            return
        L_0x020d:
            java.lang.String r0 = "app"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0230
            java.lang.String r0 = "system_browser"
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0224
            goto L_0x0230
        L_0x0224:
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r14
            r5 = r15
            r1.zzh(r2, r3, r4, r5, r6)
            return
        L_0x0230:
            java.lang.String r0 = "open_app"
            boolean r0 = r0.equalsIgnoreCase(r1)
            java.lang.String r5 = "p"
            if (r0 == 0) goto L_0x0294
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhc
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x024d
            return
        L_0x024d:
            r7.zzi(r2)
            java.lang.Object r0 = r9.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x025e
            java.lang.String r0 = "Package name missing from open app action."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        L_0x025e:
            if (r14 == 0) goto L_0x0270
            com.google.android.gms.internal.ads.zzego r1 = r7.zzf
            if (r1 == 0) goto L_0x0270
            android.content.Context r1 = r10.getContext()
            boolean r1 = r7.zzj(r8, r1, r0, r15)
            if (r1 != 0) goto L_0x026f
            goto L_0x0270
        L_0x026f:
            return
        L_0x0270:
            android.content.Context r1 = r10.getContext()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            if (r1 != 0) goto L_0x0280
            java.lang.String r0 = "Cannot get package manager from open app action."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        L_0x0280:
            android.content.Intent r0 = r1.getLaunchIntentForPackage(r0)
            if (r0 == 0) goto L_0x0293
            r1 = r8
            com.google.android.gms.internal.ads.zzcnu r1 = (com.google.android.gms.internal.ads.zzcnu) r1
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc
            com.google.android.gms.ads.internal.overlay.zzx r3 = r7.zzg
            r2.<init>(r0, r3)
            r1.zzaF(r2, r6)
        L_0x0293:
            return
        L_0x0294:
            r7.zzi(r2)
            java.lang.String r0 = "intent_url"
            java.lang.Object r0 = r9.get(r0)
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r4 = 0
            if (r0 != 0) goto L_0x02bb
            android.content.Intent r4 = android.content.Intent.parseUri(r3, r13)     // Catch:{ URISyntaxException -> 0x02ac }
            goto L_0x02bb
        L_0x02ac:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r3 = "Error parsing the url: "
            java.lang.String r0 = r3.concat(r0)
            com.google.android.gms.ads.internal.util.zze.zzh(r0, r2)
        L_0x02bb:
            r0 = r4
            if (r0 == 0) goto L_0x0312
            android.net.Uri r2 = r0.getData()
            if (r2 == 0) goto L_0x0312
            android.net.Uri r2 = r0.getData()
            android.net.Uri r3 = android.net.Uri.EMPTY
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0312
            android.content.Context r3 = r10.getContext()
            com.google.android.gms.internal.ads.zzape r4 = r10.zzK()
            android.view.View r13 = r10.zzH()
            r18 = r5
            android.app.Activity r5 = r10.zzk()
            android.net.Uri r2 = zzc(r3, r4, r2, r13, r5)
            android.net.Uri r2 = zzd(r2)
            java.lang.String r3 = r0.getType()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x030e
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzhd
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x030e
            java.lang.String r3 = r0.getType()
            r0.setDataAndType(r2, r3)
            goto L_0x0314
        L_0x030e:
            r0.setData(r2)
            goto L_0x0314
        L_0x0312:
            r18 = r5
        L_0x0314:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzho
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.String r13 = "event_id"
            if (r2 == 0) goto L_0x0339
            java.lang.String r2 = "intent_async"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0339
            boolean r1 = r9.containsKey(r13)
            if (r1 == 0) goto L_0x0339
            r16 = 1
            goto L_0x033b
        L_0x0339:
            r16 = 0
        L_0x033b:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            if (r16 == 0) goto L_0x035b
            com.google.android.gms.internal.ads.zzbqd r4 = new com.google.android.gms.internal.ads.zzbqd
            r1 = r4
            r2 = r32
            r3 = r6
            r6 = r4
            r4 = r33
            r19 = r5
            r22 = r18
            r18 = r12
            r12 = r6
            r6 = r34
            r1.<init>(r2, r3, r4, r5, r6)
            r7.zzg = r12
            r6 = 0
            goto L_0x0361
        L_0x035b:
            r19 = r5
            r22 = r18
            r18 = r12
        L_0x0361:
            java.lang.String r1 = "openIntentAsync"
            if (r0 == 0) goto L_0x039f
            if (r14 == 0) goto L_0x0391
            com.google.android.gms.internal.ads.zzego r2 = r7.zzf
            if (r2 == 0) goto L_0x0391
            android.content.Context r2 = r10.getContext()
            android.net.Uri r3 = r0.getData()
            java.lang.String r3 = r3.toString()
            boolean r2 = r7.zzj(r8, r2, r3, r15)
            if (r2 == 0) goto L_0x0391
            if (r16 == 0) goto L_0x0390
            java.lang.Object r0 = r9.get(r13)
            java.lang.String r0 = (java.lang.String) r0
            r2 = r19
            r2.put(r0, r11)
            r0 = r8
            com.google.android.gms.internal.ads.zzbsn r0 = (com.google.android.gms.internal.ads.zzbsn) r0
            r0.zzd(r1, r2)
        L_0x0390:
            return
        L_0x0391:
            r1 = r8
            com.google.android.gms.internal.ads.zzcnu r1 = (com.google.android.gms.internal.ads.zzcnu) r1
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc
            com.google.android.gms.ads.internal.overlay.zzx r3 = r7.zzg
            r2.<init>(r0, r3)
            r1.zzaF(r2, r6)
            return
        L_0x039f:
            r2 = r19
            boolean r0 = android.text.TextUtils.isEmpty(r18)
            if (r0 != 0) goto L_0x03c8
            android.net.Uri r0 = android.net.Uri.parse(r18)
            android.content.Context r3 = r10.getContext()
            com.google.android.gms.internal.ads.zzape r4 = r10.zzK()
            android.view.View r5 = r10.zzH()
            android.app.Activity r12 = r10.zzk()
            android.net.Uri r0 = zzc(r3, r4, r0, r5, r12)
            android.net.Uri r0 = zzd(r0)
            java.lang.String r12 = r0.toString()
            goto L_0x03ca
        L_0x03c8:
            r12 = r18
        L_0x03ca:
            if (r14 == 0) goto L_0x03ec
            com.google.android.gms.internal.ads.zzego r0 = r7.zzf
            if (r0 == 0) goto L_0x03ec
            android.content.Context r0 = r10.getContext()
            boolean r0 = r7.zzj(r8, r0, r12, r15)
            if (r0 == 0) goto L_0x03ec
            if (r16 == 0) goto L_0x03eb
            java.lang.Object r0 = r9.get(r13)
            java.lang.String r0 = (java.lang.String) r0
            r2.put(r0, r11)
            r0 = r8
            com.google.android.gms.internal.ads.zzbsn r0 = (com.google.android.gms.internal.ads.zzbsn) r0
            r0.zzd(r1, r2)
        L_0x03eb:
            return
        L_0x03ec:
            r0 = r8
            com.google.android.gms.internal.ads.zzcnu r0 = (com.google.android.gms.internal.ads.zzcnu) r0
            com.google.android.gms.ads.internal.overlay.zzc r1 = new com.google.android.gms.ads.internal.overlay.zzc
            java.lang.String r2 = "i"
            java.lang.Object r2 = r9.get(r2)
            r24 = r2
            java.lang.String r24 = (java.lang.String) r24
            java.lang.String r2 = "m"
            java.lang.Object r2 = r9.get(r2)
            r26 = r2
            java.lang.String r26 = (java.lang.String) r26
            r2 = r22
            java.lang.Object r2 = r9.get(r2)
            r27 = r2
            java.lang.String r27 = (java.lang.String) r27
            java.lang.String r2 = "c"
            java.lang.Object r2 = r9.get(r2)
            r28 = r2
            java.lang.String r28 = (java.lang.String) r28
            java.lang.String r2 = "f"
            java.lang.Object r2 = r9.get(r2)
            r29 = r2
            java.lang.String r29 = (java.lang.String) r29
            java.lang.String r2 = "e"
            java.lang.Object r2 = r9.get(r2)
            r30 = r2
            java.lang.String r30 = (java.lang.String) r30
            com.google.android.gms.ads.internal.overlay.zzx r2 = r7.zzg
            r23 = r1
            r25 = r12
            r31 = r2
            r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31)
            r0.zzaF(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqf.zza(com.google.android.gms.ads.internal.client.zza, java.util.Map):void");
    }
}
