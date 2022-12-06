package sg.bigo.ads.core.f.a;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public final class m {
    Document a;

    public final List<d> a() {
        ArrayList arrayList = new ArrayList();
        Document document = this.a;
        if (document == null) {
            return arrayList;
        }
        NodeList elementsByTagName = document.getElementsByTagName("Ad");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new d(elementsByTagName.item(i)));
        }
        return arrayList;
    }
}
