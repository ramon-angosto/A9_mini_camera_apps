package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.adexpress.d.e;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebviewTimeTrack */
public class m {
    /* access modifiers changed from: private */
    public String a = "embeded_ad";
    /* access modifiers changed from: private */
    public n b;
    private Boolean c = false;
    /* access modifiers changed from: private */
    public Boolean d = false;
    private Boolean e = false;
    /* access modifiers changed from: private */
    public JSONObject f;
    /* access modifiers changed from: private */
    public JSONArray g;
    /* access modifiers changed from: private */
    public JSONArray h;

    protected m() {
    }

    public m(int i, String str, n nVar) {
        this.a = str;
        this.b = nVar;
        this.f = new JSONObject();
        this.g = new JSONArray();
        this.h = new JSONArray();
        a(this.f, "webview_source", (Object) Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public void a(JSONArray jSONArray, Object obj) {
        if (jSONArray != null && jSONArray.length() < 10) {
            try {
                jSONArray.put(obj);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj) {
        a(jSONObject, str, obj, true);
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            if (!z) {
                try {
                    if (jSONObject.has(str)) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put(str, obj);
        }
    }

    /* access modifiers changed from: private */
    public boolean q() {
        return this.e.booleanValue() || (this.d.booleanValue() && this.c.booleanValue());
    }

    public void a() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(jSONObject, "render_sequence", (Object) Integer.valueOf(mVar.b.q()));
                m.this.a(jSONObject, "webview_count", (Object) Integer.valueOf(e.a().e()));
                m.this.a(jSONObject, "available_cache_count", (Object) Integer.valueOf(e.a().d()));
                m mVar2 = m.this;
                mVar2.a(mVar2.f, "render_start", (Object) jSONObject);
            }
        });
    }

    public void a(final int i) {
        h.a().post(new Runnable() {
            public void run() {
                m.this.a(i, (String) null);
            }
        });
    }

    public void a(final int i, final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m.this.a(jSONObject, "code", (Object) Integer.valueOf(i));
                String str = str;
                if (str != null) {
                    m.this.a(jSONObject, NotificationCompat.CATEGORY_MESSAGE, (Object) str);
                }
                m mVar = m.this;
                mVar.a(mVar.f, "render_error", (Object) jSONObject);
            }
        });
    }

    public void a(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                    m.this.a(jSONObject, "jsb", (Object) str);
                    m mVar = m.this;
                    mVar.a(mVar.f, "webview_jsb_start", (Object) jSONObject);
                }
            }
        });
    }

    public void a(String str, long j, long j2, int i) {
        final String str2 = str;
        final long j3 = j2;
        final long j4 = j;
        final int i2 = i;
        h.a().post(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str2) && j3 >= j4) {
                    JSONObject jSONObject = new JSONObject();
                    m.this.a(jSONObject, "start_ts", (Object) Long.valueOf(j4));
                    m.this.a(jSONObject, "end_ts", (Object) Long.valueOf(j3));
                    m.this.a(jSONObject, "intercept_type", (Object) Integer.valueOf(i2));
                    m.this.a(jSONObject, "type", (Object) "intercept_html");
                    m.this.a(jSONObject, "url", (Object) str2);
                    m.this.a(jSONObject, IronSourceConstants.EVENTS_DURATION, (Object) Long.valueOf(j3 - j4));
                    m mVar = m.this;
                    mVar.a(mVar.h, (Object) jSONObject);
                }
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        h.a().post(new Runnable() {
            public void run() {
                JSONObject jSONObject = jSONObject;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(System.currentTimeMillis()));
                m mVar = m.this;
                mVar.a(mVar.f, "webview_load_error", (Object) jSONObject);
            }
        });
    }

    public void a(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    public void b() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "render_success", (Object) jSONObject);
            }
        });
    }

    public void b(final int i) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m.this.a(jSONObject, "isWebViewCache", (Object) Integer.valueOf(i));
                m mVar = m.this;
                mVar.a(mVar.f, "before_webview_request", (Object) jSONObject);
            }
        });
    }

    public void b(final int i, final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m.this.a(jSONObject, "code", (Object) Integer.valueOf(i));
                m mVar = m.this;
                mVar.a(mVar.f, str, (Object) jSONObject);
            }
        });
    }

    public void b(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                    m.this.a(jSONObject, "jsb", (Object) str);
                    m mVar = m.this;
                    mVar.a(mVar.f, "webview_jsb_end", (Object) jSONObject);
                }
            }
        });
    }

    public void b(String str, long j, long j2, int i) {
        final String str2 = str;
        final long j3 = j2;
        final long j4 = j;
        final int i2 = i;
        h.a().post(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str2) && j3 >= j4) {
                    JSONObject jSONObject = new JSONObject();
                    m.this.a(jSONObject, "start_ts", (Object) Long.valueOf(j4));
                    m.this.a(jSONObject, "end_ts", (Object) Long.valueOf(j3));
                    m.this.a(jSONObject, "intercept_type", (Object) Integer.valueOf(i2));
                    m.this.a(jSONObject, "type", (Object) "intercept_js");
                    m.this.a(jSONObject, "url", (Object) str2);
                    m.this.a(jSONObject, IronSourceConstants.EVENTS_DURATION, (Object) Long.valueOf(j3 - j4));
                    m mVar = m.this;
                    mVar.a(mVar.h, (Object) jSONObject);
                }
            }
        });
    }

    public void b(final JSONObject jSONObject) {
        h.a().post(new Runnable() {
            public void run() {
                JSONObject jSONObject;
                if (m.this.f != null && (jSONObject = jSONObject) != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        m mVar = m.this;
                        mVar.a(mVar.f, next, jSONObject.opt(next));
                    }
                    Boolean unused = m.this.d = true;
                    m.this.m();
                }
            }
        });
    }

    public void c() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "native_render_start", (Object) jSONObject);
            }
        });
    }

    public void c(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, str, (Object) jSONObject);
            }
        });
    }

    public void d() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "native_render_end", (Object) jSONObject);
            }
        });
    }

    public void d(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, str, (Object) jSONObject);
            }
        });
    }

    public void e() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "webview_load_start", (Object) jSONObject, false);
            }
        });
    }

    public void e(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, str, (Object) jSONObject);
            }
        });
    }

    public void f() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "webview_load_success", (Object) jSONObject);
            }
        });
    }

    public void g() {
        h.a().post(new Runnable() {
            public void run() {
                m.this.a((JSONObject) null);
            }
        });
    }

    public void h() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "native_endcard_show", (Object) jSONObject);
            }
        });
    }

    public void i() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "native_endcard_close", (Object) jSONObject);
            }
        });
    }

    public void j() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m.this.a(jSONObject, "type", (Object) "native_enterBackground");
                m mVar = m.this;
                mVar.a(mVar.g, (Object) jSONObject);
            }
        });
    }

    public void k() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m.this.a(jSONObject, "type", (Object) "native_enterForeground");
                m mVar = m.this;
                mVar.a(mVar.g, (Object) jSONObject);
            }
        });
    }

    public void l() {
        this.c = true;
    }

    public void m() {
        h.a().post(new Runnable() {
            public void run() {
                if (m.this.q()) {
                    if (!(m.this.g == null || m.this.g.length() == 0)) {
                        try {
                            m.this.f.put("native_switchBackgroundAndForeground", m.this.g);
                        } catch (Exception unused) {
                        }
                    }
                    if (!(m.this.h == null || m.this.h.length() == 0)) {
                        try {
                            m.this.f.put("intercept_source", m.this.h);
                        } catch (Exception unused2) {
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("webview_time_track", m.this.f);
                    if (com.bytedance.sdk.openadsdk.core.h.d().s() && m.this.f != null) {
                        l.b("WebviewTimeTrack", m.this.f.toString());
                    }
                    c.c(com.bytedance.sdk.openadsdk.core.m.a(), m.this.b, m.this.a, "webview_time_track", (Map<String, Object>) hashMap);
                }
            }
        });
    }

    public void n() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "native_render_end", (Object) jSONObject);
                long currentTimeMillis2 = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                m.this.a(jSONObject2, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis2));
                m mVar2 = m.this;
                mVar2.a(mVar2.f, "render_success", (Object) jSONObject2);
            }
        });
    }

    public void o() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "no_native_render", (Object) jSONObject);
            }
        });
    }

    public void p() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                m.this.a(jSONObject, CampaignEx.JSON_KEY_ST_TS, (Object) Long.valueOf(currentTimeMillis));
                m mVar = m.this;
                mVar.a(mVar.f, "render_failed", (Object) jSONObject);
            }
        });
    }
}
