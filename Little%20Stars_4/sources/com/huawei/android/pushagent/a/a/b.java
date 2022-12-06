package com.huawei.android.pushagent.a.a;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class b extends com.huawei.android.pushagent.a.a.a.b {
    private short b;
    private short c;
    private byte d;
    private byte e;
    private short f;

    public b() {
        super(c());
    }

    public static byte c() {
        return 2;
    }

    public com.huawei.android.pushagent.a.a.a.b a(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[2];
            a(inputStream, bArr);
            this.c = (short) a.c(bArr);
            byte[] bArr2 = new byte[1];
            a(inputStream, bArr2);
            this.d = bArr2[0];
            byte[] bArr3 = new byte[1];
            a(inputStream, bArr3);
            this.e = bArr3[0];
            byte[] bArr4 = new byte[2];
            a(inputStream, bArr4);
            this.f = (short) a.c(bArr4);
        } catch (Exception e2) {
            e.c("PushLogAC2705", e2.toString(), e2);
        }
        return this;
    }

    public byte[] b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(a.b((int) this.b));
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(a.b((int) this.c));
            byteArrayOutputStream.write(this.d);
            byteArrayOutputStream.write(this.e);
            byteArrayOutputStream.write(a.b((int) this.f));
            e.a("PushLogAC2705", "PollingDataRspMessage encode : baos " + a.a(byteArrayOutputStream.toByteArray()));
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            e.c("PushLogAC2705", e2.toString(), e2);
            return new byte[0];
        }
    }

    public byte d() {
        return this.d;
    }

    public boolean e() {
        return this.e == 1;
    }

    public short f() {
        return this.f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(",mLength:");
        stringBuffer.append(this.b);
        stringBuffer.append(",cmdId:");
        stringBuffer.append(g());
        stringBuffer.append(",mRequestId:");
        stringBuffer.append(this.c);
        stringBuffer.append(",mMode:");
        stringBuffer.append(this.d);
        stringBuffer.append(",mHasMsg:");
        stringBuffer.append(this.e);
        stringBuffer.append(",mPollingInterval:");
        stringBuffer.append(this.f);
        return stringBuffer.toString();
    }
}
