package com.bytedance.sdk.component.e.a.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.e.d;
import com.bytedance.sdk.component.e.a.e.e;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.i;
import java.util.List;
import java.util.UUID;

/* compiled from: TrackAdUrlImpl */
public class c implements b {
    private final Context a;
    /* access modifiers changed from: private */
    public final e b;

    public c(Context context, e eVar) {
        this.a = context;
        this.b = eVar;
    }

    public Context a() {
        Context context = this.a;
        return context == null ? i.e().d() : context;
    }

    public void a(String str, List<String> list, boolean z) {
        f m = i.e().m();
        if (m != null && i.e().d() != null && m.e() != null && m.d() && list != null && list.size() != 0) {
            for (String dVar : list) {
                m.e().execute(new a(new d(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), dVar, z, 5), str));
            }
        }
    }

    public void a(final String str) {
        f m = i.e().m();
        if (m != null && i.e().d() != null && m.d()) {
            AnonymousClass1 r1 = new e("trackFailedUrls") {
                public void run() {
                    final List<d> a2 = c.this.b.a();
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            c.this.a(a2, str);
                        }
                    });
                }
            };
            r1.a(1);
            if (m.e() != null) {
                m.e().execute(r1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(List<d> list, String str) {
        if (list != null && list.size() != 0) {
            f m = i.e().m();
            for (d next : list) {
                if (!(m == null || m.e() == null)) {
                    m.e().execute(new a(next, str));
                }
            }
        }
    }

    /* compiled from: TrackAdUrlImpl */
    private class a extends e {
        private final d b;
        private final String c;

        private a(d dVar, String str) {
            super("AdsStats");
            this.b = dVar;
            this.c = str;
        }

        private String c(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.c)) ? str.replace("{UID}", this.c).replace("__UID__", this.c) : str;
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
        }

        /* access modifiers changed from: package-private */
        public String b(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(com.bytedance.sdk.component.utils.a.getRandomInstance().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        public void run() {
            f m = i.e().m();
            if (m != null && i.e().d() != null && m.d() && a(this.b.b())) {
                if (this.b.d() == 0) {
                    c.this.b.c(this.b);
                    return;
                }
                while (this.b.d() > 0) {
                    try {
                        m.n();
                        if (this.b.d() == 5) {
                            c.this.b.a(this.b);
                        }
                        if (m.a(c.this.a())) {
                            long currentTimeMillis = System.currentTimeMillis();
                            String b2 = this.b.b();
                            if (m.g() == 0) {
                                b2 = c(this.b.b());
                                if (this.b.c()) {
                                    b2 = b(b2);
                                }
                            }
                            com.bytedance.sdk.component.e.a.e.c k = m.k();
                            if (k != null) {
                                k.a("User-Agent", m.j());
                                k.a(b2);
                                d dVar = null;
                                try {
                                    dVar = k.a();
                                    m.a(dVar.a());
                                } catch (Throwable unused) {
                                }
                                if (dVar != null) {
                                    if (dVar.a()) {
                                        c.this.b.c(this.b);
                                        com.bytedance.sdk.component.e.a.c.c.a("trackurl", "track success : " + this.b.b());
                                        m.a(true, 200, System.currentTimeMillis() - currentTimeMillis);
                                        return;
                                    }
                                }
                                com.bytedance.sdk.component.e.a.c.c.a("trackurl", "track fail : " + this.b.b());
                                this.b.a(this.b.d() - 1);
                                if (this.b.d() == 0) {
                                    c.this.b.c(this.b);
                                    com.bytedance.sdk.component.e.a.c.c.a("trackurl", "track fail and delete : " + this.b.b());
                                    return;
                                }
                                c.this.b.b(this.b);
                                if (dVar != null) {
                                    m.a(false, dVar.b(), System.currentTimeMillis());
                                } else {
                                    m.a(false, 0, System.currentTimeMillis());
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }
}
