package com.a.a.a.a.b;

import com.a.a.a.a.e.e;
import java.net.URL;

public final class l {
    private final String a;
    private final URL b;
    private final String c;

    private l(String str, URL url, String str2) {
        this.a = str;
        this.b = url;
        this.c = str2;
    }

    public static l a(String str, URL url, String str2) {
        e.a(str, "VendorKey is null or empty");
        e.a((Object) url, "ResourceURL is null");
        e.a(str2, "VerificationParameters is null or empty");
        return new l(str, url, str2);
    }

    public static l a(URL url) {
        e.a((Object) url, "ResourceURL is null");
        return new l((String) null, url, (String) null);
    }

    public String a() {
        return this.a;
    }

    public URL b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
