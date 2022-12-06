package com.shix.shixipc.utils;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import java.util.Locale;

public class SystemTTS extends UtteranceProgressListener implements TextToSpeech.OnUtteranceCompletedListener {
    private static SystemTTS singleton;
    /* access modifiers changed from: private */
    public boolean isSuccess = true;
    private Context mContext;
    /* access modifiers changed from: private */
    public TextToSpeech textToSpeech;

    public static SystemTTS getInstance(Context context) {
        if (singleton == null) {
            synchronized (SystemTTS.class) {
                if (singleton == null) {
                    singleton = new SystemTTS(context);
                    CommonUtil.Log(1, "SystemTTS getInstance 1");
                } else {
                    CommonUtil.Log(1, "SystemTTS getInstance 2");
                }
            }
        }
        return singleton;
    }

    private SystemTTS(Context context) {
        this.mContext = context.getApplicationContext();
        this.textToSpeech = new TextToSpeech(this.mContext, new TextToSpeech.OnInitListener() {
            public void onInit(int i) {
                if (i == 0) {
                    CommonUtil.Log(1, "SystemTTS i == TextToSpeech.SUCCESS");
                    int language = SystemTTS.this.textToSpeech.setLanguage(Locale.CHINA);
                    SystemTTS.this.textToSpeech.setPitch(1.0f);
                    SystemTTS.this.textToSpeech.setSpeechRate(1.0f);
                    SystemTTS.this.textToSpeech.setOnUtteranceProgressListener(SystemTTS.this);
                    SystemTTS.this.textToSpeech.setOnUtteranceCompletedListener(SystemTTS.this);
                    if (language == -1 || language == -2) {
                        boolean unused = SystemTTS.this.isSuccess = false;
                        CommonUtil.Log(1, "SystemTTS isSuccess = false");
                    }
                }
            }
        });
    }

    public void playText(String str) {
        TextToSpeech textToSpeech2;
        if (this.isSuccess && (textToSpeech2 = this.textToSpeech) != null) {
            textToSpeech2.speak(str, 1, (Bundle) null, (String) null);
        }
    }

    public void stopSpeak() {
        TextToSpeech textToSpeech2 = this.textToSpeech;
        if (textToSpeech2 != null) {
            textToSpeech2.stop();
        }
    }

    public void onUtteranceCompleted(String str) {
        CommonUtil.Log(1, "SystemTTS onUtteranceCompleted");
    }

    public void onStart(String str) {
        CommonUtil.Log(1, "SystemTTS onStart");
    }

    public void onDone(String str) {
        CommonUtil.Log(1, "SystemTTS onDone");
    }

    public void onError(String str) {
        CommonUtil.Log(1, "SystemTTS onError");
    }
}
