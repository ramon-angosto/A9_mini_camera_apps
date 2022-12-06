package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import org.json.JSONException;
import org.json.JSONObject;

public class WebGLCheckSignal extends AbsFeedBackForH5 {
    public void webglState(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a.e().c(jSONObject.optInt("webgl"));
            a.e().a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
