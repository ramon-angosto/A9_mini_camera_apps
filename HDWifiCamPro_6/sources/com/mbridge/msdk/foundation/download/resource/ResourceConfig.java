package com.mbridge.msdk.foundation.download.resource;

import com.mbridge.msdk.foundation.download.DownloadResourceType;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ResourceConfig {
    private long maxStorageSpace;
    private Map<String, Long> maxStorageSpacePerResourceType;
    private long maxStorageTime;
    private Map<String, Long> maxStorageTimePerResourceType;
    private Queue<ResourceStrategy> resourceStrategyQueue;

    private ResourceConfig(Builder builder) {
        this.maxStorageSpace = builder.maxStorageSpace;
        this.maxStorageTime = builder.maxStorageTime;
        this.maxStorageSpacePerResourceType = builder.maxStorageSpacePerResourceType;
        this.maxStorageTimePerResourceType = builder.maxStorageTimePerResourceType;
        this.resourceStrategyQueue = builder.resourceStrategyQueue;
    }

    public long getMaxStorageSpace() {
        return this.maxStorageSpace;
    }

    public long getMaxStorageTime() {
        return this.maxStorageTime;
    }

    public Map<String, Long> getMaxStorageSpacePerResourceType() {
        return this.maxStorageSpacePerResourceType;
    }

    public long getMaxStorageSpace(DownloadResourceType downloadResourceType) {
        Map<String, Long> map = this.maxStorageSpacePerResourceType;
        if (map == null || !map.containsKey(downloadResourceType.name())) {
            return 0;
        }
        return this.maxStorageSpacePerResourceType.get(downloadResourceType.name()).longValue();
    }

    public Map<String, Long> getMaxStorageTimePerResourceType() {
        return this.maxStorageTimePerResourceType;
    }

    public long getMaxStorageTime(DownloadResourceType downloadResourceType) {
        Map<String, Long> map = this.maxStorageTimePerResourceType;
        if (map == null || !map.containsKey(downloadResourceType.name())) {
            return 0;
        }
        return this.maxStorageTimePerResourceType.get(downloadResourceType.name()).longValue();
    }

    public Queue<ResourceStrategy> getResourceStrategyQueue() {
        return this.resourceStrategyQueue;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public long maxStorageSpace;
        /* access modifiers changed from: private */
        public Map<String, Long> maxStorageSpacePerResourceType;
        /* access modifiers changed from: private */
        public long maxStorageTime;
        /* access modifiers changed from: private */
        public Map<String, Long> maxStorageTimePerResourceType;
        /* access modifiers changed from: private */
        public Queue<ResourceStrategy> resourceStrategyQueue;

        public Builder setMaxStorageSpace(long j) {
            this.maxStorageSpace = j;
            return this;
        }

        public Builder setMaxStorageTime(long j) {
            this.maxStorageTime = j;
            return this;
        }

        public Builder addMaxStorageSpace(DownloadResourceType downloadResourceType, long j) {
            if (this.maxStorageSpacePerResourceType == null) {
                this.maxStorageSpacePerResourceType = new HashMap();
            }
            this.maxStorageSpacePerResourceType.put(downloadResourceType.name(), Long.valueOf(j));
            return this;
        }

        public Builder addMaxStorageTime(DownloadResourceType downloadResourceType, long j) {
            if (this.maxStorageTimePerResourceType == null) {
                this.maxStorageTimePerResourceType = new HashMap();
            }
            this.maxStorageTimePerResourceType.put(downloadResourceType.name(), Long.valueOf(j));
            return this;
        }

        public Builder addResourceStrategy(ResourceStrategy resourceStrategy) {
            if (this.resourceStrategyQueue == null) {
                this.resourceStrategyQueue = new ArrayDeque();
            }
            this.resourceStrategyQueue.add(resourceStrategy);
            return this;
        }

        public ResourceConfig build() {
            return new ResourceConfig(this);
        }
    }
}
