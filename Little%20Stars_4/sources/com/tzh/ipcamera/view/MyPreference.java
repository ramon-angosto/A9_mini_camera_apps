package com.tzh.ipcamera.view;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public class MyPreference {
    private static final String AGREE = "agree";
    private static final String PASSWORD = "password";
    private static final String SSID = "ssid";
    private static MyPreference preference;
    private String packageName = "";
    private SharedPreferences sharedPreference;

    public static synchronized MyPreference getInstance(Context context) {
        MyPreference myPreference;
        synchronized (MyPreference.class) {
            if (preference == null) {
                preference = new MyPreference(context);
            }
            myPreference = preference;
        }
        return myPreference;
    }

    public MyPreference(Context context) {
        this.packageName = context.getPackageName() + "_preferences";
        this.sharedPreference = context.getSharedPreferences(this.packageName, 0);
    }

    public Boolean isExistAgree() {
        if (this.sharedPreference.contains(AGREE)) {
            return true;
        }
        return false;
    }

    public Boolean getIsAgree() {
        return Boolean.valueOf(this.sharedPreference.getBoolean(AGREE, false));
    }

    public void SetIsAgree(Boolean bool) {
        SharedPreferences.Editor edit = this.sharedPreference.edit();
        edit.putBoolean(AGREE, bool.booleanValue());
        edit.commit();
    }

    public String getSsid() {
        return this.sharedPreference.getString(SSID, "");
    }

    public void SetSsid(String str) {
        SharedPreferences.Editor edit = this.sharedPreference.edit();
        edit.putString(SSID, str);
        edit.commit();
    }

    public String getPassword() {
        return this.sharedPreference.getString(PASSWORD, "");
    }

    public void SetPassword(String str) {
        SharedPreferences.Editor edit = this.sharedPreference.edit();
        edit.putString(PASSWORD, str);
        edit.commit();
    }

    public String getPassword_new(String str) {
        Map<String, ?> all = this.sharedPreference.getAll();
        for (int i = 0; i < all.size() / 2; i++) {
            SharedPreferences sharedPreferences = this.sharedPreference;
            if (sharedPreferences.getString(SSID + i, "").equals(str)) {
                SharedPreferences sharedPreferences2 = this.sharedPreference;
                return sharedPreferences2.getString(PASSWORD + i, "");
            }
        }
        return "";
    }

    public void SetWifiData(String str, String str2) {
        Map<String, ?> all = this.sharedPreference.getAll();
        for (int i = 0; i < all.size() / 2; i++) {
            SharedPreferences sharedPreferences = this.sharedPreference;
            if (sharedPreferences.getString(SSID + i, "").equals(str)) {
                SharedPreferences.Editor edit = this.sharedPreference.edit();
                edit.putString(PASSWORD + i, str2);
                edit.commit();
                return;
            }
        }
        SharedPreferences.Editor edit2 = this.sharedPreference.edit();
        edit2.putString(SSID + (all.size() / 2), str);
        edit2.putString(PASSWORD + (all.size() / 2), str2);
        edit2.commit();
    }
}
