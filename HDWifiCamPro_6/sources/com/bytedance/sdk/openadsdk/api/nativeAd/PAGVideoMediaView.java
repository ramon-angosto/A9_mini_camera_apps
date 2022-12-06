package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;

public class PAGVideoMediaView extends PAGMediaView implements a.C0043a {
    private NativeVideoTsView a;
    private com.bytedance.sdk.openadsdk.a.b.a b;

    public PAGVideoMediaView(Context context, View view, com.bytedance.sdk.openadsdk.a.b.a aVar) {
        super(context);
        a(view);
        this.b = aVar;
    }

    public PAGVideoMediaView(Context context, AttributeSet attributeSet, View view, com.bytedance.sdk.openadsdk.a.b.a aVar) {
        super(context, attributeSet);
        a(view);
        this.b = aVar;
    }

    public PAGVideoMediaView(Context context, AttributeSet attributeSet, int i, View view, com.bytedance.sdk.openadsdk.a.b.a aVar) {
        super(context, attributeSet, i);
        a(view);
        this.b = aVar;
    }

    private void a(View view) {
        if (view instanceof NativeVideoTsView) {
            this.a = (NativeVideoTsView) view;
            addView(this.a, -1, -1);
        }
    }

    public void setVideoAdListener(final PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.a((PAGVideoAdListener) new PAGVideoAdListener() {
                public void onVideoAdPlay() {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdPlay();
                    }
                }

                public void onVideoAdPaused() {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdPaused();
                    }
                }

                public void onVideoAdComplete() {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdComplete();
                    }
                }

                public void onVideoError() {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoError();
                    }
                }
            });
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (onClickListener instanceof a) {
            ((a) onClickListener).a((a.C0043a) this);
        }
    }

    public void close() {
        NativeVideoTsView nativeVideoTsView = this.a;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.o();
        }
    }

    public long getVideoProgress() {
        NativeVideoTsView nativeVideoTsView = this.a;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.a.getNativeVideoController().g();
    }

    public void sendClickEvent() {
        NativeVideoTsView nativeVideoTsView = this.a;
        if (nativeVideoTsView != null && (nativeVideoTsView.getNativeVideoController() instanceof c)) {
            ((c) this.a.getNativeVideoController()).x();
        }
    }
}
