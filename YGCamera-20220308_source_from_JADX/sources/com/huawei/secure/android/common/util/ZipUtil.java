package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

public class ZipUtil {

    /* renamed from: A */
    private static final int f1275A = 4096;

    /* renamed from: B */
    private static final String f1276B = "../";

    /* renamed from: C */
    private static final String f1277C = "..\\";
    private static final String TAG = "ZipUtil";

    /* renamed from: y */
    private static final int f1278y = 104857600;

    /* renamed from: z */
    private static final int f1279z = 100;

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, 104857600, 100, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v31, resolved type: int} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v4, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r7v25 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        android.util.Log.e(TAG, "unzip  over than top size");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d5, code lost:
        r3 = 0;
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d9, code lost:
        r7 = r8;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fa, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9 A[Catch:{ IOException -> 0x010e, all -> 0x010c }, ExcHandler: all (th java.lang.Throwable), Splitter:B:37:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0143  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unZip(java.lang.String r16, java.lang.String r17, long r18, int r20, boolean r21) throws com.huawei.secure.android.common.util.SecurityCommonException {
        /*
            r0 = r17
            java.lang.String r1 = "ZipUtil"
            boolean r2 = m1640a((java.lang.String) r16, (java.lang.String) r17, (long) r18, (int) r20)
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = java.io.File.separator
            boolean r2 = r0.endsWith(r2)
            if (r2 == 0) goto L_0x002f
            int r2 = r17.length()
            java.lang.String r4 = java.io.File.separator
            int r4 = r4.length()
            if (r2 <= r4) goto L_0x002f
            int r2 = r17.length()
            java.lang.String r4 = java.io.File.separator
            int r4 = r4.length()
            int r2 = r2 - r4
            java.lang.String r0 = r0.substring(r3, r2)
        L_0x002f:
            r2 = 1
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r4]
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7 = 0
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0121, all -> 0x011c }
            r9 = r16
            r8.<init>(r9)     // Catch:{ IOException -> 0x0121, all -> 0x011c }
            java.util.zip.ZipInputStream r9 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r10.<init>(r8)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r9.<init>(r10)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r2 = r7
            r10 = 1
            r11 = 0
        L_0x004e:
            java.util.zip.ZipEntry r12 = r9.getNextEntry()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            if (r12 == 0) goto L_0x0102
            java.lang.String r13 = r12.getName()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            java.lang.String r14 = "\\\\"
            java.lang.String r15 = "/"
            java.lang.String r13 = r13.replaceAll(r14, r15)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            java.io.File r14 = new java.io.File     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            r14.<init>(r0, r13)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            java.text.Normalizer$Form r15 = java.text.Normalizer.Form.NFKC     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            java.lang.String r13 = java.text.Normalizer.normalize(r13, r15)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            boolean r15 = m1650h(r13)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            if (r15 == 0) goto L_0x008c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            r0.<init>()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            java.lang.String r4 = "zipPath is a invalid path: "
            r0.append(r4)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            java.lang.String r4 = m1644d((java.lang.String) r13)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            r0.append(r4)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            android.util.Log.e(r1, r0)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            r10 = 0
            goto L_0x0102
        L_0x008c:
            if (r21 == 0) goto L_0x009d
            boolean r13 = r14.exists()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            if (r13 == 0) goto L_0x009d
            boolean r13 = r14.isFile()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            if (r13 == 0) goto L_0x009d
            m1643c(r14)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
        L_0x009d:
            boolean r12 = r12.isDirectory()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            if (r12 == 0) goto L_0x00aa
            m1646e((java.io.File) r14)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            r6.add(r14)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            goto L_0x00f2
        L_0x00aa:
            java.io.File r12 = r14.getParentFile()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            if (r12 == 0) goto L_0x00b9
            boolean r13 = r12.exists()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            if (r13 != 0) goto L_0x00b9
            m1646e((java.io.File) r12)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
        L_0x00b9:
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            r12.<init>(r14)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0100, all -> 0x00fe }
            r2.<init>(r12)     // Catch:{ IOException -> 0x0100, all -> 0x00fe }
        L_0x00c3:
            int r7 = r9.read(r5, r3, r4)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
            r13 = -1
            if (r7 == r13) goto L_0x00e4
            int r11 = r11 + r7
            long r3 = (long) r11
            int r13 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r13 <= 0) goto L_0x00dd
            java.lang.String r3 = "unzip  over than top size"
            android.util.Log.e(r1, r3)     // Catch:{ IOException -> 0x00d8, all -> 0x00f9 }
            r3 = 0
            r10 = 0
            goto L_0x00e4
        L_0x00d8:
            r0 = move-exception
            r7 = r8
            r3 = 0
            goto L_0x0125
        L_0x00dd:
            r3 = 0
            r2.write(r5, r3, r7)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x00c3
        L_0x00e4:
            r6.add(r14)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
            r2.flush()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r2)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r12)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
            r7 = r2
            r2 = r12
        L_0x00f2:
            r9.closeEntry()     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x004e
        L_0x00f9:
            r0 = move-exception
            goto L_0x0149
        L_0x00fc:
            r0 = move-exception
            goto L_0x011a
        L_0x00fe:
            r0 = move-exception
            goto L_0x014a
        L_0x0100:
            r0 = move-exception
            goto L_0x0110
        L_0x0102:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r9)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r8)     // Catch:{ IOException -> 0x010e, all -> 0x010c }
            m1637a((java.io.FileInputStream) r8, (java.io.BufferedOutputStream) r7, (java.util.zip.ZipInputStream) r9, (java.io.FileOutputStream) r2)
            goto L_0x0141
        L_0x010c:
            r0 = move-exception
            goto L_0x014b
        L_0x010e:
            r0 = move-exception
            r12 = r2
        L_0x0110:
            r2 = r7
            goto L_0x011a
        L_0x0112:
            r0 = move-exception
            r2 = r7
            r9 = r2
            goto L_0x014b
        L_0x0116:
            r0 = move-exception
            r2 = r7
            r9 = r2
            r12 = r9
        L_0x011a:
            r7 = r8
            goto L_0x0125
        L_0x011c:
            r0 = move-exception
            r2 = r7
            r8 = r2
            r9 = r8
            goto L_0x014b
        L_0x0121:
            r0 = move-exception
            r2 = r7
            r9 = r2
            r12 = r9
        L_0x0125:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
            r4.<init>()     // Catch:{ all -> 0x0147 }
            java.lang.String r5 = "Unzip IOException : "
            r4.append(r5)     // Catch:{ all -> 0x0147 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0147 }
            r4.append(r0)     // Catch:{ all -> 0x0147 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0147 }
            com.huawei.secure.android.common.util.LogsUtil.m1614e(r1, r0)     // Catch:{ all -> 0x0147 }
            m1637a((java.io.FileInputStream) r7, (java.io.BufferedOutputStream) r2, (java.util.zip.ZipInputStream) r9, (java.io.FileOutputStream) r12)
            r10 = 0
        L_0x0141:
            if (r10 != 0) goto L_0x0146
            m1641a((java.util.List<java.io.File>) r6)
        L_0x0146:
            return r10
        L_0x0147:
            r0 = move-exception
            r8 = r7
        L_0x0149:
            r7 = r2
        L_0x014a:
            r2 = r12
        L_0x014b:
            m1637a((java.io.FileInputStream) r8, (java.io.BufferedOutputStream) r7, (java.util.zip.ZipInputStream) r9, (java.io.FileOutputStream) r2)
            goto L_0x0150
        L_0x014f:
            throw r0
        L_0x0150:
            goto L_0x014f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.unZip(java.lang.String, java.lang.String, long, int, boolean):boolean");
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, 104857600, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        if (!m1640a(str, str2, j, i)) {
            return null;
        }
        if (str2.endsWith(File.separator) && str2.length() > File.separator.length()) {
            str2 = str2.substring(0, str2.length() - File.separator.length());
        }
        return m1636a(m1648f(str), m1648f(str2), j, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f6, code lost:
        if (r4 == false) goto L_0x00f8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x012a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.io.File> m1636a(java.io.File r17, java.io.File r18, long r19, boolean r21) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "ZipUtil"
            r3 = 0
            if (r0 == 0) goto L_0x012e
            if (r1 != 0) goto L_0x000d
            goto L_0x012e
        L_0x000d:
            r4 = 1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            java.util.zip.ZipFile r7 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0104, all -> 0x0101 }
            r7.<init>(r0)     // Catch:{ IOException -> 0x0104, all -> 0x0101 }
            java.util.Enumeration r0 = r7.entries()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            r8 = 0
        L_0x001e:
            boolean r9 = r0.hasMoreElements()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r9 == 0) goto L_0x00f3
            java.lang.Object r9 = r0.nextElement()     // Catch:{ IllegalArgumentException -> 0x00ec }
            java.util.zip.ZipEntry r9 = (java.util.zip.ZipEntry) r9     // Catch:{ IllegalArgumentException -> 0x00ec }
            java.lang.String r10 = r9.getName()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r11 == 0) goto L_0x0035
            goto L_0x001e
        L_0x0035:
            java.text.Normalizer$Form r11 = java.text.Normalizer.Form.NFKC     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            java.lang.String r10 = java.text.Normalizer.normalize(r10, r11)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            boolean r11 = m1650h(r10)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r11 == 0) goto L_0x005c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            r0.<init>()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            java.lang.String r1 = "zipPath is a invalid path: "
            r0.append(r1)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            java.lang.String r1 = m1644d((java.lang.String) r10)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            r0.append(r1)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            android.util.Log.e(r2, r0)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            r4 = 0
            goto L_0x00f3
        L_0x005c:
            java.lang.String r11 = "\\\\"
            java.lang.String r12 = "/"
            java.lang.String r10 = r10.replaceAll(r11, r12)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            java.io.File r11 = new java.io.File     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            r11.<init>(r1, r10)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r21 == 0) goto L_0x007a
            boolean r10 = r11.exists()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r10 == 0) goto L_0x007a
            boolean r10 = r11.isFile()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r10 == 0) goto L_0x007a
            m1643c(r11)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
        L_0x007a:
            r5.add(r11)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            boolean r10 = r9.isDirectory()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r10 == 0) goto L_0x0090
            boolean r9 = m1642b(r11)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r9 != 0) goto L_0x001e
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r7)
            m1641a((java.util.List<java.io.File>) r5)
            return r3
        L_0x0090:
            boolean r10 = m1638a((java.io.File) r11)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            if (r10 != 0) goto L_0x009d
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r7)
            m1641a((java.util.List<java.io.File>) r5)
            return r3
        L_0x009d:
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00df }
            java.io.InputStream r9 = r7.getInputStream(r9)     // Catch:{ all -> 0x00df }
            r10.<init>(r9)     // Catch:{ all -> 0x00df }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x00dc }
            r9.<init>(r11)     // Catch:{ all -> 0x00dc }
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00da }
            r11.<init>(r9)     // Catch:{ all -> 0x00da }
            r12 = 1024(0x400, float:1.435E-42)
            byte[] r12 = new byte[r12]     // Catch:{ all -> 0x00d7 }
        L_0x00b4:
            int r13 = r10.read(r12)     // Catch:{ all -> 0x00d7 }
            r14 = -1
            if (r13 == r14) goto L_0x00cc
            int r8 = r8 + r13
            long r14 = (long) r8     // Catch:{ all -> 0x00d7 }
            int r16 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r16 <= 0) goto L_0x00c8
            java.lang.String r12 = "unzipFileNew: over than top size"
            android.util.Log.e(r2, r12)     // Catch:{ all -> 0x00d7 }
            r4 = 0
            goto L_0x00cc
        L_0x00c8:
            r11.write(r12, r6, r13)     // Catch:{ all -> 0x00d7 }
            goto L_0x00b4
        L_0x00cc:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r11)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r9)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            goto L_0x001e
        L_0x00d7:
            r0 = move-exception
            r3 = r11
            goto L_0x00e2
        L_0x00da:
            r0 = move-exception
            goto L_0x00e2
        L_0x00dc:
            r0 = move-exception
            r9 = r3
            goto L_0x00e2
        L_0x00df:
            r0 = move-exception
            r9 = r3
            r10 = r9
        L_0x00e2:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r3)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r9)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            throw r0     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
        L_0x00ec:
            java.lang.String r9 = "entries.nextElement IllegalArgumentException"
            android.util.Log.e(r2, r9)     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            goto L_0x001e
        L_0x00f3:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r7)
            if (r4 != 0) goto L_0x0121
        L_0x00f8:
            m1641a((java.util.List<java.io.File>) r5)
            goto L_0x0121
        L_0x00fc:
            r0 = move-exception
            goto L_0x0125
        L_0x00fe:
            r0 = move-exception
            r3 = r7
            goto L_0x0105
        L_0x0101:
            r0 = move-exception
            r7 = r3
            goto L_0x0125
        L_0x0104:
            r0 = move-exception
        L_0x0105:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
            r1.<init>()     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = "unzip new IOException : "
            r1.append(r4)     // Catch:{ all -> 0x0122 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0122 }
            r1.append(r0)     // Catch:{ all -> 0x0122 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0122 }
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x0122 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r3)
            goto L_0x00f8
        L_0x0121:
            return r5
        L_0x0122:
            r0 = move-exception
            r7 = r3
            r4 = 0
        L_0x0125:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r7)
            if (r4 != 0) goto L_0x012d
            m1641a((java.util.List<java.io.File>) r5)
        L_0x012d:
            throw r0
        L_0x012e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.m1636a(java.io.File, java.io.File, long, boolean):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r2.lastIndexOf(java.io.File.separator);
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m1644d(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0007
            return r2
        L_0x0007:
            java.lang.String r0 = java.io.File.separator
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 != r1) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.m1644d(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static boolean m1638a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!m1642b(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(TAG, "createOrExistsFile IOException ");
            return false;
        }
    }

    /* renamed from: e */
    private static void m1647e(String str) {
        if (!TextUtils.isEmpty(str) && m1650h(str)) {
            Log.e(TAG, "IllegalArgumentException--path is not a standard path");
            throw new IllegalArgumentException("path is not a standard path");
        }
    }

    /* renamed from: b */
    private static boolean m1642b(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    /* renamed from: f */
    private static File m1648f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m1649g(str);
    }

    /* renamed from: g */
    private static File m1649g(String str) {
        m1647e(str);
        return new File(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071 A[SYNTHETIC, Splitter:B:29:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0077 A[SYNTHETIC, Splitter:B:33:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0045 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019 A[Catch:{ IOException -> 0x0051, all -> 0x004e }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m1639a(java.lang.String r12, long r13, int r15) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "ZipUtil"
            r2 = 0
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0056 }
            r4.<init>(r12)     // Catch:{ IOException -> 0x0056 }
            java.util.Enumeration r12 = r4.entries()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r5 = 0
            r3 = 0
        L_0x0012:
            boolean r7 = r12.hasMoreElements()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r8 = 1
            if (r7 == 0) goto L_0x0045
            java.lang.Object r7 = r12.nextElement()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            long r9 = r7.getSize()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            long r5 = r5 + r9
            int r3 = r3 + r8
            java.lang.String r8 = r7.getName()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            boolean r8 = m1650h(r8)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            if (r8 != 0) goto L_0x003f
            if (r3 >= r15) goto L_0x003f
            int r8 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r8 > 0) goto L_0x003f
            long r7 = r7.getSize()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0012
        L_0x003f:
            java.lang.String r12 = "File name is invalid or too many files or too big"
            com.huawei.secure.android.common.util.LogsUtil.m1614e(r1, r12)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            goto L_0x0046
        L_0x0045:
            r2 = 1
        L_0x0046:
            r4.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x0074
        L_0x004a:
            com.huawei.secure.android.common.util.LogsUtil.m1614e(r1, r0)
            goto L_0x0074
        L_0x004e:
            r12 = move-exception
            r3 = r4
            goto L_0x0075
        L_0x0051:
            r12 = move-exception
            r3 = r4
            goto L_0x0057
        L_0x0054:
            r12 = move-exception
            goto L_0x0075
        L_0x0056:
            r12 = move-exception
        L_0x0057:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r13.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r14 = "not a valid zip file, IOException : "
            r13.append(r14)     // Catch:{ all -> 0x0054 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x0054 }
            r13.append(r12)     // Catch:{ all -> 0x0054 }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x0054 }
            com.huawei.secure.android.common.util.LogsUtil.m1614e(r1, r12)     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x0074
            r3.close()     // Catch:{ IOException -> 0x004a }
        L_0x0074:
            return r2
        L_0x0075:
            if (r3 == 0) goto L_0x007e
            r3.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007e
        L_0x007b:
            com.huawei.secure.android.common.util.LogsUtil.m1614e(r1, r0)
        L_0x007e:
            goto L_0x0080
        L_0x007f:
            throw r12
        L_0x0080:
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.m1639a(java.lang.String, long, int):boolean");
    }

    /* renamed from: c */
    private static void m1643c(File file) {
        if (file != null) {
            if (file.isFile()) {
                m1645d(file);
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    m1645d(file);
                    return;
                }
                for (File c : listFiles) {
                    m1643c(c);
                }
                m1645d(file);
            }
        }
    }

    /* renamed from: a */
    private static boolean m1640a(String str, String str2, long j, int i) throws SecurityCommonException {
        if (TextUtils.isEmpty(str) || m1650h(str)) {
            LogsUtil.m1614e(TAG, "zip file is not valid");
            return false;
        } else if (TextUtils.isEmpty(str2) || m1650h(str2)) {
            LogsUtil.m1614e(TAG, "target directory is not valid");
            return false;
        } else if (m1639a(str, j, i)) {
            return true;
        } else {
            LogsUtil.m1614e(TAG, "zip file contains valid chars or too many files");
            throw new SecurityCommonException("unsecure zipfile!");
        }
    }

    /* renamed from: a */
    private static boolean m1641a(List<File> list) {
        try {
            for (File c : list) {
                m1643c(c);
            }
            return true;
        } catch (Exception e) {
            LogsUtil.m1614e(TAG, "unzip fail delete file failed" + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private static void m1637a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }

    /* renamed from: d */
    private static void m1645d(File file) {
        if (file != null && !file.delete()) {
            LogsUtil.m1614e(TAG, "delete file error");
        }
    }

    /* renamed from: e */
    private static void m1646e(File file) {
        if (file != null && !file.exists() && !file.mkdirs()) {
            LogsUtil.m1614e(TAG, "mkdirs error , files exists or IOException.");
        }
    }

    /* renamed from: h */
    private static boolean m1650h(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "isContainInvalidStr: name is null");
            return true;
        } else if (str.contains(f1276B) || str.contains(f1277C) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00")) {
            return true;
        } else {
            return false;
        }
    }
}
