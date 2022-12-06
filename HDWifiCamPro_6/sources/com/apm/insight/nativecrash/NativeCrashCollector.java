package com.apm.insight.nativecrash;

import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.b;
import com.apm.insight.runtime.o;

public class NativeCrashCollector {
    public static int a() {
        return 6;
    }

    private static void a(String str, Thread thread) {
        for (ICrashCallback onCrash : o.a().d()) {
            try {
                onCrash.onCrash(CrashType.NATIVE, "", thread);
            } catch (Throwable th) {
                b.a().a("NPTH_CATCH", th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c A[Catch:{ all -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.String r0 = "main"
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x0022
            android.os.Looper r6 = android.os.Looper.getMainLooper()
            java.lang.Thread r6 = r6.getThread()
            java.lang.StackTraceElement[] r6 = r6.getStackTrace()
            java.lang.String r6 = com.apm.insight.l.v.a((java.lang.StackTraceElement[]) r6)
            return r6
        L_0x0022:
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.ThreadGroup r0 = r0.getThreadGroup()
            int r2 = r0.activeCount()
            int r3 = r2 / 2
            int r2 = r2 + r3
            java.lang.Thread[] r2 = new java.lang.Thread[r2]
            int r0 = r0.enumerate(r2)
            r3 = 0
        L_0x003c:
            if (r3 >= r0) goto L_0x006a
            r4 = r2[r3]
            java.lang.String r4 = r4.getName()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0067
            boolean r5 = r4.equals(r6)
            if (r5 != 0) goto L_0x005c
            boolean r5 = r4.startsWith(r6)
            if (r5 != 0) goto L_0x005c
            boolean r4 = r4.endsWith(r6)
            if (r4 == 0) goto L_0x0067
        L_0x005c:
            r6 = r2[r3]
            java.lang.StackTraceElement[] r6 = r6.getStackTrace()
            java.lang.String r6 = com.apm.insight.l.v.a((java.lang.StackTraceElement[]) r6)
            return r6
        L_0x0067:
            int r3 = r3 + 1
            goto L_0x003c
        L_0x006a:
            java.util.Map r0 = java.lang.Thread.getAllStackTraces()     // Catch:{ all -> 0x00a9 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x00a9 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a9 }
        L_0x0076:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x00b3
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00a9 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00a9 }
            java.lang.Thread r3 = (java.lang.Thread) r3     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x00a9 }
            boolean r4 = r3.equals(r6)     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x009e
            boolean r4 = r3.startsWith(r6)     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x009e
            boolean r3 = r3.endsWith(r6)     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0076
        L_0x009e:
            java.lang.Object r6 = r2.getValue()     // Catch:{ all -> 0x00a9 }
            java.lang.StackTraceElement[] r6 = (java.lang.StackTraceElement[]) r6     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = com.apm.insight.l.v.a((java.lang.StackTraceElement[]) r6)     // Catch:{ all -> 0x00a9 }
            return r6
        L_0x00a9:
            r6 = move-exception
            com.apm.insight.c r0 = com.apm.insight.b.a()
            java.lang.String r2 = "NPTH_CATCH"
            r0.a((java.lang.String) r2, (java.lang.Throwable) r6)
        L_0x00b3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.NativeCrashCollector.b(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void onNativeCrash(final java.lang.String r10) {
        /*
            java.lang.String r0 = "crash_cost"
            java.lang.String r1 = ""
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = "[onNativeCrash] enter"
            com.apm.insight.l.q.a((java.lang.Object) r4)
            r4 = 0
            com.apm.insight.k.b r5 = com.apm.insight.k.b.a()     // Catch:{ all -> 0x0080 }
            r5.b()     // Catch:{ all -> 0x0080 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0080 }
            java.io.File r6 = com.apm.insight.l.o.a()     // Catch:{ all -> 0x0080 }
            java.lang.String r7 = com.apm.insight.h.f()     // Catch:{ all -> 0x0080 }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x0080 }
            java.io.File r5 = com.apm.insight.l.o.e((java.io.File) r5)     // Catch:{ all -> 0x0080 }
            com.apm.insight.runtime.a.f r6 = com.apm.insight.runtime.a.f.a()     // Catch:{ all -> 0x0080 }
            com.apm.insight.CrashType r7 = com.apm.insight.CrashType.NATIVE     // Catch:{ all -> 0x0080 }
            com.apm.insight.nativecrash.NativeCrashCollector$1 r8 = new com.apm.insight.nativecrash.NativeCrashCollector$1     // Catch:{ all -> 0x0080 }
            r8.<init>(r10, r5, r2)     // Catch:{ all -> 0x0080 }
            r10 = 1
            com.apm.insight.entity.a r10 = r6.a(r7, r4, r8, r10)     // Catch:{ all -> 0x0080 }
            org.json.JSONObject r6 = r10.h()     // Catch:{ all -> 0x0080 }
            if (r6 == 0) goto L_0x008a
            int r7 = r6.length()     // Catch:{ all -> 0x0080 }
            if (r7 == 0) goto L_0x008a
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0080 }
            long r2 = r7 - r2
            java.lang.String r9 = "java_end"
            r6.put(r9, r7)     // Catch:{ all -> 0x005e }
            java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x005e }
            r10.b((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x005e }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r7
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x005e }
            r10.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x005e }
        L_0x005e:
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r0.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r5.getAbsolutePath()     // Catch:{ all -> 0x0080 }
            r0.append(r2)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = ".tmp"
            r0.append(r2)     // Catch:{ all -> 0x0080 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0080 }
            r10.<init>(r0)     // Catch:{ all -> 0x0080 }
            r0 = 0
            com.apm.insight.l.i.a((java.io.File) r10, (org.json.JSONObject) r6, (boolean) r0)     // Catch:{ all -> 0x0080 }
            r10.renameTo(r5)     // Catch:{ all -> 0x0080 }
            goto L_0x008a
        L_0x0080:
            r10 = move-exception
            com.apm.insight.c r0 = com.apm.insight.b.a()     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = "NPTH_CATCH"
            r0.a((java.lang.String) r2, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0091 }
        L_0x008a:
            android.os.SystemClock.uptimeMillis()
            a(r1, r4)
            return
        L_0x0091:
            r10 = move-exception
            android.os.SystemClock.uptimeMillis()
            a(r1, r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.NativeCrashCollector.onNativeCrash(java.lang.String):void");
    }
}
