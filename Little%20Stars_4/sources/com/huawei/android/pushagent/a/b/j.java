package com.huawei.android.pushagent.a.b;

import com.huawei.android.pushagent.a.b.a.b;
import java.io.IOException;
import java.io.InputStream;

public class j extends b {
    private byte b = 10;

    public j() {
        super(c());
    }

    public static byte c() {
        return -38;
    }

    public b a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1];
        a(inputStream, bArr);
        this.b = bArr[0];
        return this;
    }

    public void a(byte b2) {
        this.b = b2;
    }

    public byte[] b() {
        return new byte[]{a(), d()};
    }

    public byte d() {
        return this.b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(" cmdId:");
        stringBuffer.append(j());
        stringBuffer.append(" NextHeartBeatToServer:");
        stringBuffer.append(this.b);
        return stringBuffer.toString();
    }
}
