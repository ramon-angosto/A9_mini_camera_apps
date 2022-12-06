package com.unad.sdk.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.unad.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class FBAdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int AD_TYPE = 1;
    private Activity mActivity;
    private List<NativeAd> mAdItems;

    private static class a extends RecyclerView.ViewHolder {
        NativeAdLayout a;
        MediaView b;
        MediaView c;
        TextView d;
        TextView e;
        TextView f;
        TextView g;
        Button h;
        LinearLayout i;

        a(NativeAdLayout nativeAdLayout) {
            super(nativeAdLayout);
            this.a = nativeAdLayout;
            this.b = (MediaView) nativeAdLayout.findViewById(R.id.native_ad_media);
            this.d = (TextView) nativeAdLayout.findViewById(R.id.native_ad_title);
            this.e = (TextView) nativeAdLayout.findViewById(R.id.native_ad_body);
            this.f = (TextView) nativeAdLayout.findViewById(R.id.native_ad_social_context);
            this.g = (TextView) nativeAdLayout.findViewById(R.id.native_ad_sponsored_label);
            this.h = (Button) nativeAdLayout.findViewById(R.id.native_ad_call_to_action);
            this.c = (MediaView) nativeAdLayout.findViewById(R.id.native_ad_icon);
            this.i = (LinearLayout) nativeAdLayout.findViewById(R.id.ad_choices_container);
        }
    }

    public FBAdRecyclerAdapter(Activity activity, List<NativeAd> list) {
        this.mAdItems = list;
        this.mActivity = activity;
    }

    public int getItemCount() {
        return this.mAdItems.size();
    }

    public int getItemViewType(int i) {
        return 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        NativeAd nativeAd = this.mAdItems.get(i);
        a aVar = (a) viewHolder;
        aVar.i.removeAllViews();
        if (nativeAd != null) {
            aVar.d.setText(nativeAd.getAdvertiserName());
            aVar.e.setText(nativeAd.getAdBodyText());
            aVar.f.setText(nativeAd.getAdSocialContext());
            aVar.g.setText("Sponsored");
            aVar.h.setText(nativeAd.getAdCallToAction());
            aVar.h.setVisibility(nativeAd.hasCallToAction() ? 0 : 4);
            aVar.i.addView(new AdOptionsView(this.mActivity, nativeAd, aVar.a), 0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.c);
            arrayList.add(aVar.b);
            arrayList.add(aVar.h);
            nativeAd.registerViewForInteraction((View) aVar.a, aVar.b, aVar.c, (List<View>) arrayList);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((NativeAdLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.unad_ad_fb_splash_item, viewGroup, false));
    }
}
