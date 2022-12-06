package com.huawei.hms.availableupdate;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* renamed from: com.huawei.hms.availableupdate.s */
/* compiled from: ConfirmDialogs */
public abstract class C0666s extends C0661o {

    /* renamed from: com.huawei.hms.availableupdate.s$a */
    /* compiled from: ConfirmDialogs */
    public class C0667a implements DialogInterface.OnClickListener {
        public C0667a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C0666s.this.mo13292d();
        }
    }

    /* renamed from: com.huawei.hms.availableupdate.s$b */
    /* compiled from: ConfirmDialogs */
    public class C0668b implements DialogInterface.OnClickListener {
        public C0668b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C0666s.this.mo13288a();
        }
    }

    public C0666s() {
    }

    /* renamed from: g */
    public AlertDialog mo13220g() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mo13293e(), mo13294f());
        builder.setMessage(mo13299h());
        builder.setPositiveButton(mo13301j(), new C0667a());
        builder.setNegativeButton(mo13300i(), new C0668b());
        return builder.create();
    }

    /* renamed from: h */
    public abstract int mo13299h();

    /* renamed from: i */
    public abstract int mo13300i();

    /* renamed from: j */
    public abstract int mo13301j();
}
