package com.mbridge.msdk.video.dynview.endcard.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.List;

public class MBMoreOfferAdapter extends RecyclerView.Adapter<b> implements NoProGuard {
    /* access modifiers changed from: private */
    public List<View> animViews = new ArrayList();
    /* access modifiers changed from: private */
    public int bitmapSuccessCount = 0;
    private List<CampaignEx> campaignExList = new ArrayList();
    /* access modifiers changed from: private */
    public boolean isShowMoreOffer;
    public a listener;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.video.dynview.endcard.b moreOfferShowCallBack;
    private String rewardEndCardurl = "";

    public interface a {
        void a(int i);
    }

    static /* synthetic */ int access$008(MBMoreOfferAdapter mBMoreOfferAdapter) {
        int i = mBMoreOfferAdapter.bitmapSuccessCount;
        mBMoreOfferAdapter.bitmapSuccessCount = i + 1;
        return i;
    }

    public void setOnItemClickListener(a aVar) {
        this.listener = aVar;
    }

    public void setRewardEndCardurl(String str) {
        this.rewardEndCardurl = str;
    }

    public void setMoreOfferShowCallBack(com.mbridge.msdk.video.dynview.endcard.b bVar) {
        this.moreOfferShowCallBack = bVar;
    }

    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(k.a(viewGroup.getContext(), "mbridge_reward_end_card_more_offer_item", TtmlNode.TAG_LAYOUT), viewGroup, false));
    }

    public void onBindViewHolder(final b bVar, final int i) {
        List<CampaignEx> list = this.campaignExList;
        if (list != null && list.size() > 0) {
            if (bVar.a != null) {
                bVar.a.setImageDrawable((Drawable) null);
                bVar.a.setTag(this.campaignExList.get(i).getIconUrl());
            }
            com.mbridge.msdk.foundation.same.c.b.a(bVar.itemView.getContext()).a(this.campaignExList.get(i).getIconUrl(), (c) new c() {
                public final void onFailedLoad(String str, String str2) {
                }

                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    if (!(bVar.a == null || bVar.a.getTag() == null || !bVar.a.getTag().equals(str))) {
                        bVar.a.setImageBitmap(bitmap);
                    }
                    MBMoreOfferAdapter.access$008(MBMoreOfferAdapter.this);
                    if (!MBMoreOfferAdapter.this.isShowMoreOffer && MBMoreOfferAdapter.this.bitmapSuccessCount >= 5 && MBMoreOfferAdapter.this.moreOfferShowCallBack != null) {
                        boolean unused = MBMoreOfferAdapter.this.isShowMoreOffer = true;
                        MBMoreOfferAdapter.this.moreOfferShowCallBack.a((List<View>) MBMoreOfferAdapter.this.animViews);
                    }
                }
            });
            if (!TextUtils.isEmpty(this.campaignExList.get(i).getAppName())) {
                String a2 = y.a(this.rewardEndCardurl, "mof_textmod");
                if (TextUtils.isEmpty(a2) || !a2.equals("1")) {
                    if (bVar.b != null) {
                        bVar.b.setVisibility(8);
                    }
                } else if (bVar.b != null) {
                    bVar.b.setText(this.campaignExList.get(i).getAppName());
                }
            }
            bVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBMoreOfferAdapter.this.listener != null) {
                        MBMoreOfferAdapter.this.listener.a(i);
                    }
                }
            });
        }
    }

    public int getItemCount() {
        List<CampaignEx> list = this.campaignExList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    static class b extends RecyclerView.ViewHolder {
        RoundImageView a;
        TextView b;

        public b(View view) {
            super(view);
            this.a = (RoundImageView) view.findViewById(k.a(view.getContext(), "mbridge_reward_end_card_item_iv", "id"));
            this.b = (TextView) view.findViewById(k.a(view.getContext(), "mbridge_reward_end_card_item_title_tv", "id"));
        }
    }

    public void setMoreOfferData(List<CampaignEx> list) {
        com.mbridge.msdk.video.dynview.endcard.b bVar;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 5) {
            com.mbridge.msdk.video.dynview.endcard.b bVar2 = this.moreOfferShowCallBack;
            if (bVar2 != null) {
                bVar2.a("Offer list is NULL or size less than 5.");
                return;
            }
            return;
        }
        int i = 0;
        for (CampaignEx next : list) {
            if (TextUtils.isEmpty(next.getIconUrl())) {
                i++;
            } else {
                arrayList.add(next);
            }
        }
        if (list.size() - i < 5 && (bVar = this.moreOfferShowCallBack) != null) {
            bVar.a("Offer icon is Null and size less than 5.");
        }
        this.campaignExList = arrayList;
    }
}
