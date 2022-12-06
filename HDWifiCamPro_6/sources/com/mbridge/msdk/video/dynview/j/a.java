package com.mbridge.msdk.video.dynview.j;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.video.dynview.i.c.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DataEnergizeWrapper */
public final class a {
    private b a;
    /* access modifiers changed from: private */
    public Map<String, Bitmap> b;
    /* access modifiers changed from: private */
    public volatile boolean c;
    private String d = "#FFFFFFFF";
    private String e = "#60000000";
    /* access modifiers changed from: private */
    public String f = "#FF5F5F5F";

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.video.dynview.b r17, android.view.View r18, java.util.Map r19, com.mbridge.msdk.video.dynview.d.b r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            java.util.Map<java.lang.String, android.graphics.Bitmap> r5 = r0.b
            if (r5 != 0) goto L_0x0015
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r0.b = r5
        L_0x0015:
            java.util.List r5 = r17.g()
            android.content.Context r6 = r18.getContext()
            if (r6 != 0) goto L_0x0025
            com.mbridge.msdk.video.dynview.c.a r1 = com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT
            r4.a(r1)
            return
        L_0x0025:
            r7 = 0
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x003d
            int r10 = r5.size()
            if (r10 <= r8) goto L_0x003d
            java.lang.Object r7 = r5.get(r9)
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7
            java.lang.Object r10 = r5.get(r8)
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10
            goto L_0x003e
        L_0x003d:
            r10 = r7
        L_0x003e:
            if (r7 != 0) goto L_0x0048
            if (r4 == 0) goto L_0x0048
            com.mbridge.msdk.video.dynview.c.a r1 = com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL
            r4.a(r1)
            return
        L_0x0048:
            if (r10 != 0) goto L_0x0052
            if (r4 == 0) goto L_0x0052
            com.mbridge.msdk.video.dynview.c.a r1 = com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL
            r4.a(r1)
            return
        L_0x0052:
            java.lang.String r11 = "mbridge_top_item_rl"
            int r11 = r0.a((java.lang.String) r11)
            android.view.View r11 = r2.findViewById(r11)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            if (r11 == 0) goto L_0x0068
            com.mbridge.msdk.video.dynview.j.a$1 r12 = new com.mbridge.msdk.video.dynview.j.a$1
            r12.<init>(r3, r5)
            r11.setOnClickListener(r12)
        L_0x0068:
            java.lang.String r11 = "mbridge_top_iv"
            int r11 = r0.a((java.lang.String) r11)
            android.view.View r11 = r2.findViewById(r11)
            com.mbridge.msdk.videocommon.view.RoundImageView r11 = (com.mbridge.msdk.videocommon.view.RoundImageView) r11
            r13 = 1055286886(0x3ee66666, float:0.45)
            r14 = 1128792064(0x43480000, float:200.0)
            r15 = -1
            r9 = 10
            if (r11 == 0) goto L_0x00f6
            r11.setBorderRadius(r9)
            java.lang.String r9 = r7.getImageUrl()
            r0.a((java.lang.String) r9, (android.widget.ImageView) r11, (com.mbridge.msdk.video.dynview.b) r1, (android.view.View) r2)
            java.lang.String r9 = "mbridge_top_ration"
            int r9 = r0.a((java.lang.String) r9)
            android.view.View r9 = r2.findViewById(r9)
            com.mbridge.msdk.video.dynview.widget.MBRotationView r9 = (com.mbridge.msdk.video.dynview.widget.MBRotationView) r9
            if (r9 == 0) goto L_0x00f6
            boolean r11 = r7.getCanStart2C1Anim()
            if (r11 == 0) goto L_0x00e9
            java.lang.String r11 = r7.getIconUrl()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x00dc
            android.widget.ImageView r11 = new android.widget.ImageView
            android.content.Context r8 = r17.a()
            r11.<init>(r8)
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams
            android.content.Context r12 = r17.a()
            int r12 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r12, (float) r14)
            r8.<init>(r15, r12)
            r11.setLayoutParams(r8)
            android.widget.ImageView$ScaleType r8 = android.widget.ImageView.ScaleType.CENTER_CROP
            r11.setScaleType(r8)
            r9.addView(r11)
            java.lang.String r8 = r7.getIconUrl()
            r0.a((java.lang.String) r8, (android.widget.ImageView) r11)
            r9.setWidthRatio(r13)
            r8 = 1063675494(0x3f666666, float:0.9)
            r9.setHeightRatio(r8)
            r8 = 1
            r9.setAutoscroll(r8)
            goto L_0x00f6
        L_0x00dc:
            r8 = 1065353216(0x3f800000, float:1.0)
            r9.setWidthRatio(r8)
            r9.setHeightRatio(r8)
            r11 = 0
            r9.setAutoscroll(r11)
            goto L_0x00f7
        L_0x00e9:
            r8 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r9.setWidthRatio(r8)
            r9.setHeightRatio(r8)
            r9.setAutoscroll(r11)
            goto L_0x00f7
        L_0x00f6:
            r11 = 0
        L_0x00f7:
            java.lang.String r8 = "mbridge_top_icon_iv"
            int r8 = r0.a((java.lang.String) r8)
            android.view.View r8 = r2.findViewById(r8)
            com.mbridge.msdk.videocommon.view.RoundImageView r8 = (com.mbridge.msdk.videocommon.view.RoundImageView) r8
            if (r8 == 0) goto L_0x010f
            r8.setType(r11)
            java.lang.String r9 = r7.getIconUrl()
            r0.a((java.lang.String) r9, (android.widget.ImageView) r8)
        L_0x010f:
            java.lang.String r8 = "mbridge_top_title_tv"
            int r8 = r0.a((java.lang.String) r8)
            android.view.View r8 = r2.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0134
            java.lang.String r9 = r7.getAppName()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x012f
            java.lang.String r9 = r7.getAppName()
            r8.setText(r9)
            goto L_0x0134
        L_0x012f:
            r9 = 8
            r8.setVisibility(r9)
        L_0x0134:
            java.lang.String r8 = "mbridge_bottom_item_rl"
            int r8 = r0.a((java.lang.String) r8)
            android.view.View r8 = r2.findViewById(r8)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            if (r8 == 0) goto L_0x014a
            com.mbridge.msdk.video.dynview.j.a$2 r9 = new com.mbridge.msdk.video.dynview.j.a$2
            r9.<init>(r3, r5)
            r8.setOnClickListener(r9)
        L_0x014a:
            java.lang.String r5 = "mbridge_bottom_iv"
            int r5 = r0.a((java.lang.String) r5)
            android.view.View r5 = r2.findViewById(r5)
            com.mbridge.msdk.videocommon.view.RoundImageView r5 = (com.mbridge.msdk.videocommon.view.RoundImageView) r5
            if (r5 == 0) goto L_0x01d2
            r8 = 10
            r5.setBorderRadius(r8)
            java.lang.String r8 = r10.getImageUrl()
            r0.a((java.lang.String) r8, (android.widget.ImageView) r5, (com.mbridge.msdk.video.dynview.b) r1, (android.view.View) r2)
            java.lang.String r5 = "mbridge_bottom_ration"
            int r5 = r0.a((java.lang.String) r5)
            android.view.View r5 = r2.findViewById(r5)
            com.mbridge.msdk.video.dynview.widget.MBRotationView r5 = (com.mbridge.msdk.video.dynview.widget.MBRotationView) r5
            if (r5 == 0) goto L_0x01d2
            boolean r8 = r10.getCanStart2C1Anim()
            if (r8 == 0) goto L_0x01c5
            java.lang.String r8 = r10.getIconUrl()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x01b8
            android.widget.ImageView r8 = new android.widget.ImageView
            android.content.Context r9 = r17.a()
            r8.<init>(r9)
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            android.content.Context r11 = r17.a()
            int r11 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r11, (float) r14)
            r9.<init>(r15, r11)
            r8.setLayoutParams(r9)
            android.widget.ImageView$ScaleType r9 = android.widget.ImageView.ScaleType.CENTER_CROP
            r8.setScaleType(r9)
            r5.addView(r8)
            java.lang.String r9 = r10.getIconUrl()
            r0.a((java.lang.String) r9, (android.widget.ImageView) r8)
            r5.setWidthRatio(r13)
            r8 = 1063675494(0x3f666666, float:0.9)
            r5.setHeightRatio(r8)
            r8 = 1
            r5.setAutoscroll(r8)
            goto L_0x01d2
        L_0x01b8:
            r8 = 1065353216(0x3f800000, float:1.0)
            r5.setWidthRatio(r8)
            r5.setHeightRatio(r8)
            r9 = 0
            r5.setAutoscroll(r9)
            goto L_0x01d3
        L_0x01c5:
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r5.setWidthRatio(r8)
            r5.setHeightRatio(r8)
            r5.setAutoscroll(r9)
            goto L_0x01d3
        L_0x01d2:
            r9 = 0
        L_0x01d3:
            java.lang.String r5 = "mbridge_bottom_icon_iv"
            int r5 = r0.a((java.lang.String) r5)
            android.view.View r5 = r2.findViewById(r5)
            com.mbridge.msdk.videocommon.view.RoundImageView r5 = (com.mbridge.msdk.videocommon.view.RoundImageView) r5
            if (r5 == 0) goto L_0x01eb
            r5.setType(r9)
            java.lang.String r8 = r10.getIconUrl()
            r0.a((java.lang.String) r8, (android.widget.ImageView) r5)
        L_0x01eb:
            java.lang.String r5 = "mbridge_bottom_title_tv"
            int r5 = r0.a((java.lang.String) r5)
            android.view.View r5 = r2.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0200
            java.lang.String r8 = r10.getAppName()
            r5.setText(r8)
        L_0x0200:
            java.lang.String r5 = r7.getCMPTEntryUrl()
            int r7 = r17.e()
            java.lang.String r8 = "cltp"
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.y.a(r5, r8)
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            r9 = 0
            if (r8 != 0) goto L_0x021b
            long r11 = java.lang.Long.parseLong(r5)
            goto L_0x021c
        L_0x021b:
            r11 = r9
        L_0x021c:
            int r5 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x02b3
            java.lang.String r5 = "mbridge_choice_one_countdown_tv"
            int r5 = r0.a((java.lang.String) r5)
            android.view.View r5 = r2.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r8 = 1093664768(0x41300000, float:11.0)
            r5.setTextSize(r8)
            java.lang.String r8 = r0.d
            int r8 = android.graphics.Color.parseColor(r8)
            r5.setTextColor(r8)
            r8 = 12
            java.lang.String r9 = r0.e
            if (r5 == 0) goto L_0x026d
            android.graphics.drawable.GradientDrawable r10 = new android.graphics.drawable.GradientDrawable
            r10.<init>()
            int r13 = android.graphics.Color.parseColor(r9)
            r10.setColor(r13)
            android.content.Context r13 = r5.getContext()
            float r8 = (float) r8
            int r8 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r13, (float) r8)
            float r8 = (float) r8
            r10.setCornerRadius(r8)
            android.content.Context r8 = r5.getContext()
            r13 = 1
            float r14 = (float) r13
            int r8 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r8, (float) r14)
            int r9 = android.graphics.Color.parseColor(r9)
            r10.setStroke(r8, r9)
            r5.setBackground(r10)
        L_0x026d:
            r8 = 2
            if (r7 != r8) goto L_0x0285
            android.view.ViewGroup$LayoutParams r7 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r7 = (android.widget.FrameLayout.LayoutParams) r7
            if (r7 == 0) goto L_0x0285
            int r8 = com.mbridge.msdk.foundation.tools.u.e((android.content.Context) r6)
            r9 = 1092616192(0x41200000, float:10.0)
            int r9 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r6, (float) r9)
            r7.setMargins(r9, r9, r8, r9)
        L_0x0285:
            if (r5 == 0) goto L_0x02b3
            r7 = 0
            r5.setVisibility(r7)
            com.mbridge.msdk.video.dynview.j.a$3 r7 = new com.mbridge.msdk.video.dynview.j.a$3
            r7.<init>(r3)
            r5.setOnClickListener(r7)
            com.mbridge.msdk.video.dynview.i.c.b r7 = new com.mbridge.msdk.video.dynview.i.c.b
            r7.<init>()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r8
            com.mbridge.msdk.video.dynview.i.c.b r7 = r7.b(r11)
            com.mbridge.msdk.video.dynview.i.c.b r7 = r7.a((long) r8)
            com.mbridge.msdk.video.dynview.j.a$4 r8 = new com.mbridge.msdk.video.dynview.j.a$4
            r8.<init>(r5, r3)
            com.mbridge.msdk.video.dynview.i.c.b r3 = r7.a((com.mbridge.msdk.video.dynview.i.c.a) r8)
            r0.a = r3
            com.mbridge.msdk.video.dynview.i.c.b r3 = r0.a
            r3.a()
        L_0x02b3:
            android.content.Context r3 = r18.getContext()
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.m.c((android.content.Context) r3)
            java.lang.String r5 = "zh"
            boolean r3 = r3.contains(r5)
            if (r3 != 0) goto L_0x02f7
            java.lang.String r3 = "mbridge_reward_choice_one_like_iv"
            int r3 = r0.a((java.lang.String) r3)
            android.view.View r2 = r2.findViewById(r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            if (r1 == 0) goto L_0x02f7
            if (r2 == 0) goto L_0x02f7
            int r1 = r17.e()
            java.lang.String r3 = "drawable"
            r5 = 1
            if (r1 != r5) goto L_0x02ea
            android.content.Context r1 = r6.getApplicationContext()
            java.lang.String r5 = "mbridge_choice_video_title_en_por"
            int r1 = com.mbridge.msdk.foundation.tools.k.a(r1, r5, r3)
            r2.setImageResource(r1)
            goto L_0x02f7
        L_0x02ea:
            android.content.Context r1 = r6.getApplicationContext()
            java.lang.String r5 = "mbridge_choice_video_title_en_land"
            int r1 = com.mbridge.msdk.foundation.tools.k.a(r1, r5, r3)
            r2.setImageResource(r1)
        L_0x02f7:
            if (r4 == 0) goto L_0x02fc
            r20.a()
        L_0x02fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.j.a.a(com.mbridge.msdk.video.dynview.b, android.view.View, java.util.Map, com.mbridge.msdk.video.dynview.d.b):void");
    }

    public final void b(com.mbridge.msdk.video.dynview.b bVar, View view, Map map, com.mbridge.msdk.video.dynview.d.b bVar2) {
        if (bVar2 != null) {
            if (bVar == null) {
                bVar2.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
                return;
            }
            List<CampaignEx> g = bVar.g();
            if (g == null || g.size() <= 0) {
                bVar2.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
                return;
            }
            CampaignEx campaignEx = g.get(0);
            if (campaignEx != null) {
                RoundImageView roundImageView = (RoundImageView) view.findViewById(a("mbridge_reward_icon_riv"));
                if (roundImageView != null) {
                    roundImageView.setBorderRadius(10);
                    a(campaignEx.getIconUrl(), (ImageView) roundImageView);
                }
                TextView textView = (TextView) view.findViewById(a("mbridge_reward_title_tv"));
                if (textView != null) {
                    textView.setText(campaignEx.getAppName());
                }
                TextView textView2 = (TextView) view.findViewById(a("mbridge_reward_desc_tv"));
                if (textView2 != null) {
                    textView2.setText(campaignEx.getAppDesc());
                }
                MBridgeLevelLayoutView mBridgeLevelLayoutView = (MBridgeLevelLayoutView) view.findViewById(a("mbridge_reward_stars_mllv"));
                if (mBridgeLevelLayoutView != null) {
                    double rating = campaignEx.getRating();
                    if (rating <= 0.0d) {
                        rating = 5.0d;
                    }
                    mBridgeLevelLayoutView.setRatingAndUser(rating, campaignEx.getNumberRating());
                }
                TextView textView3 = (TextView) view.findViewById(a("mbridge_reward_click_tv"));
                if (textView3 != null) {
                    textView3.setText(campaignEx.getAdCall());
                }
                int h = bVar.h();
                if (!(h == 202 || h == 302)) {
                    if (h == 802) {
                        a((ImageView) view.findViewById(a("mbridge_videoview_bg")), campaignEx.getImageUrl(), h);
                    }
                }
                bVar2.a();
                return;
            }
            bVar2.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
        }
    }

    private void a(String str, ImageView imageView) {
        if (!TextUtils.isEmpty(str) && imageView != null) {
            a(imageView, str, -1);
        }
    }

    private void a(final ImageView imageView, String str, final int i) {
        if (!TextUtils.isEmpty(str) && imageView != null) {
            com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, (c) new c() {
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        int a2 = k.a(imageView.getContext(), "mbridge_icon_play_bg", "drawable");
                        imageView.setBackgroundColor(Color.parseColor(a.this.f));
                        imageView.setImageResource(a2);
                        imageView.setScaleType(ImageView.ScaleType.CENTER);
                    } else if (i != 802) {
                        imageView.setImageBitmap(bitmap);
                    } else {
                        imageView.setImageBitmap(com.mbridge.msdk.video.dynview.i.a.a().a(bitmap, 0));
                    }
                }

                public final void onFailedLoad(String str, String str2) {
                    try {
                        int a2 = k.a(imageView.getContext(), "mbridge_icon_play_bg", "drawable");
                        imageView.setBackgroundColor(Color.parseColor(a.this.f));
                        imageView.setImageResource(a2);
                        imageView.setScaleType(ImageView.ScaleType.CENTER);
                    } catch (Exception e) {
                        q.a("DataEnergizeWrapper", e.getMessage());
                    }
                }
            });
        }
    }

    private void a(String str, ImageView imageView, com.mbridge.msdk.video.dynview.b bVar, View view) {
        final ImageView imageView2 = imageView;
        final String str2 = str;
        final com.mbridge.msdk.video.dynview.b bVar2 = bVar;
        final View view2 = view;
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, (c) new c() {
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                ImageView imageView;
                if (bitmap != null && !bitmap.isRecycled() && (imageView = imageView2) != null) {
                    imageView.setImageBitmap(bitmap);
                    if (a.this.b != null) {
                        a.this.b.put(SameMD5.getMD5(str2), bitmap);
                        a.a(a.this, bVar2, view2);
                    }
                }
            }

            public final void onFailedLoad(String str, String str2) {
                a.this.b.put(SameMD5.getMD5(str2), a.this.a());
                a.a(a.this, bVar2, view2);
            }
        });
    }

    private int a(String str) {
        return k.a(com.mbridge.msdk.foundation.controller.a.e().g(), str, "id");
    }

    /* access modifiers changed from: private */
    public Bitmap a() {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_4444);
            bitmap.eraseColor(Color.parseColor(this.d));
            return bitmap;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return bitmap;
            }
            e2.printStackTrace();
            return bitmap;
        }
    }

    private void b() {
        com.mbridge.msdk.video.dynview.i.a.a.a().b();
        b bVar = this.a;
        if (bVar != null) {
            bVar.b();
            this.a = null;
        }
        Map<String, Bitmap> map = this.b;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.b.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        if (!(next == null || next.getValue() == null || ((Bitmap) next.getValue()).isRecycled())) {
                            ((Bitmap) next.getValue()).recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.b.clear();
        }
    }

    static /* synthetic */ void a(a aVar, Map map, List list, int i) {
        if (map != null && map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof com.mbridge.msdk.video.dynview.d.a) && list != null && list.size() > 1) {
            ((com.mbridge.msdk.video.dynview.d.a) map.get("choice_one_callback")).a((CampaignEx) list.get(i));
            aVar.b();
        }
    }

    static /* synthetic */ void a(a aVar, Map map) {
        if (map != null && map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof com.mbridge.msdk.video.dynview.d.a)) {
            ((com.mbridge.msdk.video.dynview.d.a) map.get("choice_one_callback")).a();
            aVar.b();
        }
    }

    static /* synthetic */ void a(a aVar, com.mbridge.msdk.video.dynview.b bVar, View view) {
        Map<String, Bitmap> map = aVar.b;
        if (map != null && map.size() > 1) {
            new com.mbridge.msdk.video.dynview.h.b();
            Map<String, Bitmap> map2 = aVar.b;
            if (view != null) {
                com.mbridge.msdk.video.dynview.i.a.a.a().a(map2, bVar, view);
            }
        }
    }
}
