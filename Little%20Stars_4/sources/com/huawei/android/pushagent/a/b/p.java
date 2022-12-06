package com.huawei.android.pushagent.a.b;

import android.text.TextUtils;
import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class p extends b {
    private String b = null;

    public p() {
        super(c());
    }

    public p(String str) {
        super(c());
        a(str);
    }

    public static byte c() {
        return -42;
    }

    public b a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[32];
        a(inputStream, bArr);
        this.b = new String(bArr, "UTF-8");
        return this;
    }

    public void a(String str) {
        this.b = str;
    }

    public byte[] b() {
        byte[] bArr = new byte[0];
        try {
            if (TextUtils.isEmpty(this.b)) {
                e.d("PushLogAC2705", "encode error reason mToken is empty");
                return bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(d().getBytes("UTF-8"));
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
        return "UnRegisterReqMessage[token:" + this.b + "]";
    }
}
