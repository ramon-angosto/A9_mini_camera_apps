package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.splash.d.a;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SplashSignalCommunicationImpl */
public final class b implements a {
    /* access modifiers changed from: private */
    public String a = "SplashSignalCommunicationImpl";
    private WeakReference<Context> b;
    private List<CampaignEx> c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int h = 5;
    private a i;
    private SplashExpandDialog j;

    public b(Context context, String str, String str2) {
        this.e = str;
        this.d = str2;
        this.b = new WeakReference<>(context);
    }

    public final void a(Context context) {
        this.b = new WeakReference<>(context);
    }

    public final void a(int i2) {
        this.g = i2;
    }

    public final void b(int i2) {
        this.h = i2;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.i = aVar;
        }
    }

    public final void a(List<CampaignEx> list) {
        this.c = list;
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.splash.a.a aVar = new com.mbridge.msdk.splash.a.a(com.mbridge.msdk.foundation.controller.a.e().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", aVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.c));
            d e2 = com.mbridge.msdk.b.b.a().e(com.mbridge.msdk.foundation.controller.a.e().h(), this.d);
            if (e2 == null) {
                e2 = d.d(this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                e2.g(this.e);
            }
            e2.a(this.d);
            e2.b(this.h);
            e2.a(this.g);
            jSONObject.put("unitSetting", e2.s());
            String c2 = com.mbridge.msdk.b.b.a().c(com.mbridge.msdk.foundation.controller.a.e().h());
            if (!TextUtils.isEmpty(c2)) {
                jSONObject.put("appSetting", new JSONObject(c2));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.a);
            String str2 = this.a;
            q.d(str2, "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            q.a(this.a, "init", th);
        }
    }

    public final void b(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                if (this.i != null) {
                    this.i.a(optInt);
                }
            }
        } catch (Throwable th) {
            q.a(this.a, "toggleCloseBtn", th);
        }
    }

    public final void c(Object obj, String str) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(obj, str);
        }
    }

    public final void d(Object obj, String str) {
        q.d(this.a, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        try {
            if (this.c != null && !TextUtils.isEmpty(str)) {
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(new JSONObject(str));
                if (this.i != null) {
                    this.i.a(parseCampaignWithBackData);
                }
            }
        } catch (Throwable th) {
            q.a(this.a, CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    public final void e(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = this.a;
        q.d(str2, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is null");
            return;
        }
        Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
        if (!TextUtils.isEmpty(str)) {
            if (g2 == null) {
                try {
                    if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) != null) {
                        g2 = windVaneWebView.getContext();
                    }
                } catch (Exception e2) {
                    q.d(this.a, e2.getMessage());
                }
            }
            if (g2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("url");
                    int optInt = jSONObject.optInt("type");
                    if (optInt == 1) {
                        com.mbridge.msdk.click.b.a(g2, optString);
                    } else if (optInt == 2) {
                        com.mbridge.msdk.click.b.b(g2, optString);
                    }
                } catch (JSONException e3) {
                    q.d(this.a, e3.getMessage());
                } catch (Throwable th) {
                    q.d(this.a, th.getMessage());
                }
            }
        }
    }

    public final void f(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                int i2 = new JSONObject(str).getInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_COUNTDOWN);
                if (this.i != null) {
                    this.i.b(i2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void open(String str) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    public final void close() {
        q.d(this.a, "close");
        try {
            if (this.i != null) {
                this.i.a();
            }
        } catch (Throwable th) {
            q.a(this.a, "close", th);
        }
    }

    public final void unload() {
        close();
    }

    public final void useCustomClose(boolean z) {
        int i2 = z ? 2 : 1;
        try {
            if (this.i != null) {
                this.i.a(i2);
            }
        } catch (Throwable th) {
            q.a(this.a, "useCustomClose", th);
        }
    }

    public final void expand(String str, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            if (this.b != null && this.b.get() != null) {
                if (this.j == null || !this.j.isShowing()) {
                    this.j = new SplashExpandDialog((Context) this.b.get(), bundle, this.i);
                    this.j.setCampaignList(this.d, this.c);
                    this.j.show();
                    if (this.i != null) {
                        this.i.a(true);
                    }
                    com.mbridge.msdk.splash.e.a.a(this.d, (this.c == null || this.c.size() <= 0) ? null : this.c.get(0), str);
                }
            }
        } catch (Throwable th) {
            q.a(this.a, "expand", th);
        }
    }

    public final void g(Object obj, String str) {
        String str2 = this.a;
        q.a(str2, "sendImpressions:" + str);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                final ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    for (CampaignEx next : this.c) {
                        if (next.getId().equals(string)) {
                            com.mbridge.msdk.foundation.same.a.d.a(this.d, next, "splash");
                            arrayList.add(string);
                        }
                    }
                }
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            j a2 = j.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                a2.b((String) it.next());
                            }
                        } catch (Exception unused) {
                            q.d(b.this.a, "campain can't insert db");
                        }
                    }
                }).start();
            }
        } catch (Throwable th) {
            q.a(this.a, "sendImpressions", th);
        }
    }

    public final void h(Object obj, String str) {
        q.a(this.a, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), (CampaignEx) null, "", jSONObject.optString("url"), false, jSONObject.optInt("type") != 0);
                }
                g.a().a(obj, c.a(0));
            } catch (Throwable th) {
                q.a(this.a, "reportUrls", th);
            }
        }
    }

    public final void i(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a);
            }
        } catch (Throwable th) {
            q.a(this.a, "onSignalCommunication", th);
        }
    }
}
