package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.download.h;
import com.mbridge.msdk.videocommon.listener.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: UnitCacheCtroller */
public final class k {
    d a = null;
    d b = null;
    private List<CampaignEx> c = new ArrayList();
    /* access modifiers changed from: private */
    public boolean d = true;
    /* access modifiers changed from: private */
    public a e;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, a> f;
    private d g = new d() {
        public final void a(long j, int i) {
            if (i == 5 || i == 4) {
                boolean unused = k.this.d = true;
                k.this.a();
            }
            if (i == 2) {
                boolean unused2 = k.this.d = true;
            }
        }
    };
    private CopyOnWriteArrayList<Map<String, a>> h = new CopyOnWriteArrayList<>();
    private Context i = com.mbridge.msdk.foundation.controller.a.e().g();
    private ExecutorService j;
    private long k = 3600;
    private String l;
    private c m;
    private int n = 2;
    private int o = 1;

    public k(Context context, List<CampaignEx> list, ExecutorService executorService, String str, int i2) {
        List<CampaignEx> list2 = this.c;
        if (!(list2 == null || list == null)) {
            list2.addAll(list);
        }
        this.j = executorService;
        this.l = str;
        this.o = i2;
        b(this.c);
    }

    public k(Context context, CampaignEx campaignEx, ExecutorService executorService, String str, int i2) {
        List<CampaignEx> list = this.c;
        if (!(list == null || campaignEx == null)) {
            list.add(campaignEx);
        }
        this.j = executorService;
        this.l = str;
        this.o = i2;
        b(this.c);
    }

    public final void a(a aVar) {
        this.e = aVar;
    }

    public final void a(String str, a aVar) {
        if (this.f == null) {
            this.f = new ConcurrentHashMap<>();
        }
        this.f.put(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        List<CampaignEx> list2 = this.c;
        if (!(list2 == null || list == null)) {
            list2.addAll(list);
        }
        b(this.c);
    }

    public final void a(CampaignEx campaignEx) {
        List<CampaignEx> list = this.c;
        if (!(list == null || campaignEx == null)) {
            list.add(campaignEx);
        }
        b(this.c);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x01f5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0215
            int r0 = r13.size()
            if (r0 != 0) goto L_0x000a
            goto L_0x0215
        L_0x000a:
            r12.e()
            r12.d()
            int r0 = r12.o
            r1 = 94
            r2 = 287(0x11f, float:4.02E-43)
            r3 = 1
            if (r0 == r3) goto L_0x00f0
            if (r0 == r2) goto L_0x00a1
            r4 = 298(0x12a, float:4.18E-43)
            if (r0 == r4) goto L_0x0061
            if (r0 == r1) goto L_0x00a1
            r4 = 95
            if (r0 == r4) goto L_0x0027
            goto L_0x012c
        L_0x0027:
            java.lang.String r0 = r12.l     // Catch:{ Exception -> 0x0059 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0059 }
            if (r0 != 0) goto L_0x012c
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0059 }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = r12.l     // Catch:{ Exception -> 0x0059 }
            com.mbridge.msdk.b.d r0 = r0.e(r4, r5)     // Catch:{ Exception -> 0x0059 }
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = r12.l     // Catch:{ Exception -> 0x0059 }
            com.mbridge.msdk.b.d r0 = com.mbridge.msdk.b.d.e(r0)     // Catch:{ Exception -> 0x0059 }
        L_0x0049:
            if (r0 == 0) goto L_0x012c
            long r4 = r0.h()     // Catch:{ Exception -> 0x0059 }
            r12.k = r4     // Catch:{ Exception -> 0x0059 }
            int r0 = r0.j()     // Catch:{ Exception -> 0x0059 }
            r12.n = r0     // Catch:{ Exception -> 0x0059 }
            goto L_0x012c
        L_0x0059:
            java.lang.String r13 = "UnitCacheCtroller"
            java.lang.String r0 = "make sure your had put feeds jar into your project"
            com.mbridge.msdk.foundation.tools.q.d(r13, r0)
            return
        L_0x0061:
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r4 = r4.h()
            java.lang.String r5 = r12.l
            com.mbridge.msdk.b.d r0 = r0.f(r4, r5)
            r12.b = r0
            com.mbridge.msdk.b.d r0 = r12.b
            if (r0 != 0) goto L_0x008d
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r4 = r4.h()
            java.lang.String r5 = r12.l
            com.mbridge.msdk.b.d r0 = r0.d(r4, r5)
            r12.b = r0
        L_0x008d:
            com.mbridge.msdk.b.d r0 = r12.b
            if (r0 == 0) goto L_0x012c
            long r4 = r0.h()
            r12.k = r4
            com.mbridge.msdk.b.d r0 = r12.b
            int r0 = r0.j()
            r12.n = r0
            goto L_0x012c
        L_0x00a1:
            java.lang.String r0 = "com.mbridge.msdk.videocommon.d.a"
            java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00e8 }
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x00e8 }
            com.mbridge.msdk.videocommon.d.a r0 = r0.b()     // Catch:{ Exception -> 0x00e8 }
            if (r0 != 0) goto L_0x00b7
            com.mbridge.msdk.videocommon.d.b r4 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x00e8 }
            r4.c()     // Catch:{ Exception -> 0x00e8 }
        L_0x00b7:
            if (r0 == 0) goto L_0x00bf
            long r4 = r0.e()     // Catch:{ Exception -> 0x00e8 }
            r12.k = r4     // Catch:{ Exception -> 0x00e8 }
        L_0x00bf:
            java.lang.String r0 = r12.l     // Catch:{ Exception -> 0x00e8 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00e8 }
            if (r0 != 0) goto L_0x00db
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x00e8 }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r5 = r12.l     // Catch:{ Exception -> 0x00e8 }
            com.mbridge.msdk.videocommon.d.c r0 = r0.a(r4, r5)     // Catch:{ Exception -> 0x00e8 }
            r12.m = r0     // Catch:{ Exception -> 0x00e8 }
        L_0x00db:
            com.mbridge.msdk.videocommon.d.c r0 = r12.m     // Catch:{ Exception -> 0x00e8 }
            if (r0 == 0) goto L_0x012c
            com.mbridge.msdk.videocommon.d.c r0 = r12.m     // Catch:{ Exception -> 0x00e8 }
            int r0 = r0.u()     // Catch:{ Exception -> 0x00e8 }
            r12.n = r0     // Catch:{ Exception -> 0x00e8 }
            goto L_0x012c
        L_0x00e8:
            java.lang.String r13 = "UnitCacheCtroller"
            java.lang.String r0 = "make sure your had put reward jar into your project"
            com.mbridge.msdk.foundation.tools.q.d(r13, r0)
            return
        L_0x00f0:
            java.lang.String r0 = r12.l     // Catch:{ Exception -> 0x020e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x020e }
            if (r0 != 0) goto L_0x012c
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x020e }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x020e }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x020e }
            java.lang.String r5 = r12.l     // Catch:{ Exception -> 0x020e }
            com.mbridge.msdk.b.d r0 = r0.e(r4, r5)     // Catch:{ Exception -> 0x020e }
            r12.a = r0     // Catch:{ Exception -> 0x020e }
            com.mbridge.msdk.b.d r0 = r12.a     // Catch:{ Exception -> 0x020e }
            if (r0 != 0) goto L_0x0118
            java.lang.String r0 = r12.l     // Catch:{ Exception -> 0x020e }
            com.mbridge.msdk.b.d r0 = com.mbridge.msdk.b.d.d(r0)     // Catch:{ Exception -> 0x020e }
            r12.a = r0     // Catch:{ Exception -> 0x020e }
        L_0x0118:
            com.mbridge.msdk.b.d r0 = r12.a     // Catch:{ Exception -> 0x020e }
            if (r0 == 0) goto L_0x012c
            com.mbridge.msdk.b.d r0 = r12.a     // Catch:{ Exception -> 0x020e }
            long r4 = r0.h()     // Catch:{ Exception -> 0x020e }
            r12.k = r4     // Catch:{ Exception -> 0x020e }
            com.mbridge.msdk.b.d r0 = r12.a     // Catch:{ Exception -> 0x020e }
            int r0 = r0.j()     // Catch:{ Exception -> 0x020e }
            r12.n = r0     // Catch:{ Exception -> 0x020e }
        L_0x012c:
            r0 = 0
            r4 = r0
        L_0x012e:
            int r5 = r13.size()
            if (r4 >= r5) goto L_0x01fe
            java.lang.Object r5 = r13.get(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5
            if (r5 == 0) goto L_0x01fa
            int r6 = r12.o
            if (r6 == r1) goto L_0x0162
            if (r6 != r2) goto L_0x0143
            goto L_0x0162
        L_0x0143:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r5.getId()
            r6.append(r7)
            java.lang.String r7 = r5.getVideoUrlEncode()
            r6.append(r7)
            java.lang.String r7 = r5.getBidToken()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto L_0x0180
        L_0x0162:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r5.getRequestId()
            r6.append(r7)
            java.lang.String r7 = r5.getId()
            r6.append(r7)
            java.lang.String r7 = r5.getVideoUrlEncode()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
        L_0x0180:
            boolean r7 = r12.c(r5)
            if (r7 != 0) goto L_0x0191
            java.lang.String r7 = r5.getVideoUrlEncode()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0191
            goto L_0x01fa
        L_0x0191:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r7 = r12.h
            if (r7 == 0) goto L_0x01fa
            monitor-enter(r7)
            r8 = r0
        L_0x0197:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r9 = r12.h     // Catch:{ all -> 0x01f5 }
            int r9 = r9.size()     // Catch:{ all -> 0x01f5 }
            if (r8 >= r9) goto L_0x01d0
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r9 = r12.h     // Catch:{ all -> 0x01f5 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x01f5 }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x01f5 }
            if (r9 == 0) goto L_0x01cd
            boolean r10 = r9.containsKey(r6)     // Catch:{ all -> 0x01f5 }
            if (r10 == 0) goto L_0x01cd
            java.lang.Object r10 = r9.get(r6)     // Catch:{ all -> 0x01f5 }
            com.mbridge.msdk.videocommon.download.a r10 = (com.mbridge.msdk.videocommon.download.a) r10     // Catch:{ all -> 0x01f5 }
            r10.a((com.mbridge.msdk.foundation.entity.CampaignEx) r5)     // Catch:{ all -> 0x01f5 }
            int r11 = r12.n     // Catch:{ all -> 0x01f5 }
            r10.a((int) r11)     // Catch:{ all -> 0x01f5 }
            r10.a((boolean) r0)     // Catch:{ all -> 0x01f5 }
            r9.remove(r6)     // Catch:{ all -> 0x01f5 }
            r9.put(r6, r10)     // Catch:{ all -> 0x01f5 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r10 = r12.h     // Catch:{ all -> 0x01f5 }
            r10.set(r8, r9)     // Catch:{ all -> 0x01f5 }
            r8 = r3
            goto L_0x01d1
        L_0x01cd:
            int r8 = r8 + 1
            goto L_0x0197
        L_0x01d0:
            r8 = r0
        L_0x01d1:
            if (r8 != 0) goto L_0x01f5
            com.mbridge.msdk.videocommon.download.a r8 = new com.mbridge.msdk.videocommon.download.a     // Catch:{ all -> 0x01f5 }
            android.content.Context r9 = r12.i     // Catch:{ all -> 0x01f5 }
            java.lang.String r10 = r12.l     // Catch:{ all -> 0x01f5 }
            int r11 = r12.n     // Catch:{ all -> 0x01f5 }
            r8.<init>(r9, r5, r10, r11)     // Catch:{ all -> 0x01f5 }
            int r5 = r12.n     // Catch:{ all -> 0x01f5 }
            r8.a((int) r5)     // Catch:{ all -> 0x01f5 }
            int r5 = r12.o     // Catch:{ all -> 0x01f5 }
            r8.d((int) r5)     // Catch:{ all -> 0x01f5 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x01f5 }
            r5.<init>()     // Catch:{ all -> 0x01f5 }
            r5.put(r6, r8)     // Catch:{ all -> 0x01f5 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r6 = r12.h     // Catch:{ all -> 0x01f5 }
            r6.add(r5)     // Catch:{ all -> 0x01f5 }
        L_0x01f5:
            monitor-exit(r7)     // Catch:{ all -> 0x01f7 }
            goto L_0x01fa
        L_0x01f7:
            r13 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x01f7 }
            throw r13
        L_0x01fa:
            int r4 = r4 + 1
            goto L_0x012e
        L_0x01fe:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13 = r12.c
            if (r13 == 0) goto L_0x020d
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x020d
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13 = r12.c
            r13.clear()
        L_0x020d:
            return
        L_0x020e:
            java.lang.String r13 = "UnitCacheCtroller"
            java.lang.String r0 = "make sure your had put native video jar into your project"
            com.mbridge.msdk.foundation.tools.q.d(r13, r0)
        L_0x0215:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.k.b(java.util.List):void");
    }

    private void d() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.h;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    while (i2 < this.h.size()) {
                        Map map = this.h.get(i2);
                        for (Map.Entry value : map.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar != null) {
                                if (currentTimeMillis - aVar.c() > this.k * 1000 && aVar.f() == 1) {
                                    aVar.b("download timeout");
                                    aVar.a(this.n);
                                    aVar.m();
                                    this.h.remove(map);
                                    i2--;
                                }
                                if (!(aVar.f() == 1 || aVar.f() == 5 || aVar.f() == 0)) {
                                    aVar.m();
                                    this.h.remove(map);
                                    i2--;
                                }
                            }
                        }
                        i2++;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.h;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i2 = 0;
                    while (i2 < this.h.size()) {
                        Map map = this.h.get(i2);
                        for (Map.Entry value : map.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar != null) {
                                if (aVar.g() != null) {
                                    if (aVar.b()) {
                                        aVar.l();
                                        this.h.remove(map);
                                        i2--;
                                    }
                                }
                            }
                        }
                        i2++;
                    }
                }
            } catch (Throwable unused) {
                q.d("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    public final List<a> a(String str, int i2, boolean z, List<CampaignEx> list, boolean z2) {
        long j2;
        Iterator it;
        Iterator it2;
        int i3 = i2;
        boolean z3 = z2;
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.h;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i4 = 0;
                    while (i4 < this.h.size()) {
                        Map map = this.h.get(i4);
                        Iterator it3 = map.entrySet().iterator();
                        while (it3.hasNext()) {
                            a aVar = (a) ((Map.Entry) it3.next()).getValue();
                            if (aVar != null) {
                                if (aVar.g() != null) {
                                    CampaignEx g2 = aVar.g();
                                    boolean z4 = false;
                                    for (CampaignEx next : list) {
                                        if (g2 == null || next == null || TextUtils.isEmpty(g2.getRequestId()) || TextUtils.isEmpty(next.getRequestId())) {
                                            it2 = it3;
                                        } else {
                                            it2 = it3;
                                            if (g2.getId().equals(next.getId()) && g2.getRequestId().equals(next.getRequestId())) {
                                                z4 = true;
                                            }
                                        }
                                        it3 = it2;
                                    }
                                    it = it3;
                                    if (z4 && (!z || g2.isBidCampaign())) {
                                        if (z || !g2.isBidCampaign()) {
                                            String str2 = g2.getendcard_url();
                                            String videoUrlEncode = g2.getVideoUrlEncode();
                                            String str3 = "";
                                            if (!(g2 == null || g2.getRewardTemplateMode() == null)) {
                                                str3 = g2.getRewardTemplateMode().e();
                                            }
                                            g2.getRewardTemplateMode();
                                            if (i3 == 94 || i3 == 287) {
                                                if (TextUtils.isEmpty(str3) || str3.contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a(i3, g2, str3)) {
                                                    if (b(str2, g2)) {
                                                        if (aVar.b()) {
                                                            aVar.l();
                                                        } else if (x.a(videoUrlEncode)) {
                                                            arrayList.add(aVar);
                                                        } else if (a(aVar, b(g2), z3)) {
                                                            arrayList.add(aVar);
                                                        }
                                                    }
                                                }
                                            }
                                            boolean isEmpty = TextUtils.isEmpty(aVar.k());
                                            int f2 = aVar.f();
                                            if (f2 != 5) {
                                                long c2 = aVar.c();
                                                if (aVar.f() == 1) {
                                                    j2 = currentTimeMillis;
                                                    if (currentTimeMillis - c2 > this.k * 1000) {
                                                        aVar.b("download timeout");
                                                        aVar.m();
                                                        this.h.remove(map);
                                                        i4--;
                                                        if (i3 != 1) {
                                                            if (i3 == 94) {
                                                            }
                                                        }
                                                        it3 = it;
                                                        currentTimeMillis = j2;
                                                    }
                                                } else {
                                                    j2 = currentTimeMillis;
                                                }
                                                if (f2 != 4) {
                                                    if (f2 != 2) {
                                                        if (f2 == 1) {
                                                            if (!aVar.b()) {
                                                                if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY && a(aVar, b(g2), z3) && a(str2, g2)) {
                                                                    arrayList.add(aVar);
                                                                }
                                                            }
                                                            it3 = it;
                                                            currentTimeMillis = j2;
                                                        }
                                                        if ((i3 == 94 || i3 == 287) && a(aVar, b(g2), z3) && a(str2, g2)) {
                                                            arrayList.add(aVar);
                                                        }
                                                        it3 = it;
                                                        currentTimeMillis = j2;
                                                    }
                                                }
                                                this.h.remove(map);
                                                aVar.m();
                                                i4--;
                                                it3 = it;
                                                currentTimeMillis = j2;
                                            } else if (aVar.b()) {
                                                aVar.l();
                                                this.h.remove(map);
                                                i4--;
                                                it3 = it;
                                            } else if (!isEmpty) {
                                                aVar.a(0, 0);
                                                if (i3 == 95) {
                                                    arrayList.add(aVar);
                                                }
                                            } else if (!a(str2, g2)) {
                                                return null;
                                            } else {
                                                arrayList.add(aVar);
                                            }
                                        }
                                    }
                                    j2 = currentTimeMillis;
                                    it3 = it;
                                    currentTimeMillis = j2;
                                }
                            }
                            j2 = currentTimeMillis;
                            it = it3;
                            it3 = it;
                            currentTimeMillis = j2;
                        }
                        long j3 = currentTimeMillis;
                        i4++;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return e(campaignEx);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0268, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x026a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x026b, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0272, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:11:0x0026, B:14:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01da A[Catch:{ Exception -> 0x026a, all -> 0x0268 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073 A[Catch:{ Exception -> 0x026a, all -> 0x0268 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.download.a a(int r25, boolean r26) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r26
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r3 = r1.h
            r4 = 0
            if (r3 == 0) goto L_0x0273
            monitor-enter(r3)
            int r5 = r1.o     // Catch:{ Exception -> 0x026a }
            r6 = 287(0x11f, float:4.02E-43)
            r7 = 94
            r8 = 1
            if (r5 == r7) goto L_0x0028
            int r5 = r1.o     // Catch:{ Exception -> 0x026a }
            if (r5 != r6) goto L_0x001a
            goto L_0x0028
        L_0x001a:
            com.mbridge.msdk.videocommon.a.a r5 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x026a }
            java.lang.String r9 = r1.l     // Catch:{ Exception -> 0x026a }
            java.util.List r5 = r5.a((java.lang.String) r9, (int) r8)     // Catch:{ Exception -> 0x026a }
            if (r5 != 0) goto L_0x0066
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r4
        L_0x0028:
            com.mbridge.msdk.videocommon.a.a r5 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x026a }
            java.lang.String r9 = r1.l     // Catch:{ Exception -> 0x026a }
            java.util.List r5 = r5.a((java.lang.String) r9, (int) r8, (boolean) r2)     // Catch:{ Exception -> 0x026a }
            if (r5 == 0) goto L_0x003a
            int r9 = r5.size()     // Catch:{ Exception -> 0x026a }
            if (r9 != 0) goto L_0x004a
        L_0x003a:
            if (r0 == r7) goto L_0x003e
            if (r0 != r6) goto L_0x004a
        L_0x003e:
            com.mbridge.msdk.videocommon.a.a r5 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x026a }
            java.lang.String r9 = r1.l     // Catch:{ Exception -> 0x026a }
            java.lang.String r10 = ""
            java.util.List r5 = r5.c(r9, r8, r2, r10)     // Catch:{ Exception -> 0x026a }
        L_0x004a:
            if (r5 == 0) goto L_0x025e
            java.lang.String r9 = "UnitCacheCtroller"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026a }
            r10.<init>()     // Catch:{ Exception -> 0x026a }
            java.lang.String r11 = "UnitCache isReady campaignList = "
            r10.append(r11)     // Catch:{ Exception -> 0x026a }
            int r11 = r5.size()     // Catch:{ Exception -> 0x026a }
            r10.append(r11)     // Catch:{ Exception -> 0x026a }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x026a }
            com.mbridge.msdk.foundation.tools.q.a(r9, r10)     // Catch:{ Exception -> 0x026a }
        L_0x0066:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x026a }
            r12 = 0
        L_0x006b:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r13 = r1.h     // Catch:{ Exception -> 0x026a }
            int r13 = r13.size()     // Catch:{ Exception -> 0x026a }
            if (r12 >= r13) goto L_0x026e
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r13 = r1.h     // Catch:{ Exception -> 0x026a }
            java.lang.Object r13 = r13.get(r12)     // Catch:{ Exception -> 0x026a }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x026a }
            java.util.Set r14 = r13.entrySet()     // Catch:{ Exception -> 0x026a }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x026a }
        L_0x0083:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x026a }
            if (r15 == 0) goto L_0x0253
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x026a }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ Exception -> 0x026a }
            java.lang.Object r15 = r15.getValue()     // Catch:{ Exception -> 0x026a }
            com.mbridge.msdk.videocommon.download.a r15 = (com.mbridge.msdk.videocommon.download.a) r15     // Catch:{ Exception -> 0x026a }
            if (r15 == 0) goto L_0x0248
            com.mbridge.msdk.foundation.entity.CampaignEx r16 = r15.g()     // Catch:{ Exception -> 0x026a }
            if (r16 != 0) goto L_0x009f
            goto L_0x0248
        L_0x009f:
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r15.g()     // Catch:{ Exception -> 0x026a }
            java.util.Iterator r17 = r5.iterator()     // Catch:{ Exception -> 0x026a }
            r18 = 0
        L_0x00a9:
            boolean r19 = r17.hasNext()     // Catch:{ Exception -> 0x026a }
            if (r19 == 0) goto L_0x00c7
            java.lang.Object r19 = r17.next()     // Catch:{ Exception -> 0x026a }
            com.mbridge.msdk.foundation.entity.CampaignEx r19 = (com.mbridge.msdk.foundation.entity.CampaignEx) r19     // Catch:{ Exception -> 0x026a }
            java.lang.String r4 = r8.getId()     // Catch:{ Exception -> 0x026a }
            java.lang.String r11 = r19.getId()     // Catch:{ Exception -> 0x026a }
            boolean r4 = r4.equals(r11)     // Catch:{ Exception -> 0x026a }
            if (r4 == 0) goto L_0x00c5
            r18 = 1
        L_0x00c5:
            r4 = 0
            goto L_0x00a9
        L_0x00c7:
            if (r18 != 0) goto L_0x00ce
        L_0x00c9:
            r11 = r6
            r6 = r12
            r0 = 1
            goto L_0x024b
        L_0x00ce:
            if (r2 == 0) goto L_0x00d6
            boolean r4 = r8.isBidCampaign()     // Catch:{ Exception -> 0x026a }
            if (r4 == 0) goto L_0x00c9
        L_0x00d6:
            if (r2 != 0) goto L_0x00df
            boolean r4 = r8.isBidCampaign()     // Catch:{ Exception -> 0x026a }
            if (r4 == 0) goto L_0x00df
            goto L_0x00c9
        L_0x00df:
            java.lang.String r4 = r8.getendcard_url()     // Catch:{ Exception -> 0x026a }
            java.lang.String r11 = r8.getVideoUrlEncode()     // Catch:{ Exception -> 0x026a }
            java.lang.String r17 = ""
            if (r8 == 0) goto L_0x00f9
            com.mbridge.msdk.foundation.entity.CampaignEx$c r18 = r8.getRewardTemplateMode()     // Catch:{ Exception -> 0x026a }
            if (r18 == 0) goto L_0x00f9
            com.mbridge.msdk.foundation.entity.CampaignEx$c r17 = r8.getRewardTemplateMode()     // Catch:{ Exception -> 0x026a }
            java.lang.String r17 = r17.e()     // Catch:{ Exception -> 0x026a }
        L_0x00f9:
            r18 = r17
            r8.getRewardTemplateMode()     // Catch:{ Exception -> 0x026a }
            int r6 = r1.o     // Catch:{ Exception -> 0x026a }
            if (r6 == r7) goto L_0x0106
            r6 = 287(0x11f, float:4.02E-43)
            if (r0 != r6) goto L_0x014a
        L_0x0106:
            boolean r6 = android.text.TextUtils.isEmpty(r18)     // Catch:{ Exception -> 0x026a }
            if (r6 != 0) goto L_0x011f
            java.lang.String r6 = "cmpt=1"
            r7 = r18
            boolean r6 = r7.contains(r6)     // Catch:{ Exception -> 0x026a }
            if (r6 != 0) goto L_0x011f
            int r6 = r1.o     // Catch:{ Exception -> 0x026a }
            boolean r6 = r1.a((int) r6, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (java.lang.String) r7)     // Catch:{ Exception -> 0x026a }
            if (r6 != 0) goto L_0x011f
            goto L_0x012e
        L_0x011f:
            boolean r6 = r1.b((java.lang.String) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x026a }
            if (r6 == 0) goto L_0x014a
            boolean r6 = r15.b()     // Catch:{ Exception -> 0x026a }
            if (r6 == 0) goto L_0x0136
            r15.l()     // Catch:{ Exception -> 0x026a }
        L_0x012e:
            r6 = r12
            r0 = 1
            r7 = 94
            r11 = 287(0x11f, float:4.02E-43)
            goto L_0x024b
        L_0x0136:
            boolean r6 = com.mbridge.msdk.foundation.tools.x.a(r11)     // Catch:{ Exception -> 0x026a }
            if (r6 == 0) goto L_0x013e
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r15
        L_0x013e:
            int r6 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x026a }
            boolean r6 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r6)     // Catch:{ Exception -> 0x026a }
            if (r6 == 0) goto L_0x014a
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r15
        L_0x014a:
            java.lang.String r6 = r15.k()     // Catch:{ Exception -> 0x026a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x026a }
            int r7 = r15.f()     // Catch:{ Exception -> 0x026a }
            int r11 = r1.o     // Catch:{ Exception -> 0x026a }
            r0 = 298(0x12a, float:4.18E-43)
            if (r11 != r0) goto L_0x0168
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x026a }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r0)     // Catch:{ Exception -> 0x026a }
            if (r0 == 0) goto L_0x0168
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r15
        L_0x0168:
            r0 = 5
            r11 = 95
            if (r7 != r0) goto L_0x019e
            boolean r0 = r15.b()     // Catch:{ Exception -> 0x026a }
            if (r0 == 0) goto L_0x0187
            r15.l()     // Catch:{ Exception -> 0x026a }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.h     // Catch:{ Exception -> 0x026a }
            r0.remove(r13)     // Catch:{ Exception -> 0x026a }
        L_0x017b:
            int r12 = r12 + -1
        L_0x017d:
            r0 = r25
            r4 = 0
            r6 = 287(0x11f, float:4.02E-43)
            r7 = 94
            r8 = 1
            goto L_0x0083
        L_0x0187:
            if (r6 != 0) goto L_0x0193
            r0 = 0
            r15.a((int) r0, (int) r0)     // Catch:{ Exception -> 0x026a }
            int r4 = r1.o     // Catch:{ Exception -> 0x026a }
            if (r4 != r11) goto L_0x012e
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r15
        L_0x0193:
            boolean r0 = r1.a((java.lang.String) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x026a }
            if (r0 == 0) goto L_0x019b
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r15
        L_0x019b:
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            r2 = 0
            return r2
        L_0x019e:
            r0 = 0
            long r20 = r15.c()     // Catch:{ Exception -> 0x026a }
            int r6 = r15.f()     // Catch:{ Exception -> 0x026a }
            r0 = 1
            if (r6 != r0) goto L_0x01d2
            long r20 = r9 - r20
            r6 = r12
            long r11 = r1.k     // Catch:{ Exception -> 0x026a }
            r22 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r22
            int r11 = (r20 > r11 ? 1 : (r20 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x01d3
            java.lang.String r11 = "download timeout"
            r15.b((java.lang.String) r11)     // Catch:{ Exception -> 0x026a }
            r15.m()     // Catch:{ Exception -> 0x026a }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r11 = r1.h     // Catch:{ Exception -> 0x026a }
            r11.remove(r13)     // Catch:{ Exception -> 0x026a }
            int r12 = r6 + -1
            int r6 = r1.o     // Catch:{ Exception -> 0x026a }
            r11 = 1
            if (r6 == r11) goto L_0x017d
            int r6 = r1.o     // Catch:{ Exception -> 0x026a }
            r11 = 94
            if (r6 != r11) goto L_0x01d4
            goto L_0x017d
        L_0x01d2:
            r6 = r12
        L_0x01d3:
            r12 = r6
        L_0x01d4:
            int r6 = r1.o     // Catch:{ Exception -> 0x026a }
            r0 = 95
            if (r6 != r0) goto L_0x01eb
            boolean r0 = r15.b()     // Catch:{ Exception -> 0x026a }
            if (r0 == 0) goto L_0x01e9
            r15.l()     // Catch:{ Exception -> 0x026a }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.h     // Catch:{ Exception -> 0x026a }
            r0.remove(r13)     // Catch:{ Exception -> 0x026a }
            goto L_0x017b
        L_0x01e9:
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r15
        L_0x01eb:
            r0 = 4
            if (r7 == r0) goto L_0x0237
            r0 = 2
            if (r7 != r0) goto L_0x01f2
            goto L_0x0237
        L_0x01f2:
            r0 = 1
            if (r7 != r0) goto L_0x0216
            boolean r6 = r15.b()     // Catch:{ Exception -> 0x026a }
            if (r6 == 0) goto L_0x0200
            r7 = 94
            r11 = 287(0x11f, float:4.02E-43)
            goto L_0x0246
        L_0x0200:
            boolean r6 = com.mbridge.msdk.MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY     // Catch:{ Exception -> 0x026a }
            if (r6 != 0) goto L_0x0216
            int r6 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x026a }
            boolean r6 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r6)     // Catch:{ Exception -> 0x026a }
            if (r6 == 0) goto L_0x0216
            boolean r6 = r1.a((java.lang.String) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x026a }
            if (r6 == 0) goto L_0x0216
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r15
        L_0x0216:
            int r6 = r1.o     // Catch:{ Exception -> 0x026a }
            r7 = 94
            if (r6 == r7) goto L_0x0223
            int r6 = r1.o     // Catch:{ Exception -> 0x026a }
            r11 = 287(0x11f, float:4.02E-43)
            if (r6 != r11) goto L_0x0246
            goto L_0x0225
        L_0x0223:
            r11 = 287(0x11f, float:4.02E-43)
        L_0x0225:
            int r6 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x026a }
            boolean r6 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r6)     // Catch:{ Exception -> 0x026a }
            if (r6 == 0) goto L_0x0246
            boolean r4 = r1.a((java.lang.String) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x026a }
            if (r4 == 0) goto L_0x0246
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            return r15
        L_0x0237:
            r0 = 1
            r7 = 94
            r11 = 287(0x11f, float:4.02E-43)
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r4 = r1.h     // Catch:{ Exception -> 0x026a }
            r4.remove(r13)     // Catch:{ Exception -> 0x026a }
            r15.m()     // Catch:{ Exception -> 0x026a }
            int r12 = r12 + -1
        L_0x0246:
            r8 = r0
            goto L_0x024d
        L_0x0248:
            r11 = r6
            r0 = r8
            r6 = r12
        L_0x024b:
            r8 = r0
            r12 = r6
        L_0x024d:
            r6 = r11
            r4 = 0
            r0 = r25
            goto L_0x0083
        L_0x0253:
            r11 = r6
            r0 = r8
            r6 = r12
            int r12 = r6 + 1
            r6 = r11
            r4 = 0
            r0 = r25
            goto L_0x006b
        L_0x025e:
            java.lang.String r0 = "UnitCacheCtroller"
            java.lang.String r2 = "UnitCache isReady campaignList = 0"
            com.mbridge.msdk.foundation.tools.q.a(r0, r2)     // Catch:{ Exception -> 0x026a }
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            r2 = 0
            return r2
        L_0x0268:
            r0 = move-exception
            goto L_0x0271
        L_0x026a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0268 }
        L_0x026e:
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            r2 = 0
            goto L_0x0274
        L_0x0271:
            monitor-exit(r3)     // Catch:{ all -> 0x0268 }
            throw r0
        L_0x0273:
            r2 = r4
        L_0x0274:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.k.a(int, boolean):com.mbridge.msdk.videocommon.download.a");
    }

    public static boolean a(a aVar, int i2) {
        long h2 = aVar.h();
        long e2 = aVar.e();
        if (TextUtils.isEmpty(aVar.a())) {
            q.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i2 == 0) {
            if (aVar.g() == null || TextUtils.isEmpty(aVar.g().getVideoUrlEncode())) {
                return false;
            }
            return true;
        } else if (e2 > 0 && h2 * 100 >= e2 * ((long) i2)) {
            if (i2 != 100 || aVar.f() == 5) {
                return true;
            }
            aVar.m();
            return false;
        }
        return false;
    }

    private static boolean a(a aVar, int i2, boolean z) {
        long h2 = aVar.h();
        long e2 = aVar.e();
        if (TextUtils.isEmpty(aVar.a())) {
            q.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx g2 = aVar.g();
        if (g2 != null) {
            if (g2.getRsIgnoreCheckRule() != null && g2.getRsIgnoreCheckRule().size() > 0 && g2.getRsIgnoreCheckRule().contains(0)) {
                q.b("UnitCacheCtroller", "Is not check video download status");
                return true;
            } else if (g2.getIsTimeoutCheckVideoStatus() == 1 && g2.getVideoCheckType() == 1) {
                return true;
            } else {
                if (z && g2.getVideoCheckType() == 1) {
                    if (i2 == 0) {
                        return true;
                    }
                    if (!(e2 == 0 && h2 == 0) && h2 >= ((long) (i2 / 100)) * e2) {
                        g2.setIsTimeoutCheckVideoStatus(1);
                        return true;
                    }
                }
            }
        }
        return a(aVar, i2);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
            if (campaignEx.isDynamicView()) {
                return true;
            }
            if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                q.b("UnitCacheCtroller", "Is not check endCard download status : " + str);
                return true;
            } else if (!x.a(str) && !b(str, campaignEx)) {
                return false;
            } else {
                return true;
            }
        } catch (Throwable th) {
            q.a("UnitCacheCtroller", th.getMessage(), th);
            return false;
        }
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !c(campaignEx)) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
            q.b("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } else if (!x.b(g.a().b(str)) && !x.b(h.a.a.b(str))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(int i2, CampaignEx campaignEx, String str) {
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
            q.b("UnitCacheCtroller", "Is not check template download status");
            return true;
        } else if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0 && g.a().b(str) == null) {
            return false;
        } else {
            return true;
        }
    }

    public final a b(int i2, boolean z) {
        try {
            return a(i2, z);
        } catch (Throwable th) {
            q.a("UnitCacheCtroller", th.getMessage(), th);
            return null;
        }
    }

    public final a a(String str) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.h;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                Iterator<Map<String, a>> it = this.h.iterator();
                while (it.hasNext()) {
                    Map next = it.next();
                    if (next != null && next.containsKey(str)) {
                        a aVar = (a) next.get(str);
                        return aVar;
                    }
                }
            } catch (Throwable unused) {
                q.d("UnitCacheCtroller", "failed to get campaignTast by cid");
            }
        }
        return null;
    }

    private boolean a(CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map next = it.next();
                if (next != null) {
                    for (Map.Entry value : next.entrySet()) {
                        if (((a) value.getValue()).f() == 1) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01b2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r16 = this;
            r1 = r16
            r16.d()
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r2 = r1.h
            if (r2 == 0) goto L_0x01f1
            monitor-enter(r2)
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.h     // Catch:{ all -> 0x01ee }
            boolean r0 = r1.a((java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>) r0)     // Catch:{ all -> 0x01ee }
            r3 = 1
            if (r0 != 0) goto L_0x0015
            r1.d = r3     // Catch:{ all -> 0x01ee }
        L_0x0015:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.h     // Catch:{ all -> 0x01ee }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01ee }
        L_0x001b:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x01ee }
            if (r4 == 0) goto L_0x01ec
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x01ee }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x01ee }
            if (r4 != 0) goto L_0x002a
            goto L_0x001b
        L_0x002a:
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x01ee }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x01ee }
        L_0x0032:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x01ee }
            if (r5 == 0) goto L_0x001b
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x01ee }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x01ee }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.videocommon.download.a r5 = (com.mbridge.msdk.videocommon.download.a) r5     // Catch:{ all -> 0x01ee }
            if (r5 != 0) goto L_0x0047
            goto L_0x0032
        L_0x0047:
            boolean r6 = r5.b()     // Catch:{ all -> 0x01ee }
            if (r6 == 0) goto L_0x004e
            goto L_0x0032
        L_0x004e:
            int r6 = r1.o     // Catch:{ all -> 0x01ee }
            r7 = 95
            if (r6 != r7) goto L_0x0056
            r1.d = r3     // Catch:{ all -> 0x01ee }
        L_0x0056:
            int r6 = r5.f()     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r5.g()     // Catch:{ all -> 0x01ee }
            if (r8 == 0) goto L_0x0072
            if (r6 != 0) goto L_0x0072
            com.mbridge.msdk.videocommon.download.c r6 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x01ee }
            java.lang.String r9 = r8.getId()     // Catch:{ all -> 0x01ee }
            java.lang.String r10 = r8.getVideoUrlEncode()     // Catch:{ all -> 0x01ee }
            int r6 = r6.b(r9, r10)     // Catch:{ all -> 0x01ee }
        L_0x0072:
            com.mbridge.msdk.videocommon.download.k$2 r9 = new com.mbridge.msdk.videocommon.download.k$2     // Catch:{ all -> 0x01ee }
            r9.<init>(r8)     // Catch:{ all -> 0x01ee }
            r5.a((com.mbridge.msdk.videocommon.listener.a) r9)     // Catch:{ all -> 0x01ee }
            int r9 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ all -> 0x01ee }
            int r10 = r1.o     // Catch:{ all -> 0x01ee }
            if (r10 != r3) goto L_0x0092
            com.mbridge.msdk.b.d r9 = r1.a     // Catch:{ all -> 0x01ee }
            if (r9 != 0) goto L_0x008e
            java.lang.String r9 = r1.l     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.b.d r9 = com.mbridge.msdk.b.d.d(r9)     // Catch:{ all -> 0x01ee }
            r1.a = r9     // Catch:{ all -> 0x01ee }
        L_0x008e:
            int r9 = r1.d(r8)     // Catch:{ all -> 0x01ee }
        L_0x0092:
            r5.c((int) r9)     // Catch:{ all -> 0x01ee }
            int r10 = r1.o     // Catch:{ all -> 0x01ee }
            r11 = 94
            r12 = 298(0x12a, float:4.18E-43)
            r13 = 287(0x11f, float:4.02E-43)
            if (r10 == r11) goto L_0x00f8
            int r10 = r1.o     // Catch:{ all -> 0x01ee }
            if (r10 == r13) goto L_0x00f8
            int r10 = r1.o     // Catch:{ all -> 0x01ee }
            if (r10 != r7) goto L_0x00a8
            goto L_0x00f8
        L_0x00a8:
            int r10 = r1.o     // Catch:{ all -> 0x01ee }
            if (r10 != r12) goto L_0x00d0
            com.mbridge.msdk.b.d r10 = r1.b     // Catch:{ all -> 0x01ee }
            if (r10 != 0) goto L_0x00c4
            com.mbridge.msdk.b.b r10 = com.mbridge.msdk.b.b.a()     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.foundation.controller.a r15 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x01ee }
            java.lang.String r15 = r15.h()     // Catch:{ all -> 0x01ee }
            java.lang.String r14 = r1.l     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.b.d r10 = r10.c(r15, r14)     // Catch:{ all -> 0x01ee }
            r1.b = r10     // Catch:{ all -> 0x01ee }
        L_0x00c4:
            com.mbridge.msdk.b.d r10 = r1.b     // Catch:{ all -> 0x01ee }
            if (r10 == 0) goto L_0x00d0
            com.mbridge.msdk.b.d r10 = r1.b     // Catch:{ all -> 0x01ee }
            int r10 = r10.f()     // Catch:{ all -> 0x01ee }
            r14 = r10
            goto L_0x00d1
        L_0x00d0:
            r14 = 0
        L_0x00d1:
            int r10 = r1.o     // Catch:{ all -> 0x01ee }
            if (r10 != r3) goto L_0x0123
            com.mbridge.msdk.b.d r10 = r1.a     // Catch:{ all -> 0x01ee }
            if (r10 != 0) goto L_0x00ed
            com.mbridge.msdk.b.b r10 = com.mbridge.msdk.b.b.a()     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.foundation.controller.a r15 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x01ee }
            java.lang.String r15 = r15.h()     // Catch:{ all -> 0x01ee }
            java.lang.String r7 = r1.l     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.b.d r7 = r10.c(r15, r7)     // Catch:{ all -> 0x01ee }
            r1.a = r7     // Catch:{ all -> 0x01ee }
        L_0x00ed:
            com.mbridge.msdk.b.d r7 = r1.a     // Catch:{ all -> 0x01ee }
            if (r7 == 0) goto L_0x0123
            com.mbridge.msdk.b.d r7 = r1.a     // Catch:{ all -> 0x01ee }
            int r14 = r7.f()     // Catch:{ all -> 0x01ee }
            goto L_0x0123
        L_0x00f8:
            com.mbridge.msdk.videocommon.d.c r7 = r1.m     // Catch:{ all -> 0x01ee }
            if (r7 != 0) goto L_0x0117
            com.mbridge.msdk.videocommon.d.b r7 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.foundation.controller.a r10 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x01ee }
            java.lang.String r10 = r10.h()     // Catch:{ all -> 0x01ee }
            java.lang.String r14 = r1.l     // Catch:{ all -> 0x01ee }
            int r15 = r1.o     // Catch:{ all -> 0x01ee }
            if (r15 != r13) goto L_0x0110
            r15 = r3
            goto L_0x0111
        L_0x0110:
            r15 = 0
        L_0x0111:
            com.mbridge.msdk.videocommon.d.c r7 = r7.a((java.lang.String) r10, (java.lang.String) r14, (boolean) r15)     // Catch:{ all -> 0x01ee }
            r1.m = r7     // Catch:{ all -> 0x01ee }
        L_0x0117:
            com.mbridge.msdk.videocommon.d.c r7 = r1.m     // Catch:{ all -> 0x01ee }
            if (r7 == 0) goto L_0x0122
            com.mbridge.msdk.videocommon.d.c r7 = r1.m     // Catch:{ all -> 0x01ee }
            int r14 = r7.q()     // Catch:{ all -> 0x01ee }
            goto L_0x0123
        L_0x0122:
            r14 = 0
        L_0x0123:
            r5.b((int) r14)     // Catch:{ all -> 0x01ee }
            if (r8 == 0) goto L_0x012d
            int r7 = r8.getVideoCtnType()     // Catch:{ all -> 0x01ee }
            goto L_0x012e
        L_0x012d:
            r7 = r3
        L_0x012e:
            r5.e((int) r7)     // Catch:{ all -> 0x01ee }
            java.lang.String r10 = "UnitCacheCtroller"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ee }
            r15.<init>()     // Catch:{ all -> 0x01ee }
            java.lang.String r13 = "ready_rate : "
            r15.append(r13)     // Catch:{ all -> 0x01ee }
            r15.append(r9)     // Catch:{ all -> 0x01ee }
            java.lang.String r13 = " cd_rate : "
            r15.append(r13)     // Catch:{ all -> 0x01ee }
            r15.append(r14)     // Catch:{ all -> 0x01ee }
            java.lang.String r13 = " videoCtnType : "
            r15.append(r13)     // Catch:{ all -> 0x01ee }
            r15.append(r7)     // Catch:{ all -> 0x01ee }
            java.lang.String r7 = r15.toString()     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.foundation.tools.q.d(r10, r7)     // Catch:{ all -> 0x01ee }
            int r7 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ all -> 0x01ee }
            boolean r7 = a((com.mbridge.msdk.videocommon.download.a) r5, (int) r7)     // Catch:{ all -> 0x01ee }
            if (r7 == 0) goto L_0x019b
            com.mbridge.msdk.videocommon.listener.a r7 = r1.e     // Catch:{ all -> 0x01ee }
            if (r7 == 0) goto L_0x0178
            int r7 = r1.o     // Catch:{ all -> 0x01ee }
            r10 = 297(0x129, float:4.16E-43)
            if (r7 == r10) goto L_0x016f
            int r7 = r1.o     // Catch:{ all -> 0x01ee }
            if (r7 != r12) goto L_0x0178
        L_0x016f:
            com.mbridge.msdk.videocommon.listener.a r7 = r1.e     // Catch:{ all -> 0x01ee }
            java.lang.String r10 = r8.getVideoUrlEncode()     // Catch:{ all -> 0x01ee }
            r7.a(r10)     // Catch:{ all -> 0x01ee }
        L_0x0178:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r7 = r1.f     // Catch:{ all -> 0x01ee }
            if (r7 == 0) goto L_0x019b
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r7 = r1.f     // Catch:{ all -> 0x01ee }
            int r7 = r7.size()     // Catch:{ all -> 0x01ee }
            if (r7 <= 0) goto L_0x019b
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r7 = r1.f     // Catch:{ all -> 0x01ee }
            java.lang.String r10 = r8.getRequestId()     // Catch:{ all -> 0x01ee }
            java.lang.Object r7 = r7.get(r10)     // Catch:{ all -> 0x01ee }
            com.mbridge.msdk.videocommon.listener.a r7 = (com.mbridge.msdk.videocommon.listener.a) r7     // Catch:{ all -> 0x01ee }
            if (r7 == 0) goto L_0x019b
            if (r8 == 0) goto L_0x019b
            java.lang.String r8 = r8.getVideoUrlEncode()     // Catch:{ all -> 0x01ee }
            r7.a(r8)     // Catch:{ all -> 0x01ee }
        L_0x019b:
            if (r6 == r3) goto L_0x0032
            r7 = 5
            if (r6 == r7) goto L_0x0032
            r7 = 4
            if (r6 == r7) goto L_0x0032
            android.content.Context r7 = r1.i     // Catch:{ all -> 0x01ee }
            int r7 = com.mbridge.msdk.foundation.tools.m.n(r7)     // Catch:{ all -> 0x01ee }
            r8 = 9
            r10 = 2
            if (r7 == r8) goto L_0x01b4
            int r7 = r1.n     // Catch:{ all -> 0x01ee }
            if (r7 != r10) goto L_0x01b4
            monitor-exit(r2)     // Catch:{ all -> 0x01ee }
            return
        L_0x01b4:
            if (r6 == r10) goto L_0x01bc
            boolean r6 = r1.d     // Catch:{ all -> 0x01ee }
            if (r6 != 0) goto L_0x01bc
            goto L_0x0032
        L_0x01bc:
            com.mbridge.msdk.videocommon.download.d r6 = r1.g     // Catch:{ all -> 0x01ee }
            r5.a((com.mbridge.msdk.videocommon.download.d) r6)     // Catch:{ all -> 0x01ee }
            boolean r6 = a((com.mbridge.msdk.videocommon.download.a) r5, (int) r9)     // Catch:{ all -> 0x01ee }
            if (r6 == 0) goto L_0x01d6
            int r6 = r1.o     // Catch:{ all -> 0x01ee }
            if (r6 == r11) goto L_0x01d1
            int r6 = r1.o     // Catch:{ all -> 0x01ee }
            r7 = 287(0x11f, float:4.02E-43)
            if (r6 != r7) goto L_0x0032
        L_0x01d1:
            r5.i()     // Catch:{ all -> 0x01ee }
            goto L_0x0032
        L_0x01d6:
            int r6 = r1.o     // Catch:{ all -> 0x01ee }
            if (r6 == r3) goto L_0x01e4
            int r6 = r1.o     // Catch:{ all -> 0x01ee }
            r7 = 95
            if (r6 == r7) goto L_0x01e4
            int r6 = r1.o     // Catch:{ all -> 0x01ee }
            if (r6 != r12) goto L_0x01e7
        L_0x01e4:
            r6 = 0
            r1.d = r6     // Catch:{ all -> 0x01ee }
        L_0x01e7:
            r5.i()     // Catch:{ all -> 0x01ee }
            goto L_0x0032
        L_0x01ec:
            monitor-exit(r2)     // Catch:{ all -> 0x01ee }
            goto L_0x01f1
        L_0x01ee:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x01ee }
            throw r0
        L_0x01f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.k.a():void");
    }

    public final void b() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.h;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    Iterator<Map<String, a>> it = this.h.iterator();
                    while (it.hasNext()) {
                        Map next = it.next();
                        if (next != null) {
                            for (Map.Entry value : next.entrySet()) {
                                a aVar = (a) value.getValue();
                                if (aVar != null) {
                                    if (aVar.f() == 1) {
                                        aVar.b("playing and stop download");
                                        aVar.m();
                                        this.h.remove(next);
                                        return;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, a>> c() {
        return this.h;
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private int d(CampaignEx campaignEx) {
        try {
            if (this.a != null) {
                return this.a.e();
            }
            return 100;
        } catch (Exception unused) {
            return 100;
        }
    }

    public final void b(String str) {
        try {
            synchronized (this.h) {
                if (!TextUtils.isEmpty(str) && this.h != null && this.h.size() > 0) {
                    Iterator<Map<String, a>> it = this.h.iterator();
                    while (it.hasNext()) {
                        Map next = it.next();
                        if (next != null) {
                            for (Map.Entry entry : next.entrySet()) {
                                if (entry != null && TextUtils.equals((CharSequence) entry.getKey(), str)) {
                                    this.h.remove(next);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private int e(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.b == null) {
                    this.b = b.a().c(com.mbridge.msdk.foundation.controller.a.e().h(), this.l);
                }
                return this.b.e();
            } else if (campaignEx.getAdType() == 42) {
                return d((CampaignEx) null);
            } else {
                if (this.m == null) {
                    this.m = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.l, false);
                }
                return this.m.p();
            }
        } catch (Throwable th) {
            q.a("UnitCacheCtroller", th.getMessage(), th);
            return 100;
        }
    }
}
