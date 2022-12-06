package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import com.huawei.updatesdk.p025a.p034b.p037c.C0989b;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0990a;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0993c;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d;
import com.huawei.updatesdk.p039b.p043b.C1003a;
import com.huawei.updatesdk.p039b.p046e.C1023a;
import com.huawei.updatesdk.p039b.p046e.C1027e;
import com.huawei.updatesdk.p039b.p048g.C1033b;
import com.huawei.updatesdk.p039b.p049h.C1037b;
import com.huawei.updatesdk.p039b.p049h.C1041c;
import com.huawei.updatesdk.p039b.p049h.C1042d;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.C1057d;
import com.huawei.updatesdk.service.appmgr.bean.C1059e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.updatesdk.service.otaupdate.e */
public class C1084e extends AsyncTask<Void, Void, C0994d> {

    /* renamed from: a */
    private Context f1474a;

    /* renamed from: b */
    private CheckUpdateCallBack f1475b;

    /* renamed from: c */
    private UpdateParams f1476c;

    /* renamed from: d */
    private Toast f1477d;

    /* renamed from: e */
    private boolean f1478e = false;

    /* renamed from: f */
    private List<String> f1479f = new ArrayList();

    /* renamed from: g */
    private C0989b f1480g;

    /* renamed from: h */
    private boolean f1481h = false;

    public C1084e(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        this.f1476c = updateParams;
        this.f1474a = context;
        this.f1475b = checkUpdateCallBack;
        C1085f.m2106f().mo15204b(updateParams.getServiceZone());
    }

    /* renamed from: a */
    private PackageInfo m2095a(Context context, String str) {
        PackageInfo a = C1037b.m1956a(str, context);
        if (a != null) {
            return a;
        }
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = str;
        packageInfo.versionName = "1.0";
        packageInfo.versionCode = 1;
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.targetSdkVersion = 19;
        packageInfo.applicationInfo = applicationInfo;
        return packageInfo;
    }

    /* renamed from: a */
    private C0994d m2096a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String a : list) {
            arrayList.add(m2095a(context, a));
        }
        C1057d dVar = !C1042d.m1975a((List) this.f1476c.getParamList()) ? new C1057d(this.f1476c.getParamList()) : C1057d.m2007a((List<PackageInfo>) arrayList);
        dVar.mo15145d(this.f1481h ? 34 : 0);
        dVar.mo15143b(0);
        dVar.mo15146d(C0981c.m1730b(context, C1027e.m1931a(this.f1481h ? "apptouch" : "default").mo14997b()));
        if (isCancelled()) {
            C0964a.m1668c("UpdateSDKCheckTask", "UpdateSDK task is canceled and return empty upgradeInfo");
            return null;
        }
        this.f1480g = new C0989b(dVar, (C0990a) null);
        return this.f1480g.mo14909c();
    }

    /* renamed from: a */
    private void m2097a() {
        Toast toast = this.f1477d;
        if (toast != null) {
            toast.cancel();
        }
    }

    /* renamed from: a */
    private void m2098a(Context context, ApkUpgradeInfo apkUpgradeInfo) {
        if (context != null) {
            Intent intent = new Intent(context, AppUpdateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("app_update_parm", apkUpgradeInfo);
            bundle.putBoolean("app_must_btn", this.f1476c.isMustBtnOne());
            bundle.putBoolean("is_apptouch", this.f1481h);
            intent.putExtras(bundle);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                C0968a.m1682b("UpdateSDKCheckTask", "go AppUpdateActivity error: " + e.toString());
            }
        }
    }

    /* renamed from: a */
    private void m2099a(List<ApkUpgradeInfo> list) {
        if (!C1042d.m1975a((List) list)) {
            for (ApkUpgradeInfo next : list) {
                if (next != null && !TextUtils.isEmpty(next.getFullDownUrl_())) {
                    if (next.getDiffSize_() > 0) {
                        next.setDiffDownUrl_(next.getDownurl_());
                    }
                    next.setDownurl_(next.getFullDownUrl_());
                }
            }
        }
    }

    /* renamed from: b */
    private void m2100b(C0994d dVar) {
        if (this.f1475b != null) {
            Intent intent = new Intent();
            intent.putExtra("status", 6);
            if (dVar.mo14927a() != null) {
                intent.putExtra(UpdateKey.FAIL_CODE, dVar.mo14927a().ordinal());
            }
            intent.putExtra(UpdateKey.FAIL_REASON, dVar.mo14933c());
            intent.putExtra(UpdateKey.RESPONSE_CODE, dVar.mo14931b());
            this.f1475b.onUpdateInfo(intent);
            this.f1475b.onUpdateStoreError(dVar.mo14934d());
        }
    }

    /* renamed from: b */
    private boolean m2101b() {
        return !this.f1478e && TextUtils.isEmpty(this.f1476c.getTargetPkgName()) && C1042d.m1975a((List) this.f1476c.getPackageList()) && C1042d.m1975a((List) this.f1476c.getParamList());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0994d doInBackground(Void... voidArr) {
        C0968a.m1680a("UpdateSDKCheckTask", "CheckOtaAndUpdataTask doInBackground");
        C1003a.m1831d().mo14963c();
        C1033b.m1947a(this);
        C1023a a = C1027e.m1931a(this.f1481h ? "apptouch" : "default");
        a.mo15000d();
        a.mo14999c();
        C0993c.m1790c(a.mo14998b(this.f1474a));
        String targetPkgName = this.f1476c.getTargetPkgName();
        if (TextUtils.isEmpty(targetPkgName)) {
            targetPkgName = this.f1474a.getPackageName();
        }
        if (!C1042d.m1975a((List) this.f1476c.getPackageList())) {
            this.f1479f.addAll(this.f1476c.getPackageList());
        } else if (!TextUtils.isEmpty(targetPkgName)) {
            this.f1479f.add(targetPkgName);
        }
        C1003a.m1831d().mo14965e(C1085f.m2106f().mo15201a());
        return m2096a(this.f1474a, this.f1479f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C0994d dVar) {
        C1033b.m1946a().remove(this);
        m2097a();
        if (this.f1475b == null) {
            C0964a.m1668c("UpdateSDKCheckTask", "UpdateSDK callback is null");
        }
        if (dVar != null) {
            int b = dVar.mo14931b();
            ArrayList<ApkUpgradeInfo> arrayList = null;
            if (dVar.mo14936f()) {
                C1059e eVar = (C1059e) dVar;
                arrayList = eVar.list;
                if (!C1042d.m1975a((List) eVar.notRcmList)) {
                    ApkUpgradeInfo apkUpgradeInfo = eVar.notRcmList.get(0);
                    C0964a.m1668c("UpdateSDKCheckTask", "UpdateSDK get update info is not recommend,reason: " + apkUpgradeInfo.getNotRcmReason_() + ",is same signature: " + apkUpgradeInfo.getSameS_());
                }
                m2099a((List<ApkUpgradeInfo>) arrayList);
                if (C1042d.m1975a((List) arrayList) && this.f1475b != null) {
                    C0964a.m1667b("UpdateSDKCheckTask", "no upgrade info");
                    Intent intent = new Intent();
                    intent.putExtra("status", 3);
                    intent.putExtra(UpdateKey.RESPONSE_CODE, b);
                    this.f1475b.onUpdateInfo(intent);
                }
            } else {
                m2100b(dVar);
                C0964a.m1666a("UpdateSDKCheckTask", "get app update msg failed,responseCode is " + dVar.mo14934d() + ",failreason: " + dVar.mo14933c());
            }
            if (!C1042d.m1975a((List) arrayList)) {
                ApkUpgradeInfo apkUpgradeInfo2 = arrayList.get(0);
                if (this.f1475b != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(UpdateKey.INFO, apkUpgradeInfo2);
                    intent2.putParcelableArrayListExtra(UpdateKey.INFO_LIST, arrayList);
                    intent2.putExtra("status", 7);
                    intent2.putExtra(UpdateKey.RESPONSE_CODE, b);
                    this.f1475b.onUpdateInfo(intent2);
                }
                if (apkUpgradeInfo2 != null) {
                    C0964a.m1667b("UpdateSDKCheckTask", "ApkUpgradeInfo,version = " + apkUpgradeInfo2.getVersion_() + ",versionCode = " + apkUpgradeInfo2.getVersionCode_() + ",detailId = " + apkUpgradeInfo2.getDetailId_() + ",devType = " + apkUpgradeInfo2.getDevType_() + ",packageName = " + apkUpgradeInfo2.getPackage_() + ",oldVersionCode = " + apkUpgradeInfo2.getOldVersionCode_());
                } else {
                    C0964a.m1666a("UpdateSDKCheckTask", "info == null");
                }
                if (this.f1476c.isShowImmediate()) {
                    m2098a(this.f1474a, apkUpgradeInfo2);
                }
            } else if (m2101b()) {
                C0964a.m1667b("UpdateSDKCheckTask", "show no upgrade info toast.");
                Context context = this.f1474a;
                Toast.makeText(context, C1041c.m1970c(context, "upsdk_update_check_no_new_version"), 0).show();
            }
        } else if (this.f1475b != null) {
            Intent intent3 = new Intent();
            intent3.putExtra("status", 3);
            this.f1475b.onUpdateInfo(intent3);
        }
    }

    /* renamed from: a */
    public void mo15195a(boolean z) {
        this.f1481h = z;
    }

    /* renamed from: b */
    public void mo15196b(boolean z) {
        this.f1478e = z;
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
        C0989b bVar = this.f1480g;
        if (bVar != null) {
            bVar.mo14908b();
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        C1083d.m2090a().mo15191a(this.f1475b);
        if (m2101b()) {
            Context context = this.f1474a;
            this.f1477d = Toast.makeText(context, C1041c.m1970c(context, "upsdk_checking_update_prompt"), 1);
            this.f1477d.show();
        }
    }
}
