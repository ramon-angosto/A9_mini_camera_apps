package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;

public abstract class ResourceLoaderUtil {

    /* renamed from: a */
    public static Context f1033a;

    /* renamed from: b */
    public static String f1034b;

    public static int getAnimId(String str) {
        return f1033a.getResources().getIdentifier(str, "anim", f1034b);
    }

    public static int getColorId(String str) {
        return f1033a.getResources().getIdentifier(str, RemoteMessageConst.Notification.COLOR, f1034b);
    }

    public static Drawable getDrawable(String str) {
        return f1033a.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        return f1033a.getResources().getIdentifier(str, "drawable", f1034b);
    }

    public static int getIdId(String str) {
        return f1033a.getResources().getIdentifier(str, "id", f1034b);
    }

    public static int getLayoutId(String str) {
        return f1033a.getResources().getIdentifier(str, "layout", f1034b);
    }

    public static String getString(String str) {
        return f1033a.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        return f1033a.getResources().getIdentifier(str, "string", f1034b);
    }

    public static int getStyleId(String str) {
        return f1033a.getResources().getIdentifier(str, "style", f1034b);
    }

    public static Context getmContext() {
        return f1033a;
    }

    public static void setmContext(Context context) {
        f1033a = context;
        f1034b = context.getPackageName();
    }

    public static String getString(String str, Object... objArr) {
        return f1033a.getResources().getString(getStringId(str), objArr);
    }
}
