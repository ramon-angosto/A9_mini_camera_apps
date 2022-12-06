package com.vungle.warren.ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import com.vungle.warren.NativeAdLayout;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.contract.NativeAdContract;
import com.vungle.warren.ui.presenter.NativeAdPresenter;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.ExternalRouter;
import java.util.concurrent.atomic.AtomicReference;

public class NativeAdView implements NativeAdContract.NativeView, NativeAdLayout.OnItemClickListener {
    private static final String TAG = NativeAdView.class.getSimpleName();
    private final Context context;
    /* access modifiers changed from: private */
    public Dialog currentDialog;
    private NativeAdContract.NativePresenter presenter;
    private final NativeAdLayout view;

    public void close() {
    }

    public String getWebsiteUrl() {
        return null;
    }

    public boolean hasWebView() {
        return false;
    }

    public void pauseWeb() {
    }

    public void removeWebView() {
    }

    public void resumeWeb() {
    }

    public void setImmersiveMode() {
    }

    public void setOrientation(int i) {
    }

    public void showCloseButton() {
    }

    public void showWebsite(String str) {
    }

    public NativeAdView(Context context2, NativeAdLayout nativeAdLayout) {
        this.context = context2;
        this.view = nativeAdLayout;
        nativeAdLayout.setOnItemClickListener(this);
    }

    public void setPresenter(NativeAdPresenter nativeAdPresenter) {
        this.presenter = nativeAdPresenter;
    }

    public void open(String str, String str2, ActivityManager.LeftApplicationCallback leftApplicationCallback, PresenterAdOpenCallback presenterAdOpenCallback) {
        if (!ExternalRouter.launch(str, str2, this.context, leftApplicationCallback, true, presenterAdOpenCallback)) {
            String str3 = TAG;
            Log.e(str3, "Cannot open url " + str2);
        }
    }

    public void showDialog(String str, String str2, String str3, String str4, final DialogInterface.OnClickListener onClickListener) {
        Context context2 = this.context;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context2, context2.getApplicationInfo().theme));
        DialogClickListenerProxy dialogClickListenerProxy = new DialogClickListenerProxy(new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Dialog unused = NativeAdView.this.currentDialog = null;
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

    private static class DialogClickListenerProxy implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private final AtomicReference<DialogInterface.OnClickListener> ckickRef = new AtomicReference<>();
        private final AtomicReference<DialogInterface.OnDismissListener> dismissRef = new AtomicReference<>();

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

    /* access modifiers changed from: protected */
    public DialogInterface.OnDismissListener getDialogDismissListener() {
        return new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                Dialog unused = NativeAdView.this.currentDialog = null;
            }
        };
    }

    public void destroyAdView(long j) {
        this.view.release();
    }

    public void refreshDialogIfVisible() {
        if (isDialogVisible()) {
            this.currentDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    NativeAdView.this.currentDialog.setOnDismissListener(NativeAdView.this.getDialogDismissListener());
                }
            });
            this.currentDialog.dismiss();
            this.currentDialog.show();
        }
    }

    public boolean isDialogVisible() {
        return this.currentDialog != null;
    }

    public void onItemClicked(int i) {
        if (i == 1) {
            this.presenter.onDownload();
        } else if (i == 2) {
            this.presenter.onPrivacy();
        }
    }
}
