package com.apm.insight.runtime.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.apm.insight.h;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    /* access modifiers changed from: private */
    public static boolean a = true;
    /* access modifiers changed from: private */
    public static boolean b = false;
    /* access modifiers changed from: private */
    public static boolean c = false;
    /* access modifiers changed from: private */
    public static int d = 1;
    private static boolean e = false;
    /* access modifiers changed from: private */
    public static long f = -1;
    private static volatile b z;
    private int A = 50;
    /* access modifiers changed from: private */
    public int B;
    private Application g;
    private Context h;
    /* access modifiers changed from: private */
    public List<String> i = new ArrayList();
    /* access modifiers changed from: private */
    public List<Long> j = new ArrayList();
    /* access modifiers changed from: private */
    public List<String> k = new ArrayList();
    /* access modifiers changed from: private */
    public List<Long> l = new ArrayList();
    private LinkedList<a> m = new LinkedList<>();
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public long q;
    /* access modifiers changed from: private */
    public String r;
    /* access modifiers changed from: private */
    public long s;
    /* access modifiers changed from: private */
    public String t;
    /* access modifiers changed from: private */
    public long u;
    /* access modifiers changed from: private */
    public String v;
    /* access modifiers changed from: private */
    public long w;
    /* access modifiers changed from: private */
    public boolean x = false;
    /* access modifiers changed from: private */
    public long y = -1;

    private static class a {
        String a;
        String b;
        long c;

        a(String str, String str2, long j) {
            this.b = str2;
            this.c = j;
            this.a = str;
        }

        public String toString() {
            return com.apm.insight.l.b.a().format(new Date(this.c)) + " : " + this.a + ' ' + this.b;
        }
    }

    private b(Application application) {
        this.h = application;
        this.g = application;
        try {
            m();
        } catch (Throwable unused) {
        }
    }

    private a a(String str, String str2, long j2) {
        a aVar;
        if (this.m.size() >= this.A) {
            aVar = this.m.poll();
            if (aVar != null) {
                this.m.add(aVar);
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, str2, j2);
        this.m.add(aVar2);
        return aVar2;
    }

    private JSONObject a(String str, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void a() {
        e = true;
    }

    /* access modifiers changed from: private */
    public void a(String str, long j2, String str2) {
        try {
            a a2 = a(str, str2, j2);
            a2.b = str2;
            a2.a = str;
            a2.c = j2;
        } catch (Throwable unused) {
        }
    }

    public static int b() {
        int i2 = d;
        return i2 == 1 ? e ? 2 : 1 : i2;
    }

    public static long c() {
        return f;
    }

    public static b d() {
        if (z == null) {
            synchronized (b.class) {
                if (z == null) {
                    z = new b(h.h());
                }
            }
        }
        return z;
    }

    static /* synthetic */ int g(b bVar) {
        int i2 = bVar.B;
        bVar.B = i2 + 1;
        return i2;
    }

    static /* synthetic */ int l(b bVar) {
        int i2 = bVar.B;
        bVar.B = i2 - 1;
        return i2;
    }

    private void m() {
        if (Build.VERSION.SDK_INT >= 14 && this.g != null) {
            this.g.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    String unused = b.this.n = activity.getClass().getName();
                    long unused2 = b.this.o = System.currentTimeMillis();
                    boolean unused3 = b.b = bundle != null;
                    boolean unused4 = b.c = true;
                    b.this.i.add(b.this.n);
                    b.this.j.add(Long.valueOf(b.this.o));
                    b bVar = b.this;
                    bVar.a(bVar.n, b.this.o, "onCreate");
                }

                public void onActivityDestroyed(Activity activity) {
                    String name = activity.getClass().getName();
                    int indexOf = b.this.i.indexOf(name);
                    if (indexOf > -1 && indexOf < b.this.i.size()) {
                        b.this.i.remove(indexOf);
                        b.this.j.remove(indexOf);
                    }
                    b.this.k.add(name);
                    long currentTimeMillis = System.currentTimeMillis();
                    b.this.l.add(Long.valueOf(currentTimeMillis));
                    b.this.a(name, currentTimeMillis, "onDestroy");
                }

                public void onActivityPaused(Activity activity) {
                    String unused = b.this.t = activity.getClass().getName();
                    long unused2 = b.this.u = System.currentTimeMillis();
                    b.l(b.this);
                    if (b.this.B != 0) {
                        if (b.this.B < 0) {
                            int unused3 = b.this.B = 0;
                        }
                        b bVar = b.this;
                        bVar.a(bVar.t, b.this.u, "onPause");
                    }
                    boolean unused4 = b.this.x = false;
                    boolean unused5 = b.c = false;
                    long unused6 = b.this.y = SystemClock.uptimeMillis();
                    b bVar2 = b.this;
                    bVar2.a(bVar2.t, b.this.u, "onPause");
                }

                public void onActivityResumed(Activity activity) {
                    String unused = b.this.r = activity.getClass().getName();
                    long unused2 = b.this.s = System.currentTimeMillis();
                    b.g(b.this);
                    if (!b.this.x) {
                        if (b.a) {
                            boolean unused3 = b.a = false;
                            int unused4 = b.d = 1;
                            long unused5 = b.f = b.this.s;
                        }
                        if (b.this.r.equals(b.this.t)) {
                            if (b.c && !b.b) {
                                int unused6 = b.d = 4;
                                long unused7 = b.f = b.this.s;
                                return;
                            } else if (!b.c) {
                                int unused8 = b.d = 3;
                                long unused9 = b.f = b.this.s;
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    boolean unused10 = b.this.x = true;
                    b bVar = b.this;
                    bVar.a(bVar.r, b.this.s, "onResume");
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                    String unused = b.this.p = activity.getClass().getName();
                    long unused2 = b.this.q = System.currentTimeMillis();
                    b bVar = b.this;
                    bVar.a(bVar.p, b.this.q, "onStart");
                }

                public void onActivityStopped(Activity activity) {
                    String unused = b.this.v = activity.getClass().getName();
                    long unused2 = b.this.w = System.currentTimeMillis();
                    b bVar = b.this;
                    bVar.a(bVar.v, b.this.w, "onStop");
                }
            });
        }
    }

    private JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.i;
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            while (i2 < this.i.size()) {
                try {
                    jSONArray.put(a(this.i.get(i2), this.j.get(i2).longValue()));
                    i2++;
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray o() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.k;
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            while (i2 < this.k.size()) {
                try {
                    jSONArray.put(a(this.k.get(i2), this.l.get(i2).longValue()));
                    i2++;
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public long e() {
        return SystemClock.uptimeMillis() - this.y;
    }

    public boolean f() {
        return this.x;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", a(this.n, this.o));
            jSONObject.put("last_start_activity", a(this.p, this.q));
            jSONObject.put("last_resume_activity", a(this.r, this.s));
            jSONObject.put("last_pause_activity", a(this.t, this.u));
            jSONObject.put("last_stop_activity", a(this.v, this.w));
            jSONObject.put("alive_activities", n());
            jSONObject.put("finish_activities", o());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String h() {
        return String.valueOf(this.r);
    }

    public JSONArray i() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = new ArrayList(this.m).iterator();
        while (it.hasNext()) {
            jSONArray.put(((a) it.next()).toString());
        }
        return jSONArray;
    }
}
