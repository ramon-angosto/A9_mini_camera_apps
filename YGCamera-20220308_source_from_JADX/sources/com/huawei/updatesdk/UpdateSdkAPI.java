package com.huawei.updatesdk;

import android.content.Context;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.C1086g;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;

public final class UpdateSdkAPI {
    public static void checkAppUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z, boolean z2) {
        C1086g.m2123a(context, checkUpdateCallBack, z, z2);
    }

    public static void checkAppUpdate(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        C1086g.m2124a(context, updateParams, checkUpdateCallBack);
    }

    public static void checkAppUpdateByAppInfo(Context context, CheckUpdateCallBack checkUpdateCallBack, AppInfoAdapter appInfoAdapter) {
        C1086g.m2121a(context, checkUpdateCallBack, appInfoAdapter);
    }

    public static void checkAppUpdateForHMSKit(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        C1086g.m2128b(context, updateParams, checkUpdateCallBack);
    }

    public static void checkClientOTAUpdate(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z, int i, boolean z2) {
        C1086g.m2122a(context, checkUpdateCallBack, z, i, z2);
    }

    public static void checkTargetAppUpdate(Context context, String str, CheckUpdateCallBack checkUpdateCallBack) {
        C1086g.m2126a(context, str, checkUpdateCallBack);
    }

    public static void releaseCallBack() {
        C1086g.m2116a();
    }

    public static void setAppStorePkgName(String str) {
        C1086g.m2127a(str);
    }

    public static void setServiceZone(String str) {
        C1086g.m2129b(str);
    }

    public static void showUpdateDialog(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z) {
        C1086g.m2119a(context, apkUpgradeInfo, z);
    }

    public static void showUpdateDialogByAppInfo(Context context, ApkUpgradeInfo apkUpgradeInfo, AppInfoAdapter appInfoAdapter) {
        C1086g.m2118a(context, apkUpgradeInfo, appInfoAdapter);
    }
}
