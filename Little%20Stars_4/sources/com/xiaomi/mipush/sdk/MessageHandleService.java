package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageHandleService extends IntentService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

    public static class a {
        private PushMessageReceiver a;
        private Intent b;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.a = pushMessageReceiver;
            this.b = intent;
        }

        public PushMessageReceiver a() {
            return this.a;
        }

        public Intent b() {
            return this.b;
        }
    }

    public MessageHandleService() {
        super("MessageHandleThread");
    }

    public static void addJob(a aVar) {
        if (aVar != null) {
            a.add(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        a poll;
        MiPushCommandMessage miPushCommandMessage;
        if (intent != null && (poll = a.poll()) != null) {
            try {
                PushMessageReceiver a2 = poll.a();
                Intent b = poll.b();
                int intExtra = b.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1);
                if (intExtra == 1) {
                    PushMessageHandler.a a3 = m.a((Context) this).a(b);
                    if (a3 == null) {
                        return;
                    }
                    if (a3 instanceof MiPushMessage) {
                        MiPushMessage miPushMessage = (MiPushMessage) a3;
                        if (!miPushMessage.isArrivedMessage()) {
                            a2.onReceiveMessage(this, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            a2.onReceivePassThroughMessage(this, miPushMessage);
                            return;
                        } else if (miPushMessage.isNotified()) {
                            a2.onNotificationMessageClicked(this, miPushMessage);
                            return;
                        } else {
                            a2.onNotificationMessageArrived(this, miPushMessage);
                            return;
                        }
                    } else if (a3 instanceof MiPushCommandMessage) {
                        miPushCommandMessage = (MiPushCommandMessage) a3;
                        a2.onCommandResult(this, miPushCommandMessage);
                        if (!TextUtils.equals(miPushCommandMessage.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (intExtra == 3) {
                    miPushCommandMessage = (MiPushCommandMessage) b.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    a2.onCommandResult(this, miPushCommandMessage);
                    if (!TextUtils.equals(miPushCommandMessage.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                        return;
                    }
                } else if (intExtra == 4) {
                    return;
                } else {
                    return;
                }
                a2.onReceiveRegisterResult(this, miPushCommandMessage);
            } catch (RuntimeException e) {
                b.a((Throwable) e);
            }
        }
    }
}
