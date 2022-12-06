package com.ironsource.environment;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class k {
    private static final String a = k.class.getSimpleName();
    private static final ArrayList<String> b = new ArrayList<String>() {
        {
            add("com.google.market");
            add("com.android.vending");
        }
    };

    private static JSONObject a(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> b2 = b(context);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                final boolean contains = b2.contains(next.trim().toLowerCase());
                jSONObject.put(next, new JSONObject() {
                    {
                        put("isInstalled", contains);
                    }
                });
            }
        } catch (Exception unused) {
            Log.d(a, "Error while extracting packages installation data");
        }
        return jSONObject;
    }

    public static boolean a(Context context) {
        JSONObject a2 = a(context, b);
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = a2.optJSONObject(keys.next());
            if (optJSONObject != null && optJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> b(Context context) {
        List<ApplicationInfo> p = h.p(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo next : p) {
            if (next != null) {
                arrayList.add(next.packageName.toLowerCase());
            }
        }
        return arrayList;
    }
}
