package sg.bigo.ads.core.player;

public final class b {
    public int a = 1;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public int e = 0;
    public boolean f = false;
    public long g = -1;
    public boolean h = false;

    public static b a(int i) {
        b bVar = new b();
        int i2 = 3;
        if (i != 3) {
            i2 = 4;
            if (i == 4) {
                bVar.h = true;
                bVar.c = true;
                bVar.b = true;
                bVar.g = 2000;
            } else if (i == 12) {
                bVar.h = true;
                bVar.c = true;
                bVar.b = true;
            }
            return bVar;
        }
        bVar.h = true;
        bVar.c = true;
        bVar.e = 2;
        bVar.g = 2000;
        bVar.a = i2;
        return bVar;
    }
}
