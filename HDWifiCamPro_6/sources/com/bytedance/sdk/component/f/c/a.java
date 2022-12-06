package com.bytedance.sdk.component.f.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.a;
import com.bytedance.sdk.component.f.b.b;
import com.bytedance.sdk.component.f.b.c;
import com.bytedance.sdk.component.f.d.e;
import com.bytedance.sdk.component.f.d.f;
import com.bytedance.sdk.component.f.d.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: AppConfig */
public class a implements g.a {
    private static a b;
    final g a = new g(Looper.getMainLooper(), this);
    private final boolean c;
    private volatile boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private long g = 0;
    /* access modifiers changed from: private */
    public long h = 0;
    private ThreadPoolExecutor i = null;
    /* access modifiers changed from: private */
    public AtomicBoolean j = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final Context k;
    private volatile boolean l = false;
    private com.bytedance.sdk.component.f.a m;
    private int n;

    public a(Context context, int i2) {
        this.k = context;
        this.c = f.b(context);
        this.n = i2;
    }

    private a(Context context, boolean z) {
        this.k = context;
        this.c = z;
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context.getApplicationContext(), f.b(context));
            }
            aVar = b;
        }
        return aVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "https://" + str + "/get_domains/v4/";
    }

    /* access modifiers changed from: private */
    public void a(final int i2) {
        String[] f2 = f();
        if (f2 == null || f2.length <= i2) {
            b(102);
            return;
        }
        String str = f2[i2];
        if (TextUtils.isEmpty(str)) {
            b(102);
            return;
        }
        try {
            String a2 = a(str);
            if (TextUtils.isEmpty(a2)) {
                b(102);
                return;
            }
            b c2 = i().c();
            c2.a(a2);
            a(c2);
            c2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                public void a(c cVar, com.bytedance.sdk.component.f.b bVar) {
                    JSONObject jSONObject;
                    if (bVar == null || !bVar.f()) {
                        a.this.a(i2 + 1);
                        return;
                    }
                    String str = null;
                    try {
                        jSONObject = new JSONObject(bVar.d());
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        a.this.a(i2 + 1);
                        return;
                    }
                    try {
                        str = jSONObject.getString("message");
                    } catch (Exception unused2) {
                    }
                    if (!"success".equals(str)) {
                        a.this.a(i2 + 1);
                        return;
                    }
                    try {
                        if (a.this.a((Object) jSONObject)) {
                            a.this.b(101);
                        } else {
                            a.this.a(i2 + 1);
                        }
                    } catch (Exception unused3) {
                    }
                }

                public void a(c cVar, IOException iOException) {
                    a.this.a(i2 + 1);
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.f.d.b.b("AppConfig", "try app config exception: " + th);
        }
    }

    private void a(b bVar) {
        if (bVar != null) {
            Address address = null;
            if (g.a().a(this.n).d() != null) {
                address = g.a().a(this.n).d().a(this.k);
            }
            if (address != null && address.hasLatitude() && address.hasLongitude()) {
                bVar.a("latitude", address.getLatitude() + "");
                bVar.a("longitude", address.getLongitude() + "");
                String locality = address.getLocality();
                if (!TextUtils.isEmpty(locality)) {
                    bVar.a("city", Uri.encode(locality));
                }
            }
            if (this.d) {
                bVar.a("force", "1");
            }
            try {
                bVar.a("abi", Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (g.a().a(this.n).d() != null) {
                bVar.a("aid", g.a().a(this.n).d().a() + "");
                bVar.a("device_platform", g.a().a(this.n).d().c());
                bVar.a("channel", g.a().a(this.n).d().b());
                bVar.a("version_code", g.a().a(this.n).d().d() + "");
                bVar.a("custom_info_1", g.a().a(this.n).d().e());
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(DataSchemeDataSource.SCHEME_DATA);
        synchronized (this) {
            SharedPreferences.Editor edit = this.k.getSharedPreferences("ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (g.a().a(this.n).h() == null) {
            return true;
        }
        g.a().a(this.n).h().a(jSONObject2);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r4 = r4.toCharArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r2 >= r4.length) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        r4[r2] = (char) (r4[r2] ^ r2);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        return new java.lang.String(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r0 = 'J';
        r1 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        switch(r1) {
            case 55: goto L_0x0039;
            case 56: goto L_0x004f;
            case 57: goto L_0x0010;
            default: goto L_0x000f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        switch(1) {
            case 60: goto L_0x0017;
            case 61: goto L_0x0023;
            case 62: goto L_0x0030;
            default: goto L_0x0016;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a1667305730924dc(java.lang.String r4) {
        /*
        L_0x0000:
            r0 = 73
            r1 = 96
        L_0x0004:
            r2 = 0
            switch(r0) {
                case 72: goto L_0x004f;
                case 73: goto L_0x0009;
                case 74: goto L_0x000c;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0054
        L_0x0009:
            switch(r1) {
                case 94: goto L_0x0000;
                case 95: goto L_0x0010;
                case 96: goto L_0x004f;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r1) {
                case 55: goto L_0x0039;
                case 56: goto L_0x004f;
                case 57: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0000
        L_0x0010:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L_0x0017;
                case 61: goto L_0x0023;
                case 62: goto L_0x0030;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x004f
        L_0x0017:
            int r3 = 0 - r1
            int r3 = r3 * r2
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0000
        L_0x0023:
            int r2 = 18 - r1
            int r2 = r2 * r0
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x004f
        L_0x0030:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L_0x0000
        L_0x0039:
            char[] r4 = r4.toCharArray()
        L_0x003d:
            int r0 = r4.length
            if (r2 >= r0) goto L_0x0049
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L_0x003d
        L_0x0049:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L_0x004f:
            r0 = 74
            r1 = 55
            goto L_0x0004
        L_0x0054:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.a.a1667305730924dc(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.sendEmptyMessage(i2);
        }
    }

    public static void b(Context context) {
        a aVar = b;
        if (aVar == null) {
            return;
        }
        if (f.b(context)) {
            aVar.a(true);
        } else {
            aVar.a();
        }
    }

    private void c(boolean z) {
        if (!this.f) {
            if (this.e) {
                this.e = false;
                this.g = 0;
                this.h = 0;
            }
            long j2 = z ? 10800000 : 43200000;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g <= j2) {
                return;
            }
            if (currentTimeMillis - this.h > 120000 || !this.l) {
                c();
            }
        }
    }

    private boolean h() {
        String[] f2 = f();
        if (!(f2 == null || f2.length == 0)) {
            a(0);
        }
        return false;
    }

    private com.bytedance.sdk.component.f.a i() {
        if (this.m == null) {
            this.m = new a.C0035a().a(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).a();
        }
        return this.m;
    }

    public void a() {
        a(false);
    }

    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 101) {
            this.f = false;
            this.g = System.currentTimeMillis();
            com.bytedance.sdk.component.f.d.b.b("TNCManager", "doRefresh, succ");
            if (this.e) {
                a();
            }
        } else if (i2 == 102) {
            this.f = false;
            if (this.e) {
                a();
            }
            com.bytedance.sdk.component.f.d.b.b("TNCManager", "doRefresh, error");
        } else {
            return;
        }
        this.j.set(false);
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        this.i = threadPoolExecutor;
    }

    public synchronized void a(boolean z) {
        if (this.c) {
            c(z);
        } else if (this.g <= 0) {
            try {
                g().execute(new Runnable() {
                    public void run() {
                        a.this.b();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        if (System.currentTimeMillis() - this.g > 3600000) {
            this.g = System.currentTimeMillis();
            try {
                if (g.a().a(this.n).h() != null) {
                    g.a().a(this.n).h().b();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        com.bytedance.sdk.component.f.d.b.b("TNCManager", "doRefresh, actual request");
        d();
        this.f = true;
        if (!z) {
            this.a.sendEmptyMessage(102);
            return;
        }
        try {
            h();
        } catch (Exception unused) {
            this.j.set(false);
        }
    }

    public boolean c() {
        com.bytedance.sdk.component.f.d.b.b("TNCManager", "doRefresh: updating state " + this.j.get());
        g().execute(new Runnable() {
            public void run() {
                boolean a2 = e.a(a.this.k);
                if (a2) {
                    long unused = a.this.h = System.currentTimeMillis();
                    if (!a.this.j.compareAndSet(false, true)) {
                        com.bytedance.sdk.component.f.d.b.b("TNCManager", "doRefresh, already running");
                    } else {
                        a.this.b(a2);
                    }
                }
            }
        });
        return true;
    }

    public synchronized void d() {
        if (!this.l) {
            this.l = true;
            long j2 = this.k.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (j2 > currentTimeMillis) {
                j2 = currentTimeMillis;
            }
            this.g = j2;
            try {
                if (g.a().a(this.n).h() != null) {
                    g.a().a(this.n).h().a();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void e() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                if (this.c) {
                    d();
                } else {
                    b();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String[] f() {
        String[] f2 = g.a().a(this.n).d() != null ? g.a().a(this.n).d().f() : null;
        return (f2 == null || f2.length <= 0) ? new String[0] : f2;
    }

    public ThreadPoolExecutor g() {
        Class<a> cls = a.class;
        if (this.i == null) {
            synchronized (cls) {
                if (this.i == null) {
                    this.i = new ThreadPoolExecutor(2, 2, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    this.i.allowCoreThreadTimeOut(true);
                }
            }
        }
        return this.i;
    }
}
