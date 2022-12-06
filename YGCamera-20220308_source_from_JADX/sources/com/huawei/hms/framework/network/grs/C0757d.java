package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p016c.C0755m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.framework.network.grs.d */
public class C0757d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f566a = "d";

    /* renamed from: b */
    private static ExecutorService f567b = ExecutorsUtils.newCachedThreadPool("GRS_GrsClient-Init");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public GrsBaseInfo f568c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f569d = false;

    /* renamed from: e */
    private final Object f570e = new Object();

    /* renamed from: f */
    private Context f571f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0755m f572g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0726a f573h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0728c f574i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0728c f575j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C0723a f576k;

    /* renamed from: l */
    private Future<Boolean> f577l;

    C0757d(Context context, GrsBaseInfo grsBaseInfo) {
        this.f571f = context.getApplicationContext();
        m644a(grsBaseInfo);
        if (!this.f569d) {
            synchronized (this.f570e) {
                if (!this.f569d) {
                    GrsBaseInfo grsBaseInfo2 = this.f568c;
                    this.f577l = f567b.submit(new C0736c(this, this.f571f, grsBaseInfo2, context));
                }
            }
        }
    }

    C0757d(GrsBaseInfo grsBaseInfo) {
        m644a(grsBaseInfo);
    }

    /* renamed from: a */
    private void m644a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f568c = grsBaseInfo.clone();
        } catch (CloneNotSupportedException e) {
            Logger.m479w(f566a, "GrsClient catch CloneNotSupportedException", (Throwable) e);
            this.f568c = grsBaseInfo.copy();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m646a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.m476v(f566a, "sp's content is empty.");
            return;
        }
        for (String next : map.keySet()) {
            if (next.endsWith(CrashHianalyticsData.TIME)) {
                String a = this.f574i.mo13805a(next, "");
                long j = 0;
                if (!TextUtils.isEmpty(a) && a.matches("\\d+")) {
                    try {
                        j = Long.parseLong(a);
                    } catch (NumberFormatException e) {
                        Logger.m479w(f566a, "convert expire time from String to Long catch NumberFormatException.", (Throwable) e);
                    }
                }
                if (!m647a(j)) {
                    Logger.m474i(f566a, "init interface auto clear some invalid sp's data.");
                    this.f574i.mo13807a(next.substring(0, next.length() - 4));
                    this.f574i.mo13807a(next);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m647a(long j) {
        return System.currentTimeMillis() - j <= 604800000;
    }

    /* renamed from: d */
    private boolean m653d() {
        try {
            if (this.f577l != null) {
                return this.f577l.get(10, TimeUnit.SECONDS).booleanValue();
            }
            return false;
        } catch (CancellationException unused) {
            Logger.m474i(f566a, "init compute task canceled.");
            return false;
        } catch (ExecutionException e) {
            Logger.m479w(f566a, "init compute task failed.", (Throwable) e);
            return false;
        } catch (InterruptedException e2) {
            Logger.m479w(f566a, "init compute task interrupted.", (Throwable) e2);
            return false;
        } catch (TimeoutException unused2) {
            Logger.m478w(f566a, "init compute task timed out");
            return false;
        } catch (Exception e3) {
            Logger.m479w(f566a, "init compute task occur unknown Exception", (Throwable) e3);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo13887a(String str, String str2) {
        if (this.f568c == null || str == null || str2 == null) {
            Logger.m478w(f566a, "invalid para!");
            return null;
        } else if (m653d()) {
            return this.f576k.mo13789a(str, str2, this.f571f);
        } else {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> mo13888a(String str) {
        if (this.f568c != null && str != null) {
            return m653d() ? this.f576k.mo13790a(str, this.f571f) : new HashMap();
        }
        Logger.m478w(f566a, "invalid para!");
        return new HashMap();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13889a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.m478w(f566a, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (this.f568c == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (m653d()) {
            this.f576k.mo13791a(str, iQueryUrlsCallBack, this.f571f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13890a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.m478w(f566a, "IQueryUrlCallBack is must not null for process continue.");
        } else if (this.f568c == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (m653d()) {
            this.f576k.mo13792a(str, str2, iQueryUrlCallBack, this.f571f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo13891a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0757d.class != obj.getClass() || !(obj instanceof C0757d)) {
            return false;
        }
        return this.f568c.compare(((C0757d) obj).f568c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo13892b() {
        if (m653d()) {
            String grsParasKey = this.f568c.getGrsParasKey(false, true, this.f571f);
            this.f574i.mo13807a(grsParasKey);
            C0728c cVar = this.f574i;
            cVar.mo13807a(grsParasKey + CrashHianalyticsData.TIME);
            this.f572g.mo13886a(grsParasKey);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo13893c() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!m653d() || (grsBaseInfo = this.f568c) == null || (context = this.f571f) == null) {
            return false;
        }
        this.f573h.mo13798a(grsBaseInfo, context);
        return true;
    }
}
