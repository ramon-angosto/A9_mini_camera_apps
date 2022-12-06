package sg.bigo.ads.common.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import sg.bigo.ads.common.utils.r;

public final class c {
    public static List<a> a;
    private static HandlerThread b;
    private static a c;
    private static HandlerThread d;
    private static a e;
    private static HandlerThread f;
    private static a g;
    /* access modifiers changed from: private */
    public static a h;
    /* access modifiers changed from: private */
    public static a i;
    /* access modifiers changed from: private */
    public static final WeakHashMap<Object, b> j = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public static boolean k = false;

    public interface a {
        void a(Throwable th);
    }

    static class b {
        final Runnable a;
        final Integer b;

        public b(Runnable runnable, Integer num) {
            this.a = runnable;
            this.b = num;
        }
    }

    static {
        r.a();
    }

    public static void a(int i2, Runnable runnable) {
        b(i2, runnable, 0);
    }

    public static void a(int i2, Runnable runnable, long j2) {
        b(i2, runnable, j2);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized void a(java.lang.Runnable r4) {
        /*
            java.lang.Class<sg.bigo.ads.common.f.c> r0 = sg.bigo.ads.common.f.c.class
            monitor-enter(r0)
            if (r4 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            java.util.WeakHashMap<java.lang.Object, sg.bigo.ads.common.f.c$b> r1 = j     // Catch:{ all -> 0x0060 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0060 }
            sg.bigo.ads.common.f.c$b r1 = (sg.bigo.ads.common.f.c.b) r1     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0013
            monitor-exit(r0)
            return
        L_0x0013:
            java.lang.Runnable r2 = r1.a     // Catch:{ all -> 0x0060 }
            if (r2 == 0) goto L_0x005e
            java.lang.Integer r1 = r1.b     // Catch:{ all -> 0x0060 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0049
            r3 = 1
            if (r1 == r3) goto L_0x0042
            r3 = 2
            if (r1 == r3) goto L_0x003b
            r3 = 3
            if (r1 == r3) goto L_0x0031
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 == r3) goto L_0x002d
            goto L_0x0050
        L_0x002d:
            r2.run()     // Catch:{ all -> 0x0060 }
            goto L_0x0050
        L_0x0031:
            sg.bigo.ads.common.f.a r1 = g     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0050
            sg.bigo.ads.common.f.a r1 = g     // Catch:{ all -> 0x0060 }
        L_0x0037:
            r1.removeCallbacks(r2)     // Catch:{ all -> 0x0060 }
            goto L_0x0050
        L_0x003b:
            sg.bigo.ads.common.f.a r1 = h     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0050
            sg.bigo.ads.common.f.a r1 = h     // Catch:{ all -> 0x0060 }
            goto L_0x0037
        L_0x0042:
            sg.bigo.ads.common.f.a r1 = e     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0050
            sg.bigo.ads.common.f.a r1 = e     // Catch:{ all -> 0x0060 }
            goto L_0x0037
        L_0x0049:
            sg.bigo.ads.common.f.a r1 = c     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0050
            sg.bigo.ads.common.f.a r1 = c     // Catch:{ all -> 0x0060 }
            goto L_0x0037
        L_0x0050:
            java.util.WeakHashMap<java.lang.Object, sg.bigo.ads.common.f.c$b> r1 = j     // Catch:{ all -> 0x0060 }
            monitor-enter(r1)     // Catch:{ all -> 0x0060 }
            java.util.WeakHashMap<java.lang.Object, sg.bigo.ads.common.f.c$b> r2 = j     // Catch:{ all -> 0x005b }
            r2.remove(r4)     // Catch:{ all -> 0x005b }
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)
            return
        L_0x005b:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            throw r4     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r0)
            return
        L_0x0060:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.f.c.a(java.lang.Runnable):void");
    }

    public static synchronized void a(a aVar) {
        synchronized (c.class) {
            if (a == null) {
                a = new ArrayList();
            }
            a.add(aVar);
        }
    }

    public static boolean a() {
        return d == Thread.currentThread();
    }

    private static synchronized void b(int i2, final Runnable runnable, long j2) {
        final a aVar;
        synchronized (c.class) {
            if (runnable != null) {
                if (h == null) {
                    j();
                }
                if (i2 == 0) {
                    if (b == null) {
                        g();
                    }
                    aVar = c;
                } else if (i2 == 1) {
                    if (d == null) {
                        h();
                    }
                    aVar = e;
                } else if (i2 != 3) {
                    aVar = h;
                } else {
                    if (f == null) {
                        i();
                    }
                    aVar = g;
                }
                if (aVar != null) {
                    final Looper myLooper = Looper.myLooper();
                    if (myLooper == null) {
                        myLooper = h.getLooper();
                    }
                    final AnonymousClass1 r3 = new Runnable() {
                        final /* synthetic */ Runnable b = null;
                        final /* synthetic */ boolean c = false;

                        public final void run() {
                            AnonymousClass1 r0 = c.i != null ? new Runnable() {
                                public final void run() {
                                    c.h.post(new Runnable() {
                                        public final void run() {
                                            sg.bigo.ads.common.k.a.a(0, "ThreadManager", "这里使用了ThreadManager.post函数运行了一个超过30s的任务");
                                        }
                                    });
                                }
                            } : null;
                            if (c.i != null) {
                                c.i.postDelayed(r0, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                            }
                            synchronized (c.j) {
                                c.j.remove(runnable);
                            }
                            if (c.k) {
                                runnable.run();
                            } else {
                                try {
                                    runnable.run();
                                } catch (Throwable th) {
                                    sg.bigo.ads.common.k.a.a(2, "ThreadManager", "An error occurred while running a task: \n" + Log.getStackTraceString(th));
                                    if (c.a != null) {
                                        for (a a2 : c.a) {
                                            a2.a(th);
                                        }
                                    }
                                }
                            }
                            if (c.i != null) {
                                c.i.removeCallbacks(r0);
                            }
                            if (this.b == null) {
                                return;
                            }
                            if (this.c || myLooper == c.h.getLooper()) {
                                c.h.post(this.b);
                            } else {
                                new Handler(myLooper).post(this.b);
                            }
                        }
                    };
                    AnonymousClass2 r4 = new Runnable() {
                        final /* synthetic */ Runnable a = null;
                        final /* synthetic */ boolean b = false;

                        public final void run() {
                            if (this.a == null) {
                                r3.run();
                            } else if (this.b || myLooper == c.h.getLooper()) {
                                c.h.post(new Runnable() {
                                    public final void run() {
                                        AnonymousClass2.this.a.run();
                                        aVar.post(r3);
                                    }
                                });
                            } else {
                                new Handler(myLooper).post(new Runnable() {
                                    public final void run() {
                                        AnonymousClass2.this.a.run();
                                        aVar.post(r3);
                                    }
                                });
                            }
                        }
                    };
                    synchronized (j) {
                        j.put(runnable, new b(r4, Integer.valueOf(i2)));
                    }
                    aVar.postDelayed(r4, j2);
                }
            }
        }
    }

    public static void b(Runnable runnable) {
        if (b()) {
            runnable.run();
        } else {
            b(2, runnable, 0);
        }
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static synchronized void g() {
        synchronized (c.class) {
            if (b == null) {
                HandlerThread handlerThread = new HandlerThread("BGAd-Background", 10);
                b = handlerThread;
                handlerThread.start();
                c = new a("BGAd-Background", b.getLooper());
            }
        }
    }

    private static synchronized void h() {
        synchronized (c.class) {
            if (d == null) {
                HandlerThread handlerThread = new HandlerThread("BGAd-Work", 5);
                d = handlerThread;
                handlerThread.start();
                e = new a("BGAd-Work", d.getLooper());
            }
        }
    }

    private static synchronized void i() {
        synchronized (c.class) {
            if (f == null) {
                HandlerThread handlerThread = new HandlerThread("BGAd-Normal", 0);
                f = handlerThread;
                handlerThread.start();
                g = new a("BGAd-Normal", f.getLooper());
            }
        }
    }

    private static synchronized void j() {
        synchronized (c.class) {
            if (h == null) {
                h = new a("BGAd-Background.Main + 38", Looper.getMainLooper());
            }
        }
    }
}
