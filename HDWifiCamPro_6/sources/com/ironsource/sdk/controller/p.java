package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.environment.e.a;
import com.ironsource.sdk.g.c;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.j.a.b;
import com.ironsource.sdk.j.e;
import java.util.Map;
import org.json.JSONObject;

public final class p implements m {
    String a = "";
    private final a b;

    p(String str, a aVar, final e eVar) {
        this.b = aVar;
        this.a = str;
        a((Runnable) new Runnable() {
            public final void run() {
                eVar.b();
            }
        });
    }

    private void a(Runnable runnable) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.c(runnable);
        }
    }

    public final void a(Context context) {
    }

    public final void a(c cVar, final Map<String, String> map, final b bVar) {
        if (bVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    bVar.d((String) map.get("demandSourceName"), p.this.a);
                }
            });
        }
    }

    public final void a(final c cVar, Map<String, String> map, final com.ironsource.sdk.j.a.c cVar2) {
        if (cVar2 != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    cVar2.b(cVar.b, p.this.a);
                }
            });
        }
    }

    public final void a(final String str, final com.ironsource.sdk.j.a.c cVar) {
        if (cVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    cVar.b(str, p.this.a);
                }
            });
        }
    }

    public final void a(String str, String str2, c cVar, b bVar) {
        if (bVar != null) {
            bVar.a(d.e.Banner, cVar.b, this.a);
        }
    }

    public final void a(String str, String str2, final c cVar, final com.ironsource.sdk.j.a.c cVar2) {
        if (cVar2 != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    cVar2.a(d.e.Interstitial, cVar.b, p.this.a);
                }
            });
        }
    }

    public final void a(String str, String str2, final c cVar, final com.ironsource.sdk.j.a.d dVar) {
        if (dVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    dVar.a(d.e.RewardedVideo, cVar.b, p.this.a);
                }
            });
        }
    }

    public final void a(String str, String str2, final e eVar) {
        if (eVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    eVar.onGetOWCreditsFailed(p.this.a);
                }
            });
        }
    }

    public final void a(String str, String str2, Map<String, String> map, final e eVar) {
        if (eVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    eVar.onOfferwallInitFail(p.this.a);
                }
            });
        }
    }

    public final void a(Map<String, String> map, final e eVar) {
        if (eVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    eVar.onOWShowFail(p.this.a);
                    eVar.onOfferwallInitFail(p.this.a);
                }
            });
        }
    }

    public final void a(JSONObject jSONObject) {
    }

    public final void a(final JSONObject jSONObject, final com.ironsource.sdk.j.a.c cVar) {
        if (cVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    cVar.c(jSONObject.optString("demandSourceName"), p.this.a);
                }
            });
        }
    }

    public final void a(final JSONObject jSONObject, final com.ironsource.sdk.j.a.d dVar) {
        if (dVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    dVar.a(jSONObject.optString("demandSourceName"), p.this.a);
                }
            });
        }
    }

    public final void b(Context context) {
    }

    public final void b(final c cVar, Map<String, String> map, final com.ironsource.sdk.j.a.c cVar2) {
        if (cVar2 != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    cVar2.c(cVar.b, p.this.a);
                }
            });
        }
    }

    public final d.c c() {
        return d.c.Native;
    }

    public final boolean c(String str) {
        return false;
    }

    public final void d() {
    }

    public final void destroy() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g() {
    }

    public final void h() {
    }
}
