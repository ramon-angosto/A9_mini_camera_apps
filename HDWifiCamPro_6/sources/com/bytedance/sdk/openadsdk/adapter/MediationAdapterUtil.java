package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.i.d;
import java.util.List;

public class MediationAdapterUtil {
    public static void addNativeFeedMainView(Context context, int i, MediaView mediaView, View view, List<TTImage> list) {
        TTImage tTImage;
        if (context != null && mediaView != null) {
            if (i == 3 || i == 2 || i == 16 || i == 4 || i == 33) {
                View inflate = LayoutInflater.from(context).inflate(t.f(context, "tt_pangle_native_image_video_layout"), (ViewGroup) null);
                if (inflate != null) {
                    ImageView imageView = (ImageView) inflate.findViewById(t.e(context, "tt_main_image"));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(t.e(context, "tt_layout_image_group"));
                    if (i != 4) {
                        imageView.setVisibility(0);
                        linearLayout.setVisibility(8);
                        if (list != null && !list.isEmpty() && (tTImage = list.get(0)) != null && tTImage.isValid()) {
                            d.a().a(tTImage.getImageUrl(), imageView);
                        }
                    } else if (list != null && list.size() >= 3) {
                        ImageView imageView2 = (ImageView) inflate.findViewById(t.e(context, "tt_group_image1"));
                        ImageView imageView3 = (ImageView) inflate.findViewById(t.e(context, "tt_group_image2"));
                        ImageView imageView4 = (ImageView) inflate.findViewById(t.e(context, "tt_group_image3"));
                        imageView.setVisibility(8);
                        linearLayout.setVisibility(0);
                        TTImage tTImage2 = list.get(0);
                        TTImage tTImage3 = list.get(1);
                        TTImage tTImage4 = list.get(2);
                        if (!(tTImage2 == null || !tTImage2.isValid() || imageView2 == null)) {
                            d.a().a(tTImage2.getImageUrl(), imageView2);
                        }
                        if (!(tTImage3 == null || !tTImage3.isValid() || imageView3 == null)) {
                            d.a().a(tTImage4.getImageUrl(), imageView3);
                        }
                        if (!(tTImage4 == null || !tTImage4.isValid() || imageView4 == null)) {
                            d.a().a(tTImage4.getImageUrl(), imageView3);
                        }
                    }
                    mediaView.removeAllViews();
                    mediaView.addView(inflate, -1, -1);
                }
            } else if ((i == 5 || i == 15 || i == 50) && view != null && view.getParent() == null) {
                mediaView.removeAllViews();
                mediaView.addView(view, -1, -1);
            }
        }
    }
}
