package com.meizu.cloud.pushsdk.notification.b;

import android.content.Context;
import object.p2pipcam.utils.DataBaseHelper;

public class b {
    public static int a(Context context) {
        return c.a(context).a("push_expandable_big_image_notification", "layout");
    }

    public static int b(Context context) {
        return c.a(context).a("push_expandable_big_text_notification", "layout");
    }

    public static int c(Context context) {
        return c.a(context).a("push_pure_pic_notification", "layout");
    }

    public static int d(Context context) {
        return c.a(context).a("push_big_notification_title", DataBaseHelper.KEY_ID);
    }

    public static int e(Context context) {
        return c.a(context).a("push_big_notification_content", DataBaseHelper.KEY_ID);
    }

    public static int f(Context context) {
        return c.a(context).a("push_big_notification_date", DataBaseHelper.KEY_ID);
    }

    public static int g(Context context) {
        return c.a(context).a("push_big_bigview_defaultView", DataBaseHelper.KEY_ID);
    }

    public static int h(Context context) {
        return c.a(context).a("push_big_bigtext_defaultView", DataBaseHelper.KEY_ID);
    }

    public static int i(Context context) {
        return c.a(context).a("push_pure_bigview_banner", DataBaseHelper.KEY_ID);
    }

    public static int j(Context context) {
        return c.a(context).a("push_pure_bigview_expanded", DataBaseHelper.KEY_ID);
    }

    public static int k(Context context) {
        return c.a(context).a("push_big_notification_icon", DataBaseHelper.KEY_ID);
    }
}
