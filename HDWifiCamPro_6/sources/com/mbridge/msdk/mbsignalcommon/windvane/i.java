package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.mbsignalcommon.c.a;
import java.util.regex.Pattern;

/* compiled from: WindVaneSignalCommunication */
public final class i implements Handler.Callback, c {
    protected Pattern a;
    protected String b;
    protected final int c = 1;
    protected Context d;
    protected WindVaneWebView e;
    protected Handler f;

    public i(Context context) {
        this.d = context;
        this.f = new Handler(Looper.getMainLooper(), this);
    }

    public final void a(WindVaneWebView windVaneWebView) {
        this.e = windVaneWebView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 2
            r1 = 0
            r2 = 1
            if (r8 != 0) goto L_0x000d
            goto L_0x006c
        L_0x000d:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r3 = r7.e
            com.mbridge.msdk.mbsignalcommon.windvane.a r3 = com.mbridge.msdk.mbsignalcommon.mraid.c.a(r3, r8)
            if (r3 == 0) goto L_0x001a
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r7.e
            r3.a = r8
            goto L_0x006d
        L_0x001a:
            java.util.regex.Pattern r3 = r7.a
            java.util.regex.Matcher r8 = r3.matcher(r8)
            boolean r3 = r8.matches()
            if (r3 == 0) goto L_0x006c
            com.mbridge.msdk.mbsignalcommon.windvane.a r3 = new com.mbridge.msdk.mbsignalcommon.windvane.a
            r3.<init>()
            int r4 = r8.groupCount()
            r5 = 5
            if (r4 < r5) goto L_0x0038
            java.lang.String r5 = r8.group(r5)
            r3.f = r5
        L_0x0038:
            r5 = 3
            if (r4 < r5) goto L_0x006c
            java.lang.String r4 = r8.group(r2)
            r3.d = r4
            java.lang.String r4 = r8.group(r0)
            r3.g = r4
            java.lang.String r8 = r8.group(r5)
            r3.e = r8
            java.util.HashMap<java.lang.String, java.lang.String> r8 = com.mbridge.msdk.mbsignalcommon.base.e.k
            if (r8 == 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.String> r8 = com.mbridge.msdk.mbsignalcommon.base.e.k
            java.lang.String r4 = r3.e
            boolean r8 = r8.containsKey(r4)
            if (r8 == 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.String> r8 = com.mbridge.msdk.mbsignalcommon.base.e.k
            java.lang.String r4 = r3.e
            java.lang.Object r8 = r8.get(r4)
            java.lang.String r8 = (java.lang.String) r8
            r3.e = r8
        L_0x0067:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r7.e
            r3.a = r8
            goto L_0x006d
        L_0x006c:
            r3 = r1
        L_0x006d:
            if (r3 != 0) goto L_0x0070
            return
        L_0x0070:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r3.a
            if (r8 != 0) goto L_0x0075
            goto L_0x007d
        L_0x0075:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r3.a
            java.lang.String r1 = r3.d
            java.lang.Object r1 = r8.getJsObject(r1)
        L_0x007d:
            if (r1 != 0) goto L_0x0080
            goto L_0x00c9
        L_0x0080:
            android.content.Context r8 = r7.d     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            java.lang.Class r4 = r1.getClass()     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            java.lang.String r4 = r4.getName()     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            com.mbridge.msdk.mbsignalcommon.c.a$c r8 = com.mbridge.msdk.mbsignalcommon.c.a.a(r8, r4)     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            java.lang.String r4 = r3.e     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            r5 = 0
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r0[r5] = r6     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r0[r2] = r5     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            com.mbridge.msdk.mbsignalcommon.c.a$d r8 = r8.a(r4, r0)     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            r8.a()     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            if (r1 == 0) goto L_0x00c9
            boolean r0 = r1 instanceof com.mbridge.msdk.mbsignalcommon.windvane.h     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            if (r0 == 0) goto L_0x00c9
            r3.b = r1     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            r3.c = r8     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            r3.b = r1     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            android.os.Message r8 = android.os.Message.obtain()     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            r8.what = r2     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            r8.obj = r3     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            android.os.Handler r0 = r7.f     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            r0.sendMessage(r8)     // Catch:{ a -> 0x00c5, Exception -> 0x00c0 }
            goto L_0x00c9
        L_0x00c0:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00c9
        L_0x00c5:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.windvane.i.b(java.lang.String):void");
    }

    public final boolean handleMessage(Message message) {
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
            if (message.what != 1) {
                return false;
            }
            Object obj = aVar.b;
            a.d dVar = aVar.c;
            Object[] objArr = new Object[2];
            objArr[0] = aVar;
            objArr[1] = TextUtils.isEmpty(aVar.f) ? "{}" : aVar.f;
            dVar.a(obj, objArr);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean a(String str) {
        if (!j.a(str)) {
            return false;
        }
        this.a = j.b(str);
        this.b = str;
        return true;
    }
}
