package com.huawei.android.pushselfshow.richpush.html.a;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue;
import com.huawei.android.pushselfshow.richpush.html.api.b;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class f implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, h {
    public String a = null;
    Handler b = new Handler();
    Runnable c = null;
    boolean d = true;
    /* access modifiers changed from: private */
    public a e = a.MEDIA_NONE;
    /* access modifiers changed from: private */
    public String f = null;
    /* access modifiers changed from: private */
    public int g = PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE;
    private MediaPlayer h = null;
    private int i = 0;
    /* access modifiers changed from: private */
    public NativeToJsMessageQueue j;

    public enum a {
        MEDIA_NONE,
        MEDIA_STARTING,
        MEDIA_RUNNING,
        MEDIA_PAUSED,
        MEDIA_STOPPED
    }

    public f(Context context) {
        e.e("PushSelfShowLog", "init AudioPlayer");
    }

    private void a(a aVar) {
        this.e = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        if (r3 != null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        if (r3 != null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        if (r3 != null) goto L_0x008f;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0085 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0093 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009d A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af A[SYNTHETIC, Splitter:B:42:0x00af] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0093=Splitter:B:31:0x0093, B:26:0x0085=Splitter:B:26:0x0085} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j() {
        /*
            r7 = this;
            java.lang.String r0 = "prepareAsync/prepare error"
            java.lang.String r1 = "close fileInputStream error"
            java.lang.String r2 = "PushSelfShowLog"
            com.huawei.android.pushselfshow.richpush.html.a.f$a r3 = r7.e
            int r3 = r3.ordinal()
            com.huawei.android.pushselfshow.richpush.html.a.f$a r4 = com.huawei.android.pushselfshow.richpush.html.a.f.a.MEDIA_NONE
            int r4 = r4.ordinal()
            r5 = 0
            if (r3 != r4) goto L_0x00b7
            android.media.MediaPlayer r3 = r7.h
            if (r3 != 0) goto L_0x002f
            android.media.MediaPlayer r3 = new android.media.MediaPlayer
            r3.<init>()
            r7.h = r3
            android.media.MediaPlayer r3 = r7.h
            r3.setOnErrorListener(r7)
            android.media.MediaPlayer r3 = r7.h
            r3.setOnPreparedListener(r7)
            android.media.MediaPlayer r3 = r7.h
            r3.setOnCompletionListener(r7)
        L_0x002f:
            r3 = 0
            java.lang.String r4 = r7.f     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            boolean r4 = com.huawei.android.pushselfshow.richpush.html.api.b.a(r4)     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            if (r4 == 0) goto L_0x0050
            android.media.MediaPlayer r4 = r7.h     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            java.lang.String r6 = r7.f     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            r4.setDataSource(r6)     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            android.media.MediaPlayer r4 = r7.h     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            r6 = 3
            r4.setAudioStreamType(r6)     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            com.huawei.android.pushselfshow.richpush.html.a.f$a r4 = com.huawei.android.pushselfshow.richpush.html.a.f.a.MEDIA_STARTING     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            r7.a((com.huawei.android.pushselfshow.richpush.html.a.f.a) r4)     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            android.media.MediaPlayer r4 = r7.h     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            r4.prepareAsync()     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            goto L_0x0080
        L_0x0050:
            java.io.File r4 = new java.io.File     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            java.lang.String r6 = r7.f     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            r4.<init>(r6)     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            boolean r6 = r4.exists()     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            if (r6 == 0) goto L_0x0080
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            r6.<init>(r4)     // Catch:{ RuntimeException -> 0x009e, FileNotFoundException -> 0x0093, IOException -> 0x0085 }
            android.media.MediaPlayer r3 = r7.h     // Catch:{ RuntimeException -> 0x007e, FileNotFoundException -> 0x007c, IOException -> 0x007a, all -> 0x0077 }
            java.io.FileDescriptor r4 = r6.getFD()     // Catch:{ RuntimeException -> 0x007e, FileNotFoundException -> 0x007c, IOException -> 0x007a, all -> 0x0077 }
            r3.setDataSource(r4)     // Catch:{ RuntimeException -> 0x007e, FileNotFoundException -> 0x007c, IOException -> 0x007a, all -> 0x0077 }
            com.huawei.android.pushselfshow.richpush.html.a.f$a r3 = com.huawei.android.pushselfshow.richpush.html.a.f.a.MEDIA_STARTING     // Catch:{ RuntimeException -> 0x007e, FileNotFoundException -> 0x007c, IOException -> 0x007a, all -> 0x0077 }
            r7.a((com.huawei.android.pushselfshow.richpush.html.a.f.a) r3)     // Catch:{ RuntimeException -> 0x007e, FileNotFoundException -> 0x007c, IOException -> 0x007a, all -> 0x0077 }
            android.media.MediaPlayer r3 = r7.h     // Catch:{ RuntimeException -> 0x007e, FileNotFoundException -> 0x007c, IOException -> 0x007a, all -> 0x0077 }
            r3.prepare()     // Catch:{ RuntimeException -> 0x007e, FileNotFoundException -> 0x007c, IOException -> 0x007a, all -> 0x0077 }
            r3 = r6
            goto L_0x0080
        L_0x0077:
            r0 = move-exception
            r3 = r6
            goto L_0x00ad
        L_0x007a:
            r3 = r6
            goto L_0x0085
        L_0x007c:
            r3 = r6
            goto L_0x0093
        L_0x007e:
            r3 = r6
            goto L_0x009e
        L_0x0080:
            if (r3 == 0) goto L_0x00ac
            goto L_0x00a8
        L_0x0083:
            r0 = move-exception
            goto L_0x00ad
        L_0x0085:
            com.huawei.android.pushagent.c.a.e.e(r2, r0)     // Catch:{ all -> 0x0083 }
            com.huawei.android.pushselfshow.richpush.html.a.f$a r0 = com.huawei.android.pushselfshow.richpush.html.a.f.a.MEDIA_NONE     // Catch:{ all -> 0x0083 }
            r7.a((com.huawei.android.pushselfshow.richpush.html.a.f.a) r0)     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x00ac
        L_0x008f:
            r3.close()     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00ac
        L_0x0093:
            com.huawei.android.pushagent.c.a.e.e(r2, r0)     // Catch:{ all -> 0x0083 }
            com.huawei.android.pushselfshow.richpush.html.a.f$a r0 = com.huawei.android.pushselfshow.richpush.html.a.f.a.MEDIA_NONE     // Catch:{ all -> 0x0083 }
            r7.a((com.huawei.android.pushselfshow.richpush.html.a.f.a) r0)     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x00ac
            goto L_0x00a8
        L_0x009e:
            com.huawei.android.pushagent.c.a.e.e(r2, r0)     // Catch:{ all -> 0x0083 }
            com.huawei.android.pushselfshow.richpush.html.a.f$a r0 = com.huawei.android.pushselfshow.richpush.html.a.f.a.MEDIA_NONE     // Catch:{ all -> 0x0083 }
            r7.a((com.huawei.android.pushselfshow.richpush.html.a.f.a) r0)     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x00ac
        L_0x00a8:
            goto L_0x008f
        L_0x00a9:
            com.huawei.android.pushagent.c.a.e.e(r2, r1)
        L_0x00ac:
            return r5
        L_0x00ad:
            if (r3 == 0) goto L_0x00b6
            r3.close()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00b6
        L_0x00b3:
            com.huawei.android.pushagent.c.a.e.e(r2, r1)
        L_0x00b6:
            throw r0
        L_0x00b7:
            com.huawei.android.pushselfshow.richpush.html.a.f$a r0 = com.huawei.android.pushselfshow.richpush.html.a.f.a.MEDIA_STARTING
            int r0 = r0.ordinal()
            if (r3 != r0) goto L_0x00c0
            return r5
        L_0x00c0:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.html.a.f.j():boolean");
    }

    /* access modifiers changed from: private */
    public float k() {
        try {
            return ((float) this.h.getDuration()) / 1000.0f;
        } catch (Exception unused) {
            e.e("PushSelfShowLog", "getDurationInSeconds error ");
            return -1.0f;
        }
    }

    public String a(String str, JSONObject jSONObject) {
        return null;
    }

    public void a() {
        if (j() && this.h != null) {
            h();
        }
    }

    public void a(int i2) {
        try {
            if (j()) {
                this.h.seekTo(i2);
                e.a("PushSelfShowLog", "Send a onStatus update for the new seek");
                return;
            }
            this.i = i2;
        } catch (Exception | IllegalStateException unused) {
            e.a("PushSelfShowLog", "seekToPlaying failed");
        }
    }

    public void a(int i2, int i3, Intent intent) {
    }

    public void a(NativeToJsMessageQueue nativeToJsMessageQueue, String str, String str2, JSONObject jSONObject) {
        int i2;
        if (nativeToJsMessageQueue == null) {
            e.a("PushSelfShowLog", "jsMessageQueue is null while run into Audio Player exec");
            return;
        }
        this.j = nativeToJsMessageQueue;
        if ("preparePlaying".equals(str)) {
            d();
            if (str2 != null) {
                this.a = str2;
                a(jSONObject);
                return;
            }
            e.a("PushSelfShowLog", "Audio exec callback is null ");
        } else if ("startPlaying".equals(str)) {
            a();
        } else if ("seekToPlaying".equals(str)) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.has("milliseconds")) {
                        a(jSONObject.getInt("milliseconds"));
                    }
                } catch (JSONException unused) {
                    e.a("PushSelfShowLog", "seekto error");
                }
            }
        } else if ("pausePlaying".equals(str)) {
            e();
        } else if ("stopPlaying".equals(str)) {
            f();
        } else if ("getPlayingStatus".equals(str)) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.has("frequently") && (i2 = jSONObject.getInt("frequently")) > this.g) {
                        this.g = i2;
                    }
                } catch (JSONException unused2) {
                    e.a("PushSelfShowLog", "seekto error");
                }
            }
            e.e("PushSelfShowLog", "this.frequently is " + this.g);
            g();
        } else {
            nativeToJsMessageQueue.a(str2, d.a.METHOD_NOT_FOUND_EXCEPTION, "error", (JSONObject) null);
        }
    }

    public void a(JSONObject jSONObject) {
        e.e("PushSelfShowLog", " run into Audio player createAudio");
        if (jSONObject != null && jSONObject.has(PushConstants.WEB_URL)) {
            try {
                String string = jSONObject.getString(PushConstants.WEB_URL);
                String a2 = b.a(this.j.a(), string);
                if (a2 == null || a2.length() <= 0) {
                    e.e("PushSelfShowLog", string + "File not exist");
                    this.j.a(this.a, d.a.AUDIO_ONLY_SUPPORT_HTTP, "error", (JSONObject) null);
                } else {
                    this.f = a2;
                    this.j.a(this.a, d.a.OK, "success", (JSONObject) null);
                }
                if (jSONObject.has("pauseOnActivityPause")) {
                    this.d = jSONObject.getBoolean("pauseOnActivityPause");
                }
            } catch (Exception e2) {
                e.d("PushSelfShowLog", "startPlaying failed ", e2);
            }
            e.e("PushSelfShowLog", " this.audioFile = " + this.f);
        }
        this.j.a(this.a, d.a.JSON_EXCEPTION, "error", (JSONObject) null);
        e.e("PushSelfShowLog", " this.audioFile = " + this.f);
    }

    public void b() {
        e.e("PushSelfShowLog", "Audio onResume");
    }

    public void c() {
        e.b("PushSelfShowLog", "Audio onPause and pauseOnActivityPause is %s  this.player is %s", Boolean.valueOf(this.d), this.h);
        d();
    }

    public void d() {
        e.e("PushSelfShowLog", "Audio reset/Destory");
        try {
            this.d = true;
            if (this.h != null) {
                if (this.e == a.MEDIA_RUNNING || this.e == a.MEDIA_PAUSED) {
                    this.h.stop();
                }
                this.h.release();
                this.h = null;
            }
            this.f = null;
            a(a.MEDIA_NONE);
            this.g = PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE;
            this.i = 0;
            if (this.c != null) {
                this.b.removeCallbacks(this.c);
            }
            this.c = null;
        } catch (Exception | IllegalStateException unused) {
            e.a("PushSelfShowLog", "reset music error");
        }
    }

    public void e() {
        MediaPlayer mediaPlayer;
        if (this.e != a.MEDIA_RUNNING || (mediaPlayer = this.h) == null) {
            e.a("PushSelfShowLog", "AudioPlayer Error: pausePlaying() called during invalid state: " + this.e.ordinal());
            return;
        }
        mediaPlayer.pause();
        a(a.MEDIA_PAUSED);
    }

    public void f() {
        if (this.e == a.MEDIA_RUNNING || this.e == a.MEDIA_PAUSED) {
            this.h.pause();
            this.h.seekTo(0);
            e.a("PushSelfShowLog", "stopPlaying is calling stopped");
            a(a.MEDIA_STOPPED);
            return;
        }
        e.a("PushSelfShowLog", "AudioPlayer Error: stopPlaying() called during invalid state: " + this.e.ordinal());
    }

    public void g() {
        e.e("PushSelfShowLog", "getPlayingStatusRb is " + this.c);
        Runnable runnable = this.c;
        if (runnable == null) {
            this.c = new g(this);
        } else {
            try {
                this.b.removeCallbacks(runnable);
            } catch (Exception unused) {
                e.e("PushSelfShowLog", "getPlayingStatus error,handler.removeCallbacks");
            }
        }
        this.b.postDelayed(this.c, (long) this.g);
        e.e("PushSelfShowLog", "handler.postDelayed " + this.g);
    }

    public void h() {
        try {
            this.h.start();
            a(a.MEDIA_RUNNING);
            this.i = 0;
        } catch (Exception e2) {
            e.d("PushSelfShowLog", "play() error ", e2);
        }
    }

    public long i() {
        if (this.e == a.MEDIA_RUNNING || this.e == a.MEDIA_PAUSED) {
            return (long) (this.h.getCurrentPosition() / PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE);
        }
        return -1;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        e.a("PushSelfShowLog", "on completion is calling stopped");
        a(a.MEDIA_STOPPED);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        e.a("PushSelfShowLog", "AudioPlayer.onError(" + i2 + ", " + i3 + ")");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConstants.WEB_URL, this.f);
            this.j.a(this.a, d.a.AUDIO_PLAY_ERROR, "error", jSONObject);
        } catch (JSONException unused) {
            e.e("PushSelfShowLog", "onError error");
        }
        d();
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        a(this.i);
        h();
    }
}
