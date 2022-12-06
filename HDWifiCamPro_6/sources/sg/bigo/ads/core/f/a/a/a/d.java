package sg.bigo.ads.core.f.a.a.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Node;
import sg.bigo.ads.common.utils.j;
import sg.bigo.ads.core.f.a;
import sg.bigo.ads.core.f.a.a.c;
import sg.bigo.ads.core.f.a.a.g;

public final class d implements sg.bigo.ads.core.f.a.a.d {
    private final Node a;
    private final String b = a.e(this.a, "id");
    private final int c = a.d(this.a, "width").intValue();
    private final int d = a.d(this.a, "height").intValue();
    private final List<g> e = new ArrayList();
    private final List<String> f = new ArrayList();
    private String g;
    private sg.bigo.ads.core.f.a.a.a h;
    private String i;
    private final List<c> j = new ArrayList();

    public d(Node node) {
        this.a = node;
        g();
    }

    private void g() {
        List<Node> b2 = a.b(this.a, "StaticResource", (String) null, (List<String>) null);
        if (!j.a(b2)) {
            for (Node next : b2) {
                this.e.add(new g(a.e(next, "creativeType"), a.a(next)));
            }
        }
        List<Node> b3 = a.b(this.a, "IFrameResource", (String) null, (List<String>) null);
        if (!j.a(b3)) {
            for (Node b4 : b3) {
                this.e.add(new f(a.b(b4)));
            }
        }
        List<Node> b5 = a.b(this.a, "HTMLResource", (String) null, (List<String>) null);
        if (!j.a(b5)) {
            for (Node b6 : b5) {
                this.e.add(new e(a.b(b6)));
            }
        }
        Node a2 = a.a(this.a, "AltText", (String) null, (List<String>) null);
        if (a2 != null) {
            this.g = a.b(a2);
        }
        Node a3 = a.a(this.a, "AdParameters", (String) null, (List<String>) null);
        if (a3 != null) {
            this.h = new a(TextUtils.equals(a.e(a3, "xmlEncoded"), "true"), a.b(a3));
        }
        Node a4 = a.a(this.a, "CompanionClickThrough", (String) null, (List<String>) null);
        if (a4 != null) {
            this.i = a.a(a4);
        }
        List<Node> b7 = a.b(this.a, "CompanionClickTracking", (String) null, (List<String>) null);
        if (!j.a(b7)) {
            for (Node next2 : b7) {
                this.j.add(new c(a.e(next2, "id"), a.a(next2)));
            }
        }
        Node a5 = a.a(this.a, "TrackingEvents", (String) null, (List<String>) null);
        if (a5 != null) {
            List<Node> b8 = a.b(a5, "Tracking", NotificationCompat.CATEGORY_EVENT, Arrays.asList(new String[]{"creativeView"}));
            if (!j.a(b8)) {
                for (Node a6 : b8) {
                    String a7 = a.a(a6);
                    if (!TextUtils.isEmpty(a7)) {
                        this.f.add(a7);
                    }
                }
            }
        }
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final List<g> c() {
        return this.e;
    }

    public final String d() {
        return this.i;
    }

    public final List<c> e() {
        return this.j;
    }

    public final List<String> f() {
        return this.f;
    }
}
