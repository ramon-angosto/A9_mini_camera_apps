package com.bytedance.sdk.openadsdk.core.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.f.b.c;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.w;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: PlayableCache */
public class a {
    private static volatile a a;
    private String b;
    /* access modifiers changed from: private */
    public Map<n, b> c = Collections.synchronizedMap(new HashMap());
    private Map<String, JSONObject> d = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    public AtomicBoolean e = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public Set<String> f = Collections.synchronizedSet(new HashSet());

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.b.a$a  reason: collision with other inner class name */
    /* compiled from: PlayableCache */
    public interface C0049a {
        void a(boolean z);
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private a() {
    }

    public boolean a(n nVar) {
        if (!(!this.e.get() || nVar == null || nVar.J() == null || nVar.J().k() == null)) {
            try {
                String a2 = e.a(nVar.J().k());
                if (this.d.get(a2) == null) {
                    return false;
                }
                return e(new File(c(), a2));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void b() {
        if (!this.e.get()) {
            w.a((g) new g("PlayableCache_init") {
                public void run() {
                    File[] listFiles;
                    try {
                        String a2 = a.this.c();
                        if (!TextUtils.isEmpty(a2)) {
                            File file = new File(a2);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                for (File a3 : listFiles) {
                                    try {
                                        JSONObject unused = a.this.a(a.this.a(a3), true);
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                    a.this.e.set(true);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public JSONObject a(File file, boolean z) {
        byte[] d2;
        String str;
        try {
            if (!b(file) || (d2 = f.d(file)) == null || d2.length <= 0) {
                return null;
            }
            if (TextUtils.equals(file.getName(), "tt_open_ad_sdk_check_res.dat")) {
                str = com.bytedance.sdk.component.utils.a.b(new String(d2));
            } else {
                str = com.bytedance.sdk.component.c.a.b(new String(d2), com.bytedance.sdk.openadsdk.core.a.b());
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (z && jSONObject.length() > 0) {
                this.d.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public File a(File file) {
        File file2 = new File(file, "tt_open_ad_sdk_check_res.dat");
        if (b(file2)) {
            return file2;
        }
        return new File(file, "tt_open_ad_sdk_check_res.dat");
    }

    private boolean b(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|(2:17|(1:19))|20|21|(1:23)(2:24|(1:26)(3:27|(2:29|(1:31)(2:32|(1:34)(2:35|(2:39|40))))|44))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0049 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057 A[Catch:{ all -> 0x00b1 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058 A[Catch:{ all -> 0x00b1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.webkit.WebResourceResponse a(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            r0 = 0
            java.util.concurrent.atomic.AtomicBoolean r1 = r4.e     // Catch:{ all -> 0x00b1 }
            boolean r1 = r1.get()     // Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x000a
            return r0
        L_0x000a:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x00b0
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x00b0
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x001e
            goto L_0x00b0
        L_0x001e:
            java.lang.String r1 = "http"
            boolean r1 = r7.startsWith(r1)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = "?"
            boolean r1 = r7.contains(r1)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = "\\?"
            java.lang.String[] r1 = r7.split(r1)     // Catch:{ all -> 0x0049 }
            r2 = 0
            r7 = r1[r2]     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = "/"
            boolean r1 = r7.endsWith(r1)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0049
            int r1 = r7.length()     // Catch:{ all -> 0x0049 }
            int r1 = r1 + -1
            java.lang.String r7 = r7.substring(r2, r1)     // Catch:{ all -> 0x0049 }
        L_0x0049:
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x00b1 }
            java.lang.String r1 = com.bytedance.sdk.component.utils.n.a((android.content.Context) r1, (java.lang.String) r7)     // Catch:{ all -> 0x00b1 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00b1 }
            if (r2 == 0) goto L_0x0058
            return r0
        L_0x0058:
            java.lang.String r5 = com.bytedance.sdk.component.utils.e.a((java.lang.String) r5)     // Catch:{ all -> 0x00b1 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00b1 }
            if (r2 == 0) goto L_0x0063
            return r0
        L_0x0063:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = r4.c()     // Catch:{ all -> 0x00b1 }
            r2.<init>(r3, r5)     // Catch:{ all -> 0x00b1 }
            boolean r3 = r4.e(r2)     // Catch:{ all -> 0x00b1 }
            if (r3 == 0) goto L_0x00b9
            java.lang.String r6 = r4.a((java.lang.String) r6)     // Catch:{ all -> 0x00b1 }
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00b1 }
            if (r3 == 0) goto L_0x007d
            return r0
        L_0x007d:
            java.lang.String r3 = ""
            java.lang.String r6 = r7.replace(r6, r3)     // Catch:{ all -> 0x00b1 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00b1 }
            if (r7 == 0) goto L_0x008a
            return r0
        L_0x008a:
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x00b1 }
            r7.<init>(r2, r6)     // Catch:{ all -> 0x00b1 }
            boolean r5 = r4.a((java.lang.String) r5, (java.lang.String) r6, (java.io.File) r7)     // Catch:{ all -> 0x00b1 }
            if (r5 == 0) goto L_0x00b9
            java.lang.String r5 = r7.getCanonicalPath()     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = r2.getCanonicalPath()     // Catch:{ all -> 0x00b1 }
            boolean r5 = r5.startsWith(r6)     // Catch:{ all -> 0x00b1 }
            if (r5 == 0) goto L_0x00b9
            android.webkit.WebResourceResponse r5 = new android.webkit.WebResourceResponse     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = "utf-8"
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x00b1 }
            r2.<init>(r7)     // Catch:{ all -> 0x00b1 }
            r5.<init>(r1, r6, r2)     // Catch:{ all -> 0x00b1 }
            return r5
        L_0x00b0:
            return r0
        L_0x00b1:
            r5 = move-exception
            java.lang.String r6 = "PlayableCache"
            java.lang.String r7 = "playable intercept error: "
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r6, (java.lang.String) r7, (java.lang.Throwable) r5)
        L_0x00b9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.b.a.a(java.lang.String, java.lang.String, java.lang.String):android.webkit.WebResourceResponse");
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length == 2) {
            if (split[0] != null && split[0].endsWith("/")) {
                str = str.substring(0, split.length - 1);
            }
            if (split[0] != null && split[0].endsWith("index.html")) {
                str = split[0];
            }
        }
        return str.replace("index.html", "");
    }

    private boolean a(String str, String str2, File file) {
        JSONObject jSONObject;
        String optString;
        if (file == null || !file.exists() || (jSONObject = this.d.get(str)) == null || (optString = jSONObject.optString(str2)) == null || !optString.equalsIgnoreCase(e.a(file))) {
            return false;
        }
        return true;
    }

    public void a(n nVar, C0049a aVar) {
        if (nVar == null || nVar.J() == null || TextUtils.isEmpty(nVar.J().k())) {
            b.a(m.a(), nVar, -701, (String) null);
            a(aVar, false);
            return;
        }
        final String k = nVar.J().k();
        if (!this.f.contains(k)) {
            this.c.put(nVar, new b().a(System.currentTimeMillis()));
            b.a(m.a(), nVar);
            String a2 = e.a(k);
            final File file = new File(c(), a2);
            if (e(file)) {
                b.a(m.a(), nVar, -702, (String) null);
                d(file);
                this.c.remove(nVar);
                a(aVar, true);
                return;
            }
            try {
                f.c(file);
            } catch (Throwable unused) {
            }
            this.f.add(k);
            String d2 = d();
            File file2 = new File(d2, a2 + ".zip");
            com.bytedance.sdk.component.f.b.a d3 = d.a().b().d();
            d3.a(k);
            d3.a(file2.getParent(), file2.getName());
            final n nVar2 = nVar;
            final C0049a aVar2 = aVar;
            d3.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                public void a(c cVar, final com.bytedance.sdk.component.f.b bVar) {
                    a.this.f.remove(k);
                    final b bVar2 = (b) a.this.c.remove(nVar2);
                    if (bVar2 != null) {
                        bVar2.b(System.currentTimeMillis());
                    }
                    if (!bVar.f() || bVar.e() == null || !bVar.e().exists()) {
                        int i = -700;
                        if (bVar.a() != 0) {
                            i = bVar.a();
                        }
                        b.a(m.a(), nVar2, i, (String) null);
                        l.c("PlayableCache", "onResponse: Playable zip download fail");
                        a.this.a(aVar2, false);
                        return;
                    }
                    l.c("PlayableCache", "onResponse: Playable zip download success");
                    w.a((g) new g("downloadZip") {
                        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|(10:1|2|(1:4)|5|(1:7)|8|(1:10)(1:11)|12|13|14)|17|18|19|21) */
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x008b */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r7 = this;
                                r0 = 1
                                com.bytedance.sdk.openadsdk.core.video.b.a$b r1 = r4     // Catch:{ all -> 0x0071 }
                                if (r1 == 0) goto L_0x000e
                                com.bytedance.sdk.openadsdk.core.video.b.a$b r1 = r4     // Catch:{ all -> 0x0071 }
                                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0071 }
                                r1.c(r2)     // Catch:{ all -> 0x0071 }
                            L_0x000e:
                                com.bytedance.sdk.component.f.b r1 = r5     // Catch:{ all -> 0x0071 }
                                java.io.File r1 = r1.e()     // Catch:{ all -> 0x0071 }
                                java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r2 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a r2 = com.bytedance.sdk.openadsdk.core.video.b.a.this     // Catch:{ all -> 0x0071 }
                                java.lang.String r2 = r2.c()     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.component.utils.y.a(r1, r2)     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a$b r1 = r4     // Catch:{ all -> 0x0071 }
                                if (r1 == 0) goto L_0x0030
                                com.bytedance.sdk.openadsdk.core.video.b.a$b r1 = r4     // Catch:{ all -> 0x0071 }
                                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0071 }
                                r1.d(r2)     // Catch:{ all -> 0x0071 }
                            L_0x0030:
                                com.bytedance.sdk.openadsdk.core.video.b.a$b r1 = r4     // Catch:{ all -> 0x0071 }
                                r2 = 0
                                if (r1 == 0) goto L_0x0045
                                com.bytedance.sdk.openadsdk.core.video.b.a$b r1 = r4     // Catch:{ all -> 0x0071 }
                                long r2 = r1.a()     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a$b r1 = r4     // Catch:{ all -> 0x0071 }
                                long r4 = r1.b()     // Catch:{ all -> 0x0071 }
                                r5 = r4
                                r3 = r2
                                goto L_0x0047
                            L_0x0045:
                                r5 = r2
                                r3 = r5
                            L_0x0047:
                                android.content.Context r1 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r2 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.model.n r2 = r5     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.b.a((android.content.Context) r1, (com.bytedance.sdk.openadsdk.core.model.n) r2, (long) r3, (long) r5)     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r1 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a r1 = com.bytedance.sdk.openadsdk.core.video.b.a.this     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r2 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this     // Catch:{ all -> 0x0071 }
                                java.io.File r2 = r6     // Catch:{ all -> 0x0071 }
                                r1.c((java.io.File) r2)     // Catch:{ all -> 0x0071 }
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r1 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this     // Catch:{ all -> 0x008b }
                                com.bytedance.sdk.openadsdk.core.video.b.a r1 = com.bytedance.sdk.openadsdk.core.video.b.a.this     // Catch:{ all -> 0x008b }
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r2 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this     // Catch:{ all -> 0x008b }
                                java.io.File r2 = r6     // Catch:{ all -> 0x008b }
                                java.io.File r1 = r1.a((java.io.File) r2)     // Catch:{ all -> 0x008b }
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r2 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this     // Catch:{ all -> 0x008b }
                                com.bytedance.sdk.openadsdk.core.video.b.a r2 = com.bytedance.sdk.openadsdk.core.video.b.a.this     // Catch:{ all -> 0x008b }
                                org.json.JSONObject unused = r2.a((java.io.File) r1, (boolean) r0)     // Catch:{ all -> 0x008b }
                                goto L_0x008b
                            L_0x0071:
                                r0 = move-exception
                                java.lang.String r1 = "PlayableCache"
                                java.lang.String r2 = "unzip error: "
                                com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r0)
                                android.content.Context r1 = com.bytedance.sdk.openadsdk.core.m.a()
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r2 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this
                                com.bytedance.sdk.openadsdk.core.model.n r2 = r5
                                r3 = -704(0xfffffffffffffd40, float:NaN)
                                java.lang.String r0 = r0.getMessage()
                                com.bytedance.sdk.openadsdk.core.video.b.b.a((android.content.Context) r1, (com.bytedance.sdk.openadsdk.core.model.n) r2, (int) r3, (java.lang.String) r0)
                                r0 = 0
                            L_0x008b:
                                com.bytedance.sdk.component.f.b r1 = r5     // Catch:{ all -> 0x0094 }
                                java.io.File r1 = r1.e()     // Catch:{ all -> 0x0094 }
                                r1.delete()     // Catch:{ all -> 0x0094 }
                            L_0x0094:
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r1 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this
                                com.bytedance.sdk.openadsdk.core.video.b.a r1 = com.bytedance.sdk.openadsdk.core.video.b.a.this
                                com.bytedance.sdk.openadsdk.core.video.b.a$2 r2 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.this
                                com.bytedance.sdk.openadsdk.core.video.b.a$a r2 = r7
                                r1.a((com.bytedance.sdk.openadsdk.core.video.b.a.C0049a) r2, (boolean) r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2.AnonymousClass1.run():void");
                        }
                    });
                }

                public void a(c cVar, IOException iOException) {
                    a.this.f.remove(k);
                    a.this.c.remove(nVar2);
                    b.a(m.a(), nVar2, -700, iOException.getMessage());
                    a.this.a(aVar2, false);
                    l.c("PlayableCache", "onFailure: Playable zip download fail");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final C0049a aVar, final boolean z) {
        w.a((Runnable) new Runnable() {
            public void run() {
                C0049a aVar = aVar;
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void c(File file) {
        d(file);
        try {
            h.d().p().a(file);
        } catch (Throwable unused) {
        }
    }

    private void d(File file) {
        try {
            if (file.exists() && !file.setLastModified(System.currentTimeMillis())) {
                file.renameTo(file);
                file.lastModified();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean e(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return false;
        }
        return Arrays.asList(list).contains("index.html");
    }

    /* access modifiers changed from: private */
    public String c() {
        File file = new File(d(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String d() {
        if (TextUtils.isEmpty(this.b)) {
            try {
                File file = new File(m.a().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.b = file.getAbsolutePath();
            } catch (Throwable th) {
                l.e("PlayableCache", "init root path error: " + th);
            }
        }
        return this.b;
    }

    /* compiled from: PlayableCache */
    private static class b {
        long a;
        long b;
        long c;
        long d;

        private b() {
        }

        public long a() {
            return this.b - this.a;
        }

        public long b() {
            return this.d - this.c;
        }

        public b a(long j) {
            this.a = j;
            return this;
        }

        public b b(long j) {
            this.b = j;
            return this;
        }

        public b c(long j) {
            this.c = j;
            return this;
        }

        public b d(long j) {
            this.d = j;
            return this;
        }
    }
}
