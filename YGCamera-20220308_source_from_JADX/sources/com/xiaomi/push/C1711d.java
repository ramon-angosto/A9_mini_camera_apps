package com.xiaomi.push;

import java.io.IOException;

/* renamed from: com.xiaomi.push.d */
public class C1711d extends IOException {
    public C1711d(String str) {
        super(str);
    }

    /* renamed from: a */
    static C1711d m2958a() {
        return new C1711d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static C1711d m2959b() {
        return new C1711d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static C1711d m2960c() {
        return new C1711d("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static C1711d m2961d() {
        return new C1711d("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static C1711d m2962e() {
        return new C1711d("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static C1711d m2963f() {
        return new C1711d("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static C1711d m2964g() {
        return new C1711d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: h */
    static C1711d m2965h() {
        return new C1711d("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
