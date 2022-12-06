package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.u */
public class C0831u {

    /* renamed from: a */
    public String f748a;

    /* renamed from: b */
    public String f749b;

    /* renamed from: c */
    public String f750c;

    /* renamed from: d */
    public List<C0823q> f751d;

    /* renamed from: e */
    public String f752e;

    public C0831u(String str, String str2, String str3, List<C0823q> list, String str4) {
        this.f748a = str;
        this.f749b = str2;
        this.f750c = str3;
        this.f751d = list;
        this.f752e = str4;
    }

    /* renamed from: a */
    public final String mo14115a(String str, String str2) {
        String str3;
        String f = C0781c.m746f(str, str2);
        if (TextUtils.isEmpty(f)) {
            C0841y.m1082a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else if (!"diffprivacy".equals(str2)) {
            return "";
        } else {
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", f);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.huawei.hms.hatool.i0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.huawei.hms.hatool.l0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.huawei.hms.hatool.i0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.huawei.hms.hatool.i0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo14116a() {
        /*
            r9 = this;
            java.lang.String r0 = r9.f748a
            java.lang.String r1 = r9.f749b
            java.lang.String r4 = r9.mo14115a(r0, r1)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r1 = "hmsSdk"
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = r9.f749b
            java.lang.String r2 = "preins"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = "collectUrl is empty"
        L_0x001c:
            com.huawei.hms.hatool.C0841y.m1091e(r1, r0)
            return
        L_0x0020:
            java.lang.String r0 = r9.f748a
            java.lang.String r2 = "_hms_config_tag"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0037
            java.lang.String r0 = r9.f748a
            java.lang.String r2 = "_openness_config_tag"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0037
            r9.mo14118b()
        L_0x0037:
            com.huawei.hms.hatool.r r0 = r9.mo14120d()
            if (r0 == 0) goto L_0x005a
            byte[] r3 = r9.mo14117a(r0)
            int r0 = r3.length
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "request body is empty"
            goto L_0x001c
        L_0x0047:
            com.huawei.hms.hatool.i0 r0 = new com.huawei.hms.hatool.i0
            java.lang.String r5 = r9.f748a
            java.lang.String r6 = r9.f749b
            java.lang.String r7 = r9.f752e
            java.util.List<com.huawei.hms.hatool.q> r8 = r9.f751d
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.huawei.hms.hatool.n0 r1 = com.huawei.hms.hatool.C0817n0.m970a()
            goto L_0x006b
        L_0x005a:
            com.huawei.hms.hatool.l0 r0 = new com.huawei.hms.hatool.l0
            java.util.List<com.huawei.hms.hatool.q> r1 = r9.f751d
            java.lang.String r2 = r9.f748a
            java.lang.String r3 = r9.f752e
            java.lang.String r4 = r9.f749b
            r0.<init>(r1, r2, r3, r4)
            com.huawei.hms.hatool.n0 r1 = com.huawei.hms.hatool.C0817n0.m971b()
        L_0x006b:
            r1.mo14082a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.C0831u.mo14116a():void");
    }

    /* renamed from: a */
    public final byte[] mo14117a(C0825r rVar) {
        String str;
        try {
            JSONObject a = rVar.mo13931a();
            if (a != null) {
                return C0826r0.m1019a(a.toString().getBytes(Key.STRING_CHARSET_NAME));
            }
            C0841y.m1091e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (JSONException unused) {
            str = "uploadEvents to json error";
            C0841y.m1091e("hmsSdk", str);
            return new byte[0];
        } catch (UnsupportedEncodingException unused2) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            C0841y.m1091e("hmsSdk", str);
            return new byte[0];
        }
    }

    /* renamed from: b */
    public final void mo14118b() {
        if (C0822p0.m989a(C0777b.m729f(), "backup_event", 5242880)) {
            C0841y.m1089d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray c = mo14119c();
        String a = C0828s0.m1025a(this.f748a, this.f749b, this.f752e);
        C0841y.m1087c("hmsSdk", "Update data cached into backup,spKey: " + a);
        C0796g0.m834b(C0777b.m729f(), "backup_event", a, c.toString());
    }

    /* renamed from: c */
    public final JSONArray mo14119c() {
        JSONArray jSONArray = new JSONArray();
        for (C0823q d : this.f751d) {
            try {
                jSONArray.put(d.mo14104d());
            } catch (JSONException unused) {
                C0841y.m1087c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    /* renamed from: d */
    public final C0825r mo14120d() {
        return C0779b1.m738a(this.f751d, this.f748a, this.f749b, this.f752e, this.f750c);
    }
}
