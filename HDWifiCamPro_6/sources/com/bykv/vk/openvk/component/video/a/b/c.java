package com.bykv.vk.openvk.component.video.a.b;

/* compiled from: IncrementalTimeout */
public class c {
    private final long a;
    private final long b;
    private final long c;

    public long a(int i) {
        if (i <= 0) {
            return this.a;
        }
        return Math.min(this.a + (this.b * ((long) i)), this.c);
    }
}
