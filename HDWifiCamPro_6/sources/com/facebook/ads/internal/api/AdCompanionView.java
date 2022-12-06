package com.facebook.ads.internal.api;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

public class AdCompanionView extends AdComponentFrameLayout {
    private AdCompanionViewApi mAdCompanionViewApi;

    public AdCompanionView(Context context) {
        super(context);
        initializeSelf(context);
    }

    public AdCompanionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeSelf(context);
    }

    public AdCompanionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeSelf(context);
    }

    private void initializeSelf(Context context) {
        this.mAdCompanionViewApi = DynamicLoaderFactory.makeLoader(context).createAdCompanionViewApi();
        attachAdComponentViewApi(this.mAdCompanionViewApi);
        this.mAdCompanionViewApi.initialize(this);
    }

    public AdCompanionViewApi getAdCompanionViewApi() {
        return this.mAdCompanionViewApi;
    }
}
