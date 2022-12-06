package com.huawei.hms.adapter.p012ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.adapter.ui.BaseResolutionAdapter */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a */
    public WeakReference<Activity> f259a;

    /* renamed from: b */
    public String f260b = "";

    /* renamed from: a */
    public final void mo13068a() {
        Activity b = mo13069b();
        if (b != null && !b.isFinishing()) {
            b.finish();
        }
    }

    /* renamed from: b */
    public final Activity mo13069b() {
        WeakReference<Activity> weakReference = this.f259a;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    /* renamed from: c */
    public final void mo13070c() {
        SystemManager.getInstance().notifyResolutionResult((Intent) null, this.f260b);
        mo13068a();
    }

    public int getRequestCode() {
        return 1001;
    }

    public void onBridgeActivityCreate(Activity activity) {
        this.f259a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            mo13070c();
            return;
        }
        Bundle extras = intent.getExtras();
        this.f260b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
        if (extras == null) {
            mo13070c();
            return;
        }
        Parcelable parcelable = extras.getParcelable(CommonCode.MapKey.HAS_RESOLUTION);
        if (parcelable == null) {
            mo13070c();
        } else if (parcelable instanceof Intent) {
            try {
                activity.startActivityForResult((Intent) parcelable, 1001);
            } catch (ActivityNotFoundException unused) {
                mo13070c();
                HMSLog.m1377e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
            }
        } else if (parcelable instanceof PendingIntent) {
            try {
                activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, (Intent) null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused2) {
                mo13070c();
                HMSLog.m1377e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    public void onBridgeActivityDestroy() {
        HMSLog.m1379i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f259a = null;
    }

    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        HMSLog.m1379i("BaseResolutionAdapter", "onBridgeActivityResult");
        if (i2 == -1 || intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f260b);
        } else {
            SystemManager.getInstance().notifyResolutionResult((Intent) null, this.f260b);
        }
        mo13068a();
        return true;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.m1379i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m1379i("BaseResolutionAdapter", "On key up when resolve conn error");
    }
}
