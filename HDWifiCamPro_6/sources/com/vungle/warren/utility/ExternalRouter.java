package com.vungle.warren.utility;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.utility.ActivityManager;
import java.net.URISyntaxException;

public class ExternalRouter {
    public static final String TAG = ExternalRouter.class.getSimpleName();

    public static boolean launch(String str, String str2, Context context, ActivityManager.LeftApplicationCallback leftApplicationCallback, boolean z, PresenterAdOpenCallback presenterAdOpenCallback) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || context == null) {
            return false;
        }
        try {
            ActivityManager.startWhenForeground(context, getIntentFromUrl(str, z), getIntentFromUrl(str2, z), leftApplicationCallback, presenterAdOpenCallback);
            return true;
        } catch (Exception e) {
            String str3 = TAG;
            Log.e(str3, "Error while opening url" + e.getLocalizedMessage());
            String str4 = TAG;
            Log.d(str4, "Cannot open url " + str2);
            return false;
        }
    }

    private static Intent getIntentFromUrl(String str, boolean z) {
        Intent intent = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                intent = Intent.parseUri(str, 0);
            }
            if (intent != null && z) {
                intent.setFlags(268435456);
            }
        } catch (URISyntaxException e) {
            String str2 = TAG;
            Log.e(str2, "url format is not correct " + e.getLocalizedMessage());
        }
        return intent;
    }
}
