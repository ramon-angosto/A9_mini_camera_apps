package com.huawei.hms.framework.network.grs.p016c;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.C0729b;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0742b;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0743c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.huawei.hms.framework.network.grs.c.m */
public class C0755m {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ExecutorService f562a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");

    /* renamed from: b */
    private Map<String, C0742b> f563b = new ConcurrentHashMap(16);

    /* renamed from: c */
    private final Object f564c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0726a f565d;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m629a(C0748f fVar, C0729b bVar) {
        if (bVar == null) {
            return;
        }
        if (fVar == null) {
            Logger.m476v("RequestController", "GrsResponse is null");
            bVar.mo13793a();
            return;
        }
        Logger.m476v("RequestController", "GrsResponse is not null");
        bVar.mo13794a(fVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        return r7.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        r8 = "RequestController";
        r9 = "when check result, find InterruptedException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        r8 = "RequestController";
        r9 = "when check result, find ExecutionException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a0, code lost:
        r8 = "RequestController";
        r9 = "when check result, find CancellationException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a4, code lost:
        com.huawei.hms.framework.common.Logger.m479w(r8, r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.framework.network.grs.p016c.C0748f mo13883a(com.huawei.hms.framework.network.grs.p016c.p018b.C0743c r7, java.lang.String r8, com.huawei.hms.framework.network.grs.p014a.C0728c r9) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "request to server with service name is: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RequestController"
            com.huawei.hms.framework.common.Logger.m469d(r1, r0)
            com.huawei.hms.framework.network.grs.GrsBaseInfo r0 = r7.mo13845b()
            android.content.Context r1 = r7.mo13843a()
            r2 = 0
            r3 = 1
            java.lang.String r0 = r0.getGrsParasTag(r2, r3, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "request spUrlKey: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RequestController"
            com.huawei.hms.framework.common.Logger.m476v(r2, r1)
            java.lang.Object r1 = r6.f564c
            monitor-enter(r1)
            android.content.Context r2 = r7.mo13843a()     // Catch:{ all -> 0x00a8 }
            boolean r2 = com.huawei.hms.framework.common.NetworkUtil.isNetworkAvailable(r2)     // Catch:{ all -> 0x00a8 }
            r3 = 0
            if (r2 != 0) goto L_0x004a
            monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
            return r3
        L_0x004a:
            com.huawei.hms.framework.network.grs.d.d$a r2 = com.huawei.hms.framework.network.grs.p019d.C0763d.m674a(r0)     // Catch:{ all -> 0x00a8 }
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.c.b.b> r4 = r6.f563b     // Catch:{ all -> 0x00a8 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x00a8 }
            com.huawei.hms.framework.network.grs.c.b.b r4 = (com.huawei.hms.framework.network.grs.p016c.p018b.C0742b) r4     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x0064
            boolean r5 = r4.mo13842b()     // Catch:{ all -> 0x00a8 }
            if (r5 != 0) goto L_0x005f
            goto L_0x0064
        L_0x005f:
            java.util.concurrent.Future r7 = r4.mo13841a()     // Catch:{ all -> 0x00a8 }
            goto L_0x008b
        L_0x0064:
            if (r2 == 0) goto L_0x006f
            boolean r2 = r2.mo13894a()     // Catch:{ all -> 0x00a8 }
            if (r2 != 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
            return r3
        L_0x006f:
            java.lang.String r2 = "RequestController"
            java.lang.String r4 = "hitGrsRequestBean == null or request block is released."
            com.huawei.hms.framework.common.Logger.m469d(r2, r4)     // Catch:{ all -> 0x00a8 }
            java.util.concurrent.ExecutorService r2 = r6.f562a     // Catch:{ all -> 0x00a8 }
            com.huawei.hms.framework.network.grs.c.k r4 = new com.huawei.hms.framework.network.grs.c.k     // Catch:{ all -> 0x00a8 }
            r4.<init>(r6, r7, r8, r9)     // Catch:{ all -> 0x00a8 }
            java.util.concurrent.Future r7 = r2.submit(r4)     // Catch:{ all -> 0x00a8 }
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.c.b.b> r8 = r6.f563b     // Catch:{ all -> 0x00a8 }
            com.huawei.hms.framework.network.grs.c.b.b r9 = new com.huawei.hms.framework.network.grs.c.b.b     // Catch:{ all -> 0x00a8 }
            r9.<init>(r7)     // Catch:{ all -> 0x00a8 }
            r8.put(r0, r9)     // Catch:{ all -> 0x00a8 }
        L_0x008b:
            monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
            java.lang.Object r7 = r7.get()     // Catch:{ CancellationException -> 0x009f, ExecutionException -> 0x0099, InterruptedException -> 0x0093 }
            com.huawei.hms.framework.network.grs.c.f r7 = (com.huawei.hms.framework.network.grs.p016c.C0748f) r7     // Catch:{ CancellationException -> 0x009f, ExecutionException -> 0x0099, InterruptedException -> 0x0093 }
            return r7
        L_0x0093:
            r7 = move-exception
            java.lang.String r8 = "RequestController"
            java.lang.String r9 = "when check result, find InterruptedException, check others"
            goto L_0x00a4
        L_0x0099:
            r7 = move-exception
            java.lang.String r8 = "RequestController"
            java.lang.String r9 = "when check result, find ExecutionException, check others"
            goto L_0x00a4
        L_0x009f:
            r7 = move-exception
            java.lang.String r8 = "RequestController"
            java.lang.String r9 = "when check result, find CancellationException, check others"
        L_0x00a4:
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r8, (java.lang.String) r9, (java.lang.Throwable) r7)
            return r3
        L_0x00a8:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p016c.C0755m.mo13883a(com.huawei.hms.framework.network.grs.c.b.c, java.lang.String, com.huawei.hms.framework.network.grs.a.c):com.huawei.hms.framework.network.grs.c.f");
    }

    /* renamed from: a */
    public void mo13884a(C0726a aVar) {
        this.f565d = aVar;
    }

    /* renamed from: a */
    public void mo13885a(C0743c cVar, C0729b bVar, String str, C0728c cVar2) {
        this.f562a.execute(new C0754l(this, cVar, str, cVar2, bVar));
    }

    /* renamed from: a */
    public void mo13886a(String str) {
        synchronized (this.f564c) {
            this.f563b.remove(str);
        }
    }
}
