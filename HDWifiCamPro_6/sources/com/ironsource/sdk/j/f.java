package com.ironsource.sdk.j;

import com.ironsource.sdk.g.a;
import org.json.JSONObject;

@Deprecated
public interface f extends a {
    void onRVAdClicked();

    void onRVAdClosed();

    void onRVAdCredited(int i);

    void onRVAdOpened();

    void onRVEventNotificationReceived(String str, JSONObject jSONObject);

    void onRVInitFail(String str);

    void onRVInitSuccess(a aVar);

    void onRVNoMoreOffers();

    void onRVShowFail(String str);
}
