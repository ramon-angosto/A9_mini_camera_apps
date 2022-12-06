package com.huawei.hmf.tasks.p011a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: com.huawei.hmf.tasks.a.g */
public final class C0590g extends Fragment {

    /* renamed from: b */
    private static final WeakHashMap<Activity, WeakReference<C0590g>> f200b = new WeakHashMap<>();

    /* renamed from: a */
    private final List<WeakReference<ExecuteResult<?>>> f201a = new ArrayList();

    /* renamed from: a */
    private static C0590g m149a(Activity activity) {
        C0590g gVar;
        WeakReference weakReference = f200b.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return (C0590g) weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            C0590g gVar2 = (C0590g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar2 == null) {
                try {
                    gVar = m150a(fragmentManager);
                } catch (ClassCastException e) {
                    e = e;
                    gVar = gVar2;
                    Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                    return gVar;
                }
            } else {
                gVar = gVar2;
            }
            try {
                f200b.put(activity, new WeakReference(gVar));
                return gVar;
            } catch (ClassCastException e2) {
                e = e2;
            }
        } catch (ClassCastException e3) {
            e = e3;
            gVar = null;
            Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
            return gVar;
        }
    }

    /* renamed from: a */
    private static C0590g m150a(FragmentManager fragmentManager) {
        C0590g gVar;
        try {
            gVar = new C0590g();
            try {
                fragmentManager.beginTransaction().add(gVar, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            gVar = null;
            Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
            return gVar;
        }
        return gVar;
    }

    /* renamed from: a */
    public static void m151a(Activity activity, ExecuteResult executeResult) {
        C0590g a = m149a(activity);
        if (a != null) {
            synchronized (a.f201a) {
                a.f201a.add(new WeakReference(executeResult));
            }
        }
    }

    public final void onStop() {
        super.onStop();
        synchronized (this.f201a) {
            for (WeakReference<ExecuteResult<?>> weakReference : this.f201a) {
                ExecuteResult executeResult = (ExecuteResult) weakReference.get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f201a.clear();
        }
    }
}
