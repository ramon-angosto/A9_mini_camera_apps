package com.huawei.hms.base.p013ui;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.base.ui.a */
/* compiled from: LogUtil */
public class C0690a {

    /* renamed from: a */
    public static final Pattern f433a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: a */
    public static void m417a(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, m415a(str2, z));
        }
    }

    /* renamed from: a */
    public static void m416a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, m415a(str2, false));
        }
    }

    /* renamed from: a */
    public static String m415a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(m414a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m414a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (f433a.matcher(String.valueOf(charAt)).matches()) {
                if (i % 2 == 0) {
                    charAt = '*';
                }
                i++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
