package androidx.work.impl.constraints;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

public class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {
    private static final String TAG = Logger.tagWithPrefix("WorkConstraintsTracker");
    private final WorkConstraintsCallback mCallback;
    private final ConstraintController<?>[] mConstraintControllers;
    private final Object mLock = new Object();

    public WorkConstraintsTracker(Context context, TaskExecutor taskExecutor, WorkConstraintsCallback workConstraintsCallback) {
        Context applicationContext = context.getApplicationContext();
        this.mCallback = workConstraintsCallback;
        this.mConstraintControllers = new ConstraintController[]{new BatteryChargingController(applicationContext, taskExecutor), new BatteryNotLowController(applicationContext, taskExecutor), new StorageNotLowController(applicationContext, taskExecutor), new NetworkConnectedController(applicationContext, taskExecutor), new NetworkUnmeteredController(applicationContext, taskExecutor), new NetworkNotRoamingController(applicationContext, taskExecutor), new NetworkMeteredController(applicationContext, taskExecutor)};
    }

    WorkConstraintsTracker(WorkConstraintsCallback workConstraintsCallback, ConstraintController<?>[] constraintControllerArr) {
        this.mCallback = workConstraintsCallback;
        this.mConstraintControllers = constraintControllerArr;
    }

    public void replace(Iterable<WorkSpec> iterable) {
        synchronized (this.mLock) {
            for (ConstraintController<?> callback : this.mConstraintControllers) {
                callback.setCallback((ConstraintController.OnConstraintUpdatedCallback) null);
            }
            for (ConstraintController<?> replace : this.mConstraintControllers) {
                replace.replace(iterable);
            }
            for (ConstraintController<?> callback2 : this.mConstraintControllers) {
                callback2.setCallback(this);
            }
        }
    }

    public void reset() {
        synchronized (this.mLock) {
            for (ConstraintController<?> reset : this.mConstraintControllers) {
                reset.reset();
            }
        }
    }

    public boolean areAllConstraintsMet(String str) {
        synchronized (this.mLock) {
            for (ConstraintController<?> constraintController : this.mConstraintControllers) {
                if (constraintController.isWorkSpecConstrained(str)) {
                    Logger.get().debug(TAG, String.format("Work %s constrained by %s", new Object[]{str, constraintController.getClass().getSimpleName()}), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void onConstraintMet(List<String> list) {
        synchronized (this.mLock) {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (areAllConstraintsMet(next)) {
                    Logger.get().debug(TAG, String.format("Constraints met for %s", new Object[]{next}), new Throwable[0]);
                    arrayList.add(next);
                }
            }
            if (this.mCallback != null) {
                this.mCallback.onAllConstraintsMet(arrayList);
            }
        }
    }

    public void onConstraintNotMet(List<String> list) {
        synchronized (this.mLock) {
            if (this.mCallback != null) {
                this.mCallback.onAllConstraintsNotMet(list);
            }
        }
    }
}
