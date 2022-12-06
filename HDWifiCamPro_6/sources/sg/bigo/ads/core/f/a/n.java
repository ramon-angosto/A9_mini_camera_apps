package sg.bigo.ads.core.f.a;

public class n {
    private boolean a;
    public final String b;
    public boolean c;
    public boolean d;

    public n(String str) {
        this.d = false;
        this.a = true;
        this.b = str;
    }

    public n(String str, byte b2) {
        this(str);
        this.d = true;
    }

    public String toString() {
        return "{\"Content\":\"" + this.b + "\"}";
    }
}
