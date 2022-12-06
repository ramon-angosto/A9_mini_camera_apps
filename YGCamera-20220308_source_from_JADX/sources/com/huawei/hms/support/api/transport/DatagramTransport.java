package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

public interface DatagramTransport {

    /* renamed from: com.huawei.hms.support.api.transport.DatagramTransport$a */
    public interface C0915a {
        /* renamed from: a */
        void mo14356a(int i, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, C0915a aVar);

    void send(ApiClient apiClient, C0915a aVar);
}
