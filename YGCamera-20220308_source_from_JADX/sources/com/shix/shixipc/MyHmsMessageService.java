package com.shix.shixipc;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.huawei.hms.push.SendException;
import com.shix.shixipc.system.ContentCommon;
import java.util.Arrays;

public class MyHmsMessageService extends HmsMessageService {
    private static final String CODELABS_ACTION = "com.huawei.codelabpush.action";
    private static final String TAG = "ZHAOPUSH";

    public void onNewToken(String str) {
        Log.i(TAG, "ZHAOPUSH received refresh token:" + str);
        if (!TextUtils.isEmpty(str)) {
            refreshedTokenToServer(str);
        }
        if (ContentCommon.HW_STRING == null || ContentCommon.HW_STRING.length() < 5) {
            ContentCommon.HW_STRING = str;
        }
        Intent intent = new Intent();
        intent.setAction(CODELABS_ACTION);
        intent.putExtra("method", "ZHAOPUSH onNewToken");
        intent.putExtra("msg", "ZHAOPUSH onNewToken called, token: " + str);
        sendBroadcast(intent);
    }

    private void refreshedTokenToServer(String str) {
        Log.i(TAG, "ZHAOPUSH sending token to server. token:" + str);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i(TAG, "ZHAOPUSH onMessageReceived is called");
        if (remoteMessage == null) {
            Log.e(TAG, "ZHAOPUSH Received message entity is null!");
            return;
        }
        Log.i(TAG, "ZHAOPUSH getCollapseKey: " + remoteMessage.getCollapseKey() + "\n getData: " + remoteMessage.getData() + "\n getFrom: " + remoteMessage.getFrom() + "\n getTo: " + remoteMessage.getTo() + "\n getMessageId: " + remoteMessage.getMessageId() + "\n getMessageType: " + remoteMessage.getMessageType() + "\n getSendTime: " + remoteMessage.getSentTime() + "\n getTtl: " + remoteMessage.getTtl() + "\n getSendMode: " + remoteMessage.getSendMode() + "\n getReceiptMode: " + remoteMessage.getReceiptMode() + "\n getOriginalUrgency: " + remoteMessage.getOriginalUrgency() + "\n getUrgency: " + remoteMessage.getUrgency() + "\n getToken: " + remoteMessage.getToken());
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification != null) {
            Log.i(TAG, "\nZHAOPUSH getTitle: " + notification.getTitle() + "\n getTitleLocalizationKey: " + notification.getTitleLocalizationKey() + "\n getTitleLocalizationArgs: " + Arrays.toString(notification.getTitleLocalizationArgs()) + "\n getBody: " + notification.getBody() + "\n getBodyLocalizationKey: " + notification.getBodyLocalizationKey() + "\n getBodyLocalizationArgs: " + Arrays.toString(notification.getBodyLocalizationArgs()) + "\n getIcon: " + notification.getIcon() + "\n getImageUrl: " + notification.getImageUrl() + "\n getSound: " + notification.getSound() + "\n getTag: " + notification.getTag() + "\n getColor: " + notification.getColor() + "\n getClickAction: " + notification.getClickAction() + "\n getIntentUri: " + notification.getIntentUri() + "\n getChannelId: " + notification.getChannelId() + "\n getLink: " + notification.getLink() + "\n getNotifyId: " + notification.getNotifyId() + "\n isDefaultLight: " + notification.isDefaultLight() + "\n isDefaultSound: " + notification.isDefaultSound() + "\n isDefaultVibrate: " + notification.isDefaultVibrate() + "\n getWhen: " + notification.getWhen() + "\n getLightSettings: " + Arrays.toString(notification.getLightSettings()) + "\n isLocalOnly: " + notification.isLocalOnly() + "\n getBadgeNumber: " + notification.getBadgeNumber() + "\n isAutoCancel: " + notification.isAutoCancel() + "\n getImportance: " + notification.getImportance() + "\n getTicker: " + notification.getTicker() + "\n getVibrateConfig: " + Arrays.toString(notification.getVibrateConfig()) + "\n getVisibility: " + notification.getVisibility());
        }
        Intent intent = new Intent();
        intent.setAction(CODELABS_ACTION);
        intent.putExtra("method", "ZHAOPUSH onMessageReceived");
        intent.putExtra("msg", "ZHAOPUSH onMessageReceived called, message id:" + remoteMessage.getMessageId() + ", payload data:" + remoteMessage.getData());
        sendBroadcast(intent);
        Boolean bool = false;
        if (bool.booleanValue()) {
            startWorkManagerJob(remoteMessage);
        } else {
            processWithin10s(remoteMessage);
        }
    }

    private void startWorkManagerJob(RemoteMessage remoteMessage) {
        Log.d(TAG, "ZHAOPUSH Start new Job processing.");
    }

    private void processWithin10s(RemoteMessage remoteMessage) {
        Log.d(TAG, "Processing now.");
    }

    public void onMessageSent(String str) {
        Log.i(TAG, "ZHAOPUSH onMessageSent called, Message id:" + str);
        Intent intent = new Intent();
        intent.setAction(CODELABS_ACTION);
        intent.putExtra("method", "onMessageSent");
        intent.putExtra("msg", "onMessageSent called, Message id:" + str);
        sendBroadcast(intent);
    }

    public void onSendError(String str, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("ZHAOPUSH onSendError called, message id:");
        sb.append(str);
        sb.append(", ErrCode:");
        SendException sendException = (SendException) exc;
        sb.append(sendException.getErrorCode());
        sb.append(", description:");
        sb.append(exc.getMessage());
        Log.i(TAG, sb.toString());
        Intent intent = new Intent();
        intent.setAction(CODELABS_ACTION);
        intent.putExtra("method", "onSendError");
        intent.putExtra("msg", "onSendError called, message id:" + str + ", ErrCode:" + sendException.getErrorCode() + ", description:" + exc.getMessage());
        sendBroadcast(intent);
    }

    public void onTokenError(Exception exc) {
        super.onTokenError(exc);
    }
}
