package sg.bigo.ads.common.utils;

import java.io.File;
import java.io.IOException;

public final class e {
    public static long a(long j, int i) {
        char c;
        if (i == 1) {
            return j;
        }
        if (i == 2) {
            c = 10;
        } else if (i == 3) {
            c = 20;
        } else if (i != 4) {
            return j;
        } else {
            c = 30;
        }
        return j >> c;
    }

    public static long a(String str, int i) {
        File file = new File(str);
        if (file.exists()) {
            return a(file.length(), i);
        }
        return 0;
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        return file.delete();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        if (r3 != null) goto L_0x0031;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067 A[SYNTHETIC, Splitter:B:25:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r7) {
        /*
            java.lang.String r0 = "FileUtils"
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            r7 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0037 }
            r3.read(r2)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0037 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r2 = "ftyp"
            boolean r2 = r4.contains(r2)     // Catch:{ Exception -> 0x0037 }
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = "moov"
            boolean r2 = r4.contains(r2)     // Catch:{ Exception -> 0x0037 }
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = "contains ftyp moov"
            r4 = 3
            sg.bigo.ads.common.k.a.a(r7, r4, r0, r2)     // Catch:{ Exception -> 0x0037 }
            r7 = 1
        L_0x0031:
            r3.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0064
        L_0x0035:
            r7 = move-exception
            goto L_0x0065
        L_0x0037:
            r2 = move-exception
            goto L_0x0040
        L_0x0039:
            r7 = move-exception
            r3 = r2
            goto L_0x0065
        L_0x003c:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0040:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "read file "
            r4.<init>(r5)     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = r1.getPath()     // Catch:{ all -> 0x0035 }
            r4.append(r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = " failed"
            r4.append(r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = r2.getMessage()     // Catch:{ all -> 0x0035 }
            r4.append(r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0035 }
            sg.bigo.ads.common.k.a.a(r7, r0, r1)     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x0064
            goto L_0x0031
        L_0x0064:
            return r7
        L_0x0065:
            if (r3 == 0) goto L_0x006a
            r3.close()     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.utils.e.a(java.lang.String):boolean");
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str, str2);
        try {
            boolean mkdirs = !file.exists() ? file.mkdirs() : true;
            return !file2.exists() ? mkdirs && file2.createNewFile() : mkdirs;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void b(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        b(file2);
                    } else {
                        a(file2);
                    }
                }
            }
        }
        a(file);
    }

    public static boolean b(String str) {
        if (o.b(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean b(String str, String str2) {
        if (o.b(str) || o.b(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static String c(String str) {
        return str + ".tmp";
    }

    public static void c(String str, String str2) {
        if (!o.b(str) && !o.b(str2)) {
            File file = new File(str, str2);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
        }
    }

    public static boolean c(File file) {
        try {
            File parentFile = file.getParentFile();
            boolean mkdirs = !parentFile.exists() ? parentFile.mkdirs() : true;
            return !file.exists() ? mkdirs && file.createNewFile() : mkdirs;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String d(String str) {
        return str + ".tmp";
    }
}
