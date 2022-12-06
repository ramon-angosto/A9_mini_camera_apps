package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;
import java.util.List;

public class ConnectResp implements IMessageEntity {
    @Packed
    public List<Integer> protocolVersion = Arrays.asList(new Integer[]{1, 2});
    @Packed
    public String sessionId;

    public String toString() {
        StringBuilder sb = new StringBuilder("protocol version:");
        for (Integer append : this.protocolVersion) {
            sb.append(append);
            sb.append(',');
        }
        return sb.toString();
    }
}
