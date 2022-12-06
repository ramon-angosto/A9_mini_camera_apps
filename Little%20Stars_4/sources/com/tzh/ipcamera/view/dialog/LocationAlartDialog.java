package com.tzh.ipcamera.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.view.VC.PrivacyPolicyActivity;
import object.p2pipcam.utils.DataBaseHelper;

public class LocationAlartDialog extends Dialog {
    /* access modifiers changed from: private */
    public AlartDialogClick alartDialogClick = null;
    /* access modifiers changed from: private */
    public Button btnAgree = null;
    private Button btnDisagree = null;
    private CheckBox checkButton = null;
    private TextView checkButtonText = null;
    private String content = null;
    /* access modifiers changed from: private */
    public Context context = null;
    private RelativeLayout frgCancel = null;
    private RelativeLayout frgConfirm = null;
    private boolean isSingle = false;
    private int languageIndex = 0;
    private int screenHeight = 0;
    private int screenWidth = 0;
    private String title = null;
    private TextView tvContent = null;
    private TextView tvTitle = null;

    public interface AlartDialogClick {
        void OnCancelClick();

        void OnConfirmClick();
    }

    public LocationAlartDialog(Context context2, int i) {
        super(context2, i);
        this.context = context2;
        setContentView(R.layout.location_alartdialog);
        LayoutInflater.from(context2).inflate(R.layout.location_alartdialog, (ViewGroup) null);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        getWindow().setFlags(32, 32);
        getWindow().setFlags(262144, 262144);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) context2.getResources().getDimension(R.dimen.y560);
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        widget_init();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    private void widget_init() {
        this.btnDisagree = (Button) findViewById(R.id.alart_btn_disagree);
        this.btnAgree = (Button) findViewById(R.id.alart_btn_agree);
        this.tvTitle = (TextView) findViewById(R.id.alart_title);
        this.tvContent = (TextView) findViewById(R.id.alart_content);
        this.checkButton = (CheckBox) findViewById(R.id.checkButton);
        this.checkButtonText = (TextView) findViewById(R.id.checkButtonText);
        this.tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        String string = this.context.getResources().getString(R.string.privacy_alart_check_txt);
        int indexOf = string.indexOf(this.context.getResources().getString(R.string.privacy_policy));
        int length = this.context.getResources().getString(R.string.privacy_policy).length();
        int indexOf2 = string.indexOf(this.context.getResources().getString(R.string.user_agreement));
        int length2 = this.context.getResources().getString(R.string.user_agreement).length();
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                Intent intent = new Intent(LocationAlartDialog.this.context, PrivacyPolicyActivity.class);
                intent.putExtra(DataBaseHelper.KEY_TYPE, "Privacy Policy");
                LocationAlartDialog.this.context.startActivity(intent);
            }
        }, indexOf, length + indexOf, 33);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                Intent intent = new Intent(LocationAlartDialog.this.context, PrivacyPolicyActivity.class);
                intent.putExtra(DataBaseHelper.KEY_TYPE, "User Agreement");
                LocationAlartDialog.this.context.startActivity(intent);
            }
        }, indexOf2, length2 + indexOf2, 33);
        this.checkButtonText.setText(spannableString);
        this.checkButtonText.setMovementMethod(LinkMovementMethod.getInstance());
        this.frgConfirm = (RelativeLayout) findViewById(R.id.alart_confirm_layout);
        this.frgCancel = (RelativeLayout) findViewById(R.id.alart_cancel_layout);
        if (this.isSingle) {
            this.frgCancel.setVisibility(8);
        }
        this.btnDisagree.setOnClickListener(new ClickListener());
        this.btnAgree.setOnClickListener(new ClickListener());
        this.checkButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    LocationAlartDialog.this.btnAgree.setEnabled(true);
                } else {
                    LocationAlartDialog.this.btnAgree.setEnabled(false);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = (int) this.context.getResources().getDimension(R.dimen.y400);
        layoutParams.gravity = 17;
        this.tvContent.setLayoutParams(layoutParams);
        new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.height = (int) this.context.getResources().getDimension(R.dimen.x80);
        layoutParams2.addRule(15);
        this.tvTitle.setGravity(17);
        this.tvTitle.setLayoutParams(layoutParams2);
    }

    public void setAlartClickListener(AlartDialogClick alartDialogClick2) {
        this.alartDialogClick = alartDialogClick2;
    }

    public void setTitle(String str) {
        this.tvTitle.setText(str);
    }

    public void setContent(String str) {
        this.tvContent.setText(str);
    }

    public void setSingleButton() {
        this.frgCancel.setVisibility(8);
    }

    private class ClickListener implements View.OnClickListener {
        private ClickListener() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.alart_btn_agree) {
                if (LocationAlartDialog.this.alartDialogClick != null) {
                    LocationAlartDialog.this.alartDialogClick.OnConfirmClick();
                }
                LocationAlartDialog.this.dismiss();
            } else if (id == R.id.alart_btn_disagree) {
                if (LocationAlartDialog.this.alartDialogClick != null) {
                    LocationAlartDialog.this.alartDialogClick.OnCancelClick();
                }
                LocationAlartDialog.this.dismiss();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.onTouchEvent(motionEvent);
    }
}
