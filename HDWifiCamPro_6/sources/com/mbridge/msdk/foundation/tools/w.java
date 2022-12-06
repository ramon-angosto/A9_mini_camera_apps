package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SharedPreferencesUtils */
public final class w {
    public static void a(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (context != null) {
            SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("share_date", 0).edit();
            if ("String".equals(simpleName)) {
                edit.putString(str, (String) obj);
            } else if ("Integer".equals(simpleName)) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if ("Boolean".equals(simpleName)) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if ("Float".equals(simpleName)) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if ("Long".equals(simpleName)) {
                edit.putLong(str, ((Long) obj).longValue());
            }
            edit.apply();
        }
    }

    public static Object b(Context context, String str, Object obj) {
        if (context == null) {
            return obj;
        }
        String simpleName = obj != null ? obj.getClass().getSimpleName() : "";
        SharedPreferences sharedPreferences = context.getSharedPreferences("share_date", 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        return "Long".equals(simpleName) ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : obj;
    }
}
