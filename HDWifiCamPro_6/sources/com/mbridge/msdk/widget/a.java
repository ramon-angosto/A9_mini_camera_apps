package com.mbridge.msdk.widget;

import android.view.View;
import java.util.Calendar;

/* compiled from: MBridgeNoDoubleClick */
public abstract class a implements View.OnClickListener {
    private long a = 0;

    /* access modifiers changed from: protected */
    public abstract void a(View view);

    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.a > 2000) {
            this.a = timeInMillis;
            a(view);
        }
    }
}
