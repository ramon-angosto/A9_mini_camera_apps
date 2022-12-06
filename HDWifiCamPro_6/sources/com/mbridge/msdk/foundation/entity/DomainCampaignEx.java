package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class DomainCampaignEx extends Campaign implements NoProGuard, Serializable {
    private static final String JSON_KEY_AD_TRACKING_DLE = "D+S8+FxXJFPsYFc3+F5/Hv==";
    private static final String JSON_KEY_AD_TRACKING_DLS = "D+S8+FxXJFPsYFc3+bfTD+zT";
    private static final String JSON_KEY_AD_TRACKING_I = "D+S8+FQ/hbxtY7M=";
    private static String TAG = "DomainCampaignEx";

    public static JSONObject campaignToJsonObject(JSONObject jSONObject, CampaignEx campaignEx) throws JSONException {
        return jSONObject;
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, CampaignEx campaignEx) {
        return campaignEx;
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject, CampaignEx campaignEx) {
        return campaignEx;
    }

    public boolean needShowIDialog(CampaignEx campaignEx) {
        return false;
    }

    public static i trackingStr2Object(JSONObject jSONObject, i iVar) {
        if (jSONObject == null || iVar == null) {
            return null;
        }
        try {
            iVar.t(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(l.b(JSON_KEY_AD_TRACKING_DLS))));
            iVar.u(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(l.b(JSON_KEY_AD_TRACKING_DLE))));
            iVar.v(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(l.b(JSON_KEY_AD_TRACKING_I))));
        } catch (Exception unused) {
        }
        return iVar;
    }

    protected static String replaceValueByKey(CampaignUnit campaignUnit, CampaignEx campaignEx, String str) {
        if (!(campaignUnit == null || TextUtils.isEmpty(str) || campaignEx == null)) {
            try {
                HashMap<String, String> rks = campaignUnit.getRks();
                if (rks != null) {
                    rks.entrySet().iterator();
                    for (Map.Entry next : rks.entrySet()) {
                        str = str.replaceAll("\\{" + ((String) next.getKey()) + "\\}", (String) next.getValue());
                    }
                }
                HashMap<String, String> aks = campaignEx.getAks();
                if (aks != null) {
                    aks.entrySet().iterator();
                    for (Map.Entry next2 : aks.entrySet()) {
                        str = str.replaceAll("\\{" + ((String) next2.getKey()) + "\\}", (String) next2.getValue());
                    }
                }
                HashMap<String, String> epMap = campaignUnit.getEpMap();
                if (epMap != null) {
                    for (Map.Entry next3 : epMap.entrySet()) {
                        str = str.replaceAll("\\{" + ((String) next3.getKey()) + "\\}", (String) next3.getValue());
                    }
                }
                str = str.replaceAll("\\{c\\}", URLEncoder.encode(campaignUnit.assembCParams(), "utf-8"));
                Matcher matcher = Pattern.compile("=\\{.*?\\}").matcher(str);
                while (matcher.find()) {
                    str = str.replace(matcher.group(0), "=");
                }
            } catch (Throwable th) {
                q.a(TAG, th.getMessage(), th);
            }
        }
        return str;
    }
}
