package com.huawei.android.pushselfshow.utils;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import java.lang.reflect.Field;
import object.p2pipcam.utils.DataBaseHelper;

public class d {
    public static int a(Context context, String str) {
        return a(context, "string", str);
    }

    public static int a(Context context, String str, String str2) {
        String str3;
        StringBuilder sb;
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    e.b("ResourceLoader", "Error-resourceType=" + str + "--resourceName=" + str2 + "--resourceId =" + identifier);
                }
            }
            return identifier;
        } catch (ClassNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            str3 = "!!!! ResourceLoader: ClassNotFoundException-resourceType=";
            sb.append(str3);
            sb.append(str);
            sb.append("--resourceName=");
            sb.append(str2);
            e.c("ResourceLoader", sb.toString(), e);
            return 0;
        } catch (NoSuchFieldException e2) {
            e = e2;
            sb = new StringBuilder();
            str3 = "!!!! ResourceLoader: NoSuchFieldException-resourceType=";
            sb.append(str3);
            sb.append(str);
            sb.append("--resourceName=");
            sb.append(str2);
            e.c("ResourceLoader", sb.toString(), e);
            return 0;
        } catch (NumberFormatException e3) {
            e = e3;
            sb = new StringBuilder();
            str3 = "!!!! ResourceLoader: NumberFormatException-resourceType=";
            sb.append(str3);
            sb.append(str);
            sb.append("--resourceName=");
            sb.append(str2);
            e.c("ResourceLoader", sb.toString(), e);
            return 0;
        } catch (IllegalAccessException e4) {
            e = e4;
            sb = new StringBuilder();
            str3 = "!!!! ResourceLoader: IllegalAccessException-resourceType=";
            sb.append(str3);
            sb.append(str);
            sb.append("--resourceName=");
            sb.append(str2);
            e.c("ResourceLoader", sb.toString(), e);
            return 0;
        } catch (IllegalArgumentException e5) {
            e = e5;
            sb = new StringBuilder();
            str3 = "!!!! ResourceLoader: IllegalArgumentException-resourceType=";
            sb.append(str3);
            sb.append(str);
            sb.append("--resourceName=");
            sb.append(str2);
            e.c("ResourceLoader", sb.toString(), e);
            return 0;
        }
    }

    public static int b(Context context, String str) {
        return a(context, "plurals", str);
    }

    public static int c(Context context, String str) {
        return a(context, "layout", str);
    }

    public static int d(Context context, String str) {
        return a(context, DataBaseHelper.KEY_ID, str);
    }

    public static int e(Context context, String str) {
        return a(context, "color", str);
    }

    public static int f(Context context, String str) {
        return a(context, "drawable", str);
    }
}
