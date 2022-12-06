package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1667bs;
import com.xiaomi.push.C1938m;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.clientreport.data.a */
public class C1526a {
    public String clientInterfaceId;
    private String miuiVersion = C1938m.m4713a();

    /* renamed from: os */
    private String f1586os = C1667bs.m2745a();
    private String pkgName;
    public int production;
    public int reportType;
    private String sdkVersion;

    public String getPackageName() {
        return this.pkgName;
    }

    public void setAppPackageName(String str) {
        this.pkgName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.production);
            jSONObject.put("reportType", this.reportType);
            jSONObject.put("clientInterfaceId", this.clientInterfaceId);
            jSONObject.put("os", this.f1586os);
            jSONObject.put("miuiVersion", this.miuiVersion);
            jSONObject.put("pkgName", this.pkgName);
            jSONObject.put("sdkVersion", this.sdkVersion);
            return jSONObject;
        } catch (JSONException e) {
            C1524b.m2155a((Throwable) e);
            return null;
        }
    }

    public String toJsonString() {
        JSONObject json = toJson();
        return json == null ? "" : json.toString();
    }
}
