package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.model.h;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.com.bytedance.overseas.sdk.a.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: WebHelper */
public class w {
    private static boolean a = false;

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a(Context context, n nVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str, c cVar, boolean z) {
        String str2;
        String str3;
        Context context2 = context;
        n nVar2 = nVar;
        String str4 = str;
        if (context2 == null || nVar2 == null || i == -1) {
            return false;
        }
        h ab = nVar.ab();
        if (ab != null) {
            String a2 = ab.a();
            if (!TextUtils.isEmpty(a2)) {
                Uri parse = Uri.parse(ab.a());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (!y.i(context)) {
                    try {
                        if (m.d().h()) {
                            y.a(nVar, str4);
                        }
                        if (!(context2 instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        com.bytedance.sdk.openadsdk.c.c.d(context, nVar, str4, "open_url_app", (Map<String, Object>) null);
                        context.startActivity(intent);
                        j.a().a(nVar, str4);
                        return true;
                    } catch (Throwable unused) {
                        a2 = nVar.O();
                    }
                } else if (y.a(context, intent)) {
                    if (m.d().h()) {
                        y.a(nVar, str4);
                    }
                    if (!(context2 instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    final Context context3 = context;
                    final n nVar3 = nVar;
                    final int i2 = i;
                    final String str5 = str;
                    final boolean z2 = z;
                    b.a(context, intent, new b.a() {
                        public void a() {
                        }

                        public void a(Throwable th) {
                            if (!m.d().h()) {
                                w.a(context3, nVar3.O(), nVar3, i2, str5, z2);
                                l.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                            }
                        }
                    });
                    com.bytedance.sdk.openadsdk.c.c.d(context, nVar, str4, "open_url_app", (Map<String, Object>) null);
                    j.a().a(nVar, str4);
                    return true;
                }
            }
            if (ab.c() != 2 || nVar.ad() == 5 || nVar.ad() == 15) {
                if (ab.c() == 1) {
                    a2 = ab.b();
                } else {
                    a2 = nVar.O();
                }
            } else if (cVar != null) {
                if (cVar.a()) {
                    com.bytedance.sdk.openadsdk.c.c.d(context, nVar, str4, "open_fallback_url", (Map<String, Object>) null);
                    return true;
                } else if (cVar.e()) {
                    com.bytedance.sdk.openadsdk.c.c.d(context, nVar, str4, "open_fallback_url", (Map<String, Object>) null);
                    return true;
                } else {
                    com.bytedance.sdk.openadsdk.c.c.d(context, nVar, str4, "open_fallback_url", (Map<String, Object>) null);
                    return false;
                }
            }
            com.bytedance.sdk.openadsdk.c.c.d(context, nVar, str4, "open_fallback_url", (Map<String, Object>) null);
            str2 = a2;
        } else {
            if (!nVar.aw() || nVar.ax() == null) {
                str3 = nVar.O();
            } else {
                str3 = nVar.ax().i();
            }
            str2 = str3;
        }
        return a(context, nVar, i, pAGNativeAd, pangleAd, str, z, str2);
    }

    public static boolean a(Context context, n nVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str, boolean z, String str2) {
        Context context2 = context;
        if (TextUtils.isEmpty(str2) && !p.a(nVar)) {
            return false;
        }
        if (nVar.L() != 2) {
            b.a(context, a(context, str2, nVar, i, pAGNativeAd, pangleAd, str, z), (b.a) null);
            a = false;
            return true;
        } else if (!o.a(str2)) {
            return false;
        } else {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.setData(Uri.parse(str2));
                if (!(context2 instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                b.a(context, intent, (b.a) null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static boolean a(Context context, String str, n nVar, int i, String str2, boolean z) {
        try {
            context.startActivity(a(context, str, nVar, i, (PAGNativeAd) null, (PangleAd) null, str2, z));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(Context context, String str, n nVar, int i, String str2, boolean z) {
        try {
            context.startActivity(a(context, str, nVar, i, (PAGNativeAd) null, (PangleAd) null, str2, z, true));
        } catch (Throwable unused) {
        }
    }

    private static Intent a(Context context, String str, n nVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z) {
        return a(context, str, nVar, i, pAGNativeAd, pangleAd, str2, z, false);
    }

    private static Intent a(Context context, String str, n nVar, int i, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z, boolean z2) {
        Intent intent;
        if (z2 || !p.a(nVar) || (pAGNativeAd == null && pangleAd == null)) {
            intent = (z2 || nVar.L() != 3 || (nVar.f() != 2 && (nVar.f() != 1 || !a)) || nVar.a) ? new Intent(context, TTLandingPageActivity.class) : new Intent(context, TTVideoLandingPageLink2Activity.class);
        } else {
            intent = new Intent(context, TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", a(nVar, z));
            String c = p.c(nVar);
            if (!TextUtils.isEmpty(c)) {
                if (c.contains("?")) {
                    str = c + "&orientation=portrait";
                } else {
                    str = c + "?orientation=portrait";
                }
            }
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", nVar.af());
        intent.putExtra("web_title", nVar.U());
        intent.putExtra("sdk_version", BuildConfig.VERSION_CODE);
        intent.putExtra("adid", nVar.Y());
        intent.putExtra("log_extra", nVar.ac());
        a aVar = null;
        intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, nVar.M() == null ? null : nVar.M().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, nVar.ar().toString());
        } else {
            r.a().h();
            r.a().a(nVar);
        }
        if (nVar.ad() == 5 || nVar.ad() == 15 || nVar.ad() == 50) {
            if (pAGNativeAd != null) {
                if (pAGNativeAd instanceof a.C0055a) {
                    aVar = ((a.C0055a) pAGNativeAd).g();
                }
                if (aVar != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
                }
            }
            if ((pangleAd instanceof com.bytedance.sdk.openadsdk.core.bannerexpress.c) && (aVar = ((com.bytedance.sdk.openadsdk.core.bannerexpress.c) pangleAd).g()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, aVar.a().toString());
            }
            if (aVar != null) {
                intent.putExtra("video_is_auto_play", aVar.d);
                if (l.d()) {
                    l.c("videoDataModel", "videoDataModel=" + aVar.a().toString());
                }
            }
        }
        return intent;
    }

    private static boolean a(n nVar, boolean z) {
        if (z && nVar != null && nVar.L() == 4 && p.a(nVar)) {
            return true;
        }
        return false;
    }
}
