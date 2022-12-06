package sg.bigo.ads.api.core;

import android.os.Parcel;
import android.text.TextUtils;
import org.json.JSONObject;
import sg.bigo.ads.api.a.j;
import sg.bigo.ads.common.utils.o;

public final class q implements j {
    private int a = 0;

    public final void a(Parcel parcel) {
        parcel.writeString(String.valueOf(this.a));
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt("ll_on", 0);
        }
    }

    public final boolean a() {
        return this.a == 1;
    }

    public final void b(Parcel parcel) {
        if (parcel.dataAvail() > 0) {
            String readString = parcel.readString();
            if (!TextUtils.isEmpty(readString)) {
                String[] split = readString.split(",");
                if (split.length > 0) {
                    this.a = o.a(split[0], 0);
                }
            }
        }
    }
}
