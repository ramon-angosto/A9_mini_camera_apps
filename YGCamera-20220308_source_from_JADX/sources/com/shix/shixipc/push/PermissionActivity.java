package com.shix.shixipc.push;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.shix.shixipc.CrashApplication;

public class PermissionActivity extends Activity {
    private static final int PERMISSION_REQUEST = 1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            String[] stringArrayExtra = getIntent().getStringArrayExtra("permissions");
            for (String checkSelfPermission : stringArrayExtra) {
                if (checkSelfPermission(checkSelfPermission) != 0) {
                    requestPermissions(stringArrayExtra, 1);
                    return;
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            boolean z = false;
            for (int i2 : iArr) {
                if (i2 == 0) {
                    z = true;
                }
            }
            if (z) {
                Log.w("PermissionActivity", "Permissions granted:");
                CrashApplication.reInitPush(this);
            }
            finish();
        }
    }
}
