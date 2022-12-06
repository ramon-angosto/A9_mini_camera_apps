package com.xiaomi.push.service;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class y {
    private static y a;
    private ConcurrentHashMap<String, HashMap<String, b>> b = new ConcurrentHashMap<>();
    private List<a> c = new ArrayList();

    public interface a {
        void a();
    }

    public static class b {
        public String a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public b k;
        public Context l;
        c m = c.unbind;
        private int n = 0;
        private List<a> o = new ArrayList();
        /* access modifiers changed from: private */
        public XMPushService p;
        /* access modifiers changed from: private */
        public XMPushService.b q = new XMPushService.b(this);

        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.p = xMPushService;
            a((a) new z(this));
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.n + 1) * 15))) * 1000;
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? EnvironmentCompat.MEDIA_UNKNOWN : "KICK" : "CLOSE" : "OPEN";
        }

        public void a(a aVar) {
            synchronized (this.o) {
                this.o.add(aVar);
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            c cVar2 = cVar;
            int i4 = i2;
            int i5 = i3;
            String str3 = str;
            String str4 = str2;
            synchronized (this.o) {
                for (a a2 : this.o) {
                    a2.a(this.m, cVar, i5);
                }
            }
            c cVar3 = this.m;
            if (cVar3 != cVar2) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", new Object[]{cVar3, cVar2, a(i2), aa.a(i3), str3, str4, this.h}));
                this.m = cVar2;
            }
            b bVar = this.k;
            if (bVar == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (i4 == 2) {
                bVar.a(this.l, this, i5);
            } else if (i4 == 3) {
                bVar.a(this.l, this, str4, str3);
            } else if (i4 == 1) {
                boolean z = cVar2 == c.binded;
                if (!z && "wait".equals(str4)) {
                    this.n++;
                } else if (z) {
                    this.n = 0;
                }
                this.k.a(this.l, this, z, i3, str);
            }
        }

        public void b(a aVar) {
            synchronized (this.o) {
                this.o.remove(aVar);
            }
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private y() {
    }

    public static synchronized y a() {
        y yVar;
        synchronized (y.class) {
            if (a == null) {
                a = new y();
            }
            yVar = a;
        }
        return yVar;
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> values : this.b.values()) {
            for (b a2 : values.values()) {
                a2.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> values : this.b.values()) {
            for (b a2 : values.values()) {
                a2.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.c.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap hashMap = this.b.get(bVar.h);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.b.put(bVar.h, hashMap);
        }
        hashMap.put(d(bVar.b), bVar);
        for (a a2 : this.c) {
            a2.a();
        }
    }

    public synchronized void a(String str) {
        HashMap hashMap = this.b.get(str);
        if (hashMap != null) {
            hashMap.clear();
            this.b.remove(str);
        }
        for (a a2 : this.c) {
            a2.a();
        }
    }

    public synchronized void a(String str, String str2) {
        HashMap hashMap = this.b.get(str);
        if (hashMap != null) {
            hashMap.remove(d(str2));
            if (hashMap.isEmpty()) {
                this.b.remove(str);
            }
        }
        for (a a2 : this.c) {
            a2.a();
        }
    }

    public synchronized b b(String str, String str2) {
        HashMap hashMap = this.b.get(str);
        if (hashMap == null) {
            return null;
        }
        return (b) hashMap.get(d(str2));
    }

    public synchronized ArrayList<b> b() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> values : this.b.values()) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    public synchronized List<String> b(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> values : this.b.values()) {
            for (b bVar : values.values()) {
                if (str.equals(bVar.a)) {
                    arrayList.add(bVar.h);
                }
            }
        }
        return arrayList;
    }

    public synchronized int c() {
        return this.b.size();
    }

    public synchronized Collection<b> c(String str) {
        if (!this.b.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.b.get(str).clone()).values();
    }

    public synchronized void d() {
        this.b.clear();
    }

    public synchronized void e() {
        this.c.clear();
    }
}
