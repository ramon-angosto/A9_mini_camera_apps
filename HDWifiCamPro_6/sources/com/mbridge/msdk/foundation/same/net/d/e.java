package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.i;
import java.io.UnsupportedEncodingException;

/* compiled from: JsonRequest */
public abstract class e<T> extends i<T> {
    private static final String c = e.class.getSimpleName();
    private final String d;

    public e(int i, String str, String str2, com.mbridge.msdk.foundation.same.net.e<T> eVar) {
        super(i, str, eVar);
        this.d = str2;
    }

    public final byte[] e() {
        try {
            if (this.d == null) {
                return null;
            }
            return this.d.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
