package com.xiaomi.channel.commonutils.android;

public class c {
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            r1 = 0
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Exception -> 0x006c, all -> 0x0068 }
            java.io.InputStream r6 = r6.open(r7)     // Catch:{ Exception -> 0x006c, all -> 0x0068 }
            byte[] r7 = com.xiaomi.channel.commonutils.file.a.b(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            boolean r8 = r2.exists()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r8 == 0) goto L_0x0040
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r8.<init>(r2)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            byte[] r3 = com.xiaomi.channel.commonutils.file.a.b(r8)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            java.lang.String r3 = com.xiaomi.channel.commonutils.string.d.a((byte[]) r3)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            java.lang.String r4 = com.xiaomi.channel.commonutils.string.d.a((byte[]) r7)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            if (r5 != 0) goto L_0x0041
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            if (r3 == 0) goto L_0x0041
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r6)
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r8)
            com.xiaomi.channel.commonutils.file.a.a((java.io.OutputStream) r1)
            return r0
        L_0x0040:
            r8 = r1
        L_0x0041:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            r3.<init>(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            r3.write(r7)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r3.flush()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r7 = 1
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r6)
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r8)
            com.xiaomi.channel.commonutils.file.a.a((java.io.OutputStream) r3)
            return r7
        L_0x0057:
            r7 = move-exception
            goto L_0x007e
        L_0x0059:
            r7 = move-exception
            goto L_0x0066
        L_0x005b:
            r7 = move-exception
            goto L_0x007f
        L_0x005d:
            r7 = move-exception
            r3 = r1
            goto L_0x0066
        L_0x0060:
            r7 = move-exception
            r8 = r1
            goto L_0x007f
        L_0x0063:
            r7 = move-exception
            r8 = r1
            r3 = r8
        L_0x0066:
            r1 = r6
            goto L_0x006f
        L_0x0068:
            r7 = move-exception
            r6 = r1
            r8 = r6
            goto L_0x007f
        L_0x006c:
            r7 = move-exception
            r8 = r1
            r3 = r8
        L_0x006f:
            r7.printStackTrace()     // Catch:{ all -> 0x007c }
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r1)
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r8)
            com.xiaomi.channel.commonutils.file.a.a((java.io.OutputStream) r3)
            return r0
        L_0x007c:
            r7 = move-exception
            r6 = r1
        L_0x007e:
            r1 = r3
        L_0x007f:
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r6)
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r8)
            com.xiaomi.channel.commonutils.file.a.a((java.io.OutputStream) r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.c.a(android.content.Context, java.lang.String, java.lang.String):boolean");
    }
}
