package com.baidu.mapapi;

class k implements j {
    private MKOfflineMapListener a;

    public k(MKOfflineMapListener mKOfflineMapListener) {
        this.a = mKOfflineMapListener;
    }

    public void a(MKEvent mKEvent) {
        if (this.a != null) {
            int i = mKEvent.a;
            if (i != 0) {
                if (i == 4) {
                    this.a.onGetOfflineMapState(mKEvent.a, 0);
                    return;
                } else if (i != 6) {
                    return;
                }
            }
            this.a.onGetOfflineMapState(mKEvent.a, mKEvent.c);
        }
    }
}
