package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.d.a.b;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.c.a.c;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.o;
import com.bytedance.sdk.openadsdk.l.w;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEvent */
public class a implements b {
    public final String a;
    protected final JSONObject b;
    private long c;
    private long d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private JSONObject f = new JSONObject();
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private com.bytedance.sdk.openadsdk.c.b.a m;
    private String n;
    private String o;
    private String p;
    private String q;

    a(C0039a aVar) {
        this.a = TextUtils.isEmpty(aVar.a) ? o.a() : aVar.a;
        this.m = aVar.n;
        this.o = aVar.e;
        this.g = aVar.b;
        this.h = aVar.c;
        this.i = TextUtils.isEmpty(aVar.d) ? "app_union" : aVar.d;
        this.n = aVar.j;
        this.j = aVar.g;
        this.l = aVar.h;
        this.k = aVar.f;
        this.p = aVar.k;
        this.q = aVar.l;
        this.f = aVar.i = aVar.i != null ? aVar.i : new JSONObject();
        this.b = new JSONObject();
        if (!TextUtils.isEmpty(aVar.l)) {
            try {
                this.b.put("app_log_url", aVar.l);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.d = System.currentTimeMillis();
        h();
    }

    public a(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    private boolean a(String str, String str2, String str3) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence) || TextUtils.equals(charSequence, MBridgeConstans.ENDCARD_URL_TYPE_PL) || TextUtils.isEmpty(str3)) {
            return false;
        }
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 111399750:
                if (str2.equals("umeng")) {
                    c2 = 0;
                    break;
                }
                break;
            case 278118976:
                if (str2.equals("event_v1")) {
                    c2 = 3;
                    break;
                }
                break;
            case 278118978:
                if (str2.equals("event_v3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1844205361:
                if (str2.equals("app_union")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        return c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            switch(r0) {
                case 111399750: goto L_0x002a;
                case 278118976: goto L_0x0020;
                case 278118978: goto L_0x0016;
                case 1844205361: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "app_union"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = r4
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "event_v3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = r2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "event_v1"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = r1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "umeng"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = r3
            goto L_0x0035
        L_0x0034:
            r6 = -1
        L_0x0035:
            if (r6 == 0) goto L_0x003e
            if (r6 == r4) goto L_0x003e
            if (r6 == r2) goto L_0x003e
            if (r6 == r1) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r3 = r4
        L_0x003f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.a.b(java.lang.String):boolean");
    }

    private void h() {
        JSONObject jSONObject = this.f;
        if (jSONObject != null) {
            String optString = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            String optString2 = this.f.optString("category");
            String optString3 = this.f.optString("log_extra");
            CharSequence charSequence = optString;
            if (a(this.j, this.i, this.o)) {
                if (!TextUtils.isEmpty(charSequence) && TextUtils.equals(charSequence, MBridgeConstans.ENDCARD_URL_TYPE_PL)) {
                    return;
                }
                if (!TextUtils.isEmpty(optString2) && !b(optString2)) {
                    return;
                }
            } else if ((!TextUtils.isEmpty(charSequence) && !TextUtils.equals(charSequence, MBridgeConstans.ENDCARD_URL_TYPE_PL)) || (!TextUtils.isEmpty(this.j) && !TextUtils.equals(this.j, MBridgeConstans.ENDCARD_URL_TYPE_PL))) {
                if ((!TextUtils.isEmpty(this.i) && b(this.i)) || (!TextUtils.isEmpty(optString2) && b(optString2))) {
                    if (TextUtils.isEmpty(this.o) && TextUtils.isEmpty(optString3)) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (!a(this.j, this.i, this.o)) {
            return;
        }
        this.c = (long) c.a.incrementAndGet();
    }

    private void i() throws JSONException {
        this.b.putOpt("app_log_url", this.q);
        this.b.putOpt("tag", this.g);
        this.b.putOpt("label", this.h);
        this.b.putOpt("category", this.i);
        if (!TextUtils.isEmpty(this.j)) {
            try {
                this.b.putOpt(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(Long.parseLong(this.j)));
            } catch (NumberFormatException unused) {
                this.b.putOpt(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0L);
            }
        }
        if (!TextUtils.isEmpty(this.l)) {
            try {
                this.b.putOpt("ext_value", Long.valueOf(Long.parseLong(this.l)));
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.o)) {
            this.b.putOpt("log_extra", this.o);
        }
        if (!TextUtils.isEmpty(this.n)) {
            try {
                this.b.putOpt("ua_policy", Integer.valueOf(Integer.parseInt(this.n)));
            } catch (NumberFormatException unused3) {
            }
        }
        this.b.putOpt("is_ad_event", "1");
        try {
            this.b.putOpt("nt", this.p);
        } catch (Exception unused4) {
        }
        Iterator<String> keys = this.f.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.b.putOpt(next, this.f.opt(next));
        }
    }

    public long a() {
        return this.d;
    }

    public JSONObject a(String str) {
        return c();
    }

    public long b() {
        return this.c;
    }

    public JSONObject c() {
        if (this.e.get()) {
            return this.b;
        }
        try {
            i();
            if (this.m != null) {
                this.m.a(this.b);
            }
            this.e.set(true);
        } catch (Throwable th) {
            l.c("AdEvent", th);
        }
        return this.b;
    }

    public JSONObject d() {
        JSONObject c2 = c();
        try {
            JSONObject jSONObject = new JSONObject(c2.toString());
            jSONObject.remove("app_log_url");
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return c2;
        }
    }

    public String e() {
        if (!TextUtils.isEmpty(this.h)) {
            return this.h;
        }
        JSONObject jSONObject = this.b;
        return jSONObject != null ? jSONObject.optString("label") : "";
    }

    public String f() {
        return this.a;
    }

    public boolean g() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("label");
        if (!TextUtils.isEmpty(optString)) {
            return b.a.contains(optString);
        }
        if (TextUtils.isEmpty(this.h)) {
            return false;
        }
        return b.a.contains(this.h);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.c.a$a  reason: collision with other inner class name */
    /* compiled from: AdEvent */
    public static final class C0039a {
        /* access modifiers changed from: private */
        public String a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public String e;
        /* access modifiers changed from: private */
        public String f;
        /* access modifiers changed from: private */
        public String g;
        /* access modifiers changed from: private */
        public String h;
        /* access modifiers changed from: private */
        public JSONObject i;
        /* access modifiers changed from: private */
        public String j;
        /* access modifiers changed from: private */
        public final String k = String.valueOf(com.bytedance.sdk.component.utils.o.c(m.a()));
        /* access modifiers changed from: private */
        public String l;
        private com.bytedance.sdk.openadsdk.c.b.b m;
        /* access modifiers changed from: private */
        public com.bytedance.sdk.openadsdk.c.b.a n;
        private final long o;

        public C0039a(long j2) {
            this.o = j2;
        }

        public C0039a a(String str) {
            this.l = str;
            return this;
        }

        public C0039a b(String str) {
            this.b = str;
            return this;
        }

        public C0039a c(String str) {
            this.c = str;
            return this;
        }

        public C0039a d(String str) {
            this.d = str;
            return this;
        }

        public C0039a e(String str) {
            this.e = str;
            return this;
        }

        public C0039a f(String str) {
            this.g = str;
            return this;
        }

        public C0039a g(String str) {
            this.h = str;
            return this;
        }

        public C0039a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.i = jSONObject;
            return this;
        }

        public C0039a h(String str) {
            this.f = str;
            return this;
        }

        public void a(com.bytedance.sdk.openadsdk.c.b.a aVar) {
            this.n = aVar;
            final a aVar2 = new a(this);
            try {
                if (this.m != null) {
                    this.m.a(aVar2.b, this.o);
                } else {
                    new com.bytedance.sdk.openadsdk.c.b.c().a(aVar2.b, this.o);
                }
            } catch (Throwable th) {
                l.c("AdEvent", th);
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                w.b(new g("dispatchEvent") {
                    public void run() {
                        c.a(aVar2);
                    }
                });
            } else {
                c.a(aVar2);
            }
        }
    }
}
