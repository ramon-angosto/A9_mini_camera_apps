package com.huawei.updatesdk.p039b.p050i;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import com.huawei.updatesdk.p039b.p049h.C1036a;
import com.huawei.updatesdk.p039b.p049h.C1041c;

/* renamed from: com.huawei.updatesdk.b.i.a */
public class C1043a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1050b f1411a;

    /* renamed from: b */
    private Context f1412b;

    /* renamed from: c */
    private String f1413c;

    /* renamed from: d */
    private CharSequence f1414d;

    /* renamed from: e */
    private AlertDialog f1415e;

    /* renamed from: f */
    private AlertDialog.Builder f1416f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DialogInterface.OnShowListener f1417g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public DialogInterface.OnDismissListener f1418h;

    /* renamed from: com.huawei.updatesdk.b.i.a$a */
    class C1044a implements DialogInterface.OnShowListener {

        /* renamed from: com.huawei.updatesdk.b.i.a$a$a */
        class C1045a implements View.OnClickListener {
            C1045a() {
            }

            public void onClick(View view) {
                if (C1043a.this.f1411a != null) {
                    C1043a.this.f1411a.mo15030a();
                }
            }
        }

        /* renamed from: com.huawei.updatesdk.b.i.a$a$b */
        class C1046b implements View.OnClickListener {
            C1046b() {
            }

            public void onClick(View view) {
                if (C1043a.this.f1411a != null) {
                    C1043a.this.f1411a.mo15031b();
                }
            }
        }

        C1044a() {
        }

        public void onShow(DialogInterface dialogInterface) {
            AlertDialog alertDialog = (AlertDialog) dialogInterface;
            alertDialog.getButton(-1).setOnClickListener(new C1045a());
            Button button = alertDialog.getButton(-2);
            if (button != null) {
                button.setOnClickListener(new C1046b());
            }
            if (C1043a.this.f1417g != null) {
                C1043a.this.f1417g.onShow(dialogInterface);
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.b.i.a$b */
    class C1047b implements DialogInterface.OnDismissListener {
        C1047b() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (C1043a.this.f1418h != null) {
                C1043a.this.f1418h.onDismiss(dialogInterface);
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.b.i.a$c */
    public enum C1048c {
        CONFIRM,
        CANCEL
    }

    /* renamed from: com.huawei.updatesdk.b.i.a$d */
    public interface C1049d {
        /* renamed from: a */
        void mo15029a();
    }

    protected C1043a(Context context, String str, CharSequence charSequence) {
        this.f1412b = context;
        this.f1413c = str;
        this.f1414d = charSequence;
        this.f1416f = C0981c.m1744i() ? new AlertDialog.Builder(context) : ((context.getResources().getConfiguration().uiMode & 48) != 32 || Build.VERSION.SDK_INT < 29) ? new AlertDialog.Builder(context, 16974546) : new AlertDialog.Builder(context, 16974545);
        this.f1416f.setTitle(this.f1413c);
        this.f1416f.setPositiveButton(C1041c.m1970c(context, "upsdk_third_app_dl_sure_cancel_download"), (DialogInterface.OnClickListener) null);
        this.f1416f.setNegativeButton(C1041c.m1970c(context, "upsdk_cancel"), (DialogInterface.OnClickListener) null);
        this.f1416f.setMessage(this.f1414d);
    }

    /* renamed from: a */
    public static C1043a m1976a(Context context, String str, CharSequence charSequence) {
        return new C1043a(context, str, charSequence);
    }

    /* renamed from: a */
    public void mo15014a() {
        try {
            if (this.f1415e != null) {
                this.f1415e.dismiss();
                this.f1415e = null;
            }
        } catch (IllegalArgumentException unused) {
            C0964a.m1667b("BaseAlertDialog", "dialog dismiss IllegalArgumentException");
        }
    }

    /* renamed from: a */
    public void mo15015a(DialogInterface.OnDismissListener onDismissListener) {
        this.f1418h = onDismissListener;
    }

    /* renamed from: a */
    public void mo15016a(DialogInterface.OnKeyListener onKeyListener) {
        AlertDialog alertDialog = this.f1415e;
        if (alertDialog != null) {
            alertDialog.setOnKeyListener(onKeyListener);
        }
    }

    /* renamed from: a */
    public void mo15017a(DialogInterface.OnShowListener onShowListener) {
        this.f1417g = onShowListener;
    }

    /* renamed from: a */
    public void mo15018a(View view) {
        ImageView imageView;
        if (this.f1416f != null) {
            if (C1036a.m1952d().mo15011a() >= 17 && (imageView = (ImageView) view.findViewById(C1041c.m1966a(view.getContext(), "divider"))) != null) {
                imageView.setVisibility(8);
            }
            this.f1416f.setMessage((CharSequence) null);
            this.f1416f.setView(view);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0018 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0019  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo15019a(com.huawei.updatesdk.p039b.p050i.C1043a.C1048c r3, java.lang.String r4) {
        /*
            r2 = this;
            android.app.AlertDialog r0 = r2.f1415e
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.huawei.updatesdk.b.i.a$c r1 = com.huawei.updatesdk.p039b.p050i.C1043a.C1048c.CONFIRM
            if (r3 != r1) goto L_0x000f
            r3 = -1
        L_0x000a:
            android.widget.Button r3 = r0.getButton(r3)
            goto L_0x0016
        L_0x000f:
            com.huawei.updatesdk.b.i.a$c r1 = com.huawei.updatesdk.p039b.p050i.C1043a.C1048c.CANCEL
            if (r3 != r1) goto L_0x0015
            r3 = -2
            goto L_0x000a
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 != 0) goto L_0x0019
            return
        L_0x0019:
            r3.setText(r4)
            r4 = 1
            r3.setAllCaps(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p039b.p050i.C1043a.mo15019a(com.huawei.updatesdk.b.i.a$c, java.lang.String):void");
    }

    /* renamed from: a */
    public void mo15020a(C1049d dVar) {
        StringBuilder sb;
        Context context = this.f1412b;
        if (context == null || ((Activity) context).isFinishing()) {
            C0964a.m1667b("BaseAlertDialog", "context == null or activity isFinishing");
            if (dVar != null) {
                dVar.mo15029a();
            }
        } else if (!mo15023b()) {
            try {
                this.f1415e = this.f1416f.create();
                this.f1415e.setCanceledOnTouchOutside(false);
                this.f1415e.setOnShowListener(new C1044a());
                this.f1415e.setOnDismissListener(new C1047b());
                this.f1415e.show();
                this.f1415e.getButton(-1).requestFocus();
            } catch (Exception e) {
                if (dVar != null) {
                    dVar.mo15029a();
                }
                sb = new StringBuilder();
                sb.append("show dlg error, e: ");
                sb.append(e.toString());
            }
        } else {
            sb = new StringBuilder();
            sb.append("show dlg error, mContext = ");
            sb.append(this.f1412b);
            sb.append(", mContext.isFinishing is ");
            Context context2 = this.f1412b;
            sb.append(context2 == null ? "mContext == null" : Boolean.valueOf(((Activity) context2).isFinishing()));
            C0964a.m1666a("BaseAlertDialog", sb.toString());
        }
    }

    /* renamed from: a */
    public void mo15021a(C1050b bVar) {
        this.f1411a = bVar;
    }

    /* renamed from: a */
    public void mo15022a(boolean z) {
        AlertDialog alertDialog = this.f1415e;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    /* renamed from: b */
    public boolean mo15023b() {
        AlertDialog alertDialog = this.f1415e;
        return alertDialog != null && alertDialog.isShowing();
    }

    /* renamed from: c */
    public void mo15024c() {
        AlertDialog.Builder builder = this.f1416f;
        if (builder != null) {
            builder.setNegativeButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        }
    }
}
