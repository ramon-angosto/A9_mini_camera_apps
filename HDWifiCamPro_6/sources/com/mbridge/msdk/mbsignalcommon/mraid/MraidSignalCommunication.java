package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.mraid.a;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import org.json.JSONObject;

public class MraidSignalCommunication extends AbsFeedBackForH5 {
    private b d;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.d = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.d = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() != null && (windVaneWebView.getMraidObject() instanceof b)) {
                this.d = (b) windVaneWebView.getMraidObject();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        if (obj instanceof a) {
            a.C0071a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "open");
        }
        try {
            String optString = new JSONObject(str).optString("url");
            q.d("MraidSignalCommunication", "MRAID Open " + optString);
            if (this.d != null && !TextUtils.isEmpty(optString)) {
                this.d.open(optString);
            }
        } catch (Throwable th) {
            q.a("MraidSignalCommunication", "MRAID Open", th);
        }
    }

    public void close(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0071a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "close");
        }
        try {
            q.d("MraidSignalCommunication", "MRAID close");
            if (this.d != null) {
                this.d.close();
            }
        } catch (Throwable th) {
            q.a("MraidSignalCommunication", "MRAID close", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0071a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "unload");
        }
        try {
            q.d("MraidSignalCommunication", "MRAID unload");
            if (this.d != null) {
                this.d.unload();
            }
        } catch (Throwable th) {
            q.a("MraidSignalCommunication", "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0071a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "useCustomClose");
        }
        try {
            String optString = new JSONObject(str).optString("shouldUseCustomClose");
            q.d("MraidSignalCommunication", "MRAID useCustomClose " + optString);
            if (!TextUtils.isEmpty(optString) && this.d != null) {
                this.d.useCustomClose(optString.toLowerCase().equals("true"));
            }
        } catch (Throwable th) {
            q.a("MraidSignalCommunication", "MRAID useCustomClose", th);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0071a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("shouldUseCustomClose");
            q.d("MraidSignalCommunication", "MRAID expand " + optString + " " + optString2);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && this.d != null) {
                this.d.expand(optString, optString2.toLowerCase().equals("true"));
            }
        } catch (Throwable th) {
            q.a("MraidSignalCommunication", "MRAID expand", th);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0071a.a.a((WebView) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("allowOrientationChange");
            String optString2 = jSONObject.optString("forceOrientation");
            q.d("MraidSignalCommunication", "MRAID setOrientationProperties");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && this.d != null) {
                optString.toLowerCase().equals("true");
                String lowerCase = optString2.toLowerCase();
                int hashCode = lowerCase.hashCode();
                if (hashCode != 729267099) {
                    if (hashCode == 1430647483) {
                        if (!lowerCase.equals("landscape")) {
                        }
                    }
                } else if (!lowerCase.equals("portrait")) {
                }
            }
        } catch (Throwable th) {
            q.a("MraidSignalCommunication", "MRAID setOrientationProperties", th);
        }
    }
}
