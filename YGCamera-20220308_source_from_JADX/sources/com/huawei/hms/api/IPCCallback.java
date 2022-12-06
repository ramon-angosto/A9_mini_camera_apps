package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.C0701a;
import com.huawei.hms.core.aidl.C0702b;
import com.huawei.hms.core.aidl.C0704c;
import com.huawei.hms.core.aidl.C0710e;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

public class IPCCallback extends C0704c.C0705a {

    /* renamed from: a */
    private final Class<? extends IMessageEntity> f330a;

    /* renamed from: b */
    private final DatagramTransport.C0915a f331b;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.C0915a aVar) {
        this.f330a = cls;
        this.f331b = aVar;
    }

    public void call(C0702b bVar) throws RemoteException {
        if (bVar == null || TextUtils.isEmpty(bVar.f436a)) {
            HMSLog.m1377e("IPCCallback", "In call, URI cannot be empty.");
            throw new RemoteException();
        }
        C0710e a = C0701a.m423a(bVar.mo13626c());
        IMessageEntity iMessageEntity = null;
        if (bVar.mo13625b() > 0 && (iMessageEntity = newResponseInstance()) != null) {
            a.mo13637a(bVar.mo13623a(), iMessageEntity);
        }
        if (bVar.f437b != null) {
            ResponseHeader responseHeader = new ResponseHeader();
            a.mo13637a(bVar.f437b, (IMessageEntity) responseHeader);
            this.f331b.mo14356a(responseHeader.getStatusCode(), iMessageEntity);
            return;
        }
        this.f331b.mo14356a(0, iMessageEntity);
    }

    /* access modifiers changed from: protected */
    public IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> cls = this.f330a;
        if (cls == null) {
            return null;
        }
        try {
            return (IMessageEntity) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            HMSLog.m1377e("IPCCallback", "In newResponseInstance, instancing exception." + e.getMessage());
            return null;
        }
    }
}
