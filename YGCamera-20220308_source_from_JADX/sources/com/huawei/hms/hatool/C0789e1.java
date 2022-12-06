package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.e1 */
public class C0789e1 extends C0821p {

    /* renamed from: f */
    public String f617f;

    /* renamed from: g */
    public String f618g;

    /* renamed from: h */
    public String f619h;

    /* renamed from: a */
    public JSONObject mo13931a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f619h);
        jSONObject.put("_emui_ver", this.f726a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f617f);
        jSONObject.put("_mnc", this.f618g);
        jSONObject.put("_package_name", this.f727b);
        jSONObject.put("_app_ver", this.f728c);
        jSONObject.put("_lib_ver", "2.2.0.308");
        jSONObject.put("_channel", this.f729d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f730e);
        return jSONObject;
    }

    /* renamed from: f */
    public void mo13949f(String str) {
        this.f617f = str;
    }

    /* renamed from: g */
    public void mo13950g(String str) {
        this.f618g = str;
    }

    /* renamed from: h */
    public void mo13951h(String str) {
        this.f619h = str;
    }
}
