package com.vungle.warren.utility;

import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;

public class VungleUrlUtility {
    private static final String TAG = VungleUrlUtility.class.getSimpleName();

    public static boolean isVungleUrl(String str) {
        try {
            return new URL(str).getHost().toLowerCase().contains(".vungle.com");
        } catch (MalformedURLException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }
}
