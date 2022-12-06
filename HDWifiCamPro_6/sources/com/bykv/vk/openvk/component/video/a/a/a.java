package com.bykv.vk.openvk.component.video.a.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.a.a.a.b;
import com.bykv.vk.openvk.component.video.api.c.c;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SdkMediaDataSource */
public class a extends MediaDataSource {
    public static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();
    private b b = null;
    private long c = -2147483648L;
    private Context d;
    private final c e;

    public a(Context context, c cVar) {
        this.d = context;
        this.e = cVar;
    }

    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        b();
        int a2 = this.b.a(j, bArr, i, i2);
        com.bykv.vk.openvk.component.video.api.f.c.b("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    private void b() {
        if (this.b == null) {
            this.b = new com.bykv.vk.openvk.component.video.a.a.a.c(this.d, this.e);
        }
    }

    public long getSize() throws IOException {
        b();
        if (this.c == -2147483648L) {
            if (this.d == null || TextUtils.isEmpty(this.e.k())) {
                return -1;
            }
            this.c = this.b.b();
            com.bykv.vk.openvk.component.video.api.f.c.b("SdkMediaDataSource", "getSize: " + this.c);
        }
        return this.c;
    }

    public void close() throws IOException {
        com.bykv.vk.openvk.component.video.api.f.c.b("SdkMediaDataSource", "close: ", this.e.k());
        b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
        a.remove(this.e.l());
    }

    public c a() {
        return this.e;
    }

    public static a a(Context context, c cVar) {
        a aVar = new a(context, cVar);
        a.put(cVar.l(), aVar);
        return aVar;
    }
}
