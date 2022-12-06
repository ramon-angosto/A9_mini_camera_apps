package com.apm.insight.l;

import com.apm.insight.h;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class f {
    public static File a(String str, int i, int i2) {
        File file = new File(o.a(h.g(), str), "logcat.txt");
        if (file.exists() && file.length() > 0) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.a(file.getAbsolutePath(), String.valueOf(i), String.valueOf(i2));
        return file;
    }

    public static void a() {
        try {
            a(h.f(), h.i().getLogcatDumpCount(), h.i().getLogcatLevel());
            b();
            d();
            c();
            e();
        } catch (Throwable unused) {
        }
    }

    public static File b() {
        File file = new File(o.e(h.g()), "maps.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.f(file.getAbsolutePath());
        return file;
    }

    public static File c() {
        File file = new File(o.e(h.g()), "meminfo.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.d(file.getAbsolutePath());
        return file;
    }

    public static File d() {
        File file = new File(o.e(h.g()), "fds.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.e(file.getAbsolutePath());
        return file;
    }

    public static File e() {
        File file = new File(o.e(h.g()), "threads.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.g(file.getAbsolutePath());
        return file;
    }

    public static File f() {
        BufferedReader bufferedReader;
        File file = new File(o.e(h.g()), "anr_trace.txt");
        if (file.exists() || !a.f()) {
            return file;
        }
        File file2 = new File("/data/anr/traces.txt");
        if (!file2.exists()) {
            return file;
        }
        BufferedWriter bufferedWriter = null;
        try {
            file.getParentFile().mkdirs();
            bufferedReader = new BufferedReader(new FileReader(file2));
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                int i = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            bufferedWriter2.write(readLine);
                            bufferedWriter2.write(10);
                            i += readLine.length();
                            if (i >= 1048576) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (IOException unused) {
                        bufferedWriter = bufferedWriter2;
                        k.a((Closeable) bufferedReader);
                        k.a((Closeable) bufferedWriter);
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        k.a((Closeable) bufferedReader);
                        k.a((Closeable) bufferedWriter);
                        throw th;
                    }
                }
                k.a((Closeable) bufferedReader);
                k.a((Closeable) bufferedWriter2);
            } catch (IOException unused2) {
                k.a((Closeable) bufferedReader);
                k.a((Closeable) bufferedWriter);
                return file;
            } catch (Throwable th2) {
                th = th2;
                k.a((Closeable) bufferedReader);
                k.a((Closeable) bufferedWriter);
                throw th;
            }
        } catch (IOException unused3) {
            bufferedReader = null;
            k.a((Closeable) bufferedReader);
            k.a((Closeable) bufferedWriter);
            return file;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            k.a((Closeable) bufferedReader);
            k.a((Closeable) bufferedWriter);
            throw th;
        }
        return file;
    }
}
