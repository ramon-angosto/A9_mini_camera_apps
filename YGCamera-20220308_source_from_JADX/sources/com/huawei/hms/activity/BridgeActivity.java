package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.p023ui.SafeIntent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import java.lang.reflect.InvocationTargetException;

public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final String EXTRA_INTENT = "intent.extra.intent";
    public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";

    /* renamed from: b */
    public static final int f243b = m176a("ro.build.hw_emui_api_level", 0);

    /* renamed from: a */
    public IBridgeActivityDelegate f244a;

    /* renamed from: com.huawei.hms.activity.BridgeActivity$a */
    public class C0607a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f245a;

        public C0607a(BridgeActivity bridgeActivity, ViewGroup viewGroup) {
            this.f245a = viewGroup;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            try {
                Object invoke = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", new Class[]{WindowInsets.class}).invoke((Object) null, new Object[]{windowInsets});
                if (invoke == null) {
                    HMSLog.m1379i("BridgeActivity", "sideRegion is null");
                } else {
                    Rect rect = (Rect) Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(invoke, new Object[0]);
                    if (this.f245a != null) {
                        this.f245a.setPadding(rect.left, 0, rect.right, 0);
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                HMSLog.m1377e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e.getMessage());
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    /* renamed from: a */
    public static void m177a(Window window, boolean z) {
        try {
            Class<?> cls = window.getClass();
            cls.getMethod("setHwFloating", new Class[]{Boolean.TYPE}).invoke(window, new Object[]{Boolean.valueOf(z)});
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            HMSLog.m1377e("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e.getMessage());
        }
    }

    public static Intent getIntentStartBridgeActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
        return intent;
    }

    /* renamed from: b */
    public final boolean mo12975b() {
        Intent intent = getIntent();
        if (intent == null) {
            HMSLog.m1377e("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        if (intent.getBooleanExtra(EXTRA_IS_FULLSCREEN, false)) {
            getWindow().setFlags(1024, 1024);
        }
        String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
        if (stringExtra == null) {
            HMSLog.m1377e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
            return false;
        }
        try {
            this.f244a = (IBridgeActivityDelegate) Class.forName(stringExtra).asSubclass(IBridgeActivityDelegate.class).newInstance();
            try {
                this.f244a.onBridgeActivityCreate(this);
                return true;
            } catch (RuntimeException e) {
                HMSLog.m1377e("BridgeActivity", "Run time Exception." + e.getMessage());
                return false;
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            HMSLog.m1377e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e2.getMessage());
            return false;
        }
    }

    /* renamed from: c */
    public final void mo12976c() {
        requestWindowFeature(1);
        Window window = getWindow();
        if (f243b >= 9) {
            window.addFlags(67108864);
            m177a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(0);
    }

    public void finish() {
        HMSLog.m1379i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    public Intent getIntent() {
        Intent intent = super.getIntent();
        return intent != null ? new SafeIntent(intent) : intent;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        super.onActivityResult(i, i2, safeIntent);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f244a;
        if (iBridgeActivityDelegate != null && !iBridgeActivityDelegate.onBridgeActivityResult(i, i2, safeIntent) && !isFinishing()) {
            setResult(i2, safeIntent);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f244a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeConfigurationChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            mo12976c();
            mo12974a();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(getApplicationContext());
            }
            if (!mo12975b()) {
                setResult(1, (Intent) null);
                finish();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f244a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f244a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    public static Intent getIntentStartBridgeActivity(Context context, String str) {
        Intent intent = new Intent(context, BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, false);
        return intent;
    }

    /* renamed from: a */
    public final void mo12974a() {
        ViewGroup viewGroup = (ViewGroup) getWindow().findViewById(16908290);
        if (viewGroup == null) {
            HMSLog.m1377e("BridgeActivity", "rootView is null");
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
            Object newInstance = cls.getDeclaredConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{attributes});
            cls.getMethod("setDisplaySideMode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{1});
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            HMSLog.m1377e("BridgeActivity", "An exception occurred while reading: setDisplaySideMode" + e.getMessage());
        }
        if (Build.VERSION.SDK_INT >= 20) {
            getWindow().getDecorView().setOnApplyWindowInsetsListener(new C0607a(this, viewGroup));
        }
    }

    /* renamed from: a */
    public static int m176a(String str, int i) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{str, Integer.valueOf(i)})).intValue();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.m1377e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
            return i;
        }
    }
}
