package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;

class KeyEventCompatEclair {
    KeyEventCompatEclair() {
    }

    public static Object getKeyDispatcherState(View view) {
        return view.getKeyDispatcherState();
    }

    public static boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
        return keyEvent.dispatch(callback, (KeyEvent.DispatcherState) obj, obj2);
    }

    public static void startTracking(KeyEvent keyEvent) {
        keyEvent.startTracking();
    }

    public static boolean isTracking(KeyEvent keyEvent) {
        return keyEvent.isTracking();
    }
}
