package com.apm.insight.l;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class e extends PrintWriter {
    private MessageDigest a = null;
    private Charset b = null;
    private a c = null;

    public static class a {
        public boolean a(String str) {
            return true;
        }
    }

    public e(OutputStream outputStream, MessageDigest messageDigest, a aVar) {
        super(outputStream);
        this.a = messageDigest;
        this.c = aVar;
        if (messageDigest != null) {
            this.b = Charset.defaultCharset();
        }
    }

    public void write(int i) {
        super.write(i);
        MessageDigest messageDigest = this.a;
        if (messageDigest != null) {
            messageDigest.update((byte) i);
        }
    }

    public void write(String str, int i, int i2) {
        super.write(str, i, i2);
        if (this.a != null) {
            a aVar = this.c;
            if (aVar == null || aVar.a(str)) {
                this.a.update(this.b.encode(CharBuffer.wrap(str, i, i2 + i)).array());
            }
        }
    }

    public void write(char[] cArr, int i, int i2) {
        super.write(cArr, i, i2);
        MessageDigest messageDigest = this.a;
        if (messageDigest != null) {
            messageDigest.update(this.b.encode(CharBuffer.wrap(cArr)).array());
        }
    }
}
