package com.unad.sdk.dto;

import java.io.Serializable;
import java.util.List;

public class AdList implements Serializable {
    private List<SourceVO> adSource;
    private String adUnitId;
    private String countrys;
    private boolean enable;
    private String facebook;
    private String facebookSplash;
    private String google;
    private String googleSplash;
    private boolean isOpenLogs = true;
    private String mintegralPlacementID;
    private String mintegralUnitID;
    private double rate;
    private String showType;
    private String style;
    private String type;

    public List<SourceVO> getAdSource() {
        return this.adSource;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getCountrys() {
        return this.countrys;
    }

    public String getFacebook() {
        return this.facebook;
    }

    public String getFacebookSplash() {
        return this.facebookSplash;
    }

    public String getGoogle() {
        return this.google;
    }

    public String getGoogleSplash() {
        return this.googleSplash;
    }

    public String getMintegralPlacementID() {
        return this.mintegralPlacementID;
    }

    public String getMintegralUnitID() {
        return this.mintegralUnitID;
    }

    public double getRate() {
        return this.rate;
    }

    public String getShowType() {
        return this.showType;
    }

    public String getStyle() {
        return this.style;
    }

    public String getType() {
        return this.type;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isOpenLogs() {
        return this.isOpenLogs;
    }

    public void setAdSource(List<SourceVO> list) {
        this.adSource = list;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setCountrys(String str) {
        this.countrys = str;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setFacebook(String str) {
        this.facebook = str;
    }

    public void setFacebookSplash(String str) {
        this.facebookSplash = str;
    }

    public void setGoogle(String str) {
        this.google = str;
    }

    public void setGoogleSplash(String str) {
        this.googleSplash = str;
    }

    public void setMintegralPlacementID(String str) {
        this.mintegralPlacementID = str;
    }

    public void setMintegralUnitID(String str) {
        this.mintegralUnitID = str;
    }

    public void setOpenLogs(boolean z) {
        this.isOpenLogs = z;
    }

    public void setRate(double d) {
        this.rate = d;
    }

    public void setShowType(String str) {
        this.showType = str;
    }

    public void setStyle(String str) {
        this.style = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
