package com.bytedance.sdk.component.f.b;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.a;
import com.bytedance.sdk.component.b.a.c;
import com.bytedance.sdk.component.b.a.e;
import com.bytedance.sdk.component.b.a.f;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.k;
import com.bytedance.sdk.component.b.a.m;
import com.bytedance.sdk.component.f.d.d;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: GetExecutor */
public class b extends c {
    public static final a a = new a.C0028a().a().b();
    public static final a b = new a.C0028a().b();
    private a g = a;
    private boolean h = false;
    private Map<String, String> i = new HashMap();

    public b(i iVar) {
        super(iVar);
    }

    public void a(String str, String str2) {
        if (str == null) {
            d.b("GetExecutor", "name cannot be null !!!");
        } else {
            this.i.put(str, str2);
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(final com.bytedance.sdk.component.f.a.a aVar) {
        try {
            k.a aVar2 = new k.a();
            if (this.h) {
                aVar2.a(this.f);
            } else {
                f.a aVar3 = new f.a();
                Uri parse = Uri.parse(this.f);
                aVar3.a(parse.getScheme());
                aVar3.b(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    aVar3.c(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String next : queryParameterNames) {
                        this.i.put(next, parse.getQueryParameter(next));
                    }
                }
                for (Map.Entry next2 : this.i.entrySet()) {
                    String str = (String) next2.getKey();
                    String str2 = (String) next2.getValue();
                    if (!TextUtils.isEmpty(str)) {
                        String encode = URLEncoder.encode(str, "UTF-8");
                        if (str2 == null) {
                            str2 = "";
                        }
                        aVar3.a(encode, URLEncoder.encode(str2, "UTF-8"));
                    }
                }
                aVar2.a(aVar3.b());
            }
            a(aVar2);
            aVar2.a(this.g);
            aVar2.a((Object) b());
            this.c.a(aVar2.a().b()).a(new c() {
                public void a(com.bytedance.sdk.component.b.a.b bVar, IOException iOException) {
                    com.bytedance.sdk.component.f.a.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a((c) b.this, iOException);
                    }
                }

                public void a(com.bytedance.sdk.component.b.a.b bVar, m mVar) throws IOException {
                    if (aVar != null) {
                        HashMap hashMap = new HashMap();
                        if (mVar != null) {
                            e g = mVar.g();
                            if (g != null) {
                                for (int i = 0; i < g.a(); i++) {
                                    hashMap.put(g.a(i), g.b(i));
                                }
                            }
                            aVar.a((c) b.this, new com.bytedance.sdk.component.f.b(mVar.d(), mVar.c(), mVar.e(), hashMap, mVar.f().b(), mVar.b(), mVar.a()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (d.a()) {
                th.printStackTrace();
            }
            if (aVar != null) {
                aVar.a((c) this, new IOException(th.getMessage()));
            }
        }
    }

    public com.bytedance.sdk.component.f.b a() {
        try {
            k.a aVar = new k.a();
            if (this.h) {
                aVar.a(this.f);
            } else {
                f.a aVar2 = new f.a();
                Uri parse = Uri.parse(this.f);
                aVar2.a(parse.getScheme());
                aVar2.b(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    aVar2.c(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String next : queryParameterNames) {
                        this.i.put(next, parse.getQueryParameter(next));
                    }
                }
                for (Map.Entry next2 : this.i.entrySet()) {
                    String str = (String) next2.getKey();
                    String str2 = (String) next2.getValue();
                    if (!TextUtils.isEmpty(str)) {
                        String encode = URLEncoder.encode(str, "UTF-8");
                        if (str2 == null) {
                            str2 = "";
                        }
                        aVar2.a(encode, URLEncoder.encode(str2, "UTF-8"));
                    }
                }
                aVar.a(aVar2.b());
            }
            a(aVar);
            aVar.a(this.g);
            aVar.a((Object) b());
            m a2 = this.c.a(aVar.a().b()).a();
            if (a2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            e g2 = a2.g();
            if (g2 != null) {
                for (int i2 = 0; i2 < g2.a(); i2++) {
                    hashMap.put(g2.a(i2), g2.b(i2));
                }
            }
            return new com.bytedance.sdk.component.f.b(a2.d(), a2.c(), a2.e(), hashMap, a2.f().b(), a2.b(), a2.a());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
