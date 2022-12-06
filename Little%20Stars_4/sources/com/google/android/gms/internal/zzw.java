package com.google.android.gms.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class zzw implements zzy {
    protected final HttpClient zzaD;

    public static final class zza extends HttpEntityEnclosingRequestBase {
        public zza() {
        }

        public zza(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public zzw(HttpClient httpClient) {
        this.zzaD = httpClient;
    }

    private static void zza(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, zzk<?> zzk) throws zza {
        byte[] zzp = zzk.zzp();
        if (zzp != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(zzp));
        }
    }

    private static void zza(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String next : map.keySet()) {
            httpUriRequest.setHeader(next, map.get(next));
        }
    }

    static HttpUriRequest zzb(zzk<?> zzk, Map<String, String> map) throws zza {
        switch (zzk.getMethod()) {
            case -1:
                byte[] zzl = zzk.zzl();
                if (zzl == null) {
                    return new HttpGet(zzk.getUrl());
                }
                HttpPost httpPost = new HttpPost(zzk.getUrl());
                httpPost.addHeader(HttpHeaders.CONTENT_TYPE, zzk.zzk());
                httpPost.setEntity(new ByteArrayEntity(zzl));
                return httpPost;
            case 0:
                return new HttpGet(zzk.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(zzk.getUrl());
                httpPost2.addHeader(HttpHeaders.CONTENT_TYPE, zzk.zzo());
                zza((HttpEntityEnclosingRequestBase) httpPost2, zzk);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(zzk.getUrl());
                httpPut.addHeader(HttpHeaders.CONTENT_TYPE, zzk.zzo());
                zza((HttpEntityEnclosingRequestBase) httpPut, zzk);
                return httpPut;
            case 3:
                return new HttpDelete(zzk.getUrl());
            case 4:
                return new HttpHead(zzk.getUrl());
            case 5:
                return new HttpOptions(zzk.getUrl());
            case 6:
                return new HttpTrace(zzk.getUrl());
            case 7:
                zza zza2 = new zza(zzk.getUrl());
                zza2.addHeader(HttpHeaders.CONTENT_TYPE, zzk.zzo());
                zza((HttpEntityEnclosingRequestBase) zza2, zzk);
                return zza2;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public HttpResponse zza(zzk<?> zzk, Map<String, String> map) throws IOException, zza {
        HttpUriRequest zzb = zzb(zzk, map);
        zza(zzb, map);
        zza(zzb, zzk.getHeaders());
        zza(zzb);
        HttpParams params = zzb.getParams();
        int zzs = zzk.zzs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, zzs);
        return this.zzaD.execute(zzb);
    }

    /* access modifiers changed from: protected */
    public void zza(HttpUriRequest httpUriRequest) throws IOException {
    }
}
