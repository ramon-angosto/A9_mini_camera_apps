package com.vungle.warren.utility;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class ImpressionTracker {
    private static final int MIN_VISIBILITY_PERCENTAGE = 1;
    private static final String TAG = ImpressionTracker.class.getSimpleName();
    private static final int VISIBILITY_THROTTLE_MILLIS = 100;
    private final Rect clipRect;
    /* access modifiers changed from: private */
    public boolean isVisibilityScheduled;
    final ViewTreeObserver.OnPreDrawListener onPreDrawListener;
    /* access modifiers changed from: private */
    public final Map<View, TrackingInfo> trackedViews;
    private final Handler visibilityHandler;
    private final VisibilityRunnable visibilityRunnable;
    WeakReference<ViewTreeObserver> weakViewTreeObserver;

    public interface ImpressionListener {
        void onImpression(View view);
    }

    static class TrackingInfo {
        ImpressionListener impressionListener;
        int minViewablePercent;

        TrackingInfo() {
        }
    }

    public ImpressionTracker(Context context) {
        this(context, new WeakHashMap(10), new Handler());
    }

    ImpressionTracker(Context context, Map<View, TrackingInfo> map, Handler handler) {
        this.clipRect = new Rect();
        this.trackedViews = map;
        this.visibilityHandler = handler;
        this.visibilityRunnable = new VisibilityRunnable();
        this.onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                ImpressionTracker.this.scheduleVisibilityCheck();
                return true;
            }
        };
        this.weakViewTreeObserver = new WeakReference<>((Object) null);
        setViewTreeObserver(context, (View) null);
    }

    private void setViewTreeObserver(Context context, View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.weakViewTreeObserver.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View topView = getTopView(context, view);
            if (topView == null) {
                Log.d(TAG, "Unable to set ViewTreeObserver due to no available root view.");
                return;
            }
            ViewTreeObserver viewTreeObserver2 = topView.getViewTreeObserver();
            if (!viewTreeObserver2.isAlive()) {
                Log.d(TAG, "The root view tree observer was not alive");
                return;
            }
            this.weakViewTreeObserver = new WeakReference<>(viewTreeObserver2);
            viewTreeObserver2.addOnPreDrawListener(this.onPreDrawListener);
        }
    }

    public void addView(View view, ImpressionListener impressionListener) {
        setViewTreeObserver(view.getContext(), view);
        TrackingInfo trackingInfo = this.trackedViews.get(view);
        if (trackingInfo == null) {
            trackingInfo = new TrackingInfo();
            this.trackedViews.put(view, trackingInfo);
            scheduleVisibilityCheck();
        }
        trackingInfo.minViewablePercent = 1;
        trackingInfo.impressionListener = impressionListener;
    }

    /* access modifiers changed from: package-private */
    public void removeView(View view) {
        this.trackedViews.remove(view);
    }

    public void clear() {
        this.trackedViews.clear();
        this.visibilityHandler.removeMessages(0);
        this.isVisibilityScheduled = false;
    }

    public void destroy() {
        clear();
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.weakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.onPreDrawListener);
        }
        this.weakViewTreeObserver.clear();
    }

    private View getTopView(Context context, View view) {
        View rootView;
        View findViewById = context instanceof Activity ? ((Activity) context).getWindow().getDecorView().findViewById(16908290) : null;
        return (findViewById != null || view == null || (rootView = view.getRootView()) == null) ? findViewById : rootView.findViewById(16908290);
    }

    /* access modifiers changed from: private */
    public void scheduleVisibilityCheck() {
        if (!this.isVisibilityScheduled) {
            this.isVisibilityScheduled = true;
            this.visibilityHandler.postDelayed(this.visibilityRunnable, 100);
        }
    }

    class VisibilityRunnable implements Runnable {
        private final ArrayList<View> mVisibleViews = new ArrayList<>();

        VisibilityRunnable() {
        }

        public void run() {
            boolean unused = ImpressionTracker.this.isVisibilityScheduled = false;
            for (Map.Entry entry : ImpressionTracker.this.trackedViews.entrySet()) {
                View view = (View) entry.getKey();
                if (ImpressionTracker.this.isVisible(view, ((TrackingInfo) entry.getValue()).minViewablePercent)) {
                    this.mVisibleViews.add(view);
                }
            }
            Iterator<View> it = this.mVisibleViews.iterator();
            while (it.hasNext()) {
                View next = it.next();
                TrackingInfo trackingInfo = (TrackingInfo) ImpressionTracker.this.trackedViews.get(next);
                if (!(trackingInfo == null || trackingInfo.impressionListener == null)) {
                    trackingInfo.impressionListener.onImpression(next);
                }
                ImpressionTracker.this.removeView(next);
            }
            this.mVisibleViews.clear();
        }
    }

    /* access modifiers changed from: private */
    public boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || !view.getGlobalVisibleRect(this.clipRect)) {
            return false;
        }
        long height = ((long) this.clipRect.height()) * ((long) this.clipRect.width());
        long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
        if (height2 > 0 && height * 100 >= ((long) i) * height2) {
            return true;
        }
        return false;
    }
}
