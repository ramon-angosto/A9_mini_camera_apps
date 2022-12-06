package com.adcolony.sdk;

public abstract class AdColonySignalsListener {
    public void onFailure() {
    }

    public abstract void onSuccess(String str);
}
