package com.mbridge.msdk.mbbanner.common.bridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.mbsignalcommon.communication.b;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BannerSignalCommunicationImpl */
public final class a extends com.mbridge.msdk.mbsignalcommon.communication.a {
    private WeakReference<Context> b;
    private List<CampaignEx> c;
    private String d;
    private String e;
    private int f;
    private com.mbridge.msdk.mbbanner.common.b.a g;
    private BannerExpandDialog h;
    private boolean i = false;

    public a(Context context, String str, String str2) {
        this.d = str;
        this.e = str2;
        this.b = new WeakReference<>(context);
    }

    public final void a(com.mbridge.msdk.mbbanner.common.b.a aVar) {
        if (aVar != null) {
            this.g = aVar;
        }
    }

    public final void a(List<CampaignEx> list) {
        this.c = list;
    }

    public final void a(int i2) {
        this.f = i2;
    }

    public final void a() {
        if (this.g != null) {
            this.g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    public final void c(Object obj, String str) {
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                g.a().a(obj, b.a(0));
                if (this.g != null) {
                    this.g.b(optInt);
                }
            } catch (Throwable th) {
                q.a("BannerSignalCommunicationImpl", "readyStatus", th);
            }
        }
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.foundation.tools.b bVar = new com.mbridge.msdk.foundation.tools.b(com.mbridge.msdk.foundation.controller.a.e().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", bVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.c));
            d e2 = com.mbridge.msdk.b.b.a().e(com.mbridge.msdk.foundation.controller.a.e().h(), this.e);
            if (e2 == null) {
                e2 = d.d(this.e);
            }
            if (!TextUtils.isEmpty(this.d)) {
                e2.g(this.d);
            }
            jSONObject.put("unitSetting", e2.s());
            String c2 = com.mbridge.msdk.b.b.a().c(com.mbridge.msdk.foundation.controller.a.e().h());
            if (!TextUtils.isEmpty(c2)) {
                jSONObject.put("appSetting", new JSONObject(c2));
            }
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", "init", th);
        }
    }

    public final void b(Object obj, String str) {
        q.d("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        try {
            if (this.c != null && !TextUtils.isEmpty(str)) {
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(new JSONObject(str).getJSONObject("pt"));
                if (this.g != null) {
                    this.g.a(parseCampaignWithBackData);
                }
            }
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    public final void d(Object obj, String str) {
        q.d("BannerSignalCommunicationImpl", "toggleCloseBtn");
        try {
            if (!TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                if (this.g != null) {
                    this.g.a(optInt);
                }
            }
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", "toggleCloseBtn", th);
        }
    }

    public final void e(Object obj, String str) {
        q.d("BannerSignalCommunicationImpl", "triggerCloseBtn");
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                if (this.g != null) {
                    this.g.a(optString);
                }
                g.a().a(obj, b.a(0));
            }
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", "triggerCloseBtn", th);
            g.a().a(obj, b.a(-1));
        }
    }

    public final void i(Object obj, String str) {
        q.a("BannerSignalCommunicationImpl", "sendImpressions:" + str);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                final ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    for (CampaignEx next : this.c) {
                        if (next.getId().equals(string)) {
                            com.mbridge.msdk.foundation.same.a.d.a(this.e, next, "banner");
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
                        } catch (Exception e) {
                            q.d("BannerSignalCommunicationImpl", e.getMessage());
                        }
                    }
                }).start();
            }
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", "sendImpressions", th);
        }
    }

    public final void open(String str) {
        q.d("BannerSignalCommunicationImpl", "open");
        try {
            q.d("BannerSignalCommunicationImpl", str);
            if (this.c.size() > 1) {
                com.mbridge.msdk.foundation.controller.a.e().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            if (this.g != null) {
                this.g.a(true, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", "open", th);
        }
    }

    public final void close() {
        q.d("BannerSignalCommunicationImpl", "close");
        try {
            if (this.g != null) {
                this.g.a();
            }
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", "close", th);
        }
    }

    public final void unload() {
        close();
    }

    private CampaignEx b() {
        List<CampaignEx> list = this.c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.c.get(0);
    }

    public final void useCustomClose(boolean z) {
        int i2 = z ? 2 : 1;
        try {
            if (this.g != null) {
                this.g.a(i2);
            }
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", "useCustomClose", th);
        }
    }

    public final void expand(String str, boolean z) {
        Context context;
        String str2 = "";
        try {
            if (b() != null) {
                if (TextUtils.isEmpty(b().getBannerHtml())) {
                    str2 = b().getBannerUrl();
                } else {
                    str2 = "file:////" + b().getBannerHtml();
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            bundle.putString("url", str2);
            bundle.putBoolean("shouldUseCustomClose", z);
            if (!(this.b == null || (context = (Context) this.b.get()) == null)) {
                if (this.h == null || !this.h.isShowing()) {
                    this.h = new BannerExpandDialog(context, bundle, this.g);
                    this.h.setCampaignList(this.e, this.c);
                    this.h.show();
                } else {
                    return;
                }
            }
            if (this.g != null) {
                this.g.a(true);
            }
            com.mbridge.msdk.mbbanner.common.d.a.a(this.e, b(), str);
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", "expand", th);
        }
    }

    public final void j(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th) {
            q.a("BannerSignalCommunicationImpl", th.getMessage());
        }
    }

    private static void a(Object obj, JSONObject jSONObject) {
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
                q.a("BannerSignalCommunicationImpl", e2.getMessage());
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
                            q.a("BannerSignalCommunicationImpl", e.getMessage());
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
                            q.a("BannerSignalCommunicationImpl", e5.getMessage());
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
                                l a = o.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g())).a(optString);
                                if (a != null) {
                                    i2 = length;
                                    q.a("BannerSignalCommunicationImpl", "VideoBean not null");
                                    jSONObject6.put("type", 1);
                                    str3 = str8;
                                    try {
                                        jSONObject6.put("videoDataLength", a.c());
                                        String e6 = a.e();
                                        str4 = str9;
                                        if (TextUtils.isEmpty(e6)) {
                                            q.a("BannerSignalCommunicationImpl", "VideoPath null");
                                            jSONObject6.put("path", "");
                                            jSONObject6.put("path4Web", "");
                                        } else {
                                            q.a("BannerSignalCommunicationImpl", "VideoPath not null");
                                            jSONObject6.put("path", e6);
                                            jSONObject6.put("path4Web", e6);
                                        }
                                        if (a.d() == 5) {
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
                                    q.a("BannerSignalCommunicationImpl", "VideoBean null");
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
                            if (com.mbridge.msdk.videocommon.download.g.a().a(optString) == null) {
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
                                    q.a("BannerSignalCommunicationImpl", "getFileInfo Mraid file " + optString);
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
}
