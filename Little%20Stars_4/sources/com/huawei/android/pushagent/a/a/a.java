package com.huawei.android.pushagent.a.a;

import com.huawei.android.pushagent.a.a.a.b;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class a extends b {
    private short b;
    private short c = ((short) (com.huawei.android.pushagent.c.a.a().hashCode() & 255));
    private int d;

    public a(int i) {
        super(c());
        this.d = i;
        this.b = 7;
    }

    private static byte c() {
        return 1;
    }

    public b a(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[2];
            a(inputStream, bArr);
            this.c = (short) com.huawei.android.pushagent.c.a.c(bArr);
            byte[] bArr2 = new byte[4];
            a(inputStream, bArr2);
            this.d = com.huawei.android.pushagent.c.a.b(bArr2);
        } catch (Exception e) {
            e.c("PushLogAC2705", e.toString(), e);
        }
        return this;
    }

    public byte[] b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(com.huawei.android.pushagent.c.a.b((int) this.b));
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(com.huawei.android.pushagent.c.a.b((int) this.c));
            byteArrayOutputStream.write(com.huawei.android.pushagent.c.a.a(this.d));
            e.a("PushLogAC2705", "PollingDataReqMessage encode : baos " + com.huawei.android.pushagent.c.a.a(byteArrayOutputStream.toByteArray()));
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.c("PushLogAC2705", e.toString(), e);
            return new byte[0];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(" mLength:");
        stringBuffer.append(this.b);
        stringBuffer.append(" cmdId:");
        stringBuffer.append(g());
        stringBuffer.append(" mRequestId:");
        stringBuffer.append(this.c);
        stringBuffer.append(" mPollingId:");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }
}
