package com.huawei.android.pushagent.a;

public class a {
    public String a;
    public Object b;
    public Class c;

    public a() {
    }

    public a(String str, Class cls, Object obj) {
        this.a = str;
        this.c = cls;
        this.b = obj;
    }

    public a(String str, Class cls, String str2) {
        this.a = str;
        this.c = cls;
        a(str2);
    }

    public void a(String str) {
        Class<String> cls = String.class;
        Class<Boolean> cls2 = this.c;
        Object obj = str;
        if (cls != cls2) {
            obj = Integer.class == cls2 ? Integer.valueOf(Integer.parseInt(str)) : Long.class == cls2 ? Long.valueOf(Long.parseLong(str)) : Boolean.class == cls2 ? Boolean.valueOf(Boolean.parseBoolean(str)) : null;
        }
        this.b = obj;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        stringBuffer.append(":");
        stringBuffer.append(this.b);
        stringBuffer.append(":");
        stringBuffer.append(this.c.getSimpleName());
        return stringBuffer.toString();
    }
}
