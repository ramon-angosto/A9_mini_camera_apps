package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.android.b;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.reflect.a;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.p;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class r {
    public static long a;
    private static LinkedList<Pair<Integer, String>> b = new LinkedList<>();

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static Notification a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", new Class[]{CharSequence.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{str});
        } catch (Exception e) {
            b.a((Throwable) e);
        }
        return notification;
    }

    @SuppressLint({"NewApi"})
    private static Notification a(Context context, p pVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        i m = pVar.m();
        Map<String, String> s = m.s();
        Notification.Builder builder = new Notification.Builder(context);
        String[] a2 = a(context, m);
        builder.setContentTitle(a2[0]);
        builder.setContentText(a2[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (Build.VERSION.SDK_INT >= 16) {
            builder.setStyle(new Notification.BigTextStyle().bigText(a2[1]));
        }
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(pendingIntent);
        int a3 = a(context, a(pVar), "mipush_notification");
        int a4 = a(context, a(pVar), "mipush_small_notification");
        if (a3 <= 0 || a4 <= 0) {
            builder.setSmallIcon(f(context, a(pVar)));
        } else {
            builder.setLargeIcon(a(context, a3));
            builder.setSmallIcon(a4);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            boolean parseBoolean = Boolean.parseBoolean(s.get("notification_is_summary"));
            a.a((Object) builder, "setGroup", s.get("notification_group"));
            a.a((Object) builder, "setGroupSummary", Boolean.valueOf(parseBoolean));
        }
        builder.setAutoCancel(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (s != null && s.containsKey("ticker")) {
            builder.setTicker(s.get("ticker"));
        }
        if (currentTimeMillis - a > 10000) {
            a = currentTimeMillis;
            int i = m.f;
            if (e(context, a(pVar))) {
                i = c(context, a(pVar));
            }
            builder.setDefaults(i);
            if (!(s == null || (i & 1) == 0)) {
                String str = s.get("sound_uri");
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("android.resource://" + a(pVar))) {
                        builder.setDefaults(i ^ 1);
                        builder.setSound(Uri.parse(str));
                    }
                }
            }
        }
        return builder.getNotification();
    }

    private static PendingIntent a(Context context, p pVar, i iVar, byte[] bArr) {
        if (iVar != null && !TextUtils.isEmpty(iVar.g)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(iVar.g));
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, 0, intent, 134217728);
        } else if (b(pVar)) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent2.putExtra("mipush_payload", bArr);
            intent2.putExtra("mipush_notified", true);
            intent2.addCategory(String.valueOf(iVar.q()));
            return PendingIntent.getService(context, 0, intent2, 134217728);
        } else {
            Intent intent3 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent3.setComponent(new ComponentName(pVar.f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent3.putExtra("mipush_payload", bArr);
            intent3.putExtra("mipush_notified", true);
            intent3.addCategory(String.valueOf(iVar.q()));
            return PendingIntent.getService(context, 0, intent3, 134217728);
        }
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    static String a(p pVar) {
        i m;
        if (!(!"com.xiaomi.xmsf".equals(pVar.f) || (m = pVar.m()) == null || m.s() == null)) {
            String str = m.s().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return pVar.f;
    }

    private static void a(Notification notification, int i) {
        Object a2 = a.a((Object) notification, "extraNotification");
        if (a2 != null) {
            a.a(a2, "setMessageCount", Integer.valueOf(i));
        }
    }

    public static void a(Context context, p pVar, byte[] bArr) {
        Notification notification;
        String str;
        Context context2 = context;
        p pVar2 = pVar;
        byte[] bArr2 = bArr;
        if (com.xiaomi.channel.commonutils.android.b.d(context2, a(pVar)) == b.a.NOT_ALLOWED) {
            str = "Do not notify because user block " + a(pVar) + "‘s notification";
        } else {
            NotificationManager notificationManager = (NotificationManager) context2.getSystemService("notification");
            i m = pVar.m();
            RemoteViews b2 = b(context, pVar, bArr);
            PendingIntent a2 = a(context2, pVar2, m, bArr2);
            if (a2 == null) {
                str = "The click PendingIntent is null. ";
            } else {
                if (Build.VERSION.SDK_INT >= 11) {
                    notification = a(context2, pVar2, bArr2, b2, a2);
                } else {
                    notification = new Notification(f(context2, a(pVar)), (CharSequence) null, System.currentTimeMillis());
                    String[] a3 = a(context2, m);
                    try {
                        notification.getClass().getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification, new Object[]{context2, a3[0], a3[1], a2});
                    } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                    Map<String, String> s = m.s();
                    if (s != null && s.containsKey("ticker")) {
                        notification.tickerText = s.get("ticker");
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - a > 10000) {
                        a = currentTimeMillis;
                        int i = m.f;
                        if (e(context2, a(pVar))) {
                            i = c(context2, a(pVar));
                        }
                        notification.defaults = i;
                        if (!(s == null || (i & 1) == 0)) {
                            String str2 = s.get("sound_uri");
                            if (!TextUtils.isEmpty(str2)) {
                                if (str2.startsWith("android.resource://" + a(pVar))) {
                                    notification.defaults = i ^ 1;
                                    notification.sound = Uri.parse(str2);
                                }
                            }
                        }
                    }
                    notification.flags |= 16;
                    if (b2 != null) {
                        notification.contentView = b2;
                    }
                }
                String str3 = m.s().get("message_count");
                if (f.a() && str3 != null) {
                    try {
                        a(notification, Integer.parseInt(str3));
                    } catch (NumberFormatException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                    }
                }
                if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
                    a(notification, a(pVar));
                }
                int hashCode = ((a(pVar).hashCode() / 10) * 10) + m.q();
                notificationManager.notify(hashCode, notification);
                Pair pair = new Pair(Integer.valueOf(hashCode), a(pVar));
                synchronized (b) {
                    b.add(pair);
                    if (b.size() > 100) {
                        b.remove();
                    }
                }
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a(str);
    }

    public static void a(Context context, String str, int i) {
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        ((NotificationManager) context.getSystemService("notification")).cancel(hashCode);
        synchronized (b) {
            Iterator it = b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair pair = (Pair) it.next();
                if (hashCode == ((Integer) pair.first).intValue() && TextUtils.equals(str, (CharSequence) pair.second)) {
                    b.remove(pair);
                    break;
                }
            }
        }
    }

    public static boolean a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.importance == 100 && Arrays.asList(next.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004e, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] a(android.content.Context r3, com.xiaomi.xmpush.thrift.i r4) {
        /*
            java.lang.String r0 = r4.h()
            java.lang.String r1 = r4.j()
            java.util.Map r4 = r4.s()
            if (r4 == 0) goto L_0x0073
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L_0x0051
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0042
            r0 = r3
        L_0x0042:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0073
            goto L_0x0072
        L_0x0051:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L_0x0073
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0064
            r0 = r3
        L_0x0064:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0073
        L_0x0072:
            r1 = r3
        L_0x0073:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.r.a(android.content.Context, com.xiaomi.xmpush.thrift.i):java.lang.String[]");
    }

    private static RemoteViews b(Context context, p pVar, byte[] bArr) {
        i m = pVar.m();
        String a2 = a(pVar);
        Map<String, String> s = m.s();
        if (s == null) {
            return null;
        }
        String str = s.get("layout_name");
        String str2 = s.get("layout_value");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
                if (identifier == 0) {
                    return null;
                }
                RemoteViews remoteViews = new RemoteViews(a2, identifier);
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("text")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String string = jSONObject2.getString(next);
                            int identifier2 = resourcesForApplication.getIdentifier(next, DataBaseHelper.KEY_ID, a2);
                            if (identifier2 > 0) {
                                remoteViews.setTextViewText(identifier2, string);
                            }
                        }
                    }
                    if (jSONObject.has("image")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                        Iterator<String> keys2 = jSONObject3.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            String string2 = jSONObject3.getString(next2);
                            int identifier3 = resourcesForApplication.getIdentifier(next2, DataBaseHelper.KEY_ID, a2);
                            int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a2);
                            if (identifier3 > 0) {
                                remoteViews.setImageViewResource(identifier3, identifier4);
                            }
                        }
                    }
                    if (jSONObject.has("time")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                        Iterator<String> keys3 = jSONObject4.keys();
                        while (keys3.hasNext()) {
                            String next3 = keys3.next();
                            String string3 = jSONObject4.getString(next3);
                            if (string3.length() == 0) {
                                string3 = "yy-MM-dd hh:mm";
                            }
                            int identifier5 = resourcesForApplication.getIdentifier(next3, DataBaseHelper.KEY_ID, a2);
                            if (identifier5 > 0) {
                                remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                            }
                        }
                    }
                    return remoteViews;
                } catch (JSONException e) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
            }
        }
        return null;
    }

    public static void b(Context context, String str) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        synchronized (b) {
            Iterator it = ((LinkedList) b.clone()).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (TextUtils.equals((CharSequence) pair.second, str)) {
                    notificationManager.cancel(((Integer) pair.first).intValue());
                    b.remove(pair);
                }
            }
        }
    }

    static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    public static boolean b(p pVar) {
        i m = pVar.m();
        return m != null && m.v();
    }

    static int c(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    static void d(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    static boolean e(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    private static int f(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }
}
