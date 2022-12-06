package com.huawei.hms.hatool;

import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.huawei.hms.hatool.s0 */
public abstract class C0828s0 {
    /* renamed from: a */
    public static long m1021a(String str, long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j))).getTime();
        } catch (ParseException unused) {
            C0841y.m1092f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0;
        }
    }

    /* renamed from: a */
    public static Pair<String, String> m1022a(String str) {
        String str2;
        String str3;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new Pair<>(str2, str3);
    }

    /* renamed from: a */
    public static String m1023a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    /* renamed from: a */
    public static String m1024a(String str, String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2;
    }

    /* renamed from: a */
    public static String m1025a(String str, String str2, String str3) {
        if ("_default_config_tag".equals(str)) {
            return "_default_config_tag#" + str3;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + "#" + str3;
    }

    /* renamed from: a */
    public static Set<String> m1026a(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String next : set) {
            if (!"_default_config_tag".equals(next)) {
                String str = next + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "oper";
                String str2 = next + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "maint";
                hashSet.add(str);
                hashSet.add(str2);
                hashSet.add(next + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "diffprivacy");
            } else {
                hashSet.add("_default_config_tag");
            }
        }
        return hashSet;
    }
}
