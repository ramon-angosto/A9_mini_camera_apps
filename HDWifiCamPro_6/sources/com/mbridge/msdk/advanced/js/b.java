package com.mbridge.msdk.advanced.js;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.communication.a;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeAdvancedSignalCommunicationImpl */
public final class b extends a {
    /* access modifiers changed from: private */
    public String b = "NativeAdvancedSignalCommunicationImpl";
    private WeakReference<Context> c;
    private List<CampaignEx> d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i = 5;
    private com.mbridge.msdk.advanced.c.a j;
    private NativeAdvancedExpandDialog k;

    public b(Context context, String str, String str2) {
        this.f = str;
        this.e = str2;
        this.c = new WeakReference<>(context);
    }

    public final void a(int i2) {
        this.h = i2;
    }

    public final void b(int i2) {
        this.i = i2;
    }

    public final void a(com.mbridge.msdk.advanced.c.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    public final void a(List<CampaignEx> list) {
        this.d = list;
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.advanced.common.a aVar = new com.mbridge.msdk.advanced.common.a(com.mbridge.msdk.foundation.controller.a.e().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.g);
            jSONObject2.put("customURLScheme", 1);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", aVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.d));
            d f2 = com.mbridge.msdk.b.b.a().f(com.mbridge.msdk.foundation.controller.a.e().h(), this.e);
            if (f2 == null) {
                f2 = d.c(this.e);
            }
            if (!TextUtils.isEmpty(this.f)) {
                f2.g(this.f);
            }
            f2.a(this.e);
            f2.b(this.i);
            f2.a(this.h);
            jSONObject.put("unitSetting", f2.s());
            String c2 = com.mbridge.msdk.b.b.a().c(com.mbridge.msdk.foundation.controller.a.e().h());
            if (!TextUtils.isEmpty(c2)) {
                jSONObject.put("appSetting", new JSONObject(c2));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.a);
            String str2 = this.b;
            q.d(str2, "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            q.a(this.b, "init", th);
        }
    }

    public final void b(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(new JSONObject(str).getJSONObject("pt"));
                if (this.j != null) {
                    this.j.a(parseCampaignWithBackData);
                }
            }
        } catch (Throwable th) {
            q.a(this.b, CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.Object r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof com.mbridge.msdk.mbsignalcommon.windvane.a     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0030
            com.mbridge.msdk.mbsignalcommon.windvane.a r3 = (com.mbridge.msdk.mbsignalcommon.windvane.a) r3     // Catch:{ all -> 0x0026 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r3 = r3.a     // Catch:{ all -> 0x0026 }
            if (r3 == 0) goto L_0x0030
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x001d }
            r0.<init>(r4)     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.mbsignalcommon.windvane.d r4 = r3.getWebViewListener()     // Catch:{ Exception -> 0x001d }
            java.lang.String r1 = "isReady"
            int r0 = r0.getInt(r1)     // Catch:{ Exception -> 0x001d }
            r4.a((android.webkit.WebView) r3, (int) r0)     // Catch:{ Exception -> 0x001d }
            goto L_0x0030
        L_0x001d:
            com.mbridge.msdk.mbsignalcommon.windvane.d r4 = r3.getWebViewListener()     // Catch:{ all -> 0x0026 }
            r0 = 2
            r4.a((android.webkit.WebView) r3, (int) r0)     // Catch:{ all -> 0x0026 }
            goto L_0x0030
        L_0x0026:
            r3 = move-exception
            java.lang.String r4 = r2.b
            java.lang.String r3 = r3.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r4, r3)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.advanced.js.b.c(java.lang.Object, java.lang.String):void");
    }

    public final void d(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                if (this.j != null) {
                    this.j.a(optInt);
                }
            }
        } catch (Throwable th) {
            q.a(this.b, "toggleCloseBtn", th);
        }
    }

    public final void e(Object obj, String str) {
        if (this.j != null) {
            a.a(obj);
            this.j.a(obj, str);
        }
    }

    public final void f(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a);
            }
        } catch (Throwable th) {
            q.a(this.b, "onSignalCommunicationConnect", th);
        }
    }

    public final void g(Object obj, String str) {
        q.d(this.b, "install");
        try {
            if (!TextUtils.isEmpty(str)) {
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(new JSONObject(str).optJSONObject("pt"));
                if (this.j != null) {
                    this.j.a(parseCampaignWithBackData);
                }
            }
        } catch (Throwable th) {
            q.a(this.b, "install", th);
        }
    }

    public final void h(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                int i2 = new JSONObject(str).getInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_COUNTDOWN);
                if (this.j != null) {
                    this.j.b(i2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void open(String str) {
        com.mbridge.msdk.advanced.c.a aVar = this.j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    public final void close() {
        q.d(this.b, "close");
        try {
            if (this.j != null) {
                this.j.a();
            }
        } catch (Throwable th) {
            q.a(this.b, "close", th);
        }
    }

    public final void unload() {
        close();
    }

    public final void useCustomClose(boolean z) {
        try {
            if (this.h == -1) {
                int i2 = z ? 2 : 1;
                if (this.j != null) {
                    this.j.a(i2);
                }
            }
        } catch (Throwable th) {
            q.a(this.b, "useCustomClose", th);
        }
    }

    public final void expand(String str, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            if (this.c != null && this.c.get() != null) {
                if (this.k == null || !this.k.isShowing()) {
                    this.k = new NativeAdvancedExpandDialog((Context) this.c.get(), bundle, this.j);
                    this.k.setCampaignList(this.e, this.d);
                    this.k.show();
                    if (this.j != null) {
                        this.j.a(true);
                    }
                    com.mbridge.msdk.advanced.d.a.a(this.e, (this.d == null || this.d.size() <= 0) ? null : this.d.get(0), str);
                }
            }
        } catch (Throwable th) {
            q.a(this.b, "expand", th);
        }
    }

    public final void i(Object obj, String str) {
        String str2 = this.b;
        q.a(str2, "sendImpressions:" + str);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                final ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    for (CampaignEx next : this.d) {
                        if (next.getId().equals(string)) {
                            com.mbridge.msdk.foundation.same.a.d.a(this.e, next, "h5_native");
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
                            q.d(b.this.b, "campain can't insert db");
                        }
                    }
                }).start();
            }
        } catch (Throwable th) {
            q.a(this.b, "sendImpressions", th);
        }
    }

    public final void j(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is empty");
            return;
        }
        try {
            a.a(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.a(this.b, th.getMessage());
        }
    }
}
