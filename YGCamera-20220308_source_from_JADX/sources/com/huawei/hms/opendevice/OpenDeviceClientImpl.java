package com.huawei.hms.opendevice;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {

    /* renamed from: a */
    public static final OpenDeviceHmsClientBuilder f777a = new OpenDeviceHmsClientBuilder();

    /* renamed from: b */
    public static final Api<OpenDeviceOptions> f778b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_OD);

    /* renamed from: c */
    public static OpenDeviceOptions f779c = new OpenDeviceOptions();

    public OpenDeviceClientImpl(Activity activity) {
        super(activity, f778b, f779c, (AbstractClientBuilder) f777a);
        super.setKitSdkVersion(50101300);
    }

    public Task<OdidResult> getOdid() {
        return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.getOdid, JsonUtil.createJsonString((IMessageEntity) null), HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.getOdid, 50101300)));
    }

    public OpenDeviceClientImpl(Context context) {
        super(context, f778b, f779c, (AbstractClientBuilder) f777a);
        super.setKitSdkVersion(50101300);
    }
}
