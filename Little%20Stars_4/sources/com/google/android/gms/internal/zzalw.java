package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

public class zzalw implements Closeable {
    private static final char[] zzbZl = ")]}'\n".toCharArray();
    private final Reader in;
    private int pos = 0;
    private int zzbQl = 0;
    private boolean zzbZm = false;
    private final char[] zzbZn = new char[1024];
    private int zzbZo = 0;
    private int zzbZp = 0;
    /* access modifiers changed from: private */
    public int zzbZq = 0;
    private long zzbZr;
    private int zzbZs;
    private String zzbZt;
    private int[] zzbZu = new int[32];
    private int zzbZv = 0;
    private String[] zzbZw;
    private int[] zzbZx;

    static {
        zzalb.zzbXe = new zzalb() {
            public void zzi(zzalw zzalw) throws IOException {
                int i;
                if (zzalw instanceof zzalm) {
                    ((zzalm) zzalw).zzWd();
                    return;
                }
                int zzG = zzalw.zzbZq;
                if (zzG == 0) {
                    zzG = zzalw.zzWn();
                }
                if (zzG == 13) {
                    i = 9;
                } else if (zzG == 12) {
                    i = 8;
                } else if (zzG == 14) {
                    i = 10;
                } else {
                    String valueOf = String.valueOf(zzalw.zzWa());
                    int zzI = zzalw.getLineNumber();
                    int zzJ = zzalw.getColumnNumber();
                    String path = zzalw.getPath();
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(path).length());
                    sb.append("Expected a name but was ");
                    sb.append(valueOf);
                    sb.append(" ");
                    sb.append(" at line ");
                    sb.append(zzI);
                    sb.append(" column ");
                    sb.append(zzJ);
                    sb.append(" path ");
                    sb.append(path);
                    throw new IllegalStateException(sb.toString());
                }
                int unused = zzalw.zzbZq = i;
            }
        };
    }

    public zzalw(Reader reader) {
        int[] iArr = this.zzbZu;
        int i = this.zzbZv;
        this.zzbZv = i + 1;
        iArr[i] = 6;
        this.zzbZw = new String[32];
        this.zzbZx = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    /* access modifiers changed from: private */
    public int getColumnNumber() {
        return (this.pos - this.zzbZp) + 1;
    }

    /* access modifiers changed from: private */
    public int getLineNumber() {
        return this.zzbZo + 1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int zzWn() throws java.io.IOException {
        /*
            r15 = this;
            int[] r0 = r15.zzbZu
            int r1 = r15.zzbZv
            int r2 = r1 + -1
            r2 = r0[r2]
            r3 = 8
            r4 = 39
            r5 = 34
            r6 = 93
            r7 = 3
            r8 = 7
            r9 = 59
            r10 = 44
            r11 = 4
            r12 = 2
            r13 = 1
            if (r2 != r13) goto L_0x0020
            int r1 = r1 - r13
            r0[r1] = r12
            goto L_0x00a2
        L_0x0020:
            if (r2 != r12) goto L_0x003a
            int r0 = r15.zzaY(r13)
            if (r0 == r10) goto L_0x00a2
            if (r0 == r9) goto L_0x0036
            if (r0 != r6) goto L_0x002f
            r15.zzbZq = r11
            return r11
        L_0x002f:
            java.lang.String r0 = "Unterminated array"
            java.io.IOException r0 = r15.zziW(r0)
            throw r0
        L_0x0036:
            r15.zzWs()
            goto L_0x00a2
        L_0x003a:
            r14 = 5
            if (r2 == r7) goto L_0x0126
            if (r2 != r14) goto L_0x0041
            goto L_0x0126
        L_0x0041:
            if (r2 != r11) goto L_0x0076
            int r1 = r1 - r13
            r0[r1] = r14
            int r0 = r15.zzaY(r13)
            r1 = 58
            if (r0 == r1) goto L_0x00a2
            r1 = 61
            if (r0 != r1) goto L_0x006f
            r15.zzWs()
            int r0 = r15.pos
            int r1 = r15.zzbQl
            if (r0 < r1) goto L_0x0061
            boolean r0 = r15.zznR(r13)
            if (r0 == 0) goto L_0x00a2
        L_0x0061:
            char[] r0 = r15.zzbZn
            int r1 = r15.pos
            char r0 = r0[r1]
            r14 = 62
            if (r0 != r14) goto L_0x00a2
            int r1 = r1 + r13
            r15.pos = r1
            goto L_0x00a2
        L_0x006f:
            java.lang.String r0 = "Expected ':'"
            java.io.IOException r0 = r15.zziW(r0)
            throw r0
        L_0x0076:
            r0 = 6
            if (r2 != r0) goto L_0x0088
            boolean r0 = r15.zzbZm
            if (r0 == 0) goto L_0x0080
            r15.zzWv()
        L_0x0080:
            int[] r0 = r15.zzbZu
            int r1 = r15.zzbZv
            int r1 = r1 - r13
            r0[r1] = r8
            goto L_0x00a2
        L_0x0088:
            if (r2 != r8) goto L_0x00a0
            r0 = 0
            int r0 = r15.zzaY(r0)
            r1 = -1
            if (r0 != r1) goto L_0x0097
            r0 = 17
        L_0x0094:
            r15.zzbZq = r0
            return r0
        L_0x0097:
            r15.zzWs()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            goto L_0x00a2
        L_0x00a0:
            if (r2 == r3) goto L_0x011e
        L_0x00a2:
            int r0 = r15.zzaY(r13)
            if (r0 == r5) goto L_0x0113
            if (r0 == r4) goto L_0x010d
            if (r0 == r10) goto L_0x00f6
            if (r0 == r9) goto L_0x00f6
            r1 = 91
            if (r0 == r1) goto L_0x00f3
            if (r0 == r6) goto L_0x00ee
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L_0x00eb
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            int r0 = r15.zzbZv
            if (r0 != r13) goto L_0x00c4
            r15.zzWs()
        L_0x00c4:
            int r0 = r15.zzWo()
            if (r0 == 0) goto L_0x00cb
            return r0
        L_0x00cb:
            int r0 = r15.zzWp()
            if (r0 == 0) goto L_0x00d2
            return r0
        L_0x00d2:
            char[] r0 = r15.zzbZn
            int r1 = r15.pos
            char r0 = r0[r1]
            boolean r0 = r15.zze(r0)
            if (r0 == 0) goto L_0x00e4
            r15.zzWs()
            r0 = 10
            goto L_0x0094
        L_0x00e4:
            java.lang.String r0 = "Expected value"
            java.io.IOException r0 = r15.zziW(r0)
            throw r0
        L_0x00eb:
            r15.zzbZq = r13
            return r13
        L_0x00ee:
            if (r2 != r13) goto L_0x00f6
            r15.zzbZq = r11
            return r11
        L_0x00f3:
            r15.zzbZq = r7
            return r7
        L_0x00f6:
            if (r2 == r13) goto L_0x0102
            if (r2 != r12) goto L_0x00fb
            goto L_0x0102
        L_0x00fb:
            java.lang.String r0 = "Unexpected value"
            java.io.IOException r0 = r15.zziW(r0)
            throw r0
        L_0x0102:
            r15.zzWs()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            r15.zzbZq = r8
            return r8
        L_0x010d:
            r15.zzWs()
            r15.zzbZq = r3
            return r3
        L_0x0113:
            int r0 = r15.zzbZv
            if (r0 != r13) goto L_0x011a
            r15.zzWs()
        L_0x011a:
            r0 = 9
            goto L_0x0094
        L_0x011e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "JsonReader is closed"
            r0.<init>(r1)
            throw r0
        L_0x0126:
            int[] r0 = r15.zzbZu
            int r1 = r15.zzbZv
            int r1 = r1 - r13
            r0[r1] = r11
            r0 = 125(0x7d, float:1.75E-43)
            if (r2 != r14) goto L_0x0148
            int r1 = r15.zzaY(r13)
            if (r1 == r10) goto L_0x0148
            if (r1 == r9) goto L_0x0145
            if (r1 != r0) goto L_0x013e
            r15.zzbZq = r12
            return r12
        L_0x013e:
            java.lang.String r0 = "Unterminated object"
            java.io.IOException r0 = r15.zziW(r0)
            throw r0
        L_0x0145:
            r15.zzWs()
        L_0x0148:
            int r1 = r15.zzaY(r13)
            if (r1 == r5) goto L_0x017d
            if (r1 == r4) goto L_0x0176
            java.lang.String r3 = "Expected name"
            if (r1 == r0) goto L_0x016c
            r15.zzWs()
            int r0 = r15.pos
            int r0 = r0 - r13
            r15.pos = r0
            char r0 = (char) r1
            boolean r0 = r15.zze(r0)
            if (r0 == 0) goto L_0x0167
            r0 = 14
            goto L_0x0094
        L_0x0167:
            java.io.IOException r0 = r15.zziW(r3)
            throw r0
        L_0x016c:
            if (r2 == r14) goto L_0x0171
            r15.zzbZq = r12
            return r12
        L_0x0171:
            java.io.IOException r0 = r15.zziW(r3)
            throw r0
        L_0x0176:
            r15.zzWs()
            r0 = 12
            goto L_0x0094
        L_0x017d:
            r0 = 13
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalw.zzWn():int");
    }

    private int zzWo() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.zzbZn[this.pos];
        if (c == 't' || c == 'T') {
            i = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.zzbQl && !zznR(i2 + 1)) {
                return 0;
            }
            char c2 = this.zzbZn[this.pos + i2];
            if (c2 != str2.charAt(i2) && c2 != str.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.zzbQl || zznR(length + 1)) && zze(this.zzbZn[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.zzbZq = i;
        return i;
    }

    private int zzWp() throws IOException {
        int i;
        char c;
        char[] cArr = this.zzbZn;
        int i2 = this.pos;
        int i3 = 0;
        int i4 = this.zzbQl;
        int i5 = 0;
        char c2 = 0;
        boolean z = true;
        long j = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i4) {
                if (i5 == cArr.length) {
                    return i3;
                }
                if (!zznR(i5 + 1)) {
                    break;
                }
                i2 = this.pos;
                i4 = this.zzbQl;
            }
            c = cArr[i2 + i5];
            if (c == '+') {
                i3 = 0;
                if (c2 != 5) {
                    return 0;
                }
            } else if (c == 'E' || c == 'e') {
                i3 = 0;
                if (c2 != 2 && c2 != 4) {
                    return 0;
                }
                c2 = 5;
                i5++;
            } else {
                if (c == '-') {
                    i3 = 0;
                    if (c2 == 0) {
                        c2 = 1;
                        z2 = true;
                    } else if (c2 != 5) {
                        return 0;
                    }
                } else if (c == '.') {
                    i3 = 0;
                    if (c2 != 2) {
                        return 0;
                    }
                    c2 = 3;
                } else if (c >= '0' && c <= '9') {
                    if (c2 == 1 || c2 == 0) {
                        j = (long) (-(c - '0'));
                        i3 = 0;
                        c2 = 2;
                    } else {
                        if (c2 == 2) {
                            if (j == 0) {
                                return 0;
                            }
                            long j2 = (10 * j) - ((long) (c - '0'));
                            boolean z3 = j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                            j = j2;
                            z = z3 & z;
                        } else if (c2 == 3) {
                            i3 = 0;
                            c2 = 4;
                        } else if (c2 == 5 || c2 == 6) {
                            i3 = 0;
                            c2 = 7;
                        }
                        i3 = 0;
                    }
                }
                i5++;
            }
            c2 = 6;
            i5++;
        }
        if (zze(c)) {
            return 0;
        }
        if (c2 == 2 && z && (j != Long.MIN_VALUE || z2)) {
            if (!z2) {
                j = -j;
            }
            this.zzbZr = j;
            this.pos += i5;
            i = 15;
        } else if (c2 != 2 && c2 != 4 && c2 != 7) {
            return 0;
        } else {
            this.zzbZs = i5;
            i = 16;
        }
        this.zzbZq = i;
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        zzWs();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String zzWq() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L_0x0003:
            r1 = 0
        L_0x0004:
            int r3 = r6.pos
            int r4 = r3 + r1
            int r5 = r6.zzbQl
            if (r4 >= r5) goto L_0x004f
            char[] r4 = r6.zzbZn
            int r3 = r3 + r1
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005d
            r4 = 10
            if (r3 == r4) goto L_0x005d
            r4 = 12
            if (r3 == r4) goto L_0x005d
            r4 = 13
            if (r3 == r4) goto L_0x005d
            r4 = 32
            if (r3 == r4) goto L_0x005d
            r4 = 35
            if (r3 == r4) goto L_0x004b
            r4 = 44
            if (r3 == r4) goto L_0x005d
            r4 = 47
            if (r3 == r4) goto L_0x004b
            r4 = 61
            if (r3 == r4) goto L_0x004b
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 58
            if (r3 == r4) goto L_0x005d
            r4 = 59
            if (r3 == r4) goto L_0x004b
            switch(r3) {
                case 91: goto L_0x005d;
                case 92: goto L_0x004b;
                case 93: goto L_0x005d;
                default: goto L_0x0048;
            }
        L_0x0048:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x004b:
            r6.zzWs()
            goto L_0x005d
        L_0x004f:
            char[] r3 = r6.zzbZn
            int r3 = r3.length
            if (r1 >= r3) goto L_0x005f
            int r3 = r1 + 1
            boolean r3 = r6.zznR(r3)
            if (r3 == 0) goto L_0x005d
            goto L_0x0004
        L_0x005d:
            r0 = r1
            goto L_0x0079
        L_0x005f:
            if (r2 != 0) goto L_0x0066
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L_0x0066:
            char[] r3 = r6.zzbZn
            int r4 = r6.pos
            r2.append(r3, r4, r1)
            int r3 = r6.pos
            int r3 = r3 + r1
            r6.pos = r3
            r1 = 1
            boolean r1 = r6.zznR(r1)
            if (r1 != 0) goto L_0x0003
        L_0x0079:
            if (r2 != 0) goto L_0x0085
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.zzbZn
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L_0x0090
        L_0x0085:
            char[] r1 = r6.zzbZn
            int r3 = r6.pos
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L_0x0090:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalw.zzWq():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        zzWs();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzWr() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.zzbQl
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.zzbZn
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.zzWs()
        L_0x004b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.zznR(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalw.zzWr():void");
    }

    private void zzWs() throws IOException {
        if (!this.zzbZm) {
            throw zziW("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void zzWt() throws IOException {
        char c;
        do {
            if (this.pos < this.zzbQl || zznR(1)) {
                char[] cArr = this.zzbZn;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.zzbZo++;
                    this.zzbZp = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    private char zzWu() throws IOException {
        int i;
        int i2;
        if (this.pos != this.zzbQl || zznR(1)) {
            char[] cArr = this.zzbZn;
            int i3 = this.pos;
            this.pos = i3 + 1;
            char c = cArr[i3];
            if (c == 10) {
                this.zzbZo++;
                this.zzbZp = this.pos;
            } else if (c == 'b') {
                return 8;
            } else {
                if (c == 'f') {
                    return 12;
                }
                if (c == 'n') {
                    return 10;
                }
                if (c == 'r') {
                    return 13;
                }
                if (c == 't') {
                    return 9;
                }
                if (c == 'u') {
                    if (this.pos + 4 <= this.zzbQl || zznR(4)) {
                        char c2 = 0;
                        int i4 = this.pos;
                        int i5 = i4 + 4;
                        while (i4 < i5) {
                            char c3 = this.zzbZn[i4];
                            char c4 = (char) (c2 << 4);
                            if (c3 < '0' || c3 > '9') {
                                if (c3 >= 'a' && c3 <= 'f') {
                                    i = c3 - 'a';
                                } else if (c3 < 'A' || c3 > 'F') {
                                    String str = new String(this.zzbZn, this.pos, 4);
                                    throw new NumberFormatException(str.length() != 0 ? "\\u".concat(str) : new String("\\u"));
                                } else {
                                    i = c3 - 'A';
                                }
                                i2 = i + 10;
                            } else {
                                i2 = c3 - '0';
                            }
                            c2 = (char) (c4 + i2);
                            i4++;
                        }
                        this.pos += 4;
                        return c2;
                    }
                    throw zziW("Unterminated escape sequence");
                }
            }
            return c;
        }
        throw zziW("Unterminated escape sequence");
    }

    private void zzWv() throws IOException {
        zzaY(true);
        this.pos--;
        int i = this.pos;
        char[] cArr = zzbZl;
        if (i + cArr.length <= this.zzbQl || zznR(cArr.length)) {
            int i2 = 0;
            while (true) {
                char[] cArr2 = zzbZl;
                if (i2 >= cArr2.length) {
                    this.pos += cArr2.length;
                    return;
                } else if (this.zzbZn[this.pos + i2] == cArr2[i2]) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        if (r1 != '/') goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        r7.pos = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        if (r4 != r2) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        r7.pos--;
        r2 = zznR(2);
        r7.pos++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r2 != false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        zzWs();
        r2 = r7.pos;
        r3 = r0[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        if (r3 == '*') goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        if (r3 == '/') goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008b, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009e, code lost:
        if (zziV("*/") == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ab, code lost:
        throw zziW("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ae, code lost:
        if (r1 != '#') goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b0, code lost:
        r7.pos = r4;
        zzWs();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b6, code lost:
        r7.pos = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b8, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int zzaY(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.zzbZn
        L_0x0002:
            int r1 = r7.pos
        L_0x0004:
            int r2 = r7.zzbQl
        L_0x0006:
            r3 = 1
            if (r1 != r2) goto L_0x0046
            r7.pos = r1
            boolean r1 = r7.zznR(r3)
            if (r1 != 0) goto L_0x0042
            if (r8 != 0) goto L_0x0015
            r8 = -1
            return r8
        L_0x0015:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.String r0 = "End of input at line "
            int r1 = r7.getLineNumber()
            int r2 = r7.getColumnNumber()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r4 = r0.length()
            int r4 = r4 + 30
            r3.<init>(r4)
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = " column "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            r8.<init>(r0)
            throw r8
        L_0x0042:
            int r1 = r7.pos
            int r2 = r7.zzbQl
        L_0x0046:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L_0x0056
            int r1 = r7.zzbZo
            int r1 = r1 + r3
            r7.zzbZo = r1
            r7.zzbZp = r4
            goto L_0x00b9
        L_0x0056:
            r5 = 32
            if (r1 == r5) goto L_0x00b9
            r5 = 13
            if (r1 == r5) goto L_0x00b9
            r5 = 9
            if (r1 != r5) goto L_0x0063
            goto L_0x00b9
        L_0x0063:
            r5 = 47
            if (r1 != r5) goto L_0x00ac
            r7.pos = r4
            r6 = 2
            if (r4 != r2) goto L_0x007d
            int r2 = r7.pos
            int r2 = r2 - r3
            r7.pos = r2
            boolean r2 = r7.zznR(r6)
            int r4 = r7.pos
            int r4 = r4 + r3
            r7.pos = r4
            if (r2 != 0) goto L_0x007d
            return r1
        L_0x007d:
            r7.zzWs()
            int r2 = r7.pos
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L_0x0094
            if (r3 == r5) goto L_0x008b
            return r1
        L_0x008b:
            int r2 = r2 + 1
            r7.pos = r2
        L_0x008f:
            r7.zzWt()
            goto L_0x0002
        L_0x0094:
            int r2 = r2 + 1
            r7.pos = r2
            java.lang.String r1 = "*/"
            boolean r1 = r7.zziV(r1)
            if (r1 == 0) goto L_0x00a5
            int r1 = r7.pos
            int r1 = r1 + r6
            goto L_0x0004
        L_0x00a5:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.zziW(r8)
            throw r8
        L_0x00ac:
            r2 = 35
            if (r1 != r2) goto L_0x00b6
            r7.pos = r4
            r7.zzWs()
            goto L_0x008f
        L_0x00b6:
            r7.pos = r4
            return r1
        L_0x00b9:
            r1 = r4
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalw.zzaY(boolean):int");
    }

    private boolean zze(char c) throws IOException {
        if (c == 9 || c == 10 || c == 12 || c == 13 || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (!(c == '/' || c == '=')) {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzWs();
        return false;
    }

    private String zzf(char c) throws IOException {
        char[] cArr = this.zzbZn;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.pos;
            int i2 = this.zzbQl;
            int i3 = i;
            while (true) {
                if (i < i2) {
                    int i4 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i4;
                        sb.append(cArr, i3, (i4 - i3) - 1);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.pos = i4;
                        sb.append(cArr, i3, (i4 - i3) - 1);
                        sb.append(zzWu());
                        break;
                    } else {
                        if (c2 == 10) {
                            this.zzbZo++;
                            this.zzbZp = i4;
                        }
                        i = i4;
                    }
                } else {
                    sb.append(cArr, i3, i - i3);
                    this.pos = i;
                    if (!zznR(1)) {
                        throw zziW("Unterminated string");
                    }
                }
            }
        }
    }

    private void zzg(char c) throws IOException {
        char[] cArr = this.zzbZn;
        while (true) {
            int i = this.pos;
            int i2 = this.zzbQl;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i3;
                        return;
                    } else if (c2 == '\\') {
                        this.pos = i3;
                        zzWu();
                        break;
                    } else {
                        if (c2 == 10) {
                            this.zzbZo++;
                            this.zzbZp = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.pos = i;
                    if (!zznR(1)) {
                        throw zziW("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean zziV(String str) throws IOException {
        while (true) {
            int i = 0;
            if (this.pos + str.length() > this.zzbQl && !zznR(str.length())) {
                return false;
            }
            char[] cArr = this.zzbZn;
            int i2 = this.pos;
            if (cArr[i2] == 10) {
                this.zzbZo++;
                this.zzbZp = i2 + 1;
            } else {
                while (i < str.length()) {
                    if (this.zzbZn[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private IOException zziW(String str) throws IOException {
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(path).length());
        sb.append(str);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new zzalz(sb.toString());
    }

    private void zznQ(int i) {
        int i2 = this.zzbZv;
        int[] iArr = this.zzbZu;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(i2 * 2)];
            int[] iArr3 = new int[(i2 * 2)];
            String[] strArr = new String[(i2 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.zzbZx, 0, iArr3, 0, this.zzbZv);
            System.arraycopy(this.zzbZw, 0, strArr, 0, this.zzbZv);
            this.zzbZu = iArr2;
            this.zzbZx = iArr3;
            this.zzbZw = strArr;
        }
        int[] iArr4 = this.zzbZu;
        int i3 = this.zzbZv;
        this.zzbZv = i3 + 1;
        iArr4[i3] = i;
    }

    private boolean zznR(int i) throws IOException {
        int i2;
        char[] cArr = this.zzbZn;
        int i3 = this.zzbZp;
        int i4 = this.pos;
        this.zzbZp = i3 - i4;
        int i5 = this.zzbQl;
        if (i5 != i4) {
            this.zzbQl = i5 - i4;
            System.arraycopy(cArr, i4, cArr, 0, this.zzbQl);
        } else {
            this.zzbQl = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i6 = this.zzbQl;
            int read = reader.read(cArr, i6, cArr.length - i6);
            if (read == -1) {
                return false;
            }
            this.zzbQl += read;
            if (this.zzbZo == 0 && (i2 = this.zzbZp) == 0 && this.zzbQl > 0 && cArr[0] == 65279) {
                this.pos++;
                this.zzbZp = i2 + 1;
                i++;
            }
        } while (this.zzbQl < i);
        return true;
    }

    public void beginArray() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 3) {
            zznQ(1);
            this.zzbZx[this.zzbZv - 1] = 0;
            this.zzbZq = 0;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 74 + String.valueOf(path).length());
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public void beginObject() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 1) {
            zznQ(3);
            this.zzbZq = 0;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 75 + String.valueOf(path).length());
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public void close() throws IOException {
        this.zzbZq = 0;
        this.zzbZu[0] = 8;
        this.zzbZv = 1;
        this.in.close();
    }

    public void endArray() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 4) {
            this.zzbZv--;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            this.zzbZq = 0;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length());
        sb.append("Expected END_ARRAY but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public void endObject() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 2) {
            this.zzbZv--;
            String[] strArr = this.zzbZw;
            int i2 = this.zzbZv;
            strArr[i2] = null;
            int[] iArr = this.zzbZx;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.zzbZq = 0;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 73 + String.valueOf(path).length());
        sb.append("Expected END_OBJECT but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.zzbZv;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.zzbZu[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.zzbZx[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.zzbZw;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.zzbZm;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 5) {
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.zzbZq = 0;
            int[] iArr2 = this.zzbZx;
            int i3 = this.zzbZv - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(zzWa());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length());
            sb.append("Expected a boolean but was ");
            sb.append(valueOf);
            sb.append(" at line ");
            sb.append(lineNumber);
            sb.append(" column ");
            sb.append(columnNumber);
            sb.append(" path ");
            sb.append(path);
            throw new IllegalStateException(sb.toString());
        }
    }

    public double nextDouble() throws IOException {
        String str;
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 15) {
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.zzbZr;
        }
        if (i == 16) {
            this.zzbZt = new String(this.zzbZn, this.pos, this.zzbZs);
            this.pos += this.zzbZs;
        } else {
            if (i == 8 || i == 9) {
                str = zzf(i == 8 ? '\'' : '\"');
            } else if (i == 10) {
                str = zzWq();
            } else if (i != 11) {
                String valueOf = String.valueOf(zzWa());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length());
                sb.append("Expected a double but was ");
                sb.append(valueOf);
                sb.append(" at line ");
                sb.append(lineNumber);
                sb.append(" column ");
                sb.append(columnNumber);
                sb.append(" path ");
                sb.append(path);
                throw new IllegalStateException(sb.toString());
            }
            this.zzbZt = str;
        }
        this.zzbZq = 11;
        double parseDouble = Double.parseDouble(this.zzbZt);
        if (this.zzbZm || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.zzbZt = null;
            this.zzbZq = 0;
            int[] iArr2 = this.zzbZx;
            int i3 = this.zzbZv - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        int lineNumber2 = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        StringBuilder sb2 = new StringBuilder(String.valueOf(path2).length() + 102);
        sb2.append("JSON forbids NaN and infinities: ");
        sb2.append(parseDouble);
        sb2.append(" at line ");
        sb2.append(lineNumber2);
        sb2.append(" column ");
        sb2.append(columnNumber2);
        sb2.append(" path ");
        sb2.append(path2);
        throw new zzalz(sb2.toString());
    }

    public int nextInt() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 15) {
            long j = this.zzbZr;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.zzbZq = 0;
                int[] iArr = this.zzbZx;
                int i3 = this.zzbZv - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            StringBuilder sb = new StringBuilder(String.valueOf(path).length() + 89);
            sb.append("Expected an int but was ");
            sb.append(j);
            sb.append(" at line ");
            sb.append(lineNumber);
            sb.append(" column ");
            sb.append(columnNumber);
            sb.append(" path ");
            sb.append(path);
            throw new NumberFormatException(sb.toString());
        }
        if (i == 16) {
            this.zzbZt = new String(this.zzbZn, this.pos, this.zzbZs);
            this.pos += this.zzbZs;
        } else if (i == 8 || i == 9) {
            this.zzbZt = zzf(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.zzbZt);
                this.zzbZq = 0;
                int[] iArr2 = this.zzbZx;
                int i4 = this.zzbZv - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            String valueOf = String.valueOf(zzWa());
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path2).length());
            sb2.append("Expected an int but was ");
            sb2.append(valueOf);
            sb2.append(" at line ");
            sb2.append(lineNumber2);
            sb2.append(" column ");
            sb2.append(columnNumber2);
            sb2.append(" path ");
            sb2.append(path2);
            throw new IllegalStateException(sb2.toString());
        }
        this.zzbZq = 11;
        double parseDouble = Double.parseDouble(this.zzbZt);
        int i5 = (int) parseDouble;
        if (((double) i5) == parseDouble) {
            this.zzbZt = null;
            this.zzbZq = 0;
            int[] iArr3 = this.zzbZx;
            int i6 = this.zzbZv - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        String str = this.zzbZt;
        int lineNumber3 = getLineNumber();
        int columnNumber3 = getColumnNumber();
        String path3 = getPath();
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path3).length());
        sb3.append("Expected an int but was ");
        sb3.append(str);
        sb3.append(" at line ");
        sb3.append(lineNumber3);
        sb3.append(" column ");
        sb3.append(columnNumber3);
        sb3.append(" path ");
        sb3.append(path3);
        throw new NumberFormatException(sb3.toString());
    }

    public long nextLong() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 15) {
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.zzbZr;
        }
        if (i == 16) {
            this.zzbZt = new String(this.zzbZn, this.pos, this.zzbZs);
            this.pos += this.zzbZs;
        } else if (i == 8 || i == 9) {
            this.zzbZt = zzf(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.zzbZt);
                this.zzbZq = 0;
                int[] iArr2 = this.zzbZx;
                int i3 = this.zzbZv - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            String valueOf = String.valueOf(zzWa());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length());
            sb.append("Expected a long but was ");
            sb.append(valueOf);
            sb.append(" at line ");
            sb.append(lineNumber);
            sb.append(" column ");
            sb.append(columnNumber);
            sb.append(" path ");
            sb.append(path);
            throw new IllegalStateException(sb.toString());
        }
        this.zzbZq = 11;
        double parseDouble = Double.parseDouble(this.zzbZt);
        long j = (long) parseDouble;
        if (((double) j) == parseDouble) {
            this.zzbZt = null;
            this.zzbZq = 0;
            int[] iArr3 = this.zzbZx;
            int i4 = this.zzbZv - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        String str = this.zzbZt;
        int lineNumber2 = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path2).length());
        sb2.append("Expected a long but was ");
        sb2.append(str);
        sb2.append(" at line ");
        sb2.append(lineNumber2);
        sb2.append(" column ");
        sb2.append(columnNumber2);
        sb2.append(" path ");
        sb2.append(path2);
        throw new NumberFormatException(sb2.toString());
    }

    public String nextName() throws IOException {
        String str;
        char c;
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 14) {
            str = zzWq();
        } else {
            if (i == 12) {
                c = '\'';
            } else if (i == 13) {
                c = '\"';
            } else {
                String valueOf = String.valueOf(zzWa());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length());
                sb.append("Expected a name but was ");
                sb.append(valueOf);
                sb.append(" at line ");
                sb.append(lineNumber);
                sb.append(" column ");
                sb.append(columnNumber);
                sb.append(" path ");
                sb.append(path);
                throw new IllegalStateException(sb.toString());
            }
            str = zzf(c);
        }
        this.zzbZq = 0;
        this.zzbZw[this.zzbZv - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 7) {
            this.zzbZq = 0;
            int[] iArr = this.zzbZx;
            int i2 = this.zzbZv - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(zzWa());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67 + String.valueOf(path).length());
        sb.append("Expected null but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public String nextString() throws IOException {
        String str;
        char c;
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        if (i == 10) {
            str = zzWq();
        } else {
            if (i == 8) {
                c = '\'';
            } else if (i == 9) {
                c = '\"';
            } else if (i == 11) {
                str = this.zzbZt;
                this.zzbZt = null;
            } else if (i == 15) {
                str = Long.toString(this.zzbZr);
            } else if (i == 16) {
                str = new String(this.zzbZn, this.pos, this.zzbZs);
                this.pos += this.zzbZs;
            } else {
                String valueOf = String.valueOf(zzWa());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length());
                sb.append("Expected a string but was ");
                sb.append(valueOf);
                sb.append(" at line ");
                sb.append(lineNumber);
                sb.append(" column ");
                sb.append(columnNumber);
                sb.append(" path ");
                sb.append(path);
                throw new IllegalStateException(sb.toString());
            }
            str = zzf(c);
        }
        this.zzbZq = 0;
        int[] iArr = this.zzbZx;
        int i2 = this.zzbZv - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final void setLenient(boolean z) {
        this.zzbZm = z;
    }

    public void skipValue() throws IOException {
        char c;
        int i = 0;
        do {
            int i2 = this.zzbZq;
            if (i2 == 0) {
                i2 = zzWn();
            }
            if (i2 == 3) {
                zznQ(1);
            } else if (i2 == 1) {
                zznQ(3);
            } else if (i2 == 4 || i2 == 2) {
                this.zzbZv--;
                i--;
                this.zzbZq = 0;
            } else if (i2 == 14 || i2 == 10) {
                zzWr();
                this.zzbZq = 0;
            } else {
                if (i2 == 8 || i2 == 12) {
                    c = '\'';
                } else if (i2 == 9 || i2 == 13) {
                    c = '\"';
                } else {
                    if (i2 == 16) {
                        this.pos += this.zzbZs;
                    }
                    this.zzbZq = 0;
                }
                zzg(c);
                this.zzbZq = 0;
            }
            i++;
            this.zzbZq = 0;
        } while (i != 0);
        int[] iArr = this.zzbZx;
        int i3 = this.zzbZv;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.zzbZw[i3 - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        return sb.toString();
    }

    public zzalx zzWa() throws IOException {
        int i = this.zzbZq;
        if (i == 0) {
            i = zzWn();
        }
        switch (i) {
            case 1:
                return zzalx.BEGIN_OBJECT;
            case 2:
                return zzalx.END_OBJECT;
            case 3:
                return zzalx.BEGIN_ARRAY;
            case 4:
                return zzalx.END_ARRAY;
            case 5:
            case 6:
                return zzalx.BOOLEAN;
            case 7:
                return zzalx.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzalx.STRING;
            case 12:
            case 13:
            case 14:
                return zzalx.NAME;
            case 15:
            case 16:
                return zzalx.NUMBER;
            case 17:
                return zzalx.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }
}
