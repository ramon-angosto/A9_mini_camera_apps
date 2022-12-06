package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;

/* compiled from: InteractViewFactory */
public class e {
    public static c a(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, int i, int i2, int i3, int i4) {
        if (context == null || dynamicBaseWidget == null || gVar == null) {
            return null;
        }
        String F = gVar.F();
        char c = 65535;
        int hashCode = F.hashCode();
        if (hashCode != 50) {
            if (hashCode != 1598) {
                if (hashCode != 1600) {
                    switch (hashCode) {
                        case 53:
                            if (F.equals("5")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 54:
                            if (F.equals("6")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 55:
                            if (F.equals("7")) {
                                c = 9;
                                break;
                            }
                            break;
                        case 56:
                            if (F.equals("8")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 57:
                            if (F.equals("9")) {
                                c = 0;
                                break;
                            }
                            break;
                        default:
                            switch (hashCode) {
                                case 1568:
                                    if (F.equals("11")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case 1569:
                                    if (F.equals("12")) {
                                        c = 6;
                                        break;
                                    }
                                    break;
                                case 1570:
                                    if (F.equals("13")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 1571:
                                    if (F.equals("14")) {
                                        c = 10;
                                        break;
                                    }
                                    break;
                                default:
                                    switch (hashCode) {
                                        case 1573:
                                            if (F.equals("16")) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                        case 1574:
                                            if (F.equals("17")) {
                                                c = 11;
                                                break;
                                            }
                                            break;
                                        case 1575:
                                            if (F.equals("18")) {
                                                c = 12;
                                                break;
                                            }
                                            break;
                                    }
                            }
                    }
                } else if (F.equals("22")) {
                    c = 14;
                }
            } else if (F.equals("20")) {
                c = 13;
            }
        } else if (F.equals("2")) {
            c = 8;
        }
        switch (c) {
            case 0:
            case 1:
                return new i(context, dynamicBaseWidget, gVar, F, i, i2, i4);
            case 2:
                return new k(context, dynamicBaseWidget, gVar);
            case 3:
            case 4:
                return new h(context, dynamicBaseWidget, gVar);
            case 5:
                return new g(context, dynamicBaseWidget, gVar);
            case 6:
                return new j(context, dynamicBaseWidget, gVar);
            case 7:
                if (gVar.G() == 1) {
                    return new k(context, dynamicBaseWidget, gVar);
                }
                return new j(context, dynamicBaseWidget, gVar);
            case 8:
                return new b(context, dynamicBaseWidget, gVar);
            case 9:
            case 10:
                return new f(context, dynamicBaseWidget, gVar);
            case 11:
            case 12:
                return new m(context, dynamicBaseWidget, gVar, F, i3);
            case 13:
                return new a(context, dynamicBaseWidget, gVar);
            case 14:
                return new l(context, dynamicBaseWidget, gVar);
            default:
                return null;
        }
    }
}
