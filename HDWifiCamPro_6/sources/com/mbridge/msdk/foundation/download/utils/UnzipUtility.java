package com.mbridge.msdk.foundation.download.utils;

public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "UnzipUtility";

    /* JADX WARNING: Removed duplicated region for block: B:82:0x0109 A[SYNTHETIC, Splitter:B:82:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0117 A[SYNTHETIC, Splitter:B:87:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0127 A[SYNTHETIC, Splitter:B:94:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0135 A[SYNTHETIC, Splitter:B:99:0x0135] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int unzip(java.lang.String r11, java.lang.String r12) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "UnzipUtility"
            r1 = -1
            if (r11 == 0) goto L_0x0142
            if (r12 != 0) goto L_0x0009
            goto L_0x0142
        L_0x0009:
            java.lang.String r2 = "/"
            boolean r3 = r12.endsWith(r2)
            if (r3 != 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            r3.append(r2)
            java.lang.String r12 = r3.toString()
        L_0x0020:
            java.io.File r2 = new java.io.File
            r2.<init>(r11)
            boolean r11 = r2.exists()
            if (r11 != 0) goto L_0x002d
            r11 = 1
            return r11
        L_0x002d:
            r11 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00fd, all -> 0x00fa }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00fd, all -> 0x00fa }
            java.util.Enumeration r2 = r3.entries()     // Catch:{ IOException -> 0x00fd, all -> 0x00fa }
            r4 = r11
        L_0x0038:
            boolean r5 = r2.hasMoreElements()     // Catch:{ IOException -> 0x00f8 }
            r6 = 0
            if (r5 == 0) goto L_0x00d8
            java.lang.Object r5 = r2.nextElement()     // Catch:{ IOException -> 0x00f8 }
            java.util.zip.ZipEntry r5 = (java.util.zip.ZipEntry) r5     // Catch:{ IOException -> 0x00f8 }
            if (r5 != 0) goto L_0x0065
            r12 = 2
            if (r11 == 0) goto L_0x0056
            r11.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0056
        L_0x004e:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)
        L_0x0056:
            if (r4 == 0) goto L_0x0064
            r4.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0064
        L_0x005c:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)
        L_0x0064:
            return r12
        L_0x0065:
            java.lang.String r7 = r5.getName()     // Catch:{ IOException -> 0x00f8 }
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x00f8 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f8 }
            r9.<init>()     // Catch:{ IOException -> 0x00f8 }
            r9.append(r12)     // Catch:{ IOException -> 0x00f8 }
            r9.append(r7)     // Catch:{ IOException -> 0x00f8 }
            java.lang.String r7 = r9.toString()     // Catch:{ IOException -> 0x00f8 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x00f8 }
            java.lang.String r7 = r8.getCanonicalPath()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0084
        L_0x0082:
            java.lang.String r7 = ""
        L_0x0084:
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x00f8 }
            if (r9 != 0) goto L_0x0038
            java.lang.String r9 = ".."
            boolean r9 = r7.startsWith(r9)     // Catch:{ IOException -> 0x00f8 }
            if (r9 != 0) goto L_0x0038
            java.lang.String r9 = "../"
            boolean r7 = r7.startsWith(r9)     // Catch:{ IOException -> 0x00f8 }
            if (r7 != 0) goto L_0x0038
            boolean r7 = r5.isDirectory()     // Catch:{ IOException -> 0x00f8 }
            if (r7 == 0) goto L_0x00a4
            r8.mkdirs()     // Catch:{ IOException -> 0x00f8 }
            goto L_0x0038
        L_0x00a4:
            java.io.File r7 = r8.getParentFile()     // Catch:{ IOException -> 0x00f8 }
            boolean r7 = r7.exists()     // Catch:{ IOException -> 0x00f8 }
            if (r7 != 0) goto L_0x00b5
            java.io.File r7 = r8.getParentFile()     // Catch:{ IOException -> 0x00f8 }
            r7.mkdirs()     // Catch:{ IOException -> 0x00f8 }
        L_0x00b5:
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00f8 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x00f8 }
            java.io.InputStream r11 = r3.getInputStream(r5)     // Catch:{ IOException -> 0x00d5, all -> 0x00d2 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch:{ IOException -> 0x00d5, all -> 0x00d2 }
        L_0x00c2:
            int r8 = r11.read(r5, r6, r4)     // Catch:{ IOException -> 0x00d5, all -> 0x00d2 }
            if (r8 == r1) goto L_0x00cf
            r7.write(r5, r6, r8)     // Catch:{ IOException -> 0x00d5, all -> 0x00d2 }
            r7.flush()     // Catch:{ IOException -> 0x00d5, all -> 0x00d2 }
            goto L_0x00c2
        L_0x00cf:
            r4 = r7
            goto L_0x0038
        L_0x00d2:
            r12 = move-exception
            r4 = r7
            goto L_0x0125
        L_0x00d5:
            r12 = move-exception
            r4 = r7
            goto L_0x00ff
        L_0x00d8:
            r3.close()     // Catch:{ IOException -> 0x00f8 }
            if (r11 == 0) goto L_0x00e9
            r11.close()     // Catch:{ IOException -> 0x00e1 }
            goto L_0x00e9
        L_0x00e1:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)
        L_0x00e9:
            if (r4 == 0) goto L_0x00f7
            r4.close()     // Catch:{ IOException -> 0x00ef }
            goto L_0x00f7
        L_0x00ef:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)
        L_0x00f7:
            return r6
        L_0x00f8:
            r12 = move-exception
            goto L_0x00ff
        L_0x00fa:
            r12 = move-exception
            r4 = r11
            goto L_0x0125
        L_0x00fd:
            r12 = move-exception
            r4 = r11
        L_0x00ff:
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x0124 }
            com.mbridge.msdk.foundation.tools.q.d(r0, r12)     // Catch:{ all -> 0x0124 }
            r12 = 3
            if (r11 == 0) goto L_0x0115
            r11.close()     // Catch:{ IOException -> 0x010d }
            goto L_0x0115
        L_0x010d:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)
        L_0x0115:
            if (r4 == 0) goto L_0x0123
            r4.close()     // Catch:{ IOException -> 0x011b }
            goto L_0x0123
        L_0x011b:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)
        L_0x0123:
            return r12
        L_0x0124:
            r12 = move-exception
        L_0x0125:
            if (r11 == 0) goto L_0x0133
            r11.close()     // Catch:{ IOException -> 0x012b }
            goto L_0x0133
        L_0x012b:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)
        L_0x0133:
            if (r4 == 0) goto L_0x0141
            r4.close()     // Catch:{ IOException -> 0x0139 }
            goto L_0x0141
        L_0x0139:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)
        L_0x0141:
            throw r12
        L_0x0142:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.utils.UnzipUtility.unzip(java.lang.String, java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void extractFile(java.util.zip.ZipInputStream r4, java.lang.String r5) throws java.io.IOException {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            java.io.File r5 = r0.getParentFile()
            boolean r5 = r5.exists()
            if (r5 != 0) goto L_0x0016
            java.io.File r5 = r0.getParentFile()
            r5.mkdirs()
        L_0x0016:
            r5 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x003d }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003d }
            r2.<init>(r0)     // Catch:{ IOException -> 0x003d }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003d }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
        L_0x0025:
            int r0 = r4.read(r5)     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            r2 = -1
            if (r0 == r2) goto L_0x0031
            r2 = 0
            r1.write(r5, r2, r0)     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            goto L_0x0025
        L_0x0031:
            r1.close()
            return
        L_0x0035:
            r4 = move-exception
            r5 = r1
            goto L_0x0044
        L_0x0038:
            r4 = move-exception
            r5 = r1
            goto L_0x003e
        L_0x003b:
            r4 = move-exception
            goto L_0x0044
        L_0x003d:
            r4 = move-exception
        L_0x003e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x003b }
            r0.<init>(r4)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x0044:
            if (r5 == 0) goto L_0x0049
            r5.close()
        L_0x0049:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.utils.UnzipUtility.extractFile(java.util.zip.ZipInputStream, java.lang.String):void");
    }
}
