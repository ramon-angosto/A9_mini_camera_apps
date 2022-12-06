package com.vungle.warren.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Consent {
    @SerializedName("ccpa")
    @Expose
    private Ccpa ccpa;
    @SerializedName("coppa")
    @Expose
    private Coppa coppa;
    @SerializedName("gdpr")
    @Expose
    private Gdpr gdpr;

    public Ccpa getCcpa() {
        return this.ccpa;
    }

    public Gdpr getGdpr() {
        return this.gdpr;
    }

    public Coppa getCoppa() {
        return this.coppa;
    }

    public Consent(Ccpa ccpa2, Gdpr gdpr2, Coppa coppa2) {
        this.ccpa = ccpa2;
        this.gdpr = gdpr2;
        this.coppa = coppa2;
    }
}
