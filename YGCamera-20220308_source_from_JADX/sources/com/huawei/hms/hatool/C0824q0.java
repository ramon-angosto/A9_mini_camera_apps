package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.hatool.q0 */
public class C0824q0 {
    /* renamed from: a */
    public static String m1002a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2)) {
            return m1005a(str, str2, str3) ? str2 : str4;
        }
        C0841y.m1092f("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + str);
        return str4;
    }

    /* renamed from: a */
    public static boolean m1003a(String str) {
        return !m1004a("eventId", str, 256);
    }

    /* renamed from: a */
    public static boolean m1004a(String str, String str2, int i) {
        StringBuilder sb;
        String str3;
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
            str3 = "checkString() Parameter is empty : ";
        } else if (str2.length() <= i) {
            return true;
        } else {
            sb = new StringBuilder();
            str3 = "checkString() Failure of parameter length check! Parameter:";
        }
        sb.append(str3);
        sb.append(str);
        C0841y.m1092f("hmsSdk", sb.toString());
        return false;
    }

    /* renamed from: a */
    public static boolean m1005a(String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
            str4 = "checkString() Parameter is null! Parameter:";
        } else if (Pattern.compile(str3).matcher(str2).matches()) {
            return true;
        } else {
            sb = new StringBuilder();
            str4 = "checkString() Parameter verification failure! Parameter:";
        }
        sb.append(str4);
        sb.append(str);
        C0841y.m1092f("hmsSdk", sb.toString());
        return false;
    }

    /* renamed from: a */
    public static boolean m1006a(Map<String, String> map) {
        String str;
        if (map == null || map.size() == 0) {
            str = "onEvent() mapValue has not data.so,The data will be empty";
        } else if (map.size() == 1 && (map.get("constants") != null || map.get("_constants") != null)) {
            str = "checkMap() the key can't be constants or _constants";
        } else if (map.size() <= 2048 && map.toString().length() <= 204800) {
            return true;
        } else {
            str = "checkMap Map data is too big! size: " + map.size() + " length: " + map.toString().length();
        }
        C0841y.m1092f("hmsSdk", str);
        return false;
    }
}
