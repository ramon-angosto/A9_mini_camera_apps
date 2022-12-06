package com.huawei.android.pushagent.b.a.a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.c;
import com.huawei.android.pushagent.a.d;
import com.huawei.android.pushagent.b.a.b.b;
import com.huawei.android.pushagent.c.a.e;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class c extends Thread {
    protected d a = null;
    protected Context b = null;
    protected a c = null;

    /* renamed from: com.huawei.android.pushagent.b.a.a.c$1  reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[b.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.huawei.android.pushagent.b.a.b.b$a[] r0 = com.huawei.android.pushagent.b.a.b.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.android.pushagent.b.a.b.b$a r1 = com.huawei.android.pushagent.b.a.b.b.a.ChannelType_Normal     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.huawei.android.pushagent.b.a.b.b$a r1 = com.huawei.android.pushagent.b.a.b.b.a.ChannelType_SSL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.huawei.android.pushagent.b.a.b.b$a r1 = com.huawei.android.pushagent.b.a.b.b.a.ChannelType_SSL_Resume     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.huawei.android.pushagent.b.a.b.b$a r1 = com.huawei.android.pushagent.b.a.b.b.a.ChannelType_Secure     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.c.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        SocketEvent_CONNECTING,
        SocketEvent_CONNECTED,
        SocketEvent_CLOSE,
        SocketEvent_MSG_RECEIVED
    }

    public c(a aVar) {
        super("SocketRead_" + new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date()));
        this.c = aVar;
        this.b = aVar.d;
        this.a = aVar.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v38, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v40, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v42, resolved type: java.io.IOException} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0244 A[SYNTHETIC, Splitter:B:78:0x0244] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.Socket a(java.lang.String r13, int r14, boolean r15) throws java.lang.Exception {
        /*
            r12 = this;
            java.lang.String r0 = "call connect cause:"
            java.lang.String r1 = ":"
            java.lang.String r2 = "PushLogAC2705"
            r3 = 0
            java.net.Socket r4 = new java.net.Socket     // Catch:{ UnsupportedEncodingException -> 0x0228, SocketException -> 0x0217, IOException -> 0x0208, NumberFormatException -> 0x01f9, IllegalArgumentException -> 0x01ea, Exception -> 0x01d9 }
            r4.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0228, SocketException -> 0x0217, IOException -> 0x0208, NumberFormatException -> 0x01f9, IllegalArgumentException -> 0x01ea, Exception -> 0x01d9 }
            r4.getTcpNoDelay()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            boolean r3 = r12 instanceof com.huawei.android.pushagent.b.a.a.b.c     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r5 = 1
            if (r3 == 0) goto L_0x0029
            boolean r3 = com.huawei.android.pushagent.c.c.e.c()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            if (r3 == 0) goto L_0x0022
            int r3 = com.huawei.android.pushagent.c.a.a((java.net.Socket) r4)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.c.c.e.a(r5, r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            goto L_0x0029
        L_0x0022:
            int r3 = com.huawei.android.pushagent.c.a.a((java.net.Socket) r4)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.c.a.a((int) r5, (int) r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
        L_0x0029:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r6 = 11
            if (r3 < r6) goto L_0x0045
            java.lang.String r3 = "http.proxyHost"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r6 = "http.proxyPort"
            java.lang.String r6 = java.lang.System.getProperty(r6)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            if (r6 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            java.lang.String r6 = "-1"
        L_0x0040:
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            goto L_0x0051
        L_0x0045:
            android.content.Context r3 = r12.b     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r3 = android.net.Proxy.getHost(r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            android.content.Context r6 = r12.b     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            int r6 = android.net.Proxy.getPort(r6)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
        L_0x0051:
            android.content.Context r7 = r12.b     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            int r7 = com.huawei.android.pushagent.c.a.b.a((android.content.Context) r7)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.b.a.a.c$a r8 = com.huawei.android.pushagent.b.a.a.c.a.SocketEvent_CONNECTING     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r9.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r12.a(r8, r9)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r8.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r9 = "enter createSocket("
            r8.append(r9)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r8.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r8.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r8.append(r14)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r9 = ", proxy:"
            r8.append(r9)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r8.append(r15)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r9 = "("
            r8.append(r9)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r8.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r8.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r8.append(r6)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r9 = ")"
            r8.append(r9)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r8 = r8.toString()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.c.a.e.a(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r9 = 0
            if (r8 != 0) goto L_0x00a4
            r8 = -1
            if (r8 == r6) goto L_0x00a4
            if (r5 == r7) goto L_0x00a4
            r7 = 1
            goto L_0x00a5
        L_0x00a4:
            r7 = 0
        L_0x00a5:
            android.content.Context r8 = r12.b     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.b.b.a r8 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r8)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            boolean r8 = r8.ac()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r10.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r11 = "useProxy is valid:"
            r10.append(r11)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r10.append(r7)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r11 = ", allow proxy:"
            r10.append(r11)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r10.append(r8)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r10 = r10.toString()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.c.a.e.b(r2, r10)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            if (r15 == 0) goto L_0x019d
            if (r7 == 0) goto L_0x019d
            if (r8 == 0) goto L_0x019d
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r7 = "use Proxy "
            r15.append(r7)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.append(r6)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r7 = " to connect to push server."
            r15.append(r7)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r15 = r15.toString()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.c.a.e.b(r2, r15)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.net.InetSocketAddress r15 = new java.net.InetSocketAddress     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.<init>(r3, r6)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            android.content.Context r3 = r12.b     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.b.b.a r3 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            long r6 = r3.u()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            int r3 = (int) r6     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            int r3 = r3 * 1000
            r4.connect(r15, r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r3 = "CONNECT "
            r15.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.append(r14)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r13 = r15.toString()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.io.OutputStream r14 = r4.getOutputStream()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r1 = " HTTP/1.1\r\nHost: "
            r15.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r13 = "\r\n\r\n"
            r15.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r13 = r15.toString()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r15 = "UTF-8"
            byte[] r13 = r13.getBytes(r15)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r14.write(r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.io.InputStream r13 = r4.getInputStream()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15 = 100
            r14.<init>(r15)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15 = 0
        L_0x014e:
            int r1 = r13.read()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            char r1 = (char) r1     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r14.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            if (r15 == 0) goto L_0x015b
            r3 = 2
            if (r15 != r3) goto L_0x0162
        L_0x015b:
            r3 = 13
            if (r1 != r3) goto L_0x0162
        L_0x015f:
            int r15 = r15 + 1
            goto L_0x016d
        L_0x0162:
            if (r15 == r5) goto L_0x0167
            r3 = 3
            if (r15 != r3) goto L_0x016c
        L_0x0167:
            r3 = 10
            if (r1 != r3) goto L_0x016c
            goto L_0x015f
        L_0x016c:
            r15 = 0
        L_0x016d:
            r1 = 4
            if (r15 != r1) goto L_0x014e
            java.lang.String r13 = r14.toString()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.io.BufferedReader r14 = new java.io.BufferedReader     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.io.StringReader r15 = new java.io.StringReader     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.<init>(r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r14.<init>(r15)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r13 = r14.readLine()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            if (r13 == 0) goto L_0x01b7
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r14.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r15 = "read data:"
            r14.append(r15)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r13 = com.huawei.android.pushagent.c.a.a.e.a((java.lang.String) r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r14.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.lang.String r13 = r14.toString()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.c.a.e.a(r2, r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            goto L_0x01b7
        L_0x019d:
            java.lang.String r15 = "create socket without proxy"
            com.huawei.android.pushagent.c.a.e.b(r2, r15)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            java.net.InetSocketAddress r15 = new java.net.InetSocketAddress     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            r15.<init>(r13, r14)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            android.content.Context r13 = r12.b     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.b.b.a r13 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            long r13 = r13.u()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            int r14 = (int) r13     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            int r14 = r14 * 1000
            r4.connect(r15, r14)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
        L_0x01b7:
            java.lang.String r13 = "write the lastcontectsucc_time to the pushConfig.xml file"
            com.huawei.android.pushagent.c.a.e.a(r2, r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            android.content.Context r13 = r12.b     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            com.huawei.android.pushagent.b.b.a r13 = com.huawei.android.pushagent.b.b.a.a((android.content.Context) r13)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            long r13 = r13.u()     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            int r14 = (int) r13     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            int r14 = r14 * 1000
            r4.setSoTimeout(r14)     // Catch:{ UnsupportedEncodingException -> 0x01d7, SocketException -> 0x01d5, IOException -> 0x01d3, NumberFormatException -> 0x01d1, IllegalArgumentException -> 0x01cf, Exception -> 0x01cd }
            return r4
        L_0x01cd:
            r13 = move-exception
            goto L_0x01db
        L_0x01cf:
            r13 = move-exception
            goto L_0x01ec
        L_0x01d1:
            r13 = move-exception
            goto L_0x01fb
        L_0x01d3:
            r13 = move-exception
            goto L_0x020a
        L_0x01d5:
            r13 = move-exception
            goto L_0x0219
        L_0x01d7:
            r13 = move-exception
            goto L_0x022a
        L_0x01d9:
            r13 = move-exception
            r4 = r3
        L_0x01db:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "call createSocket cause:"
            r14.append(r15)
            java.lang.String r15 = r13.toString()
            goto L_0x0238
        L_0x01ea:
            r13 = move-exception
            r4 = r3
        L_0x01ec:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r0)
            java.lang.String r15 = r13.toString()
            goto L_0x0238
        L_0x01f9:
            r13 = move-exception
            r4 = r3
        L_0x01fb:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r0)
            java.lang.String r15 = r13.toString()
            goto L_0x0238
        L_0x0208:
            r13 = move-exception
            r4 = r3
        L_0x020a:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r0)
            java.lang.String r15 = r13.toString()
            goto L_0x0238
        L_0x0217:
            r13 = move-exception
            r4 = r3
        L_0x0219:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "call setSoTimeout cause:"
            r14.append(r15)
            java.lang.String r15 = r13.toString()
            goto L_0x0238
        L_0x0228:
            r13 = move-exception
            r4 = r3
        L_0x022a:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "call getBytes cause:"
            r14.append(r15)
            java.lang.String r15 = r13.toString()
        L_0x0238:
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            com.huawei.android.pushagent.c.a.e.c(r2, r14, r13)
            if (r4 == 0) goto L_0x0261
            r4.close()     // Catch:{ IOException -> 0x0248 }
            goto L_0x0261
        L_0x0248:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "close socket cause:"
            r14.append(r15)
            java.lang.String r15 = r13.toString()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r2, (java.lang.String) r14, (java.lang.Throwable) r13)
        L_0x0261:
            com.huawei.android.pushagent.a.c r13 = new com.huawei.android.pushagent.a.c
            com.huawei.android.pushagent.a.c$a r14 = com.huawei.android.pushagent.a.c.a.Err_Connect
            java.lang.String r15 = "create socket failed"
            r13.<init>((java.lang.String) r15, (com.huawei.android.pushagent.a.c.a) r14)
            goto L_0x026c
        L_0x026b:
            throw r13
        L_0x026c:
            goto L_0x026b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.a.c.a(java.lang.String, int, boolean):java.net.Socket");
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, Bundle bundle) {
        this.c.a(aVar, bundle);
    }

    /* access modifiers changed from: protected */
    public boolean a() throws com.huawei.android.pushagent.a.c {
        a aVar;
        b cVar;
        Socket socket = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            e.a("PushLogAC2705", "start to create socket");
            if (!(this.a == null || this.a.a == null)) {
                if (this.a.a.length() != 0) {
                    if (this.a.c == null) {
                        e.d("PushLogAC2705", "config sslconetEntity.channelType cfgErr:" + this.a.c + " cannot connect!!");
                        return false;
                    }
                    Socket a2 = a(this.a.a, this.a.b, this.a.d);
                    e.a("PushLogAC2705", "conetEntity.channelType:" + this.a.c);
                    int i = AnonymousClass1.a[this.a.c.ordinal()];
                    if (i == 1) {
                        aVar = this.c;
                        cVar = new com.huawei.android.pushagent.b.a.b.c(this.b);
                    } else if (i == 2 || i == 3) {
                        aVar = this.c;
                        cVar = new com.huawei.android.pushagent.b.a.b.d(this.b);
                    } else if (i != 4) {
                        e.d("PushLogAC2705", "conetEntity.channelType is invalid:" + this.a.c);
                        PushService.a().stopService();
                        a2.close();
                        return false;
                    } else {
                        aVar = this.c;
                        cVar = new com.huawei.android.pushagent.b.a.b.a(this.b);
                    }
                    aVar.c = cVar;
                    if (this.c.c.a(a2)) {
                        a2.setSoTimeout(0);
                        e.a("PushLogAC2705", "connect cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms, result:" + this.c.c.b());
                        if (this.c.c.b()) {
                            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.a.a, this.a.b);
                            Bundle bundle = new Bundle();
                            bundle.putString("server_ip", inetSocketAddress.getAddress().getHostAddress());
                            bundle.putInt("server_port", inetSocketAddress.getPort());
                            bundle.putString("client_ip", a2.getLocalAddress().getHostAddress());
                            bundle.putInt("client_port", a2.getLocalPort());
                            bundle.putInt("channelEntity", this.c.e().ordinal());
                            this.c.a(a.SocketEvent_CONNECTED, bundle);
                            return true;
                        }
                        e.d("PushLogAC2705", "Socket connect failed");
                        throw new com.huawei.android.pushagent.a.c("create SSLSocket failed", c.a.Err_Connect);
                    }
                    e.d("PushLogAC2705", "call conetEntity.channel.init failed!!");
                    a2.close();
                    throw new com.huawei.android.pushagent.a.c("init socket error", c.a.Err_Connect);
                }
            }
            e.d("PushLogAC2705", "the addr is " + this.a + " is invalid");
            return false;
        } catch (SocketException e) {
            e.c("PushLogAC2705", "call connectSync cause " + e.toString(), e);
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e2) {
                    e.a("PushLogAC2705", "close socket cause:" + e2.toString(), (Throwable) e2);
                }
            }
            throw new com.huawei.android.pushagent.a.c((Throwable) e, c.a.Err_Connect);
        } catch (Exception e3) {
            e.c("PushLogAC2705", "call connectSync cause " + e3.toString(), e3);
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e4) {
                    e.a("PushLogAC2705", "close socket cause:" + e4.toString(), (Throwable) e4);
                }
            }
            throw new com.huawei.android.pushagent.a.c((Throwable) e3, c.a.Err_Connect);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b() throws Exception;

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (a()) {
                currentTimeMillis = System.currentTimeMillis();
                b();
            }
            e.a("PushLogAC2705", "normal to quit.");
            Bundle bundle = new Bundle();
            bundle.putLong("connect_time", System.currentTimeMillis() - currentTimeMillis);
            a(a.SocketEvent_CLOSE, bundle);
            e.b("PushLogAC2705", "total connect Time:" + (System.currentTimeMillis() - currentTimeMillis) + " process quit, so close socket");
            if (this.c.c != null) {
                try {
                    this.c.c.a();
                } catch (Exception e) {
                    e.c("PushLogAC2705", e.toString(), e);
                }
            }
        } catch (com.huawei.android.pushagent.a.c e2) {
            e.c("PushLogAC2705", "connect occurs :" + e2.toString(), e2);
            c.a aVar = e2.a;
            Bundle bundle2 = new Bundle();
            if (aVar != null) {
                bundle2.putSerializable("errorType", aVar);
            }
            bundle2.putString("push_exception", e2.toString());
            a(a.SocketEvent_CLOSE, bundle2);
            e.b("PushLogAC2705", "total connect Time:" + (System.currentTimeMillis() - currentTimeMillis) + " process quit, so close socket");
            if (this.c.c != null) {
                this.c.c.a();
            }
        } catch (Exception e3) {
            e.c("PushLogAC2705", "connect cause :" + e3.toString(), e3);
            Bundle bundle3 = new Bundle();
            bundle3.putString("push_exception", e3.toString());
            a(a.SocketEvent_CLOSE, bundle3);
            e.b("PushLogAC2705", "total connect Time:" + (System.currentTimeMillis() - currentTimeMillis) + " process quit, so close socket");
            if (this.c.c != null) {
                this.c.c.a();
            }
        } catch (Throwable th) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            e.b("PushLogAC2705", "total connect Time:" + currentTimeMillis2 + " process quit, so close socket");
            if (this.c.c != null) {
                try {
                    this.c.c.a();
                } catch (Exception e4) {
                    e.c("PushLogAC2705", e4.toString(), e4);
                }
            }
            throw th;
        }
        e.a("PushLogAC2705", "connect thread exit!");
    }
}
