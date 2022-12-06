package com.huawei.hms.adapter.p012ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.p024ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.adapter.ui.UpdateAdapter */
public class UpdateAdapter implements IBridgeActivityDelegate {

    /* renamed from: a */
    public WeakReference<Activity> f261a;

    /* renamed from: b */
    public int f262b;

    /* renamed from: c */
    public UpdateBean f263c;

    /* renamed from: d */
    public String f264d;

    /* renamed from: a */
    public final void mo13071a() {
        Activity b = mo13073b();
        if (b != null && !b.isFinishing()) {
            b.finish();
        }
    }

    /* renamed from: b */
    public final Activity mo13073b() {
        WeakReference<Activity> weakReference = this.f261a;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    /* renamed from: c */
    public final void mo13074c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        mo13071a();
    }

    public int getRequestCode() {
        return 1001;
    }

    public void onBridgeActivityCreate(Activity activity) {
        this.f261a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            mo13074c();
            return;
        }
        this.f262b = intent.getIntExtra(CommonCode.MapKey.UPDATE_VERSION, 0);
        if (this.f262b == 0) {
            mo13074c();
        } else if (intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
            HMSLog.m1379i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
            String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
            ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
            Intent intent2 = new Intent();
            intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
            intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
            intent2.setComponent(componentName);
            activity.startActivityForResult(intent2, 1001);
        } else {
            this.f264d = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
            UpdateBean updateBean = new UpdateBean();
            updateBean.setHmsOrApkUpgrade(true);
            HMSLog.m1379i("UpdateAdapter", "target HMS Core packageName is " + this.f264d);
            updateBean.setClientPackageName(this.f264d);
            updateBean.setClientVersionCode(this.f262b);
            updateBean.setClientAppId("C10132067");
            if (ResourceLoaderUtil.getmContext() == null && activity != null) {
                ResourceLoaderUtil.setmContext(activity.getApplicationContext());
            }
            updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
            this.f263c = updateBean;
            HMSLog.m1379i("UpdateAdapter", "old framework HMSCore upgrade process");
            UpdateManager.startUpdate(activity, 1001, updateBean);
            this.f263c = null;
        }
    }

    public void onBridgeActivityDestroy() {
        HMSLog.m1379i("UpdateAdapter", "onBridgeActivityDestroy");
        this.f261a = null;
    }

    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            this.f263c = null;
            return false;
        }
        HMSLog.m1379i("UpdateAdapter", "onBridgeActivityResult");
        if (i2 == 1214) {
            HMSLog.m1379i("UpdateAdapter", "Enter update escape route");
            Activity b = mo13073b();
            if (b == null) {
                HMSLog.m1377e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.f263c = null;
                return true;
            }
            UpdateManager.startUpdate(b, 1001, this.f263c);
            this.f263c = null;
        }
        if (i2 == -1) {
            if (intent != null) {
                if (intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0) == 1) {
                    HMSLog.m1379i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.f263c = null;
                    mo13071a();
                    return true;
                }
                int intExtra = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
                if (intExtra == 0) {
                    HMSLog.m1379i("UpdateAdapter", "Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                } else if (intExtra == 13) {
                    HMSLog.m1379i("UpdateAdapter", "Resolve error process canceled by user!");
                    SystemManager.getInstance().notifyUpdateResult(13);
                } else if (intExtra == 8) {
                    HMSLog.m1379i("UpdateAdapter", "Internal error occurred, recommended retry.");
                    SystemManager.getInstance().notifyUpdateResult(8);
                } else {
                    HMSLog.m1379i("UpdateAdapter", "Other error codes.");
                    SystemManager.getInstance().notifyUpdateResult(intExtra);
                }
            }
        } else if (i2 == 0) {
            HMSLog.m1379i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.f263c = null;
            Activity b2 = mo13073b();
            if (b2 == null) {
                return true;
            }
            if (mo13072a(b2, HMSPackageManager.getInstance(b2.getApplicationContext()).getHMSPackageName(), this.f262b)) {
                HMSLog.m1379i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            } else {
                SystemManager.getInstance().notifyUpdateResult(0);
            }
        } else if (i2 == 1) {
            SystemManager.getInstance().notifyUpdateResult(28);
        }
        mo13071a();
        return true;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.m1379i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m1379i("UpdateAdapter", "On key up when resolve conn error");
    }

    /* renamed from: a */
    public final boolean mo13072a(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str) || i == 0) {
            return false;
        }
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) && packageManagerHelper.getPackageVersionCode(str) >= i) {
            return false;
        }
        return true;
    }
}
