package sg.bigo.ads.controller.i;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.l.c.d;
import sg.bigo.ads.common.utils.p;

public final class a extends d {
    public int c;
    public String d;
    public Map<String, Object> e;
    private String f;

    public a(sg.bigo.ads.common.l.c.a aVar) {
        super(aVar);
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.f = jSONObject.optString(DataSchemeDataSource.SCHEME_DATA);
            this.c = jSONObject.optInt("code");
            this.d = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
            p.a((long) jSONObject.optInt("timestamp", 0));
            this.e = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.equals(DataSchemeDataSource.SCHEME_DATA, next) && !TextUtils.equals("code", next) && !TextUtils.equals(NotificationCompat.CATEGORY_MESSAGE, next)) {
                    this.e.put(next, jSONObject.opt(next));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f = "";
            this.c = 1005;
            this.d = "Invalid response.";
        }
    }

    public final String a() {
        return this.f;
    }
}
