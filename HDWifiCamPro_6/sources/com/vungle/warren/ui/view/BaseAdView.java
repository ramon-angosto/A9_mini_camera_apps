package com.vungle.warren.ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import com.vungle.warren.ui.CloseDelegate;
import com.vungle.warren.ui.OrientationDelegate;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.contract.AdContract.AdvertisementPresenter;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.ExternalRouter;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BaseAdView<T extends AdContract.AdvertisementPresenter> implements AdContract.AdView<T> {
    protected final String TAG = getClass().getSimpleName();
    private final CloseDelegate closeDelegate;
    protected final Context context;
    protected Dialog currentDialog;
    protected Handler handler = new Handler(Looper.getMainLooper());
    private final OrientationDelegate orientationDelegate;
    protected final FullAdWidget view;

    public BaseAdView(Context context2, FullAdWidget fullAdWidget, OrientationDelegate orientationDelegate2, CloseDelegate closeDelegate2) {
        this.view = fullAdWidget;
        this.context = context2;
        this.orientationDelegate = orientationDelegate2;
        this.closeDelegate = closeDelegate2;
    }

    public void setOrientation(int i) {
        this.orientationDelegate.setOrientation(i);
    }

    public String getWebsiteUrl() {
        return this.view.getUrl();
    }

    public void close() {
        this.closeDelegate.close();
    }

    public void destroyAdView(long j) {
        this.view.release(j);
    }

    public void showCloseButton() {
        this.view.showCloseButton(true);
    }

    public void open(String str, String str2, ActivityManager.LeftApplicationCallback leftApplicationCallback, PresenterAdOpenCallback presenterAdOpenCallback) {
        String str3 = this.TAG;
        Log.d(str3, "Opening " + str2);
        if (!ExternalRouter.launch(str, str2, this.context, leftApplicationCallback, false, presenterAdOpenCallback)) {
            String str4 = this.TAG;
            Log.e(str4, "Cannot open url " + str2);
        }
    }

    public void showDialog(String str, String str2, String str3, String str4, final DialogInterface.OnClickListener onClickListener) {
        Context context2 = this.context;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context2, context2.getApplicationInfo().theme));
        DialogClickListenerProxy dialogClickListenerProxy = new DialogClickListenerProxy(new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                BaseAdView.this.currentDialog = null;
                DialogInterface.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
            }
        }, getDialogDismissListener());
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setPositiveButton(str3, dialogClickListenerProxy);
        builder.setNegativeButton(str4, dialogClickListenerProxy);
        builder.setCancelable(false);
        this.currentDialog = builder.create();
        dialogClickListenerProxy.autoRelease(this.currentDialog);
        this.currentDialog.show();
    }

    /* access modifiers changed from: protected */
    public DialogInterface.OnDismissListener getDialogDismissListener() {
        return new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                BaseAdView.this.currentDialog = null;
            }
        };
    }

    public void resumeWeb() {
        this.view.resumeWeb();
    }

    public void pauseWeb() {
        this.view.pauseWeb();
    }

    public void setImmersiveMode() {
        this.view.setImmersiveMode();
    }

    public void refreshDialogIfVisible() {
        if (isDialogVisible()) {
            this.currentDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    BaseAdView.this.currentDialog.setOnDismissListener(BaseAdView.this.getDialogDismissListener());
                }
            });
            this.currentDialog.dismiss();
            this.currentDialog.show();
        }
    }

    public boolean isDialogVisible() {
        return this.currentDialog != null;
    }

    private static class DialogClickListenerProxy implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private AtomicReference<DialogInterface.OnClickListener> ckickRef = new AtomicReference<>();
        private AtomicReference<DialogInterface.OnDismissListener> dismissRef = new AtomicReference<>();

        public DialogClickListenerProxy(DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
            this.ckickRef.set(onClickListener);
            this.dismissRef.set(onDismissListener);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.ckickRef.get();
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i);
            }
        }

        /* access modifiers changed from: private */
        public void autoRelease(Dialog dialog) {
            dialog.setOnDismissListener(this);
        }

        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.dismissRef.get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
            this.dismissRef.set((Object) null);
            this.ckickRef.set((Object) null);
        }
    }

    public void removeWebView() {
        this.view.destroyWebView(0);
    }

    public boolean hasWebView() {
        return this.view.hasWebView();
    }
}
