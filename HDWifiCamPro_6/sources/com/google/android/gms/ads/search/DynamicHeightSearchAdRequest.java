package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzb zza = new zzb();
        private final Bundle zzb = new Bundle();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zza.zzb(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zza.zzc(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zza.zzd(cls, bundle);
            return this;
        }

        public DynamicHeightSearchAdRequest build() {
            this.zza.zzd(AdMobAdapter.class, this.zzb);
            return new DynamicHeightSearchAdRequest(this, (zza) null);
        }

        public Builder setAdBorderSelectors(String str) {
            this.zzb.putString("csa_adBorderSelectors", str);
            return this;
        }

        public Builder setAdTest(boolean z) {
            this.zzb.putString("csa_adtest", true != z ? "off" : "on");
            return this;
        }

        public Builder setAdjustableLineHeight(int i) {
            this.zzb.putString("csa_adjustableLineHeight", Integer.toString(i));
            return this;
        }

        public Builder setAdvancedOptionValue(String str, String str2) {
            this.zzb.putString(str, str2);
            return this;
        }

        public Builder setAttributionSpacingBelow(int i) {
            this.zzb.putString("csa_attributionSpacingBelow", Integer.toString(i));
            return this;
        }

        public Builder setBorderSelections(String str) {
            this.zzb.putString("csa_borderSelections", str);
            return this;
        }

        public Builder setChannel(String str) {
            this.zzb.putString("csa_channel", str);
            return this;
        }

        public Builder setColorAdBorder(String str) {
            this.zzb.putString("csa_colorAdBorder", str);
            return this;
        }

        public Builder setColorAdSeparator(String str) {
            this.zzb.putString("csa_colorAdSeparator", str);
            return this;
        }

        public Builder setColorAnnotation(String str) {
            this.zzb.putString("csa_colorAnnotation", str);
            return this;
        }

        public Builder setColorAttribution(String str) {
            this.zzb.putString("csa_colorAttribution", str);
            return this;
        }

        public Builder setColorBackground(String str) {
            this.zzb.putString("csa_colorBackground", str);
            return this;
        }

        public Builder setColorBorder(String str) {
            this.zzb.putString("csa_colorBorder", str);
            return this;
        }

        public Builder setColorDomainLink(String str) {
            this.zzb.putString("csa_colorDomainLink", str);
            return this;
        }

        public Builder setColorText(String str) {
            this.zzb.putString("csa_colorText", str);
            return this;
        }

        public Builder setColorTitleLink(String str) {
            this.zzb.putString("csa_colorTitleLink", str);
            return this;
        }

        public Builder setCssWidth(int i) {
            this.zzb.putString("csa_width", Integer.toString(i));
            return this;
        }

        public Builder setDetailedAttribution(boolean z) {
            this.zzb.putString("csa_detailedAttribution", Boolean.toString(z));
            return this;
        }

        public Builder setFontFamily(String str) {
            this.zzb.putString("csa_fontFamily", str);
            return this;
        }

        public Builder setFontFamilyAttribution(String str) {
            this.zzb.putString("csa_fontFamilyAttribution", str);
            return this;
        }

        public Builder setFontSizeAnnotation(int i) {
            this.zzb.putString("csa_fontSizeAnnotation", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeAttribution(int i) {
            this.zzb.putString("csa_fontSizeAttribution", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeDescription(int i) {
            this.zzb.putString("csa_fontSizeDescription", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeDomainLink(int i) {
            this.zzb.putString("csa_fontSizeDomainLink", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeTitle(int i) {
            this.zzb.putString("csa_fontSizeTitle", Integer.toString(i));
            return this;
        }

        public Builder setHostLanguage(String str) {
            this.zzb.putString("csa_hl", str);
            return this;
        }

        public Builder setIsClickToCallEnabled(boolean z) {
            this.zzb.putString("csa_clickToCall", Boolean.toString(z));
            return this;
        }

        public Builder setIsLocationEnabled(boolean z) {
            this.zzb.putString("csa_location", Boolean.toString(z));
            return this;
        }

        public Builder setIsPlusOnesEnabled(boolean z) {
            this.zzb.putString("csa_plusOnes", Boolean.toString(z));
            return this;
        }

        public Builder setIsSellerRatingsEnabled(boolean z) {
            this.zzb.putString("csa_sellerRatings", Boolean.toString(z));
            return this;
        }

        public Builder setIsSiteLinksEnabled(boolean z) {
            this.zzb.putString("csa_siteLinks", Boolean.toString(z));
            return this;
        }

        public Builder setIsTitleBold(boolean z) {
            this.zzb.putString("csa_titleBold", Boolean.toString(z));
            return this;
        }

        public Builder setIsTitleUnderlined(boolean z) {
            this.zzb.putString("csa_noTitleUnderline", Boolean.toString(!z));
            return this;
        }

        public Builder setLocationColor(String str) {
            this.zzb.putString("csa_colorLocation", str);
            return this;
        }

        public Builder setLocationFontSize(int i) {
            this.zzb.putString("csa_fontSizeLocation", Integer.toString(i));
            return this;
        }

        public Builder setLongerHeadlines(boolean z) {
            this.zzb.putString("csa_longerHeadlines", Boolean.toString(z));
            return this;
        }

        public Builder setNumber(int i) {
            this.zzb.putString("csa_number", Integer.toString(i));
            return this;
        }

        public Builder setPage(int i) {
            this.zzb.putString("csa_adPage", Integer.toString(i));
            return this;
        }

        public Builder setQuery(String str) {
            this.zza.zze(str);
            return this;
        }

        public Builder setStyleId(String str) {
            this.zzb.putString("csa_styleId", str);
            return this;
        }

        public Builder setVerticalSpacing(int i) {
            this.zzb.putString("csa_verticalSpacing", Integer.toString(i));
            return this;
        }
    }

    /* synthetic */ DynamicHeightSearchAdRequest(Builder builder, zza zza2) {
        this.zza = new SearchAdRequest(builder.zza, (zzc) null);
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zza.getCustomEventExtrasBundle(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zza.getNetworkExtrasBundle(cls);
    }

    public String getQuery() {
        return this.zza.getQuery();
    }

    public boolean isTestDevice(Context context) {
        return this.zza.isTestDevice(context);
    }

    /* access modifiers changed from: package-private */
    public final zzdr zza() {
        return this.zza.zza();
    }
}
