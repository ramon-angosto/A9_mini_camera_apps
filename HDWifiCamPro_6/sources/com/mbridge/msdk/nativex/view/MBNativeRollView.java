package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

public class MBNativeRollView extends LinearLayout {
    private RollingBCView a;
    private Context b;
    private NativeListener.FilpListener c;

    public interface a {
        View a(Frame frame, int i);
    }

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        if (filpListener != null) {
            this.c = filpListener;
            this.a.setFilpListening(filpListener);
        }
    }

    public MBNativeRollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MBNativeRollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        this.a = new RollingBCView(context);
        addView(this.a);
        this.a.setLayoutParams(new LinearLayout.LayoutParams((int) (((double) u.f(context)) * 0.9d), -2));
        setClipChildren(false);
    }

    public MBNativeRollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setData(List<Frame> list, Context context, String str, a aVar) {
        this.a.setData(list, context, str, aVar);
    }

    public void setFrameWidth(int i) {
        this.a.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a.dispatchTouchEvent(motionEvent);
    }
}
