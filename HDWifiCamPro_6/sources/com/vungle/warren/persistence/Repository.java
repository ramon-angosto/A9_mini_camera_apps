package com.vungle.warren.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdAsset;
import com.vungle.warren.model.AdAssetDBAdapter;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.AnalyticUrl;
import com.vungle.warren.model.AnalyticUrlDBAdapter;
import com.vungle.warren.model.CacheBust;
import com.vungle.warren.model.CacheBustDBAdapter;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.CookieDBAdapter;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.PlacementDBAdapter;
import com.vungle.warren.model.Report;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.model.SessionDataDBAdapter;
import com.vungle.warren.model.VisionData;
import com.vungle.warren.model.VisionDataDBAdapter;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.VungleThreadPoolExecutor;
import com.vungle.warren.vision.VisionAggregationData;
import com.vungle.warren.vision.VisionAggregationInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Repository {
    /* access modifiers changed from: private */
    public static final String TAG = Repository.class.getSimpleName();
    protected static final int VERSION = 11;
    /* access modifiers changed from: private */
    public Map<Class, DBAdapter> adapters;
    private final Context appCtx;
    protected DatabaseHelper dbHelper;
    /* access modifiers changed from: private */
    public final Designer designer;
    private final VungleThreadPoolExecutor ioExecutor;
    /* access modifiers changed from: private */
    public final ExecutorService uiExecutor;

    public interface LoadCallback<T> {
        void onLoaded(T t);
    }

    public interface SaveCallback {
        void onError(Exception exc);

        void onSaved();
    }

    public Repository(Context context, Designer designer2, VungleThreadPoolExecutor vungleThreadPoolExecutor, ExecutorService executorService) {
        this(context, designer2, vungleThreadPoolExecutor, executorService, 11);
    }

    public Repository(Context context, Designer designer2, VungleThreadPoolExecutor vungleThreadPoolExecutor, ExecutorService executorService, int i) {
        this.adapters = new HashMap();
        this.appCtx = context.getApplicationContext();
        this.ioExecutor = vungleThreadPoolExecutor;
        this.uiExecutor = executorService;
        this.dbHelper = new DatabaseHelper(context, i, new VungleDatabaseCreator(this.appCtx));
        this.designer = designer2;
        this.adapters.put(Placement.class, new PlacementDBAdapter());
        this.adapters.put(Cookie.class, new CookieDBAdapter());
        this.adapters.put(Report.class, new ReportDBAdapter());
        this.adapters.put(Advertisement.class, new AdvertisementDBAdapter());
        this.adapters.put(AdAsset.class, new AdAssetDBAdapter());
        this.adapters.put(VisionData.class, new VisionDataDBAdapter());
        this.adapters.put(AnalyticUrl.class, new AnalyticUrlDBAdapter());
        this.adapters.put(CacheBust.class, new CacheBustDBAdapter());
        this.adapters.put(SessionData.class, new SessionDataDBAdapter());
    }

    public void init() throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.dbHelper.init();
                ContentValues contentValues = new ContentValues();
                contentValues.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, 3);
                Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
                query.selection = "state=?";
                query.args = new String[]{String.valueOf(2)};
                Repository.this.dbHelper.update(query, contentValues);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public <T> List<T> loadAllModels(Class<T> cls) {
        DBAdapter dBAdapter = this.adapters.get(cls);
        if (dBAdapter == null) {
            return Collections.EMPTY_LIST;
        }
        return extractModels(cls, this.dbHelper.query(new Query(dBAdapter.tableName())));
    }

    /* access modifiers changed from: private */
    public <T> List<T> extractModels(Class<T> cls, Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            DBAdapter dBAdapter = this.adapters.get(cls);
            while (cursor.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
                arrayList.add(dBAdapter.fromContentValues(contentValues));
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            VungleLogger.critical(true, Repository.class.getSimpleName(), "extractModels", e.toString());
            ArrayList arrayList2 = new ArrayList();
            if (cursor != null) {
                cursor.close();
            }
            return arrayList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public <T> T loadModel(String str, Class<T> cls) {
        DBAdapter dBAdapter = this.adapters.get(cls);
        Query query = new Query(dBAdapter.tableName());
        query.selection = "item_id = ? ";
        query.args = new String[]{str};
        Cursor query2 = this.dbHelper.query(query);
        if (query2 != null) {
            try {
                if (query2.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                    return dBAdapter.fromContentValues(contentValues);
                }
                query2.close();
            } catch (Exception e) {
                VungleLogger.critical(true, Repository.class.getSimpleName(), "loadModel", e.toString());
                return null;
            } finally {
                query2.close();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public <T> void saveModel(T t) throws DatabaseHelper.DBException {
        DBAdapter dBAdapter = this.adapters.get(t.getClass());
        this.dbHelper.insertWithConflict(dBAdapter.tableName(), dBAdapter.toContentValues(t), 5);
    }

    public <T> FutureResult<T> load(final String str, final Class<T> cls) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<T>() {
            public T call() {
                return Repository.this.loadModel(str, cls);
            }
        }));
    }

    public <T> void load(final String str, final Class<T> cls, final LoadCallback<T> loadCallback) {
        this.ioExecutor.execute(new Runnable() {
            public void run() {
                final Object access$000 = Repository.this.loadModel(str, cls);
                Repository.this.uiExecutor.execute(new Runnable() {
                    public void run() {
                        loadCallback.onLoaded(access$000);
                    }
                });
            }
        });
    }

    public <T> void save(final T t) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.saveModel(t);
                return null;
            }
        });
    }

    public <T> void save(final T t, final SaveCallback saveCallback, boolean z) {
        Future<?> submit = this.ioExecutor.submit((Runnable) new Runnable() {
            public void run() {
                try {
                    Repository.this.saveModel(t);
                    if (saveCallback != null) {
                        Repository.this.uiExecutor.execute(new Runnable() {
                            public void run() {
                                saveCallback.onSaved();
                            }
                        });
                    }
                } catch (DatabaseHelper.DBException e) {
                    Repository.this.onSaveCallbackError(saveCallback, e);
                }
            }
        }, (Runnable) new Runnable() {
            public void run() {
                Repository.this.onSaveCallbackError(saveCallback, new VungleException(39));
            }
        });
        if (z) {
            try {
                submit.get();
            } catch (InterruptedException e) {
                Log.e(TAG, "InterruptedException ", e);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e2) {
                Log.e(TAG, "Error on execution during saving", e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSaveCallbackError(final SaveCallback saveCallback, final Exception exc) {
        if (saveCallback != null) {
            this.uiExecutor.execute(new Runnable() {
                public void run() {
                    saveCallback.onError(exc);
                }
            });
        }
    }

    public <T> void save(T t, SaveCallback saveCallback) {
        save(t, saveCallback, true);
    }

    /* access modifiers changed from: private */
    public List<Advertisement> findValidAdvertisementsForPlacementFromDB(String str, String str2) {
        String[] strArr;
        String str3 = TAG;
        Log.i(str3, " Searching for valid advertisement for placement with " + str + "event ID " + str2);
        Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
        StringBuilder sb = new StringBuilder();
        sb.append("placement_id = ? AND ");
        sb.append("(state = ? OR ");
        sb.append("state = ?) AND ");
        sb.append("expire_time > ?");
        if (str2 != null) {
            sb.append(" AND item_id = ?");
            strArr = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000), str2};
        } else {
            strArr = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000)};
        }
        query.selection = sb.toString();
        query.args = strArr;
        query.orderBy = "state DESC";
        AdvertisementDBAdapter advertisementDBAdapter = (AdvertisementDBAdapter) this.adapters.get(Advertisement.class);
        ArrayList arrayList = new ArrayList();
        Cursor query2 = this.dbHelper.query(query);
        if (query2 == null) {
            return arrayList;
        }
        while (advertisementDBAdapter != null) {
            try {
                if (!query2.moveToNext()) {
                    break;
                }
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                arrayList.add(advertisementDBAdapter.fromContentValues(contentValues));
            } catch (Exception e) {
                VungleLogger.critical(true, Repository.class.getSimpleName(), "findValidAdvertisementsForPlacementFromDB", e.toString());
                ArrayList arrayList2 = new ArrayList();
                query2.close();
                return arrayList2;
            } catch (Throwable th) {
                query2.close();
                throw th;
            }
        }
        query2.close();
        return arrayList;
    }

    /* access modifiers changed from: private */
    public Advertisement findValidAdvertisementForPlacementFromDB(String str, String str2) {
        String[] strArr;
        String str3 = TAG;
        Log.i(str3, " Searching for valid advertisement for placement with " + str + "event ID " + str2);
        Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
        StringBuilder sb = new StringBuilder();
        sb.append("placement_id = ? AND ");
        sb.append("(state = ? OR ");
        sb.append("state = ?) AND ");
        sb.append("expire_time > ?");
        if (str2 != null) {
            sb.append(" AND item_id = ?");
            strArr = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000), str2};
        } else {
            strArr = new String[]{str, String.valueOf(1), String.valueOf(0), String.valueOf(System.currentTimeMillis() / 1000)};
        }
        query.selection = sb.toString();
        query.args = strArr;
        query.limit = "1";
        Cursor query2 = this.dbHelper.query(query);
        Advertisement advertisement = null;
        if (query2 == null) {
            return null;
        }
        try {
            AdvertisementDBAdapter advertisementDBAdapter = (AdvertisementDBAdapter) this.adapters.get(Advertisement.class);
            if (advertisementDBAdapter != null && query2.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                advertisement = advertisementDBAdapter.fromContentValues(contentValues);
            }
            return advertisement;
        } catch (Exception e) {
            VungleLogger.critical(true, Repository.class.getSimpleName(), "findValidAdvertisementForPlacementFromDB", e.toString());
            return null;
        } finally {
            query2.close();
        }
    }

    public FutureResult<Advertisement> findValidAdvertisementForPlacement(final String str, final String str2) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<Advertisement>() {
            public Advertisement call() {
                return Repository.this.findValidAdvertisementForPlacementFromDB(str, str2);
            }
        }));
    }

    public FutureResult<Advertisement> findPotentiallyExpiredAd(final String str, final String str2) {
        String str3 = TAG;
        Log.i(str3, " Searching for valid advertisement for placement with " + str + " event ID " + str2);
        return new FutureResult<>(this.ioExecutor.submit(new Callable<Advertisement>() {
            public Advertisement call() {
                String[] strArr;
                Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
                StringBuilder sb = new StringBuilder();
                sb.append("placement_id = ? AND ");
                sb.append("(state = ? OR ");
                sb.append("state = ?)");
                if (str2 != null) {
                    sb.append(" AND item_id = ?");
                    strArr = new String[]{str, String.valueOf(1), String.valueOf(0), str2};
                } else {
                    strArr = new String[]{str, String.valueOf(1), String.valueOf(0)};
                }
                query.selection = sb.toString();
                query.args = strArr;
                Cursor query2 = Repository.this.dbHelper.query(query);
                Advertisement advertisement = null;
                if (query2 == null) {
                    return null;
                }
                try {
                    AdvertisementDBAdapter advertisementDBAdapter = (AdvertisementDBAdapter) Repository.this.adapters.get(Advertisement.class);
                    if (advertisementDBAdapter != null && query2.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                        advertisement = advertisementDBAdapter.fromContentValues(contentValues);
                    }
                    return advertisement;
                } catch (Exception e) {
                    VungleLogger.critical(true, Repository.class.getSimpleName(), "findPotentiallyExpiredAd", e.toString());
                    return null;
                } finally {
                    query2.close();
                }
            }
        }));
    }

    public FutureResult<List<Advertisement>> findValidAdvertisementsForPlacement(final String str, final String str2) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<Advertisement>>() {
            public List<Advertisement> call() {
                return Repository.this.findValidAdvertisementsForPlacementFromDB(str, str2);
            }
        }));
    }

    public <T> FutureResult<List<T>> loadAll(final Class<T> cls) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<T>>() {
            public List<T> call() {
                return Repository.this.loadAllModels(cls);
            }
        }));
    }

    public FutureResult<List<Report>> loadAllReportToSend() {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<Report>>() {
            public List<Report> call() {
                List<Report> access$700 = Repository.this.loadAllModels(Report.class);
                for (Report next : access$700) {
                    next.setStatus(2);
                    try {
                        Repository.this.saveModel(next);
                    } catch (DatabaseHelper.DBException unused) {
                        return null;
                    }
                }
                return access$700;
            }
        }));
    }

    public FutureResult<List<Report>> loadReadyOrFailedReportToSend() {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<Report>>() {
            public List<Report> call() {
                Query query = new Query(ReportDBAdapter.ReportColumns.TABLE_NAME);
                query.selection = "status = ?  OR status = ? ";
                query.args = new String[]{String.valueOf(1), String.valueOf(3)};
                List<Report> access$800 = Repository.this.extractModels(Report.class, Repository.this.dbHelper.query(query));
                for (Report next : access$800) {
                    next.setStatus(2);
                    try {
                        Repository.this.saveModel(next);
                    } catch (DatabaseHelper.DBException unused) {
                        return null;
                    }
                }
                return access$800;
            }
        }));
    }

    public void updateAndSaveReportState(String str, String str2, int i, int i2) throws DatabaseHelper.DBException {
        final int i3 = i2;
        final String str3 = str;
        final int i4 = i;
        final String str4 = str2;
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(i3));
                Query query = new Query(ReportDBAdapter.ReportColumns.TABLE_NAME);
                query.selection = "placementId = ?  AND status = ?  AND appId = ? ";
                query.args = new String[]{str3, String.valueOf(i4), str4};
                Repository.this.dbHelper.update(query, contentValues);
                return null;
            }
        });
    }

    public FutureResult<List<AdAsset>> loadAllAdAssets(final String str) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<AdAsset>>() {
            public List<AdAsset> call() {
                return Repository.this.loadAllAdAssetModels(str);
            }
        }));
    }

    /* access modifiers changed from: private */
    public List<AdAsset> loadAllAdAssetModels(String str) {
        Query query = new Query(AdAssetDBAdapter.AdAssetColumns.TABLE_NAME);
        query.selection = "ad_identifier = ? ";
        query.args = new String[]{str};
        return extractModels(AdAsset.class, this.dbHelper.query(query));
    }

    public List<AdAsset> loadAllAdAssetByStatus(String str, int i) {
        Query query = new Query(AdAssetDBAdapter.AdAssetColumns.TABLE_NAME);
        query.selection = "ad_identifier = ?  AND file_status = ? ";
        query.args = new String[]{str, String.valueOf(i)};
        return extractModels(AdAsset.class, this.dbHelper.query(query));
    }

    public <T> void delete(final T t) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.deleteModel(t);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public <T> void deleteModel(Class<T> cls, String str) throws DatabaseHelper.DBException {
        Query query = new Query(this.adapters.get(cls).tableName());
        query.selection = "item_id=?";
        query.args = new String[]{str};
        this.dbHelper.delete(query);
    }

    private void deleteAssetForAdId(String str) throws DatabaseHelper.DBException {
        Query query = new Query(this.adapters.get(AdAsset.class).tableName());
        query.selection = "ad_identifier=?";
        query.args = new String[]{str};
        this.dbHelper.delete(query);
    }

    /* access modifiers changed from: private */
    public <T> void deleteModel(T t) throws DatabaseHelper.DBException {
        deleteModel(t.getClass(), this.adapters.get(t.getClass()).toContentValues(t).getAsString(IdColumns.COLUMN_IDENTIFIER));
    }

    public void deleteAdvertisement(final String str) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Repository.this.deleteAdInternal(str);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteAdInternal(String str) throws DatabaseHelper.DBException {
        if (!TextUtils.isEmpty(str)) {
            deleteAssetForAdId(str);
            deleteModel(Advertisement.class, str);
            try {
                this.designer.deleteAssets(str);
            } catch (IOException e) {
                Log.e(TAG, "IOException ", e);
            }
        }
    }

    public FutureResult<Collection<Placement>> loadValidPlacements() {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<Collection<Placement>>() {
            public List<Placement> call() {
                List<Placement> access$800;
                synchronized (Repository.this) {
                    Query query = new Query("placement");
                    query.selection = "is_valid = ?";
                    query.args = new String[]{"1"};
                    access$800 = Repository.this.extractModels(Placement.class, Repository.this.dbHelper.query(query));
                }
                return access$800;
            }
        }));
    }

    /* access modifiers changed from: private */
    public List<String> loadValidPlacementIds() {
        Query query = new Query("placement");
        query.selection = "is_valid = ?";
        query.args = new String[]{"1"};
        query.columns = new String[]{IdColumns.COLUMN_IDENTIFIER};
        Cursor query2 = this.dbHelper.query(query);
        ArrayList arrayList = new ArrayList();
        if (query2 != null) {
            while (query2 != null) {
                try {
                    if (!query2.moveToNext()) {
                        break;
                    }
                    arrayList.add(query2.getString(query2.getColumnIndex(IdColumns.COLUMN_IDENTIFIER)));
                } catch (Exception e) {
                    VungleLogger.critical(true, Repository.class.getSimpleName(), "loadValidPlacementIds", e.toString());
                } catch (Throwable th) {
                    query2.close();
                    throw th;
                }
            }
            query2.close();
        }
        return arrayList;
    }

    public FutureResult<File> getAdvertisementAssetDirectory(final String str) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<File>() {
            public File call() throws Exception {
                return Repository.this.designer.getAssetDirectory(str);
            }
        }));
    }

    public FutureResult<Collection<String>> getValidPlacementIds() {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<Collection<String>>() {
            public Collection<String> call() throws Exception {
                List access$1300;
                synchronized (Repository.this) {
                    access$1300 = Repository.this.loadValidPlacementIds();
                }
                return access$1300;
            }
        }));
    }

    public FutureResult<List<String>> getAvailableBidTokens(final String str, final int i, final int i2) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<String>>() {
            public List<String> call() {
                ArrayList arrayList;
                synchronized (Repository.this) {
                    Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
                    String str = "bid_token != '' AND ( state = ? OR state = ? ) AND expire_time > ?";
                    if (!TextUtils.isEmpty(str)) {
                        str = str + " AND placement_id = ?";
                    }
                    query.selection = str;
                    query.columns = new String[]{AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN};
                    int i = 0;
                    String[] strArr = {String.valueOf(0), String.valueOf(1), String.valueOf(System.currentTimeMillis() / 1000)};
                    if (!TextUtils.isEmpty(str)) {
                        strArr = new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(System.currentTimeMillis() / 1000), str};
                    }
                    query.args = strArr;
                    Cursor query2 = Repository.this.dbHelper.query(query);
                    arrayList = new ArrayList();
                    if (query2 != null) {
                        while (query2.moveToNext() && i < i) {
                            try {
                                String string = query2.getString(query2.getColumnIndex(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN));
                                if (string.getBytes().length + i <= i) {
                                    i += string.getBytes().length + i2;
                                    arrayList.add(string);
                                }
                            } catch (Exception e) {
                                try {
                                    VungleLogger.critical(true, Repository.class.getSimpleName(), "getAvailableBidTokens", e.toString());
                                    return new ArrayList();
                                } finally {
                                    query2.close();
                                }
                            }
                        }
                        query2.close();
                    }
                }
                return arrayList;
            }
        }));
    }

    public void setValidPlacements(final List<Placement> list) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                synchronized (Repository.class) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(PlacementDBAdapter.PlacementColumns.COLUMN_IS_VALID, false);
                    Repository.this.dbHelper.update(new Query("placement"), contentValues);
                    for (Placement placement : list) {
                        Placement placement2 = (Placement) Repository.this.loadModel(placement.getId(), Placement.class);
                        if (!(placement2 == null || (placement2.isIncentivized() == placement.isIncentivized() && placement2.isHeaderBidding() == placement.isHeaderBidding()))) {
                            String access$1400 = Repository.TAG;
                            Log.w(access$1400, "Placements data for " + placement.getId() + " is different from disc, deleting old");
                            for (String access$1100 : Repository.this.getAdsForPlacement(placement.getId())) {
                                Repository.this.deleteAdInternal(access$1100);
                            }
                            Repository.this.deleteModel(Placement.class, placement2.getId());
                        }
                        if (placement2 != null) {
                            placement.setWakeupTime(placement2.getWakeupTime());
                            placement.setAdSize(placement2.getAdSize());
                        }
                        placement.setValid(placement.getPlacementAdType() != 2);
                        if (placement.getMaxHbCache() == Integer.MIN_VALUE) {
                            placement.setValid(false);
                        }
                        Repository.this.saveModel(placement);
                    }
                }
                return null;
            }
        });
    }

    public FutureResult<List<String>> findAdsForPlacement(final String str) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<String>>() {
            public List<String> call() {
                return Repository.this.getAdsForPlacement(str);
            }
        }));
    }

    /* access modifiers changed from: private */
    public List<String> getAdsForPlacement(String str) {
        Query query = new Query(AdvertisementDBAdapter.AdvertisementColumns.TABLE_NAME);
        query.columns = new String[]{IdColumns.COLUMN_IDENTIFIER};
        query.selection = "placement_id=?";
        query.args = new String[]{str};
        ArrayList arrayList = new ArrayList();
        Cursor query2 = this.dbHelper.query(query);
        if (query2 == null) {
            return arrayList;
        }
        while (query2.moveToNext()) {
            try {
                arrayList.add(query2.getString(query2.getColumnIndex(IdColumns.COLUMN_IDENTIFIER)));
            } catch (Exception e) {
                VungleLogger.critical(true, Repository.class.getSimpleName(), "getAdsForPlacement", e.toString());
                return new ArrayList();
            } finally {
                query2.close();
            }
        }
        return arrayList;
    }

    public List<Advertisement> getAdsByCreative(Collection<String> collection) {
        HashSet hashSet = new HashSet(collection);
        HashSet hashSet2 = new HashSet();
        for (Advertisement next : loadAllModels(Advertisement.class)) {
            if (hashSet.contains(next.getCreativeId())) {
                hashSet2.add(next);
            }
        }
        return new ArrayList(hashSet2);
    }

    public List<Advertisement> getAdsByCreative(String str) {
        return getAdsByCreative((Collection<String>) Collections.singletonList(str));
    }

    public List<Advertisement> getAdsByCampaign(Collection<String> collection) {
        HashSet hashSet = new HashSet(collection);
        HashSet hashSet2 = new HashSet();
        for (Advertisement next : loadAllModels(Advertisement.class)) {
            if (hashSet.contains(next.getCampaignId())) {
                hashSet2.add(next);
            }
        }
        return new ArrayList(hashSet2);
    }

    public List<Advertisement> getAdsByCampaign(String str) {
        return getAdsByCampaign((Collection<String>) Collections.singletonList(str));
    }

    public String getPlacementIdByAd(Advertisement advertisement) {
        return advertisement.getPlacementId();
    }

    public List<CacheBust> getUnProcessedBusts() {
        List<CacheBust> loadAllModels = loadAllModels(CacheBust.class);
        ArrayList arrayList = new ArrayList();
        for (CacheBust next : loadAllModels) {
            if (next.getTimestampProcessed() == 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void clearAllData() {
        this.dbHelper.dropDb();
        this.designer.clearCache();
    }

    public void close() {
        this.dbHelper.close();
    }

    public void saveAndApplyState(final Advertisement advertisement, final String str, final int i) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x004b, code lost:
                if (r0 != 5) goto L_0x0075;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Void call() throws java.lang.Exception {
                /*
                    r3 = this;
                    java.lang.String r0 = com.vungle.warren.persistence.Repository.TAG
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "Setting "
                    r1.append(r2)
                    int r2 = r4
                    r1.append(r2)
                    java.lang.String r2 = " for adv "
                    r1.append(r2)
                    com.vungle.warren.model.Advertisement r2 = r2
                    java.lang.String r2 = r2.getId()
                    r1.append(r2)
                    java.lang.String r2 = " and pl "
                    r1.append(r2)
                    java.lang.String r2 = r3
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    android.util.Log.i(r0, r1)
                    com.vungle.warren.model.Advertisement r0 = r2
                    int r1 = r4
                    r0.setState(r1)
                    int r0 = r4
                    r1 = 0
                    if (r0 == 0) goto L_0x0067
                    r2 = 1
                    if (r0 == r2) goto L_0x0067
                    r2 = 2
                    if (r0 == r2) goto L_0x005a
                    r2 = 3
                    if (r0 == r2) goto L_0x004e
                    r2 = 4
                    if (r0 == r2) goto L_0x004e
                    r2 = 5
                    if (r0 == r2) goto L_0x0067
                    goto L_0x0075
                L_0x004e:
                    com.vungle.warren.persistence.Repository r0 = com.vungle.warren.persistence.Repository.this
                    com.vungle.warren.model.Advertisement r2 = r2
                    java.lang.String r2 = r2.getId()
                    r0.deleteAdInternal(r2)
                    goto L_0x0075
                L_0x005a:
                    com.vungle.warren.model.Advertisement r0 = r2
                    r0.setPlacementId(r1)
                    com.vungle.warren.persistence.Repository r0 = com.vungle.warren.persistence.Repository.this
                    com.vungle.warren.model.Advertisement r2 = r2
                    r0.saveModel(r2)
                    goto L_0x0075
                L_0x0067:
                    com.vungle.warren.model.Advertisement r0 = r2
                    java.lang.String r2 = r3
                    r0.setPlacementId(r2)
                    com.vungle.warren.persistence.Repository r0 = com.vungle.warren.persistence.Repository.this
                    com.vungle.warren.model.Advertisement r2 = r2
                    r0.saveModel(r2)
                L_0x0075:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.persistence.Repository.AnonymousClass24.call():java.lang.Void");
            }
        });
    }

    public void trimVisionData(final int i) throws DatabaseHelper.DBException {
        runAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                Query query = new Query(VisionDataDBAdapter.VisionDataColumns.TABLE_NAME);
                query.selection = "_id <= ( SELECT MAX( _id ) FROM vision_data ) - ?";
                query.args = new String[]{Integer.toString(i)};
                Repository.this.dbHelper.delete(query);
                return null;
            }
        });
    }

    public FutureResult<VisionAggregationInfo> getVisionAggregationInfo(final long j) {
        return new FutureResult<>(this.ioExecutor.submit(new Callable<VisionAggregationInfo>() {
            public VisionAggregationInfo call() {
                Query query = new Query(VisionDataDBAdapter.VisionDataColumns.TABLE_NAME);
                query.selection = "timestamp >= ?";
                query.orderBy = "_id DESC";
                query.args = new String[]{Long.toString(j)};
                Cursor query2 = Repository.this.dbHelper.query(query);
                VisionDataDBAdapter visionDataDBAdapter = (VisionDataDBAdapter) Repository.this.adapters.get(VisionData.class);
                if (query2 != null) {
                    if (visionDataDBAdapter != null) {
                        try {
                            if (query2.moveToFirst()) {
                                ContentValues contentValues = new ContentValues();
                                DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                                return new VisionAggregationInfo(query2.getCount(), visionDataDBAdapter.fromContentValues(contentValues).creative);
                            }
                        } catch (Exception e) {
                            VungleLogger.critical(true, Repository.class.getSimpleName(), "getVisionAggregationInfo", e.toString());
                            return null;
                        } finally {
                            query2.close();
                        }
                    }
                    query2.close();
                }
                return null;
            }
        }));
    }

    public FutureResult<List<VisionAggregationData>> getVisionAggregationData(long j, int i, String str) {
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        return new FutureResult<>(this.ioExecutor.submit(new Callable<List<VisionAggregationData>>() {
            public List<VisionAggregationData> call() {
                ArrayList arrayList = new ArrayList();
                if (!VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER.equals(str2) && !"campaign".equals(str2) && !VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE.equals(str2)) {
                    return arrayList;
                }
                Query query = new Query(VisionDataDBAdapter.VisionDataColumns.TABLE_NAME);
                String str = str2;
                query.columns = new String[]{"COUNT ( * ) as viewCount", "MAX ( timestamp ) as lastTimeStamp", str};
                query.selection = "timestamp >= ?";
                query.groupBy = str;
                query.orderBy = "_id DESC";
                query.limit = Integer.toString(i2);
                query.args = new String[]{Long.toString(j2)};
                Cursor query2 = Repository.this.dbHelper.query(query);
                if (query2 != null) {
                    while (query2.moveToNext()) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            DatabaseUtils.cursorRowToContentValues(query2, contentValues);
                            arrayList.add(new VisionAggregationData(contentValues.getAsString(str2), contentValues.getAsInteger("viewCount").intValue(), contentValues.getAsLong("lastTimeStamp").longValue()));
                        } catch (Exception e) {
                            VungleLogger.critical(true, Repository.class.getSimpleName(), "getVisionAggregationInfo", e.toString());
                            return new ArrayList();
                        } finally {
                            query2.close();
                        }
                    }
                }
                return arrayList;
            }
        }));
    }

    private static class VungleDatabaseCreator implements DatabaseHelper.DatabaseFactory {
        private final Context context;

        public VungleDatabaseCreator(Context context2) {
            this.context = context2;
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 2) {
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN status INTEGER DEFAULT 1");
            }
            if (i < 3) {
                sQLiteDatabase.execSQL(VisionDataDBAdapter.CREATE_VISION_TABLE_QUERY);
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN ad_size TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN tt_download NUMERIC DEFAULT -1");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN ad_size TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN refresh_duration NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN supported_template_types NUMERIC DEFAULT 0");
            }
            if (i < 4) {
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN header_bidding SHORT ");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN header_bidding SHORT ");
            }
            if (i < 5) {
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN autocache_priority NUMERIC DEFAULT 2147483647");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN asset_download_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN asset_download_duration NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN ad_request_start_time NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN init_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN asset_download_duration NUMERIC DEFAULT 0");
            }
            if (i < 6) {
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_enable_om_sdk NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_om_sdk_extra_vast TEXT ");
            }
            if (i < 7) {
                sQLiteDatabase.execSQL(AnalyticUrlDBAdapter.CREATE_ANALYTICS_URL_TABLE_QUERY);
            }
            if (i < 8) {
                sQLiteDatabase.execSQL(CacheBustDBAdapter.CREATE_CACHE_BUST_TABLE_QUERY);
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_request_timestamp NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN max_hb_cache NUMERIC DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE placement ADD COLUMN recommended_ad_size TEXT ");
            }
            if (i < 9) {
                sQLiteDatabase.execSQL("ALTER TABLE report ADD COLUMN play_remote_url SHORT DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_assets_fully_downloaded SHORT DEFAULT 0");
            }
            if (i < 10) {
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_click_coordinates_enabled SHORT DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_deep_link TEXT ");
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_notifications TEXT ");
            }
            if (i < 11) {
                sQLiteDatabase.execSQL("ALTER TABLE advertisement ADD COLUMN column_header_bidding SHORT DEFAULT 0");
            }
        }

        public void create(SQLiteDatabase sQLiteDatabase) {
            dropOldFilesData();
            sQLiteDatabase.execSQL(AdvertisementDBAdapter.CREATE_ADVERTISEMENT_TABLE_QUERY);
            sQLiteDatabase.execSQL(PlacementDBAdapter.CREATE_PLACEMENT_TABLE_QUERY);
            sQLiteDatabase.execSQL(CookieDBAdapter.CREATE_COOKIE_TABLE_QUERY);
            sQLiteDatabase.execSQL(ReportDBAdapter.CREATE_REPORT_TABLE_QUERY);
            sQLiteDatabase.execSQL(AdAssetDBAdapter.CREATE_ASSET_TABLE_QUERY);
            sQLiteDatabase.execSQL(VisionDataDBAdapter.CREATE_VISION_TABLE_QUERY);
            sQLiteDatabase.execSQL(AnalyticUrlDBAdapter.CREATE_ANALYTICS_URL_TABLE_QUERY);
            sQLiteDatabase.execSQL(CacheBustDBAdapter.CREATE_CACHE_BUST_TABLE_QUERY);
            sQLiteDatabase.execSQL(SessionDataDBAdapter.CREATE_SESSION_DATA_TABLE_QUERY);
        }

        public void deleteData(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS advertisement");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cookie");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS placement");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS report");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS adAsset");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS vision_data");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS analytic_url");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cache_bust");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS session_data");
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='table'", (String[]) null);
            while (rawQuery != null && rawQuery.moveToNext()) {
                String string = rawQuery.getString(1);
                if (!string.equals("android_metadata") && !string.startsWith("sqlite_")) {
                    arrayList.add(string);
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            for (String str : arrayList) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            }
            create(sQLiteDatabase);
        }

        private void deleteDatabase(String str) {
            this.context.deleteDatabase(str);
        }

        private void dropOldFilesData() {
            deleteDatabase("vungle");
            File externalFilesDir = this.context.getExternalFilesDir((String) null);
            if ((Environment.getExternalStorageState().equals("mounted") && externalFilesDir != null) && externalFilesDir.exists()) {
                try {
                    FileUtility.delete(new File(externalFilesDir, ".vungle"));
                } catch (IOException e) {
                    Log.e(Repository.TAG, "IOException ", e);
                }
            }
            File filesDir = this.context.getFilesDir();
            if (filesDir.exists()) {
                try {
                    FileUtility.delete(new File(filesDir, "vungle"));
                } catch (IOException e2) {
                    Log.e(Repository.TAG, "IOException ", e2);
                }
            }
            try {
                FileUtility.delete(new File(this.context.getCacheDir() + File.separator + "downloads_vungle"));
            } catch (IOException e3) {
                Log.e(Repository.TAG, "IOException ", e3);
            }
        }
    }

    private void runAndWait(Callable<Void> callable) throws DatabaseHelper.DBException {
        try {
            this.ioExecutor.submit(callable).get();
        } catch (ExecutionException e) {
            if (!(e.getCause() instanceof DatabaseHelper.DBException)) {
                Log.e(TAG, "Exception during runAndWait", e);
                return;
            }
            throw ((DatabaseHelper.DBException) e.getCause());
        } catch (InterruptedException e2) {
            Log.e(TAG, "InterruptedException ", e2);
            Thread.currentThread().interrupt();
        }
    }

    public <T> void deleteAll(Class<T> cls) {
        if (cls == Advertisement.class) {
            for (Advertisement id : loadAll(Advertisement.class).get()) {
                try {
                    deleteAdvertisement(id.getId());
                } catch (DatabaseHelper.DBException e) {
                    Log.e(TAG, "DB Exception deleting advertisement", e);
                }
            }
            return;
        }
        for (T deleteModel : loadAll(cls).get()) {
            try {
                deleteModel(deleteModel);
            } catch (DatabaseHelper.DBException e2) {
                Log.e(TAG, "DB Exception deleting db entry", e2);
            }
        }
    }

    public void setMockDBHelper(DatabaseHelper databaseHelper) {
        this.dbHelper = databaseHelper;
    }
}
