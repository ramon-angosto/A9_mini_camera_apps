package com.bytedance.sdk.component.a;

import android.text.TextUtils;

/* compiled from: PermissionGroup */
public enum x {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    static x a(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        if (TextUtils.equals("private", lowerCase)) {
            return PRIVATE;
        }
        return PUBLIC;
    }

    public String toString() {
        if (this == PRIVATE) {
            return "private";
        }
        return this == PROTECTED ? "protected" : "public";
    }
}
