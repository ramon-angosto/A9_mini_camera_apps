package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.tools.q;

public abstract class MBBaseActivity extends Activity {
    /* access modifiers changed from: private */
    public OrientationEventListener a;
    private Display b;
    /* access modifiers changed from: private */
    public int c = -1;

    public abstract void setTopControllerPadding(int i, int i2, int i3, int i4, int i5);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            a();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e) {
            q.d("MBBaseActivity", e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!b.c) {
            getNotchParams();
            a();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.a;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.a = null;
        }
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:36:0x00ca A[Catch:{ Exception -> 0x00d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r13 = this;
                    java.lang.String r0 = "MBBaseActivity"
                    int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d0 }
                    r2 = 23
                    if (r1 < r2) goto L_0x00d8
                    com.mbridge.msdk.activity.MBBaseActivity r1 = com.mbridge.msdk.activity.MBBaseActivity.this     // Catch:{ Exception -> 0x00d0 }
                    android.view.Window r1 = r1.getWindow()     // Catch:{ Exception -> 0x00d0 }
                    android.view.View r1 = r1.getDecorView()     // Catch:{ Exception -> 0x00d0 }
                    android.view.WindowInsets r1 = r1.getRootWindowInsets()     // Catch:{ Exception -> 0x00d0 }
                    r2 = -1
                    r3 = 0
                    if (r1 == 0) goto L_0x00b8
                    int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d0 }
                    r5 = 28
                    if (r4 < r5) goto L_0x00b8
                    android.view.DisplayCutout r1 = r1.getDisplayCutout()     // Catch:{ Exception -> 0x00d0 }
                    if (r1 == 0) goto L_0x00b8
                    int r4 = r1.getSafeInsetLeft()     // Catch:{ Exception -> 0x00d0 }
                    int r5 = r1.getSafeInsetRight()     // Catch:{ Exception -> 0x00d0 }
                    int r6 = r1.getSafeInsetTop()     // Catch:{ Exception -> 0x00d0 }
                    int r1 = r1.getSafeInsetBottom()     // Catch:{ Exception -> 0x00d0 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0 }
                    r7.<init>()     // Catch:{ Exception -> 0x00d0 }
                    java.lang.String r8 = "NOTCH Left:"
                    r7.append(r8)     // Catch:{ Exception -> 0x00d0 }
                    r7.append(r4)     // Catch:{ Exception -> 0x00d0 }
                    java.lang.String r8 = " Right:"
                    r7.append(r8)     // Catch:{ Exception -> 0x00d0 }
                    r7.append(r5)     // Catch:{ Exception -> 0x00d0 }
                    java.lang.String r8 = " Top:"
                    r7.append(r8)     // Catch:{ Exception -> 0x00d0 }
                    r7.append(r6)     // Catch:{ Exception -> 0x00d0 }
                    java.lang.String r8 = " Bottom:"
                    r7.append(r8)     // Catch:{ Exception -> 0x00d0 }
                    r7.append(r1)     // Catch:{ Exception -> 0x00d0 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00d0 }
                    com.mbridge.msdk.foundation.tools.q.d(r0, r7)     // Catch:{ Exception -> 0x00d0 }
                    com.mbridge.msdk.activity.MBBaseActivity r7 = com.mbridge.msdk.activity.MBBaseActivity.this     // Catch:{ Exception -> 0x00d0 }
                    int r7 = com.mbridge.msdk.activity.MBBaseActivity.a(r7)     // Catch:{ Exception -> 0x00d0 }
                    com.mbridge.msdk.activity.MBBaseActivity r8 = com.mbridge.msdk.activity.MBBaseActivity.this     // Catch:{ Exception -> 0x00d0 }
                    int r8 = r8.c     // Catch:{ Exception -> 0x00d0 }
                    r9 = 3
                    r10 = 2
                    r11 = 1
                    if (r8 != r2) goto L_0x00a3
                    com.mbridge.msdk.activity.MBBaseActivity r8 = com.mbridge.msdk.activity.MBBaseActivity.this     // Catch:{ Exception -> 0x00d0 }
                    if (r7 != 0) goto L_0x0079
                    r12 = r9
                    goto L_0x0086
                L_0x0079:
                    if (r7 != r11) goto L_0x007d
                    r12 = r11
                    goto L_0x0086
                L_0x007d:
                    if (r7 != r10) goto L_0x0081
                    r12 = 4
                    goto L_0x0086
                L_0x0081:
                    if (r7 != r9) goto L_0x0085
                    r12 = r10
                    goto L_0x0086
                L_0x0085:
                    r12 = r2
                L_0x0086:
                    int unused = r8.c = r12     // Catch:{ Exception -> 0x00d0 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0 }
                    r8.<init>()     // Catch:{ Exception -> 0x00d0 }
                    com.mbridge.msdk.activity.MBBaseActivity r12 = com.mbridge.msdk.activity.MBBaseActivity.this     // Catch:{ Exception -> 0x00d0 }
                    int r12 = r12.c     // Catch:{ Exception -> 0x00d0 }
                    r8.append(r12)     // Catch:{ Exception -> 0x00d0 }
                    java.lang.String r12 = ""
                    r8.append(r12)     // Catch:{ Exception -> 0x00d0 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00d0 }
                    com.mbridge.msdk.foundation.tools.q.d(r0, r8)     // Catch:{ Exception -> 0x00d0 }
                L_0x00a3:
                    if (r7 == 0) goto L_0x00b6
                    if (r7 == r11) goto L_0x00b3
                    if (r7 == r10) goto L_0x00b0
                    if (r7 == r9) goto L_0x00ad
                L_0x00ab:
                    r7 = r1
                    goto L_0x00bc
                L_0x00ad:
                    r2 = 270(0x10e, float:3.78E-43)
                    goto L_0x00ab
                L_0x00b0:
                    r2 = 180(0xb4, float:2.52E-43)
                    goto L_0x00ab
                L_0x00b3:
                    r2 = 90
                    goto L_0x00ab
                L_0x00b6:
                    r7 = r1
                    goto L_0x00bd
                L_0x00b8:
                    r4 = r3
                    r5 = r4
                    r6 = r5
                    r7 = r6
                L_0x00bc:
                    r3 = r2
                L_0x00bd:
                    com.mbridge.msdk.activity.MBBaseActivity r2 = com.mbridge.msdk.activity.MBBaseActivity.this     // Catch:{ Exception -> 0x00d0 }
                    r2.setTopControllerPadding(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00d0 }
                    com.mbridge.msdk.activity.MBBaseActivity r1 = com.mbridge.msdk.activity.MBBaseActivity.this     // Catch:{ Exception -> 0x00d0 }
                    android.view.OrientationEventListener r1 = r1.a     // Catch:{ Exception -> 0x00d0 }
                    if (r1 != 0) goto L_0x00d8
                    com.mbridge.msdk.activity.MBBaseActivity r1 = com.mbridge.msdk.activity.MBBaseActivity.this     // Catch:{ Exception -> 0x00d0 }
                    com.mbridge.msdk.activity.MBBaseActivity.d(r1)     // Catch:{ Exception -> 0x00d0 }
                    goto L_0x00d8
                L_0x00d0:
                    r1 = move-exception
                    java.lang.String r1 = r1.getMessage()
                    com.mbridge.msdk.foundation.tools.q.d(r0, r1)
                L_0x00d8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.activity.MBBaseActivity.AnonymousClass1.run():void");
            }
        }, 500);
    }

    private void a() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(67108864);
                getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                return;
            }
            getWindow().getDecorView().setSystemUiVisibility(2);
        } catch (Throwable th) {
            q.d("MBBaseActivity", th.getMessage());
        }
    }

    static /* synthetic */ int a(MBBaseActivity mBBaseActivity) {
        if (mBBaseActivity.b == null) {
            mBBaseActivity.b = ((WindowManager) mBBaseActivity.getSystemService("window")).getDefaultDisplay();
        }
        Display display = mBBaseActivity.b;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }

    static /* synthetic */ void d(MBBaseActivity mBBaseActivity) {
        mBBaseActivity.a = new OrientationEventListener(mBBaseActivity, 1) {
            public final void onOrientationChanged(int i) {
                if (MBBaseActivity.a(MBBaseActivity.this) == 1 && MBBaseActivity.this.c != 1) {
                    int unused = MBBaseActivity.this.c = 1;
                    MBBaseActivity.this.getNotchParams();
                    q.d("MBBaseActivity", "Orientation Left");
                } else if (MBBaseActivity.a(MBBaseActivity.this) == 3 && MBBaseActivity.this.c != 2) {
                    int unused2 = MBBaseActivity.this.c = 2;
                    MBBaseActivity.this.getNotchParams();
                    q.d("MBBaseActivity", "Orientation Right");
                } else if (MBBaseActivity.a(MBBaseActivity.this) == 0 && MBBaseActivity.this.c != 3) {
                    int unused3 = MBBaseActivity.this.c = 3;
                    MBBaseActivity.this.getNotchParams();
                    q.d("MBBaseActivity", "Orientation Top");
                } else if (MBBaseActivity.a(MBBaseActivity.this) == 2 && MBBaseActivity.this.c != 4) {
                    int unused4 = MBBaseActivity.this.c = 4;
                    MBBaseActivity.this.getNotchParams();
                    q.d("MBBaseActivity", "Orientation Bottom");
                }
            }
        };
        if (mBBaseActivity.a.canDetectOrientation()) {
            mBBaseActivity.a.enable();
            return;
        }
        mBBaseActivity.a.disable();
        mBBaseActivity.a = null;
    }
}
