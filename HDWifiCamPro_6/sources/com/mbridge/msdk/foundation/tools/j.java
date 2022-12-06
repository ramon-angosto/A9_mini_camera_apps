package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.report.d;
import java.lang.reflect.Method;

/* compiled from: MiaUtil */
public class j {
    public static void mia(Context context, String str) {
        String str2 = null;
        try {
            Object invoke = context.getClass().getMethod(l.b("HF5TNFK/J75/JczQhFKsJr5B"), (Class[]) null).invoke(context, (Object[]) null);
            if (invoke != null) {
                Method method = invoke.getClass().getMethod(l.b("HF5T5dQMHN=="), new Class[]{Uri.class});
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append(l.b("DFK/J75/JaEXWFfXYZPsD+utH7j/DkP3hrKuHoP7hrQQYrxNhrKFLkxQhl==" + "ybfXJ+zUHnT="));
                if (TextUtils.isEmpty(str)) {
                    str = l.b("n+xg");
                }
                sb.append(str);
                objArr[0] = Uri.parse(sb.toString());
                str2 = (String) method.invoke(invoke, objArr);
            }
        } catch (Throwable th) {
            q.d("MiaUtil", th.getMessage());
        }
        d.b(str2);
    }
}
