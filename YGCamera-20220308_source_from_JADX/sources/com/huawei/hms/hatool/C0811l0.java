package com.huawei.hms.hatool;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.l0 */
public class C0811l0 implements C0814m0 {

    /* renamed from: a */
    public String f703a;

    /* renamed from: b */
    public String f704b;

    /* renamed from: c */
    public String f705c;

    /* renamed from: d */
    public List<C0823q> f706d;

    public C0811l0(List<C0823q> list, String str, String str2, String str3) {
        this.f703a = str;
        this.f704b = str2;
        this.f705c = str3;
        this.f706d = list;
    }

    /* renamed from: a */
    public final void mo14069a() {
        String a = C0828s0.m1025a(this.f703a, this.f705c, this.f704b);
        C0796g0.m831a(C0777b.m729f(), "backup_event", a);
    }

    public void run() {
        List<C0823q> list = this.f706d;
        if (list == null || list.size() == 0) {
            C0841y.m1089d("hmsSdk", "failed events is empty");
            return;
        }
        if (C0822p0.m989a(C0777b.m729f(), "cached_v2_1", C0777b.m731h() * 1048576)) {
            C0841y.m1091e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.f704b);
            return;
        }
        String a = C0828s0.m1024a(this.f703a, this.f705c);
        List list2 = C0835w.m1053b(C0777b.m729f(), "cached_v2_1", a).get(a);
        if (!(list2 == null || list2.size() == 0)) {
            this.f706d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        for (C0823q d : this.f706d) {
            try {
                jSONArray.put(d.mo14104d());
            } catch (JSONException unused) {
                C0841y.m1091e("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > C0777b.m728e() * 1048576) {
            C0841y.m1091e("hmsSdk", "this failed data is too long,can not writing it");
            this.f706d = null;
            return;
        }
        C0841y.m1089d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f704b);
        C0796g0.m834b(C0777b.m729f(), "cached_v2_1", a, jSONArray2);
        mo14069a();
    }
}
