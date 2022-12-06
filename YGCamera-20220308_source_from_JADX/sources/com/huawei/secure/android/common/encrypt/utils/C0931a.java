package com.huawei.secure.android.common.encrypt.utils;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* renamed from: com.huawei.secure.android.common.encrypt.utils.a */
public class C0931a {

    /* renamed from: S */
    private static final int f1124S = 4096;
    private static final String TAG = "IOUtil";

    /* renamed from: a */
    public static void m1482a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: a */
    public static void m1486a(Reader reader) {
        m1483a((Closeable) reader);
    }

    /* renamed from: a */
    public static void m1487a(Writer writer) {
        m1483a((Closeable) writer);
    }

    /* renamed from: a */
    public static void m1484a(InputStream inputStream) {
        m1483a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m1485a(OutputStream outputStream) {
        m1483a((Closeable) outputStream);
    }

    /* renamed from: a */
    public static void m1483a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C0932b.m1497f(TAG, "closeSecure IOException");
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m1481a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m1481a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: b */
    public static byte[] m1489b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: f */
    public static InputStream m1490f(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    /* renamed from: b */
    public static void m1488b(File file) {
        if (file != null && file.exists() && !file.delete()) {
            C0932b.m1497f(TAG, "deleteSecure exception");
        }
    }

    /* renamed from: h */
    public static void m1491h(String str) {
        if (!TextUtils.isEmpty(str)) {
            m1488b(new File(str));
        }
    }
}
