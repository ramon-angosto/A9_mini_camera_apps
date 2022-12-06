package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.C1623an;
import java.util.ArrayList;

/* renamed from: com.xiaomi.push.ha */
final class C1850ha extends C1623an.C1625b {

    /* renamed from: a */
    final /* synthetic */ Context f2609a;

    C1850ha(Context context) {
        this.f2609a = context;
    }

    /* renamed from: b */
    public void mo17228b() {
        ArrayList arrayList;
        synchronized (C1847gz.m3813a()) {
            arrayList = new ArrayList(C1847gz.m3813a());
            C1847gz.m3813a().clear();
        }
        C1847gz.m3823b(this.f2609a, arrayList);
    }
}
