package com.ironsource.sdk.controller;

import com.ironsource.sdk.a.d;
import com.ironsource.sdk.h.c;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONObject;

final class f {
    long a;
    int b;
    int c;
    b d = b.NONE;
    private String e;
    private String f;
    private com.ironsource.sdk.k.b g;

    /* renamed from: com.ironsource.sdk.controller.f$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[a.a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0018 */
        static {
            /*
                int[] r0 = com.ironsource.sdk.controller.f.a.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                r0 = 1
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.ironsource.sdk.controller.f.a.a     // Catch:{ NoSuchFieldError -> 0x0011 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                r1 = 2
                int[] r2 = a     // Catch:{ NoSuchFieldError -> 0x0018 }
                int r3 = com.ironsource.sdk.controller.f.a.b     // Catch:{ NoSuchFieldError -> 0x0018 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = com.ironsource.sdk.controller.f.a.c     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.f.AnonymousClass2.<clinit>():void");
        }
    }

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{1, 2, 3};
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    public enum b {
        NONE(0),
        PREPARED_CONTROLLER_LOADED(1),
        CONTROLLER_FROM_SERVER(2),
        MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(3),
        FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(4),
        FALLBACK_CONTROLLER_RECOVERY(5);
        
        int g;

        private b(int i) {
            this.g = i;
        }
    }

    f(JSONObject jSONObject, String str, String str2, com.ironsource.sdk.k.b bVar) {
        this.b = jSONObject.optInt("controllerSourceStrategy", -1);
        int i = this.b;
        this.c = i != 1 ? i != 2 ? a.a : a.c : a.b;
        this.e = str;
        this.f = str2;
        this.g = bVar;
    }

    private void a(c cVar) {
        if (!this.g.b()) {
            this.g.a(cVar, this.f);
        }
    }

    private c g() {
        return new c(this.e, "next_mobileController.html");
    }

    private c h() {
        return new c(this.e, "fallback_mobileController.html");
    }

    private void i() {
        try {
            c d2 = d();
            if (d2.exists()) {
                c h = h();
                if (h.exists()) {
                    h.delete();
                }
                IronSourceStorageUtils.renameFile(d2.getPath(), h.getPath());
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("generalmessage", Integer.valueOf(this.b)).a("controllersource", Integer.valueOf(bVar.g));
        if (this.a > 0) {
            a2.a("timingvalue", Long.valueOf(System.currentTimeMillis() - this.a));
        }
        d.a(com.ironsource.sdk.a.f.s, (Map<String, Object>) a2.a);
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.d != b.NONE;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        c cVar;
        int i = AnonymousClass2.a[this.c - 1];
        if (i == 1) {
            IronSourceStorageUtils.deleteFile(d());
            cVar = new c(this.e, SDKUtils.getFileName(this.f));
        } else if (i != 2) {
            if (i == 3) {
                try {
                    c d2 = d();
                    c g2 = g();
                    if (!g2.exists() && !d2.exists()) {
                        a(new c(this.e, SDKUtils.getFileName(this.f)));
                        return false;
                    } else if (g2.exists() || !d2.exists()) {
                        i();
                        if (IronSourceStorageUtils.renameFile(g().getPath(), d().getPath())) {
                            this.d = b.PREPARED_CONTROLLER_LOADED;
                            a(this.d);
                            c();
                            a(new c(this.e, g2.getName()));
                            return true;
                        } else if (e()) {
                            this.d = b.FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                            a(this.d);
                            a(new c(this.e, g2.getName()));
                            return true;
                        } else {
                            a(new c(this.e, SDKUtils.getFileName(this.f)));
                        }
                    } else {
                        this.d = b.MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                        a(this.d);
                        a(new c(this.e, g2.getName()));
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } else {
            i();
            cVar = new c(this.e, SDKUtils.getFileName(this.f));
        }
        a(cVar);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        IronSourceStorageUtils.deleteFile(h());
    }

    /* access modifiers changed from: package-private */
    public final c d() {
        return new c(this.e, "mobileController.html");
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        try {
            if (!h().exists()) {
                return false;
            }
            return IronSourceStorageUtils.renameFile(h().getPath(), d().getPath());
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final JSONObject f() {
        return new JSONObject() {
            {
                putOpt("controllerSourceStrategy", Integer.valueOf(f.this.b));
                putOpt("controllerSourceCode", Integer.valueOf(f.this.d.g));
            }
        };
    }
}
