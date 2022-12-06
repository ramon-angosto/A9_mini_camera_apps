package com.tzh.ipcamera.permission;

import android.app.Activity;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

public class PermissionHelper {
    private static final String TAG = "PermissionHelper";
    private Activity mActivity;
    private PermissionInterface mPermissionInterface;

    public PermissionHelper(Activity activity, PermissionInterface permissionInterface) {
        this.mActivity = activity;
        this.mPermissionInterface = permissionInterface;
    }

    public void requestPermissions() {
        String[] deniedPermissions = PermissionUtil.getDeniedPermissions(this.mActivity, this.mPermissionInterface.getPermissions());
        if (deniedPermissions == null || deniedPermissions.length <= 0) {
            Log.e(PermissionHelper.class.getSimpleName(), "request camera success!");
            this.mPermissionInterface.requestPermissionsSuccess();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.mActivity.requestPermissions(deniedPermissions, this.mPermissionInterface.getPermissionsRequestCode());
        }
    }

    public void requesetStoragePermission() {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this.mActivity, "android.permission-group.STORAGE") != 0) {
            ActivityCompat.requestPermissions(this.mActivity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    public boolean requestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z = false;
        if (i != this.mPermissionInterface.getPermissionsRequestCode()) {
            return false;
        }
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            }
            int i3 = iArr[i2];
            Log.i(TAG, "requestPermissionsResult: " + i3);
            if (i3 == -1) {
                break;
            }
            i2++;
        }
        if (z) {
            this.mPermissionInterface.requestPermissionsSuccess();
        } else {
            this.mPermissionInterface.requestPermissionsFail();
        }
        return true;
    }
}
