package sg.bigo.ads.common.l;

public class h extends Exception {
    public final int a;
    private String b;
    private Exception c;

    public h(int i, Exception exc) {
        this.a = i;
        this.c = exc;
    }

    public h(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public String getMessage() {
        Exception exc = this.c;
        return exc != null ? exc.getMessage() : this.b;
    }
}
