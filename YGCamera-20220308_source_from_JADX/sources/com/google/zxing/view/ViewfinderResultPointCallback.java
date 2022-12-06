package com.google.zxing.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

public final class ViewfinderResultPointCallback implements ResultPointCallback {
    private final ViewfinderView viewfinderView;

    public ViewfinderResultPointCallback(ViewfinderView viewfinderView2) {
        this.viewfinderView = viewfinderView2;
    }

    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.viewfinderView.addPossibleResultPoint(resultPoint);
    }
}
