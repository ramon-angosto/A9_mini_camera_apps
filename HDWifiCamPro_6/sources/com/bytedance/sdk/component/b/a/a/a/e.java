package com.bytedance.sdk.component.b.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: NetInputStram */
public class e extends InputStream {
    InputStream a;
    HttpURLConnection b;

    public e(InputStream inputStream, HttpURLConnection httpURLConnection) {
        this.a = inputStream;
        this.b = httpURLConnection;
    }

    public int read() throws IOException {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            return inputStream.read();
        }
        return 0;
    }

    public int read(byte[] bArr) throws IOException {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            return inputStream.read(bArr);
        }
        return 0;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        return 0;
    }

    public long skip(long j) throws IOException {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            return inputStream.skip(j);
        }
        return 0;
    }

    public int available() throws IOException {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    public void close() throws IOException {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            inputStream.close();
            this.a = null;
        }
        HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.b = null;
        }
    }

    public synchronized void mark(int i) {
        if (this.a != null) {
            this.a.mark(i);
        }
    }

    public void reset() throws IOException {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            inputStream.reset();
        }
    }

    public boolean markSupported() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return false;
    }
}
