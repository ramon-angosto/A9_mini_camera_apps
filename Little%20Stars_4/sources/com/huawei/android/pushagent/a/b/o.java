package com.huawei.android.pushagent.a.b;

import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class o extends b {
    private byte b = 1;
    private String c = null;
    private String d = null;

    public o() {
        super(c());
    }

    public static byte c() {
        return -35;
    }

    public b a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[1];
        a(inputStream, bArr);
        this.b = bArr[0];
        if (bArr[0] != 0) {
            this.d = null;
            this.c = null;
        }
        byte[] bArr2 = new byte[32];
        a(inputStream, bArr2);
        this.c = new String(bArr2, "UTF-8");
        byte[] bArr3 = new byte[2];
        a(inputStream, bArr3);
        byte[] bArr4 = new byte[a.c(bArr3)];
        a(inputStream, bArr4);
        this.d = new String(bArr4, "UTF-8");
        return this;
    }

    public byte[] b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(this.c.getBytes("UTF-8"));
            byteArrayOutputStream.write(a.b(this.d.length()));
            byteArrayOutputStream.write(this.d.getBytes("UTF-8"));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.d("PushLogAC2705", "encode error,e " + e.toString());
            return new byte[0];
        }
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public byte f() {
        return this.b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RegisterTokenRspMessage[");
        stringBuffer.append("result:");
        stringBuffer.append(a.a(this.b));
        stringBuffer.append(",token:");
        stringBuffer.append(this.c);
        stringBuffer.append(",packageName:");
        stringBuffer.append(this.d);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
