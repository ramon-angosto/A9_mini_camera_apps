package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.entity.opendevice.OdidReq;
import com.huawei.hms.support.log.HMSLog;

public class HuaweiOpendeviceApiImpl implements HuaweiOpendeviceApi {
    public PendingResult<OdidResult> getOdid(HuaweiApiClient huaweiApiClient) {
        HMSLog.m1379i("OpenIdentifierApiImpl", "Enter getOdid");
        return new C0869u(this, huaweiApiClient, HuaweiOpendeviceNaming.getOdid, new OdidReq());
    }
}
