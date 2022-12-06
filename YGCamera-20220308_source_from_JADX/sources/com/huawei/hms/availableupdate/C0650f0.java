package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import java.io.File;
import java.io.Serializable;

/* renamed from: com.huawei.hms.availableupdate.f0 */
/* compiled from: UpdateWizard */
public class C0650f0 extends C0660n implements C0649f {

    /* renamed from: j */
    public C0645e f380j;

    /* renamed from: k */
    public C0653g f381k;

    /* renamed from: l */
    public int f382l = 0;

    /* renamed from: com.huawei.hms.availableupdate.f0$a */
    /* compiled from: UpdateWizard */
    public static class C0651a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C0649f f383a;

        /* renamed from: b */
        public final /* synthetic */ int f384b;

        /* renamed from: c */
        public final /* synthetic */ C0653g f385c;

        public C0651a(C0649f fVar, int i, C0653g gVar) {
            this.f383a = fVar;
            this.f384b = i;
            this.f385c = gVar;
        }

        public void run() {
            this.f383a.mo13231a(this.f384b, this.f385c);
        }
    }

    /* renamed from: com.huawei.hms.availableupdate.f0$b */
    /* compiled from: UpdateWizard */
    public class C0652b implements CheckUpdateCallBack {

        /* renamed from: a */
        public final /* synthetic */ C0649f f386a;

        public C0652b(C0649f fVar) {
            this.f386a = fVar;
        }

        public void onMarketInstallInfo(Intent intent) {
        }

        public void onMarketStoreError(int i) {
            HMSLog.m1377e("UpdateWizard", "onMarketStoreError responseCode: " + i);
        }

        public void onUpdateInfo(Intent intent) {
            if (intent != null) {
                C0650f0.this.mo13253a(intent, this.f386a);
            }
        }

        public void onUpdateStoreError(int i) {
            HMSLog.m1377e("UpdateWizard", "onUpdateStoreError responseCode: " + i);
        }
    }

    /* renamed from: b */
    public void mo13258b(C0661o oVar) {
        HMSLog.m1379i("UpdateWizard", "Enter onDoWork.");
        if (oVar instanceof C0676y) {
            oVar.mo13290b();
            mo13242a((Class<? extends C0661o>) C0664q.class);
            mo13254a((C0649f) this);
        } else if (oVar instanceof C0671v) {
            oVar.mo13290b();
            mo13263g();
        } else if (oVar instanceof C0670u) {
            mo13242a((Class<? extends C0661o>) C0672w.class);
            mo13262f();
        } else if (oVar instanceof C0669t) {
            mo13242a((Class<? extends C0661o>) C0672w.class);
            mo13262f();
        } else if (oVar instanceof C0635b0) {
            mo13261e();
        } else if (oVar instanceof C0641c0) {
            mo13261e();
        } else if (oVar instanceof C0644d0) {
            mo13261e();
        }
    }

    /* renamed from: c */
    public final void mo13259c() {
        C0645e eVar = this.f380j;
        if (eVar != null) {
            eVar.mo13228a();
            this.f380j = null;
        }
    }

    /* renamed from: d */
    public final void mo13260d() {
        Activity b = mo13285b();
        String netType = b != null ? SystemUtils.getNetType(b.getBaseContext()) : "";
        HMSLog.m1379i("UpdateWizard", "current network is " + netType);
        if ("WIFI".equals(netType)) {
            mo13242a((Class<? extends C0661o>) C0672w.class);
            mo13262f();
            HMSLog.m1379i("UpdateWizard", "current network is wifi");
            return;
        }
        mo13242a((Class<? extends C0661o>) C0669t.class);
        HMSLog.m1379i("UpdateWizard", "current network is not wifi");
    }

    /* renamed from: e */
    public final void mo13261e() {
        if (!mo13284a(false)) {
            mo13287c(8, this.f403f);
        } else {
            mo13280a(8, this.f403f);
        }
    }

    /* renamed from: f */
    public final void mo13262f() {
        Activity b = mo13285b();
        if (b == null || b.isFinishing()) {
            mo13242a((Class<? extends C0661o>) C0641c0.class);
        } else if (mo13257a(b)) {
            mo13259c();
            this.f380j = new C0636c(new C0642d(b));
            this.f380j.mo13229a(this, this.f381k);
        }
    }

    /* renamed from: g */
    public void mo13263g() {
        mo13287c(13, this.f403f);
    }

    public int getRequestCode() {
        return 2006;
    }

    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        if (this.f400c != null) {
            this.f403f = 6;
            if (mo13257a(activity)) {
                if (!this.f400c.isNeedConfirm() || TextUtils.isEmpty(this.f405h)) {
                    mo13242a((Class<? extends C0661o>) C0664q.class);
                    mo13254a((C0649f) this);
                    return;
                }
                mo13242a((Class<? extends C0661o>) C0676y.class);
            }
        }
    }

    public void onBridgeActivityDestroy() {
        mo13259c();
        super.onBridgeActivityDestroy();
    }

    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        if (this.f402e && (iBridgeActivityDelegate = this.f399b) != null) {
            return iBridgeActivityDelegate.onBridgeActivityResult(i, i2, intent);
        }
        if (this.f403f != 6 || i != getRequestCode()) {
            return false;
        }
        if (mo13283a(this.f404g, this.f406i)) {
            mo13287c(0, this.f403f);
            return true;
        }
        mo13261e();
        return true;
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        if (this.f402e && (iBridgeActivityDelegate = this.f399b) != null) {
            iBridgeActivityDelegate.onKeyUp(i, keyEvent);
        } else if (4 == i) {
            HMSLog.m1379i("UpdateWizard", "In onKeyUp, Call finish.");
            Activity b = mo13285b();
            if (b != null && !b.isFinishing()) {
                b.setResult(0, (Intent) null);
                b.finish();
            }
        }
    }

    /* renamed from: a */
    public static Uri m309a(Context context, File file) {
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        String packageName = context.getPackageName();
        String str = packageName + UpdateProvider.AUTHORITIES_SUFFIX;
        if (Build.VERSION.SDK_INT > 23 && (context.getApplicationInfo().targetSdkVersion > 23 || packageManagerHelper.hasProvider(packageName, str))) {
            return UpdateProvider.getUriForFile(context, str, file);
        }
        return Uri.fromFile(file);
    }

    /* renamed from: a */
    public static void m311a(C0649f fVar, int i, C0653g gVar) {
        if (fVar != null) {
            new Handler(Looper.getMainLooper()).post(new C0651a(fVar, i, gVar));
        }
    }

    /* renamed from: a */
    public final boolean mo13257a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).isApkUpdateNecessary(this.f400c.mo14629c())) {
            return true;
        }
        mo13279a();
        SystemManager.getInstance().notifyUpdateResult(0);
        return false;
    }

    /* renamed from: a */
    public void mo13231a(int i, C0653g gVar) {
        HMSLog.m1379i("UpdateWizard", "Enter onCheckUpdate, status: " + C0654h.m327a(i));
        if (i != 1000) {
            switch (i) {
                case 1201:
                case 1202:
                case 1203:
                    mo13242a((Class<? extends C0661o>) C0635b0.class);
                    return;
                default:
                    mo13242a((Class<? extends C0661o>) C0635b0.class);
                    return;
            }
        } else {
            this.f381k = gVar;
            mo13260d();
        }
    }

    /* renamed from: a */
    public void mo13230a(int i, int i2, int i3, File file) {
        HMSLog.m1379i("UpdateWizard", "Enter onDownloadPackage, status: " + C0654h.m327a(i) + ", reveived: " + i2 + ", total: " + i3);
        if (i == 2000) {
            mo13279a();
            if (file == null) {
                mo13261e();
            } else if (FileUtil.verifyHash(this.f381k.f392e, file)) {
                mo13256a(file);
            } else {
                HMSLog.m1379i("UpdateWizard", "Hash value mismatch for download file");
            }
        } else if (i == 2100) {
            C0661o oVar = this.f401d;
            if (oVar != null && (oVar instanceof C0672w)) {
                int i4 = 0;
                if (i2 >= 0 && i3 > 0) {
                    i4 = (int) ((((long) i2) * 100) / ((long) i3));
                }
                this.f382l = i4;
                ((C0672w) this.f401d).mo13305b(i4);
            }
        } else if (i != 2101) {
            switch (i) {
                case 2201:
                    mo13242a((Class<? extends C0661o>) C0641c0.class);
                    return;
                case 2202:
                    mo13242a((Class<? extends C0661o>) C0670u.class);
                    return;
                case 2203:
                case 2204:
                    mo13242a((Class<? extends C0661o>) C0644d0.class);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public final void mo13256a(File file) {
        Activity b = mo13285b();
        if (b != null && !b.isFinishing()) {
            Uri a = m309a((Context) b, file);
            if (a == null) {
                HMSLog.m1377e("UpdateWizard", "In startInstaller, Failed to creates a Uri from a file.");
                mo13261e();
            } else if (mo13257a(b)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(a, "application/vnd.android.package-archive");
                intent.setFlags(3);
                intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                try {
                    b.startActivityForResult(intent, getRequestCode());
                } catch (ActivityNotFoundException e) {
                    HMSLog.m1377e("UpdateWizard", "In startInstaller, Failed to start package installer." + e.getMessage());
                    mo13261e();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo13255a(C0661o oVar) {
        HMSLog.m1379i("UpdateWizard", "Enter onCancel.");
        if (oVar instanceof C0676y) {
            mo13263g();
        } else if (oVar instanceof C0664q) {
            mo13259c();
            mo13263g();
        } else if (oVar instanceof C0672w) {
            mo13259c();
            mo13242a((Class<? extends C0661o>) C0671v.class);
        } else if (oVar instanceof C0671v) {
            mo13242a((Class<? extends C0661o>) C0672w.class);
            mo13262f();
        } else if (oVar instanceof C0670u) {
            mo13263g();
        } else if (oVar instanceof C0669t) {
            mo13263g();
        } else {
            mo13261e();
        }
    }

    /* renamed from: a */
    public void mo13242a(Class<? extends C0661o> cls) {
        if (mo13257a(mo13285b())) {
            mo13279a();
            try {
                C0661o oVar = (C0661o) cls.newInstance();
                if (!TextUtils.isEmpty(this.f405h) && (oVar instanceof C0676y)) {
                    this.f405h = ResourceLoaderUtil.getString("hms_update_title");
                    ((C0676y) oVar).mo13310a(this.f405h);
                }
                if (this.f382l > 0 && (oVar instanceof C0672w)) {
                    ((C0672w) oVar).mo13304a(this.f382l);
                }
                oVar.mo13289a((C0660n) this);
                this.f401d = oVar;
            } catch (IllegalAccessException | IllegalStateException | InstantiationException e) {
                HMSLog.m1377e("UpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public final void mo13254a(C0649f fVar) {
        if (fVar != null) {
            Activity b = mo13285b();
            if (b == null || b.isFinishing()) {
                m311a(fVar, 1201, (C0653g) null);
            } else if (mo13257a(b)) {
                UpdateSdkAPI.checkTargetAppUpdate(b, this.f400c.mo14628b(), new C0652b(fVar));
            }
        }
    }

    /* renamed from: a */
    public final void mo13253a(Intent intent, C0649f fVar) {
        try {
            int intExtra = intent.getIntExtra("status", -99);
            HMSLog.m1379i("UpdateWizard", "CheckUpdateCallBack status is " + intExtra);
            String stringExtra = intent.getStringExtra(UpdateKey.FAIL_REASON);
            if (!TextUtils.isEmpty(stringExtra)) {
                HMSLog.m1377e("UpdateWizard", "checkTargetAppUpdate reason is " + stringExtra);
            }
            if (intExtra == 7) {
                Serializable serializableExtra = intent.getSerializableExtra(UpdateKey.INFO);
                if (serializableExtra instanceof ApkUpgradeInfo) {
                    ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) serializableExtra;
                    String package_ = apkUpgradeInfo.getPackage_();
                    int versionCode_ = apkUpgradeInfo.getVersionCode_();
                    String downurl_ = apkUpgradeInfo.getDownurl_();
                    int size_ = apkUpgradeInfo.getSize_();
                    String sha256_ = apkUpgradeInfo.getSha256_();
                    if (TextUtils.isEmpty(package_) || !package_.equals(this.f400c.mo14628b())) {
                        m311a(fVar, 1201, (C0653g) null);
                    } else if (versionCode_ < this.f400c.mo14629c()) {
                        HMSLog.m1377e("UpdateWizard", "CheckUpdateCallBack versionCode is " + versionCode_ + "bean.getClientVersionCode() is " + this.f400c.mo14629c());
                        m311a(fVar, 1203, (C0653g) null);
                    } else if (TextUtils.isEmpty(downurl_) || TextUtils.isEmpty(sha256_)) {
                        m311a(fVar, 1201, (C0653g) null);
                    } else {
                        m311a(fVar, 1000, new C0653g(package_, versionCode_, downurl_, size_, sha256_));
                    }
                }
            } else if (intExtra == 3) {
                m311a(fVar, 1202, (C0653g) null);
            } else {
                m311a(fVar, 1201, (C0653g) null);
            }
        } catch (Exception e) {
            HMSLog.m1377e("UpdateWizard", "intent has some error" + e.getMessage());
            m311a(fVar, 1201, (C0653g) null);
        }
    }
}
