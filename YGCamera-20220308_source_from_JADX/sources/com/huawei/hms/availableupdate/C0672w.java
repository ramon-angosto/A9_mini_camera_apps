package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.text.NumberFormat;

/* renamed from: com.huawei.hms.availableupdate.w */
/* compiled from: DownloadProgress */
public class C0672w extends C0661o {

    /* renamed from: c */
    public ProgressBar f412c;

    /* renamed from: d */
    public TextView f413d;

    /* renamed from: e */
    public int f414e = 0;

    /* renamed from: f */
    public DialogInterface.OnKeyListener f415f = new C0674b();

    /* renamed from: com.huawei.hms.availableupdate.w$b */
    /* compiled from: DownloadProgress */
    public static class C0674b implements DialogInterface.OnKeyListener {
        public C0674b() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4 && keyEvent.getRepeatCount() == 0;
        }
    }

    /* renamed from: a */
    public void mo13304a(int i) {
        this.f414e = i;
    }

    /* renamed from: b */
    public void mo13305b(int i) {
        ProgressBar progressBar;
        Activity e = mo13293e();
        if (e == null || e.isFinishing()) {
            HMSLog.m1380w("DownloadProgress", "In setDownloading, The activity is null or finishing.");
        } else if (this.f413d != null && (progressBar = this.f412c) != null) {
            progressBar.setProgress(i);
            this.f413d.setText(NumberFormat.getPercentInstance().format((double) (((float) i) / 100.0f)));
        }
    }

    /* renamed from: g */
    public AlertDialog mo13220g() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mo13293e(), mo13294f());
        View inflate = View.inflate(mo13293e(), ResourceLoaderUtil.getLayoutId("hms_download_progress"), (ViewGroup) null);
        builder.setView(inflate);
        builder.setCancelable(false);
        builder.setOnKeyListener(this.f415f);
        this.f412c = (ProgressBar) inflate.findViewById(ResourceLoaderUtil.getIdId("download_info_progress"));
        this.f413d = (TextView) inflate.findViewById(ResourceLoaderUtil.getIdId("hms_progress_text"));
        mo13305b(this.f414e);
        return builder.create();
    }
}
