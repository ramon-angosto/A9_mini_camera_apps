package com.vungle.warren.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coppa {
    @SerializedName("is_coppa")
    @Expose
    private boolean isCoppa;

    public boolean getIsCoppa() {
        return this.isCoppa;
    }

    public Coppa(boolean z) {
        this.isCoppa = z;
    }
}
