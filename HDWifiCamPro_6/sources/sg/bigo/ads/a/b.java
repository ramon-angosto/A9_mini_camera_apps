package sg.bigo.ads.a;

import android.content.Context;
import androidx.browser.customtabs.CustomTabsClient;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import sg.bigo.ads.a.a.a;
import sg.bigo.ads.a.a.b;
import sg.bigo.ads.a.a.c;

final class b implements a.C0110a {
    private static final b c = new b();
    /* access modifiers changed from: package-private */
    public final a a = new a();
    final Set<String> b = new LinkedHashSet();
    private final int d = 300000;
    private final int e = 200;
    /* access modifiers changed from: private */
    public final HashMap<String, Long> f = new HashMap<>();
    private int g = 0;
    private boolean h = false;
    private boolean i = false;
    private boolean j = true;
    private boolean k = false;

    b() {
    }

    static /* synthetic */ String a(int i2) {
        switch (i2) {
            case 1:
                return "Navigation Started";
            case 2:
                return "Navigation Finished";
            case 3:
                return "Navigation Failed";
            case 4:
                return "Navigation Aborted";
            case 5:
                return "Tab Shown";
            case 6:
                return "Tab Hidden";
            default:
                return "Unknown Event";
        }
    }

    public static b a() {
        return c;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r8 = this;
            boolean r0 = r8.i
            r1 = 0
            if (r0 != 0) goto L_0x0008
            r8.k = r1
            return
        L_0x0008:
            boolean r0 = r8.k
            r2 = 3
            java.lang.String r3 = "ChromeTabsStatic"
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = "The task of preload start."
            sg.bigo.ads.common.k.a.a(r1, r2, r3, r0)
        L_0x0014:
            r0 = 0
            r4 = 1
            java.util.Set<java.lang.String> r5 = r8.b     // Catch:{ Exception -> 0x003e }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x003e }
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x003e }
            if (r6 != 0) goto L_0x002a
            java.lang.String r5 = "The task of preload stop."
            sg.bigo.ads.common.k.a.a(r1, r2, r3, r5)     // Catch:{ Exception -> 0x003e }
            r8.k = r1     // Catch:{ Exception -> 0x003e }
            return
        L_0x002a:
            r8.k = r4     // Catch:{ Exception -> 0x003e }
            java.lang.Object r1 = r5.next()     // Catch:{ Exception -> 0x003e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x003e }
            java.util.Set<java.lang.String> r0 = r8.b     // Catch:{ Exception -> 0x0039 }
            r0.remove(r1)     // Catch:{ Exception -> 0x0039 }
            r0 = r1
            goto L_0x0042
        L_0x0039:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x003f
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            r1.printStackTrace()
        L_0x0042:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0050
            sg.bigo.ads.a.b$3 r1 = new sg.bigo.ads.a.b$3
            r1.<init>(r0)
            sg.bigo.ads.common.f.c.a(r4, r1)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.a.b.e():void");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Context context) {
        boolean z;
        String str;
        if (!this.j) {
            sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Chrome service is unavailable.");
            return false;
        }
        if (this.i) {
            str = "Chrome service connected";
        } else if (this.h) {
            str = "Chrome service connect trying.";
        } else {
            this.h = true;
            a aVar = this.a;
            aVar.c = this;
            if (aVar.a != null) {
                z = true;
            } else {
                b.a a2 = sg.bigo.ads.a.a.b.a(context);
                if (a2 == null || !a2.a) {
                    z = false;
                } else {
                    aVar.b = new c(aVar);
                    z = CustomTabsClient.bindCustomTabsService(context, a2.e, aVar.b);
                }
            }
            if (!z) {
                this.h = false;
                int i2 = this.g;
                this.g = i2 + 1;
                if (i2 < 3) {
                    this.j = false;
                }
            }
            return z;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", str);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (!this.k) {
            e();
        }
    }

    public final void c() {
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs service connected.");
        this.i = true;
        this.h = false;
        b();
    }

    public final void d() {
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs service disconnected.");
        this.i = false;
        this.h = false;
    }
}
