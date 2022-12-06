package com.unad.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: IPSharedPreferencesUtil */
public class b {
    public static String d = "service_id";
    public static String e = "appuuid";
    public static String f = "splasherrorlogs";
    public String a = "parmIP";
    private SharedPreferences b;
    private SharedPreferences.Editor c;

    public b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("parmIP", 4);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    public void a(String str, String str2) {
        try {
            this.c.putString(str, str2);
            this.c.commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String b(String str, String str2) {
        try {
            return this.b.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
