package com.mbridge.msdk.video.dynview.endcard.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.video.dynview.endcard.cloudview.d;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ViewTagsAdapter */
public final class a extends d {
    private List<CampaignEx> a;

    public final void a(View view, int i, float f) {
    }

    public final void a(List<CampaignEx> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (CampaignEx next : list) {
                if (!TextUtils.isEmpty(next.getIconUrl())) {
                    arrayList.add(next);
                }
            }
            this.a = arrayList;
        }
    }

    public final int a() {
        List<CampaignEx> list = this.a;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.a.size();
    }

    public final View a(Context context, int i, ViewGroup viewGroup) {
        List<CampaignEx> list;
        View inflate = LayoutInflater.from(context).inflate(k.a(viewGroup.getContext(), "mbridge_reward_view_tag_item", TtmlNode.TAG_LAYOUT), viewGroup, false);
        if (inflate != null) {
            final RoundImageView roundImageView = (RoundImageView) inflate.findViewById(k.a(context, "mbridge_tag_icon", "id"));
            if (!(roundImageView == null || (list = this.a) == null || list.size() <= 0)) {
                roundImageView.setBorderRadius(2);
                b.a(context).a(this.a.get(i).getIconUrl(), (c) new c() {
                    public final void onFailedLoad(String str, String str2) {
                    }

                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        RoundImageView roundImageView = roundImageView;
                        if (roundImageView != null) {
                            roundImageView.setImageBitmap(bitmap);
                        }
                    }
                });
            }
            TextView textView = (TextView) inflate.findViewById(k.a(context, "mbridge_tag_title", "id"));
            if (textView != null) {
                textView.setText(this.a.get(i).getAppName());
            }
        }
        return inflate;
    }

    public final int a(int i) {
        return i % 5;
    }
}
