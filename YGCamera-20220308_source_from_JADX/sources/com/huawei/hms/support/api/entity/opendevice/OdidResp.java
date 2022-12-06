package com.huawei.hms.support.api.entity.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class OdidResp extends AbstractMessageEntity {
    @Packed

    /* renamed from: id */
    public String f971id;

    public String getId() {
        return this.f971id;
    }

    public void setId(String str) {
        this.f971id = str;
    }
}
