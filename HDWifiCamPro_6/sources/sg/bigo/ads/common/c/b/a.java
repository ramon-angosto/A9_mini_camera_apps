package sg.bigo.ads.common.c.b;

import android.database.Cursor;

public class a {
    public long a = -1;
    public String b;
    public String c;
    public int d;
    public String e;
    public long f;
    public long g;

    public a(Cursor cursor) {
        this.a = cursor.getLong(cursor.getColumnIndex("_id"));
        this.b = cursor.getString(cursor.getColumnIndex("event_action"));
        this.c = cursor.getString(cursor.getColumnIndex("event_info"));
        this.d = cursor.getInt(cursor.getColumnIndex("states"));
        this.e = cursor.getString(cursor.getColumnIndex("ext"));
        this.f = cursor.getLong(cursor.getColumnIndex("ctime"));
        this.g = cursor.getLong(cursor.getColumnIndex("mtime"));
    }

    public a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.b = str;
        this.c = str2;
        this.d = 0;
        this.e = "";
        this.f = currentTimeMillis;
        this.g = currentTimeMillis;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        long j = this.a;
        return j >= 0 && j == ((a) obj).a;
    }

    public String toString() {
        return "mId = " + this.a + ",eventInfo=" + this.c;
    }
}
