package com.mbridge.msdk.video.signal.communication;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.vungle.warren.model.AdvertisementDBAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseVideoCommunication extends AbsFeedBackForH5 implements IVideoCommunication {
    protected IJSFactory d;

    private String a(int i) {
        switch (i) {
            case 1:
                return "sdk_info";
            case 2:
                return MBridgeConstans.PROPERTIES_UNIT_ID;
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return "device";
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof IJSFactory) {
            this.d = (IJSFactory) obj;
        }
    }

    public void init(Object obj, String str) {
        q.b("JS-Video-Brigde", "init");
        try {
            boolean z = false;
            if (this.d != null) {
                String c = this.d.getJSCommon().c();
                if (!TextUtils.isEmpty(c)) {
                    c = Base64.encodeToString(c.getBytes(), 2);
                }
                g.a().a(obj, c);
                this.d.getJSCommon().b(true);
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("showTransparent");
                    int optInt2 = jSONObject.optInt("mute");
                    int optInt3 = jSONObject.optInt("closeType");
                    int optInt4 = jSONObject.optInt("orientationType");
                    int optInt5 = jSONObject.optInt("webfront");
                    int optInt6 = jSONObject.optInt("showAlertRole");
                    c jSCommon = this.d.getJSCommon();
                    if (optInt == 1) {
                        z = true;
                    }
                    jSCommon.a(z);
                    this.d.getJSCommon().b(optInt2);
                    this.d.getJSCommon().c(optInt3);
                    this.d.getJSCommon().d(optInt4);
                    this.d.getJSCommon().e(optInt5);
                    c jSCommon2 = this.d.getJSCommon();
                    if (optInt6 == 0) {
                        optInt6 = 1;
                    }
                    jSCommon2.h(optInt6);
                }
            } else if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a.getObject() instanceof j) {
                    j jVar = (j) aVar.a.getObject();
                    String c2 = jVar.c();
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int optInt7 = jSONObject2.optInt("showTransparent");
                        int optInt8 = jSONObject2.optInt("mute");
                        int optInt9 = jSONObject2.optInt("closeType");
                        int optInt10 = jSONObject2.optInt("orientationType");
                        int optInt11 = jSONObject2.optInt("webfront");
                        int optInt12 = jSONObject2.optInt("showAlertRole");
                        if (optInt7 == 1) {
                            z = true;
                        }
                        jVar.a(z);
                        jVar.b(optInt8);
                        jVar.c(optInt9);
                        jVar.d(optInt10);
                        jVar.e(optInt11);
                        if (optInt12 == 0) {
                            optInt12 = 1;
                        }
                        jVar.h(optInt12);
                        q.b("JS-Video-Brigde", "init jsCommon.setIsShowingTransparent = " + optInt7);
                    }
                    g.a().a(obj, Base64.encodeToString(c2.getBytes(), 2));
                }
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "init error", th);
        }
    }

    public void click(Object obj, String str) {
        int i;
        String str2;
        j jVar;
        q.b("JS-Video-Brigde", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                i = jSONObject.optInt("type");
                str2 = jSONObject.optString("pt");
                if (this.d != null) {
                    this.d.getJSCommon().click(i, str2);
                } else if (obj != null) {
                    a aVar = (a) obj;
                    if ((aVar.a.getObject() instanceof j) && (jVar = (j) aVar.a.getObject()) != null) {
                        jVar.click(i, str2);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            i = 1;
            str2 = "";
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "click error", th);
        }
    }

    public void statistics(Object obj, String str) {
        q.b("JS-Video-Brigde", "statistics,params:" + str);
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.d.getJSCommon().a(jSONObject.optInt("type"), jSONObject.optString(DataSchemeDataSource.SCHEME_DATA));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "statistics error", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        q.b("JS-Video-Brigde", "triggerCloseBtn");
        try {
            if (this.d != null && !TextUtils.isEmpty(str) && new JSONObject(str).optString(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE).equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                this.d.getJSVideoModule().closeVideoOperate(1, -1);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "triggerCloseBtn error", th);
        }
    }

    public void showVideoLocation(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("margin_top", 0);
                int optInt2 = jSONObject.optInt("margin_left", 0);
                int optInt3 = jSONObject.optInt("view_width", 0);
                int optInt4 = jSONObject.optInt("view_height", 0);
                int optInt5 = jSONObject.optInt("radius", 0);
                int optInt6 = jSONObject.optInt("border_top", 0);
                int optInt7 = jSONObject.optInt("border_left", 0);
                int optInt8 = jSONObject.optInt("border_width", 0);
                int optInt9 = jSONObject.optInt("border_height", 0);
                q.b("JS-Video-Brigde", "showVideoLocation,margin_top:" + optInt + ",marginLeft:" + optInt2 + ",viewWidth:" + optInt3 + ",viewHeight:" + optInt4 + ",radius:" + optInt5 + ",borderTop: " + optInt6 + ",borderLeft: " + optInt7 + ",borderWidth: " + optInt8 + ",borderHeight: " + optInt9);
                this.d.getJSVideoModule().showVideoLocation(optInt, optInt2, optInt3, optInt4, optInt5, optInt6, optInt7, optInt8, optInt9);
                this.d.getJSCommon().f();
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "showVideoLocation error", th);
        }
    }

    public void soundOperate(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("mute");
                int optInt2 = jSONObject.optInt("view_visible");
                String optString = jSONObject.optString("pt", "");
                q.b("JS-Video-Brigde", "soundOperate,mute:" + optInt + ",viewVisible:" + optInt2 + ",pt:" + optString);
                if (TextUtils.isEmpty(optString)) {
                    this.d.getJSVideoModule().soundOperate(optInt, optInt2);
                } else {
                    this.d.getJSVideoModule().soundOperate(optInt, optInt2, optString);
                }
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "soundOperate error", th);
        }
    }

    public void videoOperate(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("pause_or_resume");
                q.b("JS-Video-Brigde", "videoOperate,pauseOrResume:" + optInt);
                this.d.getJSVideoModule().videoOperate(optInt);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "videoOperate error", th);
        }
    }

    public void closeVideoOperte(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("close");
                int optInt2 = jSONObject.optInt("view_visible");
                q.b("JS-Video-Brigde", "closeVideoOperte,close:" + optInt + ",viewVisible:" + optInt2);
                this.d.getJSVideoModule().closeVideoOperate(optInt, optInt2);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "closeOperte error", th);
        }
    }

    public void progressOperate(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
                int optInt2 = jSONObject.optInt("view_visible");
                q.b("JS-Video-Brigde", "progressOperate,progress:" + optInt + ",viewVisible:" + optInt2);
                this.d.getJSVideoModule().progressOperate(optInt, optInt2);
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    public void progressBarOperate(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.getJSVideoModule().progressBarOperate(new JSONObject(str).optInt("view_visible"));
                g.a().a(obj, b(0));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    public void getCurrentProgress(Object obj, String str) {
        try {
            if (this.d != null) {
                String currentProgress = this.d.getJSVideoModule().getCurrentProgress();
                q.b("JS-Video-Brigde", "getCurrentProgress:" + currentProgress);
                if (!TextUtils.isEmpty(currentProgress)) {
                    currentProgress = Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                g.a().a(obj, currentProgress);
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "getCurrentProgress error", th);
        }
    }

    public void showVideoClickView(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("type");
                q.b("JS-Video-Brigde", "showVideoClickView,type:" + optInt);
                this.d.getJSContainerModule().showVideoClickView(optInt);
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    public void setScaleFitXY(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("fitxy");
                q.b("JS-Video-Brigde", "setScaleFitXY,type:" + optInt);
                this.d.getJSVideoModule().setScaleFitXY(optInt);
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                q.b("JS-Video-Brigde", "notifyCloseBtn,result:" + optInt);
                this.d.getJSVideoModule().notifyCloseBtn(optInt);
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "notifyCloseBtn", th);
        }
    }

    public void openURL(Object obj, String str) {
        q.d("JS-Video-Brigde", "openURL:" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt("type");
                if (optInt == 1) {
                    b.a(this.a, optString);
                } else if (optInt == 2) {
                    b.b(this.a, optString);
                }
            } catch (JSONException e) {
                q.d("JS-Video-Brigde", e.getMessage());
            } catch (Throwable th) {
                q.d("JS-Video-Brigde", th.getMessage());
            }
        }
    }

    public void showAlertView(Object obj, String str) {
        q.b("JS-Video-Brigde", "showAlertView");
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.d.getJSVideoModule().showIVRewardAlertView(str);
                g.a().a(obj, "showAlertView", "");
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "showAlertView", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                q.b("JS-Video-Brigde", "toggleCloseBtn,result:" + optInt);
                int i = 2;
                if (optInt != 1) {
                    i = optInt == 2 ? 1 : 0;
                }
                this.d.getJSVideoModule().closeVideoOperate(0, i);
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "toggleCloseBtn", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            if (this.d != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                q.b("JS-Video-Brigde", "handlerH5Exception,params:" + str);
                this.d.getJSCommon().handlerH5Exception(jSONObject.optInt("code", -999), jSONObject.optString("message", "h5 error"));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "handlerH5Exception", th);
        }
    }

    public void isSystemResume(Object obj, String str) {
        try {
            if (this.d != null) {
                q.b("JS-Video-Brigde", "isSystemResume,params:" + str);
                g.a().a(obj, b(this.d.getActivityProxy().h()));
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "isSystemResume", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a.getObject() instanceof j) {
                    ((j) aVar.a.getObject()).i(optInt);
                }
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().a((WebView) windVaneWebView, optInt);
                    }
                }
            } catch (Throwable th) {
                q.a("JS-Video-Brigde", "readyStatus", th);
            }
        }
    }

    public void playVideoFinishOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str) && this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("type");
                q.b("JS-Video-Brigde", "playVideoFinishOperate,type: " + optInt);
                this.d.getJSCommon().f(optInt);
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "playVideoFinishOperate error", th);
        }
    }

    private String b(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            q.d("JS-Video-Brigde", "code to string is error");
            return "";
        }
    }

    public void reactDeveloper(Object obj, String str) {
        q.a("JS-Video-Brigde", "reactDeveloper");
        try {
            if (this.d == null || TextUtils.isEmpty(str)) {
                g.a().b(obj, b(1));
            } else {
                this.d.getJSBTModule().reactDeveloper(obj, str);
            }
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "reactDeveloper error " + th);
        }
    }

    public void reportUrls(Object obj, String str) {
        q.a("JS-Video-Brigde", "reportUrls");
        try {
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.video.bt.a.c.a().b(obj, str);
            } else {
                g.a().b(obj, b(1));
            }
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "reportUrls error " + th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().M(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "getFileInfo error", th);
        }
    }

    public void getSDKInfo(Object obj, String str) {
        q.b("JS-Video-Brigde", "getSDKInfo");
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("type");
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                if (this.d != null) {
                    while (i < jSONArray.length()) {
                        int i2 = jSONArray.getInt(i);
                        jSONObject.put(a(i2), this.d.getJSCommon().g(i2));
                        i++;
                    }
                } else if (obj != null) {
                    while (i < jSONArray.length()) {
                        int i3 = jSONArray.getInt(i);
                        a aVar = (a) obj;
                        if (aVar.a.getObject() instanceof j) {
                            jSONObject.put(a(i3), ((j) aVar.a.getObject()).g(i3));
                        }
                        i++;
                    }
                }
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            g.a().b(obj, "params is null");
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "getSDKInfo error", th);
            g.a().b(obj, "exception");
        }
    }

    public void loadads(Object obj, String str) {
        int i;
        int i2;
        String str2;
        String str3;
        q.b("JS-Video-Brigde", "loadads");
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(MBridgeConstans.PLACEMENT_ID);
                String optString2 = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                int optInt = jSONObject.optInt("type", 1);
                if (optInt > 2) {
                    optInt = 1;
                }
                str2 = optString2;
                i = jSONObject.optInt("adtype", 1);
                i2 = optInt;
                str3 = optString;
            } else {
                i2 = 1;
                i = 1;
                str3 = "";
                str2 = str3;
            }
            if (TextUtils.isEmpty(str2)) {
                g.a().a(obj, b(1));
                return;
            }
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a instanceof WindVaneWebView) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(windVaneWebView, str3, str2, i2, i);
                    }
                }
            }
            g.a().a(obj, b(0));
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "loadads error", th);
            g.a().a(obj, b(1));
        }
    }

    private void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Exception e) {
            q.a("JS-Video-Brigde", e.getMessage());
        }
    }

    public void createWebview(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "createWebview error " + th);
        }
    }

    public void createView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "createView error " + th);
        }
    }

    public void createPlayerView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().c(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "createPlayerView error " + th);
        }
    }

    public void createSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().d(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "createSubPlayTemplateView error " + th);
        }
    }

    public void destroyComponent(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().e(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "destroyComponent error " + th);
        }
    }

    public void getComponentOptions(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().f(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "getComponentOptions error " + th);
        }
    }

    public void setViewRect(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().g(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "setViewRect error " + th);
        }
    }

    public void removeFromSuperView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().h(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "removeFromSuperView error " + th);
        }
    }

    public void appendSubView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().i(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    public void appendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().j(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    public void onlyAppendSubView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().k(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    public void onlyAppendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().l(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    public void bringViewToFront(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().m(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "bringViewToFront error " + th);
        }
    }

    public void hideView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().n(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "hideView error " + th);
        }
    }

    public void showView(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().o(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "showView error " + th);
        }
    }

    public void setViewBgColor(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().p(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "setViewBgColor error " + th);
        }
    }

    public void setViewAlpha(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().q(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "setViewAlpha error " + th);
        }
    }

    public void setViewScale(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().r(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "setViewScale error " + th);
        }
    }

    public void insertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    public void insertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    public void onlyInsertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().a(obj, new JSONObject(str), false);
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    public void onlyInsertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().b(obj, new JSONObject(str), false);
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    public void webviewLoad(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().s(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "webviewLoad error " + th);
        }
    }

    public void webviewReload(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().t(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "webviewReload error " + th);
        }
    }

    public void webviewGoBack(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().u(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "webviewGoBack error " + th);
        }
    }

    public void webviewGoForward(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().v(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "webviewGoForward error " + th);
        }
    }

    public void playerPlay(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().w(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerPlay error " + th);
        }
    }

    public void playerPause(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().x(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerPause error " + th);
        }
    }

    public void playerResume(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().y(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerResume error " + th);
        }
    }

    public void playerStop(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().z(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerStop error " + th);
        }
    }

    public void playerUpdateFrame(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().A(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerUpdateFrame error " + th);
        }
    }

    public void playerMute(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().B(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerMute error " + th);
        }
    }

    public void playerUnmute(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().C(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerUnmute error " + th);
        }
    }

    public void playerGetMuteState(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().D(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerGetMuteState error " + th);
        }
    }

    public void playerSetSource(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().E(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerSetSource error " + th);
        }
    }

    public void playerSetRenderType(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().F(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "playerSetRenderType error " + th);
        }
    }

    public void preloadSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            if (this.d != null) {
                com.mbridge.msdk.video.bt.a.c.a().G(obj, new JSONObject(str));
                return;
            }
            a aVar = (a) obj;
            if (aVar.a instanceof WindVaneWebView) {
                WindVaneWebView windVaneWebView = aVar.a;
                if (windVaneWebView.getWebViewListener() != null) {
                    ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj, str);
                    q.a("JS-Video-Brigde", "preloadSubPlayTemplateView: RVWebViewListener");
                    return;
                }
                q.a("JS-Video-Brigde", "preloadSubPlayTemplateView: failed");
            }
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "preloadSubPlayTemplateView error " + th);
        }
    }

    public void closeAd(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().H(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "closeAd error " + th);
        }
    }

    public void broadcast(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().I(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "broadcast error " + th);
        }
    }

    public void closeWeb(Object obj, String str) {
        q.d("JS-Video-Brigde", "type" + str);
        try {
            if (!TextUtils.isEmpty(str) && this.d != null && !TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt("status");
                this.d.getJSContainerModule().hideAlertWebview();
                this.d.getJSVideoModule().hideAlertView(optInt);
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "closeWeb", th);
        }
    }

    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        q.d("JS-Video-Brigde", "ivRewardAdsWithoutVideo ： params" + str);
        try {
            if (!TextUtils.isEmpty(str) && this.d != null && !TextUtils.isEmpty(str)) {
                this.d.getJSContainerModule().ivRewardAdsWithoutVideo(str);
            }
        } catch (Throwable th) {
            q.a("JS-Video-Brigde", "ivRewardAdsWithoutVideo", th);
        }
    }

    public void setSubPlayTemplateInfo(Object obj, String str) {
        q.d("JS-Video-Brigde", "setSubPlayTemplateInfo : " + str);
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().J(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    public void webviewFireEvent(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().K(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().L(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "increaseOfferFrequence error " + th);
        }
    }

    public void handleNativeObject(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.b.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "handleNativeObject error " + th);
        }
    }

    public void loadingResourceStatus(Object obj, String str) {
        a(obj, str);
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().c(windVaneWebView, optInt);
                    }
                }
            } catch (Throwable th) {
                q.d("JS-Video-Brigde", "loadingResourceStatus error " + th);
            }
        }
    }

    public void createNativeEC(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.a.c.a().N(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "createNativeEC error " + th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d A[Catch:{ all -> 0x00b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCacheItem(java.lang.Object r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "setCacheItem error "
            java.lang.String r1 = "JS-Video-Brigde"
            r2 = 1
            r3 = 0
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x004b }
            android.content.Context r4 = r4.g()     // Catch:{ all -> 0x004b }
            java.lang.String r5 = "MBridgeH5CacheSP"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r5, r3)     // Catch:{ all -> 0x004b }
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x004b }
            if (r5 != 0) goto L_0x0047
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x004b }
            r5.<init>(r9)     // Catch:{ all -> 0x004b }
            java.lang.String r9 = "key"
            java.lang.String r9 = r5.getString(r9)     // Catch:{ all -> 0x004b }
            java.lang.String r6 = "value"
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x004b }
            boolean r6 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x004b }
            if (r6 != 0) goto L_0x0042
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x004b }
            if (r6 != 0) goto L_0x0042
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x004b }
            android.content.SharedPreferences$Editor r9 = r4.putString(r9, r5)     // Catch:{ all -> 0x004b }
            r9.apply()     // Catch:{ all -> 0x004b }
        L_0x0042:
            java.lang.String r9 = "Save Success"
            r4 = r9
            r9 = r2
            goto L_0x0074
        L_0x0047:
            java.lang.String r9 = ""
            r4 = r9
            goto L_0x0073
        L_0x004b:
            r9 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.mbridge.msdk.foundation.tools.q.d(r1, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Save Error, reason is : "
            r4.append(r5)
            java.lang.String r9 = r9.getMessage()
            r4.append(r9)
            java.lang.String r4 = r4.toString()
        L_0x0073:
            r9 = r3
        L_0x0074:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x00b3 }
            r5.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r6 = "code"
            if (r9 == 0) goto L_0x007e
            r2 = r3
        L_0x007e:
            r5.put(r6, r2)     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = "message"
            r5.put(r2, r4)     // Catch:{ all -> 0x00b3 }
            r2 = 2
            if (r8 == 0) goto L_0x009f
            if (r9 == 0) goto L_0x009f
            com.mbridge.msdk.mbsignalcommon.windvane.g r9 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00b3 }
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r2)     // Catch:{ all -> 0x00b3 }
            r9.a(r8, r2)     // Catch:{ all -> 0x00b3 }
            goto L_0x00b6
        L_0x009f:
            com.mbridge.msdk.mbsignalcommon.windvane.g r9 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00b3 }
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r2)     // Catch:{ all -> 0x00b3 }
            r9.b(r8, r2)     // Catch:{ all -> 0x00b3 }
            goto L_0x00b6
        L_0x00b3:
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.setCacheItem(java.lang.Object, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071 A[Catch:{ all -> 0x00a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeCacheItem(java.lang.Object r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "removeCacheItem error "
            java.lang.String r1 = "JS-Video-Brigde"
            r2 = 1
            r3 = 0
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x003f }
            android.content.Context r4 = r4.g()     // Catch:{ all -> 0x003f }
            java.lang.String r5 = "MBridgeH5CacheSP"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r5, r3)     // Catch:{ all -> 0x003f }
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x003b
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x003f }
            r5.<init>(r9)     // Catch:{ all -> 0x003f }
            java.lang.String r9 = "key"
            java.lang.String r9 = r5.getString(r9)     // Catch:{ all -> 0x003f }
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x0036
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x003f }
            android.content.SharedPreferences$Editor r9 = r4.remove(r9)     // Catch:{ all -> 0x003f }
            r9.apply()     // Catch:{ all -> 0x003f }
        L_0x0036:
            java.lang.String r9 = "Delete Success"
            r4 = r9
            r9 = r2
            goto L_0x0068
        L_0x003b:
            java.lang.String r9 = ""
            r4 = r9
            goto L_0x0067
        L_0x003f:
            r9 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.mbridge.msdk.foundation.tools.q.d(r1, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Delete Error, reason is : "
            r4.append(r5)
            java.lang.String r9 = r9.getMessage()
            r4.append(r9)
            java.lang.String r4 = r4.toString()
        L_0x0067:
            r9 = r3
        L_0x0068:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x00a7 }
            r5.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r6 = "code"
            if (r9 == 0) goto L_0x0072
            r2 = r3
        L_0x0072:
            r5.put(r6, r2)     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "message"
            r5.put(r2, r4)     // Catch:{ all -> 0x00a7 }
            r2 = 2
            if (r8 == 0) goto L_0x0093
            if (r9 == 0) goto L_0x0093
            com.mbridge.msdk.mbsignalcommon.windvane.g r9 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00a7 }
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r2)     // Catch:{ all -> 0x00a7 }
            r9.a(r8, r2)     // Catch:{ all -> 0x00a7 }
            goto L_0x00aa
        L_0x0093:
            com.mbridge.msdk.mbsignalcommon.windvane.g r9 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00a7 }
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r2)     // Catch:{ all -> 0x00a7 }
            r9.b(r8, r2)     // Catch:{ all -> 0x00a7 }
            goto L_0x00aa
        L_0x00a7:
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.removeCacheItem(java.lang.Object, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081 A[SYNTHETIC, Splitter:B:17:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085 A[Catch:{ all -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c A[Catch:{ all -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getAllCache(java.lang.Object r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r8 = "getAllCache error "
            java.lang.String r0 = "JS-Video-Brigde"
            r1 = 0
            r2 = 0
            com.mbridge.msdk.foundation.controller.a r3 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0044 }
            android.content.Context r3 = r3.g()     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = "MBridgeH5CacheSP"
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r1)     // Catch:{ all -> 0x0044 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            java.util.Map r2 = r3.getAll()     // Catch:{ all -> 0x0042 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0042 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0042 }
        L_0x0025:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x003f
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0042 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0042 }
            java.lang.Object r5 = r3.getKey()     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0042 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0042 }
            r4.put(r5, r3)     // Catch:{ all -> 0x0042 }
            goto L_0x0025
        L_0x003f:
            java.lang.String r2 = "getAllCache Success"
            goto L_0x006e
        L_0x0042:
            r2 = move-exception
            goto L_0x0047
        L_0x0044:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L_0x0047:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r8)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.mbridge.msdk.foundation.tools.q.d(r0, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getAllCache Error, reason is : "
            r3.append(r5)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x006e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x00a1 }
            r3.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r5 = "code"
            r3.put(r5, r1)     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = "message"
            r3.put(r1, r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = "data"
            if (r4 == 0) goto L_0x0085
            r3.put(r1, r4)     // Catch:{ all -> 0x00a1 }
            goto L_0x008a
        L_0x0085:
            java.lang.String r2 = "{}"
            r3.put(r1, r2)     // Catch:{ all -> 0x00a1 }
        L_0x008a:
            if (r7 == 0) goto L_0x00b4
            com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00a1 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x00a1 }
            r3 = 2
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch:{ all -> 0x00a1 }
            r1.a(r7, r2)     // Catch:{ all -> 0x00a1 }
            goto L_0x00b4
        L_0x00a1:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r8)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.mbridge.msdk.foundation.tools.q.d(r0, r7)
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.communication.BaseVideoCommunication.getAllCache(java.lang.Object, java.lang.String):void");
    }

    public void clearAllCache(Object obj, String str) {
        try {
            com.mbridge.msdk.foundation.controller.a.e().g().getSharedPreferences("MBridgeH5CacheSP", 0).edit().clear().apply();
            if (obj != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "getAllCache error " + th);
        }
    }

    public void getCutout(Object obj, String str) {
        try {
            String i = this.d.getJSCommon().i();
            q.d("JS-Video-Brigde", i);
            if (obj == null || TextUtils.isEmpty(i)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "No notch data, plz try again later.");
                g.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            g.a().a(obj, Base64.encodeToString(i.getBytes(), 2));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "getCutout error : " + th.getMessage());
        }
    }

    public void cai(Object obj, String str) {
        q.a("JS-Video-Brigde", "cai:" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(optString)) {
                    com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "packageName is empty");
                }
                int i = u.c(com.mbridge.msdk.foundation.controller.a.e().g(), optString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.b.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, i);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, e.getMessage());
                    q.a("JS-Video-Brigde", e.getMessage());
                }
            } catch (JSONException e2) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + e2.getLocalizedMessage());
                q.a("JS-Video-Brigde", "cai", e2);
            } catch (Throwable th) {
                com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "exception: " + th.getLocalizedMessage());
                q.a("JS-Video-Brigde", "cai", th);
            }
        }
    }

    public void getAppSetting(Object obj, String str) {
        JSONObject jSONObject;
        try {
            String optString = new JSONObject(str).optString("appid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(optString)) {
                String c = com.mbridge.msdk.b.b.a().c(optString);
                if (TextUtils.isEmpty(c)) {
                    jSONObject = new JSONObject(com.mbridge.msdk.b.b.a().b().al());
                } else {
                    jSONObject = new JSONObject(c);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get App Setting error, plz try again later.");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get App Setting error, because must give a appId.");
            }
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "getAppSetting error : " + th.getMessage());
        }
    }

    public void getRewardSetting(Object obj, String str) {
        try {
            JSONObject j = com.mbridge.msdk.videocommon.d.b.a().b().j();
            JSONObject jSONObject = new JSONObject();
            if (obj == null || j == null) {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Get Reward Setting error, plz try again later.");
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, j);
            }
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "getRewardSetting error : " + th.getMessage());
        }
    }

    public void getRewardUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid", "");
            String optString2 = jSONObject.optString("unitid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject D = com.mbridge.msdk.videocommon.d.b.a().a(optString, optString2).D();
                    if (obj == null || D == null) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put("message", "Get Reward Unit Setting error, plz try again later.");
                    } else {
                        jSONObject2.put("code", 0);
                        jSONObject2.put("message", "Success");
                        jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, D);
                    }
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                }
            }
            jSONObject2.put("code", 1);
            jSONObject2.put("message", "Get reward unit Setting error, because must give appId and unitId.");
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "getRewardUnitSetting error : " + th.getMessage());
        }
    }

    public void getUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "Get Unit Setting error, RV/IV can not support this method.");
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "getUnitSetting error : " + th.getMessage());
        }
    }

    public void getEncryptPrice(Object obj, String str) {
        String str2;
        String str3 = "not replaced";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int i = 1;
            if (TextUtils.isEmpty(str)) {
                str2 = "params is null";
            } else {
                JSONObject jSONObject3 = new JSONObject(str);
                String optString = jSONObject3.optString("unitid", "");
                String optString2 = jSONObject3.optString("requestId", "");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    str2 = "params parsing exception";
                } else {
                    com.mbridge.msdk.foundation.entity.c c = d.c(optString, optString2);
                    if (c != null && c.d() == 1) {
                        str3 = "success";
                        jSONObject2.put("encrypt_p", c.b());
                        jSONObject2.put(CampaignUnit.KEY_IRLFA, 1);
                        i = 0;
                    }
                    str2 = str3;
                }
            }
            jSONObject.put("code", i);
            jSONObject.put("message", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            q.d("JS-Video-Brigde", "getEncryptPrice error : " + th.getMessage());
        }
    }
}
