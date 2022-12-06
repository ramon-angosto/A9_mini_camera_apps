package com.apm.insight.b;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.apm.insight.runtime.g;
import com.apm.insight.runtime.u;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    public static boolean b = false;
    /* access modifiers changed from: private */
    public static int t = 2;
    c a;
    private int c;
    /* access modifiers changed from: private */
    public volatile int d;
    private int e;
    private int f;
    private f g;
    /* access modifiers changed from: private */
    public b h;
    private long i;
    private long j;
    private int k;
    private long l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public String n;
    private e o;
    private volatile boolean p;
    private boolean q;
    /* access modifiers changed from: private */
    public final u r;
    /* access modifiers changed from: private */
    public volatile boolean s;
    /* access modifiers changed from: private */
    public Runnable u;

    private static class a {
        long a;
        long b;
        long c;
        boolean d;
        int e;
        StackTraceElement[] f;

        private a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.e = -1;
            this.f = null;
        }
    }

    private static class b {
        final int a;
        a b;
        final List<a> c;
        private int d = 0;

        public b(int i) {
            this.a = i;
            this.c = new ArrayList(i);
        }

        /* access modifiers changed from: package-private */
        public a a() {
            a aVar = this.b;
            if (aVar == null) {
                return new a();
            }
            this.b = null;
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            int i;
            int size = this.c.size();
            int i2 = this.a;
            if (size < i2) {
                this.c.add(aVar);
                i = this.c.size();
            } else {
                this.d %= i2;
                a aVar2 = this.c.set(this.d, aVar);
                aVar2.a();
                this.b = aVar2;
                i = this.d + 1;
            }
            this.d = i;
        }
    }

    public interface c {
    }

    public static class d {
        long a;
        long b;
        long c;
        long d;
        long e;
    }

    public static class e {
        public long a;
        long b;
        long c;
        int d;
        int e;
        long f;
        long g;
        String h;
        public String i;
        String j;
        d k;

        private void a(JSONObject jSONObject) {
            jSONObject.put("block_uuid", this.j);
            jSONObject.put("sblock_uuid", this.j);
            jSONObject.put("belong_frame", this.k != null);
            d dVar = this.k;
            if (dVar != null) {
                jSONObject.put("vsyncDelayTime", this.c - (dVar.a / 1000000));
                jSONObject.put("doFrameTime", (this.k.b / 1000000) - this.c);
                jSONObject.put("inputHandlingTime", (this.k.c / 1000000) - (this.k.b / 1000000));
                jSONObject.put("animationsTime", (this.k.d / 1000000) - (this.k.c / 1000000));
                jSONObject.put("performTraversalsTime", (this.k.e / 1000000) - (this.k.d / 1000000));
                jSONObject.put("drawTime", this.b - (this.k.e / 1000000));
            }
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, h.a(this.h));
                jSONObject.put("cpuDuration", this.g);
                jSONObject.put(IronSourceConstants.EVENTS_DURATION, this.f);
                jSONObject.put("type", this.d);
                jSONObject.put("count", this.e);
                jSONObject.put("messageCount", this.e);
                jSONObject.put("lastDuration", this.b - this.c);
                jSONObject.put("start", this.a);
                jSONObject.put(TtmlNode.END, this.b);
                a(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.h = null;
            this.j = null;
            this.k = null;
            this.i = null;
        }
    }

    private static class f {
        int a;
        int b;
        e c;
        List<e> d = new ArrayList();

        f(int i) {
            this.a = i;
        }

        /* access modifiers changed from: package-private */
        public e a(int i) {
            e eVar = this.c;
            if (eVar != null) {
                eVar.d = i;
                this.c = null;
                return eVar;
            }
            e eVar2 = new e();
            eVar2.d = i;
            return eVar2;
        }

        /* access modifiers changed from: package-private */
        public List<e> a() {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            if (this.d.size() == this.a) {
                for (int i2 = this.b; i2 < this.d.size(); i2++) {
                    arrayList.add(this.d.get(i2));
                }
                while (i < this.b - 1) {
                    arrayList.add(this.d.get(i));
                    i++;
                }
            } else {
                while (i < this.d.size()) {
                    arrayList.add(this.d.get(i));
                    i++;
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public void a(e eVar) {
            int i;
            int size = this.d.size();
            int i2 = this.a;
            if (size < i2) {
                this.d.add(eVar);
                i = this.d.size();
            } else {
                this.b %= i2;
                e eVar2 = this.d.set(this.b, eVar);
                eVar2.b();
                this.c = eVar2;
                i = this.b + 1;
            }
            this.b = i;
        }
    }

    public h(int i2) {
        this(i2, false);
    }

    public h(int i2, boolean z) {
        this.c = 0;
        this.d = 0;
        this.e = 100;
        this.f = 200;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.p = false;
        this.q = false;
        this.s = false;
        this.u = new Runnable() {
            private long b = 0;
            private long c;
            private int d = -1;
            private int e = 0;
            private int f = 0;

            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                a a2 = h.this.h.a();
                if (this.d == h.this.d) {
                    this.e++;
                } else {
                    this.e = 0;
                    this.f = 0;
                    this.c = uptimeMillis;
                }
                this.d = h.this.d;
                int i = this.e;
                if (i > 0 && i - this.f >= h.t && this.b != 0 && uptimeMillis - this.c > 700 && h.this.s) {
                    a2.f = Looper.getMainLooper().getThread().getStackTrace();
                    this.f = this.e;
                }
                a2.d = h.this.s;
                a2.c = (uptimeMillis - this.b) - 300;
                a2.a = uptimeMillis;
                this.b = SystemClock.uptimeMillis();
                a2.b = this.b - uptimeMillis;
                a2.e = h.this.d;
                h.this.r.a(h.this.u, 300);
                h.this.h.a(a2);
            }
        };
        this.a = new c() {
        };
        if (z || b) {
            this.r = new u("looper_monitor");
            this.r.b();
            this.h = new b(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
            this.r.a(this.u, 300);
            return;
        }
        this.r = null;
    }

    private static long a(int i2) {
        if (i2 < 0) {
            return 0;
        }
        try {
            return g.a(i2);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown message";
        }
        try {
            String[] split = str.split(":");
            String str2 = split.length == 2 ? split[1] : "";
            if (!str.contains("{") || !str.contains("}")) {
                String str3 = str;
            } else {
                String str4 = str.split("\\{")[0];
                try {
                    str = str4 + str.split("\\}")[1];
                } catch (Throwable unused) {
                    return str4;
                }
            }
            if (str.contains("@")) {
                String[] split2 = str.split("@");
                if (split2.length > 1) {
                    str = split2[0];
                }
            }
            if (str.contains("(") && str.contains(")") && !str.endsWith(" null")) {
                String[] split3 = str.split("\\(");
                if (split3.length > 1) {
                    str = split3[1];
                }
                str = str.replace(")", "");
            }
            if (str.startsWith(" ")) {
                str = str.replace(" ", "");
            }
            return str + str2;
        } catch (Throwable unused2) {
            return str;
        }
    }

    private void a(int i2, long j2, String str) {
        a(i2, j2, str, true);
    }

    private void a(int i2, long j2, String str, boolean z) {
        this.q = true;
        e a2 = this.g.a(i2);
        a2.f = j2 - this.i;
        if (z) {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            a2.g = currentThreadTimeMillis - this.l;
            this.l = currentThreadTimeMillis;
        } else {
            a2.g = -1;
        }
        a2.e = this.c;
        a2.h = str;
        a2.i = this.m;
        a2.a = this.i;
        a2.b = j2;
        a2.c = this.j;
        this.g.a(a2);
        this.c = 0;
        this.i = j2;
    }

    /* access modifiers changed from: private */
    public void a(boolean z, long j2) {
        boolean z2;
        String str;
        int i2;
        h hVar;
        int i3 = this.d + 1;
        this.d = i3;
        this.d = i3 & 65535;
        this.q = false;
        if (this.i < 0) {
            this.i = j2;
        }
        if (this.j < 0) {
            this.j = j2;
        }
        if (this.k < 0) {
            this.k = Process.myTid();
            this.l = SystemClock.currentThreadTimeMillis();
        }
        int i4 = this.f;
        if (j2 - this.i > ((long) i4)) {
            long j3 = this.j;
            if (j2 - j3 > ((long) i4)) {
                int i5 = this.c;
                if (z) {
                    if (i5 == 0) {
                        a(1, j2, "no message running");
                    } else {
                        a(9, j3, this.m);
                        i2 = 1;
                        z2 = false;
                        str = "no message running";
                    }
                } else if (i5 == 0) {
                    i2 = 8;
                    str = this.n;
                    z2 = true;
                } else {
                    hVar = this;
                    hVar.a(9, j3, this.m, false);
                    i2 = 8;
                    str = this.n;
                    z2 = true;
                    hVar.a(i2, j2, str, z2);
                }
                hVar = this;
                hVar.a(i2, j2, str, z2);
            } else {
                a(9, j2, this.n);
            }
        }
        this.j = j2;
        String str2 = this.n;
    }

    private void e() {
        this.e = 100;
        this.f = ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE;
    }

    static /* synthetic */ int f(h hVar) {
        int i2 = hVar.c;
        hVar.c = i2 + 1;
        return i2;
    }

    public e a(long j2) {
        e eVar = new e();
        eVar.h = this.n;
        eVar.i = this.m;
        eVar.f = j2 - this.j;
        eVar.g = a(this.k) - this.l;
        eVar.e = this.c;
        return eVar;
    }

    public void a() {
        if (!this.p) {
            this.p = true;
            e();
            this.g = new f(this.e);
            this.o = new e() {
                public void a(String str) {
                    boolean unused = h.this.s = true;
                    String unused2 = h.this.n = str;
                    super.a(str);
                    h.this.a(true, e.a);
                }

                public boolean a() {
                    return true;
                }

                public void b(String str) {
                    super.b(str);
                    h.f(h.this);
                    h.this.a(false, e.a);
                    h hVar = h.this;
                    String unused = hVar.m = hVar.n;
                    String unused2 = h.this.n = "no message running";
                    boolean unused3 = h.this.s = false;
                }
            };
            i.a();
            i.a(this.o);
            k.a(k.a());
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a();
    }

    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            List<e> a2 = this.g.a();
            if (a2 == null) {
                return jSONArray;
            }
            int i2 = 0;
            for (e next : a2) {
                if (next != null) {
                    i2++;
                    jSONArray.put(next.a().put("id", i2));
                }
            }
            return jSONArray;
        } catch (Throwable unused) {
        }
    }
}
