package com.huawei.android.pushagent.a.b;

import android.text.TextUtils;
import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class q extends b {
    private String b = null;
    private byte c = 1;

    public q() {
        super(c());
    }

    public static byte c() {
        return -41;
    }

    public b a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[32];
        a(inputStream, bArr);
        this.b = new String(bArr, "UTF-8");
        byte[] bArr2 = new byte[1];
        a(inputStream, bArr2);
        this.c = bArr2[0];
        return this;
    }

    public byte[] b() {
        byte[] bArr = new byte[0];
        try {
            if (TextUtils.isEmpty(this.b)) {
                e.d("PushLogAC2705", "encode error, mToken = " + this.b);
                return bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(this.b.getBytes("UTF-8"));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.d("PushLogAC2705", "encode error " + e.toString());
            return bArr;
        }
    }

    public String d() {
        return this.b;
    }

    public String toString() {
        return "UnRegisterRspMessage[token:" + this.b + " result:" + this.c + "]";
    }
}
