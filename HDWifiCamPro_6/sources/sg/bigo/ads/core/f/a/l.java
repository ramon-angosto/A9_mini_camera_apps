package sg.bigo.ads.core.f.a;

public final class l extends n implements Comparable<l> {
    public final float a;

    public l(String str, float f) {
        super(str);
        this.a = f;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return Double.compare((double) this.a, (double) ((l) obj).a);
    }

    public final String toString() {
        return "{\"Content\":\"" + this.b + "\",\"progress\":\"" + this.a + "\"}";
    }
}
