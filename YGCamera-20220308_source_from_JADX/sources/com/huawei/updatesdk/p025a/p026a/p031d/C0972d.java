package com.huawei.updatesdk.p025a.p026a.p031d;

import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.updatesdk.a.a.d.d */
public abstract class C0972d {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0076, code lost:
        if (r2 != null) goto L_0x0037;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050 A[Catch:{ NoSuchAlgorithmException -> 0x006f, FileNotFoundException -> 0x0065, IOException -> 0x005b, IllegalArgumentException -> 0x0051, IndexOutOfBoundsException -> 0x0047, all -> 0x0045, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005a A[Catch:{ NoSuchAlgorithmException -> 0x006f, FileNotFoundException -> 0x0065, IOException -> 0x005b, IllegalArgumentException -> 0x0051, IndexOutOfBoundsException -> 0x0047, all -> 0x0045, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0064 A[Catch:{ NoSuchAlgorithmException -> 0x006f, FileNotFoundException -> 0x0065, IOException -> 0x005b, IllegalArgumentException -> 0x0051, IndexOutOfBoundsException -> 0x0047, all -> 0x0045, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006e A[Catch:{ NoSuchAlgorithmException -> 0x006f, FileNotFoundException -> 0x0065, IOException -> 0x005b, IllegalArgumentException -> 0x0051, IndexOutOfBoundsException -> 0x0047, all -> 0x0045, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0081 A[SYNTHETIC, Splitter:B:55:0x0081] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m1691a(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "FileUtil"
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            java.security.MessageDigest r11 = java.security.MessageDigest.getInstance(r11)     // Catch:{ NoSuchAlgorithmException -> 0x006f, FileNotFoundException -> 0x0065, IOException -> 0x005b, IllegalArgumentException -> 0x0051, IndexOutOfBoundsException -> 0x0047, all -> 0x0045 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x006f, FileNotFoundException -> 0x0065, IOException -> 0x005b, IllegalArgumentException -> 0x0051, IndexOutOfBoundsException -> 0x0047, all -> 0x0045 }
            r2.<init>(r10)     // Catch:{ NoSuchAlgorithmException -> 0x006f, FileNotFoundException -> 0x0065, IOException -> 0x005b, IllegalArgumentException -> 0x0051, IndexOutOfBoundsException -> 0x0047, all -> 0x0045 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ NoSuchAlgorithmException -> 0x0043, FileNotFoundException -> 0x0041, IOException -> 0x003f, IllegalArgumentException -> 0x003d, IndexOutOfBoundsException -> 0x003b }
            r4 = 0
            r6 = r4
        L_0x001c:
            int r8 = r2.read(r10)     // Catch:{ NoSuchAlgorithmException -> 0x0043, FileNotFoundException -> 0x0041, IOException -> 0x003f, IllegalArgumentException -> 0x003d, IndexOutOfBoundsException -> 0x003b }
            r9 = -1
            if (r8 == r9) goto L_0x002a
            r9 = 0
            r11.update(r10, r9, r8)     // Catch:{ NoSuchAlgorithmException -> 0x0043, FileNotFoundException -> 0x0041, IOException -> 0x003f, IllegalArgumentException -> 0x003d, IndexOutOfBoundsException -> 0x003b }
            long r8 = (long) r8     // Catch:{ NoSuchAlgorithmException -> 0x0043, FileNotFoundException -> 0x0041, IOException -> 0x003f, IllegalArgumentException -> 0x003d, IndexOutOfBoundsException -> 0x003b }
            long r6 = r6 + r8
            goto L_0x001c
        L_0x002a:
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x0037
            byte[] r10 = r11.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0043, FileNotFoundException -> 0x0041, IOException -> 0x003f, IllegalArgumentException -> 0x003d, IndexOutOfBoundsException -> 0x003b }
            java.lang.String r10 = com.huawei.updatesdk.p025a.p026a.p031d.C0970b.m1687a(r10)     // Catch:{ NoSuchAlgorithmException -> 0x0043, FileNotFoundException -> 0x0041, IOException -> 0x003f, IllegalArgumentException -> 0x003d, IndexOutOfBoundsException -> 0x003b }
            r3 = r10
        L_0x0037:
            r2.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007c
        L_0x003b:
            r10 = move-exception
            goto L_0x0049
        L_0x003d:
            r10 = move-exception
            goto L_0x0053
        L_0x003f:
            r10 = move-exception
            goto L_0x005d
        L_0x0041:
            r10 = move-exception
            goto L_0x0067
        L_0x0043:
            r10 = move-exception
            goto L_0x0071
        L_0x0045:
            r10 = move-exception
            goto L_0x007f
        L_0x0047:
            r10 = move-exception
            r2 = r3
        L_0x0049:
            java.lang.String r11 = "getFileHashData IndexOutOfBoundsException"
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r11, r10)     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x007c
            goto L_0x0037
        L_0x0051:
            r10 = move-exception
            r2 = r3
        L_0x0053:
            java.lang.String r11 = "getFileHashData IllegalArgumentException"
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r11, r10)     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x007c
            goto L_0x0037
        L_0x005b:
            r10 = move-exception
            r2 = r3
        L_0x005d:
            java.lang.String r11 = "getFileHashData IOException"
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r11, r10)     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x007c
            goto L_0x0037
        L_0x0065:
            r10 = move-exception
            r2 = r3
        L_0x0067:
            java.lang.String r11 = "getFileHashData FileNotFoundException"
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r11, r10)     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x007c
            goto L_0x0037
        L_0x006f:
            r10 = move-exception
            r2 = r3
        L_0x0071:
            java.lang.String r11 = "getFileHashData NoSuchAlgorithmException"
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r11, r10)     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x007c
            goto L_0x0037
        L_0x0079:
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r1, r0)
        L_0x007c:
            return r3
        L_0x007d:
            r10 = move-exception
            r3 = r2
        L_0x007f:
            if (r3 == 0) goto L_0x0088
            r3.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0088
        L_0x0085:
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r1, r0)
        L_0x0088:
            goto L_0x008a
        L_0x0089:
            throw r10
        L_0x008a:
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p025a.p026a.p031d.C0972d.m1691a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static void m1692a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C0968a.m1681a("FileUtil", "Closeable exception", e);
            }
        }
    }

    /* renamed from: a */
    public static boolean m1693a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File a : listFiles) {
                m1693a(a);
            }
        }
        return file.delete();
    }
}
