package com.mbridge.msdk.videocommon.b;

import com.vungle.warren.model.ReportDBAdapter;
import org.json.JSONObject;

/* compiled from: AdParams */
public final class a {
    private String a;
    private String b;

    private a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new a(jSONObject.optString("appId"), jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
