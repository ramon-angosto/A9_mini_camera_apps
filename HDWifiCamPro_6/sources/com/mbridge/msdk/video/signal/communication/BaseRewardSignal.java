package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.communication.b;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.signal.a.j;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseRewardSignal extends AbsFeedBackForH5 implements IRewardCommunication {
    protected IRewardCommunication d;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        boolean z;
        super.initialize(context, windVaneWebView);
        try {
            z = Class.forName("com.mbridge.msdk.video.signal.factory.IJSFactory").isInstance(context);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            try {
                Class<?> cls = Class.forName("com.mbridge.msdk.video.signal.communication.BaseRewardSignalH5");
                this.d = (IRewardCommunication) cls.newInstance();
                cls.getMethod("initialize", new Class[]{Context.class, WindVaneWebView.class}).invoke(this.d, new Object[]{context, windVaneWebView});
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IRewardCommunication)) {
            this.d = (IRewardCommunication) windVaneWebView.getObject();
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        boolean z;
        super.initialize(obj, windVaneWebView);
        try {
            z = Class.forName("com.mbridge.msdk.video.signal.factory.IJSFactory").isInstance(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        if (z) {
            try {
                Class<?> cls = Class.forName("com.mbridge.msdk.video.signal.communication.BaseRewardSignalH5");
                this.d = (IRewardCommunication) cls.newInstance();
                cls.getMethod("initialize", new Class[]{Object.class, WindVaneWebView.class}).invoke(this.d, new Object[]{obj, windVaneWebView});
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IRewardCommunication)) {
            this.d = (IRewardCommunication) windVaneWebView.getObject();
        }
    }

    public void getEndScreenInfo(Object obj, String str) {
        try {
            if (this.d != null) {
                this.d.getEndScreenInfo(obj, str);
                q.d("JS-Reward-Brigde", "getEndScreenInfo factory is true");
                return;
            }
            q.d("JS-Reward-Brigde", "getEndScreenInfo factory is null");
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a instanceof WindVaneWebView) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj);
                    }
                }
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Brigde", "getEndScreenInfo", th);
        }
    }

    public void install(Object obj, String str) {
        try {
            if (this.d != null) {
                this.d.install(obj, str);
            } else if (!TextUtils.isEmpty(str)) {
                if (obj != null) {
                    a aVar = (a) obj;
                    if (aVar.a.getObject() instanceof j) {
                        ((j) aVar.a.getObject()).click(1, str);
                        q.d("JS-Reward-Brigde", "JSCommon install jump success");
                    }
                }
                q.d("JS-Reward-Brigde", "JSCommon install failed");
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Brigde", "install", th);
        }
    }

    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.notifyCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Brigde", "notifyCloseBtn", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.toggleCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Brigde", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.triggerCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Brigde", "triggerCloseBtn", th);
            g.a().a(obj, a(-1));
        }
    }

    public void setOrientation(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.setOrientation(obj, str);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Brigde", "setOrientation", th);
        }
    }

    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.handlerPlayableException(obj, str);
            }
        } catch (Throwable th) {
            q.a("JS-Reward-Brigde", "handlerPlayableException", th);
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
            q.d("JS-Reward-Brigde", "code to string is error");
            return "";
        }
    }

    public void openURL(Object obj, String str) {
        q.d("JS-Reward-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt("type");
                if (optInt == 1) {
                    com.mbridge.msdk.click.b.a(this.a, optString);
                } else if (optInt == 2) {
                    com.mbridge.msdk.click.b.b(this.a, optString);
                }
            } catch (JSONException e) {
                q.d("JS-Reward-Brigde", e.getMessage());
            } catch (Throwable th) {
                q.d("JS-Reward-Brigde", th.getMessage());
            }
        }
    }

    public void cai(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(optString)) {
                    b.a(obj, "packageName is empty");
                }
                int i = u.c(com.mbridge.msdk.foundation.controller.a.e().g(), optString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", b.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, i);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    b.a(obj, e.getMessage());
                    q.a("JS-Reward-Brigde", e.getMessage());
                }
            } catch (JSONException e2) {
                b.a(obj, "exception: " + e2.getLocalizedMessage());
                q.a("JS-Reward-Brigde", "cai", e2);
            } catch (Throwable th) {
                b.a(obj, "exception: " + th.getLocalizedMessage());
                q.a("JS-Reward-Brigde", "cai", th);
            }
        }
    }
}
