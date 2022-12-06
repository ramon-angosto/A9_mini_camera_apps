package com.adcolony.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.adcolony.sdk.e0;
import com.mbridge.msdk.foundation.entity.CampaignEx;

class r {
    /* access modifiers changed from: private */
    public h0 a;
    /* access modifiers changed from: private */
    public AlertDialog b;
    /* access modifiers changed from: private */
    public boolean c;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (!a.c() || !(a.a() instanceof Activity)) {
                new e0.a().a("Missing Activity reference, can't build AlertDialog.").a(e0.i);
            } else if (c0.b(h0Var.a(), "on_resume")) {
                h0 unused = r.this.a = h0Var;
            } else {
                r.this.a(h0Var);
            }
        }
    }

    class b implements DialogInterface.OnClickListener {
        final /* synthetic */ h0 a;

        b(h0 h0Var) {
            this.a = h0Var;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog unused = r.this.b = null;
            dialogInterface.dismiss();
            f1 b2 = c0.b();
            c0.b(b2, "positive", true);
            boolean unused2 = r.this.c = false;
            this.a.a(b2).c();
        }
    }

    class c implements DialogInterface.OnClickListener {
        final /* synthetic */ h0 a;

        c(h0 h0Var) {
            this.a = h0Var;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog unused = r.this.b = null;
            dialogInterface.dismiss();
            f1 b2 = c0.b();
            c0.b(b2, "positive", false);
            boolean unused2 = r.this.c = false;
            this.a.a(b2).c();
        }
    }

    class d implements DialogInterface.OnCancelListener {
        final /* synthetic */ h0 a;

        d(h0 h0Var) {
            this.a = h0Var;
        }

        public void onCancel(DialogInterface dialogInterface) {
            AlertDialog unused = r.this.b = null;
            boolean unused2 = r.this.c = false;
            f1 b2 = c0.b();
            c0.b(b2, "positive", false);
            this.a.a(b2).c();
        }
    }

    class e implements Runnable {
        final /* synthetic */ AlertDialog.Builder a;

        e(AlertDialog.Builder builder) {
            this.a = builder;
        }

        public void run() {
            boolean unused = r.this.c = true;
            AlertDialog unused2 = r.this.b = this.a.show();
        }
    }

    r() {
        a.a("Alert.show", (j0) new a());
    }

    /* access modifiers changed from: package-private */
    public void c() {
        h0 h0Var = this.a;
        if (h0Var != null) {
            a(h0Var);
            this.a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.c;
    }

    /* access modifiers changed from: private */
    public void a(h0 h0Var) {
        AlertDialog.Builder builder;
        Context a2 = a.a();
        if (a2 != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                builder = new AlertDialog.Builder(a2, 16974374);
            } else {
                builder = new AlertDialog.Builder(a2, 16974126);
            }
            f1 a3 = h0Var.a();
            String h = c0.h(a3, "message");
            String h2 = c0.h(a3, CampaignEx.JSON_KEY_TITLE);
            String h3 = c0.h(a3, "positive");
            String h4 = c0.h(a3, "negative");
            builder.setMessage(h);
            builder.setTitle(h2);
            builder.setPositiveButton(h3, new b(h0Var));
            if (!h4.equals("")) {
                builder.setNegativeButton(h4, new c(h0Var));
            }
            builder.setOnCancelListener(new d(h0Var));
            z0.b((Runnable) new e(builder));
        }
    }

    /* access modifiers changed from: package-private */
    public AlertDialog a() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void a(AlertDialog alertDialog) {
        this.b = alertDialog;
    }
}
