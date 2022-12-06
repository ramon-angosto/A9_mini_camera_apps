package com.huawei.android.pushagent.c.c;

public class e {
    private static boolean a = false;
    private static boolean b = false;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0066=Splitter:B:23:0x0066, B:31:0x0076=Splitter:B:31:0x0076} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r6, int r7) {
        /*
            java.lang.String r0 = "ctrlSocket error:"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ctrlSocket cmd is "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = ", param is "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PushLogAC2705"
            com.huawei.android.pushagent.c.a.e.a(r2, r1)
            r1 = 0
            java.lang.String r3 = "connectivity"
            android.os.IBinder r3 = android.os.ServiceManager.getService(r3)     // Catch:{ RemoteException -> 0x0074, Exception -> 0x0064, all -> 0x0061 }
            if (r3 != 0) goto L_0x002f
            java.lang.String r6 = "get connectivity service failed "
            com.huawei.android.pushagent.c.a.e.c(r2, r6)     // Catch:{ RemoteException -> 0x0074, Exception -> 0x0064, all -> 0x0061 }
            return
        L_0x002f:
            android.os.Parcel r4 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0074, Exception -> 0x0064, all -> 0x0061 }
            int r5 = android.os.Process.myPid()     // Catch:{ RemoteException -> 0x005d, Exception -> 0x0059, all -> 0x0055 }
            r4.writeInt(r5)     // Catch:{ RemoteException -> 0x005d, Exception -> 0x0059, all -> 0x0055 }
            r4.writeInt(r6)     // Catch:{ RemoteException -> 0x005d, Exception -> 0x0059, all -> 0x0055 }
            r4.writeInt(r7)     // Catch:{ RemoteException -> 0x005d, Exception -> 0x0059, all -> 0x0055 }
            android.os.Parcel r1 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x005d, Exception -> 0x0059, all -> 0x0055 }
            r6 = 1003(0x3eb, float:1.406E-42)
            r7 = 0
            r3.transact(r6, r4, r1, r7)     // Catch:{ RemoteException -> 0x005d, Exception -> 0x0059, all -> 0x0055 }
            if (r4 == 0) goto L_0x004f
            r4.recycle()
        L_0x004f:
            if (r1 == 0) goto L_0x0094
            r1.recycle()
            goto L_0x0094
        L_0x0055:
            r6 = move-exception
            r7 = r1
            r1 = r4
            goto L_0x0096
        L_0x0059:
            r6 = move-exception
            r7 = r1
            r1 = r4
            goto L_0x0066
        L_0x005d:
            r6 = move-exception
            r7 = r1
            r1 = r4
            goto L_0x0076
        L_0x0061:
            r6 = move-exception
            r7 = r1
            goto L_0x0096
        L_0x0064:
            r6 = move-exception
            r7 = r1
        L_0x0066:
            com.huawei.android.pushagent.c.a.e.c(r2, r0, r6)     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x006e
            r1.recycle()
        L_0x006e:
            if (r7 == 0) goto L_0x0094
        L_0x0070:
            r7.recycle()
            goto L_0x0094
        L_0x0074:
            r6 = move-exception
            r7 = r1
        L_0x0076:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r3.<init>()     // Catch:{ all -> 0x0095 }
            r3.append(r0)     // Catch:{ all -> 0x0095 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0095 }
            r3.append(r6)     // Catch:{ all -> 0x0095 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0095 }
            com.huawei.android.pushagent.c.a.e.d(r2, r6)     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x0091
            r1.recycle()
        L_0x0091:
            if (r7 == 0) goto L_0x0094
            goto L_0x0070
        L_0x0094:
            return
        L_0x0095:
            r6 = move-exception
        L_0x0096:
            if (r1 == 0) goto L_0x009b
            r1.recycle()
        L_0x009b:
            if (r7 == 0) goto L_0x00a0
            r7.recycle()
        L_0x00a0:
            goto L_0x00a2
        L_0x00a1:
            throw r6
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.e.a(int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x005b=Splitter:B:26:0x005b, B:34:0x006b=Splitter:B:34:0x006b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r6) {
        /*
            java.lang.String r0 = "registerPackage error:"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ctrlScoket registerPackage "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PushLogAC2705"
            com.huawei.android.pushagent.c.a.e.a(r2, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x001f
            return
        L_0x001f:
            r1 = 0
            java.lang.String r3 = "connectivity"
            android.os.IBinder r3 = android.os.ServiceManager.getService(r3)     // Catch:{ RemoteException -> 0x0069, Exception -> 0x0059, all -> 0x0056 }
            if (r3 != 0) goto L_0x002e
            java.lang.String r6 = "get connectivity service failed "
            com.huawei.android.pushagent.c.a.e.c(r2, r6)     // Catch:{ RemoteException -> 0x0069, Exception -> 0x0059, all -> 0x0056 }
            return
        L_0x002e:
            android.os.Parcel r4 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0069, Exception -> 0x0059, all -> 0x0056 }
            r4.writeString(r6)     // Catch:{ RemoteException -> 0x0052, Exception -> 0x004e, all -> 0x004a }
            android.os.Parcel r1 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0052, Exception -> 0x004e, all -> 0x004a }
            r6 = 1001(0x3e9, float:1.403E-42)
            r5 = 0
            r3.transact(r6, r4, r1, r5)     // Catch:{ RemoteException -> 0x0052, Exception -> 0x004e, all -> 0x004a }
            if (r4 == 0) goto L_0x0044
            r4.recycle()
        L_0x0044:
            if (r1 == 0) goto L_0x0089
            r1.recycle()
            goto L_0x0089
        L_0x004a:
            r6 = move-exception
            r3 = r1
            r1 = r4
            goto L_0x008b
        L_0x004e:
            r6 = move-exception
            r3 = r1
            r1 = r4
            goto L_0x005b
        L_0x0052:
            r6 = move-exception
            r3 = r1
            r1 = r4
            goto L_0x006b
        L_0x0056:
            r6 = move-exception
            r3 = r1
            goto L_0x008b
        L_0x0059:
            r6 = move-exception
            r3 = r1
        L_0x005b:
            com.huawei.android.pushagent.c.a.e.c(r2, r0, r6)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0063
            r1.recycle()
        L_0x0063:
            if (r3 == 0) goto L_0x0089
        L_0x0065:
            r3.recycle()
            goto L_0x0089
        L_0x0069:
            r6 = move-exception
            r3 = r1
        L_0x006b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r4.<init>()     // Catch:{ all -> 0x008a }
            r4.append(r0)     // Catch:{ all -> 0x008a }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x008a }
            r4.append(r6)     // Catch:{ all -> 0x008a }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x008a }
            com.huawei.android.pushagent.c.a.e.d(r2, r6)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0086
            r1.recycle()
        L_0x0086:
            if (r3 == 0) goto L_0x0089
            goto L_0x0065
        L_0x0089:
            return
        L_0x008a:
            r6 = move-exception
        L_0x008b:
            if (r1 == 0) goto L_0x0090
            r1.recycle()
        L_0x0090:
            if (r3 == 0) goto L_0x0095
            r3.recycle()
        L_0x0095:
            goto L_0x0097
        L_0x0096:
            throw r6
        L_0x0097:
            goto L_0x0096
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.e.a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006c, code lost:
        if (r5 == null) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006e, code lost:
        r5.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008f, code lost:
        if (r5 == null) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009b  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x0064=Splitter:B:26:0x0064, B:34:0x0074=Splitter:B:34:0x0074} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] a() {
        /*
            java.lang.String r0 = "ctrlSocket error:"
            java.lang.String r1 = "PushLogAC2705"
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]
            r4 = 0
            java.lang.String r5 = "connectivity"
            android.os.IBinder r5 = android.os.ServiceManager.getService(r5)     // Catch:{ RemoteException -> 0x0072, Exception -> 0x0062, all -> 0x005f }
            if (r5 != 0) goto L_0x0016
            java.lang.String r2 = "get connectivity service failed "
            com.huawei.android.pushagent.c.a.e.c(r1, r2)     // Catch:{ RemoteException -> 0x0072, Exception -> 0x0062, all -> 0x005f }
            return r3
        L_0x0016:
            android.os.Parcel r6 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0072, Exception -> 0x0062, all -> 0x005f }
            android.os.Parcel r4 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            r7 = 1004(0x3ec, float:1.407E-42)
            r5.transact(r7, r6, r4, r2)     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            java.lang.String r2 = r4.readString()     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            r5.<init>()     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            java.lang.String r7 = "ctrlSocket whitepackages is:"
            r5.append(r7)     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            r5.append(r2)     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            java.lang.String r5 = r5.toString()     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            com.huawei.android.pushagent.c.a.e.a(r1, r5)     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            if (r5 != 0) goto L_0x0048
            java.lang.String r5 = "\t"
            java.lang.String[] r0 = r2.split(r5)     // Catch:{ RemoteException -> 0x005b, Exception -> 0x0057, all -> 0x0053 }
            r3 = r0
        L_0x0048:
            if (r6 == 0) goto L_0x004d
            r6.recycle()
        L_0x004d:
            if (r4 == 0) goto L_0x0092
            r4.recycle()
            goto L_0x0092
        L_0x0053:
            r0 = move-exception
            r5 = r4
            r4 = r6
            goto L_0x0094
        L_0x0057:
            r2 = move-exception
            r5 = r4
            r4 = r6
            goto L_0x0064
        L_0x005b:
            r2 = move-exception
            r5 = r4
            r4 = r6
            goto L_0x0074
        L_0x005f:
            r0 = move-exception
            r5 = r4
            goto L_0x0094
        L_0x0062:
            r2 = move-exception
            r5 = r4
        L_0x0064:
            com.huawei.android.pushagent.c.a.e.c(r1, r0, r2)     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x006c
            r4.recycle()
        L_0x006c:
            if (r5 == 0) goto L_0x0092
        L_0x006e:
            r5.recycle()
            goto L_0x0092
        L_0x0072:
            r2 = move-exception
            r5 = r4
        L_0x0074:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r6.<init>()     // Catch:{ all -> 0x0093 }
            r6.append(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r2.getMessage()     // Catch:{ all -> 0x0093 }
            r6.append(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0093 }
            com.huawei.android.pushagent.c.a.e.d(r1, r0)     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x008f
            r4.recycle()
        L_0x008f:
            if (r5 == 0) goto L_0x0092
            goto L_0x006e
        L_0x0092:
            return r3
        L_0x0093:
            r0 = move-exception
        L_0x0094:
            if (r4 == 0) goto L_0x0099
            r4.recycle()
        L_0x0099:
            if (r5 == 0) goto L_0x009e
            r5.recycle()
        L_0x009e:
            goto L_0x00a0
        L_0x009f:
            throw r0
        L_0x00a0:
            goto L_0x009f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.e.a():java.lang.String[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        if (r5 == null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        r5.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
        if (r5 == null) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0090  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0045=Splitter:B:23:0x0045, B:31:0x0055=Splitter:B:31:0x0055} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b() {
        /*
            java.lang.String r0 = "getCtrlSocketModel error:"
            java.lang.String r1 = "PushLogAC2705"
            r2 = 0
            r3 = -1
            java.lang.String r4 = "connectivity"
            android.os.IBinder r4 = android.os.ServiceManager.getService(r4)     // Catch:{ RemoteException -> 0x0053, Exception -> 0x0043, all -> 0x0040 }
            if (r4 != 0) goto L_0x0014
            java.lang.String r4 = "get connectivity service failed "
            com.huawei.android.pushagent.c.a.e.c(r1, r4)     // Catch:{ RemoteException -> 0x0053, Exception -> 0x0043, all -> 0x0040 }
            return r3
        L_0x0014:
            android.os.Parcel r5 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0053, Exception -> 0x0043, all -> 0x0040 }
            android.os.Parcel r2 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x003b, Exception -> 0x0036, all -> 0x0031 }
            r6 = 1005(0x3ed, float:1.408E-42)
            r7 = 0
            r4.transact(r6, r5, r2, r7)     // Catch:{ RemoteException -> 0x003b, Exception -> 0x0036, all -> 0x0031 }
            int r3 = r2.readInt()     // Catch:{ RemoteException -> 0x003b, Exception -> 0x0036, all -> 0x0031 }
            if (r5 == 0) goto L_0x002b
            r5.recycle()
        L_0x002b:
            if (r2 == 0) goto L_0x0073
            r2.recycle()
            goto L_0x0073
        L_0x0031:
            r0 = move-exception
            r8 = r5
            r5 = r2
            r2 = r8
            goto L_0x0089
        L_0x0036:
            r4 = move-exception
            r8 = r5
            r5 = r2
            r2 = r8
            goto L_0x0045
        L_0x003b:
            r4 = move-exception
            r8 = r5
            r5 = r2
            r2 = r8
            goto L_0x0055
        L_0x0040:
            r0 = move-exception
            r5 = r2
            goto L_0x0089
        L_0x0043:
            r4 = move-exception
            r5 = r2
        L_0x0045:
            com.huawei.android.pushagent.c.a.e.c(r1, r0, r4)     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x004d
            r2.recycle()
        L_0x004d:
            if (r5 == 0) goto L_0x0073
        L_0x004f:
            r5.recycle()
            goto L_0x0073
        L_0x0053:
            r4 = move-exception
            r5 = r2
        L_0x0055:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r6.<init>()     // Catch:{ all -> 0x0088 }
            r6.append(r0)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r4.getMessage()     // Catch:{ all -> 0x0088 }
            r6.append(r0)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0088 }
            com.huawei.android.pushagent.c.a.e.d(r1, r0)     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0070
            r2.recycle()
        L_0x0070:
            if (r5 == 0) goto L_0x0073
            goto L_0x004f
        L_0x0073:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "ctrlSocket level is:"
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.huawei.android.pushagent.c.a.e.a(r1, r0)
            return r3
        L_0x0088:
            r0 = move-exception
        L_0x0089:
            if (r2 == 0) goto L_0x008e
            r2.recycle()
        L_0x008e:
            if (r5 == 0) goto L_0x0093
            r5.recycle()
        L_0x0093:
            goto L_0x0095
        L_0x0094:
            throw r0
        L_0x0095:
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.e.b():int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0056=Splitter:B:25:0x0056, B:33:0x0066=Splitter:B:33:0x0066} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r6) {
        /*
            java.lang.String r0 = "deregisterPackage error:"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ctrlScoket deregisterPackage "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PushLogAC2705"
            com.huawei.android.pushagent.c.a.e.a(r2, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x001f
            return
        L_0x001f:
            r1 = 0
            java.lang.String r3 = "connectivity"
            android.os.IBinder r3 = android.os.ServiceManager.getService(r3)     // Catch:{ RemoteException -> 0x0064, Exception -> 0x0054, all -> 0x0051 }
            if (r3 != 0) goto L_0x0029
            return
        L_0x0029:
            android.os.Parcel r4 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0064, Exception -> 0x0054, all -> 0x0051 }
            r4.writeString(r6)     // Catch:{ RemoteException -> 0x004d, Exception -> 0x0049, all -> 0x0045 }
            android.os.Parcel r1 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x004d, Exception -> 0x0049, all -> 0x0045 }
            r6 = 1002(0x3ea, float:1.404E-42)
            r5 = 0
            r3.transact(r6, r4, r1, r5)     // Catch:{ RemoteException -> 0x004d, Exception -> 0x0049, all -> 0x0045 }
            if (r4 == 0) goto L_0x003f
            r4.recycle()
        L_0x003f:
            if (r1 == 0) goto L_0x0084
            r1.recycle()
            goto L_0x0084
        L_0x0045:
            r6 = move-exception
            r3 = r1
            r1 = r4
            goto L_0x0086
        L_0x0049:
            r6 = move-exception
            r3 = r1
            r1 = r4
            goto L_0x0056
        L_0x004d:
            r6 = move-exception
            r3 = r1
            r1 = r4
            goto L_0x0066
        L_0x0051:
            r6 = move-exception
            r3 = r1
            goto L_0x0086
        L_0x0054:
            r6 = move-exception
            r3 = r1
        L_0x0056:
            com.huawei.android.pushagent.c.a.e.c(r2, r0, r6)     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x005e
            r1.recycle()
        L_0x005e:
            if (r3 == 0) goto L_0x0084
        L_0x0060:
            r3.recycle()
            goto L_0x0084
        L_0x0064:
            r6 = move-exception
            r3 = r1
        L_0x0066:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r4.<init>()     // Catch:{ all -> 0x0085 }
            r4.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0085 }
            r4.append(r6)     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0085 }
            com.huawei.android.pushagent.c.a.e.d(r2, r6)     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0081
            r1.recycle()
        L_0x0081:
            if (r3 == 0) goto L_0x0084
            goto L_0x0060
        L_0x0084:
            return
        L_0x0085:
            r6 = move-exception
        L_0x0086:
            if (r1 == 0) goto L_0x008b
            r1.recycle()
        L_0x008b:
            if (r3 == 0) goto L_0x0090
            r3.recycle()
        L_0x0090:
            goto L_0x0092
        L_0x0091:
            throw r6
        L_0x0092:
            goto L_0x0091
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.e.b(java.lang.String):void");
    }

    public static synchronized boolean c() {
        boolean z;
        synchronized (e.class) {
            if (!a) {
                a = true;
                b = "v2".equals(d());
            }
            z = b;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        if (r5 == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        r5.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0071, code lost:
        if (r5 == null) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0091  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0046=Splitter:B:23:0x0046, B:31:0x0056=Splitter:B:31:0x0056} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d() {
        /*
            java.lang.String r0 = "getCtrlSocketVersion error:"
            java.lang.String r1 = "PushLogAC2705"
            java.lang.String r2 = ""
            r3 = 0
            java.lang.String r4 = "connectivity"
            android.os.IBinder r4 = android.os.ServiceManager.getService(r4)     // Catch:{ RemoteException -> 0x0054, Exception -> 0x0044, all -> 0x0041 }
            if (r4 != 0) goto L_0x0015
            java.lang.String r4 = "get connectivity service failed "
            com.huawei.android.pushagent.c.a.e.c(r1, r4)     // Catch:{ RemoteException -> 0x0054, Exception -> 0x0044, all -> 0x0041 }
            return r2
        L_0x0015:
            android.os.Parcel r5 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0054, Exception -> 0x0044, all -> 0x0041 }
            android.os.Parcel r3 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x003c, Exception -> 0x0037, all -> 0x0032 }
            r6 = 1006(0x3ee, float:1.41E-42)
            r7 = 0
            r4.transact(r6, r5, r3, r7)     // Catch:{ RemoteException -> 0x003c, Exception -> 0x0037, all -> 0x0032 }
            java.lang.String r2 = r3.readString()     // Catch:{ RemoteException -> 0x003c, Exception -> 0x0037, all -> 0x0032 }
            if (r5 == 0) goto L_0x002c
            r5.recycle()
        L_0x002c:
            if (r3 == 0) goto L_0x0074
            r3.recycle()
            goto L_0x0074
        L_0x0032:
            r0 = move-exception
            r8 = r5
            r5 = r3
            r3 = r8
            goto L_0x008a
        L_0x0037:
            r4 = move-exception
            r8 = r5
            r5 = r3
            r3 = r8
            goto L_0x0046
        L_0x003c:
            r4 = move-exception
            r8 = r5
            r5 = r3
            r3 = r8
            goto L_0x0056
        L_0x0041:
            r0 = move-exception
            r5 = r3
            goto L_0x008a
        L_0x0044:
            r4 = move-exception
            r5 = r3
        L_0x0046:
            com.huawei.android.pushagent.c.a.e.c(r1, r0, r4)     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x004e
            r3.recycle()
        L_0x004e:
            if (r5 == 0) goto L_0x0074
        L_0x0050:
            r5.recycle()
            goto L_0x0074
        L_0x0054:
            r4 = move-exception
            r5 = r3
        L_0x0056:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r6.<init>()     // Catch:{ all -> 0x0089 }
            r6.append(r0)     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = r4.getMessage()     // Catch:{ all -> 0x0089 }
            r6.append(r0)     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0089 }
            com.huawei.android.pushagent.c.a.e.d(r1, r0)     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x0071
            r3.recycle()
        L_0x0071:
            if (r5 == 0) goto L_0x0074
            goto L_0x0050
        L_0x0074:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "ctrlSocket version is:"
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.huawei.android.pushagent.c.a.e.a(r1, r0)
            return r2
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            if (r3 == 0) goto L_0x008f
            r3.recycle()
        L_0x008f:
            if (r5 == 0) goto L_0x0094
            r5.recycle()
        L_0x0094:
            goto L_0x0096
        L_0x0095:
            throw r0
        L_0x0096:
            goto L_0x0095
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.c.e.d():java.lang.String");
    }
}
