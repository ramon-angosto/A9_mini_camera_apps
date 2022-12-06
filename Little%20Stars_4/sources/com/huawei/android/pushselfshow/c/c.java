package com.huawei.android.pushselfshow.c;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.b.a;
import com.huawei.android.pushselfshow.utils.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.security.SecureRandom;
import java.util.Date;
import object.p2pipcam.utils.DataBaseHelper;

public class c {
    public static Notification.Builder a(Context context, Notification.Builder builder, int i, a aVar, Bitmap bitmap) {
        RemoteViews remoteViews;
        e.a("PushSelfShowLog", "Notification addStyle");
        if (!(context == null || builder == null || aVar == null)) {
            a aVar2 = a.STYLE_1;
            if (aVar.K >= 0 && aVar.K < a.values().length) {
                aVar2 = a.values()[aVar.K];
            }
            switch (aVar2) {
                case STYLE_2:
                    remoteViews = a(context, i, bitmap, aVar);
                    break;
                case STYLE_4:
                    remoteViews = b(context, i, bitmap, aVar);
                    break;
                case STYLE_5:
                    a(context, builder, i, bitmap, aVar);
                    break;
                case STYLE_6:
                    if (!b(context, builder, i, bitmap, aVar)) {
                        return null;
                    }
                    break;
                case STYLE_7:
                    remoteViews = c(context, i, bitmap, aVar);
                    break;
                case STYLE_8:
                    remoteViews = a(context, bitmap, aVar);
                    if (remoteViews == null) {
                        return null;
                    }
                    break;
            }
            builder.setContent(remoteViews);
        }
        return builder;
    }

    public static Notification a(Context context, Notification notification, int i, a aVar, Bitmap bitmap) {
        RemoteViews remoteViews;
        if (!(notification == null || aVar == null)) {
            a aVar2 = a.STYLE_1;
            if (aVar.K >= 0 && aVar.K < a.values().length) {
                aVar2 = a.values()[aVar.K];
            }
            switch (aVar2) {
                case STYLE_2:
                    remoteViews = a(context, i, bitmap, aVar);
                    break;
                case STYLE_4:
                    remoteViews = b(context, i, bitmap, aVar);
                    break;
                case STYLE_7:
                    remoteViews = c(context, i, bitmap, aVar);
                    break;
                case STYLE_8:
                    remoteViews = a(context, bitmap, aVar);
                    if (remoteViews == null) {
                        return null;
                    }
                    break;
            }
            notification.contentView = remoteViews;
        }
        return notification;
    }

    private static PendingIntent a(Context context, int i, String str) {
        Intent flags = new Intent("com.huawei.android.push.intent.CLICK").setPackage(context.getPackageName()).setFlags(32);
        flags.putExtra("notifyId", i);
        flags.putExtra("clickBtn", str);
        int hashCode = (context.getPackageName() + str + new SecureRandom().nextInt() + new Date().toString()).hashCode();
        StringBuilder sb = new StringBuilder();
        sb.append("getPendingIntent,requestCode:");
        sb.append(hashCode);
        e.a("PushSelfShowLog", sb.toString());
        return PendingIntent.getBroadcast(context, hashCode, flags, 134217728);
    }

    private static RemoteViews a(Context context, int i, Bitmap bitmap, a aVar) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), d.c(context, "hwpush_layout2"));
        a(context, bitmap, remoteViews);
        a(context, i, remoteViews, aVar);
        remoteViews.setTextViewText(d.d(context, PushConstants.TITLE), a(context, aVar));
        remoteViews.setTextViewText(d.d(context, "text"), aVar.p);
        return remoteViews;
    }

    private static RemoteViews a(Context context, Bitmap bitmap, a aVar) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), d.a(context, "layout", "hwpush_layout8"));
        Bitmap a = !TextUtils.isEmpty(aVar.S) ? new com.huawei.android.pushselfshow.utils.c.a().a(context, aVar.S) : null;
        if (a == null) {
            return null;
        }
        remoteViews.setViewVisibility(d.a(context, DataBaseHelper.KEY_ID, "big_pic"), 0);
        remoteViews.setImageViewBitmap(d.a(context, DataBaseHelper.KEY_ID, "big_pic"), a);
        return remoteViews;
    }

    private static String a(Context context, a aVar) {
        if (context == null || aVar == null) {
            return "";
        }
        if (!TextUtils.isEmpty(aVar.r)) {
            return aVar.r;
        }
        return context.getResources().getString(context.getApplicationInfo().labelRes);
    }

    private static void a(Context context, int i, RemoteViews remoteViews, a aVar) {
        if (context == null || remoteViews == null || aVar == null) {
            e.c("PushSelfShowLog", "showRightBtn error");
        } else if ((a.STYLE_2.ordinal() == aVar.K || a.STYLE_3.ordinal() == aVar.K || a.STYLE_4.ordinal() == aVar.K) && !TextUtils.isEmpty(aVar.M[0]) && !TextUtils.isEmpty(aVar.O[0])) {
            int a = d.a(context, DataBaseHelper.KEY_ID, "right_btn");
            remoteViews.setViewVisibility(a, 0);
            remoteViews.setTextViewText(a, aVar.M[0]);
            remoteViews.setOnClickPendingIntent(a, a(context, i, aVar.O[0]));
        }
    }

    private static void a(Context context, Notification.Builder builder, int i, Bitmap bitmap, a aVar) {
        if (aVar == null || aVar.p == null) {
            e.b("PushSelfShowLog", "msg is null");
        } else if (!TextUtils.isEmpty(aVar.p) && aVar.p.contains("##")) {
            builder.setTicker(aVar.p.replace("##", "，"));
            if (!com.huawei.android.pushselfshow.utils.a.c()) {
                builder.setContentText(aVar.p.replace("##", "，"));
                return;
            }
            builder.setLargeIcon(bitmap);
            builder.setContentTitle(a(context, aVar));
            Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
            String[] split = aVar.p.split("##");
            int length = split.length;
            if (length > 4) {
                length = 4;
            }
            if (!TextUtils.isEmpty(aVar.R)) {
                inboxStyle.setBigContentTitle(aVar.R);
                builder.setContentText(aVar.R);
                if (4 == length) {
                    length--;
                }
            }
            for (int i2 = 0; i2 < length; i2++) {
                inboxStyle.addLine(split[i2]);
            }
            if (aVar.M != null && aVar.M.length > 0) {
                for (int i3 = 0; i3 < aVar.M.length; i3++) {
                    if (!TextUtils.isEmpty(aVar.M[i3]) && !TextUtils.isEmpty(aVar.O[i3])) {
                        builder.addAction(0, aVar.M[i3], a(context, i, aVar.O[i3]));
                    }
                }
            }
            builder.setStyle(inboxStyle);
        }
    }

    private static void a(Context context, Bitmap bitmap, RemoteViews remoteViews) {
        if (context != null && remoteViews != null && com.huawei.android.pushselfshow.utils.a.b()) {
            if (bitmap == null) {
                int i = context.getApplicationInfo().icon;
                if (i == 0 && (i = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android")) == 0) {
                    i = 17301651;
                }
                remoteViews.setImageViewResource(d.a(context, DataBaseHelper.KEY_ID, "icon"), i);
                return;
            }
            remoteViews.setImageViewBitmap(d.a(context, DataBaseHelper.KEY_ID, "icon"), bitmap);
        }
    }

    private static RemoteViews b(Context context, int i, Bitmap bitmap, a aVar) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), d.c(context, "hwpush_layout4"));
        a(context, bitmap, remoteViews);
        a(context, i, remoteViews, aVar);
        remoteViews.setTextViewText(d.d(context, PushConstants.TITLE), a(context, aVar));
        if (aVar.Q != null && aVar.Q.length > 0) {
            com.huawei.android.pushselfshow.utils.c.a aVar2 = new com.huawei.android.pushselfshow.utils.c.a();
            remoteViews.removeAllViews(d.d(context, "linear_icons"));
            Bitmap bitmap2 = null;
            for (int i2 = 0; i2 < aVar.Q.length; i2++) {
                RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), d.a(context, "layout", "hwpush_icons_layout"));
                if (!TextUtils.isEmpty(aVar.Q[i2])) {
                    bitmap2 = aVar2.a(context, aVar.Q[i2]);
                }
                if (bitmap2 != null) {
                    e.a("PushSelfShowLog", "rescale bitmap success");
                    remoteViews2.setImageViewBitmap(d.a(context, DataBaseHelper.KEY_ID, "smallicon"), bitmap2);
                    remoteViews.addView(d.a(context, DataBaseHelper.KEY_ID, "linear_icons"), remoteViews2);
                }
            }
        }
        return remoteViews;
    }

    private static boolean b(Context context, Notification.Builder builder, int i, Bitmap bitmap, a aVar) {
        builder.setContentTitle(a(context, aVar));
        builder.setContentText(aVar.p);
        builder.setLargeIcon(bitmap);
        if (!com.huawei.android.pushselfshow.utils.a.c()) {
            return true;
        }
        com.huawei.android.pushselfshow.utils.c.a aVar2 = new com.huawei.android.pushselfshow.utils.c.a();
        Bitmap bitmap2 = null;
        if (!TextUtils.isEmpty(aVar.S)) {
            bitmap2 = aVar2.a(context, aVar.S);
        }
        if (bitmap2 == null) {
            return false;
        }
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
        bigPictureStyle.bigPicture(bitmap2);
        for (int i2 = 0; i2 < aVar.M.length; i2++) {
            if (!TextUtils.isEmpty(aVar.M[i2]) && !TextUtils.isEmpty(aVar.O[i2])) {
                builder.addAction(0, aVar.M[i2], a(context, i, aVar.O[i2]));
            }
        }
        builder.setStyle(bigPictureStyle);
        return true;
    }

    private static RemoteViews c(Context context, int i, Bitmap bitmap, a aVar) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), d.a(context, "layout", "hwpush_layout7"));
        a(context, bitmap, remoteViews);
        remoteViews.setTextViewText(d.a(context, DataBaseHelper.KEY_ID, PushConstants.TITLE), a(context, aVar));
        remoteViews.setTextViewText(d.a(context, DataBaseHelper.KEY_ID, "text"), aVar.p);
        if (aVar.N != null && aVar.N.length > 0 && aVar.O != null && aVar.O.length > 0 && aVar.N.length == aVar.O.length) {
            com.huawei.android.pushselfshow.utils.c.a aVar2 = new com.huawei.android.pushselfshow.utils.c.a();
            remoteViews.removeAllViews(d.a(context, DataBaseHelper.KEY_ID, "linear_buttons"));
            for (int i2 = 0; i2 < aVar.N.length; i2++) {
                RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), d.a(context, "layout", "hwpush_buttons_layout"));
                Bitmap bitmap2 = null;
                if (!TextUtils.isEmpty(aVar.N[i2])) {
                    bitmap2 = aVar2.a(context, aVar.N[i2]);
                }
                if (bitmap2 != null && !TextUtils.isEmpty(aVar.O[i2])) {
                    int a = d.a(context, DataBaseHelper.KEY_ID, "small_btn");
                    remoteViews2.setImageViewBitmap(a, bitmap2);
                    remoteViews2.setOnClickPendingIntent(a, a(context, i, aVar.O[i2]));
                    remoteViews.addView(d.a(context, DataBaseHelper.KEY_ID, "linear_buttons"), remoteViews2);
                }
            }
        }
        return remoteViews;
    }
}
