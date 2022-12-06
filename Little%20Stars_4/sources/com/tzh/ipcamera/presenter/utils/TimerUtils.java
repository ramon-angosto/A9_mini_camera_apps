package com.tzh.ipcamera.presenter.utils;

import android.os.Handler;
import com.tzh.ipcamera.presenter.LogUtils;
import java.util.Timer;
import java.util.TimerTask;

public class TimerUtils {
    /* access modifiers changed from: private */
    public int action;
    private long duration;
    /* access modifiers changed from: private */
    public boolean isTimerStart = false;
    LogUtils logEx = LogUtils.setLogger(TimerUtils.class);
    /* access modifiers changed from: private */
    public Handler mHandler;
    private Task mTask = null;
    private Timer mTimer = null;

    public TimerUtils(Handler handler, long j, int i) {
        this.mHandler = handler;
        this.action = i;
        this.duration = j;
    }

    private void initTimer() {
        if (this.mTimer == null) {
            this.mTimer = new Timer();
            this.mTask = new Task();
        }
    }

    public void start() {
        if (this.mTimer == null) {
            initTimer();
            this.logEx.e("TimerUtils start");
            this.mTimer.schedule(this.mTask, 50, this.duration);
        }
    }

    public void cancel() {
        if (this.mTimer != null) {
            this.logEx.e("TimerUtils cancel");
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    private class Task extends TimerTask {
        private Task() {
        }

        public void run() {
            if (TimerUtils.this.mHandler != null) {
                TimerUtils.this.mHandler.sendEmptyMessage(TimerUtils.this.action);
                boolean unused = TimerUtils.this.isTimerStart = false;
            }
        }
    }
}
