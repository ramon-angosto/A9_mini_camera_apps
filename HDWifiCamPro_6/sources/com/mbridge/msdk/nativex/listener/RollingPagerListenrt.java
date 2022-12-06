package com.mbridge.msdk.nativex.listener;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.a;
import com.mbridge.msdk.foundation.same.report.c;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RollingPagerListenrt implements ViewPager.OnPageChangeListener {
    private NativeListener.FilpListener FilpListening;
    private List<Frame> frames;
    private List<Integer> list = new ArrayList();
    private c reportController;
    private String unit_id;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        this.FilpListening = filpListener;
    }

    public void setCampList(List<Frame> list2, Context context, String str) {
        this.frames = list2;
        this.reportController = new c(context, 2);
        this.unit_id = str;
        this.list.clear();
        reportRollBC(0);
    }

    public void onPageSelected(int i) {
        reportRollBC(i);
    }

    public void reportRollBC(int i) {
        NativeListener.FilpListener filpListener = this.FilpListening;
        if (filpListener != null) {
            filpListener.filpEvent(i);
        }
        if (!this.list.contains(Integer.valueOf(i))) {
            this.list.add(Integer.valueOf(i));
            Frame frame = this.frames.get(i);
            List<CampaignEx> campaigns = frame.getCampaigns();
            if (campaigns != null && !campaigns.isEmpty()) {
                CampaignEx campaignEx = campaigns.get(0);
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < campaigns.size(); i2++) {
                    campaignEx = campaigns.get(i2);
                    if (i2 == campaigns.size() - 1) {
                        sb.append(campaignEx.getId());
                    } else {
                        sb.append(campaignEx.getId() + ",");
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("rid_n", campaignEx.getRequestId());
                hashMap.put("frame_id", (i + 1) + "");
                hashMap.put("template", Integer.valueOf(frame.getTemplate()));
                hashMap.put("cids", sb.toString());
                hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.unit_id);
                String a = d.a("2000005", (Map<String, Object>) hashMap);
                if (a.a().c()) {
                    a.a().a(a);
                } else {
                    this.reportController.a("native_rollbc", a, this.unit_id, frame);
                }
            }
        }
    }
}
