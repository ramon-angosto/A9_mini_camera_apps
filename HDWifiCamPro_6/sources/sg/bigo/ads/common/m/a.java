package sg.bigo.ads.common.m;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import sg.bigo.ads.common.utils.o;

public final class a {
    public final Set<String> a = new HashSet();
    public final Set<String> b = new HashSet();

    public a(Context context) {
        XmlResourceParser a2 = a(context);
        if (a2 != null) {
            try {
                int depth = a2.getDepth();
                while (true) {
                    int next = a2.next();
                    if (next == 1) {
                        return;
                    }
                    if (next == 3 && a2.getDepth() <= depth) {
                        return;
                    }
                    if (next == 2 && "queries".equalsIgnoreCase(a2.getName())) {
                        a(a2);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static XmlResourceParser a(Context context) {
        Method method;
        AssetManager assets = context.getAssets();
        try {
            Method[] declaredMethods = assets.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                sg.bigo.ads.common.k.a.a(0, 3, "QueryInfo", "method->".concat(String.valueOf(method)));
                if (method.getName().equals("addAssetPath") && method.getParameterTypes() != null && method.getParameterTypes().length == 1 && method.getParameterTypes()[0].getSimpleName().equals(String.class.getSimpleName())) {
                    break;
                }
                i++;
            }
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return assets.openXmlResourceParser(((Integer) method.invoke(assets, new Object[]{context.getApplicationInfo().sourceDir})).intValue(), "AndroidManifest.xml");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(XmlResourceParser xmlResourceParser) {
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                return;
            }
            if (next == 2) {
                if (xmlResourceParser.getName().equals("intent")) {
                    int depth2 = xmlResourceParser.getDepth();
                    while (true) {
                        int next2 = xmlResourceParser.next();
                        if (next2 == 1 || (next2 == 3 && xmlResourceParser.getDepth() <= depth2)) {
                            break;
                        } else if (next2 == 2) {
                            String name = xmlResourceParser.getName();
                            char c = 65535;
                            if (name.hashCode() == -1422950858 && name.equals("action")) {
                                c = 0;
                            }
                            if (c == 0) {
                                String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                if (!o.b(attributeValue)) {
                                    this.a.add(attributeValue);
                                }
                            }
                        }
                    }
                } else if (xmlResourceParser.getName().equals("package")) {
                    String attributeValue2 = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                    if (!o.b(attributeValue2)) {
                        this.b.add(attributeValue2);
                    }
                }
            }
        }
    }
}
