package com.bytedance.sdk.openadsdk.g.a;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.u;
import org.json.JSONObject;

/* compiled from: OldBridgeSyncMethod */
public class e extends com.bytedance.sdk.component.a.e<JSONObject, JSONObject> {
    private String a;
    private u b;

    public e(String str, u uVar) {
        this.b = uVar;
        this.a = str;
    }

    public static void a(r rVar, u uVar) {
        rVar.a("appInfo", (com.bytedance.sdk.component.a.e<?, ?>) new e("appInfo", uVar));
        rVar.a("adInfo", (com.bytedance.sdk.component.a.e<?, ?>) new e("adInfo", uVar));
        rVar.a("sendLog", (com.bytedance.sdk.component.a.e<?, ?>) new e("sendLog", uVar));
        rVar.a("playable_style", (com.bytedance.sdk.component.a.e<?, ?>) new e("playable_style", uVar));
        rVar.a("getTemplateInfo", (com.bytedance.sdk.component.a.e<?, ?>) new e("getTemplateInfo", uVar));
        rVar.a("getTeMaiAds", (com.bytedance.sdk.component.a.e<?, ?>) new e("getTeMaiAds", uVar));
        rVar.a("isViewable", (com.bytedance.sdk.component.a.e<?, ?>) new e("isViewable", uVar));
        rVar.a("getScreenSize", (com.bytedance.sdk.component.a.e<?, ?>) new e("getScreenSize", uVar));
        rVar.a("getCloseButtonInfo", (com.bytedance.sdk.component.a.e<?, ?>) new e("getCloseButtonInfo", uVar));
        rVar.a("getVolume", (com.bytedance.sdk.component.a.e<?, ?>) new e("getVolume", uVar));
        rVar.a("removeLoading", (com.bytedance.sdk.component.a.e<?, ?>) new e("removeLoading", uVar));
        rVar.a("sendReward", (com.bytedance.sdk.component.a.e<?, ?>) new e("sendReward", uVar));
        rVar.a("subscribe_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new e("subscribe_app_ad", uVar));
        rVar.a("download_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new e("download_app_ad", uVar));
        rVar.a("cancel_download_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new e("cancel_download_app_ad", uVar));
        rVar.a("unsubscribe_app_ad", (com.bytedance.sdk.component.a.e<?, ?>) new e("unsubscribe_app_ad", uVar));
        rVar.a("landscape_click", (com.bytedance.sdk.component.a.e<?, ?>) new e("landscape_click", uVar));
        rVar.a("clickEvent", (com.bytedance.sdk.component.a.e<?, ?>) new e("clickEvent", uVar));
        rVar.a("renderDidFinish", (com.bytedance.sdk.component.a.e<?, ?>) new e("renderDidFinish", uVar));
        rVar.a("dynamicTrack", (com.bytedance.sdk.component.a.e<?, ?>) new e("dynamicTrack", uVar));
        rVar.a("skipVideo", (com.bytedance.sdk.component.a.e<?, ?>) new e("skipVideo", uVar));
        rVar.a("muteVideo", (com.bytedance.sdk.component.a.e<?, ?>) new e("muteVideo", uVar));
        rVar.a("changeVideoState", (com.bytedance.sdk.component.a.e<?, ?>) new e("changeVideoState", uVar));
        rVar.a("getCurrentVideoState", (com.bytedance.sdk.component.a.e<?, ?>) new e("getCurrentVideoState", uVar));
        rVar.a("send_temai_product_ids", (com.bytedance.sdk.component.a.e<?, ?>) new e("send_temai_product_ids", uVar));
        rVar.a("getMaterialMeta", (com.bytedance.sdk.component.a.e<?, ?>) new e("getMaterialMeta", uVar));
        rVar.a("endcard_load", (com.bytedance.sdk.component.a.e<?, ?>) new e("endcard_load", uVar));
        rVar.a("pauseWebView", (com.bytedance.sdk.component.a.e<?, ?>) new e("pauseWebView", uVar));
        rVar.a("pauseWebViewTimers", (com.bytedance.sdk.component.a.e<?, ?>) new e("pauseWebViewTimers", uVar));
        rVar.a("webview_time_track", (com.bytedance.sdk.component.a.e<?, ?>) new e("webview_time_track", uVar));
        rVar.a("openPrivacy", (com.bytedance.sdk.component.a.e<?, ?>) new e("openPrivacy", uVar));
        rVar.a("openAdLandPageLinks", (com.bytedance.sdk.component.a.e<?, ?>) new e("openAdLandPageLinks", uVar));
        rVar.a("getNativeSiteCustomData", (com.bytedance.sdk.component.a.e<?, ?>) new e("getNativeSiteCustomData", uVar));
        rVar.a("close", (com.bytedance.sdk.component.a.e<?, ?>) new e("close", uVar));
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        while (true) {
            char c = '_';
            char c2 = '_';
            while (true) {
                switch (c) {
                    case '^':
                        if (c2 != '\'') {
                            break;
                        } else {
                            continue;
                        }
                    case '_':
                        switch (c2) {
                            case '^':
                            case '`':
                                continue;
                            case '_':
                                break;
                        }
                    case '`':
                        break;
                }
                switch (c2) {
                    case '7':
                    case '9':
                        break;
                    case '8':
                        break;
                }
                c = '^';
                c2 = '}';
            }
        }
        u.a aVar = new u.a();
        aVar.a = NotificationCompat.CATEGORY_CALL;
        aVar.c = this.a;
        aVar.d = jSONObject;
        return this.b.a(aVar, 3);
    }
}
