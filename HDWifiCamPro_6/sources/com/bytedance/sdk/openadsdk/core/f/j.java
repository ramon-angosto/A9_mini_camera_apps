package com.bytedance.sdk.openadsdk.core.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewabilityVendor */
public class j {
    private final String a;
    private final URL b;
    private final String c;
    private final String d;

    private j(String str, String str2, String str3, String str4) throws MalformedURLException {
        this.a = str2;
        this.b = new URL(str);
        this.c = str3;
        this.d = str4;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public URL c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (a(this.a, jVar.a) && a(this.b, jVar.b) && a(this.c, jVar.c)) {
            return a(this.d, jVar.d);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b.hashCode()) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apiFramework", CampaignEx.KEY_OMID);
            jSONObject.put("javascriptResourceUrl", this.b.toString());
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put("vendorKey", this.a);
            }
            if (!TextUtils.isEmpty(this.c)) {
                jSONObject.put("verificationParameters", this.c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                jSONObject.put("verificationNotExecuted", this.d);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static j a(String str, String str2, String str3, String str4, String str5) {
        if (CampaignEx.KEY_OMID.equalsIgnoreCase(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new j(str2, str3, str4, str5);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static j a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("apiFramework");
            String optString2 = jSONObject.optString("javascriptResourceUrl");
            if (CampaignEx.KEY_OMID.equalsIgnoreCase(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    return new j(optString2, jSONObject.optString("vendorKey"), jSONObject.optString("verificationParameters"), jSONObject.optString("verificationNotExecuted"));
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Set<j> a(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            return hashSet;
        }
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                hashSet.add(a(jSONArray.getJSONObject(i)));
                i++;
            } catch (Throwable unused) {
            }
        }
        return hashSet;
    }
}
