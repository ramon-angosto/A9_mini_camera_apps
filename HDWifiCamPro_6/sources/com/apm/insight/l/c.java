package com.apm.insight.l;

import android.os.Build;
import android.os.Debug;

public class c {
    static final a a = (Build.VERSION.SDK_INT >= 19 ? new b() : new a());

    private static class a {
        private a() {
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    private static class b extends a {
        private b() {
            super();
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return a.c(memoryInfo);
    }
}
