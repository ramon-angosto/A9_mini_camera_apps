package com.huawei.hms.availableupdate;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hms.availableupdate.j */
/* compiled from: HttpRequestHelper */
public class C0656j implements C0657k {

    /* renamed from: a */
    public HttpURLConnection f393a;

    /* renamed from: b */
    public volatile int f394b = -1;

    /* renamed from: a */
    public void mo13267a() {
        this.f394b = 1;
    }

    public void close() {
        this.f394b = -1;
        HttpURLConnection httpURLConnection = this.f393a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: a */
    public int mo13266a(String str, OutputStream outputStream, int i, int i2, Context context) throws IOException, C0655i {
        InputStream inputStream = null;
        try {
            mo13269a(str, context);
            this.f393a.setRequestMethod("GET");
            if (i > 0) {
                HttpURLConnection httpURLConnection = this.f393a;
                httpURLConnection.addRequestProperty(HttpHeaders.RANGE, "bytes=" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2);
            }
            int responseCode = this.f393a.getResponseCode();
            if ((i > 0 && responseCode == 206) || (i <= 0 && responseCode == 200)) {
                inputStream = this.f393a.getInputStream();
                mo13268a((InputStream) new BufferedInputStream(inputStream, 4096), outputStream);
                outputStream.flush();
            }
            return responseCode;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    /* renamed from: a */
    public final void mo13269a(String str, Context context) throws IOException {
        if (this.f394b == 0) {
            HMSLog.m1377e("HttpRequestHelper", "Not allowed to repeat open http(s) connection.");
        }
        this.f393a = (HttpURLConnection) new URL(str).openConnection();
        if (this.f393a instanceof HttpsURLConnection) {
            try {
                SecureSSLSocketFactory instance = SecureSSLSocketFactory.getInstance(context);
                if (instance != null) {
                    ((HttpsURLConnection) this.f393a).setSSLSocketFactory(instance);
                }
                ((HttpsURLConnection) this.f393a).setSSLSocketFactory(instance);
            } catch (IOException | IllegalAccessException | IllegalArgumentException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                HMSLog.m1377e("HttpRequestHelper", "Failed to new TLSSocketFactory instance." + e.getMessage());
                throw new IOException("Failed to create SSLSocketFactory.");
            }
        }
        this.f393a.setConnectTimeout(30000);
        this.f393a.setReadTimeout(30000);
        this.f393a.setDoInput(true);
        this.f393a.setDoOutput(true);
        this.f393a.setUseCaches(false);
        this.f393a.setInstanceFollowRedirects(true);
        this.f394b = 0;
    }

    /* renamed from: a */
    public final void mo13268a(InputStream inputStream, OutputStream outputStream) throws IOException, C0655i {
        byte[] bArr = new byte[4096];
        do {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        } while (this.f394b != 1);
        throw new C0655i("HTTP(s) request was canceled.");
    }
}
