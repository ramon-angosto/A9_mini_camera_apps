package sg.bigo.ads.core.mraid;

public enum g {
    CLOSE("close"),
    UNLOAD("unload"),
    EXPAND {
        /* access modifiers changed from: package-private */
        public final boolean a(n nVar) {
            return nVar == n.INLINE;
        }
    },
    USE_CUSTOM_CLOSE("usecustomclose"),
    OPEN {
        /* access modifiers changed from: package-private */
        public final boolean a(n nVar) {
            return true;
        }
    },
    RESIZE {
        /* access modifiers changed from: package-private */
        public final boolean a(n nVar) {
            return true;
        }
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO {
        /* access modifiers changed from: package-private */
        public final boolean a(n nVar) {
            return nVar == n.INLINE;
        }
    },
    STORE_PICTURE {
        /* access modifiers changed from: package-private */
        public final boolean a(n nVar) {
            return true;
        }
    },
    CREATE_CALENDAR_EVENT {
        /* access modifiers changed from: package-private */
        public final boolean a(n nVar) {
            return true;
        }
    },
    UNSPECIFIED("");
    
    final String l;

    private g(String str) {
        this.l = str;
    }

    static g a(String str) {
        for (g gVar : values()) {
            if (gVar.l.equals(str)) {
                return gVar;
            }
        }
        return UNSPECIFIED;
    }

    /* access modifiers changed from: package-private */
    public boolean a(n nVar) {
        return false;
    }
}
