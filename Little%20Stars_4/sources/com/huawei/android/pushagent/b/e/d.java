package com.huawei.android.pushagent.b.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.b.i;
import com.huawei.android.pushagent.a.b.l;
import com.huawei.android.pushagent.a.b.n;
import com.huawei.android.pushagent.a.b.o;
import com.huawei.android.pushagent.a.b.p;
import com.huawei.android.pushagent.a.b.q;
import com.huawei.android.pushagent.b.a;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.a.f;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.c.c.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d extends a {
    private static List a = new ArrayList();
    private static final Object b = new Object();
    private String[] c;
    private List d = new ArrayList();
    private List e = new ArrayList();

    public d(Context context) {
        if (!e.c()) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "not support ctrlsocket v2 ");
        } else if (1 == e.b()) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "push is in socket ctrl model, only white packages app can use push");
            this.c = e.a();
        } else {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "all apps can use push");
            this.c = new String[0];
        }
    }

    private void a(Context context) {
        String str;
        if (-1 == b.a(context)) {
            str = "sendAllMessagetoServer have no net work";
        } else if (!com.huawei.android.pushagent.b.a.a.e().a()) {
            str = "sendAllMessagetoServer have no channel or no connection";
        } else {
            com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "sendAllMessagetoServer get the client");
            ArrayList b2 = b.b(context);
            for (Map.Entry key : new h(context, "pclient_unRegist_info_v2").b().entrySet()) {
                b2.add(new p(f.b(context, (String) key.getKey())));
            }
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "send all client registerToken message count to Sever is " + b2.size());
            if (b2.size() > 0) {
                Iterator it = b2.iterator();
                while (it.hasNext()) {
                    try {
                        com.huawei.android.pushagent.b.a.a.e().a((com.huawei.android.pushagent.a.b) (com.huawei.android.pushagent.a.b.a.b) it.next());
                    } catch (Exception e2) {
                        com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", "call ChannelMgr.getPushChannel().send cause:" + e2.toString(), e2);
                    }
                }
                return;
            }
            com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "no more client need register and unregister");
            return;
        }
        com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r12, com.huawei.android.pushagent.a.b.l r13) {
        /*
            r11 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = ""
            java.lang.String r2 = "PushLogAC2705"
            java.lang.String r3 = "enter rspPushMessage"
            com.huawei.android.pushagent.c.a.e.b(r2, r3)
            byte[] r3 = r13.e()
            if (r3 != 0) goto L_0x0017
            java.lang.String r12 = "token is null, error!"
            com.huawei.android.pushagent.c.a.e.d(r2, r12)
            return
        L_0x0017:
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x001d }
            r4.<init>(r3, r0)     // Catch:{ Exception -> 0x001d }
            goto L_0x0026
        L_0x001d:
            r4 = move-exception
            java.lang.String r5 = r4.toString()
            com.huawei.android.pushagent.c.a.e.c(r2, r5, r4)
            r4 = r1
        L_0x0026:
            byte[] r5 = r13.d()
            byte[] r6 = r13.h()
            if (r6 == 0) goto L_0x005b
            int r7 = r6.length
            if (r7 <= 0) goto L_0x005b
            int r7 = r13.g()
            int r8 = r6.length
            if (r8 != r7) goto L_0x0070
            java.lang.String r7 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0041 }
            r7.<init>(r6, r0)     // Catch:{ UnsupportedEncodingException -> 0x0041 }
            r1 = r7
            goto L_0x0046
        L_0x0041:
            java.lang.String r0 = "UnsupportedEncodingException occur"
            com.huawei.android.pushagent.c.a.e.d(r2, r0)
        L_0x0046:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "rspPushMessage from srv response pkgname is :"
            r0.append(r6)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.huawei.android.pushagent.c.a.e.a(r2, r0)
            goto L_0x0070
        L_0x005b:
            com.huawei.android.pushagent.b.e.b r0 = com.huawei.android.pushagent.b.e.b.a(r12)
            java.util.HashMap r0 = r0.a
            if (r0 == 0) goto L_0x0070
            com.huawei.android.pushagent.b.e.b r0 = com.huawei.android.pushagent.b.e.b.a(r12)
            java.util.HashMap r0 = r0.a
            java.lang.Object r0 = r0.get(r4)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x0070:
            java.lang.String r0 = com.huawei.android.pushagent.c.a.a((byte[]) r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "rspPushMessage token ="
            r6.append(r7)
            java.lang.String r7 = com.huawei.android.pushagent.c.a.a.e.a((java.lang.String) r4)
            r6.append(r7)
            java.lang.String r7 = " pkgname="
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = " msgId="
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.huawei.android.pushagent.c.a.e.a(r2, r6)
            com.huawei.android.pushagent.a.b.m r6 = new com.huawei.android.pushagent.a.b.m
            r7 = 0
            r6.<init>(r5, r7)
            java.lang.String r8 = com.huawei.android.pushagent.c.a.i(r12)
            boolean r4 = r8.equals(r4)
            java.lang.String r8 = "push message's owner is not white app, send it when screen on"
            r9 = 1
            if (r4 == 0) goto L_0x0106
            boolean r4 = r11.b(r0)
            if (r4 == 0) goto L_0x00bc
            java.lang.String r12 = "msgId duplicate, do not show it"
        L_0x00b7:
            com.huawei.android.pushagent.c.a.e.b(r2, r12)
            goto L_0x0172
        L_0x00bc:
            r11.a((java.lang.String) r0)
            java.lang.String[] r0 = r11.c
            if (r0 == 0) goto L_0x00fd
            int r0 = r0.length
            if (r0 <= 0) goto L_0x00fd
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x00df
            java.lang.String[] r0 = r11.c
            int r4 = r0.length
            r5 = 0
        L_0x00d0:
            if (r5 >= r4) goto L_0x00df
            r10 = r0[r5]
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L_0x00dc
            r7 = 1
            goto L_0x00df
        L_0x00dc:
            int r5 = r5 + 1
            goto L_0x00d0
        L_0x00df:
            if (r7 == 0) goto L_0x00ea
            byte[] r13 = r13.f()
            r11.b(r12, r3, r13)
            goto L_0x0172
        L_0x00ea:
            com.huawei.android.pushagent.c.a.e.a(r2, r8)
            java.util.List r12 = r11.e
            com.huawei.android.pushagent.a.b.a r0 = new com.huawei.android.pushagent.a.b.a
            byte[] r13 = r13.f()
            r0.<init>(r1, r3, r13)
        L_0x00f8:
            r12.add(r0)
            goto L_0x0172
        L_0x00fd:
            byte[] r13 = r13.f()
            r11.b(r12, r3, r13)
            goto L_0x0172
        L_0x0106:
            if (r1 == 0) goto L_0x0153
            boolean r4 = com.huawei.android.pushagent.c.c.d.a((android.content.Context) r12, (java.lang.String) r1)
            if (r4 == 0) goto L_0x0153
            boolean r4 = r11.b(r0)
            if (r4 == 0) goto L_0x0117
            java.lang.String r12 = "msgId duplicate, do not sent it to other apps"
            goto L_0x00b7
        L_0x0117:
            r11.a((java.lang.String) r0)
            java.lang.String[] r0 = r11.c
            if (r0 == 0) goto L_0x014b
            int r4 = r0.length
            if (r4 <= 0) goto L_0x014b
            int r4 = r0.length
            r5 = 0
        L_0x0123:
            if (r5 >= r4) goto L_0x0132
            r10 = r0[r5]
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L_0x012f
            r7 = 1
            goto L_0x0132
        L_0x012f:
            int r5 = r5 + 1
            goto L_0x0123
        L_0x0132:
            if (r7 == 0) goto L_0x013c
            byte[] r13 = r13.f()
            r11.a(r12, r1, r3, r13)
            goto L_0x0172
        L_0x013c:
            com.huawei.android.pushagent.c.a.e.a(r2, r8)
            java.util.List r12 = r11.d
            com.huawei.android.pushagent.a.b.a r0 = new com.huawei.android.pushagent.a.b.a
            byte[] r13 = r13.f()
            r0.<init>(r1, r3, r13)
            goto L_0x00f8
        L_0x014b:
            byte[] r13 = r13.f()
            r11.a(r12, r1, r3, r13)
            goto L_0x0172
        L_0x0153:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "pkgName"
            r12.append(r13)
            r12.append(r1)
            java.lang.String r13 = " is null or not exist in local"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.huawei.android.pushagent.c.a.e.d(r2, r12)
            com.huawei.android.pushagent.a.b.m r6 = new com.huawei.android.pushagent.a.b.m
            r12 = 2
            r6.<init>(r5, r12)
        L_0x0172:
            com.huawei.android.pushagent.b.a.a.a r12 = com.huawei.android.pushagent.b.a.a.e()     // Catch:{ Exception -> 0x017a }
            r12.a((com.huawei.android.pushagent.a.b) r6)     // Catch:{ Exception -> 0x017a }
            goto L_0x0193
        L_0x017a:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "call ChannelMgr.getPushChannel().send cause:"
            r13.append(r0)
            java.lang.String r0 = r12.toString()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            com.huawei.android.pushagent.c.a.e.c(r2, r13, r12)
        L_0x0193:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "rspPushMessage the response msg is :"
            r12.append(r13)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            com.huawei.android.pushagent.c.a.e.b(r2, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.e.d.a(android.content.Context, com.huawei.android.pushagent.a.b.l):void");
    }

    private void a(Context context, o oVar) {
        String str;
        if (oVar == null) {
            str = "responseRegisterToken have a wrong parm";
        } else {
            h hVar = new h(context, "pclient_request_info");
            if (!TextUtils.isEmpty(oVar.e())) {
                hVar.f(oVar.e());
            }
            if (oVar.f() == 1) {
                str = "responseRegisterToken FAILED:" + oVar.f();
            } else {
                String d2 = oVar.d();
                String e2 = oVar.e();
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "pushSrv response register token to " + e2);
                if (TextUtils.isEmpty(e2) || TextUtils.isEmpty(d2)) {
                    str = "pushSrv response registerToken a invalid message ";
                } else {
                    if (e.c()) {
                        e.a(e2);
                    }
                    b.a(context, d2, e2);
                    if (hVar.b().size() == 0) {
                        com.huawei.android.pushagent.c.a.a.a(context, new Intent("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV").setPackage(context.getPackageName()));
                        PushService.a(new Intent("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV"));
                    }
                    a(context, e2, d2);
                    return;
                }
            }
        }
        com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", str);
    }

    private void a(Context context, q qVar) {
        com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "unregister token from pushsrv success");
        if (qVar == null) {
            com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", "responseUnregisterToken have an wrong param");
            return;
        }
        String d2 = qVar.d();
        b.c(context, d2);
        com.huawei.android.pushagent.c.a.f.b(context, d2);
        PushService.a(new Intent("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV"));
    }

    private void a(Context context, String str) {
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "begin to get token from pushSrv, packagename = " + str);
        String a2 = com.huawei.android.pushagent.c.a.a(context);
        new h(context, "pclient_request_info").a(str, "true");
        if (!com.huawei.android.pushagent.b.a.a.e().a()) {
            PushService.a(new Intent("com.huawei.action.CONNECT_PUSHSRV_PUSHSRV").setPackage(context.getPackageName()));
            return;
        }
        try {
            com.huawei.android.pushagent.b.a.a.e().a((com.huawei.android.pushagent.a.b) new n(a2, com.huawei.android.pushagent.c.a.f(context, str)));
        } catch (Exception e2) {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", "call ChannelMgr.getPushChannel().send cause:" + e2.toString(), e2);
        }
        com.huawei.android.pushagent.c.a.a.c(context, new Intent("com.huawei.action.CONNECT_PUSHSRV_POLLINGSRV").setPackage(context.getPackageName()), com.huawei.android.pushagent.b.b.a.a(context).F() * 1000);
    }

    private synchronized void a(Context context, String str, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pushConfig", 4).edit();
        edit.putBoolean("cloudpush_ConnectStatus", bool.booleanValue()).commit();
        edit.putLong(str, System.currentTimeMillis()).commit();
    }

    public static void a(Context context, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                Intent flags = new Intent("com.huawei.android.push.intent.REGISTRATION").setPackage(str).putExtra("device_token", str2.getBytes("UTF-8")).putExtra("belongId", com.huawei.android.pushagent.b.b.a.a(context).b()).setFlags(32);
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "send registerToken to:" + str + " token:" + com.huawei.android.pushagent.c.a.a.e.a(str2));
                context.sendBroadcast(flags);
            } catch (Exception e2) {
                com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", e2.toString(), e2);
            }
        }
    }

    private void a(Context context, String str, byte[] bArr, byte[] bArr2) {
        if (e.c()) {
            e.a(2, 180);
        } else {
            com.huawei.android.pushagent.c.a.a(2, 180);
        }
        Intent intent = new Intent("com.huawei.android.push.intent.RECEIVE");
        intent.setPackage(str).putExtra("msg_data", bArr2).putExtra("device_token", bArr).setFlags(32);
        context.sendBroadcast(intent);
        PushService.a(new Intent("com.huawei.android.push.intent.MSG_BROAD_TO_APP").putExtra("appName", str));
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "broadcast pushDataRspMessage to " + str + " over");
    }

    private static void a(SharedPreferences sharedPreferences, NetworkInfo networkInfo) {
        StringBuilder sb;
        String str;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String str2 = "";
        String string = sharedPreferences.getString("cloudpush_arrayOfNetEventTime", str2);
        if (!TextUtils.isEmpty(string) || string.equals("null")) {
            String[] split = string.split("\\,");
            int length = split.length - 1;
            StringBuffer stringBuffer = new StringBuffer();
            if (length == 16) {
                int i = 0;
                while (i < 15) {
                    StringBuilder sb2 = new StringBuilder();
                    i++;
                    sb2.append(split[i]);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    stringBuffer.append(sb2.toString());
                }
                str2 = stringBuffer.toString();
            } else if (length < 16) {
                str2 = string + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
        }
        String num = Integer.toString(networkInfo.getType());
        if (networkInfo.isConnected() || networkInfo.isConnectedOrConnecting()) {
            sb = new StringBuilder();
            sb.append(num);
            str = "-1-";
        } else {
            sb = new StringBuilder();
            sb.append(num);
            str = "-0-";
        }
        sb.append(str);
        sb.append(Long.toString(System.currentTimeMillis()));
        edit.putString("cloudpush_arrayOfNetEventTime", str2 + sb.toString()).commit();
    }

    private void a(String str) {
        synchronized (b) {
            if (a.size() >= 10) {
                a.remove(0);
            }
            a.add(str);
        }
    }

    private void b(Context context, Intent intent) {
        byte b2;
        StringBuilder sb;
        com.huawei.android.pushagent.a.a aVar;
        com.huawei.android.pushagent.a.b.a.b bVar = (com.huawei.android.pushagent.a.b.a.b) intent.getSerializableExtra("push_msg");
        if (bVar == null) {
            com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "msg is null");
            return;
        }
        byte a2 = bVar.a();
        if (a2 != -96) {
            if (a2 == -45) {
                com.huawei.android.pushagent.a.b.d dVar = (com.huawei.android.pushagent.a.b.d) bVar;
                if (dVar.d() == 0) {
                    com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "PushCommandProcessor device register success");
                    aVar = new com.huawei.android.pushagent.a.a("cloudpush_arrayOfNetEventTime", String.class, "");
                } else {
                    sb = new StringBuilder();
                    sb.append("PushCommandProcessor device register fail:");
                    b2 = dVar.d();
                    sb.append(b2);
                    com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", sb.toString());
                    return;
                }
            } else if (a2 == -41) {
                a(context, (q) bVar);
                return;
            } else if (a2 == -37) {
                return;
            } else {
                if (a2 == -35) {
                    com.huawei.android.pushagent.c.a.a(context, 10000);
                    a(context, (o) bVar);
                    return;
                } else if (a2 != -33) {
                    if (a2 != -91) {
                        if (a2 == -90) {
                            try {
                                com.huawei.android.pushagent.b.a.a.e().a((com.huawei.android.pushagent.a.b) new com.huawei.android.pushagent.a.b.b((byte) -89));
                            } catch (Exception e2) {
                                com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", "send serverToAgentMsgRsp error:" + e2.getMessage(), e2);
                            }
                        } else {
                            return;
                        }
                    }
                    a.a().a(context, (com.huawei.android.pushagent.a.b.b) bVar);
                    return;
                } else {
                    i iVar = (i) bVar;
                    if (iVar.d() == 0) {
                        com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "PushCommandProcessor device register success");
                        aVar = new com.huawei.android.pushagent.a.a("cloudpush_arrayOfNetEventTime", String.class, "");
                    } else {
                        sb = new StringBuilder();
                        sb.append("PushCommandProcessor device register fail:");
                        b2 = iVar.d();
                        sb.append(b2);
                        com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", sb.toString());
                        return;
                    }
                }
            }
            c.a(context, aVar);
            com.huawei.android.pushagent.b.a.a.b(context).a(false);
            com.huawei.android.pushagent.b.a.a.b(context).g();
            a(context);
            return;
        }
        com.huawei.android.pushagent.c.a.a(context, 10000);
        a(context, (l) bVar);
    }

    private void b(Context context, String str) {
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", str + " will be unregister.");
        String d2 = b.d(context, str);
        if (!TextUtils.isEmpty(d2)) {
            try {
                com.huawei.android.pushagent.b.a.a.e().a((com.huawei.android.pushagent.a.b) new p(d2));
            } catch (Exception e2) {
                com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", "call ChannelMgr.getPushChannel().send cause:" + e2.toString(), e2);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", r2 + " depose failed, maybe old selfShow message");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Context r7, byte[] r8, byte[] r9) {
        /*
            r6 = this;
            java.lang.String r0 = "app"
            java.lang.String r1 = "PushLogAC2705"
            java.lang.String r2 = "enter deposeMessageBySelf"
            com.huawei.android.pushagent.c.a.e.b(r1, r2)     // Catch:{ Exception -> 0x0090 }
            if (r9 != 0) goto L_0x0011
            java.lang.String r7 = "enter deposeMessageBySelf msg is null!"
            com.huawei.android.pushagent.c.a.e.d(r1, r7)     // Catch:{ Exception -> 0x0090 }
            return
        L_0x0011:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0090 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r9, r3)     // Catch:{ Exception -> 0x0090 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0090 }
            if (r3 == 0) goto L_0x0024
            java.lang.String r7 = "enter deposeMessageBySelf jsonStr is null!"
            com.huawei.android.pushagent.c.a.e.d(r1, r7)     // Catch:{ Exception -> 0x0090 }
            return
        L_0x0024:
            boolean r3 = com.huawei.android.pushagent.c.c.e.c()     // Catch:{ Exception -> 0x0090 }
            r4 = 180(0xb4, float:2.52E-43)
            r5 = 2
            if (r3 == 0) goto L_0x0031
            com.huawei.android.pushagent.c.c.e.a(r5, r4)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0034
        L_0x0031:
            com.huawei.android.pushagent.c.a.a((int) r5, (int) r4)     // Catch:{ Exception -> 0x0090 }
        L_0x0034:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0073 }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x0073 }
            boolean r4 = r3.has(r0)     // Catch:{ JSONException -> 0x0073 }
            if (r4 == 0) goto L_0x006d
            java.lang.String r4 = "jsonStr has a mapping for app"
            com.huawei.android.pushagent.c.a.e.a(r1, r4)     // Catch:{ JSONException -> 0x0073 }
            int r0 = r3.getInt(r0)     // Catch:{ Exception -> 0x0064 }
            r3 = 1
            if (r3 != r0) goto L_0x004f
            com.huawei.android.pushagent.b.e.c.a(r7, r2)     // Catch:{ Exception -> 0x0064 }
            return
        L_0x004f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064 }
            r3.<init>()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r4 = "the app value is not 1! it is "
            r3.append(r4)     // Catch:{ Exception -> 0x0064 }
            r3.append(r0)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0064 }
            com.huawei.android.pushagent.c.a.e.b(r1, r0)     // Catch:{ Exception -> 0x0064 }
            goto L_0x0087
        L_0x0064:
            r0 = move-exception
            java.lang.String r3 = r0.toString()     // Catch:{ JSONException -> 0x0073 }
            com.huawei.android.pushagent.c.a.e.c(r1, r3, r0)     // Catch:{ JSONException -> 0x0073 }
            goto L_0x0087
        L_0x006d:
            java.lang.String r0 = "jsonStr does not  have a mapping for app"
            com.huawei.android.pushagent.c.a.e.a(r1, r0)     // Catch:{ JSONException -> 0x0073 }
            goto L_0x0087
        L_0x0073:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090 }
            r0.<init>()     // Catch:{ Exception -> 0x0090 }
            r0.append(r2)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r2 = " depose failed, maybe old selfShow message"
            r0.append(r2)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0090 }
            com.huawei.android.pushagent.c.a.e.a(r1, r0)     // Catch:{ Exception -> 0x0090 }
        L_0x0087:
            java.lang.String r0 = "send selfShow message"
            com.huawei.android.pushagent.c.a.e.a(r1, r0)     // Catch:{ Exception -> 0x0090 }
            r6.a((android.content.Context) r7, (byte[]) r8, (byte[]) r9)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0098
        L_0x0090:
            r7 = move-exception
            java.lang.String r8 = r7.toString()
            com.huawei.android.pushagent.c.a.e.c(r1, r8, r7)
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.e.d.b(android.content.Context, byte[], byte[]):void");
    }

    private boolean b(String str) {
        boolean contains;
        synchronized (b) {
            contains = a.contains(str);
        }
        return contains;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006f A[Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0075 A[Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0078 A[Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a3 A[Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }, LOOP:0: B:23:0x00a0->B:25:0x00a3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e7 A[Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.android.pushagent.a.b.h c(android.content.Context r18, java.lang.String r19) {
        /*
            r17 = this;
            java.lang.String r0 = "PushLogAC2705"
            r1 = 0
            java.lang.String r2 = "pushConfig"
            r3 = r18
            android.content.SharedPreferences r2 = r3.getSharedPreferences(r2, r1)
            java.lang.String r4 = com.huawei.android.pushagent.c.a.g(r18)
            int r8 = java.lang.Integer.parseInt(r4)
            r4 = 0
            java.lang.String r6 = "cloudpush_off"
            long r9 = r2.getLong(r6, r4)
            java.lang.String r6 = "cloudpush_on"
            long r11 = r2.getLong(r6, r4)
            long r13 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = "cloudpush_arrayOfNetEventTime"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.getString(r4, r5)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.lang.String r5 = "null"
            java.lang.String r6 = "\\,"
            if (r4 == 0) goto L_0x0040
            boolean r4 = r2.equals(r5)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            if (r4 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r4 = 0
            goto L_0x0045
        L_0x0040:
            java.lang.String[] r4 = r2.split(r6)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            int r4 = r4.length     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
        L_0x0045:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r7.<init>()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.lang.String r15 = "mDeviceTokenMgr.tokenMap.size:"
            r7.append(r15)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            com.huawei.android.pushagent.b.e.b r15 = com.huawei.android.pushagent.b.e.b.a(r18)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.util.HashMap r15 = r15.a     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            int r15 = r15.size()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r7.append(r15)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.lang.String r7 = r7.toString()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            com.huawei.android.pushagent.c.a.e.a(r0, r7)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            com.huawei.android.pushagent.b.e.b r7 = com.huawei.android.pushagent.b.e.b.a(r18)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.util.HashMap r7 = r7.a     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            int r7 = r7.size()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            if (r7 != 0) goto L_0x0071
            int r4 = r4 + 1
        L_0x0071:
            r7 = 16
            if (r4 <= r7) goto L_0x0078
            r15 = 16
            goto L_0x0079
        L_0x0078:
            r15 = r4
        L_0x0079:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r4.<init>()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.lang.String r7 = "netEventAccount is: "
            r4.append(r7)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r4.append(r15)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.lang.String r4 = r4.toString()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            com.huawei.android.pushagent.c.a.e.a(r0, r4)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            com.huawei.android.pushagent.a.b.g[] r4 = new com.huawei.android.pushagent.a.b.g[r15]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            if (r7 == 0) goto L_0x009b
            boolean r5 = r2.equals(r5)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            if (r5 == 0) goto L_0x00db
        L_0x009b:
            java.lang.String[] r2 = r2.split(r6)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r5 = 0
        L_0x00a0:
            int r6 = r2.length     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            if (r5 >= r6) goto L_0x00db
            r6 = r2[r5]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.lang.String r7 = "\\-"
            java.lang.String[] r6 = r6.split(r7)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            com.huawei.android.pushagent.a.b.g r7 = new com.huawei.android.pushagent.a.b.g     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r7.<init>()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r4[r5] = r7     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r7 = r4[r5]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r16 = r6[r1]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            int r1 = java.lang.Integer.parseInt(r16)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            byte r1 = (byte) r1     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r7.a((byte) r1)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r1 = r4[r5]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r7 = 1
            r7 = r6[r7]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            byte r7 = (byte) r7     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r1.b(r7)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r1 = r4[r5]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r7 = 2
            r6 = r6[r7]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r1.a((long) r6)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            int r5 = r5 + 1
            r1 = 0
            goto L_0x00a0
        L_0x00db:
            com.huawei.android.pushagent.b.e.b r1 = com.huawei.android.pushagent.b.e.b.a(r18)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.util.HashMap r1 = r1.a     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            int r1 = r1.size()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            if (r1 != 0) goto L_0x011d
            int r1 = r15 + -1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r2.<init>()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.lang.String r5 = "syncPos is: "
            r2.append(r5)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r2.append(r1)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            com.huawei.android.pushagent.c.a.e.a(r0, r2)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r0 = r4[r1]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            if (r0 != 0) goto L_0x0108
            com.huawei.android.pushagent.a.b.g r0 = new com.huawei.android.pushagent.a.b.g     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r4[r1] = r0     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
        L_0x0108:
            r0 = r4[r1]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r2 = -1
            r0.a((byte) r2)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r0 = r4[r1]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r2 = 0
            r0.b(r2)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r0 = r4[r1]     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
            r0.a((long) r1)     // Catch:{ NumberFormatException -> 0x013e, Exception -> 0x012d }
        L_0x011d:
            com.huawei.android.pushagent.a.b.h r0 = new com.huawei.android.pushagent.a.b.h
            int r1 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r18)
            byte r7 = (byte) r1
            r5 = r0
            r6 = r19
            r16 = r4
            r5.<init>(r6, r7, r8, r9, r11, r13, r15, r16)
            return r0
        L_0x012d:
            com.huawei.android.pushagent.a.b.h r0 = new com.huawei.android.pushagent.a.b.h
            int r1 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r18)
            byte r7 = (byte) r1
            r15 = 0
            r16 = 0
            r5 = r0
            r6 = r19
            r5.<init>(r6, r7, r8, r9, r11, r13, r15, r16)
            return r0
        L_0x013e:
            com.huawei.android.pushagent.a.b.h r0 = new com.huawei.android.pushagent.a.b.h
            int r1 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r18)
            byte r7 = (byte) r1
            r15 = 0
            r16 = 0
            r5 = r0
            r6 = r19
            r5.<init>(r6, r7, r8, r9, r11, r13, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.e.d.c(android.content.Context, java.lang.String):com.huawei.android.pushagent.a.b.h");
    }

    private void c(Context context, Intent intent) {
        com.huawei.android.pushagent.c.a.a.a(context, new Intent("com.huawei.intent.action.PUSH_OFF").setPackage(context.getPackageName()).putExtra("Remote_Package_Name", context.getPackageName()));
        String stringExtra = intent.getStringExtra("pkg_name");
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "PushCommandProcessor: get the packageName: " + stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", "PushCommandProcessor: get the wrong package name from the Client!");
        } else if (!com.huawei.android.pushagent.c.c.d.a(context, stringExtra)) {
            com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", "rec register toke request , but the packageName:" + stringExtra + " was not install !!");
        } else {
            h hVar = new h(context, "pclient_unRegist_info_v2");
            Iterator it = hVar.b().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (stringExtra.equals((String) entry.getValue())) {
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", stringExtra + " need to register again");
                    hVar.f((String) entry.getKey());
                    break;
                }
            }
            if (b.a(context, stringExtra)) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "PushCommandProcessor: this package:" + stringExtra + " have already registered ");
                a(context, stringExtra, b.d(context, stringExtra));
                return;
            }
            a(context, stringExtra);
        }
    }

    private void d(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("pkg_name");
        if (TextUtils.isEmpty(stringExtra)) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "packagename is null, cannot deregister");
            return;
        }
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "responseClientUnRegistration: packagename = " + stringExtra);
        new h(context, "pclient_request_info").f(stringExtra);
        String stringExtra2 = intent.getStringExtra("device_token");
        if (intent.getBooleanExtra("isTokenEncrypt", false)) {
            stringExtra2 = f.b(context, stringExtra2);
        }
        if (TextUtils.isEmpty(stringExtra2)) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "token is null, cannot deregister");
            return;
        }
        String d2 = b.d(context, stringExtra);
        if (!stringExtra2.equals(d2)) {
            com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "token not match, cannot deregister. token is " + com.huawei.android.pushagent.c.a.a.e.a(stringExtra2) + ", local token is " + com.huawei.android.pushagent.c.a.a.e.a(d2));
            return;
        }
        if (e.c()) {
            e.b(stringExtra);
        }
        com.huawei.android.pushagent.c.a.f.c(context, b.d(context, stringExtra), stringExtra);
        b(context, stringExtra);
        b.b(context, stringExtra);
    }

    private void e(Context context, Intent intent) {
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : "";
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "responseAddPackage pkgName= " + schemeSpecificPart);
        if (!TextUtils.isEmpty(schemeSpecificPart)) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "responseAddPackage,isRegistered:" + b.a(context, schemeSpecificPart));
            if (!b.a(context, schemeSpecificPart)) {
                return;
            }
            if (com.huawei.android.pushagent.c.a.c(context, schemeSpecificPart)) {
                a(context, schemeSpecificPart);
                return;
            }
            String d2 = b.d(context, schemeSpecificPart);
            Intent intent2 = new Intent();
            intent2.putExtra("pkg_name", schemeSpecificPart);
            intent2.putExtra("device_token", d2);
            d(context, intent);
        }
    }

    private void f(Context context, Intent intent) {
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : "";
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.DATA_REMOVED", true);
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "ACTION_PACKAGE_REMOVED : isRemoveData=" + booleanExtra + " remove pkgName:" + schemeSpecificPart);
        if (booleanExtra) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "responseRemovePackage pkgName= " + schemeSpecificPart);
            if (com.huawei.android.pushagent.c.a.c(context, schemeSpecificPart)) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "received pkgRemove action, but pkg:" + schemeSpecificPart + " is exist and have " + "com.huawei.android.push.intent.REGISTRATION" + ", register again");
                if (b.a(context, schemeSpecificPart)) {
                    a(context, schemeSpecificPart);
                    return;
                }
                return;
            }
            String d2 = b.d(context, schemeSpecificPart);
            Intent intent2 = new Intent();
            intent2.putExtra("pkg_name", schemeSpecificPart);
            intent2.putExtra("device_token", d2);
            d(context, intent2);
        }
    }

    public void a(Context context, Intent intent) {
        String str;
        long currentTimeMillis;
        String str2;
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "enter PushCommandProcessor:onReceive(intent:" + intent + " context:" + context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pushConfig", 4);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    currentTimeMillis = System.currentTimeMillis();
                    str2 = "cloudpush_net_on";
                } else {
                    if (!networkInfo.isConnectedOrConnecting()) {
                        currentTimeMillis = System.currentTimeMillis();
                        str2 = "cloudpush_net_off";
                    }
                    a(sharedPreferences, networkInfo);
                    return;
                }
                edit.putLong(str2, currentTimeMillis).commit();
                a(sharedPreferences, networkInfo);
                return;
            }
            str = "networkinfo is null";
        } else if ("com.huawei.android.push.intent.CONNECTED".equals(action)) {
            a(context, "cloudpush_on", (Boolean) true);
            try {
                com.huawei.android.pushagent.b.a.a.e().a((com.huawei.android.pushagent.a.b) c(context, com.huawei.android.pushagent.c.a.a(context)));
                return;
            } catch (Exception e2) {
                com.huawei.android.pushagent.c.a.e.c("PushLogAC2705", "call ChannelMgr.getPushChannel().send cause:" + e2.toString(), e2);
                return;
            }
        } else if ("com.huawei.android.push.intent.CHANNEL_CLOSED".equals(action)) {
            a(context, "cloudpush_off", (Boolean) false);
            return;
        } else if ("com.huawei.android.push.intent.MSG_RECEIVED".equals(action)) {
            b(context, intent);
            return;
        } else if ("com.huawei.android.push.intent.REGISTER".equals(action)) {
            c(context, intent);
            return;
        } else if ("com.huawei.android.push.intent.DEREGISTER".equals(action)) {
            d(context, intent);
            return;
        } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            e(context, intent);
            return;
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            f(context, intent);
            return;
        } else if ("android.ctrlsocket.all.allowed".equals(action)) {
            this.c = new String[0];
            com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "all packages allow to use push, send cached messages to apps");
            for (com.huawei.android.pushagent.a.b.a aVar : this.d) {
                if (!(aVar.b() == null || aVar.c() == null)) {
                    a(context, aVar.a(), aVar.b(), aVar.c());
                }
            }
            this.d.clear();
            for (com.huawei.android.pushagent.a.b.a aVar2 : this.e) {
                if (!(aVar2.b() == null || aVar2.c() == null)) {
                    b(context, aVar2.b(), aVar2.c());
                }
            }
            this.e.clear();
            return;
        } else if (!"android.scroff.ctrlsocket.status".equals(action)) {
            return;
        } else {
            if (intent.getBooleanExtra("ctrl_socket_status", false)) {
                String stringExtra = intent.getStringExtra("ctrl_socket_list");
                com.huawei.android.pushagent.c.a.e.b("PushLogAC2705", "only whitepackages can use push:" + stringExtra);
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.c = stringExtra.split("\t");
                    return;
                }
                return;
            }
            this.c = new String[0];
            str = "not support push in sleep model";
        }
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        r2 = r6.getJSONObject("msgContent");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r10, byte[] r11, byte[] r12) {
        /*
            r9 = this;
            java.lang.String r0 = "com.huawei.android.push.intent.AD_INFO"
            java.lang.String r1 = "dispPkgName"
            java.lang.String r2 = "msgContent"
            java.lang.String r3 = "deposeSelfShowMsg error:"
            java.lang.String r4 = "PushLogAC2705"
            java.lang.String r5 = new java.lang.String     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r12, r6)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r6.<init>(r5)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            boolean r5 = r6.has(r2)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            if (r5 == 0) goto L_0x002d
            org.json.JSONObject r2 = r6.getJSONObject(r2)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            if (r2 == 0) goto L_0x002d
            boolean r5 = r2.has(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            if (r5 == 0) goto L_0x002d
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            goto L_0x002f
        L_0x002d:
            java.lang.String r1 = ""
        L_0x002f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r2.<init>()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r5 = "dispkgName is "
            r2.append(r5)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r2.append(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            com.huawei.android.pushagent.c.a.e.a(r4, r2)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            if (r2 == 0) goto L_0x004b
            java.lang.String r1 = "com.huawei.android.pushagent"
        L_0x004b:
            java.lang.String r2 = r10.getPackageName()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r5 = r1.trim()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r5 = "selfshow_token"
            java.lang.String r6 = "selfshow_info"
            java.lang.String r7 = "com.huawei.intent.action.PUSH"
            java.lang.String r8 = " to depose selfshow msg"
            if (r2 == 0) goto L_0x0093
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.<init>()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r1 = "need current package "
            r0.append(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r1 = r10.getPackageName()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.append(r8)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            com.huawei.android.pushagent.c.a.e.a(r4, r0)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.putExtra(r6, r12)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.putExtra(r5, r11)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r11 = r10.getPackageName()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.setPackage(r11)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
        L_0x008e:
            r10.sendBroadcast(r0)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            goto L_0x016a
        L_0x0093:
            java.util.ArrayList r2 = com.huawei.android.pushagent.c.a.a((android.content.Context) r10, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            boolean r2 = r2.contains(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            if (r2 == 0) goto L_0x00cb
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r2.<init>()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r5 = "need old package "
            r2.append(r5)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r2.append(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r2.append(r8)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            com.huawei.android.pushagent.c.a.e.a(r4, r2)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r0 = "ad_event_info"
            r2.putExtra(r0, r12)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r12 = "ad_event_token"
            r2.putExtra(r12, r11)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r2.setPackage(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r10.sendBroadcast(r2)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            goto L_0x016a
        L_0x00cb:
            boolean r0 = com.huawei.android.pushagent.c.a.d(r10, r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            if (r0 != 0) goto L_0x010b
            boolean r0 = com.huawei.android.pushagent.c.a.c(r10, r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            if (r0 == 0) goto L_0x00d8
            goto L_0x010b
        L_0x00d8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.<init>()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r2 = "not find dispkgName "
            r0.append(r2)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r1 = " or is not pushclient"
            r0.append(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            com.huawei.android.pushagent.c.a.e.a(r4, r0)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.putExtra(r6, r12)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.putExtra(r5, r11)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r11 = "selfshow_event_id"
            java.lang.String r12 = "5"
            r0.putExtra(r11, r12)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r11 = r10.getPackageName()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.setPackage(r11)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            goto L_0x008e
        L_0x010b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.<init>()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r2 = "try to send selfshow msg to push client ,package "
            r0.append(r2)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.append(r8)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            com.huawei.android.pushagent.c.a.e.a(r4, r0)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.putExtra(r6, r12)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.putExtra(r5, r11)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r11 = 32
            r0.setFlags(r11)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            r0.setPackage(r1)     // Catch:{ JSONException -> 0x0153, IOException -> 0x0145, Exception -> 0x0137 }
            goto L_0x008e
        L_0x0137:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r3)
            java.lang.String r10 = r10.toString()
            goto L_0x0160
        L_0x0145:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r3)
            java.lang.String r10 = r10.toString()
            goto L_0x0160
        L_0x0153:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r3)
            java.lang.String r10 = r10.toString()
        L_0x0160:
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            com.huawei.android.pushagent.c.a.e.d(r4, r10)
        L_0x016a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.e.d.a(android.content.Context, byte[], byte[]):void");
    }
}
