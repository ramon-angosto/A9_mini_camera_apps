package ms.bd.o.Pgl;

import java.io.BufferedInputStream;

public class v0 {
    private static final String a = ((String) pblk.a(16777217, 0, 0, "316475", new byte[]{54, 39, 122, 78, 12}));

    static {
        String str = (String) pblk.a(16777217, 0, 0, "21ecdb", new byte[]{24, 111, 87, 73, 102});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(android.content.Context r26) {
        /*
            java.lang.Class<ms.bd.o.Pgl.v0> r1 = ms.bd.o.Pgl.v0.class
            monitor-enter(r1)
            r0 = 75
            r2 = 104(0x68, float:1.46E-43)
            r7 = 4
            r8 = 3
            r10 = 10
            r12 = 5
            r13 = 2
            r14 = 1
            r15 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r3.<init>()     // Catch:{ all -> 0x0125 }
            java.io.File r16 = r26.getFilesDir()     // Catch:{ all -> 0x0125 }
            java.lang.String r9 = r16.getAbsolutePath()     // Catch:{ all -> 0x0125 }
            r3.append(r9)     // Catch:{ all -> 0x0125 }
            r17 = 16777217(0x1000001, float:2.350989E-38)
            r18 = 0
            r19 = 0
            java.lang.String r21 = "0dac94"
            byte[] r9 = new byte[r14]     // Catch:{ all -> 0x0125 }
            r16 = 110(0x6e, float:1.54E-43)
            r9[r15] = r16     // Catch:{ all -> 0x0125 }
            r22 = r9
            java.lang.Object r9 = ms.bd.o.Pgl.pblk.a(r17, r18, r19, r21, r22)     // Catch:{ all -> 0x0125 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0125 }
            r3.append(r9)     // Catch:{ all -> 0x0125 }
            java.lang.String r9 = a     // Catch:{ all -> 0x0125 }
            r3.append(r9)     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0125 }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x0125 }
            r9.<init>(r3)     // Catch:{ all -> 0x0125 }
            boolean r9 = r9.exists()     // Catch:{ all -> 0x0125 }
            if (r9 == 0) goto L_0x005b
            java.lang.String r9 = a((java.lang.String) r3)     // Catch:{ all -> 0x0125 }
            if (r9 == 0) goto L_0x005b
            int r16 = r9.length()     // Catch:{ all -> 0x0125 }
            if (r16 <= 0) goto L_0x005b
            monitor-exit(r1)
            return r9
        L_0x005b:
            android.content.res.Resources r9 = r26.getResources()     // Catch:{ all -> 0x0125 }
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = a     // Catch:{ all -> 0x0125 }
            java.io.InputStream r4 = r9.open(r4)     // Catch:{ all -> 0x0125 }
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0125 }
            r9.<init>()     // Catch:{ all -> 0x0125 }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0125 }
        L_0x0072:
            r11 = 4096(0x1000, float:5.74E-42)
            int r11 = r4.read(r5, r15, r11)     // Catch:{ all -> 0x0125 }
            r6 = -1
            if (r11 == r6) goto L_0x007f
            r9.write(r5, r15, r11)     // Catch:{ all -> 0x0125 }
            goto L_0x0072
        L_0x007f:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0125 }
            r4.<init>(r3)     // Catch:{ all -> 0x0125 }
            byte[] r5 = r9.toByteArray()     // Catch:{ all -> 0x0125 }
            r4.write(r5)     // Catch:{ all -> 0x0125 }
            r4.close()     // Catch:{ all -> 0x0125 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r4.<init>()     // Catch:{ all -> 0x0125 }
            r20 = 16777217(0x1000001, float:2.350989E-38)
            r21 = 0
            r22 = 0
            java.lang.String r24 = "bba013"
            byte[] r5 = new byte[r10]     // Catch:{ all -> 0x0125 }
            r6 = 112(0x70, float:1.57E-43)
            r5[r15] = r6     // Catch:{ all -> 0x0125 }
            r5[r14] = r2     // Catch:{ all -> 0x0125 }
            r6 = 31
            r5[r13] = r6     // Catch:{ all -> 0x0125 }
            r5[r8] = r0     // Catch:{ all -> 0x0125 }
            r5[r7] = r10     // Catch:{ all -> 0x0125 }
            r6 = 100
            r5[r12] = r6     // Catch:{ all -> 0x0125 }
            r6 = 54
            r9 = 6
            r5[r9] = r6     // Catch:{ all -> 0x0125 }
            r6 = 20
            r9 = 7
            r5[r9] = r6     // Catch:{ all -> 0x0125 }
            r6 = 103(0x67, float:1.44E-43)
            r9 = 8
            r5[r9] = r6     // Catch:{ all -> 0x0125 }
            r6 = 32
            r9 = 9
            r5[r9] = r6     // Catch:{ all -> 0x0125 }
            r25 = r5
            java.lang.Object r5 = ms.bd.o.Pgl.pblk.a(r20, r21, r22, r24, r25)     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0125 }
            r4.append(r5)     // Catch:{ all -> 0x0125 }
            r4.append(r3)     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0125 }
            a((java.lang.String) r4)     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = a((java.lang.String) r3)     // Catch:{ all -> 0x0125 }
            if (r4 == 0) goto L_0x00eb
            int r5 = r4.length()     // Catch:{ all -> 0x0125 }
            if (r5 != 0) goto L_0x00e8
            goto L_0x00eb
        L_0x00e8:
            r6 = r1
            goto L_0x019a
        L_0x00eb:
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0125 }
            r20 = 16777217(0x1000001, float:2.350989E-38)
            r21 = 0
            r22 = 0
            java.lang.String r24 = "5ee262"
            byte[] r5 = new byte[r13]     // Catch:{ all -> 0x0125 }
            r6 = 54
            r5[r15] = r6     // Catch:{ all -> 0x0125 }
            r6 = 112(0x70, float:1.57E-43)
            r5[r14] = r6     // Catch:{ all -> 0x0125 }
            r25 = r5
            java.lang.Object r5 = ms.bd.o.Pgl.pblk.a(r20, r21, r22, r24, r25)     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0125 }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0125 }
            byte[] r5 = new byte[r14]     // Catch:{ all -> 0x0125 }
            r5[r15] = r13     // Catch:{ all -> 0x0125 }
            r6 = r1
            r0 = 16
            r4.seek(r0)     // Catch:{ all -> 0x0126 }
            r4.write(r5)     // Catch:{ all -> 0x0126 }
            r4.close()     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = a((java.lang.String) r3)     // Catch:{ all -> 0x0126 }
            goto L_0x019a
        L_0x0121:
            r0 = move-exception
            r6 = r1
            goto L_0x0207
        L_0x0125:
            r6 = r1
        L_0x0126:
            r0 = 20
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0206 }
            r1 = 118(0x76, float:1.65E-43)
            r0[r15] = r1     // Catch:{ all -> 0x0206 }
            r1 = 88
            r0[r14] = r1     // Catch:{ all -> 0x0206 }
            r1 = 29
            r0[r13] = r1     // Catch:{ all -> 0x0206 }
            r3 = 7
            r0[r8] = r3     // Catch:{ all -> 0x0206 }
            r4 = 83
            r0[r7] = r4     // Catch:{ all -> 0x0206 }
            r0[r12] = r1     // Catch:{ all -> 0x0206 }
            r1 = 17
            r4 = 6
            r0[r4] = r1     // Catch:{ all -> 0x0206 }
            r1 = 120(0x78, float:1.68E-43)
            r0[r3] = r1     // Catch:{ all -> 0x0206 }
            r1 = 64
            r3 = 8
            r0[r3] = r1     // Catch:{ all -> 0x0206 }
            r1 = 71
            r3 = 9
            r0[r3] = r1     // Catch:{ all -> 0x0206 }
            r1 = 22
            r0[r10] = r1     // Catch:{ all -> 0x0206 }
            r1 = 11
            r3 = 87
            r0[r1] = r3     // Catch:{ all -> 0x0206 }
            r1 = 12
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r1 = 13
            r3 = 105(0x69, float:1.47E-43)
            r0[r1] = r3     // Catch:{ all -> 0x0206 }
            r1 = 14
            r3 = 35
            r0[r1] = r3     // Catch:{ all -> 0x0206 }
            r1 = 15
            r3 = 27
            r0[r1] = r3     // Catch:{ all -> 0x0206 }
            r1 = 16
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r1 = 17
            r0[r1] = r14     // Catch:{ all -> 0x0206 }
            r1 = 18
            r2 = 61
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r1 = 19
            r2 = 95
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r20 = 16777217(0x1000001, float:2.350989E-38)
            r21 = 0
            r22 = 0
            java.lang.String r24 = "7a2227"
            r25 = r0
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r20, r21, r22, r24, r25)     // Catch:{ all -> 0x0206 }
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0206 }
        L_0x019a:
            if (r4 == 0) goto L_0x01a2
            int r0 = r4.length()     // Catch:{ all -> 0x0206 }
            if (r0 != 0) goto L_0x0204
        L_0x01a2:
            r0 = 16
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0206 }
            r1 = 36
            r0[r15] = r1     // Catch:{ all -> 0x0206 }
            r1 = 91
            r0[r14] = r1     // Catch:{ all -> 0x0206 }
            r1 = 25
            r0[r13] = r1     // Catch:{ all -> 0x0206 }
            r1 = 87
            r0[r8] = r1     // Catch:{ all -> 0x0206 }
            r0[r7] = r12     // Catch:{ all -> 0x0206 }
            r1 = 75
            r0[r12] = r1     // Catch:{ all -> 0x0206 }
            r1 = 67
            r2 = 6
            r0[r2] = r1     // Catch:{ all -> 0x0206 }
            r1 = 113(0x71, float:1.58E-43)
            r2 = 7
            r0[r2] = r1     // Catch:{ all -> 0x0206 }
            r1 = 85
            r2 = 8
            r0[r2] = r1     // Catch:{ all -> 0x0206 }
            r1 = 9
            r2 = 29
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r1 = 70
            r0[r10] = r1     // Catch:{ all -> 0x0206 }
            r1 = 11
            r2 = 91
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r1 = 12
            r2 = 25
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r1 = 13
            r2 = 87
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r1 = 14
            r0[r1] = r12     // Catch:{ all -> 0x0206 }
            r1 = 15
            r2 = 75
            r0[r1] = r2     // Catch:{ all -> 0x0206 }
            r20 = 16777217(0x1000001, float:2.350989E-38)
            r21 = 0
            r22 = 0
            java.lang.String r24 = "eb6bda"
            r25 = r0
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r20, r21, r22, r24, r25)     // Catch:{ all -> 0x0206 }
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0206 }
        L_0x0204:
            monitor-exit(r6)
            return r4
        L_0x0206:
            r0 = move-exception
        L_0x0207:
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.o.Pgl.v0.a(android.content.Context):java.lang.String");
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception unused) {
                String str = (String) pblk.a(16777217, 0, 0, "a9d4e1", new byte[]{117, 50, 20});
            }
        } while (read >= 4096);
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        r14 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f6, code lost:
        if (r5 != null) goto L_0x00f8;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c6 A[SYNTHETIC, Splitter:B:44:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00df A[SYNTHETIC, Splitter:B:49:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fe A[SYNTHETIC, Splitter:B:57:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0117 A[SYNTHETIC, Splitter:B:62:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r14) {
        /*
            r0 = 1
            r1 = 0
            r2 = 2
            r3 = 0
            r4 = 5
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x009b, all -> 0x0097 }
            r6 = 16777217(0x1000001, float:2.350989E-38)
            r7 = 0
            r8 = 0
            java.lang.String r10 = "564c77"
            byte[] r11 = new byte[r2]     // Catch:{ Exception -> 0x009b, all -> 0x0097 }
            r12 = 55
            r11[r1] = r12     // Catch:{ Exception -> 0x009b, all -> 0x0097 }
            r12 = 60
            r11[r0] = r12     // Catch:{ Exception -> 0x009b, all -> 0x0097 }
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r6, r7, r8, r10, r11)     // Catch:{ Exception -> 0x009b, all -> 0x0097 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x009b, all -> 0x0097 }
            java.lang.Process r5 = r5.exec(r6)     // Catch:{ Exception -> 0x009b, all -> 0x0097 }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x009c, all -> 0x0095 }
            java.io.OutputStream r7 = r5.getOutputStream()     // Catch:{ Exception -> 0x009c, all -> 0x0095 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x009c, all -> 0x0095 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0093 }
            java.io.InputStream r8 = r5.getInputStream()     // Catch:{ Exception -> 0x0093 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0093 }
            byte[] r14 = r14.getBytes()     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            r6.write(r14)     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            r14 = 10
            r6.write(r14)     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            r6.flush()     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            r6.close()     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            r5.waitFor()     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            java.lang.String r14 = a((java.io.BufferedInputStream) r7)     // Catch:{ Exception -> 0x008d, all -> 0x0089 }
            if (r14 == 0) goto L_0x0058
            r14.length()     // Catch:{ Exception -> 0x0056, all -> 0x0089 }
            goto L_0x0058
        L_0x0056:
            r3 = r14
            goto L_0x008d
        L_0x0058:
            r6.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x006f
        L_0x005c:
            byte[] r13 = new byte[r4]
            r13 = {33, 51, 66, 46, 8} // fill-array
            r8 = 16777217(0x1000001, float:2.350989E-38)
            r9 = 0
            r10 = 0
            java.lang.String r12 = "582e22"
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r8, r9, r10, r12, r13)
            java.lang.String r0 = (java.lang.String) r0
        L_0x006f:
            r7.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x00f8
        L_0x0074:
            byte[] r13 = new byte[r4]
            r13 = {33, 106, 65, 121, 95} // fill-array
            r8 = 16777217(0x1000001, float:2.350989E-38)
            r9 = 0
            r10 = 0
            java.lang.String r12 = "5a12ee"
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r8, r9, r10, r12, r13)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00f8
        L_0x0089:
            r14 = move-exception
            r3 = r7
            goto L_0x00fc
        L_0x008d:
            r14 = r3
            r3 = r7
            goto L_0x009e
        L_0x0090:
            r14 = move-exception
            goto L_0x00fc
        L_0x0093:
            r14 = r3
            goto L_0x009e
        L_0x0095:
            r14 = move-exception
            goto L_0x0099
        L_0x0097:
            r14 = move-exception
            r5 = r3
        L_0x0099:
            r6 = r3
            goto L_0x00fc
        L_0x009b:
            r5 = r3
        L_0x009c:
            r14 = r3
            r6 = r14
        L_0x009e:
            r7 = 16777217(0x1000001, float:2.350989E-38)
            r8 = 0
            r9 = 0
            java.lang.String r11 = "8b78b1"
            byte[] r12 = new byte[r4]     // Catch:{ all -> 0x0090 }
            r13 = 44
            r12[r1] = r13     // Catch:{ all -> 0x0090 }
            r1 = 105(0x69, float:1.47E-43)
            r12[r0] = r1     // Catch:{ all -> 0x0090 }
            r0 = 71
            r12[r2] = r0     // Catch:{ all -> 0x0090 }
            r0 = 3
            r1 = 115(0x73, float:1.61E-43)
            r12[r0] = r1     // Catch:{ all -> 0x0090 }
            r0 = 4
            r1 = 88
            r12[r0] = r1     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r7, r8, r9, r11, r12)     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0090 }
            if (r6 == 0) goto L_0x00dd
            r6.close()     // Catch:{ IOException -> 0x00ca }
            goto L_0x00dd
        L_0x00ca:
            byte[] r12 = new byte[r4]
            r12 = {33, 61, 73, 41, 91} // fill-array
            r7 = 16777217(0x1000001, float:2.350989E-38)
            r8 = 0
            r9 = 0
            java.lang.String r11 = "569ba3"
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r7, r8, r9, r11, r12)
            java.lang.String r0 = (java.lang.String) r0
        L_0x00dd:
            if (r3 == 0) goto L_0x00f6
            r3.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00f6
        L_0x00e3:
            byte[] r11 = new byte[r4]
            r11 = {45, 58, 65, 115, 3} // fill-array
            r6 = 16777217(0x1000001, float:2.350989E-38)
            r7 = 0
            r8 = 0
            java.lang.String r10 = "91189d"
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r6, r7, r8, r10, r11)
            java.lang.String r0 = (java.lang.String) r0
        L_0x00f6:
            if (r5 == 0) goto L_0x00fb
        L_0x00f8:
            r5.destroy()
        L_0x00fb:
            return r14
        L_0x00fc:
            if (r6 == 0) goto L_0x0115
            r6.close()     // Catch:{ IOException -> 0x0102 }
            goto L_0x0115
        L_0x0102:
            byte[] r12 = new byte[r4]
            r12 = {33, 61, 73, 122, 94} // fill-array
            r7 = 16777217(0x1000001, float:2.350989E-38)
            r8 = 0
            r9 = 0
            java.lang.String r11 = "5691da"
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r7, r8, r9, r11, r12)
            java.lang.String r0 = (java.lang.String) r0
        L_0x0115:
            if (r3 == 0) goto L_0x012e
            r3.close()     // Catch:{ IOException -> 0x011b }
            goto L_0x012e
        L_0x011b:
            byte[] r11 = new byte[r4]
            r11 = {32, 105, 72, 127, 94} // fill-array
            r6 = 16777217(0x1000001, float:2.350989E-38)
            r7 = 0
            r8 = 0
            java.lang.String r10 = "4b84d2"
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r6, r7, r8, r10, r11)
            java.lang.String r0 = (java.lang.String) r0
        L_0x012e:
            if (r5 == 0) goto L_0x0133
            r5.destroy()
        L_0x0133:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.o.Pgl.v0.a(java.lang.String):java.lang.String");
    }
}
