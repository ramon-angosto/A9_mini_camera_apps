package shix.ihdbell.project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class AppFrontBackHelper {
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        private int activityStartCount = 0;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            this.activityStartCount++;
            if (this.activityStartCount == 1 && AppFrontBackHelper.this.mOnAppStatusListener != null) {
                AppFrontBackHelper.this.mOnAppStatusListener.onFront();
            }
        }

        public void onActivityStopped(Activity activity) {
            this.activityStartCount--;
            if (this.activityStartCount == 0 && AppFrontBackHelper.this.mOnAppStatusListener != null) {
                AppFrontBackHelper.this.mOnAppStatusListener.onBack();
            }
        }
    };
    /* access modifiers changed from: private */
    public OnAppStatusListener mOnAppStatusListener;

    public interface OnAppStatusListener {
        void onBack();

        void onFront();
    }

    @TargetApi(14)
    public void register(Application application, OnAppStatusListener onAppStatusListener) {
        this.mOnAppStatusListener = onAppStatusListener;
        application.registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }

    @TargetApi(14)
    public void unRegister(Application application) {
        application.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }
}
