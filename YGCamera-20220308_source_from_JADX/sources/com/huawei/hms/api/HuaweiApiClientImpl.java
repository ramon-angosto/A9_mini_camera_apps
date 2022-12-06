package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.C0701a;
import com.huawei.hms.core.aidl.C0702b;
import com.huawei.hms.core.aidl.C0704c;
import com.huawei.hms.core.aidl.C0707d;
import com.huawei.hms.core.aidl.C0710e;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {

    /* renamed from: B */
    private static final Object f289B = new Object();

    /* renamed from: C */
    private static final Object f290C = new Object();
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: A */
    private CheckUpdateCallBack f291A;

    /* renamed from: a */
    private int f292a = -1;

    /* renamed from: b */
    private final Context f293b;

    /* renamed from: c */
    private final String f294c;

    /* renamed from: d */
    private String f295d;

    /* renamed from: e */
    private String f296e;

    /* renamed from: f */
    private volatile C0707d f297f;

    /* renamed from: g */
    private String f298g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WeakReference<Activity> f299h;

    /* renamed from: i */
    private WeakReference<Activity> f300i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f301j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AtomicInteger f302k = new AtomicInteger(1);

    /* renamed from: l */
    private List<Scope> f303l;

    /* renamed from: m */
    private List<PermissionInfo> f304m;

    /* renamed from: n */
    private Map<Api<?>, Api.ApiOptions> f305n;

    /* renamed from: o */
    private SubAppInfo f306o;

    /* renamed from: p */
    private long f307p = 0;

    /* renamed from: q */
    private int f308q = 0;

    /* renamed from: r */
    private final Object f309r = new Object();

    /* renamed from: s */
    private final ReentrantLock f310s = new ReentrantLock();

    /* renamed from: t */
    private final Condition f311t = this.f310s.newCondition();

    /* renamed from: u */
    private ConnectionResult f312u;

    /* renamed from: v */
    private HuaweiApiClient.ConnectionCallbacks f313v;

    /* renamed from: w */
    private HuaweiApiClient.OnConnectionFailedListener f314w;

    /* renamed from: x */
    private Handler f315x = null;

    /* renamed from: y */
    private Handler f316y = null;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public CheckUpdatelistener f317z = null;

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$a */
    class C0618a implements CheckUpdateCallBack {
        C0618a() {
        }

        public void onMarketInstallInfo(Intent intent) {
            if (intent != null) {
                int intExtra = intent.getIntExtra(UpdateKey.MARKET_DLD_STATUS, -99);
                int intExtra2 = intent.getIntExtra(UpdateKey.MARKET_INSTALL_STATE, -99);
                int intExtra3 = intent.getIntExtra(UpdateKey.MARKET_INSTALL_TYPE, -99);
                HMSLog.m1379i("HuaweiApiClientImpl", "onMarketInstallInfo installState: " + intExtra2 + ",installType: " + intExtra3 + ",downloadCode: " + intExtra);
            }
        }

        public void onMarketStoreError(int i) {
            HMSLog.m1377e("HuaweiApiClientImpl", "onMarketStoreError responseCode: " + i);
        }

        public void onUpdateInfo(Intent intent) {
            if (intent != null && HuaweiApiClientImpl.this.f317z != null) {
                try {
                    int intExtra = intent.getIntExtra("status", -99);
                    int intExtra2 = intent.getIntExtra(UpdateKey.FAIL_CODE, -99);
                    boolean booleanExtra = intent.getBooleanExtra(UpdateKey.MUST_UPDATE, false);
                    HMSLog.m1379i("HuaweiApiClientImpl", "onUpdateInfo status: " + intExtra + ",failcause: " + intExtra2 + ",isExit: " + booleanExtra);
                    if (intExtra == 7) {
                        ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) intent.getSerializableExtra(UpdateKey.INFO);
                        if (apkUpgradeInfo != null) {
                            HMSLog.m1379i("HuaweiApiClientImpl", "onUpdateInfo: " + apkUpgradeInfo.toString());
                        }
                        HuaweiApiClientImpl.this.f317z.onResult(1);
                    } else if (intExtra == 3) {
                        HuaweiApiClientImpl.this.f317z.onResult(0);
                    } else {
                        HuaweiApiClientImpl.this.f317z.onResult(-1);
                    }
                    CheckUpdatelistener unused = HuaweiApiClientImpl.this.f317z = null;
                } catch (Exception e) {
                    HMSLog.m1377e("HuaweiApiClientImpl", "intent has some error" + e.getMessage());
                    HuaweiApiClientImpl.this.f317z.onResult(-1);
                }
            }
        }

        public void onUpdateStoreError(int i) {
            HMSLog.m1377e("HuaweiApiClientImpl", "onUpdateStoreError responseCode: " + i);
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$b */
    class C0619b implements Handler.Callback {
        C0619b() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.m1377e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.f302k.get() == 5) {
                HuaweiApiClientImpl.this.m226c(1);
                HuaweiApiClientImpl.this.m221b();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$c */
    class C0620c implements Handler.Callback {
        C0620c() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.m1377e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.f302k.get() == 2) {
                HuaweiApiClientImpl.this.m226c(1);
                HuaweiApiClientImpl.this.m221b();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$d */
    class C0621d extends C0704c.C0705a {

        /* renamed from: a */
        final /* synthetic */ ResultCallback f321a;

        C0621d(HuaweiApiClientImpl huaweiApiClientImpl, ResultCallback resultCallback) {
            this.f321a = resultCallback;
        }

        public void call(C0702b bVar) {
            if (bVar != null) {
                C0710e a = C0701a.m423a(bVar.mo13626c());
                ResponseHeader responseHeader = new ResponseHeader();
                a.mo13637a(bVar.f437b, (IMessageEntity) responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), bVar.mo13623a());
                HMSLog.m1379i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.f321a.onResult(bundleResult);
                return;
            }
            HMSLog.m1379i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
            this.f321a.onResult(new BundleResult(-1, (Bundle) null));
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$e */
    static class C0622e extends PendingResultImpl<Status, IMessageEntity> {
        public C0622e(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$f */
    private class C0623f implements ResultCallback<ResolveResult<ConnectResp>> {

        /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$f$a */
        class C0624a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ResolveResult f323a;

            C0624a(ResolveResult resolveResult) {
                this.f323a = resolveResult;
            }

            public void run() {
                HuaweiApiClientImpl.this.m218a((ResolveResult<ConnectResp>) this.f323a);
            }
        }

        private C0623f() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new C0624a(resolveResult));
        }

        /* synthetic */ C0623f(HuaweiApiClientImpl huaweiApiClientImpl, C0618a aVar) {
            this();
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$g */
    private class C0625g implements ResultCallback<ResolveResult<DisconnectResp>> {

        /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$g$a */
        class C0626a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ResolveResult f326a;

            C0626a(ResolveResult resolveResult) {
                this.f326a = resolveResult;
            }

            public void run() {
                HuaweiApiClientImpl.this.m224b((ResolveResult<DisconnectResp>) this.f326a);
            }
        }

        private C0625g() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new C0626a(resolveResult));
        }

        /* synthetic */ C0625g(HuaweiApiClientImpl huaweiApiClientImpl, C0618a aVar) {
            this();
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$h */
    private class C0627h implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private C0627h() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
            r4 = r4.getValue();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResult(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp> r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L_0x004c
                com.huawei.hms.support.api.client.Status r0 = r4.getStatus()
                boolean r0 = r0.isSuccess()
                if (r0 == 0) goto L_0x004c
                java.lang.Object r4 = r4.getValue()
                com.huawei.hms.support.api.entity.core.JosGetNoticeResp r4 = (com.huawei.hms.support.api.entity.core.JosGetNoticeResp) r4
                android.content.Intent r0 = r4.getNoticeIntent()
                if (r0 == 0) goto L_0x004c
                int r4 = r4.getStatusCode()
                if (r4 != 0) goto L_0x004c
                java.lang.String r4 = "HuaweiApiClientImpl"
                java.lang.String r1 = "get notice has intent."
                com.huawei.hms.support.log.HMSLog.m1379i(r4, r1)
                com.huawei.hms.api.HuaweiApiClientImpl r1 = com.huawei.hms.api.HuaweiApiClientImpl.this
                java.lang.ref.WeakReference r1 = r1.f299h
                java.lang.Object r1 = r1.get()
                android.app.Activity r1 = (android.app.Activity) r1
                com.huawei.hms.api.HuaweiApiClientImpl r2 = com.huawei.hms.api.HuaweiApiClientImpl.this
                android.app.Activity r2 = r2.getTopActivity()
                android.app.Activity r1 = com.huawei.hms.utils.Util.getValidActivity(r1, r2)
                if (r1 != 0) goto L_0x0043
                java.lang.String r0 = "showNotice no valid activity!"
                com.huawei.hms.support.log.HMSLog.m1377e(r4, r0)
                return
            L_0x0043:
                com.huawei.hms.api.HuaweiApiClientImpl r4 = com.huawei.hms.api.HuaweiApiClientImpl.this
                r2 = 1
                boolean unused = r4.f301j = r2
                r1.startActivity(r0)
            L_0x004c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.C0627h.onResult(com.huawei.hms.support.api.ResolveResult):void");
        }

        /* synthetic */ C0627h(HuaweiApiClientImpl huaweiApiClientImpl, C0618a aVar) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        this.f293b = context;
        this.f294c = Util.getAppId(context);
        this.f295d = this.f294c;
        this.f296e = Util.getCpId(context);
    }

    /* renamed from: e */
    private int m230e() {
        int hmsVersion = Util.getHmsVersion(this.f293b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int f = m231f();
        if (m233h()) {
            if (f < 20503000) {
                return 20503000;
            }
            return f;
        } else if (f < 20600000) {
            return 20600000;
        } else {
            return f;
        }
    }

    /* renamed from: f */
    private int m231f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i = 0;
        if (apiMap == null) {
            return 0;
        }
        for (Api<?> apiName : apiMap.keySet()) {
            String apiName2 = apiName.getApiName();
            if (!TextUtils.isEmpty(apiName2) && (num = HuaweiApiAvailability.getApiMap().get(apiName2)) != null && (intValue = num.intValue()) > i) {
                i = intValue;
            }
        }
        return i;
    }

    /* renamed from: g */
    private void m232g() {
        this.f291A = new C0618a();
    }

    /* renamed from: h */
    private boolean m233h() {
        Map<Api<?>, Api.ApiOptions> map = this.f305n;
        if (map == null) {
            return false;
        }
        for (Api<?> apiName : map.keySet()) {
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(apiName.getApiName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    private void m234i() {
        Handler handler = this.f315x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.f315x = new Handler(Looper.getMainLooper(), new C0619b());
        }
        this.f315x.sendEmptyMessageDelayed(2, 5000);
    }

    /* renamed from: j */
    private void m235j() {
        synchronized (f290C) {
            if (this.f316y != null) {
                this.f316y.removeMessages(3);
            } else {
                this.f316y = new Handler(Looper.getMainLooper(), new C0620c());
            }
            boolean sendEmptyMessageDelayed = this.f316y.sendEmptyMessageDelayed(3, 3000);
            HMSLog.m1374d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + sendEmptyMessageDelayed);
        }
    }

    /* renamed from: k */
    private void m236k() {
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, m225c()).setResultCallback(new C0623f(this, (C0618a) null));
    }

    /* renamed from: l */
    private void m237l() {
        ConnectService.disconnect(this, m228d()).setResultCallback(new C0625g(this, (C0618a) null));
    }

    /* renamed from: m */
    private void m238m() {
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, m225c()).setResultCallback(new C0623f(this, (C0618a) null));
    }

    /* renamed from: n */
    private void m239n() {
        if (this.f301j) {
            HMSLog.m1379i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f293b) == 0) {
            ConnectService.getNotice(this, 0, "5.2.0.300").setResultCallback(new C0627h(this, (C0618a) null));
        }
    }

    /* renamed from: o */
    private void m240o() {
        Util.unBindServiceCatchException(this.f293b, this);
        this.f297f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i, ResultCallback<BundleResult> resultCallback) {
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback == null || str == null || bundle == null) {
            HMSLog.m1377e("HuaweiApiClientImpl", "arguments is invalid.");
            return CommonCode.ErrorCode.ARGUMENTS_INVALID;
        } else if (!innerIsConnected()) {
            HMSLog.m1377e("HuaweiApiClientImpl", "client is unConnect.");
            return CommonCode.ErrorCode.CLIENT_API_INVALID;
        } else {
            C0702b bVar = new C0702b(str, i);
            C0710e a = C0701a.m423a(bVar.mo13626c());
            bVar.mo13624a(bundle);
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 50200300, getSessionId());
            requestHeader.setApiNameList(getApiNameList());
            bVar.f437b = a.mo13636a((IMessageEntity) requestHeader, new Bundle());
            try {
                getService().mo13634a(bVar, new C0621d(this, resultCallback));
                return 0;
            } catch (RemoteException e) {
                HMSLog.m1377e("HuaweiApiClientImpl", "remote exception:" + e.getMessage());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
    }

    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (Util.isAvailableLibExist(this.f293b)) {
            HMSLog.m1379i("HuaweiApiClientImpl", "Enter checkUpdate");
            if (checkUpdatelistener == null) {
                HMSLog.m1377e("HuaweiApiClientImpl", "listener is null!");
            } else if (activity == null || activity.isFinishing()) {
                HMSLog.m1377e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + activity);
                checkUpdatelistener.onResult(-1);
            } else {
                this.f317z = checkUpdatelistener;
                if (this.f291A == null) {
                    m232g();
                }
                UpdateSdkAPI.checkClientOTAUpdate(activity, this.f291A, true, 0, true);
            }
        } else {
            HMSLog.m1379i("HuaweiApiClientImpl", "available lib does not exist.");
        }
    }

    public void connect(Activity activity) {
        HMSLog.m1379i("HuaweiApiClientImpl", "====== HMSSDK version: 50200300 ======");
        int i = this.f302k.get();
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i);
        if (i != 3 && i != 5 && i != 2 && i != 4) {
            if (activity != null) {
                this.f299h = new WeakReference<>(activity);
                this.f300i = new WeakReference<>(activity);
            }
            this.f295d = TextUtils.isEmpty(this.f294c) ? Util.getAppId(this.f293b) : this.f294c;
            int e = m230e();
            HMSLog.m1379i("HuaweiApiClientImpl", "connect minVersion:" + e);
            HuaweiApiAvailability.setServicesVersionCode(e);
            int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.f293b, e);
            HMSLog.m1379i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
            this.f308q = HMSPackageManager.getInstance(this.f293b).getHmsVersionCode();
            if (isHuaweiMobileServicesAvailable == 0) {
                m226c(5);
                if (this.f297f == null) {
                    m214a();
                    return;
                }
                m226c(2);
                m236k();
                m235j();
            } else if (this.f314w != null) {
                m222b(isHuaweiMobileServicesAvailable);
            }
        }
    }

    public void connectForeground() {
        HMSLog.m1379i("HuaweiApiClientImpl", "====== HMSSDK version: 50200300 ======");
        int i = this.f302k.get();
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i);
        if (i != 3 && i != 5 && i != 2 && i != 4) {
            this.f295d = TextUtils.isEmpty(this.f294c) ? Util.getAppId(this.f293b) : this.f294c;
            m238m();
        }
    }

    public void disableLifeCycleManagement(Activity activity) {
        if (this.f292a >= 0) {
            AutoLifecycleFragment instance = AutoLifecycleFragment.getInstance(activity);
            if (instance != null) {
                instance.stopAutoManage(this.f292a);
                return;
            }
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    public PendingResult<Status> discardAndReconnect() {
        return new C0622e(this, (String) null, (IMessageEntity) null);
    }

    public void disconnect() {
        int i = this.f302k.get();
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i);
        if (i == 1) {
            return;
        }
        if (i == 2) {
            m226c(4);
        } else if (i == 3) {
            m226c(4);
            m237l();
        } else if (i != 4 && i == 5) {
            m215a(2);
            m226c(4);
        }
    }

    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.f305n;
    }

    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f305n;
        if (map != null) {
            for (Api<?> apiName : map.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return arrayList;
    }

    public String getAppID() {
        return this.f295d;
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.f312u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.f312u;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    public Context getContext() {
        return this.f293b;
    }

    public String getCpID() {
        return this.f296e;
    }

    public String getPackageName() {
        return this.f293b.getPackageName();
    }

    public List<PermissionInfo> getPermissionInfos() {
        return this.f304m;
    }

    public List<Scope> getScopes() {
        return this.f303l;
    }

    public C0707d getService() {
        return this.f297f;
    }

    public String getSessionId() {
        return this.f298g;
    }

    public final SubAppInfo getSubAppInfo() {
        return this.f306o;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.f300i;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f309r) {
            if (this.f314w == onConnectionFailedListener) {
                return true;
            }
            return false;
        }
    }

    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f309r) {
            if (this.f313v == connectionCallbacks) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|11|12|5) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.api.ConnectionResult holdUpConnect() {
        /*
            r3 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0067
            java.util.concurrent.locks.ReentrantLock r0 = r3.f310s
            r0.lock()
            r0 = 0
            r3.connect((android.app.Activity) r0)     // Catch:{ all -> 0x0060 }
        L_0x0013:
            boolean r1 = r3.isConnecting()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0033
            java.util.concurrent.locks.Condition r1 = r3.f311t     // Catch:{ InterruptedException -> 0x001f }
            r1.await()     // Catch:{ InterruptedException -> 0x001f }
            goto L_0x0013
        L_0x001f:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0060 }
            r1.interrupt()     // Catch:{ all -> 0x0060 }
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0060 }
            r2 = 15
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0060 }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f310s
            r0.unlock()
            return r1
        L_0x0033:
            boolean r1 = r3.isConnected()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0047
            r3.f312u = r0     // Catch:{ all -> 0x0060 }
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0060 }
            r2 = 0
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0060 }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f310s
            r0.unlock()
            return r1
        L_0x0047:
            com.huawei.hms.api.ConnectionResult r1 = r3.f312u     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0053
            com.huawei.hms.api.ConnectionResult r0 = r3.f312u     // Catch:{ all -> 0x0060 }
            java.util.concurrent.locks.ReentrantLock r1 = r3.f310s
            r1.unlock()
            return r0
        L_0x0053:
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0060 }
            r2 = 13
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0060 }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f310s
            r0.unlock()
            return r1
        L_0x0060:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r3.f310s
            r1.unlock()
            throw r0
        L_0x0067:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            r0.<init>(r1)
            goto L_0x0070
        L_0x006f:
            throw r0
        L_0x0070:
            goto L_0x006f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.holdUpConnect():com.huawei.hms.api.ConnectionResult");
    }

    public boolean innerIsConnected() {
        return this.f302k.get() == 3 || this.f302k.get() == 4;
    }

    public boolean isConnected() {
        if (this.f308q == 0) {
            this.f308q = HMSPackageManager.getInstance(this.f293b).getHmsVersionCode();
        }
        if (this.f308q >= 20504000) {
            return innerIsConnected();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f307p;
        if (currentTimeMillis > 0 && currentTimeMillis < Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL) {
            return innerIsConnected();
        }
        if (!innerIsConnected()) {
            return false;
        }
        Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000, TimeUnit.MILLISECONDS).getStatus();
        if (status.isSuccess()) {
            this.f307p = System.currentTimeMillis();
            return true;
        }
        int statusCode = status.getStatusCode();
        HMSLog.m1379i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
        if (statusCode == 907135004) {
            return false;
        }
        m240o();
        m226c(1);
        this.f307p = System.currentTimeMillis();
        return false;
    }

    public boolean isConnecting() {
        int i = this.f302k.get();
        return i == 2 || i == 5;
    }

    public void onPause(Activity activity) {
        HMSLog.m1379i("HuaweiApiClientImpl", "onPause");
    }

    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.m1379i("HuaweiApiClientImpl", "onResume");
            this.f300i = new WeakReference<>(activity);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter onServiceConnected.");
        m215a(2);
        this.f297f = C0707d.C0708a.m432a(iBinder);
        if (this.f297f == null) {
            HMSLog.m1377e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            m240o();
            m226c(1);
            if (this.f314w != null) {
                PendingIntent pendingIntent = null;
                WeakReference<Activity> weakReference = this.f299h;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity) this.f299h.get(), 10);
                }
                ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                this.f314w.onConnectionFailed(connectionResult);
                this.f312u = connectionResult;
            }
        } else if (this.f302k.get() == 5) {
            m226c(2);
            m236k();
            m235j();
        } else if (this.f302k.get() != 3) {
            m240o();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f297f = null;
        m226c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f313v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f309r) {
            if (this.f314w != onConnectionFailedListener) {
                HMSLog.m1380w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.f314w = null;
            }
        }
    }

    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f309r) {
            if (this.f313v != connectionCallbacks) {
                HMSLog.m1380w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.f313v = null;
            }
        }
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.f305n = map;
    }

    /* access modifiers changed from: protected */
    public void setAutoLifecycleClientId(int i) {
        this.f292a = i;
    }

    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f313v = connectionCallbacks;
    }

    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f314w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z) {
        this.f301j = z;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f304m = list;
    }

    public void setScopes(List<Scope> list) {
        this.f303l = list;
    }

    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.m1377e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.m1377e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.f294c) ? Util.getAppId(this.f293b) : this.f294c)) {
            HMSLog.m1377e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.f306o = new SubAppInfo(subAppInfo);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m226c(int i) {
        this.f302k.set(i);
        if (i == 1 || i == 3 || i == 2) {
            this.f310s.lock();
            try {
                this.f311t.signalAll();
            } finally {
                this.f310s.unlock();
            }
        }
    }

    /* renamed from: d */
    private DisconnectInfo m228d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f305n;
        if (map != null) {
            for (Api<?> apiName : map.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return new DisconnectInfo(this.f303l, arrayList);
    }

    /* renamed from: b */
    private void m222b(int i) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.f299h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity) this.f299h.get(), i);
            HMSLog.m1379i("HuaweiApiClientImpl", "connect 2.0 fail: " + i);
        }
        ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
        this.f314w.onConnectionFailed(connectionResult);
        this.f312u = connectionResult;
    }

    /* renamed from: a */
    private void m214a() {
        Intent intent = new Intent("com.huawei.hms.core.aidlservice");
        HMSPackageManager.getInstance(this.f293b).refresh();
        intent.setPackage(HMSPackageManager.getInstance(this.f293b).getHMSPackageName());
        synchronized (f289B) {
            if (this.f293b.bindService(intent, this, 1)) {
                m234i();
                return;
            }
            m226c(1);
            HMSLog.m1377e("HuaweiApiClientImpl", "In connect, bind core service fail");
            m221b();
        }
    }

    /* renamed from: c */
    private ConnectInfo m225c() {
        String packageSignature = new PackageManagerHelper(this.f293b).getPackageSignature(this.f293b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.f306o;
        return new ConnectInfo(getApiNameList(), this.f303l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m221b() {
        m240o();
        if (this.f314w != null) {
            int i = UIUtil.isBackground(this.f293b) ? 7 : 6;
            PendingIntent pendingIntent = null;
            WeakReference<Activity> weakReference = this.f299h;
            if (!(weakReference == null || weakReference.get() == null)) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity) this.f299h.get(), i);
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            this.f314w.onConnectionFailed(connectionResult);
            this.f312u = connectionResult;
        }
    }

    /* renamed from: a */
    private void m215a(int i) {
        if (i == 2) {
            synchronized (f289B) {
                if (this.f315x != null) {
                    this.f315x.removeMessages(i);
                    this.f315x = null;
                }
            }
        }
        if (i == 3) {
            synchronized (f290C) {
                if (this.f316y != null) {
                    this.f316y.removeMessages(i);
                    this.f316y = null;
                }
            }
        }
        synchronized (f289B) {
            if (this.f315x != null) {
                this.f315x.removeMessages(2);
                this.f315x = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m224b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        m240o();
        m226c(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m218a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f297f == null || this.f302k.get() != 2) {
            HMSLog.m1377e("HuaweiApiClientImpl", "Invalid onConnectionResult");
            return;
        }
        m215a(3);
        ConnectResp value = resolveResult.getValue();
        if (value != null) {
            this.f298g = value.sessionId;
        }
        SubAppInfo subAppInfo = this.f306o;
        PendingIntent pendingIntent = null;
        String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
        if (!TextUtils.isEmpty(subAppID)) {
            this.f295d = subAppID;
        }
        int statusCode = resolveResult.getStatus().getStatusCode();
        HMSLog.m1379i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
        if (Status.SUCCESS.equals(resolveResult.getStatus())) {
            if (resolveResult.getValue() != null) {
                ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
            }
            m226c(3);
            this.f312u = null;
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f313v;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnected();
            }
            if (this.f299h != null) {
                m239n();
            }
            for (Map.Entry next : getApiMap().entrySet()) {
                if (((Api) next.getKey()).getmConnetctPostList() != null && !((Api) next.getKey()).getmConnetctPostList().isEmpty()) {
                    HMSLog.m1379i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                    for (ConnectionPostProcessor run : ((Api) next.getKey()).getmConnetctPostList()) {
                        HMSLog.m1379i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                        run.run(this, this.f299h);
                    }
                }
            }
        } else if (resolveResult.getStatus() == null || resolveResult.getStatus().getStatusCode() != 1001) {
            m240o();
            m226c(1);
            if (this.f314w != null) {
                WeakReference<Activity> weakReference = this.f299h;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity) this.f299h.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                this.f314w.onConnectionFailed(connectionResult);
                this.f312u = connectionResult;
            }
        } else {
            m240o();
            m226c(1);
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks2 = this.f313v;
            if (connectionCallbacks2 != null) {
                connectionCallbacks2.onConnectionSuspended(3);
            }
        }
    }

    public void connect(int i) {
        connect((Activity) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        return new com.huawei.hms.api.ConnectionResult(15, (android.app.PendingIntent) null);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.api.ConnectionResult holdUpConnect(long r4, java.util.concurrent.TimeUnit r6) {
        /*
            r3 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0082
            java.util.concurrent.locks.ReentrantLock r0 = r3.f310s
            r0.lock()
            r0 = 0
            r3.connect((android.app.Activity) r0)     // Catch:{ all -> 0x007b }
            long r4 = r6.toNanos(r4)     // Catch:{ all -> 0x007b }
        L_0x0017:
            boolean r6 = r3.isConnecting()     // Catch:{ all -> 0x007b }
            if (r6 == 0) goto L_0x004e
            r1 = 0
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x0033
            r3.disconnect()     // Catch:{ all -> 0x007b }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x007b }
            r5 = 14
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x007b }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f310s
            r5.unlock()
            return r4
        L_0x0033:
            java.util.concurrent.locks.Condition r6 = r3.f311t     // Catch:{ InterruptedException -> 0x003a }
            long r4 = r6.awaitNanos(r4)     // Catch:{ InterruptedException -> 0x003a }
            goto L_0x0017
        L_0x003a:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x007b }
            r4.interrupt()     // Catch:{ all -> 0x007b }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x007b }
            r5 = 15
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x007b }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f310s
            r5.unlock()
            return r4
        L_0x004e:
            boolean r4 = r3.isConnected()     // Catch:{ all -> 0x007b }
            if (r4 == 0) goto L_0x0062
            r3.f312u = r0     // Catch:{ all -> 0x007b }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x007b }
            r5 = 0
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x007b }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f310s
            r5.unlock()
            return r4
        L_0x0062:
            com.huawei.hms.api.ConnectionResult r4 = r3.f312u     // Catch:{ all -> 0x007b }
            if (r4 == 0) goto L_0x006e
            com.huawei.hms.api.ConnectionResult r4 = r3.f312u     // Catch:{ all -> 0x007b }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f310s
            r5.unlock()
            return r4
        L_0x006e:
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x007b }
            r5 = 13
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x007b }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f310s
            r5.unlock()
            return r4
        L_0x007b:
            r4 = move-exception
            java.util.concurrent.locks.ReentrantLock r5 = r3.f310s
            r5.unlock()
            throw r4
        L_0x0082:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "blockingConnect must not be called on the UI thread"
            r4.<init>(r5)
            goto L_0x008b
        L_0x008a:
            throw r4
        L_0x008b:
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.holdUpConnect(long, java.util.concurrent.TimeUnit):com.huawei.hms.api.ConnectionResult");
    }
}
