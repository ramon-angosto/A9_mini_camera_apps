package com.bytedance.sdk.openadsdk.core.video.d;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.c.c;
import com.bytedance.sdk.component.b.a.f;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.c.c.b.i;
import com.bytedance.sdk.openadsdk.c.c.b.j;
import com.bytedance.sdk.openadsdk.c.c.b.k;
import com.bytedance.sdk.openadsdk.c.c.b.l;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.y;
import org.json.JSONObject;

/* compiled from: VideoPreloadFactory */
public class a {
    public static final com.bykv.vk.openvk.component.video.api.e.a a = new com.bykv.vk.openvk.component.video.a.a.b.a();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.bytedance.sdk.openadsdk.core.model.n} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.bykv.vk.openvk.component.video.api.c.c r13, com.bykv.vk.openvk.component.video.api.e.a.C0022a r14) {
        /*
            int r0 = r13.b()
            if (r0 > 0) goto L_0x000c
            boolean r0 = r13.i()
            if (r0 == 0) goto L_0x0013
        L_0x000c:
            int r0 = r13.m()
            r1 = -2
            if (r0 != r1) goto L_0x0014
        L_0x0013:
            return
        L_0x0014:
            r0 = 6000(0x1770, float:8.408E-42)
            r13.d((int) r0)
            r13.e((int) r0)
            r13.f(r0)
            java.lang.String r0 = "material_meta"
            java.lang.Object r1 = r13.e((java.lang.String) r0)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r13.e((java.lang.String) r0)
            boolean r1 = r1 instanceof com.bytedance.sdk.openadsdk.core.model.n
            if (r1 == 0) goto L_0x0033
            r1 = r3
            goto L_0x0034
        L_0x0033:
            r1 = r2
        L_0x0034:
            java.lang.String r4 = "ad_slot"
            java.lang.Object r5 = r13.e((java.lang.String) r4)
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r13.e((java.lang.String) r4)
            boolean r5 = r5 instanceof com.bytedance.sdk.openadsdk.AdSlot
            if (r5 == 0) goto L_0x0045
            r2 = r3
        L_0x0045:
            r5 = 0
            if (r1 == 0) goto L_0x005b
            if (r2 == 0) goto L_0x005b
            java.lang.Object r0 = r13.e((java.lang.String) r0)
            r5 = r0
            com.bytedance.sdk.openadsdk.core.model.n r5 = (com.bytedance.sdk.openadsdk.core.model.n) r5
            java.lang.Object r0 = r13.e((java.lang.String) r4)
            com.bytedance.sdk.openadsdk.AdSlot r0 = (com.bytedance.sdk.openadsdk.AdSlot) r0
            b(r13, r5, r0)
            goto L_0x005c
        L_0x005b:
            r0 = r5
        L_0x005c:
            long r1 = android.os.SystemClock.elapsedRealtime()
            com.bytedance.sdk.openadsdk.core.video.d.a$1 r4 = new com.bytedance.sdk.openadsdk.core.video.d.a$1
            r6 = r4
            r7 = r14
            r8 = r5
            r9 = r0
            r10 = r1
            r12 = r13
            r6.<init>(r7, r8, r9, r10, r12)
            java.lang.String r6 = r13.k()
            boolean r6 = a((java.lang.String) r6)
            if (r6 != 0) goto L_0x00a1
            if (r14 == 0) goto L_0x0091
            r3 = 404(0x194, float:5.66E-43)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "unexpected url: "
            r4.append(r6)
            java.lang.String r6 = r13.k()
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r14.a(r13, r3, r4)
        L_0x0091:
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r9 = r3 - r1
            r11 = -1
            java.lang.String r12 = "video url is invalid"
            r6 = r13
            r7 = r5
            r8 = r0
            b(r6, r7, r8, r9, r11, r12)
            return
        L_0x00a1:
            int r14 = r13.m()
            if (r14 != r3) goto L_0x00a8
            goto L_0x00ca
        L_0x00a8:
            int r14 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r14 < r0) goto L_0x00c3
            com.bykv.vk.openvk.component.video.api.e.a r14 = a     // Catch:{ Exception -> 0x00b8 }
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ Exception -> 0x00b8 }
            r14.a(r0, r13, r4)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00ca
        L_0x00b8:
            r13 = move-exception
            java.lang.String r13 = r13.getMessage()
            java.lang.String r14 = "VideoPreloadUtils"
            com.bytedance.sdk.component.utils.l.d(r14, r13)
            goto L_0x00ca
        L_0x00c3:
            com.bykv.vk.openvk.component.video.a.b.f.a r14 = com.bykv.vk.openvk.component.video.a.b.f.a.a()
            r14.a(r13)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.d.a.a(com.bykv.vk.openvk.component.video.api.c.c, com.bykv.vk.openvk.component.video.api.e.a$a):void");
    }

    private static boolean a(c cVar) {
        return Build.VERSION.SDK_INT >= 23 || cVar.m() != 0;
    }

    private static void b(c cVar, n nVar, AdSlot adSlot) {
        if (a(cVar)) {
            com.bytedance.sdk.openadsdk.c.c.a.a.a((com.bytedance.sdk.openadsdk.c.c.b.a<k>) new com.bytedance.sdk.openadsdk.c.c.b.a(nVar, y.b(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.c.c.a.a.a(nVar, (String) null, -1, cVar.m()), new k(cVar.k(), cVar.i() ? cVar.h() : (long) cVar.b())));
        }
    }

    /* access modifiers changed from: private */
    public static void b(c cVar, n nVar, AdSlot adSlot, long j, int i, String str) {
        if (a(cVar)) {
            String b = y.b(adSlot.getDurationSlotType());
            JSONObject a2 = com.bytedance.sdk.openadsdk.c.c.a.a.a(nVar, (String) null, -1, cVar.m());
            j jVar = new j();
            jVar.a(cVar.k());
            jVar.a((long) cVar.b());
            jVar.b(j);
            jVar.a(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jVar.b(str);
            jVar.c("");
            com.bytedance.sdk.openadsdk.c.c.a.a.c((com.bytedance.sdk.openadsdk.c.c.b.a<j>) new com.bytedance.sdk.openadsdk.c.c.b.a(nVar, b, a2, jVar));
        }
    }

    /* access modifiers changed from: private */
    public static void b(c cVar, n nVar, AdSlot adSlot, long j) {
        if (a(cVar)) {
            String b = y.b(adSlot.getDurationSlotType());
            JSONObject a2 = com.bytedance.sdk.openadsdk.c.c.a.a.a(nVar, (String) null, -1, cVar.m());
            l lVar = new l();
            lVar.a(cVar.k());
            lVar.a((long) cVar.b());
            lVar.b(j);
            if (cVar.q() == 1) {
                lVar.c(1);
            } else {
                lVar.c(0);
            }
            com.bytedance.sdk.openadsdk.c.c.a.a.b((com.bytedance.sdk.openadsdk.c.c.b.a<l>) new com.bytedance.sdk.openadsdk.c.c.b.a(nVar, b, a2, lVar));
        }
    }

    /* access modifiers changed from: private */
    public static void c(c cVar, n nVar, AdSlot adSlot) {
        if (a(cVar)) {
            com.bytedance.sdk.openadsdk.c.c.a.a.d((com.bytedance.sdk.openadsdk.c.c.b.a<i>) new com.bytedance.sdk.openadsdk.c.c.b.a(nVar, y.b(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.c.c.a.a.a(nVar, (String) null, -1, cVar.m()), new i(cVar.k(), (long) cVar.b())));
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str = "http:" + str.substring(3);
        } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
            str = "https:" + str.substring(4);
        }
        if (f.c(str) == null) {
            return false;
        }
        return true;
    }
}
