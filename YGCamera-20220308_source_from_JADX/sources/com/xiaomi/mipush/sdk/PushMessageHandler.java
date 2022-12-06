package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.C1776eu;
import com.xiaomi.push.C1788fe;
import com.xiaomi.push.C1872hs;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C2087u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PushMessageHandler extends BaseService {

    /* renamed from: a */
    private static List<MiPushClient.ICallbackResult> f1637a = new ArrayList();

    /* renamed from: a */
    private static ThreadPoolExecutor f1638a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: b */
    private static List<MiPushClient.MiPushClientCallback> f1639b = new ArrayList();

    /* renamed from: com.xiaomi.mipush.sdk.PushMessageHandler$a */
    interface C1552a extends Serializable {
    }

    /* renamed from: a */
    protected static void mo17007a() {
        synchronized (f1639b) {
            f1639b.clear();
        }
    }

    /* renamed from: a */
    public static void m2256a(long j, String str, String str2) {
        synchronized (f1639b) {
            for (MiPushClient.MiPushClientCallback onInitializeResult : f1639b) {
                onInitializeResult.onInitializeResult(j, str, str2);
            }
        }
    }

    /* renamed from: a */
    public static void m2257a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e) {
            C1524b.m2141a(e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m2258a(Context context, Intent intent) {
        C1524b.m2159c("addjob PushMessageHandler " + intent);
        if (intent != null) {
            m2273c(context, intent);
            m2257a(context);
        }
    }

    /* renamed from: a */
    private static void m2259a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.C1543a aVar = new MessageHandleService.C1543a(intent, (PushMessageReceiver) C2087u.m5373a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.m2230a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.m2229a(context, new Intent(context.getApplicationContext(), MessageHandleService.class));
        } catch (Throwable th) {
            C1524b.m2155a(th);
        }
    }

    /* renamed from: a */
    protected static void m2260a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f1637a) {
            for (MiPushClient.ICallbackResult next : f1637a) {
                if (next instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (!(miPushCommandMessage == null || miPushCommandMessage.getCommandArguments() == null || miPushCommandMessage.getCommandArguments().size() <= 0)) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    next.onResult(tokenResult);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2261a(Context context, MiPushMessage miPushMessage) {
        synchronized (f1639b) {
            for (MiPushClient.MiPushClientCallback next : f1639b) {
                if (m2267a(miPushMessage.getCategory(), next.getCategory())) {
                    next.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    next.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2262a(Context context, C1552a aVar) {
        if (aVar instanceof MiPushMessage) {
            m2261a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (C1788fe.COMMAND_REGISTER.f2292a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                m2256a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (C1788fe.COMMAND_SET_ALIAS.f2292a.equals(command) || C1788fe.COMMAND_UNSET_ALIAS.f2292a.equals(command) || C1788fe.COMMAND_SET_ACCEPT_TIME.f2292a.equals(command)) {
                m2264a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (C1788fe.COMMAND_SUBSCRIBE_TOPIC.f2292a.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                Context context2 = context;
                m2263a(context2, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (C1788fe.COMMAND_UNSUBSCRIBE_TOPIC.f2292a.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                Context context3 = context;
                m2271b(context3, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    /* renamed from: a */
    protected static void m2263a(Context context, String str, long j, String str2, String str3) {
        synchronized (f1639b) {
            for (MiPushClient.MiPushClientCallback next : f1639b) {
                if (m2267a(str, next.getCategory())) {
                    next.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: a */
    protected static void m2264a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (f1639b) {
            for (MiPushClient.MiPushClientCallback next : f1639b) {
                if (m2267a(str, next.getCategory())) {
                    next.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    /* renamed from: a */
    protected static void m2265a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (f1637a) {
            if (!f1637a.contains(iCallbackResult)) {
                f1637a.add(iCallbackResult);
            }
        }
    }

    /* renamed from: a */
    protected static void m2266a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (f1639b) {
            if (!f1639b.contains(miPushClientCallback)) {
                f1639b.add(miPushClientCallback);
            }
        }
    }

    /* renamed from: a */
    protected static boolean m2267a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* renamed from: b */
    protected static void m2268b() {
        synchronized (f1637a) {
            f1637a.clear();
        }
    }

    /* renamed from: b */
    private static void m2269b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, C1581d.m2417a(context));
        } catch (Exception e) {
            C1524b.m2141a("callback sync error" + e);
        }
    }

    /* renamed from: b */
    protected static void m2270b(Context context, Intent intent) {
        boolean z = false;
        try {
            z = intent.getBooleanExtra("is_clicked_activity_call", z);
        } catch (Throwable th) {
            C1524b.m2141a("intent unparcel error:" + th);
        }
        try {
            ResolveInfo resolveInfo = null;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                C1593o.m2457a(context, intent, (Uri) null);
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                C1872hs hsVar = new C1872hs();
                C1905iy.m4542a(hsVar, intent.getByteArrayExtra("mipush_payload"));
                C1524b.m2159c("PushMessageHandler.onHandleIntent " + hsVar.mo17792d());
                MiTinyDataClient.upload(context, hsVar);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m2268b()) {
                    C1524b.m2160d("receive a message before application calling initialize");
                    if (z) {
                        m2269b(context);
                        return;
                    }
                    return;
                }
                C1552a a = C1566am.m2297a(context).mo17131a(intent);
                if (a != null) {
                    m2262a(context, a);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                if (queryBroadcastReceivers != null) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ResolveInfo next = it.next();
                        if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(C2087u.m5373a(context, next.activityInfo.name))) {
                            resolveInfo = next;
                            break;
                        }
                    }
                }
                if (resolveInfo != null) {
                    m2259a(context, intent2, resolveInfo, z);
                } else {
                    C1524b.m2160d("cannot find the receiver to handler this message, check your manifest");
                    C1776eu.m3405a(context).mo17535a(context.getPackageName(), intent, "11");
                }
            }
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            C1776eu.m3405a(context).mo17535a(context.getPackageName(), intent, "9");
        } catch (Throwable th2) {
            try {
                C1524b.m2155a(th2);
                C1776eu.m3405a(context).mo17535a(context.getPackageName(), intent, "10");
                if (!z) {
                    return;
                }
            } finally {
                if (z) {
                    m2269b(context);
                }
            }
        }
        if (!z) {
        }
    }

    /* renamed from: b */
    protected static void m2271b(Context context, String str, long j, String str2, String str3) {
        synchronized (f1639b) {
            for (MiPushClient.MiPushClientCallback next : f1639b) {
                if (m2267a(str, next.getCategory())) {
                    next.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m2272b() {
        return f1639b.isEmpty();
    }

    /* renamed from: c */
    private static void m2273c(Context context, Intent intent) {
        if (intent != null && !f1638a.isShutdown()) {
            f1638a.execute(new C1565al(context, intent));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m2274a() {
        ThreadPoolExecutor threadPoolExecutor = f1638a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f1638a.getQueue().size() <= 0) ? false : true;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        m2273c(getApplicationContext(), intent);
    }
}
