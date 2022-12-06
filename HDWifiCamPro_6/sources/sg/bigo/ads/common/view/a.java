package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class a extends ImageView {
    public final sg.bigo.ads.common.h.a a;

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b) {
        this(context, 0);
    }

    private a(Context context, char c) {
        super(context, (AttributeSet) null, -1);
        this.a = new sg.bigo.ads.common.h.a(this);
    }

    public final void setImageURI(String str) {
        this.a.a(str);
    }
}
