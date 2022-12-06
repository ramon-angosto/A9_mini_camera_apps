package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.vungle.warren.model.AdvertisementDBAdapter;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseRewardSignalH5 implements IRewardCommunication {
    protected IJSFactory a;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        if (context instanceof IJSFactory) {
            this.a = (IJSFactory) context;
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        if (obj instanceof IJSFactory) {
            this.a = (IJSFactory) obj;
        }
    }

    public void getEndScreenInfo(Object obj, String str) {
        String str2;
        try {
            if (this.a != null) {
                String a2 = this.a.getIJSRewardVideoV1().a();
                if (!TextUtils.isEmpty(a2)) {
                    str2 = Base64.encodeToString(a2.getBytes(), 2);
                    q.a("JS-Reward-Communication", "getEndScreenInfo success");
                } else {
                    str2 = "";
                    q.a("JS-Reward-Communication", "getEndScreenInfo failed");
                }
                g.a().a(obj, str2);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Communication", "getEndScreenInfo", th);
        }
    }

    public void install(Object obj, String str) {
        try {
            if (this.a != null) {
                q.a("JS-Reward-Communication", "install:" + str);
                if (this.a.getJSContainerModule().endCardShowing()) {
                    this.a.getJSCommon().click(3, str);
                } else {
                    this.a.getJSCommon().click(1, str);
                }
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Communication", "install", th);
        }
    }

    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        q.d("JS-Reward-Communication", "openURL:" + str);
        Context g = a.e().g();
        if (!TextUtils.isEmpty(str)) {
            if (g == null) {
                try {
                    if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) != null) {
                        g = windVaneWebView.getContext();
                    }
                } catch (Exception e) {
                    q.d("JS-Reward-Communication", e.getMessage());
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
                    q.d("JS-Reward-Communication", e2.getMessage());
                } catch (Throwable th) {
                    q.d("JS-Reward-Communication", th.getMessage());
                }
            }
        }
    }

    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                q.a("JS-Reward-Communication", "notifyCloseBtn,state:" + str);
                this.a.getIJSRewardVideoV1().notifyCloseBtn(optInt);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Communication", "notifyCloseBtn", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                q.a("JS-Reward-Communication", "toggleCloseBtn,state:" + str);
                this.a.getIJSRewardVideoV1().toggleCloseBtn(optInt);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Communication", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                g.a().a(obj, a(0));
                this.a.getIJSRewardVideoV1().a(new JSONObject(str).optString(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE));
                q.a("JS-Reward-Communication", "triggerCloseBtn,state:" + str);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Communication", "triggerCloseBtn", th);
            g.a().a(obj, a(-1));
        }
    }

    public void setOrientation(Object obj, String str) {
        try {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                q.a("JS-Reward-Communication", "setOrientation,state:" + str);
                this.a.getIJSRewardVideoV1().b(optString);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Communication", "setOrientation", th);
        }
    }

    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(NotificationCompat.CATEGORY_MESSAGE);
                q.a("JS-Reward-Communication", "handlerPlayableException,msg:" + str);
                this.a.getIJSRewardVideoV1().c(optString);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Communication", "setOrientation", th);
        }
    }

    private String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            q.d("JS-Reward-Communication", "code to string is error");
            return "";
        }
    }

    public void cai(Object obj, String str) {
        q.a("JS-Reward-Communication", "cai:" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(optString)) {
                    com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "packageName is empty");
                }
                int i = u.c(a.e().g(), optString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.b.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, i);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, e.getMessage());
                    q.a("JS-Reward-Communication", e.getMessage());
                }
            } catch (JSONException e2) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + e2.getLocalizedMessage());
                q.a("JS-Reward-Communication", "cai", e2);
            } catch (Throwable th) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + th.getLocalizedMessage());
                q.a("JS-Reward-Communication", "cai", th);
            }
        }
    }
}
