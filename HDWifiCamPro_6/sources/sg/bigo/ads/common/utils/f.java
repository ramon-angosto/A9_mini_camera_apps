package sg.bigo.ads.common.utils;

import java.io.Closeable;
import java.io.File;

public final class f {
    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        if (r2 != null) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.InputStream r6) {
        /*
            java.lang.String r0 = ""
            if (r6 != 0) goto L_0x0005
            return r0
        L_0x0005:
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r2.<init>()     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x0026 }
        L_0x000f:
            int r3 = r6.read(r1)     // Catch:{ IOException -> 0x0026 }
            r4 = -1
            if (r3 == r4) goto L_0x001b
            r4 = 0
            r2.write(r1, r4, r3)     // Catch:{ IOException -> 0x0026 }
            goto L_0x000f
        L_0x001b:
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x0026 }
            a((java.io.Closeable) r6)
        L_0x0022:
            a((java.io.Closeable) r2)
            goto L_0x0038
        L_0x0026:
            r1 = move-exception
            goto L_0x002f
        L_0x0028:
            r0 = move-exception
            r2 = r1
            goto L_0x003a
        L_0x002b:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x002f:
            r1.printStackTrace()     // Catch:{ all -> 0x0039 }
            a((java.io.Closeable) r6)
            if (r2 == 0) goto L_0x0038
            goto L_0x0022
        L_0x0038:
            return r0
        L_0x0039:
            r0 = move-exception
        L_0x003a:
            a((java.io.Closeable) r6)
            if (r2 == 0) goto L_0x0042
            a((java.io.Closeable) r2)
        L_0x0042:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.utils.f.a(java.io.InputStream):java.lang.String");
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011d, code lost:
        sg.bigo.ads.common.k.a.b("IOUtils", "close file " + r14.getPath() + " failed");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ff */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0119 A[SYNTHETIC, Splitter:B:48:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0138 A[SYNTHETIC, Splitter:B:56:0x0138] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(java.io.File r14) {
        /*
            java.lang.String r0 = " failed, data's length is 0."
            java.lang.String r1 = "read "
            java.lang.String r2 = ", fileName="
            java.lang.String r3 = "close file "
            java.lang.String r4 = " failed"
            java.lang.String r5 = "IOUtils"
            java.io.File r6 = a((java.io.File) r14)
            boolean r7 = r6.exists()
            if (r7 == 0) goto L_0x001c
            r14.delete()
            r6.renameTo(r14)
        L_0x001c:
            boolean r6 = r14.exists()
            r7 = 0
            if (r6 != 0) goto L_0x0024
            return r7
        L_0x0024:
            r6 = 0
            long r8 = r14.length()     // Catch:{ Exception -> 0x00fe, all -> 0x00fb }
            int r8 = (int) r8     // Catch:{ Exception -> 0x00fe, all -> 0x00fb }
            if (r8 == 0) goto L_0x0054
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00fe, all -> 0x00fb }
            r9.<init>(r14)     // Catch:{ Exception -> 0x00fe, all -> 0x00fb }
            byte[] r10 = new byte[r8]     // Catch:{ Exception -> 0x00ff }
            int r11 = r9.read(r10)     // Catch:{ Exception -> 0x00ff }
            if (r11 != r8) goto L_0x0055
            r9.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0053
        L_0x003d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r3)
            java.lang.String r14 = r14.getPath()
            r0.append(r14)
            r0.append(r4)
            java.lang.String r14 = r0.toString()
            sg.bigo.ads.common.k.a.b(r5, r14)
        L_0x0053:
            return r10
        L_0x0054:
            r9 = r7
        L_0x0055:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ff }
            java.lang.String r11 = "readFileLocked length="
            r10.<init>(r11)     // Catch:{ Exception -> 0x00ff }
            r10.append(r8)     // Catch:{ Exception -> 0x00ff }
            r10.append(r2)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r8 = r14.getName()     // Catch:{ Exception -> 0x00ff }
            r10.append(r8)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x00ff }
            r10 = 3
            sg.bigo.ads.common.k.a.a(r6, r10, r5, r8)     // Catch:{ Exception -> 0x00ff }
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00ff }
            r8.<init>()     // Catch:{ Exception -> 0x00ff }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ff }
            r11.<init>(r14)     // Catch:{ Exception -> 0x00ff }
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
        L_0x007f:
            int r12 = r11.read(r9)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r13 = -1
            if (r12 == r13) goto L_0x008a
            r8.write(r9, r6, r12)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            goto L_0x007f
        L_0x008a:
            byte[] r8 = r8.toByteArray()     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.String r12 = "readFileLocked data="
            r9.<init>(r12)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            int r12 = r8.length     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r9.append(r12)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r9.append(r2)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.String r2 = r14.getName()     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r9.append(r2)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.String r2 = r9.toString()     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            sg.bigo.ads.common.k.a.a(r6, r10, r5, r2)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            int r2 = r8.length     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            if (r2 == 0) goto L_0x00c8
            r11.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00c7
        L_0x00b1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r3)
            java.lang.String r14 = r14.getPath()
            r0.append(r14)
            r0.append(r4)
            java.lang.String r14 = r0.toString()
            sg.bigo.ads.common.k.a.b(r5, r14)
        L_0x00c7:
            return r8
        L_0x00c8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.String r8 = r14.getName()     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r2.append(r8)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r2.append(r0)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            sg.bigo.ads.common.k.a.a(r6, r5, r2)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.String r1 = r14.getName()     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r8.append(r1)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r8.append(r0)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
            throw r2     // Catch:{ Exception -> 0x00f9, all -> 0x00f7 }
        L_0x00f7:
            r0 = move-exception
            goto L_0x0136
        L_0x00f9:
            r9 = r11
            goto L_0x00ff
        L_0x00fb:
            r0 = move-exception
            r11 = r7
            goto L_0x0136
        L_0x00fe:
            r9 = r7
        L_0x00ff:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            java.lang.String r1 = "read file "
            r0.<init>(r1)     // Catch:{ all -> 0x0134 }
            java.lang.String r1 = r14.getPath()     // Catch:{ all -> 0x0134 }
            r0.append(r1)     // Catch:{ all -> 0x0134 }
            r0.append(r4)     // Catch:{ all -> 0x0134 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0134 }
            sg.bigo.ads.common.k.a.a(r6, r5, r0)     // Catch:{ all -> 0x0134 }
            if (r9 == 0) goto L_0x0133
            r9.close()     // Catch:{ IOException -> 0x011d }
            goto L_0x0133
        L_0x011d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r3)
            java.lang.String r14 = r14.getPath()
            r0.append(r14)
            r0.append(r4)
            java.lang.String r14 = r0.toString()
            sg.bigo.ads.common.k.a.b(r5, r14)
        L_0x0133:
            return r7
        L_0x0134:
            r0 = move-exception
            r11 = r9
        L_0x0136:
            if (r11 == 0) goto L_0x0152
            r11.close()     // Catch:{ IOException -> 0x013c }
            goto L_0x0152
        L_0x013c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r14 = r14.getPath()
            r1.append(r14)
            r1.append(r4)
            java.lang.String r14 = r1.toString()
            sg.bigo.ads.common.k.a.b(r5, r14)
        L_0x0152:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.utils.f.b(java.io.File):byte[]");
    }
}
