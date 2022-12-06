package com.ironsource.a;

import android.net.Uri;
import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import com.ironsource.d.b;
import com.ironsource.d.c;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b {
    a a;
    private c b;
    private d c;
    private ExecutorService d;

    public b(a aVar, c cVar) {
        if (aVar == null) {
            throw new InvalidParameterException("Null configuration not supported ");
        } else if (aVar.d != null) {
            this.a = aVar;
            this.b = cVar;
            this.c = aVar.d;
            this.d = Executors.newSingleThreadExecutor();
        } else {
            throw new InvalidParameterException("Null formatter not supported ");
        }
    }

    private static void a(Map<String, Object> map, Map<String, Object> map2) {
        try {
            map.putAll(map2);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (this.a.e) {
            Log.d("EventsTracker", str);
        }
    }

    public final void a(String str, Map<String, Object> map) {
        a(String.format(Locale.ENGLISH, "%s %s", new Object[]{str, map.toString()}));
        if (this.a.b && !str.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("eventname", str);
            a((Map<String, Object>) hashMap, this.b.a());
            a((Map<String, Object>) hashMap, map);
            final String a2 = this.c.a(hashMap);
            this.d.submit(new Runnable() {
                public final void run() {
                    try {
                        c cVar = new c();
                        ArrayList arrayList = new ArrayList(b.this.a.f);
                        if (ShareTarget.METHOD_POST.equals(b.this.a.c)) {
                            cVar = com.ironsource.d.b.a(b.this.a.a, a2, arrayList);
                        } else if (ShareTarget.METHOD_GET.equals(b.this.a.c)) {
                            String str = b.this.a.a;
                            String str2 = a2;
                            Uri build = Uri.parse(str).buildUpon().encodedQuery(str2).build();
                            b.a.C0087a aVar = new b.a.C0087a();
                            aVar.b = build.toString();
                            aVar.d = str2;
                            aVar.c = ShareTarget.METHOD_GET;
                            aVar.a(arrayList);
                            cVar = com.ironsource.d.b.a(aVar.a());
                        }
                        b bVar = b.this;
                        bVar.a("response status code: " + cVar.a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
