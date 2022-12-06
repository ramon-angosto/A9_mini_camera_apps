package sg.bigo.ads.core.player.b;

import android.content.Context;
import android.view.TextureView;
import android.widget.FrameLayout;

public final class d extends TextureView {
    int a;
    int b;
    private int c;

    public d(Context context, int i, int i2, int i3) {
        super(context);
        this.a = i;
        this.b = i2;
        this.c = i3;
        int i4 = this.c;
        setLayoutParams((i4 == 1 || i4 == 4) ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-1, -2, 17));
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        if (r11 != 4) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        if ((((double) r11) * r5) < (((double) r12) * r3)) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        if ((((double) r11) * r5) >= (((double) r12) * r3)) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        r5 = (((double) r12) * r3) / ((double) r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r12 = r10.a
            if (r12 <= 0) goto L_0x00a6
            int r12 = r10.b
            if (r12 > 0) goto L_0x000d
            goto L_0x00a6
        L_0x000d:
            int r12 = android.view.View.MeasureSpec.getMode(r11)
            int r11 = android.view.View.MeasureSpec.getSize(r11)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r0) goto L_0x0020
            if (r12 == 0) goto L_0x0020
            r0 = 1073741824(0x40000000, float:2.0)
            if (r12 == r0) goto L_0x0020
            return
        L_0x0020:
            int r12 = r10.c
            r0 = 4
            r1 = 2
            r2 = 1
            if (r12 == r2) goto L_0x003d
            if (r12 == r1) goto L_0x003d
            if (r12 != r0) goto L_0x002c
            goto L_0x003d
        L_0x002c:
            r12 = 1065353216(0x3f800000, float:1.0)
            int r0 = r10.b
            float r0 = (float) r0
            float r0 = r0 * r12
            float r12 = (float) r11
            float r0 = r0 * r12
            int r12 = r10.a
            float r12 = (float) r12
            float r0 = r0 / r12
            int r12 = (int) r0
            r10.setMeasuredDimension(r11, r12)
            return
        L_0x003d:
            int r11 = r10.c
            int r12 = r10.getMeasuredWidth()
            double r3 = (double) r12
            int r12 = r10.getMeasuredHeight()
            double r5 = (double) r12
            android.content.Context r12 = r10.getContext()
            sg.bigo.ads.common.utils.d.c(r12)
            r7 = 0
            int r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r12 > 0) goto L_0x0061
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0061
            int r11 = r10.a
            double r3 = (double) r11
            int r11 = r10.b
            double r5 = (double) r11
            goto L_0x00a0
        L_0x0061:
            if (r12 <= 0) goto L_0x0097
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 > 0) goto L_0x0071
            int r11 = r10.b
            double r11 = (double) r11
            double r11 = r11 * r3
            int r0 = r10.a
            double r0 = (double) r0
            double r5 = r11 / r0
            goto L_0x00a0
        L_0x0071:
            if (r11 == r2) goto L_0x0085
            if (r11 == r1) goto L_0x0078
            if (r11 == r0) goto L_0x0085
            goto L_0x00a0
        L_0x0078:
            int r11 = r10.a
            double r0 = (double) r11
            double r0 = r0 * r5
            int r12 = r10.b
            double r7 = (double) r12
            double r7 = r7 * r3
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0097
            goto L_0x0091
        L_0x0085:
            int r11 = r10.a
            double r0 = (double) r11
            double r0 = r0 * r5
            int r12 = r10.b
            double r7 = (double) r12
            double r7 = r7 * r3
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x0097
        L_0x0091:
            double r0 = (double) r12
            double r0 = r0 * r3
            double r11 = (double) r11
            double r5 = r0 / r11
            goto L_0x00a0
        L_0x0097:
            int r11 = r10.a
            double r11 = (double) r11
            double r11 = r11 * r5
            int r0 = r10.b
            double r0 = (double) r0
            double r3 = r11 / r0
        L_0x00a0:
            int r11 = (int) r3
            int r12 = (int) r5
            r10.setMeasuredDimension(r11, r12)
            return
        L_0x00a6:
            r11 = 0
            java.lang.String r12 = "VideoTextureView"
            java.lang.String r0 = "video width or height is invalidate"
            sg.bigo.ads.common.k.a.a(r11, r12, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.b.d.onMeasure(int, int):void");
    }
}
