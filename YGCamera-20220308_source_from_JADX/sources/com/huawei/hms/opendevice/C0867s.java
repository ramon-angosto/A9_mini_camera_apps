package com.huawei.hms.opendevice;

import com.bumptech.glide.load.Key;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;

/* renamed from: com.huawei.hms.opendevice.s */
/* compiled from: StreamUtil */
public abstract class C0867s {
    /* renamed from: a */
    public static void m1187a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HMSLog.m1380w("StreamUtil", "close IOException");
            }
        }
    }

    /* renamed from: a */
    public static void m1189a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
                HMSLog.m1380w("StreamUtil", "close HttpURLConnection Exception");
            }
        }
    }

    /* renamed from: a */
    public static String m1185a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read = inputStream.read();
        while (-1 != read) {
            byteArrayOutputStream.write(read);
            read = inputStream.read();
        }
        String byteArrayOutputStream2 = byteArrayOutputStream.toString(Key.STRING_CHARSET_NAME);
        m1187a((Closeable) inputStream);
        IOUtil.closeSecure((OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream2;
    }

    /* renamed from: a */
    public static void m1188a(File file) throws IOException {
        if (!file.exists()) {
            if (file.getParentFile() == null) {
                HMSLog.m1377e("StreamUtil", "parent file is null.");
                throw new IOException("parent file is null");
            } else if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                HMSLog.m1377e("StreamUtil", "make parent dirs failed.");
                throw new IOException("make parent dirs failed");
            } else if (!file.createNewFile()) {
                HMSLog.m1377e("StreamUtil", "create file failed.");
                throw new IOException("create file failed");
            }
        }
    }

    /* renamed from: a */
    public static String m1186a(String str) {
        InputStreamReader inputStreamReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file), Key.STRING_CHARSET_NAME);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        HMSLog.m1377e("StreamUtil", "file not exist.");
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                        return sb.toString();
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        try {
                            HMSLog.m1377e("StreamUtil", "read value IOException.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                        throw th;
                    }
                }
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader2);
            } catch (FileNotFoundException unused3) {
                HMSLog.m1377e("StreamUtil", "file not exist.");
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader);
                return sb.toString();
            } catch (IOException unused4) {
                HMSLog.m1377e("StreamUtil", "read value IOException.");
                IOUtils.closeQuietly((Reader) inputStreamReader);
                IOUtils.closeQuietly((Reader) bufferedReader);
                return sb.toString();
            }
        } catch (FileNotFoundException unused5) {
            inputStreamReader = null;
            HMSLog.m1377e("StreamUtil", "file not exist.");
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            return sb.toString();
        } catch (IOException unused6) {
            inputStreamReader = null;
            HMSLog.m1377e("StreamUtil", "read value IOException.");
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            IOUtils.closeQuietly((Reader) inputStreamReader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            throw th;
        }
        return sb.toString();
    }
}
