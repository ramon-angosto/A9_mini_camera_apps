package com.huawei.hms.framework.network.grs.p016c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C0768a;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p015b.C0731b;
import com.huawei.hms.framework.network.grs.p016c.p017a.C0738a;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0743c;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0744d;
import com.huawei.hms.framework.network.grs.p019d.C0763d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* renamed from: com.huawei.hms.framework.network.grs.c.e */
public class C0747e implements C0737a {

    /* renamed from: a */
    private static final String f517a = "e";

    /* renamed from: b */
    private GrsBaseInfo f518b;

    /* renamed from: c */
    private Context f519c;

    /* renamed from: d */
    private C0726a f520d;

    /* renamed from: e */
    private C0748f f521e;

    /* renamed from: f */
    private ArrayList<Future<C0748f>> f522f = new ArrayList<>();

    /* renamed from: g */
    private ArrayList<C0748f> f523g = new ArrayList<>();

    /* renamed from: h */
    private JSONArray f524h = new JSONArray();

    /* renamed from: i */
    private ArrayList<String> f525i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<String> f526j = new ArrayList<>();

    /* renamed from: k */
    private C0744d f527k;

    /* renamed from: l */
    private C0743c f528l;

    /* renamed from: m */
    private long f529m = 1;

    public C0747e(C0743c cVar, C0726a aVar) {
        this.f528l = cVar;
        this.f518b = cVar.mo13845b();
        this.f519c = cVar.mo13843a();
        this.f520d = aVar;
        m589b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0091 A[LOOP:0: B:1:0x0005->B:38:0x0091, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.framework.network.grs.p016c.C0748f m586a(java.util.concurrent.ExecutorService r16, java.util.ArrayList<java.lang.String> r17, java.lang.String r18, com.huawei.hms.framework.network.grs.p014a.C0728c r19) {
        /*
            r15 = this;
            r9 = r15
            r10 = 0
            r0 = 0
            r12 = r0
            r11 = 0
        L_0x0005:
            int r0 = r17.size()
            if (r11 >= r0) goto L_0x0095
            r13 = r17
            java.lang.Object r0 = r13.get(r11)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            r14 = 1
            if (r0 != 0) goto L_0x0084
            com.huawei.hms.framework.network.grs.c.b r0 = new com.huawei.hms.framework.network.grs.c.b
            android.content.Context r5 = r9.f519c
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.f518b
            r1 = r0
            r3 = r11
            r4 = r15
            r6 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r0 = r0.mo13840g()
            r1 = r16
            java.util.concurrent.Future r0 = r1.submit(r0)
            java.util.ArrayList<java.util.concurrent.Future<com.huawei.hms.framework.network.grs.c.f>> r2 = r9.f522f
            r2.add(r0)
            long r2 = r9.f529m     // Catch:{ CancellationException -> 0x007c, ExecutionException -> 0x0073, InterruptedException -> 0x006a, TimeoutException -> 0x0062 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ CancellationException -> 0x007c, ExecutionException -> 0x0073, InterruptedException -> 0x006a, TimeoutException -> 0x0062 }
            java.lang.Object r0 = r0.get(r2, r4)     // Catch:{ CancellationException -> 0x007c, ExecutionException -> 0x0073, InterruptedException -> 0x006a, TimeoutException -> 0x0062 }
            r2 = r0
            com.huawei.hms.framework.network.grs.c.f r2 = (com.huawei.hms.framework.network.grs.p016c.C0748f) r2     // Catch:{ CancellationException -> 0x007c, ExecutionException -> 0x0073, InterruptedException -> 0x006a, TimeoutException -> 0x0062 }
            if (r2 == 0) goto L_0x005f
            boolean r0 = r2.mo13877m()     // Catch:{ CancellationException -> 0x005d, ExecutionException -> 0x005a, InterruptedException -> 0x0057, TimeoutException -> 0x0055 }
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = f517a     // Catch:{ CancellationException -> 0x005d, ExecutionException -> 0x005a, InterruptedException -> 0x0057, TimeoutException -> 0x0055 }
            java.lang.String r3 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.m474i(r0, r3)     // Catch:{ CancellationException -> 0x005d, ExecutionException -> 0x005a, InterruptedException -> 0x0057, TimeoutException -> 0x0055 }
            goto L_0x0060
        L_0x0055:
            r12 = r2
            goto L_0x0062
        L_0x0057:
            r0 = move-exception
            r12 = r2
            goto L_0x006b
        L_0x005a:
            r0 = move-exception
            r12 = r2
            goto L_0x0074
        L_0x005d:
            r12 = r2
            goto L_0x007c
        L_0x005f:
            r14 = 0
        L_0x0060:
            r12 = r2
            goto L_0x0087
        L_0x0062:
            java.lang.String r0 = f517a
            java.lang.String r2 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.m478w(r0, r2)
            goto L_0x0086
        L_0x006a:
            r0 = move-exception
        L_0x006b:
            java.lang.String r2 = f517a
            java.lang.String r3 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r2, (java.lang.String) r3, (java.lang.Throwable) r0)
            goto L_0x0087
        L_0x0073:
            r0 = move-exception
        L_0x0074:
            java.lang.String r2 = f517a
            java.lang.String r3 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r2, (java.lang.String) r3, (java.lang.Throwable) r0)
            goto L_0x0086
        L_0x007c:
            java.lang.String r0 = f517a
            java.lang.String r2 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.m474i(r0, r2)
            goto L_0x0087
        L_0x0084:
            r1 = r16
        L_0x0086:
            r14 = 0
        L_0x0087:
            if (r14 == 0) goto L_0x0091
            java.lang.String r0 = f517a
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.m476v(r0, r1)
            goto L_0x0095
        L_0x0091:
            int r11 = r11 + 1
            goto L_0x0005
        L_0x0095:
            com.huawei.hms.framework.network.grs.c.f r0 = r15.m587b(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p016c.C0747e.m586a(java.util.concurrent.ExecutorService, java.util.ArrayList, java.lang.String, com.huawei.hms.framework.network.grs.a.c):com.huawei.hms.framework.network.grs.c.f");
    }

    /* renamed from: b */
    private C0748f m587b(C0748f fVar) {
        String str;
        String str2;
        int size = this.f522f.size();
        for (int i = 0; i < size && (fVar == null || !fVar.mo13877m()); i++) {
            try {
                fVar = (C0748f) this.f522f.get(i).get(40000, TimeUnit.MILLISECONDS);
            } catch (CancellationException unused) {
                Logger.m474i(f517a, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e) {
                e = e;
                str2 = f517a;
                str = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.m479w(str2, str, e);
            } catch (InterruptedException e2) {
                e = e2;
                str2 = f517a;
                str = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.m479w(str2, str, e);
            } catch (TimeoutException unused2) {
                Logger.m478w(f517a, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!this.f522f.get(i).isCancelled()) {
                    this.f522f.get(i).cancel(true);
                }
            }
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public C0748f m588b(ExecutorService executorService, String str, C0728c cVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C0748f a = m586a(executorService, this.f526j, str, cVar);
        int b = a == null ? 0 : a.mo13865b();
        Logger.m477v(f517a, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(b));
        if (b == 404 || b == 401) {
            if (!TextUtils.isEmpty(m590c()) || !TextUtils.isEmpty(this.f518b.getAppName())) {
                this.f522f.clear();
                Logger.m474i(f517a, "this env has not deploy new interface,so use old interface.");
                a = m586a(executorService, this.f525i, str, cVar);
            } else {
                Logger.m474i(f517a, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
        }
        C0750h.m626a(new ArrayList(this.f523g), SystemClock.elapsedRealtime() - elapsedRealtime, this.f524h, this.f519c);
        return a;
    }

    /* renamed from: b */
    private void m589b() {
        C0744d a = C0738a.m557a(this.f519c);
        if (a == null) {
            Logger.m478w(f517a, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        mo13860a(a);
        List<String> a2 = a.mo13848a();
        if (a2 == null || a2.size() <= 0) {
            Logger.m476v(f517a, "maybe grs_base_url config with [],please check.");
        } else if (a2.size() <= 10) {
            String c = a.mo13854c();
            String b = a.mo13852b();
            if (a2.size() > 0) {
                for (String next : a2) {
                    if (!next.startsWith("https://")) {
                        Logger.m478w(f517a, "grs server just support https scheme url,please check.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(next);
                        Locale locale = Locale.ROOT;
                        Object[] objArr = new Object[1];
                        objArr[0] = TextUtils.isEmpty(m590c()) ? this.f518b.getAppName() : m590c();
                        sb.append(String.format(locale, c, objArr));
                        String grsReqParamJoint = this.f518b.getGrsReqParamJoint(false, false, "1.0", this.f519c);
                        if (!TextUtils.isEmpty(grsReqParamJoint)) {
                            sb.append("?");
                            sb.append(grsReqParamJoint);
                        }
                        this.f525i.add(sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(next);
                        sb2.append(b);
                        String grsReqParamJoint2 = this.f518b.getGrsReqParamJoint(false, false, m590c(), this.f519c);
                        if (!TextUtils.isEmpty(grsReqParamJoint2)) {
                            sb2.append("?");
                            sb2.append(grsReqParamJoint2);
                        }
                        this.f526j.add(sb2.toString());
                    }
                }
            }
            Logger.m477v(f517a, "request to GRS server url is{%s} and {%s}", this.f525i, this.f526j);
        } else {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
    }

    /* renamed from: c */
    private String m590c() {
        C0731b a = C0731b.m539a(this.f519c.getPackageName(), this.f518b);
        C0768a a2 = a != null ? a.mo13825a() : null;
        if (a2 == null) {
            return "";
        }
        String b = a2.mo13903b();
        Logger.m477v(f517a, "get appName from local assets is{%s}", b);
        return b;
    }

    /* renamed from: a */
    public C0744d mo13858a() {
        return this.f527k;
    }

    /* renamed from: a */
    public C0748f mo13859a(ExecutorService executorService, String str, C0728c cVar) {
        String str2;
        String str3;
        if (this.f525i == null || this.f526j == null) {
            return null;
        }
        try {
            C0744d a = mo13858a();
            return (C0748f) executorService.submit(new C0746d(this, executorService, str, cVar)).get((long) (a != null ? a.mo13855d() : 10), TimeUnit.SECONDS);
        } catch (CancellationException unused) {
            Logger.m474i(f517a, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e) {
            e = e;
            str3 = f517a;
            str2 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.m479w(str3, str2, e);
            return null;
        } catch (InterruptedException e2) {
            e = e2;
            str3 = f517a;
            str2 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.m479w(str3, str2, e);
            return null;
        } catch (TimeoutException unused2) {
            Logger.m478w(f517a, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e3) {
            e = e3;
            str3 = f517a;
            str2 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.m479w(str3, str2, e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo13860a(C0744d dVar) {
        this.f527k = dVar;
    }

    /* renamed from: a */
    public synchronized void mo13833a(C0748f fVar) {
        this.f523g.add(fVar);
        C0748f fVar2 = this.f521e;
        if (fVar2 == null || !fVar2.mo13877m()) {
            if (fVar.mo13876l()) {
                Logger.m474i(f517a, "GRS server open 503 limiting strategy.");
                C0763d.m675a(this.f518b.getGrsParasKey(false, true, this.f519c), new C0763d.C0764a(fVar.mo13874j(), SystemClock.elapsedRealtime()));
            } else if (!fVar.mo13877m()) {
                Logger.m476v(f517a, "grsResponseResult has exception so need return");
            } else {
                this.f521e = fVar;
                this.f520d.mo13799a(this.f518b, this.f521e, this.f519c, this.f528l);
                for (int i = 0; i < this.f522f.size(); i++) {
                    if (!this.f525i.get(i).equals(fVar.mo13875k()) && !this.f526j.get(i).equals(fVar.mo13875k()) && !this.f522f.get(i).isCancelled()) {
                        Logger.m474i(f517a, "future cancel");
                        this.f522f.get(i).cancel(true);
                    }
                }
            }
        } else {
            Logger.m476v(f517a, "grsResponseResult is ok");
        }
    }
}
