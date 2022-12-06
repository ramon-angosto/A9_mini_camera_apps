package com.meizu.cloud.pushsdk.b.b;

import android.content.Context;
import android.net.Uri;
import com.meizu.cloud.pushsdk.a.d.e;
import com.meizu.cloud.pushsdk.a.d.g;
import com.meizu.cloud.pushsdk.a.d.i;
import com.meizu.cloud.pushsdk.a.d.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public abstract class c {
    protected int a = 88;
    protected int b = 22;
    protected final g c = g.a("application/json; charset=utf-8");
    protected Context d;
    protected Uri.Builder e;
    protected f f;
    protected d g;
    protected a h;
    protected h i;
    protected SSLSocketFactory j;
    protected HostnameVerifier k;
    protected String l;
    protected int m;
    protected int n;
    protected int o;
    protected long p;
    protected long q;
    protected TimeUnit r;
    /* access modifiers changed from: protected */
    public AtomicBoolean s = new AtomicBoolean(false);
    private final String t = c.class.getSimpleName();

    public abstract void a();

    public abstract void a(com.meizu.cloud.pushsdk.b.a.a aVar);

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    public static class a {
        protected final String a;
        protected final Context b;
        protected f c = null;
        protected d d = d.POST;
        protected a e = a.Single;
        protected h f = h.HTTPS;
        protected int g = 5;
        protected int h = 250;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected TimeUnit l = TimeUnit.SECONDS;
        protected SSLSocketFactory m;
        protected HostnameVerifier n;
        private Class<? extends c> o;

        public a(String str, Context context, Class<? extends c> cls) {
            this.a = str;
            this.b = context;
            this.o = cls;
        }

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.m = sSLSocketFactory;
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            this.n = hostnameVerifier;
            return this;
        }

        public a a(f fVar) {
            this.c = fVar;
            return this;
        }

        public a a(int i2) {
            this.g = i2;
            return this;
        }

        public a b(int i2) {
            this.i = i2;
            return this;
        }
    }

    public c(a aVar) {
        this.g = aVar.d;
        this.f = aVar.c;
        this.d = aVar.b;
        this.h = aVar.e;
        this.i = aVar.f;
        this.j = aVar.m;
        this.k = aVar.n;
        this.m = aVar.g;
        this.n = aVar.i;
        this.o = aVar.h;
        this.p = aVar.j;
        this.q = aVar.k;
        this.l = aVar.a;
        this.r = aVar.l;
        c();
        com.meizu.cloud.pushsdk.b.f.c.c(this.t, "Emitter created successfully!", new Object[0]);
    }

    private void c() {
        String str = this.t;
        com.meizu.cloud.pushsdk.b.f.c.a(str, "security " + this.i, new Object[0]);
        if (this.i == h.HTTP) {
            this.e = Uri.parse("http://" + this.l).buildUpon();
        } else {
            this.e = Uri.parse("https://" + this.l).buildUpon();
        }
        if (this.g == d.GET) {
            this.e.appendPath("i");
        } else {
            this.e.appendEncodedPath("push_data_report/mobile");
        }
    }

    /* access modifiers changed from: protected */
    public int a(i iVar) {
        try {
            com.meizu.cloud.pushsdk.b.f.c.b(this.t, "Sending request: %s", iVar);
            return new e(iVar).a().a();
        } catch (IOException e2) {
            com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Request sending failed: %s", e2.toString());
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public LinkedList<e> a(b bVar) {
        int size = bVar.a().size();
        LinkedList<Long> b2 = bVar.b();
        LinkedList<e> linkedList = new LinkedList<>();
        if (this.g == d.GET) {
            for (int i2 = 0; i2 < size; i2++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b2.get(i2));
                com.meizu.cloud.pushsdk.b.a.a aVar = bVar.a().get(i2);
                linkedList.add(new e(aVar.b() + ((long) this.b) > this.p, b(aVar), linkedList2));
            }
        } else {
            for (int i3 = 0; i3 < size; i3 += this.h.a()) {
                LinkedList linkedList3 = new LinkedList();
                long j2 = 0;
                ArrayList arrayList = new ArrayList();
                LinkedList linkedList4 = linkedList3;
                int i4 = i3;
                while (i4 < this.h.a() + i3 && i4 < size) {
                    com.meizu.cloud.pushsdk.b.a.a aVar2 = bVar.a().get(i4);
                    LinkedList linkedList5 = linkedList4;
                    long b3 = aVar2.b() + ((long) this.b);
                    int i5 = this.a;
                    ArrayList arrayList2 = arrayList;
                    int i6 = i5;
                    if (((long) i5) + b3 > this.q) {
                        ArrayList arrayList3 = new ArrayList();
                        LinkedList linkedList6 = new LinkedList();
                        arrayList3.add(aVar2);
                        linkedList6.add(b2.get(i4));
                        linkedList.add(new e(true, a((ArrayList<com.meizu.cloud.pushsdk.b.a.a>) arrayList3), linkedList6));
                        arrayList = arrayList2;
                        linkedList4 = linkedList5;
                    } else {
                        long j3 = j2 + b3;
                        long j4 = j3;
                        if (((long) i6) + j3 + ((long) (arrayList2.size() - 1)) > this.q) {
                            linkedList.add(new e(false, a((ArrayList<com.meizu.cloud.pushsdk.b.a.a>) arrayList2), linkedList5));
                            ArrayList arrayList4 = new ArrayList();
                            LinkedList linkedList7 = new LinkedList();
                            arrayList4.add(aVar2);
                            linkedList7.add(b2.get(i4));
                            arrayList = arrayList4;
                            linkedList4 = linkedList7;
                            j2 = b3;
                        } else {
                            ArrayList arrayList5 = arrayList2;
                            LinkedList linkedList8 = linkedList5;
                            arrayList5.add(aVar2);
                            linkedList8.add(b2.get(i4));
                            j2 = j4;
                            LinkedList linkedList9 = linkedList8;
                            arrayList = arrayList5;
                            linkedList4 = linkedList9;
                        }
                    }
                    i4++;
                }
                ArrayList arrayList6 = arrayList;
                LinkedList linkedList10 = linkedList4;
                ArrayList arrayList7 = arrayList6;
                if (!arrayList7.isEmpty()) {
                    linkedList.add(new e(false, a((ArrayList<com.meizu.cloud.pushsdk.b.a.a>) arrayList7), linkedList10));
                }
            }
        }
        return linkedList;
    }

    private i b(com.meizu.cloud.pushsdk.b.a.a aVar) {
        a(aVar, "");
        this.e.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.e.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.e.build().toString()).a().c();
    }

    private i a(ArrayList<com.meizu.cloud.pushsdk.b.a.a> arrayList) {
        new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.meizu.cloud.pushsdk.b.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        String uri = this.e.build().toString();
        String stringBuffer2 = stringBuffer.toString();
        String str = this.t;
        com.meizu.cloud.pushsdk.b.f.c.b(str, "post final String " + stringBuffer2, new Object[0]);
        return new i.a().a(uri).a(j.a(this.c, stringBuffer2)).c();
    }

    private void a(com.meizu.cloud.pushsdk.b.a.a aVar, String str) {
        if (str.equals("")) {
            str = com.meizu.cloud.pushsdk.b.f.e.a();
        }
        aVar.a("stm", str);
    }

    public String b() {
        return this.e.clearQuery().build().toString();
    }
}
