package com.huawei.hms.hatool;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* renamed from: com.huawei.hms.hatool.r0 */
public final class C0826r0 {
    /* renamed from: a */
    public static String m1013a(File file) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                C0820o0 o0Var = new C0820o0(1024);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    o0Var.mo14090a(bArr, read);
                }
                if (o0Var.mo14092b() == 0) {
                    m1015a((Closeable) fileInputStream2);
                    return "";
                }
                String str = new String(o0Var.mo14091a(), Key.STRING_CHARSET_NAME);
                m1015a((Closeable) fileInputStream2);
                return str;
            } catch (FileNotFoundException unused) {
                fileInputStream = fileInputStream2;
                C0841y.m1092f("hmsSdk", "getInfoFromFile(): No files need to be read");
                m1015a((Closeable) fileInputStream);
                return "";
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                try {
                    C0841y.m1092f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
                    m1015a((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    m1015a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                m1015a((Closeable) fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            C0841y.m1092f("hmsSdk", "getInfoFromFile(): No files need to be read");
            m1015a((Closeable) fileInputStream);
            return "";
        } catch (IOException unused4) {
            C0841y.m1092f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
            m1015a((Closeable) fileInputStream);
            return "";
        }
    }

    /* renamed from: a */
    public static String m1014a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString(Key.STRING_CHARSET_NAME);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            m1015a((Closeable) byteArrayOutputStream);
        }
    }

    /* renamed from: a */
    public static void m1015a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C0841y.m1092f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    /* renamed from: a */
    public static void m1016a(File file, String str) {
        FileOutputStream fileOutputStream;
        String str2;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes(Key.STRING_CHARSET_NAME));
                fileOutputStream.flush();
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
                str2 = "saveInfoToFile(): io exc from write info to file!";
                C0841y.m1092f("hmsSdk", str2);
                m1015a((Closeable) fileOutputStream);
            }
        } catch (FileNotFoundException unused3) {
            fileOutputStream = null;
            str2 = "saveInfoToFile(): No files need to be read";
            C0841y.m1092f("hmsSdk", str2);
            m1015a((Closeable) fileOutputStream);
        } catch (IOException unused4) {
            fileOutputStream = null;
            str2 = "saveInfoToFile(): io exc from write info to file!";
            C0841y.m1092f("hmsSdk", str2);
            m1015a((Closeable) fileOutputStream);
        } catch (Throwable th) {
            th = th;
            fileOutputStream2 = fileOutputStream;
            m1015a((Closeable) fileOutputStream2);
            throw th;
        }
        m1015a((Closeable) fileOutputStream);
    }

    /* renamed from: a */
    public static void m1017a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                C0841y.m1092f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    /* renamed from: a */
    public static void m1018a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            C0841y.m1092f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        C0841y.m1081a("hmsSdk", " connHttp disconnect");
    }

    /* renamed from: a */
    public static byte[] m1019a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        m1017a((OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
