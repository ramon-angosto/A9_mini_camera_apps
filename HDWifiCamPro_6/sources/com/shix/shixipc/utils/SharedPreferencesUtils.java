package com.shix.shixipc.utils;

import android.content.SharedPreferences;
import com.shix.shixipc.CrashApplication;

public class SharedPreferencesUtils {
    public static final String USER_NAME = "name";
    private static SharedPreferencesUtils instance;
    private String SHARED_NAME = "shix_sp";
    private SharedPreferences.Editor editor = this.share.edit();
    private SharedPreferences share = CrashApplication.getContext().getSharedPreferences(this.SHARED_NAME, 0);

    private SharedPreferencesUtils() {
    }

    public static SharedPreferencesUtils getInstance() {
        if (instance == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (instance == null) {
                    instance = new SharedPreferencesUtils();
                }
            }
        }
        return instance;
    }

    public void putInt(String str, int i) {
        this.editor.putInt(str, i);
        this.editor.commit();
    }

    public int getInt(String str, int i) {
        return this.share.getInt(str, i);
    }

    public void putString(String str, String str2) {
        this.editor.putString(str, str2);
        this.editor.commit();
    }

    public String getString(String str, String str2) {
        return this.share.getString(str, str2);
    }

    public String getString(String str) {
        return this.share.getString(str, "");
    }

    public void putBoolean(String str, boolean z) {
        this.editor.putBoolean(str, z);
        this.editor.commit();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.share.getBoolean(str, z);
    }

    public void putFloat(String str, float f) {
        this.editor.putFloat(str, f);
        this.editor.commit();
    }

    public float getFloat(String str, float f) {
        return this.share.getFloat(str, f);
    }

    public void putLong(String str, long j) {
        this.editor.putLong(str, j);
        this.editor.commit();
    }

    public long getLong(String str, long j) {
        return this.share.getLong(str, j);
    }

    public void clear() {
        this.editor.clear();
        this.editor.commit();
    }

    public void remove(String str) {
        this.editor.remove(str);
        this.editor.commit();
    }

    public boolean contains(String str) {
        return this.share.contains(str);
    }
}
