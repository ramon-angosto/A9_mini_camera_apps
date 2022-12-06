package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;

public class ErrDlgFragmentForSupport extends DialogFragment {
    private DialogInterface.OnCancelListener listener = null;
    private Dialog log = null;

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog) {
        return newInstance(dialog, (DialogInterface.OnCancelListener) null);
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.listener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.log == null) {
            setShowsDialog(false);
        }
        return this.log;
    }

    public void show(FragmentManager fragmentManager, String str) {
        Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrDlgFragmentForSupport errDlgFragmentForSupport = new ErrDlgFragmentForSupport();
        errDlgFragmentForSupport.log = dialog;
        errDlgFragmentForSupport.log.setOnCancelListener((DialogInterface.OnCancelListener) null);
        errDlgFragmentForSupport.log.setOnDismissListener((DialogInterface.OnDismissListener) null);
        errDlgFragmentForSupport.listener = onCancelListener;
        return errDlgFragmentForSupport;
    }
}
