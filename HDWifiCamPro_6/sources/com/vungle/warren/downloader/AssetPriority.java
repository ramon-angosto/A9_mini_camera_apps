package com.vungle.warren.downloader;

public class AssetPriority implements Comparable {
    private final Integer firstPriority;
    private final Integer secondPriority;

    public AssetPriority(int i, int i2) {
        this.firstPriority = Integer.valueOf(i);
        this.secondPriority = Integer.valueOf(i2);
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof AssetPriority)) {
            return -1;
        }
        AssetPriority assetPriority = (AssetPriority) obj;
        int compareTo = this.firstPriority.compareTo(assetPriority.firstPriority);
        return compareTo == 0 ? this.secondPriority.compareTo(assetPriority.secondPriority) : compareTo;
    }

    public String toString() {
        return "AssetPriority{firstPriority=" + this.firstPriority + ", secondPriority=" + this.secondPriority + '}';
    }
}
