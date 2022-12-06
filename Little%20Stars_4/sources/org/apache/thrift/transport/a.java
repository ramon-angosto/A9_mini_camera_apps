package org.apache.thrift.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a extends d {
    protected InputStream a = null;
    protected OutputStream b = null;

    protected a() {
    }

    public a(OutputStream outputStream) {
        this.b = outputStream;
    }

    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new e(4);
            } catch (IOException e) {
                throw new e(0, (Throwable) e);
            }
        } else {
            throw new e(1, "Cannot read from null inputStream");
        }
    }

    public void b(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new e(0, (Throwable) e);
            }
        } else {
            throw new e(1, "Cannot write to null outputStream");
        }
    }
}
