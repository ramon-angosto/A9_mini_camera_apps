package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.p012ui.UpdateAdapter;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class AvailableAdapter {

    /* renamed from: d */
    public static AtomicBoolean f246d = new AtomicBoolean(false);

    /* renamed from: e */
    public static int f247e = 0;

    /* renamed from: a */
    public final int f248a;

    /* renamed from: b */
    public AvailableCallBack f249b;

    /* renamed from: c */
    public SystemObserver f250c = new C0609a();

    public interface AvailableCallBack {
        void onComplete(int i);
    }

    /* renamed from: com.huawei.hms.adapter.AvailableAdapter$a */
    public class C0609a implements SystemObserver {
        public C0609a() {
        }

        public boolean onSolutionResult(Intent intent, String str) {
            return false;
        }

        public boolean onUpdateResult(int i) {
            AvailableCallBack a = AvailableAdapter.this.mo13022a();
            if (a == null) {
                HMSLog.m1377e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            a.onComplete(i);
            int unused = AvailableAdapter.f247e = i;
            HMSLog.m1379i("AvailableAdapter", "user response " + AvailableAdapter.f247e);
            AvailableAdapter.f246d.set(false);
            return true;
        }
    }

    public AvailableAdapter(int i) {
        this.f248a = i;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        if (Build.VERSION.SDK_INT < 16) {
            HMSLog.m1379i("AvailableAdapter", "HMS can not be supported under android 4.1");
            return 21;
        }
        HMSPackageManager instance = HMSPackageManager.getInstance(context);
        PackageManagerHelper.PackageStates hMSPackageStates = instance.getHMSPackageStates();
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStates)) {
            HMSLog.m1379i("AvailableAdapter", "HMS is not installed");
            return 1;
        } else if (PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStates)) {
            HMSLog.m1379i("AvailableAdapter", "HMS is disabled");
            return 3;
        } else if (!instance.isApkUpdateNecessary(this.f248a)) {
            return 0;
        } else {
            HMSLog.m1379i("AvailableAdapter", "The current version does not meet the minimum version requirements");
            return 2;
        }
    }

    public boolean isUserResolvableError(int i) {
        return i == 1 || i == 2;
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        if (activity != null && availableCallBack != null) {
            if (UIUtil.isBackground(activity)) {
                HMSLog.m1379i("AvailableAdapter", "current app is in Background");
                availableCallBack.onComplete(28);
            } else if (!f246d.get() || Looper.getMainLooper() == Looper.myLooper()) {
                if (f246d.compareAndSet(false, true)) {
                    HMSLog.m1379i("AvailableAdapter", "Start to resolution for the 1st time.");
                } else if (Looper.getMainLooper() == Looper.myLooper()) {
                    HMSLog.m1379i("AvailableAdapter", "main thread invokes resolution.");
                }
                HMSLog.m1379i("AvailableAdapter", "startResolution");
                this.f249b = availableCallBack;
                SystemManager.getSystemNotifier().registerObserver(this.f250c);
                Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
                intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, this.f248a);
                intentStartBridgeActivity.putExtra(CommonCode.MapKey.NEW_UPDATE, mo13024a(activity));
                activity.startActivity(intentStartBridgeActivity);
            } else {
                HMSLog.m1379i("AvailableAdapter", "Another thread start to resolution.");
                mo13023a(availableCallBack);
            }
        }
    }

    /* renamed from: a */
    public final void mo13023a(AvailableCallBack availableCallBack) {
        int i = 0;
        while (f246d.get()) {
            if (i >= 300) {
                HMSLog.m1379i("AvailableAdapter", "Previous popup is not handled by user or download has not finished within 1min.");
                if (availableCallBack != null) {
                    availableCallBack.onComplete(27);
                    return;
                }
                return;
            }
            try {
                HMSLog.m1374d("AvailableAdapter", "Concurrent startResolution thread is waiting.");
                Thread.sleep(200);
                i++;
            } catch (InterruptedException unused) {
                HMSLog.m1374d("AvailableAdapter", "Concurrent startResolution thread waiting is interrupted.");
            }
        }
        HMSLog.m1379i("AvailableAdapter", "Concurrent startResolution thread waiting finished.");
        if (availableCallBack != null) {
            availableCallBack.onComplete(f247e);
        }
    }

    /* renamed from: a */
    public final boolean mo13024a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).getHmsVersionCode() < 40000000) {
            return false;
        }
        HMSLog.m1379i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
        return true;
    }

    /* renamed from: a */
    public final AvailableCallBack mo13022a() {
        return this.f249b;
    }
}
