package com.bytedance.sdk.component.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AbstractBridge */
public abstract class a {
    protected Context a;
    protected m b;
    protected h c;
    protected Handler d = new Handler(Looper.getMainLooper());
    protected String e;
    protected volatile boolean f = false;
    g g;
    private final Map<String, g> h = new HashMap();

    /* access modifiers changed from: protected */
    public abstract Context a(j jVar);

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public abstract void b(j jVar);

    protected a() {
    }

    /* access modifiers changed from: protected */
    public void invokeMethod(final String str) {
        if (!this.f) {
            i.a("Received call: " + str);
            this.d.post(new Runnable() {
                public void run() {
                    if (!a.this.f) {
                        q qVar = null;
                        try {
                            qVar = a.this.a(new JSONObject(str));
                        } catch (JSONException e) {
                            i.b("Exception thrown while parsing function.", e);
                        }
                        if (q.a(qVar)) {
                            i.a("By pass invalid call: " + qVar);
                            if (qVar != null) {
                                a.this.b(y.a((Throwable) new s(qVar.a, "Failed to parse invocation.")), qVar);
                                return;
                            }
                            return;
                        }
                        a.this.a(qVar);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str, q qVar) {
        a(str);
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.g.a();
        for (g a2 : this.h.values()) {
            a2.a();
        }
        this.d.removeCallbacksAndMessages((Object) null);
        this.f = true;
    }

    /* access modifiers changed from: protected */
    public final void a(q qVar) {
        String a2;
        if (!this.f && (a2 = a()) != null) {
            g b2 = b(qVar.g);
            if (b2 == null) {
                i.b("Received call with unknown namespace, " + qVar);
                m mVar = this.b;
                if (mVar != null) {
                    mVar.a(a(), qVar.d, 2);
                }
                b(y.a((Throwable) new s(-4, "Namespace " + qVar.g + " unknown.")), qVar);
                return;
            }
            f fVar = new f();
            fVar.b = a2;
            fVar.a = this.a;
            fVar.c = b2;
            try {
                g.a a3 = b2.a(qVar, fVar);
                if (a3 == null) {
                    i.b("Received call but not registered, " + qVar);
                    if (this.b != null) {
                        this.b.a(a(), qVar.d, 2);
                    }
                    b(y.a((Throwable) new s(-2, "Function " + qVar.d + " is not registered.")), qVar);
                    return;
                }
                if (a3.a) {
                    b(a3.b, qVar);
                }
                if (this.b != null) {
                    this.b.a(a(), qVar.d);
                }
            } catch (Exception e2) {
                i.a("call finished with error, " + qVar, e2);
                b(y.a((Throwable) e2), qVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(j jVar, v vVar) {
        this.a = a(jVar);
        this.c = jVar.d;
        this.b = jVar.i;
        this.g = new g(jVar, this, vVar);
        this.e = jVar.k;
        b(jVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, q qVar) {
        JSONObject jSONObject;
        if (!this.f) {
            if (TextUtils.isEmpty(qVar.f)) {
                i.a("By passing js callback due to empty callback: " + str);
                return;
            }
            if (!str.startsWith("{") || !str.endsWith("}")) {
                i.a((RuntimeException) new IllegalArgumentException("Illegal callback data: " + str));
            }
            i.a("Invoking js callback: " + qVar.f);
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                jSONObject = new JSONObject();
            }
            a(p.a().a("__msg_type", "callback").a("__callback_id", qVar.f).a("__params", jSONObject).b(), qVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r5 = r9.optString("params");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.a.q a(org.json.JSONObject r9) {
        /*
            r8 = this;
            java.lang.String r0 = "params"
            boolean r1 = r8.f
            r2 = 0
            if (r1 == 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.String r1 = "__callback_id"
            java.lang.String r1 = r9.optString(r1)
            java.lang.String r3 = "func"
            java.lang.String r3 = r9.optString(r3)
            java.lang.String r4 = r8.a()
            if (r4 != 0) goto L_0x0023
            com.bytedance.sdk.component.a.m r9 = r8.b
            if (r9 == 0) goto L_0x0022
            r0 = 3
            r9.a(r2, r2, r0)
        L_0x0022:
            return r2
        L_0x0023:
            java.lang.String r2 = "__msg_type"
            java.lang.String r2 = r9.getString(r2)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r5 = ""
            java.lang.Object r6 = r9.opt(r0)     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x004d
            boolean r5 = r6 instanceof org.json.JSONObject     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x003c
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ all -> 0x0049 }
            java.lang.String r5 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x003c:
            boolean r5 = r6 instanceof java.lang.String     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0044
            r5 = r6
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x0044:
            java.lang.String r5 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            java.lang.String r5 = r9.optString(r0)     // Catch:{ JSONException -> 0x0084 }
        L_0x004d:
            java.lang.String r0 = "JSSDK"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r6 = "namespace"
            java.lang.String r6 = r9.optString(r6)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r7 = "__iframe_url"
            java.lang.String r9 = r9.optString(r7)     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q$a r7 = com.bytedance.sdk.component.a.q.a()     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q$a r0 = r7.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q$a r0 = r0.b((java.lang.String) r2)     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q$a r0 = r0.c((java.lang.String) r3)     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q$a r0 = r0.d((java.lang.String) r5)     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q$a r0 = r0.e((java.lang.String) r1)     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q$a r0 = r0.f((java.lang.String) r6)     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q$a r9 = r0.g((java.lang.String) r9)     // Catch:{ JSONException -> 0x0084 }
            com.bytedance.sdk.component.a.q r9 = r9.a()     // Catch:{ JSONException -> 0x0084 }
            return r9
        L_0x0084:
            r9 = move-exception
            java.lang.String r0 = "Failed to create call."
            com.bytedance.sdk.component.a.i.b(r0, r9)
            com.bytedance.sdk.component.a.m r9 = r8.b
            if (r9 == 0) goto L_0x0092
            r0 = 1
            r9.a(r4, r3, r0)
        L_0x0092:
            r9 = -1
            com.bytedance.sdk.component.a.q r9 = com.bytedance.sdk.component.a.q.a(r1, r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.a.a.a(org.json.JSONObject):com.bytedance.sdk.component.a.q");
    }

    private g b(String str) {
        if (TextUtils.equals(str, this.e) || TextUtils.isEmpty(str)) {
            return this.g;
        }
        return this.h.get(str);
    }
}
