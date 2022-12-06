package com.huawei.android.pushagent.c.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

public class h {
    protected SharedPreferences a;

    public h(Context context, String str) {
        if (context != null) {
            this.a = context.getSharedPreferences(str, 4);
            return;
        }
        throw new NullPointerException("context is null!");
    }

    public ContentValues a() {
        Map<String, ?> all;
        Float valueOf;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof String) {
                contentValues.put(str, String.valueOf(value));
            } else if ((value instanceof Integer) || (value instanceof Short) || (value instanceof Byte)) {
                contentValues.put(str, (Integer) value);
            } else if (value instanceof Long) {
                contentValues.put(str, (Long) value);
            } else {
                if (value instanceof Float) {
                    valueOf = (Float) value;
                } else if (value instanceof Double) {
                    valueOf = Float.valueOf((float) ((Double) value).doubleValue());
                } else if (value instanceof Boolean) {
                    contentValues.put(str, (Boolean) value);
                }
                contentValues.put(str, valueOf);
            }
        }
        return contentValues;
    }

    public void a(String str, Integer num) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putInt(str, num.intValue()).commit();
        }
    }

    public void a(String str, Long l) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, l.longValue()).commit();
        }
    }

    public void a(String str, boolean z) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putBoolean(str, z).commit();
        }
    }

    public void a(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            a((String) entry.getKey(), entry.getValue());
        }
    }

    public boolean a(ContentValues contentValues) {
        if (this.a == null || contentValues == null) {
            return false;
        }
        boolean z = true;
        for (Map.Entry next : contentValues.valueSet()) {
            if (!a((String) next.getKey(), next.getValue())) {
                z = false;
            }
        }
        return z;
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return false;
    }

    public boolean a(String str, Object obj) {
        float doubleValue;
        int byteValue;
        SharedPreferences.Editor edit = this.a.edit();
        if (obj instanceof String) {
            edit.putString(str, String.valueOf(obj));
        } else {
            if (obj instanceof Integer) {
                byteValue = ((Integer) obj).intValue();
            } else if (obj instanceof Short) {
                byteValue = ((Short) obj).shortValue();
            } else if (obj instanceof Byte) {
                byteValue = ((Byte) obj).byteValue();
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else {
                if (obj instanceof Float) {
                    doubleValue = ((Float) obj).floatValue();
                } else if (obj instanceof Double) {
                    doubleValue = (float) ((Double) obj).doubleValue();
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                }
                edit.putFloat(str, doubleValue);
            }
            edit.putInt(str, byteValue);
        }
        return edit.commit();
    }

    public boolean a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public String b(String str) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    public Map b() {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getAll() : new HashMap();
    }

    public int c(String str) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    public boolean c() {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit().clear().commit();
        }
        return false;
    }

    public long d(String str) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0);
        }
        return 0;
    }

    public boolean e(String str) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public boolean f(String str) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || !sharedPreferences.contains(str)) {
            return false;
        }
        SharedPreferences.Editor remove = this.a.edit().remove(str);
        remove.commit();
        return remove.commit();
    }
}
