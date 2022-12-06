package com.huawei.android.pushagent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.c.b;

public class PushEventReceiver extends BroadcastReceiver {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.IllegalAccessException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.IllegalArgumentException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.reflect.InvocationTargetException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.NoSuchMethodException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r8, android.content.Intent r9) {
        /*
            java.lang.String r0 = "PushLogAC2705"
            java.lang.String r1 = "com.huawei.android.pushagent"
            java.lang.String r2 = r8.getPackageName()     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            if (r1 != 0) goto L_0x006a
            java.lang.String r1 = "run invokePluginReport"
            com.huawei.android.pushagent.c.a.e.a(r0, r1)     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            java.lang.String r1 = "com.huawei.android.pushagent.plugin.tools.PushPluginsBroadcastMgr"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            java.lang.String r2 = "handleEvent"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            java.lang.Class<android.content.Intent> r5 = android.content.Intent.class
            r7 = 1
            r4[r7] = r5     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            java.lang.reflect.Method r2 = r1.getMethod(r2, r4)     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            r3[r6] = r8     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            r3[r7] = r9     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            r2.invoke(r1, r3)     // Catch:{ ClassNotFoundException -> 0x0051, NoSuchMethodException -> 0x0048, IllegalAccessException -> 0x0042, IllegalArgumentException -> 0x003c, InvocationTargetException -> 0x0036 }
            goto L_0x006a
        L_0x0036:
            r8 = move-exception
            java.lang.String r9 = r8.toString()
            goto L_0x004d
        L_0x003c:
            r8 = move-exception
            java.lang.String r9 = r8.toString()
            goto L_0x004d
        L_0x0042:
            r8 = move-exception
            java.lang.String r9 = r8.toString()
            goto L_0x004d
        L_0x0048:
            r8 = move-exception
            java.lang.String r9 = r8.toString()
        L_0x004d:
            com.huawei.android.pushagent.c.a.e.c(r0, r9, r8)
            goto L_0x006a
        L_0x0051:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "ClassNotFoundException:"
            r9.append(r1)
            java.lang.String r8 = r8.toString()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.huawei.android.pushagent.c.a.e.a(r0, r8)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.PushEventReceiver.a(android.content.Context, android.content.Intent):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.IllegalAccessException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.IllegalArgumentException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.reflect.InvocationTargetException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.InstantiationException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.NoSuchMethodException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r9, android.content.Intent r10) {
        /*
            com.huawei.android.pushagent.c.a.h r0 = new com.huawei.android.pushagent.c.a.h
            java.lang.String r1 = "push_switch"
            r0.<init>(r9, r1)
            java.lang.String r1 = "notify_msg_enable"
            boolean r0 = r0.a((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "closePush_Notify:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PushLogAC2705"
            com.huawei.android.pushagent.c.a.e.a(r2, r1)
            if (r0 == 0) goto L_0x0026
            return
        L_0x0026:
            java.lang.String r0 = "run push selfshow"
            com.huawei.android.pushagent.c.a.e.b(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.String r0 = "com.huawei.android.pushselfshow.SelfShowReceiver"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            r1 = 0
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.reflect.Constructor r3 = r0.getConstructor(r3)     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.String r4 = "onReceive"
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r1] = r7     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.Class<android.content.Intent> r7 = android.content.Intent.class
            r8 = 1
            r6[r8] = r7     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r6)     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            r4[r1] = r9     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            r4[r8] = r10     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            r0.invoke(r3, r4)     // Catch:{ ClassNotFoundException -> 0x0064, NoSuchMethodException -> 0x0062, IllegalAccessException -> 0x0060, IllegalArgumentException -> 0x005e, InvocationTargetException -> 0x005c, InstantiationException -> 0x005a }
            goto L_0x009a
        L_0x005a:
            r9 = move-exception
            goto L_0x0066
        L_0x005c:
            r9 = move-exception
            goto L_0x006b
        L_0x005e:
            r9 = move-exception
            goto L_0x0070
        L_0x0060:
            r9 = move-exception
            goto L_0x0075
        L_0x0062:
            r9 = move-exception
            goto L_0x007a
        L_0x0064:
            r9 = move-exception
            goto L_0x0082
        L_0x0066:
            java.lang.String r10 = r9.toString()
            goto L_0x007e
        L_0x006b:
            java.lang.String r10 = r9.toString()
            goto L_0x007e
        L_0x0070:
            java.lang.String r10 = r9.toString()
            goto L_0x007e
        L_0x0075:
            java.lang.String r10 = r9.toString()
            goto L_0x007e
        L_0x007a:
            java.lang.String r10 = r9.toString()
        L_0x007e:
            com.huawei.android.pushagent.c.a.e.c(r2, r10, r9)
            goto L_0x009a
        L_0x0082:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "ClassNotFoundException:"
            r10.append(r0)
            java.lang.String r9 = r9.toString()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.huawei.android.pushagent.c.a.e.b(r2, r9)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.PushEventReceiver.b(android.content.Context, android.content.Intent):void");
    }

    private static void c(Context context, Intent intent) {
        try {
            e.a("PushLogAC2705", "run PushProxy.handleEvent ");
            b.a(context, intent);
        } catch (Exception e) {
            e.c("PushLogAC2705", e.toString(), e);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            e.a("PushLogAC2705", "context== null or intent == null");
            return;
        }
        e.a(context);
        String action = intent.getAction();
        e.b("PushLogAC2705", "action is " + action);
        if ((!"com.huawei.intent.action.PUSH".equals(action) || !intent.hasExtra("selfshow_info")) && !"android.intent.action.PACKAGE_ADDED".equals(action)) {
            if (!"com.huawei.android.push.PLUGIN".equals(action)) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    c(context, intent);
                }
            }
            a(context, intent);
            return;
        }
        b(context, intent);
        if (!"android.intent.action.PACKAGE_ADDED".equals(action)) {
            return;
        }
        c(context, intent);
    }
}
