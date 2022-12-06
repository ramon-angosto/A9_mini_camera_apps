package com.vungle.warren.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device {
    @SerializedName("amazon")
    @Expose
    private AndroidInfo amazon;
    @SerializedName("android")
    @Expose

    /* renamed from: android  reason: collision with root package name */
    private AndroidInfo f5android;
    @SerializedName("battery_saver_enabled")
    @Expose
    private Boolean batterySaverEnabled;
    @SerializedName("extension")
    @Expose
    private Extension extension;
    @SerializedName("ifa")
    @Expose
    private String ifa;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("time_zone")
    @Expose
    private String timezone;
    @SerializedName("volume_level")
    @Expose
    private Double volumeLevel;

    public Device(Boolean bool, String str, String str2, Double d, String str3, AndroidInfo androidInfo, AndroidInfo androidInfo2, Extension extension2) {
        this.batterySaverEnabled = bool;
        this.language = str;
        this.timezone = str2;
        this.volumeLevel = d;
        this.ifa = str3;
        this.amazon = androidInfo;
        this.f5android = androidInfo2;
        this.extension = extension2;
    }
}
