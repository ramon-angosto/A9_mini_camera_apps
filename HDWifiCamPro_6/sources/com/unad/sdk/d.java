package com.unad.sdk;

import android.content.Context;
import com.unad.sdk.dto.AdList;
import com.unad.sdk.dto.SourceVO;
import java.util.ArrayList;

/* compiled from: UnadAdRuleUtils */
public class d {
    protected static ArrayList<SourceVO> a(AdList adList, SourceVO sourceVO) {
        ArrayList<SourceVO> arrayList = new ArrayList<>();
        for (int i = 0; i < adList.getAdSource().size(); i++) {
            if (sourceVO.getIndex() != adList.getAdSource().get(i).getIndex()) {
                SourceVO sourceVO2 = new SourceVO();
                sourceVO2.setId(adList.getAdSource().get(i).getId());
                sourceVO2.setRate(adList.getAdSource().get(i).getRate());
                sourceVO2.setSource(adList.getAdSource().get(i).getSource());
                sourceVO2.setIndex(adList.getAdSource().get(i).getIndex());
                arrayList.add(sourceVO2);
            }
        }
        return arrayList;
    }

    protected static boolean a(AdList adList, int i) {
        int i2 = 0;
        for (SourceVO rate : adList.getAdSource()) {
            int rate2 = rate.getRate();
            if (rate2 > 0) {
                i2 += rate2;
            }
        }
        if (i >= i2) {
            return true;
        }
        return false;
    }

    protected static SourceVO a(AdList adList, int i, Context context) {
        ArrayList<SourceVO> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < adList.getAdSource().size(); i2++) {
            SourceVO sourceVO = new SourceVO();
            sourceVO.setId(adList.getAdSource().get(i2).getId());
            sourceVO.setRate(adList.getAdSource().get(i2).getRate());
            sourceVO.setSource(adList.getAdSource().get(i2).getSource());
            sourceVO.setIndex(adList.getAdSource().get(i2).getIndex());
            arrayList.add(sourceVO);
        }
        int i3 = 0;
        for (SourceVO sourceVO2 : arrayList) {
            int rate = sourceVO2.getRate();
            if (rate > 0) {
                arrayList2.add(sourceVO2);
                i3 += rate;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i4 >= arrayList2.size()) {
                i4 = 0;
            }
            SourceVO sourceVO3 = (SourceVO) arrayList2.get(i4);
            arrayList3.add(sourceVO3);
            sourceVO3.setRate(sourceVO3.getRate() - 1);
            i4++;
            if (sourceVO3.getRate() == 0) {
                arrayList2.remove(sourceVO3);
                i4 = 0;
            }
        }
        if (i >= arrayList3.size()) {
            i = 0;
        }
        if (i3 == 0) {
            return null;
        }
        return (SourceVO) arrayList3.get(i);
    }
}
