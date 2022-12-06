package sg.bigo.ads.core.f.a;

public final class c extends n implements Comparable<c> {
    public final int a;

    public c(String str, int i) {
        super(str);
        this.a = i;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.a - ((c) obj).a;
    }

    public final String toString() {
        return "{\"Content\":\"" + this.b + "\",\"pro_ms\":\"" + this.a + "\"}";
    }
}
