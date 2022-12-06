package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p024ui.UpdateBean;
import com.huawei.hms.utils.NetWorkUtil;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.huawei.hms.availableupdate.n */
/* compiled from: AbsUpdateWizard */
public abstract class C0660n implements IBridgeActivityDelegate {

    /* renamed from: a */
    public WeakReference<Activity> f398a;

    /* renamed from: b */
    public IBridgeActivityDelegate f399b;

    /* renamed from: c */
    public UpdateBean f400c = null;

    /* renamed from: d */
    public C0661o f401d = null;

    /* renamed from: e */
    public boolean f402e = false;

    /* renamed from: f */
    public int f403f = -1;

    /* renamed from: g */
    public String f404g = null;

    /* renamed from: h */
    public String f405h = null;

    /* renamed from: i */
    public int f406i = 0;

    /* renamed from: a */
    public static String m343a(int i) {
        if (i == 0) {
            return C0646e0.class.getName();
        }
        if (i == 5) {
            return C0675x.class.getName();
        }
        if (i != 6) {
            return i != 7 ? "" : C0663p.class.getName();
        }
        return C0650f0.class.getName();
    }

    /* renamed from: a */
    public void mo13255a(C0661o oVar) {
    }

    /* renamed from: a */
    public abstract void mo13242a(Class<? extends C0661o> cls);

    /* renamed from: b */
    public Activity mo13285b() {
        WeakReference<Activity> weakReference = this.f398a;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    /* renamed from: b */
    public void mo13258b(C0661o oVar) {
    }

    /* renamed from: c */
    public void mo13287c(int i, int i2) {
        Activity b = mo13285b();
        if (b != null && !b.isFinishing()) {
            mo13280a(i, i2);
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, getClass().getName());
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
            b.setResult(-1, intent);
            b.finish();
        }
    }

    public void onBridgeActivityCreate(Activity activity) {
        this.f398a = new WeakReference<>(activity);
        if (this.f400c == null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                this.f400c = (UpdateBean) intent.getSerializableExtra(BridgeActivity.EXTRA_DELEGATE_UPDATE_INFO);
                if (this.f400c == null) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f404g = this.f400c.mo14628b();
        this.f405h = this.f400c.getClientAppName();
        this.f406i = this.f400c.mo14629c();
        this.f400c.mo14627a();
        this.f399b = null;
        this.f402e = false;
        this.f403f = -1;
    }

    public void onBridgeActivityDestroy() {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        this.f398a = null;
        mo13279a();
        if (this.f402e && (iBridgeActivityDelegate = this.f399b) != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
    }

    public void onBridgeConfigurationChanged() {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        if (!this.f402e || (iBridgeActivityDelegate = this.f399b) == null) {
            C0661o oVar = this.f401d;
            if (oVar != null) {
                Class<?> cls = oVar.getClass();
                this.f401d.mo13290b();
                this.f401d = null;
                mo13242a((Class<? extends C0661o>) cls);
                return;
            }
            return;
        }
        iBridgeActivityDelegate.onBridgeConfigurationChanged();
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        if (this.f402e && (iBridgeActivityDelegate = this.f399b) != null) {
            iBridgeActivityDelegate.onKeyUp(i, keyEvent);
        }
    }

    /* renamed from: b */
    public final String mo13286b(int i, int i2) {
        String valueOf = String.valueOf(i);
        if (i2 == 0) {
            return "0000" + valueOf;
        } else if (i2 == 5) {
            return "5000" + valueOf;
        } else if (i2 != 6) {
            return valueOf;
        } else {
            return "4000" + valueOf;
        }
    }

    /* renamed from: a */
    public void mo13279a() {
        C0661o oVar = this.f401d;
        if (oVar != null) {
            try {
                oVar.mo13290b();
                this.f401d = null;
            } catch (IllegalStateException e) {
                HMSLog.m1377e("AbsUpdateWizard", "In dismissDialog, Failed to dismiss the dialog." + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public void mo13280a(int i, int i2) {
        if (!SystemUtils.isChinaROM()) {
            HMSLog.m1379i("AbsUpdateWizard", "not ChinaROM ");
            return;
        }
        Activity b = mo13285b();
        if (b != null && !b.isFinishing()) {
            int packageVersionCode = new PackageManagerHelper(b).getPackageVersionCode(this.f404g);
            HashMap hashMap = new HashMap();
            hashMap.put("package", b.getPackageName());
            hashMap.put(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, this.f404g);
            hashMap.put(HiAnalyticsConstant.BI_KEY_TARGET_VER, String.valueOf(packageVersionCode));
            hashMap.put(HiAnalyticsConstant.BI_KEY_SDK_VER, String.valueOf(50200300));
            hashMap.put("app_id", AGCUtils.getAppId(b));
            hashMap.put(HiAnalyticsConstant.BI_KEY_TRIGGER_API, "core.connnect");
            hashMap.put(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE, String.valueOf(i2));
            hashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(NetWorkUtil.getNetworkType(b)));
            hashMap.put("result", mo13286b(i, i2));
            HiAnalyticsUtils.getInstance().onEvent(b, HiAnalyticsConstant.BI_TYPE_UPDATE, hashMap);
        }
    }

    /* renamed from: a */
    public boolean mo13284a(boolean z) {
        Activity b = mo13285b();
        boolean z2 = false;
        if (b == null) {
            return false;
        }
        ArrayList typeList = this.f400c.getTypeList();
        if (typeList.size() > 0) {
            typeList.remove(0);
        }
        if (this.f399b == null) {
            mo13282a(typeList);
        }
        if (this.f399b != null) {
            z2 = true;
            this.f402e = true;
            this.f400c.setTypeList(typeList);
            this.f400c.setNeedConfirm(z);
            IBridgeActivityDelegate iBridgeActivityDelegate = this.f399b;
            if (iBridgeActivityDelegate instanceof C0660n) {
                ((C0660n) iBridgeActivityDelegate).mo13281a(this.f400c);
            }
            this.f399b.onBridgeActivityCreate(b);
        }
        return z2;
    }

    /* renamed from: a */
    public final void mo13282a(ArrayList arrayList) {
        String a = (arrayList == null || arrayList.size() <= 0) ? null : m343a(((Integer) arrayList.get(0)).intValue());
        if (a != null) {
            try {
                this.f399b = (IBridgeActivityDelegate) Class.forName(a).asSubclass(IBridgeActivityDelegate.class).newInstance();
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                HMSLog.m1377e("AbsUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public final void mo13281a(UpdateBean updateBean) {
        this.f400c = updateBean;
    }

    /* renamed from: a */
    public boolean mo13283a(String str, int i) {
        Activity b;
        if (!TextUtils.isEmpty(str) && (b = mo13285b()) != null && !b.isFinishing() && new PackageManagerHelper(b).getPackageVersionCode(str) >= i) {
            return true;
        }
        return false;
    }
}
