package shix.ihdbell.project;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import object.p2pipcam.system.SwipeBackLayout;

public class SwipeBackActivity extends FragmentActivity {
    private boolean mIsFinishing;
    private boolean mOverrideExitAniamtion = true;
    private SwipeBackLayout mSwipeBackLayout;
    private SharedPreferences pre_all_one;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().getDecorView().setBackgroundDrawable((Drawable) null);
        this.mSwipeBackLayout = new SwipeBackLayout(this);
        this.pre_all_one = getSharedPreferences("shix_zhao_pre_all_one", 0);
    }
}
