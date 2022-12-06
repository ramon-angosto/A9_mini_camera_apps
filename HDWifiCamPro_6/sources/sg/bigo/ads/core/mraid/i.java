package sg.bigo.ads.core.mraid;

enum i {
    PORTRAIT(1),
    LANDSCAPE(0),
    NONE(-1);
    
    final int d;

    private i(int i) {
        this.d = i;
    }
}
