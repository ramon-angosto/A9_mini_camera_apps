package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.Campaign;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: CampaignDao */
public class e extends a<Campaign> {
    private static final String a = e.class.getName();
    private static e b = null;
    private final String c = "rid";
    private final String d = "cid";
    private final String e = CampaignEx.JSON_KEY_PLCT;
    private final String f = CampaignEx.JSON_KEY_PLCTB;
    private final String g = "timestamp";
    private final String h = "ridCount";
    private final String i = " WHERE ";
    private final String j = " AND ";
    private final String k = "SELECT ";
    private final String l = "*";
    private final String m = " FROM ";
    private final String n = " AND readyState = '0'";
    private final String o = " AND is_bid_campaign = 1";
    private final String p = " order by ts ASC";
    private final String q = " group by request_id";
    private final String r = " group by bid_token";

    private e(f fVar) {
        super(fVar);
    }

    public static synchronized e a(f fVar) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                b = new e(fVar);
            }
            eVar = b;
        }
        return eVar;
    }

    public final synchronized void a(String str, int i2, int i3) {
        try {
            String str2 = "unitid = " + str + " AND " + "level" + " = " + i2 + " AND " + "adSource" + " = " + i3;
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(String str, int i2, int i3, boolean z) {
        try {
            String str2 = "unitid = " + str + " AND " + "level" + " = " + i2 + " AND " + "adSource" + " = " + i3;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(" AND is_bid_campaign = ");
            sb.append(z ? 1 : 0);
            String sb2 = sb.toString();
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", sb2, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("readyState", 2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("id = '" + next.getId() + "' AND " + "unitid" + " = " + str + " AND " + "request_id" + " = '" + next.getRequestId() + "'");
                    sb.append(" AND is_bid_campaign = ");
                    sb.append(next.isBidCampaign() ? 1 : 0);
                    String sb2 = sb.toString();
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, sb2, (String[]) null);
                        }
                    } catch (SQLException e2) {
                        q.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, boolean z) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        if (next.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid");
                            sb.append(" = '");
                            sb.append(str);
                            sb.append("' AND ");
                            sb.append("id");
                            sb.append(" = '");
                            sb.append(next.getId());
                            sb.append("' AND ");
                            sb.append("request_id");
                            sb.append(" = '");
                            sb.append(next.getRequestId());
                            sb.append("'");
                            if (z) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("readyState", 2);
                            SQLiteDatabase writableDatabase = getWritableDatabase();
                            if (writableDatabase != null) {
                                writableDatabase.update("campaign", contentValues, sb.toString(), (String[]) null);
                            }
                        }
                    } catch (SQLException e2) {
                        q.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r6, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r7, java.lang.String r8, int r9) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x0086
            if (r7 == 0) goto L_0x0086
            int r0 = r7.size()     // Catch:{ all -> 0x0088 }
            if (r0 <= 0) goto L_0x0086
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x0086
            android.database.sqlite.SQLiteDatabase r0 = r5.getWritableDatabase()     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r5)
            return
        L_0x001d:
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
        L_0x0021:
            boolean r1 = r7.hasNext()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            if (r1 == 0) goto L_0x0086
            java.lang.Object r1 = r7.next()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            if (r1 == 0) goto L_0x0021
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r2.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "unitid = '"
            r2.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r2.append(r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "' AND "
            r2.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "id"
            r2.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = " = '"
            r2.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = r1.getId()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r2.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "' AND "
            r2.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "request_id"
            r2.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = " = '"
            r2.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r1 = r1.getRequestId()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r2.append(r1)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r1 = "'"
            r2.append(r1)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r2.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r2.put(r8, r3)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "campaign"
            r4 = 0
            r0.update(r3, r2, r1, r4)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            goto L_0x0021
        L_0x0084:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0088 }
        L_0x0086:
            monitor-exit(r5)
            return
        L_0x0088:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, java.util.List, java.lang.String, int):void");
    }

    public final synchronized void a(String str, List<CampaignEx> list, List<CampaignEx> list2, boolean z) {
        String str2;
        if (getWritableDatabase() != null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        for (CampaignEx next : list) {
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("readyState", 0);
                                String str3 = "unitid = '" + str + "' AND " + "id" + " = '" + next.getId() + "' AND " + "request_id" + " = '" + next.getRequestId() + "'";
                                if (z) {
                                    str2 = str3 + " AND " + "is_bid_campaign" + " = 1";
                                } else {
                                    str2 = str3 + " AND " + "is_bid_campaign" + " = 0";
                                }
                                getWritableDatabase().update("campaign", contentValues, str2, (String[]) null);
                            } catch (Exception e2) {
                                q.d("CampaignDao", e2.getLocalizedMessage());
                            }
                        }
                    }
                } catch (Exception e3) {
                    try {
                        q.d("CampaignDao", e3.getLocalizedMessage());
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (CampaignEx next2 : list2) {
                    try {
                        if (next2.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid");
                            sb.append(" = '");
                            sb.append(str);
                            sb.append("' AND ");
                            sb.append("id");
                            sb.append(" = '");
                            sb.append(next2.getId());
                            sb.append("' AND ");
                            sb.append("request_id");
                            sb.append(" = '");
                            sb.append(next2.getRequestId());
                            sb.append("'");
                            if (z) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("readyState", 2);
                            getWritableDatabase().update("campaign", contentValues2, sb.toString(), (String[]) null);
                        }
                    } catch (SQLException e4) {
                        q.d("CampaignDao", e4.getLocalizedMessage());
                    }
                }
            }
        } else {
            return;
        }
    }

    public final synchronized void b(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", 0);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = '" + str + "' AND " + "id" + " = '" + next.getId() + "' AND " + "request_id" + " = '" + next.getRequestId() + "'", (String[]) null);
                        }
                    } catch (Exception e2) {
                        q.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2) {
        try {
            String str3 = "id = '" + str + "' AND " + "unitid" + " = " + str2;
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str3, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete("campaign", "unitid" + " = '" + str + "' AND " + "readyState" + " = " + 2, (String[]) null);
                }
            } catch (Exception e2) {
                q.d("CampaignDao", e2.getLocalizedMessage());
            }
        } else {
            return;
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0060, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> b(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r2 = "SELECT * FROM "
            r1.<init>(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r2 = "campaign"
            r1.append(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r2 = " WHERE "
            r1.append(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r2 = "unitid"
            r1.append(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r2 = " = '"
            r1.append(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r1.append(r4)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r4 = "' AND "
            r1.append(r4)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r4 = "readyState"
            r1.append(r4)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r4 = " = "
            r1.append(r4)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r4 = 2
            r1.append(r4)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            android.database.sqlite.SQLiteDatabase r4 = r3.getReadableDatabase()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            android.database.Cursor r4 = r4.rawQuery(r1, r0)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            if (r4 == 0) goto L_0x0061
            int r1 = r4.getCount()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            if (r1 <= 0) goto L_0x0061
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r1.<init>()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
        L_0x004c:
            boolean r2 = r4.moveToNext()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            if (r2 == 0) goto L_0x005a
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r3.a((android.database.Cursor) r4)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r1.add(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            goto L_0x004c
        L_0x005a:
            if (r4 == 0) goto L_0x005f
            r4.close()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
        L_0x005f:
            monitor-exit(r3)
            return r1
        L_0x0061:
            if (r4 == 0) goto L_0x0066
            r4.close()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
        L_0x0066:
            monitor-exit(r3)
            return r0
        L_0x0068:
            monitor-exit(r3)
            return r0
        L_0x006a:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.b(java.lang.String):java.util.List");
    }

    public final synchronized void a(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", 2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid" + " = '" + str + "' AND " + "id" + " = '" + next.getId() + "' AND " + "request_id" + " = '" + next.getRequestId() + "'", (String[]) null);
                        }
                    } catch (SQLException e2) {
                        q.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2, boolean z, String str3) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("id = '");
            sb.append(str);
            sb.append("' AND ");
            sb.append("unitid");
            sb.append(" = ");
            sb.append(str2);
            sb.append(" AND ");
            sb.append("is_bid_campaign");
            sb.append(" = ");
            sb.append(z ? "1" : MBridgeConstans.ENDCARD_URL_TYPE_PL);
            sb.append(" AND ");
            sb.append("request_id");
            sb.append(" = '");
            sb.append(str3);
            sb.append("'");
            String sb2 = sb.toString();
            if (getWritableDatabase() != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                getWritableDatabase().update("campaign", contentValues, sb2, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void b(String str, String str2) {
        try {
            if (getWritableDatabase() != null) {
                String str3 = "id = '" + str + "' AND " + "request_id" + " = '" + str2 + "'";
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                getWritableDatabase().update("campaign", contentValues, str3, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(String str, String str2, int i2, int i3, boolean z) {
        String str3;
        try {
            String str4 = "id = '" + str + "' AND " + "unitid" + " = " + str2 + " AND " + "level" + " = " + i2 + " AND " + "adSource" + " = " + i3;
            if (z) {
                str3 = str4 + " AND is_bid_campaign = 1";
            } else {
                str3 = str4 + " AND is_bid_campaign = 0";
            }
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str3, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
    }

    public final synchronized void c(String str) {
        try {
            String str2 = "unitid = " + str;
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(String str, int i2, boolean z) {
        String str2;
        if (z) {
            try {
                str2 = "placement_id = " + str + " AND " + "ad_type" + " = " + i2;
            } catch (Exception e2) {
                q.d("CampaignDao", e2.getLocalizedMessage());
            }
        } else {
            str2 = "ad_type = " + i2;
        }
        if (getWritableDatabase() != null) {
            getWritableDatabase().delete("campaign", str2, (String[]) null);
        } else {
            return;
        }
        return;
    }

    public final synchronized void a() {
        try {
            String str = "ts<" + (System.currentTimeMillis() - 3600000) + " AND " + CampaignEx.JSON_KEY_ST_TS + ">" + 0;
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str, (String[]) null);
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(long j2, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = "(plctb>0 and (plctb* 1000+ts)<" + currentTimeMillis + ") or (" + CampaignEx.JSON_KEY_PLCTB + "<=" + 0 + " and " + CampaignEx.JSON_KEY_ST_TS + "<" + (currentTimeMillis - j2) + ") and " + "unitid" + "=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, strArr);
            }
        } catch (Exception e2) {
            q.d(a, e2.getMessage());
        }
        return;
    }

    public final synchronized void b(long j2, String str) {
        try {
            String str2 = "ts<" + (System.currentTimeMillis() - j2) + " and " + "unitid" + "=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, strArr);
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x002b
            int r0 = r2.size()     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x000a
            goto L_0x002b
        L_0x000a:
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0012
            monitor-exit(r1)
            return
        L_0x0012:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0028 }
        L_0x0016:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0028 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0028 }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r3, (java.lang.String) r4, (int) r5)     // Catch:{ all -> 0x0028 }
            goto L_0x0016
        L_0x0026:
            monitor-exit(r1)
            return
        L_0x0028:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x002b:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.util.List, java.lang.String, java.lang.String, int):void");
    }

    private synchronized long a(CampaignEx campaignEx, String str, String str2, int i2) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("id", campaignEx.getId());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            contentValues.put("placement_id", str);
            contentValues.put("unitid", str2);
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            contentValues.put("app_name", campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put("video_url", campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(CampaignUnit.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(CampaignUnit.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.c());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.b()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.a()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN, campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(CampaignUnit.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("request_id", campaignEx.getRequestId());
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            return getWritableDatabase().insert("campaign", (String) null, contentValues);
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
            return -1;
        }
    }

    public final synchronized long a(CampaignEx campaignEx, String str, int i2) {
        String str2;
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("unitid", str);
            contentValues.put("request_id", campaignEx.getRequestId());
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            contentValues.put("app_name", campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put("video_url", campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(CampaignUnit.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(CampaignUnit.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.c());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.b()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.a()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN, campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(CampaignUnit.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put("placement_id", campaignEx.getPlacementId());
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            if (a(campaignEx.getId(), campaignEx.getTab(), str, i2, campaignEx.getType(), campaignEx.isBidCampaign())) {
                if (campaignEx.isBidCampaign()) {
                    str2 = "unitid = " + str + " AND " + "is_bid_campaign" + " = 1";
                } else {
                    str2 = "id = " + campaignEx.getId() + " AND " + "unitid" + " = " + str + " AND " + "is_bid_campaign" + " = 0";
                }
                return (long) getWritableDatabase().update("campaign", contentValues, str2, (String[]) null);
            }
            return getWritableDatabase().insert("campaign", (String) null, contentValues);
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(final java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3, final java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x001c
            int r0 = r3.size()     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x000a
            goto L_0x001c
        L_0x000a:
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x0019 }
            com.mbridge.msdk.foundation.db.e$1 r1 = new com.mbridge.msdk.foundation.db.e$1     // Catch:{ all -> 0x0019 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0019 }
            r0.<init>(r1)     // Catch:{ all -> 0x0019 }
            r0.start()     // Catch:{ all -> 0x0019 }
            monitor-exit(r2)
            return
        L_0x0019:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x001c:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.b(java.util.List, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        return 0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a(java.lang.String r10, long r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            com.mbridge.msdk.b.a r1 = r1.b(r2)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r1 != 0) goto L_0x001c
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            com.mbridge.msdk.b.a r1 = r1.b()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
        L_0x001c:
            long r1 = r1.v()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r9.a((long) r1, (java.lang.String) r10)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r5 = 0
            r6 = 0
            r7 = 1
            r8 = 0
            r3 = r9
            r4 = r10
            java.util.List r10 = r3.a((java.lang.String) r4, (int) r5, (int) r6, (int) r7, (boolean) r8)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r10 == 0) goto L_0x0054
            boolean r3 = r10.isEmpty()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r3 == 0) goto L_0x0039
            goto L_0x0054
        L_0x0039:
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
        L_0x003d:
            boolean r3 = r10.hasNext()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r3 == 0) goto L_0x0051
            java.lang.Object r3 = r10.next()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            boolean r3 = r3.isSpareOffer(r11, r1)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r3 != 0) goto L_0x003d
            monitor-exit(r9)
            return r0
        L_0x0051:
            r10 = 1
            monitor-exit(r9)
            return r10
        L_0x0054:
            r10 = -1
            monitor-exit(r9)
            return r10
        L_0x0057:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x005a:
            monitor-exit(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.a(java.lang.String, long):int");
    }

    public final synchronized boolean a(String str, int i2, String str2, int i3, int i4, boolean z) {
        String str3;
        if (z) {
            str3 = "SELECT id FROM campaign WHERE " + "unitid = " + str2 + " AND " + "is_bid_campaign" + " = 1";
        } else {
            str3 = "SELECT id FROM campaign WHERE " + "id='" + str + "' AND " + "tab" + "=" + i2 + " AND " + "unitid" + " = '" + str2 + "' AND " + "level" + " = " + i3 + " AND " + "adSource" + " = " + i4 + " AND " + "is_bid_campaign" + " = 0";
        }
        Cursor rawQuery = getReadableDatabase().rawQuery(str3, (String[]) null);
        if (rawQuery == null || rawQuery.getCount() <= 0) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        }
        rawQuery.close();
        return true;
    }

    public final List<CampaignEx> a(String str, int i2, int i3, int i4) {
        String str2;
        String str3 = " WHERE unitid = '" + str + "' AND " + "level" + " = " + i3 + " AND " + "adSource" + " = " + i4;
        if (i2 > 0) {
            str2 = " LIMIT " + i2;
        } else {
            str2 = "";
        }
        return f("SELECT * FROM campaign" + str3 + str2);
    }

    public final synchronized List<CampaignEx> a(String str, int i2, int i3, int i4, boolean z) {
        String str2;
        String str3;
        String str4 = " WHERE unitid = '" + str + "' AND " + "level" + " = " + i3 + " AND " + "adSource" + " = " + i4;
        if (z) {
            str2 = str4 + " AND is_bid_campaign = 1";
        } else {
            str2 = str4 + " AND is_bid_campaign = 0";
        }
        str3 = "";
        if (i2 > 0) {
            str3 = " LIMIT " + i2;
        }
        return f("SELECT * FROM campaign" + str2 + str3);
    }

    public final synchronized List<CampaignEx> a(String str, int i2, int i3, int i4, String str2) {
        String str3;
        String str4;
        str3 = ((" WHERE unitid = '" + str + "'" + " AND " + "level" + " = " + i3 + " AND " + "adSource" + " = " + i4) + " AND is_bid_campaign = 1") + " AND readyState = '0'";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + " AND request_id = '" + str2 + "'";
        }
        str4 = "";
        if (i2 > 0) {
            str4 = " LIMIT " + i2;
        }
        return f("SELECT * FROM campaign" + (str3 + " order by ts ASC") + str4);
    }

    public final synchronized List<CampaignEx> b(String str, int i2, int i3, int i4) {
        String str2;
        String str3;
        str2 = " WHERE unitid = '" + str + "' AND " + "level" + " = " + i3 + " AND " + "adSource" + " = " + i4;
        str3 = "";
        if (i2 > 0) {
            str3 = " LIMIT " + i2;
        }
        return f("SELECT * FROM campaign" + str2 + str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r10.getCount() <= 0) goto L_0x05b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r1 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        if (r10.moveToNext() == false) goto L_0x05af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        r2 = new com.mbridge.msdk.foundation.entity.CampaignEx();
        r3 = r10.getString(r10.getColumnIndex("pv_urls"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r4 = new org.json.JSONArray(r3);
        r3 = new java.util.ArrayList();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r6 >= r4.length()) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        r3.add(r4.getString(r6));
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        r2.setPv_urls(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        r2.setId(r10.getString(r10.getColumnIndex("id")));
        r2.setTab(r10.getInt(r10.getColumnIndex("tab")));
        r2.setPackageName(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_PACKAGE_NAME)));
        r2.setAppName(r10.getString(r10.getColumnIndex("app_name")));
        r2.setAppDesc(r10.getString(r10.getColumnIndex("app_desc")));
        r2.setSize(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_APP_SIZE)));
        r2.setImageSize(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_IMAGE_SIZE)));
        r2.setIconUrl(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_ICON_URL)));
        r2.setImageUrl(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_IMAGE_URL)));
        r2.setImpressionURL(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_IMPRESSION_URL)));
        r2.setNoticeUrl(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_NOTICE_URL)));
        r2.setClickURL(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.download.database.DownloadModel.DOWNLOAD_URL)));
        r2.setWtick(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
        r2.setDeepLinkUrl(r10.getString(r10.getColumnIndex("deeplink_url")));
        r2.setUserActivation(java.lang.Boolean.parseBoolean(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_USER_ACTIVATION))));
        r2.setOnlyImpressionURL(r10.getString(r10.getColumnIndex("only_impression")));
        r2.setTemplate(r10.getInt(r10.getColumnIndex("template")));
        r2.setLandingType(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_LANDING_TYPE)));
        r2.setLinkType(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_LINK_TYPE)));
        r2.setClick_mode(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_CLICK_MODE)));
        r2.setRating(java.lang.Double.parseDouble(r10.getString(r10.getColumnIndex("star"))));
        r2.setNumberRating(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_NUMBER_RATING)));
        r2.setClickInterval(r10.getInt(r10.getColumnIndex("cti")));
        r2.setTimestamp(r10.getLong(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_ST_TS)));
        r2.setCacheLevel(r10.getInt(r10.getColumnIndex("level")));
        r2.setType(r10.getInt(r10.getColumnIndex("adSource")));
        r2.setAdCall(r10.getString(r10.getColumnIndex("ad_call")));
        r2.setFca(r10.getInt(r10.getColumnIndex("fc_a")));
        r2.setFcb(r10.getInt(r10.getColumnIndex("fc_b")));
        r2.setAd_url_list(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_AD_URL_LIST)));
        r2.setVideoLength(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
        r2.setVideoSize(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_VIDEO_SIZE)));
        r2.setVideoResolution(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
        r2.setEndcard_click_result(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_ENDCARD_CLICK)));
        r2.setVideoUrlEncode(r10.getString(r10.getColumnIndex("video_url")));
        r2.setWatchMile(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_WATCH_MILE)));
        r2.setTImp(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_T_IMP)));
        r2.setBty(r10.getInt(r10.getColumnIndex("bty")));
        r2.setAdvImp(r10.getString(r10.getColumnIndex("advImp")));
        r2.setOfferType(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_OFFER_TYPE)));
        r2.setGuidelines(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_GUIDELINES)));
        r2.setHtmlUrl(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignUnit.JSON_KEY_HTML_URL)));
        r2.setEndScreenUrl(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignUnit.JSON_KEY_END_SCREEN_URL)));
        r2.setRewardName(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_NAME)));
        r2.setRewardAmount(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_AMOUNT)));
        r2.setRewardPlayStatus(r10.getInt(r10.getColumnIndex("reward_play_status")));
        r2.setRetarget_offer(r10.getInt(r10.getColumnIndex("retarget")));
        r2.setCampaignUnitId(r10.getString(r10.getColumnIndex("unitid")));
        r2.setNativeVideoTracking(com.mbridge.msdk.foundation.entity.CampaignEx.TrackingStr2Object(r10.getString(r10.getColumnIndex("native_ad_tracking"))));
        r2.setNativeVideoTrackingString(r10.getString(r10.getColumnIndex("native_ad_tracking")));
        r2.setVideo_end_type(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.VIDEO_END_TYPE)));
        r2.setendcard_url(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.ENDCARD_URL)));
        r2.setPlayable_ads_without_video(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
        r2.setRewardTemplateMode(com.mbridge.msdk.foundation.entity.CampaignEx.c.a(r10.getString(r10.getColumnIndex("reward_teamplate"))));
        r2.setVideoMD5Value(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
        r2.setGifUrl(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_GIF_URL)));
        r2.setNvT2(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_NV_T2)));
        r2.setClickTimeOutInterval(r10.getInt(r10.getColumnIndex("c_coi")));
        r2.setcUA(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_C_UA)));
        r2.setImpUA(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_IMP_UA)));
        r2.setOc_time(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.KEY_OC_TIME)));
        r2.setOc_type(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.KEY_OC_TYPE)));
        r2.setT_list(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.KEY_T_LIST)));
        r3 = r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.KEY_ADCHOICE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x03a9, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x03ab, code lost:
        r2.setAdchoice(com.mbridge.msdk.foundation.entity.CampaignEx.a.a(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x03b2, code lost:
        r2.setAdchoiceSizeHeight(r10.getInt(r10.getColumnIndex("adchoice_size_height")));
        r2.setAdchoiceSizeWidth(r10.getInt(r10.getColumnIndex("adchoice_size_width")));
        r2.setPlct(r10.getLong(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_PLCT)));
        r2.setPlctb(r10.getLong(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_PLCTB)));
        r2.setAdZip(r10.getString(r10.getColumnIndex("ad_zip")));
        r2.setAdHtml(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_AD_HTML)));
        r2.setBannerUrl(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_BANNER_URL)));
        r2.setBannerHtml(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_BANNER_HTML)));
        r2.setCreativeId(r10.getLong(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_CREATIVE_ID)));
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0432, code lost:
        if (r10.getInt(r10.getColumnIndex("is_bid_campaign")) != 1) goto L_0x0436;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0434, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0436, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0437, code lost:
        r2.setIsBidCampaign(r3);
        r2.setBidToken(r10.getString(r10.getColumnIndex(com.vungle.warren.model.AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN)));
        r2.setAdType(r10.getInt(r10.getColumnIndex("ad_type")));
        r2.setMraid(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_MRAID)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x046b, code lost:
        if (r10.getInt(r10.getColumnIndex("is_mraid_campaign")) != 1) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x046e, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x046f, code lost:
        r2.setIsMraid(r4);
        r2.setOmid(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.KEY_OMID)));
        r2.setReady_rate(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_READY_RATE)));
        r2.setExt_data(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_EXT_DATA)));
        r2.setNscpt(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignUnit.JSON_KEY_NSCPT)));
        r2.setMof_template_url(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL)));
        r2.setMof_tplid(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignUnit.JSON_KEY_MOF_TPLID)));
        r2.setReq_ext_data(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignUnit.JSON_KEY_REQ_EXT_DATA)));
        r2.setReadyState(r10.getInt(r10.getColumnIndex("readyState")));
        r2.setLoadTimeoutState(r10.getInt(r10.getColumnIndex("load_timeout")));
        r2.setPlacementId(r10.getString(r10.getColumnIndex("placement_id")));
        r2.setMaitve(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_MAITVE)));
        r2.setMaitve_src(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_MAITVESRC)));
        r2.setFlb(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_FLB)));
        r2.setFlbSkipTime(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
        r2.setCbd(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
        r2.setVst(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
        r2.setAdSpaceT(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
        r2.setVcn(r10.getInt(r10.getColumnIndex("vcn")));
        r2.setTokenRule(r10.getInt(r10.getColumnIndex("token_r")));
        r2.setEncryptPrice(r10.getString(r10.getColumnIndex("encrypt_p")));
        r2.setVideoCheckType(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
        r2.setVideoCtnType(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
        r2.setRsIgnoreCheckRuleByString(r10.getString(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
        r2.setVideoCompleteTime(r10.getInt(r10.getColumnIndex(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
        r1.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x05af, code lost:
        if (r10 == null) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x05b5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x05b6, code lost:
        if (r10 == null) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x05c0, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x05d4, code lost:
        if (r10 == null) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x05d8, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        if (r10 == null) goto L_0x05b6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x05dc A[SYNTHETIC, Splitter:B:63:0x05dc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> f(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            java.lang.Object r1 = new java.lang.Object     // Catch:{ Exception -> 0x05c9, all -> 0x05c4 }
            r1.<init>()     // Catch:{ Exception -> 0x05c9, all -> 0x05c4 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x05c9, all -> 0x05c4 }
            android.database.sqlite.SQLiteDatabase r2 = r9.getReadableDatabase()     // Catch:{ all -> 0x05bc }
            android.database.Cursor r10 = r2.rawQuery(r10, r0)     // Catch:{ all -> 0x05bc }
            monitor-exit(r1)     // Catch:{ all -> 0x05c2 }
            if (r10 == 0) goto L_0x05b6
            int r1 = r10.getCount()     // Catch:{ Exception -> 0x05c0 }
            if (r1 <= 0) goto L_0x05b6
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x05c0 }
            r1.<init>()     // Catch:{ Exception -> 0x05c0 }
        L_0x001e:
            boolean r2 = r10.moveToNext()     // Catch:{ Exception -> 0x05c0 }
            if (r2 == 0) goto L_0x05af
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = new com.mbridge.msdk.foundation.entity.CampaignEx     // Catch:{ Exception -> 0x05c0 }
            r2.<init>()     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "pv_urls"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x05c0 }
            r5 = 0
            if (r4 != 0) goto L_0x0058
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x05c0 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x05c0 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x05c0 }
            r3.<init>()     // Catch:{ Exception -> 0x05c0 }
            r6 = r5
        L_0x0045:
            int r7 = r4.length()     // Catch:{ Exception -> 0x05c0 }
            if (r6 >= r7) goto L_0x0055
            java.lang.String r7 = r4.getString(r6)     // Catch:{ Exception -> 0x05c0 }
            r3.add(r7)     // Catch:{ Exception -> 0x05c0 }
            int r6 = r6 + 1
            goto L_0x0045
        L_0x0055:
            r2.setPv_urls(r3)     // Catch:{ Exception -> 0x05c0 }
        L_0x0058:
            java.lang.String r3 = "id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setId(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "tab"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setTab(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "package_name"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setPackageName(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "app_name"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAppName(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "app_desc"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAppDesc(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "app_size"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setSize(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "image_size"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setImageSize(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "icon_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setIconUrl(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "image_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setImageUrl(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "impression_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setImpressionURL(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "notice_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setNoticeUrl(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "download_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setClickURL(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "wtick"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setWtick(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "deeplink_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setDeepLinkUrl(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "user_activation"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setUserActivation(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "only_impression"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setOnlyImpressionURL(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "template"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setTemplate(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "landing_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setLandingType(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "link_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setLinkType(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "click_mode"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setClick_mode(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "star"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            double r3 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setRating(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "number_rating"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setNumberRating(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "cti"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setClickInterval(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "ts"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setTimestamp(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "level"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setCacheLevel(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "adSource"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setType(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "ad_call"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdCall(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "fc_a"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setFca(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "fc_b"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setFcb(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "ad_url_list"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAd_url_list(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "video_length"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideoLength(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "video_size"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideoSize(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "video_resolution"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideoResolution(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "endcard_click_result"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setEndcard_click_result(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "video_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideoUrlEncode(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "watch_mile"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setWatchMile(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "t_imp"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setTImp(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "bty"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setBty(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "advImp"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdvImp(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "offer_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setOfferType(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "guidelines"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setGuidelines(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "html_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setHtmlUrl(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "end_screen_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setEndScreenUrl(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "reward_name"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setRewardName(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "reward_amount"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setRewardAmount(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "reward_play_status"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setRewardPlayStatus(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "retarget"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setRetarget_offer(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "unitid"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setCampaignUnitId(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "native_ad_tracking"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            com.mbridge.msdk.foundation.entity.i r3 = com.mbridge.msdk.foundation.entity.CampaignEx.TrackingStr2Object(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setNativeVideoTracking(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "native_ad_tracking"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setNativeVideoTrackingString(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "video_end_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideo_end_type(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "endcard_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setendcard_url(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "playable_ads_without_video"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setPlayable_ads_without_video(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "reward_teamplate"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r3 = com.mbridge.msdk.foundation.entity.CampaignEx.c.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setRewardTemplateMode(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "md5_file"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideoMD5Value(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "gif_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setGifUrl(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "nv_t2"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setNvT2(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "c_coi"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setClickTimeOutInterval(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "c_ua"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setcUA(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "imp_ua"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setImpUA(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "oc_time"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setOc_time(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "oc_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setOc_type(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "t_list"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setT_list(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "adchoice"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x05c0 }
            if (r4 != 0) goto L_0x03b2
            com.mbridge.msdk.foundation.entity.CampaignEx$a r3 = com.mbridge.msdk.foundation.entity.CampaignEx.a.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdchoice(r3)     // Catch:{ Exception -> 0x05c0 }
        L_0x03b2:
            java.lang.String r3 = "adchoice_size_height"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdchoiceSizeHeight(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "adchoice_size_width"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdchoiceSizeWidth(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "plct"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setPlct(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "plctb"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setPlctb(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "ad_zip"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdZip(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "ad_html"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdHtml(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "banner_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setBannerUrl(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "banner_html"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setBannerHtml(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "creative_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setCreativeId(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "is_bid_campaign"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r4 = 1
            if (r3 != r4) goto L_0x0436
            r3 = r4
            goto L_0x0437
        L_0x0436:
            r3 = r5
        L_0x0437:
            r2.setIsBidCampaign(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "bid_token"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setBidToken(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "ad_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdType(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "mraid"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setMraid(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "is_mraid_campaign"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            if (r3 != r4) goto L_0x046e
            goto L_0x046f
        L_0x046e:
            r4 = r5
        L_0x046f:
            r2.setIsMraid(r4)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "omid"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setOmid(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "ready_rate"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setReady_rate(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "ext_data"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setExt_data(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "nscpt"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setNscpt(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "mof_template_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setMof_template_url(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "mof_tplid"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setMof_tplid(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "req_ext_data"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setReq_ext_data(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "readyState"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setReadyState(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "load_timeout"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setLoadTimeoutState(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "placement_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setPlacementId(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "maitve"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setMaitve(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "maitve_src"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setMaitve_src(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "flb"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setFlb(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "flb_skiptime"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setFlbSkipTime(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "cbd"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setCbd(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "vst"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVst(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "adspace_t"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setAdSpaceT(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "vcn"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVcn(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "token_r"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setTokenRule(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "encrypt_p"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setEncryptPrice(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "vck_t"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideoCheckType(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "vctn_t"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideoCtnType(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "rs_ignc_r"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setRsIgnoreCheckRuleByString(r3)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r3 = "view_com_time"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x05c0 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x05c0 }
            r2.setVideoCompleteTime(r3)     // Catch:{ Exception -> 0x05c0 }
            r1.add(r2)     // Catch:{ Exception -> 0x05c0 }
            goto L_0x001e
        L_0x05af:
            if (r10 == 0) goto L_0x05b4
            r10.close()     // Catch:{ all -> 0x05e0 }
        L_0x05b4:
            monitor-exit(r9)
            return r1
        L_0x05b6:
            if (r10 == 0) goto L_0x05d7
        L_0x05b8:
            r10.close()     // Catch:{ all -> 0x05e0 }
            goto L_0x05d7
        L_0x05bc:
            r2 = move-exception
            r10 = r0
        L_0x05be:
            monitor-exit(r1)     // Catch:{ all -> 0x05c2 }
            throw r2     // Catch:{ Exception -> 0x05c0 }
        L_0x05c0:
            r1 = move-exception
            goto L_0x05cb
        L_0x05c2:
            r2 = move-exception
            goto L_0x05be
        L_0x05c4:
            r10 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x05da
        L_0x05c9:
            r1 = move-exception
            r10 = r0
        L_0x05cb:
            java.lang.String r2 = "CampaignDao"
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch:{ all -> 0x05d9 }
            com.mbridge.msdk.foundation.tools.q.d(r2, r1)     // Catch:{ all -> 0x05d9 }
            if (r10 == 0) goto L_0x05d7
            goto L_0x05b8
        L_0x05d7:
            monitor-exit(r9)
            return r0
        L_0x05d9:
            r0 = move-exception
        L_0x05da:
            if (r10 == 0) goto L_0x05df
            r10.close()     // Catch:{ all -> 0x05e0 }
        L_0x05df:
            throw r0     // Catch:{ all -> 0x05e0 }
        L_0x05e0:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.f(java.lang.String):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r1v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v9, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v10, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x011f, code lost:
        if (r1 != 0) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0136, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.foundation.entity.b> d(java.lang.String r10) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " WHERE unitid = '"
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = "'"
            r1.append(r10)
            java.lang.String r10 = " AND "
            r1.append(r10)
            java.lang.String r10 = "level"
            r1.append(r10)
            java.lang.String r10 = " = "
            r1.append(r10)
            r10 = 0
            r1.append(r10)
            java.lang.String r10 = " AND "
            r1.append(r10)
            java.lang.String r10 = "adSource"
            r1.append(r10)
            java.lang.String r10 = " = "
            r1.append(r10)
            r10 = 1
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r10 = " AND is_bid_campaign = 1"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r10 = " AND readyState = '0'"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r10 = " group by request_id"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r10 = " order by ts ASC"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT request_id as rid ,count(*) as ridCount ,vcn,token_r,bid_token,ts as timestamp FROM campaign"
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r1 = 0
            java.lang.Object r2 = new java.lang.Object     // Catch:{ Exception -> 0x0127 }
            r2.<init>()     // Catch:{ Exception -> 0x0127 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x0127 }
            android.database.sqlite.SQLiteDatabase r3 = r9.getReadableDatabase()     // Catch:{ all -> 0x0122 }
            android.database.Cursor r1 = r3.rawQuery(r10, r1)     // Catch:{ all -> 0x0122 }
            monitor-exit(r2)     // Catch:{ all -> 0x0122 }
            if (r1 == 0) goto L_0x011f
            int r10 = r1.getCount()     // Catch:{ Exception -> 0x0127 }
            if (r10 <= 0) goto L_0x011f
        L_0x00b5:
            boolean r10 = r1.moveToNext()     // Catch:{ Exception -> 0x0127 }
            if (r10 == 0) goto L_0x011f
            com.mbridge.msdk.foundation.entity.b r10 = new com.mbridge.msdk.foundation.entity.b     // Catch:{ Exception -> 0x0127 }
            r10.<init>()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r2 = "rid"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0127 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0127 }
            if (r3 == 0) goto L_0x00d1
            goto L_0x00b5
        L_0x00d1:
            java.lang.String r3 = "bid_token"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r4 = "ridCount"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x0127 }
            int r4 = r1.getInt(r4)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = "token_r"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x0127 }
            int r5 = r1.getInt(r5)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r6 = "timestamp"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0127 }
            long r6 = r1.getLong(r6)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r8 = "vcn"
            int r8 = r1.getColumnIndex(r8)     // Catch:{ Exception -> 0x0127 }
            int r8 = r1.getInt(r8)     // Catch:{ Exception -> 0x0127 }
            r10.b((java.lang.String) r2)     // Catch:{ Exception -> 0x0127 }
            r10.c((int) r4)     // Catch:{ Exception -> 0x0127 }
            r10.c((long) r6)     // Catch:{ Exception -> 0x0127 }
            r10.a((int) r5)     // Catch:{ Exception -> 0x0127 }
            r10.b((int) r8)     // Catch:{ Exception -> 0x0127 }
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0127 }
            if (r2 != 0) goto L_0x011b
            r10.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0127 }
        L_0x011b:
            r0.add(r10)     // Catch:{ Exception -> 0x0127 }
            goto L_0x00b5
        L_0x011f:
            if (r1 == 0) goto L_0x0136
            goto L_0x0133
        L_0x0122:
            r10 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0122 }
            throw r10     // Catch:{ Exception -> 0x0127 }
        L_0x0125:
            r10 = move-exception
            goto L_0x0137
        L_0x0127:
            r10 = move-exception
            java.lang.String r2 = "CampaignDao"
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch:{ all -> 0x0125 }
            com.mbridge.msdk.foundation.tools.q.d(r2, r10)     // Catch:{ all -> 0x0125 }
            if (r1 == 0) goto L_0x0136
        L_0x0133:
            r1.close()
        L_0x0136:
            return r0
        L_0x0137:
            if (r1 == 0) goto L_0x013c
            r1.close()
        L_0x013c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.d(java.lang.String):java.util.List");
    }

    public final int c(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "unitid = '" + str2 + "'" + " AND " + "request_id" + " = '" + str + "'" + " AND is_bid_campaign = 1";
        } else {
            str3 = "unitid = '" + str2 + "'" + " AND is_bid_campaign = 1";
        }
        String str4 = str3 + " AND readyState = '0'";
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", 2);
            return getWritableDatabase().update("campaign", contentValues, str4, (String[]) null);
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
            return 0;
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x010c, code lost:
        if (r1 != 0) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0123, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.entity.b> e(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " WHERE unitid = '"
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = "'"
            r0.append(r11)
            java.lang.String r11 = " AND "
            r0.append(r11)
            java.lang.String r11 = "level"
            r0.append(r11)
            java.lang.String r11 = " = "
            r0.append(r11)
            r11 = 0
            r0.append(r11)
            java.lang.String r11 = " AND "
            r0.append(r11)
            java.lang.String r11 = "adSource"
            r0.append(r11)
            java.lang.String r11 = " = "
            r0.append(r11)
            r11 = 1
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = " AND is_bid_campaign = 1"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = " AND readyState = '0'"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "SELECT request_id as rid, id as cid, plct as plct, plctb as plctb, ts as timestamp FROM campaign"
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1 = 0
            java.lang.Object r2 = new java.lang.Object     // Catch:{ Exception -> 0x0114 }
            r2.<init>()     // Catch:{ Exception -> 0x0114 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x0114 }
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch:{ all -> 0x010f }
            android.database.Cursor r1 = r3.rawQuery(r11, r1)     // Catch:{ all -> 0x010f }
            monitor-exit(r2)     // Catch:{ all -> 0x010f }
            if (r1 == 0) goto L_0x010c
            int r11 = r1.getCount()     // Catch:{ Exception -> 0x0114 }
            if (r11 <= 0) goto L_0x010c
        L_0x008c:
            boolean r11 = r1.moveToNext()     // Catch:{ Exception -> 0x0114 }
            if (r11 == 0) goto L_0x010c
            java.lang.String r11 = "rid"
            int r11 = r1.getColumnIndex(r11)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r11 = r1.getString(r11)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r2 = "cid"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r3 = "plct"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x0114 }
            long r3 = r1.getLong(r3)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r5 = "plctb"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x0114 }
            long r5 = r1.getLong(r5)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r7 = "timestamp"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0114 }
            long r7 = r1.getLong(r7)     // Catch:{ Exception -> 0x0114 }
            boolean r9 = r0.containsKey(r11)     // Catch:{ Exception -> 0x0114 }
            if (r9 == 0) goto L_0x00ec
            java.lang.Object r9 = r0.get(r11)     // Catch:{ Exception -> 0x0114 }
            com.mbridge.msdk.foundation.entity.b r9 = (com.mbridge.msdk.foundation.entity.b) r9     // Catch:{ Exception -> 0x0114 }
            if (r9 == 0) goto L_0x008c
            r9.b((java.lang.String) r11)     // Catch:{ Exception -> 0x0114 }
            r9.a((long) r3)     // Catch:{ Exception -> 0x0114 }
            r9.b((long) r5)     // Catch:{ Exception -> 0x0114 }
            r9.c((long) r7)     // Catch:{ Exception -> 0x0114 }
            java.util.List r11 = r9.c()     // Catch:{ Exception -> 0x0114 }
            if (r11 == 0) goto L_0x008c
            java.util.List r11 = r9.c()     // Catch:{ Exception -> 0x0114 }
            r11.add(r2)     // Catch:{ Exception -> 0x0114 }
            goto L_0x008c
        L_0x00ec:
            com.mbridge.msdk.foundation.entity.b r9 = new com.mbridge.msdk.foundation.entity.b     // Catch:{ Exception -> 0x0114 }
            r9.<init>()     // Catch:{ Exception -> 0x0114 }
            r9.b((java.lang.String) r11)     // Catch:{ Exception -> 0x0114 }
            r9.a((long) r3)     // Catch:{ Exception -> 0x0114 }
            r9.b((long) r5)     // Catch:{ Exception -> 0x0114 }
            r9.c((long) r7)     // Catch:{ Exception -> 0x0114 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0114 }
            r3.<init>()     // Catch:{ Exception -> 0x0114 }
            r3.add(r2)     // Catch:{ Exception -> 0x0114 }
            r9.a((java.util.List<java.lang.String>) r3)     // Catch:{ Exception -> 0x0114 }
            r0.put(r11, r9)     // Catch:{ Exception -> 0x0114 }
            goto L_0x008c
        L_0x010c:
            if (r1 == 0) goto L_0x0123
            goto L_0x0120
        L_0x010f:
            r11 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x010f }
            throw r11     // Catch:{ Exception -> 0x0114 }
        L_0x0112:
            r11 = move-exception
            goto L_0x0124
        L_0x0114:
            r11 = move-exception
            java.lang.String r2 = "CampaignDao"
            java.lang.String r11 = r11.getLocalizedMessage()     // Catch:{ all -> 0x0112 }
            com.mbridge.msdk.foundation.tools.q.d(r2, r11)     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x0123
        L_0x0120:
            r1.close()
        L_0x0123:
            return r0
        L_0x0124:
            if (r1 == 0) goto L_0x0129
            r1.close()
        L_0x0129:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.e(java.lang.String):java.util.concurrent.ConcurrentHashMap");
    }

    private CampaignEx a(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        boolean z = false;
        try {
            String string = cursor.getString(cursor.getColumnIndex("pv_urls"));
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getString(i2));
                }
                campaignEx.setPv_urls(arrayList);
            }
        } catch (JSONException unused) {
        }
        campaignEx.setId(cursor.getString(cursor.getColumnIndex("id")));
        campaignEx.setTab(cursor.getInt(cursor.getColumnIndex("tab")));
        campaignEx.setPackageName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PACKAGE_NAME)));
        campaignEx.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
        campaignEx.setAppDesc(cursor.getString(cursor.getColumnIndex("app_desc")));
        campaignEx.setSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
        campaignEx.setImageSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
        campaignEx.setIconUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
        campaignEx.setImageUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
        campaignEx.setImpressionURL(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
        campaignEx.setNoticeUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
        campaignEx.setClickURL(cursor.getString(cursor.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
        campaignEx.setWtick(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
        campaignEx.setDeepLinkUrl(cursor.getString(cursor.getColumnIndex("deeplink_url")));
        campaignEx.setUserActivation(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
        campaignEx.setOnlyImpressionURL(cursor.getString(cursor.getColumnIndex("only_impression")));
        campaignEx.setTemplate(cursor.getInt(cursor.getColumnIndex("template")));
        campaignEx.setLandingType(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
        campaignEx.setLinkType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
        campaignEx.setClick_mode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
        campaignEx.setRating(Double.parseDouble(cursor.getString(cursor.getColumnIndex("star"))));
        campaignEx.setNumberRating(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
        campaignEx.setClickInterval(cursor.getInt(cursor.getColumnIndex("cti")));
        campaignEx.setTimestamp(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_ST_TS)));
        campaignEx.setCacheLevel(cursor.getInt(cursor.getColumnIndex("level")));
        campaignEx.setAdCall(cursor.getString(cursor.getColumnIndex("ad_call")));
        campaignEx.setFcb(cursor.getInt(cursor.getColumnIndex("fc_b")));
        campaignEx.setAd_url_list(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
        campaignEx.setVideoLength(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
        campaignEx.setVideoSize(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
        campaignEx.setVideoResolution(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
        campaignEx.setEndcard_click_result(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
        campaignEx.setVideoUrlEncode(cursor.getString(cursor.getColumnIndex("video_url")));
        campaignEx.setWatchMile(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
        campaignEx.setTImp(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
        campaignEx.setBty(cursor.getInt(cursor.getColumnIndex("bty")));
        campaignEx.setAdvImp(cursor.getString(cursor.getColumnIndex("advImp")));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setOfferType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_HTML_URL)));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_HTML_URL)));
        campaignEx.setEndScreenUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_END_SCREEN_URL)));
        campaignEx.setRewardName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_NAME)));
        campaignEx.setRewardAmount(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_AMOUNT)));
        campaignEx.setRewardPlayStatus(cursor.getInt(cursor.getColumnIndex("reward_play_status")));
        campaignEx.setRetarget_offer(cursor.getInt(cursor.getColumnIndex("retarget")));
        campaignEx.setCampaignUnitId(cursor.getString(cursor.getColumnIndex("unitid")));
        campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursor.getString(cursor.getColumnIndex("native_ad_tracking"))));
        campaignEx.setNativeVideoTrackingString(cursor.getString(cursor.getColumnIndex("native_ad_tracking")));
        campaignEx.setVideo_end_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
        campaignEx.setendcard_url(cursor.getString(cursor.getColumnIndex(CampaignEx.ENDCARD_URL)));
        campaignEx.setPlayable_ads_without_video(cursor.getInt(cursor.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
        campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursor.getString(cursor.getColumnIndex("reward_teamplate"))));
        campaignEx.setVideoMD5Value(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
        campaignEx.setGifUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
        campaignEx.setNvT2(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
        campaignEx.setClickTimeOutInterval(cursor.getInt(cursor.getColumnIndex("c_coi")));
        campaignEx.setcUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
        campaignEx.setImpUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
        campaignEx.setJmPd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_JM_PD)));
        campaignEx.setIsDeleted(cursor.getInt(cursor.getColumnIndex("is_deleted")));
        campaignEx.setIsClick(cursor.getInt(cursor.getColumnIndex("is_click")));
        campaignEx.setIsAddSuccesful(cursor.getInt(cursor.getColumnIndex("is_add_sucesful")));
        campaignEx.setIsDownLoadZip(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_IS_DOWNLOAD)));
        campaignEx.setInteractiveCache(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_CACHE)));
        campaignEx.setKeyIaOri(cursor.getInt(cursor.getColumnIndex("ia_ori")));
        campaignEx.setAdType(cursor.getInt(cursor.getColumnIndex("ad_type")));
        campaignEx.setIa_ext1(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT1)));
        campaignEx.setIa_ext2(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT2)));
        campaignEx.setKeyIaRst(cursor.getInt(cursor.getColumnIndex("ia_rst")));
        campaignEx.setKeyIaUrl(cursor.getString(cursor.getColumnIndex("ia_url")));
        campaignEx.setKeyIaIcon(cursor.getString(cursor.getColumnIndex("ia_icon")));
        campaignEx.setOc_time(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TIME)));
        campaignEx.setOc_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
        campaignEx.setT_list(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_T_LIST)));
        String string2 = cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ADCHOICE));
        if (!TextUtils.isEmpty(string2)) {
            campaignEx.setAdchoice(CampaignEx.a.a(string2));
        }
        campaignEx.setAdchoiceSizeHeight(cursor.getInt(cursor.getColumnIndex("adchoice_size_height")));
        campaignEx.setAdchoiceSizeWidth(cursor.getInt(cursor.getColumnIndex("adchoice_size_width")));
        campaignEx.setPlct(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
        campaignEx.setPlctb(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
        campaignEx.setAdZip(cursor.getString(cursor.getColumnIndex("ad_zip")));
        campaignEx.setAdHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
        campaignEx.setBannerUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
        campaignEx.setBannerHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
        campaignEx.setCreativeId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
        campaignEx.setIsBidCampaign(cursor.getInt(cursor.getColumnIndex("is_bid_campaign")) == 1);
        campaignEx.setBidToken(cursor.getString(cursor.getColumnIndex(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN)));
        campaignEx.setMraid(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MRAID)));
        if (cursor.getInt(cursor.getColumnIndex("is_mraid_campaign")) == 1) {
            z = true;
        }
        campaignEx.setIsMraid(z);
        campaignEx.setOmid(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_OMID)));
        campaignEx.setReady_rate(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
        campaignEx.setExt_data(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_EXT_DATA)));
        campaignEx.setNscpt(cursor.getInt(cursor.getColumnIndex(CampaignUnit.JSON_KEY_NSCPT)));
        campaignEx.setMof_template_url(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL)));
        campaignEx.setMof_tplid(cursor.getInt(cursor.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TPLID)));
        campaignEx.setReq_ext_data(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_REQ_EXT_DATA)));
        campaignEx.setReadyState(cursor.getInt(cursor.getColumnIndex("readyState")));
        campaignEx.setLoadTimeoutState(cursor.getInt(cursor.getColumnIndex("load_timeout")));
        campaignEx.setPlacementId(cursor.getString(cursor.getColumnIndex("placement_id")));
        campaignEx.setMaitve(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVE)));
        campaignEx.setMaitve_src(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVESRC)));
        campaignEx.setFlb(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
        campaignEx.setFlbSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
        campaignEx.setCbd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
        campaignEx.setVst(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
        campaignEx.setAdSpaceT(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
        campaignEx.setVcn(cursor.getInt(cursor.getColumnIndex("vcn")));
        campaignEx.setTokenRule(cursor.getInt(cursor.getColumnIndex("token_r")));
        campaignEx.setEncryptPrice(cursor.getString(cursor.getColumnIndex("encrypt_p")));
        campaignEx.setVideoCheckType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
        campaignEx.setVideoCtnType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
        campaignEx.setRsIgnoreCheckRuleByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
        campaignEx.setVideoCompleteTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
        return campaignEx;
    }

    public final synchronized void d(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str3 = "unitid = '" + str + "'";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + " AND bid_token != '" + str2 + "'";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                getWritableDatabase().update("campaign", contentValues, (str3 + " AND is_bid_campaign = 1") + " AND bid_token IS NOT NULL", (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            q.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void e(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x005e }
            if (r0 != 0) goto L_0x005a
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x005e }
            if (r0 == 0) goto L_0x000e
            goto L_0x005a
        L_0x000e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005e }
            r0.<init>()     // Catch:{ Exception -> 0x005e }
            java.lang.String r1 = "unitid = '"
            r0.append(r1)     // Catch:{ Exception -> 0x005e }
            r0.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = "' AND "
            r0.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = "bid_token"
            r0.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = " = '"
            r0.append(r4)     // Catch:{ Exception -> 0x005e }
            r0.append(r5)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = "' AND "
            r0.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = "bid_token"
            r0.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = " IS NOT NULL"
            r0.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x005e }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x005e }
            r5.<init>()     // Catch:{ Exception -> 0x005e }
            java.lang.String r0 = "readyState"
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x005e }
            r5.put(r0, r1)     // Catch:{ Exception -> 0x005e }
            android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x005e }
            java.lang.String r1 = "campaign"
            r2 = 0
            r0.update(r1, r5, r4, r2)     // Catch:{ Exception -> 0x005e }
            goto L_0x0068
        L_0x005a:
            monitor-exit(r3)
            return
        L_0x005c:
            r4 = move-exception
            goto L_0x006a
        L_0x005e:
            r4 = move-exception
            java.lang.String r5 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x005c }
            com.mbridge.msdk.foundation.tools.q.d(r5, r4)     // Catch:{ all -> 0x005c }
        L_0x0068:
            monitor-exit(r3)
            return
        L_0x006a:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.e(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006d, code lost:
        r0 = r4;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        r0 = r4;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070 A[ExcHandler: all (r5v9 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:7:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> b(java.lang.String r4, int r5, boolean r6) {
        /*
            r3 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0027
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0081 }
            r6.<init>()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r1 = "placement_id = "
            r6.append(r1)     // Catch:{ Exception -> 0x0081 }
            r6.append(r4)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r4 = " AND "
            r6.append(r4)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r4 = "ad_type"
            r6.append(r4)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r4 = " = "
            r6.append(r4)     // Catch:{ Exception -> 0x0081 }
            r6.append(r5)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0038
        L_0x0027:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0081 }
            r4.<init>()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r6 = "ad_type = "
            r4.append(r6)     // Catch:{ Exception -> 0x0081 }
            r4.append(r5)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0081 }
        L_0x0038:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0081 }
            r5.<init>()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r6 = "SELECT * FROM campaign WHERE "
            r5.append(r6)     // Catch:{ Exception -> 0x0081 }
            r5.append(r4)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0081 }
            android.database.sqlite.SQLiteDatabase r5 = r3.getReadableDatabase()     // Catch:{ Exception -> 0x0081 }
            android.database.Cursor r4 = r5.rawQuery(r4, r0)     // Catch:{ Exception -> 0x0081 }
            if (r4 == 0) goto L_0x007a
            int r5 = r4.getCount()     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            if (r5 <= 0) goto L_0x007a
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            r5.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
        L_0x005e:
            boolean r6 = r4.moveToNext()     // Catch:{ Exception -> 0x006c, all -> 0x0070 }
            if (r6 == 0) goto L_0x007b
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r3.a((android.database.Cursor) r4)     // Catch:{ Exception -> 0x006c, all -> 0x0070 }
            r5.add(r6)     // Catch:{ Exception -> 0x006c, all -> 0x0070 }
            goto L_0x005e
        L_0x006c:
            r6 = move-exception
            r0 = r4
            r4 = r6
            goto L_0x0083
        L_0x0070:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x0093
        L_0x0074:
            r5 = move-exception
            r2 = r0
            r0 = r4
            r4 = r5
            r5 = r2
            goto L_0x0083
        L_0x007a:
            r5 = r0
        L_0x007b:
            if (r4 == 0) goto L_0x0091
            r4.close()
            goto L_0x0091
        L_0x0081:
            r4 = move-exception
            r5 = r0
        L_0x0083:
            java.lang.String r6 = "CampaignDao"
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch:{ all -> 0x0092 }
            com.mbridge.msdk.foundation.tools.q.d(r6, r4)     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x0091
            r0.close()
        L_0x0091:
            return r5
        L_0x0092:
            r4 = move-exception
        L_0x0093:
            if (r0 == 0) goto L_0x0098
            r0.close()
        L_0x0098:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.e.b(java.lang.String, int, boolean):java.util.List");
    }
}
