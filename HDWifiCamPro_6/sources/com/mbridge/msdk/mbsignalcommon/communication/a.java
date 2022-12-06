package com.mbridge.msdk.mbsignalcommon.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommonBannerSignalCommunicationImp */
public abstract class a implements c {
    public static final String a = a.class.getSimpleName();

    public void f(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a);
            }
        } catch (Throwable th) {
            q.a(a, "onSignalCommunication", th);
        }
    }

    public void c(Object obj, String str) {
        String str2 = a;
        q.a(str2, "readyStatus: " + str);
    }

    public void a(Object obj, String str) {
        String str2 = a;
        q.a(str2, "init: " + str);
    }

    public void b(Object obj, String str) {
        String str2 = a;
        q.a(str2, "click: " + str);
    }

    public void d(Object obj, String str) {
        String str2 = a;
        q.a(str2, "toggleCloseBtn: " + str);
    }

    public void e(Object obj, String str) {
        String str2 = a;
        q.a(str2, "triggerCloseBtn: " + str);
    }

    public void i(Object obj, String str) {
        String str2 = a;
        q.a(str2, "sendImpressions: " + str);
    }

    public final void k(Object obj, String str) {
        q.a(a, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), (CampaignEx) null, "", jSONObject.optString("url"), false, jSONObject.optInt("type") != 0);
                }
                g.a().a(obj, b.a(0));
            } catch (Throwable th) {
                q.a(a, "reportUrls", th);
            }
        }
    }

    public final void l(Object obj, String str) {
        String str2 = a;
        q.a(str2, "increaseOfferFrequence:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                b.a(obj, new JSONObject(str));
            } catch (Throwable th) {
                q.a(a, "increaseOfferFrequence", th);
            }
        }
    }

    public void h(Object obj, String str) {
        String str2 = a;
        q.a(str2, "resetCountdown: " + str);
    }

    public final void m(Object obj, String str) {
        String str2 = a;
        q.a(str2, "handlerH5Exception: " + str);
    }

    public void g(Object obj, String str) {
        String str2 = a;
        q.a(str2, "install: " + str);
    }

    public final void n(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = a;
        q.d(str2, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
            return;
        }
        Context g = com.mbridge.msdk.foundation.controller.a.e().g();
        if (!TextUtils.isEmpty(str)) {
            if (g == null) {
                try {
                    if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) != null) {
                        g = windVaneWebView.getContext();
                    }
                } catch (Exception e) {
                    q.d(a, e.getMessage());
                }
            }
            if (g != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("url");
                    int optInt = jSONObject.optInt("type");
                    if (optInt == 1) {
                        b.a(g, optString);
                    } else if (optInt == 2) {
                        b.b(g, optString);
                    }
                } catch (JSONException e2) {
                    q.d(a, e2.getMessage());
                } catch (Throwable th) {
                    q.d(a, th.getMessage());
                }
            }
        }
    }

    public final void o(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = a;
        q.d(str2, "getNetstat:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
            return;
        }
        Context g = com.mbridge.msdk.foundation.controller.a.e().g();
        if (!TextUtils.isEmpty(str)) {
            if (g == null) {
                try {
                    if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) != null) {
                        g = windVaneWebView.getContext();
                    }
                } catch (Exception e) {
                    q.d(a, e.getMessage());
                }
            }
            if (g == null) {
                g.a().a(obj, b.a(1));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", m.n(g));
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    jSONObject2 = Base64.encodeToString(jSONObject2.getBytes(), 2);
                }
                g.a().a(obj, jSONObject2);
            } catch (Throwable th) {
                q.d(a, th.getMessage());
                g.a().a(obj, b.a(1));
            }
        }
    }

    public void j(Object obj, String str) {
        String str2 = a;
        q.a(str2, "getFileInfo:" + str);
    }
}
