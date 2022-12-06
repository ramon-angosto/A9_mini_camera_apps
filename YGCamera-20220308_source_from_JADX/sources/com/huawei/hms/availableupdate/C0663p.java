package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p024ui.UpdateBean;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* renamed from: com.huawei.hms.availableupdate.p */
/* compiled from: AppTouchWizard */
public class C0663p extends C0660n {
    /* renamed from: a */
    public void mo13255a(C0661o oVar) {
        HMSLog.m1379i("AppTouchWizard", "Enter onCancel.");
        if (oVar instanceof C0676y) {
            mo13298d();
        }
    }

    /* renamed from: b */
    public void mo13258b(C0661o oVar) {
        HMSLog.m1379i("AppTouchWizard", "Enter onDoWork.");
        if (oVar instanceof C0676y) {
            oVar.mo13290b();
            if (!mo13297c()) {
                mo13280a(8, this.f403f);
            }
        }
    }

    /* renamed from: c */
    public final boolean mo13297c() {
        Activity b = mo13285b();
        if (b == null || b.isFinishing() || TextUtils.isEmpty(this.f404g)) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.appmarket.intent.action.AppDetail");
            intent.putExtra("APP_PACKAGENAME", this.f404g);
            mo13296a(intent);
            b.startActivityForResult(intent, getRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            HMSLog.m1377e("AppTouchWizard", "can not open AppTouch detail page");
            return false;
        }
    }

    /* renamed from: d */
    public void mo13298d() {
        mo13287c(13, this.f403f);
    }

    public int getRequestCode() {
        return 2007;
    }

    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        UpdateBean updateBean = this.f400c;
        if (updateBean != null) {
            this.f403f = 7;
            if (updateBean.isNeedConfirm() && !TextUtils.isEmpty(this.f405h)) {
                mo13242a((Class<? extends C0661o>) C0676y.class);
            } else if (!mo13297c()) {
                mo13280a(8, this.f403f);
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
        if (this.f403f != 7 || i != getRequestCode()) {
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
            HMSLog.m1379i("AppTouchWizard", "In onKeyUp, Call finish.");
            Activity b = mo13285b();
            if (b != null && !b.isFinishing()) {
                b.setResult(0, (Intent) null);
                b.finish();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13296a(android.content.Intent r4) {
        /*
            r3 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.apptouch.intent.action.update_hms"
            r0.<init>(r1)
            android.app.Activity r1 = r3.mo13285b()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = 0
            java.util.List r0 = r1.queryIntentServices(r0, r2)
            if (r0 == 0) goto L_0x0039
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0039
            java.util.Iterator r0 = r0.iterator()
        L_0x0020:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r0.next()
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            android.content.pm.ServiceInfo r1 = r1.serviceInfo
            if (r1 == 0) goto L_0x0020
            java.lang.String r1 = r1.packageName
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0020
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0043
            r4.setPackage(r1)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.availableupdate.C0663p.mo13296a(android.content.Intent):void");
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
            HMSLog.m1377e("AppTouchWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        }
    }
}
