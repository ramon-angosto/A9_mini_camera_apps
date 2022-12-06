package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.openadsdk.core.c;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: CpuUtils */
public class d {
    public static int a() {
        File[] listFiles;
        if (Build.VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 0);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || (listFiles = file.listFiles(new FilenameFilter() {
                private final Pattern a = Pattern.compile("^cpu[0-9]+$");

                public boolean accept(File file, String str) {
                    return this.a.matcher(str).matches();
                }
            })) == null) {
                return 0;
            }
            return Math.max(listFiles.length, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int a(Context context) {
        return c.a(context).b("cpu_count", 0);
    }

    public static int b(Context context) {
        return c.a(context).b("cpu_max_frequency", 0);
    }

    public static int c(Context context) {
        return c.a(context).b("cpu_min_frequency", 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[SYNTHETIC, Splitter:B:27:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[Catch:{ Exception -> 0x0003 }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0003 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = r0
        L_0x0003:
            int r7 = r7 + -1
            if (r7 < 0) goto L_0x006d
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x004c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ all -> 0x004c }
            r4.append(r7)     // Catch:{ all -> 0x004c }
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            r4.append(r5)     // Catch:{ all -> 0x004c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x004c }
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r0.readLine()     // Catch:{ all -> 0x0041 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x0038
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0041 }
            if (r2 <= r1) goto L_0x0038
            r1 = r2
        L_0x0038:
            r0.close()     // Catch:{ Exception -> 0x003e }
            r3.close()     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            r2 = r0
            r0 = r3
            goto L_0x0003
        L_0x0041:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r3
            r3 = r6
            goto L_0x004d
        L_0x0047:
            r0 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x004d
        L_0x004c:
            r3 = move-exception
        L_0x004d:
            java.lang.String r4 = "CpuUtils"
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0061 }
            com.bytedance.sdk.component.utils.l.e(r4, r3)     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ Exception -> 0x0003 }
        L_0x005b:
            if (r0 == 0) goto L_0x0003
            r0.close()     // Catch:{ Exception -> 0x0003 }
            goto L_0x0003
        L_0x0061:
            r7 = move-exception
            if (r2 == 0) goto L_0x0067
            r2.close()     // Catch:{ Exception -> 0x006c }
        L_0x0067:
            if (r0 == 0) goto L_0x006c
            r0.close()     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            throw r7
        L_0x006d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.d.a(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b A[SYNTHETIC, Splitter:B:28:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0060 A[Catch:{ Exception -> 0x0003 }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0003 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(int r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = r0
        L_0x0003:
            int r7 = r7 + -1
            if (r7 < 0) goto L_0x0070
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x004f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r4.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ all -> 0x004f }
            r4.append(r7)     // Catch:{ all -> 0x004f }
            java.lang.String r5 = "/cpufreq/cpuinfo_min_freq"
            r4.append(r5)     // Catch:{ all -> 0x004f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x004f }
            r3.<init>(r4)     // Catch:{ all -> 0x004f }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x004a }
            r0.<init>(r3)     // Catch:{ all -> 0x004a }
            java.lang.String r2 = r0.readLine()     // Catch:{ all -> 0x0044 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0044 }
            if (r4 != 0) goto L_0x003b
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0044 }
            if (r2 >= r1) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            if (r1 != 0) goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            r0.close()     // Catch:{ Exception -> 0x0041 }
            r3.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            r2 = r0
            r0 = r3
            goto L_0x0003
        L_0x0044:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r3
            r3 = r6
            goto L_0x0050
        L_0x004a:
            r0 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x0050
        L_0x004f:
            r3 = move-exception
        L_0x0050:
            java.lang.String r4 = "CpuUtils"
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0064 }
            com.bytedance.sdk.component.utils.l.e(r4, r3)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x005e
            r2.close()     // Catch:{ Exception -> 0x0003 }
        L_0x005e:
            if (r0 == 0) goto L_0x0003
            r0.close()     // Catch:{ Exception -> 0x0003 }
            goto L_0x0003
        L_0x0064:
            r7 = move-exception
            if (r2 == 0) goto L_0x006a
            r2.close()     // Catch:{ Exception -> 0x006f }
        L_0x006a:
            if (r0 == 0) goto L_0x006f
            r0.close()     // Catch:{ Exception -> 0x006f }
        L_0x006f:
            throw r7
        L_0x0070:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.d.b(int):int");
    }
}
