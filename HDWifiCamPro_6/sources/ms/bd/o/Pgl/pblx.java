package ms.bd.o.Pgl;

import ms.bd.o.Pgl.pblu;

final class pblx implements pblu.pblb {
    pblx() {
    }

    public String a(String str) {
        return (!str.startsWith("lib") || !str.endsWith(".so")) ? System.mapLibraryName(str) : str;
    }
}
