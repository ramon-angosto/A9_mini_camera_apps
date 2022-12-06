package com.huawei.android.pushselfshow.utils;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import java.lang.reflect.InvocationTargetException;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    b(Context context, String str, String str2, String str3) {
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public void run() {
        String str;
        String str2;
        try {
            if (!a.l(this.a)) {
                e.a("PushSelfShowLog", "not allowed to sendHiAnalytics!");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(a.a()));
            stringBuffer.append("|");
            stringBuffer.append("PS");
            stringBuffer.append("|");
            stringBuffer.append(a.b(this.a));
            stringBuffer.append("|");
            stringBuffer.append(this.b);
            stringBuffer.append("|");
            stringBuffer.append(this.c);
            stringBuffer.append("|");
            stringBuffer.append(a.a(this.a));
            stringBuffer.append("|");
            stringBuffer.append(this.d);
            String stringBuffer2 = stringBuffer.toString();
            if (this.a != null) {
                e.b("PushSelfShowLog", "run normal sendHiAnalytics");
                Class<?> cls = Class.forName("com.hianalytics.android.v1.HiAnalytics");
                cls.getMethod("onEvent", new Class[]{Context.class, String.class, String.class}).invoke(cls, new Object[]{this.a, "PUSH_PS", stringBuffer2});
                cls.getMethod("onReport", new Class[]{Context.class}).invoke(cls, new Object[]{this.a});
                str2 = "send HiAnalytics msg, report cmd =" + this.d + ", msgid = " + this.b + ", eventId = " + this.c;
            } else {
                str2 = "send HiAnalytics msg, report cmd =" + this.d + ",context = " + this.a;
            }
            e.a("PushSelfShowLog", str2);
        } catch (IllegalAccessException e) {
            e = e;
            str = "sendHiAnalytics IllegalAccessException ";
            e.d("PushSelfShowLog", str, e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            str = "sendHiAnalytics IllegalArgumentException ";
            e.d("PushSelfShowLog", str, e);
        } catch (InvocationTargetException e3) {
            e = e3;
            str = "sendHiAnalytics InvocationTargetException";
            e.d("PushSelfShowLog", str, e);
        } catch (NoSuchMethodException e4) {
            e = e4;
            str = "sendHiAnalytics NoSuchMethodException";
            e.d("PushSelfShowLog", str, e);
        } catch (ClassNotFoundException e5) {
            e = e5;
            str = "sendHiAnalytics ClassNotFoundException";
            e.d("PushSelfShowLog", str, e);
        }
    }
}
