package com.bytedance.sdk.openadsdk.e;

import android.content.Context;
import com.bytedance.sdk.component.d.c.b;
import com.bytedance.sdk.component.d.c.e;
import com.bytedance.sdk.component.d.d;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.n;
import com.bytedance.sdk.component.d.s;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.l.v;
import com.bytedance.sdk.openadsdk.l.z;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageLoaderWrapper */
public class a {
    public static j a(String str) {
        return C0052a.b(str);
    }

    public static j a(k kVar) {
        return C0052a.b(kVar);
    }

    public static InputStream a(String str, String str2) {
        return C0052a.b(str, str2);
    }

    public static boolean a(String str, String str2, String str3) {
        return C0052a.b(str, str2, str3);
    }

    public static n a() {
        return C0052a.a;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.e.a$a  reason: collision with other inner class name */
    /* compiled from: ImageLoaderWrapper */
    private static final class C0052a {
        /* access modifiers changed from: private */
        public static n a = a(m.a());

        private static n a(Context context) {
            return b.a(context, (com.bytedance.sdk.component.d.m) new e.a().a((com.bytedance.sdk.component.d.b) new com.bytedance.sdk.component.d.c.a.a(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 83886080), 10485760), 41943040, new File(CacheDirFactory.getImageCacheDir()))).a(com.bytedance.sdk.component.g.e.a(5)).a((d) new d() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.Closeable} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.bytedance.sdk.component.d.b.e} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.bytedance.sdk.component.d.b.e} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.bytedance.sdk.component.d.b.e} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* renamed from: b */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.bytedance.sdk.component.d.b.d a(com.bytedance.sdk.component.d.e r7) {
                    /*
                        r6 = this;
                        com.bytedance.sdk.openadsdk.i.d r0 = com.bytedance.sdk.openadsdk.i.d.a()
                        com.bytedance.sdk.component.f.a r0 = r0.b()
                        com.bytedance.sdk.component.b.a.i r0 = r0.e()
                        com.bytedance.sdk.component.b.a.k$a r1 = new com.bytedance.sdk.component.b.a.k$a
                        r1.<init>()
                        java.lang.String r2 = r7.a()
                        com.bytedance.sdk.component.b.a.k$a r1 = r1.a((java.lang.String) r2)
                        com.bytedance.sdk.component.b.a.k$a r1 = r1.a()
                        com.bytedance.sdk.component.b.a.k r1 = r1.b()
                        boolean r2 = r7.c()
                        r3 = 0
                        if (r2 == 0) goto L_0x002e
                        com.bytedance.sdk.component.d.b.e r2 = new com.bytedance.sdk.component.d.b.e
                        r2.<init>()
                        goto L_0x002f
                    L_0x002e:
                        r2 = r3
                    L_0x002f:
                        if (r2 == 0) goto L_0x0038
                        long r4 = java.lang.System.currentTimeMillis()
                        r2.a(r4)
                    L_0x0038:
                        com.bytedance.sdk.component.b.a.b r0 = r0.a(r1)     // Catch:{ all -> 0x0070 }
                        com.bytedance.sdk.component.b.a.m r3 = r0.a()     // Catch:{ all -> 0x0070 }
                        if (r2 == 0) goto L_0x0049
                        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0070 }
                        r2.b(r0)     // Catch:{ all -> 0x0070 }
                    L_0x0049:
                        java.util.Map r7 = r6.a((com.bytedance.sdk.component.d.e) r7, (com.bytedance.sdk.component.b.a.m) r3)     // Catch:{ all -> 0x0070 }
                        com.bytedance.sdk.component.b.a.n r0 = r3.f()     // Catch:{ all -> 0x0070 }
                        byte[] r0 = r0.d()     // Catch:{ all -> 0x0070 }
                        if (r2 == 0) goto L_0x005e
                        long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0070 }
                        r2.c(r4)     // Catch:{ all -> 0x0070 }
                    L_0x005e:
                        com.bytedance.sdk.component.d.b.d r1 = new com.bytedance.sdk.component.d.b.d     // Catch:{ all -> 0x0070 }
                        int r4 = r3.c()     // Catch:{ all -> 0x0070 }
                        java.lang.String r5 = ""
                        r1.<init>(r4, r0, r5, r7)     // Catch:{ all -> 0x0070 }
                        r1.a(r2)     // Catch:{ all -> 0x0070 }
                        com.bytedance.sdk.component.d.c.c.b.a(r3)
                        return r1
                    L_0x0070:
                        r7 = move-exception
                        com.bytedance.sdk.component.d.b.d r7 = r6.a((com.bytedance.sdk.component.d.b.e) r2, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0079 }
                        com.bytedance.sdk.component.d.c.c.b.a(r3)
                        return r7
                    L_0x0079:
                        r7 = move-exception
                        com.bytedance.sdk.component.d.c.c.b.a(r3)
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.e.a.C0052a.AnonymousClass1.a(com.bytedance.sdk.component.d.e):com.bytedance.sdk.component.d.b.d");
                }

                private Map<String, String> a(com.bytedance.sdk.component.d.e eVar, com.bytedance.sdk.component.b.a.m mVar) {
                    if (!eVar.b()) {
                        return null;
                    }
                    com.bytedance.sdk.component.b.a.e g = mVar.g();
                    HashMap hashMap = new HashMap();
                    int a = g.a();
                    for (int i = 0; i < a; i++) {
                        String a2 = g.a(i);
                        String b = g.b(i);
                        if (a2 != null) {
                            hashMap.put(a2, b);
                        }
                    }
                    return hashMap;
                }

                private com.bytedance.sdk.component.d.b.d a(com.bytedance.sdk.component.d.b.e eVar, Throwable th) {
                    l.d("ImageLoaderWrapper", th.getMessage());
                    if (eVar != null) {
                        eVar.c(System.currentTimeMillis());
                    }
                    com.bytedance.sdk.component.d.b.d dVar = new com.bytedance.sdk.component.d.b.d(0, th, "net failed");
                    dVar.a(eVar);
                    return dVar;
                }
            }).a());
        }

        /* access modifiers changed from: private */
        public static j b(String str) {
            return a(a.a(str).d(z.d(m.a())).c(z.c(m.a())));
        }

        /* access modifiers changed from: private */
        public static j b(k kVar) {
            return a(a.a(kVar.a()).a(kVar.b()).b(kVar.c()).d(z.d(m.a())).c(z.c(m.a())).a(kVar.g()));
        }

        private static j a(j jVar) {
            return v.a() ? jVar.a((s) new b()) : jVar;
        }

        /* access modifiers changed from: private */
        public static InputStream b(String str, String str2) {
            return a.a(str, str2);
        }

        /* access modifiers changed from: private */
        public static boolean b(String str, String str2, String str3) {
            return a.a(str, str2, str3);
        }
    }
}
