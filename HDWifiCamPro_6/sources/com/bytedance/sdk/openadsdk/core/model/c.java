package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.component.utils.l;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* compiled from: AppInfo */
public class c {
    private static int f = 1;
    private static int g = 5;
    private String a = "";
    private String b = "";
    private String c = "";
    private double d = -1.0d;
    private int e = -1;
    private int h;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public double d() {
        return this.d;
    }

    public void a(double d2) {
        if (d2 < ((double) f) || d2 > ((double) g)) {
            this.d = -1.0d;
        } else {
            this.d = d2;
        }
    }

    public int e() {
        return this.e;
    }

    public void a(int i) {
        if (i <= 0) {
            this.e = -1;
        } else {
            this.e = i;
        }
    }

    public int f() {
        return this.h;
    }

    public void b(int i) {
        this.h = i;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", b());
            jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, f());
            jSONObject.put("comment_num", e());
            jSONObject.put(DownloadModel.DOWNLOAD_URL, a());
            jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, c());
            jSONObject.put("score", d());
        } catch (Exception e2) {
            l.d(e2.toString());
        }
        return jSONObject;
    }
}
