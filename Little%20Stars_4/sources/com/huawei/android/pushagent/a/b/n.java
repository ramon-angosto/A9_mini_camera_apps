package com.huawei.android.pushagent.a.b;

import android.text.TextUtils;
import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class n extends b {
    private String b = null;
    private String c = null;

    public n() {
        super(c());
    }

    public n(String str, String str2) {
        super(c());
        this.b = str;
        this.c = str2;
    }

    public static byte c() {
        return -36;
    }

    public b a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[16];
        a(inputStream, bArr);
        this.b = new String(bArr, "UTF-8");
        byte[] bArr2 = new byte[2];
        a(inputStream, bArr2);
        byte[] bArr3 = new byte[a.c(bArr2)];
        a(inputStream, bArr3);
        this.c = new String(bArr3, "UTF-8");
        return this;
    }

    public byte[] b() {
        byte[] bArr = new byte[0];
        try {
            if (TextUtils.isEmpty(this.b)) {
                e.d("PushLogAC2705", "encode error mDeviceId = " + this.b);
                return bArr;
            } else if (TextUtils.isEmpty(this.c)) {
                e.d("PushLogAC2705", "encode error mPackageName = " + this.c);
                return bArr;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(a());
                byteArrayOutputStream.write(this.b.getBytes("UTF-8"));
                byteArrayOutputStream.write(a.b(this.c.length()));
                byteArrayOutputStream.write(this.c.getBytes("UTF-8"));
                return byteArrayOutputStream.toByteArray();
            }
        } catch (IOException e) {
            e.d("PushLogAC2705", "encode error " + e.toString());
            return bArr;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RegisterTokenReqMessage[");
        stringBuffer.append("deviceId:");
        stringBuffer.append(this.b);
        stringBuffer.append(",packageName:");
        stringBuffer.append(this.c);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
