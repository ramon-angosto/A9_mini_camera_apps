package com.huawei.agconnect.config.p006a;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* renamed from: com.huawei.agconnect.config.a.j */
public final class C0550j {
    /* renamed from: a */
    public static String m67a(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        m69a((Reader) new InputStreamReader(inputStream, str), (Writer) stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static void m68a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e("Utils", "Exception when closing the 'Closeable'.");
            }
        }
    }

    /* renamed from: a */
    public static void m69a(Reader reader, Writer writer) throws IOException {
        m70a(reader, writer, new char[4096]);
    }

    /* renamed from: a */
    public static void m70a(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int read = reader.read(cArr);
            if (-1 != read) {
                writer.write(cArr, 0, read);
            } else {
                return;
            }
        }
    }
}
