package com.hianalytics.android.v1;

import android.content.Context;
import android.content.SharedPreferences;
import com.hianalytics.android.a.a.c;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a implements Runnable {
    private Context a;
    private String b;
    private String c;
    private long d;

    public a(Context context, String str, String str2, long j) {
        this.a = context;
        this.b = str.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "^");
        this.c = str2.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "^");
        this.d = j;
    }

    public final void run() {
        try {
            SharedPreferences a2 = c.a(this.a, "state");
            if (a2 == null) {
                com.hianalytics.android.a.a.a.h();
                return;
            }
            String string = a2.getString("events", "");
            if (!"".equals(string)) {
                string = String.valueOf(string) + ";";
            }
            String str = String.valueOf(string) + this.b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.c + Constants.ACCEPT_TIME_SEPARATOR_SP + new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US).format(new Date(this.d));
            int length = str.split(";").length;
            if (length <= com.hianalytics.android.a.a.a.d()) {
                SharedPreferences.Editor edit = a2.edit();
                edit.remove("events");
                edit.putString("events", str);
                edit.commit();
                " current event record is：" + length;
                com.hianalytics.android.a.a.a.h();
            }
            if (!com.hianalytics.android.a.a.a.d(this.a)) {
                return;
            }
            if (com.hianalytics.android.a.a.a.e()) {
                com.hianalytics.android.a.a.a.h();
                HiAnalytics.onReport(this.a);
                return;
            }
            a2.edit().remove("events").commit();
        } catch (Exception e) {
            "EventThread.run() throw exception:" + e.getMessage();
            com.hianalytics.android.a.a.a.h();
            e.printStackTrace();
        }
    }
}
