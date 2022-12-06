package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.api.a */
/* compiled from: BindingFailedResolveMgr */
class C0628a {

    /* renamed from: b */
    static final C0628a f340b = new C0628a();

    /* renamed from: a */
    List<Activity> f341a = new ArrayList(1);

    C0628a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13209a(Activity activity) {
        for (Activity next : this.f341a) {
            if (!(next == null || next == activity || next.isFinishing())) {
                next.finish();
            }
        }
        this.f341a.add(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo13210b(Activity activity) {
        this.f341a.remove(activity);
    }
}
