package com.adcolony.sdk;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import com.adcolony.sdk.e0;
import java.io.File;

class v0 {
    private String a;
    private String b;
    private String c;
    private String d;
    private File e;
    private File f;
    private File g;

    v0() {
    }

    private long b(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    private long c(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? d(statFs) : (long) statFs.getBlockSize();
    }

    private long d(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    /* access modifiers changed from: package-private */
    public double a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return (double) (a(statFs) * c(statFs));
        } catch (RuntimeException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        k b2 = a.b();
        this.a = f() + "/adc3/";
        this.b = this.a + "media/";
        File file = new File(this.b);
        this.e = file;
        if (!file.isDirectory()) {
            this.e.delete();
            this.e.mkdirs();
        }
        if (!this.e.isDirectory()) {
            b2.b(true);
            return false;
        } else if (a(this.b) < 2.097152E7d) {
            new e0.a().a("Not enough memory available at media path, disabling AdColony.").a(e0.f);
            b2.b(true);
            return false;
        } else {
            this.c = f() + "/adc3/data/";
            File file2 = new File(this.c);
            this.f = file2;
            if (!file2.isDirectory()) {
                this.f.delete();
            }
            this.f.mkdirs();
            this.d = this.a + "tmp/";
            File file3 = new File(this.d);
            this.g = file3;
            if (!file3.isDirectory()) {
                this.g.delete();
                this.g.mkdirs();
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public String f() {
        Context a2 = a.a();
        if (a2 == null) {
            return "";
        }
        return a2.getFilesDir().getAbsolutePath();
    }

    /* access modifiers changed from: package-private */
    public f1 g() {
        if (!new File(a() + "AppVersion").exists()) {
            return c0.b();
        }
        return c0.c(a() + "AppVersion");
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        File file = this.e;
        if (file == null || this.f == null || this.g == null) {
            return false;
        }
        if (!file.isDirectory()) {
            this.e.delete();
        }
        if (!this.f.isDirectory()) {
            this.f.delete();
        }
        if (!this.g.isDirectory()) {
            this.g.delete();
        }
        this.e.mkdirs();
        this.f.mkdirs();
        this.g.mkdirs();
        return true;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.d;
    }

    private long a(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? b(statFs) : (long) statFs.getAvailableBlocks();
    }

    /* access modifiers changed from: package-private */
    public void a(f1 f1Var) {
        c0.j(f1Var, a() + "AppVersion");
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.a;
    }
}
