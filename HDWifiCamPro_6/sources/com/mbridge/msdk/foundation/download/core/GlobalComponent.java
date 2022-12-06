package com.mbridge.msdk.foundation.download.core;

import android.content.Context;
import android.database.Cursor;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.database.DatabaseHelper;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class GlobalComponent {
    private static volatile GlobalComponent INSTANCE;
    private int byteBufferSize = 4096;
    private Context context;
    private IDatabaseHelper databaseHelper;
    private String databaseTableName = DownloadModel.TABLE_NAME;
    private ILogger logger;
    private OkHttpClient okHttpClient;

    private GlobalComponent() {
    }

    public static GlobalComponent getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (GlobalComponent.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new GlobalComponent();
                }
            }
        }
        return INSTANCE;
    }

    public final void initialize(Context context2, MBDownloadConfig mBDownloadConfig) {
        this.context = context2.getApplicationContext();
        this.logger = mBDownloadConfig.getLogger();
        if (mBDownloadConfig == null || mBDownloadConfig.getDatabaseHandler() == null || mBDownloadConfig.getDatabaseHelper() == null) {
            this.databaseHelper = new IDatabaseHelper() {
                public void clear() {
                }

                public void find(String str, String str2, IDatabaseHelper.IDatabaseListener iDatabaseListener) {
                }

                public List<DownloadModel> findAll() {
                    return null;
                }

                public void findByDownloadUrl(String str, IDatabaseHelper.IDatabaseListener iDatabaseListener) {
                }

                public List<DownloadModel> getUnwantedModels(long j) {
                    return null;
                }

                public void insert(DownloadModel downloadModel) {
                }

                public Cursor rawQuery(String str, String[] strArr) {
                    return null;
                }

                public void remove(String str) {
                }

                public void remove(String str, String str2) {
                }

                public void update(DownloadModel downloadModel, String str) {
                }

                public void updateProgress(String str, String str2, DownloadModel downloadModel) {
                }

                public void updateUnzipResource(String str, String str2, long j) {
                }
            };
        } else {
            this.databaseHelper = new DatabaseHelper(context2, mBDownloadConfig.getDatabaseHandler(), mBDownloadConfig.getDatabaseHelper());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(mBDownloadConfig.getMaxRequests());
        dispatcher.setMaxRequestsPerHost(mBDownloadConfig.getMaxRequestsPerHost());
        this.okHttpClient = new OkHttpClient.Builder().connectTimeout(mBDownloadConfig.getDefaultConnectTimeout(), TimeUnit.MILLISECONDS).readTimeout(mBDownloadConfig.getDefaultConnectTimeout(), TimeUnit.MILLISECONDS).writeTimeout(mBDownloadConfig.getDefaultWriteTimeout(), TimeUnit.MILLISECONDS).dispatcher(dispatcher).pingInterval(mBDownloadConfig.getDefaultPingInterval(), TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).protocols(arrayList).build();
    }

    public final ILogger getLogger() {
        if (this.logger == null) {
            this.logger = new ILogger() {
                public void log(String str, String str2) {
                    q.a(str, str2);
                }

                public void log(String str, Exception exc) {
                    q.a(str, exc.getMessage());
                }
            };
        }
        return this.logger;
    }

    public final IDatabaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public final int getByteBufferSize() {
        return this.byteBufferSize;
    }

    public final Context getContext() {
        return this.context;
    }

    public final OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public final String getDatabaseTableName() {
        return this.databaseTableName;
    }
}
