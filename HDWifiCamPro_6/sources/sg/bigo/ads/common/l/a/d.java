package sg.bigo.ads.common.l.a;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import sg.bigo.ads.common.l.f;
import sg.bigo.ads.common.utils.g;

public final class d {
    final HttpURLConnection a;
    final int b;
    final g<List<String>> c;
    private final c d;
    private final String e;
    private final boolean f;

    public static class a {
        public final int a;
        public final URL b;
        public final String c;
        public final String d;
        public final int e;

        private a(int i, URL url, String str, String str2, int i2) {
            this.a = i;
            this.b = url;
            this.c = str;
            this.d = str2;
            this.e = i2;
        }

        /* synthetic */ a(int i, URL url, String str, String str2, int i2, byte b2) {
            this(i, url, str, str2, i2);
        }
    }

    public d(c cVar) {
        URL url;
        this.d = cVar;
        if (cVar.c != null) {
            url = cVar.c;
        } else {
            cVar.a.a("PreHost");
            url = new URL(cVar.a.d);
            if (cVar.b != null) {
                URL a2 = cVar.b.a(url);
                cVar.a.e = a2.toString();
                String a3 = cVar.b.a(url.getHost());
                if (!TextUtils.equals(a3, url.getHost())) {
                    cVar.a.a("PreHost", a3);
                }
                url = a2;
            }
        }
        boolean equalsIgnoreCase = "HTTPS".equalsIgnoreCase(url.getProtocol());
        URLConnection openConnection = url.openConnection();
        cVar.d = equalsIgnoreCase ? (HttpsURLConnection) openConnection : (HttpURLConnection) openConnection;
        cVar.d.setInstanceFollowRedirects(false);
        cVar.d.setDoInput(true);
        cVar.d.setUseCaches(false);
        cVar.d.setConnectTimeout((int) cVar.a.f);
        cVar.d.setReadTimeout((int) cVar.a.f);
        cVar.d.setRequestMethod(cVar.a.a());
        cVar.b();
        byte[] c2 = cVar.a.c();
        if (c2 != null && c2.length > 0) {
            f b2 = cVar.a.b();
            if (b2 != null) {
                cVar.d.setRequestProperty(HttpHeaders.CONTENT_TYPE, b2.toString());
            }
            cVar.d.setDoOutput(true);
            cVar.d.setRequestProperty(HttpHeaders.CONTENT_LENGTH, Long.toString((long) cVar.a.e()));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(cVar.d.getOutputStream());
            bufferedOutputStream.write(c2);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
        this.a = cVar.d;
        this.b = this.a.getResponseCode();
        this.e = this.a.getRequestMethod();
        this.c = new g<>();
        Map headerFields = this.a.getHeaderFields();
        if (headerFields != null) {
            this.c.a(headerFields);
        }
        this.f = "gzip".equalsIgnoreCase(this.a.getContentEncoding());
        if (this.f && cVar.e) {
            this.c.b(HttpHeaders.CONTENT_ENCODING);
            this.c.b(HttpHeaders.CONTENT_LENGTH);
        }
    }

    private String a(String str) {
        List a2 = this.c.a(str);
        int size = a2 != null ? a2.size() : 0;
        String str2 = "";
        while (TextUtils.isEmpty(str2) && size > 0) {
            str2 = (String) a2.get(0);
        }
        return str2;
    }

    public final InputStream a() {
        InputStream inputStream = this.a.getInputStream();
        return (!this.f || !this.d.e) ? inputStream : new GZIPInputStream(inputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.net.URL} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.net.URL} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: java.net.URL} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: java.net.URL} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final sg.bigo.ads.common.l.a.d.a b() {
        /*
            r19 = this;
            r0 = r19
            int r1 = r0.b
            r2 = 307(0x133, float:4.3E-43)
            java.lang.String r3 = "Location"
            r4 = 0
            if (r1 == r2) goto L_0x0013
            r2 = 308(0x134, float:4.32E-43)
            if (r1 == r2) goto L_0x0013
            switch(r1) {
                case 300: goto L_0x0051;
                case 301: goto L_0x0051;
                case 302: goto L_0x0051;
                case 303: goto L_0x0051;
                default: goto L_0x0012;
            }
        L_0x0012:
            return r4
        L_0x0013:
            java.lang.String r1 = r0.e
            java.lang.String r2 = "GET"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x0051
            java.lang.String r1 = r0.e
            java.lang.String r2 = "HEAD"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x0051
            java.lang.String r8 = r0.a(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "redirect code("
            r1.<init>(r2)
            int r2 = r0.b
            r1.append(r2)
            java.lang.String r2 = ") is only available for GET or HEAD method, current request method is "
            r1.append(r2)
            java.lang.String r2 = r0.e
            r1.append(r2)
            java.lang.String r9 = r1.toString()
            sg.bigo.ads.common.l.a.d$a r1 = new sg.bigo.ads.common.l.a.d$a
            r6 = -1
            r7 = 0
            int r10 = r0.b
            r11 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r1
        L_0x0051:
            java.lang.String r15 = r0.a(r3)
            boolean r1 = android.text.TextUtils.isEmpty(r15)
            if (r1 == 0) goto L_0x0061
            java.lang.String r1 = "empty location."
        L_0x005d:
            r16 = r1
            r14 = r4
            goto L_0x009b
        L_0x0061:
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0087 }
            sg.bigo.ads.common.l.a.c r2 = r0.d     // Catch:{ Exception -> 0x0087 }
            java.net.URL r2 = r2.a()     // Catch:{ Exception -> 0x0087 }
            r1.<init>(r2, r15)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = r1.toString()     // Catch:{ Exception -> 0x0086 }
            sg.bigo.ads.common.l.a.c r3 = r0.d     // Catch:{ Exception -> 0x0086 }
            java.net.URL r3 = r3.a()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0086 }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ Exception -> 0x0086 }
            if (r2 == 0) goto L_0x0082
            java.lang.String r4 = "same location."
        L_0x0082:
            r14 = r1
            r16 = r4
            goto L_0x009b
        L_0x0086:
            r4 = r1
        L_0x0087:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "location->\""
            r1.<init>(r2)
            r1.append(r15)
            java.lang.String r2 = "\" is not a network url."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            goto L_0x005d
        L_0x009b:
            sg.bigo.ads.common.l.a.d$a r1 = new sg.bigo.ads.common.l.a.d$a
            if (r14 != 0) goto L_0x00a1
            r2 = 0
            goto L_0x00a2
        L_0x00a1:
            r2 = 2
        L_0x00a2:
            r13 = r2
            int r2 = r0.b
            r18 = 0
            r12 = r1
            r17 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.l.a.d.b():sg.bigo.ads.common.l.a.d$a");
    }
}
