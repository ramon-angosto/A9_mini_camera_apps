package com.bytedance.sdk.component.e.a.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.e.a.c.c;

/* compiled from: MyDBCallback */
public class e implements com.bytedance.sdk.component.e.a.a.e {
    public static final e a = new e();
    private volatile SQLiteDatabase b;

    public String a() {
        return "loghighpriority";
    }

    public String b() {
        return "adevent";
    }

    public String c() {
        return null;
    }

    public String d() {
        return "logstats";
    }

    public String e() {
        return "logstatsbatch";
    }

    public String f() {
        return null;
    }

    public SQLiteDatabase a(Context context) {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new d(context).getWritableDatabase();
                    c.a("---------------DB CREATE  SUCCESS------------");
                }
            }
        }
        return this.b;
    }
}
