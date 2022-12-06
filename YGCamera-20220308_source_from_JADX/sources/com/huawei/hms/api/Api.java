package com.huawei.hms.api;

import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

public class Api<O extends ApiOptions> {

    /* renamed from: a */
    private final String f265a;

    /* renamed from: b */
    private final Options<O> f266b;
    public List<ConnectionPostProcessor> mConnetctPostList;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class Options<O> {
        public List<PermissionInfo> getPermissionInfoList(O o) {
            return Collections.emptyList();
        }

        public List<Scope> getScopeList(O o) {
            return Collections.emptyList();
        }
    }

    public Api(String str) {
        this.f265a = str;
        this.f266b = null;
    }

    public String getApiName() {
        return this.f265a;
    }

    public Options<O> getOptions() {
        return this.f266b;
    }

    public List<ConnectionPostProcessor> getmConnetctPostList() {
        return this.mConnetctPostList;
    }

    public void setmConnetctPostList(List<ConnectionPostProcessor> list) {
        this.mConnetctPostList = list;
    }

    public Api(String str, Options<O> options) {
        this.f265a = str;
        this.f266b = options;
    }
}
