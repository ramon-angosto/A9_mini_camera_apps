package com.bytedance.sdk.component.e.a;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.a.a.e;
import com.bytedance.sdk.component.e.a.b.b.b;
import com.bytedance.sdk.component.e.a.c.a;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.utils.r;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: EventMultiUtils */
public class d {
    public static final d a = new d();

    public void c() {
    }

    public void a(a aVar, Context context) {
        b(aVar, context);
        i.e().a(context);
        i.e().a(aVar.g());
        i.e().a(aVar.d());
        i.e().b(aVar.e());
        i.e().c(aVar.f());
        i.e().d(aVar.c());
        i.e().a(aVar.a() == null ? e.a : aVar.a());
        i.e().a(aVar.h());
        i.e().a(aVar.b());
        a(aVar);
    }

    private void a(a aVar) {
        Executor f;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            a.a();
            return;
        }
        f b = aVar.b();
        if (b != null && (f = b.f()) != null) {
            f.execute(new Runnable() {
                public void run() {
                    a.a();
                }
            });
        }
    }

    private void b(a aVar, Context context) {
        c.a(context, "context == null");
        c.a(aVar, "AdLogConfig == null");
        c.a(aVar.b(), "AdLogDepend ==null");
    }

    public void a() {
        c.a("EventMultiUtils start");
        final f m = i.e().m();
        if (m != null && i.e().d() != null && m.e() != null) {
            if (!i.e().a()) {
                i.e().g();
            } else if (r.a(i.e().d())) {
                i.e().g();
            } else if (d()) {
                m.e().execute(new com.bytedance.sdk.component.e.a.e.e("start") {
                    public void run() {
                        c.a("TTExecutor start");
                        d.this.a(m.g());
                    }
                });
            } else {
                a(m.g());
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            com.bytedance.sdk.component.e.a.b.b.a.a();
        } else if (i == 1) {
            b.a();
        }
    }

    public void b() {
        final f m = i.e().m();
        if (m != null && i.e().d() != null && m.e() != null) {
            if (!i.e().a()) {
                i.e().h();
            } else if (r.a(i.e().d())) {
                i.e().h();
            } else if (d()) {
                m.e().execute(new com.bytedance.sdk.component.e.a.e.e("stop") {
                    public void run() {
                        d.this.b(m.g());
                    }
                });
            } else {
                b(m.g());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        if (i == 0) {
            com.bytedance.sdk.component.e.a.b.b.a.b();
        } else if (i == 1) {
            b.b();
        }
    }

    public void a(com.bytedance.sdk.component.e.a.d.a aVar) {
        b(aVar);
    }

    private boolean d() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void b(final com.bytedance.sdk.component.e.a.d.a aVar) {
        final f m = i.e().m();
        if (aVar != null && m != null && i.e().d() != null && m.e() != null) {
            if (i.e().a()) {
                boolean a2 = r.a(i.e().d());
                c.a("dispatchEvent mainProcess:" + a2);
                if (a2) {
                    i.e().a(aVar);
                    return;
                }
                c.a("sub thread dispatch:" + d());
                if (d()) {
                    m.e().execute(new com.bytedance.sdk.component.e.a.e.e("dispatchEvent") {
                        public void run() {
                            d.this.a(aVar, m.g());
                        }
                    });
                } else {
                    a(aVar, m.g());
                }
            } else {
                i.e().a(aVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(com.bytedance.sdk.component.e.a.d.a aVar, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.e.a.b.b.a.a(aVar);
        } else if (i == 1) {
            b.a(aVar);
        }
    }

    public void a(String str, List<String> list, boolean z) {
        final f m = i.e().m();
        if (m != null && i.e().d() != null && m.e() != null && m.i()) {
            if (m.g() == 1) {
                if (list == null || list.isEmpty()) {
                    return;
                }
            } else if (m.g() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
                return;
            }
            if (!i.e().a() || r.a(i.e().d())) {
                i.e().a(str, list, z);
            } else if (d()) {
                final String str2 = str;
                final List<String> list2 = list;
                final boolean z2 = z;
                m.e().execute(new com.bytedance.sdk.component.e.a.e.e("trackFailed") {
                    public void run() {
                        d.this.a(str2, list2, z2, m.g());
                    }
                });
            } else {
                a(str, list, z, m.g());
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, List<String> list, boolean z, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.e.a.b.b.a.a(str, list, z);
        } else if (i == 1) {
            b.a(str, list, z);
        }
    }

    public void a(final String str) {
        final f m = i.e().m();
        if (m != null && i.e().d() != null && m.e() != null && m.i()) {
            if (m.g() == 0 && TextUtils.isEmpty(str)) {
                return;
            }
            if (!i.e().a() || r.a(i.e().d())) {
                i.e().a(str);
            } else if (d()) {
                m.e().execute(new com.bytedance.sdk.component.e.a.e.e("trackFailed") {
                    public void run() {
                        d.this.a(str, m.g());
                    }
                });
            } else {
                a(str, m.g());
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.e.a.b.b.a.a(str);
        } else if (i == 1) {
            b.a(str);
        }
    }
}
