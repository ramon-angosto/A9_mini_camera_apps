package com.huawei.hms.hatool;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.g0 */
public class C0796g0 {
    /* renamed from: a */
    public static long m828a(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0841y.m1092f("hmsSdk", "context is null or spName empty or spkey is empty");
            return j;
        }
        SharedPreferences b = m832b(context, str);
        return b != null ? b.getLong(str2, j) : j;
    }

    /* renamed from: a */
    public static String m829a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0841y.m1092f("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences b = m832b(context, str);
        return b != null ? b.getString(str2, str3) : str3;
    }

    /* renamed from: a */
    public static Map<String, ?> m830a(Context context, String str) {
        return m832b(context, str).getAll();
    }

    /* renamed from: a */
    public static void m831a(Context context, String str, String... strArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else if (strArr == null) {
            str2 = "clearData(): No data need to be deleted,keys is null";
        } else {
            SharedPreferences b = m832b(context, str);
            if (b != null) {
                SharedPreferences.Editor edit = b.edit();
                if (strArr.length == 0) {
                    edit.clear();
                    edit.commit();
                    return;
                }
                for (String str3 : strArr) {
                    if (b.contains(str3)) {
                        edit.remove(str3);
                        edit.commit();
                    }
                }
                return;
            }
            return;
        }
        C0841y.m1092f("hmsSdk", str2);
    }

    /* renamed from: b */
    public static SharedPreferences m832b(Context context, String str) {
        return context.getSharedPreferences(m835c(context, str), 0);
    }

    /* renamed from: b */
    public static void m833b(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0841y.m1092f("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences b = m832b(context, str);
        if (b != null) {
            SharedPreferences.Editor edit = b.edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    /* renamed from: b */
    public static void m834b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0841y.m1091e("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences b = m832b(context, str);
        if (b != null) {
            SharedPreferences.Editor edit = b.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    /* renamed from: c */
    public static String m835c(Context context, String str) {
        String packageName = context.getPackageName();
        String n = C0781c.m754n("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(n)) {
            return "hms_" + str + "_" + packageName;
        }
        return "hms_" + str + "_" + packageName + "_" + n;
    }
}
