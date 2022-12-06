package com.bytedance.sdk.openadsdk.c.c.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.c.b;
import com.bykv.vk.openvk.component.video.api.c.c;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.c.c.b.d;
import com.bytedance.sdk.openadsdk.c.c.b.e;
import com.bytedance.sdk.openadsdk.c.c.b.g;
import com.bytedance.sdk.openadsdk.c.c.b.h;
import com.bytedance.sdk.openadsdk.c.c.b.i;
import com.bytedance.sdk.openadsdk.c.c.b.j;
import com.bytedance.sdk.openadsdk.c.c.b.k;
import com.bytedance.sdk.openadsdk.c.c.b.l;
import com.bytedance.sdk.openadsdk.c.c.b.m;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.y;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VideoEventManager */
public class a {
    private static final Map<com.bykv.vk.openvk.component.video.api.b.a, o> a = Collections.synchronizedMap(new WeakHashMap());

    public static JSONObject a(n nVar, String str, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (nVar != null) {
                b J = nVar.J();
                if (J != null) {
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, J.g());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(J.e()));
                    jSONObject.put("video_url", J.i());
                    jSONObject.put("player_type", i2);
                }
                jSONObject.put("dp_creative_type", nVar.bb());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void a(com.bytedance.sdk.openadsdk.c.c.b.a<k> aVar) {
        a((com.bytedance.sdk.openadsdk.c.c.b.a) aVar, "load_video_start");
    }

    public static void b(com.bytedance.sdk.openadsdk.c.c.b.a<l> aVar) {
        a((com.bytedance.sdk.openadsdk.c.c.b.a) aVar, "load_video_success");
    }

    public static void c(com.bytedance.sdk.openadsdk.c.c.b.a<j> aVar) {
        a((com.bytedance.sdk.openadsdk.c.c.b.a) aVar, "load_video_error");
    }

    public static void d(com.bytedance.sdk.openadsdk.c.c.b.a<i> aVar) {
        a((com.bytedance.sdk.openadsdk.c.c.b.a) aVar, "load_video_cancel");
    }

    public static void a(n nVar, com.bykv.vk.openvk.component.video.api.b.a aVar, c cVar) {
        if (nVar != null && aVar != null && cVar != null) {
            String a2 = com.bytedance.sdk.openadsdk.l.o.a();
            boolean z = true;
            int i = CacheDirFactory.getICacheDir(nVar.aL()).a(cVar) ? 1 : 2;
            a.put(aVar, new o(SystemClock.elapsedRealtime(), a2, i, cVar, nVar));
            com.bytedance.sdk.openadsdk.c.c.b.a aVar2 = new com.bytedance.sdk.openadsdk.c.c.b.a(nVar, y.a(nVar), a(nVar, a2, i, cVar.m()), null);
            if (cVar.m() != -1) {
                z = false;
            }
            aVar2.a(z);
            a(aVar2, "play_start");
        }
    }

    public static void a(Context context, com.bykv.vk.openvk.component.video.api.b.a aVar, o.a aVar2, f fVar) {
        o oVar;
        if (context != null && aVar != null && aVar2 != null && (oVar = a.get(aVar)) != null) {
            c d = oVar.d();
            n e = oVar.e();
            if (d != null && e != null) {
                if (!aVar2.l()) {
                    a(e, d, aVar2);
                }
                h hVar = new h();
                hVar.a(aVar2.m() ? 1 : 0);
                hVar.b(CacheDirFactory.getICacheDir(e.aL()).b(d));
                hVar.a(SystemClock.elapsedRealtime() - oVar.a());
                com.bytedance.sdk.openadsdk.c.c.b.a aVar3 = new com.bytedance.sdk.openadsdk.c.c.b.a(e, y.a(e), a(e, oVar.b(), oVar.c(), d.m()), hVar);
                aVar3.a(aVar2.l());
                a(aVar3, "feed_play", fVar);
            }
        }
    }

    public static void a(com.bykv.vk.openvk.component.video.api.b.a aVar, o.a aVar2) {
        o oVar;
        if (aVar != null && aVar2 != null && (oVar = a.get(aVar)) != null) {
            c d = oVar.d();
            n e = oVar.e();
            if (d != null && e != null) {
                long a2 = aVar2.a();
                long c = aVar2.c();
                if (c > 0 && a2 > 0) {
                    g gVar = new g();
                    gVar.a(aVar2.b());
                    gVar.b(c);
                    com.bytedance.sdk.openadsdk.c.c.b.a aVar3 = new com.bytedance.sdk.openadsdk.c.c.b.a(e, y.a(e), a(e, oVar.b(), oVar.c(), d.m()), gVar);
                    aVar3.a(aVar2.l());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(IronSourceConstants.EVENTS_DURATION, a2);
                        jSONObject.put("percent", aVar2.h());
                        a(aVar3, "feed_pause", jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void b(com.bykv.vk.openvk.component.video.api.b.a aVar, o.a aVar2) {
        o oVar;
        if (aVar != null && aVar2 != null && (oVar = a.get(aVar)) != null) {
            c d = oVar.d();
            n e = oVar.e();
            if (d != null && e != null) {
                long a2 = aVar2.a();
                long c = aVar2.c();
                if (c > 0 && a2 > 0) {
                    e eVar = new e();
                    eVar.a(aVar2.b());
                    eVar.b(c);
                    com.bytedance.sdk.openadsdk.c.c.b.a aVar3 = new com.bytedance.sdk.openadsdk.c.c.b.a(e, y.a(e), a(e, oVar.b(), oVar.c(), d.m()), eVar);
                    aVar3.a(aVar2.l());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(IronSourceConstants.EVENTS_DURATION, a2);
                        jSONObject.put("percent", aVar2.h());
                        a(aVar3, "feed_continue", jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void c(com.bykv.vk.openvk.component.video.api.b.a aVar, o.a aVar2) {
        o oVar;
        if (aVar != null && aVar2 != null && (oVar = a.get(aVar)) != null) {
            c d = oVar.d();
            n e = oVar.e();
            if (d != null && e != null) {
                long a2 = aVar2.a();
                long c = aVar2.c();
                com.bytedance.sdk.openadsdk.c.c.b.n nVar = new com.bytedance.sdk.openadsdk.c.c.b.n();
                nVar.a(aVar2.b());
                nVar.b(c);
                nVar.a(aVar2.d());
                nVar.b(aVar2.e());
                com.bytedance.sdk.openadsdk.c.c.b.a aVar3 = new com.bytedance.sdk.openadsdk.c.c.b.a(e, y.a(e), a(e, oVar.b(), oVar.c(), d.m()), nVar);
                aVar3.a(aVar2.l());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IronSourceConstants.EVENTS_DURATION, a2);
                    jSONObject.put("percent", aVar2.h());
                    a(aVar3, "play_error", jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void d(com.bykv.vk.openvk.component.video.api.b.a aVar, o.a aVar2) {
        o oVar;
        if (aVar != null && aVar2 != null && (oVar = a.get(aVar)) != null) {
            c d = oVar.d();
            n e = oVar.e();
            if (d != null && e != null) {
                long a2 = aVar2.a();
                long c = aVar2.c();
                com.bytedance.sdk.openadsdk.c.c.b.b bVar = new com.bytedance.sdk.openadsdk.c.c.b.b();
                bVar.a(aVar2.b());
                bVar.b(c);
                bVar.a(aVar2.f());
                bVar.b(aVar2.g());
                com.bytedance.sdk.openadsdk.c.c.b.a aVar3 = new com.bytedance.sdk.openadsdk.c.c.b.a(e, y.a(e), a(e, oVar.b(), oVar.c(), d.m()), bVar);
                aVar3.a(aVar2.l());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IronSourceConstants.EVENTS_DURATION, a2);
                    jSONObject.put("percent", aVar2.h());
                    a(aVar3, "endcard_skip", jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                a.remove(aVar);
            }
        }
    }

    public static void a(com.bykv.vk.openvk.component.video.api.b.a aVar, o.a aVar2, f fVar) {
        o oVar;
        if (aVar != null && aVar2 != null && (oVar = a.get(aVar)) != null) {
            c d = oVar.d();
            n e = oVar.e();
            if (d != null && e != null) {
                long a2 = aVar2.a();
                long c = aVar2.c();
                d dVar = new d();
                dVar.b(aVar2.b());
                dVar.a(c);
                dVar.a(aVar2.i());
                dVar.b(aVar2.j());
                com.bytedance.sdk.openadsdk.c.c.b.a aVar3 = new com.bytedance.sdk.openadsdk.c.c.b.a(e, y.a(e), a(e, oVar.b(), oVar.c(), d.m()), dVar);
                aVar3.a(aVar2.l());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IronSourceConstants.EVENTS_DURATION, a2);
                    jSONObject.put("percent", aVar2.h());
                    a(aVar3, "feed_break", jSONObject, fVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                a.remove(aVar);
            }
        }
    }

    public static void b(com.bykv.vk.openvk.component.video.api.b.a aVar, o.a aVar2, f fVar) {
        if (aVar != null && aVar2 != null) {
            e(aVar, aVar2);
            o oVar = a.get(aVar);
            if (oVar != null) {
                c d = oVar.d();
                n e = oVar.e();
                if (d != null && e != null) {
                    long a2 = aVar2.a();
                    long c = aVar2.c();
                    if (c > 0) {
                        com.bytedance.sdk.openadsdk.c.c.b.f fVar2 = new com.bytedance.sdk.openadsdk.c.c.b.f();
                        fVar2.b(aVar2.b());
                        fVar2.a(c);
                        fVar2.a(aVar2.j());
                        com.bytedance.sdk.openadsdk.c.c.b.a aVar3 = new com.bytedance.sdk.openadsdk.c.c.b.a(e, y.a(e), a(e, oVar.b(), oVar.c(), d.m()), fVar2);
                        aVar3.a(aVar2.l());
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(IronSourceConstants.EVENTS_DURATION, a2);
                            jSONObject.put("percent", aVar2.h());
                            a(aVar3, "feed_over", jSONObject, fVar);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        a.remove(aVar);
                    }
                }
            }
        }
    }

    public static void e(com.bykv.vk.openvk.component.video.api.b.a aVar, o.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (aVar2.k() <= 0) {
                com.bytedance.sdk.component.utils.l.c("VideoEventManager", "Cancel log report when buffer count is 0");
                return;
            }
            o oVar = a.get(aVar);
            if (oVar != null) {
                c d = oVar.d();
                n e = oVar.e();
                if (d != null && e != null) {
                    long c = aVar2.c();
                    if (c > 0) {
                        m mVar = new m();
                        mVar.a(aVar2.b());
                        mVar.b(c);
                        mVar.a(aVar2.k());
                        com.bytedance.sdk.openadsdk.c.c.b.a aVar3 = new com.bytedance.sdk.openadsdk.c.c.b.a(e, y.a(e), a(e, oVar.b(), oVar.c(), d.m()), mVar);
                        aVar3.a(aVar2.l());
                        a(aVar3, "play_buffer");
                    }
                }
            }
        }
    }

    private static void a(com.bytedance.sdk.openadsdk.c.c.b.a aVar, String str) {
        a(aVar, str, (JSONObject) null, (f) null);
    }

    private static void a(com.bytedance.sdk.openadsdk.c.c.b.a aVar, String str, JSONObject jSONObject) {
        a(aVar, str, jSONObject, (f) null);
    }

    private static void a(com.bytedance.sdk.openadsdk.c.c.b.a aVar, String str, f fVar) {
        a(aVar, str, (JSONObject) null, fVar);
    }

    private static void a(final com.bytedance.sdk.openadsdk.c.c.b.a aVar, String str, JSONObject jSONObject, final f fVar) {
        if (aVar != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = jSONObject;
            if (aVar.e() && !TextUtils.isEmpty(aVar.b())) {
                String b = aVar.b();
                char c = 65535;
                int hashCode = b.hashCode();
                if (hashCode != -891990144) {
                    if (hashCode != -712491894) {
                        if (hashCode == 1912999166 && b.equals("draw_ad")) {
                            c = 2;
                        }
                    } else if (b.equals("embeded_ad")) {
                        c = 0;
                    }
                } else if (b.equals("stream")) {
                    c = 1;
                }
                if (c == 0 || c == 1 || c == 2) {
                    str = "customer_" + str;
                }
            }
            final String str2 = str;
            com.bytedance.sdk.openadsdk.c.c.a(System.currentTimeMillis(), aVar.a(), aVar.b(), str2, jSONObject2, fVar, (com.bytedance.sdk.openadsdk.c.b.a) new com.bytedance.sdk.openadsdk.c.b.a() {
                public void a(JSONObject jSONObject) throws JSONException {
                    f fVar;
                    JSONObject c2 = aVar.c();
                    if (aVar.d() != null) {
                        aVar.d().a(c2);
                    }
                    if (("feed_play".equals(str2) || "feed_over".equals(str2) || "feed_break".equals(str2)) && (fVar = fVar) != null) {
                        fVar.a(c2);
                    }
                    jSONObject.put("ad_extra_data", c2.toString());
                }
            });
        }
    }

    private static void a(final n nVar, final c cVar, final o.a aVar) {
        com.bytedance.sdk.openadsdk.h.b.a().b((com.bytedance.sdk.openadsdk.h.a) new com.bytedance.sdk.openadsdk.h.a() {
            public com.bytedance.sdk.openadsdk.h.a.a a() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", a.c(cVar));
                jSONObject.put("player_duration", aVar.c());
                jSONObject.put("cache_path_type", CacheDirFactory.getCacheType());
                jSONObject.put("url", cVar.k());
                jSONObject.put("path", a.d(cVar));
                jSONObject.put("player_type", cVar.m());
                com.bytedance.sdk.openadsdk.h.a.b a2 = com.bytedance.sdk.openadsdk.h.a.b.b().a("pangle_video_play_state");
                n nVar = nVar;
                return a2.a(nVar != null ? nVar.aR() : 0).b(jSONObject.toString());
            }
        });
    }

    /* access modifiers changed from: private */
    public static long c(c cVar) {
        if (cVar == null) {
            return 0;
        }
        b s = cVar.j() ? cVar.s() : cVar.r();
        if (s != null) {
            return Double.valueOf(s.f() * 1000.0d).longValue();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static String d(c cVar) {
        return new File(cVar.a(), cVar.l()).getAbsolutePath();
    }
}
