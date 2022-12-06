package com.bytedance.sdk.component.b.a.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.b;
import com.bytedance.sdk.component.b.a.d;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.k;

/* compiled from: NetClient */
public class c extends i {
    public d h = new d();

    public c(i.a aVar) {
        super(aVar);
    }

    public d a() {
        return this.h;
    }

    public b a(k kVar) {
        kVar.a(this);
        if (kVar == null || kVar.b() == null || kVar.b().a() == null || TextUtils.isEmpty(kVar.b().a().toString())) {
            return null;
        }
        a aVar = new a(kVar, this.h);
        this.h.c().add(aVar);
        return aVar;
    }
}
