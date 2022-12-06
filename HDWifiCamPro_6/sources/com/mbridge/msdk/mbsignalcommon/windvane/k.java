package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.q;

/* compiled from: WindVaneWebViewChromeClient */
public final class k extends WebChromeClient {
    WindVaneWebView a;
    private d b;

    public k(WindVaneWebView windVaneWebView) {
        this.a = windVaneWebView;
    }

    public final void a(d dVar) {
        this.b = dVar;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        q.d("H5_ENTRY", str2 + "");
        c signalCommunication = this.a.getSignalCommunication();
        if (signalCommunication == null || str3 == null || !signalCommunication.a(str3)) {
            return false;
        }
        signalCommunication.b(str2);
        jsPromptResult.confirm("");
        return true;
    }

    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(webView, i);
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        c signalCommunication = this.a.getSignalCommunication();
        if (!(signalCommunication == null || consoleMessage == null)) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message) || !message.startsWith("mv://")) {
                return false;
            }
            q.a("H5_ENTRY", "onConsoleMessage: message.length() = " + message.length() + " " + message);
            if (message.contains("wv_hybrid:") && signalCommunication.a("wv_hybrid:")) {
                String substring = message.substring(0, message.lastIndexOf(" ") + 1);
                q.a("H5_ENTRY", "message = " + substring);
                signalCommunication.b(substring);
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
