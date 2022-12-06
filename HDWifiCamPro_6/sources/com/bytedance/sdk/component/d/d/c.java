package com.bytedance.sdk.component.d.d;

import android.text.TextUtils;
import com.bytedance.sdk.component.d.l;

/* compiled from: CacheKeyVisitor */
public class c extends a {
    public String a() {
        return "generate_key";
    }

    public void a(com.bytedance.sdk.component.d.c.c cVar) {
        if (TextUtils.isEmpty(cVar.e())) {
            l d = cVar.r().d();
            cVar.b(d.a(cVar));
            cVar.a(d.b(cVar));
        }
        cVar.a((i) new g());
    }
}
