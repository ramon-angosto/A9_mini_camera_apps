package com.tzh.ipcamera.view.VC;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import shix.ihdbell.project.BaseActivity;

public class AddDeviceFailedActivity extends BaseActivity implements View.OnClickListener {
    private Button btnConfirm = null;
    LogUtils logUtils = LogUtils.setLogger(AddDeviceFailedActivity.class);
    private TextView tvAddDeviceFailedBack = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.color_all_bg));
        }
        setContentView(R.layout.connect_failed_info);
        widget_init();
    }

    private void widget_init() {
        this.tvAddDeviceFailedBack = (TextView) findViewById(R.id.tvAddDeviceFailedBack);
        this.btnConfirm = (Button) findViewById(R.id.btnConfirm);
        this.tvAddDeviceFailedBack.setOnClickListener(this);
        this.btnConfirm.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnConfirm || id == R.id.tvAddDeviceFailedBack) {
            super.onBackPressed();
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
    }
}
