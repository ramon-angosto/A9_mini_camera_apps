package com.huawei.hms.update.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.availableupdate.C0660n;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p024ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.StringUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

public class UpdateManager {
    /* renamed from: a */
    public static boolean m1386a(Context context, String str) {
        PackageManagerHelper.PackageStates packageStates = new PackageManagerHelper(context).getPackageStates(str);
        HMSLog.m1379i("UpdateManager", "app is: " + str + ";status is:" + packageStates);
        return PackageManagerHelper.PackageStates.ENABLED == packageStates;
    }

    /* renamed from: b */
    public static void m1387b(Context context, ArrayList<Integer> arrayList) {
        if (m1386a(context, PackageConstants.SERVICES_PACKAGE_APPMARKET) && !PackageConstants.SERVICES_PACKAGE_APPMARKET.equals(context.getPackageName())) {
            arrayList.add(5);
        }
    }

    /* renamed from: c */
    public static void m1389c(Context context, ArrayList<Integer> arrayList) {
        if (m1386a(context, PackageConstants.SERVICES_PACKAGE_APPMARKET) && !PackageConstants.SERVICES_PACKAGE_APPMARKET.equals(context.getPackageName()) && m1390c(context)) {
            arrayList.add(5);
        } else if (m1391d(context)) {
            arrayList.add(7);
        } else if (!m1385a(context)) {
            arrayList.add(6);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1391d(android.content.Context r4) {
        /*
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.apptouch.intent.action.update_hms"
            r0.<init>(r1)
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            r2 = 0
            java.util.List r0 = r1.queryIntentServices(r0, r2)
            if (r0 == 0) goto L_0x003f
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x003f
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r0.next()
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            android.content.pm.ServiceInfo r1 = r1.serviceInfo
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r1.packageName
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x001c
            android.content.Context r3 = r4.getApplicationContext()
            boolean r3 = com.huawei.hms.android.SystemUtils.isSystemApp(r3, r1)
            if (r3 == 0) goto L_0x001c
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            if (r1 == 0) goto L_0x0043
            r2 = 1
        L_0x0043:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.manager.UpdateManager.m1391d(android.content.Context):boolean");
    }

    public static Intent getStartUpdateIntent(Activity activity, UpdateBean updateBean) {
        if (activity == null || updateBean == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(updateBean.getClientAppName())) {
            m1384a((Context) activity, (ArrayList<Integer>) arrayList);
        } else {
            m1383a(activity, (ArrayList<Integer>) arrayList);
        }
        int i = -2;
        if (arrayList.size() > 0) {
            i = ((Integer) arrayList.get(0)).intValue();
        } else {
            HMSLog.m1379i("UpdateManager", "typeList is empty, no upgrade solution");
        }
        updateBean.setTypeList(arrayList);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, C0660n.m343a(i));
        intentStartBridgeActivity.putExtra(BridgeActivity.EXTRA_DELEGATE_UPDATE_INFO, updateBean);
        return intentStartBridgeActivity;
    }

    public static void startUpdate(Activity activity, int i, UpdateBean updateBean) {
        Intent startUpdateIntent = getStartUpdateIntent(activity, updateBean);
        if (startUpdateIntent != null) {
            activity.startActivityForResult(startUpdateIntent, i);
        }
    }

    public static Intent startUpdateIntent(Activity activity) {
        Intent intent;
        if (activity == null) {
            return null;
        }
        UpdateBean updateBean = new UpdateBean();
        updateBean.setHmsOrApkUpgrade(true);
        updateBean.setClientPackageName(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName());
        updateBean.setClientVersionCode(HMSPackageManager.getInstance(activity.getApplicationContext()).getHmsVersionCode());
        updateBean.setClientAppId("C10132067");
        updateBean.setNeedConfirm(false);
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(updateBean.getClientAppName())) {
            m1384a((Context) activity, (ArrayList<Integer>) arrayList);
        } else {
            m1383a(activity, (ArrayList<Integer>) arrayList);
        }
        updateBean.setTypeList(arrayList);
        if (arrayList.size() > 1) {
            intent = BridgeActivity.getIntentStartBridgeActivity(activity, C0660n.m343a(((Integer) arrayList.get(1)).intValue()));
        } else {
            int i = -2;
            if (arrayList.size() > 0) {
                i = ((Integer) arrayList.get(0)).intValue();
            } else {
                HMSLog.m1379i("UpdateManager", "typeList is empty, no upgrade solution");
            }
            intent = BridgeActivity.getIntentStartBridgeActivity(activity, C0660n.m343a(i));
        }
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_UPDATE_INFO, updateBean);
        return intent;
    }

    /* renamed from: b */
    public static boolean m1388b(Context context) {
        int packageVersionCode = new PackageManagerHelper(context).getPackageVersionCode(PackageConstants.SERVICES_PACKAGE_APPMARKET);
        HMSLog.m1379i("UpdateManager", "getHiappVersion is " + packageVersionCode);
        return ((long) packageVersionCode) >= 70203000;
    }

    /* renamed from: a */
    public static void m1384a(Context context, ArrayList<Integer> arrayList) {
        if (SystemUtils.isTVDevice()) {
            arrayList.add(5);
        } else if (!SystemUtils.isSystemApp(context.getApplicationContext(), PackageConstants.SERVICES_PACKAGE_APPMARKET) || !m1388b(context) || !SystemUtils.isChinaROM()) {
            m1389c(context, arrayList);
        } else {
            arrayList.add(0);
            arrayList.add(6);
        }
    }

    /* renamed from: c */
    public static boolean m1390c(Context context) {
        if (context == null) {
            HMSLog.m1379i("UpdateManager", "In isAgNewVersion, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m1379i("UpdateManager", "In isAgNewVersion, configuration not found for base version setting");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_APPMARKET, 128).applicationInfo;
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                if (applicationInfo.metaData.containsKey("com.huawei.hms.client.service.name:base")) {
                    String string = applicationInfo.metaData.getString("com.huawei.hms.client.service.name:base");
                    if (!TextUtils.isEmpty(string)) {
                        if (string.split(Constants.COLON_SEPARATOR).length == 2) {
                            if (StringUtil.convertVersion2Integer(string.split(Constants.COLON_SEPARATOR)[1]) >= 50004100) {
                                return true;
                            }
                            HMSLog.m1379i("UpdateManager", "In isAgNewVersion, configuration not found for base version setting");
                            return false;
                        }
                    }
                    HMSLog.m1379i("UpdateManager", "In isAgNewVersion, configuration not found for base version setting");
                    return false;
                }
            }
            HMSLog.m1379i("UpdateManager", "In isAgNewVersion, configuration not found for base version setting");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m1377e("UpdateManager", "In isAgNewVersion, Failed to read meta data from base version setting channel.");
        }
    }

    /* renamed from: a */
    public static void m1383a(Activity activity, ArrayList<Integer> arrayList) {
        if (m1386a((Context) activity, PackageConstants.SERVICES_PACKAGE_APPMARKET) && !PackageConstants.SERVICES_PACKAGE_APPMARKET.equals(activity.getPackageName())) {
            arrayList.add(5);
        }
    }

    /* renamed from: a */
    public static boolean m1385a(Context context) {
        if (context == null) {
            HMSLog.m1377e("UpdateManager", "In getAndroidMarketSetting, context is null.");
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m1379i("UpdateManager", "In getAndroidMarketSetting, configuration not found for android channel market setting.");
            return true;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("com.huawei.hms.client.channel.androidMarket"))) {
                return applicationInfo.metaData.getBoolean("com.huawei.hms.client.channel.androidMarket", true);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m1377e("UpdateManager", "In getAndroidMarketSetting, Failed to read meta data from android market channel.");
        }
        HMSLog.m1379i("UpdateManager", "In getAndroidMarketSetting, configuration not found for android channel market setting.");
        return true;
    }

    public static Intent getStartUpdateIntent(Context context, UpdateBean updateBean) {
        if (context == null || updateBean == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(updateBean.getClientAppName())) {
            m1384a(context, (ArrayList<Integer>) arrayList);
        } else {
            m1387b(context, arrayList);
        }
        int i = -2;
        if (arrayList.size() > 0) {
            i = ((Integer) arrayList.get(0)).intValue();
        } else {
            HMSLog.m1379i("UpdateManager", "typeList is empty, no upgrade solution");
        }
        updateBean.setTypeList(arrayList);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(context, C0660n.m343a(i));
        intentStartBridgeActivity.putExtra(BridgeActivity.EXTRA_DELEGATE_UPDATE_INFO, updateBean);
        return intentStartBridgeActivity;
    }
}
