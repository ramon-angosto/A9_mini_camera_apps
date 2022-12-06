package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.PointerIconCompat;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import com.huawei.updatesdk.p025a.p026a.p031d.p033i.C0984a;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import com.huawei.updatesdk.p025a.p034b.p036b.C0986a;
import com.huawei.updatesdk.p025a.p034b.p036b.C0987b;
import com.huawei.updatesdk.p039b.p045d.C1013a;
import com.huawei.updatesdk.p039b.p045d.C1014b;
import com.huawei.updatesdk.p039b.p045d.C1015c;
import com.huawei.updatesdk.p039b.p045d.C1020f;
import com.huawei.updatesdk.p039b.p046e.C1027e;
import com.huawei.updatesdk.p039b.p047f.C1029b;
import com.huawei.updatesdk.p039b.p047f.C1030c;
import com.huawei.updatesdk.p039b.p049h.C1037b;
import com.huawei.updatesdk.p039b.p049h.C1041c;
import com.huawei.updatesdk.p039b.p049h.C1042d;
import com.huawei.updatesdk.p039b.p050i.C1043a;
import com.huawei.updatesdk.p039b.p050i.C1050b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.C1056c;
import com.huawei.updatesdk.service.otaupdate.C1080c;
import java.io.Serializable;
import java.util.concurrent.Executors;

public class AppUpdateActivity extends Activity implements C1079b, C1029b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f1428a;

    /* renamed from: b */
    private AlertDialog f1429b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1043a f1430c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1043a f1431d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ProgressBar f1432e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f1433f;

    /* renamed from: g */
    private boolean f1434g = false;

    /* renamed from: h */
    private boolean f1435h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ApkUpgradeInfo f1436i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f1437j = false;

    /* renamed from: k */
    private boolean f1438k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C1015c f1439l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f1440m = -99;

    /* renamed from: n */
    private int f1441n = -99;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f1442o = -99;

    /* renamed from: p */
    private Intent f1443p = null;

    /* renamed from: q */
    private C1076q f1444q;

    /* renamed from: r */
    private boolean f1445r = false;

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$a */
    class C1060a implements DialogInterface.OnKeyListener {
        C1060a() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            int unused = AppUpdateActivity.this.f1440m = 4;
            AppUpdateActivity.this.finish();
            return true;
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$b */
    class C1061b implements C1050b {

        /* renamed from: a */
        final /* synthetic */ C1056c f1447a;

        /* renamed from: b */
        final /* synthetic */ C1043a f1448b;

        C1061b(C1056c cVar, C1043a aVar) {
            this.f1447a = cVar;
            this.f1448b = aVar;
        }

        /* renamed from: a */
        public void mo15030a() {
            AppUpdateActivity.this.m2053d(this.f1447a);
            this.f1448b.mo15014a();
        }

        /* renamed from: b */
        public void mo15031b() {
            this.f1448b.mo15014a();
            if (AppUpdateActivity.this.f1437j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.m2039b(appUpdateActivity.f1436i);
                return;
            }
            int unused = AppUpdateActivity.this.f1440m = 4;
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$c */
    class C1062c implements C1043a.C1049d {
        C1062c() {
        }

        /* renamed from: a */
        public void mo15029a() {
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$d */
    class C1063d implements DialogInterface.OnKeyListener {

        /* renamed from: a */
        final /* synthetic */ C1043a f1451a;

        C1063d(C1043a aVar) {
            this.f1451a = aVar;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            if (AppUpdateActivity.this.f1437j) {
                this.f1451a.mo15014a();
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.m2039b(appUpdateActivity.f1436i);
                return true;
            }
            int unused = AppUpdateActivity.this.f1440m = 4;
            AppUpdateActivity.this.finish();
            return true;
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$e */
    class C1064e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0987b f1453a;

        C1064e(C0987b bVar) {
            this.f1453a = bVar;
        }

        public void run() {
            Bundle b = this.f1453a.mo14901b();
            if (b != null) {
                int i = b.getInt("INSTALL_STATE");
                C1083d.m2090a().mo15190a(AppUpdateActivity.this.m2021a(i, b.getInt("INSTALL_TYPE"), -1));
                AppUpdateActivity.this.m2047c(i);
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$f */
    class C1065f implements C1050b {
        C1065f() {
        }

        /* renamed from: a */
        public void mo15030a() {
            AppUpdateActivity.this.f1432e.setProgress(0);
            AppUpdateActivity.this.f1432e.setMax(0);
            AppUpdateActivity.this.f1433f.setText("");
            AppUpdateActivity.this.m2023a();
            if (AppUpdateActivity.this.f1439l != null) {
                AppUpdateActivity.this.f1439l.mo14988a();
            }
            AppUpdateActivity.this.f1430c.mo15014a();
            if (AppUpdateActivity.this.f1437j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.m2039b(appUpdateActivity.f1436i);
                return;
            }
            int unused = AppUpdateActivity.this.f1440m = 4;
            AppUpdateActivity.this.finish();
        }

        /* renamed from: b */
        public void mo15031b() {
            AppUpdateActivity.this.f1430c.mo15014a();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$g */
    class C1066g implements C1043a.C1049d {
        C1066g() {
        }

        /* renamed from: a */
        public void mo15029a() {
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$h */
    class C1067h implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f1457a;

        C1067h(String str) {
            this.f1457a = str;
        }

        public void onClick(View view) {
            AppUpdateActivity.this.m2050c(this.f1457a);
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$i */
    class C1068i implements C1050b {

        /* renamed from: a */
        final /* synthetic */ C1056c f1459a;

        /* renamed from: b */
        final /* synthetic */ C1043a f1460b;

        C1068i(C1056c cVar, C1043a aVar) {
            this.f1459a = cVar;
            this.f1460b = aVar;
        }

        /* renamed from: a */
        public void mo15030a() {
            if (!C0984a.m1755d(AppUpdateActivity.this)) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                Toast.makeText(appUpdateActivity, C1041c.m1970c(appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
                AppUpdateActivity.this.finish();
            } else if (C0984a.m1754c(AppUpdateActivity.this) != 1) {
                AppUpdateActivity.this.m2049c(this.f1459a);
            } else {
                AppUpdateActivity.this.m2053d(this.f1459a);
                this.f1460b.mo15014a();
            }
        }

        /* renamed from: b */
        public void mo15031b() {
            this.f1460b.mo15014a();
            if (AppUpdateActivity.this.f1437j) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.m2039b(appUpdateActivity.f1436i);
                return;
            }
            int unused = AppUpdateActivity.this.f1440m = 4;
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$j */
    class C1069j implements C1043a.C1049d {
        C1069j() {
        }

        /* renamed from: a */
        public void mo15029a() {
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$k */
    class C1070k implements DialogInterface.OnKeyListener {

        /* renamed from: a */
        final /* synthetic */ C1043a f1463a;

        C1070k(C1043a aVar) {
            this.f1463a = aVar;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            if (AppUpdateActivity.this.f1437j) {
                this.f1463a.mo15014a();
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                appUpdateActivity.m2039b(appUpdateActivity.f1436i);
                return true;
            }
            int unused = AppUpdateActivity.this.f1440m = 4;
            AppUpdateActivity.this.finish();
            return true;
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$l */
    class C1071l implements C1050b {
        C1071l() {
        }

        /* renamed from: a */
        public void mo15030a() {
            int unused = AppUpdateActivity.this.f1442o = 101;
            if (!C0984a.m1755d(AppUpdateActivity.this)) {
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                Toast.makeText(appUpdateActivity, C1041c.m1970c(appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
                int unused2 = AppUpdateActivity.this.f1440m = 2;
                AppUpdateActivity.this.finish();
                return;
            }
            AppUpdateActivity.this.m2055e();
        }

        /* renamed from: b */
        public void mo15031b() {
            AppUpdateActivity.this.f1431d.mo15014a();
            int unused = AppUpdateActivity.this.f1440m = 4;
            int unused2 = AppUpdateActivity.this.f1442o = 100;
            if (!AppUpdateActivity.this.f1437j) {
                C1080c cVar = new C1080c();
                AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                cVar.mo15184a(appUpdateActivity, appUpdateActivity.f1428a, new C1073n());
                return;
            }
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$m */
    class C1072m implements C1043a.C1049d {
        C1072m() {
        }

        /* renamed from: a */
        public void mo15029a() {
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$n */
    public class C1073n implements C1080c.C1081a {
        public C1073n() {
        }

        /* renamed from: a */
        public void mo15165a(Boolean bool) {
            if (bool.booleanValue()) {
                try {
                    Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateRemindAction");
                    intent.setPackage(AppUpdateActivity.this.f1428a);
                    AppUpdateActivity.this.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    C0968a.m1682b("AppUpdateActivity", "goHiappUpgrade error: " + e.toString());
                }
            }
            AppUpdateActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$o */
    private static class C1074o implements DialogInterface.OnDismissListener {
        private C1074o() {
        }

        /* synthetic */ C1074o(C1064e eVar) {
            this();
        }

        public void onDismiss(DialogInterface dialogInterface) {
            Intent intent = new Intent();
            intent.putExtra(UpdateKey.DIALOG_STATUS, UpdateDialogStatusCode.DISMISS);
            C1083d.m2090a().mo15192b(intent);
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$p */
    private static class C1075p implements DialogInterface.OnShowListener {
        private C1075p() {
        }

        /* synthetic */ C1075p(C1064e eVar) {
            this();
        }

        public void onShow(DialogInterface dialogInterface) {
            Intent intent = new Intent();
            intent.putExtra(UpdateKey.DIALOG_STATUS, UpdateDialogStatusCode.SHOW);
            C1083d.m2090a().mo15192b(intent);
        }
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$q */
    private class C1076q extends C0986a {
        private C1076q() {
        }

        /* synthetic */ C1076q(AppUpdateActivity appUpdateActivity, C1064e eVar) {
            this();
        }

        /* renamed from: a */
        public void mo14894a(Context context, C0987b bVar) {
            if (bVar.mo14903d()) {
                if (AppUpdateActivity.this.f1430c != null) {
                    AppUpdateActivity.this.f1430c.mo15014a();
                }
                AppUpdateActivity.this.m2023a();
                String a = bVar.mo14897a();
                String dataString = bVar.mo14902c().getDataString();
                if (dataString != null && dataString.length() >= 9) {
                    String substring = dataString.substring(8);
                    if ("android.intent.action.PACKAGE_ADDED".equals(a) && TextUtils.equals(AppUpdateActivity.this.f1428a, substring)) {
                        C1083d.m2090a().mo15190a(AppUpdateActivity.this.m2021a(6, 0, -1));
                        C1037b.m1958a();
                        AppUpdateActivity appUpdateActivity = AppUpdateActivity.this;
                        appUpdateActivity.m2034a(appUpdateActivity.f1436i.getPackage_(), AppUpdateActivity.this.f1436i.getDetailId_());
                        if (AppUpdateActivity.this.f1437j) {
                            AppUpdateActivity appUpdateActivity2 = AppUpdateActivity.this;
                            appUpdateActivity2.m2039b(appUpdateActivity2.f1436i);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private long m2020a(ApkUpgradeInfo apkUpgradeInfo) {
        long longSize_ = apkUpgradeInfo.getLongSize_();
        if (apkUpgradeInfo.getPackingType_() == 1 && apkUpgradeInfo.getBundleSize_() > 0) {
            return apkUpgradeInfo.getBundleSize_();
        }
        if (apkUpgradeInfo.getPackingType_() == 3 && apkUpgradeInfo.getObbSize_() > 0) {
            longSize_ += apkUpgradeInfo.getObbSize_();
        }
        if (apkUpgradeInfo.getDiffSize_() <= 0) {
            return longSize_;
        }
        long diffSize_ = (long) apkUpgradeInfo.getDiffSize_();
        return (apkUpgradeInfo.getPackingType_() != 3 || apkUpgradeInfo.getObbSize_() <= 0) ? diffSize_ : diffSize_ + apkUpgradeInfo.getObbSize_();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Intent m2021a(int i, int i2, int i3) {
        Intent intent = new Intent();
        intent.putExtra(UpdateKey.MARKET_DLD_STATUS, i3);
        intent.putExtra(UpdateKey.MARKET_INSTALL_STATE, i);
        intent.putExtra(UpdateKey.MARKET_INSTALL_TYPE, i2);
        return intent;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2023a() {
        try {
            if (this.f1429b != null && this.f1429b.isShowing()) {
                this.f1429b.dismiss();
                this.f1429b = null;
            }
        } catch (IllegalArgumentException unused) {
            C0968a.m1680a("AppUpdateActivity", "progressDialog dismiss IllegalArgumentException");
        }
    }

    /* renamed from: a */
    private void m2024a(View view) {
        if (C0981c.m1744i()) {
            try {
                ScrollView scrollView = (ScrollView) view.findViewById(C1041c.m1966a(this, "scroll_layout"));
                if (Build.VERSION.SDK_INT >= 22) {
                    TypedValue typedValue = new TypedValue();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    getTheme().resolveAttribute(16843987, typedValue, true);
                    ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    int complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, displayMetrics);
                    scrollView.setPadding(complexToDimensionPixelSize, 0, complexToDimensionPixelSize, 0);
                }
            } catch (Exception e) {
                C0968a.m1682b("AppUpdateActivity", e.toString());
            }
        }
    }

    /* renamed from: a */
    private void m2025a(C0987b bVar) {
        Bundle b = bVar.mo14901b();
        if (b != null) {
            int i = b.getInt("download_status_param", -1);
            C1083d.m2090a().mo15190a(m2021a(-1, -1, i));
            if (!C1013a.m1879a(i)) {
                m2023a();
                if (C1013a.m1880b(i)) {
                    Toast.makeText(this, getString(C1041c.m1970c(this, "upsdk_third_app_dl_install_failed")), 0).show();
                    finish();
                }
            }
        }
    }

    /* renamed from: a */
    private void m2026a(ApkUpgradeInfo apkUpgradeInfo, TextView textView) {
        if (textView != null) {
            if (apkUpgradeInfo.getDiffSize_() > 0) {
                String a = C1042d.m1974a((Context) this, (apkUpgradeInfo.getPackingType_() != 3 || apkUpgradeInfo.getObbSize_() <= 0) ? apkUpgradeInfo.getLongSize_() : apkUpgradeInfo.getLongSize_() + apkUpgradeInfo.getObbSize_());
                SpannableString spannableString = new SpannableString(a);
                spannableString.setSpan(new StrikethroughSpan(), 0, a.length(), 33);
                spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, (int) textView.getTextSize(), (ColorStateList) null, (ColorStateList) null), 0, spannableString.length(), 33);
                textView.setText(spannableString);
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m2033a(String str) {
        Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        intent.setPackage(this.f1428a);
        intent.putExtra("APP_PACKAGENAME", str);
        intent.putExtra("APP_MUST_UPDATE_BTN", this.f1438k);
        try {
            this.f1435h = false;
            startActivityForResult(intent, PointerIconCompat.TYPE_HAND);
        } catch (ActivityNotFoundException e) {
            C0968a.m1682b("AppUpdateActivity", "goHiappUpgrade error: " + e.toString());
            this.f1435h = true;
            Intent intent2 = new Intent();
            intent2.putExtra("status", 8);
            C1083d.m2090a().mo15192b(intent2);
            m2039b(this.f1436i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2034a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.f1440m = 1;
            finish();
            return;
        }
        Intent intent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId");
        intent.setPackage(this.f1428a);
        intent.putExtra("appDetailId", str2);
        intent.putExtra("thirdId", str);
        intent.addFlags(268468224);
        try {
            startActivity(intent);
            if (!this.f1437j) {
                finish();
            }
        } catch (Exception e) {
            C0964a.m1666a("AppUpdateActivity", "openMarketUpdateDetail error: " + e.toString());
            C1020f.m1907a((C1079b) this);
            C1020f.m1908a(this.f1445r);
            Intent intent2 = new Intent();
            intent2.putExtra("status", 8);
            C1083d.m2090a().mo15192b(intent2);
            C1043a aVar = this.f1431d;
            if (aVar != null) {
                aVar.mo15014a();
            }
        }
    }

    /* renamed from: b */
    private void m2037b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.f1444q = new C1076q(this, (C1064e) null);
        C1078a.m2080a(this, intentFilter, this.f1444q);
    }

    /* renamed from: b */
    private void m2038b(C0987b bVar) {
        if (this.f1432e != null) {
            this.f1432e.setProgress(C1042d.m1972a(bVar.mo14900b("download_apk_already", 0), bVar.mo14900b("download_apk_size", 0)));
            this.f1433f.setText(C1042d.m1973a((int) ((((float) this.f1432e.getProgress()) / ((float) this.f1432e.getMax())) * 100.0f)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2039b(ApkUpgradeInfo apkUpgradeInfo) {
        C0964a.m1667b("AppUpdateActivity", "showOtaDialog");
        if (apkUpgradeInfo == null) {
            finish();
            return;
        }
        String string = getString(C1041c.m1970c(this, "upsdk_ota_title"));
        String string2 = getString(C1041c.m1970c(this, "upsdk_ota_notify_updatebtn"));
        String string3 = getString(C1041c.m1970c(this, "upsdk_ota_cancel"));
        m2042b(string);
        if (1 == apkUpgradeInfo.getIsCompulsoryUpdate_()) {
            string3 = getString(C1041c.m1970c(this, "upsdk_ota_force_cancel_new"));
            if (this.f1438k) {
                this.f1431d.mo15024c();
            }
            this.f1434g = true;
        }
        this.f1431d.mo15021a((C1050b) new C1071l());
        m2046c();
        this.f1431d.mo15020a((C1043a.C1049d) new C1072m());
        if (this.f1434g) {
            this.f1431d.mo15022a(false);
        } else {
            this.f1431d.mo15016a((DialogInterface.OnKeyListener) new C1060a());
        }
        this.f1431d.mo15019a(C1043a.C1048c.CONFIRM, string2);
        this.f1431d.mo15019a(C1043a.C1048c.CANCEL, string3);
    }

    /* renamed from: b */
    private void m2040b(C1056c cVar) {
        C1043a a = C1043a.m1976a(this, (String) null, getString(C1041c.m1970c(this, "upsdk_appstore_install"), new Object[]{cVar.mo15135a()}));
        a.mo15021a((C1050b) new C1068i(cVar, a));
        String string = getString(C1041c.m1970c(this, "upsdk_app_download_info_new"));
        a.mo15020a((C1043a.C1049d) new C1069j());
        a.mo15019a(C1043a.C1048c.CONFIRM, string);
        a.mo15016a((DialogInterface.OnKeyListener) new C1070k(a));
    }

    /* renamed from: b */
    private void m2042b(String str) {
        View inflate = LayoutInflater.from(this).inflate(C1041c.m1969b(this, "upsdk_ota_update_view"), (ViewGroup) null);
        ((TextView) inflate.findViewById(C1041c.m1966a(this, "content_textview"))).setText(TextUtils.isEmpty(this.f1436i.getNewFeatures_()) ? getString(C1041c.m1970c(this, "upsdk_choice_update")) : this.f1436i.getNewFeatures_());
        ((TextView) inflate.findViewById(C1041c.m1966a(this, "version_textview"))).setText(this.f1436i.getVersion_());
        ((TextView) inflate.findViewById(C1041c.m1966a(this, "appsize_textview"))).setText(C1042d.m1974a((Context) this, m2020a(this.f1436i)));
        ((TextView) inflate.findViewById(C1041c.m1966a(this, "name_textview"))).setText(this.f1436i.getName_());
        m2026a(this.f1436i, (TextView) inflate.findViewById(C1041c.m1966a(this, "allsize_textview")));
        m2024a(inflate);
        this.f1431d = C1043a.m1976a(this, str, (CharSequence) null);
        this.f1431d.mo15018a(inflate);
    }

    /* renamed from: b */
    private void m2043b(String str, String str2) {
        AlertDialog alertDialog = this.f1429b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.f1429b = (C0981c.m1744i() ? new AlertDialog.Builder(this) : ((getResources().getConfiguration().uiMode & 48) != 32 || Build.VERSION.SDK_INT < 29) ? new AlertDialog.Builder(this, 16974546) : new AlertDialog.Builder(this, 16974545)).create();
            View inflate = LayoutInflater.from(this).inflate(C1041c.m1969b(this, "upsdk_app_dl_progress_dialog"), (ViewGroup) null);
            ((TextView) inflate.findViewById(C1041c.m1966a(this, "third_app_warn_text"))).setText(getString(C1041c.m1970c(this, "upsdk_app_download_installing"), new Object[]{str2}));
            this.f1432e = (ProgressBar) inflate.findViewById(C1041c.m1966a(this, "third_app_dl_progressbar"));
            this.f1432e.setMax(100);
            this.f1433f = (TextView) inflate.findViewById(C1041c.m1966a(this, "third_app_dl_progress_text"));
            inflate.findViewById(C1041c.m1966a(this, "cancel_bg")).setOnClickListener(new C1067h(str));
            this.f1429b.setView(inflate);
            this.f1429b.setCancelable(false);
            this.f1429b.setCanceledOnTouchOutside(false);
            if (!C1078a.m2081a(this)) {
                this.f1429b.show();
            }
            this.f1433f.setText(C1042d.m1973a(0));
        }
    }

    /* renamed from: c */
    private void m2046c() {
        C1043a aVar = this.f1431d;
        if (aVar != null) {
            aVar.mo15015a((DialogInterface.OnDismissListener) new C1074o((C1064e) null));
            this.f1431d.mo15017a((DialogInterface.OnShowListener) new C1075p((C1064e) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2047c(int i) {
        if (i == 5 || i == 4) {
            Toast.makeText(this, getString(C1041c.m1970c(this, "upsdk_third_app_dl_install_failed")), 0).show();
            C1037b.m1958a();
            finish();
        }
        if (i == 7) {
            C1037b.m1958a();
            if (this.f1434g) {
                m2039b(this.f1436i);
            } else {
                finish();
            }
        }
    }

    /* renamed from: c */
    private void m2048c(C0987b bVar) {
        new Handler(Looper.getMainLooper()).post(new C1064e(bVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2049c(C1056c cVar) {
        String a = C1042d.m1974a((Context) this, cVar.mo15137c());
        C1043a a2 = C1043a.m1976a(this, (String) null, getString(C1041c.m1970c(this, "upsdk_mobile_dld_warn"), new Object[]{a}));
        a2.mo15021a((C1050b) new C1061b(cVar, a2));
        String string = getString(C1041c.m1970c(this, "upsdk_app_download_info_new"));
        a2.mo15020a((C1043a.C1049d) new C1062c());
        a2.mo15019a(C1043a.C1048c.CONFIRM, string);
        a2.mo15016a((DialogInterface.OnKeyListener) new C1063d(a2));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2050c(String str) {
        this.f1430c = C1043a.m1976a(this, (String) null, getString(C1041c.m1970c(this, "upsdk_third_app_dl_cancel_download_prompt_ex")));
        this.f1430c.mo15021a((C1050b) new C1065f());
        String string = getString(C1041c.m1970c(this, "upsdk_third_app_dl_sure_cancel_download"));
        this.f1430c.mo15020a((C1043a.C1049d) new C1066g());
        this.f1430c.mo15019a(C1043a.C1048c.CONFIRM, string);
    }

    /* renamed from: d */
    private void m2052d() {
        C1078a.m2079a(this, this.f1444q);
        C1030c.m1936a().mo15005b(this);
        C1015c cVar = this.f1439l;
        if (cVar != null) {
            cVar.mo14989b();
        }
        C1020f.m1907a((C1079b) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2053d(C1056c cVar) {
        m2037b();
        m2043b(cVar.mo15138d(), cVar.mo15135a());
        C1014b bVar = new C1014b(cVar.mo15136b(), cVar.mo15137c(), cVar.mo15139e());
        bVar.mo14982a(cVar.mo15138d());
        this.f1439l = new C1015c(bVar);
        this.f1439l.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2055e() {
        if (!C1037b.m1963c(this, this.f1428a)) {
            C1020f.m1907a((C1079b) this);
            C1020f.m1908a(this.f1445r);
            this.f1431d.mo15014a();
            return;
        }
        m2034a(this.f1436i.getPackage_(), this.f1436i.getDetailId_());
    }

    /* renamed from: a */
    public void mo15153a(int i) {
        Toast.makeText(this, getString(C1041c.m1970c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
        C1083d.m2090a().mo15189a(i);
        finish();
    }

    /* renamed from: a */
    public void mo15006a(int i, C0987b bVar) {
        if (bVar != null) {
            if (i == 0) {
                m2025a(bVar);
            } else if (1 == i) {
                m2038b(bVar);
            } else if (2 == i) {
                m2048c(bVar);
            }
        }
    }

    /* renamed from: a */
    public void mo15154a(C1056c cVar) {
        if (cVar == null || !cVar.mo15140f()) {
            Toast.makeText(this, getString(C1041c.m1970c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
            finish();
            return;
        }
        C1030c.m1936a().mo15004a(this);
        this.f1428a = cVar.mo15138d();
        m2040b(cVar);
    }

    /* renamed from: b */
    public void mo15155b(int i) {
        Toast.makeText(this, getString(C1041c.m1970c(this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
        C1083d.m2090a().mo15189a(i);
        finish();
    }

    public void finish() {
        if (this.f1434g) {
            overridePendingTransition(0, 0);
        }
        this.f1443p = new Intent();
        this.f1443p.putExtra("status", this.f1440m);
        this.f1443p.putExtra(UpdateKey.FAIL_CODE, this.f1441n);
        this.f1443p.putExtra(UpdateKey.MUST_UPDATE, this.f1434g);
        this.f1443p.putExtra(UpdateKey.BUTTON_STATUS, this.f1442o);
        C1083d.m2090a().mo15192b(this.f1443p);
        super.finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1002) {
            if (intent != null) {
                C0987b a = C0987b.m1761a(intent);
                this.f1440m = i2;
                this.f1441n = a.mo14896a("installResultCode", -99);
                this.f1434g = a.mo14899a(UpdateKey.MUST_UPDATE, false);
            }
            this.f1442o = i2 == 4 ? 100 : 101;
            if (!this.f1435h) {
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        requestWindowFeature(1);
        C0981c.m1734d().mo14890a(getWindow());
        super.onCreate(bundle);
        Bundle b = C0987b.m1761a(getIntent()).mo14901b();
        C0985a.m1756a(this);
        if (b != null) {
            try {
                serializable = b.getSerializable("app_update_parm");
                this.f1445r = b.getBoolean("is_apptouch", false);
            } catch (Exception e) {
                C0964a.m1666a("AppUpdateActivity", "Type Conversion Error: " + e.toString());
                super.finish();
                return;
            }
        } else {
            serializable = null;
        }
        this.f1428a = C1027e.m1931a(this.f1445r ? "apptouch" : "default").mo14997b();
        if (TextUtils.isEmpty(this.f1428a)) {
            C0964a.m1666a("AppUpdateActivity", "finish activity and appStorePkgName is: " + this.f1428a);
            super.finish();
        } else if (serializable instanceof ApkUpgradeInfo) {
            this.f1436i = (ApkUpgradeInfo) serializable;
            this.f1438k = b.getBoolean("app_must_btn", false);
            if (this.f1436i.getIsCompulsoryUpdate_() == 1) {
                this.f1437j = true;
            }
            if (this.f1436i.getDevType_() == 1 && C1037b.m1957a((Context) this, this.f1428a) == C1037b.C1039b.INSTALLED) {
                m2033a(this.f1436i.getPackage_());
            } else {
                m2039b(this.f1436i);
            }
        } else {
            this.f1440m = 3;
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C1043a aVar = this.f1430c;
        if (aVar != null) {
            aVar.mo15014a();
            this.f1430c = null;
        }
        C1043a aVar2 = this.f1431d;
        if (aVar2 != null) {
            aVar2.mo15014a();
            this.f1431d = null;
        }
        m2023a();
        m2052d();
        super.onDestroy();
        finishActivity(PointerIconCompat.TYPE_HAND);
    }
}
