package com.huawei.updatesdk.p025a.p034b.p037c.p038c;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.updatesdk.p025a.p026a.p031d.C0974f;
import com.huawei.updatesdk.p025a.p026a.p031d.C0975g;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;
import com.shix.shixipc.system.ContentCommon;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.a.b.c.c.c */
public class C0993c {
    public static final String CLIENT_API = "clientApi";
    private static final String END_FLAG = "_";
    private static String url;
    @SDKNetTransmission
    private String method;
    @SDKNetTransmission
    private String ver = ContentCommon.APP_SOFTVERSION;

    /* renamed from: a */
    private String m1789a(Field field) {
        Object obj = field.get(this);
        if (obj instanceof C0991b) {
            return ((C0991b) obj).toJson();
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    /* renamed from: c */
    public static void m1790c(String str) {
        url = str;
    }

    /* renamed from: a */
    public String mo14920a() {
        mo14926e();
        Map<String, Field> c = mo14924c();
        String[] strArr = new String[c.size()];
        c.keySet().toArray(strArr);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do {
            String a = m1789a(c.get(strArr[i]));
            if (a != null) {
                String a2 = C0975g.m1702a(a);
                sb.append(strArr[i]);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(a2);
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            i++;
        } while (i < strArr.length);
        int length = sb.length();
        if (length > 0) {
            int i2 = length - 1;
            if (sb.charAt(i2) == '&') {
                sb.deleteCharAt(i2);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo14921a(String str) {
        this.method = str;
    }

    /* renamed from: b */
    public String mo14922b() {
        return this.method;
    }

    /* renamed from: b */
    public void mo14923b(String str) {
        this.ver = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Map<String, Field> mo14924c() {
        HashMap hashMap = new HashMap();
        for (Field field : C0974f.m1701a((Class) getClass())) {
            field.setAccessible(true);
            String name = field.getName();
            if (name.endsWith(END_FLAG) || field.isAnnotationPresent(SDKNetTransmission.class)) {
                if (name.endsWith(END_FLAG)) {
                    name = name.substring(0, name.length() - 1);
                }
                hashMap.put(name, field);
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    public String mo14925d() {
        return url + CLIENT_API;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo14926e() {
    }
}
