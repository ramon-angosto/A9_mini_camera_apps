package com.apm.insight.h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.apm.insight.l.i;
import com.apm.insight.l.k;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class c {
    private static List<String> a = new ArrayList();

    public static String a(Context context, String str, File file) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String a2 = a(applicationInfo.sourceDir, str, file);
        if (a2 == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 21) {
            return "low";
        }
        String str2 = a2;
        for (String a3 : applicationInfo.splitSourceDirs) {
            str2 = a(a3, str, file);
            if (str2 == null) {
                return null;
            }
        }
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            while (!(classLoader instanceof BaseDexClassLoader) && classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
            }
            if (!(classLoader instanceof BaseDexClassLoader)) {
                return str2;
            }
            Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField2.setAccessible(true);
            for (String file2 : (String[]) declaredField2.get(obj)) {
                File file3 = new File(file2, System.mapLibraryName(str));
                if (file3.exists()) {
                    i.a(file3, file);
                    k.a(file.getAbsolutePath(), 493);
                    return null;
                }
            }
            return "not_found";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static String a(String str, String str2, File file) {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            zipFile = new ZipFile(new File(str), 1);
            try {
                ZipEntry entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str2));
                if (entry == null) {
                    int indexOf = Build.CPU_ABI.indexOf(45);
                    StringBuilder sb = new StringBuilder();
                    sb.append("lib/");
                    String str3 = Build.CPU_ABI;
                    if (indexOf <= 0) {
                        indexOf = Build.CPU_ABI.length();
                    }
                    sb.append(str3.substring(0, indexOf));
                    sb.append("/");
                    sb.append(System.mapLibraryName(str2));
                    String sb2 = sb.toString();
                    ZipEntry entry2 = zipFile.getEntry(sb2);
                    if (entry2 == null) {
                        message = "Library entry not found:" + sb2;
                        k.a((Closeable) null);
                        k.a((Closeable) null);
                        k.a(zipFile);
                        return message;
                    }
                    entry = entry2;
                }
                file.createNewFile();
                InputStream inputStream2 = zipFile.getInputStream(entry);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    inputStream = inputStream2;
                    th = th2;
                    try {
                        message = th.getMessage();
                        k.a((Closeable) fileOutputStream2);
                        k.a((Closeable) inputStream);
                        k.a(zipFile);
                        return message;
                    } catch (Throwable th3) {
                        k.a((Closeable) fileOutputStream2);
                        k.a((Closeable) inputStream);
                        k.a(zipFile);
                        throw th3;
                    }
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            k.a(file.getAbsolutePath(), 493);
                            k.a((Closeable) fileOutputStream);
                            k.a((Closeable) inputStream2);
                            k.a(zipFile);
                            return null;
                        }
                    }
                } catch (Throwable th4) {
                    fileOutputStream2 = fileOutputStream;
                    inputStream = inputStream2;
                    th = th4;
                    message = th.getMessage();
                    k.a((Closeable) fileOutputStream2);
                    k.a((Closeable) inputStream);
                    k.a(zipFile);
                    return message;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                message = th.getMessage();
                k.a((Closeable) fileOutputStream2);
                k.a((Closeable) inputStream);
                k.a(zipFile);
                return message;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            zipFile = null;
            message = th.getMessage();
            k.a((Closeable) fileOutputStream2);
            k.a((Closeable) inputStream);
            k.a(zipFile);
            return message;
        }
    }
}
