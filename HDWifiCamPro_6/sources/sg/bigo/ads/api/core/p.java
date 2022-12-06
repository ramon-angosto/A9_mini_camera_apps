package sg.bigo.ads.api.core;

import android.os.Parcel;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import org.json.JSONObject;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.utils.o;

public final class p implements i {
    private int a = 0;
    private long b = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    private long c = 21600000;

    public final void a(Parcel parcel) {
        parcel.writeString(this.a + "," + this.b + "," + this.c);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt("duration_on", 0);
            this.b = jSONObject.optLong("duration_valid_interval", DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            this.c = jSONObject.optLong("suspend_limit", 21600000);
        }
    }

    public final boolean a() {
        return this.a == 1;
    }

    public final long b() {
        return this.b;
    }

    public final void b(Parcel parcel) {
        if (parcel.dataAvail() > 0) {
            String readString = parcel.readString();
            if (!TextUtils.isEmpty(readString)) {
                String[] split = readString.split(",");
                if (split.length >= 3) {
                    this.a = o.a(split[0], 0);
                    this.b = o.a(split[1], (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                    this.c = o.a(split[2], 21600000);
                }
            }
        }
    }

    public final long c() {
        return this.c;
    }
}
