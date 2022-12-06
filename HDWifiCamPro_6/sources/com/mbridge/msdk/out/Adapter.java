package com.mbridge.msdk.out;

import android.view.View;
import java.util.List;

public interface Adapter {
    boolean init(Object... objArr);

    boolean loadAd(AdapterListener adapterListener);

    void registerView(Campaign campaign, View view);

    void registerView(Campaign campaign, View view, List<View> list);

    void unregisterView(Campaign campaign, View view);

    void unregisterView(Campaign campaign, View view, List<View> list);
}
