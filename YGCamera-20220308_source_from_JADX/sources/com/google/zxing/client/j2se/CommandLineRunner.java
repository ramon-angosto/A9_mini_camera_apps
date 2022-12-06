package com.google.zxing.client.j2se;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class CommandLineRunner {
    private CommandLineRunner() {
    }

    public static void main(String[] strArr) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tJCommander cannot be resolved to a type\n\tJCommander cannot be resolved to a type\n");
    }

    private static List<URI> expand(List<URI> list) throws IOException {
        DirectoryStream<Path> newDirectoryStream;
        ArrayList arrayList = new ArrayList();
        for (URI next : list) {
            if (isFileOrDir(next)) {
                Path path = Paths.get(next);
                if (Files.isDirectory(path, new LinkOption[0])) {
                    Throwable th = null;
                    try {
                        newDirectoryStream = Files.newDirectoryStream(path);
                        for (Path uri : newDirectoryStream) {
                            arrayList.add(uri.toUri());
                        }
                        if (newDirectoryStream != null) {
                            newDirectoryStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (th != null) {
                            if (th != th) {
                                th.addSuppressed(th);
                            }
                            th = th;
                        }
                        throw th;
                    }
                } else {
                    arrayList.add(next);
                }
            } else {
                arrayList.add(next);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            URI uri2 = (URI) arrayList.get(i);
            if (uri2.getScheme() == null) {
                arrayList.set(i, Paths.get(uri2.getRawPath(), new String[0]).toUri());
            }
        }
        return arrayList;
    }

    private static List<URI> retainValid(List<URI> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (URI next : list) {
            boolean z2 = true;
            if (isFileOrDir(next)) {
                Path path = Paths.get(next);
                if (path.getFileName().toString().startsWith(".") || (!z && Files.isDirectory(path, new LinkOption[0]))) {
                    z2 = false;
                }
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static boolean isExpandable(List<URI> list) {
        for (URI next : list) {
            if (isFileOrDir(next) && Files.isDirectory(Paths.get(next), new LinkOption[0])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isFileOrDir(URI uri) {
        return "file".equals(uri.getScheme());
    }
}
