package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetPeriodStartTime;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                if (workSpec.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workSpec.id);
                }
                supportSQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
                if (workSpec.workerClassName == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, workSpec.workerClassName);
                }
                if (workSpec.inputMergerClassName == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, workSpec.inputMergerClassName);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
                supportSQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.periodStartTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1 : 0);
                supportSQLiteStatement.bindLong(17, (long) WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                Constraints constraints = workSpec.constraints;
                if (constraints != null) {
                    supportSQLiteStatement.bindLong(18, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(19, constraints.requiresCharging() ? 1 : 0);
                    supportSQLiteStatement.bindLong(20, constraints.requiresDeviceIdle() ? 1 : 0);
                    supportSQLiteStatement.bindLong(21, constraints.requiresBatteryNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(22, constraints.requiresStorageNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(23, constraints.getTriggerContentUpdateDelay());
                    supportSQLiteStatement.bindLong(24, constraints.getTriggerMaxContentDelay());
                    byte[] contentUriTriggersToByteArray = WorkTypeConverters.contentUriTriggersToByteArray(constraints.getContentUriTriggers());
                    if (contentUriTriggersToByteArray == null) {
                        supportSQLiteStatement.bindNull(25);
                    } else {
                        supportSQLiteStatement.bindBlob(25, contentUriTriggersToByteArray);
                    }
                } else {
                    supportSQLiteStatement.bindNull(18);
                    supportSQLiteStatement.bindNull(19);
                    supportSQLiteStatement.bindNull(20);
                    supportSQLiteStatement.bindNull(21);
                    supportSQLiteStatement.bindNull(22);
                    supportSQLiteStatement.bindNull(23);
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetPeriodStartTime = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    public void setOutput(String str, Data data) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetOutput.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(acquire);
        }
    }

    public void setPeriodStartTime(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetPeriodStartTime.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetPeriodStartTime.release(acquire);
        }
    }

    public int incrementWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public int resetWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public int markWorkSpecScheduled(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(acquire);
        }
    }

    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(acquire);
        }
    }

    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(acquire);
        }
    }

    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i = columnIndexOrThrow25;
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.expedited = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i));
                    workSpec.constraints = constraints;
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public WorkSpec[] getWorkSpecs(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                WorkSpec[] workSpecArr = new WorkSpec[query.getCount()];
                int i2 = 0;
                while (query.moveToNext()) {
                    WorkSpec[] workSpecArr2 = workSpecArr;
                    String string = query.getString(columnIndexOrThrow9);
                    int i3 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i4 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i5 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    int i6 = columnIndexOrThrow2;
                    int i7 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                    int i8 = i6;
                    int i9 = columnIndexOrThrow14;
                    int i10 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i10);
                    columnIndexOrThrow15 = i10;
                    int i11 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i11);
                    int i12 = columnIndexOrThrow12;
                    int i13 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i13);
                    int i14 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i14);
                    int i15 = columnIndexOrThrow19;
                    int i16 = i11;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i15));
                    columnIndexOrThrow17 = i13;
                    int i17 = i14;
                    int i18 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i18);
                    int i19 = i15;
                    int i20 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i20);
                    int i21 = i18;
                    columnIndexOrThrow21 = i20;
                    int i22 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i22);
                    columnIndexOrThrow22 = i22;
                    int i23 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i23);
                    int i24 = columnIndexOrThrow24;
                    workSpec.expedited = query.getInt(i24) != 0;
                    int i25 = columnIndexOrThrow25;
                    int i26 = i23;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i25));
                    workSpec.constraints = constraints;
                    workSpecArr2[i2] = workSpec;
                    i2++;
                    columnIndexOrThrow25 = i25;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow23 = i26;
                    workSpecArr = workSpecArr2;
                    columnIndexOrThrow9 = i3;
                    columnIndexOrThrow11 = i4;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow24 = i24;
                    columnIndexOrThrow14 = i9;
                    columnIndexOrThrow3 = i7;
                    int i27 = i19;
                    columnIndexOrThrow20 = i21;
                    columnIndexOrThrow12 = i12;
                    columnIndexOrThrow16 = i16;
                    columnIndexOrThrow18 = i17;
                    columnIndexOrThrow19 = i27;
                }
                WorkSpec[] workSpecArr3 = workSpecArr;
                query.close();
                roomSQLiteQuery.release();
                return workSpecArr3;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.id = query.getString(columnIndexOrThrow);
                idAndState.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, new Callable<List<String>>() {
            public List<String> call() throws Exception {
                Cursor query;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(query.getString(0));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public WorkInfo.State getState(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        WorkInfo.State state = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                state = WorkTypeConverters.intToState(query.getInt(0));
            }
            return state;
        } finally {
            query.close();
            acquire.release();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.util.List<androidx.work.Data>] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.impl.model.WorkSpec.WorkInfoPojo getWorkStatusPojoForId(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            java.lang.String r1 = "SELECT id, state, output, run_attempt_count FROM workspec WHERE id=?"
            androidx.room.RoomSQLiteQuery r1 = androidx.room.RoomSQLiteQuery.acquire(r1, r0)
            if (r11 != 0) goto L_0x000d
            r1.bindNull(r0)
            goto L_0x0010
        L_0x000d:
            r1.bindString(r0, r11)
        L_0x0010:
            androidx.room.RoomDatabase r11 = r10.__db
            r11.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r11 = r10.__db
            r11.beginTransaction()
            androidx.room.RoomDatabase r11 = r10.__db     // Catch:{ all -> 0x0101 }
            r2 = 0
            android.database.Cursor r11 = androidx.room.util.DBUtil.query(r11, r1, r0, r2)     // Catch:{ all -> 0x0101 }
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r11, r0)     // Catch:{ all -> 0x00f9 }
            java.lang.String r3 = "state"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r11, r3)     // Catch:{ all -> 0x00f9 }
            java.lang.String r4 = "output"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r11, r4)     // Catch:{ all -> 0x00f9 }
            java.lang.String r5 = "run_attempt_count"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r11, r5)     // Catch:{ all -> 0x00f9 }
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00f9 }
            r6.<init>()     // Catch:{ all -> 0x00f9 }
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00f9 }
            r7.<init>()     // Catch:{ all -> 0x00f9 }
        L_0x0043:
            boolean r8 = r11.moveToNext()     // Catch:{ all -> 0x00f9 }
            if (r8 == 0) goto L_0x007e
            boolean r8 = r11.isNull(r0)     // Catch:{ all -> 0x00f9 }
            if (r8 != 0) goto L_0x0063
            java.lang.String r8 = r11.getString(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.Object r9 = r6.get(r8)     // Catch:{ all -> 0x00f9 }
            java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x00f9 }
            if (r9 != 0) goto L_0x0063
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00f9 }
            r9.<init>()     // Catch:{ all -> 0x00f9 }
            r6.put(r8, r9)     // Catch:{ all -> 0x00f9 }
        L_0x0063:
            boolean r8 = r11.isNull(r0)     // Catch:{ all -> 0x00f9 }
            if (r8 != 0) goto L_0x0043
            java.lang.String r8 = r11.getString(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.Object r9 = r7.get(r8)     // Catch:{ all -> 0x00f9 }
            java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x00f9 }
            if (r9 != 0) goto L_0x0043
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00f9 }
            r9.<init>()     // Catch:{ all -> 0x00f9 }
            r7.put(r8, r9)     // Catch:{ all -> 0x00f9 }
            goto L_0x0043
        L_0x007e:
            r8 = -1
            r11.moveToPosition(r8)     // Catch:{ all -> 0x00f9 }
            r10.__fetchRelationshipWorkTagAsjavaLangString(r6)     // Catch:{ all -> 0x00f9 }
            r10.__fetchRelationshipWorkProgressAsandroidxWorkData(r7)     // Catch:{ all -> 0x00f9 }
            boolean r8 = r11.moveToFirst()     // Catch:{ all -> 0x00f9 }
            if (r8 == 0) goto L_0x00e8
            boolean r8 = r11.isNull(r0)     // Catch:{ all -> 0x00f9 }
            if (r8 != 0) goto L_0x009f
            java.lang.String r8 = r11.getString(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.Object r6 = r6.get(r8)     // Catch:{ all -> 0x00f9 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x00f9 }
            goto L_0x00a0
        L_0x009f:
            r6 = r2
        L_0x00a0:
            if (r6 != 0) goto L_0x00a7
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00f9 }
            r6.<init>()     // Catch:{ all -> 0x00f9 }
        L_0x00a7:
            boolean r8 = r11.isNull(r0)     // Catch:{ all -> 0x00f9 }
            if (r8 != 0) goto L_0x00b7
            java.lang.String r2 = r11.getString(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.Object r2 = r7.get(r2)     // Catch:{ all -> 0x00f9 }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x00f9 }
        L_0x00b7:
            if (r2 != 0) goto L_0x00be
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00f9 }
            r2.<init>()     // Catch:{ all -> 0x00f9 }
        L_0x00be:
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r7 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00f9 }
            r7.<init>()     // Catch:{ all -> 0x00f9 }
            java.lang.String r0 = r11.getString(r0)     // Catch:{ all -> 0x00f9 }
            r7.id = r0     // Catch:{ all -> 0x00f9 }
            int r0 = r11.getInt(r3)     // Catch:{ all -> 0x00f9 }
            androidx.work.WorkInfo$State r0 = androidx.work.impl.model.WorkTypeConverters.intToState(r0)     // Catch:{ all -> 0x00f9 }
            r7.state = r0     // Catch:{ all -> 0x00f9 }
            byte[] r0 = r11.getBlob(r4)     // Catch:{ all -> 0x00f9 }
            androidx.work.Data r0 = androidx.work.Data.fromByteArray(r0)     // Catch:{ all -> 0x00f9 }
            r7.output = r0     // Catch:{ all -> 0x00f9 }
            int r0 = r11.getInt(r5)     // Catch:{ all -> 0x00f9 }
            r7.runAttemptCount = r0     // Catch:{ all -> 0x00f9 }
            r7.tags = r6     // Catch:{ all -> 0x00f9 }
            r7.progress = r2     // Catch:{ all -> 0x00f9 }
            r2 = r7
        L_0x00e8:
            androidx.room.RoomDatabase r0 = r10.__db     // Catch:{ all -> 0x00f9 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x00f9 }
            r11.close()     // Catch:{ all -> 0x0101 }
            r1.release()     // Catch:{ all -> 0x0101 }
            androidx.room.RoomDatabase r11 = r10.__db
            r11.endTransaction()
            return r2
        L_0x00f9:
            r0 = move-exception
            r11.close()     // Catch:{ all -> 0x0101 }
            r1.release()     // Catch:{ all -> 0x0101 }
            throw r0     // Catch:{ all -> 0x0101 }
        L_0x0101:
            r11 = move-exception
            androidx.room.RoomDatabase r0 = r10.__db
            r0.endTransaction()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.getWorkStatusPojoForId(java.lang.String):androidx.work.impl.model.WorkSpec$WorkInfoPojo");
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        Cursor query;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    String string2 = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap2.get(string2)) == null) {
                        arrayMap2.put(string2, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ArrayList arrayList2 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList2;
                workInfoPojo.progress = arrayList3;
                arrayList.add(workInfoPojo);
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string = query.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap.get(string)) == null) {
                                arrayMap.put(string, new ArrayList());
                            }
                        }
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string2 = query.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap2.get(string2)) == null) {
                                arrayMap2.put(string2, new ArrayList());
                            }
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        ArrayList arrayList2 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.id = query.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        Cursor query;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    String string2 = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap2.get(string2)) == null) {
                        arrayMap2.put(string2, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ArrayList arrayList2 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList2;
                workInfoPojo.progress = arrayList3;
                arrayList.add(workInfoPojo);
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string = query.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap.get(string)) == null) {
                                arrayMap.put(string, new ArrayList());
                            }
                        }
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string2 = query.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap2.get(string2)) == null) {
                                arrayMap2.put(string2, new ArrayList());
                            }
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        ArrayList arrayList2 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.id = query.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        Cursor query;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    String string2 = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap2.get(string2)) == null) {
                        arrayMap2.put(string2, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ArrayList arrayList2 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList2;
                workInfoPojo.progress = arrayList3;
                arrayList.add(workInfoPojo);
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string = query.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap.get(string)) == null) {
                                arrayMap.put(string, new ArrayList());
                            }
                        }
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string2 = query.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap2.get(string2)) == null) {
                                arrayMap2.put(string2, new ArrayList());
                            }
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        ArrayList arrayList2 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !query.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.id = query.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<Data> getInputsFromPrerequisites(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(Data.fromByteArray(query.getBlob(0)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean hasUnfinishedWork() {
        boolean z = false;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst() && query.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public LiveData<Long> getScheduleRequestedAtLiveData(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, new Callable<Long>() {
            public Long call() throws Exception {
                Long l = null;
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    if (query.moveToFirst()) {
                        if (!query.isNull(0)) {
                            l = Long.valueOf(query.getLong(0));
                        }
                    }
                    return l;
                } finally {
                    query.close();
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<WorkSpec> getEligibleWorkForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i3 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i4 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i5 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    int i6 = columnIndexOrThrow2;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i7 = i2;
                    workSpec.output = Data.fromByteArray(query.getBlob(i7));
                    int i8 = columnIndexOrThrow12;
                    i2 = i7;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i9);
                    columnIndexOrThrow15 = i9;
                    int i10 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i10);
                    columnIndexOrThrow16 = i10;
                    int i11 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i11);
                    int i12 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i12);
                    int i13 = columnIndexOrThrow19;
                    columnIndexOrThrow18 = i12;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i13));
                    columnIndexOrThrow17 = i11;
                    int i14 = columnIndexOrThrow3;
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i16);
                    columnIndexOrThrow21 = i16;
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i17);
                    columnIndexOrThrow22 = i17;
                    int i18 = i13;
                    int i19 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i19);
                    int i20 = columnIndexOrThrow24;
                    workSpec.expedited = query.getInt(i20) != 0;
                    int i21 = columnIndexOrThrow25;
                    columnIndexOrThrow24 = i20;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i21));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i21;
                    columnIndexOrThrow23 = i19;
                    columnIndexOrThrow12 = i8;
                    columnIndexOrThrow9 = i3;
                    columnIndexOrThrow11 = i4;
                    columnIndexOrThrow2 = i6;
                    columnIndexOrThrow = i5;
                    int i22 = i14;
                    columnIndexOrThrow19 = i18;
                    columnIndexOrThrow3 = i22;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i3 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i4 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i5 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    int i6 = columnIndexOrThrow2;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i7 = i2;
                    workSpec.output = Data.fromByteArray(query.getBlob(i7));
                    int i8 = columnIndexOrThrow12;
                    i2 = i7;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i9);
                    columnIndexOrThrow15 = i9;
                    int i10 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i10);
                    columnIndexOrThrow16 = i10;
                    int i11 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i11);
                    int i12 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i12);
                    int i13 = columnIndexOrThrow19;
                    columnIndexOrThrow18 = i12;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i13));
                    columnIndexOrThrow17 = i11;
                    int i14 = columnIndexOrThrow3;
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i16);
                    columnIndexOrThrow21 = i16;
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i17);
                    columnIndexOrThrow22 = i17;
                    int i18 = i13;
                    int i19 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i19);
                    int i20 = columnIndexOrThrow24;
                    workSpec.expedited = query.getInt(i20) != 0;
                    int i21 = columnIndexOrThrow25;
                    columnIndexOrThrow24 = i20;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i21));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i21;
                    columnIndexOrThrow23 = i19;
                    columnIndexOrThrow12 = i8;
                    columnIndexOrThrow9 = i3;
                    columnIndexOrThrow11 = i4;
                    columnIndexOrThrow2 = i6;
                    columnIndexOrThrow = i5;
                    int i22 = i14;
                    columnIndexOrThrow19 = i18;
                    columnIndexOrThrow3 = i22;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    int i5 = columnIndexOrThrow2;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i6 = i;
                    workSpec.output = Data.fromByteArray(query.getBlob(i6));
                    int i7 = columnIndexOrThrow13;
                    i = i6;
                    int i8 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i8);
                    columnIndexOrThrow15 = i8;
                    int i9 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i9);
                    columnIndexOrThrow16 = i9;
                    int i10 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i10);
                    int i11 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i11);
                    int i12 = columnIndexOrThrow19;
                    columnIndexOrThrow18 = i11;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i12));
                    columnIndexOrThrow17 = i10;
                    int i13 = columnIndexOrThrow3;
                    int i14 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i14);
                    columnIndexOrThrow20 = i14;
                    int i15 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i15);
                    columnIndexOrThrow21 = i15;
                    int i16 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i16);
                    columnIndexOrThrow22 = i16;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i18);
                    int i19 = columnIndexOrThrow24;
                    workSpec.expedited = query.getInt(i19) != 0;
                    int i20 = columnIndexOrThrow25;
                    columnIndexOrThrow24 = i19;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i20));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow2 = i5;
                    int i21 = i13;
                    columnIndexOrThrow19 = i17;
                    columnIndexOrThrow3 = i21;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    int i5 = columnIndexOrThrow2;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i6 = i;
                    workSpec.output = Data.fromByteArray(query.getBlob(i6));
                    int i7 = columnIndexOrThrow13;
                    i = i6;
                    int i8 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i8);
                    columnIndexOrThrow15 = i8;
                    int i9 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i9);
                    columnIndexOrThrow16 = i9;
                    int i10 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i10);
                    int i11 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i11);
                    int i12 = columnIndexOrThrow19;
                    columnIndexOrThrow18 = i11;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i12));
                    columnIndexOrThrow17 = i10;
                    int i13 = columnIndexOrThrow3;
                    int i14 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i14);
                    columnIndexOrThrow20 = i14;
                    int i15 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i15);
                    columnIndexOrThrow21 = i15;
                    int i16 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i16);
                    columnIndexOrThrow22 = i16;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i18);
                    int i19 = columnIndexOrThrow24;
                    workSpec.expedited = query.getInt(i19) != 0;
                    int i20 = columnIndexOrThrow25;
                    columnIndexOrThrow24 = i19;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i20));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i20;
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow2 = i5;
                    int i21 = i13;
                    columnIndexOrThrow19 = i17;
                    columnIndexOrThrow3 = i21;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getRecentlyCompletedWork(long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    int i5 = columnIndexOrThrow2;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i6 = i;
                    workSpec.output = Data.fromByteArray(query.getBlob(i6));
                    int i7 = columnIndexOrThrow15;
                    int i8 = columnIndexOrThrow12;
                    i = i6;
                    workSpec.initialDelay = query.getLong(i7);
                    int i9 = i7;
                    int i10 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i10);
                    columnIndexOrThrow16 = i10;
                    int i11 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i11);
                    int i12 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i12);
                    int i13 = columnIndexOrThrow19;
                    columnIndexOrThrow18 = i12;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i13));
                    columnIndexOrThrow17 = i11;
                    int i14 = columnIndexOrThrow3;
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i16);
                    columnIndexOrThrow21 = i16;
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i17);
                    columnIndexOrThrow22 = i17;
                    int i18 = i13;
                    int i19 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i19);
                    int i20 = columnIndexOrThrow24;
                    workSpec.expedited = query.getInt(i20) != 0;
                    int i21 = columnIndexOrThrow25;
                    columnIndexOrThrow24 = i20;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i21));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow12 = i8;
                    columnIndexOrThrow25 = i21;
                    columnIndexOrThrow23 = i19;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow2 = i5;
                    columnIndexOrThrow = i4;
                    int i22 = i14;
                    columnIndexOrThrow19 = i18;
                    columnIndexOrThrow3 = i22;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public int setState(WorkInfo.State state, String... strArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE workspec SET state=");
        newStringBuilder.append("?");
        newStringBuilder.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, strArr.length);
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, (long) WorkTypeConverters.stateToInt(state));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> arrayMap) {
        ArrayList arrayList;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = arrayMap.size();
                ArrayMap arrayMap3 = arrayMap2;
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    arrayMap3.put(arrayMap.keyAt(i), arrayMap.valueAt(i));
                    i++;
                    i2++;
                    if (i2 == 999) {
                        __fetchRelationshipWorkTagAsjavaLangString(arrayMap3);
                        arrayMap3 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        i2 = 0;
                    }
                }
                if (i2 > 0) {
                    __fetchRelationshipWorkTagAsjavaLangString(arrayMap3);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, next);
                }
                i3++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex) && (arrayList = arrayMap.get(query.getString(columnIndex))) != null) {
                            arrayList.add(query.getString(0));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> arrayMap) {
        ArrayList arrayList;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = arrayMap.size();
                ArrayMap arrayMap3 = arrayMap2;
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    arrayMap3.put(arrayMap.keyAt(i), arrayMap.valueAt(i));
                    i++;
                    i2++;
                    if (i2 == 999) {
                        __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap3);
                        arrayMap3 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        i2 = 0;
                    }
                }
                if (i2 > 0) {
                    __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap3);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, next);
                }
                i3++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex) && (arrayList = arrayMap.get(query.getString(columnIndex))) != null) {
                            arrayList.add(Data.fromByteArray(query.getBlob(0)));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }
}
