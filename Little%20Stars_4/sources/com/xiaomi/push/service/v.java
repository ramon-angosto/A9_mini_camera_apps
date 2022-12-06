package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.b;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;

public class v {
    private static volatile v b;
    protected SharedPreferences a;

    private v(Context context) {
        this.a = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    public static v a(Context context) {
        if (b == null) {
            synchronized (v.class) {
                if (b == null) {
                    b = new v(context);
                }
            }
        }
        return b;
    }

    private String a(int i) {
        return "normal_oc_" + i;
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            editor.putString(str, (String) pair.second);
        } else if (pair.second instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    private String b(int i) {
        return "custom_oc_" + i;
    }

    public int a(int i, int i2) {
        String b2 = b(i);
        if (this.a.contains(b2)) {
            return this.a.getInt(b2, 0);
        }
        String a2 = a(i);
        return this.a.contains(a2) ? this.a.getInt(a2, 0) : i2;
    }

    public String a(int i, String str) {
        String b2 = b(i);
        if (this.a.contains(b2)) {
            return this.a.getString(b2, (String) null);
        }
        String a2 = a(i);
        return this.a.contains(a2) ? this.a.getString(a2, (String) null) : str;
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (!b.a(list)) {
            SharedPreferences.Editor edit = this.a.edit();
            for (Pair next : list) {
                if (!(next.first == null || next.second == null)) {
                    a(edit, next, a(((Integer) next.first).intValue()));
                }
            }
            edit.commit();
        }
    }

    public boolean a(int i, boolean z) {
        String b2 = b(i);
        if (this.a.contains(b2)) {
            return this.a.getBoolean(b2, false);
        }
        String a2 = a(i);
        return this.a.contains(a2) ? this.a.getBoolean(a2, false) : z;
    }

    public void b(List<Pair<Integer, Object>> list) {
        if (!b.a(list)) {
            SharedPreferences.Editor edit = this.a.edit();
            for (Pair next : list) {
                if (next.first != null) {
                    String b2 = b(((Integer) next.first).intValue());
                    if (next.second == null) {
                        edit.remove(b2);
                    } else {
                        a(edit, next, b2);
                    }
                }
            }
            edit.commit();
        }
    }
}
