package com.baidu.mapapi;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

class q extends Handler {
    q() {
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            PlaceCaterActivity.c.setImageBitmap(((u) message.obj).a());
        } else if (i == 2) {
            ((ImageView) PlaceCaterActivity.o.get(Integer.valueOf(message.arg1))).setImageBitmap(((u) message.obj).a());
        }
    }
}
