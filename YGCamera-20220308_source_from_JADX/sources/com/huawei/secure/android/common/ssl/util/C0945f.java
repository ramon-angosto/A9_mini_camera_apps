package com.huawei.secure.android.common.ssl.util;

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

/* renamed from: com.huawei.secure.android.common.ssl.util.f */
public abstract class C0945f {

    /* renamed from: a */
    private static final String f1243a = "IOUtil";

    /* renamed from: b */
    private static final int f1244b = 4096;

    /* renamed from: a */
    public static void m1567a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: b */
    public static byte[] m1575b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m1564a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static void m1572a(Reader reader) {
        m1568a((Closeable) reader);
    }

    /* renamed from: a */
    public static void m1573a(Writer writer) {
        m1568a((Closeable) writer);
    }

    /* renamed from: a */
    public static void m1570a(InputStream inputStream) {
        m1568a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m1571a(OutputStream outputStream) {
        m1568a((Closeable) outputStream);
    }

    /* renamed from: a */
    public static void m1568a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C0946g.m1579b(f1243a, "closeSecure IOException");
            }
        }
    }

    /* renamed from: a */
    public static long m1564a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m1565a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m1565a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
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

    /* renamed from: a */
    public static InputStream m1566a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    /* renamed from: a */
    public static void m1569a(File file) {
        if (file != null && file.exists() && !file.delete()) {
            C0946g.m1579b(f1243a, "deleteSecure exception");
        }
    }

    /* renamed from: a */
    public static void m1574a(String str) {
        if (!TextUtils.isEmpty(str)) {
            m1569a(new File(str));
        }
    }
}
