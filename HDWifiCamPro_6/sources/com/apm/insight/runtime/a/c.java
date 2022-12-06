package com.apm.insight.runtime.a;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.ICommonParams;
import com.apm.insight.h;
import com.apm.insight.l.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class c {
    protected CrashType a;
    protected Context b;
    protected ICommonParams c = h.a().c();
    protected b d;
    protected d e;

    public interface a {
        com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar);

        com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar, boolean z);

        void a(Throwable th);
    }

    c(CrashType crashType, Context context, b bVar, d dVar) {
        this.a = crashType;
        this.b = context;
        this.d = bVar;
        this.e = dVar;
    }

    private void i(com.apm.insight.entity.a aVar) {
        List<AttachUserData> a2 = h.b().a(this.a);
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = aVar.h().optJSONObject("custom");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            aVar.a("custom", (Object) optJSONObject);
        }
        if (a2 != null) {
            for (int i = 0; i < a2.size(); i++) {
                try {
                    AttachUserData attachUserData = a2.get(i);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    com.apm.insight.entity.a.a(optJSONObject, attachUserData.getUserData(this.a));
                    hashMap.put("custom_cost_" + attachUserData.getClass().getName() + "_" + hashMap.size(), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                } catch (Throwable th) {
                    com.apm.insight.entity.a.a(optJSONObject, th);
                }
            }
        }
        try {
            optJSONObject.put("fd_count", com.apm.insight.l.h.a());
        } catch (Throwable unused) {
        }
        List<AttachUserData> b2 = h.b().b(this.a);
        if (b2 != null) {
            JSONObject optJSONObject2 = aVar.h().optJSONObject("custom_long");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                aVar.a("custom_long", (Object) optJSONObject2);
            }
            for (int i2 = 0; i2 < b2.size(); i2++) {
                try {
                    AttachUserData attachUserData2 = b2.get(i2);
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    com.apm.insight.entity.a.a(optJSONObject2, attachUserData2.getUserData(this.a));
                    hashMap.put("custom_cost_" + attachUserData2.getClass().getName() + "_" + hashMap.size(), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis2));
                } catch (Throwable th2) {
                    com.apm.insight.entity.a.a(optJSONObject2, th2);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                optJSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Throwable unused2) {
            }
        }
    }

    public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
        if (aVar == null) {
            aVar = new com.apm.insight.entity.a();
        }
        if (i == 0) {
            b(aVar);
        } else if (i == 1) {
            c(aVar);
            i(aVar);
        } else if (i == 2) {
            e(aVar);
        } else if (i == 4) {
            f(aVar);
        } else if (i == 5) {
            d(aVar);
        }
        return aVar;
    }

    public com.apm.insight.entity.a a(com.apm.insight.entity.a aVar) {
        return aVar;
    }

    public com.apm.insight.entity.a a(com.apm.insight.entity.a aVar, a aVar2, boolean z) {
        if (aVar == null) {
            aVar = new com.apm.insight.entity.a();
        }
        com.apm.insight.entity.a aVar3 = aVar;
        com.apm.insight.entity.a aVar4 = aVar3;
        for (int i = 0; i < b(); i++) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (aVar2 != null) {
                try {
                    aVar4 = aVar2.a(i, aVar4);
                } catch (Throwable th) {
                    aVar2.a(th);
                }
            }
            try {
                aVar4 = a(i, aVar4);
            } catch (Throwable th2) {
                if (aVar2 != null) {
                    aVar2.a(th2);
                }
            }
            if (aVar2 != null) {
                try {
                    boolean z2 = true;
                    if (i != b() - 1) {
                        z2 = false;
                    }
                    aVar4 = aVar2.a(i, aVar4, z2);
                } catch (Throwable th3) {
                    aVar2.a(th3);
                }
                if (z) {
                    if (i != 0) {
                        aVar3.c(aVar4.h());
                    } else {
                        aVar3 = aVar4;
                    }
                    aVar4 = new com.apm.insight.entity.a();
                }
            }
            aVar3.b("step_cost_" + i, String.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
        }
        return a(aVar3);
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    public int b() {
        return 6;
    }

    public com.apm.insight.entity.a b(com.apm.insight.entity.a aVar) {
        aVar.a(h.p(), h.q());
        if (h.m()) {
            aVar.a("is_mp", (Object) 1);
        }
        try {
            aVar.a(this.c.getPluginInfo());
        } catch (Throwable unused) {
        }
        aVar.b((Map<Integer, String>) h.o());
        aVar.a("process_name", (Object) com.apm.insight.l.a.c(h.g()));
        return aVar;
    }

    public com.apm.insight.entity.a c(com.apm.insight.entity.a aVar) {
        b bVar;
        if (!com.apm.insight.l.a.b(h.g())) {
            aVar.a("remote_process", (Object) 1);
        }
        aVar.a("pid", (Object) Integer.valueOf(Process.myPid()));
        aVar.a(h.j());
        if (c() && (bVar = this.d) != null) {
            aVar.a(bVar);
        }
        try {
            aVar.a(this.c.getPatchInfo());
        } catch (Throwable unused) {
        }
        String k = h.k();
        if (k != null) {
            aVar.a("business", (Object) k);
        }
        aVar.a("is_background", (Object) Boolean.valueOf(!com.apm.insight.l.a.a(this.b)));
        return aVar;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public com.apm.insight.entity.a d(com.apm.insight.entity.a aVar) {
        if (d()) {
            aVar.b(w.a(this.b));
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return true;
    }

    public com.apm.insight.entity.a e(com.apm.insight.entity.a aVar) {
        d dVar = this.e;
        aVar.a("battery", (Object) Integer.valueOf(dVar == null ? 0 : dVar.a()));
        aVar.c((Map<? extends String, ? extends String>) h.b().a());
        return aVar;
    }

    public com.apm.insight.entity.a f(com.apm.insight.entity.a aVar) {
        if (a()) {
            h(aVar);
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public void g(com.apm.insight.entity.a aVar) {
    }

    /* access modifiers changed from: protected */
    public void h(com.apm.insight.entity.a aVar) {
    }
}
