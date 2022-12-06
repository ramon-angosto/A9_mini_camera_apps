package com.ironsource.mediationsdk.model;

public class Placement {
    private int a;
    private String b;
    private boolean c;
    private String d;
    private int e;
    private k f;

    public Placement(int i, String str, boolean z, String str2, int i2, k kVar) {
        this.a = i;
        this.b = str;
        this.c = z;
        this.d = str2;
        this.e = i2;
        this.f = kVar;
    }

    public Placement(InterstitialPlacement interstitialPlacement) {
        this.a = interstitialPlacement.getPlacementId();
        this.b = interstitialPlacement.getPlacementName();
        this.c = interstitialPlacement.isDefault();
        this.f = interstitialPlacement.getPlacementAvailabilitySettings();
    }

    public k getPlacementAvailabilitySettings() {
        return this.f;
    }

    public int getPlacementId() {
        return this.a;
    }

    public String getPlacementName() {
        return this.b;
    }

    public int getRewardAmount() {
        return this.e;
    }

    public String getRewardName() {
        return this.d;
    }

    public boolean isDefault() {
        return this.c;
    }

    public String toString() {
        return "placement name: " + this.b + ", reward name: " + this.d + " , amount: " + this.e;
    }
}
