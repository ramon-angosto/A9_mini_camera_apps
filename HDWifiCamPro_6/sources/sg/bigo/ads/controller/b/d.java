package sg.bigo.ads.controller.b;

import android.content.Context;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.common.c;
import sg.bigo.ads.common.d;
import sg.bigo.ads.common.h;

public final class d extends c {
    public Map<String, e> a;

    public d(Context context) {
        super(context);
    }

    public final void a(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        Map<String, e> map = this.a;
        if (map != null) {
            arrayList.addAll(map.values());
        }
        h.a(parcel, arrayList);
    }

    public final void a(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            e eVar = new e();
            if (eVar.a(optJSONObject)) {
                hashMap.put(eVar.a, eVar);
            }
        }
        this.a = hashMap;
    }

    public final String a_() {
        return "bigoad_slots.dat";
    }

    public final String b() {
        return "SlotData";
    }

    public final void b(Parcel parcel) {
        List<e> a2 = h.a(parcel, new d.a<e>() {
            public final /* synthetic */ sg.bigo.ads.common.d a() {
                return new e();
            }
        });
        HashMap hashMap = new HashMap();
        for (e eVar : a2) {
            hashMap.put(eVar.a, eVar);
        }
        this.a = hashMap;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Map<String, e> map = this.a;
        if (map != null) {
            for (g next : map.values()) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(next);
            }
        }
        return "SlotData[" + sb.toString() + ']';
    }
}
