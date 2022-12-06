package sg.bigo.ads.core.a;

import java.util.ArrayList;
import java.util.Collection;

public final class o<E> extends ArrayList<E> {
    public final boolean add(E e) {
        int indexOf = indexOf(e);
        if (indexOf < 0) {
            return super.add(e);
        }
        set(indexOf, e);
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }
}
