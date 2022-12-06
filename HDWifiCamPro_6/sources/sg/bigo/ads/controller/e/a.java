package sg.bigo.ads.controller.e;

import android.content.ContentValues;
import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.work.PeriodicWorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.controller.a.a;
import sg.bigo.ads.controller.b.d;
import sg.bigo.ads.controller.c;
import sg.bigo.ads.controller.e.d;
import sg.bigo.ads.controller.g.a;
import sg.bigo.ads.core.a.c;

public final class a implements c<sg.bigo.ads.api.core.c>, a.C0131a {
    final Context a;
    final AdConfig b;
    final sg.bigo.ads.controller.b.b c;
    final d d;
    final sg.bigo.ads.common.l.a e;
    public final c f;
    final d g;
    final Queue<C0129a<? extends sg.bigo.ads.api.b>> h;
    final SparseArray<C0129a<sg.bigo.ads.controller.h.b>> i;
    public long j;
    boolean k = true;
    final b l;
    private final AtomicBoolean m = new AtomicBoolean(false);

    /* renamed from: sg.bigo.ads.controller.e.a$a  reason: collision with other inner class name */
    public static class C0129a<T> {
        final T a;
        final sg.bigo.ads.controller.b b;

        private C0129a(T t, sg.bigo.ads.controller.b bVar) {
            this.a = t;
            this.b = bVar;
        }

        /* synthetic */ C0129a(Object obj, sg.bigo.ads.controller.b bVar, byte b2) {
            this(obj, bVar);
        }
    }

    public class b implements Runnable {
        private volatile int b = 0;
        private boolean c = true;

        public b() {
        }

        static /* synthetic */ void a(b bVar) {
            if (bVar.b == 2) {
                sg.bigo.ads.common.k.a.a(0, 3, "PrefetchConfigTask", "Task resumed.");
                bVar.a();
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (this.b == 0 || this.b == 2) {
                sg.bigo.ads.common.k.a.a(0, 3, "PrefetchConfigTask", "Task set.");
                sg.bigo.ads.common.f.c.a(3, this, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                this.b = 1;
            }
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (this.b == 1 || this.b == 2) {
                if (this.b == 1) {
                    sg.bigo.ads.common.f.c.a((Runnable) this);
                }
                sg.bigo.ads.common.k.a.a(0, 3, "PrefetchConfigTask", "Task canceled.");
                this.b = 3;
            }
        }

        public final void run() {
            if (!sg.bigo.ads.common.b.c.c()) {
                b();
            } else if (!this.c || a.this.k) {
                sg.bigo.ads.common.k.a.a(0, 3, "PrefetchConfigTask", "Start to execute task.");
                this.b = 4;
                a.this.g.a((d.a) new d.a() {
                    public final void a() {
                        a.a(a.this, 1);
                        c.a.a.b();
                        c.a.a.a();
                    }

                    public final void a(int i, String str) {
                        if (a.this.c.D()) {
                            c.a.a.b();
                            c.a.a.a();
                        }
                    }
                }, 0);
            } else {
                this.c = false;
                sg.bigo.ads.common.k.a.b("PrefetchConfigTask", "The network is unavailable now. Task paused.");
                this.b = 2;
            }
        }
    }

    public a(Context context, AdConfig adConfig) {
        this.a = context;
        this.b = adConfig;
        this.c = new sg.bigo.ads.controller.b.b(this.a);
        e.a = this.c;
        this.d = new sg.bigo.ads.controller.b.d(this.a);
        this.e = new sg.bigo.ads.controller.a.a(this.a, this.c, new a.b() {
            public final String a() {
                return a.this.f.u();
            }
        });
        this.f = new c(this.a, this.b, this.c, this.e);
        this.g = new d(this.c, this.d, this.f, this.e);
        this.h = new LinkedList();
        this.i = new SparseArray<>();
        this.l = new b();
        g.a.a(this.e);
    }

    static /* synthetic */ void a(a aVar, int i2) {
        if (!o.b(aVar.f.c.v()) && !aVar.m.getAndSet(true)) {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = ((Long) sg.bigo.ads.common.n.b.b("last_stat_init_time", 0, 1)).longValue();
            long elapsedRealtime = aVar.j == 0 ? -1 : SystemClock.elapsedRealtime() - aVar.j;
            if (currentTimeMillis - longValue >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                sg.bigo.ads.core.d.b.d dVar = new sg.bigo.ads.core.d.b.d("06002001");
                dVar.a("states", "success");
                dVar.a("cost", elapsedRealtime);
                dVar.a("status", i2);
                sg.bigo.ads.core.d.a.a(dVar);
                sg.bigo.ads.common.n.b.a("last_stat_init_time", Long.valueOf(currentTimeMillis), 1);
            }
        }
    }

    static /* synthetic */ void a(a aVar, final C0129a aVar2) {
        if (aVar.c.e()) {
            sg.bigo.ads.common.f.c.a(3, new Runnable() {
                public final void run() {
                    a.this.h.offer(aVar2);
                    a.this.a();
                }
            });
            c.a.a.c();
            return;
        }
        aVar.a(aVar2, 1002, "The ad is disable.");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        C0129a poll;
        boolean z;
        String str;
        while (this.i.size() < this.c.t() && (poll = this.h.poll()) != null) {
            sg.bigo.ads.controller.b.d dVar = this.d;
            String str2 = ((sg.bigo.ads.api.b) poll.a).a;
            sg.bigo.ads.api.a.g gVar = (dVar.a == null || str2 == null) ? null : dVar.a.get(str2);
            if (gVar == null) {
                sg.bigo.ads.common.k.a.a(0, "AdController", "scheduleRequest error, slot is empty, slot id=" + ((sg.bigo.ads.api.b) poll.a).a);
                str = "Invalid ad slot id.";
            } else if (!gVar.l()) {
                sg.bigo.ads.common.k.a.a(0, "AdController", "schedule next request, slot is disable, slot id=" + ((sg.bigo.ads.api.b) poll.a).a);
                a(poll, 1002, "The ad is disable.");
            } else if (gVar.b() != ((sg.bigo.ads.api.b) poll.a).b()) {
                sg.bigo.ads.common.k.a.a(0, "AdController", "schedule next request, this slot id is ad type " + gVar.b() + ", request as type " + ((sg.bigo.ads.api.b) poll.a).b());
                str = "Unmatched ad type.";
            } else {
                if (sg.bigo.ads.api.core.b.c(gVar.b())) {
                    sg.bigo.ads.common.n.a.b(gVar.k());
                    int a2 = gVar.p().a("splash_impression_limit");
                    if (a2 <= 0) {
                        z = true;
                    } else {
                        z = sg.bigo.ads.common.n.a.a(gVar.k()) < a2;
                        if (!z) {
                            sg.bigo.ads.common.k.a.b("AdController", "The maximum number of ad impressions for the day (" + a2 + ") has been reached.");
                        }
                    }
                    if (!z) {
                        str = "The maximum number of ad impressions for the day has been reached.";
                    } else {
                        sg.bigo.ads.api.core.c a3 = sg.bigo.ads.controller.c.a.a(gVar, ((sg.bigo.ads.api.b) poll.a).c);
                        if (a3 != null) {
                            if (a3.y()) {
                                sg.bigo.ads.controller.c.a.a(gVar.k());
                            } else {
                                sg.bigo.ads.common.k.a.a("AdController", "Succeed to load splash ads from local db.");
                                g.a aVar = new g.a(a3, gVar, this.b, (sg.bigo.ads.api.b) poll.a);
                                aVar.a = this.f;
                                poll.b.a(-1, aVar.a());
                            }
                        }
                    }
                }
                sg.bigo.ads.controller.h.b bVar = new sg.bigo.ads.controller.h.b(this.c, this.f, (sg.bigo.ads.api.b) poll.a, gVar, this);
                this.i.put(bVar.a(), new C0129a(bVar, poll.b, (byte) 0));
                bVar.b();
                sg.bigo.ads.api.b bVar2 = (sg.bigo.ads.api.b) poll.a;
                Map<String, Object> a4 = sg.bigo.ads.core.b.a.a("load", gVar, bVar2, Integer.valueOf(gVar.u()));
                a4.put("is_server_request", 1);
                sg.bigo.ads.core.b.b.a().a("load", a4);
                Map<String, String> a5 = sg.bigo.ads.core.d.a.a(gVar);
                a5.put("banner_type", String.valueOf(bVar2.b));
                a5.put("is_server_request", "1");
                sg.bigo.ads.core.d.a.a(a5, (h) bVar2.c);
                sg.bigo.ads.core.d.a.c(a5);
                sg.bigo.ads.core.d.a.a("06002006", a5);
                return;
            }
            a(poll, 1001, str);
        }
    }

    public final void a(int i2, int i3, int i4, String str, Object obj) {
        final int i5 = i2;
        final int i6 = i3;
        final String str2 = str;
        final int i7 = i4;
        final Object obj2 = obj;
        sg.bigo.ads.common.f.c.a(3, new Runnable() {
            public final void run() {
                C0129a aVar = a.this.i.get(i5);
                if (aVar != null) {
                    sg.bigo.ads.api.b bVar = ((sg.bigo.ads.controller.h.b) aVar.a).g;
                    a.this.i.remove(i5);
                    int i = i6;
                    String str = str2;
                    if (i == 1005) {
                        if (i7 == -6) {
                            i = 1004;
                            str = "No fill. Please try again later.";
                        } else {
                            str = "Error from server: " + str2;
                        }
                    }
                    aVar.b.a(i5, i, i7, str, obj2);
                    Object obj = obj2;
                    if (obj instanceof sg.bigo.ads.api.a.g) {
                        int i2 = i6;
                        int i3 = i7;
                        String str2 = str2;
                        Map<String, String> a2 = sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.a.g) obj);
                        a2.put("rslt", MBridgeConstans.ENDCARD_URL_TYPE_PL);
                        a2.put("banner_type", String.valueOf(bVar.b));
                        a2.put("cost", String.valueOf(System.currentTimeMillis() - bVar.d()));
                        a2.put("e_code", String.valueOf(i2));
                        a2.put("s_code", String.valueOf(i3));
                        a2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str2);
                        sg.bigo.ads.core.d.a.a(a2, (h) bVar.c);
                        sg.bigo.ads.core.d.a.a("06002007", a2);
                    }
                }
                a.this.a();
            }
        });
    }

    public final /* synthetic */ void a(final int i2, Object obj) {
        final sg.bigo.ads.api.core.c cVar = (sg.bigo.ads.api.core.c) obj;
        sg.bigo.ads.common.f.c.a(3, new Runnable() {
            public final void run() {
                C0129a aVar = a.this.i.get(i2);
                if (aVar != null) {
                    a.this.i.remove(i2);
                    sg.bigo.ads.api.b bVar = ((sg.bigo.ads.controller.h.b) aVar.a).g;
                    g.a aVar2 = new g.a(cVar, ((sg.bigo.ads.controller.h.b) aVar.a).h, a.this.b, bVar);
                    aVar2.a = a.this.f;
                    sg.bigo.ads.api.core.g a2 = aVar2.a();
                    sg.bigo.ads.api.core.c cVar = cVar;
                    int i = 1;
                    boolean z = ((sg.bigo.ads.controller.h.b) aVar.a).h.r() && cVar.H();
                    Map<String, String> b2 = sg.bigo.ads.core.d.a.b(cVar);
                    String str = "1";
                    b2.put("rslt", str);
                    b2.put("banner_type", String.valueOf(bVar.b));
                    b2.put("cost", String.valueOf(System.currentTimeMillis() - bVar.d()));
                    if ((cVar instanceof n) && cVar.l() == 2) {
                        n nVar = (n) cVar;
                        if (nVar.T() == null || !nVar.T().a()) {
                            i = 0;
                        }
                        b2.put("video_type", String.valueOf(i));
                    }
                    if (!z) {
                        str = MBridgeConstans.ENDCARD_URL_TYPE_PL;
                    }
                    b2.put("is_playable", str);
                    sg.bigo.ads.core.d.a.a("06002007", b2);
                    aVar.b.a(i2, a2);
                    if (sg.bigo.ads.api.core.b.c(cVar.m())) {
                        sg.bigo.ads.api.core.c cVar2 = cVar;
                        r.a();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("slot", cVar2.a());
                        contentValues.put("log_id", Long.valueOf(cVar2.D()));
                        long currentTimeMillis = System.currentTimeMillis();
                        contentValues.put("start_time", Long.valueOf(currentTimeMillis));
                        contentValues.put("end_time", Long.valueOf((cVar2.z() * 1000) + currentTimeMillis));
                        JSONObject K = cVar2.K();
                        contentValues.put("ad_data", K == null ? "" : K.toString());
                        contentValues.put("mtime", Long.valueOf(currentTimeMillis));
                        sg.bigo.ads.common.c.a.a.b("tb_addata", contentValues);
                    }
                }
                a.this.a();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a(final C0129a<? extends sg.bigo.ads.api.b> aVar, final int i2, final String str) {
        sg.bigo.ads.common.f.c.a(2, new Runnable() {
            public final void run() {
                aVar.b.a(0, i2, 0, str, (Object) null);
            }
        });
    }

    public final void a(boolean z) {
        this.k = z;
        if (this.k) {
            sg.bigo.ads.common.p.b.b();
            b.a(this.l);
        }
    }
}
