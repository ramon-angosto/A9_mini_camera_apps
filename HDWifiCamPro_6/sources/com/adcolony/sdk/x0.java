package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.adcolony.sdk.e0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

class x0 {

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.f(h0Var);
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.a(h0Var);
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            x0.this.c(h0Var);
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.n(h0Var);
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.j(h0Var);
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.i(h0Var);
        }
    }

    class g implements Runnable {
        final /* synthetic */ String a;

        g(x0 x0Var, String str) {
            this.a = str;
        }

        public void run() {
            f1 b = c0.b();
            c0.a(b, "type", "open_hook");
            c0.a(b, "message", this.a);
            new h0("CustomMessage.controller_send", 0, b).c();
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            x0.this.h(h0Var);
        }
    }

    class i implements j0 {
        i() {
        }

        public void a(h0 h0Var) {
            x0.this.m(h0Var);
        }
    }

    class j implements j0 {
        j() {
        }

        public void a(h0 h0Var) {
            x0.this.k(h0Var);
        }
    }

    class k implements j0 {
        k() {
        }

        public void a(h0 h0Var) {
            x0.this.o(h0Var);
        }
    }

    class l implements j0 {
        l() {
        }

        public void a(h0 h0Var) {
            x0.this.g(h0Var);
        }
    }

    class m implements j0 {
        m() {
        }

        public void a(h0 h0Var) {
            x0.this.e(h0Var);
        }
    }

    class n implements j0 {
        n() {
        }

        public void a(h0 h0Var) {
            x0.this.d(h0Var);
        }
    }

    class o implements j0 {
        o() {
        }

        public void a(h0 h0Var) {
            x0.this.b(h0Var);
        }
    }

    class p implements j0 {
        p() {
        }

        public void a(h0 h0Var) {
            x0.this.l(h0Var);
        }
    }

    x0() {
    }

    /* access modifiers changed from: private */
    public boolean f(h0 h0Var) {
        f1 a2 = h0Var.a();
        d c2 = a.b().c();
        String h2 = c0.h(a2, "ad_session_id");
        AdColonyInterstitial adColonyInterstitial = c2.f().get(h2);
        AdColonyAdView adColonyAdView = c2.d().get(h2);
        if ((adColonyInterstitial == null || adColonyInterstitial.getListener() == null || adColonyInterstitial.d() == null) && (adColonyAdView == null || adColonyAdView.getListener() == null)) {
            return false;
        }
        if (adColonyAdView == null) {
            new h0("AdUnit.make_in_app_purchase", adColonyInterstitial.d().k()).c();
        }
        a(h2);
        b(h2);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean i(h0 h0Var) {
        f1 a2 = h0Var.a();
        String h2 = c0.h(c0.f(a2, "clickOverride"), "url");
        String h3 = c0.h(a2, "ad_session_id");
        d c2 = a.b().c();
        AdColonyInterstitial adColonyInterstitial = c2.f().get(h3);
        AdColonyAdView adColonyAdView = c2.d().get(h3);
        if (adColonyInterstitial != null) {
            adColonyInterstitial.b(h2);
            return true;
        } else if (adColonyAdView == null) {
            return false;
        } else {
            adColonyAdView.setClickOverride(h2);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean j(h0 h0Var) {
        int i2;
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "ad_session_id");
        int d2 = c0.d(a2, "orientation");
        d c2 = a.b().c();
        AdColonyAdView adColonyAdView = c2.d().get(h2);
        AdColonyInterstitial adColonyInterstitial = c2.f().get(h2);
        Context a3 = a.a();
        if (adColonyAdView != null) {
            adColonyAdView.setOrientation(d2);
        } else if (adColonyInterstitial != null) {
            adColonyInterstitial.a(d2);
        }
        if (adColonyInterstitial == null && adColonyAdView == null) {
            new e0.a().a("Invalid ad session id sent with set orientation properties message: ").a(h2).a(e0.i);
            return false;
        } else if (!(a3 instanceof b)) {
            return true;
        } else {
            b bVar = (b) a3;
            if (adColonyAdView == null) {
                i2 = adColonyInterstitial.f();
            } else {
                i2 = adColonyAdView.getOrientation();
            }
            bVar.a(i2);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean n(h0 h0Var) {
        AdColonyAdView adColonyAdView = a.b().c().d().get(c0.h(h0Var.a(), "ad_session_id"));
        if (adColonyAdView == null) {
            return false;
        }
        adColonyAdView.setNoCloseButton(c0.b(h0Var.a(), "use_custom_close"));
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean g(h0 h0Var) {
        f1 b2 = c0.b();
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "url");
        String h3 = c0.h(a2, "ad_session_id");
        AdColonyAdView adColonyAdView = a.b().c().d().get(h3);
        if (adColonyAdView != null && !adColonyAdView.getTrustedDemandSource() && !adColonyAdView.c()) {
            return false;
        }
        if (h2.startsWith("browser")) {
            h2 = h2.replaceFirst("browser", "http");
        }
        if (h2.startsWith("safari")) {
            h2 = h2.replaceFirst("safari", "http");
        }
        d(h2);
        if (z0.a(new Intent("android.intent.action.VIEW", Uri.parse(h2)))) {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            c(h3);
            a(h3);
            b(h3);
            return true;
        }
        z0.a("Failed to launch browser.", 0);
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean h(h0 h0Var) {
        f1 b2 = c0.b();
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "product_id");
        String h3 = c0.h(a2, "ad_session_id");
        if (h2.equals("")) {
            h2 = c0.h(a2, "handle");
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(h2));
        d(h2);
        if (z0.a(intent)) {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            c(h3);
            a(h3);
            b(h3);
            return true;
        }
        z0.a("Unable to open.", 0);
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean k(h0 h0Var) {
        f1 a2 = h0Var.a();
        f1 b2 = c0.b();
        String h2 = c0.h(a2, "ad_session_id");
        e1 a3 = c0.a(a2, "recipients");
        String str = "";
        for (int i2 = 0; i2 < a3.b(); i2++) {
            if (i2 != 0) {
                str = str + ";";
            }
            str = str + c0.b(a3, i2);
        }
        if (z0.a(new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + str)).putExtra("sms_body", c0.h(a2, TtmlNode.TAG_BODY)))) {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            c(h2);
            a(h2);
            b(h2);
            return true;
        }
        z0.a("Failed to create sms.", 0);
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean l(h0 h0Var) {
        f1 b2 = c0.b();
        f1 a2 = h0Var.a();
        Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
        Intent putExtra = type.putExtra("android.intent.extra.TEXT", c0.h(a2, MimeTypes.BASE_TYPE_TEXT) + " " + c0.h(a2, "url"));
        String h2 = c0.h(a2, "ad_session_id");
        if (z0.a(putExtra, true)) {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            c(h2);
            a(h2);
            b(h2);
            return true;
        }
        z0.a("Unable to create social post.", 0);
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean m(h0 h0Var) {
        f1 b2 = c0.b();
        f1 a2 = h0Var.a();
        Intent intent = new Intent("android.intent.action.DIAL");
        Intent data = intent.setData(Uri.parse("tel:" + c0.h(a2, "phone_number")));
        String h2 = c0.h(a2, "ad_session_id");
        if (z0.a(data)) {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            c(h2);
            a(h2);
            b(h2);
            return true;
        }
        z0.a("Failed to dial number.", 0);
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean o(h0 h0Var) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        int a3 = c0.a(h0Var.a(), "length_ms", 500);
        f1 b2 = c0.b();
        e1 e2 = z0.e(a2);
        boolean z = false;
        for (int i2 = 0; i2 < e2.b(); i2++) {
            if (c0.b(e2, i2).equals("android.permission.VIBRATE")) {
                z = true;
            }
        }
        if (!z) {
            new e0.a().a("No vibrate permission detected.").a(e0.f);
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return false;
        } else if (Build.VERSION.SDK_INT < 11 || !z0.a(a2, (long) a3)) {
            c0.b(b2, "success", false);
            h0Var.a(b2).c();
            return false;
        } else {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a.a("System.open_store", (j0) new h());
        a.a("System.telephone", (j0) new i());
        a.a("System.sms", (j0) new j());
        a.a("System.vibrate", (j0) new k());
        a.a("System.open_browser", (j0) new l());
        a.a("System.mail", (j0) new m());
        a.a("System.launch_app", (j0) new n());
        a.a("System.create_calendar_event", (j0) new o());
        a.a("System.social_post", (j0) new p());
        a.a("System.make_in_app_purchase", (j0) new a());
        a.a("System.close", (j0) new b());
        a.a("System.expand", (j0) new c());
        a.a("System.use_custom_close", (j0) new d());
        a.a("System.set_orientation_properties", (j0) new e());
        a.a("System.click_override", (j0) new f());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.adcolony.sdk.h0 r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            com.adcolony.sdk.f1 r2 = com.adcolony.sdk.c0.b()
            com.adcolony.sdk.f1 r3 = r25.a()
            java.lang.String r4 = "ad_session_id"
            java.lang.String r4 = com.adcolony.sdk.c0.h(r3, r4)
            java.lang.String r5 = "params"
            com.adcolony.sdk.f1 r3 = com.adcolony.sdk.c0.f(r3, r5)
            java.lang.String r5 = "recurrence"
            com.adcolony.sdk.f1 r5 = com.adcolony.sdk.c0.f(r3, r5)
            com.adcolony.sdk.e1 r6 = com.adcolony.sdk.c0.a()
            com.adcolony.sdk.e1 r7 = com.adcolony.sdk.c0.a()
            com.adcolony.sdk.e1 r8 = com.adcolony.sdk.c0.a()
            java.lang.String r9 = "description"
            java.lang.String r10 = com.adcolony.sdk.c0.h(r3, r9)
            java.lang.String r11 = "location"
            com.adcolony.sdk.c0.h(r3, r11)
            java.lang.String r11 = "start"
            java.lang.String r11 = com.adcolony.sdk.c0.h(r3, r11)
            java.lang.String r12 = "end"
            java.lang.String r12 = com.adcolony.sdk.c0.h(r3, r12)
            java.lang.String r13 = "summary"
            java.lang.String r3 = com.adcolony.sdk.c0.h(r3, r13)
            java.lang.String r13 = ""
            if (r5 == 0) goto L_0x0078
            boolean r14 = r5.b()
            if (r14 != 0) goto L_0x0078
            java.lang.String r6 = "expires"
            java.lang.String r6 = com.adcolony.sdk.c0.h(r5, r6)
            java.lang.String r7 = "frequency"
            java.lang.String r7 = com.adcolony.sdk.c0.h(r5, r7)
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r7 = r7.toUpperCase(r8)
            java.lang.String r8 = "daysInWeek"
            com.adcolony.sdk.e1 r8 = com.adcolony.sdk.c0.a((com.adcolony.sdk.f1) r5, (java.lang.String) r8)
            java.lang.String r14 = "daysInMonth"
            com.adcolony.sdk.e1 r14 = com.adcolony.sdk.c0.a((com.adcolony.sdk.f1) r5, (java.lang.String) r14)
            java.lang.String r15 = "daysInYear"
            com.adcolony.sdk.e1 r15 = com.adcolony.sdk.c0.a((com.adcolony.sdk.f1) r5, (java.lang.String) r15)
            goto L_0x007d
        L_0x0078:
            r14 = r7
            r15 = r8
            r7 = r13
            r8 = r6
            r6 = r7
        L_0x007d:
            boolean r13 = r3.equals(r13)
            if (r13 == 0) goto L_0x0084
            r3 = r10
        L_0x0084:
            java.util.Date r11 = com.adcolony.sdk.z0.g(r11)
            java.util.Date r12 = com.adcolony.sdk.z0.g(r12)
            java.util.Date r6 = com.adcolony.sdk.z0.g(r6)
            java.lang.String r13 = "success"
            if (r11 == 0) goto L_0x0206
            if (r12 != 0) goto L_0x0098
            goto L_0x0206
        L_0x0098:
            long r0 = r11.getTime()
            r16 = r13
            long r12 = r12.getTime()
            r17 = 0
            if (r6 == 0) goto L_0x00b5
            long r19 = r6.getTime()
            long r21 = r11.getTime()
            long r19 = r19 - r21
            r21 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 / r21
            goto L_0x00b7
        L_0x00b5:
            r19 = r17
        L_0x00b7:
            java.lang.String r6 = "DAILY"
            boolean r6 = r7.equals(r6)
            r21 = 1
            if (r6 == 0) goto L_0x00cd
            r17 = 86400(0x15180, double:4.26873E-319)
            long r19 = r19 / r17
        L_0x00c6:
            long r17 = r19 + r21
        L_0x00c8:
            r19 = r12
            r11 = r17
            goto L_0x00f7
        L_0x00cd:
            java.lang.String r6 = "WEEKLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00db
            r17 = 604800(0x93a80, double:2.98811E-318)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00db:
            java.lang.String r6 = "MONTHLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00e9
            r17 = 2629800(0x2820a8, double:1.299294E-317)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00e9:
            java.lang.String r6 = "YEARLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00c8
            r17 = 31557600(0x1e187e0, double:1.5591526E-316)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00f7:
            java.lang.String r6 = "endTime"
            java.lang.String r13 = "beginTime"
            r17 = r4
            java.lang.String r4 = "title"
            r18 = r2
            java.lang.String r2 = "vnd.android.cursor.item/event"
            r21 = r6
            java.lang.String r6 = "android.intent.action.EDIT"
            if (r5 == 0) goto L_0x01aa
            boolean r5 = r5.b()
            if (r5 != 0) goto L_0x01aa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r22 = r0
            java.lang.String r0 = "FREQ="
            r5.append(r0)
            r5.append(r7)
            java.lang.String r0 = ";COUNT="
            r5.append(r0)
            r5.append(r11)
            java.lang.String r0 = r5.toString()
            int r1 = r8.b()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0148
            java.lang.String r1 = com.adcolony.sdk.z0.a((com.adcolony.sdk.e1) r8)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0148:
            int r1 = r14.b()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0166
            java.lang.String r1 = com.adcolony.sdk.z0.b((com.adcolony.sdk.e1) r14)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYMONTHDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0166:
            int r1 = r15.b()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0184
            java.lang.String r1 = com.adcolony.sdk.z0.b((com.adcolony.sdk.e1) r15)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYYEARDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0184:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6)
            android.content.Intent r1 = r1.setType(r2)
            android.content.Intent r1 = r1.putExtra(r4, r3)
            android.content.Intent r1 = r1.putExtra(r9, r10)
            r7 = r22
            android.content.Intent r1 = r1.putExtra(r13, r7)
            r11 = r19
            r5 = r21
            android.content.Intent r1 = r1.putExtra(r5, r11)
            java.lang.String r2 = "rrule"
            android.content.Intent r0 = r1.putExtra(r2, r0)
            goto L_0x01c8
        L_0x01aa:
            r7 = r0
            r11 = r19
            r5 = r21
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r6)
            android.content.Intent r0 = r0.setType(r2)
            android.content.Intent r0 = r0.putExtra(r4, r3)
            android.content.Intent r0 = r0.putExtra(r9, r10)
            android.content.Intent r0 = r0.putExtra(r13, r7)
            android.content.Intent r0 = r0.putExtra(r5, r11)
        L_0x01c8:
            boolean r0 = com.adcolony.sdk.z0.a((android.content.Intent) r0)
            if (r0 == 0) goto L_0x01ed
            r0 = 1
            r2 = r16
            r1 = r18
            com.adcolony.sdk.c0.b((com.adcolony.sdk.f1) r1, (java.lang.String) r2, (boolean) r0)
            r3 = r25
            com.adcolony.sdk.h0 r1 = r3.a(r1)
            r1.c()
            r4 = r24
            r1 = r17
            r4.c((java.lang.String) r1)
            r4.a((java.lang.String) r1)
            r4.b((java.lang.String) r1)
            return r0
        L_0x01ed:
            r0 = 0
            r4 = r24
            r3 = r25
            r2 = r16
            r1 = r18
            java.lang.String r5 = "Unable to create Calendar Event."
            com.adcolony.sdk.z0.a((java.lang.String) r5, (int) r0)
            com.adcolony.sdk.c0.b((com.adcolony.sdk.f1) r1, (java.lang.String) r2, (boolean) r0)
            com.adcolony.sdk.h0 r1 = r3.a(r1)
            r1.c()
            return r0
        L_0x0206:
            r0 = 0
            r4 = r24
            r3 = r1
            r1 = r2
            r2 = r13
            java.lang.String r5 = "Unable to create Calendar Event"
            com.adcolony.sdk.z0.a((java.lang.String) r5, (int) r0)
            com.adcolony.sdk.c0.b((com.adcolony.sdk.f1) r1, (java.lang.String) r2, (boolean) r0)
            com.adcolony.sdk.h0 r1 = r3.a(r1)
            r1.c()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.x0.b(com.adcolony.sdk.h0):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean c(h0 h0Var) {
        f1 a2 = h0Var.a();
        Context a3 = a.a();
        if (a3 != null && a.d()) {
            String h2 = c0.h(a2, "ad_session_id");
            k b2 = a.b();
            AdColonyAdView adColonyAdView = b2.c().d().get(h2);
            if (adColonyAdView != null && ((adColonyAdView.getTrustedDemandSource() || adColonyAdView.c()) && b2.k() != adColonyAdView)) {
                adColonyAdView.setExpandMessage(h0Var);
                adColonyAdView.setExpandedWidth(c0.d(a2, "width"));
                adColonyAdView.setExpandedHeight(c0.d(a2, "height"));
                adColonyAdView.setOrientation(c0.a(a2, "orientation", -1));
                adColonyAdView.setNoCloseButton(c0.b(a2, "use_custom_close"));
                b2.a(adColonyAdView);
                b2.a(adColonyAdView.getContainer());
                Intent intent = new Intent(a3, AdColonyAdViewActivity.class);
                b(h2);
                a(h2);
                z0.a(intent);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d(h0 h0Var) {
        f1 b2 = c0.b();
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "ad_session_id");
        if (c0.b(a2, CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
            return h(h0Var);
        }
        Context a3 = a.a();
        if (a3 == null) {
            return false;
        }
        if (z0.a(a3.getPackageManager().getLaunchIntentForPackage(c0.h(a2, "handle")))) {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            c(h2);
            a(h2);
            b(h2);
            return true;
        }
        z0.a("Failed to launch external application.", 0);
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean e(h0 h0Var) {
        f1 b2 = c0.b();
        f1 a2 = h0Var.a();
        e1 a3 = c0.a(a2, "recipients");
        boolean b3 = c0.b(a2, "html");
        String h2 = c0.h(a2, "subject");
        String h3 = c0.h(a2, TtmlNode.TAG_BODY);
        String h4 = c0.h(a2, "ad_session_id");
        String[] strArr = new String[a3.b()];
        for (int i2 = 0; i2 < a3.b(); i2++) {
            strArr[i2] = c0.b(a3, i2);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (!b3) {
            intent.setType("plain/text");
        }
        intent.putExtra("android.intent.extra.SUBJECT", h2).putExtra("android.intent.extra.TEXT", h3).putExtra("android.intent.extra.EMAIL", strArr);
        if (z0.a(intent)) {
            c0.b(b2, "success", true);
            h0Var.a(b2).c();
            c(h4);
            a(h4);
            b(h4);
            return true;
        }
        z0.a("Failed to send email.", 0);
        c0.b(b2, "success", false);
        h0Var.a(b2).c();
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        d c2 = a.b().c();
        AdColonyInterstitial adColonyInterstitial = c2.f().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.getListener() == null) {
            AdColonyAdView adColonyAdView = c2.d().get(str);
            AdColonyAdViewListener listener = adColonyAdView != null ? adColonyAdView.getListener() : null;
            if (adColonyAdView != null && listener != null) {
                listener.onLeftApplication(adColonyAdView);
                return;
            }
            return;
        }
        adColonyInterstitial.getListener().onLeftApplication(adColonyInterstitial);
    }

    private void d(String str) {
        if (!z0.a((Runnable) new g(this, str))) {
            new e0.a().a("Executing ADCSystem.sendOpenCustomMessage failed").a(e0.i);
        }
    }

    /* access modifiers changed from: private */
    public boolean a(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "ad_session_id");
        Activity activity = a.a() instanceof Activity ? (Activity) a.a() : null;
        boolean z = activity instanceof AdColonyAdViewActivity;
        if (!(activity instanceof b)) {
            return false;
        }
        if (z) {
            ((AdColonyAdViewActivity) activity).b();
            return true;
        }
        f1 b2 = c0.b();
        c0.a(b2, "id", h2);
        new h0("AdSession.on_request_close", ((b) activity).c, b2).c();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        d c2 = a.b().c();
        AdColonyInterstitial adColonyInterstitial = c2.f().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.getListener() == null || !adColonyInterstitial.h()) {
            AdColonyAdView adColonyAdView = c2.d().get(str);
            AdColonyAdViewListener listener = adColonyAdView != null ? adColonyAdView.getListener() : null;
            if (adColonyAdView != null && listener != null && adColonyAdView.c()) {
                listener.onClicked(adColonyAdView);
                return;
            }
            return;
        }
        adColonyInterstitial.getListener().onClicked(adColonyInterstitial);
    }

    private boolean b(String str) {
        if (a.b().c().d().get(str) == null) {
            return false;
        }
        f1 b2 = c0.b();
        c0.a(b2, "ad_session_id", str);
        new h0("MRAID.on_event", 1, b2).c();
        return true;
    }
}
