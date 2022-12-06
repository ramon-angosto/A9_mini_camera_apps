package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ai */
public class C1616ai {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m2513a(android.content.Context r5, java.lang.String r6, long r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 23
            if (r0 < r2) goto L_0x0010
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r0 = com.xiaomi.push.C1816g.m3673c(r5, r0)
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            r0 = 0
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.lang.String r4 = "/.vdevdir/"
            r2.<init>(r3, r4)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.lang.String r4 = "lcfp.lock"
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r3)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.lang.String r4 = "rw"
            r2.<init>(r3, r4)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.nio.channels.FileChannel r3 = r2.getChannel()     // Catch:{ IOException -> 0x0048 }
            java.nio.channels.FileLock r0 = r3.lock()     // Catch:{ IOException -> 0x0048 }
            boolean r5 = m2514b(r5, r6, r7)     // Catch:{ IOException -> 0x0048 }
            if (r0 == 0) goto L_0x0044
            boolean r6 = r0.isValid()
            if (r6 == 0) goto L_0x0044
            r0.release()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            return r5
        L_0x0048:
            r5 = move-exception
            goto L_0x004f
        L_0x004a:
            r5 = move-exception
            r2 = r0
            goto L_0x0062
        L_0x004d:
            r5 = move-exception
            r2 = r0
        L_0x004f:
            r5.printStackTrace()     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x005d
            boolean r5 = r0.isValid()
            if (r5 == 0) goto L_0x005d
            r0.release()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            return r1
        L_0x0061:
            r5 = move-exception
        L_0x0062:
            if (r0 == 0) goto L_0x006d
            boolean r6 = r0.isValid()
            if (r6 == 0) goto L_0x006d
            r0.release()     // Catch:{ IOException -> 0x006d }
        L_0x006d:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1616ai.m2513a(android.content.Context, java.lang.String, long):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00da A[Catch:{ IOException -> 0x00ea }, LOOP:1: B:47:0x00d4->B:49:0x00da, LOOP_END] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2514b(android.content.Context r16, java.lang.String r17, long r18) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = "/.vdevdir/"
            r0.<init>(r1, r2)
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "lcfp"
            r1.<init>(r0, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = r17
            r4.append(r5)
            java.lang.String r6 = ":"
            r4.append(r6)
            java.lang.String r7 = r16.getPackageName()
            r4.append(r7)
            java.lang.String r7 = ","
            r4.append(r7)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            boolean r8 = r1.exists()
            r10 = 1
            if (r8 == 0) goto L_0x00bc
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.io.FileReader r11 = new java.io.FileReader     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            r11.<init>(r1)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            r8.<init>(r11)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
        L_0x004e:
            java.lang.String r11 = r8.readLine()     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            if (r11 == 0) goto L_0x00a3
            java.lang.String[] r12 = r11.split(r6)     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            int r13 = r12.length     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            r14 = 2
            if (r13 == r14) goto L_0x005d
            goto L_0x004e
        L_0x005d:
            r13 = 0
            r15 = r12[r13]     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            java.lang.String r9 = java.lang.String.valueOf(r17)     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            boolean r9 = android.text.TextUtils.equals(r15, r9)     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            if (r9 == 0) goto L_0x009f
            r9 = r12[r10]     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            java.lang.String[] r9 = r9.split(r7)     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            int r11 = r9.length     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            if (r11 == r14) goto L_0x0074
            goto L_0x004e
        L_0x0074:
            r11 = r9[r10]     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            long r11 = java.lang.Long.parseLong(r11)     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            r9 = r9[r13]     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            java.lang.String r14 = r16.getPackageName()     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            boolean r9 = android.text.TextUtils.equals(r9, r14)     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            if (r9 != 0) goto L_0x004e
            long r11 = r2 - r11
            long r11 = java.lang.Math.abs(r11)     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            float r9 = (float) r11
            r11 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r18
            float r11 = (float) r11
            r12 = 1063675494(0x3f666666, float:0.9)
            float r11 = r11 * r12
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L_0x004e
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r8)
            return r13
        L_0x009f:
            r0.add(r11)     // Catch:{ Exception -> 0x00a9, all -> 0x00a7 }
            goto L_0x004e
        L_0x00a3:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r8)
            goto L_0x00c3
        L_0x00a7:
            r0 = move-exception
            goto L_0x00b8
        L_0x00a9:
            r9 = r8
            goto L_0x00af
        L_0x00ab:
            r0 = move-exception
            r8 = 0
            goto L_0x00b8
        L_0x00ae:
            r9 = 0
        L_0x00af:
            r0.clear()     // Catch:{ all -> 0x00b6 }
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r9)
            goto L_0x00c3
        L_0x00b6:
            r0 = move-exception
            r8 = r9
        L_0x00b8:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r8)
            throw r0
        L_0x00bc:
            boolean r2 = com.xiaomi.push.C1608aa.m2490a((java.io.File) r1)
            if (r2 != 0) goto L_0x00c3
            return r10
        L_0x00c3:
            r0.add(r4)
            java.io.BufferedWriter r9 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r2.<init>(r1)     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r9.<init>(r2)     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x00ea }
        L_0x00d4:
            boolean r1 = r0.hasNext()     // Catch:{ IOException -> 0x00ea }
            if (r1 == 0) goto L_0x00f8
            java.lang.Object r1 = r0.next()     // Catch:{ IOException -> 0x00ea }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x00ea }
            r9.write(r1)     // Catch:{ IOException -> 0x00ea }
            r9.newLine()     // Catch:{ IOException -> 0x00ea }
            r9.flush()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00d4
        L_0x00ea:
            r0 = move-exception
            goto L_0x00f1
        L_0x00ec:
            r0 = move-exception
            r9 = 0
            goto L_0x00fd
        L_0x00ef:
            r0 = move-exception
            r9 = 0
        L_0x00f1:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00fc }
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)     // Catch:{ all -> 0x00fc }
        L_0x00f8:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r9)
            return r10
        L_0x00fc:
            r0 = move-exception
        L_0x00fd:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r9)
            goto L_0x0102
        L_0x0101:
            throw r0
        L_0x0102:
            goto L_0x0101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1616ai.m2514b(android.content.Context, java.lang.String, long):boolean");
    }
}
