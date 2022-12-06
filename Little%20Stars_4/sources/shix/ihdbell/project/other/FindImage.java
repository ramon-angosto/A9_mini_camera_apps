package shix.ihdbell.project.other;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindImage {
    List<String> list = new ArrayList();

    public FindImage(String str) {
        System.out.println(str);
        start(str);
    }

    public void start(String str) {
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            File[] fileArr = new File[0];
            File[] listFiles = file.listFiles();
            if (listFiles.length != 0) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].getAbsolutePath().contains(".jpg") || listFiles[i].getAbsolutePath().contains(".JPG") || listFiles[i].getAbsolutePath().contains(".png") || listFiles[i].getAbsolutePath().contains(".PNG")) {
                        this.list.add(listFiles[i].getAbsolutePath());
                    }
                    if (listFiles[i].isDirectory() && listFiles[i].canRead()) {
                        Find(listFiles[i].getAbsolutePath());
                    }
                }
            }
        }
    }

    public List<String> getList() {
        return this.list;
    }

    public int getSize() {
        return this.list.size();
    }

    public void Find(String str) {
        File file = new File(str);
        if (file.exists()) {
            File[] fileArr = new File[0];
            File[] listFiles = file.listFiles();
            if (listFiles.length != 0) {
                for (int i = 0; i < listFiles.length; i++) {
                    if ((listFiles[i].getAbsolutePath().contains("jpg") | listFiles[i].getAbsolutePath().contains("JPG") | listFiles[i].getAbsolutePath().contains("png")) || listFiles[i].getAbsolutePath().contains("PNG")) {
                        this.list.add(listFiles[i].getAbsolutePath());
                    }
                    if (listFiles[i].isDirectory() && listFiles[i].canRead()) {
                        Find(listFiles[i].getAbsolutePath());
                    }
                }
            }
        }
    }
}
