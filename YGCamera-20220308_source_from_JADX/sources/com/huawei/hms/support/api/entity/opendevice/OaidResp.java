package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class OaidResp extends AbstractMessageEntity {
    @Packed

    /* renamed from: id */
    public String f970id;
    @Packed
    public boolean isTrackLimited;
    @Packed
    public PendingIntent settingIntent;

    public String getId() {
        return this.f970id;
    }

    public PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setId(String str) {
        this.f970id = str;
    }

    public void setSettingIntent(PendingIntent pendingIntent) {
        this.settingIntent = pendingIntent;
    }

    public void setTrackLimited(boolean z) {
        this.isTrackLimited = z;
    }
}
