package com.huawei.android.pushselfshow.c;

import android.R;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.a;
import object.p2pipcam.utils.DataBaseHelper;

public class b {
    private static int a;

    @SuppressLint({"InlinedApi"})
    private static float a(Context context) {
        float a2 = (float) a.a(context, 48.0f);
        try {
            float dimension = context.getResources().getDimension(17104901);
            if (dimension > 0.0f && a2 > dimension) {
                a2 = dimension;
            }
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString());
        }
        e.a("PushSelfShowLog", "getRescaleBitmapSize:" + a2);
        return a2;
    }

    public static int a(Context context, String str, String str2, Object obj) {
        String str3;
        Exception exc;
        Class cls;
        int i;
        String str4 = str;
        String str5 = str2;
        Object obj2 = obj;
        int i2 = 0;
        try {
            String str6 = context.getPackageName() + ".R";
            e.a("PushSelfShowLog", "try to refrect " + str6 + " typeName is " + str5);
            Class[] classes = Class.forName(str6).getClasses();
            StringBuilder sb = new StringBuilder();
            sb.append("sonClassArr length ");
            sb.append(classes.length);
            e.a("PushSelfShowLog", sb.toString());
            int i3 = 0;
            while (true) {
                if (i3 >= classes.length) {
                    cls = null;
                    break;
                }
                cls = classes[i3];
                String substring = cls.getName().substring(str6.length() + 1);
                e.a("PushSelfShowLog", "sonTypeClass,query sonclass is  %s", substring + " sonClass.getName() is" + cls.getName());
                if (str5.equals(substring)) {
                    break;
                }
                i3++;
            }
            if (cls != null) {
                i = cls.getField(str4).getInt(obj2);
                try {
                    e.a("PushSelfShowLog", " refect res id is %s", "" + i);
                } catch (ClassNotFoundException e) {
                    e = e;
                    i2 = i;
                } catch (NoSuchFieldException e2) {
                    e = e2;
                    i2 = i;
                    exc = e;
                    str3 = "NoSuchFieldException failed,";
                    e.c("PushSelfShowLog", str3, exc);
                    return i2;
                } catch (IllegalAccessException e3) {
                    e = e3;
                    i2 = i;
                    exc = e;
                    str3 = "IllegalAccessException failed,";
                    e.c("PushSelfShowLog", str3, exc);
                    return i2;
                } catch (IllegalArgumentException e4) {
                    e = e4;
                    i2 = i;
                    exc = e;
                    str3 = "IllegalArgumentException failed,";
                    e.c("PushSelfShowLog", str3, exc);
                    return i2;
                } catch (IndexOutOfBoundsException e5) {
                    e = e5;
                    i2 = i;
                    exc = e;
                    str3 = "IndexOutOfBoundsException failed,";
                    e.c("PushSelfShowLog", str3, exc);
                    return i2;
                } catch (Exception e6) {
                    e = e6;
                    i2 = i;
                    exc = e;
                    str3 = "  failed,";
                    e.c("PushSelfShowLog", str3, exc);
                    return i2;
                }
            } else {
                e.a("PushSelfShowLog", "sonTypeClass is null");
                String str7 = context.getPackageName() + ".R$" + str5;
                e.a("PushSelfShowLog", "try to refrect 2 " + str7 + " typeName is " + str5);
                i = Class.forName(str7).getField(str4).getInt(obj2);
                e.a("PushSelfShowLog", " refect res id 2 is %s", "" + i);
            }
            return i;
        } catch (ClassNotFoundException e7) {
            e = e7;
            exc = e;
            str3 = "ClassNotFound failed,";
            e.c("PushSelfShowLog", str3, exc);
            return i2;
        } catch (NoSuchFieldException e8) {
            e = e8;
            exc = e;
            str3 = "NoSuchFieldException failed,";
            e.c("PushSelfShowLog", str3, exc);
            return i2;
        } catch (IllegalAccessException e9) {
            e = e9;
            exc = e;
            str3 = "IllegalAccessException failed,";
            e.c("PushSelfShowLog", str3, exc);
            return i2;
        } catch (IllegalArgumentException e10) {
            e = e10;
            exc = e;
            str3 = "IllegalArgumentException failed,";
            e.c("PushSelfShowLog", str3, exc);
            return i2;
        } catch (IndexOutOfBoundsException e11) {
            e = e11;
            exc = e;
            str3 = "IndexOutOfBoundsException failed,";
            e.c("PushSelfShowLog", str3, exc);
            return i2;
        } catch (Exception e12) {
            e = e12;
            exc = e;
            str3 = "  failed,";
            e.c("PushSelfShowLog", str3, exc);
            return i2;
        }
    }

    public static Notification a(Context context, com.huawei.android.pushselfshow.b.a aVar, int i, int i2, int i3) {
        Notification notification = new Notification();
        notification.icon = b(context, aVar);
        int i4 = context.getApplicationInfo().labelRes;
        notification.tickerText = aVar.p;
        notification.when = System.currentTimeMillis();
        notification.flags |= 16;
        notification.defaults |= 1;
        Intent intent = new Intent("com.huawei.intent.action.PUSH");
        intent.putExtra("selfshow_info", aVar.c()).putExtra("selfshow_token", aVar.d()).putExtra("selfshow_event_id", "1").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, 134217728);
        notification.contentIntent = broadcast;
        Intent intent2 = new Intent("com.huawei.intent.action.PUSH");
        intent2.putExtra("selfshow_info", aVar.c()).putExtra("selfshow_token", aVar.d()).putExtra("selfshow_event_id", "2").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(268435456);
        notification.deleteIntent = PendingIntent.getBroadcast(context, i3, intent2, 134217728);
        notification.setLatestEventInfo(context, (aVar.r == null || "".equals(aVar.r)) ? context.getResources().getString(i4) : aVar.r, aVar.p, broadcast);
        int identifier = context.getResources().getIdentifier("icon", DataBaseHelper.KEY_ID, "android");
        Bitmap c = c(context, aVar);
        if (!(identifier == 0 || notification.contentView == null || c == null)) {
            notification.contentView.setImageViewBitmap(identifier, c);
        }
        return c.a(context, notification, i, aVar, c);
    }

    public static void a(Context context, int i) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(i);
            }
        } catch (Exception e) {
            e.d("PushSelfShowLog", "removeNotifiCationById err:" + e.toString());
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            int i = 0;
            if (intent.hasExtra("selfshow_notify_id")) {
                i = intent.getIntExtra("selfshow_notify_id", 0) + 3;
            }
            e.a("PushSelfShowLog", "setDelayAlarm(cancel) alarmNotityId " + i + " and intent is " + intent.toURI());
            Intent intent2 = new Intent("com.huawei.intent.action.PUSH");
            intent2.setPackage(context.getPackageName()).setFlags(32);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent2, 536870912);
            if (broadcast != null) {
                e.a("PushSelfShowLog", "  alarm cancel");
                alarmManager.cancel(broadcast);
                return;
            }
            e.a("PushSelfShowLog", "alarm not exist");
        } catch (Exception e) {
            e.d("PushSelfShowLog", "cancelAlarm err:" + e.toString());
        }
    }

    public static void a(Context context, Intent intent, long j, int i) {
        try {
            e.a("PushSelfShowLog", "enter setDelayAlarm(intent:" + intent.toURI() + " interval:" + j + "ms, context:" + context);
            ((AlarmManager) context.getSystemService("alarm")).set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, i, intent, 134217728));
        } catch (Exception e) {
            e.a("PushSelfShowLog", "set DelayAlarm error", (Throwable) e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x010a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r7, com.huawei.android.pushselfshow.b.a r8) {
        /*
            java.lang.Class<com.huawei.android.pushselfshow.c.b> r0 = com.huawei.android.pushselfshow.c.b.class
            monitor-enter(r0)
            if (r7 == 0) goto L_0x0109
            if (r8 != 0) goto L_0x0009
            goto L_0x0109
        L_0x0009:
            java.lang.String r1 = "PushSelfShowLog"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r2.<init>()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r3 = " showNotification , the msg id = "
            r2.append(r3)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r3 = r8.l     // Catch:{ Exception -> 0x00ea }
            r2.append(r3)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ea }
            com.huawei.android.pushagent.c.a.e.a(r1, r2)     // Catch:{ Exception -> 0x00ea }
            r1 = 2
            r2 = 180(0xb4, float:2.52E-43)
            com.huawei.android.pushselfshow.utils.a.a((int) r1, (int) r2)     // Catch:{ Exception -> 0x00ea }
            int r1 = a     // Catch:{ Exception -> 0x00ea }
            if (r1 != 0) goto L_0x004d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r1.<init>()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r7.getPackageName()     // Catch:{ Exception -> 0x00ea }
            r1.append(r2)     // Catch:{ Exception -> 0x00ea }
            java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x00ea }
            r2.<init>()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ea }
            r1.append(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ea }
            int r1 = r1.hashCode()     // Catch:{ Exception -> 0x00ea }
            a = r1     // Catch:{ Exception -> 0x00ea }
        L_0x004d:
            int r1 = a     // Catch:{ Exception -> 0x00ea }
            int r2 = a     // Catch:{ Exception -> 0x00ea }
            int r2 = r2 + 1
            a = r2     // Catch:{ Exception -> 0x00ea }
            int r3 = a     // Catch:{ Exception -> 0x00ea }
            int r3 = r3 + 1
            a = r3     // Catch:{ Exception -> 0x00ea }
            int r4 = a     // Catch:{ Exception -> 0x00ea }
            int r4 = r4 + 1
            a = r4     // Catch:{ Exception -> 0x00ea }
            boolean r5 = com.huawei.android.pushselfshow.utils.a.b()     // Catch:{ Exception -> 0x00ea }
            if (r5 == 0) goto L_0x006c
            android.app.Notification r2 = b(r7, r8, r1, r2, r3)     // Catch:{ Exception -> 0x00ea }
            goto L_0x0070
        L_0x006c:
            android.app.Notification r2 = a(r7, r8, r1, r2, r3)     // Catch:{ Exception -> 0x00ea }
        L_0x0070:
            java.lang.String r3 = "notification"
            java.lang.Object r3 = r7.getSystemService(r3)     // Catch:{ Exception -> 0x00ea }
            android.app.NotificationManager r3 = (android.app.NotificationManager) r3     // Catch:{ Exception -> 0x00ea }
            if (r3 == 0) goto L_0x0105
            if (r2 == 0) goto L_0x0105
            r3.notify(r1, r2)     // Catch:{ Exception -> 0x00ea }
            int r2 = r8.e     // Catch:{ Exception -> 0x00ea }
            if (r2 <= 0) goto L_0x00e1
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x00ea }
            java.lang.String r3 = "com.huawei.intent.action.PUSH"
            r2.<init>(r3)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r3 = "selfshow_info"
            byte[] r5 = r8.c()     // Catch:{ Exception -> 0x00ea }
            android.content.Intent r3 = r2.putExtra(r3, r5)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = "selfshow_token"
            byte[] r6 = r8.d()     // Catch:{ Exception -> 0x00ea }
            android.content.Intent r3 = r3.putExtra(r5, r6)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = "selfshow_event_id"
            java.lang.String r6 = "-1"
            android.content.Intent r3 = r3.putExtra(r5, r6)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = "selfshow_notify_id"
            android.content.Intent r1 = r3.putExtra(r5, r1)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r3 = r7.getPackageName()     // Catch:{ Exception -> 0x00ea }
            android.content.Intent r1 = r1.setPackage(r3)     // Catch:{ Exception -> 0x00ea }
            r3 = 32
            r1.setFlags(r3)     // Catch:{ Exception -> 0x00ea }
            int r1 = r8.e     // Catch:{ Exception -> 0x00ea }
            long r5 = (long) r1     // Catch:{ Exception -> 0x00ea }
            a((android.content.Context) r7, (android.content.Intent) r2, (long) r5, (int) r4)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r1 = "PushSelfShowLog"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea }
            r3.<init>()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = "setDelayAlarm alarmNotityId"
            r3.append(r5)     // Catch:{ Exception -> 0x00ea }
            r3.append(r4)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r4 = " and intent is "
            r3.append(r4)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r2.toURI()     // Catch:{ Exception -> 0x00ea }
            r3.append(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00ea }
            com.huawei.android.pushagent.c.a.e.a(r1, r2)     // Catch:{ Exception -> 0x00ea }
        L_0x00e1:
            java.lang.String r1 = "0"
            com.huawei.android.pushselfshow.utils.a.a((android.content.Context) r7, (java.lang.String) r1, (com.huawei.android.pushselfshow.b.a) r8)     // Catch:{ Exception -> 0x00ea }
            monitor-exit(r0)
            return
        L_0x00e8:
            r7 = move-exception
            goto L_0x0107
        L_0x00ea:
            r7 = move-exception
            java.lang.String r8 = "PushSelfShowLog"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e8 }
            r1.<init>()     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = "showNotification error "
            r1.append(r2)     // Catch:{ all -> 0x00e8 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e8 }
            r1.append(r7)     // Catch:{ all -> 0x00e8 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x00e8 }
            com.huawei.android.pushagent.c.a.e.d(r8, r7)     // Catch:{ all -> 0x00e8 }
        L_0x0105:
            monitor-exit(r0)
            return
        L_0x0107:
            monitor-exit(r0)
            throw r7
        L_0x0109:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.c.b.a(android.content.Context, com.huawei.android.pushselfshow.b.a):void");
    }

    private static int b(Context context, com.huawei.android.pushselfshow.b.a aVar) {
        int i = 0;
        if (context == null || aVar == null) {
            e.b("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (aVar.s != null && aVar.s.length() > 0) {
            i = a(context, aVar.s, "drawable", (Object) new R.drawable());
            e.a("PushSelfShowLog", context.getPackageName() + "  msg.statusIcon is " + aVar.s + ",and icon is " + i);
            if (i == 0) {
                i = context.getResources().getIdentifier(aVar.s, "drawable", "android");
            }
            e.a("PushSelfShowLog", "msg.statusIcon is " + aVar.s + ",and icon is " + i);
        }
        if (i != 0) {
            return i;
        }
        int i2 = context.getApplicationInfo().icon;
        if (i2 != 0) {
            return i2;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        if (identifier == 0) {
            return 17301651;
        }
        return identifier;
    }

    public static Notification b(Context context, com.huawei.android.pushselfshow.b.a aVar, int i, int i2, int i3) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(b(context, aVar));
        int i4 = context.getApplicationInfo().labelRes;
        builder.setTicker(aVar.p);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setDefaults(1);
        Intent intent = new Intent("com.huawei.intent.action.PUSH");
        intent.putExtra("selfshow_info", aVar.c()).putExtra("selfshow_token", aVar.d()).putExtra("selfshow_event_id", "1").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, 134217728);
        Intent intent2 = new Intent("com.huawei.intent.action.PUSH");
        intent2.putExtra("selfshow_info", aVar.c()).putExtra("selfshow_token", aVar.d()).putExtra("selfshow_event_id", "2").putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(268435456);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, i3, intent2, 134217728);
        builder.setContentTitle((aVar.r == null || "".equals(aVar.r)) ? context.getResources().getString(i4) : aVar.r);
        builder.setContentText(aVar.p);
        builder.setContentIntent(broadcast);
        builder.setDeleteIntent(broadcast2);
        Bitmap c = c(context, aVar);
        if (c != null) {
            builder.setLargeIcon(c);
        }
        if (c.a(context, builder, i, aVar, c) == null) {
            return null;
        }
        return builder.getNotification();
    }

    private static Bitmap c(Context context, com.huawei.android.pushselfshow.b.a aVar) {
        if (context == null || aVar == null) {
            return null;
        }
        try {
            if (aVar.q == null || aVar.q.length() <= 0) {
                return null;
            }
            com.huawei.android.pushselfshow.utils.c.a aVar2 = new com.huawei.android.pushselfshow.utils.c.a();
            int i = 0;
            String str = aVar.q;
            if (!str.equals("" + aVar.a())) {
                i = a(context, aVar.q, "drawable", (Object) new R.drawable());
                if (i == 0) {
                    i = context.getResources().getIdentifier(aVar.q, "drawable", "android");
                }
                e.a("PushSelfShowLog", "msg.notifyIcon is " + aVar.q + ",and defaultIcon is " + i);
            }
            if (i != 0) {
                return BitmapFactory.decodeResource(context.getResources(), i);
            }
            Bitmap a2 = aVar2.a(context, aVar.q);
            e.a("PushSelfShowLog", "get bitmap from new downloaded ");
            if (a2 != null) {
                e.a("PushSelfShowLog", "height:" + a2.getHeight() + ",width:" + a2.getWidth());
                float a3 = a(context);
                a2 = aVar2.a(context, a2, a3, a3);
            }
            if (a2 != null) {
                return a2;
            }
            return null;
        } catch (Exception e) {
            e.c("PushSelfShowLog", "" + e.toString(), e);
            return null;
        }
    }
}
