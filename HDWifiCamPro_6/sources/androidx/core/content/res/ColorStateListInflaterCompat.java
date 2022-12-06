package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList inflate(Resources resources, int i, Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList createFromXml(android.content.res.Resources r4, org.xmlpull.v1.XmlPullParser r5, android.content.res.Resources.Theme r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0004:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x000f
            r3 = 1
            if (r1 == r3) goto L_0x000f
            goto L_0x0004
        L_0x000f:
            if (r1 != r2) goto L_0x0016
            android.content.res.ColorStateList r4 = createFromXmlInner(r4, r5, r0, r6)
            return r4
        L_0x0016:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.createFromXml(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList inflate(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r17
            r1 = r19
            r2 = r20
            int r3 = r18.getDepth()
            r4 = 1
            int r3 = r3 + r4
            r5 = 20
            int[][] r5 = new int[r5][]
            int r6 = r5.length
            int[] r6 = new int[r6]
            r7 = 0
            r8 = r7
        L_0x0015:
            int r9 = r18.next()
            if (r9 == r4) goto L_0x00d0
            int r10 = r18.getDepth()
            if (r10 >= r3) goto L_0x0024
            r11 = 3
            if (r9 == r11) goto L_0x00d0
        L_0x0024:
            r11 = 2
            if (r9 != r11) goto L_0x00cd
            if (r10 > r3) goto L_0x00cd
            java.lang.String r9 = r18.getName()
            java.lang.String r10 = "item"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0037
            goto L_0x00cd
        L_0x0037:
            int[] r9 = androidx.core.R.styleable.ColorStateListItem
            android.content.res.TypedArray r9 = obtainAttributes(r0, r2, r1, r9)
            int r10 = androidx.core.R.styleable.ColorStateListItem_android_color
            r11 = -1
            int r10 = r9.getResourceId(r10, r11)
            r12 = -65281(0xffffffffffff00ff, float:NaN)
            if (r10 == r11) goto L_0x0063
            boolean r11 = isColorInt(r0, r10)
            if (r11 != 0) goto L_0x0063
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)     // Catch:{ Exception -> 0x005c }
            android.content.res.ColorStateList r10 = createFromXml(r0, r10, r2)     // Catch:{ Exception -> 0x005c }
            int r10 = r10.getDefaultColor()     // Catch:{ Exception -> 0x005c }
            goto L_0x0069
        L_0x005c:
            int r10 = androidx.core.R.styleable.ColorStateListItem_android_color
            int r10 = r9.getColor(r10, r12)
            goto L_0x0069
        L_0x0063:
            int r10 = androidx.core.R.styleable.ColorStateListItem_android_color
            int r10 = r9.getColor(r10, r12)
        L_0x0069:
            r11 = 1065353216(0x3f800000, float:1.0)
            int r12 = androidx.core.R.styleable.ColorStateListItem_android_alpha
            boolean r12 = r9.hasValue(r12)
            if (r12 == 0) goto L_0x007a
            int r12 = androidx.core.R.styleable.ColorStateListItem_android_alpha
            float r11 = r9.getFloat(r12, r11)
            goto L_0x0088
        L_0x007a:
            int r12 = androidx.core.R.styleable.ColorStateListItem_alpha
            boolean r12 = r9.hasValue(r12)
            if (r12 == 0) goto L_0x0088
            int r12 = androidx.core.R.styleable.ColorStateListItem_alpha
            float r11 = r9.getFloat(r12, r11)
        L_0x0088:
            r9.recycle()
            int r9 = r19.getAttributeCount()
            int[] r12 = new int[r9]
            r13 = r7
            r14 = r13
        L_0x0093:
            if (r13 >= r9) goto L_0x00b8
            int r15 = r1.getAttributeNameResource(r13)
            r4 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r4) goto L_0x00b4
            r4 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r4) goto L_0x00b4
            int r4 = androidx.core.R.attr.alpha
            if (r15 == r4) goto L_0x00b4
            int r4 = r14 + 1
            boolean r16 = r1.getAttributeBooleanValue(r13, r7)
            if (r16 == 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            int r15 = -r15
        L_0x00b1:
            r12[r14] = r15
            r14 = r4
        L_0x00b4:
            int r13 = r13 + 1
            r4 = 1
            goto L_0x0093
        L_0x00b8:
            int[] r4 = android.util.StateSet.trimStateSet(r12, r14)
            int r9 = modulateColorAlpha(r10, r11)
            int[] r6 = androidx.core.content.res.GrowingArrayUtils.append((int[]) r6, (int) r8, (int) r9)
            java.lang.Object[] r4 = androidx.core.content.res.GrowingArrayUtils.append((T[]) r5, (int) r8, r4)
            r5 = r4
            int[][] r5 = (int[][]) r5
            int r8 = r8 + 1
        L_0x00cd:
            r4 = 1
            goto L_0x0015
        L_0x00d0:
            int[] r0 = new int[r8]
            int[][] r1 = new int[r8][]
            java.lang.System.arraycopy(r6, r7, r0, r7, r8)
            java.lang.System.arraycopy(r5, r7, r1, r7, r8)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    private static boolean isColorInt(Resources resources, int i) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            return false;
        }
        return true;
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue = sTempTypedValue.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        sTempTypedValue.set(typedValue2);
        return typedValue2;
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int modulateColorAlpha(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (Math.round(((float) Color.alpha(i)) * f) << 24);
    }
}
