package com.baidu.mapapi;

class g implements j {
    private MKGeneralListener a;

    public g(MKGeneralListener mKGeneralListener) {
        this.a = mKGeneralListener;
    }

    public void a(MKEvent mKEvent) {
        int i = mKEvent.a;
        if (i == 7) {
            this.a.onGetNetworkState(mKEvent.b);
        } else if (i == 9) {
            this.a.onGetPermissionState(mKEvent.b);
        }
    }
}
