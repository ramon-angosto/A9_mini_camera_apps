package com.tzh.ipcamera.permission;

public interface PermissionInterface {
    String[] getPermissions();

    int getPermissionsRequestCode();

    void requestPermissionsFail();

    void requestPermissionsSuccess();
}
