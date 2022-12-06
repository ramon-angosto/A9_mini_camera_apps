package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.component.d.h;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.l.h;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.x;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TTAppOpenAdCacheManager */
public class c {
    private static volatile c a;
    private final com.bytedance.sdk.openadsdk.b.b b;
    private final n<com.bytedance.sdk.openadsdk.c.a> c;
    /* access modifiers changed from: private */
    public final Context d;

    /* compiled from: TTAppOpenAdCacheManager */
    public interface b {
        void a();

        void a(com.bytedance.sdk.openadsdk.i.a.b bVar);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.component.c$c  reason: collision with other inner class name */
    /* compiled from: TTAppOpenAdCacheManager */
    interface C0040c {
        void a();

        void a(int i, String str);
    }

    /* compiled from: TTAppOpenAdCacheManager */
    public interface d {
        void a();

        void a(Bitmap bitmap);
    }

    private c(Context context) {
        if (context != null) {
            this.d = context.getApplicationContext();
        } else {
            this.d = m.a();
        }
        this.b = new com.bytedance.sdk.openadsdk.b.b(10, 8, true);
        this.c = m.c();
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    public static void a(com.bytedance.sdk.openadsdk.core.model.n nVar, d dVar) {
        a(nVar, dVar, 0);
    }

    public static void a(com.bytedance.sdk.openadsdk.core.model.n nVar, final d dVar, final int i) {
        com.bytedance.sdk.openadsdk.e.a.a(nVar.J().h()).a(u.BITMAP).a((h) new h() {
            public Bitmap a(Bitmap bitmap) {
                if (i <= 0) {
                    return bitmap;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    return com.bytedance.sdk.component.adexpress.c.a.a(m.a(), bitmap, i);
                }
                return null;
            }
        }).a((o) new o<Bitmap>() {
            public void a(k<Bitmap> kVar) {
                if (kVar == null || kVar.b() == null || kVar.c() == null) {
                    d dVar = dVar;
                    if (dVar != null) {
                        dVar.a();
                        return;
                    }
                    return;
                }
                d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.a(kVar.b());
                }
            }

            public void a(int i, String str, Throwable th) {
                d dVar = dVar;
                if (dVar != null) {
                    dVar.a();
                }
            }
        });
    }

    public void a(final AdSlot adSlot) {
        final r rVar = new r();
        rVar.a(x.a());
        com.bytedance.sdk.openadsdk.core.model.o oVar = new com.bytedance.sdk.openadsdk.core.model.o();
        oVar.i = rVar;
        oVar.d = 2;
        oVar.f = 2;
        this.c.a(adSlot, oVar, 3, new n.a() {
            public void a(int i, String str) {
                l.b("TTAppOpenAdCacheManager", "cache Load App OpenAd From Network fail");
            }

            public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                l.b("TTAppOpenAdCacheManager", "cache Load App Open Ad From Network success");
                if (aVar == null || aVar.b() == null || aVar.b().size() == 0) {
                    l.b("TTAppOpenAdCacheManager", "material is null");
                    bVar.a(-3);
                    com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.model.n nVar = aVar.b().get(0);
                if (com.bytedance.sdk.openadsdk.core.model.n.c(nVar)) {
                    c.this.a(nVar, adSlot, rVar);
                } else {
                    c.this.a(nVar, rVar);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.model.n nVar, AdSlot adSlot, final r rVar) {
        final int aW = nVar.aW();
        a(nVar, adSlot, rVar, (C0040c) new C0040c() {
            public void a(int i, String str) {
            }

            public void a() {
                com.bytedance.sdk.openadsdk.component.e.a aVar = new com.bytedance.sdk.openadsdk.component.e.a(aW, nVar);
                c.this.a(aVar);
                com.bytedance.sdk.openadsdk.component.d.a.a(aVar.b(), 1, rVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.model.n nVar, final r rVar) {
        final int aW = nVar.aW();
        a(nVar, rVar, (b) new b() {
            public void a() {
            }

            public void a(com.bytedance.sdk.openadsdk.i.a.b bVar) {
                com.bytedance.sdk.openadsdk.component.e.a aVar = new com.bytedance.sdk.openadsdk.component.e.a(aW, nVar);
                c.this.a(aVar);
                com.bytedance.sdk.openadsdk.component.d.a.a(aVar.b(), 1, rVar);
            }
        });
    }

    public void a(com.bytedance.sdk.openadsdk.core.model.n nVar, AdSlot adSlot, r rVar, C0040c cVar) {
        com.bytedance.sdk.openadsdk.core.model.n nVar2 = nVar;
        r rVar2 = rVar;
        x a2 = x.a();
        int aW = nVar.aW();
        com.bykv.vk.openvk.component.video.api.c.b J = nVar.J();
        String i = J.i();
        String l = J.l();
        if (TextUtils.isEmpty(l)) {
            l = e.a(i);
        }
        final File a3 = com.bytedance.sdk.openadsdk.component.g.a.a(l);
        if (a3.exists()) {
            l.b("TTAppOpenAdCacheManager", "The video cache exists locally, use the cache directly");
            com.bytedance.sdk.openadsdk.component.g.a.a(a3);
            a(aW);
            long c2 = a2.c();
            if (rVar2 != null) {
                rVar2.a(c2);
                rVar2.a(1);
            }
            cVar.a();
            a(nVar2, (d) null);
        } else if (!m.d().u(String.valueOf(aW)) || com.bytedance.sdk.component.utils.o.d(m.a())) {
            C0040c cVar2 = cVar;
            com.bykv.vk.openvk.component.video.api.c.c a4 = com.bytedance.sdk.openadsdk.core.model.n.a(a3.getParent(), nVar2);
            a4.a("material_meta", nVar2);
            a4.a("ad_slot", adSlot);
            final int i2 = aW;
            final x xVar = a2;
            final com.bytedance.sdk.openadsdk.core.model.n nVar3 = nVar;
            AnonymousClass6 r14 = r0;
            final r rVar3 = rVar;
            com.bykv.vk.openvk.component.video.api.c.c cVar3 = a4;
            final C0040c cVar4 = cVar;
            AnonymousClass6 r0 = new a.C0022a() {
                public void b(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                }

                public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                    l.b("TTAppOpenAdCacheManager", "Video file caching success");
                    c.this.a(i2);
                    long c2 = xVar.c();
                    com.bytedance.sdk.openadsdk.component.d.a.b(nVar3, c2, true);
                    r rVar = rVar3;
                    if (rVar != null) {
                        rVar.a(c2);
                        rVar3.a(2);
                    }
                    cVar4.a();
                    c.a(nVar3, (d) null);
                }

                public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i, String str) {
                    l.b("TTAppOpenAdCacheManager", "Video file caching failed");
                    long c2 = xVar.c();
                    com.bytedance.sdk.openadsdk.component.d.a.b(nVar3, c2, false);
                    r rVar = rVar3;
                    if (rVar != null) {
                        rVar.a(c2);
                    }
                    cVar4.a(i, str);
                    try {
                        if (a3.exists() && a3.isFile()) {
                            f.c(a3);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            com.bytedance.sdk.openadsdk.core.video.d.a.a(cVar3, r14);
            if (Build.VERSION.SDK_INT < 23) {
                a(new File(com.bykv.vk.openvk.component.video.api.b.a().getCacheDir(), "proxy_cache"));
                a(aW);
                long c3 = a2.c();
                com.bytedance.sdk.openadsdk.component.d.a.b(nVar2, c3, true);
                if (rVar2 != null) {
                    rVar2.a(c3);
                    rVar2.a(2);
                }
                cVar.a();
                a(nVar2, (d) null);
            }
        } else {
            cVar.a(100, "OnlyWifi");
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.model.n nVar, r rVar, b bVar) {
        final x a2 = x.a();
        final int aW = nVar.aW();
        com.bytedance.sdk.openadsdk.core.model.k kVar = nVar.P().get(0);
        String g = kVar.g();
        String a3 = kVar.a();
        int b2 = kVar.b();
        int c2 = kVar.c();
        File b3 = com.bytedance.sdk.openadsdk.component.g.a.b(TextUtils.isEmpty(g) ? e.a(a3) : g);
        if (a(a3, g)) {
            l.b("TTAppOpenAdCacheManager", "The image cache exists locally, directly use the cache");
            c(aW);
            long c3 = a2.c();
            if (rVar != null) {
                rVar.a(c3);
                rVar.a(1);
            }
            bVar.a((com.bytedance.sdk.openadsdk.i.a.b) null);
            return;
        }
        com.bytedance.sdk.openadsdk.i.a aVar = new com.bytedance.sdk.openadsdk.i.a(a3, kVar.g());
        final com.bytedance.sdk.openadsdk.core.model.n nVar2 = nVar;
        final r rVar2 = rVar;
        final b bVar2 = bVar;
        com.bytedance.sdk.openadsdk.l.h.a(aVar, b2, c2, new h.a() {
            public void a(com.bytedance.sdk.openadsdk.i.a.b bVar) {
                if (bVar.d()) {
                    l.b("TTAppOpenAdCacheManager", "Image loaded successfully");
                    c.this.c(aW);
                    long c2 = a2.c();
                    com.bytedance.sdk.openadsdk.component.d.a.a(nVar2, c2, true);
                    r rVar = rVar2;
                    if (rVar != null) {
                        rVar.a(c2);
                        rVar2.a(2);
                    }
                    bVar2.a(bVar);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.d.a.a(nVar2, a2.c(), false);
                bVar2.a();
            }

            public void a() {
                l.b("TTAppOpenAdCacheManager", "Image loading failed");
                com.bytedance.sdk.openadsdk.component.d.a.a(nVar2, a2.c(), false);
                bVar2.a();
            }

            public void b() {
                l.b("TTAppOpenAdCacheManager", "Image caching success");
            }
        }, b3.getParent());
    }

    public void a(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_openad", "video_has_cached" + i, (Boolean) true);
            return;
        }
        SharedPreferences.Editor edit = this.d.getSharedPreferences("tt_openad", 0).edit();
        edit.putBoolean("video_has_cached" + i, true).apply();
    }

    public boolean b(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_openad", "video_has_cached" + i, false);
        }
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("tt_openad", 0);
        return sharedPreferences.getBoolean("video_has_cached" + i, false);
    }

    public void c(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_openad", "image_has_cached" + i, (Boolean) true);
            return;
        }
        SharedPreferences.Editor edit = this.d.getSharedPreferences("tt_openad", 0).edit();
        edit.putBoolean("image_has_cached" + i, true).apply();
    }

    public boolean d(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_openad", "image_has_cached" + i, false);
        }
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("tt_openad", 0);
        return sharedPreferences.getBoolean("image_has_cached" + i, false);
    }

    public void a(com.bytedance.sdk.openadsdk.component.e.a aVar) {
        if (aVar.b() != null && aVar.a() != 0) {
            long ag = aVar.b().ag();
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_openad", "material_expiration_time" + aVar.a(), Long.valueOf(ag));
            } else {
                SharedPreferences.Editor edit = this.d.getSharedPreferences("tt_openad", 0).edit();
                edit.putLong("material_expiration_time" + aVar.a(), ag).apply();
            }
            b(aVar);
        }
    }

    public com.bytedance.sdk.openadsdk.core.model.n e(int i) {
        long j;
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            j = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_openad", "material_expiration_time" + i, -1);
        } else {
            SharedPreferences sharedPreferences = this.d.getSharedPreferences("tt_openad", 0);
            j = sharedPreferences.getLong("material_expiration_time" + i, -1);
        }
        com.bytedance.sdk.openadsdk.core.model.n f = f(i);
        if (System.currentTimeMillis() / 1000 < j && f != null) {
            return f;
        }
        if (f == null && j == -1) {
            return null;
        }
        if (f != null) {
            com.bytedance.sdk.openadsdk.component.d.a.a(f);
        }
        g(i);
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.model.n f(int i) {
        String str;
        String str2;
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            str = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_openad_materialMeta", "material" + i, (String) null);
        } else {
            str = this.d.getSharedPreferences("tt_openad_materialMeta", 0).getString("material" + i, (String) null);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = com.bytedance.sdk.component.utils.a.b(new JSONObject(str).optString("message"));
            } catch (JSONException e) {
                e.printStackTrace();
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    com.bytedance.sdk.openadsdk.core.model.n a2 = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(str2));
                    if (a2 != null) {
                        return a2;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    private void b(com.bytedance.sdk.openadsdk.component.e.a aVar) {
        w.a(new a(aVar), 10, 5);
    }

    public String a(com.bytedance.sdk.openadsdk.core.model.n nVar) {
        if (!(nVar == null || nVar.J() == null || TextUtils.isEmpty(nVar.J().i()))) {
            String i = nVar.J().i();
            String l = nVar.J().l();
            if (TextUtils.isEmpty(l)) {
                l = e.a(i);
            }
            File a2 = com.bytedance.sdk.openadsdk.component.g.a.a(l);
            if (a2.exists() && a2.isFile()) {
                return a2.getAbsolutePath();
            }
        }
        return null;
    }

    public boolean b(com.bytedance.sdk.openadsdk.core.model.n nVar) {
        if (nVar == null || nVar.P() == null || nVar.P().size() == 0 || TextUtils.isEmpty(nVar.P().get(0).a())) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.k kVar = nVar.P().get(0);
        return a(kVar.a(), kVar.g());
    }

    public boolean a(String str, String str2) {
        boolean z;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = e.a(str);
            }
            File b2 = com.bytedance.sdk.openadsdk.component.g.a.b(str2);
            InputStream a2 = com.bytedance.sdk.openadsdk.e.a.a(str, str2);
            if (a2 != null) {
                try {
                    a2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (com.bytedance.sdk.openadsdk.e.a.a(str, str2, b2.getParent())) {
                    return true;
                }
                if (new File(b2.getPath() + ".0").exists()) {
                    return true;
                }
            }
            return z;
        } catch (Exception e2) {
            l.e("TTAppOpenAdCacheManager", e2.getMessage());
            return false;
        }
    }

    public void a(File file) {
        try {
            this.b.a(file);
        } catch (IOException e) {
            l.c("TTAppOpenAdCacheManager", "trimFileCache fail", (Throwable) e);
        }
    }

    public void g(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_openad_materialMeta", "material" + i);
            com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_openad", "material_expiration_time" + i);
            com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_openad", "video_has_cached" + i);
            com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_openad", "image_has_cached" + i);
            return;
        }
        SharedPreferences.Editor edit = this.d.getSharedPreferences("tt_openad_materialMeta", 0).edit();
        edit.remove("material" + i).apply();
        SharedPreferences.Editor edit2 = this.d.getSharedPreferences("tt_openad", 0).edit();
        SharedPreferences.Editor remove = edit2.remove("material_expiration_time" + i);
        SharedPreferences.Editor remove2 = remove.remove("video_has_cached" + i);
        remove2.remove("image_has_cached" + i).apply();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|(2:5|6)(1:7)|8|9|(1:34)(4:19|(5:21|22|23|28|24)|27|35)) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[Catch:{ all -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = com.bytedance.sdk.openadsdk.multipro.b.c()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "tt_openad"
            java.lang.String r3 = "tt_openad_materialMeta"
            if (r1 == 0) goto L_0x0012
            com.bytedance.sdk.openadsdk.multipro.d.a.a((java.lang.String) r3)     // Catch:{ all -> 0x0034 }
            com.bytedance.sdk.openadsdk.multipro.d.a.a((java.lang.String) r2)     // Catch:{ all -> 0x0034 }
            goto L_0x0034
        L_0x0012:
            android.content.Context r1 = r4.d     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r3, r0)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r1.clear()     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
            android.content.Context r1 = r4.d     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r0)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r1.clear()     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0034:
            android.content.Context r1 = r4.d     // Catch:{ all -> 0x0061 }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x0061
            boolean r2 = r1.exists()     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x0061
            boolean r2 = r1.isDirectory()     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x0061
            com.bytedance.sdk.openadsdk.component.c$8 r2 = new com.bytedance.sdk.openadsdk.component.c$8     // Catch:{ all -> 0x0061 }
            r2.<init>()     // Catch:{ all -> 0x0061 }
            java.io.File[] r1 = r1.listFiles(r2)     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x0061
            int r2 = r1.length     // Catch:{ all -> 0x0061 }
            if (r2 <= 0) goto L_0x0061
            int r2 = r1.length     // Catch:{ all -> 0x0061 }
        L_0x0057:
            if (r0 >= r2) goto L_0x0061
            r3 = r1[r0]     // Catch:{ all -> 0x0061 }
            com.bytedance.sdk.component.utils.f.c(r3)     // Catch:{ all -> 0x005e }
        L_0x005e:
            int r0 = r0 + 1
            goto L_0x0057
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.c.a():void");
    }

    public String b() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            return name + "/" + "openad_image_cache" + "/";
        }
        return name + "/" + "/openad_image_cache" + "/";
    }

    /* compiled from: TTAppOpenAdCacheManager */
    private class a extends g {
        private final com.bytedance.sdk.openadsdk.component.e.a b;

        public a(com.bytedance.sdk.openadsdk.component.e.a aVar) {
            super("App Open Ad Write Cache");
            this.b = aVar;
        }

        public void run() {
            try {
                String jSONObject = com.bytedance.sdk.component.utils.a.a(this.b.b().ar()).toString();
                if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_openad_materialMeta", "material" + this.b.a(), jSONObject);
                    return;
                }
                SharedPreferences.Editor edit = c.this.d.getSharedPreferences("tt_openad_materialMeta", 0).edit();
                edit.putString("material" + this.b.a(), jSONObject).apply();
            } catch (Throwable unused) {
            }
        }
    }
}
