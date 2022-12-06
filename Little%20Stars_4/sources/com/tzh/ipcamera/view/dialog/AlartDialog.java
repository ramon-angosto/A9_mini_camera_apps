package com.tzh.ipcamera.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;

public class AlartDialog extends Dialog {
    /* access modifiers changed from: private */
    public AlartDialogClick alartDialogClick = null;
    private Button btnCancel = null;
    private ImageView btnClose = null;
    private Button btnConfirm = null;
    private String content = null;
    private Context context = null;
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

    public AlartDialog(Context context2, int i) {
        super(context2, i);
        this.context = context2;
        setContentView(R.layout.alartdialog);
        LayoutInflater.from(context2).inflate(R.layout.alartdialog, (ViewGroup) null);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) context2.getResources().getDimension(R.dimen.y560);
        attributes.height = (int) context2.getResources().getDimension(R.dimen.x320);
        attributes.gravity = 17;
        window.setAttributes(attributes);
        widget_init();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    private void widget_init() {
        this.btnConfirm = (Button) findViewById(R.id.alart_btn_confirm);
        this.btnCancel = (Button) findViewById(R.id.alart_btn_cancel);
        this.tvTitle = (TextView) findViewById(R.id.alart_title);
        this.tvContent = (TextView) findViewById(R.id.alart_content);
        this.btnClose = (ImageView) findViewById(R.id.alart_close);
        this.frgConfirm = (RelativeLayout) findViewById(R.id.alart_confirm_layout);
        this.frgCancel = (RelativeLayout) findViewById(R.id.alart_cancel_layout);
        if (this.isSingle) {
            this.frgCancel.setVisibility(8);
        }
        this.btnClose.setOnClickListener(new ClickListener());
        this.btnCancel.setOnClickListener(new ClickListener());
        this.btnConfirm.setOnClickListener(new ClickListener());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = (int) this.context.getResources().getDimension(R.dimen.x130);
        layoutParams.gravity = 17;
        this.tvContent.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) this.context.getResources().getDimension(R.dimen.x60);
        layoutParams2.height = (int) this.context.getResources().getDimension(R.dimen.x60);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = (int) this.context.getResources().getDimension(R.dimen.x10);
        this.btnClose.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.height = (int) this.context.getResources().getDimension(R.dimen.x80);
        layoutParams3.addRule(15);
        this.tvTitle.setGravity(17);
        this.tvTitle.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) this.context.getResources().getDimension(R.dimen.y200);
        layoutParams4.height = (int) this.context.getResources().getDimension(R.dimen.x70);
        layoutParams4.addRule(13);
        this.btnConfirm.setGravity(17);
        this.btnConfirm.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) this.context.getResources().getDimension(R.dimen.y200);
        layoutParams5.height = (int) this.context.getResources().getDimension(R.dimen.x70);
        layoutParams5.addRule(13);
        this.btnCancel.setGravity(17);
        this.btnCancel.setLayoutParams(layoutParams5);
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
            switch (view.getId()) {
                case R.id.alart_btn_cancel:
                    if (AlartDialog.this.alartDialogClick != null) {
                        AlartDialog.this.alartDialogClick.OnCancelClick();
                    }
                    AlartDialog.this.dismiss();
                    return;
                case R.id.alart_btn_confirm:
                    if (AlartDialog.this.alartDialogClick != null) {
                        AlartDialog.this.alartDialogClick.OnConfirmClick();
                    }
                    AlartDialog.this.dismiss();
                    return;
                case R.id.alart_close:
                    if (AlartDialog.this.alartDialogClick != null) {
                        AlartDialog.this.alartDialogClick.OnCancelClick();
                    }
                    AlartDialog.this.dismiss();
                    return;
                default:
                    return;
            }
        }
    }
}
