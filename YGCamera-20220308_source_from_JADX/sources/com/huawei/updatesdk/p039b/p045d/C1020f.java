package com.huawei.updatesdk.p039b.p045d;

import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0990a;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0993c;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d;
import com.huawei.updatesdk.p039b.p043b.C1005c;
import com.huawei.updatesdk.p039b.p048g.C1033b;
import com.huawei.updatesdk.service.appmgr.bean.C1054a;
import com.huawei.updatesdk.service.appmgr.bean.C1055b;
import com.huawei.updatesdk.service.otaupdate.C1079b;
import com.huawei.updatesdk.service.otaupdate.C1085f;

/* renamed from: com.huawei.updatesdk.b.d.f */
public class C1020f {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static C1079b f1384a;

    /* renamed from: com.huawei.updatesdk.b.d.f$b */
    private static class C1022b implements C0990a {
        private C1022b() {
        }

        /* renamed from: a */
        public void mo14912a(C0993c cVar, C0994d dVar) {
        }

        /* renamed from: b */
        public void mo14913b(C0993c cVar, C0994d dVar) {
            if (C1020f.f1384a != null) {
                if (dVar instanceof C1055b) {
                    C1055b bVar = (C1055b) dVar;
                    if (dVar.mo14934d() != 0 || dVar.mo14935e() != 0) {
                        C1020f.f1384a.mo15155b(dVar.mo14934d());
                    } else if (bVar.mo15134g() == null) {
                        C1020f.f1384a.mo15153a(dVar.mo14934d());
                    } else {
                        C1020f.f1384a.mo15154a(bVar.mo15134g());
                    }
                } else {
                    C1020f.f1384a.mo15153a(dVar.mo14934d());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1907a(C1079b bVar) {
        f1384a = bVar;
    }

    /* renamed from: a */
    public static void m1908a(boolean z) {
        C1033b.m1945a((C1005c) new C1054a(z ? C1085f.m2106f().mo15205c() : null), (C0990a) new C1022b());
    }
}
