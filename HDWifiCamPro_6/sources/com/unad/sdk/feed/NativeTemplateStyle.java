package com.unad.sdk.feed;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;

public class NativeTemplateStyle {
    /* access modifiers changed from: private */
    public ColorDrawable callToActionBackgroundColor;
    /* access modifiers changed from: private */
    public float callToActionTextSize;
    /* access modifiers changed from: private */
    public Typeface callToActionTextTypeface;
    /* access modifiers changed from: private */
    public int callToActionTypefaceColor;
    /* access modifiers changed from: private */
    public ColorDrawable mainBackgroundColor;
    /* access modifiers changed from: private */
    public ColorDrawable primaryTextBackgroundColor;
    /* access modifiers changed from: private */
    public float primaryTextSize;
    /* access modifiers changed from: private */
    public Typeface primaryTextTypeface;
    /* access modifiers changed from: private */
    public int primaryTextTypefaceColor;
    /* access modifiers changed from: private */
    public ColorDrawable secondaryTextBackgroundColor;
    /* access modifiers changed from: private */
    public float secondaryTextSize;
    /* access modifiers changed from: private */
    public Typeface secondaryTextTypeface;
    /* access modifiers changed from: private */
    public int secondaryTextTypefaceColor;
    /* access modifiers changed from: private */
    public ColorDrawable tertiaryTextBackgroundColor;
    /* access modifiers changed from: private */
    public float tertiaryTextSize;
    /* access modifiers changed from: private */
    public Typeface tertiaryTextTypeface;
    /* access modifiers changed from: private */
    public int tertiaryTextTypefaceColor;

    public static class Builder {
        private NativeTemplateStyle styles = new NativeTemplateStyle();

        public NativeTemplateStyle build() {
            return this.styles;
        }

        public Builder withCallToActionBackgroundColor(ColorDrawable colorDrawable) {
            ColorDrawable unused = this.styles.callToActionBackgroundColor = colorDrawable;
            return this;
        }

        public Builder withCallToActionTextSize(float f) {
            float unused = this.styles.callToActionTextSize = f;
            return this;
        }

        public Builder withCallToActionTextTypeface(Typeface typeface) {
            Typeface unused = this.styles.callToActionTextTypeface = typeface;
            return this;
        }

        public Builder withCallToActionTypefaceColor(int i) {
            int unused = this.styles.callToActionTypefaceColor = i;
            return this;
        }

        public Builder withMainBackgroundColor(ColorDrawable colorDrawable) {
            ColorDrawable unused = this.styles.mainBackgroundColor = colorDrawable;
            return this;
        }

        public Builder withPrimaryTextBackgroundColor(ColorDrawable colorDrawable) {
            ColorDrawable unused = this.styles.primaryTextBackgroundColor = colorDrawable;
            return this;
        }

        public Builder withPrimaryTextSize(float f) {
            float unused = this.styles.primaryTextSize = f;
            return this;
        }

        public Builder withPrimaryTextTypeface(Typeface typeface) {
            Typeface unused = this.styles.primaryTextTypeface = typeface;
            return this;
        }

        public Builder withPrimaryTextTypefaceColor(int i) {
            int unused = this.styles.primaryTextTypefaceColor = i;
            return this;
        }

        public Builder withSecondaryTextBackgroundColor(ColorDrawable colorDrawable) {
            ColorDrawable unused = this.styles.secondaryTextBackgroundColor = colorDrawable;
            return this;
        }

        public Builder withSecondaryTextSize(float f) {
            float unused = this.styles.secondaryTextSize = f;
            return this;
        }

        public Builder withSecondaryTextTypeface(Typeface typeface) {
            Typeface unused = this.styles.secondaryTextTypeface = typeface;
            return this;
        }

        public Builder withSecondaryTextTypefaceColor(int i) {
            int unused = this.styles.secondaryTextTypefaceColor = i;
            return this;
        }

        public Builder withTertiaryTextBackgroundColor(ColorDrawable colorDrawable) {
            ColorDrawable unused = this.styles.tertiaryTextBackgroundColor = colorDrawable;
            return this;
        }

        public Builder withTertiaryTextSize(float f) {
            float unused = this.styles.tertiaryTextSize = f;
            return this;
        }

        public Builder withTertiaryTextTypeface(Typeface typeface) {
            Typeface unused = this.styles.tertiaryTextTypeface = typeface;
            return this;
        }

        public Builder withTertiaryTextTypefaceColor(int i) {
            int unused = this.styles.tertiaryTextTypefaceColor = i;
            return this;
        }
    }

    public ColorDrawable getCallToActionBackgroundColor() {
        return this.callToActionBackgroundColor;
    }

    public float getCallToActionTextSize() {
        return this.callToActionTextSize;
    }

    public Typeface getCallToActionTextTypeface() {
        return this.callToActionTextTypeface;
    }

    public int getCallToActionTypefaceColor() {
        return this.callToActionTypefaceColor;
    }

    public ColorDrawable getMainBackgroundColor() {
        return this.mainBackgroundColor;
    }

    public ColorDrawable getPrimaryTextBackgroundColor() {
        return this.primaryTextBackgroundColor;
    }

    public float getPrimaryTextSize() {
        return this.primaryTextSize;
    }

    public Typeface getPrimaryTextTypeface() {
        return this.primaryTextTypeface;
    }

    public int getPrimaryTextTypefaceColor() {
        return this.primaryTextTypefaceColor;
    }

    public ColorDrawable getSecondaryTextBackgroundColor() {
        return this.secondaryTextBackgroundColor;
    }

    public float getSecondaryTextSize() {
        return this.secondaryTextSize;
    }

    public Typeface getSecondaryTextTypeface() {
        return this.secondaryTextTypeface;
    }

    public int getSecondaryTextTypefaceColor() {
        return this.secondaryTextTypefaceColor;
    }

    public ColorDrawable getTertiaryTextBackgroundColor() {
        return this.tertiaryTextBackgroundColor;
    }

    public float getTertiaryTextSize() {
        return this.tertiaryTextSize;
    }

    public Typeface getTertiaryTextTypeface() {
        return this.tertiaryTextTypeface;
    }

    public int getTertiaryTextTypefaceColor() {
        return this.tertiaryTextTypefaceColor;
    }
}
