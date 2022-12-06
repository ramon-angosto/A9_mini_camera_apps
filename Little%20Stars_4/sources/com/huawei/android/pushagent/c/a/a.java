package com.huawei.android.pushagent.c.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

public class a {
    private static String a = "PushLogSC2705";
    private static int b = 19;

    public static void a(Context context, long j, PendingIntent pendingIntent) {
        String str;
        StringBuilder sb;
        String str2;
        Exception exc;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            e.b(a, "get AlarmManager error");
            return;
        }
        try {
            Class[] clsArr = {Integer.TYPE, Long.TYPE, PendingIntent.class};
            alarmManager.getClass().getDeclaredMethod("setExact", clsArr).invoke(alarmManager, new Object[]{0, Long.valueOf(j), pendingIntent});
        } catch (NoSuchMethodException e) {
            str2 = a;
            sb = new StringBuilder();
            sb.append(" setExact NoSuchMethodException ");
            str = e.toString();
            exc = e;
            sb.append(str);
            e.c(str2, sb.toString(), exc);
            alarmManager.set(0, j, pendingIntent);
        } catch (IllegalAccessException e2) {
            str2 = a;
            sb = new StringBuilder();
            sb.append(" setExact IllegalAccessException ");
            str = e2.toString();
            exc = e2;
            sb.append(str);
            e.c(str2, sb.toString(), exc);
            alarmManager.set(0, j, pendingIntent);
        } catch (InvocationTargetException e3) {
            str2 = a;
            sb = new StringBuilder();
            sb.append(" setExact InvocationTargetException ");
            str = e3.toString();
            exc = e3;
            sb.append(str);
            e.c(str2, sb.toString(), exc);
            alarmManager.set(0, j, pendingIntent);
        } catch (Exception e4) {
            str2 = a;
            sb = new StringBuilder();
            sb.append(" setExact Exception ");
            str = e4.toString();
            exc = e4;
            sb.append(str);
            e.c(str2, sb.toString(), exc);
            alarmManager.set(0, j, pendingIntent);
        }
    }

    public static void a(Context context, Intent intent) {
        String str = a;
        e.a(str, "enter cancelAlarm(Intent=" + intent);
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    public static void a(Context context, Intent intent, long j) {
        String str = a;
        e.a(str, "enter AlarmTools:setAlarmLoops(intent:" + intent + " interval:" + j + "ms");
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(0, System.currentTimeMillis() + j, j, PendingIntent.getBroadcast(context, 0, intent, 134217728));
    }

    public static void a(Context context, String str) {
        String str2 = a;
        e.a(str2, "enter cancelAlarm(Action=" + str);
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    public static void b(Context context, Intent intent, long j) {
        String str = a;
        e.a(str, "enter AlarmTools:setHeartAlarm(intent:" + intent + " interval:" + j + "ms");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        if (Build.VERSION.SDK_INT >= b) {
            a(context, System.currentTimeMillis() + j, broadcast);
        } else {
            alarmManager.setRepeating(0, System.currentTimeMillis() + j, j, broadcast);
        }
    }

    public static void c(Context context, Intent intent, long j) {
        String str = a;
        e.a(str, "enter AlarmTools:setDelayAlarm(intent:" + intent + " interval:" + j + "ms, context:" + context);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        if (Build.VERSION.SDK_INT >= b) {
            a(context, System.currentTimeMillis() + j, broadcast);
        } else {
            alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
        }
    }
}
