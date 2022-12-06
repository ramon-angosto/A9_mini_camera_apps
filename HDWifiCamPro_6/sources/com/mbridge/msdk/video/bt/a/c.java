package com.mbridge.msdk.video.bt.a;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.h;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.module.BTBaseView;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC;
import com.mbridge.msdk.video.bt.module.MBridgeBTVideoView;
import com.mbridge.msdk.video.bt.module.MBridgeBTWebView;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OperateViews */
public final class c {
    private static ConcurrentHashMap<String, LinkedHashMap<String, View>> a = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static LinkedHashMap<String, String> b = new LinkedHashMap<>();
    private static LinkedHashMap<String, CampaignEx> c = new LinkedHashMap<>();
    private static LinkedHashMap<String, com.mbridge.msdk.videocommon.d.c> d = new LinkedHashMap<>();
    private static LinkedHashMap<String, String> e = new LinkedHashMap<>();
    private static LinkedHashMap<String, Integer> f = new LinkedHashMap<>();
    private static volatile int g = 10000;
    private static int h = 0;
    private static int i = 1;
    private static String j = "";
    private static int k;
    private static int l;
    private static int m;
    private static int n;
    private static int o;

    /* compiled from: OperateViews */
    private static class a {
        /* access modifiers changed from: private */
        public static c a = new c();
    }

    private c() {
    }

    public static c a() {
        return a.a;
    }

    public final String b() {
        g++;
        return String.valueOf(g);
    }

    public final CampaignEx a(String str) {
        if (c.containsKey(str)) {
            return c.get(str);
        }
        return null;
    }

    private String g(String str) {
        return b.containsKey(str) ? b.get(str) : "";
    }

    public final void a(String str, String str2) {
        b.put(str, str2);
    }

    public final com.mbridge.msdk.videocommon.d.c b(String str) {
        if (d.containsKey(str)) {
            return d.get(str);
        }
        return null;
    }

    public final String c(String str) {
        return e.containsKey(str) ? e.get(str) : "";
    }

    public final void a(String str, int i2) {
        f.put(str, Integer.valueOf(i2));
    }

    public final int d(String str) {
        if (f.containsKey(str)) {
            return f.get(str).intValue();
        }
        return 2;
    }

    public final void e(String str) {
        if (e.containsKey(str)) {
            e.remove(str);
        }
        if (d.containsKey(str)) {
            d.remove(str);
        }
        if (c.containsKey(str)) {
            c.remove(str);
        }
        if (b.containsKey(str)) {
            b.remove(str);
        }
    }

    public final void f(String str) {
        if (f.containsKey(str)) {
            f.remove(str);
        }
    }

    public final synchronized LinkedHashMap<String, View> b(String str, String str2) {
        ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(str + "_" + str2)) {
            ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap2 = a;
            return concurrentHashMap2.get(str + "_" + str2);
        }
        LinkedHashMap<String, View> linkedHashMap = new LinkedHashMap<>();
        ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap3 = a;
        concurrentHashMap3.put(str + "_" + str2, linkedHashMap);
        return linkedHashMap;
    }

    private void c(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            q.a("OperateViews", e2.getMessage());
        }
    }

    public final void a(WebView webView, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(webView, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            q.a("OperateViews", e2.getMessage());
        }
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", h);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            c(obj, e2.getMessage());
            q.a("OperateViews", e2.getMessage());
        }
    }

    private void a(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", h);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(obj, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            c(obj, e2.getMessage());
            q.a("OperateViews", e2.getMessage());
        }
    }

    public final void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", h);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            a(webView, e2.getMessage());
            q.a("OperateViews", e2.getMessage());
        }
    }

    public final void a(Object obj, JSONObject jSONObject) {
        final int i2;
        final int i3;
        final Rect rect;
        try {
            final String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (TextUtils.isEmpty(optString)) {
                c(obj, "unitId is empty");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            int optInt = optJSONObject.optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY, 0);
            optJSONObject.optString("fileURL");
            optJSONObject.optString("filePath");
            optJSONObject.optString("html");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (optJSONObject2 != null) {
                Rect rect3 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                int optInt2 = optJSONObject2.optInt("width");
                i2 = optJSONObject2.optInt("height");
                rect = rect3;
                i3 = optInt2;
            } else {
                i3 = 0;
                i2 = 0;
                rect = rect2;
            }
            final Object obj2 = obj;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    String str;
                    WindVaneWebView windVaneWebView;
                    com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj2;
                    if (aVar.a != null) {
                        windVaneWebView = aVar.a;
                        str = windVaneWebView.getRid();
                    } else {
                        str = "";
                        windVaneWebView = null;
                    }
                    LinkedHashMap<String, View> b2 = c.this.b(optString, str);
                    String b3 = c.this.b();
                    c.b.put(b3, str);
                    MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.a.e().g());
                    b2.put(b3, mBridgeBTLayout);
                    mBridgeBTLayout.setInstanceId(b3);
                    mBridgeBTLayout.setUnitId(optString);
                    mBridgeBTLayout.setWebView(windVaneWebView);
                    mBridgeBTLayout.setRect(rect);
                    if (i3 > 0 || i2 > 0) {
                        mBridgeBTLayout.setLayout(i3, i2);
                    }
                    c.this.a(obj2, b3);
                    q.a("OperateViews", "create view instanceId = " + b3);
                }
            }, (long) optInt);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "create view failed：" + th.getMessage());
        }
    }

    public final void b(Object obj, JSONObject jSONObject) {
        final int i2;
        final int i3;
        final Rect rect;
        try {
            final String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (TextUtils.isEmpty(optString)) {
                c(obj, "unitId is empty");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            int optInt = optJSONObject.optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY, 0);
            final String optString2 = optJSONObject.optString("fileURL");
            final String optString3 = optJSONObject.optString("filePath");
            final String optString4 = optJSONObject.optString("html");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (optJSONObject2 != null) {
                Rect rect3 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                int optInt2 = optJSONObject2.optInt("width");
                i2 = optJSONObject2.optInt("height");
                rect = rect3;
                i3 = optInt2;
            } else {
                i3 = 0;
                i2 = 0;
                rect = rect2;
            }
            final Object obj2 = obj;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    String str;
                    WindVaneWebView windVaneWebView;
                    com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj2;
                    if (aVar.a != null) {
                        windVaneWebView = aVar.a;
                        str = windVaneWebView.getRid();
                    } else {
                        str = "";
                        windVaneWebView = null;
                    }
                    LinkedHashMap<String, View> b2 = c.this.b(optString, str);
                    String b3 = c.this.b();
                    c.b.put(b3, str);
                    MBridgeBTWebView mBridgeBTWebView = new MBridgeBTWebView(com.mbridge.msdk.foundation.controller.a.e().g());
                    b2.put(b3, mBridgeBTWebView);
                    mBridgeBTWebView.setInstanceId(b3);
                    mBridgeBTWebView.setUnitId(optString);
                    mBridgeBTWebView.setFileURL(optString2);
                    mBridgeBTWebView.setFilePath(optString3);
                    mBridgeBTWebView.setHtml(optString4);
                    mBridgeBTWebView.setRect(rect);
                    mBridgeBTWebView.setWebViewRid(str);
                    mBridgeBTWebView.setCreateWebView(windVaneWebView);
                    if (i3 > 0 || i2 > 0) {
                        mBridgeBTWebView.setLayout(i3, i2);
                    }
                    mBridgeBTWebView.preload();
                    c.this.a(obj2, b3);
                    q.a("OperateViews", "createWebview instanceId = " + b3);
                }
            }, (long) optInt);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "createWebview failed：" + th.getMessage());
        }
    }

    public final void c(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String str = "";
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                    if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                        str = parseCampaignWithBackData.getRequestId();
                    }
                    int optInt = optJSONObject.optInt("show_time", 0);
                    int optInt2 = optJSONObject.optInt("show_mute", 0);
                    int optInt3 = optJSONObject.optInt("show_close", 0);
                    int optInt4 = optJSONObject.optInt("orientation", 1);
                    int optInt5 = optJSONObject.optInt("show_pgb", 0);
                    MBridgeBTVideoView mBridgeBTVideoView = new MBridgeBTVideoView(com.mbridge.msdk.foundation.controller.a.e().g());
                    mBridgeBTVideoView.setCampaign(parseCampaignWithBackData);
                    mBridgeBTVideoView.setUnitId(optString);
                    mBridgeBTVideoView.setShowMute(optInt2);
                    mBridgeBTVideoView.setShowTime(optInt);
                    mBridgeBTVideoView.setShowClose(optInt3);
                    mBridgeBTVideoView.setOrientation(optInt4);
                    mBridgeBTVideoView.setProgressBarState(optInt5);
                    com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                    if (aVar.a != null) {
                        WindVaneWebView windVaneWebView = aVar.a;
                        str = windVaneWebView.getRid();
                        mBridgeBTVideoView.setCreateWebView(windVaneWebView);
                    }
                    LinkedHashMap<String, View> b2 = b(optString, str);
                    String b3 = b();
                    b.put(b3, str);
                    mBridgeBTVideoView.setInstanceId(b3);
                    b2.put(b3, mBridgeBTVideoView);
                    mBridgeBTVideoView.preLoadData();
                    if (parseCampaignWithBackData == null) {
                        c(obj, "campaign is null");
                        q.a("OperateViews", "createPlayerView failed");
                    } else {
                        a(obj, b3);
                        q.a("OperateViews", "createPlayerView instanceId = " + b3);
                    }
                    a.a().a(b3, mBridgeBTVideoView);
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "createPlayerView failed：" + th.getMessage());
        }
    }

    public final void d(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    int optInt = optJSONObject.optInt("mute");
                    String str = "";
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                    if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                        str = parseCampaignWithBackData.getRequestId();
                    }
                    com.mbridge.msdk.videocommon.d.c a2 = com.mbridge.msdk.videocommon.d.c.a(optJSONObject.optJSONObject("unitSetting"));
                    if (a2 != null) {
                        a2.a(optString);
                    }
                    String optString2 = optJSONObject.optString("userId");
                    if (TextUtils.isEmpty(str)) {
                        com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                        if (aVar.a != null) {
                            str = aVar.a.getRid();
                        }
                    }
                    LinkedHashMap<String, View> b2 = b(optString, str);
                    String b3 = b();
                    b.put(b3, str);
                    MBTempContainer mBTempContainer = new MBTempContainer(com.mbridge.msdk.foundation.controller.a.e().g());
                    mBTempContainer.setInstanceId(b3);
                    mBTempContainer.setUnitId(optString);
                    mBTempContainer.setCampaign(parseCampaignWithBackData);
                    mBTempContainer.setRewardUnitSetting(a2);
                    mBTempContainer.setBigOffer(true);
                    if (!TextUtils.isEmpty(optString2)) {
                        mBTempContainer.setUserId(optString2);
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
                    if (optJSONObject2 != null) {
                        String optString3 = optJSONObject2.optString("id");
                        com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(optJSONObject2.optString("name"), optJSONObject2.optInt(RewardPlus.AMOUNT));
                        if (!TextUtils.isEmpty(optString3)) {
                            mBTempContainer.setRewardId(optString3);
                        }
                        if (!TextUtils.isEmpty(cVar.a())) {
                            mBTempContainer.setReward(cVar);
                        }
                    }
                    String optString4 = optJSONObject.optString("extra");
                    if (!TextUtils.isEmpty(optString4)) {
                        mBTempContainer.setDeveloperExtraData(optString4);
                    }
                    mBTempContainer.setMute(optInt);
                    b2.put(b3, mBTempContainer);
                    e.put(b3, optString);
                    c.put(b3, parseCampaignWithBackData);
                    d.put(b3, a2);
                    a(obj, b3);
                    q.a("OperateViews", "createSubPlayTemplateView instanceId = " + b3);
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "createSubPlayTemplateView failed：" + th.getMessage());
        }
    }

    public final void e(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String g2 = g(optString2);
                    if (TextUtils.isEmpty(g2)) {
                        com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                        if (aVar.a != null) {
                            g2 = aVar.a.getRid();
                        }
                    }
                    LinkedHashMap<String, View> b2 = b(optString, g2);
                    if (b2 == null || !b2.containsKey(optString2)) {
                        c(obj, "unitId or instanceId not exist");
                        q.a("OperateViews", "destroyComponent failed");
                        return;
                    }
                    View view = b2.get(optString2);
                    b2.remove(optString2);
                    if (!(view == null || view.getParent() == null)) {
                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(view);
                        }
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) view;
                            if (viewGroup2.getChildCount() > 0) {
                                int childCount = viewGroup2.getChildCount();
                                for (int i2 = 0; i2 < childCount; i2++) {
                                    View childAt = viewGroup2.getChildAt(i2);
                                    if (childAt instanceof MBridgeBTWebView) {
                                        b2.remove(((MBridgeBTWebView) childAt).getInstanceId());
                                        ((MBridgeBTWebView) childAt).onDestory();
                                    } else if (childAt instanceof MBridgeBTVideoView) {
                                        b2.remove(((MBridgeBTVideoView) childAt).getInstanceId());
                                        ((MBridgeBTVideoView) childAt).onDestory();
                                    } else if (childAt instanceof MBTempContainer) {
                                        b2.remove(((MBTempContainer) childAt).getInstanceId());
                                        ((MBTempContainer) childAt).onDestroy();
                                    }
                                }
                            }
                        }
                    }
                    if (view instanceof MBTempContainer) {
                        ((MBTempContainer) view).onDestroy();
                    }
                    if (view instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) view).onDestory();
                    }
                    if (view instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) view).onDestory();
                    }
                    a(obj, optString2);
                    a(obj, "onComponentDestroy", optString2);
                    q.a("OperateViews", "destroyComponent instanceId = " + optString2);
                    return;
                }
            }
            c(obj, "unidId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "destroyComponent failed");
        }
    }

    public final void f(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString = jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            } else {
                a(obj, optString);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void g(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            if (optJSONObject2 == null) {
                c(obj, "rect not exist");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            Rect rect = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
            int optInt = optJSONObject2.optInt("width");
            int optInt2 = optJSONObject2.optInt("height");
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view != null) {
                    if (view.getParent() != null) {
                        view.setLayoutParams(a(view.getLayoutParams(), rect, optInt, optInt2));
                        view.requestLayout();
                    } else {
                        if (view instanceof MBridgeBTWebView) {
                            ((MBridgeBTWebView) view).setRect(rect);
                            ((MBridgeBTWebView) view).setLayout(optInt, optInt2);
                        }
                        if (view instanceof MBridgeBTVideoView) {
                            ((MBridgeBTVideoView) view).setRect(rect);
                            ((MBridgeBTVideoView) view).setLayout(optInt, optInt2);
                        }
                    }
                    a(obj, optString2);
                    a(obj, "onViewRectChanged", optString2);
                    q.a("OperateViews", "setViewRect instanceId = " + optString2);
                    return;
                }
                c(obj, "view is null");
                q.a("OperateViews", "setViewRect failed: view is null");
                return;
            }
            c(obj, "instanceId not exist");
            q.a("OperateViews", "setViewRect failed: instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "setViewRect failed: " + th.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: android.widget.LinearLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.widget.LinearLayout$LayoutParams} */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.ViewGroup.LayoutParams a(android.view.ViewGroup.LayoutParams r5, android.graphics.Rect r6, int r7, int r8) {
        /*
            r4 = this;
            r0 = -999(0xfffffffffffffc19, float:NaN)
            if (r6 != 0) goto L_0x0009
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>(r0, r0, r0, r0)
        L_0x0009:
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r1 = r1.g()
            if (r1 != 0) goto L_0x0014
            return r5
        L_0x0014:
            boolean r2 = r5 instanceof android.widget.FrameLayout.LayoutParams
            r3 = -1
            if (r2 == 0) goto L_0x0065
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r5.<init>(r3, r3)
            int r2 = r6.left
            if (r2 == r0) goto L_0x002b
            int r2 = r6.left
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.leftMargin = r2
        L_0x002b:
            int r2 = r6.top
            if (r2 == r0) goto L_0x0038
            int r2 = r6.top
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.topMargin = r2
        L_0x0038:
            int r2 = r6.right
            if (r2 == r0) goto L_0x0045
            int r2 = r6.right
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.rightMargin = r2
        L_0x0045:
            int r2 = r6.bottom
            if (r2 == r0) goto L_0x0052
            int r6 = r6.bottom
            float r6 = (float) r6
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.bottomMargin = r6
        L_0x0052:
            if (r7 <= 0) goto L_0x005b
            float r6 = (float) r7
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.width = r6
        L_0x005b:
            if (r8 <= 0) goto L_0x0064
            float r6 = (float) r8
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.height = r6
        L_0x0064:
            return r5
        L_0x0065:
            boolean r2 = r5 instanceof android.widget.RelativeLayout.LayoutParams
            if (r2 == 0) goto L_0x00b5
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r5.<init>(r3, r3)
            int r2 = r6.left
            if (r2 == r0) goto L_0x007b
            int r2 = r6.left
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.leftMargin = r2
        L_0x007b:
            int r2 = r6.top
            if (r2 == r0) goto L_0x0088
            int r2 = r6.top
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.topMargin = r2
        L_0x0088:
            int r2 = r6.right
            if (r2 == r0) goto L_0x0095
            int r2 = r6.right
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.rightMargin = r2
        L_0x0095:
            int r2 = r6.bottom
            if (r2 == r0) goto L_0x00a2
            int r6 = r6.bottom
            float r6 = (float) r6
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.bottomMargin = r6
        L_0x00a2:
            if (r7 <= 0) goto L_0x00ab
            float r6 = (float) r7
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.width = r6
        L_0x00ab:
            if (r8 <= 0) goto L_0x00b4
            float r6 = (float) r8
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.height = r6
        L_0x00b4:
            return r5
        L_0x00b5:
            boolean r2 = r5 instanceof android.widget.LinearLayout.LayoutParams
            if (r2 == 0) goto L_0x0104
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r5.<init>(r3, r3)
            int r2 = r6.left
            if (r2 == r0) goto L_0x00cb
            int r2 = r6.left
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.leftMargin = r2
        L_0x00cb:
            int r2 = r6.top
            if (r2 == r0) goto L_0x00d8
            int r2 = r6.top
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.topMargin = r2
        L_0x00d8:
            int r2 = r6.right
            if (r2 == r0) goto L_0x00e5
            int r2 = r6.right
            float r2 = (float) r2
            int r2 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r2)
            r5.rightMargin = r2
        L_0x00e5:
            int r2 = r6.bottom
            if (r2 == r0) goto L_0x00f2
            int r6 = r6.bottom
            float r6 = (float) r6
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.bottomMargin = r6
        L_0x00f2:
            if (r7 <= 0) goto L_0x00fb
            float r6 = (float) r7
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.width = r6
        L_0x00fb:
            if (r8 <= 0) goto L_0x0104
            float r6 = (float) r8
            int r6 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r1, (float) r6)
            r5.height = r6
        L_0x0104:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.c.a(android.view.ViewGroup$LayoutParams, android.graphics.Rect, int, int):android.view.ViewGroup$LayoutParams");
    }

    public final void h(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view == null || view.getParent() == null) {
                    c(obj, "view is null");
                    q.a("OperateViews", "removeFromSuperView failed: view is null instanceId = " + optString2);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                    a(obj, optString2);
                    a(obj, "onRemoveFromView", optString2);
                    q.a("OperateViews", "removeFromSuperView instanceId = " + optString2);
                    return;
                }
                c(obj, "parent is null");
                q.a("OperateViews", "removeFromSuperView failed: parent is null instanceId = " + optString2);
                return;
            }
            c(obj, "params not enough");
            q.a("OperateViews", "removeFromSuperView failed: params not enough instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "removeFromSuperView failed: " + th.getMessage());
        }
    }

    public final void i(Object obj, JSONObject jSONObject) {
        int i2;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("id");
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (!b2.containsKey(optString3) || !b2.containsKey(optString2)) {
                c(obj, "instanceId is not exist");
                q.a("OperateViews", "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) b2.get(optString2);
            View view = b2.get(optString3);
            aa.a(view);
            if (viewGroup != null) {
                if (view != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                    int i3 = 0;
                    if (view instanceof MBTempContainer) {
                        q.d("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", new Object[]{Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(o)}));
                        ((MBTempContainer) view).setNotchPadding(k, l, m, n, o);
                        Iterator<View> it = b2.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                aa.a(view);
                                ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                break;
                            }
                        }
                    } else {
                        Rect rect = null;
                        if (optJSONObject2 != null) {
                            Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                            i3 = optJSONObject2.optInt("width");
                            i2 = optJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            i3 = ((BTBaseView) view).getViewWidth();
                            i2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            i2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        ViewGroup.LayoutParams a2 = a(layoutParams, rect, i3, i2);
                        aa.a(view);
                        viewGroup.addView(view, a2);
                    }
                    a(obj, optString2);
                    a(obj, "onAppendView", optString2);
                    q.a("OperateViews", "appendSubView parentId = " + optString2 + " childId = " + optString3);
                    return;
                }
            }
            c(obj, "view is not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "appendSubView failed: " + th.getMessage());
        }
    }

    public final void j(Object obj, JSONObject jSONObject) {
        int i2;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String optString3 = optJSONObject.optString("id");
                    LinkedHashMap<String, View> b2 = b(optString, g2);
                    if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                        c(obj, "instanceId is not exist");
                        q.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) b2.get(optString3);
                    View view = b2.get(optString2);
                    aa.a(view);
                    if (viewGroup != null) {
                        if (view != null) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                            if (view instanceof MBTempContainer) {
                                Iterator<View> it = b2.values().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    View next = it.next();
                                    if (next instanceof MBridgeBTContainer) {
                                        aa.a(view);
                                        ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                        break;
                                    }
                                }
                            } else {
                                Rect rect = null;
                                int i3 = 0;
                                if (optJSONObject2 != null) {
                                    Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                                    i3 = optJSONObject2.optInt("width");
                                    i2 = optJSONObject2.optInt("height");
                                    rect = rect2;
                                } else if (view instanceof BTBaseView) {
                                    rect = ((BTBaseView) view).getRect();
                                    i3 = ((BTBaseView) view).getViewWidth();
                                    i2 = ((BTBaseView) view).getViewHeight();
                                } else {
                                    i2 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                                if (viewGroup instanceof FrameLayout) {
                                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                } else if (viewGroup instanceof RelativeLayout) {
                                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                } else if (viewGroup instanceof LinearLayout) {
                                    layoutParams = new LinearLayout.LayoutParams(-1, -1);
                                }
                                ViewGroup.LayoutParams a2 = a(layoutParams, rect, i3, i2);
                                aa.a(view);
                                viewGroup.addView(view, a2);
                            }
                            a(obj, optString2);
                            a(obj, "onAppendViewTo", optString2);
                            q.a("OperateViews", "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                            return;
                        }
                    }
                    c(obj, "view is not exist");
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "appendViewTo failed: " + th.getMessage());
        }
    }

    public final void k(Object obj, JSONObject jSONObject) {
        int i2;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("id");
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (!b2.containsKey(optString3) || !b2.containsKey(optString2)) {
                c(obj, "instanceId is not exist");
                q.a("OperateViews", "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) b2.get(optString2);
            View view = b2.get(optString3);
            if (viewGroup != null) {
                if (view != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                    int i3 = 0;
                    if (view instanceof MBTempContainer) {
                        q.d("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", new Object[]{Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(o)}));
                        ((MBTempContainer) view).setNotchPadding(k, l, m, n, o);
                        Iterator<View> it = b2.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                aa.a(view);
                                ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                break;
                            }
                        }
                    } else {
                        Rect rect = null;
                        if (optJSONObject2 != null) {
                            Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                            i3 = optJSONObject2.optInt("width");
                            i2 = optJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            i3 = ((BTBaseView) view).getViewWidth();
                            i2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            i2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        viewGroup.addView(view, a(layoutParams, rect, i3, i2));
                    }
                    a(obj, optString2);
                    a(obj, "onAppendView", optString2);
                    q.a("OperateViews", "appendSubView parentId = " + optString2 + " childId = " + optString3);
                    return;
                }
            }
            c(obj, "view is not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "appendSubView failed: " + th.getMessage());
        }
    }

    public final void l(Object obj, JSONObject jSONObject) {
        int i2;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String optString3 = optJSONObject.optString("id");
                    LinkedHashMap<String, View> b2 = b(optString, g2);
                    if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                        c(obj, "instanceId is not exist");
                        q.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) b2.get(optString3);
                    View view = b2.get(optString2);
                    if (viewGroup != null) {
                        if (view != null) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                            if (view instanceof MBTempContainer) {
                                Iterator<View> it = b2.values().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    View next = it.next();
                                    if (next instanceof MBridgeBTContainer) {
                                        aa.a(view);
                                        ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                        break;
                                    }
                                }
                            } else {
                                Rect rect = null;
                                int i3 = 0;
                                if (optJSONObject2 != null) {
                                    Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                                    i3 = optJSONObject2.optInt("width");
                                    i2 = optJSONObject2.optInt("height");
                                    rect = rect2;
                                } else if (view instanceof BTBaseView) {
                                    rect = ((BTBaseView) view).getRect();
                                    i3 = ((BTBaseView) view).getViewWidth();
                                    i2 = ((BTBaseView) view).getViewHeight();
                                } else {
                                    i2 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                                if (viewGroup instanceof FrameLayout) {
                                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                } else if (viewGroup instanceof RelativeLayout) {
                                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                } else if (viewGroup instanceof LinearLayout) {
                                    layoutParams = new LinearLayout.LayoutParams(-1, -1);
                                }
                                viewGroup.addView(view, a(layoutParams, rect, i3, i2));
                            }
                            a(obj, optString2);
                            a(obj, "onAppendViewTo", optString2);
                            q.a("OperateViews", "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                            return;
                        }
                    }
                    c(obj, "view is not exist");
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "appendViewTo failed: " + th.getMessage());
        }
    }

    public final void m(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view == null || view.getParent() == null) {
                    c(obj, "view is null");
                    q.a("OperateViews", "bringViewToFront failed: view is null");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.bringChildToFront(view);
                    a(obj, optString2);
                    a(obj, "onBringViewToFront", optString2);
                    q.a("OperateViews", "bringViewToFront instanceId = " + optString2);
                    return;
                }
                c(obj, "parent is null");
                q.a("OperateViews", "bringViewToFront failed: parent is null");
                return;
            }
            c(obj, "instanceId is not exist");
            q.a("OperateViews", "bringViewToFront failed: instanceId is not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "bringViewToFront failed: " + th.getMessage());
        }
    }

    public final void n(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view != null) {
                    view.setVisibility(8);
                    a(obj, optString2);
                    a(obj, "onHideView", optString2);
                    q.a("OperateViews", "hideView instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                q.a("OperateViews", "hideView failed: view not exist");
                return;
            }
            c(obj, "instanceId not exist");
            q.a("OperateViews", "hideView failed: instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "hideView failed: + " + th.getMessage());
        }
    }

    public final void o(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view != null) {
                    view.setVisibility(0);
                    a(obj, optString2);
                    a(obj, "onShowView", optString2);
                    q.a("OperateViews", "showView instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                q.a("OperateViews", "showView failed: view not exist instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            q.a("OperateViews", "showView failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "showView failed: " + th.getMessage());
        }
    }

    public final void p(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString(TtmlNode.ATTR_TTS_COLOR);
            if (TextUtils.isEmpty(optString3)) {
                c(obj, "color is not exist");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view != null) {
                    a(obj, optString2);
                    view.setBackgroundColor(Color.parseColor(optString3));
                    a(obj, "onViewBgColorChanged", optString2);
                    q.a("OperateViews", "setViewBgColor instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                q.a("OperateViews", "setViewBgColor failed: view not exist instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            q.a("OperateViews", "setViewBgColor failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "setViewBgColor failed: " + th.getMessage());
        }
    }

    public final void q(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("alpha", 1.0d);
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view != null) {
                    view.setAlpha((float) optDouble);
                    a(obj, optString2);
                    a(obj, "onViewAlphaChanged", optString2);
                    q.a("OperateViews", "setViewAlpha instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                q.a("OperateViews", "setViewAlpha failed: view not exist instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            q.a("OperateViews", "setViewAlpha failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "setViewAlpha failed: " + th.getMessage());
        }
    }

    public final void r(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("vertical", 1.0d);
            double optDouble2 = optJSONObject.optDouble("horizon", 1.0d);
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view != null) {
                    view.setScaleX((float) optDouble2);
                    view.setScaleY((float) optDouble);
                    a(obj, optString2);
                    a(obj, "onViewScaleChanged", optString2);
                    q.a("OperateViews", "setViewScale instanceId = " + optString2);
                    return;
                }
                c(obj, "view not exist");
                q.a("OperateViews", "setViewScale failed: view not exist instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            q.a("OperateViews", "setViewScale failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "setViewScale failed: " + th.getMessage());
        }
    }

    public final void a(Object obj, JSONObject jSONObject, boolean z) {
        int i2;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                q.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                q.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            int i3 = 0;
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                i3 = optJSONObject2.optInt("width");
                i2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                i3 = ((BTBaseView) view).getViewWidth();
                i2 = ((BTBaseView) view).getViewHeight();
            } else {
                i2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams a2 = a(layoutParams, rect, i3, i2);
            if (z) {
                aa.a(view);
            }
            viewGroup.addView(view, indexOfChild + 1, a2);
            a(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
            q.a("OperateViews", "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "insertViewAbove failed: " + th.getMessage());
        }
    }

    public final void b(Object obj, JSONObject jSONObject, boolean z) {
        int i2;
        int i3;
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                q.a("OperateViews", "insertViewBelow failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                q.a("OperateViews", "insertViewBelow failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt("bottom", -999));
                int optInt = optJSONObject2.optInt("width");
                i3 = optJSONObject2.optInt("height");
                i2 = optInt;
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                i2 = ((BTBaseView) view).getViewWidth();
                i3 = ((BTBaseView) view).getViewHeight();
            } else {
                i2 = 0;
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams a2 = a(layoutParams, rect, i2, i3);
            if (z) {
                aa.a(view);
            }
            int i4 = indexOfChild - 1;
            if (i4 <= -1) {
                i4 = 0;
            }
            viewGroup.addView(view, i4, a2);
            viewGroup.addView(view, indexOfChild, a2);
            a(obj, optString2);
            a(obj, "onInsertViewBelow", optString2);
            q.a("OperateViews", "insertViewBelow instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "insertViewBelow failed: " + th.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(java.lang.Object r19, org.json.JSONObject r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r20
            java.lang.String r3 = "unitId"
            java.lang.String r4 = "OperateViews"
            java.lang.String r5 = r0.optString(r3)     // Catch:{ all -> 0x0191 }
            java.lang.String r6 = "id"
            java.lang.String r6 = r0.optString(r6)     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = r1.g(r6)     // Catch:{ all -> 0x0191 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0191 }
            if (r8 == 0) goto L_0x002b
            r8 = r2
            com.mbridge.msdk.mbsignalcommon.windvane.a r8 = (com.mbridge.msdk.mbsignalcommon.windvane.a) r8     // Catch:{ all -> 0x0191 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r9 = r8.a     // Catch:{ all -> 0x0191 }
            if (r9 == 0) goto L_0x002b
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r7 = r8.a     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = r7.getRid()     // Catch:{ all -> 0x0191 }
        L_0x002b:
            java.lang.String r8 = "data"
            org.json.JSONObject r8 = r0.optJSONObject(r8)     // Catch:{ all -> 0x0191 }
            if (r8 != 0) goto L_0x0039
            java.lang.String r0 = "data is empty"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0191 }
            return
        L_0x0039:
            java.lang.String r9 = "content"
            org.json.JSONObject r8 = r8.optJSONObject(r9)     // Catch:{ all -> 0x0191 }
            if (r8 != 0) goto L_0x0047
            java.lang.String r0 = "content is empty"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0191 }
            return
        L_0x0047:
            java.lang.String r9 = "fileURL"
            java.lang.String r9 = r8.optString(r9)     // Catch:{ all -> 0x0191 }
            java.lang.String r10 = "filePath"
            java.lang.String r10 = r8.optString(r10)     // Catch:{ all -> 0x0191 }
            java.lang.String r11 = "html"
            java.lang.String r11 = r8.optString(r11)     // Catch:{ all -> 0x0191 }
            boolean r12 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0191 }
            if (r12 == 0) goto L_0x0071
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0191 }
            if (r12 == 0) goto L_0x0071
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0191 }
            if (r12 == 0) goto L_0x0071
            java.lang.String r0 = "url is empty"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0191 }
            return
        L_0x0071:
            java.lang.String r12 = "campaigns"
            org.json.JSONArray r12 = r8.optJSONArray(r12)     // Catch:{ all -> 0x0191 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x0191 }
            r13.<init>()     // Catch:{ all -> 0x0191 }
            if (r12 == 0) goto L_0x00a2
            int r15 = r12.length()     // Catch:{ all -> 0x0191 }
            if (r15 <= 0) goto L_0x00a2
            int r15 = r12.length()     // Catch:{ all -> 0x0191 }
            r14 = 0
        L_0x0089:
            if (r14 >= r15) goto L_0x00a2
            org.json.JSONObject r16 = r12.getJSONObject(r14)     // Catch:{ all -> 0x0191 }
            r17 = r12
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r16)     // Catch:{ all -> 0x0191 }
            if (r12 == 0) goto L_0x009d
            r12.setCampaignUnitId(r5)     // Catch:{ all -> 0x0191 }
            r13.add(r12)     // Catch:{ all -> 0x0191 }
        L_0x009d:
            int r14 = r14 + 1
            r12 = r17
            goto L_0x0089
        L_0x00a2:
            java.lang.String r3 = r8.optString(r3)     // Catch:{ all -> 0x0191 }
            java.lang.String r12 = "unitSetting"
            org.json.JSONObject r12 = r8.optJSONObject(r12)     // Catch:{ all -> 0x0191 }
            com.mbridge.msdk.videocommon.d.c r12 = com.mbridge.msdk.videocommon.d.c.a((org.json.JSONObject) r12)     // Catch:{ all -> 0x0191 }
            if (r12 == 0) goto L_0x00b5
            r12.a((java.lang.String) r3)     // Catch:{ all -> 0x0191 }
        L_0x00b5:
            java.lang.String r3 = "rect"
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x0191 }
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ all -> 0x0191 }
            r14 = -999(0xfffffffffffffc19, float:NaN)
            r3.<init>(r14, r14, r14, r14)     // Catch:{ all -> 0x0191 }
            if (r0 == 0) goto L_0x00f5
            java.lang.String r3 = "left"
            int r3 = r0.optInt(r3, r14)     // Catch:{ all -> 0x00f0 }
            java.lang.String r15 = "top"
            int r15 = r0.optInt(r15, r14)     // Catch:{ all -> 0x00f0 }
            r16 = r4
            java.lang.String r4 = "right"
            int r4 = r0.optInt(r4, r14)     // Catch:{ all -> 0x018b }
            java.lang.String r2 = "bottom"
            int r2 = r0.optInt(r2, r14)     // Catch:{ all -> 0x018b }
            android.graphics.Rect r14 = new android.graphics.Rect     // Catch:{ all -> 0x018b }
            r14.<init>(r3, r15, r4, r2)     // Catch:{ all -> 0x018b }
            java.lang.String r2 = "width"
            int r2 = r0.optInt(r2)     // Catch:{ all -> 0x018b }
            java.lang.String r3 = "height"
            int r0 = r0.optInt(r3)     // Catch:{ all -> 0x018b }
            goto L_0x00fa
        L_0x00f0:
            r0 = move-exception
            r2 = r19
            goto L_0x0192
        L_0x00f5:
            r16 = r4
            r14 = r3
            r0 = 0
            r2 = 0
        L_0x00fa:
            java.lang.String r3 = "refreshCache"
            r4 = 0
            int r3 = r8.optInt(r3, r4)     // Catch:{ all -> 0x018b }
            java.util.LinkedHashMap r4 = r1.b((java.lang.String) r5, (java.lang.String) r7)     // Catch:{ all -> 0x018b }
            boolean r5 = r4.containsKey(r6)     // Catch:{ all -> 0x018b }
            if (r5 == 0) goto L_0x016b
            java.lang.Object r4 = r4.get(r6)     // Catch:{ all -> 0x018b }
            android.view.View r4 = (android.view.View) r4     // Catch:{ all -> 0x018b }
            boolean r5 = r4 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTWebView     // Catch:{ all -> 0x018b }
            if (r5 == 0) goto L_0x014d
            com.mbridge.msdk.video.bt.module.MBridgeBTWebView r4 = (com.mbridge.msdk.video.bt.module.MBridgeBTWebView) r4     // Catch:{ all -> 0x018b }
            r4.setHtml(r11)     // Catch:{ all -> 0x018b }
            r4.setFilePath(r10)     // Catch:{ all -> 0x018b }
            r4.setFileURL(r9)     // Catch:{ all -> 0x018b }
            r4.setRect(r14)     // Catch:{ all -> 0x018b }
            r4.setLayout(r2, r0)     // Catch:{ all -> 0x018b }
            r4.setCampaigns(r13)     // Catch:{ all -> 0x018b }
            r4.setRewardUnitSetting(r12)     // Catch:{ all -> 0x018b }
            r4.webviewLoad(r3)     // Catch:{ all -> 0x018b }
            r2 = r19
            r1.a((java.lang.Object) r2, (java.lang.String) r6)     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            r0.<init>()     // Catch:{ all -> 0x014b }
            java.lang.String r3 = "webviewLoad instanceId = "
            r0.append(r3)     // Catch:{ all -> 0x014b }
            r0.append(r6)     // Catch:{ all -> 0x014b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x014b }
            r3 = r16
            com.mbridge.msdk.foundation.tools.q.a(r3, r0)     // Catch:{ all -> 0x0189 }
            goto L_0x01b2
        L_0x014b:
            r0 = move-exception
            goto L_0x018e
        L_0x014d:
            r2 = r19
            r3 = r16
            java.lang.String r0 = "view not exist"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0189 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0189 }
            r0.<init>()     // Catch:{ all -> 0x0189 }
            java.lang.String r4 = "webviewLoad failed: view not exist instanceId = "
            r0.append(r4)     // Catch:{ all -> 0x0189 }
            r0.append(r6)     // Catch:{ all -> 0x0189 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0189 }
            com.mbridge.msdk.foundation.tools.q.a(r3, r0)     // Catch:{ all -> 0x0189 }
            goto L_0x01b2
        L_0x016b:
            r2 = r19
            r3 = r16
            java.lang.String r0 = "instanceId not exist"
            r1.c((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0189 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0189 }
            r0.<init>()     // Catch:{ all -> 0x0189 }
            java.lang.String r4 = "webviewLoad failed: instanceId not exist instanceId = "
            r0.append(r4)     // Catch:{ all -> 0x0189 }
            r0.append(r6)     // Catch:{ all -> 0x0189 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0189 }
            com.mbridge.msdk.foundation.tools.q.a(r3, r0)     // Catch:{ all -> 0x0189 }
            goto L_0x01b2
        L_0x0189:
            r0 = move-exception
            goto L_0x0193
        L_0x018b:
            r0 = move-exception
            r2 = r19
        L_0x018e:
            r3 = r16
            goto L_0x0193
        L_0x0191:
            r0 = move-exception
        L_0x0192:
            r3 = r4
        L_0x0193:
            java.lang.String r4 = r0.getMessage()
            r1.c((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "webviewLoad failed: "
            r2.append(r4)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.mbridge.msdk.foundation.tools.q.a(r3, r0)
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.c.s(java.lang.Object, org.json.JSONObject):void");
    }

    public final void t(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (!(view instanceof MBridgeBTWebView)) {
                    c(obj, "view not exist");
                    q.a("OperateViews", "webviewReload failed view not exist instanceId = " + optString2);
                } else if (((MBridgeBTWebView) view).webviewReload()) {
                    a(obj, optString2);
                    q.a("OperateViews", "webviewReload instanceId = " + optString2);
                } else {
                    c(obj, "reload failed");
                    q.a("OperateViews", "webviewReload failed reload failed instanceId = " + optString2);
                }
            } else {
                c(obj, "instanceId not exist");
                q.a("OperateViews", "webviewReload failed instanceId not exist instanceId = " + optString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "webviewReload failed: " + th.getMessage());
        }
    }

    public final void u(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (!(view instanceof MBridgeBTWebView)) {
                    c(obj, "view not exist");
                    q.a("OperateViews", "webviewGoBack failed view not exist instanceId = " + optString2);
                } else if (((MBridgeBTWebView) view).webviewGoBack()) {
                    a(obj, optString2);
                    q.a("OperateViews", "webviewGoBack instanceId = " + optString2);
                } else {
                    c(obj, "webviewGoBack failed");
                    q.a("OperateViews", "webviewGoBack failed instanceId = " + optString2);
                }
            } else {
                c(obj, "instanceId not exist");
                q.a("OperateViews", "webviewGoBack failed instanceId not exist instanceId = " + optString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "webviewGoBack failed: " + th.getMessage());
        }
    }

    public final void v(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (!(view instanceof MBridgeBTWebView)) {
                    c(obj, "view not exist");
                    q.a("OperateViews", "webviewGoForward failed view not exist instanceId = " + optString2);
                } else if (((MBridgeBTWebView) view).webviewGoForward()) {
                    a(obj, optString2);
                    q.a("OperateViews", "webviewGoForward instanceId = " + optString2);
                } else {
                    c(obj, "webviewGoForward failed");
                    q.a("OperateViews", "webviewGoForward failed instanceId = " + optString2);
                }
            } else {
                c(obj, "instanceId not exist");
                q.a("OperateViews", "webviewGoForward failed instanceId not exist instanceId = " + optString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "webviewGoForward failed: " + th.getMessage());
        }
    }

    public final void w(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).play();
                    a(obj, optString2);
                    q.a("OperateViews", "playerPlay success");
                    return;
                }
                c(obj, "instanceId is not player");
                q.a("OperateViews", "playerPlay failed instanceId is not player instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exit");
            q.a("OperateViews", "playerPlay failed instanceId not exit instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "playerPlay failed: " + th.getMessage());
        }
    }

    public final void x(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).pause();
                    a(obj, optString2);
                    q.a("OperateViews", "playerPause success");
                    return;
                }
                c(obj, "instanceId is not player");
                q.a("OperateViews", "playerPause failed instanceId is not player instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exit");
            q.a("OperateViews", "playerPause failed instanceId not exit instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "playerPause failed: " + th.getMessage());
        }
    }

    public final void y(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).resume();
                    a(obj, optString2);
                    q.a("OperateViews", "playerResume success");
                    return;
                }
                c(obj, "instanceId is not player");
                q.a("OperateViews", "playerResume failed instanceId is not player instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exit");
            q.a("OperateViews", "playerResume failed instanceId not exit instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "playerResume failed: " + th.getMessage());
        }
    }

    public final void z(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).stop();
                    a(obj, optString2);
                    q.a("OperateViews", "playerStop success");
                    return;
                }
                c(obj, "instanceId is not player");
                q.a("OperateViews", "playerStop failed instanceId is not player instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exit");
            q.a("OperateViews", "playerStop failed instanceId not exit instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "playerStop failed: " + th.getMessage());
        }
    }

    public final void A(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void B(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (!(view instanceof MBridgeBTVideoView)) {
                    c(obj, "instanceId is not player");
                    q.a("OperateViews", "playerMute failed: instanceId is not player");
                } else if (((MBridgeBTVideoView) view).playMute()) {
                    a(obj, optString2);
                    q.a("OperateViews", "playerMute success");
                } else {
                    c(obj, "set mute failed");
                    q.a("OperateViews", "playerMute failed set mute failed");
                }
            } else {
                c(obj, "instanceId not exist");
                q.a("OperateViews", "playerMute failed: instanceId is not exist");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "playerMute failed: " + th.getMessage());
        }
    }

    public final void C(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (!(view instanceof MBridgeBTVideoView)) {
                    c(obj, "instanceId is not player");
                    q.a("OperateViews", "playerUnmute failed: instanceId is not player");
                } else if (((MBridgeBTVideoView) view).playUnMute()) {
                    a(obj, optString2);
                    a(obj, "onUnmute", optString2);
                    q.a("OperateViews", "playerUnmute successed");
                } else {
                    a(obj, "set unmute failed");
                    q.a("OperateViews", "playerUnmute failed: set unmute failed");
                }
            } else {
                c(obj, "instanceId not exit");
                q.a("OperateViews", "playerUnmute failed: instanceId not exit");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "playerUnmute failed: " + th.getMessage());
        }
    }

    public final void D(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view instanceof MBridgeBTVideoView) {
                    int mute = ((MBridgeBTVideoView) view).getMute();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", h);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", optString2);
                    jSONObject3.put("mute", mute);
                    jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject3);
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    q.a("OperateViews", "playerGetMuteState successed mute = " + mute);
                    return;
                }
                c(obj, "instanceId is not player");
                q.a("OperateViews", "playerGetMuteState failed instanceId is not player");
                return;
            }
            c(obj, "instanceId not exist");
            q.a("OperateViews", "playerGetMuteState failed instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "playerGetMuteState failed: " + th.getMessage());
        }
    }

    public final void E(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void F(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            jSONObject.optString("id");
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
            } else {
                c(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void G(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            String g2 = g(optString2);
            if (TextUtils.isEmpty(g2)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    g2 = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA) == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, g2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).preload();
                    a(obj, optString2);
                    return;
                }
                c(obj, "view not exist");
                return;
            }
            c(obj, "instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "preloadSubPlayTemplateView failed: " + th.getMessage());
        }
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(java.lang.Object r10, org.json.JSONObject r11) {
        /*
            r9 = this;
            java.lang.String r0 = "OperateViews"
            java.lang.String r1 = "unitId"
            java.lang.String r1 = r11.optString(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r2 = "id"
            java.lang.String r2 = r11.optString(r2)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = r9.g(r2)     // Catch:{ all -> 0x00d5 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00d5 }
            if (r4 == 0) goto L_0x0025
            r4 = r10
            com.mbridge.msdk.mbsignalcommon.windvane.a r4 = (com.mbridge.msdk.mbsignalcommon.windvane.a) r4     // Catch:{ all -> 0x00d5 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r5 = r4.a     // Catch:{ all -> 0x00d5 }
            if (r5 == 0) goto L_0x0025
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r3 = r4.a     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = r3.getRid()     // Catch:{ all -> 0x00d5 }
        L_0x0025:
            java.lang.String r4 = "data"
            org.json.JSONObject r11 = r11.optJSONObject(r4)     // Catch:{ all -> 0x00d5 }
            if (r11 != 0) goto L_0x0033
            java.lang.String r11 = "data is empty"
            r9.c((java.lang.Object) r10, (java.lang.String) r11)     // Catch:{ all -> 0x00d5 }
            return
        L_0x0033:
            java.util.LinkedHashMap r11 = r9.b((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x00d5 }
            r4 = 0
            int r5 = r11.size()     // Catch:{ all -> 0x00d5 }
            if (r5 <= 0) goto L_0x00bb
            java.util.Collection r5 = r11.values()     // Catch:{ all -> 0x00d5 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00d5 }
        L_0x0046:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00d5 }
            if (r6 == 0) goto L_0x0086
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00d5 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x00d5 }
            boolean r7 = r6 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTContainer     // Catch:{ all -> 0x00d5 }
            if (r7 == 0) goto L_0x005a
            r4 = r6
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer r4 = (com.mbridge.msdk.video.bt.module.MBridgeBTContainer) r4     // Catch:{ all -> 0x00d5 }
            goto L_0x0046
        L_0x005a:
            boolean r7 = r6 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTWebView     // Catch:{ all -> 0x00d5 }
            if (r7 == 0) goto L_0x0064
            com.mbridge.msdk.video.bt.module.MBridgeBTWebView r6 = (com.mbridge.msdk.video.bt.module.MBridgeBTWebView) r6     // Catch:{ all -> 0x00d5 }
            r6.onDestory()     // Catch:{ all -> 0x00d5 }
            goto L_0x0046
        L_0x0064:
            boolean r7 = r6 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTVideoView     // Catch:{ all -> 0x00d5 }
            if (r7 == 0) goto L_0x007c
            r7 = r6
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r7     // Catch:{ all -> 0x00d5 }
            java.lang.String r7 = r7.getInstanceId()     // Catch:{ all -> 0x00d5 }
            com.mbridge.msdk.video.bt.a.a r8 = com.mbridge.msdk.video.bt.a.a.a()     // Catch:{ all -> 0x00d5 }
            r8.a(r7)     // Catch:{ all -> 0x00d5 }
            com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r6 = (com.mbridge.msdk.video.bt.module.MBridgeBTVideoView) r6     // Catch:{ all -> 0x00d5 }
            r6.onDestory()     // Catch:{ all -> 0x00d5 }
            goto L_0x0046
        L_0x007c:
            boolean r7 = r6 instanceof com.mbridge.msdk.video.bt.module.MBTempContainer     // Catch:{ all -> 0x00d5 }
            if (r7 == 0) goto L_0x0046
            com.mbridge.msdk.video.bt.module.MBTempContainer r6 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r6     // Catch:{ all -> 0x00d5 }
            r6.onDestroy()     // Catch:{ all -> 0x00d5 }
            goto L_0x0046
        L_0x0086:
            if (r4 == 0) goto L_0x00b0
            r4.onAdClose()     // Catch:{ all -> 0x00d5 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedHashMap<java.lang.String, android.view.View>> r4 = a     // Catch:{ all -> 0x00d5 }
            r4.remove(r11)     // Catch:{ all -> 0x00d5 }
            r11.clear()     // Catch:{ all -> 0x00d5 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedHashMap<java.lang.String, android.view.View>> r11 = a     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r4.<init>()     // Catch:{ all -> 0x00d5 }
            r4.append(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r1 = "_"
            r4.append(r1)     // Catch:{ all -> 0x00d5 }
            r4.append(r3)     // Catch:{ all -> 0x00d5 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00d5 }
            r11.remove(r1)     // Catch:{ all -> 0x00d5 }
            r9.a((java.lang.Object) r10, (java.lang.String) r2)     // Catch:{ all -> 0x00d5 }
            return
        L_0x00b0:
            java.lang.String r11 = "not found MBridgeBTContainer"
            r9.c((java.lang.Object) r10, (java.lang.String) r11)     // Catch:{ all -> 0x00d5 }
            java.lang.String r11 = "closeAd successed"
            com.mbridge.msdk.foundation.tools.q.a(r0, r11)     // Catch:{ all -> 0x00d5 }
            goto L_0x00f5
        L_0x00bb:
            java.lang.String r11 = "unitId or instanceId not exist"
            r9.c((java.lang.Object) r10, (java.lang.String) r11)     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r11.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r2 = "closeAd failed: unitId or instanceId not exist unitId = "
            r11.append(r2)     // Catch:{ all -> 0x00d5 }
            r11.append(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00d5 }
            com.mbridge.msdk.foundation.tools.q.a(r0, r11)     // Catch:{ all -> 0x00d5 }
            goto L_0x00f5
        L_0x00d5:
            r11 = move-exception
            java.lang.String r1 = r11.getMessage()
            r9.c((java.lang.Object) r10, (java.lang.String) r1)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "closeAd failed: "
            r10.append(r1)
            java.lang.String r11 = r11.getMessage()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.mbridge.msdk.foundation.tools.q.a(r0, r10)
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.a.c.H(java.lang.Object, org.json.JSONObject):void");
    }

    public final void I(Object obj, JSONObject jSONObject) {
        String str;
        try {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            if (aVar.a != null) {
                str = aVar.a.getRid();
            } else {
                str = "";
            }
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("eventName");
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (b2 == null || b2.size() <= 0) {
                c(obj, "unitId not exist");
                return;
            }
            for (View next : b2.values()) {
                if (next instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) next).broadcast(optString2, optJSONObject);
                }
                if (next instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) next).broadcast(optString2, optJSONObject);
                }
            }
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "broadcast failed: " + th.getMessage());
        }
    }

    public final void J(Object obj, JSONObject jSONObject) {
        try {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            String str = "";
            String rid = aVar.a != null ? aVar.a.getRid() : str;
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            String optString3 = optJSONObject.optString("userId");
            boolean optBoolean = optJSONObject.optBoolean("expired");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
            String optString4 = optJSONObject.optString("extra");
            com.mbridge.msdk.videocommon.b.c cVar = null;
            if (optJSONObject2 != null) {
                cVar = new com.mbridge.msdk.videocommon.b.c(optJSONObject2.optString("name"), optJSONObject2.optInt(RewardPlus.AMOUNT));
                str = optJSONObject2.optString("id");
            }
            LinkedHashMap<String, View> b2 = b(optString, rid);
            if (b2.size() <= 0 || !e.containsKey(optString2)) {
                c(obj, "unitId not exist");
                q.a("OperateViews", "setSubPlayTemplateInfo failed: unitId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (view instanceof MBTempContainer) {
                MBTempContainer mBTempContainer = (MBTempContainer) view;
                mBTempContainer.setReward(cVar);
                mBTempContainer.setUserId(optString3);
                mBTempContainer.setRewardId(str);
                mBTempContainer.setCampaignExpired(optBoolean);
                if (!TextUtils.isEmpty(optString4)) {
                    mBTempContainer.setDeveloperExtraData(optString4);
                }
                a(obj, optString2);
                q.a("OperateViews", "setSubPlayTemplateInfo success instanceId = " + optString2);
                return;
            }
            c(obj, "instanceId not exist");
            q.a("OperateViews", "setSubPlayTemplateInfo failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "setSubPlayTemplateInfo failed: " + th.getMessage());
        }
    }

    public final void K(Object obj, JSONObject jSONObject) {
        try {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            String str = "";
            if (aVar.a != null) {
                str = aVar.a.getRid();
            }
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            String optString3 = optJSONObject.optString("eventName");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("eventData");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (b2.size() > 0) {
                View view = b2.get(optString2);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt instanceof WindVaneWebView) {
                            g.a().a((WebView) (WindVaneWebView) childAt, optString3, Base64.encodeToString(optJSONObject2.toString().getBytes(), 2));
                            a(obj, optString2);
                            q.a("OperateViews", "webviewFireEvent instanceId = " + optString2);
                            return;
                        }
                    }
                }
                c(obj, "instanceId not exist");
                q.a("OperateViews", "webviewFireEvent failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            c(obj, "unitId not exist");
            q.a("OperateViews", "webviewFireEvent failed: unitId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "webviewFireEvent failed: " + th.getMessage());
        }
    }

    public final void L(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                c(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        j a2 = j.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                        if (a2 != null) {
                            if (!a2.a(parseCampaignWithBackData.getId())) {
                                com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                                fVar.a(parseCampaignWithBackData.getId());
                                fVar.a(parseCampaignWithBackData.getFca());
                                fVar.b(parseCampaignWithBackData.getFcb());
                                fVar.d(0);
                                fVar.c(1);
                                fVar.a(System.currentTimeMillis());
                                a2.a(fVar);
                            } else {
                                a2.b(parseCampaignWithBackData.getId());
                            }
                        }
                        c.a(c.this, parseCampaignWithBackData.getCampaignUnitId(), parseCampaignWithBackData);
                    } catch (Throwable th) {
                        q.a("OperateViews", th.getMessage(), th);
                    }
                }
            }).start();
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void M(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        boolean z;
        String str5;
        String str6;
        String str7;
        Object obj2 = obj;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        String str8 = "message";
        String str9 = "code";
        int i3 = 1;
        if (jSONObject2 == null) {
            try {
                jSONObject3.put(str9, 1);
                jSONObject3.put(str8, "params is null");
                g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (JSONException e2) {
                q.a("OperateViews", e2.getMessage());
            }
        } else {
            try {
                jSONObject3.put(str9, 0);
                jSONObject3.put(str8, "");
                JSONArray jSONArray = jSONObject2.getJSONArray("resource");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    str3 = str8;
                    str2 = str9;
                    try {
                        jSONObject3.put(str2, 1);
                        str = str3;
                        try {
                            jSONObject3.put(str, "resource is null");
                            g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                        } catch (JSONException e3) {
                            e = e3;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        str = str3;
                        try {
                            q.a("OperateViews", e.getMessage());
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str = str3;
                        try {
                            jSONObject3.put(str2, 1);
                            jSONObject3.put(str, th.getLocalizedMessage());
                            g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                        } catch (JSONException e5) {
                            q.a("OperateViews", e5.getMessage());
                        }
                    }
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    int length = jSONArray.length();
                    int i4 = 0;
                    while (i4 < length) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i4);
                        String optString = jSONObject4.optString("ref", "");
                        int i5 = jSONObject4.getInt("type");
                        JSONObject jSONObject5 = new JSONObject();
                        JSONArray jSONArray3 = jSONArray;
                        if (i5 == i3) {
                            if (!TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject6 = new JSONObject();
                                l a2 = o.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g())).a(optString);
                                if (a2 != null) {
                                    i2 = length;
                                    q.a("OperateViews", "VideoBean not null");
                                    jSONObject6.put("type", 1);
                                    str3 = str8;
                                    try {
                                        jSONObject6.put("videoDataLength", a2.c());
                                        String e6 = a2.e();
                                        str4 = str9;
                                        if (TextUtils.isEmpty(e6)) {
                                            q.a("OperateViews", "VideoPath null");
                                            jSONObject6.put("path", "");
                                            jSONObject6.put("path4Web", "");
                                        } else {
                                            q.a("OperateViews", "VideoPath not null");
                                            jSONObject6.put("path", e6);
                                            jSONObject6.put("path4Web", e6);
                                        }
                                        if (a2.d() == 5) {
                                            jSONObject6.put("downloaded", 1);
                                            z = false;
                                        } else {
                                            z = false;
                                            jSONObject6.put("downloaded", 0);
                                        }
                                        jSONObject5.put(optString, jSONObject6);
                                        jSONArray2.put(jSONObject5);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str = str3;
                                        str2 = str4;
                                        jSONObject3.put(str2, 1);
                                        jSONObject3.put(str, th.getLocalizedMessage());
                                        g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                                    }
                                } else {
                                    str3 = str8;
                                    str4 = str9;
                                    i2 = length;
                                    z = false;
                                    q.a("OperateViews", "VideoBean null");
                                }
                                i4++;
                                jSONArray = jSONArray3;
                                boolean z2 = z;
                                length = i2;
                                str8 = str3;
                                str9 = str4;
                                i3 = 1;
                            }
                        }
                        str3 = str8;
                        str4 = str9;
                        i2 = length;
                        z = false;
                        if (i5 == 2 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("type", 2);
                            if (com.mbridge.msdk.videocommon.download.g.a().b(optString) == null) {
                                str7 = "";
                            } else {
                                str7 = com.mbridge.msdk.videocommon.download.g.a().b(optString);
                            }
                            jSONObject7.put("path", str7);
                            jSONObject5.put(optString, jSONObject7);
                            jSONArray2.put(jSONObject5);
                            i4++;
                            jSONArray = jSONArray3;
                            boolean z22 = z;
                            length = i2;
                            str8 = str3;
                            str9 = str4;
                            i3 = 1;
                        } else if (i5 != 3 || TextUtils.isEmpty(optString)) {
                            if (i5 == 4 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("type", 4);
                                if (t.a(optString) == null) {
                                    str5 = "";
                                } else {
                                    str5 = t.a(optString);
                                }
                                jSONObject8.put("path", str5);
                                jSONObject5.put(optString, jSONObject8);
                                jSONArray2.put(jSONObject5);
                            }
                            i4++;
                            jSONArray = jSONArray3;
                            boolean z222 = z;
                            length = i2;
                            str8 = str3;
                            str9 = str4;
                            i3 = 1;
                        } else {
                            try {
                                File file = new File(optString);
                                if (file.exists() && file.isFile() && file.canRead()) {
                                    q.a("OperateViews", "getFileInfo Mraid file " + optString);
                                    str6 = "file:////" + optString;
                                    JSONObject jSONObject9 = new JSONObject();
                                    jSONObject9.put("type", 3);
                                    jSONObject9.put("path", str6);
                                    jSONObject5.put(optString, jSONObject9);
                                    jSONArray2.put(jSONObject5);
                                    i4++;
                                    jSONArray = jSONArray3;
                                    boolean z2222 = z;
                                    length = i2;
                                    str8 = str3;
                                    str9 = str4;
                                    i3 = 1;
                                }
                            } catch (Throwable th4) {
                                if (MBridgeConstans.DEBUG) {
                                    th4.printStackTrace();
                                }
                            }
                            str6 = "";
                            JSONObject jSONObject92 = new JSONObject();
                            jSONObject92.put("type", 3);
                            jSONObject92.put("path", str6);
                            jSONObject5.put(optString, jSONObject92);
                            jSONArray2.put(jSONObject5);
                            i4++;
                            jSONArray = jSONArray3;
                            boolean z22222 = z;
                            length = i2;
                            str8 = str3;
                            str9 = str4;
                            i3 = 1;
                        }
                    }
                    String str10 = str8;
                    String str11 = str9;
                    jSONObject3.put("resource", jSONArray2);
                    g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                }
            } catch (Throwable th5) {
                th = th5;
                str = str8;
                str2 = str9;
                jSONObject3.put(str2, 1);
                jSONObject3.put(str, th.getLocalizedMessage());
                g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            }
        }
    }

    public final void b(Object obj, String str) {
        q.a("OperateViews", "reportUrls:" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), (CampaignEx) null, "", jSONObject.optString("url"), false, jSONObject.optInt("type") != 0);
                }
                a(obj, "");
            } catch (Throwable th) {
                q.a("OperateViews", "reportUrls", th);
            }
        }
    }

    public final void N(Object obj, JSONObject jSONObject) {
        q.a("OperateViews", "createNativeEC:" + jSONObject);
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optString)) {
                    String str = "";
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                    if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                        str = parseCampaignWithBackData.getRequestId();
                    }
                    com.mbridge.msdk.videocommon.d.c a2 = com.mbridge.msdk.videocommon.d.c.a(optJSONObject.optJSONObject("unitSetting"));
                    if (a2 != null) {
                        a2.a(optString);
                    }
                    MBridgeBTNativeEC mBridgeBTNativeEC = new MBridgeBTNativeEC(com.mbridge.msdk.foundation.controller.a.e().g());
                    mBridgeBTNativeEC.setCampaign(parseCampaignWithBackData);
                    com.mbridge.msdk.video.signal.a.j jVar = new com.mbridge.msdk.video.signal.a.j((Activity) null, parseCampaignWithBackData);
                    jVar.a(optString);
                    mBridgeBTNativeEC.setJSCommon(jVar);
                    mBridgeBTNativeEC.setUnitId(optString);
                    mBridgeBTNativeEC.setRewardUnitSetting(a2);
                    com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                    if (aVar.a != null) {
                        WindVaneWebView windVaneWebView = aVar.a;
                        str = windVaneWebView.getRid();
                        mBridgeBTNativeEC.setCreateWebView(windVaneWebView);
                    }
                    LinkedHashMap<String, View> b2 = b(optString, str);
                    String b3 = b();
                    b.put(b3, str);
                    mBridgeBTNativeEC.setInstanceId(b3);
                    b2.put(b3, mBridgeBTNativeEC);
                    mBridgeBTNativeEC.preLoadData();
                    if (parseCampaignWithBackData == null) {
                        c(obj, "campaign is null");
                        q.a("OperateViews", "createNativeEC failed");
                        return;
                    }
                    a(obj, b3);
                    q.a("OperateViews", "createNativeEC instanceId = " + b3);
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            q.a("OperateViews", "createNativeEC failed：" + th.getMessage());
        }
    }

    public final void a(int i2, int i3, int i4, int i5, int i6) {
        q.a("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}));
        j = h.a(i2, i3, i4, i5, i6);
        k = i2;
        l = i3;
        m = i4;
        n = i5;
        o = i6;
    }

    static /* synthetic */ void a(c cVar, String str, CampaignEx campaignEx) {
        if (d.d != null && !TextUtils.isEmpty(campaignEx.getId())) {
            d.a(str, campaignEx, "reward");
        }
    }
}
