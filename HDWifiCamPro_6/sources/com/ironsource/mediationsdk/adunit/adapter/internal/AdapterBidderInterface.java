package com.ironsource.mediationsdk.adunit.adapter.internal;

import android.content.Context;
import java.util.Map;

public interface AdapterBidderInterface {
    Map<String, Object> getBiddingData(Context context);
}
