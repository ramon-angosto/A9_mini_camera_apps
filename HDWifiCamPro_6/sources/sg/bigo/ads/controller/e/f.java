package sg.bigo.ads.controller.e;

import android.os.SystemClock;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.b.b;
import sg.bigo.ads.controller.e.e;

public final class f implements b.a {
    private static final f f = new f();
    public boolean a = false;
    long b = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    long c = 0;
    long d = 0;
    public final a e = new a();
    private long g = 21600000;
    private boolean h;
    private long i;
    private long j;

    public class a {
        long a = 0;

        public a() {
        }

        public final String a(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("start_ts", Long.valueOf(this.a));
                f fVar = f.this;
                jSONObject.putOpt("total_duration", Long.valueOf(fVar.c + fVar.b()));
                f fVar2 = f.this;
                long b2 = fVar2.b();
                if (b2 > fVar2.b) {
                    fVar2.d = b2;
                } else {
                    b2 = fVar2.d;
                }
                jSONObject.putOpt("close_duration", Long.valueOf(b2));
                e.a a2 = e.a().a(str);
                jSONObject.putOpt("front_total_req_times", Long.valueOf((long) (e.this.c ? a2.a.getAndAdd(1) : a2.a.get())));
                e.a a3 = e.a().a(str);
                jSONObject.putOpt("back_total_req_times", Long.valueOf((long) (!e.this.c ? a3.b.getAndAdd(1) : a3.b.get())));
                e.a a4 = e.a().a(str);
                jSONObject.putOpt("close_front_req_times", Long.valueOf((long) (e.this.c ? a4.c.getAndAdd(1) : a4.c.get())));
                jSONObject.putOpt("req_status", Long.valueOf((long) f.a(f.this)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    private f() {
        b.a().d = this;
    }

    static /* synthetic */ int a(f fVar) {
        return fVar.h ? 1 : 2;
    }

    public static f a() {
        return f;
    }

    public final void a(long j2) {
        this.h = true;
        this.i = j2;
        long j3 = this.g;
        if (j3 > 0) {
            long j4 = this.j;
            if (j4 > 0 && j2 - j4 >= j3) {
                this.c = 0;
                this.d = 0;
                this.e.a = System.currentTimeMillis();
                e.a().a.clear();
            }
        }
        if (this.e.a == 0) {
            this.e.a = System.currentTimeMillis();
        }
        e.a().a(true);
    }

    public final void a(i iVar) {
        this.a = iVar.a();
        this.b = iVar.b();
        this.g = iVar.c();
    }

    public final void a(boolean z, long j2, long j3, long j4) {
        this.h = false;
        this.j = j3;
        this.i = 0;
        long j5 = j3 - j2;
        if (j5 > 0 && j5 > this.b) {
            this.c += j5;
            this.d = j5;
            if (this.a) {
                int i2 = z ? 1 : 2;
                HashMap hashMap = new HashMap();
                hashMap.put("start_type", String.valueOf(i2));
                hashMap.put("start_time", String.valueOf(j4));
                hashMap.put(IronSourceConstants.EVENTS_DURATION, String.valueOf(j5));
                sg.bigo.ads.core.d.a.a("06002044", (Map<String, String>) hashMap);
            }
        }
        e.a().a(false);
    }

    /* access modifiers changed from: package-private */
    public final long b() {
        long j2 = this.i;
        if (j2 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
            if (elapsedRealtime > 0 && elapsedRealtime > this.b) {
                return elapsedRealtime;
            }
        }
        return 0;
    }
}
