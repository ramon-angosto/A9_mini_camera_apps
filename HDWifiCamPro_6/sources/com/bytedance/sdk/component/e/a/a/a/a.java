package com.bytedance.sdk.component.e.a.a.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.a.a.b;

/* compiled from: DBAdapter */
public class a extends b {
    private static volatile a a;

    public /* bridge */ /* synthetic */ b.C0033b a() {
        return super.a();
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private a(Context context) {
        super(context);
    }
}
