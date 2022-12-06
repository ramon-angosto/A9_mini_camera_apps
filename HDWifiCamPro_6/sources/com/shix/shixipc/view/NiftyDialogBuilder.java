package com.shix.shixipc.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.qhipc.R;

public class NiftyDialogBuilder extends Dialog implements DialogInterface {
    private static volatile NiftyDialogBuilder instance = null;
    private static int mOrientation = 1;
    /* access modifiers changed from: private */
    public boolean isCancelable = true;
    private View mDialogView;
    private int mDuration = -1;
    private TextView mMessage;
    private RelativeLayout mRelativeLayoutView;
    private TextView mTitle;
    private TextView tv_1;
    private TextView tv_2;
    /* access modifiers changed from: private */
    public Effectstype type = null;

    public NiftyDialogBuilder(Context context) {
        super(context);
        init(context);
    }

    public NiftyDialogBuilder(Context context, int i) {
        super(context, i);
        init(context);
    }

    public void setTv1(String str) {
        TextView textView = this.tv_1;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTv2(String str) {
        TextView textView = this.tv_2;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public TextView getMsg() {
        TextView textView = this.mMessage;
        if (textView != null) {
            return textView;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -1;
        attributes.width = -1;
        getWindow().setAttributes(attributes);
    }

    public static NiftyDialogBuilder getInstance(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (mOrientation != i) {
            mOrientation = i;
            instance = null;
        }
        if (instance == null) {
            synchronized (NiftyDialogBuilder.class) {
                if (instance == null) {
                    instance = new NiftyDialogBuilder(context, R.style.dialog_untran);
                }
            }
        }
        return instance;
    }

    private void init(Context context) {
        this.mDialogView = View.inflate(context, R.layout.dialog_layout, (ViewGroup) null);
        this.mRelativeLayoutView = (RelativeLayout) this.mDialogView.findViewById(R.id.main);
        this.mTitle = (TextView) this.mDialogView.findViewById(R.id.dialog_title);
        this.mMessage = (TextView) this.mDialogView.findViewById(R.id.tv_content);
        this.tv_1 = (TextView) this.mDialogView.findViewById(R.id.tv_1);
        this.tv_2 = (TextView) this.mDialogView.findViewById(R.id.tv_2);
        setContentView(this.mDialogView);
        setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                if (NiftyDialogBuilder.this.type == null) {
                    Effectstype unused = NiftyDialogBuilder.this.type = Effectstype.Slidetop;
                }
                NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.this;
                niftyDialogBuilder.start(niftyDialogBuilder.type);
            }
        });
        this.mRelativeLayoutView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (NiftyDialogBuilder.this.isCancelable) {
                    NiftyDialogBuilder.this.dismiss();
                }
            }
        });
    }

    public NiftyDialogBuilder withTitle(CharSequence charSequence) {
        this.mTitle.setText(charSequence);
        return this;
    }

    public NiftyDialogBuilder withTitleColor(String str) {
        this.mTitle.setTextColor(Color.parseColor(str));
        return this;
    }

    public NiftyDialogBuilder withMessage(int i) {
        this.mMessage.setText(i);
        return this;
    }

    public NiftyDialogBuilder withMessageLayoutWrap() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mMessage.setLayoutParams(layoutParams);
        return this;
    }

    public NiftyDialogBuilder withMessage(CharSequence charSequence) {
        this.mMessage.setText(charSequence);
        return this;
    }

    public NiftyDialogBuilder withDuration(int i) {
        this.mDuration = i;
        return this;
    }

    public NiftyDialogBuilder withEffect(Effectstype effectstype) {
        this.type = effectstype;
        return this;
    }

    public NiftyDialogBuilder withButton1Text(CharSequence charSequence) {
        this.tv_1.setText(charSequence);
        return this;
    }

    public NiftyDialogBuilder withButton2Text(CharSequence charSequence) {
        this.tv_2.setText(charSequence);
        return this;
    }

    public NiftyDialogBuilder setButton1Click(View.OnClickListener onClickListener) {
        this.tv_1.setOnClickListener(onClickListener);
        return this;
    }

    public NiftyDialogBuilder setButton2Click(View.OnClickListener onClickListener) {
        this.tv_2.setOnClickListener(onClickListener);
        return this;
    }

    public NiftyDialogBuilder isCancelableOnTouchOutside(boolean z) {
        this.isCancelable = z;
        setCanceledOnTouchOutside(z);
        return this;
    }

    public NiftyDialogBuilder isCancelable(boolean z) {
        this.isCancelable = z;
        setCancelable(z);
        return this;
    }

    public void show() {
        super.show();
    }

    /* access modifiers changed from: private */
    public void start(Effectstype effectstype) {
        BaseEffects animator = effectstype.getAnimator();
        int i = this.mDuration;
        if (i != -1) {
            animator.setDuration((long) Math.abs(i));
        }
        animator.start(this.mRelativeLayoutView);
    }

    public void dismiss() {
        super.dismiss();
        if (instance != null) {
            instance = null;
        }
    }
}
