package com.ironsource.sdk.j;

import com.ironsource.sdk.c.a;

public interface b extends a {
    void onBannerClick();

    void onBannerInitFailed(String str);

    void onBannerInitSuccess();

    void onBannerLoadFail(String str);

    void onBannerLoadSuccess(a aVar);

    void onBannerShowSuccess();
}
