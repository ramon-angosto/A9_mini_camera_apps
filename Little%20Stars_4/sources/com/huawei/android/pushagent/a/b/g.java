package com.huawei.android.pushagent.a.b;

import com.huawei.android.pushagent.c.a;
import java.io.Serializable;

public class g implements Serializable {
    private long a;
    private byte b;
    private byte c;

    public long a() {
        return this.a;
    }

    public void a(byte b2) {
        this.b = b2;
    }

    public void a(long j) {
        this.a = j;
    }

    public byte b() {
        return this.b;
    }

    public void b(byte b2) {
        this.c = b2;
    }

    public byte c() {
        return this.c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(" netEventTime:");
        stringBuffer.append(a.a(this.a, "yyyy-MM-dd HH:mm:ss SSS"));
        stringBuffer.append(" netType:");
        stringBuffer.append(this.b);
        stringBuffer.append(" netEvent:");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
