package com.huawei.hms.hatool;

import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.c1 */
public class C0783c1 extends C0816n {

    /* renamed from: b */
    public String f604b = "";

    /* renamed from: c */
    public String f605c = "";

    /* renamed from: d */
    public String f606d = "";

    /* renamed from: e */
    public String f607e = "";

    /* renamed from: f */
    public String f608f = "";

    /* renamed from: g */
    public String f609g;

    /* renamed from: a */
    public JSONObject mo13931a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f713a);
        jSONObject.put("oaid", this.f609g);
        jSONObject.put("uuid", this.f608f);
        jSONObject.put("upid", this.f607e);
        jSONObject.put("imei", this.f604b);
        jSONObject.put("sn", this.f605c);
        jSONObject.put("udid", this.f606d);
        return jSONObject;
    }

    /* renamed from: b */
    public void mo13932b(String str) {
        this.f604b = str;
    }

    /* renamed from: c */
    public void mo13933c(String str) {
        this.f609g = str;
    }

    /* renamed from: d */
    public void mo13934d(String str) {
        this.f605c = str;
    }

    /* renamed from: e */
    public void mo13935e(String str) {
        this.f606d = str;
    }

    /* renamed from: f */
    public void mo13936f(String str) {
        this.f607e = str;
    }

    /* renamed from: g */
    public void mo13937g(String str) {
        this.f608f = str;
    }
}
