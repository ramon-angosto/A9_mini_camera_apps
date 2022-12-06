package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

public class BindResolveClients {
    private static final Object LOCK_INST = new Object();
    private ArrayList<ResolveClientBean> mClientList;

    private static class SingletonManager {
        /* access modifiers changed from: private */
        public static final BindResolveClients INSTANCE = new BindResolveClients();

        private SingletonManager() {
        }
    }

    public static BindResolveClients getInstance() {
        return SingletonManager.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (LOCK_INST) {
            contains = this.mClientList.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (LOCK_INST) {
            ListIterator<ResolveClientBean> listIterator = this.mClientList.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.mClientList.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean != null) {
            synchronized (LOCK_INST) {
                if (!this.mClientList.contains(resolveClientBean)) {
                    this.mClientList.add(resolveClientBean);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean != null) {
            synchronized (LOCK_INST) {
                if (this.mClientList.contains(resolveClientBean)) {
                    ListIterator<ResolveClientBean> listIterator = this.mClientList.listIterator();
                    while (true) {
                        if (listIterator.hasNext()) {
                            if (resolveClientBean.equals(listIterator.next())) {
                                listIterator.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (LOCK_INST) {
            this.mClientList.clear();
        }
    }

    private BindResolveClients() {
        this.mClientList = new ArrayList<>();
    }
}
