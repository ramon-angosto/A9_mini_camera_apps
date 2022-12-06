package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public abstract class HmsClient extends BaseHmsClient implements AnyClient {
    private static final String TAG = "HmsClient";

    public HmsClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    public void post(IMessageEntity iMessageEntity, String str, AnyClient.CallBack callBack) {
        if (callBack == null) {
            HMSLog.m1377e(TAG, "callback is invalid, discard.");
        } else if (!(iMessageEntity instanceof RequestHeader) || str == null) {
            HMSLog.m1377e(TAG, "arguments is invalid.");
            callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "Args is invalid"), new JSONObject().toString());
        } else if (!isConnected()) {
            HMSLog.m1377e(TAG, "post failed for no connected.");
            callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, "Not Connected"), new JSONObject().toString());
        } else {
            RequestHeader requestHeader = (RequestHeader) iMessageEntity;
            HMSLog.m1379i(TAG, "post msg " + requestHeader);
            Activity cpActivity = getClientSettings().getCpActivity();
            (cpActivity == null ? new BaseAdapter(this) : new BaseAdapter(this, cpActivity)).baseRequest(requestHeader.toJson(), str, requestHeader.getParcelable(), new BaseAdapterCallBack(this, callBack));
        }
    }

    public void updateSessionId(String str) {
        if (TextUtils.isEmpty(this.sessionId)) {
            this.sessionId = str;
        }
    }

    private static class BaseAdapterCallBack implements BaseAdapter.BaseCallBack {
        private final AnyClient.CallBack callback;
        private final WeakReference<HmsClient> hmsClient;

        BaseAdapterCallBack(HmsClient hmsClient2, AnyClient.CallBack callBack) {
            this.callback = callBack;
            this.hmsClient = new WeakReference<>(hmsClient2);
        }

        private void doCallback(String str, String str2) {
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                HMSLog.m1379i(HmsClient.TAG, "receive msg " + responseHeader);
                updateSessionId(responseHeader.getSessionId());
                this.callback.onCallback(responseHeader, str2);
                return;
            }
            this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }

        private void updateSessionId(String str) {
            HmsClient hmsClient2 = (HmsClient) this.hmsClient.get();
            if (hmsClient2 != null) {
                hmsClient2.updateSessionId(str);
            }
        }

        public void onComplete(String str, String str2, Parcelable parcelable) {
            if (parcelable == null) {
                doCallback(str, str2);
            } else {
                doCallback(str, str2, parcelable);
            }
        }

        public void onError(String str) {
            ResponseWrap responseWrap = new ResponseWrap(new ResponseHeader());
            if (responseWrap.fromJson(str)) {
                HMSLog.m1379i(HmsClient.TAG, "receive msg " + responseWrap);
                ResponseHeader responseHeader = responseWrap.getResponseHeader();
                updateSessionId(responseHeader.getSessionId());
                this.callback.onCallback(responseHeader, responseWrap.getBody());
                return;
            }
            this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }

        private void doCallback(String str, String str2, Parcelable parcelable) {
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                responseHeader.setParcelable(parcelable);
                HMSLog.m1379i(HmsClient.TAG, "receive msg " + responseHeader);
                updateSessionId(responseHeader.getSessionId());
                this.callback.onCallback(responseHeader, str2);
                return;
            }
            this.callback.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }
    }
}
