package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.core.model.b;
import com.bytedance.sdk.openadsdk.core.n;

/* compiled from: AdCallBackAdapter */
public class a implements n.a {
    private final n.a a;

    public a(n.a aVar) {
        this.a = aVar;
    }

    public void a(int i, String str) {
        n.a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, b bVar) {
        n.a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.a(aVar, bVar);
        }
    }
}
