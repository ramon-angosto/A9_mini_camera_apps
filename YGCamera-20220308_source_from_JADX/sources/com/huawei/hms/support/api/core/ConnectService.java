package com.huawei.hms.support.api.core;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;

public final class ConnectService {

    /* renamed from: com.huawei.hms.support.api.core.ConnectService$a */
    static class C0907a extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp> {
        C0907a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        /* renamed from: a */
        public ResolveResult<ConnectResp> onComplete(ConnectResp connectResp) {
            ResolveResult<ConnectResp> resolveResult = new ResolveResult<>(connectResp);
            resolveResult.setStatus(Status.SUCCESS);
            HMSLog.m1374d("connectservice", "connect - onComplete: success");
            return resolveResult;
        }

        /* access modifiers changed from: protected */
        public boolean checkApiClient(ApiClient apiClient) {
            return apiClient != null;
        }
    }

    /* renamed from: com.huawei.hms.support.api.core.ConnectService$b */
    static class C0908b extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp> {
        C0908b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        /* renamed from: a */
        public ResolveResult<ConnectResp> onComplete(ConnectResp connectResp) {
            ResolveResult<ConnectResp> resolveResult = new ResolveResult<>(connectResp);
            resolveResult.setStatus(Status.SUCCESS);
            HMSLog.m1374d("connectservice", "forceConnect - onComplete: success");
            return resolveResult;
        }

        /* access modifiers changed from: protected */
        public boolean checkApiClient(ApiClient apiClient) {
            return apiClient != null;
        }
    }

    /* renamed from: com.huawei.hms.support.api.core.ConnectService$c */
    static class C0909c extends PendingResultImpl<ResolveResult<JosGetNoticeResp>, JosGetNoticeResp> {
        C0909c(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        /* renamed from: a */
        public ResolveResult<JosGetNoticeResp> onComplete(JosGetNoticeResp josGetNoticeResp) {
            if (josGetNoticeResp == null) {
                HMSLog.m1377e("connectservice", "JosNoticeResp is null");
                return null;
            }
            HMSLog.m1379i("connectservice", "josNoticeResp status code :" + josGetNoticeResp.getStatusCode());
            ResolveResult<JosGetNoticeResp> resolveResult = new ResolveResult<>(josGetNoticeResp);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    private ConnectService() {
    }

    public static InnerPendingResult<ResolveResult<CheckConnectResp>> checkconnect(ApiClient apiClient, CheckConnectInfo checkConnectInfo) {
        return ResolvePendingResult.build(apiClient, CoreNaming.CHECKCONNECT, checkConnectInfo, CheckConnectResp.class);
    }

    public static PendingResult<ResolveResult<ConnectResp>> connect(ApiClient apiClient, ConnectInfo connectInfo) {
        return new C0907a(apiClient, CoreNaming.CONNECT, connectInfo);
    }

    public static ResolvePendingResult<DisconnectResp> disconnect(ApiClient apiClient, DisconnectInfo disconnectInfo) {
        return ResolvePendingResult.build(apiClient, CoreNaming.DISCONNECT, disconnectInfo, DisconnectResp.class);
    }

    public static PendingResult<ResolveResult<ConnectResp>> forceConnect(ApiClient apiClient, ConnectInfo connectInfo) {
        return new C0908b(apiClient, CoreNaming.FORECONNECT, connectInfo);
    }

    public static PendingResult<ResolveResult<JosGetNoticeResp>> getNotice(ApiClient apiClient, int i, String str) {
        JosGetNoticeReq josGetNoticeReq = new JosGetNoticeReq();
        josGetNoticeReq.setNoticeType(i);
        josGetNoticeReq.setHmsSdkVersionName(str);
        if (!TextUtils.isEmpty(apiClient.getCpID())) {
            josGetNoticeReq.setCpID(apiClient.getCpID());
        }
        return new C0909c(apiClient, CoreNaming.GETNOTICE, josGetNoticeReq);
    }
}
