package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.environment.h;
import com.ironsource.sdk.a.f;
import com.ironsource.sdk.controller.x;
import com.ironsource.sdk.g.b;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.i.a;
import com.ironsource.sdk.j.g;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.Map;

public class ControllerActivity extends Activity implements w, g {
    private static final String a = ControllerActivity.class.getSimpleName();
    private static String b = "removeWebViewContainerView | mContainer is null";
    private static String c = "removeWebViewContainerView | view is null";
    public int currentRequestedRotation = -1;
    private String d;
    private x e;
    private RelativeLayout f;
    private FrameLayout g;
    /* access modifiers changed from: private */
    public boolean h = false;
    private String i;
    /* access modifiers changed from: private */
    public Handler j = new Handler();
    /* access modifiers changed from: private */
    public final Runnable k = new Runnable() {
        public final void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(ControllerActivity.this.h));
        }
    };
    private RelativeLayout.LayoutParams l = new RelativeLayout.LayoutParams(-1, -1);
    private b m;
    private boolean n;
    private boolean o;

    private void a() {
        Logger.i(a, "clearWebviewController");
        x xVar = this.e;
        if (xVar == null) {
            Logger.i(a, "clearWebviewController, null");
            return;
        }
        xVar.j = x.g.Gone;
        x xVar2 = this.e;
        xVar2.l = null;
        xVar2.v = null;
        xVar2.a(this.i, "onDestroy");
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        if ("landscape".equalsIgnoreCase(str)) {
            b();
        } else if ("portrait".equalsIgnoreCase(str)) {
            c();
        } else if ("device".equalsIgnoreCase(str)) {
            if (h.q(this)) {
                setRequestedOrientation(1);
            }
        } else if (getRequestedOrientation() == -1) {
            setRequestedOrientation(4);
        }
    }

    private void b() {
        int k2 = h.k(this);
        Logger.i(a, "setInitiateLandscapeOrientation");
        if (k2 == 0) {
            Logger.i(a, "ROTATION_0");
            setRequestedOrientation(0);
        } else if (k2 == 2) {
            Logger.i(a, "ROTATION_180");
            setRequestedOrientation(8);
        } else if (k2 == 3) {
            Logger.i(a, "ROTATION_270 Right Landscape");
            setRequestedOrientation(8);
        } else if (k2 == 1) {
            Logger.i(a, "ROTATION_90 Left Landscape");
            setRequestedOrientation(0);
        } else {
            Logger.i(a, "No Rotation");
        }
    }

    private void c() {
        int k2 = h.k(this);
        Logger.i(a, "setInitiatePortraitOrientation");
        if (k2 == 0) {
            Logger.i(a, "ROTATION_0");
            setRequestedOrientation(1);
        } else if (k2 == 2) {
            Logger.i(a, "ROTATION_180");
            setRequestedOrientation(9);
        } else if (k2 == 1) {
            Logger.i(a, "ROTATION_270 Right Landscape");
            setRequestedOrientation(1);
        } else if (k2 == 3) {
            Logger.i(a, "ROTATION_90 Left Landscape");
            setRequestedOrientation(1);
        } else {
            Logger.i(a, "No Rotation");
        }
    }

    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        Logger.i(a, "onBackPressed");
        new a();
        if (!a.a(this)) {
            super.onBackPressed();
        }
    }

    public void onCloseRequested() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Logger.i(a, "onCreate");
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            this.e = (x) com.ironsource.sdk.d.b.a((Context) this).a.a;
            this.e.i.setId(1);
            this.e.v = this;
            this.e.l = this;
            Intent intent = getIntent();
            this.i = intent.getStringExtra("productType");
            this.h = intent.getBooleanExtra("immersive", false);
            this.d = intent.getStringExtra("adViewId");
            this.n = false;
            this.o = intent.getBooleanExtra("ctrWVPauseResume", false);
            if (this.h) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    public final void onSystemUiVisibilityChange(int i) {
                        if ((i & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                            ControllerActivity.this.j.removeCallbacks(ControllerActivity.this.k);
                            ControllerActivity.this.j.postDelayed(ControllerActivity.this.k, 500);
                        }
                    }
                });
                runOnUiThread(this.k);
            }
            if (!TextUtils.isEmpty(this.i) && d.e.OfferWall.toString().equalsIgnoreCase(this.i)) {
                if (bundle != null) {
                    b bVar = (b) bundle.getParcelable(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                    if (bVar != null) {
                        this.m = bVar;
                        this.e.a(bVar);
                    }
                    finish();
                } else {
                    this.m = this.e.m;
                }
            }
            this.f = new RelativeLayout(this);
            setContentView(this.f, this.l);
            String str = this.d;
            this.g = !(!TextUtils.isEmpty(str) && !str.equals(Integer.toString(1))) ? this.e.i : com.ironsource.sdk.utils.d.a(getApplicationContext(), com.ironsource.sdk.c.d.a().a(str).b());
            if (this.f.findViewById(1) == null && this.g.getParent() != null) {
                finish();
            }
            Intent intent2 = getIntent();
            String stringExtra = intent2.getStringExtra("orientation_set_flag");
            intent2.getIntExtra("rotation_set_flag", 0);
            a(stringExtra);
            this.f.addView(this.g, this.l);
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        Logger.i(a, "onDestroy");
        try {
            if (this.f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.g.getParent();
                View findViewById = this.d == null ? viewGroup2.findViewById(1) : com.ironsource.sdk.c.d.a().a(this.d).b();
                if (findViewById != null) {
                    if (isFinishing() && (viewGroup = (ViewGroup) findViewById.getParent()) != null) {
                        viewGroup.removeView(findViewById);
                    }
                    viewGroup2.removeView(this.g);
                    if (!this.n) {
                        Logger.i(a, "onDestroy | destroyedFromBackground");
                        a();
                        return;
                    }
                    return;
                }
                throw new Exception(c);
            }
            throw new Exception(b);
        } catch (Exception e2) {
            com.ironsource.sdk.a.d.a(f.p, (Map<String, Object>) new com.ironsource.sdk.a.a().a("callfailreason", e2.getMessage()).a);
            String str = a;
            Logger.i(str, "removeWebViewContainerView fail " + e2.getMessage());
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.e.h != null) {
                this.e.g.onHideCustomView();
                return true;
            }
        }
        if (this.h && (i2 == 25 || i2 == 24)) {
            this.j.removeCallbacks(this.k);
            this.j.postDelayed(this.k, 500);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onOrientationChanged(String str, int i2) {
        a(str);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        String str = a;
        Logger.i(str, "onPause, isFinishing=" + isFinishing());
        com.ironsource.environment.e.a.a.b(new Runnable((AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO)) {
            private /* synthetic */ AudioManager a;

            {
                this.a = r1;
            }

            public final void run() {
                try {
                    this.a.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        x xVar = this.e;
        if (xVar != null) {
            xVar.b((Context) this);
            if (!this.o) {
                this.e.k();
            }
            this.e.a(false, "main");
            this.e.a(this.i, "onPause");
        }
        if (isFinishing()) {
            this.n = true;
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Logger.i(a, "onResume");
        x xVar = this.e;
        if (xVar != null) {
            xVar.a((Context) this);
            if (!this.o) {
                this.e.l();
            }
            this.e.a(true, "main");
            this.e.a(this.i, "onResume");
        }
        com.ironsource.environment.e.a.a.b(new Runnable((AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO)) {
            private /* synthetic */ AudioManager a;

            {
                this.a = r1;
            }

            public final void run() {
                try {
                    this.a.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!TextUtils.isEmpty(this.i) && d.e.OfferWall.toString().equalsIgnoreCase(this.i)) {
            b bVar = this.m;
            bVar.d = true;
            bundle.putParcelable(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, bVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Logger.i(a, "onStart");
        x xVar = this.e;
        if (xVar != null) {
            xVar.a(this.i, "onStart");
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Logger.i(a, "onStop");
        x xVar = this.e;
        if (xVar != null) {
            xVar.a(this.i, "onStop");
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(a, "onUserLeaveHint");
        x xVar = this.e;
        if (xVar != null) {
            xVar.a(this.i, "onUserLeaveHint");
        }
    }

    public void onVideoEnded() {
        toggleKeepScreen(false);
    }

    public void onVideoPaused() {
        toggleKeepScreen(false);
    }

    public void onVideoResumed() {
        toggleKeepScreen(true);
    }

    public void onVideoStarted() {
        toggleKeepScreen(true);
    }

    public void onVideoStopped() {
        toggleKeepScreen(false);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.h && z) {
            runOnUiThread(this.k);
        }
    }

    public void setRequestedOrientation(int i2) {
        if (this.currentRequestedRotation != i2) {
            String str = a;
            Logger.i(str, "Rotation: Req = " + i2 + " Curr = " + this.currentRequestedRotation);
            this.currentRequestedRotation = i2;
            super.setRequestedOrientation(i2);
        }
    }

    public void toggleKeepScreen(boolean z) {
        runOnUiThread(z ? new Runnable() {
            public final void run() {
                ControllerActivity.this.getWindow().addFlags(128);
            }
        } : new Runnable() {
            public final void run() {
                ControllerActivity.this.getWindow().clearFlags(128);
            }
        });
    }
}
