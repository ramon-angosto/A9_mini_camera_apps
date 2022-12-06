package com.mbridge.msdk.foundation.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.tools.q;

/* compiled from: SharedPerferenceManager */
public class a {
    public static final String a = a.class.getSimpleName();
    private static a c;
    SharedPreferences b;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public final void a(String str, String str2) {
        try {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g != null) {
                if (this.b == null && g != null) {
                    this.b = g.getSharedPreferences("mbridge", 0);
                }
                SharedPreferences.Editor edit = this.b.edit();
                edit.putString(str, str2);
                edit.apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(String str, int i) {
        try {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g != null) {
                if (this.b == null && g != null) {
                    this.b = g.getSharedPreferences("mbridge", 0);
                }
                SharedPreferences.Editor edit = this.b.edit();
                edit.putInt(str, i);
                edit.apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(String str, long j) {
        try {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g == null) {
                q.d(a, "context is null in put");
                return;
            }
            if (this.b == null && g != null) {
                this.b = g.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor edit = this.b.edit();
            edit.putLong(str, j);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Long a(String str) {
        try {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g == null) {
                q.d(a, "context is null in get");
                return 0L;
            }
            if (this.b == null && g != null) {
                this.b = g.getSharedPreferences("mbridge", 0);
            }
            return Long.valueOf(this.b.getLong(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public final int b(String str, int i) {
        try {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g == null) {
                return i;
            }
            if (this.b == null) {
                this.b = g.getSharedPreferences("mbridge", 0);
            }
            return this.b.getInt(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public final String b(String str) {
        try {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g == null) {
                return null;
            }
            if (this.b == null && g != null) {
                this.b = g.getSharedPreferences("mbridge", 0);
            }
            return this.b.getString(str, "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void c(String str) {
        Context g = com.mbridge.msdk.foundation.controller.a.e().g();
        if (g != null) {
            if (this.b == null && g != null) {
                this.b = g.getSharedPreferences("mbridge", 0);
            }
            this.b.edit().remove(str).apply();
        }
    }
}
