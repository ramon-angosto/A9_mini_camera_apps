package com.vungle.warren.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AndroidInfo {
    @SerializedName("android_id")
    @Expose
    public String android_id;
    @SerializedName("app_set_id")
    @Expose
    public String app_set_id;
}
