package sg.bigo.ads.core.c;

import android.content.Context;
import android.text.TextUtils;
import com.iab.omid.library.bigosg.Omid;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.n.b;

public final class c extends sg.bigo.ads.common.d.c {
    protected String e;

    public static class a {
        /* access modifiers changed from: private */
        public static final c a = new c((byte) 0);
    }

    private c() {
        this.e = "";
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public final String a() {
        return "OMSDK";
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final sg.bigo.ads.core.c.b a(android.webkit.WebView r13, android.view.View... r14) {
        /*
            r12 = this;
            java.lang.String r0 = "OMSDK"
            boolean r1 = r12.b
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            com.iab.omid.library.bigosg.b.f r1 = com.iab.omid.library.bigosg.b.f.HTML_DISPLAY     // Catch:{ Exception -> 0x0069 }
            com.iab.omid.library.bigosg.b.h r3 = com.iab.omid.library.bigosg.b.h.BEGIN_TO_RENDER     // Catch:{ Exception -> 0x0069 }
            com.iab.omid.library.bigosg.b.i r4 = com.iab.omid.library.bigosg.b.i.NATIVE     // Catch:{ Exception -> 0x0069 }
            com.iab.omid.library.bigosg.b.i r5 = com.iab.omid.library.bigosg.b.i.NONE     // Catch:{ Exception -> 0x0069 }
            com.iab.omid.library.bigosg.b.c r1 = com.iab.omid.library.bigosg.b.c.a(r1, r3, r4, r5)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "Bigosg"
            java.lang.String r4 = "2.4.1"
            com.iab.omid.library.bigosg.b.j r6 = com.iab.omid.library.bigosg.b.j.a(r3, r4)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "Partner is null"
            com.iab.omid.library.bigosg.e.d.a((java.lang.Object) r6, (java.lang.String) r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "WebView is null"
            com.iab.omid.library.bigosg.e.d.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x0069 }
            com.iab.omid.library.bigosg.b.d r3 = new com.iab.omid.library.bigosg.b.d     // Catch:{ Exception -> 0x0069 }
            r8 = 0
            r9 = 0
            r10 = 0
            com.iab.omid.library.bigosg.b.e r11 = com.iab.omid.library.bigosg.b.e.HTML     // Catch:{ Exception -> 0x0069 }
            r5 = r3
            r7 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0069 }
            com.iab.omid.library.bigosg.b.b r1 = com.iab.omid.library.bigosg.b.b.a(r1, r3)     // Catch:{ Exception -> 0x0069 }
            r1.a(r13)     // Catch:{ Exception -> 0x0067 }
            int r13 = r14.length     // Catch:{ Exception -> 0x0067 }
            r3 = 0
            r4 = r3
        L_0x003c:
            if (r4 >= r13) goto L_0x0048
            r5 = r14[r4]     // Catch:{ Exception -> 0x0067 }
            if (r5 == 0) goto L_0x0045
            r1.b(r5)     // Catch:{ Exception -> 0x0067 }
        L_0x0045:
            int r4 = r4 + 1
            goto L_0x003c
        L_0x0048:
            r1.a()     // Catch:{ Exception -> 0x0067 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            java.lang.String r14 = "createHtmlOmsdkEvent success, AdSession Id: "
            r13.<init>(r14)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r14 = r1.c()     // Catch:{ Exception -> 0x0067 }
            r13.append(r14)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0067 }
            r14 = 3
            sg.bigo.ads.common.k.a.a(r3, r14, r0, r13)     // Catch:{ Exception -> 0x0067 }
            sg.bigo.ads.core.c.b r13 = new sg.bigo.ads.core.c.b     // Catch:{ Exception -> 0x0067 }
            r13.<init>(r1, r2)     // Catch:{ Exception -> 0x0067 }
            return r13
        L_0x0067:
            r13 = move-exception
            goto L_0x006b
        L_0x0069:
            r13 = move-exception
            r1 = r2
        L_0x006b:
            r13.printStackTrace()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r3 = "createHtmlOmsdkEvent error: "
            r14.<init>(r3)
            java.lang.String r13 = r13.getMessage()
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            sg.bigo.ads.common.k.a.b(r0, r13)
            if (r1 == 0) goto L_0x0088
            r1.b()
        L_0x0088:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.c.c.a(android.webkit.WebView, android.view.View[]):sg.bigo.ads.core.c.b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final sg.bigo.ads.core.c.b a(java.util.List<sg.bigo.ads.core.c.a> r17, boolean r18, android.view.View r19, android.view.View... r20) {
        /*
            r16 = this;
            r1 = r16
            r0 = r20
            java.lang.String r2 = " "
            boolean r3 = r1.b
            r4 = 0
            java.lang.String r5 = "OMSDK"
            if (r3 != 0) goto L_0x0013
            java.lang.String r0 = "Fail to create native OM AdSession: OMSDK is not ready"
        L_0x000f:
            sg.bigo.ads.common.k.a.b(r5, r0)
            return r4
        L_0x0013:
            if (r17 != 0) goto L_0x0018
            java.lang.String r0 = "Fail to create native OM AdSession: OM configs is null"
            goto L_0x000f
        L_0x0018:
            java.lang.String r11 = ""
            java.lang.String r3 = "Bigosg"
            java.lang.String r6 = "2.4.1"
            com.iab.omid.library.bigosg.b.j r7 = com.iab.omid.library.bigosg.b.j.a(r3, r6)     // Catch:{ Exception -> 0x0143 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0143 }
            r10.<init>()     // Catch:{ Exception -> 0x0143 }
            java.util.Iterator r3 = r17.iterator()     // Catch:{ Exception -> 0x0143 }
        L_0x002b:
            boolean r6 = r3.hasNext()     // Catch:{ Exception -> 0x0143 }
            r13 = 3
            r14 = 0
            if (r6 == 0) goto L_0x0087
            java.lang.Object r6 = r3.next()     // Catch:{ Exception -> 0x0143 }
            sg.bigo.ads.core.c.a r6 = (sg.bigo.ads.core.c.a) r6     // Catch:{ Exception -> 0x0143 }
            java.lang.String r8 = r6.a     // Catch:{ Exception -> 0x0143 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0143 }
            if (r8 != 0) goto L_0x002b
            java.lang.String r8 = r6.b     // Catch:{ Exception -> 0x0143 }
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x0143 }
            java.lang.String r12 = r6.a     // Catch:{ Exception -> 0x0143 }
            r9.<init>(r12)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r12 = r6.c     // Catch:{ Exception -> 0x0143 }
            java.lang.String r15 = "VendorKey is null or empty"
            com.iab.omid.library.bigosg.e.d.a((java.lang.String) r8, (java.lang.String) r15)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r15 = "ResourceURL is null"
            com.iab.omid.library.bigosg.e.d.a((java.lang.Object) r9, (java.lang.String) r15)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r15 = "VerificationParameters is null or empty"
            com.iab.omid.library.bigosg.e.d.a((java.lang.String) r12, (java.lang.String) r15)     // Catch:{ Exception -> 0x0143 }
            com.iab.omid.library.bigosg.b.k r15 = new com.iab.omid.library.bigosg.b.k     // Catch:{ Exception -> 0x0143 }
            r15.<init>(r8, r9, r12)     // Catch:{ Exception -> 0x0143 }
            r10.add(r15)     // Catch:{ Exception -> 0x0143 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0143 }
            java.lang.String r9 = "Create verificationScriptResource: "
            r8.<init>(r9)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r9 = r6.b     // Catch:{ Exception -> 0x0143 }
            r8.append(r9)     // Catch:{ Exception -> 0x0143 }
            r8.append(r2)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r9 = r6.a     // Catch:{ Exception -> 0x0143 }
            r8.append(r9)     // Catch:{ Exception -> 0x0143 }
            r8.append(r2)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r6 = r6.c     // Catch:{ Exception -> 0x0143 }
            r8.append(r6)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x0143 }
            sg.bigo.ads.common.k.a.a(r14, r13, r5, r6)     // Catch:{ Exception -> 0x0143 }
            goto L_0x002b
        L_0x0087:
            int r2 = r10.size()     // Catch:{ Exception -> 0x0143 }
            if (r2 != 0) goto L_0x0093
            java.lang.String r0 = "Fail to create native OM AdSession: no verification script resources"
            sg.bigo.ads.common.k.a.b(r5, r0)     // Catch:{ Exception -> 0x0143 }
            return r4
        L_0x0093:
            java.lang.String r9 = r1.a     // Catch:{ Exception -> 0x0143 }
            java.lang.String r2 = "Partner is null"
            com.iab.omid.library.bigosg.e.d.a((java.lang.Object) r7, (java.lang.String) r2)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r2 = "OM SDK JS script content is null"
            com.iab.omid.library.bigosg.e.d.a((java.lang.Object) r9, (java.lang.String) r2)     // Catch:{ Exception -> 0x0143 }
            java.lang.String r2 = "VerificationScriptResources is null"
            com.iab.omid.library.bigosg.e.d.a((java.lang.Object) r10, (java.lang.String) r2)     // Catch:{ Exception -> 0x0143 }
            com.iab.omid.library.bigosg.b.d r2 = new com.iab.omid.library.bigosg.b.d     // Catch:{ Exception -> 0x0143 }
            r8 = 0
            com.iab.omid.library.bigosg.b.e r12 = com.iab.omid.library.bigosg.b.e.NATIVE     // Catch:{ Exception -> 0x0143 }
            r6 = r2
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0143 }
            if (r18 == 0) goto L_0x00b2
            com.iab.omid.library.bigosg.b.f r3 = com.iab.omid.library.bigosg.b.f.VIDEO     // Catch:{ Exception -> 0x0143 }
            goto L_0x00b4
        L_0x00b2:
            com.iab.omid.library.bigosg.b.f r3 = com.iab.omid.library.bigosg.b.f.NATIVE_DISPLAY     // Catch:{ Exception -> 0x0143 }
        L_0x00b4:
            com.iab.omid.library.bigosg.b.h r6 = com.iab.omid.library.bigosg.b.h.BEGIN_TO_RENDER     // Catch:{ Exception -> 0x0143 }
            com.iab.omid.library.bigosg.b.i r7 = com.iab.omid.library.bigosg.b.i.NATIVE     // Catch:{ Exception -> 0x0143 }
            if (r18 == 0) goto L_0x00bd
            com.iab.omid.library.bigosg.b.i r8 = com.iab.omid.library.bigosg.b.i.NATIVE     // Catch:{ Exception -> 0x0143 }
            goto L_0x00bf
        L_0x00bd:
            com.iab.omid.library.bigosg.b.i r8 = com.iab.omid.library.bigosg.b.i.NONE     // Catch:{ Exception -> 0x0143 }
        L_0x00bf:
            com.iab.omid.library.bigosg.b.c r3 = com.iab.omid.library.bigosg.b.c.a(r3, r6, r7, r8)     // Catch:{ Exception -> 0x0143 }
            com.iab.omid.library.bigosg.b.b r2 = com.iab.omid.library.bigosg.b.b.a(r3, r2)     // Catch:{ Exception -> 0x0143 }
            r3 = r19
            r2.a(r3)     // Catch:{ Exception -> 0x0141 }
            if (r0 == 0) goto L_0x00dc
            int r3 = r0.length     // Catch:{ Exception -> 0x0141 }
            r6 = r14
        L_0x00d0:
            if (r6 >= r3) goto L_0x00dc
            r7 = r0[r6]     // Catch:{ Exception -> 0x0141 }
            if (r7 == 0) goto L_0x00d9
            r2.b(r7)     // Catch:{ Exception -> 0x0141 }
        L_0x00d9:
            int r6 = r6 + 1
            goto L_0x00d0
        L_0x00dc:
            if (r18 == 0) goto L_0x0122
            r0 = r2
            com.iab.omid.library.bigosg.b.l r0 = (com.iab.omid.library.bigosg.b.l) r0     // Catch:{ Exception -> 0x0141 }
            java.lang.String r3 = "AdSession is null"
            com.iab.omid.library.bigosg.e.d.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0141 }
            com.iab.omid.library.bigosg.b.c r3 = r0.a     // Catch:{ Exception -> 0x0141 }
            com.iab.omid.library.bigosg.b.i r6 = com.iab.omid.library.bigosg.b.i.NATIVE     // Catch:{ Exception -> 0x0141 }
            com.iab.omid.library.bigosg.b.i r3 = r3.b     // Catch:{ Exception -> 0x0141 }
            if (r6 != r3) goto L_0x00f0
            r3 = 1
            goto L_0x00f1
        L_0x00f0:
            r3 = r14
        L_0x00f1:
            if (r3 == 0) goto L_0x011a
            boolean r3 = r0.d     // Catch:{ Exception -> 0x0141 }
            if (r3 != 0) goto L_0x0112
            com.iab.omid.library.bigosg.e.d.a(r0)     // Catch:{ Exception -> 0x0141 }
            com.iab.omid.library.bigosg.g.a r3 = r0.c     // Catch:{ Exception -> 0x0141 }
            com.iab.omid.library.bigosg.b.a.b r3 = r3.c     // Catch:{ Exception -> 0x0141 }
            if (r3 != 0) goto L_0x010a
            com.iab.omid.library.bigosg.b.a.b r3 = new com.iab.omid.library.bigosg.b.a.b     // Catch:{ Exception -> 0x0141 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0141 }
            com.iab.omid.library.bigosg.g.a r0 = r0.c     // Catch:{ Exception -> 0x0141 }
            r0.c = r3     // Catch:{ Exception -> 0x0141 }
            goto L_0x0123
        L_0x010a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0141 }
            java.lang.String r3 = "MediaEvents already exists for AdSession"
            r0.<init>(r3)     // Catch:{ Exception -> 0x0141 }
            throw r0     // Catch:{ Exception -> 0x0141 }
        L_0x0112:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0141 }
            java.lang.String r3 = "AdSession is started"
            r0.<init>(r3)     // Catch:{ Exception -> 0x0141 }
            throw r0     // Catch:{ Exception -> 0x0141 }
        L_0x011a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0141 }
            java.lang.String r3 = "Cannot create MediaEvents for JavaScript AdSession"
            r0.<init>(r3)     // Catch:{ Exception -> 0x0141 }
            throw r0     // Catch:{ Exception -> 0x0141 }
        L_0x0122:
            r3 = r4
        L_0x0123:
            r2.a()     // Catch:{ Exception -> 0x0141 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0141 }
            java.lang.String r6 = "Create native OM AdSession success, AdSession Id: "
            r0.<init>(r6)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r6 = r2.c()     // Catch:{ Exception -> 0x0141 }
            r0.append(r6)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0141 }
            sg.bigo.ads.common.k.a.a(r14, r13, r5, r0)     // Catch:{ Exception -> 0x0141 }
            sg.bigo.ads.core.c.b r0 = new sg.bigo.ads.core.c.b     // Catch:{ Exception -> 0x0141 }
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0141 }
            return r0
        L_0x0141:
            r0 = move-exception
            goto L_0x0145
        L_0x0143:
            r0 = move-exception
            r2 = r4
        L_0x0145:
            r0.printStackTrace()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "Fail to create native OM Session: : "
            r3.<init>(r6)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            sg.bigo.ads.common.k.a.b(r5, r0)
            if (r2 == 0) goto L_0x0162
            r2.b()
        L_0x0162:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.c.c.a(java.util.List, boolean, android.view.View, android.view.View[]):sg.bigo.ads.core.c.b");
    }

    public final void a(Context context, String str) {
        try {
            Omid.a(context);
            sg.bigo.ads.common.k.a.a("OMSDK", "OM SDK initialized successfully.");
            this.e = str;
            sg.bigo.ads.common.f.c.a(1, new Runnable() {
                public final void run() {
                    c cVar = c.this;
                    if (cVar.j()) {
                        cVar.a = cVar.i();
                        if (!TextUtils.isEmpty(cVar.a)) {
                            sg.bigo.ads.common.k.a.a("OMSDK", "Fetch omsdk-v1.js from file successfully.");
                            cVar.b = true;
                            cVar.g();
                            return;
                        }
                        cVar.c("https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js");
                        return;
                    }
                    cVar.c("https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js");
                }
            });
        } catch (Throwable th) {
            sg.bigo.ads.common.k.a.a(1, 5, "OMSDK", "Failed to initialize OM SDK initialize: " + th.getMessage());
            th.printStackTrace();
        }
    }

    public final void a(String str) {
        b.a("sp_omid_service_downloaded_url", str, 3);
    }

    public final boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals(str2);
    }

    public final String b() {
        return i.e();
    }

    public final boolean b(String str) {
        return str.contains("omidGlobal");
    }

    public final String c() {
        return "omsdk-v1.js";
    }

    public final String d() {
        return "https://gdl.news-cdn.site/as/bigo-ad-creatives/7h5/M09/FD/6B/qvsbAF5g1KaIOSQ7AACyEETvrcoABLLjgDvdTQAALIo1432.js";
    }

    public final String d(String str) {
        try {
            return com.iab.omid.library.bigosg.c.a(this.a, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final String e() {
        return this.e;
    }

    public final String f() {
        return (String) b.b("sp_omid_service_downloaded_url", "", 3);
    }
}
