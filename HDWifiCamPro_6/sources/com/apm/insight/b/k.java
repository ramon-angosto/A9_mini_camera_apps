package com.apm.insight.b;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
    private static MessageQueue a;
    private static Field b;
    private static Field c;

    protected static Message a(Message message) {
        Field field = c;
        if (field == null) {
            try {
                c = Class.forName("android.os.Message").getDeclaredField("next");
                c.setAccessible(true);
                return (Message) c.get(message);
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                return (Message) field.get(message);
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public static Message a(MessageQueue messageQueue) {
        Field field = b;
        if (field == null) {
            try {
                b = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                b.setAccessible(true);
                return (Message) b.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                return (Message) field.get(messageQueue);
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public static MessageQueue a() {
        MessageQueue queue;
        if (a == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                queue = Looper.myQueue();
            } else if (Build.VERSION.SDK_INT >= 23) {
                queue = mainLooper.getQueue();
            } else {
                try {
                    Field declaredField = mainLooper.getClass().getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    a = (MessageQueue) declaredField.get(mainLooper);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            a = queue;
        }
        return a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        return r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray a(int r7, long r8) {
        /*
            android.os.MessageQueue r0 = a()
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            monitor-enter(r0)     // Catch:{ all -> 0x0035 }
            android.os.Message r2 = a((android.os.MessageQueue) r0)     // Catch:{ all -> 0x0032 }
            if (r2 != 0) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r1
        L_0x0015:
            r3 = 0
            r4 = r3
        L_0x0017:
            if (r2 == 0) goto L_0x0030
            if (r3 >= r7) goto L_0x0030
            int r3 = r3 + 1
            int r4 = r4 + 1
            org.json.JSONObject r5 = a((android.os.Message) r2, (long) r8)     // Catch:{ all -> 0x0032 }
            java.lang.String r6 = "id"
            r5.put(r6, r4)     // Catch:{ JSONException -> 0x0028 }
        L_0x0028:
            r1.put(r5)     // Catch:{ all -> 0x0032 }
            android.os.Message r2 = a((android.os.Message) r2)     // Catch:{ all -> 0x0032 }
            goto L_0x0017
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r1
        L_0x0032:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r7     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r7 = move-exception
            com.apm.insight.c r8 = com.apm.insight.b.a()
            java.lang.String r9 = "NPTH_CATCH"
            r8.a((java.lang.String) r9, (java.lang.Throwable) r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.k.a(int, long):org.json.JSONArray");
    }

    private static JSONObject a(Message message, long j) {
        JSONObject jSONObject = new JSONObject();
        if (message == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("when", message.getWhen() - j);
            if (message.getCallback() != null) {
                jSONObject.put("callback", String.valueOf(message.getCallback()));
            }
            jSONObject.put("what", message.what);
            if (message.getTarget() != null) {
                jSONObject.put("target", String.valueOf(message.getTarget()));
            } else {
                jSONObject.put("barrier", message.arg1);
            }
            jSONObject.put("arg1", message.arg1);
            jSONObject.put("arg2", message.arg2);
            if (message.obj != null) {
                jSONObject.put("obj", message.obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
