package com.apm.insight.l;

import com.apm.insight.h.a;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

public final class k {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, int i) {
        a.a("android.os.FileUtils", "setPermissions", str, Integer.valueOf(i), -1, -1);
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }
}
