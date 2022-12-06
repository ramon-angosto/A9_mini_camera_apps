package com.huawei.android.pushagent.a.b;

import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a;
import java.io.IOException;
import java.io.InputStream;

public class f extends b {
    public f() {
        super(c());
    }

    public static byte c() {
        return -47;
    }

    public b a(InputStream inputStream) throws IOException {
        return this;
    }

    public byte[] b() {
        return new byte[]{this.a};
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HeartBeatRspMessage[");
        stringBuffer.append("cmdId:");
        stringBuffer.append(a.a(this.a));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
