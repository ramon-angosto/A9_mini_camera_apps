package com.vungle.warren;

import com.vungle.warren.error.VungleException;

public interface InitCallback {
    void onAutoCacheAdAvailable(String str);

    void onError(VungleException vungleException);

    void onSuccess();
}
