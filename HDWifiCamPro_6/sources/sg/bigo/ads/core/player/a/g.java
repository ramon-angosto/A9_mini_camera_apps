package sg.bigo.ads.core.player.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import sg.bigo.ads.common.k.a;

public final class g {
    HttpURLConnection a;
    InputStream b;
    String c;

    public g(String str) {
        this.c = str;
    }

    public final int a(byte[] bArr) {
        String str;
        StringBuilder sb;
        InputStream inputStream = this.b;
        if (inputStream == null) {
            a.a(0, "ProxyCache", "Error reading data from " + this.c + ": connection is absent!");
            return 0;
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            sb = new StringBuilder("Reading source ");
            sb.append(this.c);
            sb.append(" is interrupted, error message is : ");
            str = e.toString();
            sb.append(str);
            a.a(0, "ProxyCache", sb.toString());
            return 0;
        } catch (IOException e2) {
            sb = new StringBuilder("Error reading data from ");
            sb.append(this.c);
            sb.append(", error message is : ");
            str = e2.toString();
            sb.append(str);
            a.a(0, "ProxyCache", sb.toString());
            return 0;
        }
    }

    public final void a() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e) {
                a.a(0, "ProxyCache", "connection disconnect error..., the error message is : " + e.toString());
            } catch (ArrayIndexOutOfBoundsException e2) {
                a.a(0, "ProxyCache", "Error closing connection correctly, the error message is : " + e2.toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047 A[Catch:{ IOException -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055 A[Catch:{ IOException -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[LOOP:0: B:1:0x0008->B:20:0x0065, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080 A[EDGE_INSN: B:26:0x0080->B:25:0x0080 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection b() {
        /*
            r8 = this;
            java.lang.String r0 = "ProxyCache"
            java.lang.String r1 = r8.c
            r2 = 0
            r3 = 0
            r4 = r3
            r3 = r2
        L_0x0008:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0069 }
            java.lang.String r6 = "Open connection "
            r5.<init>(r6)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r6 = ""
            r5.append(r6)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r6 = " to "
            r5.append(r6)     // Catch:{ IOException -> 0x0069 }
            r5.append(r1)     // Catch:{ IOException -> 0x0069 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0069 }
            r6 = 3
            sg.bigo.ads.common.k.a.a(r2, r6, r0, r5)     // Catch:{ IOException -> 0x0069 }
            java.net.URL r5 = new java.net.URL     // Catch:{ IOException -> 0x0069 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0069 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ IOException -> 0x0069 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x0069 }
            if (r5 == 0) goto L_0x0080
            int r4 = r5.getResponseCode()     // Catch:{ IOException -> 0x0067 }
            r6 = 301(0x12d, float:4.22E-43)
            if (r4 == r6) goto L_0x0044
            r6 = 302(0x12e, float:4.23E-43)
            if (r4 == r6) goto L_0x0044
            r6 = 303(0x12f, float:4.25E-43)
            if (r4 != r6) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r4 = r2
            goto L_0x0045
        L_0x0044:
            r4 = 1
        L_0x0045:
            if (r4 == 0) goto L_0x0052
            java.lang.String r1 = "Location"
            java.lang.String r1 = r5.getHeaderField(r1)     // Catch:{ IOException -> 0x0067 }
            int r3 = r3 + 1
            r5.disconnect()     // Catch:{ IOException -> 0x0067 }
        L_0x0052:
            r6 = 5
            if (r3 <= r6) goto L_0x0062
            java.lang.String r6 = "Too many redirects: "
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0067 }
            java.lang.String r6 = r6.concat(r7)     // Catch:{ IOException -> 0x0067 }
            sg.bigo.ads.common.k.a.a(r2, r0, r6)     // Catch:{ IOException -> 0x0067 }
        L_0x0062:
            if (r4 != 0) goto L_0x0065
            goto L_0x0080
        L_0x0065:
            r4 = r5
            goto L_0x0008
        L_0x0067:
            r1 = move-exception
            goto L_0x006b
        L_0x0069:
            r1 = move-exception
            r5 = r4
        L_0x006b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "PingHttpUrlSource#openConnection, error message is : "
            r3.<init>(r4)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            sg.bigo.ads.common.k.a.a(r2, r0, r1)
        L_0x0080:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.a.g.b():java.net.HttpURLConnection");
    }
}
