package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.nativex.view.mbfullview.BaseView;
import java.lang.ref.WeakReference;

/* compiled from: FullViewManager */
public class a {
    private static volatile a b;
    private WeakReference<Context> a;

    private a(Context context) {
        this.a = new WeakReference<>(context);
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
        return b;
    }

    /* renamed from: com.mbridge.msdk.nativex.view.mbfullview.a$a  reason: collision with other inner class name */
    /* compiled from: FullViewManager */
    private class C0072a implements c {
        private WeakReference<MBridgeTopFullView> b;

        public final void onFailedLoad(String str, String str2) {
        }

        public C0072a(MBridgeTopFullView mBridgeTopFullView) {
            this.b = new WeakReference<>(mBridgeTopFullView);
        }

        public final void onSuccessLoad(Bitmap bitmap, String str) {
            WeakReference<MBridgeTopFullView> weakReference = this.b;
            if (weakReference != null && weakReference.get() != null) {
                ((MBridgeTopFullView) this.b.get()).getMBridgeFullViewDisplayIcon().setImageBitmap(a.a(a.this, bitmap, 25));
            }
        }
    }

    /* renamed from: com.mbridge.msdk.nativex.view.mbfullview.a$2  reason: invalid class name */
    /* compiled from: FullViewManager */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[BaseView.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.mbridge.msdk.nativex.view.mbfullview.BaseView$a[] r0 = com.mbridge.msdk.nativex.view.mbfullview.BaseView.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.mbridge.msdk.nativex.view.mbfullview.BaseView$a r1 = com.mbridge.msdk.nativex.view.mbfullview.BaseView.a.FULL_TOP_VIEW     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.mbridge.msdk.nativex.view.mbfullview.BaseView$a r1 = com.mbridge.msdk.nativex.view.mbfullview.BaseView.a.FULL_MIDDLE_VIEW     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.nativex.view.mbfullview.a.AnonymousClass2.<clinit>():void");
        }
    }

    public final void a(BaseView.a aVar, CampaignEx campaignEx, BaseView baseView) {
        int i = AnonymousClass2.a[aVar.ordinal()];
        if (i == 1) {
            MBridgeTopFullView mBridgeTopFullView = (MBridgeTopFullView) baseView;
            if (mBridgeTopFullView != null) {
                Context context = (Context) this.a.get();
                if (context != null) {
                    b.a(context).a(campaignEx.getIconUrl(), (c) new C0072a(mBridgeTopFullView));
                }
                mBridgeTopFullView.getMBridgeFullViewDisplayTitle().setText(campaignEx.getAppName());
                mBridgeTopFullView.getMBridgeFullViewDisplayDscription().setText(campaignEx.getAppDesc());
                mBridgeTopFullView.getMBridgeFullTvInstall().setText(campaignEx.getAdCall());
                mBridgeTopFullView.getStarLevelLayoutView().setRating((int) campaignEx.getRating());
            }
        } else if (i == 2) {
            baseView.getMBridgeFullTvInstall().setText(campaignEx.getAdCall());
        }
    }

    public final void a(boolean z, BaseView baseView, int i) {
        RelativeLayout.LayoutParams layoutParams;
        Context context = (Context) this.a.get();
        if (context != null) {
            if (z) {
                layoutParams = new RelativeLayout.LayoutParams((int) (a(z) / 3.0f), u.b(context, 45.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = u.b(context, 10.0f);
                layoutParams.rightMargin = u.a(context) && i == 0 ? u.k(context) + u.b(context, 8.0f) : u.b(context, 8.0f);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, u.b(context, 45.0f));
                layoutParams.addRule(12);
            }
            baseView.getmAnimationContent().setLayoutParams(layoutParams);
        }
    }

    private float a(boolean z) {
        try {
            Context context = (Context) this.a.get();
            if (context == null) {
                return 0.0f;
            }
            float i = (float) u.i(context);
            return z ? i + ((float) u.k(context)) : i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final void a(final boolean z, boolean z2, final BaseView baseView) {
        int parseColor = Color.parseColor("#ff264870");
        baseView.getmAnimationPlayer().setBackgroundColor(parseColor);
        Context context = (Context) this.a.get();
        if (z) {
            if (baseView.style == BaseView.a.FULL_TOP_VIEW && context != null) {
                baseView.getmAnimationContent().setBackgroundResource(k.a(context, "mbridge_nativex_fullview_background", "drawable"));
                baseView.getmAnimationPlayer().setBackgroundColor(parseColor);
            }
            if (z2) {
                baseView.getmAnimationPlayer().getBackground().setAlpha(80);
            } else {
                baseView.getmAnimationPlayer().setBackgroundColor(Color.parseColor("#ff4c8fdf"));
                baseView.getmAnimationPlayer().getBackground().setAlpha(200);
            }
        } else if (baseView.style != BaseView.a.FULL_MIDDLE_VIEW) {
            if (context != null) {
                baseView.getmAnimationContent().setBackgroundResource(k.a(context, "mbridge_nativex_cta_por_pre", "drawable"));
                baseView.getmAnimationPlayer().setBackgroundResource(k.a(context, "mbridge_nativex_cta_por_pre", "drawable"));
                return;
            }
            return;
        }
        if (z2) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    baseView.getmAnimationPlayer().setBackgroundColor(Color.parseColor("#ff4c8fdf"));
                    baseView.getmAnimationPlayer().getBackground().setAlpha(z ? 200 : 255);
                    a.a(a.this, (View) baseView.getmAnimationPlayer());
                }
            }, 1000);
        }
    }

    public final void a(View view, BaseView baseView) {
        if (view != null && baseView != null) {
            view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            baseView.i.addView(view);
        }
    }

    public final void a(BaseView baseView, boolean z) {
        if (baseView != null && Build.VERSION.SDK_INT >= 11) {
            baseView.setSystemUiVisibility(z ? 0 : InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    static /* synthetic */ Bitmap a(a aVar, Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        bitmap.getWidth();
        float f = (float) i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    static /* synthetic */ void a(a aVar, View view) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
            alphaAnimation.setDuration(800);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setRepeatCount(2);
            alphaAnimation.setRepeatMode(1);
            view.startAnimation(alphaAnimation);
        }
    }
}
