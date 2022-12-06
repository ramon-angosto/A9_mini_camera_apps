package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.badge.BadgeDrawable;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.common.utils.d;

public class MraidVideoActivity extends Activity {
    private MediaView a;
    /* access modifiers changed from: private */
    public VideoController b;

    public static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClass(context, MraidVideoActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("INTENT_VIDEO_URL", str);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("INTENT_VIDEO_URL");
        this.a = new MediaView(this);
        this.a.a(stringExtra);
        this.b = this.a.getVideoController();
        this.a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (MraidVideoActivity.this.b == null) {
                    return;
                }
                if (MraidVideoActivity.this.b.isPlaying()) {
                    MraidVideoActivity.this.b.pause();
                } else {
                    MraidVideoActivity.this.b.play();
                }
            }
        });
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.bigo_ad_ic_close);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MraidVideoActivity.this.finish();
            }
        });
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.addView(this.a, new FrameLayout.LayoutParams(-1, -2, 17));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.a(this, 25), d.a(this, 25), BadgeDrawable.TOP_START);
        layoutParams.leftMargin = d.a(this, 15);
        layoutParams.topMargin = d.a(this, 25);
        frameLayout.addView(imageView, layoutParams);
        setContentView(frameLayout);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        VideoController videoController = this.b;
        if (videoController != null) {
            videoController.pause();
        }
        MediaView mediaView = this.a;
        if (mediaView != null) {
            mediaView.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        VideoController videoController = this.b;
        if (videoController != null) {
            videoController.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        VideoController videoController = this.b;
        if (videoController != null) {
            videoController.play();
        }
    }
}
