package com.bykv.vk.openvk.component.video.a.b.f;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bykv.vk.openvk.component.video.a.b.d;
import com.bykv.vk.openvk.component.video.a.b.e;
import com.bykv.vk.openvk.component.video.a.b.f;
import com.bykv.vk.openvk.component.video.api.f.c;
import com.bytedance.sdk.component.utils.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: VideoCachePreloader */
public class a {
    public static final boolean a = c.c();
    private HashMap<String, Boolean> b;
    private C0016a c;

    /* compiled from: VideoCachePreloader */
    private static class b {
        /* access modifiers changed from: private */
        public static final a a = new a();
    }

    private a() {
        this.b = new HashMap<>();
        b();
    }

    public static a a() {
        return b.a;
    }

    public boolean b() {
        if (this.c != null) {
            return true;
        }
        com.bykv.vk.openvk.component.video.a.b.a.c c2 = c();
        if (c2 == null) {
            return false;
        }
        e.a(true);
        e.b(true);
        e.a(1);
        f.a().d();
        try {
            this.c = new C0016a();
            this.c.setName("csj_video_cache_preloader");
            this.c.start();
            e.a(c2, com.bykv.vk.openvk.component.video.api.b.a());
            d.c().a((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, (long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, (long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        if (!b()) {
            return false;
        }
        this.c.a(cVar);
        return true;
    }

    public String b(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        if (cVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(cVar.l());
        return f.a().a(false, z, z ? cVar.l() : cVar.k(), cVar.k());
    }

    private static com.bykv.vk.openvk.component.video.a.b.a.c c() {
        com.bykv.vk.openvk.component.video.a.b.a.c cVar;
        File file = new File(com.bykv.vk.openvk.component.video.api.b.a().getCacheDir(), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            cVar = new com.bykv.vk.openvk.component.video.a.b.a.c(file);
            try {
                cVar.a(104857600);
            } catch (IOException e) {
                e = e;
            }
        } catch (IOException e2) {
            e = e2;
            cVar = null;
            e.printStackTrace();
            return cVar;
        }
        return cVar;
    }

    /* renamed from: com.bykv.vk.openvk.component.video.a.b.f.a$a  reason: collision with other inner class name */
    /* compiled from: VideoCachePreloader */
    class C0016a extends Thread {
        private Queue<C0017a> b = new LinkedBlockingQueue();
        private boolean c = true;
        private final Queue<C0017a> d = new ArrayBlockingQueue(10);
        private Queue<C0017a> e = new LinkedBlockingQueue();

        private void a() {
        }

        private void b() {
        }

        public C0016a() {
        }

        private C0017a a(int i, com.bykv.vk.openvk.component.video.api.c.c cVar) {
            b();
            l.b("VideoCachePreloader", "pool: " + this.d.size());
            C0017a poll = this.d.poll();
            if (poll == null) {
                poll = new C0017a();
            }
            poll.a = i;
            poll.f = cVar;
            return poll;
        }

        private void a(C0017a aVar) {
            a();
            aVar.c = null;
            aVar.b = null;
            aVar.a = -1;
            aVar.f = null;
            this.d.offer(aVar);
        }

        private synchronized void b(C0017a aVar) {
            b();
            this.e.add(aVar);
            notify();
        }

        private void c(C0017a aVar) {
            a();
            if (aVar != null) {
                this.b.offer(aVar);
                notify();
            }
        }

        public void run() {
            while (this.c) {
                synchronized (this) {
                    if (!this.e.isEmpty()) {
                        c();
                    }
                    while (!this.b.isEmpty()) {
                        C0017a poll = this.b.poll();
                        if (poll != null) {
                            int i = poll.a;
                            if (i != 0) {
                                if (i == 1) {
                                    d.c().a(poll.b);
                                } else if (i == 2) {
                                    d.c().d();
                                } else if (i == 3) {
                                    d.c().d();
                                    if (e.c() != null) {
                                        e.c().a();
                                    }
                                    if (e.b() != null) {
                                        e.b().a();
                                    }
                                } else if (i == 4) {
                                    d.c().d();
                                    this.c = false;
                                }
                            } else if (poll.c != null && poll.c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.c) {
                                    if (com.bykv.vk.openvk.component.video.a.c.a.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.e), poll.d, poll.b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            a(poll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        private void c() {
            a();
            while (true) {
                C0017a poll = this.e.poll();
                if (poll != null) {
                    poll.b = poll.f.k();
                    poll.c = new String[]{poll.f.k()};
                    poll.d = poll.f.b();
                    poll.e = poll.f.l();
                    if (!TextUtils.isEmpty(poll.f.l())) {
                        poll.b = poll.f.l();
                    }
                    poll.f = null;
                    c(poll);
                } else {
                    return;
                }
            }
        }

        public void a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
            b(a(0, cVar));
        }

        /* renamed from: com.bykv.vk.openvk.component.video.a.b.f.a$a$a  reason: collision with other inner class name */
        /* compiled from: VideoCachePreloader */
        private class C0017a {
            public int a;
            public String b;
            public String[] c;
            public int d;
            public String e;
            public com.bykv.vk.openvk.component.video.api.c.c f;

            public C0017a() {
            }
        }
    }
}
