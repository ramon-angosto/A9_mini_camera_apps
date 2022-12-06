package com.vungle.warren.ui;

public interface PresenterAdOpenCallback {

    public enum AdOpenType {
        DEFAULT,
        DEEP_LINK
    }

    void onAdOpenType(AdOpenType adOpenType);
}
