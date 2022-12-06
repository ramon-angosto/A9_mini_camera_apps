package sg.bigo.ads.core.player.b;

import android.content.Context;
import android.widget.FrameLayout;
import sg.bigo.ads.core.g.a;

public abstract class c extends FrameLayout {
    private a a;

    public c(Context context) {
        super(context);
    }

    public final void a(String str, int[] iArr) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(str, iArr);
        }
    }

    public void setOnEventListener(a aVar) {
        this.a = aVar;
    }
}
