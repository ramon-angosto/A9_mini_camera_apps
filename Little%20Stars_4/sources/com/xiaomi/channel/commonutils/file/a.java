package com.xiaomi.channel.commonutils.file;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class a {
    public static final String[] a = {"jpg", "png", "bmp", "gif", "webp"};

    public static void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(File file, File file2) {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file, false));
            try {
                a(zipOutputStream2, file2, (String) null, (FileFilter) null);
                a((OutputStream) zipOutputStream2);
            } catch (FileNotFoundException unused) {
                zipOutputStream = zipOutputStream2;
                a((OutputStream) zipOutputStream);
            } catch (IOException e) {
                e = e;
                zipOutputStream = zipOutputStream2;
                try {
                    b.a("zip file failure + " + e.getMessage());
                    a((OutputStream) zipOutputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                a((OutputStream) zipOutputStream);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            a((OutputStream) zipOutputStream);
        } catch (IOException e2) {
            e = e2;
            b.a("zip file failure + " + e.getMessage());
            a((OutputStream) zipOutputStream);
        }
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:1|2|3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.OutputStream r0) {
        /*
            if (r0 == 0) goto L_0x0008
            r0.flush()     // Catch:{ IOException -> 0x0005 }
        L_0x0005:
            r0.close()     // Catch:{ IOException -> 0x0008 }
        L_0x0008:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.a(java.io.OutputStream):void");
    }

    public static void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
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
                    a(zipOutputStream, listFiles[i], str2 + listFiles[i].getName(), (FileFilter) null);
                }
                File[] listFiles2 = file.listFiles(new b());
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
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
                        b.d("zipFiction failed with exception:" + e.toString());
                        a((InputStream) fileInputStream2);
                    } catch (Throwable th) {
                        th = th;
                        a((InputStream) fileInputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    a((InputStream) fileInputStream2);
                    throw th;
                }
            }
            a((InputStream) fileInputStream);
        } catch (IOException e2) {
            e = e2;
            b.d("zipFiction failed with exception:" + e.toString());
            a((InputStream) fileInputStream2);
        }
    }

    public static byte[] b(InputStream inputStream) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr2, 0, 8192);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            } catch (Exception e) {
                e.printStackTrace();
                bArr = null;
            } catch (Throwable th) {
                a(inputStream);
                a((OutputStream) byteArrayOutputStream);
                throw th;
            }
        }
        bArr = byteArrayOutputStream.toByteArray();
        a(inputStream);
        a((OutputStream) byteArrayOutputStream);
        return bArr;
    }
}
