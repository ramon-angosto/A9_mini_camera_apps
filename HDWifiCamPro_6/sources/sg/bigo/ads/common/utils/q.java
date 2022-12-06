package sg.bigo.ads.common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Window;
import android.widget.ProgressBar;

public final class q {
    public static void a(Context context, ProgressBar progressBar, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
            indeterminateDrawable.setTint(context.getResources().getColor(17170443));
            progressBar.setIndeterminateDrawable(indeterminateDrawable);
            return;
        }
        progressBar.setIndeterminateDrawable(context.getResources().getDrawable(i));
    }

    public static void a(Window window) {
        window.getDecorView().setSystemUiVisibility(5894);
    }
}
