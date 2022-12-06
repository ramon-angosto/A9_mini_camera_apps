package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.listener.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DownLoadManager */
public class c {
    private static c a;
    private ThreadPoolExecutor b = new ThreadPoolExecutor(5, 15, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
    private boolean c = false;
    private ConcurrentHashMap<String, k> d = new ConcurrentHashMap<>();
    private Map<String, List<Map<String, a>>> e;
    private Map<String, List<CampaignEx>> f;
    private Map<String, List<a>> g;

    private c() {
        this.b.allowCoreThreadTimeOut(true);
    }

    public static c getInstance() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public final a a(String str, String str2) {
        k c2 = c(str);
        if (c2 != null) {
            return c2.a(str2);
        }
        return null;
    }

    public final List<CampaignEx> a(String str) {
        Map<String, List<CampaignEx>> map = this.f;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f.get(str);
    }

    public final List<a> b(String str) {
        Map<String, List<a>> map = this.g;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.g.get(str);
    }

    public final k c(String str) {
        ConcurrentHashMap<String, k> concurrentHashMap = this.d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.d.get(str);
    }

    public final boolean a(int i, String str, boolean z) {
        try {
            k c2 = c(str);
            if (c2 == null || c2.a(i, z) == null) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list) {
        return a(i, str, z, i2, z2, i3, list, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008b, code lost:
        if (r4.size() > 0) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ee, code lost:
        if (r4.size() >= r17) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0186, code lost:
        if (r4.size() > 0) goto L_0x0188;
     */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0246  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r14, java.lang.String r15, boolean r16, int r17, boolean r18, int r19, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r20, boolean r21) {
        /*
            r13 = this;
            r1 = r13
            r0 = r15
            r8 = r20
            r9 = 0
            if (r8 == 0) goto L_0x0249
            int r2 = r20.size()     // Catch:{ Exception -> 0x0241 }
            if (r2 != 0) goto L_0x000f
            goto L_0x0249
        L_0x000f:
            com.mbridge.msdk.videocommon.download.k r2 = r13.c(r15)     // Catch:{ Exception -> 0x0241 }
            if (r2 == 0) goto L_0x0249
            r3 = r15
            r4 = r14
            r5 = r16
            r6 = r20
            r7 = r21
            java.util.List r2 = r2.a(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0241 }
            r3 = 1
            if (r2 == 0) goto L_0x0189
            int r4 = r2.size()     // Catch:{ Exception -> 0x0241 }
            if (r4 != 0) goto L_0x002c
            goto L_0x0189
        L_0x002c:
            if (r18 == 0) goto L_0x012b
            if (r19 != 0) goto L_0x0091
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0241 }
            r4.<init>()     // Catch:{ Exception -> 0x0241 }
            java.util.Iterator r5 = r2.iterator()     // Catch:{ Exception -> 0x0241 }
        L_0x0039:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0241 }
            if (r6 == 0) goto L_0x0087
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ Exception -> 0x0241 }
            java.util.Iterator r7 = r20.iterator()     // Catch:{ Exception -> 0x0241 }
        L_0x0049:
            boolean r10 = r7.hasNext()     // Catch:{ Exception -> 0x0241 }
            if (r10 == 0) goto L_0x0039
            java.lang.Object r10 = r7.next()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x0241 }
            if (r6 == 0) goto L_0x0049
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.g()     // Catch:{ Exception -> 0x0241 }
            if (r11 == 0) goto L_0x0049
            if (r10 == 0) goto L_0x0049
            java.lang.String r11 = r10.getId()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r6.g()     // Catch:{ Exception -> 0x0241 }
            java.lang.String r12 = r12.getId()     // Catch:{ Exception -> 0x0241 }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x0241 }
            if (r11 == 0) goto L_0x0049
            java.lang.String r10 = r10.getRequestId()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.g()     // Catch:{ Exception -> 0x0241 }
            java.lang.String r11 = r11.getRequestId()     // Catch:{ Exception -> 0x0241 }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0241 }
            if (r10 == 0) goto L_0x0049
            r4.add(r6)     // Catch:{ Exception -> 0x0241 }
            goto L_0x0049
        L_0x0087:
            int r4 = r4.size()     // Catch:{ Exception -> 0x0241 }
            if (r4 <= 0) goto L_0x008f
        L_0x008d:
            r4 = r3
            goto L_0x00f1
        L_0x008f:
            r4 = r9
            goto L_0x00f1
        L_0x0091:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0241 }
            r4.<init>()     // Catch:{ Exception -> 0x0241 }
            java.util.Iterator r5 = r2.iterator()     // Catch:{ Exception -> 0x0241 }
        L_0x009a:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0241 }
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ Exception -> 0x0241 }
            java.util.Iterator r7 = r20.iterator()     // Catch:{ Exception -> 0x0241 }
        L_0x00aa:
            boolean r10 = r7.hasNext()     // Catch:{ Exception -> 0x0241 }
            if (r10 == 0) goto L_0x009a
            java.lang.Object r10 = r7.next()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x0241 }
            if (r6 == 0) goto L_0x00aa
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.g()     // Catch:{ Exception -> 0x0241 }
            if (r11 == 0) goto L_0x00aa
            if (r10 == 0) goto L_0x00aa
            java.lang.String r11 = r10.getId()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r6.g()     // Catch:{ Exception -> 0x0241 }
            java.lang.String r12 = r12.getId()     // Catch:{ Exception -> 0x0241 }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x0241 }
            if (r11 == 0) goto L_0x00aa
            java.lang.String r10 = r10.getRequestId()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.g()     // Catch:{ Exception -> 0x0241 }
            java.lang.String r11 = r11.getRequestId()     // Catch:{ Exception -> 0x0241 }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0241 }
            if (r10 == 0) goto L_0x00aa
            r4.add(r6)     // Catch:{ Exception -> 0x0241 }
            goto L_0x00aa
        L_0x00e8:
            int r4 = r4.size()     // Catch:{ Exception -> 0x0241 }
            r5 = r17
            if (r4 < r5) goto L_0x008f
            goto L_0x008d
        L_0x00f1:
            int r5 = r20.size()     // Catch:{ Exception -> 0x0127 }
            if (r5 <= 0) goto L_0x0125
            java.lang.Object r5 = r8.get(r9)     // Catch:{ Exception -> 0x0127 }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5     // Catch:{ Exception -> 0x0127 }
            if (r5 == 0) goto L_0x0125
            java.util.ArrayList r6 = r5.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x0125
            java.util.ArrayList r6 = r5.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0127 }
            int r6 = r6.size()     // Catch:{ Exception -> 0x0127 }
            if (r6 <= 0) goto L_0x0125
            java.util.ArrayList r5 = r5.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0127 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0127 }
            boolean r5 = r5.contains(r6)     // Catch:{ Exception -> 0x0127 }
            if (r5 == 0) goto L_0x0125
            java.lang.String r5 = "DownLoadManager"
            java.lang.String r6 = "Is not check video download status with TPL"
            com.mbridge.msdk.foundation.tools.q.b(r5, r6)     // Catch:{ Exception -> 0x0127 }
            goto L_0x0188
        L_0x0125:
            r9 = r4
            goto L_0x0189
        L_0x0127:
            r0 = move-exception
            r9 = r4
            goto L_0x0242
        L_0x012b:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0241 }
            r4.<init>()     // Catch:{ Exception -> 0x0241 }
            java.util.Iterator r5 = r2.iterator()     // Catch:{ Exception -> 0x0241 }
        L_0x0134:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0241 }
            if (r6 == 0) goto L_0x0182
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ Exception -> 0x0241 }
            java.util.Iterator r7 = r20.iterator()     // Catch:{ Exception -> 0x0241 }
        L_0x0144:
            boolean r10 = r7.hasNext()     // Catch:{ Exception -> 0x0241 }
            if (r10 == 0) goto L_0x0134
            java.lang.Object r10 = r7.next()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x0241 }
            if (r6 == 0) goto L_0x0144
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.g()     // Catch:{ Exception -> 0x0241 }
            if (r11 == 0) goto L_0x0144
            if (r10 == 0) goto L_0x0144
            java.lang.String r11 = r10.getId()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r6.g()     // Catch:{ Exception -> 0x0241 }
            java.lang.String r12 = r12.getId()     // Catch:{ Exception -> 0x0241 }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x0241 }
            if (r11 == 0) goto L_0x0144
            java.lang.String r10 = r10.getRequestId()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.g()     // Catch:{ Exception -> 0x0241 }
            java.lang.String r11 = r11.getRequestId()     // Catch:{ Exception -> 0x0241 }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x0241 }
            if (r10 == 0) goto L_0x0144
            r4.add(r6)     // Catch:{ Exception -> 0x0241 }
            goto L_0x0144
        L_0x0182:
            int r4 = r4.size()     // Catch:{ Exception -> 0x0241 }
            if (r4 <= 0) goto L_0x0189
        L_0x0188:
            r9 = r3
        L_0x0189:
            if (r9 == 0) goto L_0x0249
            java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r3 = r1.e     // Catch:{ Exception -> 0x0241 }
            if (r3 != 0) goto L_0x0197
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0241 }
            r3.<init>()     // Catch:{ Exception -> 0x0241 }
            r1.e = r3     // Catch:{ Exception -> 0x0241 }
            goto L_0x01a4
        L_0x0197:
            java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r3 = r1.e     // Catch:{ Exception -> 0x0241 }
            boolean r3 = r3.containsKey(r15)     // Catch:{ Exception -> 0x0241 }
            if (r3 == 0) goto L_0x01a4
            java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r3 = r1.e     // Catch:{ Exception -> 0x0241 }
            r3.remove(r15)     // Catch:{ Exception -> 0x0241 }
        L_0x01a4:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.videocommon.download.a>> r3 = r1.g     // Catch:{ Exception -> 0x0241 }
            if (r3 != 0) goto L_0x01b0
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0241 }
            r3.<init>()     // Catch:{ Exception -> 0x0241 }
            r1.g = r3     // Catch:{ Exception -> 0x0241 }
            goto L_0x01bd
        L_0x01b0:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.videocommon.download.a>> r3 = r1.g     // Catch:{ Exception -> 0x0241 }
            boolean r3 = r3.containsKey(r15)     // Catch:{ Exception -> 0x0241 }
            if (r3 == 0) goto L_0x01bd
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.videocommon.download.a>> r3 = r1.g     // Catch:{ Exception -> 0x0241 }
            r3.remove(r15)     // Catch:{ Exception -> 0x0241 }
        L_0x01bd:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>> r3 = r1.f     // Catch:{ Exception -> 0x0241 }
            if (r3 != 0) goto L_0x01c9
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0241 }
            r3.<init>()     // Catch:{ Exception -> 0x0241 }
            r1.f = r3     // Catch:{ Exception -> 0x0241 }
            goto L_0x01d6
        L_0x01c9:
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>> r3 = r1.f     // Catch:{ Exception -> 0x0241 }
            boolean r3 = r3.containsKey(r15)     // Catch:{ Exception -> 0x0241 }
            if (r3 == 0) goto L_0x01d6
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>> r3 = r1.f     // Catch:{ Exception -> 0x0241 }
            r3.remove(r15)     // Catch:{ Exception -> 0x0241 }
        L_0x01d6:
            if (r2 == 0) goto L_0x0249
            int r3 = r2.size()     // Catch:{ Exception -> 0x0241 }
            if (r3 <= 0) goto L_0x0249
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0241 }
            r3.<init>()     // Catch:{ Exception -> 0x0241 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0241 }
            r4.<init>()     // Catch:{ Exception -> 0x0241 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0241 }
            r5.<init>()     // Catch:{ Exception -> 0x0241 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0241 }
        L_0x01f1:
            boolean r6 = r2.hasNext()     // Catch:{ Exception -> 0x0241 }
            if (r6 == 0) goto L_0x0231
            java.lang.Object r6 = r2.next()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ Exception -> 0x0241 }
            java.util.concurrent.ConcurrentHashMap r7 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x0241 }
            r7.<init>()     // Catch:{ Exception -> 0x0241 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r6.g()     // Catch:{ Exception -> 0x0241 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0241 }
            r10.<init>()     // Catch:{ Exception -> 0x0241 }
            java.lang.String r11 = r8.getId()     // Catch:{ Exception -> 0x0241 }
            r10.append(r11)     // Catch:{ Exception -> 0x0241 }
            java.lang.String r11 = r8.getVideoUrlEncode()     // Catch:{ Exception -> 0x0241 }
            r10.append(r11)     // Catch:{ Exception -> 0x0241 }
            java.lang.String r11 = r8.getBidToken()     // Catch:{ Exception -> 0x0241 }
            r10.append(r11)     // Catch:{ Exception -> 0x0241 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0241 }
            r7.put(r10, r6)     // Catch:{ Exception -> 0x0241 }
            r3.add(r7)     // Catch:{ Exception -> 0x0241 }
            r4.add(r8)     // Catch:{ Exception -> 0x0241 }
            r5.add(r6)     // Catch:{ Exception -> 0x0241 }
            goto L_0x01f1
        L_0x0231:
            java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r2 = r1.e     // Catch:{ Exception -> 0x0241 }
            r2.put(r15, r3)     // Catch:{ Exception -> 0x0241 }
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>> r2 = r1.f     // Catch:{ Exception -> 0x0241 }
            r2.put(r15, r4)     // Catch:{ Exception -> 0x0241 }
            java.util.Map<java.lang.String, java.util.List<com.mbridge.msdk.videocommon.download.a>> r2 = r1.g     // Catch:{ Exception -> 0x0241 }
            r2.put(r15, r5)     // Catch:{ Exception -> 0x0241 }
            goto L_0x0249
        L_0x0241:
            r0 = move-exception
        L_0x0242:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x0249
            r0.printStackTrace()
        L_0x0249:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.c.a(int, java.lang.String, boolean, int, boolean, int, java.util.List, boolean):boolean");
    }

    public void load(String str) {
        k c2 = c(str);
        if (c2 != null) {
            c2.a();
        }
    }

    public k createUnitCache(Context context, String str, List<CampaignEx> list, int i, a aVar) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return null;
        }
        if (this.d.containsKey(str)) {
            k kVar = this.d.get(str);
            if (i == 94 || i == 287) {
                kVar.a(list.get(0).getRequestId(), aVar);
            } else {
                kVar.a(aVar);
            }
            kVar.a(list);
            return kVar;
        }
        k kVar2 = new k(context, list, (ExecutorService) this.b, str, i);
        if (aVar != null) {
            kVar2.a(aVar);
        }
        this.d.put(str, kVar2);
        return kVar2;
    }

    public k createUnitCache(Context context, String str, CampaignEx campaignEx, int i, a aVar) {
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.d.containsKey(str)) {
            k kVar = this.d.get(str);
            if (i == 94 || i == 287) {
                kVar.a(campaignEx.getRequestId(), aVar);
            } else {
                kVar.a(aVar);
            }
            kVar.a(campaignEx);
            return kVar;
        }
        k kVar2 = new k(context, campaignEx, (ExecutorService) this.b, str, i);
        if (aVar != null) {
            kVar2.a(aVar);
        }
        this.d.put(str, kVar2);
        return kVar2;
    }

    public final void a(boolean z) {
        this.c = z;
        ConcurrentHashMap<String, k> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, k> value : concurrentHashMap.entrySet()) {
                k kVar = (k) value.getValue();
                if (kVar != null) {
                    kVar.b();
                }
            }
        }
    }

    public final int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> c2;
        a aVar;
        CampaignEx g2;
        ConcurrentHashMap<String, k> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, k> value : concurrentHashMap.entrySet()) {
                k kVar = (k) value.getValue();
                if (!(kVar == null || (c2 = kVar.c()) == null)) {
                    int size = c2.size();
                    for (int i = 0; i < size; i++) {
                        Map map = c2.get(i);
                        if (map != null) {
                            Iterator it = map.entrySet().iterator();
                            if (!(!it.hasNext() || (aVar = (a) ((Map.Entry) it.next()).getValue()) == null || (g2 = aVar.g()) == null)) {
                                String videoUrlEncode = g2.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return aVar.f();
                                }
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return 0;
    }

    public final void b(boolean z) {
        if (!z) {
            this.c = false;
        } else if (this.c) {
            return;
        }
        ConcurrentHashMap<String, k> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, k> value : concurrentHashMap.entrySet()) {
                ((k) value.getValue()).a();
            }
        }
    }

    public final void a() {
        ConcurrentHashMap<String, k> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry next : concurrentHashMap.entrySet()) {
                k kVar = (k) next.getValue();
                String str = (String) next.getKey();
                try {
                    Class.forName("com.mbridge.msdk.videocommon.d.a");
                    com.mbridge.msdk.videocommon.d.c a2 = b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), str);
                    if (a2 != null) {
                        if (a2.u() == 2) {
                            kVar.b();
                        } else {
                            kVar.a();
                        }
                    }
                } catch (Exception e2) {
                    q.d("DownLoadManager", e2.getMessage());
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            d e3 = com.mbridge.msdk.b.b.a().e(com.mbridge.msdk.foundation.controller.a.e().h(), str);
                            if (e3 == null) {
                                e3 = d.e(str);
                            }
                            if (e3.j() == 2) {
                                kVar.b();
                            } else {
                                kVar.a();
                            }
                        }
                    } catch (Exception e4) {
                        q.d("DownLoadManager", e4.getMessage());
                    }
                }
            }
        }
    }
}
