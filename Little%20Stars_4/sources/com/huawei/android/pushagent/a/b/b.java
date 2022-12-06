package com.huawei.android.pushagent.a.b;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public class b extends com.huawei.android.pushagent.a.b.a.b {
    private JSONObject b = new JSONObject();

    public b() {
    }

    public b(byte b2) {
        super(b2);
    }

    public com.huawei.android.pushagent.a.b.a.b a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[2];
        a(inputStream, bArr);
        int c = a.c(bArr);
        e.a("PushLogAC2705", "push message len=" + c);
        byte[] bArr2 = new byte[c];
        a(inputStream, bArr2);
        String str = new String(bArr2, "UTF-8");
        e.a("PushLogAC2705", "push message data :" + str);
        this.b = new JSONObject(str);
        return this;
    }

    public byte[] b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(a());
            if (this.b.length() == 0) {
                byteArrayOutputStream.write(a.b(0));
            } else {
                byte[] bytes = this.b.toString().getBytes("UTF-8");
                byteArrayOutputStream.write(a.b(bytes.length));
                byteArrayOutputStream.write(bytes);
                e.a("PushLogAC2705", " begin to send:" + this.b);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.a("PushLogAC2705", "encode error," + e.toString());
            return new byte[0];
        }
    }

    public JSONObject c() {
        return this.b;
    }

    public String toString() {
        return this.b.toString();
    }
}
