package com.apm.insight.l;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.insight.b.f;
import com.apm.insight.runtime.a.b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONObject;

public final class a {
    private static String a = null;
    private static Class<?> b = null;
    private static Field c = null;
    private static Field d = null;
    private static boolean e = false;

    private static long a(int i) {
        if (i < 0) {
            return 0;
        }
        return ((long) i) * 1024;
    }

    public static ActivityManager.ProcessErrorStateInfo a(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        int myPid = Process.myPid();
        int i2 = 0;
        while (i2 < i) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo next : processesInErrorState) {
                    if (next.pid == myPid && next.condition == 2) {
                        return next;
                    }
                }
            }
            i2++;
            if (i == i2 || f.a()) {
                break;
            }
            SystemClock.sleep(200);
        }
        return null;
    }

    private static String a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read > 0) {
                        sb.append((char) read);
                    } else {
                        String sb2 = sb.toString();
                        k.a((Closeable) bufferedReader);
                        return sb2;
                    }
                }
            } catch (Throwable unused) {
                k.a((Closeable) bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            k.a((Closeable) bufferedReader);
            return null;
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            a(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                b(jSONObject, activityManager);
            }
            a(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        a = str;
    }

    private static void a(JSONObject jSONObject) {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", a(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", a(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", a(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
                if (!TextUtils.isEmpty(memoryStat)) {
                    jSONObject2.put("summary.graphics", a(Integer.parseInt(memoryStat)));
                }
            } catch (Throwable unused) {
            }
        }
        jSONObject2.put("totalPrivateClean", c.a(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", c.b(memoryInfo));
        jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", a(c.c(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    private static void a(JSONObject jSONObject, ActivityManager activityManager) {
        JSONObject jSONObject2 = new JSONObject();
        boolean z = true;
        com.apm.insight.entity.a.a(jSONObject, "filters", "native_heap_leak", String.valueOf(Debug.getNativeHeapAllocatedSize() > 209715200));
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long freeMemory = runtime.freeMemory();
        long j = runtime.totalMemory();
        jSONObject2.put("max_memory", maxMemory);
        jSONObject2.put("free_memory", freeMemory);
        jSONObject2.put("total_memory", j);
        if (((float) (j - freeMemory)) <= ((float) maxMemory) * 0.95f) {
            z = false;
        }
        com.apm.insight.entity.a.a(jSONObject, "filters", "java_heap_leak", String.valueOf(z));
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    public static boolean a(Context context) {
        return context == null ? b.d().f() : b.d().f() || f(context);
    }

    private static void b(JSONObject jSONObject, ActivityManager activityManager) {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", n.a(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    public static boolean b(Context context) {
        String c2 = c(context);
        if (c2 != null && c2.contains(":")) {
            return false;
        }
        if (c2 == null || !c2.equals(context.getPackageName())) {
            return c2 != null && c2.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
                    if (next.pid == myPid) {
                        a = next.processName;
                        return a;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        a = a();
        String str = a;
        return str == null ? "" : str;
    }

    public static String d(Context context) {
        Class<?> g = g(context);
        if (c == null && g != null) {
            try {
                c = g.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = c;
        if (field == null) {
            return "";
        }
        try {
            return String.valueOf(field.get((Object) null));
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static int e(Context context) {
        Class<?> g = g(context);
        if (d == null && g != null) {
            try {
                d = g.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = d;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get((Object) null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r5 = r5.get(0).topActivity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean f(android.content.Context r5) {
        /*
            java.lang.String r0 = r5.getPackageName()
            r1 = 0
            java.lang.String r2 = "activity"
            java.lang.Object r5 = r5.getSystemService(r2)     // Catch:{ all -> 0x005d }
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch:{ all -> 0x005d }
            if (r5 != 0) goto L_0x0010
            return r1
        L_0x0010:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005d }
            r3 = 21
            if (r2 >= r3) goto L_0x0038
            r2 = 1
            java.util.List r5 = r5.getRunningTasks(r2)     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x005d
            boolean r3 = r5.isEmpty()     // Catch:{ all -> 0x005d }
            if (r3 != 0) goto L_0x005d
            java.lang.Object r5 = r5.get(r1)     // Catch:{ all -> 0x005d }
            android.app.ActivityManager$RunningTaskInfo r5 = (android.app.ActivityManager.RunningTaskInfo) r5     // Catch:{ all -> 0x005d }
            android.content.ComponentName r5 = r5.topActivity     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x005d
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x005d }
            boolean r5 = r0.equals(r5)     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x005d
            return r2
        L_0x0038:
            java.util.List r5 = r5.getRunningAppProcesses()     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x005d
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x005d }
        L_0x0042:
            boolean r2 = r5.hasNext()     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x005d
            java.lang.Object r2 = r5.next()     // Catch:{ all -> 0x005d }
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch:{ all -> 0x005d }
            int r3 = r2.importance     // Catch:{ all -> 0x005d }
            r4 = 100
            if (r3 != r4) goto L_0x0042
            java.lang.String[] r5 = r2.pkgList     // Catch:{ all -> 0x005d }
            r5 = r5[r1]     // Catch:{ all -> 0x005d }
            boolean r5 = r0.equals(r5)     // Catch:{ all -> 0x005d }
            return r5
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.l.a.f(android.content.Context):boolean");
    }

    private static Class<?> g(Context context) {
        if (b == null && !e) {
            try {
                b = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            e = true;
        }
        return b;
    }
}
