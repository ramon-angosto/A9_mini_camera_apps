package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.view.PointerIconCompat;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class ResolutionDelegate implements IBridgeActivityDelegate {
    public static final String CALLBACK_METHOD = "CALLBACK_METHOD";

    /* renamed from: a */
    private WeakReference<Activity> f338a;

    /* renamed from: a */
    private void m246a() {
        Activity b = m247b();
        if (b != null && !b.isFinishing()) {
            b.finish();
        }
    }

    /* renamed from: b */
    private Activity m247b() {
        WeakReference<Activity> weakReference = this.f338a;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public int getRequestCode() {
        return PointerIconCompat.TYPE_HAND;
    }

    public void onBridgeActivityCreate(Activity activity) {
        this.f338a = new WeakReference<>(activity);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            activity.startActivityForResult((Intent) extras.getParcelable(CommonCode.MapKey.HAS_RESOLUTION), PointerIconCompat.TYPE_HAND);
        }
    }

    public void onBridgeActivityDestroy() {
        this.f338a = null;
    }

    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        BusResponseCallback a = m245a(CALLBACK_METHOD);
        int isHuaweiMobileServicesAvailable = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable((Activity) this.f338a.get(), 30000000);
        if (i2 == -1 && isHuaweiMobileServicesAvailable == 0) {
            HMSLog.m1379i("ResolutionDelegate", "Make service available success.");
        } else {
            a.innerError((Activity) this.f338a.get(), i2, "Make service available failed.");
        }
        m246a();
        return true;
    }

    public void onBridgeConfigurationChanged() {
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
    }

    /* renamed from: a */
    private BusResponseCallback m245a(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }
}
