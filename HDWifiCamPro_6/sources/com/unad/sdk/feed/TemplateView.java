package com.unad.sdk.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.unad.sdk.R;

public class TemplateView extends FrameLayout {
    private int a;
    private NativeTemplateStyle b;
    private NativeAdView c;
    private TextView d;
    private TextView e;
    private RatingBar f;
    private TextView g;
    private ImageView h;
    private MediaView i;
    private Button j;
    private ConstraintLayout k;

    public TemplateView(Context context) {
        super(context);
    }

    private void a() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Button button;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        Button button2;
        Button button3;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        Button button4;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        ColorDrawable mainBackgroundColor = this.b.getMainBackgroundColor();
        if (mainBackgroundColor != null) {
            this.k.setBackground(mainBackgroundColor);
            TextView textView13 = this.d;
            if (textView13 != null) {
                textView13.setBackground(mainBackgroundColor);
            }
            TextView textView14 = this.e;
            if (textView14 != null) {
                textView14.setBackground(mainBackgroundColor);
            }
            TextView textView15 = this.g;
            if (textView15 != null) {
                textView15.setBackground(mainBackgroundColor);
            }
        }
        Typeface primaryTextTypeface = this.b.getPrimaryTextTypeface();
        if (!(primaryTextTypeface == null || (textView12 = this.d) == null)) {
            textView12.setTypeface(primaryTextTypeface);
        }
        Typeface secondaryTextTypeface = this.b.getSecondaryTextTypeface();
        if (!(secondaryTextTypeface == null || (textView11 = this.e) == null)) {
            textView11.setTypeface(secondaryTextTypeface);
        }
        Typeface tertiaryTextTypeface = this.b.getTertiaryTextTypeface();
        if (!(tertiaryTextTypeface == null || (textView10 = this.g) == null)) {
            textView10.setTypeface(tertiaryTextTypeface);
        }
        Typeface callToActionTextTypeface = this.b.getCallToActionTextTypeface();
        if (!(callToActionTextTypeface == null || (button4 = this.j) == null)) {
            button4.setTypeface(callToActionTextTypeface);
        }
        int primaryTextTypefaceColor = this.b.getPrimaryTextTypefaceColor();
        if (primaryTextTypefaceColor > 0 && (textView9 = this.d) != null) {
            textView9.setTextColor(primaryTextTypefaceColor);
        }
        int secondaryTextTypefaceColor = this.b.getSecondaryTextTypefaceColor();
        if (secondaryTextTypefaceColor > 0 && (textView8 = this.e) != null) {
            textView8.setTextColor(secondaryTextTypefaceColor);
        }
        int tertiaryTextTypefaceColor = this.b.getTertiaryTextTypefaceColor();
        if (tertiaryTextTypefaceColor > 0 && (textView7 = this.g) != null) {
            textView7.setTextColor(tertiaryTextTypefaceColor);
        }
        int callToActionTypefaceColor = this.b.getCallToActionTypefaceColor();
        if (callToActionTypefaceColor > 0 && (button3 = this.j) != null) {
            button3.setTextColor(callToActionTypefaceColor);
        }
        float callToActionTextSize = this.b.getCallToActionTextSize();
        if (callToActionTextSize > 0.0f && (button2 = this.j) != null) {
            button2.setTextSize(callToActionTextSize);
        }
        float primaryTextSize = this.b.getPrimaryTextSize();
        if (primaryTextSize > 0.0f && (textView6 = this.d) != null) {
            textView6.setTextSize(primaryTextSize);
        }
        float secondaryTextSize = this.b.getSecondaryTextSize();
        if (secondaryTextSize > 0.0f && (textView5 = this.e) != null) {
            textView5.setTextSize(secondaryTextSize);
        }
        float tertiaryTextSize = this.b.getTertiaryTextSize();
        if (tertiaryTextSize > 0.0f && (textView4 = this.g) != null) {
            textView4.setTextSize(tertiaryTextSize);
        }
        ColorDrawable callToActionBackgroundColor = this.b.getCallToActionBackgroundColor();
        if (!(callToActionBackgroundColor == null || (button = this.j) == null)) {
            button.setBackground(callToActionBackgroundColor);
        }
        ColorDrawable primaryTextBackgroundColor = this.b.getPrimaryTextBackgroundColor();
        if (!(primaryTextBackgroundColor == null || (textView3 = this.d) == null)) {
            textView3.setBackground(primaryTextBackgroundColor);
        }
        ColorDrawable secondaryTextBackgroundColor = this.b.getSecondaryTextBackgroundColor();
        if (!(secondaryTextBackgroundColor == null || (textView2 = this.e) == null)) {
            textView2.setBackground(secondaryTextBackgroundColor);
        }
        ColorDrawable tertiaryTextBackgroundColor = this.b.getTertiaryTextBackgroundColor();
        if (!(tertiaryTextBackgroundColor == null || (textView = this.g) == null)) {
            textView.setBackground(tertiaryTextBackgroundColor);
        }
        invalidate();
        requestLayout();
    }

    public NativeAdView getNativeAdView() {
        return this.c;
    }

    public String getTemplateTypeName() {
        int i2 = this.a;
        if (i2 == R.layout.unad_medium_template_view) {
            return "medium_template";
        }
        return i2 == R.layout.unad_small_template_view ? "small_template" : "";
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.c = (NativeAdView) findViewById(R.id.native_ad_view);
        this.d = (TextView) findViewById(R.id.primary);
        this.e = (TextView) findViewById(R.id.secondary);
        this.g = (TextView) findViewById(R.id.body);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        this.f = ratingBar;
        ratingBar.setEnabled(false);
        this.j = (Button) findViewById(R.id.cta);
        this.h = (ImageView) findViewById(R.id.icon);
        this.i = (MediaView) findViewById(R.id.media_view);
        this.k = (ConstraintLayout) findViewById(R.id.background);
    }

    public void setNativeAd(NativeAd nativeAd) {
        String store = nativeAd.getStore();
        String advertiser = nativeAd.getAdvertiser();
        String headline = nativeAd.getHeadline();
        String body = nativeAd.getBody();
        String callToAction = nativeAd.getCallToAction();
        Double starRating = nativeAd.getStarRating();
        NativeAd.Image icon = nativeAd.getIcon();
        this.c.setCallToActionView(this.j);
        this.c.setHeadlineView(this.d);
        this.c.setMediaView(this.i);
        this.e.setVisibility(0);
        if (a(nativeAd)) {
            this.c.setStoreView(this.e);
        } else if (!TextUtils.isEmpty(advertiser)) {
            this.c.setAdvertiserView(this.e);
            store = advertiser;
        } else {
            store = "";
        }
        this.d.setText(headline);
        this.j.setText(callToAction);
        if (starRating == null || starRating.doubleValue() <= 0.0d) {
            this.e.setText(store);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        } else {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setRating(starRating.floatValue());
            this.c.setStarRatingView(this.f);
        }
        if (icon != null) {
            this.h.setVisibility(0);
            this.h.setImageDrawable(icon.getDrawable());
        } else {
            this.h.setVisibility(8);
        }
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(body);
            this.c.setBodyView(this.g);
        }
        this.c.setNativeAd(nativeAd);
    }

    public void setStyles(NativeTemplateStyle nativeTemplateStyle) {
        this.b = nativeTemplateStyle;
        a();
    }

    public TemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TemplateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public TemplateView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    private boolean a(NativeAd nativeAd) {
        return !TextUtils.isEmpty(nativeAd.getStore()) && TextUtils.isEmpty(nativeAd.getAdvertiser());
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TemplateView, 0, 0);
        try {
            this.a = obtainStyledAttributes.getResourceId(R.styleable.TemplateView_gnt_template_type, R.layout.unad_medium_template_view);
            obtainStyledAttributes.recycle();
            ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.a, this);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
