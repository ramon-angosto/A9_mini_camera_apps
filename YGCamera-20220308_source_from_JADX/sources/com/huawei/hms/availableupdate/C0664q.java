package com.huawei.hms.availableupdate;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* renamed from: com.huawei.hms.availableupdate.q */
/* compiled from: CheckProgress */
public class C0664q extends C0661o {
    /* renamed from: g */
    public AlertDialog mo13220g() {
        ProgressDialog progressDialog = new ProgressDialog(mo13293e(), mo13294f());
        progressDialog.setMessage(ResourceLoaderUtil.getString("hms_checking"));
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
