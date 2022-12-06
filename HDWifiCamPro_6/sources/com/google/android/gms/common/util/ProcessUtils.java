package com.google.android.gms.common.util;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class ProcessUtils {
    @Nullable
    private static String zza;
    private static int zzb;

    private ProcessUtils() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMyProcessName() {
        /*
            java.lang.String r0 = zza
            if (r0 != 0) goto L_0x005a
            int r0 = zzb
            if (r0 != 0) goto L_0x000e
            int r0 = android.os.Process.myPid()
            zzb = r0
        L_0x000e:
            r1 = 0
            if (r0 > 0) goto L_0x0012
            goto L_0x0058
        L_0x0012:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            r3 = 25
            r2.<init>(r3)     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            java.lang.String r3 = "/proc/"
            r2.append(r3)     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            r2.append(r0)     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            java.lang.String r0 = "/cmdline"
            r2.append(r0)     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            android.os.StrictMode$ThreadPolicy r2 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x004a }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x004a }
            r4.<init>(r0)     // Catch:{ all -> 0x004a }
            r3.<init>(r4)     // Catch:{ all -> 0x004a }
            android.os.StrictMode.setThreadPolicy(r2)     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            java.lang.String r0 = r3.readLine()     // Catch:{ IOException -> 0x0055, all -> 0x0047 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ IOException -> 0x0055, all -> 0x0047 }
            java.lang.String r1 = r0.trim()     // Catch:{ IOException -> 0x0055, all -> 0x0047 }
            goto L_0x0055
        L_0x0047:
            r0 = move-exception
            r1 = r3
            goto L_0x0050
        L_0x004a:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r2)     // Catch:{ IOException -> 0x0054, all -> 0x004f }
            throw r0     // Catch:{ IOException -> 0x0054, all -> 0x004f }
        L_0x004f:
            r0 = move-exception
        L_0x0050:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r1)
            throw r0
        L_0x0054:
            r3 = r1
        L_0x0055:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
        L_0x0058:
            zza = r1
        L_0x005a:
            java.lang.String r0 = zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.ProcessUtils.getMyProcessName():java.lang.String");
    }
}
