package com.bytedance.sdk.component.b.a;

import com.bytedance.sdk.component.b.a.b.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;

/* compiled from: HttpUrl */
public final class f {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;
    final String b;
    final int c;
    private final String e;
    private final String f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    f(a aVar) {
        this.a = aVar.a;
        this.e = a(aVar.b, false);
        this.f = a(aVar.c, false);
        this.b = aVar.d;
        this.c = aVar.a();
        this.g = a(aVar.f, false);
        String str = null;
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : str;
        this.j = aVar.toString();
    }

    public URL a() {
        try {
            return new URL(this.j);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String b() {
        if (this.e.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.j;
        return this.j.substring(length, i.a(str, length, str.length(), ":@"));
    }

    public String c() {
        if (this.f.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.a.length() + 3) + 1, indexOf);
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public List<String> d() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        String str = this.j;
        int a2 = i.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = i.a(this.j, i2, a2, '/');
            arrayList.add(this.j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String e() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, i.a(str, indexOf, str.length(), '#'));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static f c(String str) {
        a aVar = new a();
        if (aVar.a((f) null, str) == a.C0029a.SUCCESS) {
            return aVar.b();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).j.equals(this.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    /* compiled from: HttpUrl */
    public static final class a {
        String a;
        String b = "";
        String c = "";
        String d;
        int e = -1;
        final List<String> f = new ArrayList();
        List<String> g;
        String h;

        /* renamed from: com.bytedance.sdk.component.b.a.f$a$a  reason: collision with other inner class name */
        /* compiled from: HttpUrl */
        enum C0029a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f.add("");
        }

        public a a(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a b(String str) {
            if (str != null) {
                String e2 = e(str, 0, str.length());
                if (e2 != null) {
                    this.d = e2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* access modifiers changed from: package-private */
        public int a() {
            int i = this.e;
            return i != -1 ? i : f.a(this.a);
        }

        public a c(String str) {
            if (str != null) {
                return a(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        private a a(String str, boolean z) {
            int i = 0;
            do {
                int a2 = i.a(str, i, str.length(), "/\\");
                a(str, i, a2, a2 < str.length(), z);
                i = a2 + 1;
            } while (i <= str.length());
            return this;
        }

        public a d(String str) {
            this.g = str != null ? f.b(f.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(f.a(str, " \"'<>#&=", true, false, true, true));
                this.g.add(str2 != null ? f.a(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public f b() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.d != null) {
                return new f(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int a2 = a();
            if (a2 != f.a(this.a)) {
                sb.append(':');
                sb.append(a2);
            }
            f.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                f.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public C0029a a(f fVar, String str) {
            int i;
            int a2;
            int i2;
            f fVar2 = fVar;
            String str2 = str;
            int a3 = i.a(str2, 0, str.length());
            int b2 = i.b(str2, a3, str.length());
            if (b(str2, a3, b2) != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.a = "https";
                    a3 += 6;
                } else if (!str.regionMatches(true, a3, "http:", 0, 5)) {
                    return C0029a.UNSUPPORTED_SCHEME;
                } else {
                    this.a = "http";
                    a3 += 5;
                }
            } else if (fVar2 == null) {
                return C0029a.MISSING_SCHEME;
            } else {
                this.a = fVar2.a;
            }
            int c2 = c(str2, a3, b2);
            char c3 = '?';
            char c4 = '#';
            if (c2 >= 2 || fVar2 == null || !fVar2.a.equals(this.a)) {
                boolean z = false;
                boolean z2 = false;
                int i3 = a3 + c2;
                while (true) {
                    a2 = i.a(str2, i3, b2, "@/\\?#");
                    char charAt = a2 != b2 ? str2.charAt(a2) : 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        i = a2;
                        int d2 = d(str2, i3, i);
                        int i4 = d2 + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int a4 = i.a(str2, i3, a2, ':');
                                int i5 = a4;
                                String str3 = "%40";
                                i2 = a2;
                                String a5 = f.a(str, i3, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z2) {
                                    a5 = this.b + str3 + a5;
                                }
                                this.b = a5;
                                if (i5 != i2) {
                                    this.c = f.a(str, i5 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i2 = a2;
                                this.c += "%40" + f.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                            }
                            i3 = i2 + 1;
                        }
                        c3 = '?';
                        c4 = '#';
                    }
                }
                i = a2;
                int d22 = d(str2, i3, i);
                int i42 = d22 + 1;
                if (i42 < i) {
                    this.d = e(str2, i3, d22);
                    this.e = f(str2, i42, i);
                    if (this.e == -1) {
                        return C0029a.INVALID_PORT;
                    }
                } else {
                    this.d = e(str2, i3, d22);
                    this.e = f.a(this.a);
                }
                if (this.d == null) {
                    return C0029a.INVALID_HOST;
                }
            } else {
                this.b = fVar.b();
                this.c = fVar.c();
                this.d = fVar2.b;
                this.e = fVar2.c;
                this.f.clear();
                this.f.addAll(fVar.d());
                if (a3 == b2 || str2.charAt(a3) == '#') {
                    d(fVar.e());
                }
                i = a3;
            }
            int a6 = i.a(str2, i, b2, "?#");
            a(str2, i, a6);
            if (a6 < b2 && str2.charAt(a6) == '?') {
                int a7 = i.a(str2, a6, b2, '#');
                this.g = f.b(f.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, (Charset) null));
                a6 = a7;
            }
            if (a6 < b2 && str2.charAt(a6) == '#') {
                this.h = f.a(str, 1 + a6, b2, "", true, false, false, false, (Charset) null);
            }
            return C0029a.SUCCESS;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = com.bytedance.sdk.component.b.a.b.i.a((java.lang.String) r11, (int) r6, (int) r13, (java.lang.String) r12)
                if (r12 >= r13) goto L_0x0036
                r0 = r3
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.a.f.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = f.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, (Charset) null);
            if (!e(a2)) {
                if (f(a2)) {
                    c();
                    return;
                }
                List<String> list = this.f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f.add(a2);
                }
                if (z) {
                    this.f.add("");
                }
            }
        }

        private boolean e(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean f(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void c() {
            List<String> list = this.f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
                return;
            }
            List<String> list2 = this.f;
            list2.set(list2.size() - 1, "");
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) == ']');
                }
                i++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            return i.a(f.a(str, i, i2, false));
        }

        private static int f(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(f.a(str, i, i2, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.bytedance.sdk.component.b.a.b.a aVar = new com.bytedance.sdk.component.b.a.b.a();
                aVar.a(str, i2, i4);
                a(aVar, str, i4, i3, z);
                return aVar.c();
            }
        }
        return str.substring(i2, i3);
    }

    static void a(com.bytedance.sdk.component.b.a.b.a aVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = i.a(str.charAt(i2 + 1));
                int a3 = i.a(str.charAt(i4));
                if (!(a2 == -1 || a3 == -1)) {
                    aVar.b((a2 << 4) + a3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                aVar.b(32);
                i2 += Character.charCount(codePointAt);
            }
            aVar.a(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        if (i4 >= i3 || str.charAt(i2) != '%' || i.a(str.charAt(i2 + 1)) == -1 || i.a(str.charAt(i4)) == -1) {
            return false;
        }
        return true;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i4 = i3;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i5, i3)))) && (codePointAt != 43 || !z3))) {
                    i5 += Character.charCount(codePointAt);
                }
            }
            com.bytedance.sdk.component.b.a.b.a aVar = new com.bytedance.sdk.component.b.a.b.a();
            int i6 = i2;
            aVar.a(str, i2, i5);
            a(aVar, str, i5, i3, str2, z, z2, z3, z4, charset);
            return aVar.c();
        }
        int i7 = i2;
        return str.substring(i2, i3);
    }

    static void a(com.bytedance.sdk.component.b.a.b.a aVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.b.a.b.a aVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    aVar.a(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (aVar2 == null) {
                        aVar2 = new com.bytedance.sdk.component.b.a.b.a();
                    }
                    if (charset == null || charset.equals(i.a)) {
                        aVar2.a(codePointAt);
                    } else {
                        aVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!aVar2.a()) {
                        byte b2 = aVar2.b() & UByte.MAX_VALUE;
                        aVar.b(37);
                        aVar.b((int) d[(b2 >> 4) & 15]);
                        aVar.b((int) d[b2 & 15]);
                    }
                } else {
                    aVar.a(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, (Charset) null);
    }
}
