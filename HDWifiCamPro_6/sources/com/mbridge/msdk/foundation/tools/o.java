package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.c.e;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: SameFileTool */
public final class o extends e {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A[SYNTHETIC, Splitter:B:24:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e A[SYNTHETIC, Splitter:B:28:0x003e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long c(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x0032 }
            if (r3 == 0) goto L_0x001b
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0032 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0032 }
            int r4 = r3.available()     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            long r0 = (long) r4
            r2 = r3
            goto L_0x0025
        L_0x0015:
            r4 = move-exception
            r2 = r3
            goto L_0x003c
        L_0x0018:
            r4 = move-exception
            r2 = r3
            goto L_0x0033
        L_0x001b:
            r4.createNewFile()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r4 = "获取文件大小"
            java.lang.String r3 = "文件不存在!"
            com.mbridge.msdk.foundation.tools.q.d(r4, r3)     // Catch:{ Exception -> 0x0032 }
        L_0x0025:
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x003b
        L_0x002b:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x003b
        L_0x0030:
            r4 = move-exception
            goto L_0x003c
        L_0x0032:
            r4 = move-exception
        L_0x0033:
            r4.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ Exception -> 0x002b }
        L_0x003b:
            return r0
        L_0x003c:
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ Exception -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0046:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.c(java.io.File):long");
    }

    private static long d(File file) throws Exception {
        long j;
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    j = d(listFiles[i]);
                } else {
                    j = c(listFiles[i]);
                }
                j2 += j;
            }
        }
        return j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        if (r1 == null) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004e A[SYNTHETIC, Splitter:B:30:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0034 }
            r4.<init>()     // Catch:{ IOException -> 0x0034 }
        L_0x0013:
            java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x0032 }
            if (r2 == 0) goto L_0x002e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0032 }
            r3.<init>()     // Catch:{ IOException -> 0x0032 }
            r3.append(r2)     // Catch:{ IOException -> 0x0032 }
            java.lang.String r2 = "\n"
            r3.append(r2)     // Catch:{ IOException -> 0x0032 }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0032 }
            r4.append(r2)     // Catch:{ IOException -> 0x0032 }
            goto L_0x0013
        L_0x002e:
            r1.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0043
        L_0x0032:
            r2 = move-exception
            goto L_0x003d
        L_0x0034:
            r2 = move-exception
            r4 = r0
            goto L_0x003d
        L_0x0037:
            r4 = move-exception
            r1 = r0
            goto L_0x004c
        L_0x003a:
            r2 = move-exception
            r4 = r0
            r1 = r4
        L_0x003d:
            r2.printStackTrace()     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0043
            goto L_0x002e
        L_0x0043:
            if (r4 == 0) goto L_0x004a
            java.lang.String r4 = r4.toString()
            return r4
        L_0x004a:
            return r0
        L_0x004b:
            r4 = move-exception
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.a(java.io.File):java.lang.String");
    }

    public static boolean a(String str) {
        if (e.a(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public static File[] b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a() {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    if (a.e().g() != null) {
                        String b = com.mbridge.msdk.foundation.same.b.e.b(c.MBRIDGE_VC);
                        try {
                            File file = new File(b);
                            if (file.exists() && file.isDirectory()) {
                                for (File file2 : o.b(b)) {
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.b.a b = b.a().b(a.e().h());
                if (b == null) {
                    b = b.a().b();
                }
                long currentTimeMillis = System.currentTimeMillis() - ((long) (b.w() * 1000));
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (file2.lastModified() + currentTimeMillis < currentTimeMillis2) {
                                b(file2);
                                try {
                                    File file3 = new File(str + ".zip");
                                    if (file3.exists() && file3.isFile()) {
                                        b(file3);
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void b() {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    com.mbridge.msdk.b.a b = b.a().b(a.e().h());
                    if (b == null) {
                        b = b.a().b();
                    }
                    o.a(com.mbridge.msdk.foundation.same.b.e.b(c.MBRIDGE_RES_MANAGER_DIR), b.d());
                    o.a(System.currentTimeMillis() - ((long) (b.w() * 1000)));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static String b(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            } else if (!file.isDirectory()) {
                return "";
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length != 0) {
                        for (File b : listFiles) {
                            b(b);
                        }
                        file.delete();
                        return "";
                    }
                }
                file.delete();
                return "";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private static ArrayList<File> e(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                if (!file.isHidden() || file.isDirectory()) {
                    return true;
                }
                return false;
            }
        })) {
            if (!file2.isDirectory()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(e(file2));
            }
        }
        return arrayList;
    }

    private static void d(String str) {
        try {
            ArrayList<File> e = e(new File(str));
            Collections.sort(e, new Comparator<File>() {
                public final boolean equals(Object obj) {
                    return true;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    int i = ((((File) obj).lastModified() - ((File) obj2).lastModified()) > 0 ? 1 : ((((File) obj).lastModified() - ((File) obj2).lastModified()) == 0 ? 0 : -1));
                    if (i > 0) {
                        return 1;
                    }
                    return i == 0 ? 0 : -1;
                }
            });
            int size = (e.size() - 1) / 2;
            for (int i = 0; i < size; i++) {
                File file = e.get(i);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            q.d("SameFileTool", "del memory failed");
        }
    }

    public static void a(long j) {
        try {
            Iterator<File> it = e(new File(com.mbridge.msdk.foundation.same.b.e.b(c.MBRIDGE_RES_MANAGER_DIR))).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.lastModified() < j && next.exists() && next.isFile()) {
                    next.delete();
                }
            }
        } catch (Throwable th) {
            q.a("SameFileTool", th.getMessage(), th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0035 A[SYNTHETIC, Splitter:B:24:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0040 A[SYNTHETIC, Splitter:B:30:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(byte[] r2, java.io.File r3) {
        /*
            r0 = 0
            java.io.File r1 = r3.getParentFile()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0014
            boolean r1 = r3.exists()     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0014
            java.io.File r1 = r3.getParentFile()     // Catch:{ Exception -> 0x002e }
            r1.mkdirs()     // Catch:{ Exception -> 0x002e }
        L_0x0014:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002e }
            r1.<init>(r3)     // Catch:{ Exception -> 0x002e }
            r1.write(r2)     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            r1.close()     // Catch:{ IOException -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0024:
            r2 = 1
            return r2
        L_0x0026:
            r2 = move-exception
            r0 = r1
            goto L_0x003e
        L_0x0029:
            r2 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x002c:
            r2 = move-exception
            goto L_0x003e
        L_0x002e:
            r2 = move-exception
        L_0x002f:
            r2.printStackTrace()     // Catch:{ all -> 0x002c }
            r2 = 0
            if (r0 == 0) goto L_0x003d
            r0.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003d:
            return r2
        L_0x003e:
            if (r0 == 0) goto L_0x0048
            r0.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0048:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.a(byte[], java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d2, code lost:
        if (r8 == null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d8, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d9, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0079 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x011b A[SYNTHETIC, Splitter:B:100:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095 A[Catch:{ IOException -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099 A[Catch:{ IOException -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f2 A[Catch:{ all -> 0x010e }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00fb A[SYNTHETIC, Splitter:B:83:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0105 A[SYNTHETIC, Splitter:B:88:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0111 A[SYNTHETIC, Splitter:B:95:0x0111] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r8, java.lang.String r9) {
        /*
            if (r8 == 0) goto L_0x0124
            if (r9 != 0) goto L_0x0006
            goto L_0x0124
        L_0x0006:
            java.lang.String r0 = "/"
            boolean r1 = r9.endsWith(r0)
            if (r1 != 0) goto L_0x001d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r0)
            java.lang.String r9 = r1.toString()
        L_0x001d:
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r8 = r0.exists()
            if (r8 != 0) goto L_0x002b
            java.lang.String r8 = "unzip file not exists"
            return r8
        L_0x002b:
            r8 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
            java.util.Enumeration r0 = r1.entries()     // Catch:{ IOException -> 0x00ec, all -> 0x00e9 }
            r2 = r8
        L_0x0036:
            boolean r3 = r0.hasMoreElements()     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x00cf
            java.lang.Object r3 = r0.nextElement()     // Catch:{ IOException -> 0x00e7 }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ IOException -> 0x00e7 }
            if (r3 != 0) goto L_0x005d
            java.lang.String r9 = "unzip zipEntry is null"
            if (r8 == 0) goto L_0x0052
            r8.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0052:
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r8 = move-exception
            r8.printStackTrace()
        L_0x005c:
            return r9
        L_0x005d:
            java.lang.String r5 = r3.getName()     // Catch:{ IOException -> 0x00e7 }
            java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x00e7 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e7 }
            r7.<init>()     // Catch:{ IOException -> 0x00e7 }
            r7.append(r9)     // Catch:{ IOException -> 0x00e7 }
            r7.append(r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r5 = r7.toString()     // Catch:{ IOException -> 0x00e7 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = r6.getCanonicalPath()     // Catch:{ IOException -> 0x0079 }
        L_0x0079:
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x00e7 }
            if (r5 != 0) goto L_0x0036
            java.lang.String r5 = ".."
            boolean r5 = r4.startsWith(r5)     // Catch:{ IOException -> 0x00e7 }
            if (r5 != 0) goto L_0x0036
            java.lang.String r5 = "../"
            boolean r4 = r4.startsWith(r5)     // Catch:{ IOException -> 0x00e7 }
            if (r4 != 0) goto L_0x0036
            boolean r4 = r3.isDirectory()     // Catch:{ IOException -> 0x00e7 }
            if (r4 == 0) goto L_0x0099
            r6.mkdirs()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x0036
        L_0x0099:
            java.io.File r4 = r6.getParentFile()     // Catch:{ IOException -> 0x00e7 }
            boolean r4 = r4.exists()     // Catch:{ IOException -> 0x00e7 }
            if (r4 != 0) goto L_0x00aa
            java.io.File r4 = r6.getParentFile()     // Catch:{ IOException -> 0x00e7 }
            r4.mkdirs()     // Catch:{ IOException -> 0x00e7 }
        L_0x00aa:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00e7 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x00e7 }
            java.io.InputStream r8 = r1.getInputStream(r3)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
        L_0x00b7:
            r5 = 0
            int r6 = r8.read(r3, r5, r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r7 = -1
            if (r6 == r7) goto L_0x00c6
            r4.write(r3, r5, r6)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r4.flush()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            goto L_0x00b7
        L_0x00c6:
            r2 = r4
            goto L_0x0036
        L_0x00c9:
            r9 = move-exception
            r2 = r4
            goto L_0x010f
        L_0x00cc:
            r9 = move-exception
            r2 = r4
            goto L_0x00ee
        L_0x00cf:
            r1.close()     // Catch:{ IOException -> 0x00e7 }
            if (r8 == 0) goto L_0x00dc
            r8.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00dc
        L_0x00d8:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00dc:
            if (r2 == 0) goto L_0x00e6
            r2.close()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00e6
        L_0x00e2:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00e6:
            return r4
        L_0x00e7:
            r9 = move-exception
            goto L_0x00ee
        L_0x00e9:
            r9 = move-exception
            r2 = r8
            goto L_0x010f
        L_0x00ec:
            r9 = move-exception
            r2 = r8
        L_0x00ee:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x010e }
            if (r0 == 0) goto L_0x00f5
            r9.printStackTrace()     // Catch:{ all -> 0x010e }
        L_0x00f5:
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x010e }
            if (r8 == 0) goto L_0x0103
            r8.close()     // Catch:{ IOException -> 0x00ff }
            goto L_0x0103
        L_0x00ff:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0103:
            if (r2 == 0) goto L_0x010d
            r2.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x010d
        L_0x0109:
            r8 = move-exception
            r8.printStackTrace()
        L_0x010d:
            return r9
        L_0x010e:
            r9 = move-exception
        L_0x010f:
            if (r8 == 0) goto L_0x0119
            r8.close()     // Catch:{ IOException -> 0x0115 }
            goto L_0x0119
        L_0x0115:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0119:
            if (r2 == 0) goto L_0x0123
            r2.close()     // Catch:{ IOException -> 0x011f }
            goto L_0x0123
        L_0x011f:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0123:
            throw r9
        L_0x0124:
            java.lang.String r8 = "unzip srcFile or destDir is null "
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.a(java.lang.String, java.lang.String):java.lang.String");
    }

    static /* synthetic */ void a(String str, int i) {
        try {
            if (d(new File(str)) > ((long) (i * 1048576))) {
                d(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
            q.d("SameFileTool", "clean memory failed");
        }
    }
}
