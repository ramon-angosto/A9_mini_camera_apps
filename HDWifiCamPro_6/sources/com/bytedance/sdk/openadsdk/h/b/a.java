package com.bytedance.sdk.openadsdk.h.b;

import com.bytedance.sdk.component.g.c;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.h.b;

/* compiled from: ReportThreadLogServiceImp */
public class a implements c {
    public void a(final com.bytedance.sdk.component.g.a.a aVar) {
        b.a().b((com.bytedance.sdk.openadsdk.h.a) new com.bytedance.sdk.openadsdk.h.a() {
            public com.bytedance.sdk.openadsdk.h.a.a a() throws Exception {
                com.bytedance.sdk.component.g.a.a aVar;
                if (!m.d().O() || (aVar = aVar) == null || aVar.a() == null) {
                    return null;
                }
                return com.bytedance.sdk.openadsdk.h.a.b.b().a("stats_sdk_thread_num").b(aVar.a().toString());
            }
        });
    }
}
