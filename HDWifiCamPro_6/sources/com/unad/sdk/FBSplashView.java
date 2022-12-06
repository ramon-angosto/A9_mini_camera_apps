package com.unad.sdk;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdsManager;
import com.unad.sdk.adapter.FBAdRecyclerAdapter;
import com.unad.sdk.dto.AdError;
import com.unad.sdk.util.DividerItemDecoration;
import java.util.ArrayList;

public class FBSplashView extends FrameLayout {
    private static String q = "";
    /* access modifiers changed from: private */
    public ImageView a;
    private ImageView b;
    private TextView c;
    private View d;
    /* access modifiers changed from: private */
    public LinearLayout e;
    /* access modifiers changed from: private */
    public Integer f = 6;
    /* access modifiers changed from: private */
    public String g = null;
    private boolean h = true;
    /* access modifiers changed from: private */
    public ArrayList<NativeAd> i;
    /* access modifiers changed from: private */
    public NativeAdsManager j;
    /* access modifiers changed from: private */
    public RecyclerView k;
    /* access modifiers changed from: private */
    public Activity l = null;
    /* access modifiers changed from: private */
    public OnSplashViewActionListener m = null;
    /* access modifiers changed from: private */
    public Handler n = new Handler();
    /* access modifiers changed from: private */
    public Runnable o = new a();
    private GradientDrawable p = new GradientDrawable();

    public interface OnSplashViewActionListener {
        void onAdViewFailed(AdError adError);

        void onAdViewLoaded();

        void onSplashImageClick(String str);

        void onSplashViewDismiss(boolean z);
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (FBSplashView.this.f.intValue() == 0) {
                FBSplashView.this.a(false);
                return;
            }
            FBSplashView fBSplashView = FBSplashView.this;
            fBSplashView.setDuration(fBSplashView.f = Integer.valueOf(fBSplashView.f.intValue() - 1));
            FBSplashView.this.n.postDelayed(FBSplashView.this.o, 1000);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            FBSplashView.this.a(true);
        }
    }

    class c implements NativeAdsManager.Listener {
        c() {
        }

        public void onAdError(com.facebook.ads.AdError adError) {
            if (FBSplashView.this.m != null) {
                OnSplashViewActionListener l = FBSplashView.this.m;
                l.onAdViewFailed(new AdError(adError.getErrorCode() + "", adError.getErrorMessage()));
            }
        }

        public void onAdsLoaded() {
            if (FBSplashView.this.l != null && !FBSplashView.this.l.isFinishing()) {
                NativeAd nextNativeAd = FBSplashView.this.j.nextNativeAd();
                if (!nextNativeAd.isAdInvalidated()) {
                    FBSplashView.this.i.add(nextNativeAd);
                }
                NativeAd nextNativeAd2 = FBSplashView.this.j.nextNativeAd();
                if (!nextNativeAd2.isAdInvalidated()) {
                    FBSplashView.this.i.add(nextNativeAd2);
                }
                FBSplashView.this.k.setLayoutManager(new LinearLayoutManager(FBSplashView.this.l));
                FBSplashView.this.k.addItemDecoration(new DividerItemDecoration(FBSplashView.this.l, 1));
                FBSplashView.this.k.setAdapter(new FBAdRecyclerAdapter(FBSplashView.this.l, FBSplashView.this.i));
                if (FBSplashView.this.m != null) {
                    FBSplashView.this.m.onAdViewLoaded();
                    FBSplashView.this.a.setVisibility(8);
                    FBSplashView.this.e.setVisibility(8);
                }
            }
        }
    }

    class d implements View.OnClickListener {
        final /* synthetic */ OnSplashViewActionListener a;

        d(OnSplashViewActionListener onSplashViewActionListener) {
            this.a = onSplashViewActionListener;
        }

        public void onClick(View view) {
            this.a.onSplashImageClick(FBSplashView.this.g);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            FBSplashView.this.setAlpha(1.0f - (2.0f * floatValue));
            float f = floatValue + 1.0f;
            FBSplashView.this.setScaleX(f);
            FBSplashView.this.setScaleY(f);
        }
    }

    class f implements Animator.AnimatorListener {
        final /* synthetic */ ViewGroup a;

        f(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        public void onAnimationCancel(Animator animator) {
            this.a.removeView(FBSplashView.this);
            FBSplashView.this.b();
        }

        public void onAnimationEnd(Animator animator) {
            this.a.removeView(FBSplashView.this);
            FBSplashView.this.b();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public FBSplashView(Activity activity) {
        super(activity);
        this.l = activity;
        a();
    }

    /* access modifiers changed from: private */
    public void setDuration(Integer num) {
        this.f = num;
        this.c.setText(String.format("%d s", new Object[]{num}));
    }

    private void setImage(Bitmap bitmap) {
        this.a.setImageBitmap(bitmap);
    }

    private void setOnSplashImageClickListener(OnSplashViewActionListener onSplashViewActionListener) {
        if (onSplashViewActionListener != null) {
            this.m = onSplashViewActionListener;
            this.a.setOnClickListener(new d(onSplashViewActionListener));
        }
    }

    public void setLogoBitmapRes(Integer num) {
        this.b.setImageResource(num.intValue());
    }

    /* access modifiers changed from: private */
    public void b() {
        ActionBar actionBar;
        this.l.getWindow().clearFlags(1024);
        Activity activity = this.l;
        if (activity instanceof AppCompatActivity) {
            androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null && this.h) {
                supportActionBar.show();
            }
        } else if ((activity instanceof Activity) && (actionBar = activity.getActionBar()) != null && this.h) {
            actionBar.show();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View inflate = ((LayoutInflater) this.l.getSystemService("layout_inflater")).inflate(R.layout.unad_ad_fb_splash_view, this, true);
        this.d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ad_content_view);
        this.b = (ImageView) this.d.findViewById(R.id.image_logo);
        this.e = (LinearLayout) this.d.findViewById(R.id.layout_bottom);
        this.p.setShape(1);
        this.p.setColor(Color.parseColor("#66333333"));
        ImageView imageView = (ImageView) this.d.findViewById(R.id.image_bg);
        this.a = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.a.setBackgroundColor(this.l.getResources().getColor(17170443));
        this.a.setClickable(true);
        this.c = new TextView(this.l);
        int applyDimension = (int) TypedValue.applyDimension(1, 36.0f, this.l.getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.gravity = 53;
        int applyDimension2 = (int) TypedValue.applyDimension(1, 16.0f, this.l.getResources().getDisplayMetrics());
        layoutParams.setMargins(0, applyDimension2, applyDimension2, 0);
        this.c.setGravity(17);
        this.c.setTextColor(this.l.getResources().getColor(17170443));
        this.c.setBackgroundDrawable(this.p);
        this.c.setTextSize(1, 10.0f);
        addView(this.c, layoutParams);
        this.c.setOnClickListener(new b());
        setDuration(this.f);
        this.k = (RecyclerView) this.d.findViewById(R.id.recyclerView);
        this.i = new ArrayList<>();
        NativeAdsManager nativeAdsManager = new NativeAdsManager(this.l, q, 2);
        this.j = nativeAdsManager;
        nativeAdsManager.loadAds();
        this.j.setListener(new c());
        this.n.postDelayed(this.o, 1000);
    }

    protected static void a(Activity activity, Integer num, Integer num2, Integer num3, OnSplashViewActionListener onSplashViewActionListener, String str) {
        ActionBar actionBar;
        q = str;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            throw new IllegalStateException("You should call showSplashView() after setContentView() in Activity instance");
        }
        FBSplashView fBSplashView = new FBSplashView(activity);
        fBSplashView.setLogoBitmapRes(num3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        fBSplashView.setOnSplashImageClickListener(onSplashViewActionListener);
        if (num != null) {
            fBSplashView.setDuration(num);
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(activity.getResources(), num2.intValue());
        if (decodeResource != null) {
            fBSplashView.setImage(decodeResource);
        }
        activity.getWindow().setFlags(1024, 1024);
        if (activity instanceof AppCompatActivity) {
            androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setShowHideAnimationEnabled(false);
                fBSplashView.h = supportActionBar.isShowing();
                supportActionBar.hide();
            }
        } else if ((activity instanceof Activity) && (actionBar = activity.getActionBar()) != null) {
            fBSplashView.h = actionBar.isShowing();
            actionBar.hide();
        }
        viewGroup.addView(fBSplashView, layoutParams);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        OnSplashViewActionListener onSplashViewActionListener = this.m;
        if (onSplashViewActionListener != null) {
            onSplashViewActionListener.onSplashViewDismiss(z);
        }
        this.n.removeCallbacks(this.o);
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this, "scale", new float[]{0.0f, 0.5f}).setDuration(600);
            duration.start();
            duration.addUpdateListener(new e());
            duration.addListener(new f(viewGroup));
        }
    }
}
