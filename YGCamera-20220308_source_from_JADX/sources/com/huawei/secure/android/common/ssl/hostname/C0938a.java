package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.huawei.secure.android.common.ssl.hostname.a */
public class C0938a {

    /* renamed from: a */
    private final String f1210a;

    /* renamed from: b */
    private final int f1211b = this.f1210a.length();

    /* renamed from: c */
    private int f1212c;

    /* renamed from: d */
    private int f1213d;

    /* renamed from: e */
    private int f1214e;

    /* renamed from: f */
    private int f1215f;

    /* renamed from: g */
    private char[] f1216g;

    public C0938a(X500Principal x500Principal) {
        this.f1210a = x500Principal.getName("RFC2253");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r8.f1216g;
        r2 = r8.f1213d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f1215f - r2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m1517a() {
        /*
            r8 = this;
            int r0 = r8.f1212c
            r8.f1213d = r0
            r8.f1214e = r0
        L_0x0006:
            int r0 = r8.f1212c
            int r1 = r8.f1211b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f1216g
            int r2 = r8.f1213d
            int r3 = r8.f1214e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f1216g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x0060
            if (r2 == r5) goto L_0x0053
            r5 = 92
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            int r2 = r8.f1214e
            int r3 = r2 + 1
            r8.f1214e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f1212c = r0
            goto L_0x0006
        L_0x0040:
            int r0 = r8.f1214e
            int r2 = r0 + 1
            r8.f1214e = r2
            char r2 = r8.m1518b()
            r1[r0] = r2
            int r0 = r8.f1212c
            int r0 = r0 + 1
            r8.f1212c = r0
            goto L_0x0006
        L_0x0053:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f1216g
            int r2 = r8.f1213d
            int r3 = r8.f1214e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0060:
            int r2 = r8.f1214e
            r8.f1215f = r2
            int r0 = r0 + 1
            r8.f1212c = r0
            int r0 = r2 + 1
            r8.f1214e = r0
            r1[r2] = r6
        L_0x006e:
            int r0 = r8.f1212c
            int r1 = r8.f1211b
            if (r0 >= r1) goto L_0x0087
            char[] r1 = r8.f1216g
            char r2 = r1[r0]
            if (r2 != r6) goto L_0x0087
            int r2 = r8.f1214e
            int r7 = r2 + 1
            r8.f1214e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f1212c = r0
            goto L_0x006e
        L_0x0087:
            int r0 = r8.f1212c
            int r1 = r8.f1211b
            if (r0 == r1) goto L_0x009b
            char[] r1 = r8.f1216g
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x009b
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x009b
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x009b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f1216g
            int r2 = r8.f1213d
            int r3 = r8.f1215f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.C0938a.m1517a():java.lang.String");
    }

    /* renamed from: b */
    private char m1518b() {
        this.f1212c++;
        int i = this.f1212c;
        if (i != this.f1211b) {
            char[] cArr = this.f1216g;
            char c = cArr[i];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#')) {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return m1519c();
                        }
                }
            }
            return cArr[i];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f1210a);
    }

    /* renamed from: c */
    private char m1519c() {
        int i;
        int i2;
        int a = m1516a(this.f1212c);
        this.f1212c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i2 = a & 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f1212c++;
            int i4 = this.f1212c;
            if (i4 == this.f1211b || this.f1216g[i4] != '\\') {
                return '?';
            }
            this.f1212c = i4 + 1;
            int a2 = m1516a(this.f1212c);
            this.f1212c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: d */
    private String m1520d() {
        int i = this.f1212c;
        if (i + 4 < this.f1211b) {
            this.f1213d = i;
            this.f1212c = i + 1;
            while (true) {
                int i2 = this.f1212c;
                if (i2 == this.f1211b) {
                    break;
                }
                char[] cArr = this.f1216g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f1214e = i2;
                    this.f1212c = i2 + 1;
                    while (true) {
                        int i3 = this.f1212c;
                        if (i3 >= this.f1211b || this.f1216g[i3] != ' ') {
                            break;
                        }
                        this.f1212c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f1212c++;
                }
            }
            this.f1214e = this.f1212c;
            int i4 = this.f1214e;
            int i5 = this.f1213d;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f1210a);
            }
            byte[] bArr = new byte[(i6 / 2)];
            int i7 = i5 + 1;
            for (int i8 = 0; i8 < bArr.length; i8++) {
                bArr[i8] = (byte) m1516a(i7);
                i7 += 2;
            }
            return new String(this.f1216g, this.f1213d, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f1210a);
    }

    /* renamed from: e */
    private String m1521e() {
        while (true) {
            int i = this.f1212c;
            if (i >= this.f1211b || this.f1216g[i] != ' ') {
                int i2 = this.f1212c;
            } else {
                this.f1212c = i + 1;
            }
        }
        int i22 = this.f1212c;
        if (i22 == this.f1211b) {
            return null;
        }
        this.f1213d = i22;
        this.f1212c = i22 + 1;
        while (true) {
            int i3 = this.f1212c;
            if (i3 >= this.f1211b) {
                break;
            }
            char[] cArr = this.f1216g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f1212c = i3 + 1;
        }
        int i4 = this.f1212c;
        if (i4 < this.f1211b) {
            this.f1214e = i4;
            if (this.f1216g[i4] == ' ') {
                while (true) {
                    int i5 = this.f1212c;
                    if (i5 >= this.f1211b) {
                        break;
                    }
                    char[] cArr2 = this.f1216g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f1212c = i5 + 1;
                }
                char[] cArr3 = this.f1216g;
                int i6 = this.f1212c;
                if (cArr3[i6] != '=' || i6 == this.f1211b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f1210a);
                }
            }
            this.f1212c++;
            while (true) {
                int i7 = this.f1212c;
                if (i7 >= this.f1211b || this.f1216g[i7] != ' ') {
                    int i8 = this.f1214e;
                    int i9 = this.f1213d;
                } else {
                    this.f1212c = i7 + 1;
                }
            }
            int i82 = this.f1214e;
            int i92 = this.f1213d;
            if (i82 - i92 > 4) {
                char[] cArr4 = this.f1216g;
                if (cArr4[i92 + 3] == '.' && (cArr4[i92] == 'O' || cArr4[i92] == 'o')) {
                    char[] cArr5 = this.f1216g;
                    int i10 = this.f1213d + 1;
                    if (cArr5[i10] == 'I' || cArr5[i10] == 'i') {
                        char[] cArr6 = this.f1216g;
                        int i11 = this.f1213d + 2;
                        if (cArr6[i11] == 'D' || cArr6[i11] == 'd') {
                            this.f1213d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f1216g;
            int i12 = this.f1213d;
            return new String(cArr7, i12, this.f1214e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f1210a);
    }

    /* renamed from: f */
    private String m1522f() {
        this.f1212c++;
        this.f1213d = this.f1212c;
        this.f1214e = this.f1213d;
        while (true) {
            int i = this.f1212c;
            if (i != this.f1211b) {
                char[] cArr = this.f1216g;
                if (cArr[i] == '\"') {
                    this.f1212c = i + 1;
                    while (true) {
                        int i2 = this.f1212c;
                        if (i2 >= this.f1211b || this.f1216g[i2] != ' ') {
                            char[] cArr2 = this.f1216g;
                            int i3 = this.f1213d;
                        } else {
                            this.f1212c = i2 + 1;
                        }
                    }
                    char[] cArr22 = this.f1216g;
                    int i32 = this.f1213d;
                    return new String(cArr22, i32, this.f1214e - i32);
                }
                if (cArr[i] == '\\') {
                    cArr[this.f1214e] = m1518b();
                } else {
                    cArr[this.f1214e] = cArr[i];
                }
                this.f1212c++;
                this.f1214e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f1210a);
            }
        }
    }

    /* renamed from: b */
    public List<String> mo14790b(String str) {
        String str2;
        this.f1212c = 0;
        this.f1213d = 0;
        this.f1214e = 0;
        this.f1215f = 0;
        this.f1216g = this.f1210a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String e = m1521e();
        if (e == null) {
            return emptyList;
        }
        do {
            int i = this.f1212c;
            if (i < this.f1211b) {
                char c = this.f1216g[i];
                if (c == '\"') {
                    str2 = m1522f();
                } else if (c != '#') {
                    str2 = (c == '+' || c == ',' || c == ';') ? "" : m1517a();
                } else {
                    str2 = m1520d();
                }
                if (str.equalsIgnoreCase(e)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(str2);
                }
                int i2 = this.f1212c;
                if (i2 < this.f1211b) {
                    char[] cArr = this.f1216g;
                    if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                        this.f1212c++;
                        e = m1521e();
                    } else {
                        throw new IllegalStateException("Malformed DN: " + this.f1210a);
                    }
                }
            }
            return emptyList;
        } while (e != null);
        throw new IllegalStateException("Malformed DN: " + this.f1210a);
    }

    /* renamed from: a */
    private int m1516a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f1211b) {
            char c = this.f1216g[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f1210a);
            } else {
                i2 = c - '7';
            }
            char c2 = this.f1216g[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f1210a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f1210a);
    }

    /* renamed from: a */
    public String mo14789a(String str) {
        String str2;
        this.f1212c = 0;
        this.f1213d = 0;
        this.f1214e = 0;
        this.f1215f = 0;
        this.f1216g = this.f1210a.toCharArray();
        String e = m1521e();
        if (e == null) {
            return null;
        }
        do {
            int i = this.f1212c;
            if (i == this.f1211b) {
                return null;
            }
            char c = this.f1216g[i];
            if (c == '\"') {
                str2 = m1522f();
            } else if (c != '#') {
                str2 = (c == '+' || c == ',' || c == ';') ? "" : m1517a();
            } else {
                str2 = m1520d();
            }
            if (str.equalsIgnoreCase(e)) {
                return str2;
            }
            int i2 = this.f1212c;
            if (i2 >= this.f1211b) {
                return null;
            }
            char[] cArr = this.f1216g;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.f1212c++;
                e = m1521e();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f1210a);
            }
        } while (e != null);
        throw new IllegalStateException("Malformed DN: " + this.f1210a);
    }
}
