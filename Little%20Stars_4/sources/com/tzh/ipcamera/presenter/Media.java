package com.tzh.ipcamera.presenter;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import com.jxl.app.littlestars.project.R;
import java.io.IOException;

public class Media {
    /* access modifiers changed from: private */
    public MediaPlayer mp = null;

    public Media(Context context) {
        this.mp = MediaPlayer.create(context, R.raw.shutter);
        try {
            if (this.mp != null) {
                this.mp.prepare();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void play() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (Media.this.mp != null) {
                        Media.this.mp.seekTo(0);
                        Media.this.mp.start();
                    }
                } catch (Exception e) {
                    Log.e("", "music error");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void cancel() {
        MediaPlayer mediaPlayer = this.mp;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mp.pause();
        }
    }

    public void destroy() {
        MediaPlayer mediaPlayer = this.mp;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
