package com.bytedance.sdk.openadsdk.c.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.e.a.a.e;
import com.bytedance.sdk.component.e.a.c.c;

/* compiled from: MyDBCallback */
public class f implements e {
    public static final f a = new f();
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
                    this.b = com.bytedance.sdk.openadsdk.core.e.a(context).a().a();
                    c.a("---------------DB CREATE  SUCCESS------------");
                }
            }
        }
        return this.b;
    }
}
