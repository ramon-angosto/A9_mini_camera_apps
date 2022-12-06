package com.huawei.android.pushagent.c;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import java.lang.reflect.InvocationTargetException;

final class d implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    d(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        String str;
        try {
            if (this.a != null) {
                e.b("PushLogAC2705", "run normal sendHiAnalytics");
                if (!c.e(this.a)) {
                    e.b("PushLogAC2705", "not allowed to sendHiAnalytics!");
                    return;
                }
                Class<?> cls = Class.forName("com.hianalytics.android.v1.HiAnalytics");
                cls.getMethod("onEvent", new Class[]{Context.class, String.class, String.class}).invoke(cls, new Object[]{this.a, this.b, this.c});
                cls.getMethod("onReport", new Class[]{Context.class}).invoke(cls, new Object[]{this.a});
                e.a("PushLogAC2705", "send HiAnalytics msg,PS =" + this.b);
                return;
            }
            e.d("PushLogAC2705", "context is null when sendHiAnalytics");
        } catch (IllegalAccessException e) {
            e = e;
            str = "sendHiAnalytics IllegalAccessException ";
            e.d("PushLogAC2705", str, e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            str = "sendHiAnalytics IllegalArgumentException ";
            e.d("PushLogAC2705", str, e);
        } catch (InvocationTargetException e3) {
            e = e3;
            str = "sendHiAnalytics InvocationTargetException";
            e.d("PushLogAC2705", str, e);
        } catch (NoSuchMethodException e4) {
            e = e4;
            str = "sendHiAnalytics NoSuchMethodException";
            e.d("PushLogAC2705", str, e);
        } catch (ClassNotFoundException e5) {
            e = e5;
            str = "sendHiAnalytics ClassNotFoundException";
            e.d("PushLogAC2705", str, e);
        } catch (Exception e6) {
            e = e6;
            str = "sendHiAnalytics Exception";
            e.d("PushLogAC2705", str, e);
        }
    }
}
