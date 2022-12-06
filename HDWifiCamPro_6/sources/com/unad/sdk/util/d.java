package com.unad.sdk.util;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: OkHttpTool */
public class d {
    private static OkHttpClient a;

    /* compiled from: OkHttpTool */
    static class a implements CookieJar {
        private final HashMap<String, List<Cookie>> a = new HashMap<>();

        a() {
        }

        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> list = this.a.get(httpUrl.host());
            return list != null ? list : new ArrayList();
        }

        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            this.a.put(httpUrl.host(), list);
        }
    }

    /* compiled from: OkHttpTool */
    static class b implements Callback {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        public void onFailure(Call call, IOException iOException) {
            this.a.a(call, (Exception) iOException);
        }

        public void onResponse(Call call, Response response) throws IOException {
            try {
                this.a.a(call, response.body().string());
            } catch (Exception e) {
                this.a.a(call, e);
            }
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a = builder.connectTimeout(20, timeUnit).readTimeout(30, timeUnit).cookieJar(new a()).build();
    }

    public static void a(String str, Map<String, String> map, c cVar) {
        a.newCall(new Request.Builder().url(str).get().build()).enqueue(new b(cVar));
    }
}
