package com.bytedance.sdk.component.f.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.k;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: NetExecutor */
public abstract class c {
    protected i c;
    protected String d = null;
    protected final Map<String, String> e = new HashMap();
    protected String f = null;

    public c(i iVar) {
        this.c = iVar;
        b(UUID.randomUUID().toString());
    }

    /* access modifiers changed from: protected */
    public void a(k.a aVar) {
        if (aVar != null && this.e.size() > 0) {
            for (Map.Entry next : this.e.entrySet()) {
                String str = (String) next.getKey();
                if (!TextUtils.isEmpty(str)) {
                    String str2 = (String) next.getValue();
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar.b(str, str2);
                }
            }
        }
    }

    public void a(String str) {
        this.f = str;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(String str, String str2) {
        this.e.put(str, str2);
    }

    public void d(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                this.e.put(next.getKey(), next.getValue());
            }
        }
    }
}
