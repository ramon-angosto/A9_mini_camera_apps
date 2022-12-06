package com.adcolony.sdk;

import android.os.Bundle;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import java.util.HashMap;

class r0 {
    private static int a;
    private static HashMap<String, Integer> b = new HashMap<>();
    private static HashMap<String, Integer> c = new HashMap<>();

    static boolean a(int i, Bundle bundle) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (i != 0) {
            if (i != 1 || bundle == null) {
                return false;
            }
            String string = bundle.getString(AdColonyAdapterUtils.KEY_ZONE_ID);
            if (b.get(string) == null) {
                b.put(string, Integer.valueOf(currentTimeMillis));
            }
            if (c.get(string) == null) {
                c.put(string, 0);
            }
            if (currentTimeMillis - b.get(string).intValue() > 1) {
                c.put(string, 1);
                b.put(string, Integer.valueOf(currentTimeMillis));
                return false;
            }
            int intValue = c.get(string).intValue() + 1;
            c.put(string, Integer.valueOf(intValue));
            return intValue > 3;
        } else if (currentTimeMillis - a < 5) {
            return true;
        } else {
            a = currentTimeMillis;
            return false;
        }
    }
}
