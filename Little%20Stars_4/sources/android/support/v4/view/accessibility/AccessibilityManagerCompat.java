package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

public final class AccessibilityManagerCompat {
    /* access modifiers changed from: private */
    public static final AccessibilityManagerVersionImpl IMPL;

    interface AccessibilityManagerVersionImpl {
        boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i);

        List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager);

        boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager);

        Object newAccessiblityStateChangeListener(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);
    }

    public static abstract class AccessibilityStateChangeListenerCompat {
        final Object mListener = AccessibilityManagerCompat.IMPL.newAccessiblityStateChangeListener(this);

        public abstract void onAccessibilityStateChanged(boolean z);
    }

    static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return false;
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return false;
        }

        public Object newAccessiblityStateChangeListener(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return null;
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return false;
        }

        AccessibilityManagerStubImpl() {
        }

        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return Collections.emptyList();
        }

        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return Collections.emptyList();
        }
    }

    static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
        AccessibilityManagerIcsImpl() {
        }

        public Object newAccessiblityStateChangeListener(final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge() {
                public void onAccessibilityStateChanged(boolean z) {
                    accessibilityStateChangeListenerCompat.onAccessibilityStateChanged(z);
                }
            });
        }

        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat.mListener);
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat.mListener);
        }

        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(accessibilityManager, i);
        }

        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(accessibilityManager);
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(accessibilityManager);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityManagerIcsImpl();
        } else {
            IMPL = new AccessibilityManagerStubImpl();
        }
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return IMPL.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return IMPL.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat);
    }

    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return IMPL.getInstalledAccessibilityServiceList(accessibilityManager);
    }

    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return IMPL.getEnabledAccessibilityServiceList(accessibilityManager, i);
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return IMPL.isTouchExplorationEnabled(accessibilityManager);
    }

    private AccessibilityManagerCompat() {
    }
}
