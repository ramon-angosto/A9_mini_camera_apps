package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* renamed from: com.xiaomi.push.cs */
public final class C1700cs {

    /* renamed from: a */
    private int f1970a;

    /* renamed from: a */
    private String f1971a;

    public C1700cs(String str, int i) {
        this.f1971a = str;
        this.f1970a = i;
    }

    /* renamed from: a */
    public static C1700cs m2904a(String str, int i) {
        String str2;
        int lastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
        } else {
            str2 = str;
        }
        return new C1700cs(str2, i);
    }

    /* renamed from: a */
    public static InetSocketAddress m2905a(String str, int i) {
        C1700cs a = m2904a(str, i);
        return new InetSocketAddress(a.mo17354a(), a.mo17354a());
    }

    /* renamed from: a */
    public int mo17354a() {
        return this.f1970a;
    }

    /* renamed from: a */
    public String m2907a() {
        return this.f1971a;
    }

    public String toString() {
        if (this.f1970a <= 0) {
            return this.f1971a;
        }
        return this.f1971a + Constants.COLON_SEPARATOR + this.f1970a;
    }
}
