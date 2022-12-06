package com.huawei.android.pushagent.a.b;

import com.huawei.android.pushagent.a.b.a.b;
import java.io.IOException;
import java.io.InputStream;

public class d extends b {
    private byte b = 1;

    public d() {
        super(c());
    }

    public static byte c() {
        return -45;
    }

    public b a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1];
        a(inputStream, bArr);
        this.b = bArr[0];
        return this;
    }

    public byte[] b() {
        return new byte[]{a(), this.b};
    }

    public byte d() {
        return this.b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(" cmdId:");
        stringBuffer.append(j());
        stringBuffer.append(" result:");
        stringBuffer.append(this.b);
        return stringBuffer.toString();
    }
}
