package com.huawei.hms.opendevice;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApiImpl;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.opendevice.u */
/* compiled from: HuaweiOpendeviceApiImpl */
class C0869u extends PendingResultImpl<OdidResult, OdidResp> {

    /* renamed from: a */
    public final /* synthetic */ HuaweiOpendeviceApiImpl f824a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0869u(HuaweiOpendeviceApiImpl huaweiOpendeviceApiImpl, ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        super(apiClient, str, iMessageEntity);
        this.f824a = huaweiOpendeviceApiImpl;
    }

    /* renamed from: a */
    public OdidResult onComplete(OdidResp odidResp) {
        if (odidResp == null) {
            HMSLog.m1377e("OpenIdentifierApiImpl", "getOdid OaidResp is null");
            return null;
        }
        Status commonStatus = odidResp.getCommonStatus();
        if (commonStatus == null) {
            HMSLog.m1377e("OpenIdentifierApiImpl", "getOdid commonStatus is null");
            return null;
        }
        HMSLog.m1379i("OpenIdentifierApiImpl", "getOdid onComplete:" + commonStatus.getStatusCode());
        OdidResult odidResult = new OdidResult();
        odidResult.setStatus(commonStatus);
        odidResult.setId(odidResp.getId());
        return odidResult;
    }
}
