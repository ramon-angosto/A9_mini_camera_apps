package sg.bigo.ads.core.e.a;

import java.util.Arrays;
import java.util.Map;
import sg.bigo.ads.api.core.o;

public final class a extends b {
    public a(o oVar, d[] dVarArr, d[] dVarArr2, d[] dVarArr3, d[] dVarArr4, Map<String, String> map) {
        super(oVar);
        this.a.addAll(Arrays.asList(dVarArr));
        this.b.addAll(Arrays.asList(dVarArr2));
        this.c.addAll(Arrays.asList(dVarArr3));
        this.d.addAll(Arrays.asList(dVarArr4));
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (!(str == null || str2 == null)) {
                this.g.put(str, str2);
            }
        }
    }
}
