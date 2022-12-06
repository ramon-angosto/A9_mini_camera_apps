package com.apm.insight.j;

import android.content.Context;
import android.os.Handler;
import com.apm.insight.l.a;
import com.apm.insight.l.q;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private List<a> a = new ArrayList(3);

    private d(Handler handler, Context context) {
        if (a.b(context)) {
            this.a.add(new c(handler, 0, 15000));
        }
    }

    public static d a(Handler handler, Context context) {
        return new d(handler, context);
    }

    public void a() {
        q.a((Object) "[ScheduleTaskManager] execute, task size=" + this.a.size());
        for (a a2 : this.a) {
            try {
                a2.a();
            } catch (Throwable unused) {
            }
        }
    }
}
