package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1776eu;
import com.xiaomi.push.C1788fe;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MessageHandleService extends BaseService {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<C1543a> f1620a = new ConcurrentLinkedQueue<>();

    /* renamed from: a */
    private static ExecutorService f1621a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: com.xiaomi.mipush.sdk.MessageHandleService$a */
    public static class C1543a {

        /* renamed from: a */
        private Intent f1622a;

        /* renamed from: a */
        private PushMessageReceiver f1623a;

        public C1543a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f1623a = pushMessageReceiver;
            this.f1622a = intent;
        }

        /* renamed from: a */
        public Intent mo17014a() {
            return this.f1622a;
        }

        /* renamed from: a */
        public PushMessageReceiver m2235a() {
            return this.f1623a;
        }
    }

    /* renamed from: a */
    protected static void m2229a(Context context, Intent intent) {
        if (intent != null) {
            m2231b(context);
        }
    }

    /* renamed from: a */
    static void m2230a(Context context, C1543a aVar) {
        String[] stringArrayExtra;
        if (aVar != null) {
            try {
                PushMessageReceiver a = aVar.mo17014a();
                Intent a2 = aVar.mo17014a();
                int intExtra = a2.getIntExtra("message_type", 1);
                if (intExtra == 1) {
                    PushMessageHandler.C1552a a3 = C1566am.m2297a(context).mo17131a(a2);
                    int intExtra2 = a2.getIntExtra("eventMessageType", -1);
                    if (a3 == null) {
                        return;
                    }
                    if (a3 instanceof MiPushMessage) {
                        MiPushMessage miPushMessage = (MiPushMessage) a3;
                        if (!miPushMessage.isArrivedMessage()) {
                            a.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            C1776eu.m3405a(context.getApplicationContext()).mo17534a(context.getPackageName(), a2, 2004, (String) null);
                            C1524b.m2161e("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                            a.onReceivePassThroughMessage(context, miPushMessage);
                            return;
                        } else if (miPushMessage.isNotified()) {
                            if (intExtra2 == 1000) {
                                C1776eu.m3405a(context.getApplicationContext()).mo17534a(context.getPackageName(), a2, (int) PointerIconCompat.TYPE_CROSSHAIR, (String) null);
                            } else {
                                C1776eu.m3405a(context.getApplicationContext()).mo17534a(context.getPackageName(), a2, 3007, (String) null);
                            }
                            C1524b.m2161e("begin execute onNotificationMessageClicked from　" + miPushMessage.getMessageId());
                            a.onNotificationMessageClicked(context, miPushMessage);
                            return;
                        } else {
                            C1524b.m2161e("begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                            a.onNotificationMessageArrived(context, miPushMessage);
                            return;
                        }
                    } else if (a3 instanceof MiPushCommandMessage) {
                        MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                        C1524b.m2161e("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                        a.onCommandResult(context, miPushCommandMessage);
                        if (TextUtils.equals(miPushCommandMessage.getCommand(), C1788fe.COMMAND_REGISTER.f2292a)) {
                            a.onReceiveRegisterResult(context, miPushCommandMessage);
                            PushMessageHandler.m2260a(context, miPushCommandMessage);
                            if (miPushCommandMessage.getResultCode() != 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (intExtra == 3) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    C1524b.m2161e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), C1788fe.COMMAND_REGISTER.f2292a)) {
                        a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.m2260a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() != 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (intExtra != 4 && intExtra == 5) {
                    if (PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a2.getStringExtra(PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = a2.getStringArrayExtra(PushMessageHelper.ERROR_MESSAGE)) != null) {
                        C1524b.m2161e("begin execute onRequirePermissions, lack of necessary permissions");
                        a.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                } else {
                    return;
                }
                C1586i.m2443b(context);
            } catch (RuntimeException e) {
                C1524b.m2155a((Throwable) e);
            }
        }
    }

    public static void addJob(Context context, C1543a aVar) {
        if (aVar != null) {
            f1620a.add(aVar);
            m2231b(context);
            startService(context);
        }
    }

    /* renamed from: b */
    private static void m2231b(Context context) {
        if (!f1621a.isShutdown()) {
            f1621a.execute(new C1606z(context));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m2232c(Context context) {
        try {
            m2230a(context, f1620a.poll());
        } catch (RuntimeException e) {
            C1524b.m2155a((Throwable) e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        C1618ak.m2518a(context).mo17212a((Runnable) new C1605y(context, intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo17007a() {
        ConcurrentLinkedQueue<C1543a> concurrentLinkedQueue = f1620a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
