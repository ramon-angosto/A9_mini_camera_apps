package com.huawei.hms.availableupdate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* renamed from: com.huawei.hms.availableupdate.y */
/* compiled from: InstallConfirm */
public class C0676y extends C0661o {

    /* renamed from: c */
    public String f416c = ResourceLoaderUtil.getString("hms_update_title");

    /* renamed from: com.huawei.hms.availableupdate.y$a */
    /* compiled from: InstallConfirm */
    public class C0677a implements DialogInterface.OnClickListener {
        public C0677a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C0676y.this.mo13292d();
        }
    }

    /* renamed from: com.huawei.hms.availableupdate.y$b */
    /* compiled from: InstallConfirm */
    public class C0678b implements DialogInterface.OnClickListener {
        public C0678b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C0676y.this.mo13288a();
        }
    }

    /* renamed from: a */
    public void mo13310a(String str) {
        this.f416c = str;
    }

    /* renamed from: g */
    public AlertDialog mo13220g() {
        int stringId = ResourceLoaderUtil.getStringId("hms_update_message_new");
        int stringId2 = ResourceLoaderUtil.getStringId("hms_install");
        AlertDialog.Builder builder = new AlertDialog.Builder(mo13293e(), mo13294f());
        builder.setMessage(mo13293e().getString(stringId, new Object[]{this.f416c}));
        builder.setPositiveButton(stringId2, new C0677a());
        builder.setNegativeButton(ResourceLoaderUtil.getStringId("hms_cancel"), new C0678b());
        return builder.create();
    }
}
