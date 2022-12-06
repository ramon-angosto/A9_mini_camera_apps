package com.huawei.hms.availableupdate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* renamed from: com.huawei.hms.availableupdate.a0 */
/* compiled from: PromptDialogs */
public abstract class C0632a0 extends C0661o {

    /* renamed from: com.huawei.hms.availableupdate.a0$a */
    /* compiled from: PromptDialogs */
    public class C0633a implements DialogInterface.OnClickListener {
        public C0633a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C0632a0.this.mo13292d();
        }
    }

    public C0632a0() {
    }

    /* renamed from: g */
    public AlertDialog mo13220g() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mo13293e(), mo13294f());
        builder.setMessage(mo13221h());
        builder.setPositiveButton(mo13222i(), new C0633a());
        return builder.create();
    }

    /* renamed from: h */
    public abstract int mo13221h();

    /* renamed from: i */
    public int mo13222i() {
        return ResourceLoaderUtil.getStringId("hms_confirm");
    }
}
