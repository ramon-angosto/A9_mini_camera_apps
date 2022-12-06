package com.huawei.android.pushagent.a.b;

import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class m extends b {
    private byte[] b;
    private byte c;

    public m() {
        super(c());
    }

    public m(byte[] bArr, byte b2) {
        this();
        this.b = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        this.c = b2;
    }

    public static byte c() {
        return -95;
    }

    public b a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8];
        a(inputStream, bArr);
        this.b = bArr;
        byte[] bArr2 = new byte[1];
        a(inputStream, bArr2);
        this.c = bArr2[0];
        return this;
    }

    public byte[] b() {
        String str;
        byte[] bArr = new byte[0];
        if (this.b == null) {
            str = "encode error, mMsgId is null ";
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(a());
                byteArrayOutputStream.write(this.b);
                byteArrayOutputStream.write(this.c);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                str = "encode error " + e.toString();
            }
        }
        e.d("PushLogAC2705", str);
        return bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(",cmdId:");
        stringBuffer.append(j());
        stringBuffer.append(",msgId:");
        stringBuffer.append(a.a(this.b));
        stringBuffer.append(",flag:");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
