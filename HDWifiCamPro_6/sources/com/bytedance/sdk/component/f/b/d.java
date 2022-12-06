package com.bytedance.sdk.component.f.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.b;
import com.bytedance.sdk.component.b.a.c;
import com.bytedance.sdk.component.b.a.e;
import com.bytedance.sdk.component.b.a.h;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.k;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.m;
import com.bytedance.sdk.component.f.a.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: PostExecutor */
public class d extends c {
    l a = null;

    public d(i iVar) {
        super(iVar);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.a = l.a(h.a("application/json; charset=utf-8"), str);
    }

    public void a(JSONObject jSONObject) {
        this.a = l.a(h.a("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : "{}");
    }

    public void a(final a aVar) {
        try {
            k.a aVar2 = new k.a();
            if (TextUtils.isEmpty(this.f)) {
                aVar.a((c) this, new IOException("Url is Empty"));
                return;
            }
            aVar2.a(this.f);
            if (this.a != null) {
                a(aVar2);
                aVar2.a((Object) b());
                this.c.a(aVar2.a(this.a).b()).a(new c() {
                    public void a(b bVar, IOException iOException) {
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.a((c) d.this, iOException);
                        }
                    }

                    public void a(b bVar, m mVar) throws IOException {
                        IOException iOException;
                        a aVar = aVar;
                        if (aVar == null) {
                            return;
                        }
                        if (mVar == null) {
                            aVar.a((c) d.this, new IOException("No response"));
                            return;
                        }
                        com.bytedance.sdk.component.f.b bVar2 = null;
                        try {
                            HashMap hashMap = new HashMap();
                            e g = mVar.g();
                            if (g != null) {
                                for (int i = 0; i < g.a(); i++) {
                                    hashMap.put(g.a(i), g.b(i));
                                }
                            }
                            iOException = null;
                            bVar2 = new com.bytedance.sdk.component.f.b(mVar.d(), mVar.c(), mVar.e(), hashMap, mVar.f().b(), mVar.b(), mVar.a());
                        } catch (Throwable th) {
                            iOException = new IOException(th);
                        }
                        if (bVar2 != null) {
                            aVar.a((c) d.this, bVar2);
                            return;
                        }
                        a aVar2 = aVar;
                        d dVar = d.this;
                        if (iOException == null) {
                            iOException = new IOException("Unexpected exception");
                        }
                        aVar2.a((c) dVar, iOException);
                    }
                });
            } else if (aVar != null) {
                aVar.a((c) this, new IOException("RequestBody is null, content type is not support!!"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            aVar.a((c) this, new IOException(th.getMessage()));
        }
    }

    public com.bytedance.sdk.component.f.b a() {
        try {
            k.a aVar = new k.a();
            if (TextUtils.isEmpty(this.f)) {
                com.bytedance.sdk.component.f.d.d.b("PostExecutor", "execute: Url is Empty");
                return new com.bytedance.sdk.component.f.b(false, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS, "URL_NULL_MSG", (Map<String, String>) null, "URL_NULL_BODY", 1, 1);
            }
            aVar.a(this.f);
            if (this.a == null) {
                com.bytedance.sdk.component.f.d.d.b("PostExecutor", "RequestBody is null, content type is not support!!");
                return new com.bytedance.sdk.component.f.b(false, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS, "BODY_NULL_MSG", (Map<String, String>) null, "BODY_NULL_BODY", 1, 1);
            }
            a(aVar);
            aVar.a((Object) b());
            m a2 = this.c.a(aVar.a(this.a).b()).a();
            if (a2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            e g = a2.g();
            if (g != null) {
                for (int i = 0; i < g.a(); i++) {
                    hashMap.put(g.a(i), g.b(i));
                }
            }
            return new com.bytedance.sdk.component.f.b(a2.d(), a2.c(), a2.e(), hashMap, a2.f().b(), a2.b(), a2.a());
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.f.b(false, IronSourceConstants.errorCode_biddingDataException, th.getMessage(), (Map<String, String>) null, "BODY_NULL_BODY", 1, 1);
        }
    }
}
