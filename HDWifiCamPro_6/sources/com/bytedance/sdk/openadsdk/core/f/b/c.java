package com.bytedance.sdk.openadsdk.core.f.b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.openadsdk.core.f.b.a;
import com.bytedance.sdk.openadsdk.core.f.b.b;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: VastTracker */
public class c {
    private String a;
    private C0047c b;
    private boolean c;
    private boolean d;

    /* renamed from: com.bytedance.sdk.openadsdk.core.f.b.c$c  reason: collision with other inner class name */
    /* compiled from: VastTracker */
    enum C0047c {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    protected c(String str, C0047c cVar, Boolean bool) {
        this.a = str;
        this.b = cVar;
        this.c = bool.booleanValue();
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public void f_() {
        this.d = true;
    }

    /* compiled from: VastTracker */
    public static class a {
        private String a;
        private C0047c b = C0047c.TRACKING_URL;
        private boolean c = false;

        public a(String str) {
            this.a = str;
        }

        public a a(boolean z) {
            this.c = z;
            return this;
        }

        public c a() {
            return new c(this.a, this.b, Boolean.valueOf(this.c));
        }
    }

    public boolean e() {
        return this.d;
    }

    public static List<String> a(List<c> list, com.bytedance.sdk.openadsdk.core.f.a.a aVar, long j, String str) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (c next : list) {
            if (next != null && (!next.e() || next.d())) {
                arrayList.add(next.c());
                next.f_();
            }
        }
        return new com.bytedance.sdk.openadsdk.core.f.c.c(arrayList).a(aVar).a(j).a(str).a();
    }

    public static void a(List<c> list, com.bytedance.sdk.openadsdk.core.f.a.a aVar, long j, String str, b bVar) {
        a(a(list, aVar, j, str), bVar);
    }

    public static void b(List<c> list, com.bytedance.sdk.openadsdk.core.f.a.a aVar, long j, String str) {
        a(list, aVar, j, str, (b) null);
    }

    public static void a(List<String> list, final b bVar) {
        com.bytedance.sdk.component.f.b.b c2;
        for (final String next : list) {
            if (!(next == null || (c2 = d.a().b().c()) == null)) {
                c2.a(true);
                c2.a(next);
                c2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                    public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                        b bVar2 = bVar;
                        if (bVar2 != null && bVar2.b != null) {
                            boolean z = false;
                            String str = null;
                            if (bVar != null && bVar.f()) {
                                z = true;
                            } else if (bVar != null) {
                                str = bVar.a() + ":" + bVar.b();
                            }
                            c.b(z, str, y.b(bVar.b.aR()), bVar, next);
                        }
                    }

                    public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                        b bVar = bVar;
                        if (bVar != null && bVar.b != null) {
                            c.b(false, iOException != null ? iOException.getMessage() : null, y.b(bVar.b.aR()), bVar, next);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(boolean z, String str, String str2, b bVar, String str3) {
        final b bVar2 = bVar;
        final boolean z2 = z;
        final String str4 = str;
        final String str5 = str3;
        final String str6 = str2;
        com.bytedance.sdk.openadsdk.c.c.a((g) new g("dsp_track_link_result") {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", bVar2.a);
                    jSONObject.put("success", z2);
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject.put("description", str4);
                    }
                    jSONObject.put("link", str5);
                    if (bVar2.c >= 0.0f) {
                        jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, ((double) Math.round(bVar2.c * 100.0f)) / 100.0d);
                    }
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.c.c.b(m.a(), bVar2.b, str6, "dsp_track_link_result", jSONObject);
            }
        });
    }

    public static JSONArray a(List<c> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i).c());
        }
        return jSONArray;
    }

    public static List<c> a(JSONArray jSONArray) {
        return a(jSONArray, false);
    }

    public static List<c> a(JSONArray jSONArray, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(new a(optString).a(z).a());
                }
            }
        }
        return arrayList;
    }

    public static List<b> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new b.a(optJSONObject.optString("content"), (float) optJSONObject.optDouble("trackingFraction", 0.0d)).a());
                }
            }
        }
        return arrayList;
    }

    public static List<a> c(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new a.C0046a(optJSONObject.optString("content"), optJSONObject.optLong("trackingMilliseconds", 0)).a());
                }
            }
        }
        return arrayList;
    }

    /* compiled from: VastTracker */
    public static class b {
        String a;
        n b;
        float c;

        public b(String str, n nVar) {
            this(str, nVar, -1.0f);
        }

        public b(String str, n nVar, float f) {
            this.a = str;
            this.b = nVar;
            this.c = f;
        }
    }
}
