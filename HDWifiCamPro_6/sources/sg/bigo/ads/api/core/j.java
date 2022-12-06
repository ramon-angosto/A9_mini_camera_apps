package sg.bigo.ads.api.core;

import android.os.Parcel;
import android.text.TextUtils;
import org.json.JSONObject;
import sg.bigo.ads.api.a.c;
import sg.bigo.ads.common.utils.o;

public final class j implements c {
    private int a = 2;
    private int b = 3;
    private int c = 5;

    public final void a(Parcel parcel) {
        parcel.writeString(this.a + "," + this.b + "," + this.c);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt("id_show_loading", 2);
            this.b = jSONObject.optInt("loading_timeout", 3);
            this.c = jSONObject.optInt("material_show_close_button", 5);
        }
    }

    public final boolean a() {
        return this.a == 2;
    }

    public final int b() {
        return this.b;
    }

    public final void b(Parcel parcel) {
        String[] split;
        if (parcel.dataAvail() > 0) {
            String readString = parcel.readString();
            if (!TextUtils.isEmpty(readString) && (split = readString.split(",")) != null && split.length == 3) {
                this.a = o.a(split[0], 2);
                this.b = o.a(split[1], 3);
                this.c = o.a(split[2], 5);
            }
        }
    }

    public final int c() {
        return this.c;
    }
}
