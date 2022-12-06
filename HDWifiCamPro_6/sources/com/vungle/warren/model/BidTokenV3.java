package com.vungle.warren.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vungle.warren.model.token.Consent;
import com.vungle.warren.model.token.Device;
import com.vungle.warren.model.token.Request;

public class BidTokenV3 {
    @SerializedName("consent")
    @Expose
    private Consent consent;
    @SerializedName("device")
    @Expose
    private Device device;
    @SerializedName("request")
    @Expose
    private Request request;

    public BidTokenV3(Device device2, Request request2, Consent consent2) {
        this.device = device2;
        this.request = request2;
        this.consent = consent2;
    }

    public Request getRequest() {
        return this.request;
    }

    public Consent getConsent() {
        return this.consent;
    }

    public Device getDevice() {
        return this.device;
    }
}
