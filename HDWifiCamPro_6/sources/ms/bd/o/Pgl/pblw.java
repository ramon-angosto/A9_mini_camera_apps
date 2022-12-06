package ms.bd.o.Pgl;

import java.io.File;
import java.io.FilenameFilter;

class pblw implements FilenameFilter {
    final /* synthetic */ String a;

    pblw(pblv pblv, String str) {
        this.a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
