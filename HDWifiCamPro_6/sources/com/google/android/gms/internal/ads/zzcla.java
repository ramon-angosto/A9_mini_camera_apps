package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcla implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzclb zze;

    zzcla(zzclb zzclb, String str, String str2, String str3, String str4) {
        this.zze = zzclb;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "event"
            java.lang.String r2 = "precacheCanceled"
            r0.put(r1, r2)
            java.lang.String r1 = r3.zza
            java.lang.String r2 = "src"
            r0.put(r2, r1)
            java.lang.String r1 = r3.zzb
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = r3.zzb
            java.lang.String r2 = "cachedSrc"
            r0.put(r2, r1)
        L_0x0022:
            java.lang.String r1 = r3.zzc
            int r2 = r1.hashCode()
            switch(r2) {
                case -1947652542: goto L_0x00a1;
                case -1396664534: goto L_0x0096;
                case -1347010958: goto L_0x008c;
                case -918817863: goto L_0x0081;
                case -659376217: goto L_0x0077;
                case -642208130: goto L_0x006d;
                case -354048396: goto L_0x0062;
                case -32082395: goto L_0x0057;
                case 3387234: goto L_0x004d;
                case 96784904: goto L_0x0043;
                case 580119100: goto L_0x0038;
                case 725497484: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x00ab
        L_0x002d:
            java.lang.String r2 = "noCacheDir"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 7
            goto L_0x00ac
        L_0x0038:
            java.lang.String r2 = "expireFailed"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 6
            goto L_0x00ac
        L_0x0043:
            java.lang.String r2 = "error"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 1
            goto L_0x00ac
        L_0x004d:
            java.lang.String r2 = "noop"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 4
            goto L_0x00ac
        L_0x0057:
            java.lang.String r2 = "externalAbort"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 10
            goto L_0x00ac
        L_0x0062:
            java.lang.String r2 = "sizeExceeded"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 11
            goto L_0x00ac
        L_0x006d:
            java.lang.String r2 = "playerFailed"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 5
            goto L_0x00ac
        L_0x0077:
            java.lang.String r2 = "contentLengthMissing"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 0
            goto L_0x00ac
        L_0x0081:
            java.lang.String r2 = "downloadTimeout"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 9
            goto L_0x00ac
        L_0x008c:
            java.lang.String r2 = "inProgress"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 2
            goto L_0x00ac
        L_0x0096:
            java.lang.String r2 = "badUrl"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 8
            goto L_0x00ac
        L_0x00a1:
            java.lang.String r2 = "interrupted"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ab
            r1 = 3
            goto L_0x00ac
        L_0x00ab:
            r1 = -1
        L_0x00ac:
            java.lang.String r2 = "internal"
            switch(r1) {
                case 0: goto L_0x00ba;
                case 1: goto L_0x00ba;
                case 2: goto L_0x00ba;
                case 3: goto L_0x00ba;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00ba;
                case 6: goto L_0x00b8;
                case 7: goto L_0x00b8;
                case 8: goto L_0x00b5;
                case 9: goto L_0x00b5;
                case 10: goto L_0x00b2;
                case 11: goto L_0x00b2;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            goto L_0x00ba
        L_0x00b2:
            java.lang.String r2 = "policy"
            goto L_0x00ba
        L_0x00b5:
            java.lang.String r2 = "network"
            goto L_0x00ba
        L_0x00b8:
            java.lang.String r2 = "io"
        L_0x00ba:
            java.lang.String r1 = "type"
            r0.put(r1, r2)
            java.lang.String r1 = r3.zzc
            java.lang.String r2 = "reason"
            r0.put(r2, r1)
            java.lang.String r1 = r3.zzd
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00d5
            java.lang.String r1 = r3.zzd
            java.lang.String r2 = "message"
            r0.put(r2, r1)
        L_0x00d5:
            com.google.android.gms.internal.ads.zzclb r1 = r3.zze
            java.lang.String r2 = "onPrecacheEvent"
            com.google.android.gms.internal.ads.zzclb.zza(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcla.run():void");
    }
}
