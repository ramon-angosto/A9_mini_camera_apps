package com.ironsource.mediationsdk.server;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    private String a;
    private String b;
    private String c;
    private List<String> d;
    private List<String> e;
    private List<String> f;
    private boolean g;
    private ImpressionData h;

    public b(String str) {
        this.a = str;
        this.b = "";
        this.c = "";
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = true;
        this.h = null;
    }

    public b(JSONObject jSONObject) {
        this(jSONObject, (JSONObject) null);
    }

    public b(JSONObject jSONObject, JSONObject jSONObject2) {
        this.g = false;
        try {
            if (jSONObject.has("instance")) {
                this.a = jSONObject.getString("instance");
            }
            this.b = jSONObject.has("adMarkup") ? jSONObject.getString("adMarkup") : jSONObject.has("serverData") ? jSONObject.getString("serverData") : "";
            this.c = jSONObject.has("price") ? jSONObject.getString("price") : MBridgeConstans.ENDCARD_URL_TYPE_PL;
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.f = new ArrayList();
            if (jSONObject.has("notifications")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("notifications");
                if (optJSONObject.has("burl")) {
                    JSONArray jSONArray = optJSONObject.getJSONArray("burl");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.d.add(jSONArray.getString(i));
                    }
                }
                if (optJSONObject.has("lurl")) {
                    JSONArray jSONArray2 = optJSONObject.getJSONArray("lurl");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.e.add(jSONArray2.getString(i2));
                    }
                }
                if (optJSONObject.has("nurl")) {
                    JSONArray jSONArray3 = optJSONObject.getJSONArray("nurl");
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        this.f.add(jSONArray3.getString(i3));
                    }
                }
            }
            this.h = new ImpressionData(com.ironsource.mediationsdk.c.b.a(jSONObject2, jSONObject.has("armData") ? jSONObject.optJSONObject("armData") : null));
            this.g = true;
        } catch (Exception unused) {
        }
    }

    public ImpressionData a(String str) {
        ImpressionData impressionData = this.h;
        if (impressionData != null) {
            impressionData.replaceMacroForPlacementWithValue("${PLACEMENT_NAME}", str);
        }
        return this.h;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public List<String> d() {
        return this.d;
    }

    public List<String> e() {
        return this.e;
    }

    public List<String> f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }
}
