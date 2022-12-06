package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HmsMessageService extends Service {
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";

    /* renamed from: a */
    public final Messenger f827a = new Messenger(new C0870a());

    /* renamed from: com.huawei.hms.push.HmsMessageService$a */
    private class C0870a extends Handler {
        public C0870a() {
        }

        public void handleMessage(Message message) {
            if (message == null) {
                HMSLog.m1377e("HmsMessageService", "receive message is null");
                return;
            }
            HMSLog.m1379i("HmsMessageService", "handle message start ");
            Bundle data = message.getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                intent.putExtra(RemoteMessageConst.INPUT_TYPE, data.getInt(RemoteMessageConst.INPUT_TYPE, -1));
                HmsMessageService.this.handleIntentMessage(intent);
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    public final void mo14184a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Context applicationContext = getApplicationContext();
            if (!str.equals(BaseUtils.getLocalToken(applicationContext, str2))) {
                HMSLog.m1379i("HmsMessageService", "receive a token, refresh the local token");
                BaseUtils.saveToken(applicationContext, str2, str);
                return;
            }
            BaseUtils.reportAaidToken(applicationContext, str);
        }
    }

    /* renamed from: b */
    public final void mo14186b(Intent intent) {
        HMSLog.m1379i("HmsMessageService", "parse batch response.");
        String stringExtra = intent.getStringExtra("batchMsgbody");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONArray jSONArray = new JSONArray(stringExtra);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("transactionId");
                    String optString2 = jSONObject.optString(RemoteMessageConst.MSGID);
                    int optInt = jSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
                    if (ErrorEnum.SUCCESS.getInternalCode() == optInt) {
                        mo14187b(optString, optString2);
                    } else {
                        mo14188b(optString, optString2, optInt);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.m1380w("HmsMessageService", "parse batch response failed.");
            }
        }
    }

    public void doMsgReceived(Intent intent) {
        onMessageReceived(new RemoteMessage(mo14180a(intent)));
    }

    public void handleIntentMessage(Intent intent) {
        if (intent == null) {
            HMSLog.m1377e("HmsMessageService", "receive message is null");
            return;
        }
        String stringExtra = intent.getStringExtra("message_id");
        String stringExtra2 = intent.getStringExtra("message_type");
        String stringExtra3 = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
        if ("new_token".equals(stringExtra2)) {
            HMSLog.m1379i("HmsMessageService", "onNewToken");
            mo14182a(intent, stringExtra3);
        } else if ("received_message".equals(stringExtra2)) {
            HMSLog.m1379i("HmsMessageService", "onMessageReceived, message id:" + stringExtra);
            mo14185a(PushNaming.RECEIVE_MSG_RSP, stringExtra, ErrorEnum.SUCCESS.getInternalCode());
            doMsgReceived(intent);
        } else if ("sent_message".equals(stringExtra2)) {
            mo14187b(stringExtra3, stringExtra);
        } else if ("send_error".equals(stringExtra2)) {
            mo14188b(stringExtra3, stringExtra, intent.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
        } else if ("delivery".equals(stringExtra2)) {
            int intExtra = intent.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
            HMSLog.m1379i("HmsMessageService", "onMessageDelivery, message id:" + stringExtra + ", status:" + intExtra + ", transactionId: " + stringExtra3);
            mo14185a(PushNaming.UPSEND_RECEIPT, stringExtra3, intExtra);
            onMessageDelivered(stringExtra, new SendException(intExtra));
        } else if ("server_deleted_message".equals(stringExtra2)) {
            HMSLog.m1379i("HmsMessageService", "delete message, message id:" + stringExtra);
            onDeletedMessages();
        } else if ("batchSent".equals(stringExtra2)) {
            mo14186b(intent);
        } else {
            HMSLog.m1377e("HmsMessageService", "Receive unknown message: " + stringExtra2);
        }
    }

    public IBinder onBind(Intent intent) {
        HMSLog.m1379i("HmsMessageService", "start to bind");
        return this.f827a.getBinder();
    }

    public void onDeletedMessages() {
    }

    public void onDestroy() {
        HMSLog.m1379i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public void onMessageDelivered(String str, Exception exc) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onNewToken(String str, Bundle bundle) {
    }

    public void onSendError(String str, Exception exc) {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        HMSLog.m1379i("HmsMessageService", "start to command , startId = " + i2);
        handleIntentMessage(intent);
        return 2;
    }

    public void onTokenError(Exception exc) {
    }

    public void onTokenError(Exception exc, Bundle bundle) {
    }

    /* renamed from: a */
    public final Bundle mo14180a(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("message_id", intent.getStringExtra("message_id"));
        bundle.putByteArray(RemoteMessageConst.MSGBODY, intent.getByteArrayExtra(RemoteMessageConst.MSGBODY));
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN));
        if (intent.getIntExtra(RemoteMessageConst.INPUT_TYPE, -1) == 1) {
            bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
        }
        return bundle;
    }

    /* renamed from: b */
    public final void mo14187b(String str, String str2) {
        HMSLog.m1379i("HmsMessageService", "onMessageSent, message id:" + str2 + ", transactionId: " + str);
        mo14185a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, ErrorEnum.SUCCESS.getInternalCode());
        onMessageSent(str2);
    }

    /* renamed from: a */
    public final void mo14182a(Intent intent, String str) {
        int intExtra = intent.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode());
        mo14185a(PushNaming.GETTOKEN_ASYNC_RSP, str, intExtra);
        String stringExtra = intent.getStringExtra("subjectId");
        String stringExtra2 = intent.getStringExtra("message_proxy_type");
        HMSLog.m1379i("HmsMessageService", "doOnNewToken:transactionId = " + str + " , internalCode = " + intExtra + ",subjectId:" + stringExtra + ",proxyType:" + stringExtra2);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString(SUBJECT_ID, stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString(PROXY_TYPE, stringExtra2);
        }
        if (intExtra == ErrorEnum.SUCCESS.getInternalCode()) {
            HMSLog.m1379i("HmsMessageService", "Apply token OnNewToken, subId: " + stringExtra);
            mo14181a(intent, bundle, stringExtra);
            return;
        }
        HMSLog.m1379i("HmsMessageService", "Apply token failed, subId: " + stringExtra);
        mo14183a(bundle, stringExtra, intExtra);
    }

    /* renamed from: b */
    public final void mo14188b(String str, String str2, int i) {
        HMSLog.m1379i("HmsMessageService", "onSendError, message id:" + str2 + " error:" + i + ", transactionId: " + str);
        mo14185a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, i);
        onSendError(str2, new SendException(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a8, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo14183a(android.os.Bundle r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.Context r0 = r4.getApplicationContext()     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = r0.getPackageName()     // Catch:{ all -> 0x00a9 }
            r2 = 0
            java.lang.String r1 = com.huawei.hms.aaid.utils.BaseUtils.getCacheData(r0, r1, r2)     // Catch:{ all -> 0x00a9 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00a9 }
            r1 = r1 ^ 1
            boolean r3 = r5.isEmpty()     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0032
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = "HmsMessageService"
            java.lang.String r3 = "onTokenError to host app."
            com.huawei.hms.support.log.HMSLog.m1379i(r1, r3)     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.push.BaseException r1 = new com.huawei.hms.push.BaseException     // Catch:{ all -> 0x00a9 }
            r1.<init>(r7)     // Catch:{ all -> 0x00a9 }
            r4.onTokenError(r1)     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = r0.getPackageName()     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.aaid.utils.BaseUtils.deleteCacheData(r0, r1)     // Catch:{ all -> 0x00a9 }
        L_0x0032:
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x0089
            java.lang.String[] r6 = com.huawei.hms.aaid.utils.BaseUtils.getSubjectIds(r0)     // Catch:{ all -> 0x00a9 }
            if (r6 == 0) goto L_0x0078
            int r1 = r6.length     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0042
            goto L_0x0078
        L_0x0042:
            int r5 = r6.length     // Catch:{ all -> 0x00a9 }
            if (r2 >= r5) goto L_0x0074
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x00a9 }
            r5.<init>()     // Catch:{ all -> 0x00a9 }
            r1 = r6[r2]     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = "subject_id"
            r5.putString(r3, r1)     // Catch:{ all -> 0x00a9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r1.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = "onTokenError to sub app, subjectId:"
            r1.append(r3)     // Catch:{ all -> 0x00a9 }
            r3 = r6[r2]     // Catch:{ all -> 0x00a9 }
            r1.append(r3)     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = "HmsMessageService"
            com.huawei.hms.support.log.HMSLog.m1379i(r3, r1)     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.push.BaseException r1 = new com.huawei.hms.push.BaseException     // Catch:{ all -> 0x00a9 }
            r1.<init>(r7)     // Catch:{ all -> 0x00a9 }
            r4.onTokenError(r1, r5)     // Catch:{ all -> 0x00a9 }
            int r2 = r2 + 1
            goto L_0x0042
        L_0x0074:
            com.huawei.hms.aaid.utils.BaseUtils.clearSubjectIds(r0)     // Catch:{ all -> 0x00a9 }
            goto L_0x00a7
        L_0x0078:
            java.lang.String r6 = "HmsMessageService"
            java.lang.String r0 = "onTokenError to host app with bundle."
            com.huawei.hms.support.log.HMSLog.m1379i(r6, r0)     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.push.BaseException r6 = new com.huawei.hms.push.BaseException     // Catch:{ all -> 0x00a9 }
            r6.<init>(r7)     // Catch:{ all -> 0x00a9 }
            r4.onTokenError(r6, r5)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r4)
            return
        L_0x0089:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r0.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = "onTokenError to sub app, subjectId:"
            r0.append(r1)     // Catch:{ all -> 0x00a9 }
            r0.append(r6)     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = "HmsMessageService"
            com.huawei.hms.support.log.HMSLog.m1379i(r0, r6)     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.push.BaseException r6 = new com.huawei.hms.push.BaseException     // Catch:{ all -> 0x00a9 }
            r6.<init>(r7)     // Catch:{ all -> 0x00a9 }
            r4.onTokenError(r6, r5)     // Catch:{ all -> 0x00a9 }
        L_0x00a7:
            monitor-exit(r4)
            return
        L_0x00a9:
            r5 = move-exception
            monitor-exit(r4)
            goto L_0x00ad
        L_0x00ac:
            throw r5
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.HmsMessageService.mo14183a(android.os.Bundle, java.lang.String, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ad, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo14181a(android.content.Intent r6, android.os.Bundle r7, java.lang.String r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "device_token"
            java.lang.String r0 = r6.getStringExtra(r0)     // Catch:{ all -> 0x00ae }
            r5.mo14184a((java.lang.String) r0, (java.lang.String) r8)     // Catch:{ all -> 0x00ae }
            android.content.Context r1 = r5.getApplicationContext()     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = r1.getPackageName()     // Catch:{ all -> 0x00ae }
            r3 = 0
            java.lang.String r2 = com.huawei.hms.aaid.utils.BaseUtils.getCacheData(r1, r2, r3)     // Catch:{ all -> 0x00ae }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00ae }
            r2 = r2 ^ 1
            boolean r4 = r7.isEmpty()     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0036
            if (r2 == 0) goto L_0x0036
            java.lang.String r2 = "HmsMessageService"
            java.lang.String r4 = "onNewToken to host app."
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r4)     // Catch:{ all -> 0x00ae }
            r5.onNewToken(r0)     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = r1.getPackageName()     // Catch:{ all -> 0x00ae }
            com.huawei.hms.aaid.utils.BaseUtils.deleteCacheData(r1, r2)     // Catch:{ all -> 0x00ae }
        L_0x0036:
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x0093
            java.lang.String[] r8 = com.huawei.hms.aaid.utils.BaseUtils.getSubjectIds(r1)     // Catch:{ all -> 0x00ae }
            if (r8 == 0) goto L_0x007c
            int r2 = r8.length     // Catch:{ all -> 0x00ae }
            if (r2 != 0) goto L_0x0046
            goto L_0x007c
        L_0x0046:
            int r6 = r8.length     // Catch:{ all -> 0x00ae }
            if (r3 >= r6) goto L_0x0078
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x00ae }
            r6.<init>()     // Catch:{ all -> 0x00ae }
            r7 = r8[r3]     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "subject_id"
            r6.putString(r2, r7)     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r7.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "onNewToken to sub app, subjectId:"
            r7.append(r2)     // Catch:{ all -> 0x00ae }
            r2 = r8[r3]     // Catch:{ all -> 0x00ae }
            r7.append(r2)     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "HmsMessageService"
            com.huawei.hms.support.log.HMSLog.m1379i(r2, r7)     // Catch:{ all -> 0x00ae }
            r5.onNewToken(r0, r6)     // Catch:{ all -> 0x00ae }
            r6 = r8[r3]     // Catch:{ all -> 0x00ae }
            r5.mo14184a((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x00ae }
            int r3 = r3 + 1
            goto L_0x0046
        L_0x0078:
            com.huawei.hms.aaid.utils.BaseUtils.clearSubjectIds(r1)     // Catch:{ all -> 0x00ae }
            goto L_0x00ac
        L_0x007c:
            java.lang.String r8 = "HmsMessageService"
            java.lang.String r1 = "onNewToken to host app with bundle."
            com.huawei.hms.support.log.HMSLog.m1379i(r8, r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "belongId"
            java.lang.String r6 = r6.getStringExtra(r8)     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "belongId"
            r7.putString(r8, r6)     // Catch:{ all -> 0x00ae }
            r5.onNewToken(r0, r7)     // Catch:{ all -> 0x00ae }
            monitor-exit(r5)
            return
        L_0x0093:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r6.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = "onNewToken to sub app, subjectId:"
            r6.append(r1)     // Catch:{ all -> 0x00ae }
            r6.append(r8)     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "HmsMessageService"
            com.huawei.hms.support.log.HMSLog.m1379i(r8, r6)     // Catch:{ all -> 0x00ae }
            r5.onNewToken(r0, r7)     // Catch:{ all -> 0x00ae }
        L_0x00ac:
            monitor-exit(r5)
            return
        L_0x00ae:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x00b2
        L_0x00b1:
            throw r6
        L_0x00b2:
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.HmsMessageService.mo14181a(android.content.Intent, android.os.Bundle, java.lang.String):void");
    }

    /* renamed from: a */
    public final void mo14185a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "null";
        }
        PushBiUtil.reportExit(getApplicationContext(), str, str2, i);
    }
}
