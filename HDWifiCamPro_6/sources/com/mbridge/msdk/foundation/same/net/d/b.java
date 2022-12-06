package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.j;
import com.mbridge.msdk.foundation.same.net.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: FileDownloader */
public final class b {
    /* access modifiers changed from: private */
    public j a;
    private int b;
    private LinkedList<a> c = new LinkedList<>();

    public b(j jVar, int i) {
        this.a = jVar;
        this.b = i;
    }

    public final a a(File file, String str, e<Void> eVar) {
        a aVar = new a(file, str, eVar);
        synchronized (this) {
            this.c.add(aVar);
        }
        a();
        return aVar;
    }

    private void a() {
        synchronized (this) {
            int i = 0;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                if (((a) it.next()).a()) {
                    i++;
                }
            }
            if (i < this.b) {
                Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    if (a.a((a) it2.next()) && (i = i + 1) == this.b) {
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: FileDownloader */
    public class a {
        private String b;
        private File c;
        /* access modifiers changed from: private */
        public e<Void> d;
        private a e;
        /* access modifiers changed from: private */
        public int f;

        private a(File file, String str, e<Void> eVar) {
            this.c = file;
            this.d = eVar;
            this.b = str;
        }

        public final boolean a() {
            return this.f == 1;
        }

        static /* synthetic */ boolean a(a aVar) {
            if (aVar.f != 0) {
                return false;
            }
            b bVar = b.this;
            aVar.e = new a(aVar.c, aVar.b);
            aVar.e.a(new f<Void>() {
                boolean a;

                public final void a() {
                    a.this.d.a();
                }

                public final void b() {
                    if (!this.a) {
                        int unused = a.this.f = 3;
                        a.this.d.b();
                        b.a(b.this, a.this);
                    }
                }

                public final void a(k kVar) {
                    if (!this.a) {
                        a.this.d.a(kVar);
                    }
                }

                public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
                    if (!this.a) {
                        a.this.d.a(aVar);
                    }
                }

                public final void c() {
                    a.this.d.c();
                    this.a = true;
                }

                public final void a(long j, long j2) {
                    a.this.d.a(j, j2);
                }
            });
            aVar.f = 1;
            b.this.a.a((i) aVar.e);
            return true;
        }
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        synchronized (bVar) {
            bVar.c.remove(aVar);
        }
        bVar.a();
    }
}
