package com.bytedance.sdk.component.e.a.b.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.component.e.a.a.b;
import com.bytedance.sdk.component.e.a.a.d;
import com.bytedance.sdk.component.e.a.d.a;
import com.bytedance.sdk.component.e.a.e.e;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.i;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdPriorityLogThread */
public class c extends HandlerThread implements Handler.Callback {
    protected d a;
    private volatile boolean b = true;
    private final Object c = new Object();
    private com.bytedance.sdk.component.e.a.b.c d;
    private final PriorityBlockingQueue<a> e;
    /* access modifiers changed from: private */
    public volatile int f;
    private volatile long g = 0;
    private volatile long h = 0;
    private final AtomicInteger i = new AtomicInteger(0);
    private final long j = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    private final long k = 5000000000L;
    /* access modifiers changed from: private */
    public final AtomicInteger l = new AtomicInteger(0);
    private volatile Handler m;
    private final List<a> n = new ArrayList();
    private final AtomicInteger o = new AtomicInteger(0);
    private final AtomicInteger p = new AtomicInteger(0);
    private int q = 10;
    private final int r = 1;
    private final int s = 2;
    private final int t = 3;

    public c(PriorityBlockingQueue<a> priorityBlockingQueue) {
        super("csj_log");
        this.e = priorityBlockingQueue;
        this.a = new b();
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean a() {
        return this.b;
    }

    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            com.bytedance.sdk.component.e.a.c.c.a("HANDLER_MESSAGE_INIT");
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.i(), 1);
            a(true);
            d();
        } else if (i2 == 2 || i2 == 3) {
            com.bytedance.sdk.component.e.a.c.c.a("-----------------server busy handleMessage---------------- ");
            b();
        } else if (i2 == 11) {
            com.bytedance.sdk.component.e.a.c.c.a("opt upload");
            ArrayList arrayList = new ArrayList(this.n);
            this.n.clear();
            a((List<a>) arrayList, false, "timeout_dispatch");
            i();
        }
        return true;
    }

    private void b() {
        com.bytedance.sdk.component.e.a.c.c.a("sendServerBusyOrRoutineErrorRetryMessage");
        c();
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.I(), 1);
        a(1);
    }

    private void c() {
        if (!isAlive()) {
            com.bytedance.sdk.component.e.a.c.c.a("th dead");
            com.bytedance.sdk.component.e.a.b.d.a.d();
        } else if (!a()) {
            com.bytedance.sdk.component.e.a.c.c.a("monitor  mLogThread ");
            a(6);
        }
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.m = new Handler(getLooper(), this);
        com.bytedance.sdk.component.e.a.b.d.a.a(this.m);
        this.m.sendEmptyMessage(1);
        com.bytedance.sdk.component.e.a.c.c.a("onLooperPrepared");
    }

    public boolean a(int i2, boolean z) {
        f m2 = i.e().m();
        if (m2 != null && m2.a(i.e().d())) {
            return this.a.a(i2, z);
        }
        com.bytedance.sdk.component.e.a.c.c.d("AdThread NET IS NOT AVAILABLE!!!");
        return false;
    }

    public void a(a aVar, boolean z) {
        if (aVar != null) {
            com.bytedance.sdk.component.e.a.c.c.a("ignore result : " + z + ":" + this.b + " adType: " + aVar.d());
            if (!z) {
                this.e.add(aVar);
                c(2);
            } else if (this.m != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(aVar);
                a((List<a>) arrayList, true, "ignore_result_dispatch");
            } else {
                com.bytedance.sdk.component.e.a.c.c.d("handler is null，ignore is true");
            }
        }
    }

    public void a(int i2) {
        try {
            boolean a2 = a(i2, com.bytedance.sdk.component.e.a.b.d.a.b);
            com.bytedance.sdk.component.e.a.c.c.c("notify flush : " + a2);
            if (i2 == 6 || a2) {
                com.bytedance.sdk.component.e.a.d.b bVar = new com.bytedance.sdk.component.e.a.d.b();
                bVar.a(i2);
                this.e.add(bVar);
                c(3);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.e.a.c.c.d(th.getMessage());
        }
    }

    private void a(a aVar, int i2) {
        this.i.set(0);
        com.bytedance.sdk.component.e.a.c.c.a("handleThreadMessage()");
        if (i2 == 0) {
            this.f = ((com.bytedance.sdk.component.e.a.d.b) aVar).j();
            if (this.f != 6) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.N(), 1);
                b(aVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.e.a.d.b bVar = (com.bytedance.sdk.component.e.a.d.b) aVar;
        if (bVar.j() == 1) {
            this.f = 1;
            b(aVar);
        } else if (bVar.j() == 2) {
            com.bytedance.sdk.component.e.a.c.c.a("before size:" + i2);
            f();
            com.bytedance.sdk.component.e.a.c.c.a("after size :" + i2);
            this.f = 2;
            b(aVar);
        }
    }

    private void d() {
        while (a()) {
            try {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.h(), 1);
                a poll = this.e.poll(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS, TimeUnit.MILLISECONDS);
                int size = this.e.size();
                com.bytedance.sdk.component.e.a.c.c.a("poll size:" + size);
                if (poll instanceof com.bytedance.sdk.component.e.a.d.b) {
                    a(poll, size);
                } else if (poll == null) {
                    int incrementAndGet = this.i.incrementAndGet();
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.O(), 1);
                    if (b(incrementAndGet)) {
                        e();
                        return;
                    } else if (incrementAndGet < 4) {
                        com.bytedance.sdk.component.e.a.c.c.a("timeoutCount:" + incrementAndGet);
                        this.f = 1;
                        b((a) null);
                    }
                } else {
                    a(poll);
                    b(poll);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.component.e.a.c.c.d("run exception:" + th.getMessage());
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.K(), 1);
            }
        }
    }

    private boolean b(int i2) {
        return i2 >= 4 && this.l.get() == 0 && !com.bytedance.sdk.component.e.a.b.d.a.b && !com.bytedance.sdk.component.e.a.b.d.a.c;
    }

    private void e() {
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.v(), 1);
        a(false);
        com.bytedance.sdk.component.e.a.b.d.a.c();
        com.bytedance.sdk.component.e.a.c.c.c("exit log thread");
    }

    private void f() {
        if (this.e.size() >= 100) {
            for (int i2 = 0; i2 < 100; i2++) {
                a poll = this.e.poll();
                if (poll instanceof com.bytedance.sdk.component.e.a.d.b) {
                    com.bytedance.sdk.component.e.a.c.c.a("ignore tm");
                } else if (poll != null) {
                    a(poll);
                } else {
                    com.bytedance.sdk.component.e.a.c.c.d("event == null");
                }
            }
        }
    }

    private void a(a aVar) {
        this.i.set(0);
        if (com.bytedance.sdk.component.e.a.b.d.a.b) {
            this.f = 5;
        } else if (com.bytedance.sdk.component.e.a.b.d.a.c) {
            this.f = 7;
        } else {
            this.f = 4;
        }
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.U(), 1);
        this.a.a(aVar, this.f);
        com.bytedance.sdk.component.e.a.c.a.g(aVar);
    }

    private boolean g() {
        return com.bytedance.sdk.component.e.a.b.d.a.b && (this.f == 4 || this.f == 7 || this.f == 6 || this.f == 5 || this.f == 2);
    }

    private void b(a aVar) {
        if (g()) {
            com.bytedance.sdk.component.e.a.c.c.c("upload cancel:" + com.bytedance.sdk.component.e.a.c.a.a(this.f));
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.l(), 1);
            if (this.e.size() != 0) {
                return;
            }
            if (!this.m.hasMessages(2)) {
                com.bytedance.sdk.component.e.a.b.d.a.b = false;
                this.h = 0;
                this.g = 0;
                this.o.set(0);
                this.p.set(0);
            } else {
                a(false);
                return;
            }
        }
        boolean a2 = a(this.f, com.bytedance.sdk.component.e.a.b.d.a.b);
        com.bytedance.sdk.component.e.a.c.a.a(a2, this.f, aVar);
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.m(), 1);
        if (a2) {
            List<a> a3 = this.a.a(this.f, -1);
            if (a3 != null) {
                a(a3);
            } else {
                h();
            }
        } else {
            h();
        }
    }

    private void h() {
        try {
            if (this.e.size() == 0 && this.m.hasMessages(11) && a()) {
                a(false);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.e.a.c.c.d(e2.getMessage());
        }
    }

    private void a(List<a> list, String str) {
        a(str);
        a(list, false, str);
        i();
    }

    private void a(List<a> list) {
        if (list.size() != 0) {
            com.bytedance.sdk.component.e.a.c.a.a(list, this.e.size());
            if (list.size() > 1) {
                a(list, "batchRead");
                return;
            }
            a aVar = list.get(0);
            if (aVar == null) {
                com.bytedance.sdk.component.e.a.c.c.a("upload adLogEvent is null");
            } else if (aVar.e() == 1) {
                a(list, "highPriority");
            } else if (aVar.d() == 0 && aVar.e() == 2) {
                if (aVar.b() == 3) {
                    a(list, "version_v3");
                } else {
                    b(list);
                }
            } else if (aVar.d() == 1) {
                a(list, "stats");
            } else if (aVar.d() == 3) {
                a(list, "adType_v3");
            } else if (aVar.d() == 2) {
                a(list, "other");
            } else {
                com.bytedance.sdk.component.e.a.c.c.a("upload adLogEvent adType error");
            }
        } else {
            h();
            com.bytedance.sdk.component.e.a.c.c.a("upload list is empty");
        }
    }

    private void b(List<a> list) {
        this.n.addAll(list);
        f m2 = i.e().m();
        if (!(m2 == null || m2.m() == null)) {
            this.q = m2.m().b();
        }
        if (this.n.size() >= this.q) {
            if (this.m.hasMessages(11)) {
                this.m.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.n);
            this.n.clear();
            a((List<a>) arrayList, false, "max_size_dispatch");
            i();
        } else if (this.e.size() == 0) {
            a(false);
            if (this.m.hasMessages(11)) {
                this.m.removeMessages(11);
            }
            if (this.m.hasMessages(1)) {
                this.m.removeMessages(1);
            }
            long j2 = 200;
            if (!(m2 == null || m2.m() == null)) {
                j2 = m2.m().a();
            }
            this.m.sendEmptyMessageDelayed(11, j2);
        } else {
            com.bytedance.sdk.component.e.a.c.c.a("uploadBatchOptimize nothing：" + this.e.size() + "  " + this.b);
        }
    }

    private void a(String str) {
        if (this.m.hasMessages(11)) {
            this.m.removeMessages(11);
        }
        if (this.n.size() != 0) {
            ArrayList arrayList = new ArrayList(this.n);
            this.n.clear();
            a((List<a>) arrayList, false, "before_" + str);
            i();
            return;
        }
        com.bytedance.sdk.component.e.a.c.c.a("ensureUploadOptBatch empty：" + str);
    }

    private void a(List<a> list, boolean z, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.e.a.c.a.a(list, this.f, str);
        this.d = i.e().f();
        if (this.d != null) {
            b(list, z, currentTimeMillis);
        } else {
            a(list, z, currentTimeMillis);
        }
    }

    private void a(List<a> list, boolean z, long j2) {
        f m2 = i.e().m();
        if (m2 != null) {
            Executor f2 = m2.f();
            if (list.get(0).e() == 1) {
                f2 = m2.e();
            }
            if (f2 != null) {
                this.l.incrementAndGet();
                final List<a> list2 = list;
                final boolean z2 = z;
                final long j3 = j2;
                f2.execute(new e("csj_log_upload") {
                    public void run() {
                        c cVar = c.this;
                        cVar.a((List<a>) list2, z2, j3, cVar.f);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(List<a> list, boolean z, long j2, int i2) {
        b a2;
        try {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.ad(), 1);
            if (list.get(0).d() == 0) {
                a2 = i.c().a(list);
                a(a2, list);
                if (a2 != null) {
                    com.bytedance.sdk.component.e.a.c.a.a(list, a2.d);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (a g2 : list) {
                    jSONArray.put(g2.g());
                }
                jSONObject.put("stats_list", jSONArray);
                a2 = i.c().a(jSONObject);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.e.a.c.c.d("json exception:" + e2.getMessage());
        } catch (Throwable th) {
            com.bytedance.sdk.component.e.a.c.c.d("inner exception:" + th.getMessage());
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.K(), 1);
            this.l.decrementAndGet();
            return;
        }
        b bVar = a2;
        this.l.decrementAndGet();
        a(z, bVar, list, j2);
    }

    private void b(List<a> list, final boolean z, final long j2) {
        this.l.incrementAndGet();
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.ad(), 1);
        try {
            this.d.a(list, new com.bytedance.sdk.component.e.a.b.b() {
                public void a(List<a> list) {
                    try {
                        c.this.l.decrementAndGet();
                        if (list != null && list.size() != 0) {
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                a aVar = list.get(i);
                                if (aVar != null) {
                                    c.this.a(z, aVar.a(), aVar.b(), j2);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e2) {
            com.bytedance.sdk.component.e.a.c.c.d("outer exception：" + e2.getMessage());
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.K(), 1);
            this.l.decrementAndGet();
        }
    }

    private void c(int i2) {
        if (a()) {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.a(), 1);
        } else if (this.m != null) {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.c(), 1);
            if (!this.m.hasMessages(1)) {
                if (i2 == 1) {
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.f(), 1);
                } else if (i2 == 2) {
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.d(), 1);
                } else if (i2 == 3) {
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.e(), 1);
                }
                this.m.sendEmptyMessage(1);
            }
        }
    }

    private void a(b bVar, List<a> list) {
        if (bVar != null && bVar.a) {
            List<com.bytedance.sdk.component.e.a.e> a2 = com.bytedance.sdk.component.e.a.b.a();
            if (list != null && a2 != null && a2.size() != 0) {
                for (a next : list) {
                    if (next.e() == 1) {
                        String a3 = com.bytedance.sdk.component.e.a.c.a.a(next);
                        String e2 = com.bytedance.sdk.component.e.a.c.a.e(next);
                        for (com.bytedance.sdk.component.e.a.e next2 : a2) {
                            if (next2 != null) {
                                next2.a(a3, e2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x008f A[Catch:{ InterruptedException -> 0x00f1, all -> 0x00ef }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r11 = this;
            android.os.Handler r0 = r11.m
            r1 = 11
            boolean r0 = r0.hasMessages(r1)
            r1 = 1
            if (r0 == 0) goto L_0x000f
            r11.h()
            goto L_0x0012
        L_0x000f:
            r11.c(r1)
        L_0x0012:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "afterUpload message:"
            r0.append(r2)
            int r2 = r11.f
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.e.a.c.c.a(r0)
            com.bytedance.sdk.component.e.a.b.a.a r0 = com.bytedance.sdk.component.e.a.b.d.d
            java.util.concurrent.atomic.AtomicLong r0 = r0.b()
            com.bytedance.sdk.component.e.a.c.b.a(r0, r1)
            int r0 = r11.f
            r2 = 2
            if (r0 != r2) goto L_0x0111
            com.bytedance.sdk.component.e.a.b.a.a r0 = com.bytedance.sdk.component.e.a.b.d.d
            java.util.concurrent.atomic.AtomicLong r0 = r0.g()
            com.bytedance.sdk.component.e.a.c.b.a(r0, r1)
            java.lang.Object r0 = r11.c
            monitor-enter(r0)
            long r3 = java.lang.System.nanoTime()     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.Object r5 = r11.c     // Catch:{ InterruptedException -> 0x00f1 }
            r6 = 5000(0x1388, double:2.4703E-320)
            r5.wait(r6)     // Catch:{ InterruptedException -> 0x00f1 }
            long r5 = java.lang.System.nanoTime()     // Catch:{ InterruptedException -> 0x00f1 }
            long r5 = r5 - r3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00f1 }
            r7.<init>()     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.String r8 = "afterUpload delta:"
            r7.append(r8)     // Catch:{ InterruptedException -> 0x00f1 }
            r7.append(r5)     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.String r8 = " start:"
            r7.append(r8)     // Catch:{ InterruptedException -> 0x00f1 }
            r7.append(r3)     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.String r3 = " condition:"
            r7.append(r3)     // Catch:{ InterruptedException -> 0x00f1 }
            com.bytedance.sdk.component.e.a.b.d r3 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ InterruptedException -> 0x00f1 }
            boolean r3 = r3.b     // Catch:{ InterruptedException -> 0x00f1 }
            if (r3 != 0) goto L_0x007b
            com.bytedance.sdk.component.e.a.b.d r3 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ InterruptedException -> 0x00f1 }
            boolean r3 = r3.c     // Catch:{ InterruptedException -> 0x00f1 }
            if (r3 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r3 = 0
            goto L_0x007c
        L_0x007b:
            r3 = r1
        L_0x007c:
            r7.append(r3)     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.String r3 = r7.toString()     // Catch:{ InterruptedException -> 0x00f1 }
            com.bytedance.sdk.component.e.a.c.c.a(r3)     // Catch:{ InterruptedException -> 0x00f1 }
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x00df
            long r7 = r3 - r5
            r9 = 50000000(0x2faf080, double:2.47032823E-316)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 >= 0) goto L_0x0099
            goto L_0x00df
        L_0x0099:
            com.bytedance.sdk.component.e.a.b.d r7 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ InterruptedException -> 0x00f1 }
            boolean r7 = r7.b     // Catch:{ InterruptedException -> 0x00f1 }
            if (r7 != 0) goto L_0x00cf
            com.bytedance.sdk.component.e.a.b.d r7 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ InterruptedException -> 0x00f1 }
            boolean r7 = r7.c     // Catch:{ InterruptedException -> 0x00f1 }
            if (r7 == 0) goto L_0x00a6
            goto L_0x00cf
        L_0x00a6:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00f1 }
            r7.<init>()     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.String r8 = "afterUpload notifyRunOnce:"
            r7.append(r8)     // Catch:{ InterruptedException -> 0x00f1 }
            r7.append(r5)     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.String r5 = "  "
            r7.append(r5)     // Catch:{ InterruptedException -> 0x00f1 }
            r7.append(r3)     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.String r3 = r7.toString()     // Catch:{ InterruptedException -> 0x00f1 }
            com.bytedance.sdk.component.e.a.c.c.c(r3)     // Catch:{ InterruptedException -> 0x00f1 }
            com.bytedance.sdk.component.e.a.b.a.a r3 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ InterruptedException -> 0x00f1 }
            java.util.concurrent.atomic.AtomicLong r3 = r3.J()     // Catch:{ InterruptedException -> 0x00f1 }
            com.bytedance.sdk.component.e.a.c.b.a(r3, r1)     // Catch:{ InterruptedException -> 0x00f1 }
            r11.a((int) r2)     // Catch:{ InterruptedException -> 0x00f1 }
            goto L_0x010d
        L_0x00cf:
            com.bytedance.sdk.component.e.a.b.a.a r2 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ InterruptedException -> 0x00f1 }
            java.util.concurrent.atomic.AtomicLong r2 = r2.k()     // Catch:{ InterruptedException -> 0x00f1 }
            com.bytedance.sdk.component.e.a.c.b.a(r2, r1)     // Catch:{ InterruptedException -> 0x00f1 }
            java.lang.String r1 = "afterUpload wait serverBusy"
            com.bytedance.sdk.component.e.a.c.c.d(r1)     // Catch:{ InterruptedException -> 0x00f1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00ef }
            return
        L_0x00df:
            java.lang.String r2 = "afterUpload wait timeout"
            com.bytedance.sdk.component.e.a.c.c.d(r2)     // Catch:{ InterruptedException -> 0x00f1 }
            com.bytedance.sdk.component.e.a.b.a.a r2 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ InterruptedException -> 0x00f1 }
            java.util.concurrent.atomic.AtomicLong r2 = r2.j()     // Catch:{ InterruptedException -> 0x00f1 }
            com.bytedance.sdk.component.e.a.c.b.a(r2, r1)     // Catch:{ InterruptedException -> 0x00f1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00ef }
            return
        L_0x00ef:
            r1 = move-exception
            goto L_0x010f
        L_0x00f1:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ef }
            r2.<init>()     // Catch:{ all -> 0x00ef }
            java.lang.String r3 = "wait exception:"
            r2.append(r3)     // Catch:{ all -> 0x00ef }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x00ef }
            r2.append(r3)     // Catch:{ all -> 0x00ef }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ef }
            com.bytedance.sdk.component.e.a.c.c.d(r2)     // Catch:{ all -> 0x00ef }
            r1.printStackTrace()     // Catch:{ all -> 0x00ef }
        L_0x010d:
            monitor-exit(r0)     // Catch:{ all -> 0x00ef }
            goto L_0x0111
        L_0x010f:
            monitor-exit(r0)     // Catch:{ all -> 0x00ef }
            throw r1
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.b.c.c.i():void");
    }

    /* access modifiers changed from: private */
    public void a(boolean z, b bVar, List<a> list, long j2) {
        if (!z && bVar != null) {
            int i2 = bVar.b;
            if (bVar.e) {
                i2 = -1;
            }
            if (i2 == 510 || i2 == 511) {
                i2 = -2;
            }
            if (list != null) {
                com.bytedance.sdk.component.e.a.c.c.a("preprocessResult code is " + i2 + " sz:" + list.size() + "  count:" + this.l.get());
            }
            a(i2, list, j2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0129, code lost:
        com.bytedance.sdk.component.e.a.c.c.b("upload thread reuse or close: " + r5.b + " queue:" + r5.e.size() + " " + r5.f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0157, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r6, java.util.List<com.bytedance.sdk.component.e.a.d.a> r7, long r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.c
            monitor-enter(r0)
            if (r7 == 0) goto L_0x0158
            android.os.Handler r1 = r5.m     // Catch:{ all -> 0x015a }
            if (r1 != 0) goto L_0x000b
            goto L_0x0158
        L_0x000b:
            com.bytedance.sdk.component.e.a.c.a.a((int) r6, (java.util.List<com.bytedance.sdk.component.e.a.d.a>) r7, (long) r8)     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.e.a.a.d r8 = r5.a     // Catch:{ all -> 0x015a }
            r8.a((int) r6, (java.util.List<com.bytedance.sdk.component.e.a.d.a>) r7)     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.e.a.i r8 = com.bytedance.sdk.component.e.a.i.e()     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.e.a.f r8 = r8.m()     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x0026
            com.bytedance.sdk.component.e.a.h r8 = r8.m()     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x0026
            r8.a(r6, r7)     // Catch:{ all -> 0x015a }
        L_0x0026:
            r7 = -2
            r8 = 1
            r9 = 3
            r1 = 0
            r2 = 2
            if (r6 == r7) goto L_0x00d9
            r7 = -1
            if (r6 == r7) goto L_0x0089
            if (r6 == 0) goto L_0x00d9
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 == r7) goto L_0x0089
            r7 = 509(0x1fd, float:7.13E-43)
            if (r6 == r7) goto L_0x003c
            goto L_0x011a
        L_0x003c:
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x015a }
            r6.b = r8     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x015a }
            r6.c = r1     // Catch:{ all -> 0x015a }
            java.lang.String r6 = "-----------------  server busy start---------------- "
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x015a }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            boolean r6 = r6.hasMessages(r2)     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x0058
            java.lang.String r6 = "already server busy message"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x015a }
            monitor-exit(r0)     // Catch:{ all -> 0x015a }
            return
        L_0x0058:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015a }
            long r3 = r5.g     // Catch:{ all -> 0x015a }
            long r6 = r6 - r3
            r3 = 30000(0x7530, double:1.4822E-319)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x006c
            java.lang.String r6 = "already server busy，too short"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x015a }
            monitor-exit(r0)     // Catch:{ all -> 0x015a }
            return
        L_0x006c:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015a }
            r5.g = r6     // Catch:{ all -> 0x015a }
            java.lang.String r6 = "-----------------  server busy send---------------- "
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x015a }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            boolean r6 = r6.hasMessages(r9)     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x0084
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            r6.removeMessages(r9)     // Catch:{ all -> 0x015a }
        L_0x0084:
            r5.a((int) r2, (long) r3)     // Catch:{ all -> 0x015a }
            goto L_0x011a
        L_0x0089:
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x015a }
            boolean r6 = r6.b     // Catch:{ all -> 0x015a }
            if (r6 != 0) goto L_0x0095
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x015a }
            boolean r6 = r6.c     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x011a
        L_0x0095:
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x015a }
            r6.b = r1     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x015a }
            r6.c = r1     // Catch:{ all -> 0x015a }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            boolean r6 = r6.hasMessages(r2)     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x00aa
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            r6.removeMessages(r2)     // Catch:{ all -> 0x015a }
        L_0x00aa:
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            boolean r6 = r6.hasMessages(r9)     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x00b7
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            r6.removeMessages(r9)     // Catch:{ all -> 0x015a }
        L_0x00b7:
            r6 = 0
            r5.h = r6     // Catch:{ all -> 0x015a }
            r5.g = r6     // Catch:{ all -> 0x015a }
            java.util.concurrent.atomic.AtomicInteger r6 = r5.o     // Catch:{ all -> 0x015a }
            r6.set(r1)     // Catch:{ all -> 0x015a }
            java.util.concurrent.atomic.AtomicInteger r6 = r5.p     // Catch:{ all -> 0x015a }
            r6.set(r1)     // Catch:{ all -> 0x015a }
            java.lang.String r6 = "--dispatchResult flush--"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.e.a.b.a.a r6 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ all -> 0x015a }
            java.util.concurrent.atomic.AtomicLong r6 = r6.L()     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.e.a.c.b.a(r6, r8)     // Catch:{ all -> 0x015a }
            r5.a((int) r2)     // Catch:{ all -> 0x015a }
            goto L_0x011a
        L_0x00d9:
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x015a }
            r6.b = r1     // Catch:{ all -> 0x015a }
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x015a }
            r6.c = r8     // Catch:{ all -> 0x015a }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            boolean r6 = r6.hasMessages(r9)     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x00f0
            java.lang.String r6 = "already routine error message"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x015a }
            monitor-exit(r0)     // Catch:{ all -> 0x015a }
            return
        L_0x00f0:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015a }
            long r3 = r5.h     // Catch:{ all -> 0x015a }
            long r6 = r6 - r3
            r3 = 15000(0x3a98, double:7.411E-320)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0104
            java.lang.String r6 = "already routine error,too short"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x015a }
            monitor-exit(r0)     // Catch:{ all -> 0x015a }
            return
        L_0x0104:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015a }
            r5.h = r6     // Catch:{ all -> 0x015a }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            boolean r6 = r6.hasMessages(r2)     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x0117
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x015a }
            r6.removeMessages(r2)     // Catch:{ all -> 0x015a }
        L_0x0117:
            r5.a((int) r9, (long) r3)     // Catch:{ all -> 0x015a }
        L_0x011a:
            int r6 = r5.f     // Catch:{ all -> 0x015a }
            if (r6 != r2) goto L_0x0128
            java.lang.String r6 = "send notify"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x015a }
            java.lang.Object r6 = r5.c     // Catch:{ all -> 0x015a }
            r6.notify()     // Catch:{ all -> 0x015a }
        L_0x0128:
            monitor-exit(r0)     // Catch:{ all -> 0x015a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "upload thread reuse or close: "
            r6.append(r7)
            boolean r7 = r5.b
            r6.append(r7)
            java.lang.String r7 = " queue:"
            r6.append(r7)
            java.util.concurrent.PriorityBlockingQueue<com.bytedance.sdk.component.e.a.d.a> r7 = r5.e
            int r7 = r7.size()
            r6.append(r7)
            java.lang.String r7 = " "
            r6.append(r7)
            int r7 = r5.f
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.e.a.c.c.b(r6)
            return
        L_0x0158:
            monitor-exit(r0)     // Catch:{ all -> 0x015a }
            return
        L_0x015a:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x015a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.b.c.c.a(int, java.util.List, long):void");
    }

    public void a(int i2, long j2) {
        if (this.m == null) {
            com.bytedance.sdk.component.e.a.c.c.d("mHandler == null");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i2;
        if (i2 == 2) {
            int incrementAndGet = this.o.incrementAndGet();
            long j3 = ((long) (((incrementAndGet - 1) % 4) + 1)) * j2;
            com.bytedance.sdk.component.e.a.c.c.a("sendMonitorMessage:" + i2 + "  busy:" + incrementAndGet + "  l:" + j3);
            this.m.sendMessageDelayed(obtain, j3);
        } else if (i2 == 3) {
            int incrementAndGet2 = this.p.incrementAndGet();
            com.bytedance.sdk.component.e.a.c.c.a("sendMonitorMessage:" + i2 + "  error:" + incrementAndGet2);
            this.m.sendMessageDelayed(obtain, ((long) (((incrementAndGet2 + -1) % 4) + 1)) * j2);
        } else {
            com.bytedance.sdk.component.e.a.c.c.d("sendMonitorMessage error state");
        }
    }
}
