package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.j0 */
public class C0805j0 implements C0814m0 {

    /* renamed from: a */
    public Context f655a = C0777b.m729f();

    /* renamed from: b */
    public String f656b;

    /* renamed from: c */
    public JSONObject f657c;

    /* renamed from: d */
    public String f658d;

    /* renamed from: e */
    public String f659e;

    /* renamed from: f */
    public String f660f;

    /* renamed from: g */
    public String f661g;

    /* renamed from: h */
    public Boolean f662h;

    public C0805j0(String str, JSONObject jSONObject, String str2, String str3, long j) {
        this.f656b = str;
        this.f657c = jSONObject;
        this.f658d = str2;
        this.f659e = str3;
        this.f660f = String.valueOf(j);
        if (C0773a.m711i(str2, "oper")) {
            C0792f0 a = C0788e0.m792a().mo13948a(str2, j);
            this.f661g = a.mo13952a();
            this.f662h = Boolean.valueOf(a.mo13954b());
        }
    }

    public void run() {
        JSONArray jSONArray;
        C0841y.m1087c("hmsSdk", "Begin to run EventRecordTask...");
        int e = C0777b.m728e();
        int k = C0781c.m751k(this.f658d, this.f659e);
        if (C0822p0.m989a(this.f655a, "stat_v2_1", e * 1048576)) {
            C0841y.m1087c("hmsSdk", "stat sp file reach max limited size, discard new event");
            C0799h0.m845a().mo13969a("", "alltype");
            return;
        }
        C0823q qVar = new C0823q();
        qVar.mo14101b(this.f656b);
        qVar.mo14098a(this.f657c.toString());
        qVar.mo14105d(this.f659e);
        qVar.mo14103c(this.f660f);
        qVar.mo14107f(this.f661g);
        Boolean bool = this.f662h;
        qVar.mo14106e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject d = qVar.mo14104d();
            String a = C0828s0.m1024a(this.f658d, this.f659e);
            String a2 = C0796g0.m829a(this.f655a, "stat_v2_1", a, "");
            try {
                jSONArray = !TextUtils.isEmpty(a2) ? new JSONArray(a2) : new JSONArray();
            } catch (JSONException unused) {
                C0841y.m1089d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(d);
            C0796g0.m834b(this.f655a, "stat_v2_1", a, jSONArray.toString());
            if (jSONArray.toString().length() > k * 1024) {
                C0799h0.m845a().mo13969a(this.f658d, this.f659e);
            }
        } catch (JSONException unused2) {
            C0841y.m1091e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
