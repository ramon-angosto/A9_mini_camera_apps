package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcmo extends WebChromeClient {
    private final zzcmp zza;

    public zzcmo(zzcmp zzcmp) {
        this.zza = zzcmp;
    }

    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcmp)) {
            return webView.getContext();
        }
        zzcmp zzcmp = (zzcmp) webView;
        Activity zzk = zzcmp.zzk();
        if (zzk != null) {
            return zzk;
        }
        return zzcmp.getContext();
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcmp)) {
            zze.zzj("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzl zzN = ((zzcmp) webView).zzN();
        if (zzN == null) {
            zze.zzj("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzN.zzb();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzcmn.zza[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            zze.zzg(str);
        } else if (i == 2) {
            zze.zzj(str);
        } else if (i == 3 || i == 4) {
            zze.zzi(str);
        } else if (i != 5) {
            zze.zzi(str);
        } else {
            zze.zze(str);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzJ() != null) {
            webView2.setWebViewClient(this.zza.zzJ());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        long j5 = 0;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 <= j4 && j2 <= 1048576) {
                j5 = j2;
            }
        } else if (j2 == 0) {
            j5 = Math.min(j + Math.min(131072, j4), 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j5 = j;
        }
        quotaUpdater.updateQuota(j5);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzt.zzp();
            if (!zzs.zzx(this.zza.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzt.zzp();
                if (!zzs.zzx(this.zza.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        zzl zzN = this.zza.zzN();
        if (zzN == null) {
            zze.zzj("Could not get ad overlay when hiding custom view.");
        } else {
            zzN.zzf();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zzl zzN = this.zza.zzN();
        if (zzN == null) {
            zze.zzj("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzN.zzA(view, customViewCallback);
        zzN.zzy(i);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zzb zzd;
        try {
            zzcmp zzcmp = this.zza;
            if (zzcmp == null || zzcmp.zzP() == null || this.zza.zzP().zzd() == null || (zzd = this.zza.zzP().zzd()) == null || zzd.zzc()) {
                zzt.zzp();
                AlertDialog.Builder zzG = zzs.zzG(context);
                zzG.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    zzG.setView(linearLayout).setPositiveButton(17039370, new zzcmm(jsPromptResult, editText)).setNegativeButton(17039360, new zzcml(jsPromptResult)).setOnCancelListener(new zzcmk(jsPromptResult)).create().show();
                } else {
                    zzG.setMessage(str3).setPositiveButton(17039370, new zzcmj(jsResult)).setNegativeButton(17039360, new zzcmi(jsResult)).setOnCancelListener(new zzcmh(jsResult)).create().show();
                }
                return true;
            }
            zzd.zzb("window." + str + "('" + str3 + "')");
            return false;
        } catch (WindowManager.BadTokenException e) {
            zze.zzk("Fail to display Dialog.", e);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
