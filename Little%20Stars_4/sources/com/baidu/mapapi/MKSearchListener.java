package com.baidu.mapapi;

public interface MKSearchListener {
    void onGetAddrResult(MKAddrInfo mKAddrInfo, int i);

    void onGetBusDetailResult(MKBusLineResult mKBusLineResult, int i);

    void onGetDrivingRouteResult(MKDrivingRouteResult mKDrivingRouteResult, int i);

    void onGetPoiDetailSearchResult(int i, int i2);

    void onGetPoiResult(MKPoiResult mKPoiResult, int i, int i2);

    void onGetRGCShareUrlResult(String str, int i);

    void onGetSuggestionResult(MKSuggestionResult mKSuggestionResult, int i);

    void onGetTransitRouteResult(MKTransitRouteResult mKTransitRouteResult, int i);

    void onGetWalkingRouteResult(MKWalkingRouteResult mKWalkingRouteResult, int i);
}
