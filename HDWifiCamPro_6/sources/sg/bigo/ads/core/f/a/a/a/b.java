package sg.bigo.ads.core.f.a.a.a;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import sg.bigo.ads.core.f.a;
import sg.bigo.ads.core.f.a.a.d;

public final class b implements sg.bigo.ads.core.f.a.a.b {
    private final Node a;
    private List<d> b;

    public b(Node node) {
        this.a = node;
    }

    public final List<d> a() {
        if (this.b == null) {
            this.b = new ArrayList();
            for (Node dVar : a.c(this.a, "Companion")) {
                this.b.add(new d(dVar));
            }
        }
        return this.b;
    }
}
