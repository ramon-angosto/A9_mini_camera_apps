package com.huawei.android.pushagent.a.a.a;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class b implements com.huawei.android.pushagent.a.b {
    protected byte a = -1;

    public b() {
    }

    public b(byte b) {
        a(b);
    }

    public static void a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        while (i < bArr.length) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (-1 != read) {
                i += read;
            } else {
                throw new IOException("read -1 reached");
            }
        }
    }

    public static b b(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[2];
        a(inputStream, bArr);
        int c = (short) a.c(bArr);
        byte[] bArr2 = new byte[c];
        a(inputStream, bArr2);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
        byte read = (byte) byteArrayInputStream.read();
        e.a("PushLogAC2705", "cmdId: 0X" + Integer.toHexString(read) + " len:" + c);
        return a.a(Byte.valueOf(read), byteArrayInputStream);
    }

    public byte a() {
        return this.a;
    }

    public abstract b a(InputStream inputStream) throws IOException;

    public void a(byte b) {
        this.a = b;
    }

    public String g() {
        return a.a(new byte[]{this.a});
    }
}
