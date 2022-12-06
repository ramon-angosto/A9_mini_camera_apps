package com.huawei.android.pushagent.a.b;

import android.text.TextUtils;
import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a.e;
import java.io.InputStream;

public class c extends b {
    private String b = null;
    private byte c = -1;

    public c() {
        super(c());
    }

    public static byte c() {
        return -46;
    }

    public b a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[16];
        a(inputStream, bArr);
        this.b = new String(bArr, "UTF-8");
        byte[] bArr2 = new byte[1];
        a(inputStream, bArr2);
        this.c = bArr2[0];
        return this;
    }

    public byte[] b() {
        byte[] bArr = new byte[0];
        if (TextUtils.isEmpty(this.b)) {
            e.d("PushLogAC2705", "encode error, reason mDeviceId = " + this.b);
            return bArr;
        }
        try {
            byte[] bytes = this.b.getBytes("UTF-8");
            bArr = new byte[(bytes.length + 1 + 1)];
            bArr[0] = a();
            System.arraycopy(bytes, 0, bArr, 1, bytes.length);
            bArr[bArr.length - 1] = this.c;
            return bArr;
        } catch (Exception e) {
            e.a("PushLogAC2705", e.toString(), (Throwable) e);
            return bArr;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(" cmdId:");
        stringBuffer.append(j());
        stringBuffer.append(" mDeviceId:");
        stringBuffer.append(this.b);
        stringBuffer.append(" mNetworkType:");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
