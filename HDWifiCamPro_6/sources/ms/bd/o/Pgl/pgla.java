package ms.bd.o.Pgl;

import android.content.Context;

public final class pgla {
    private static final pgla b = new pgla();
    private Context a;

    public static pgla a() {
        return b;
    }

    public void a(Context context) {
        this.a = context != null ? context.getApplicationContext() : null;
    }

    public Context b() {
        return this.a;
    }
}
