package com.vungle.warren.utility;

import android.util.Log;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;

public class CookieUtil {
    private static final String TAG = CookieUtil.class.getSimpleName();

    public static void update(Repository repository, String str, String str2, Object obj) {
        Cookie cookie = repository.load(str, Cookie.class).get();
        if (cookie == null) {
            cookie = new Cookie(str);
        }
        cookie.putValue(str2, obj);
        try {
            repository.save(cookie);
        } catch (DatabaseHelper.DBException e) {
            Log.e(TAG, "DB Exception saving cookie", e);
        }
    }

    public static Boolean getBoolean(Repository repository, String str, String str2) {
        Cookie cookie = repository.load(str, Cookie.class).get();
        if (cookie != null) {
            return cookie.getBooleanOrNull(str2);
        }
        return null;
    }
}
