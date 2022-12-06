package com.bytedance.sdk.openadsdk.core.f;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.openadsdk.core.f.b.a;
import com.bytedance.sdk.openadsdk.core.f.b.b;
import com.bytedance.sdk.openadsdk.core.f.b.c;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VideoTrackers */
public class d {
    public List<c> a = new ArrayList();
    public List<c> b = new ArrayList();
    public List<c> c = new ArrayList();
    public List<c> d = new ArrayList();
    public List<c> e = new ArrayList();
    public List<c> f = new ArrayList();
    public List<c> g = new ArrayList();
    public List<c> h = new ArrayList();
    public List<c> i = new ArrayList();
    public List<c> j = new ArrayList();
    public List<b> k = new ArrayList();
    public List<a> l = new ArrayList();
    private a m;
    private final AtomicBoolean n = new AtomicBoolean(false);
    private final AtomicBoolean o = new AtomicBoolean(false);
    private long p;
    private n q;
    private boolean r;
    private boolean s;
    private boolean t;
    private String u;

    public d(a aVar) {
        this.m = aVar;
    }

    public void a(com.bytedance.sdk.openadsdk.core.f.a.a aVar) {
        a(-1, this.a, aVar);
    }

    public void a(long j2) {
        if (this.n.compareAndSet(false, true)) {
            a(j2, this.b, (com.bytedance.sdk.openadsdk.core.f.a.a) null, new c.b("show_impression", this.q));
        }
    }

    public void b(long j2) {
        a(j2, this.c, (com.bytedance.sdk.openadsdk.core.f.a.a) null);
    }

    public void c(long j2) {
        a(j2, this.d, (com.bytedance.sdk.openadsdk.core.f.a.a) null);
    }

    public void d(long j2) {
        a(j2, this.e, (com.bytedance.sdk.openadsdk.core.f.a.a) null, new c.b("video_progress", this.q, 1.0f));
    }

    public void e(long j2) {
        if (this.o.compareAndSet(false, true)) {
            a(j2, this.f, (com.bytedance.sdk.openadsdk.core.f.a.a) null);
        }
    }

    public void f(long j2) {
        a(j2, this.g, (com.bytedance.sdk.openadsdk.core.f.a.a) null);
    }

    public void g(long j2) {
        a(j2, this.h, (com.bytedance.sdk.openadsdk.core.f.a.a) null, new c.b(CampaignEx.JSON_NATIVE_VIDEO_CLICK, this.q));
    }

    public void h(long j2) {
        a(j2, this.i, (com.bytedance.sdk.openadsdk.core.f.a.a) null);
    }

    public void i(long j2) {
        a(j2, this.j, (com.bytedance.sdk.openadsdk.core.f.a.a) null);
    }

    public void a(long j2, long j3, f fVar) {
        if (System.currentTimeMillis() - this.p >= 1000 && j2 >= 0 && j3 > 0) {
            this.p = System.currentTimeMillis();
            float f2 = ((float) j2) / ((float) j3);
            List<c> a2 = a(j2, f2);
            float f3 = 0.25f;
            if (f2 >= 0.25f && !this.r) {
                b("firstQuartile");
                this.r = true;
                if (fVar != null) {
                    a(fVar, 6);
                }
            } else if (f2 >= 0.5f && !this.s) {
                b(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
                this.s = true;
                if (fVar != null) {
                    a(fVar, 7);
                }
                f3 = 0.5f;
            } else if (f2 < 0.75f || this.t) {
                f3 = f2;
            } else {
                b("thirdQuartile");
                this.t = true;
                if (fVar != null) {
                    a(fVar, 8);
                }
                f3 = 0.75f;
            }
            if (f3 < 0.03f) {
                f3 = 0.0f;
            }
            a(j2, a2, (com.bytedance.sdk.openadsdk.core.f.a.a) null, new c.b("video_progress", this.q, f3));
        }
    }

    private void a(final f fVar, final int i2) {
        h.b().post(new Runnable() {
            public void run() {
                f fVar = fVar;
                if (fVar != null) {
                    fVar.a(i2);
                }
            }
        });
    }

    private void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            com.bytedance.sdk.openadsdk.c.c.b(m.a(), this.q, this.u, "vast_play_track", jSONObject);
        } catch (Throwable unused) {
        }
    }

    private void a(long j2, List<c> list, com.bytedance.sdk.openadsdk.core.f.a.a aVar, c.b bVar) {
        a aVar2 = this.m;
        c.a(list, aVar, j2, aVar2 != null ? aVar2.g() : null, bVar);
    }

    private void a(long j2, List<c> list, com.bytedance.sdk.openadsdk.core.f.a.a aVar) {
        a(j2, list, aVar, (c.b) null);
    }

    public List<c> a(long j2, float f2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            b bVar = this.k.get(i2);
            if (bVar.a(f2)) {
                arrayList.add(bVar);
            }
        }
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            a aVar = this.l.get(i3);
            if (aVar.a(j2)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public void a(List<c> list) {
        this.b.addAll(list);
    }

    public void b(List<c> list) {
        this.c.addAll(list);
    }

    public void c(List<c> list) {
        this.d.addAll(list);
    }

    public void d(List<c> list) {
        this.e.addAll(list);
    }

    public void e(List<c> list) {
        this.f.addAll(list);
    }

    public void f(List<c> list) {
        this.g.addAll(list);
    }

    public void g(List<c> list) {
        this.h.addAll(list);
    }

    public void h(List<b> list) {
        this.k.addAll(list);
        Collections.sort(this.k);
    }

    public void i(List<a> list) {
        this.l.addAll(list);
        Collections.sort(this.l);
    }

    public void j(List<c> list) {
        this.a.addAll(list);
    }

    public void k(List<c> list) {
        this.i.addAll(list);
    }

    public void l(List<c> list) {
        this.j.addAll(list);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorTrackers", c.a(this.a));
        jSONObject.put("impressionTrackers", c.a(this.b));
        jSONObject.put("pauseTrackers", c.a(this.c));
        jSONObject.put("resumeTrackers", c.a(this.d));
        jSONObject.put("completeTrackers", c.a(this.e));
        jSONObject.put("closeTrackers", c.a(this.f));
        jSONObject.put("skipTrackers", c.a(this.g));
        jSONObject.put("clickTrackers", c.a(this.h));
        jSONObject.put("muteTrackers", c.a(this.i));
        jSONObject.put("unMuteTrackers", c.a(this.j));
        jSONObject.put("fractionalTrackers", b());
        jSONObject.put("absoluteTrackers", c());
        return jSONObject;
    }

    private JSONArray b() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (b b2 : this.k) {
            jSONArray.put(b2.b());
        }
        return jSONArray;
    }

    private JSONArray c() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (a a2 : this.l) {
            jSONArray.put(a2.a());
        }
        return jSONArray;
    }

    public void a(JSONObject jSONObject) {
        j(c.a(jSONObject.optJSONArray("errorTrackers")));
        a(c.a(jSONObject.optJSONArray("impressionTrackers")));
        b(c.a(jSONObject.optJSONArray("pauseTrackers"), true));
        c(c.a(jSONObject.optJSONArray("resumeTrackers"), true));
        d(c.a(jSONObject.optJSONArray("completeTrackers")));
        e(c.a(jSONObject.optJSONArray("closeTrackers")));
        f(c.a(jSONObject.optJSONArray("skipTrackers")));
        g(c.a(jSONObject.optJSONArray("clickTrackers")));
        k(c.a(jSONObject.optJSONArray("muteTrackers"), true));
        l(c.a(jSONObject.optJSONArray("unMuteTrackers"), true));
        h(c.b(jSONObject.optJSONArray("fractionalTrackers")));
        i(c.c(jSONObject.optJSONArray("absoluteTrackers")));
    }

    public void a(n nVar) {
        this.q = nVar;
    }

    public void a(String str) {
        this.u = str;
    }

    public void a(String str, long j2) {
        if (!TextUtils.isEmpty(str) && j2 >= 0) {
            i((List<a>) Collections.singletonList(new a.C0046a(str, j2).a()));
        }
    }

    public void a(String str, float f2) {
        if (!TextUtils.isEmpty(str) && f2 >= 0.0f) {
            h((List<b>) Collections.singletonList(new b.a(str, f2).a()));
        }
    }

    public void a(d dVar) {
        j(dVar.a);
        a(dVar.b);
        b(dVar.c);
        c(dVar.d);
        d(dVar.e);
        e(dVar.f);
        f(dVar.g);
        g(dVar.h);
        k(dVar.i);
        l(dVar.j);
        h(dVar.k);
        i(dVar.l);
    }
}
