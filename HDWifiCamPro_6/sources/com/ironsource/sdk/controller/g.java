package com.ironsource.sdk.controller;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import com.ironsource.environment.e.a;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.a.e;
import com.ironsource.sdk.a.f;
import com.ironsource.sdk.g.c;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.h.b;
import com.ironsource.sdk.utils.Logger;
import java.util.Map;
import org.json.JSONObject;

public class g implements e, m {
    public m a;
    /* access modifiers changed from: private */
    public final String b = g.class.getSimpleName();
    private d.b c = d.b.None;
    private CountDownTimer d;
    private final b e = new b("NativeCommandExecutor");
    private final b f = new b("ControllerCommandsExecutor");
    private final a g;

    public g(Context context, c cVar, com.ironsource.sdk.service.d dVar, j jVar, a aVar) {
        this.g = aVar;
        final Context context2 = context;
        final c cVar2 = cVar;
        final com.ironsource.sdk.service.d dVar2 = dVar;
        final j jVar2 = jVar;
        b((Runnable) new Runnable() {
            public final void run() {
                try {
                    m unused = g.this.a = g.a(g.this, context2, cVar2, dVar2, jVar2);
                    g.this.a.h();
                } catch (Exception e2) {
                    g.this.d(Log.getStackTraceString(e2));
                }
            }
        });
        this.d = new CountDownTimer(200000, 1000) {
            public final void onFinish() {
                Logger.i(g.this.b, "Global Controller Timer Finish");
                g.this.d("controller html - download timeout");
            }

            public final void onTick(long j) {
                String b = g.this.b;
                Logger.i(b, "Global Controller Timer Tick " + j);
            }
        }.start();
    }

    static /* synthetic */ x a(g gVar, Context context, c cVar, com.ironsource.sdk.service.d dVar, j jVar) {
        com.ironsource.sdk.a.d.a(f.b);
        x xVar = new x(context, jVar, cVar, gVar, gVar.g);
        b bVar = new b(context, xVar.a(), new com.ironsource.sdk.h.a(a.a()), new com.ironsource.sdk.h.d(xVar.a().b));
        xVar.p = new v(context, dVar);
        xVar.n = new q(context);
        xVar.o = new r(context);
        xVar.q = new k(context);
        xVar.r = new a(cVar);
        a aVar = xVar.r;
        if (xVar.t == null) {
            xVar.t = new y() {
                public final void a(String str, JSONObject jSONObject) {
                    x.this.b(x.b(str, jSONObject.toString()));
                }
            };
        }
        aVar.a = xVar.t;
        xVar.s = new l(xVar.a().b, bVar);
        return xVar;
    }

    private void b(Runnable runnable) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(runnable);
        } else {
            Logger.e(this.b, "mThreadManager = null");
        }
    }

    /* access modifiers changed from: private */
    public synchronized void d(String str) {
        com.ironsource.sdk.a.d.a(f.c, (Map<String, Object>) new com.ironsource.sdk.a.a().a("callfailreason", str).a);
        this.a = new p(str, this.g, this);
        this.e.a();
        this.e.b();
    }

    private boolean i() {
        return d.b.Ready.equals(this.c);
    }

    public final void a() {
        this.c = d.b.Loaded;
        this.e.a();
        this.e.b();
    }

    public final void a(Context context) {
        if (i()) {
            this.a.a(context);
        }
    }

    public final void a(final c cVar, final Map<String, String> map, final com.ironsource.sdk.j.a.b bVar) {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(cVar, (Map<String, String>) map, bVar);
            }
        });
    }

    public final void a(final c cVar, final Map<String, String> map, final com.ironsource.sdk.j.a.c cVar2) {
        this.f.a(new Runnable() {
            public final void run() {
                com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("demandsourcename", cVar.a).a("producttype", e.a(cVar, d.e.Interstitial)).a("isbiddinginstance", Boolean.valueOf(e.a(cVar)));
                com.ironsource.sdk.service.a aVar = com.ironsource.sdk.service.a.a;
                com.ironsource.sdk.a.d.a(f.i, (Map<String, Object>) a2.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.c(cVar.b))).a);
                g.this.a.a(cVar, (Map<String, String>) map, cVar2);
            }
        });
    }

    public final void a(Runnable runnable) {
        this.e.a(runnable);
    }

    public final void a(String str) {
        com.ironsource.sdk.a.d.a(f.l, (Map<String, Object>) new com.ironsource.sdk.a.a().a("callfailreason", str).a);
        com.ironsource.sdk.j.d initListener = IronSourceNetwork.getInitListener();
        if (initListener != null) {
            initListener.onFail(new com.ironsource.sdk.g.e(1001, str));
            IronSourceNetwork.setInitListener((com.ironsource.sdk.j.d) null);
        }
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d(str);
    }

    public final void a(final String str, final com.ironsource.sdk.j.a.c cVar) {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(str, cVar);
            }
        });
    }

    public final void a(String str, String str2, c cVar, com.ironsource.sdk.j.a.b bVar) {
        final String str3 = str;
        final String str4 = str2;
        final c cVar2 = cVar;
        final com.ironsource.sdk.j.a.b bVar2 = bVar;
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(str3, str4, cVar2, bVar2);
            }
        });
    }

    public final void a(String str, String str2, c cVar, com.ironsource.sdk.j.a.c cVar2) {
        final String str3 = str;
        final String str4 = str2;
        final c cVar3 = cVar;
        final com.ironsource.sdk.j.a.c cVar4 = cVar2;
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(str3, str4, cVar3, cVar4);
            }
        });
    }

    public final void a(String str, String str2, c cVar, com.ironsource.sdk.j.a.d dVar) {
        final String str3 = str;
        final String str4 = str2;
        final c cVar2 = cVar;
        final com.ironsource.sdk.j.a.d dVar2 = dVar;
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(str3, str4, cVar2, dVar2);
            }
        });
    }

    public final void a(final String str, final String str2, final com.ironsource.sdk.j.e eVar) {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(str, str2, eVar);
            }
        });
    }

    public final void a(String str, String str2, Map<String, String> map, com.ironsource.sdk.j.e eVar) {
        final String str3 = str;
        final String str4 = str2;
        final Map<String, String> map2 = map;
        final com.ironsource.sdk.j.e eVar2 = eVar;
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(str3, str4, (Map<String, String>) map2, eVar2);
            }
        });
    }

    public final void a(final Map<String, String> map, final com.ironsource.sdk.j.e eVar) {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a((Map<String, String>) map, eVar);
            }
        });
    }

    public final void a(final JSONObject jSONObject) {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(jSONObject);
            }
        });
    }

    public final void a(final JSONObject jSONObject, final com.ironsource.sdk.j.a.c cVar) {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(jSONObject, cVar);
            }
        });
    }

    public final void a(final JSONObject jSONObject, final com.ironsource.sdk.j.a.d dVar) {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.a(jSONObject, dVar);
            }
        });
    }

    public final void b() {
        if (d.c.Web.equals(c())) {
            com.ironsource.sdk.a.d.a(f.d);
            com.ironsource.sdk.j.d initListener = IronSourceNetwork.getInitListener();
            if (initListener != null) {
                initListener.onSuccess();
                IronSourceNetwork.setInitListener((com.ironsource.sdk.j.d) null);
            }
        }
        this.c = d.b.Ready;
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f.a();
        this.f.b();
        this.a.g();
    }

    public final void b(Context context) {
        if (i()) {
            this.a.b(context);
        }
    }

    public final void b(final c cVar, final Map<String, String> map, final com.ironsource.sdk.j.a.c cVar2) {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.b(cVar, map, cVar2);
            }
        });
    }

    public final void b(String str) {
        com.ironsource.sdk.a.d.a(f.u, (Map<String, Object>) new com.ironsource.sdk.a.a().a("generalmessage", str).a);
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d(str);
    }

    public final d.c c() {
        return this.a.c();
    }

    public final boolean c(String str) {
        if (!i()) {
            return false;
        }
        return this.a.c(str);
    }

    public final void d() {
        this.f.a(new Runnable() {
            public final void run() {
                g.this.a.d();
            }
        });
    }

    public void destroy() {
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.d = null;
        b((Runnable) new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.destroy();
                    m unused = g.this.a = null;
                }
            }
        });
    }

    public final void e() {
        if (i()) {
            this.a.e();
        }
    }

    public final void f() {
        if (i()) {
            this.a.f();
        }
    }

    @Deprecated
    public final void g() {
    }

    public final void h() {
    }
}
