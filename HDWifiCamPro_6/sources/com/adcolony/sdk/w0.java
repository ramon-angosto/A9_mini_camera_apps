package com.adcolony.sdk;

import java.io.IOException;
import java.io.InputStream;

class w0 extends InputStream {
    InputStream a;
    int b;

    w0(InputStream inputStream, int i, int i2) throws IOException {
        this.a = inputStream;
        while (i > 0) {
            i -= (int) inputStream.skip((long) i);
        }
        this.b = i2;
    }

    public int available() throws IOException {
        int available = this.a.available();
        int i = this.b;
        return available <= i ? available : i;
    }

    public void close() throws IOException {
        this.a.close();
    }

    public int read() throws IOException {
        int i = this.b;
        if (i == 0) {
            return -1;
        }
        this.b = i - 1;
        return this.a.read();
    }

    public long skip(long j) throws IOException {
        int i = (int) j;
        if (i <= 0) {
            return 0;
        }
        int i2 = this.b;
        if (i > i2) {
            i = i2;
        }
        this.b = i2 - i;
        while (i > 0) {
            i -= (int) this.a.skip(j);
        }
        return j;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.b;
        if (i3 == 0) {
            return -1;
        }
        if (i2 > i3) {
            i2 = i3;
        }
        int read = this.a.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.b -= read;
        return read;
    }
}
