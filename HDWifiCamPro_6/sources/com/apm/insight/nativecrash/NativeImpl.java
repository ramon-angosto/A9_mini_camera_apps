package com.apm.insight.nativecrash;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.apm.insight.b.d;
import com.apm.insight.b.f;
import com.apm.insight.b.g;
import com.apm.insight.h;
import com.apm.insight.h.b;
import com.apm.insight.l.o;
import com.apm.insight.l.u;
import com.apm.insight.l.x;
import java.io.File;

public class NativeImpl {
    private static volatile boolean a = false;
    private static volatile boolean b = false;
    private static boolean c = true;

    public static int a(int i) {
        if (a && i >= 0) {
            try {
                return doLock("", i);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static String a(String str) {
        if (!a) {
            return null;
        }
        return doGetCrashHeader(str);
    }

    public static void a(int i, String str) {
        if (a && !TextUtils.isEmpty(str)) {
            try {
                doWriteFile(i, str, str.length());
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(long j) {
    }

    public static void a(File file) {
        if (a) {
            doRebuildTombstone(o.c(file).getAbsolutePath(), o.b(file).getAbsolutePath(), o.d(file).getAbsolutePath());
        }
    }

    public static void a(String str, String str2, String str3) {
        if (a) {
            try {
                doDumpLogcat(str, str2, str3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z) {
        c = z;
        if (a) {
            doSetResendSigQuit(z ? 1 : 0);
        }
    }

    public static boolean a() {
        if (b) {
            return a;
        }
        b = true;
        if (!a) {
            a = u.a("apminsighta");
        }
        return a;
    }

    public static boolean a(Context context) {
        String str;
        boolean a2 = a();
        if (a2) {
            String str2 = o.j(context) + "/apminsight";
            if (new File(context.getApplicationInfo().nativeLibraryDir, "libapminsightb.so").exists()) {
                str = context.getApplicationInfo().nativeLibraryDir;
            } else {
                str = b.a();
                b.b("apminsightb");
            }
            doStart(Build.VERSION.SDK_INT, str, str2, h.f(), h.l());
        }
        return a2;
    }

    public static int b() {
        if (!a) {
            return -1;
        }
        return doCreateCallbackThread();
    }

    public static void b(int i) {
        if (a) {
            try {
                doCloseFile(i);
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(long j) {
        if (a) {
            try {
                doSetAlogFlushAddr(j);
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str) {
        if (a) {
            doDumpHprof(str);
        }
    }

    public static int c(String str) {
        if (a && !TextUtils.isEmpty(str)) {
            try {
                return doLock(str, -1);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static long c(int i) {
        if (!a) {
            return 0;
        }
        return doGetThreadCpuTime(i);
    }

    public static void c() {
    }

    public static void c(long j) {
        if (a) {
            try {
                doSetAlogLogDirAddr(j);
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(String str) {
        if (a) {
            try {
                doDumpMemInfo(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean d() {
        if (!a) {
            return false;
        }
        try {
            return doCheckNativeCrash();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static native boolean doCheckNativeCrash();

    private static native void doCloseFile(int i);

    private static native int doCreateCallbackThread();

    private static native void doDump(String str);

    private static native void doDumpFds(String str);

    private static native void doDumpHprof(String str);

    private static native void doDumpLogcat(String str, String str2, String str3);

    private static native void doDumpMaps(String str);

    private static native void doDumpMemInfo(String str);

    private static native void doDumpThreads(String str);

    private static native long doGetAppCpuTime();

    private static native long doGetChildCpuTime();

    private static native String doGetCrashHeader(String str);

    private static native long doGetDeviceCpuTime();

    private static native int doGetFDCount();

    private static native String[] doGetFdDump(int i, int i2, int[] iArr, String[] strArr);

    private static native long doGetFreeMemory();

    private static native long doGetThreadCpuTime(int i);

    private static native int doGetThreadsCount();

    private static native long doGetTotalMemory();

    private static native long doGetVMSize();

    private static native void doInitThreadDump();

    private static native int doLock(String str, int i);

    private static native int doOpenFile(String str);

    private static native void doRebuildTombstone(String str, String str2, String str3);

    private static native void doSetAlogConfigPath(String str);

    private static native void doSetAlogFlushAddr(long j);

    private static native void doSetAlogLogDirAddr(long j);

    private static native void doSetResendSigQuit(int i);

    private static native void doSetUploadEnd();

    private static native void doSignalMainThread();

    private static native int doStart(int i, String str, String str2, String str3, int i2);

    private static native void doStartAnrMonitor(int i);

    private static native void doWriteFile(int i, String str, int i2);

    public static void e(String str) {
        if (a) {
            try {
                doDumpFds(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean e() {
        if (!a) {
            return false;
        }
        try {
            return is64Bit();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void f() {
        x.a(new Runnable() {
            public void run() {
                try {
                    NativeImpl.l();
                } catch (Throwable unused) {
                }
            }
        }, "NPTH-AnrMonitor");
    }

    public static void f(String str) {
        if (a) {
            try {
                doDumpMaps(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void g(String str) {
        if (a) {
            try {
                doDumpThreads(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean g() {
        return c;
    }

    public static int h(String str) {
        if (!a) {
            return -1;
        }
        try {
            return doOpenFile(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void h() {
        if (a) {
            doSignalMainThread();
        }
    }

    private static void handleNativeCrash(String str) {
        NativeCrashCollector.onNativeCrash(str);
    }

    public static void i() {
        if (a) {
            doSetUploadEnd();
        }
    }

    public static void i(String str) {
        if (a) {
            doDump(str);
        }
    }

    private static native boolean is64Bit();

    public static void j() {
        if (a) {
            doInitThreadDump();
        }
    }

    /* access modifiers changed from: private */
    public static void l() {
        if (a) {
            try {
                doStartAnrMonitor(Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
            }
        }
    }

    private static void reportEventForAnrMonitor() {
        try {
            System.currentTimeMillis();
            h.j();
            f.b(true);
            d.b();
            g.a(h.g()).a().e();
        } catch (Throwable unused) {
        }
    }
}
