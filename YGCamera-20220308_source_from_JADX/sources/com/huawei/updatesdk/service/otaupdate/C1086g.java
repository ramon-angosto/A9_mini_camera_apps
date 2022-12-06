package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0976a;
import com.huawei.updatesdk.p025a.p026a.p031d.p033i.C0984a;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import com.huawei.updatesdk.p039b.p043b.C1003a;
import com.huawei.updatesdk.p039b.p044c.C1008b;
import com.huawei.updatesdk.p039b.p048g.C1033b;
import com.huawei.updatesdk.p039b.p048g.C1034c;
import com.huawei.updatesdk.p039b.p049h.C1041c;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import java.util.List;

/* renamed from: com.huawei.updatesdk.service.otaupdate.g */
public final class C1086g {
    /* renamed from: a */
    public static void m2116a() {
        Log.i("UpdateSdk", "UpdateSDK releaseCallBack");
        C1083d.m2090a().mo15191a((CheckUpdateCallBack) null);
        List<AsyncTask> a = C1033b.m1946a();
        if (a != null && !a.isEmpty()) {
            for (AsyncTask next : a) {
                if (next != null) {
                    next.cancel(true);
                }
                Log.d("UpdateSdk", "cancel task");
            }
            a.clear();
        }
    }

    /* renamed from: a */
    private static void m2117a(Context context) {
        C0985a.m1756a(context);
        Log.i("updatesdk", "UpdateSDK version is: 3.0.1.300 ,flavor: envrelease ,pkgName: " + context.getPackageName());
        if (C1008b.m1856a().mo14973b() == 3) {
            C0976a.m1713b(context);
        }
    }

    /* renamed from: a */
    public static void m2118a(Context context, ApkUpgradeInfo apkUpgradeInfo, AppInfoAdapter appInfoAdapter) {
        if (appInfoAdapter != null && !TextUtils.isEmpty(appInfoAdapter.getAppStorePkgName()) && !TextUtils.equals(C1085f.m2106f().mo15205c(), appInfoAdapter.getAppStorePkgName())) {
            C1085f.m2106f().mo15207d(appInfoAdapter.getAppStorePkgName());
        }
        if (appInfoAdapter != null && !TextUtils.isEmpty(appInfoAdapter.getAppStorePkgName())) {
            C1085f.m2106f().mo15206c(appInfoAdapter.getBusiness());
        }
        m2120a(context, apkUpgradeInfo, appInfoAdapter != null && appInfoAdapter.isMustBtnOne(), true);
    }

    /* renamed from: a */
    public static void m2119a(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z) {
        m2120a(context, apkUpgradeInfo, z, false);
    }

    /* renamed from: a */
    private static void m2120a(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z, boolean z2) {
        StringBuilder sb;
        String str;
        if (context != null && apkUpgradeInfo != null) {
            Intent intent = new Intent(context, AppUpdateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("app_update_parm", apkUpgradeInfo);
            bundle.putBoolean("app_must_btn", z);
            bundle.putBoolean("is_apptouch", z2);
            intent.putExtras(bundle);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                sb = new StringBuilder();
                sb.append("go AppUpdateActivity error: ");
                str = e.toString();
            } catch (SecurityException e2) {
                sb = new StringBuilder();
                sb.append("go AppUpdateActivity security error: ");
                str = e2.toString();
            }
        } else {
            return;
        }
        sb.append(str);
        Log.e("UpdateSdk", sb.toString());
    }

    /* renamed from: a */
    public static void m2121a(Context context, CheckUpdateCallBack checkUpdateCallBack, AppInfoAdapter appInfoAdapter) {
        if (context != null) {
            UpdateParams.Builder builder = new UpdateParams.Builder();
            String str = null;
            if (appInfoAdapter != null && !TextUtils.isEmpty(appInfoAdapter.getAppStorePkgName())) {
                str = appInfoAdapter.getBusiness();
            }
            C1085f.m2106f().mo15206c(str);
            if (appInfoAdapter != null) {
                if (!TextUtils.isEmpty(appInfoAdapter.getServiceZone())) {
                    builder.setServiceZone(appInfoAdapter.getServiceZone());
                }
                m2127a(appInfoAdapter.getAppStorePkgName());
                builder.setTargetPkgName(appInfoAdapter.getTargetPkgName()).setPackageList(appInfoAdapter.getPackageList()).setMustBtnOne(appInfoAdapter.isMustBtnOne()).setIsShowImmediate(appInfoAdapter.isShowImmediate()).setMinIntervalDay(appInfoAdapter.getMinIntervalDay());
            }
            UpdateParams build = builder.build();
            build.resetParamList();
            m2125a(context, build, checkUpdateCallBack, !TextUtils.isEmpty(str));
        }
    }

    /* renamed from: a */
    public static void m2122a(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z, int i, boolean z2) {
        if (context != null && C0984a.m1755d(context)) {
            m2117a(context);
            long currentTimeMillis = System.currentTimeMillis();
            long b = C1003a.m1831d().mo14959b();
            if (i == 0 || Math.abs(currentTimeMillis - b) >= ((long) i) * 86400000) {
                C1003a.m1831d().mo14956a(currentTimeMillis);
                C1084e eVar = new C1084e(context, new UpdateParams.Builder().setIsShowImmediate(z).setMustBtnOne(z2).setMinIntervalDay(i).build(), checkUpdateCallBack);
                eVar.mo15196b(true);
                eVar.executeOnExecutor(C1034c.f1395b, new Void[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m2123a(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z, boolean z2) {
        if (context != null) {
            if (C0984a.m1755d(context)) {
                m2117a(context);
                new C1084e(context, new UpdateParams.Builder().setIsShowImmediate(z).setMustBtnOne(z2).build(), checkUpdateCallBack).executeOnExecutor(C1034c.f1395b, new Void[0]);
                return;
            }
            if (checkUpdateCallBack != null) {
                Intent intent = new Intent();
                intent.putExtra("status", 2);
                checkUpdateCallBack.onUpdateInfo(intent);
            }
            Toast.makeText(context, C1041c.m1970c(context, "upsdk_no_available_network_prompt_toast"), 0).show();
        }
    }

    /* renamed from: a */
    public static void m2124a(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        if (context != null && updateParams != null && checkUpdateCallBack != null) {
            m2117a(context);
            updateParams.resetParamList();
            m2128b(context, updateParams, checkUpdateCallBack);
        }
    }

    /* renamed from: a */
    private static void m2125a(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack, boolean z) {
        if (context != null && updateParams != null && checkUpdateCallBack != null) {
            m2117a(context);
            long currentTimeMillis = System.currentTimeMillis();
            long b = C1003a.m1831d().mo14959b();
            if (updateParams.getMinIntervalDay() != 0 && Math.abs(currentTimeMillis - b) < ((long) updateParams.getMinIntervalDay()) * 86400000) {
                return;
            }
            if (C0984a.m1755d(context)) {
                C1003a.m1831d().mo14956a(currentTimeMillis);
                C1084e eVar = new C1084e(context, updateParams, checkUpdateCallBack);
                eVar.mo15195a(z);
                eVar.executeOnExecutor(C1034c.f1395b, new Void[0]);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("status", 2);
            checkUpdateCallBack.onUpdateInfo(intent);
        }
    }

    /* renamed from: a */
    public static void m2126a(Context context, String str, CheckUpdateCallBack checkUpdateCallBack) {
        if (context == null || TextUtils.isEmpty(str) || checkUpdateCallBack == null) {
            if (checkUpdateCallBack != null) {
                Intent intent = new Intent();
                intent.putExtra("status", 1);
                checkUpdateCallBack.onUpdateInfo(intent);
            }
        } else if (C0984a.m1755d(context)) {
            m2117a(context);
            new C1084e(context, new UpdateParams.Builder().setMustBtnOne(false).setTargetPkgName(str).build(), checkUpdateCallBack).executeOnExecutor(C1034c.f1395b, new Void[0]);
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra("status", 2);
            checkUpdateCallBack.onUpdateInfo(intent2);
        }
    }

    /* renamed from: a */
    public static void m2127a(String str) {
        C1085f.m2106f().mo15207d(str);
    }

    /* renamed from: b */
    public static void m2128b(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        m2125a(context, updateParams, checkUpdateCallBack, false);
    }

    /* renamed from: b */
    public static void m2129b(String str) {
        C1085f.m2106f().mo15204b(str);
    }
}
