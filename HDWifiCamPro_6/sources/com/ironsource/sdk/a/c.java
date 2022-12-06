package com.ironsource.sdk.a;

import android.util.Base64;
import com.ironsource.a.d;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements d {
    public final String a(Map<String, Object> map) {
        try {
            return String.format("%s=%s", new Object[]{DataSchemeDataSource.SCHEME_DATA, Base64.encodeToString(new JSONObject().put("table", "supersonic.adunitanalytics.ad_unit_events").put(DataSchemeDataSource.SCHEME_DATA, new JSONObject(map)).toString().getBytes(), 2)});
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
