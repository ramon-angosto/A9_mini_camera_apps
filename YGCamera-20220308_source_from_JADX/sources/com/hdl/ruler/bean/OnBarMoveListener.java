package com.hdl.ruler.bean;

public interface OnBarMoveListener {
    void onBarMoveFinish(long j);

    void onBarMoving(long j);

    void onDragBar(boolean z, long j);

    void onMaxScale();

    void onMinScale();

    void onMoveExceedEndTime();

    void onMoveExceedStartTime();
}
