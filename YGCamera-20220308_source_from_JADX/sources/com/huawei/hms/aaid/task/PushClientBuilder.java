package com.huawei.hms.aaid.task;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import java.util.Arrays;

public class PushClientBuilder extends AbstractClientBuilder<PushClient, Api.ApiOptions.NoOptions> {
    public PushClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        clientSettings.setApiName(Arrays.asList(new String[]{HuaweiApiAvailability.HMS_API_NAME_PUSH, "Core.API"}));
        return new PushClient(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
