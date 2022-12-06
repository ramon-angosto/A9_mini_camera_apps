package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.y;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: OpenAppSuccEvent */
public class j {
    private static volatile j a;
    private HandlerThread b;
    private final Handler c;
    private final Executor d = Executors.newCachedThreadPool();
    private b e = b.a();
    private Map<String, Object> f;

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                }
            }
        }
        return a;
    }

    private j() {
        if (this.b == null) {
            this.b = new HandlerThread("OpenAppSuccEvent_HandlerThread", 10);
            this.b.start();
        }
        this.c = new Handler(this.b.getLooper(), new Handler.Callback() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.bytedance.sdk.openadsdk.c.j$a} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean handleMessage(android.os.Message r3) {
                /*
                    r2 = this;
                    int r0 = r3.what
                    r1 = 100
                    if (r0 != r1) goto L_0x001d
                    r0 = 0
                    java.lang.Object r1 = r3.obj
                    if (r1 == 0) goto L_0x0016
                    java.lang.Object r1 = r3.obj
                    boolean r1 = r1 instanceof com.bytedance.sdk.openadsdk.c.j.a
                    if (r1 == 0) goto L_0x0016
                    java.lang.Object r3 = r3.obj
                    r0 = r3
                    com.bytedance.sdk.openadsdk.c.j$a r0 = (com.bytedance.sdk.openadsdk.c.j.a) r0
                L_0x0016:
                    if (r0 == 0) goto L_0x001d
                    com.bytedance.sdk.openadsdk.c.j r3 = com.bytedance.sdk.openadsdk.c.j.this
                    r3.b(r0)
                L_0x001d:
                    r3 = 1
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.j.AnonymousClass1.handleMessage(android.os.Message):boolean");
            }
        });
    }

    public void a(n nVar, String str) {
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 100;
        obtainMessage.obj = a.a(nVar, str, this.f);
        obtainMessage.sendToTarget();
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.b();
            if (aVar.a() * this.e.a > this.e.b) {
                c(aVar.a(false));
                return;
            }
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.obj = aVar;
            this.c.sendMessageDelayed(obtainMessage, (long) this.e.a);
        }
    }

    /* access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null) {
            if (y.a()) {
                a(aVar);
            } else {
                c(aVar.a(true));
            }
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            this.d.execute(aVar);
        }
    }

    /* compiled from: OpenAppSuccEvent */
    private static class a implements Serializable, Runnable {
        public final AtomicInteger a = new AtomicInteger(0);
        public final AtomicBoolean b = new AtomicBoolean(false);
        public n c;
        public String d;
        public Map<String, Object> e;

        public static a a(n nVar, String str, Map<String, Object> map) {
            return new a(nVar, str, map);
        }

        public a() {
        }

        public a(n nVar, String str, Map<String, Object> map) {
            this.c = nVar;
            this.d = str;
            this.e = map;
        }

        public a a(boolean z) {
            this.b.set(z);
            return this;
        }

        public int a() {
            return this.a.get();
        }

        public void b() {
            this.a.incrementAndGet();
        }

        public void run() {
            if (this.c == null || TextUtils.isEmpty(this.d)) {
                l.b("materialMeta or eventTag is null, pls check");
            } else {
                c.d(m.a(), this.c, this.d, this.b.get() ? "dpl_success" : "dpl_failed", this.e);
            }
        }
    }

    /* compiled from: OpenAppSuccEvent */
    private static class b {
        public int a = 500;
        public int b = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;

        public static b a() {
            return new b();
        }
    }
}
