package com.huawei.updatesdk.p025a.p026a.p031d.p032h;

import android.content.Context;
import com.huawei.updatesdk.p025a.p026a.p031d.C0973e;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0991b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.updatesdk.a.a.d.h.b */
public class C0978b extends C0991b {
    /* access modifiers changed from: private */
    public String abis_;
    /* access modifiers changed from: private */
    public String deviceFeatures_;
    /* access modifiers changed from: private */
    public int dpi_;
    /* access modifiers changed from: private */
    public String preferLan_;

    /* renamed from: com.huawei.updatesdk.a.a.d.h.b$b */
    public static class C0980b {

        /* renamed from: a */
        private final Context f1314a;

        /* renamed from: b */
        private boolean f1315b;

        /* renamed from: c */
        private Set<String> f1316c;

        /* renamed from: d */
        private String[] f1317d;

        /* renamed from: e */
        private boolean f1318e;

        public C0980b(Context context) {
            this.f1314a = context;
        }

        /* renamed from: b */
        private String m1721b() {
            ArrayList arrayList = new ArrayList(C0981c.m1735d(this.f1314a));
            Set<String> set = this.f1316c;
            if (set != null) {
                for (String next : set) {
                    if (!arrayList.contains(next)) {
                        arrayList.add(next);
                    }
                }
            }
            return this.f1318e ? C0973e.m1695a(C0981c.m1728a((List<String>) arrayList, this.f1317d), Constants.ACCEPT_TIME_SEPARATOR_SP) : C0973e.m1695a((List<String>) arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP);
        }

        /* renamed from: a */
        public C0980b mo14887a(boolean z) {
            this.f1315b = z;
            return this;
        }

        /* renamed from: a */
        public C0978b mo14888a() {
            C0978b bVar = new C0978b();
            String unused = bVar.abis_ = C0973e.m1697a(C0981c.m1739f(), Constants.ACCEPT_TIME_SEPARATOR_SP);
            int unused2 = bVar.dpi_ = Integer.parseInt(C0981c.m1738f(this.f1314a));
            String unused3 = bVar.preferLan_ = m1721b();
            if (this.f1315b) {
                String unused4 = bVar.deviceFeatures_ = C0981c.m1725a(this.f1314a);
            }
            return bVar;
        }
    }

    private C0978b() {
    }
}
