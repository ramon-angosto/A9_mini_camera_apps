package com.shix.shixipc.bean;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

public class YearsModel {
    private int cmd;
    private ArrayList<String> days = new ArrayList<>();
    private int result;

    public int getCmd() {
        return this.cmd;
    }

    public void setCmd(int i) {
        this.cmd = i;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public ArrayList<String> getDays() {
        return this.days;
    }

    public void setDays(ArrayList<String> arrayList) {
        this.days = arrayList;
    }

    private static String getHour(int i) {
        if (i < 10) {
            return MBridgeConstans.ENDCARD_URL_TYPE_PL + i;
        }
        return i + "";
    }

    public static YearsModel jsonToModel(String str) throws JSONException {
        int i;
        int i2;
        int i3;
        YearsModel yearsModel = new YearsModel();
        JSONObject jSONObject = new JSONObject(str);
        yearsModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        yearsModel.setResult(CommonUtil.jasonPaseInt(jSONObject, IronSourceConstants.EVENTS_RESULT, ContentCommon.SHIXFINAL_ERRORINT));
        int jasonPaseInt = CommonUtil.jasonPaseInt(jSONObject, "year", ContentCommon.SHIXFINAL_ERRORINT);
        if (jasonPaseInt < 2018 || jasonPaseInt > 2025) {
            jasonPaseInt = 2020;
        }
        int jasonPaseInt2 = CommonUtil.jasonPaseInt(jSONObject, "month[0]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt3 = CommonUtil.jasonPaseInt(jSONObject, "month[1]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt4 = CommonUtil.jasonPaseInt(jSONObject, "month[2]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt5 = CommonUtil.jasonPaseInt(jSONObject, "month[3]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt6 = CommonUtil.jasonPaseInt(jSONObject, "month[4]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt7 = CommonUtil.jasonPaseInt(jSONObject, "month[5]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt8 = CommonUtil.jasonPaseInt(jSONObject, "month[6]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt9 = CommonUtil.jasonPaseInt(jSONObject, "month[7]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt10 = CommonUtil.jasonPaseInt(jSONObject, "month[8]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt11 = CommonUtil.jasonPaseInt(jSONObject, "month[9]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt12 = CommonUtil.jasonPaseInt(jSONObject, "month[10]", ContentCommon.SHIXFINAL_ERRORINT);
        int jasonPaseInt13 = CommonUtil.jasonPaseInt(jSONObject, "month[11]", ContentCommon.SHIXFINAL_ERRORINT);
        StringBuilder sb = new StringBuilder();
        sb.append("YearsModel jsonToModel month0:");
        sb.append(jasonPaseInt2);
        sb.append("  month1:");
        sb.append(jasonPaseInt3);
        sb.append("  month2:");
        sb.append(jasonPaseInt4);
        sb.append(" month3:");
        sb.append(jasonPaseInt5);
        sb.append(" month4:");
        sb.append(jasonPaseInt6);
        sb.append(" month5:");
        sb.append(jasonPaseInt7);
        sb.append(" month6:");
        sb.append(jasonPaseInt8);
        sb.append(" month7:");
        sb.append(jasonPaseInt9);
        sb.append(" month8:");
        sb.append(jasonPaseInt10);
        sb.append(" month9:");
        sb.append(jasonPaseInt11);
        YearsModel yearsModel2 = yearsModel;
        sb.append(" month10:");
        sb.append(jasonPaseInt12);
        sb.append("  month11:");
        sb.append(jasonPaseInt13);
        CommonUtil.Log(1, sb.toString());
        ArrayList arrayList = new ArrayList();
        int i4 = jasonPaseInt13;
        int i5 = jasonPaseInt12;
        if (jasonPaseInt2 > 0) {
            i3 = jasonPaseInt11;
            int i6 = 0;
            for (int i7 = 31; i6 < i7; i7 = 31) {
                boolean z = CommonUtil.get(jasonPaseInt2, i6);
                int i8 = jasonPaseInt10;
                StringBuilder sb2 = new StringBuilder();
                int i9 = jasonPaseInt9;
                sb2.append(" month0:");
                sb2.append(jasonPaseInt2);
                sb2.append("  isHave:");
                sb2.append(z);
                sb2.append("   i:");
                sb2.append(i6);
                CommonUtil.Log(1, sb2.toString());
                if (z) {
                    arrayList.add(jasonPaseInt + "_01_" + getHour(i6 + 1));
                }
                i6++;
                jasonPaseInt10 = i8;
                jasonPaseInt9 = i9;
            }
            i = jasonPaseInt9;
            i2 = jasonPaseInt10;
        } else {
            i = jasonPaseInt9;
            i2 = jasonPaseInt10;
            i3 = jasonPaseInt11;
        }
        if (jasonPaseInt3 > 0) {
            for (int i10 = 0; i10 < 31; i10++) {
                boolean z2 = CommonUtil.get(jasonPaseInt3, i10);
                CommonUtil.Log(1, " month9:" + jasonPaseInt3 + "  isHave:" + z2 + "   i:" + i10);
                if (z2) {
                    arrayList.add(jasonPaseInt + "_02_" + getHour(i10 + 1));
                }
            }
        }
        if (jasonPaseInt4 > 0) {
            for (int i11 = 0; i11 < 31; i11++) {
                boolean z3 = CommonUtil.get(jasonPaseInt4, i11);
                CommonUtil.Log(1, " month9:" + jasonPaseInt4 + "  isHave:" + z3 + "   i:" + i11);
                if (z3) {
                    arrayList.add(jasonPaseInt + "_03_" + getHour(i11 + 1));
                }
            }
        }
        if (jasonPaseInt5 > 0) {
            for (int i12 = 0; i12 < 31; i12++) {
                boolean z4 = CommonUtil.get(jasonPaseInt5, i12);
                CommonUtil.Log(1, " month9:" + jasonPaseInt5 + "  isHave:" + z4 + "   i:" + i12);
                if (z4) {
                    arrayList.add(jasonPaseInt + "_04_" + getHour(i12 + 1));
                }
            }
        }
        if (jasonPaseInt6 > 0) {
            for (int i13 = 0; i13 < 31; i13++) {
                boolean z5 = CommonUtil.get(jasonPaseInt6, i13);
                CommonUtil.Log(1, " month9:" + jasonPaseInt6 + "  isHave:" + z5 + "   i:" + i13);
                if (z5) {
                    arrayList.add(jasonPaseInt + "_05_" + getHour(i13 + 1));
                }
            }
        }
        if (jasonPaseInt7 > 0) {
            for (int i14 = 0; i14 < 31; i14++) {
                boolean z6 = CommonUtil.get(jasonPaseInt7, i14);
                CommonUtil.Log(1, " month9:" + jasonPaseInt7 + "  isHave:" + z6 + "   i:" + i14);
                if (z6) {
                    arrayList.add(jasonPaseInt + "_06_" + (i14 + 1));
                }
            }
        }
        if (jasonPaseInt8 > 0) {
            for (int i15 = 0; i15 < 31; i15++) {
                boolean z7 = CommonUtil.get(jasonPaseInt8, i15);
                CommonUtil.Log(1, " month9:" + jasonPaseInt8 + "  isHave:" + z7 + "   i:" + i15);
                if (z7) {
                    arrayList.add(jasonPaseInt + "_07_" + (i15 + 1));
                }
            }
        }
        if (i > 0) {
            int i16 = 0;
            while (i16 < 31) {
                int i17 = i;
                boolean z8 = CommonUtil.get(i17, i16);
                CommonUtil.Log(1, " month9:" + i17 + "  isHave:" + z8 + "   i:" + i16);
                if (z8) {
                    arrayList.add(jasonPaseInt + "_08_" + getHour(i16 + 1));
                }
                i16++;
                i = i17;
            }
        }
        if (i2 > 0) {
            int i18 = 0;
            while (i18 < 31) {
                int i19 = i2;
                boolean z9 = CommonUtil.get(i19, i18);
                CommonUtil.Log(1, " month9:" + i19 + "  isHave:" + z9 + "   i:" + i18);
                if (z9) {
                    arrayList.add(jasonPaseInt + "_09_" + getHour(i18 + 1));
                }
                i18++;
                i2 = i19;
            }
        }
        if (i3 > 0) {
            int i20 = 0;
            while (i20 < 31) {
                int i21 = i3;
                boolean z10 = CommonUtil.get(i21, i20);
                CommonUtil.Log(1, " month9:" + i21 + "  isHave:" + z10 + "   i:" + i20);
                if (z10) {
                    arrayList.add(jasonPaseInt + "_10_" + getHour(i20 + 1));
                }
                i20++;
                i3 = i21;
            }
        }
        if (i5 > 0) {
            int i22 = 0;
            while (i22 < 31) {
                int i23 = i5;
                boolean z11 = CommonUtil.get(i23, i22);
                CommonUtil.Log(1, " month9:" + i23 + "  isHave:" + z11 + "   i:" + i22);
                if (z11) {
                    arrayList.add(jasonPaseInt + "_11_" + getHour(i22 + 1));
                }
                i22++;
                i5 = i23;
            }
        }
        if (i4 > 0) {
            int i24 = 0;
            while (i24 < 31) {
                int i25 = i4;
                boolean z12 = CommonUtil.get(i25, i24);
                CommonUtil.Log(1, " month9:" + i25 + "  isHave:" + z12 + "   i:" + i24);
                if (z12) {
                    arrayList.add(jasonPaseInt + "_12_" + getHour(i24 + 1));
                }
                i24++;
                i4 = i25;
            }
        }
        YearsModel yearsModel3 = yearsModel2;
        yearsModel3.setDays(arrayList);
        Collections.reverse(arrayList);
        return yearsModel3;
    }
}
