package com.huawei.android.pushagent.b.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.pushagent.a.c;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class b {
    private static b e;
    private int a = 3;
    private long b = 600000;
    private long c = 300000;
    private long d = 300000;
    private int f = 0;
    private ArrayList g = new ArrayList();

    /* renamed from: com.huawei.android.pushagent.b.d.b$1  reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[C0035b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.huawei.android.pushagent.b.d.b$b[] r0 = com.huawei.android.pushagent.b.d.b.C0035b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.android.pushagent.b.d.b$b r1 = com.huawei.android.pushagent.b.d.b.C0035b.NETWORK_CHANGE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.huawei.android.pushagent.b.d.b$b r1 = com.huawei.android.pushagent.b.d.b.C0035b.TRS_QUERIED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.huawei.android.pushagent.b.d.b$b r1 = com.huawei.android.pushagent.b.d.b.C0035b.SOCKET_CLOSE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.huawei.android.pushagent.b.d.b$b r1 = com.huawei.android.pushagent.b.d.b.C0035b.SOCKET_CONNECTED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.d.b.AnonymousClass1.<clinit>():void");
        }
    }

    static class a implements Comparable {
        /* access modifiers changed from: private */
        public long a;
        private boolean b;

        a() {
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return (int) ((a() - aVar.a()) / 1000);
        }

        public long a() {
            return this.a;
        }

        public void a(long j) {
            this.a = j;
        }

        public void a(boolean z) {
            this.b = z;
        }

        public boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                String[] split = str.split(";");
                if (split.length < 2) {
                    e.d("PushLogAC2705", "load connectinfo " + str + " error");
                    return false;
                }
                this.a = Long.parseLong(split[0]);
                this.b = Boolean.parseBoolean(split[1]);
                return true;
            } catch (Exception e) {
                e.c("PushLogAC2705", "load connectinfo " + str + " error:" + e.toString(), e);
                return false;
            }
        }

        public boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass() || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.a == aVar.a;
        }

        public int hashCode() {
            long j = this.a;
            return ((527 + ((int) (j ^ (j >>> 32)))) * 31) + (this.b ? 1 : 0);
        }

        public String toString() {
            if (this.a <= 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.a);
            stringBuffer.append(";");
            stringBuffer.append(this.b);
            return stringBuffer.toString();
        }
    }

    /* renamed from: com.huawei.android.pushagent.b.d.b$b  reason: collision with other inner class name */
    public enum C0035b {
        SOCKET_CLOSE,
        SOCKET_CONNECTED,
        TRS_QUERIED,
        NETWORK_CHANGE
    }

    private b() {
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (e == null) {
                e = new b();
            }
            if (e.g.isEmpty()) {
                e.c(context);
            }
            bVar = e;
        }
        return bVar;
    }

    private void a(Context context, boolean z) {
        e.a("PushLogAC2705", "save connection info " + z);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (currentTimeMillis < aVar.a() || currentTimeMillis - aVar.a() > this.b) {
                arrayList.add(aVar);
            }
        }
        if (!arrayList.isEmpty()) {
            e.a("PushLogAC2705", "some connection info is expired:" + arrayList.size());
            this.g.removeAll(arrayList);
        }
        a aVar2 = new a();
        aVar2.a(z);
        aVar2.a(System.currentTimeMillis());
        if (this.g.size() >= this.a) {
            this.g.remove(0);
        }
        this.g.add(aVar2);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it2 = this.g.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(((a) it2.next()).toString());
            stringBuffer.append("|");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        new h(context, "PushConnectControl").a("connectPushSvrInfos", stringBuffer.toString());
    }

    private boolean a() {
        if (this.g.size() < this.a) {
            e.a("PushLogAC2705", "total connect times is less than " + this.a);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.g.iterator();
        int i = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (currentTimeMillis > aVar.a() && currentTimeMillis - aVar.a() < this.b) {
                i++;
            }
        }
        e.a("PushLogAC2705", "connect times in last " + this.b + " is " + i + ", limits is " + this.a);
        return i >= this.a;
    }

    private void b() {
        this.f = 0;
    }

    private void b(Context context, boolean z) {
        e.a("PushLogAC2705", "set bad network mode " + z);
        c.a(context, new com.huawei.android.pushagent.a.a("isBadNetworkMode", Boolean.class, (Object) Boolean.valueOf(z)));
    }

    private void c() {
        this.f++;
    }

    private void c(Context context) {
        this.a = com.huawei.android.pushagent.b.b.a.a(context).Z();
        this.b = com.huawei.android.pushagent.b.b.a.a(context).Y();
        this.c = com.huawei.android.pushagent.b.b.a.a(context).ab();
        this.d = com.huawei.android.pushagent.b.b.a.a(context).aa();
        String b2 = new h(context, "PushConnectControl").b("connectPushSvrInfos");
        if (!TextUtils.isEmpty(b2)) {
            e.a("PushLogAC2705", "connectPushSvrInfos is " + b2);
            for (String str : b2.split("\\|")) {
                a aVar = new a();
                if (aVar.a(str)) {
                    this.g.add(aVar);
                }
            }
        }
        Collections.sort(this.g);
        if (this.g.size() > this.a) {
            ArrayList arrayList = new ArrayList();
            int size = this.g.size() - this.a;
            for (int i = 0; i < size; i++) {
                arrayList.add(this.g.get(i));
            }
            this.g.removeAll(arrayList);
        }
    }

    private void d(Context context) {
        String str;
        if (!g(context)) {
            e.a("PushLogAC2705", "It is not bad network mode, do nothing");
        } else if (this.g.isEmpty()) {
            b(context, false);
        } else {
            ArrayList arrayList = this.g;
            a aVar = (a) arrayList.get(arrayList.size() - 1);
            if (aVar.b()) {
                e.a("PushLogAC2705", "last connection is success");
                long currentTimeMillis = System.currentTimeMillis();
                long a2 = aVar.a();
                if (currentTimeMillis - a2 > this.c || currentTimeMillis < a2) {
                    e.a("PushLogAC2705", this.c + " has passed since last connect");
                    b(context, false);
                    return;
                }
                str = "connection keep too short , still in bad network mode";
            } else {
                str = "last connection result is false , still in bad network mode";
            }
            e.a("PushLogAC2705", str);
        }
    }

    private long e(Context context) {
        long k;
        long j = 0;
        if (this.g.isEmpty()) {
            e.a("PushLogAC2705", "first connection, return 0");
            return 0;
        }
        long j2 = 1000;
        if (!c.a(context, "cloudpush_isNoDelayConnect", false)) {
            if (((long) this.f) == com.huawei.android.pushagent.b.b.a.a(context).s()) {
                com.huawei.android.pushagent.b.b.a.a(context).a = true;
                k = com.huawei.android.pushagent.b.b.a.a(context).o();
            } else {
                int i = this.f;
                if (i == 0) {
                    k = com.huawei.android.pushagent.b.b.a.a(context).k();
                } else if (i == 1) {
                    k = com.huawei.android.pushagent.b.b.a.a(context).l();
                } else if (i == 2) {
                    k = com.huawei.android.pushagent.b.b.a.a(context).m();
                } else if (i != 3) {
                    j2 = 1000 * com.huawei.android.pushagent.b.b.a.a(context).o();
                    com.huawei.android.pushagent.b.b.a.a(context).a = true;
                } else {
                    k = com.huawei.android.pushagent.b.b.a.a(context).n();
                }
            }
            j2 = 1000 * k;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = this.g;
        long b2 = ((a) arrayList.get(arrayList.size() - 1)).a;
        if (currentTimeMillis < b2) {
            e.a("PushLogAC2705", "now is less than last connect time");
        } else {
            j = Math.max((b2 + j2) - currentTimeMillis, 0);
        }
        e.b("PushLogAC2705", "after getConnectPushSrvInterval:" + j + " ms, connectTimes:" + this.f);
        return j;
    }

    private long f(Context context) {
        if (a()) {
            b(context, true);
        }
        boolean g2 = g(context);
        e.a("PushLogAC2705", "bad network mode is " + g2);
        long j = 0;
        if (g2 && !this.g.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = this.g;
            long b2 = ((a) arrayList.get(arrayList.size() - 1)).a;
            if (currentTimeMillis < b2) {
                e.a("PushLogAC2705", "now is less than last connect time");
            } else {
                j = Math.max((b2 + this.d) - currentTimeMillis, 0);
            }
            e.a("PushLogAC2705", "It is in bad network mode, connect limit interval is " + j);
        }
        return j;
    }

    private boolean g(Context context) {
        return c.a(context, "isBadNetworkMode", false);
    }

    public void a(Context context, C0035b bVar, Bundle bundle) {
        String str;
        e.a("PushLogAC2705", "receive reconnectevent:" + bVar);
        int i = AnonymousClass1.a[bVar.ordinal()];
        if (i == 1 || i == 2) {
            b();
        } else if (i == 3) {
            d(context);
            if (bundle.containsKey("errorType")) {
                if (c.a.Err_Connect == ((c.a) bundle.getSerializable("errorType"))) {
                    a(context, false);
                    c();
                    com.huawei.android.pushagent.b.a.a.a(context).a(b(context));
                }
                str = "socket close not caused by connect error, do not need save connection info";
            } else {
                str = "socket close not caused by pushException";
            }
            e.a("PushLogAC2705", str);
            c();
            com.huawei.android.pushagent.b.a.a.a(context).a(b(context));
        } else if (i == 4) {
            b();
            a(context, true);
        }
    }

    public long b(Context context) {
        return Math.max(e(context), f(context));
    }
}
