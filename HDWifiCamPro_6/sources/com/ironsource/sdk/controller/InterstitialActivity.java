package com.ironsource.sdk.controller;

import android.os.Bundle;
import com.ironsource.sdk.utils.Logger;

public class InterstitialActivity extends ControllerActivity {
    private static final String a = InterstitialActivity.class.getSimpleName();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(a, "onCreate");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Logger.i(a, "onPause");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Logger.i(a, "onResume");
    }
}
