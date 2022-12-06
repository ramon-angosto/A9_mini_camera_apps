package com.google.firebase.auth;

import android.support.annotation.Nullable;

public class GetTokenResult {
    private String zzabf;

    public GetTokenResult(String str) {
        this.zzabf = str;
    }

    @Nullable
    public String getToken() {
        return this.zzabf;
    }
}
