package com.bytedance.sdk.component.adexpress.dynamic.a;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicClose;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislike;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislikeFeedBack;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLogoAd;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLogoUnion;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicMutedView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicPrivacyView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRoot;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDown;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDownBtn;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDownContainer;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSplitLineView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicStarView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuter;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterContainerWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterSkip;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicUnKnowView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVideoView;

/* compiled from: DynamicViewFactory */
public class b {
    public static DynamicBaseWidget a(Context context, DynamicRootView dynamicRootView, h hVar) {
        if (context == null || dynamicRootView == null || hVar == null || hVar.i() == null) {
            return null;
        }
        switch (hVar.i().a()) {
            case -1:
                return new DynamicUnKnowView(context, dynamicRootView, hVar);
            case 0:
                return new DynamicTextView(context, dynamicRootView, hVar);
            case 1:
                return new DynamicImageView(context, dynamicRootView, hVar);
            case 2:
                return new DynamicButton(context, dynamicRootView, hVar);
            case 3:
                return new DynamicDislike(context, dynamicRootView, hVar);
            case 4:
                return new DynamicLogoAd(context, dynamicRootView, hVar);
            case 5:
                return new DynamicLogoUnion(context, dynamicRootView, hVar);
            case 6:
            case 9:
            case 17:
                return new DynamicBaseWidgetImp(context, dynamicRootView, hVar);
            case 7:
                return new DynamicVideoView(context, dynamicRootView, hVar);
            case 8:
                return new DynamicRoot(context, dynamicRootView, hVar);
            case 10:
                return new DynamicMutedView(context, dynamicRootView, hVar);
            case 11:
                return new DynamicStarView(context, dynamicRootView, hVar);
            case 12:
                return new DynamicDislikeFeedBack(context, dynamicRootView, hVar);
            case 13:
                return new DynamicTimeOuter(context, dynamicRootView, hVar);
            case 14:
                return new DynamicTimeOuterContainerWidgetImp(context, dynamicRootView, hVar);
            case 15:
                return new DynamicTimeOuterSkip(context, dynamicRootView, hVar);
            case 16:
                return new DynamicImageView(context, dynamicRootView, hVar);
            case 18:
                return new DynamicSplitLineView(context, dynamicRootView, hVar);
            case 19:
                return new DynamicSkipCountDownContainer(context, dynamicRootView, hVar);
            case 20:
                return new DynamicSkipCountDown(context, dynamicRootView, hVar);
            case 21:
                return new DynamicSkipCountDownBtn(context, dynamicRootView, hVar);
            case 22:
                return new DynamicClose(context, dynamicRootView, hVar);
            case 23:
                return new DynamicPrivacyView(context, dynamicRootView, hVar);
            case 24:
                return new DynamicBaseScrollWidgetImp(context, dynamicRootView, hVar);
            default:
                return null;
        }
    }
}
