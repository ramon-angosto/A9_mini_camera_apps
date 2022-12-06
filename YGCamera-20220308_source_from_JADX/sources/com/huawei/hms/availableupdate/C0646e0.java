package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.p023ui.SafeBundle;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.availableupdate.e0 */
/* compiled from: SilentUpdateWizard */
public class C0646e0 extends C0660n {

    /* renamed from: j */
    public BroadcastReceiver f374j;

    /* renamed from: k */
    public Handler f375k = new Handler();

    /* renamed from: l */
    public int f376l = 0;

    /* renamed from: m */
    public Handler f377m = new C0647a();

    /* renamed from: com.huawei.hms.availableupdate.e0$a */
    /* compiled from: SilentUpdateWizard */
    public class C0647a extends Handler {
        public C0647a() {
        }

        public void handleMessage(Message message) {
            SafeBundle safeBundle = new SafeBundle((Bundle) message.obj);
            switch (message.what) {
                case 101:
                    C0646e0.this.mo13241a(safeBundle);
                    return;
                case 102:
                    C0646e0.this.mo13245b(safeBundle);
                    return;
                case 103:
                    C0646e0.this.mo13248c(safeBundle);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.huawei.hms.availableupdate.e0$b */
    /* compiled from: SilentUpdateWizard */
    public class C0648b implements Runnable {
        public C0648b() {
        }

        public void run() {
            C0646e0.this.mo13247c(14);
        }

        public /* synthetic */ C0648b(C0646e0 e0Var, C0647a aVar) {
            this();
        }
    }

    /* renamed from: d */
    public final void mo13249d() {
        BroadcastReceiver broadcastReceiver;
        Activity b = mo13285b();
        if (b != null && (broadcastReceiver = this.f374j) != null) {
            b.unregisterReceiver(broadcastReceiver);
            this.f374j = null;
        }
    }

    /* renamed from: e */
    public void mo13250e() {
        mo13287c(13, this.f403f);
    }

    public int getRequestCode() {
        return Constants.ASSEMBLE_PUSH_RETRY_INTERVAL;
    }

    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        if (this.f400c != null) {
            this.f403f = 0;
            if (mo13243a(activity)) {
                return;
            }
            if (!mo13284a(true)) {
                mo13287c(8, this.f403f);
            } else {
                mo13280a(8, this.f403f);
            }
        }
    }

    public void onBridgeActivityDestroy() {
        this.f375k.removeCallbacksAndMessages((Object) null);
        mo13249d();
        super.onBridgeActivityDestroy();
    }

    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        if (this.f402e && (iBridgeActivityDelegate = this.f399b) != null) {
            return iBridgeActivityDelegate.onBridgeActivityResult(i, i2, intent);
        }
        HMSLog.m1379i("SilentUpdateWizard", "onBridgeActivityResult requestCode is " + i + "resultCode is " + i2);
        if (i != getRequestCode()) {
            return false;
        }
        if (i2 == 0) {
            mo13246c();
            mo13244b(20000);
            return true;
        } else if (i2 == 4) {
            mo13250e();
            return true;
        } else {
            if (!mo13284a(true)) {
                mo13287c(i2, this.f403f);
            } else {
                mo13280a(i2, this.f403f);
            }
            return true;
        }
    }

    public void onBridgeConfigurationChanged() {
        super.onBridgeConfigurationChanged();
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
        super.onKeyUp(i, keyEvent);
    }

    /* renamed from: b */
    public final void mo13244b(int i) {
        this.f375k.removeCallbacksAndMessages((Object) null);
        this.f375k.postDelayed(new C0648b(this, (C0647a) null), (long) i);
    }

    /* renamed from: c */
    public final void mo13246c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.progress.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.installerservice.Receiver");
        this.f374j = new C0659m(this.f377m);
        Activity b = mo13285b();
        if (b != null) {
            b.registerReceiver(this.f374j, intentFilter);
        }
    }

    /* renamed from: a */
    public final boolean mo13243a(Activity activity) {
        if (TextUtils.isEmpty(this.f404g)) {
            return false;
        }
        Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        intent.setPackage(PackageConstants.SERVICES_PACKAGE_APPMARKET);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pkgName", this.f404g);
            jSONObject.put("versioncode", this.f406i);
            jSONArray.put(jSONObject);
            intent.putExtra("params", jSONArray.toString());
            intent.putExtra("isHmsOrApkUpgrade", this.f400c.mo14630d());
            intent.putExtra("buttonDlgY", ResourceLoaderUtil.getString("hms_install"));
            intent.putExtra("buttonDlgN", ResourceLoaderUtil.getString("hms_cancel"));
            intent.putExtra("upgradeDlgContent", ResourceLoaderUtil.getString("hms_update_message_new", "%P"));
            try {
                HMSLog.m1379i("SilentUpdateWizard", "start silent activity of AppMarket");
                activity.startActivityForResult(intent, getRequestCode());
                HMSLog.m1379i("SilentUpdateWizard", "start silent activity finished");
                return true;
            } catch (ActivityNotFoundException unused) {
                HMSLog.m1377e("SilentUpdateWizard", "ActivityNotFoundException");
                return false;
            }
        } catch (JSONException e) {
            HMSLog.m1377e("SilentUpdateWizard", "create hmsJsonObject fail" + e.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public final void mo13245b(SafeBundle safeBundle) {
        String string = safeBundle.containsKey("UpgradePkgName") ? safeBundle.getString("UpgradePkgName") : null;
        if (string != null && string.equals(this.f404g) && safeBundle.containsKey("UpgradeDownloadProgress") && safeBundle.containsKey("UpgradeAppName")) {
            int i = safeBundle.getInt("UpgradeDownloadProgress");
            HMSLog.m1379i("SilentUpdateWizard", "handlerDownloadProgress-progress is " + i);
            mo13244b(20000);
            if (i >= 99) {
                i = 99;
            }
            this.f376l = i;
            if (this.f401d == null) {
                mo13242a((Class<? extends C0661o>) C0672w.class);
            }
            C0661o oVar = this.f401d;
            if (oVar != null) {
                ((C0672w) oVar).mo13305b(i);
            }
        }
    }

    /* renamed from: c */
    public final void mo13247c(int i) {
        this.f375k.removeCallbacksAndMessages((Object) null);
        mo13249d();
        mo13279a();
        if (!mo13284a(false)) {
            mo13287c(i, this.f403f);
        } else {
            mo13280a(i, this.f403f);
        }
    }

    /* renamed from: c */
    public final void mo13248c(SafeBundle safeBundle) {
        if (safeBundle.containsKey("packagename") && safeBundle.containsKey("status")) {
            String string = safeBundle.getString("packagename");
            int i = safeBundle.getInt("status");
            HMSLog.m1379i("SilentUpdateWizard", "handlerInstallStatus-status is " + i);
            if (string != null && string.equals(this.f404g)) {
                if (i == 2) {
                    this.f375k.removeCallbacksAndMessages((Object) null);
                    C0661o oVar = this.f401d;
                    if (oVar != null) {
                        ((C0672w) oVar).mo13305b(100);
                    }
                    mo13287c(0, this.f403f);
                } else if (i == -1 || i == -2) {
                    mo13247c(i);
                } else {
                    mo13244b(60000);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo13241a(SafeBundle safeBundle) {
        String string = safeBundle.containsKey("UpgradePkgName") ? safeBundle.getString("UpgradePkgName") : null;
        if (string != null && string.equals(this.f404g) && safeBundle.containsKey("downloadtask.status")) {
            int i = safeBundle.getInt("downloadtask.status");
            HMSLog.m1379i("SilentUpdateWizard", "handleDownloadStatus-status is " + i);
            if (i == 3 || i == 5 || i == 6 || i == 8) {
                mo13247c(i);
            } else if (i == 4) {
                mo13244b(60000);
            } else {
                mo13244b(20000);
            }
        }
    }

    /* renamed from: a */
    public void mo13242a(Class<? extends C0661o> cls) {
        try {
            C0661o oVar = (C0661o) cls.newInstance();
            if (this.f376l > 0 && (oVar instanceof C0672w)) {
                ((C0672w) oVar).mo13304a(this.f376l);
            }
            oVar.mo13289a((C0660n) this);
            this.f401d = oVar;
        } catch (IllegalAccessException | IllegalStateException | InstantiationException e) {
            HMSLog.m1377e("SilentUpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        }
    }
}
