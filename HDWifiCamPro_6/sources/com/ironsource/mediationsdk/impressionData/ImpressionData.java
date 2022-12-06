package com.ironsource.mediationsdk.impressionData;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class ImpressionData {
    private String A = null;
    private DecimalFormat B;
    private final String a = IronSourceConstants.EVENTS_AUCTION_ID;
    private final String b = IronSourceConstants.EVENTS_AD_UNIT;
    private final String c = "country";
    private final String d = "ab";
    private final String e = "segmentName";
    private final String f = "placement";
    private final String g = "adNetwork";
    private final String h = "instanceName";
    private final String i = "instanceId";
    private final String j = "revenue";
    private final String k = "precision";
    private final String l = "lifetimeRevenue";
    private final String m = "encryptedCPM";
    private JSONObject n;
    private String o = null;
    private String p = null;
    private String q = null;
    private String r = null;
    private String s = null;
    private String t = null;
    private String u = null;
    private String v = null;
    private String w = null;
    private Double x = null;
    private String y = null;
    private Double z = null;

    public ImpressionData(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        String str = "revenue";
        this.B = new DecimalFormat("#.#####");
        if (jSONObject2 != null) {
            try {
                this.n = jSONObject2;
                this.o = jSONObject2.optString(IronSourceConstants.EVENTS_AUCTION_ID, (String) null);
                this.p = jSONObject2.optString(IronSourceConstants.EVENTS_AD_UNIT, (String) null);
                this.q = jSONObject2.optString("country", (String) null);
                this.r = jSONObject2.optString("ab", (String) null);
                this.s = jSONObject2.optString("segmentName", (String) null);
                this.t = jSONObject2.optString("placement", (String) null);
                this.u = jSONObject2.optString("adNetwork", (String) null);
                this.v = jSONObject2.optString("instanceName", (String) null);
                this.w = jSONObject2.optString("instanceId", (String) null);
                this.y = jSONObject2.optString("precision", (String) null);
                this.A = jSONObject2.optString("encryptedCPM", (String) null);
                double optDouble = jSONObject2.optDouble("lifetimeRevenue");
                this.z = Double.isNaN(optDouble) ? null : Double.valueOf(optDouble);
                double optDouble2 = jSONObject2.optDouble(str);
                this.x = Double.isNaN(optDouble2) ? null : Double.valueOf(optDouble2);
            } catch (Exception e2) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("error parsing impression " + e2.getMessage());
            }
        }
    }

    public String getAb() {
        return this.r;
    }

    public String getAdNetwork() {
        return this.u;
    }

    public String getAdUnit() {
        return this.p;
    }

    public JSONObject getAllData() {
        return this.n;
    }

    public String getAuctionId() {
        return this.o;
    }

    public String getCountry() {
        return this.q;
    }

    public String getEncryptedCPM() {
        return this.A;
    }

    public String getInstanceId() {
        return this.w;
    }

    public String getInstanceName() {
        return this.v;
    }

    public Double getLifetimeRevenue() {
        return this.z;
    }

    public String getPlacement() {
        return this.t;
    }

    public String getPrecision() {
        return this.y;
    }

    public Double getRevenue() {
        return this.x;
    }

    public String getSegmentName() {
        return this.s;
    }

    public void replaceMacroForPlacementWithValue(String str, String str2) {
        String str3 = this.t;
        if (str3 != null) {
            this.t = str3.replace(str, str2);
            JSONObject jSONObject = this.n;
            if (jSONObject != null) {
                try {
                    jSONObject.put("placement", this.t);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImpressionData{auctionId='");
        sb.append(this.o);
        sb.append('\'');
        sb.append(", adUnit='");
        sb.append(this.p);
        sb.append('\'');
        sb.append(", country='");
        sb.append(this.q);
        sb.append('\'');
        sb.append(", ab='");
        sb.append(this.r);
        sb.append('\'');
        sb.append(", segmentName='");
        sb.append(this.s);
        sb.append('\'');
        sb.append(", placement='");
        sb.append(this.t);
        sb.append('\'');
        sb.append(", adNetwork='");
        sb.append(this.u);
        sb.append('\'');
        sb.append(", instanceName='");
        sb.append(this.v);
        sb.append('\'');
        sb.append(", instanceId='");
        sb.append(this.w);
        sb.append('\'');
        sb.append(", revenue=");
        Double d2 = this.x;
        String str = null;
        sb.append(d2 == null ? null : this.B.format(d2));
        sb.append(", precision='");
        sb.append(this.y);
        sb.append('\'');
        sb.append(", lifetimeRevenue=");
        Double d3 = this.z;
        if (d3 != null) {
            str = this.B.format(d3);
        }
        sb.append(str);
        sb.append(", encryptedCPM='");
        sb.append(this.A);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
