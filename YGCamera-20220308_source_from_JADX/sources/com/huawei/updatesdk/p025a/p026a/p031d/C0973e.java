package com.huawei.updatesdk.p025a.p026a.p031d;

import java.util.List;

/* renamed from: com.huawei.updatesdk.a.a.d.e */
public class C0973e {
    /* renamed from: a */
    private static String m1694a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public static String m1695a(List<String> list, String str) {
        return m1696a(list, str, (String) null, (String) null);
    }

    /* renamed from: a */
    public static String m1696a(List<String> list, String str, String str2, String str3) {
        return (list == null || list.isEmpty()) ? "" : m1698a((String[]) list.toArray(new String[0]), str, str2, str3);
    }

    /* renamed from: a */
    public static String m1697a(String[] strArr, String str) {
        return m1698a(strArr, str, (String) null, (String) null);
    }

    /* renamed from: a */
    public static String m1698a(String[] strArr, String str, String str2, String str3) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String a = m1694a(str);
        String a2 = m1694a(str2);
        String a3 = m1694a(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append(strArr[0]);
        sb.append(a3);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(a);
            sb.append(a2);
            sb.append(strArr[i]);
            sb.append(a3);
        }
        return sb.toString();
    }
}
