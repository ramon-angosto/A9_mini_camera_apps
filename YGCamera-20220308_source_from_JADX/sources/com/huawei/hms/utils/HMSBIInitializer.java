package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.C0898a;
import com.huawei.hms.stats.C0900c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class HMSBIInitializer {

    /* renamed from: d */
    public static final Object f1015d = new Object();

    /* renamed from: e */
    public static HMSBIInitializer f1016e;

    /* renamed from: f */
    public static HiAnalyticsInstance f1017f;

    /* renamed from: a */
    public final Context f1018a;

    /* renamed from: b */
    public AtomicBoolean f1019b = new AtomicBoolean(false);

    /* renamed from: c */
    public boolean f1020c;

    /* renamed from: com.huawei.hms.utils.HMSBIInitializer$a */
    public class C0923a implements IQueryUrlCallBack {
        public C0923a() {
        }

        public void onCallBackFail(int i) {
            HMSLog.m1377e("HMSBIInitializer", "get grs failed, the errorcode is " + i);
            HMSBIInitializer.this.f1019b.set(false);
        }

        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!HMSBIInitializer.this.f1020c) {
                    HmsHiAnalyticsUtils.init(HMSBIInitializer.this.f1018a, false, false, false, str, "com.huawei.hwid");
                } else {
                    HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
                    HiAnalyticsInstance unused = HMSBIInitializer.f1017f = new HiAnalyticsInstance.Builder(HMSBIInitializer.this.f1018a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
                    HMSBIInitializer.f1017f.setAppid("com.huawei.hwid");
                }
                HMSLog.m1379i("HMSBIInitializer", "BI URL acquired successfully");
            }
            HMSBIInitializer.this.f1019b.set(false);
        }
    }

    /* renamed from: com.huawei.hms.utils.HMSBIInitializer$b */
    public class C0924b extends AsyncTask<String, Integer, Void> {
        public C0924b() {
        }

        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.mo14642a(strArr[0]);
            return null;
        }

        public /* synthetic */ C0924b(HMSBIInitializer hMSBIInitializer, C0923a aVar) {
            this();
        }
    }

    public HMSBIInitializer(Context context) {
        this.f1018a = context;
        this.f1020c = C0900c.m1342a();
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (f1015d) {
            if (f1016e == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    f1016e = new HMSBIInitializer(applicationContext);
                } else {
                    f1016e = new HMSBIInitializer(context);
                }
            }
        }
        return f1016e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f1017f;
    }

    public void initBI() {
        boolean z;
        if (!this.f1020c) {
            z = HmsHiAnalyticsUtils.getInitFlag();
        } else {
            z = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        HMSLog.m1379i("HMSBIInitializer", "Builder->biInitFlag :" + z);
        if (!z && !C0898a.m1337c(this.f1018a) && this.f1019b.compareAndSet(false, true)) {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.f1018a);
            if (!TextUtils.isEmpty(issueCountryCode)) {
                issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
            }
            if (GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(issueCountryCode) || TextUtils.isEmpty(issueCountryCode)) {
                HMSLog.m1377e("HMSBIInitializer", "Failed to get device issue country");
                this.f1019b.set(false);
                return;
            }
            new C0924b(this, (C0923a) null).execute(new String[]{issueCountryCode});
        }
    }

    public boolean isInit() {
        if (!this.f1020c) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    /* renamed from: a */
    public final void mo14642a(String str) {
        HMSLog.m1379i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.f1018a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOT", new C0923a());
    }
}
