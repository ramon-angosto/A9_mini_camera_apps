package com.huawei.hms.hatool;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.d1 */
public class C0786d1 extends C0819o {

    /* renamed from: g */
    public String f614g = "";

    /* renamed from: a */
    public JSONObject mo13931a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f721d);
        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f718a);
        jSONObject.put("hmac", this.f614g);
        jSONObject.put("chifer", this.f723f);
        jSONObject.put("timestamp", this.f719b);
        jSONObject.put("servicetag", this.f720c);
        jSONObject.put("requestid", this.f722e);
        return jSONObject;
    }

    /* renamed from: g */
    public void mo13946g(String str) {
        this.f614g = str;
    }
}
