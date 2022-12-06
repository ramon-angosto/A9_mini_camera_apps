package com.xiaomi.push.service;

import com.xiaomi.push.C1623an;
import com.xiaomi.push.service.C2027bo;

/* renamed from: com.xiaomi.push.service.bp */
class C2029bp extends C1623an.C1625b {

    /* renamed from: a */
    final /* synthetic */ C2027bo f3836a;

    /* renamed from: a */
    boolean f3837a = false;

    C2029bp(C2027bo boVar) {
        this.f3836a = boVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039 A[Catch:{ Exception -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17228b() {
        /*
            r3 = this;
            android.content.Context r0 = com.xiaomi.push.C2087u.m5371a()     // Catch:{ Exception -> 0x0047 }
            com.xiaomi.push.service.a r0 = com.xiaomi.push.service.C1966a.m4862a((android.content.Context) r0)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r0 = r0.mo18436a()     // Catch:{ Exception -> 0x0047 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0047 }
            if (r1 != 0) goto L_0x0022
            com.xiaomi.push.p r1 = com.xiaomi.push.C1941p.China     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = r1.name()     // Catch:{ Exception -> 0x0047 }
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0047 }
            if (r0 == 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            java.lang.String r0 = "https://resolver.msg.global.xiaomi.net/psc/?t=a"
            goto L_0x0024
        L_0x0022:
            java.lang.String r0 = "https://resolver.msg.xiaomi.net/psc/?t=a"
        L_0x0024:
            android.content.Context r1 = com.xiaomi.push.C2087u.m5371a()     // Catch:{ Exception -> 0x0047 }
            r2 = 0
            java.lang.String r0 = com.xiaomi.push.C1708cy.m2951a((android.content.Context) r1, (java.lang.String) r0, (java.util.List<com.xiaomi.push.C1652bh>) r2)     // Catch:{ Exception -> 0x0047 }
            r1 = 10
            byte[] r0 = android.util.Base64.decode(r0, r1)     // Catch:{ Exception -> 0x0047 }
            com.xiaomi.push.ec$a r0 = com.xiaomi.push.C1745ec.C1746a.m3088a((byte[]) r0)     // Catch:{ Exception -> 0x0047 }
            if (r0 == 0) goto L_0x0060
            com.xiaomi.push.service.bo r1 = r3.f3836a     // Catch:{ Exception -> 0x0047 }
            com.xiaomi.push.C1745ec.C1746a unused = r1.f3834a = r0     // Catch:{ Exception -> 0x0047 }
            r0 = 1
            r3.f3837a = r0     // Catch:{ Exception -> 0x0047 }
            com.xiaomi.push.service.bo r0 = r3.f3836a     // Catch:{ Exception -> 0x0047 }
            com.xiaomi.push.service.C2027bo.m5147a((com.xiaomi.push.service.C2027bo) r0)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0060
        L_0x0047:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "fetch config failure: "
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2029bp.mo17228b():void");
    }

    /* renamed from: c */
    public void mo17229c() {
        C2027bo.C2028a[] aVarArr;
        C1623an.C1625b unused = this.f3836a.f3833a = null;
        if (this.f3837a) {
            synchronized (this.f3836a) {
                aVarArr = (C2027bo.C2028a[]) C2027bo.m5147a(this.f3836a).toArray(new C2027bo.C2028a[C2027bo.m5147a(this.f3836a).size()]);
            }
            for (C2027bo.C2028a a : aVarArr) {
                a.mo18499a(C2027bo.m5147a(this.f3836a));
            }
        }
    }
}
