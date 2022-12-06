package com.vungle.warren;

import com.vungle.warren.model.Advertisement;

interface LoadNativeAdCallback extends LoadAdCallback {
    void onAdLoad(Advertisement advertisement);
}
