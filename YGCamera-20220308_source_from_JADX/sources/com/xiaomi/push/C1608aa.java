package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* renamed from: com.xiaomi.push.aa */
public class C1608aa {

    /* renamed from: a */
    public static final String[] f1753a = {"jpg", "png", "bmp", "gif", "webp"};

    /* renamed from: a */
    public static String m2490a(File file) {
        InputStreamReader inputStreamReader;
        StringWriter stringWriter = new StringWriter();
        try {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String stringWriter2 = stringWriter.toString();
                        m2491a((Closeable) inputStreamReader);
                        m2491a((Closeable) stringWriter);
                        return stringWriter2;
                    }
                }
            } catch (IOException e) {
                e = e;
                try {
                    C1524b.m2159c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    m2491a((Closeable) inputStreamReader);
                    m2491a((Closeable) stringWriter);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    m2491a((Closeable) inputStreamReader);
                    m2491a((Closeable) stringWriter);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamReader = null;
            C1524b.m2159c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            m2491a((Closeable) inputStreamReader);
            m2491a((Closeable) stringWriter);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
            m2491a((Closeable) inputStreamReader);
            m2491a((Closeable) stringWriter);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m2491a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m2492a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File a : listFiles) {
                m2490a(a);
            }
        } else if (!file.exists()) {
            return;
        }
        file.delete();
    }

    /* renamed from: a */
    public static void m2493a(File file, File file2) {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file, false));
            try {
                m2495a(zipOutputStream2, file2, (String) null, (FileFilter) null);
                m2491a((Closeable) zipOutputStream2);
            } catch (FileNotFoundException unused) {
                zipOutputStream = zipOutputStream2;
                m2491a((Closeable) zipOutputStream);
            } catch (IOException e) {
                e = e;
                zipOutputStream = zipOutputStream2;
                try {
                    C1524b.m2141a("zip file failure + " + e.getMessage());
                    m2491a((Closeable) zipOutputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                m2491a((Closeable) zipOutputStream);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            m2491a((Closeable) zipOutputStream);
        } catch (IOException e2) {
            e = e2;
            C1524b.m2141a("zip file failure + " + e.getMessage());
            m2491a((Closeable) zipOutputStream);
        }
    }

    /* renamed from: a */
    public static void m2494a(File file, String str) {
        if (!file.exists()) {
            C1524b.m2159c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                bufferedWriter2.write(str);
                m2491a((Closeable) bufferedWriter2);
            } catch (IOException e) {
                e = e;
                bufferedWriter = bufferedWriter2;
                try {
                    C1524b.m2159c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    m2491a((Closeable) bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    m2491a((Closeable) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                m2491a((Closeable) bufferedWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            C1524b.m2159c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            m2491a((Closeable) bufferedWriter);
        }
    }

    /* renamed from: a */
    public static void m2495a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        FileInputStream fileInputStream;
        ZipEntry zipEntry;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        FileInputStream fileInputStream2 = null;
        try {
            if (file.isDirectory()) {
                File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                zipOutputStream.putNextEntry(new ZipEntry(str + File.separator));
                if (!TextUtils.isEmpty(str)) {
                    str2 = str + File.separator;
                }
                for (int i = 0; i < listFiles.length; i++) {
                    m2495a(zipOutputStream, listFiles[i], str2 + listFiles[i].getName(), (FileFilter) null);
                }
                File[] listFiles2 = file.listFiles(new C1609ab());
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        m2495a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                    }
                }
                fileInputStream = null;
            } else {
                if (!TextUtils.isEmpty(str)) {
                    zipEntry = new ZipEntry(str);
                } else {
                    Date date = new Date();
                    zipEntry = new ZipEntry(String.valueOf(date.getTime()) + ".txt");
                }
                zipOutputStream.putNextEntry(zipEntry);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    e = e;
                    fileInputStream2 = fileInputStream;
                    try {
                        C1524b.m2160d("zipFiction failed with exception:" + e.toString());
                        m2491a((Closeable) fileInputStream2);
                    } catch (Throwable th) {
                        th = th;
                        m2491a((Closeable) fileInputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    m2491a((Closeable) fileInputStream2);
                    throw th;
                }
            }
            m2491a((Closeable) fileInputStream);
        } catch (IOException e2) {
            e = e2;
            C1524b.m2160d("zipFiction failed with exception:" + e.toString());
            m2491a((Closeable) fileInputStream2);
        }
    }

    /* renamed from: a */
    public static boolean m2496a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static byte[] m2497a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2498b(java.io.File r3, java.io.File r4) {
        /*
            java.lang.String r0 = r3.getAbsolutePath()
            java.lang.String r1 = r4.getAbsolutePath()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            return
        L_0x000f:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0035 }
            r1.<init>(r3)     // Catch:{ all -> 0x0035 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0033 }
            r3.<init>(r4)     // Catch:{ all -> 0x0033 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0030 }
        L_0x001e:
            int r0 = r1.read(r4)     // Catch:{ all -> 0x0030 }
            if (r0 < 0) goto L_0x0029
            r2 = 0
            r3.write(r4, r2, r0)     // Catch:{ all -> 0x0030 }
            goto L_0x001e
        L_0x0029:
            r1.close()
            r3.close()
            return
        L_0x0030:
            r4 = move-exception
            r0 = r3
            goto L_0x0037
        L_0x0033:
            r4 = move-exception
            goto L_0x0037
        L_0x0035:
            r4 = move-exception
            r1 = r0
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.close()
        L_0x0041:
            goto L_0x0043
        L_0x0042:
            throw r4
        L_0x0043:
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1608aa.m2498b(java.io.File, java.io.File):void");
    }
}
