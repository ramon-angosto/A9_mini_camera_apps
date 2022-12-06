package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.p023ui.AbstractDialog;
import com.huawei.hms.p023ui.AbstractPromptDialog;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

public class BindingFailedResolution implements IBridgeActivityDelegate, ServiceConnection {

    /* renamed from: f */
    private static final Object f267f = new Object();

    /* renamed from: a */
    private Activity f268a;

    /* renamed from: b */
    private boolean f269b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0616d f270c;

    /* renamed from: d */
    private Handler f271d = null;

    /* renamed from: e */
    private Handler f272e = null;

    /* renamed from: com.huawei.hms.api.BindingFailedResolution$a */
    class C0613a implements Handler.Callback {
        C0613a() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            BindingFailedResolution.this.m200a(8);
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.BindingFailedResolution$b */
    class C0614b implements Handler.Callback {
        C0614b() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.m1377e("BindingFailedResolution", "In connect, bind core try timeout");
            BindingFailedResolution.this.m204a(false);
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.BindingFailedResolution$c */
    class C0615c implements AbstractDialog.Callback {
        C0615c() {
        }

        public void onCancel(AbstractDialog abstractDialog) {
            C0616d unused = BindingFailedResolution.this.f270c = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.m200a(8);
        }

        public void onDoWork(AbstractDialog abstractDialog) {
            C0616d unused = BindingFailedResolution.this.f270c = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.m200a(8);
        }
    }

    /* renamed from: com.huawei.hms.api.BindingFailedResolution$d */
    private static class C0616d extends AbstractPromptDialog {
        private C0616d() {
        }

        /* access modifiers changed from: protected */
        public String onGetMessageString(Context context) {
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message", Util.getAppName(context, (String) null), Util.getAppName(context, HMSPackageManager.getInstance(context).getHMSPackageName()));
        }

        /* access modifiers changed from: protected */
        public String onGetPositiveButtonString(Context context) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        /* synthetic */ C0616d(C0613a aVar) {
            this();
        }
    }

    /* renamed from: b */
    private void m205b() {
        synchronized (f267f) {
            if (this.f271d != null) {
                this.f271d.removeMessages(2);
                this.f271d = null;
            }
        }
    }

    /* renamed from: c */
    private void m206c() {
        Handler handler = this.f271d;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.f271d = new Handler(Looper.getMainLooper(), new C0614b());
        }
        this.f271d.sendEmptyMessageDelayed(2, 5000);
    }

    /* renamed from: d */
    private void m207d() {
        Handler handler = this.f272e;
        if (handler != null) {
            handler.removeMessages(3);
        } else {
            this.f272e = new Handler(Looper.getMainLooper(), new C0613a());
        }
        this.f272e.sendEmptyMessageDelayed(3, 4000);
    }

    /* renamed from: e */
    private void m208e() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            C0616d dVar = this.f270c;
            if (dVar == null) {
                this.f270c = new C0616d((C0613a) null);
            } else {
                dVar.dismiss();
            }
            HMSLog.m1379i("BindingFailedResolution", "showPromptdlg to resolve conn error");
            this.f270c.show(activity, new C0615c());
        }
    }

    /* access modifiers changed from: protected */
    public Activity getActivity() {
        return this.f268a;
    }

    public int getRequestCode() {
        return 2003;
    }

    public void onBridgeActivityCreate(Activity activity) {
        this.f268a = activity;
        C0628a.f340b.mo13209a(this.f268a);
        m207d();
        m201a(activity);
    }

    public void onBridgeActivityDestroy() {
        m205b();
        C0628a.f340b.mo13210b(this.f268a);
        this.f268a = null;
    }

    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        HMSLog.m1379i("BindingFailedResolution", "onBridgeActivityResult");
        Handler handler = this.f272e;
        if (handler != null) {
            handler.removeMessages(3);
            this.f272e = null;
        }
        m199a();
        return true;
    }

    public void onBridgeConfigurationChanged() {
        if (this.f270c != null) {
            HMSLog.m1379i("BindingFailedResolution", "re show prompt dialog");
            m208e();
        }
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m1379i("BindingFailedResolution", "On key up when resolve conn error");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m205b();
        m204a(true);
        Activity activity = getActivity();
        if (activity != null) {
            Util.unBindServiceCatchException(activity, this);
            HMSLog.m1379i("BindingFailedResolution", "test connect success, try to reConnect and reply message");
            BindResolveClients.getInstance().notifyClientReconnect();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    /* access modifiers changed from: protected */
    public void onStartResult(boolean z) {
        if (getActivity() != null) {
            if (z) {
                m200a(0);
            } else {
                m208e();
            }
        }
    }

    /* renamed from: a */
    private void m201a(Activity activity) {
        Intent intent = new Intent();
        intent.setClassName(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName(), HuaweiApiAvailability.ACTIVITY_NAME);
        HMSLog.m1379i("BindingFailedResolution", "onBridgeActivityCreate：try to start HMS");
        try {
            activity.startActivityForResult(intent, getRequestCode());
        } catch (Throwable th) {
            HMSLog.m1377e("BindingFailedResolution", "ActivityNotFoundException：" + th.getMessage());
            Handler handler = this.f272e;
            if (handler != null) {
                handler.removeMessages(3);
                this.f272e = null;
            }
            m199a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m204a(boolean z) {
        if (this.f269b) {
            this.f269b = false;
            onStartResult(z);
        }
    }

    /* renamed from: a */
    private void m199a() {
        Activity activity = getActivity();
        if (activity == null) {
            HMSLog.m1377e("BindingFailedResolution", "In connect, bind core try fail");
            m204a(false);
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.aidlservice");
        intent.setPackage(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName());
        synchronized (f267f) {
            if (activity.bindService(intent, this, 1)) {
                m206c();
                return;
            }
            HMSLog.m1377e("BindingFailedResolution", "In connect, bind core try fail");
            m204a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m200a(int i) {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            HMSLog.m1379i("BindingFailedResolution", "finishBridgeActivity：" + i);
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }
}
