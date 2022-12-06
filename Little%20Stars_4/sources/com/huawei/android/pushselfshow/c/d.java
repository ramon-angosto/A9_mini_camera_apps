package com.huawei.android.pushselfshow.c;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.b.a;
import com.huawei.android.pushselfshow.richpush.tools.b;

public class d extends Thread {
    private Context a;
    private a b;

    public d(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
    }

    public boolean a(Context context) {
        if ("cosa".equals(this.b.o)) {
            return b(context);
        }
        if ("email".equals(this.b.o)) {
            return c(context);
        }
        if ("rp".equals(this.b.o)) {
            return d(context);
        }
        return true;
    }

    public boolean b(Context context) {
        if (com.huawei.android.pushselfshow.utils.a.b(context, this.b.z)) {
            return true;
        }
        com.huawei.android.pushselfshow.utils.a.a(context, "4", this.b);
        return false;
    }

    public boolean c(Context context) {
        if (com.huawei.android.pushselfshow.utils.a.d(context)) {
            return true;
        }
        com.huawei.android.pushselfshow.utils.a.a(context, "15", this.b);
        return false;
    }

    public boolean d(Context context) {
        if (this.b.C == null || this.b.C.length() == 0) {
            com.huawei.android.pushselfshow.utils.a.a(context, "6", this.b);
            e.a("PushSelfShowLog", "ilegle richpush param ,rpl is null");
            return false;
        }
        e.a("PushSelfShowLog", "rpl is " + this.b.C);
        if ("application/zip".equals(this.b.E) || this.b.C.endsWith(".zip")) {
            a aVar = this.b;
            aVar.E = "application/zip";
            if (aVar.i == 1) {
                String a2 = new com.huawei.android.pushselfshow.richpush.tools.d().a(context, this.b.C, this.b.j, b.a("application/zip"));
                if (a2 != null && a2.length() > 0) {
                    a aVar2 = this.b;
                    aVar2.C = a2;
                    aVar2.E = "application/zip_local";
                }
                e.a("PushSelfShowLog", "Download first ,the localfile" + a2);
            }
            return true;
        } else if ("text/html".equals(this.b.E) || this.b.C.endsWith(".html")) {
            this.b.E = "text/html";
            return true;
        } else {
            e.a("PushSelfShowLog", "unknow rpl type");
            com.huawei.android.pushselfshow.utils.a.a(context, "6", this.b);
            return false;
        }
    }

    public void run() {
        e.a("PushSelfShowLog", "enter run()");
        try {
            if (a(this.a)) {
                b.a(this.a, this.b);
            }
        } catch (Exception unused) {
        }
        super.run();
    }
}
