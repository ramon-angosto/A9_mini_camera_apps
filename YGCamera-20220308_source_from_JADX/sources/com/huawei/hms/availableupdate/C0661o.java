package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.availableupdate.o */
/* compiled from: AbstractDialog */
public abstract class C0661o {

    /* renamed from: a */
    public AlertDialog f407a;

    /* renamed from: b */
    public C0660n f408b;

    /* renamed from: com.huawei.hms.availableupdate.o$a */
    /* compiled from: AbstractDialog */
    public class C0662a implements DialogInterface.OnCancelListener {
        public C0662a() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            C0661o.this.mo13291c();
        }
    }

    /* renamed from: a */
    public static int m356a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", (String) null, (String) null);
    }

    /* renamed from: b */
    public void mo13290b() {
        AlertDialog alertDialog = this.f407a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: c */
    public void mo13291c() {
        C0660n nVar = this.f408b;
        if (nVar != null) {
            nVar.mo13255a(this);
        }
    }

    /* renamed from: d */
    public void mo13292d() {
        C0660n nVar = this.f408b;
        if (nVar != null) {
            nVar.mo13258b(this);
        }
    }

    /* renamed from: e */
    public Activity mo13293e() {
        C0660n nVar = this.f408b;
        if (nVar != null) {
            return nVar.mo13285b();
        }
        return null;
    }

    /* renamed from: f */
    public int mo13294f() {
        return (m356a((Context) mo13293e()) == 0 || Build.VERSION.SDK_INT < 16) ? 3 : 0;
    }

    /* renamed from: g */
    public abstract AlertDialog mo13220g();

    /* renamed from: a */
    public void mo13289a(C0660n nVar) {
        this.f408b = nVar;
        if (mo13293e() == null || mo13293e().isFinishing()) {
            HMSLog.m1377e("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        this.f407a = mo13220g();
        this.f407a.setCanceledOnTouchOutside(false);
        this.f407a.setOnCancelListener(new C0662a());
        this.f407a.show();
    }

    /* renamed from: a */
    public void mo13288a() {
        AlertDialog alertDialog = this.f407a;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }
}
