package com.vungle.warren.utility;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = UnzipUtility.class.getCanonicalName();

    public interface Filter {
        boolean matches(String str);
    }

    public static List<File> unzip(String str, String str2) throws IOException {
        return unzip(str, str2, (Filter) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008d A[SYNTHETIC, Splitter:B:32:0x008d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.io.File> unzip(java.lang.String r5, java.lang.String r6, com.vungle.warren.utility.UnzipUtility.Filter r7) throws java.io.IOException {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0099
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 == 0) goto L_0x0091
            java.io.File r5 = new java.io.File
            r5.<init>(r6)
            boolean r1 = r5.exists()
            if (r1 != 0) goto L_0x001f
            r5.mkdir()
        L_0x001f:
            r5 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ all -> 0x0088 }
            r2.<init>(r0)     // Catch:{ all -> 0x0088 }
            java.util.Enumeration r5 = r2.entries()     // Catch:{ all -> 0x0086 }
        L_0x002e:
            boolean r0 = r5.hasMoreElements()     // Catch:{ all -> 0x0086 }
            if (r0 == 0) goto L_0x0082
            java.lang.Object r0 = r5.nextElement()     // Catch:{ all -> 0x0086 }
            java.util.zip.ZipEntry r0 = (java.util.zip.ZipEntry) r0     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r3.<init>()     // Catch:{ all -> 0x0086 }
            r3.append(r6)     // Catch:{ all -> 0x0086 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x0086 }
            r3.append(r4)     // Catch:{ all -> 0x0086 }
            java.lang.String r4 = r0.getName()     // Catch:{ all -> 0x0086 }
            r3.append(r4)     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0086 }
            if (r7 == 0) goto L_0x005a
            boolean r4 = r7.matches(r3)     // Catch:{ all -> 0x0086 }
            if (r4 == 0) goto L_0x002e
        L_0x005a:
            validateFilename(r3, r6)     // Catch:{ all -> 0x0086 }
            boolean r4 = r0.isDirectory()     // Catch:{ all -> 0x0086 }
            if (r4 == 0) goto L_0x0072
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0086 }
            r0.<init>(r3)     // Catch:{ all -> 0x0086 }
            boolean r3 = r0.exists()     // Catch:{ all -> 0x0086 }
            if (r3 != 0) goto L_0x002e
            r0.mkdir()     // Catch:{ all -> 0x0086 }
            goto L_0x002e
        L_0x0072:
            java.io.InputStream r0 = r2.getInputStream(r0)     // Catch:{ all -> 0x0086 }
            extractFile(r0, r3)     // Catch:{ all -> 0x0086 }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0086 }
            r0.<init>(r3)     // Catch:{ all -> 0x0086 }
            r1.add(r0)     // Catch:{ all -> 0x0086 }
            goto L_0x002e
        L_0x0082:
            r2.close()     // Catch:{ IOException -> 0x0085 }
        L_0x0085:
            return r1
        L_0x0086:
            r5 = move-exception
            goto L_0x008b
        L_0x0088:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L_0x008b:
            if (r2 == 0) goto L_0x0090
            r2.close()     // Catch:{ IOException -> 0x0090 }
        L_0x0090:
            throw r5
        L_0x0091:
            java.io.IOException r5 = new java.io.IOException
            java.lang.String r6 = "File does not exist"
            r5.<init>(r6)
            throw r5
        L_0x0099:
            java.io.IOException r5 = new java.io.IOException
            java.lang.String r6 = "Path is empty"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.utility.UnzipUtility.unzip(java.lang.String, java.lang.String, com.vungle.warren.utility.UnzipUtility$Filter):java.util.List");
    }

    static void extractFile(InputStream inputStream, String str) throws IOException {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        File file = new File(str);
        FileUtility.delete(file);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                FileUtility.closeQuietly(inputStream);
                FileUtility.closeQuietly(bufferedOutputStream2);
                FileUtility.closeQuietly(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        FileUtility.closeQuietly(inputStream);
                        FileUtility.closeQuietly(bufferedOutputStream);
                        FileUtility.closeQuietly(fileOutputStream);
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                FileUtility.closeQuietly(inputStream);
                FileUtility.closeQuietly(bufferedOutputStream2);
                FileUtility.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            FileUtility.closeQuietly(inputStream);
            FileUtility.closeQuietly(bufferedOutputStream2);
            FileUtility.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private static String validateFilename(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath;
        }
        Log.e(TAG, "File is outside extraction target directory.");
        throw new ZipSecurityException("File is outside extraction target directory.");
    }

    static class ZipSecurityException extends IOException {
        ZipSecurityException(String str) {
            super(str);
        }
    }
}
