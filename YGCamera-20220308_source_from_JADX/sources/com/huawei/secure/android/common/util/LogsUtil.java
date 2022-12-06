package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

public class LogsUtil {

    /* renamed from: k */
    private static final Pattern f1262k = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: l */
    private static final char f1263l = '*';

    /* renamed from: m */
    private static final int f1264m = 2;

    /* renamed from: a */
    private static String m1605a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(m1603a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m1604a(String str, String str2) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(m1603a(str2));
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static void m1613d(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, m1605a(str2, z));
        }
    }

    /* renamed from: d */
    public static void m1609d(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.d(str, m1604a(str2, str3));
        }
    }

    /* renamed from: d */
    public static void m1610d(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.d(str, m1604a(str2, str3), m1606a(th));
        }
    }

    /* renamed from: d */
    public static void m1608d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, m1605a(str2, false));
        }
    }

    /* renamed from: d */
    public static void m1612d(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, m1605a(str2, z), m1606a(th));
        }
    }

    /* renamed from: d */
    public static void m1611d(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.d(str, m1605a(str2, false), m1606a(th));
        }
    }

    /* renamed from: i */
    public static void m1625i(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, m1605a(str2, z));
        }
    }

    /* renamed from: i */
    public static void m1621i(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, m1604a(str2, str3));
        }
    }

    /* renamed from: i */
    public static void m1622i(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, m1604a(str2, str3), m1606a(th));
        }
    }

    /* renamed from: i */
    public static void m1620i(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, m1605a(str2, false));
        }
    }

    /* renamed from: i */
    public static void m1624i(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.i(str, m1605a(str2, z), m1606a(th));
        }
    }

    /* renamed from: i */
    public static void m1623i(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.i(str, m1605a(str2, false), m1606a(th));
        }
    }

    /* renamed from: w */
    public static void m1631w(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, m1605a(str2, z));
        }
    }

    /* renamed from: w */
    public static void m1627w(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, m1604a(str2, str3));
        }
    }

    /* renamed from: w */
    public static void m1628w(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, m1604a(str2, str3), m1606a(th));
        }
    }

    /* renamed from: w */
    public static void m1626w(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, m1605a(str2, false));
        }
    }

    /* renamed from: w */
    public static void m1630w(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.w(str, m1605a(str2, z), m1606a(th));
        }
    }

    /* renamed from: w */
    public static void m1629w(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.w(str, m1605a(str2, false), m1606a(th));
        }
    }

    /* renamed from: e */
    public static void m1619e(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, m1605a(str2, z));
        }
    }

    /* renamed from: e */
    public static void m1615e(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, m1604a(str2, str3));
        }
    }

    /* renamed from: e */
    public static void m1616e(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, m1604a(str2, str3), m1606a(th));
        }
    }

    /* renamed from: e */
    public static void m1614e(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, m1605a(str2, false));
        }
    }

    /* renamed from: e */
    public static void m1618e(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.e(str, m1605a(str2, z), m1606a(th));
        }
    }

    /* renamed from: e */
    public static void m1617e(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.e(str, m1605a(str2, false), m1606a(th));
        }
    }

    /* renamed from: a */
    private static String m1603a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i = 1;
        if (1 == length) {
            return String.valueOf(f1263l);
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (f1262k.matcher(String.valueOf(charAt)).matches()) {
                if (i % 2 == 0) {
                    charAt = f1263l;
                }
                i++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static Throwable m1606a(Throwable th) {
        if (th == null) {
            return null;
        }
        C0950a aVar = new C0950a(th);
        aVar.setStackTrace(th.getStackTrace());
        aVar.setMessage(m1607b(th.getMessage()));
        Throwable cause = th.getCause();
        C0950a aVar2 = aVar;
        while (cause != null) {
            C0950a aVar3 = new C0950a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.setMessage(m1607b(cause.getMessage()));
            aVar2.mo14808b(aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }

    /* renamed from: b */
    private static String m1607b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 0) {
                charArray[i] = f1263l;
            }
        }
        return new String(charArray);
    }

    /* renamed from: com.huawei.secure.android.common.util.LogsUtil$a */
    private static class C0950a extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;

        /* renamed from: n */
        private String f1265n;

        /* renamed from: o */
        private Throwable f1266o;

        /* renamed from: p */
        private Throwable f1267p;

        public C0950a(Throwable th) {
            this.f1267p = th;
        }

        public Throwable getCause() {
            Throwable th = this.f1266o;
            if (th == this) {
                return null;
            }
            return th;
        }

        /* renamed from: b */
        public void mo14808b(Throwable th) {
            this.f1266o = th;
        }

        public String getMessage() {
            return this.f1265n;
        }

        public void setMessage(String str) {
            this.f1265n = str;
        }

        public String toString() {
            Throwable th = this.f1267p;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f1265n == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f1265n.startsWith(str)) {
                return this.f1265n;
            }
            return str + this.f1265n;
        }
    }
}
