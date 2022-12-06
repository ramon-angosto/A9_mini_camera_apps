package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.push.cc */
public class C1679cc extends C1681ce {
    public C1679cc(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    /* renamed from: a */
    public static C1679cc m2825a(Context context, String str, int i) {
        C1524b.m2158b("delete  messages when db size is too bigger");
        String a = C1685ci.m2838a(context).mo17311a(str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new C1679cc(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    /* renamed from: a */
    private void m2826a(long j) {
        if (this.f1942a != null && this.f1942a.length > 0) {
            this.f1942a[0] = String.valueOf(j);
        }
    }

    /* renamed from: a */
    public void mo17305a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = C1696co.m2870a(mo17307a());
            long j = C1677ca.f1911a;
            if (a > j) {
                double d = (double) (a - j);
                Double.isNaN(d);
                double d2 = (double) j;
                Double.isNaN(d2);
                double d3 = (double) longValue;
                Double.isNaN(d3);
                long j2 = (long) (((d * 1.2d) / d2) * d3);
                m2826a(j2);
                C1671bw a2 = C1671bw.m2760a(context);
                a2.mo17273a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
                super.mo17305a(context, obj);
                return;
            }
            C1524b.m2158b("db size is suitable");
        }
    }
}
