package com.huawei.android.pushagent.a;

import com.huawei.android.pushagent.b.a.b.b;

public class d {
    public String a;
    public int b;
    public b.a c;
    public boolean d;

    public d(String str, int i, boolean z, b.a aVar) {
        this.a = str;
        this.b = i;
        this.d = z;
        this.c = aVar;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ip:");
        stringBuffer.append(this.a);
        stringBuffer.append(" port:");
        stringBuffer.append(this.b);
        stringBuffer.append(" useProxy:");
        stringBuffer.append(this.d);
        stringBuffer.append(" conType");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }
}
