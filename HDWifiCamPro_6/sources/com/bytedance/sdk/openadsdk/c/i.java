package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.k;

/* compiled from: LastShowAdManager */
public class i {
    public static void a(final n nVar, final String str) {
        if (nVar != null) {
            h.a().post(new Runnable() {
                public void run() {
                    try {
                        k.a(nVar.ar().toString(), str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
