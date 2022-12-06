package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.C0707d;
import java.util.List;

public interface AidlApiClient extends ApiClient {
    List<String> getApiNameList();

    C0707d getService();
}
