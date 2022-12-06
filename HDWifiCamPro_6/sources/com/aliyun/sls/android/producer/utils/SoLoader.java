package com.aliyun.sls.android.producer.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SoLoader {
    private static final int MAX_RETRY_COUNT = 5;

    private SoLoader() {
    }

    public static SoLoader instance() {
        return new SoLoader();
    }

    public void loadLibrary(Context context, String str) {
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError unused) {
            if (context != null) {
                File libraryFile = getLibraryFile(context, str);
                if (!libraryFile.exists()) {
                    cleanup(context, str);
                }
                installLibrary(context, str);
                System.load(libraryFile.getAbsolutePath());
            }
        }
    }

    private void cleanup(Context context, String str) {
        File libraryDir = getLibraryDir(context);
        if (libraryDir.exists()) {
            File libraryFile = getLibraryFile(context, str);
            final String mapLibraryName = mapLibraryName(str);
            File[] listFiles = libraryDir.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith(mapLibraryName);
                }
            });
            if (listFiles != null && listFiles.length != 0) {
                for (File file : listFiles) {
                    if (!file.getAbsolutePath().equals(libraryFile.getAbsolutePath())) {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.FileOutputStream] */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:11|(7:12|13|14|15|16|17|(2:19|20))|21|22|59|51) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        if (r1 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        r10.setReadable(true, false);
        r10.setExecutable(true, false);
        r10.setWritable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        return;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0056 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a A[SYNTHETIC, Splitter:B:35:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006f A[SYNTHETIC, Splitter:B:39:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0076 A[SYNTHETIC, Splitter:B:47:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x007c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void installLibrary(android.content.Context r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String[] r0 = r8.getSupportABIs()
            java.lang.String r1 = r8.mapLibraryName(r10)
            java.io.File r10 = r8.getLibraryFile(r9, r10)
            com.aliyun.sls.android.producer.utils.SoLoader$ZipFileInEntry r9 = r8.getZipFileInEntry(r9, r0, r1)
            if (r9 != 0) goto L_0x0013
            return
        L_0x0013:
            r0 = 0
            r1 = r0
        L_0x0015:
            int r2 = r1 + 1
            r3 = 5
            if (r1 >= r3) goto L_0x007e
            boolean r1 = r10.exists()     // Catch:{ IOException -> 0x007c }
            if (r1 != 0) goto L_0x0027
            boolean r1 = r10.createNewFile()     // Catch:{ IOException -> 0x007c }
            if (r1 != 0) goto L_0x0027
            goto L_0x007c
        L_0x0027:
            r1 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0073, all -> 0x0066 }
            r3.<init>(r10)     // Catch:{ IOException -> 0x0073, all -> 0x0066 }
            java.util.zip.ZipFile r4 = r9.zipFile     // Catch:{ IOException -> 0x0074, all -> 0x0064 }
            java.util.zip.ZipEntry r5 = r9.zipEntry     // Catch:{ IOException -> 0x0074, all -> 0x0064 }
            java.io.InputStream r1 = r4.getInputStream(r5)     // Catch:{ IOException -> 0x0074, all -> 0x0064 }
            long r4 = r8.copy(r1, r3)     // Catch:{ IOException -> 0x0074, all -> 0x0064 }
            java.io.FileDescriptor r6 = r3.getFD()     // Catch:{ IOException -> 0x0074, all -> 0x0064 }
            r6.sync()     // Catch:{ IOException -> 0x0074, all -> 0x0064 }
            long r6 = r10.length()     // Catch:{ IOException -> 0x0074, all -> 0x0064 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0051
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ all -> 0x004d }
        L_0x004d:
            r3.close()     // Catch:{  }
            goto L_0x007c
        L_0x0051:
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r3.close()     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r9 = 1
            r10.setReadable(r9, r0)
            r10.setExecutable(r9, r0)
            r10.setWritable(r9, r0)
            return
        L_0x0064:
            r9 = move-exception
            goto L_0x0068
        L_0x0066:
            r9 = move-exception
            r3 = r1
        L_0x0068:
            if (r1 == 0) goto L_0x006d
            r1.close()     // Catch:{ all -> 0x006d }
        L_0x006d:
            if (r3 == 0) goto L_0x0072
            r3.close()     // Catch:{ all -> 0x0072 }
        L_0x0072:
            throw r9
        L_0x0073:
            r3 = r1
        L_0x0074:
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ all -> 0x0079 }
        L_0x0079:
            if (r3 == 0) goto L_0x007c
            goto L_0x004d
        L_0x007c:
            r1 = r2
            goto L_0x0015
        L_0x007e:
            java.util.zip.ZipFile r9 = r9.zipFile     // Catch:{ all -> 0x0083 }
            r9.close()     // Catch:{ all -> 0x0083 }
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.sls.android.producer.utils.SoLoader.installLibrary(android.content.Context, java.lang.String):void");
    }

    private long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r5.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.aliyun.sls.android.producer.utils.SoLoader.ZipFileInEntry getZipFileInEntry(android.content.Context r12, java.lang.String[] r13, java.lang.String r14) {
        /*
            r11 = this;
            java.lang.String[] r12 = r11.getAPKFiles(r12)
            int r0 = r12.length
            r1 = 0
            r2 = r1
        L_0x0007:
            r3 = 0
            if (r2 >= r0) goto L_0x0064
            r4 = r12[r2]
            r5 = r1
        L_0x000d:
            int r6 = r5 + 1
            r7 = 5
            if (r5 >= r7) goto L_0x0020
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x001e }
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x001e }
            r8.<init>(r4)     // Catch:{ IOException -> 0x001e }
            r9 = 1
            r5.<init>(r8, r9)     // Catch:{ IOException -> 0x001e }
            goto L_0x0021
        L_0x001e:
            r5 = r6
            goto L_0x000d
        L_0x0020:
            r5 = r3
        L_0x0021:
            if (r5 != 0) goto L_0x0024
            return r3
        L_0x0024:
            r3 = r1
        L_0x0025:
            int r4 = r3 + 1
            if (r3 >= r7) goto L_0x005e
            int r3 = r13.length
            r6 = r1
        L_0x002b:
            if (r6 >= r3) goto L_0x005c
            r8 = r13[r6]
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "lib"
            r9.append(r10)
            char r10 = java.io.File.separatorChar
            r9.append(r10)
            r9.append(r8)
            char r8 = java.io.File.separatorChar
            r9.append(r8)
            r9.append(r14)
            java.lang.String r8 = r9.toString()
            java.util.zip.ZipEntry r8 = r5.getEntry(r8)
            if (r8 == 0) goto L_0x0059
            com.aliyun.sls.android.producer.utils.SoLoader$ZipFileInEntry r12 = new com.aliyun.sls.android.producer.utils.SoLoader$ZipFileInEntry
            r12.<init>(r5, r8)
            return r12
        L_0x0059:
            int r6 = r6 + 1
            goto L_0x002b
        L_0x005c:
            r3 = r4
            goto L_0x0025
        L_0x005e:
            r5.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0061:
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0064:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.sls.android.producer.utils.SoLoader.getZipFileInEntry(android.content.Context, java.lang.String[], java.lang.String):com.aliyun.sls.android.producer.utils.SoLoader$ZipFileInEntry");
    }

    private File getLibraryFile(Context context, String str) {
        return new File(getLibraryDir(context), mapLibraryName(str));
    }

    private File getLibraryDir(Context context) {
        return context.getDir("libs", 0);
    }

    private String mapLibraryName(String str) {
        if (!str.startsWith("lib") || !str.endsWith(".so")) {
            return System.mapLibraryName(str);
        }
        return str;
    }

    private String[] getSupportABIs() {
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }

    private String[] getAPKFiles(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || applicationInfo.splitSourceDirs == null || applicationInfo.splitSourceDirs.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr = new String[(applicationInfo.splitSourceDirs.length + 1)];
        strArr[0] = applicationInfo.sourceDir;
        System.arraycopy(applicationInfo.splitSourceDirs, 0, strArr, 1, applicationInfo.splitSourceDirs.length);
        return strArr;
    }

    private static class ZipFileInEntry {
        public ZipEntry zipEntry;
        public ZipFile zipFile;

        public ZipFileInEntry(ZipFile zipFile2, ZipEntry zipEntry2) {
            this.zipFile = zipFile2;
            this.zipEntry = zipEntry2;
        }
    }
}
