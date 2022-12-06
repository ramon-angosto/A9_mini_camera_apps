package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p024ui.UpdateBean;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.availableupdate.x */
/* compiled from: HiappWizard */
public class C0675x extends C0660n {
    /* renamed from: a */
    public void mo13255a(C0661o oVar) {
        HMSLog.m1379i("HiappWizard", "Enter onCancel.");
        if (oVar instanceof C0676y) {
            mo13309d();
        }
    }

    /* renamed from: b */
    public void mo13258b(C0661o oVar) {
        HMSLog.m1379i("HiappWizard", "Enter onDoWork.");
        if (oVar instanceof C0676y) {
            oVar.mo13290b();
            if (mo13308c()) {
                return;
            }
            if (!mo13284a(false)) {
                mo13287c(8, this.f403f);
            } else {
                mo13280a(8, this.f403f);
            }
        }
    }

    /* renamed from: c */
    public final boolean mo13308c() {
        Activity b = mo13285b();
        if (b == null || b.isFinishing() || TextUtils.isEmpty(this.f404g)) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.appmarket.intent.action.AppDetail");
            intent.putExtra("APP_PACKAGENAME", this.f404g);
            if (SystemUtils.isTVDevice()) {
                int packageVersionCode = new PackageManagerHelper(b).getPackageVersionCode("com.hisilicon.android.hiRMService");
                HMSLog.m1379i("HiappWizard", "version " + packageVersionCode);
                if (packageVersionCode == 1) {
                    HMSLog.m1379i("HiappWizard", "startActivity");
                    intent.addFlags(268435456);
                    mo13307a(intent);
                    b.startActivity(intent);
                    return true;
                }
            }
            HMSLog.m1379i("HiappWizard", "startActivityForResult");
            mo13307a(intent);
            b.startActivityForResult(intent, getRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            HMSLog.m1377e("HiappWizard", "can not open hiapp");
            return false;
        }
    }

    /* renamed from: d */
    public void mo13309d() {
        mo13287c(13, this.f403f);
    }

    public int getRequestCode() {
        return 2005;
    }

    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        UpdateBean updateBean = this.f400c;
        if (updateBean != null) {
            this.f403f = 5;
            if (updateBean.isNeedConfirm() && !TextUtils.isEmpty(this.f405h)) {
                mo13242a((Class<? extends C0661o>) C0676y.class);
            } else if (mo13308c()) {
            } else {
                if (!mo13284a(false)) {
                    mo13287c(8, this.f403f);
                } else {
                    mo13280a(8, this.f403f);
                }
            }
        }
    }

    public void onBridgeActivityDestroy() {
        super.onBridgeActivityDestroy();
    }

    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        if (this.f402e && (iBridgeActivityDelegate = this.f399b) != null) {
            return iBridgeActivityDelegate.onBridgeActivityResult(i, i2, intent);
        }
        if (this.f403f != 5 || i != getRequestCode()) {
            return false;
        }
        if (mo13283a(this.f404g, this.f406i)) {
            mo13287c(0, this.f403f);
            return true;
        }
        mo13287c(8, this.f403f);
        return true;
    }

    public void onBridgeConfigurationChanged() {
        super.onBridgeConfigurationChanged();
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        if (this.f402e && (iBridgeActivityDelegate = this.f399b) != null) {
            iBridgeActivityDelegate.onKeyUp(i, keyEvent);
        } else if (4 == i) {
            HMSLog.m1379i("HiappWizard", "In onKeyUp, Call finish.");
            Activity b = mo13285b();
            if (b != null && !b.isFinishing()) {
                b.setResult(0, (Intent) null);
                b.finish();
            }
        }
    }

    /* renamed from: a */
    public final void mo13307a(Intent intent) {
        List<ResolveInfo> queryIntentActivities = mo13285b().getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(PackageConstants.SERVICES_PACKAGE_APPMARKET_TV);
            arrayList.add(PackageConstants.SERVICES_PACKAGE_APPMARKET_CAR);
            arrayList.add(PackageConstants.SERVICES_PACKAGE_APPMARKET);
            if (queryIntentActivities.size() != 1) {
                for (ResolveInfo next : queryIntentActivities) {
                    if (arrayList.contains(next.activityInfo.packageName)) {
                        intent.setPackage(next.activityInfo.packageName);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo13242a(Class<? extends C0661o> cls) {
        mo13279a();
        try {
            C0661o oVar = (C0661o) cls.newInstance();
            if (!TextUtils.isEmpty(this.f405h) && (oVar instanceof C0676y)) {
                this.f405h = ResourceLoaderUtil.getString("hms_update_title");
                ((C0676y) oVar).mo13310a(this.f405h);
            }
            oVar.mo13289a((C0660n) this);
            this.f401d = oVar;
        } catch (IllegalAccessException | IllegalStateException | InstantiationException e) {
            HMSLog.m1377e("HiappWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        }
    }
}
