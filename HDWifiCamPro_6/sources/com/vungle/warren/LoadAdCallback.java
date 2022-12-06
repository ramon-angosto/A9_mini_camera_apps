package com.vungle.warren;

import com.vungle.warren.error.VungleException;

public interface LoadAdCallback {
    void onAdLoad(String str);

    void onError(String str, VungleException vungleException);
}
