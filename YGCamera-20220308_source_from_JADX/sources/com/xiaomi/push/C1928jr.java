package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.xiaomi.push.jr */
public class C1928jr extends C1931ju {

    /* renamed from: a */
    protected InputStream f3545a = null;

    /* renamed from: a */
    protected OutputStream f3546a = null;

    protected C1928jr() {
    }

    public C1928jr(OutputStream outputStream) {
        this.f3546a = outputStream;
    }

    /* renamed from: a */
    public int mo18358a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f3545a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new C1932jv(4);
            } catch (IOException e) {
                throw new C1932jv(0, (Throwable) e);
            }
        } else {
            throw new C1932jv(1, "Cannot read from null inputStream");
        }
    }

    /* renamed from: a */
    public void m4690a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f3546a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new C1932jv(0, (Throwable) e);
            }
        } else {
            throw new C1932jv(1, "Cannot write to null outputStream");
        }
    }
}
