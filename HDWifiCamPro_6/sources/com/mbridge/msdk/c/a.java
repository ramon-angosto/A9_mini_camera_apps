package com.mbridge.msdk.c;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.reward.adapter.d;
import java.util.LinkedList;
import java.util.List;

/* compiled from: LoopTimer */
public final class a {
    /* access modifiers changed from: private */
    public long a;
    /* access modifiers changed from: private */
    public boolean b;
    private LinkedList<h> c;
    private LinkedList<h> d;
    private int e;
    private int f;
    private e g;
    private com.mbridge.msdk.videocommon.d.a h;
    private n i;
    private g j;
    /* access modifiers changed from: private */
    public Handler k;

    /* renamed from: com.mbridge.msdk.c.a$a  reason: collision with other inner class name */
    /* compiled from: LoopTimer */
    static class C0057a {
        static a a = new a();
    }

    private a() {
        this.b = false;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = 0;
        this.f = 0;
        this.k = new Handler() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(android.os.Message r5) {
                /*
                    r4 = this;
                    com.mbridge.msdk.c.a r0 = com.mbridge.msdk.c.a.this
                    monitor-enter(r0)
                    int r5 = r5.what     // Catch:{ all -> 0x0036 }
                    r1 = 1
                    if (r5 == r1) goto L_0x0012
                    r1 = 2
                    if (r5 == r1) goto L_0x000c
                    goto L_0x0034
                L_0x000c:
                    com.mbridge.msdk.c.a r5 = com.mbridge.msdk.c.a.this     // Catch:{ all -> 0x0036 }
                    com.mbridge.msdk.c.a.c(r5)     // Catch:{ all -> 0x0036 }
                    goto L_0x0034
                L_0x0012:
                    com.mbridge.msdk.c.a r5 = com.mbridge.msdk.c.a.this     // Catch:{ all -> 0x0036 }
                    boolean r5 = r5.b     // Catch:{ all -> 0x0036 }
                    if (r5 == 0) goto L_0x001c
                    monitor-exit(r0)     // Catch:{ all -> 0x0036 }
                    return
                L_0x001c:
                    com.mbridge.msdk.c.a r5 = com.mbridge.msdk.c.a.this     // Catch:{ all -> 0x0036 }
                    com.mbridge.msdk.c.a r2 = com.mbridge.msdk.c.a.this     // Catch:{ all -> 0x0036 }
                    long r2 = r2.a     // Catch:{ all -> 0x0036 }
                    com.mbridge.msdk.c.a.a((com.mbridge.msdk.c.a) r5, (long) r2)     // Catch:{ all -> 0x0036 }
                    android.os.Message r5 = r4.obtainMessage(r1)     // Catch:{ all -> 0x0036 }
                    com.mbridge.msdk.c.a r1 = com.mbridge.msdk.c.a.this     // Catch:{ all -> 0x0036 }
                    long r1 = r1.a     // Catch:{ all -> 0x0036 }
                    r4.sendMessageDelayed(r5, r1)     // Catch:{ all -> 0x0036 }
                L_0x0034:
                    monitor-exit(r0)     // Catch:{ all -> 0x0036 }
                    return
                L_0x0036:
                    r5 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0036 }
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.c.a.AnonymousClass1.handleMessage(android.os.Message):void");
            }
        };
    }

    private boolean a(h hVar) {
        if (hVar == null || TextUtils.isEmpty(hVar.a())) {
            return false;
        }
        String a2 = hVar.a();
        boolean z = true;
        try {
            if (this.g == null) {
                return true;
            }
            long j2 = 0;
            if (this.h != null) {
                j2 = this.h.d();
            }
            int a3 = this.g.a(a2, j2);
            if (a3 != -1) {
                if (a3 == 1) {
                    return true;
                }
            } else if (!TextUtils.isEmpty(a2)) {
                if (this.c != null && this.c.contains(a2)) {
                    this.c.remove(a2);
                } else if (this.d != null && this.d.contains(a2)) {
                    this.d.remove(a2);
                }
                if (this.i != null) {
                    this.i.a(a2);
                }
            }
            try {
                this.k.sendMessage(this.k.obtainMessage(2));
                return false;
            } catch (Throwable th) {
                th = th;
                z = false;
                q.a("LoopTimer", th.getMessage(), th);
                return z;
            }
        } catch (Throwable th2) {
            th = th2;
            q.a("LoopTimer", th.getMessage(), th);
            return z;
        }
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g2 != null) {
                final d dVar = new d(g2, str, str2);
                dVar.b(z);
                dVar.a((b) new b() {
                    public final void a() {
                    }

                    public final void a(String str) {
                        a.this.k.sendMessage(a.this.k.obtainMessage(2));
                        dVar.a((b) null);
                    }

                    public final void b(String str) {
                        a.this.k.sendMessage(a.this.k.obtainMessage(2));
                        dVar.a((b) null);
                    }
                });
                dVar.a(1, 8000, false);
            }
        } catch (Exception e2) {
            q.a("LoopTimer", e2.getMessage(), e2);
        }
    }

    public final void a(String str, String str2) {
        if (!this.c.contains(str2)) {
            this.c.add(new h(str, str2, 94));
            n nVar = this.i;
            if (nVar != null) {
                nVar.a(str, str2, 94);
            }
        }
    }

    public final void b(String str, String str2) {
        if (!this.d.contains(str2)) {
            this.d.add(new h(str, str2, 287));
            n nVar = this.i;
            if (nVar != null) {
                nVar.a(str, str2, 287);
            }
        }
    }

    public final void a(long j2) {
        if (this.j == null) {
            this.j = g.a(com.mbridge.msdk.foundation.controller.a.e().g());
        }
        if (this.i == null) {
            this.i = n.a((f) this.j);
        }
        List<h> a2 = this.i.a(287);
        if (a2 != null) {
            this.d.addAll(a2);
            for (h next : a2) {
                b(next.b(), next.a());
            }
        }
        List<h> a3 = this.i.a(94);
        if (a3 != null) {
            this.c.addAll(a3);
            for (h next2 : a3) {
                a(next2.b(), next2.a());
            }
        }
        if (this.g == null) {
            this.g = e.a((f) this.j);
        }
        if (this.h == null) {
            this.h = com.mbridge.msdk.videocommon.d.b.a().b();
        }
        this.a = j2;
        this.b = false;
        Handler handler = this.k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.a);
    }

    static /* synthetic */ void a(a aVar, long j2) {
        LinkedList<h> linkedList = aVar.c;
        if (linkedList == null || linkedList.size() <= 0 || aVar.e == 0 || aVar.c.size() <= aVar.e) {
            LinkedList<h> linkedList2 = aVar.d;
            if (linkedList2 == null || linkedList2.size() <= 0 || aVar.f == 0 || aVar.d.size() == aVar.f) {
                aVar.f = 0;
                aVar.e = 0;
                Handler handler = aVar.k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }

    static /* synthetic */ void c(a aVar) {
        try {
            if (aVar.c != null && aVar.c.size() > 0 && aVar.e < aVar.c.size()) {
                h hVar = aVar.c.get(aVar.e);
                aVar.e++;
                if (aVar.a(hVar)) {
                    aVar.a(hVar.b(), hVar.a(), false);
                }
            } else if (aVar.d != null && aVar.d.size() > 0 && aVar.f < aVar.d.size()) {
                h hVar2 = aVar.d.get(aVar.f);
                aVar.f++;
                if (aVar.a(hVar2)) {
                    aVar.a(hVar2.b(), hVar2.a(), true);
                }
            }
        } catch (Throwable th) {
            q.a("LoopTimer", th.getMessage(), th);
        }
    }
}
