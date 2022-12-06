package com.mbridge.msdk.foundation.same.net.h;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONObject;

/* compiled from: CommonMBListener */
public abstract class c extends f<JSONObject> {
    public abstract void a(String str);

    public abstract void a(JSONObject jSONObject);

    public final void a(k<JSONObject> kVar) {
        if (kVar != null) {
            int optInt = ((JSONObject) kVar.a).optInt("status");
            if (optInt == 1 || optInt == 200) {
                a(((JSONObject) kVar.a).optJSONObject(DataSchemeDataSource.SCHEME_DATA));
            } else {
                a(((JSONObject) kVar.a).optString(NotificationCompat.CATEGORY_MESSAGE));
            }
        }
    }

    public final void a(a aVar) {
        a(com.mbridge.msdk.foundation.same.net.g.a.a(aVar.a));
    }
}
