package androidx.browser.customtabs;

import android.os.Bundle;

public final class CustomTabColorSchemeParams {
    public final Integer navigationBarColor;
    public final Integer navigationBarDividerColor;
    public final Integer secondaryToolbarColor;
    public final Integer toolbarColor;

    CustomTabColorSchemeParams(Integer num, Integer num2, Integer num3, Integer num4) {
        this.toolbarColor = num;
        this.secondaryToolbarColor = num2;
        this.navigationBarColor = num3;
        this.navigationBarDividerColor = num4;
    }

    /* access modifiers changed from: package-private */
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        Integer num = this.toolbarColor;
        if (num != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, num.intValue());
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR, num2.intValue());
        }
        Integer num3 = this.navigationBarColor;
        if (num3 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR, num3.intValue());
        }
        Integer num4 = this.navigationBarDividerColor;
        if (num4 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR, num4.intValue());
        }
        return bundle;
    }

    static CustomTabColorSchemeParams fromBundle(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(0);
        }
        return new CustomTabColorSchemeParams((Integer) bundle.get(CustomTabsIntent.EXTRA_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR));
    }

    /* access modifiers changed from: package-private */
    public CustomTabColorSchemeParams withDefaults(CustomTabColorSchemeParams customTabColorSchemeParams) {
        Integer num = this.toolbarColor;
        if (num == null) {
            num = customTabColorSchemeParams.toolbarColor;
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 == null) {
            num2 = customTabColorSchemeParams.secondaryToolbarColor;
        }
        Integer num3 = this.navigationBarColor;
        if (num3 == null) {
            num3 = customTabColorSchemeParams.navigationBarColor;
        }
        Integer num4 = this.navigationBarDividerColor;
        if (num4 == null) {
            num4 = customTabColorSchemeParams.navigationBarDividerColor;
        }
        return new CustomTabColorSchemeParams(num, num2, num3, num4);
    }

    public static final class Builder {
        private Integer mNavigationBarColor;
        private Integer mNavigationBarDividerColor;
        private Integer mSecondaryToolbarColor;
        private Integer mToolbarColor;

        public Builder setToolbarColor(int i) {
            this.mToolbarColor = Integer.valueOf(i | -16777216);
            return this;
        }

        public Builder setSecondaryToolbarColor(int i) {
            this.mSecondaryToolbarColor = Integer.valueOf(i);
            return this;
        }

        public Builder setNavigationBarColor(int i) {
            this.mNavigationBarColor = Integer.valueOf(i | -16777216);
            return this;
        }

        public Builder setNavigationBarDividerColor(int i) {
            this.mNavigationBarDividerColor = Integer.valueOf(i);
            return this;
        }

        public CustomTabColorSchemeParams build() {
            return new CustomTabColorSchemeParams(this.mToolbarColor, this.mSecondaryToolbarColor, this.mNavigationBarColor, this.mNavigationBarDividerColor);
        }
    }
}
