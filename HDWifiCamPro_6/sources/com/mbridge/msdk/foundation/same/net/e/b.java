package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import java.util.concurrent.TimeUnit;

/* compiled from: OKHTTPClientManager */
public final class b {
    private OkHttpClient a;

    /* compiled from: OKHTTPClientManager */
    private static final class a {
        /* access modifiers changed from: private */
        public static final b a = new b();
    }

    private b() {
        this.a = null;
    }

    public final synchronized OkHttpClient a() {
        if (this.a == null) {
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequestsPerHost(10);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(100, TimeUnit.SECONDS);
            builder.connectTimeout(60, TimeUnit.SECONDS);
            builder.writeTimeout(60, TimeUnit.SECONDS);
            builder.connectionPool(new ConnectionPool(32, 5, TimeUnit.MINUTES));
            builder.dispatcher(dispatcher);
            builder.eventListener(new EventListener() {
            });
            this.a = builder.build();
        }
        return this.a;
    }
}
