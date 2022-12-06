package object.p2pipcam.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;

public class LoadingLayout extends FrameLayout {
    static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
    private final ImageView headerImage;
    private final ProgressBar headerProgress;
    private final TextView headerText;
    private String pullLabel;
    private String refreshingLabel;
    private String releaseLabel;
    private final Animation resetRotateAnimation;
    private final Animation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context, int i, String str, String str2, String str3) {
        super(context);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header, this);
        this.headerText = (TextView) viewGroup.findViewById(R.id.pull_to_refresh_text);
        this.headerImage = (ImageView) viewGroup.findViewById(R.id.pull_to_refresh_image);
        this.headerProgress = (ProgressBar) viewGroup.findViewById(R.id.pull_to_refresh_progress);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.rotateAnimation.setInterpolator(linearInterpolator);
        this.rotateAnimation.setDuration(150);
        this.rotateAnimation.setFillAfter(true);
        this.resetRotateAnimation = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.resetRotateAnimation.setInterpolator(linearInterpolator);
        this.resetRotateAnimation.setDuration(150);
        this.resetRotateAnimation.setFillAfter(true);
        this.releaseLabel = str;
        this.pullLabel = str2;
        this.refreshingLabel = str3;
        if (i != 2) {
            this.headerImage.setImageResource(R.drawable.pulltorefresh_down_arrow);
        } else {
            this.headerImage.setImageResource(R.drawable.pulltorefresh_up_arrow);
        }
    }

    public void reset() {
        this.headerText.setText(this.pullLabel);
        this.headerImage.setVisibility(0);
        this.headerProgress.setVisibility(8);
    }

    public void releaseToRefresh() {
        this.headerText.setText(this.releaseLabel);
        this.headerImage.clearAnimation();
        this.headerImage.startAnimation(this.rotateAnimation);
    }

    public void setPullLabel(String str) {
        this.pullLabel = str;
    }

    public void refreshing() {
        this.headerText.setText(this.refreshingLabel);
        this.headerImage.clearAnimation();
        this.headerImage.setVisibility(4);
        this.headerProgress.setVisibility(0);
    }

    public void setRefreshingLabel(String str) {
        this.refreshingLabel = str;
    }

    public void setReleaseLabel(String str) {
        this.releaseLabel = str;
    }

    public void pullToRefresh() {
        this.headerText.setText(this.pullLabel);
        this.headerImage.clearAnimation();
        this.headerImage.startAnimation(this.resetRotateAnimation);
    }

    public void setTextColor(int i) {
        this.headerText.setTextColor(i);
    }
}
