package com.mbridge.msdk.out;

public enum ZoomOutTypeEnum {
    FloatBall(1),
    BigView(4),
    MediumView(3),
    SmallView(2);
    
    private int index;

    private ZoomOutTypeEnum(int i) {
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }
}
