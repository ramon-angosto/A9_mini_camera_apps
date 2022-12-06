package sg.bigo.ads.common.c.b;

import android.database.Cursor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.i;

public abstract class c {
    public long a = -1;
    public boolean b = false;
    public int c = 0;
    public long d = 0;
    public String e = "";
    public long f;
    public long g;
    public Map<String, String> h;

    public c(Cursor cursor) {
        this.a = cursor.getLong(cursor.getColumnIndex("_id"));
        try {
            this.h = i.a(new JSONObject(cursor.getString(cursor.getColumnIndex("ad_data"))));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(cursor.getString(cursor.getColumnIndex("tracker_imp")));
        b(cursor.getString(cursor.getColumnIndex("tracker_cli")));
        c(cursor.getString(cursor.getColumnIndex("tracker_nurl")));
        d(cursor.getString(cursor.getColumnIndex("tracker_lurl")));
        this.c = cursor.getInt(cursor.getColumnIndex("tracker_type"));
        this.d = cursor.getLong(cursor.getColumnIndex("last_retry_ts"));
        this.e = cursor.getString(cursor.getColumnIndex("ext"));
        this.f = cursor.getLong(cursor.getColumnIndex("ctime"));
        this.g = cursor.getLong(cursor.getColumnIndex("mtime"));
        this.b = true;
    }

    public c(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis();
        this.h = map;
        this.f = currentTimeMillis;
        this.g = currentTimeMillis;
    }

    public final String a() {
        Map<String, String> map = this.h;
        if (map == null) {
            return "";
        }
        if ((map instanceof HashMap) && map != null) {
            map.remove((Object) null);
            map.values().removeAll(Collections.singleton((Object) null));
        }
        return new JSONObject(this.h).toString();
    }

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    public abstract String b();

    /* access modifiers changed from: protected */
    public abstract void b(String str);

    public abstract String c();

    /* access modifiers changed from: protected */
    public abstract void c(String str);

    public abstract String d();

    /* access modifiers changed from: protected */
    public abstract void d(String str);

    public abstract String e();

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != c.class) {
            return false;
        }
        long j = this.a;
        return j >= 0 && j == ((c) obj).a;
    }

    public long f() {
        return 0;
    }

    public String toString() {
        return "mId = " + this.a;
    }
}
