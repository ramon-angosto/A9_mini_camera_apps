package com.huawei.updatesdk.p039b.p047f;

import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p034b.p036b.C0987b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.f.c */
public final class C1030c {

    /* renamed from: a */
    private static C1030c f1389a = new C1030c();

    /* renamed from: b */
    private static C1028a f1390b = new C1031a();

    /* renamed from: com.huawei.updatesdk.b.f.c$a */
    static class C1031a implements C1028a {

        /* renamed from: a */
        private final List<C1029b> f1391a = new ArrayList();

        C1031a() {
        }

        /* renamed from: a */
        public void mo15003a(int i, C0987b bVar) {
            synchronized (this.f1391a) {
                for (C1029b a : this.f1391a) {
                    a.mo15006a(i, bVar);
                }
            }
        }

        /* renamed from: a */
        public void mo15004a(C1029b bVar) {
            String str;
            String str2;
            synchronized (this.f1391a) {
                if (bVar != null) {
                    if (!this.f1391a.contains(bVar)) {
                        try {
                            this.f1391a.add(bVar);
                        } catch (UnsupportedOperationException unused) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver UnsupportedOperationException";
                        } catch (ClassCastException unused2) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver ClassCastException";
                        } catch (IllegalArgumentException unused3) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver IllegalArgumentException";
                        }
                    }
                } else {
                    return;
                }
            }
            C0968a.m1682b(str, str2);
        }

        /* renamed from: b */
        public void mo15005b(C1029b bVar) {
            synchronized (this.f1391a) {
                try {
                    this.f1391a.remove(bVar);
                } catch (UnsupportedOperationException unused) {
                    C0968a.m1682b("InstallObserverManager", "unRegisterObserver UnsupportedOperationException");
                }
            }
        }
    }

    private C1030c() {
    }

    /* renamed from: a */
    public static C1028a m1936a() {
        return f1390b;
    }

    /* renamed from: b */
    public static C1030c m1937b() {
        return f1389a;
    }

    /* renamed from: a */
    public void mo15007a(C0987b bVar) {
        f1390b.mo15003a(1, bVar);
    }

    /* renamed from: b */
    public void mo15008b(C0987b bVar) {
        f1390b.mo15003a(0, bVar);
    }

    /* renamed from: c */
    public void mo15009c(C0987b bVar) {
        f1390b.mo15003a(2, bVar);
    }
}
