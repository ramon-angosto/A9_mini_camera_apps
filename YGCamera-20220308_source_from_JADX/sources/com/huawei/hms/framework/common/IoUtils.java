package com.huawei.hms.framework.common;

import android.database.Cursor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IoUtils {
    private static final int BUFF_SIZE = 4096;
    private static final int MAX_SIZE = 16777216;

    private IoUtils() {
    }

    public static void close(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void closeSecure(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Logger.m479w("IOUtil", "closeSecure IOException", (Throwable) e);
            }
        } else {
            Logger.m478w("IOUtil", "closeable is null");
        }
    }

    public static void closeSecure(InputStream inputStream) {
        closeSecure((Closeable) inputStream);
    }

    public static void closeSecure(OutputStream outputStream) {
        closeSecure((Closeable) outputStream);
    }

    public static void closeSecure(Reader reader) {
        closeSecure((Closeable) reader);
    }

    public static void closeSecure(Writer writer) {
        closeSecure((Closeable) writer);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            if (j <= 16777216) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                throw new IOException("input data too large for byte.");
            }
        }
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
