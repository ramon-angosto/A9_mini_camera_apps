package sg.bigo.ads.core.h;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.d.a;

public class e extends WebView {
    protected boolean e;

    e(Context context) {
        super(context);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
    }

    public static e a(Context context) {
        try {
            return new e(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            a.a((c) null, (int) PathInterpolatorCompat.MAX_NUM_POINTS, 10100, Log.getStackTraceString(e2));
            return null;
        }
    }

    public void destroy() {
        if (!this.e) {
            this.e = true;
            stopLoading();
            s.a(this);
            removeAllViews();
            setWebChromeClient((WebChromeClient) null);
            setWebViewClient((WebViewClient) null);
            super.destroy();
        }
    }
}
