package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.e.b;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: OkHttpStack */
public final class c implements a {
    private final OkHttpClient a = b.a.a.a();

    private static RequestBody b(i iVar) {
        byte[] e = iVar.e();
        if (e == null) {
            return null;
        }
        return RequestBody.create((MediaType) null, e);
    }

    public final com.mbridge.msdk.foundation.same.net.f.b a(i<?> iVar) throws IOException {
        int h = iVar.h();
        int i = iVar.i();
        int j = iVar.j();
        int k = iVar.k();
        int l = iVar.l();
        if (i == 0) {
            i = h;
        }
        if (j == 0) {
            j = h;
        }
        if (k != 0) {
            h = k;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        arrayList.add(Protocol.HTTP_2);
        OkHttpClient.Builder writeTimeout = this.a.newBuilder().protocols(arrayList).readTimeout((long) j, TimeUnit.MILLISECONDS).connectTimeout((long) i, TimeUnit.MILLISECONDS).writeTimeout((long) h, TimeUnit.MILLISECONDS);
        if (l > 0) {
            writeTimeout.callTimeout((long) l, TimeUnit.MILLISECONDS);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("connectTimeout: ");
        sb.append(i);
        sb.append(" readTimeout: ");
        sb.append(j);
        sb.append(" writeTimeout: ");
        sb.append(h);
        sb.append(" callTimeout: ");
        sb.append(l == 0 ? "not set" : Integer.valueOf(l));
        q.a("OkHttpStack", sb.toString());
        Request.Builder builder = new Request.Builder();
        for (Map.Entry next : iVar.d().entrySet()) {
            builder.addHeader((String) next.getKey(), (String) next.getValue());
        }
        switch (iVar.a()) {
            case 0:
                builder.get();
                break;
            case 1:
                builder.post(b(iVar));
                break;
            case 2:
                builder.put(b(iVar));
                break;
            case 3:
                builder.delete();
                break;
            case 4:
                builder.head();
                break;
            case 5:
                builder.method("OPTIONS", (RequestBody) null);
                break;
            case 6:
                builder.method("TRACE", (RequestBody) null);
                break;
            case 7:
                builder.patch(b(iVar));
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        Response execute = writeTimeout.build().newCall(builder.url(iVar.b()).build()).execute();
        Headers headers = execute.headers();
        ArrayList arrayList2 = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = headers.name(i2);
            String value = headers.value(i2);
            if (name != null) {
                arrayList2.add(new com.mbridge.msdk.foundation.same.net.c.b(name, value));
            }
        }
        return new com.mbridge.msdk.foundation.same.net.f.b(execute.code(), arrayList2, execute.body().byteStream());
    }
}
