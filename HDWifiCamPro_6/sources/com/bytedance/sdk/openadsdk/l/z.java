package com.bytedance.sdk.openadsdk.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.utils.d;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: UIUtils */
public class z {
    private static float a = -1.0f;
    private static int b = -1;
    private static float c = -1.0f;
    private static int d = -1;
    private static int e = -1;
    private static WindowManager f;

    public static void a(Context context, n nVar, String str, WebView webView) {
    }

    private static boolean a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    static {
        a(m.a());
    }

    private static boolean a() {
        return a < 0.0f || b < 0 || c < 0.0f || d < 0 || e < 0;
    }

    public static void a(Context context) {
        a(context, false);
    }

    public static void a(Context context, boolean z) {
        Context a2 = context == null ? m.a() : context;
        if (a2 != null) {
            f = (WindowManager) a2.getSystemService("window");
            if (a() || z) {
                DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
                a = displayMetrics.density;
                b = displayMetrics.densityDpi;
                c = displayMetrics.scaledDensity;
                d = displayMetrics.widthPixels;
                e = displayMetrics.heightPixels;
            }
            if (context != null && context.getResources() != null && context.getResources().getConfiguration() != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    int i = d;
                    int i2 = e;
                    if (i > i2) {
                        d = i2;
                        e = i;
                        return;
                    }
                    return;
                }
                int i3 = d;
                int i4 = e;
                if (i3 < i4) {
                    d = i4;
                    e = i3;
                }
            }
        }
    }

    public static int a(Context context, float f2) {
        a(context);
        float f3 = f(context);
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static float b(Context context, float f2) {
        return a(context, f2, true);
    }

    public static float a(Context context, float f2, boolean z) {
        a(context);
        return (f2 * e(context)) + (z ? 0.5f : 0.0f);
    }

    public static int c(Context context, float f2) {
        a(context, true);
        float e2 = e(context);
        if (e2 <= 0.0f) {
            e2 = 1.0f;
        }
        return (int) ((f2 / e2) + 0.5f);
    }

    public static int[] b(Context context) {
        if (context == null) {
            return null;
        }
        if (f == null) {
            f = (WindowManager) m.a().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = f;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
                try {
                    i = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    i2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    Point point = new Point();
                    Display.class.getMethod("getRealSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
                    i = point.x;
                    i2 = point.y;
                } catch (Exception unused2) {
                }
            }
            iArr[0] = i;
            iArr[1] = i2;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int c(Context context) {
        a(context);
        return d;
    }

    public static int d(Context context) {
        a(context);
        return e;
    }

    public static float e(Context context) {
        a(context, true);
        return a;
    }

    public static float f(Context context) {
        a(context);
        return c;
    }

    public static int g(Context context) {
        a(context);
        return b;
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new g(rect, view));
    }

    public static int[] a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] b(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] c(View view) {
        if (view == null) {
            return null;
        }
        return new int[]{view.getWidth(), view.getHeight()};
    }

    public static void a(View view, int i) {
        if (view != null && view.getVisibility() != i && a(i)) {
            view.setVisibility(i);
        }
    }

    public static boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
        }
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            a(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
        }
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view != null && marginLayoutParams != null) {
            if (marginLayoutParams.leftMargin != i || marginLayoutParams.topMargin != i2 || marginLayoutParams.rightMargin != i3 || marginLayoutParams.bottomMargin != i4) {
                if (i != -3) {
                    marginLayoutParams.leftMargin = i;
                }
                if (i2 != -3) {
                    marginLayoutParams.topMargin = i2;
                }
                if (i3 != -3) {
                    marginLayoutParams.rightMargin = i3;
                }
                if (i4 != -3) {
                    marginLayoutParams.bottomMargin = i4;
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private static Bitmap a(WebView webView) {
        Bitmap bitmap = null;
        try {
            Picture capturePicture = webView.capturePicture();
            bitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            capturePicture.draw(new Canvas(bitmap));
            return bitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmap;
        }
    }

    public static void e(final View view) {
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    z.a(view, 8);
                    ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f}).setDuration(0).start();
                }
            });
            ofFloat.setDuration(800);
            ofFloat.start();
        }
    }

    public static void f(View view) {
        if (view != null) {
            a(view, 0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
            ofFloat.setDuration(300);
            ofFloat.start();
        }
    }

    public static Pair<Integer, Integer> h(Context context) {
        if (context == null) {
            context = m.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static int i(Context context) {
        return ((Integer) h(context).second).intValue();
    }

    public static int j(Context context) {
        return ((Integer) h(context).first).intValue();
    }

    public static float k(Context context) {
        if (context == null) {
            context = m.a();
        }
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return (float) context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            try {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(3846);
                    activity.getWindow().addFlags(1792);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(Activity activity) {
        if (activity != null) {
            try {
                activity.getWindow().getDecorView().setSystemUiVisibility(1792);
                activity.getWindow().clearFlags(1792);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(Activity activity) {
        if (d(activity) || a("ro.miui.notch", activity) == 1 || l(activity) || p(activity) || m(activity) || n(activity) || o(activity)) {
            return true;
        }
        return false;
    }

    public static boolean d(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        DisplayCutout displayCutout = null;
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets != null) {
                displayCutout = rootWindowInsets.getDisplayCutout();
            }
            if (displayCutout != null) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int a(String str, Activity activity) {
        if (!p.e()) {
            return 0;
        }
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(loadClass, new Object[]{new String(str), new Integer(0)})).intValue();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return 0;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
            return 0;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean l(android.content.Context r3) {
        /*
            r0 = 0
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.String r1 = "com.huawei.android.util.HwNotchSizeUtil"
            java.lang.Class r3 = r3.loadClass(r1)     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.String r1 = "hasNotchInScreen"
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.reflect.Method r1 = r3.getMethod(r1, r2)     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.Object r3 = r1.invoke(r3, r2)     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x0022, all -> 0x0020 }
            boolean r0 = r3.booleanValue()     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x0022, all -> 0x0020 }
            goto L_0x0022
        L_0x0020:
            r3 = move-exception
            throw r3
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.z.l(android.content.Context):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m(android.content.Context r5) {
        /*
            r0 = 0
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            java.lang.String r1 = "android.util.FtFeature"
            java.lang.Class r5 = r5.loadClass(r1)     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            java.lang.String r1 = "isFeatureSupport"
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            r3[r0] = r4     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            java.lang.reflect.Method r1 = r5.getMethod(r1, r3)     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            r3 = 32
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            r2[r0] = r3     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            java.lang.Object r5 = r1.invoke(r5, r2)     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            boolean r0 = r5.booleanValue()     // Catch:{ ClassNotFoundException | Exception | NoSuchMethodException -> 0x002f, all -> 0x002d }
            goto L_0x002f
        L_0x002d:
            r5 = move-exception
            throw r5
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.z.m(android.content.Context):boolean");
    }

    public static boolean n(Context context) {
        return Build.MODEL.equals("IN2010") || Build.MODEL.equals("IN2020") || Build.MODEL.equals("KB2000") || Build.MODEL.startsWith("ONEPLUS");
    }

    public static boolean o(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string == null || TextUtils.isEmpty(string)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean p(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            l.e("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            l.e("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void a(View view, float f2) {
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    public static void a(TextView textView, TTRatingBar2 tTRatingBar2, n nVar, Context context) {
        a(textView, tTRatingBar2, (nVar == null || nVar.aa() == null) ? -1.0d : nVar.aa().d(), context);
    }

    public static void a(TextView textView, TTRatingBar2 tTRatingBar2, double d2, Context context) {
        if (d2 == -1.0d) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            tTRatingBar2.setVisibility(8);
            return;
        }
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f", new Object[]{Double.valueOf(d2)}));
        }
        a(tTRatingBar2, d2, 0, 14);
    }

    public static void a(TTRatingBar2 tTRatingBar2, double d2, int i, int i2) {
        if (d2 < 0.0d) {
            tTRatingBar2.setVisibility(8);
            return;
        }
        tTRatingBar2.setVisibility(0);
        tTRatingBar2.a(d2, i, i2);
    }

    public static void a(TextView textView, n nVar, Context context, String str) {
        a(textView, nVar.aa() != null ? nVar.aa().e() : -1, context, str);
    }

    public static void a(TextView textView, int i, Context context, String str) {
        StringBuilder sb;
        String str2;
        String a2 = t.a(context, str);
        if (i > 10000) {
            sb = new StringBuilder();
            sb.append(i / 1000);
            str2 = CampaignEx.JSON_KEY_AD_K;
        } else {
            sb = new StringBuilder();
            sb.append(i);
            str2 = "";
        }
        sb.append(str2);
        textView.setText(String.format(a2, new Object[]{sb.toString()}));
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    public static Bitmap a(SSWebView sSWebView) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        WebView webView = sSWebView.getWebView();
        int layerType = webView.getLayerType();
        webView.setLayerType(1, (Paint) null);
        Bitmap b2 = b(sSWebView);
        if (b2 == null) {
            b2 = a(webView);
        }
        webView.setLayerType(layerType, (Paint) null);
        if (b2 == null) {
            return null;
        }
        return d.a(b2, b2.getWidth() / 6, b2.getHeight() / 6);
    }

    public static void a(n nVar, String str, String str2, Bitmap bitmap, String str3, long j) {
        final n nVar2 = nVar;
        final String str4 = str;
        final String str5 = str2;
        final Bitmap bitmap2 = bitmap;
        final String str6 = str3;
        final long j2 = j;
        e.b(new com.bytedance.sdk.component.g.g("startCheckPlayableStatusPercentage") {
            public void run() {
                z.c(nVar2, str4, str5, bitmap2, str6, j2);
            }
        }, 5);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(18:9|10|11|12|(1:14)|15|(1:17)(1:18)|19|(1:21)(1:22)|23|(1:25)|26|27|28|29|32|33|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0078 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(com.bytedance.sdk.openadsdk.core.model.n r4, java.lang.String r5, java.lang.String r6, android.graphics.Bitmap r7, java.lang.String r8, long r9) {
        /*
            if (r7 == 0) goto L_0x009b
            int r0 = r7.getWidth()     // Catch:{ all -> 0x0080 }
            if (r0 <= 0) goto L_0x009b
            int r0 = r7.getHeight()     // Catch:{ all -> 0x0080 }
            if (r0 <= 0) goto L_0x009b
            boolean r0 = r7.isRecycled()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0016
            goto L_0x009b
        L_0x0016:
            int r7 = a((android.graphics.Bitmap) r7)     // Catch:{ all -> 0x0080 }
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0077 }
            r1.<init>()     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r2 = "url"
            r1.put(r2, r8)     // Catch:{ JSONException -> 0x0077 }
            r2 = -1
            int r8 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0030
            java.lang.String r8 = "page_id"
            r1.put(r8, r9)     // Catch:{ JSONException -> 0x0077 }
        L_0x0030:
            java.lang.String r8 = "render_type"
            java.lang.String r9 = "h5"
            r1.put(r8, r9)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r8 = "render_type_2"
            r9 = 0
            r1.put(r8, r9)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r8 = "is_blank"
            r10 = 100
            r2 = 1
            if (r7 != r10) goto L_0x0046
            r7 = r2
            goto L_0x0047
        L_0x0046:
            r7 = r9
        L_0x0047:
            r1.put(r8, r7)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r7 = "is_playable"
            boolean r8 = com.bytedance.sdk.openadsdk.core.model.p.a((com.bytedance.sdk.openadsdk.core.model.n) r4)     // Catch:{ JSONException -> 0x0077 }
            if (r8 == 0) goto L_0x0054
            r8 = r2
            goto L_0x0055
        L_0x0054:
            r8 = r9
        L_0x0055:
            r1.put(r7, r8)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r7 = "usecache"
            com.bytedance.sdk.openadsdk.core.video.b.a r8 = com.bytedance.sdk.openadsdk.core.video.b.a.a()     // Catch:{ JSONException -> 0x0077 }
            boolean r8 = r8.a((com.bytedance.sdk.openadsdk.core.model.n) r4)     // Catch:{ JSONException -> 0x0077 }
            if (r8 == 0) goto L_0x0065
            r9 = r2
        L_0x0065:
            r1.put(r7, r9)     // Catch:{ JSONException -> 0x0077 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0077 }
            r7.<init>()     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r8 = "ad_extra_data"
            java.lang.String r9 = r1.toString()     // Catch:{ JSONException -> 0x0078 }
            r7.put(r8, r9)     // Catch:{ JSONException -> 0x0078 }
            goto L_0x0078
        L_0x0077:
            r7 = r0
        L_0x0078:
            android.content.Context r8 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x0080 }
            com.bytedance.sdk.openadsdk.c.c.c((android.content.Context) r8, (com.bytedance.sdk.openadsdk.core.model.n) r4, (java.lang.String) r5, (java.lang.String) r6, (org.json.JSONObject) r7)     // Catch:{ all -> 0x0080 }
            goto L_0x009b
        L_0x0080:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "(Developers can ignore this detection exception)checkWebViewIsTransparent->throwable ex>>>"
            r5.append(r6)
            java.lang.String r4 = r4.toString()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "UIUtils"
            com.bytedance.sdk.component.utils.l.e(r5, r4)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.z.c(com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, android.graphics.Bitmap, java.lang.String, long):void");
    }

    private static Bitmap b(SSWebView sSWebView) {
        if (sSWebView == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(sSWebView.getWidth(), sSWebView.getHeight(), Bitmap.Config.RGB_565);
            sSWebView.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(Bitmap bitmap) {
        try {
            ArrayList<Integer> b2 = b(bitmap);
            if (b2 == null) {
                return -1;
            }
            HashMap hashMap = new HashMap();
            Iterator<Integer> it = b2.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hashMap.containsKey(next)) {
                    Integer valueOf = Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1);
                    hashMap.remove(next);
                    hashMap.put(next, valueOf);
                } else {
                    hashMap.put(next, 1);
                }
            }
            int i = 0;
            int i2 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i2 < intValue) {
                    i = ((Integer) entry.getKey()).intValue();
                    i2 = intValue;
                }
            }
            if (i == 0) {
                return -1;
            }
            return (int) ((((float) i2) / (((float) (bitmap.getWidth() * bitmap.getHeight())) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static ArrayList<Integer> b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i : iArr) {
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i) >> 16, (65280 & i) >> 8, i & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(View view, final float f2) {
        if (view == null || f2 <= 0.0f) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    if (outline != null) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f2);
                    }
                }
            });
            view.setClipToOutline(true);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(f2);
        view.setBackground(gradientDrawable);
    }
}
