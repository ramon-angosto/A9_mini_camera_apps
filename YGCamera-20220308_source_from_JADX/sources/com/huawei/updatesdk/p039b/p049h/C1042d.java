package com.huawei.updatesdk.p039b.p049h;

import android.content.Context;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.h.d */
public class C1042d {
    /* renamed from: a */
    public static int m1972a(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        double d = (double) j;
        double d2 = (double) j2;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.min((int) Math.round((d / d2) * 100.0d), 100);
    }

    /* renamed from: a */
    public static String m1973a(int i) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        double d = (double) i;
        Double.isNaN(d);
        percentInstance.setMinimumFractionDigits(0);
        return percentInstance.format(d / 100.0d);
    }

    /* renamed from: a */
    public static String m1974a(Context context, long j) {
        if (j == 0) {
            return context.getString(C1041c.m1970c(context, "upsdk_storage_utils"), new Object[]{"0"});
        }
        DecimalFormat decimalFormat = null;
        if (j > 104857) {
            decimalFormat = new DecimalFormat("###.#");
        } else if (j > 10485) {
            decimalFormat = new DecimalFormat("###.##");
        }
        if (decimalFormat != null) {
            double d = (double) j;
            Double.isNaN(d);
            return context.getString(C1041c.m1970c(context, "upsdk_storage_utils"), new Object[]{decimalFormat.format(d / 1048576.0d)});
        }
        return context.getString(C1041c.m1970c(context, "upsdk_storage_utils"), new Object[]{"0.01"});
    }

    /* renamed from: a */
    public static boolean m1975a(List list) {
        return list == null || list.size() <= 0;
    }
}
