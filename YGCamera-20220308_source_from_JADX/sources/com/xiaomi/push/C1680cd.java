package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.C1685ci;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.cd */
public class C1680cd extends C1685ci.C1687b<Long> {

    /* renamed from: a */
    private long f1915a = 0;

    /* renamed from: a */
    private String f1916a;

    public C1680cd(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.f1916a = str6;
    }

    /* renamed from: a */
    public static C1680cd m2828a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new C1680cd(str, arrayList, (String) null, (String[]) null, (String) null, (String) null, (String) null, 0, "job to get count of all message");
    }

    /* renamed from: a */
    public Long m2831a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    /* renamed from: a */
    public Object mo17307a() {
        return Long.valueOf(this.f1915a);
    }

    /* renamed from: a */
    public void mo17308a(Context context, List<Long> list) {
        if (context != null && list != null && list.size() > 0) {
            this.f1915a = list.get(0).longValue();
        }
    }
}
