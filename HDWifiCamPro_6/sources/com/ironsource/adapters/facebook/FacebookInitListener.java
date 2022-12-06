package com.ironsource.adapters.facebook;

import com.facebook.ads.AudienceNetworkAds;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.logger.IronLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class FacebookInitListener implements AudienceNetworkAds.InitListener {
    private WeakReference<FacebookAdapter> mAdapter;

    public FacebookInitListener(FacebookAdapter facebookAdapter) {
        this.mAdapter = new WeakReference<>(facebookAdapter);
    }

    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("init SDK is completed with status: " + initResult.isSuccess() + ", " + initResult.getMessage());
        WeakReference<FacebookAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        if (initResult.isSuccess()) {
            FacebookAdapter facebookAdapter = (FacebookAdapter) this.mAdapter.get();
            FacebookAdapter.mDidInitSuccess = true;
            FacebookAdapter facebookAdapter2 = (FacebookAdapter) this.mAdapter.get();
            Iterator<INetworkInitCallbackListener> it = FacebookAdapter.initCallbackListeners.iterator();
            while (it.hasNext()) {
                it.next().onNetworkInitCallbackSuccess();
            }
        } else {
            FacebookAdapter facebookAdapter3 = (FacebookAdapter) this.mAdapter.get();
            FacebookAdapter.mDidInitSuccess = false;
            FacebookAdapter facebookAdapter4 = (FacebookAdapter) this.mAdapter.get();
            Iterator<INetworkInitCallbackListener> it2 = FacebookAdapter.initCallbackListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onNetworkInitCallbackFailed(initResult.getMessage());
            }
        }
        FacebookAdapter facebookAdapter5 = (FacebookAdapter) this.mAdapter.get();
        FacebookAdapter.initCallbackListeners.clear();
    }
}
