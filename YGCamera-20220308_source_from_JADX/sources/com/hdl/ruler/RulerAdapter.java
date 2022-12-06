package com.hdl.ruler;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hdl.ruler.bean.ScaleMode;
import com.hdl.ruler.bean.TimeSlot;
import com.hdl.ruler.utils.CUtils;
import java.util.ArrayList;
import java.util.List;
import shix.cykj.camera.R;

public class RulerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "RulerAdapter";
    private final AnimationSet animationSetLeft;
    private final AnimationSet animationSetRight;
    private Context context;
    private int orientation = 2;
    private ScaleMode scaleMode = ScaleMode.KEY_MINUTE;
    private List<TimeSlot> vedioTimeSlot = new ArrayList();
    private int viewHeight = CUtils.dip2px(75.0f);
    private int width;
    private float zoom;

    public int getItemCount() {
        return 288;
    }

    public RulerAdapter(Context context2) {
        Context context3 = context2;
        this.context = context3;
        Display defaultDisplay = ((WindowManager) context3.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.width = point.x;
        int i = point.y;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) (-CUtils.dip2px(3.0f)), 0, 0.0f, 0, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(30);
        alphaAnimation.setRepeatMode(2);
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatCount(30);
        translateAnimation.setRepeatMode(2);
        this.animationSetRight = new AnimationSet(false);
        this.animationSetRight.addAnimation(alphaAnimation);
        this.animationSetRight.addAnimation(translateAnimation);
        this.animationSetRight.setDuration(1000);
        this.animationSetRight.setRepeatCount(30);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0, 0.0f, 0, (float) CUtils.dip2px(3.0f), 0, 0.0f, 0, 0.0f);
        alphaAnimation2.setDuration(1000);
        alphaAnimation2.setRepeatCount(30);
        alphaAnimation2.setRepeatMode(2);
        translateAnimation2.setDuration(1000);
        translateAnimation2.setRepeatCount(30);
        translateAnimation2.setRepeatMode(2);
        this.animationSetLeft = new AnimationSet(false);
        this.animationSetLeft.addAnimation(alphaAnimation);
        this.animationSetLeft.addAnimation(translateAnimation2);
        this.animationSetLeft.setDuration(1000);
        this.animationSetLeft.setRepeatCount(30);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(View.inflate(this.context, R.layout.item_ruler, (ViewGroup) null));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int i2 = (int) (this.zoom + 320.0f);
        viewHolder.parentView.setLayoutParams(new RecyclerView.LayoutParams(-2, this.viewHeight));
        if (this.orientation == 2) {
            viewHolder.iv_tip_left.setImageResource(R.drawable.ic_last_day);
            viewHolder.iv_tip_right.setImageResource(R.drawable.ic_next_day);
        } else {
            viewHolder.iv_tip_left.setImageResource(R.drawable.ic_last_day_landscape);
            viewHolder.iv_tip_right.setImageResource(R.drawable.ic_next_day_landscape);
        }
        viewHolder.view.setCurTimeIndex(i - 72);
        viewHolder.view.setScaleMode(this.scaleMode);
        viewHolder.view.setVedioTimeSlot(this.vedioTimeSlot);
        viewHolder.parentView.setLayoutParams(new RecyclerView.LayoutParams(i2, -2));
        viewHolder.view.postInvalidate();
        viewHolder.view.setViewHeight(this.viewHeight);
        if (i == 216) {
            viewHolder.ll_next_day_tip.bringToFront();
            viewHolder.ll_next_day_tip.setVisibility(0);
            viewHolder.ivRight.startAnimation(this.animationSetRight);
        } else {
            viewHolder.ll_next_day_tip.setVisibility(8);
        }
        if (i == 71) {
            viewHolder.ll_last_day_tip.setVisibility(0);
            viewHolder.ivLeft.startAnimation(this.animationSetLeft);
            return;
        }
        viewHolder.ll_last_day_tip.setVisibility(8);
    }

    public List<TimeSlot> getVedioTimeSlot() {
        return this.vedioTimeSlot;
    }

    public void setVedioTimeSlot(List<TimeSlot> list) {
        this.vedioTimeSlot.clear();
        this.vedioTimeSlot.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public ImageView ivLeft;
        /* access modifiers changed from: private */
        public ImageView ivRight;
        /* access modifiers changed from: private */
        public ImageView iv_tip_left;
        /* access modifiers changed from: private */
        public ImageView iv_tip_right;
        /* access modifiers changed from: private */
        public LinearLayout ll_last_day_tip;
        /* access modifiers changed from: private */
        public LinearLayout ll_next_day_tip;
        /* access modifiers changed from: private */
        public View parentView;
        /* access modifiers changed from: private */
        public RulerItemView view;

        public ViewHolder(View view2) {
            super(view2);
            this.parentView = view2;
            this.view = (RulerItemView) view2.findViewById(R.id.riv_ruler_item);
            this.ll_next_day_tip = (LinearLayout) view2.findViewById(R.id.ll_next_day_tip);
            this.ll_last_day_tip = (LinearLayout) view2.findViewById(R.id.ll_last_day_tip);
            this.ivLeft = (ImageView) view2.findViewById(R.id.iv_left);
            this.ivRight = (ImageView) view2.findViewById(R.id.iv_right);
            this.iv_tip_left = (ImageView) view2.findViewById(R.id.iv_tip_left);
            this.iv_tip_right = (ImageView) view2.findViewById(R.id.iv_tip_right);
        }
    }

    public void setZoom(float f) {
        this.zoom = f;
        notifyDataSetChanged();
    }

    public void setScaleMode(ScaleMode scaleMode2) {
        this.scaleMode = scaleMode2;
        notifyDataSetChanged();
    }

    public void setViewHeight(int i) {
        if (this.viewHeight < i) {
            this.orientation = 2;
        } else {
            this.orientation = 1;
        }
        this.viewHeight = i;
        notifyDataSetChanged();
    }
}
