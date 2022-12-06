package com.huawei.hms.p023ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.ui.AbstractDialog */
public abstract class AbstractDialog {

    /* renamed from: a */
    public Activity f991a;

    /* renamed from: b */
    public AlertDialog f992b;

    /* renamed from: c */
    public Callback f993c;

    /* renamed from: com.huawei.hms.ui.AbstractDialog$Callback */
    public interface Callback {
        void onCancel(AbstractDialog abstractDialog);

        void onDoWork(AbstractDialog abstractDialog);
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$a */
    public class C0918a implements DialogInterface.OnClickListener {
        public C0918a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractDialog.this.fireDoWork();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$b */
    public class C0919b implements DialogInterface.OnClickListener {
        public C0919b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractDialog.this.cancel();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$c */
    public class C0920c implements DialogInterface.OnCancelListener {
        public C0920c() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            AbstractDialog.this.fireCancel();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$d */
    public class C0921d implements DialogInterface.OnKeyListener {
        public C0921d() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (4 != i || keyEvent.getAction() != 1) {
                return false;
            }
            AbstractDialog.this.cancel();
            return true;
        }
    }

    /* renamed from: a */
    public static int m1382a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", (String) null, (String) null);
    }

    public void cancel() {
        AlertDialog alertDialog = this.f992b;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.f992b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void fireCancel() {
        Callback callback = this.f993c;
        if (callback != null) {
            callback.onCancel(this);
        }
    }

    public void fireDoWork() {
        Callback callback = this.f993c;
        if (callback != null) {
            callback.onDoWork(this);
        }
    }

    public Activity getActivity() {
        return this.f991a;
    }

    public int getDialogThemeId() {
        return (m1382a(this.f991a) == 0 || Build.VERSION.SDK_INT < 16) ? 3 : 0;
    }

    public AlertDialog onCreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), getDialogThemeId());
        String onGetTitleString = onGetTitleString(activity);
        if (onGetTitleString != null) {
            builder.setTitle(onGetTitleString);
        }
        String onGetMessageString = onGetMessageString(activity);
        if (onGetMessageString != null) {
            builder.setMessage(onGetMessageString);
        }
        String onGetPositiveButtonString = onGetPositiveButtonString(activity);
        if (onGetPositiveButtonString != null) {
            builder.setPositiveButton(onGetPositiveButtonString, new C0918a());
        }
        String onGetNegativeButtonString = onGetNegativeButtonString(activity);
        if (onGetNegativeButtonString != null) {
            builder.setNegativeButton(onGetNegativeButtonString, new C0919b());
        }
        return builder.create();
    }

    public abstract String onGetMessageString(Context context);

    public abstract String onGetNegativeButtonString(Context context);

    public abstract String onGetPositiveButtonString(Context context);

    public abstract String onGetTitleString(Context context);

    public void setMessage(CharSequence charSequence) {
        AlertDialog alertDialog = this.f992b;
        if (alertDialog != null) {
            alertDialog.setMessage(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        AlertDialog alertDialog = this.f992b;
        if (alertDialog != null) {
            alertDialog.setTitle(charSequence);
        }
    }

    public void show(Activity activity, Callback callback) {
        this.f991a = activity;
        this.f993c = callback;
        Activity activity2 = this.f991a;
        if (activity2 == null || activity2.isFinishing()) {
            HMSLog.m1377e("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        this.f992b = onCreateDialog(this.f991a);
        this.f992b.setCanceledOnTouchOutside(false);
        this.f992b.setOnCancelListener(new C0920c());
        this.f992b.setOnKeyListener(new C0921d());
        this.f992b.show();
    }
}
