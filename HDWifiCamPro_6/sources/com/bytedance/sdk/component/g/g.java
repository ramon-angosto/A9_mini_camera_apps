package com.bytedance.sdk.component.g;

/* compiled from: TTRunnable */
public abstract class g implements Comparable<g>, Runnable {
    private int a;
    private String b;

    public g(String str, int i) {
        this.a = 0;
        this.a = i == 0 ? 5 : i;
        this.b = str;
    }

    public g(String str) {
        this.a = 0;
        this.a = 5;
        this.b = str;
    }

    public void setPriority(int i) {
        this.a = i;
    }

    public int getPriority() {
        return this.a;
    }

    public int compareTo(g gVar) {
        if (getPriority() < gVar.getPriority()) {
            return 1;
        }
        return getPriority() >= gVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.b;
    }
}
