package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;

public class zzt {
    private static String zzauo;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[SYNTHETIC, Splitter:B:16:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051 A[SYNTHETIC, Splitter:B:22:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzcz(int r6) {
        /*
            java.lang.String r0 = "ProcessUtils"
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r5 = 25
            r4.<init>(r5)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.append(r6)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.String r6 = "/cmdline"
            r4.append(r6)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.String r6 = r4.toString()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r3.<init>(r6)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r2.<init>(r3)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.String r6 = r2.readLine()     // Catch:{ IOException -> 0x003a }
            java.lang.String r1 = r6.trim()     // Catch:{ IOException -> 0x003a }
            r2.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x004c
        L_0x0031:
            r6 = move-exception
            java.lang.String r2 = r6.getMessage()
            android.util.Log.w(r0, r2, r6)
            goto L_0x004c
        L_0x003a:
            r6 = move-exception
            goto L_0x0040
        L_0x003c:
            r6 = move-exception
            goto L_0x004f
        L_0x003e:
            r6 = move-exception
            r2 = r1
        L_0x0040:
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x004d }
            android.util.Log.e(r0, r3, r6)     // Catch:{ all -> 0x004d }
            if (r2 == 0) goto L_0x004c
            r2.close()     // Catch:{ Exception -> 0x0031 }
        L_0x004c:
            return r1
        L_0x004d:
            r6 = move-exception
            r1 = r2
        L_0x004f:
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x005d
        L_0x0055:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            android.util.Log.w(r0, r2, r1)
        L_0x005d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzt.zzcz(int):java.lang.String");
    }

    public static String zzvi() {
        return zzcz(Binder.getCallingPid());
    }

    public static String zzvj() {
        if (zzauo == null) {
            zzauo = zzcz(Process.myPid());
        }
        return zzauo;
    }
}
