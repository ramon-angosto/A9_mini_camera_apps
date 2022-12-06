package com.vungle.warren.persistence;

import android.content.ContentValues;

public class ContentValuesUtil {
    public static boolean getBoolean(ContentValues contentValues, String str) {
        Object obj = contentValues.get(str);
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            if (obj instanceof CharSequence) {
                if (Boolean.valueOf(obj.toString()).booleanValue() || "1".equals(obj)) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Number) || ((Number) obj).intValue() == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}
