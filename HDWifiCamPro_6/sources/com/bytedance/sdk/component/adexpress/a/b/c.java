package com.bytedance.sdk.component.adexpress.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.a.a.a;
import com.bytedance.sdk.component.adexpress.a.c.a;
import com.bytedance.sdk.component.f.b;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: TemplateManager */
public class c {
    private static File a;
    private static volatile c b;
    /* access modifiers changed from: private */
    public AtomicBoolean c = new AtomicBoolean(true);
    private AtomicBoolean d = new AtomicBoolean(false);
    private boolean e = false;
    private AtomicBoolean f = new AtomicBoolean(false);
    private AtomicInteger g = new AtomicInteger(0);
    private AtomicLong h = new AtomicLong();

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private c() {
        h();
    }

    public void b() {
        h();
    }

    private void h() {
        e.a(new g("init") {
            public void run() {
                f.a();
                c.this.c.set(false);
                c.this.i();
                c.this.e();
                if (a.a().c() != null && r.a(a.a().c().b())) {
                    a.a().c().c().post(new Runnable() {
                        public void run() {
                            if (a.a().c() != null) {
                                a.a().c().d();
                            }
                        }
                    });
                }
            }
        }, 10);
    }

    /* access modifiers changed from: private */
    public void i() {
        l.b("TemplateManager", "check template usable1");
        com.bytedance.sdk.component.adexpress.a.c.a b2 = f.b();
        if (b2 == null || !b2.f()) {
            l.b("TemplateManager", "check template usable2");
            return;
        }
        boolean z = a(b2.d()) || a(b2.e());
        if (!z) {
            b(MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            f.d();
        }
        l.b("TemplateManager", "check template usable4: " + z);
        this.e = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.List<com.bytedance.sdk.component.adexpress.a.c.a.C0025a> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x004e
            int r1 = r6.size()
            if (r1 > 0) goto L_0x000a
            goto L_0x004e
        L_0x000a:
            java.util.Iterator r6 = r6.iterator()
        L_0x000e:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x004c
            java.lang.Object r1 = r6.next()
            com.bytedance.sdk.component.adexpress.a.c.a$a r1 = (com.bytedance.sdk.component.adexpress.a.c.a.C0025a) r1
            java.lang.String r2 = r1.a()
            java.lang.String r2 = com.bytedance.sdk.component.utils.e.a((java.lang.String) r2)
            java.io.File r3 = new java.io.File
            java.io.File r4 = f()
            r3.<init>(r4, r2)
            java.lang.String r2 = com.bytedance.sdk.component.utils.e.a((java.io.File) r3)
            boolean r4 = r3.exists()
            if (r4 == 0) goto L_0x004b
            boolean r3 = r3.isFile()
            if (r3 == 0) goto L_0x004b
            java.lang.String r3 = r1.b()
            if (r3 == 0) goto L_0x004b
            java.lang.String r1 = r1.b()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x000e
        L_0x004b:
            return r0
        L_0x004c:
            r6 = 1
            return r6
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.a.b.c.a(java.util.List):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.bytedance.sdk.component.adexpress.a.c.a.b r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.List r5 = r5.b()
            if (r5 == 0) goto L_0x003a
            int r1 = r5.size()
            if (r1 <= 0) goto L_0x003a
            java.util.Iterator r5 = r5.iterator()
        L_0x0014:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r5.next()
            android.util.Pair r1 = (android.util.Pair) r1
            java.io.File r2 = new java.io.File
            java.io.File r3 = f()
            java.lang.Object r1 = r1.first
            java.lang.String r1 = (java.lang.String) r1
            r2.<init>(r3, r1)
            boolean r1 = r2.exists()
            if (r1 == 0) goto L_0x0039
            boolean r1 = r2.isFile()
            if (r1 != 0) goto L_0x0014
        L_0x0039:
            return r0
        L_0x003a:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.a.b.c.a(com.bytedance.sdk.component.adexpress.a.c.a$b):boolean");
    }

    public boolean c() {
        return this.e;
    }

    public com.bytedance.sdk.component.adexpress.a.c.a d() {
        return f.b();
    }

    public void e() {
        a(false);
    }

    public void a(boolean z) {
        if (this.c.get()) {
            l.b("TemplateManager", "loadTemplate error1");
            return;
        }
        try {
            if (this.d.get()) {
                if (z) {
                    this.g.getAndIncrement();
                }
                l.b("TemplateManager", "loadTemplate error2: " + z);
                return;
            }
            this.d.set(true);
            com.bytedance.sdk.component.adexpress.a.c.a e2 = a.a().c().e();
            com.bytedance.sdk.component.adexpress.a.c.a b2 = f.b();
            if (e2 != null) {
                if (e2.f()) {
                    boolean b3 = f.b(e2.b());
                    if (!b3) {
                        this.d.set(false);
                        this.h.set(System.currentTimeMillis());
                        l.b("TemplateManager", "loadTemplate error4");
                        return;
                    }
                    if (b3 && a.a().c() != null) {
                        a.a().c().c().post(new Runnable() {
                            public void run() {
                                com.bytedance.sdk.component.adexpress.d.e.a().c();
                            }
                        });
                    }
                    boolean a2 = (e2.d() == null || TextUtils.isEmpty(e2.d().a())) ? false : a(e2.d().a());
                    List<a.C0025a> list = null;
                    if (!a2) {
                        list = a(e2, b2);
                        a2 = list != null;
                    }
                    if (a2 && e2 != null && (a(e2.e()) || a(e2.d()))) {
                        f.a(e2);
                        f.c();
                        b(list);
                    }
                    l.b("TemplateManager", "loadTemplate update success: " + e2.b());
                    i();
                    this.d.set(false);
                    this.h.set(System.currentTimeMillis());
                    j();
                    return;
                }
            }
            this.d.set(false);
            a(109);
            l.b("TemplateManager", "loadTemplate error3");
        } catch (Throwable th) {
            l.a("TemplateManager", "loadTemplate error: ", th);
        }
    }

    private List<a.C0025a> a(com.bytedance.sdk.component.adexpress.a.c.a aVar, com.bytedance.sdk.component.adexpress.a.c.a aVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList<a.C0025a> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (aVar2 == null || aVar2.e().isEmpty()) {
            arrayList2.addAll(aVar.e());
            l.b("TemplateManager", "loadTemplate update1");
        } else if (aVar.e().isEmpty()) {
            arrayList.addAll(aVar2.e());
            l.b("TemplateManager", "loadTemplate update2");
        } else {
            for (a.C0025a next : aVar.e()) {
                if (!aVar2.e().contains(next)) {
                    arrayList2.add(next);
                } else {
                    a.C0025a a2 = f.a(next.a());
                    if (!(a2 == null || next.b() == null || next.b().equals(a2.b()))) {
                        arrayList2.add(next);
                    }
                }
            }
            for (a.C0025a next2 : aVar2.e()) {
                if (!aVar.e().contains(next2)) {
                    arrayList.add(next2);
                }
            }
            l.b("TemplateManager", "loadTemplate update3");
        }
        for (a.C0025a aVar3 : arrayList2) {
            String a3 = aVar3.a();
            String a4 = com.bytedance.sdk.component.utils.e.a(a3);
            File file = new File(f(), a4);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.f.b.a f2 = com.bytedance.sdk.component.adexpress.a.a.a.a().c().f();
            f2.a(a3);
            f2.a(f().getAbsolutePath(), a4);
            b a5 = f2.a();
            arrayList3.add(aVar3);
            if (a5 == null || !a5.f() || a5.e() == null || !a5.e().exists()) {
                this.d.set(false);
                c(arrayList3);
                l.b("TemplateManager", "loadTemplate error5");
                return null;
            }
            l.b("TemplateManager", "loadTemplate success");
        }
        return arrayList;
    }

    private void b(List<a.C0025a> list) {
        if (list != null && !list.isEmpty()) {
            for (a.C0025a a2 : list) {
                File file = new File(f(), com.bytedance.sdk.component.utils.e.a(a2.a()));
                File file2 = new File(file + ".tmp");
                if (file.exists()) {
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                }
                if (file2.exists()) {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    private boolean a(String str) {
        String a2 = com.bytedance.sdk.component.utils.e.a(str);
        File absoluteFile = f().getAbsoluteFile();
        File file = new File(absoluteFile, a2 + ".zip");
        com.bytedance.sdk.component.f.b.a f2 = com.bytedance.sdk.component.adexpress.a.a.a.a().c().f();
        f2.a(str);
        f2.a(file.getParent(), file.getName());
        b a3 = f2.a();
        if (a3.f() && a3.e() != null && a3.e().exists()) {
            File e2 = a3.e();
            try {
                y.a(e2.getAbsolutePath(), file.getParent());
                if (!e2.exists()) {
                    return true;
                }
                e2.delete();
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    private void a(int i) {
        if (com.bytedance.sdk.component.adexpress.a.a.a.a().d() != null) {
            com.bytedance.sdk.component.adexpress.a.a.a.a().d().a(i);
        }
    }

    private void b(String str) {
        if (com.bytedance.sdk.component.adexpress.a.a.a.a().d() != null) {
            com.bytedance.sdk.component.adexpress.a.a.a.a().d().a(str);
        }
    }

    private void j() {
        if (this.g.getAndSet(0) > 0 && System.currentTimeMillis() - this.h.get() > TTAdConstant.AD_MAX_EVENT_TIME) {
            e();
        }
    }

    private void c(List<a.C0025a> list) {
        if (list != null && !list.isEmpty()) {
            for (a.C0025a a2 : list) {
                File file = new File(f(), com.bytedance.sdk.component.utils.e.a(a2.a()));
                File file2 = new File(file + ".tmp");
                if (file.exists()) {
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                }
                if (file2.exists()) {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public static File f() {
        if (a == null) {
            try {
                File file = new File(new File(b.a(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                a = file;
            } catch (Throwable th) {
                l.c("TemplateManager", "getTemplateDir error", th);
            }
        }
        return a;
    }

    public void b(boolean z) {
        this.f.set(z);
    }

    public void g() {
        this.f.set(true);
        this.e = false;
        this.d.set(false);
    }
}
