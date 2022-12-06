package com.adcolony.sdk;

public abstract class AdColonyAdViewListener {
    String a = "";
    AdColonyAdSize b;
    p0 c;

    /* access modifiers changed from: package-private */
    public AdColonyAdSize a() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public p0 b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.a;
    }

    public void onClicked(AdColonyAdView adColonyAdView) {
    }

    public void onClosed(AdColonyAdView adColonyAdView) {
    }

    public void onLeftApplication(AdColonyAdView adColonyAdView) {
    }

    public void onOpened(AdColonyAdView adColonyAdView) {
    }

    public abstract void onRequestFilled(AdColonyAdView adColonyAdView);

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
    }

    public void onShow(AdColonyAdView adColonyAdView) {
    }

    /* access modifiers changed from: package-private */
    public void a(p0 p0Var) {
        this.c = p0Var;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.a = str;
    }

    /* access modifiers changed from: package-private */
    public void a(AdColonyAdSize adColonyAdSize) {
        this.b = adColonyAdSize;
    }
}
