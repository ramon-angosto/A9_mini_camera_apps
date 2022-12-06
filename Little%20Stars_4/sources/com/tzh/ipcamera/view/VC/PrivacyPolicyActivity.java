package com.tzh.ipcamera.view.VC;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.BaseActivity;

public class PrivacyPolicyActivity extends BaseActivity implements View.OnClickListener {
    private TextView clauseContent = null;
    private TextView clauseTitle = null;
    LogUtils logUtils = LogUtils.setLogger(PrivacyPolicyActivity.class);
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
        setContentView(R.layout.privacy_policy_info);
        widget_init();
        if (getIntent().getStringExtra(DataBaseHelper.KEY_TYPE).equals("Privacy Policy")) {
            this.clauseTitle.setText(getResources().getString(R.string.privacy_policy_title_txt));
            this.clauseContent.setText(getResources().getString(R.string.privacy_policy_content));
            return;
        }
        this.clauseTitle.setText(getResources().getString(R.string.user_agreement_title_txt));
        this.clauseContent.setText(getResources().getString(R.string.user_agreement_content));
    }

    private void widget_init() {
        this.tvAddDeviceFailedBack = (TextView) findViewById(R.id.tvAddDeviceFailedBack);
        this.clauseTitle = (TextView) findViewById(R.id.clauseTitle);
        this.clauseContent = (TextView) findViewById(R.id.clauseContent);
        this.tvAddDeviceFailedBack.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tvAddDeviceFailedBack) {
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
