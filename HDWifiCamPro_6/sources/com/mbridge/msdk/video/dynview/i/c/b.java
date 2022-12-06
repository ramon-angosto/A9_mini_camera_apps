package com.mbridge.msdk.video.dynview.i.c;

import android.os.CountDownTimer;

/* compiled from: MBCountDownTimer */
public final class b {
    private long a = 0;
    private long b;
    private a c;
    private a d;

    public final b a(long j) {
        if (j < 0) {
            j = 1000;
        }
        this.b = j;
        return this;
    }

    public final b a(a aVar) {
        this.c = aVar;
        return this;
    }

    public final b b(long j) {
        this.a = j;
        return this;
    }

    public final void a() {
        a aVar = this.d;
        if (aVar == null) {
            if (aVar != null) {
                aVar.cancel();
                this.d = null;
            }
            if (this.b <= 0) {
                this.b = this.a + 1000;
            }
            this.d = new a(this.a, this.b);
            this.d.a(this.c);
        }
        this.d.start();
    }

    public final void b() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.cancel();
            this.d = null;
        }
    }

    /* compiled from: MBCountDownTimer */
    private static class a extends CountDownTimer {
        private a a;

        public a(long j, long j2) {
            super(j, j2);
        }

        public final void onTick(long j) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(j);
            }
        }

        public final void onFinish() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(a aVar) {
            this.a = aVar;
        }
    }
}
