package com.bytedance.sdk.component.d.c.a;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.component.d.b;
import java.io.File;

/* compiled from: CacheConfig */
public class a implements b, Cloneable {
    private static volatile b f;
    private long a;
    private int b;
    private boolean c;
    private boolean d;
    private File e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(int i, long j, File file) {
        this(i, j, i != 0, j != 0, file);
    }

    public a(int i, long j, boolean z, boolean z2, File file) {
        this.a = j;
        this.b = i;
        this.c = z;
        this.d = z2;
        this.e = file;
    }

    public static b a(File file) {
        long j;
        long j2;
        int i;
        file.mkdirs();
        if (f == null) {
            i = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            j2 = g();
            j = 16;
        } else {
            i = Math.min(f.b() / 2, 31457280);
            j2 = f.a();
            j = 2;
        }
        return new a(Math.max(i, 26214400), Math.max(Math.min(j2 / j, 41943040), 20971520), file);
    }

    public static void a(Context context, b bVar) {
        if (bVar != null) {
            f = bVar;
        } else {
            f = a(new File(context.getCacheDir(), "image"));
        }
    }

    public static b f() {
        return f;
    }

    private static long g() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public long a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public File e() {
        return this.e;
    }
}
