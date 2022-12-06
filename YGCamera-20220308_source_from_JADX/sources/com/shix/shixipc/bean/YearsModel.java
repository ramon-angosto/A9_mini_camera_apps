package com.shix.shixipc.bean;

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

    public static YearsModel jsonToModel(String str) throws JSONException {
        int i;
        int i2;
        int i3;
        YearsModel yearsModel = new YearsModel();
        JSONObject jSONObject = new JSONObject(str);
        yearsModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        yearsModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        int jasonPaseInt = CommonUtil.jasonPaseInt(jSONObject, "year", ContentCommon.SHIXFINAL_ERRORINT);
        if (jasonPaseInt < 2018 || jasonPaseInt > 2025) {
            jasonPaseInt = 2019;
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
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(jasonPaseInt);
                    sb3.append("_01_");
                    int i10 = i6 + 1;
                    sb3.append(i10);
                    String sb4 = sb3.toString();
                    if (i6 < 9) {
                        sb4 = jasonPaseInt + "_01_0" + i10;
                    }
                    arrayList.add(sb4);
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
            for (int i11 = 0; i11 < 31; i11++) {
                boolean z2 = CommonUtil.get(jasonPaseInt3, i11);
                CommonUtil.Log(1, " month9:" + jasonPaseInt3 + "  isHave:" + z2 + "   i:" + i11);
                if (z2) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(jasonPaseInt);
                    sb5.append("_02_");
                    int i12 = i11 + 1;
                    sb5.append(i12);
                    String sb6 = sb5.toString();
                    if (i11 < 9) {
                        sb6 = jasonPaseInt + "_02_0" + i12;
                    }
                    arrayList.add(sb6);
                }
            }
        }
        if (jasonPaseInt4 > 0) {
            for (int i13 = 0; i13 < 31; i13++) {
                boolean z3 = CommonUtil.get(jasonPaseInt4, i13);
                CommonUtil.Log(1, " month9:" + jasonPaseInt4 + "  isHave:" + z3 + "   i:" + i13);
                if (z3) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(jasonPaseInt);
                    sb7.append("_03_");
                    int i14 = i13 + 1;
                    sb7.append(i14);
                    String sb8 = sb7.toString();
                    if (i13 < 9) {
                        sb8 = jasonPaseInt + "_03_0" + i14;
                    }
                    arrayList.add(sb8);
                }
            }
        }
        if (jasonPaseInt5 > 0) {
            for (int i15 = 0; i15 < 31; i15++) {
                boolean z4 = CommonUtil.get(jasonPaseInt5, i15);
                CommonUtil.Log(1, " month9:" + jasonPaseInt5 + "  isHave:" + z4 + "   i:" + i15);
                if (z4) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(jasonPaseInt);
                    sb9.append("_04_");
                    int i16 = i15 + 1;
                    sb9.append(i16);
                    String sb10 = sb9.toString();
                    if (i15 < 9) {
                        sb10 = jasonPaseInt + "_04_0" + i16;
                    }
                    arrayList.add(sb10);
                }
            }
        }
        if (jasonPaseInt6 > 0) {
            for (int i17 = 0; i17 < 31; i17++) {
                boolean z5 = CommonUtil.get(jasonPaseInt6, i17);
                CommonUtil.Log(1, " month9:" + jasonPaseInt6 + "  isHave:" + z5 + "   i:" + i17);
                if (z5) {
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(jasonPaseInt);
                    sb11.append("_05_");
                    int i18 = i17 + 1;
                    sb11.append(i18);
                    String sb12 = sb11.toString();
                    if (i17 < 9) {
                        sb12 = jasonPaseInt + "_05_0" + i18;
                    }
                    arrayList.add(sb12);
                }
            }
        }
        if (jasonPaseInt7 > 0) {
            for (int i19 = 0; i19 < 31; i19++) {
                boolean z6 = CommonUtil.get(jasonPaseInt7, i19);
                CommonUtil.Log(1, " month9:" + jasonPaseInt7 + "  isHave:" + z6 + "   i:" + i19);
                if (z6) {
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(jasonPaseInt);
                    sb13.append("_06_");
                    int i20 = i19 + 1;
                    sb13.append(i20);
                    String sb14 = sb13.toString();
                    if (i19 < 9) {
                        sb14 = jasonPaseInt + "_06_0" + i20;
                    }
                    arrayList.add(sb14);
                }
            }
        }
        if (jasonPaseInt8 > 0) {
            for (int i21 = 0; i21 < 31; i21++) {
                boolean z7 = CommonUtil.get(jasonPaseInt8, i21);
                CommonUtil.Log(1, " month9:" + jasonPaseInt8 + "  isHave:" + z7 + "   i:" + i21);
                if (z7) {
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append(jasonPaseInt);
                    sb15.append("_07_");
                    int i22 = i21 + 1;
                    sb15.append(i22);
                    String sb16 = sb15.toString();
                    if (i21 < 9) {
                        sb16 = jasonPaseInt + "_07_0" + i22;
                    }
                    arrayList.add(sb16);
                }
            }
        }
        if (i > 0) {
            int i23 = 0;
            while (i23 < 31) {
                int i24 = i;
                boolean z8 = CommonUtil.get(i24, i23);
                CommonUtil.Log(1, " month9:" + i24 + "  isHave:" + z8 + "   i:" + i23);
                if (z8) {
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append(jasonPaseInt);
                    sb17.append("_08_");
                    int i25 = i23 + 1;
                    sb17.append(i25);
                    String sb18 = sb17.toString();
                    if (i23 < 9) {
                        sb18 = jasonPaseInt + "_08_0" + i25;
                    }
                    arrayList.add(sb18);
                }
                i23++;
                i = i24;
            }
        }
        if (i2 > 0) {
            int i26 = 0;
            while (i26 < 31) {
                int i27 = i2;
                boolean z9 = CommonUtil.get(i27, i26);
                CommonUtil.Log(1, " month9:" + i27 + "  isHave:" + z9 + "   i:" + i26);
                if (z9) {
                    StringBuilder sb19 = new StringBuilder();
                    sb19.append(jasonPaseInt);
                    sb19.append("_09_");
                    int i28 = i26 + 1;
                    sb19.append(i28);
                    String sb20 = sb19.toString();
                    if (i26 < 9) {
                        sb20 = jasonPaseInt + "_09_0" + i28;
                    }
                    arrayList.add(sb20);
                }
                i26++;
                i2 = i27;
            }
        }
        if (i3 > 0) {
            int i29 = 0;
            while (i29 < 31) {
                int i30 = i3;
                boolean z10 = CommonUtil.get(i30, i29);
                CommonUtil.Log(1, " month9:" + i30 + "  isHave:" + z10 + "   i:" + i29);
                if (z10) {
                    StringBuilder sb21 = new StringBuilder();
                    sb21.append(jasonPaseInt);
                    sb21.append("_10_");
                    int i31 = i29 + 1;
                    sb21.append(i31);
                    String sb22 = sb21.toString();
                    if (i29 < 9) {
                        sb22 = jasonPaseInt + "_10_0" + i31;
                    }
                    arrayList.add(sb22);
                }
                i29++;
                i3 = i30;
            }
        }
        if (i5 > 0) {
            int i32 = 0;
            while (i32 < 31) {
                int i33 = i5;
                boolean z11 = CommonUtil.get(i33, i32);
                CommonUtil.Log(1, " month9:" + i33 + "  isHave:" + z11 + "   i:" + i32);
                if (z11) {
                    StringBuilder sb23 = new StringBuilder();
                    sb23.append(jasonPaseInt);
                    sb23.append("_11_");
                    int i34 = i32 + 1;
                    sb23.append(i34);
                    String sb24 = sb23.toString();
                    if (i32 < 9) {
                        sb24 = jasonPaseInt + "_11_0" + i34;
                    }
                    arrayList.add(sb24);
                }
                i32++;
                i5 = i33;
            }
        }
        if (i4 > 0) {
            int i35 = 0;
            while (i35 < 31) {
                int i36 = i4;
                boolean z12 = CommonUtil.get(i36, i35);
                CommonUtil.Log(1, " month9:" + i36 + "  isHave:" + z12 + "   i:" + i35);
                if (z12) {
                    StringBuilder sb25 = new StringBuilder();
                    sb25.append(jasonPaseInt);
                    sb25.append("_12_");
                    int i37 = i35 + 1;
                    sb25.append(i37);
                    String sb26 = sb25.toString();
                    if (i35 < 9) {
                        sb26 = jasonPaseInt + "_12_0" + i37;
                    }
                    arrayList.add(sb26);
                }
                i35++;
                i4 = i36;
            }
        }
        Collections.reverse(arrayList);
        YearsModel yearsModel3 = yearsModel2;
        yearsModel3.setDays(arrayList);
        return yearsModel3;
    }
}
