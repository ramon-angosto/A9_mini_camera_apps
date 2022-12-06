package com.mbridge.msdk.foundation.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.fragment.BaseFragment;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.NativeListener;

public class WebViewFragment extends BaseFragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BrowserView browserView = new BrowserView(getActivity());
        browserView.loadUrl(getActivity().getIntent().getExtras().getString(NotificationCompat.CATEGORY_MESSAGE));
        browserView.setListener(new BrowserView.a() {
            public final boolean a(WebView webView, String str) {
                return false;
            }

            public final void a() {
                WebViewFragment.this.getActivity().finish();
            }

            public final void a(WebView webView, String str, Bitmap bitmap) {
                if (t.a.a(str) && t.a.a(WebViewFragment.this.getActivity().getApplicationContext(), str, (NativeListener.NativeTrackingListener) null)) {
                    WebViewFragment.this.getActivity().finish();
                }
            }
        });
        return browserView;
    }
}
