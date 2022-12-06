package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.core.aidl.C0701a;
import com.huawei.hms.core.aidl.C0702b;
import com.huawei.hms.core.aidl.C0704c;
import com.huawei.hms.core.aidl.C0710e;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

public class IPCTransport implements DatagramTransport {

    /* renamed from: a */
    private final String f332a;

    /* renamed from: b */
    private final IMessageEntity f333b;

    /* renamed from: c */
    private final Class<? extends IMessageEntity> f334c;

    /* renamed from: d */
    private int f335d;

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls) {
        this.f332a = str;
        this.f333b = iMessageEntity;
        this.f334c = cls;
    }

    /* renamed from: a */
    private int m244a(ApiClient apiClient, C0704c cVar) {
        if (apiClient instanceof HuaweiApiClientImpl) {
            C0702b bVar = new C0702b(this.f332a, ProtocolNegotiate.getInstance().getVersion());
            C0710e a = C0701a.m423a(bVar.mo13626c());
            bVar.mo13624a(a.mo13636a(this.f333b, new Bundle()));
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.setAppID(apiClient.getAppID());
            requestHeader.setPackageName(apiClient.getPackageName());
            requestHeader.setSdkVersion(50200300);
            requestHeader.setApiNameList(((HuaweiApiClientImpl) apiClient).getApiNameList());
            requestHeader.setSessionId(apiClient.getSessionId());
            requestHeader.setApiLevel(this.f335d);
            bVar.f437b = a.mo13636a((IMessageEntity) requestHeader, new Bundle());
            try {
                HuaweiApiClientImpl huaweiApiClientImpl = (HuaweiApiClientImpl) apiClient;
                if (huaweiApiClientImpl.getService() == null) {
                    HMSLog.m1377e("IPCTransport", "HuaweiApiClient is not binded to service yet.");
                    return CommonCode.ErrorCode.INTERNAL_ERROR;
                }
                huaweiApiClientImpl.getService().mo13634a(bVar, cVar);
                return 0;
            } catch (Exception e) {
                HMSLog.m1377e("IPCTransport", "sync call ex:" + e);
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        } else {
            if (apiClient instanceof AidlApiClient) {
                AidlApiClient aidlApiClient = (AidlApiClient) apiClient;
                C0702b bVar2 = new C0702b(this.f332a, ProtocolNegotiate.getInstance().getVersion());
                bVar2.mo13624a(C0701a.m423a(bVar2.mo13626c()).mo13636a(this.f333b, new Bundle()));
                try {
                    aidlApiClient.getService().mo13634a(bVar2, cVar);
                    return 0;
                } catch (Exception e2) {
                    HMSLog.m1377e("IPCTransport", "sync call ex:" + e2);
                }
            }
            return CommonCode.ErrorCode.INTERNAL_ERROR;
        }
    }

    public final void post(ApiClient apiClient, DatagramTransport.C0915a aVar) {
        send(apiClient, aVar);
    }

    public final void send(ApiClient apiClient, DatagramTransport.C0915a aVar) {
        int a = m244a(apiClient, new IPCCallback(this.f334c, aVar));
        if (a != 0) {
            aVar.mo14356a(a, (IMessageEntity) null);
        }
    }

    public IPCTransport(String str, IMessageEntity iMessageEntity, Class<? extends IMessageEntity> cls, int i) {
        this.f332a = str;
        this.f333b = iMessageEntity;
        this.f334c = cls;
        this.f335d = i;
    }
}
