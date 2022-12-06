package com.unad.sdk;

import android.content.Context;
import android.util.Log;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unad.sdk.tool.AdInfoListener;
import com.unad.sdk.util.GsonUtils;
import com.unad.sdk.util.c;
import com.unad.sdk.util.d;
import java.util.Map;
import okhttp3.Call;
import org.json.JSONObject;

/* compiled from: AdInfoManager */
public class a {
    private static a a = null;
    protected static AdInfo b = null;
    protected static boolean c = true;

    /* renamed from: com.unad.sdk.a$a  reason: collision with other inner class name */
    /* compiled from: AdInfoManager */
    static class C0108a extends c {
        final /* synthetic */ com.unad.sdk.util.b a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0108a(Context context, com.unad.sdk.util.b bVar) {
            super(context);
            this.a = bVar;
        }

        public void a(Call call, Exception exc) {
        }

        public void a(Call call, String str) {
            try {
                String string = new JSONObject(str).getString(IronSourceConstants.EVENTS_RESULT);
                this.a.a(com.unad.sdk.util.b.d, string);
                UNAD.serviceId = string;
            } catch (Exception unused) {
            }
        }
    }

    private a() {
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str) {
        AdInfo adInfo;
        try {
            com.unad.sdk.util.b bVar = new com.unad.sdk.util.b(context);
            String b2 = bVar.b(com.unad.sdk.util.b.d, "");
            if (!"".equals(b2) || (adInfo = b) == null || !adInfo.isGetServiceId()) {
                UNAD.serviceId = b2;
                return;
            }
            String idServer = (b.getIdServer() == null || b.getIdServer().length() <= 0) ? "http://developer.adgo.link:8083/ad/serial/" : b.getIdServer();
            d.a(idServer + str, (Map<String, String>) null, new C0108a(context, bVar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* compiled from: AdInfoManager */
    static class b extends c {
        final /* synthetic */ boolean a;
        final /* synthetic */ AdInfoListener b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;
        final /* synthetic */ boolean e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, boolean z, AdInfoListener adInfoListener, String str, Context context2, boolean z2) {
            super(context);
            this.a = z;
            this.b = adInfoListener;
            this.c = str;
            this.d = context2;
            this.e = z2;
        }

        public void a(Call call, Exception exc) {
            AdInfoListener adInfoListener;
            if (this.a && (adInfoListener = this.b) != null) {
                adInfoListener.error("-1", exc.getMessage());
            }
        }

        public void a(Call call, String str) {
            AdInfoListener adInfoListener;
            AdInfoListener adInfoListener2;
            AdInfoListener adInfoListener3;
            try {
                AdInfo adInfo = (AdInfo) GsonUtils.GsonToBean(str, AdInfo.class);
                a.b = adInfo;
                if (this.c.equals(adInfo.getAppId())) {
                    com.unad.sdk.util.b bVar = new com.unad.sdk.util.b(this.d);
                    bVar.a("ADINFO" + this.c, str);
                    if (this.a && (adInfoListener3 = this.b) != null) {
                        adInfoListener3.onAdLoadOk();
                    }
                } else if (this.a && (adInfoListener2 = this.b) != null) {
                    adInfoListener2.error(a.b.getStatus(), a.b.getDes());
                }
                a.b(this.d, this.c);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (this.a && (adInfoListener = this.b) != null) {
                    if (this.e) {
                        adInfoListener.error("99999", "Network error or AppId is invalid!");
                        return;
                    }
                    adInfoListener.error("-1", e2.toString() + " exception");
                }
            }
        }
    }

    protected static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    protected static void a(String str, Context context, AdInfoListener adInfoListener) {
        com.unad.sdk.util.b bVar = new com.unad.sdk.util.b(context);
        String b2 = bVar.b("ADINFO" + str, "");
        if ("".equals(b2)) {
            c = false;
            a(str, "https://unad.oss-accelerate.aliyuncs.com/" + str + ".json", context, true, adInfoListener, true);
            return;
        }
        try {
            b = (AdInfo) GsonUtils.GsonToBean(b2, AdInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdInfo adInfo = b;
        if (adInfo == null || !str.equals(adInfo.getAppId())) {
            c = false;
            a(str, "https://unad.oss-accelerate.aliyuncs.com/" + str + ".json", context, true, adInfoListener, false);
            return;
        }
        String b3 = bVar.b(com.unad.sdk.util.b.d, "");
        if (!"".equals(b3)) {
            UNAD.serviceId = b3;
        }
        adInfoListener.onAdLoadOk();
    }

    protected static void a(Context context) {
        if (c) {
            c = false;
            Log.i("UNAD_SDK", "update config");
            String str = UNAD.APPID;
            a(str, "https://unad.oss-accelerate.aliyuncs.com/" + UNAD.APPID + ".json", context, false, (AdInfoListener) null, false);
        }
    }

    private static void a(String str, String str2, Context context, boolean z, AdInfoListener adInfoListener, boolean z2) {
        d.a(str2, (Map<String, String>) null, new b(context, z, adInfoListener, str, context, z2));
    }
}
