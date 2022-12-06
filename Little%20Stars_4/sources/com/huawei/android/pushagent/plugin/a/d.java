package com.huawei.android.pushagent.plugin.a;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private String a;
    private int b;
    private List c = new ArrayList();
    private double d = -1.0d;
    private double e = -1.0d;
    private boolean f = false;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mccmnc", this.a);
            jSONObject.put("phoneType", this.b);
            if (this.c != null) {
                if (this.c.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (b a2 : this.c) {
                        JSONObject a3 = a2.a();
                        if (a3 != null) {
                            jSONArray.put(a3);
                        }
                    }
                    jSONObject.put(RequestParameters.SUBRESOURCE_LOCATION, jSONArray);
                    if (!(this.d == -1.0d || this.e == -1.0d)) {
                        jSONObject.put("lng", this.d);
                        jSONObject.put("lat", this.e);
                    }
                    return jSONObject;
                }
            }
            e.d(BLocation.TAG, "locations is null");
            return null;
        } catch (JSONException e2) {
            e.c(BLocation.TAG, "parse GSMInfo to json error", e2);
            return null;
        } catch (Exception e3) {
            e.c(BLocation.TAG, "parse GSMInfo to json error", e3);
            return null;
        }
    }

    public void a(double d2, double d3) {
        if (d2 != -1.0d && d3 != -1.0d) {
            this.d = d2;
            this.e = d3;
            this.f = true;
        }
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(List list) {
        this.c = list;
    }

    public boolean b() {
        e.a(BLocation.TAG, "hasLonLat:" + this.f);
        return this.f;
    }
}
