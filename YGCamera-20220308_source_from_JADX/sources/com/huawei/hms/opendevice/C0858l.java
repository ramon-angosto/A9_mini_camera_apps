package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* renamed from: com.huawei.hms.opendevice.l */
/* compiled from: GetTokenTask */
public class C0858l extends TaskApiCall<PushClient, TokenResult> {

    /* renamed from: a */
    public Context f797a;

    /* renamed from: b */
    public TokenReq f798b;

    public C0858l(String str, TokenReq tokenReq, Context context, String str2) {
        super(str, JsonUtil.createJsonString(tokenReq), str2);
        this.f797a = context;
        this.f798b = tokenReq;
    }

    /* renamed from: a */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<TokenResult> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            String str2 = HmsInstanceId.TAG;
            HMSLog.m1377e(str2, "TokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.setException(fromCode.toApiException());
            } else {
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        } else {
            TokenResp tokenResp = (TokenResp) JsonUtil.jsonToEntity(str, new TokenResp());
            ErrorEnum fromCode2 = ErrorEnum.fromCode(tokenResp.getRetCode());
            if (fromCode2 != ErrorEnum.SUCCESS) {
                taskCompletionSource.setException(fromCode2.toApiException());
                String str3 = HmsInstanceId.TAG;
                HMSLog.m1377e(str3, "TokenTask failed, StatusCode:" + fromCode2.getExternalCode());
            } else {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(tokenResp.getToken());
                tokenResult.setBelongId(tokenResp.getBelongId());
                tokenResult.setRetCode(ErrorEnum.fromCode(tokenResp.getRetCode()).getExternalCode());
                taskCompletionSource.setResult(tokenResult);
                String token = tokenResp.getToken();
                if (TextUtils.isEmpty(token)) {
                    HMSLog.m1379i(HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
                    C0865q.m1181a(pushClient.getContext(), getUri(), responseErrorCode);
                    return;
                }
                mo14173a(token, this.f798b.getSubjectId());
                C0860n.m1154a(this.f797a, token);
            }
        }
        C0865q.m1181a(pushClient.getContext(), getUri(), responseErrorCode);
    }

    public int getMinApkVersion() {
        return this.f798b.isMultiSender() ? 50004300 : 30000000;
    }

    /* renamed from: a */
    public final void mo14173a(String str, String str2) {
        if (!C0855i.m1144a(this.f797a).mo14167b(str2).equals(str)) {
            HMSLog.m1379i(HmsInstanceId.TAG, "receive a token, refresh the local token");
            C0855i.m1144a(this.f797a).mo14168b(str2, str);
        }
    }
}
