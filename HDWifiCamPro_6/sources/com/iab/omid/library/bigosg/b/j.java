package com.iab.omid.library.bigosg.b;

import com.iab.omid.library.bigosg.e.d;

public final class j {
    public final String a;
    public final String b;

    private j(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static j a(String str, String str2) {
        d.a(str, "Name is null or empty");
        d.a(str2, "Version is null or empty");
        return new j(str, str2);
    }
}
