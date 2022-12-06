package com.huawei.hms.aaid.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class PushPreferences {
    public static final String TAG = "PushPreferences";

    /* renamed from: a */
    public SharedPreferences f242a;

    public PushPreferences(Context context, String str) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
                if (!sharedPreferences.getBoolean(str, false)) {
                    if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean(str, true);
                        edit.apply();
                    }
                }
                context = createDeviceProtectedStorageContext;
            }
            this.f242a = mo12956b(context, str);
            if (this.f242a == null) {
                HMSLog.m1380w(TAG, "get new sharedPreferences failed,start to get from context. ");
                this.f242a = context.getSharedPreferences(str, 0);
                return;
            }
            return;
        }
        throw new NullPointerException("context is null!");
    }

    /* renamed from: a */
    public final File mo12955a(Context context, String str) {
        File file;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(context.getDataDir() + "/shared_prefs", str + ".xml");
            } else {
                file = new File(context.getFilesDir().getParent() + "/shared_prefs", str + ".xml");
            }
            if (!file.exists()) {
                return null;
            }
            return file;
        } catch (Exception e) {
            HMSLog.m1377e(TAG, "get failed error." + e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public final SharedPreferences mo12956b(Context context, String str) {
        File a = mo12955a(context, str);
        if (a == null) {
            return null;
        }
        try {
            Constructor<?> declaredConstructor = Class.forName("android.app.SharedPreferencesImpl").getDeclaredConstructor(new Class[]{File.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return (SharedPreferences) declaredConstructor.newInstance(new Object[]{a, 0});
        } catch (Exception e) {
            HMSLog.m1377e(TAG, "get SharedPreferences error." + e.getMessage());
            return null;
        }
    }

    public boolean clear() {
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit().clear().commit();
        }
        return false;
    }

    public boolean containsKey(String str) {
        SharedPreferences sharedPreferences = this.f242a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return new HashMap();
    }

    public boolean getBoolean(String str) {
        SharedPreferences sharedPreferences = this.f242a;
        return sharedPreferences != null && sharedPreferences.getBoolean(str, false);
    }

    public int getInt(String str) {
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    public long getLong(String str) {
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0);
        }
        return 0;
    }

    public String getString(String str) {
        SharedPreferences sharedPreferences = this.f242a;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    public ContentValues read() {
        Map<String, ?> all;
        SharedPreferences sharedPreferences = this.f242a;
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
            } else if (value instanceof Float) {
                contentValues.put(str, (Float) value);
            } else if (value instanceof Double) {
                contentValues.put(str, Float.valueOf((float) ((Double) value).doubleValue()));
            } else if (value instanceof Boolean) {
                contentValues.put(str, (Boolean) value);
            }
        }
        return contentValues;
    }

    public boolean removeKey(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (edit = this.f242a.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }

    public boolean save(String str, Object obj) {
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (obj instanceof String) {
            edit.putString(str, String.valueOf(obj));
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            edit.putInt(str, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            edit.putInt(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            edit.putFloat(str, (float) ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        return edit.commit();
    }

    public void saveBoolean(String str, boolean z) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putBoolean(str, z).commit();
        }
    }

    public void saveInt(String str, Integer num) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putInt(str, num.intValue()).commit();
        }
    }

    public void saveLong(String str, Long l) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, l.longValue()).commit();
        }
    }

    public void saveMap(Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            save((String) next.getKey(), next.getValue());
        }
    }

    public boolean saveString(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f242a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public boolean write(ContentValues contentValues) {
        if (this.f242a == null || contentValues == null) {
            return false;
        }
        boolean z = true;
        for (Map.Entry next : contentValues.valueSet()) {
            if (!save((String) next.getKey(), next.getValue())) {
                z = false;
            }
        }
        return z;
    }

    public boolean removeKey(String[] strArr) {
        if (this.f242a == null) {
            return false;
        }
        for (String str : strArr) {
            if (this.f242a.contains(str)) {
                this.f242a.edit().remove(str);
            }
        }
        this.f242a.edit().commit();
        return true;
    }
}
