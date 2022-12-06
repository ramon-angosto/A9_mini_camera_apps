package com.google.zxing;

import com.bumptech.glide.load.Key;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URI;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringsResourceTranslator {
    private static final String APACHE_2_LICENSE = "<!--\n Copyright (C) 2015 ZXing authors\n\n Licensed under the Apache License, Version 2.0 (the \"License\");\n you may not use this file except in compliance with the License.\n You may obtain a copy of the License at\n\n      http://www.apache.org/licenses/LICENSE-2.0\n\n Unless required by applicable law or agreed to in writing, software\n distributed under the License is distributed on an \"AS IS\" BASIS,\n WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n See the License for the specific language governing permissions and\n limitations under the License.\n -->\n";
    private static final String API_KEY = System.getProperty("translateAPI.key");
    private static final Pattern ENTRY_PATTERN = Pattern.compile("<string name=\"([^\"]+)\".*>([^<]+)</string>");
    private static final Map<String, String> LANGUAGE_CODE_MASSAGINGS = new HashMap(3);
    private static final Pattern STRINGS_FILE_NAME_PATTERN = Pattern.compile("values-(.+)");
    private static final Pattern TRANSLATE_RESPONSE_PATTERN = Pattern.compile("translatedText\":\\s*\"([^\"]+)\"");
    /* access modifiers changed from: private */
    public static final Pattern VALUES_DIR_PATTERN = Pattern.compile("values-[a-z]{2}(-[a-zA-Z]{2,3})?");

    static {
        if (API_KEY != null) {
            LANGUAGE_CODE_MASSAGINGS.put("zh-rCN", "zh-cn");
            LANGUAGE_CODE_MASSAGINGS.put("zh-rTW", "zh-tw");
            return;
        }
        throw new IllegalArgumentException("translateAPI.key is not specified");
    }

    private StringsResourceTranslator() {
    }

    public static void main(String[] strArr) throws IOException {
        DirectoryStream<Path> newDirectoryStream;
        Path path = Paths.get(strArr[0], new String[0]);
        Path resolve = path.resolve("values").resolve("strings.xml");
        List subList = Arrays.asList(strArr).subList(1, strArr.length);
        Throwable th = null;
        try {
            newDirectoryStream = Files.newDirectoryStream(path, new DirectoryStream.Filter<Path>() {
                public boolean accept(Path path) {
                    if (!Files.isDirectory(path, new LinkOption[0]) || Files.isSymbolicLink(path) || !StringsResourceTranslator.VALUES_DIR_PATTERN.matcher(path.getFileName().toString()).matches()) {
                        return false;
                    }
                    return true;
                }
            });
            for (Path resolve2 : newDirectoryStream) {
                translate(resolve, resolve2.resolve("strings.xml"), subList);
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
    }

    private static void translate(Path path, Path path2, Collection<String> collection) throws IOException {
        BufferedWriter newBufferedWriter;
        Map<String, String> readLines = readLines(path);
        Map<String, String> readLines2 = readLines(path2);
        String path3 = path2.getParent().getFileName().toString();
        Matcher matcher = STRINGS_FILE_NAME_PATTERN.matcher(path3);
        if (matcher.find()) {
            String group = matcher.group(1);
            String str = LANGUAGE_CODE_MASSAGINGS.get(group);
            if (str != null) {
                group = str;
            }
            PrintStream printStream = System.out;
            printStream.println("Translating " + group);
            Throwable th = null;
            Path createTempFile = Files.createTempFile((String) null, (String) null, new FileAttribute[0]);
            try {
                newBufferedWriter = Files.newBufferedWriter(createTempFile, StandardCharsets.UTF_8, new OpenOption[0]);
                newBufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                newBufferedWriter.write(APACHE_2_LICENSE);
                newBufferedWriter.write("<resources>\n");
                boolean z = false;
                for (Map.Entry next : readLines.entrySet()) {
                    String str2 = (String) next.getKey();
                    String str3 = (String) next.getValue();
                    newBufferedWriter.write("  <string name=\"");
                    newBufferedWriter.write(str2);
                    newBufferedWriter.write(34);
                    if (str3.contains("%s") || str3.contains("%f")) {
                        newBufferedWriter.write(" formatted=\"false\"");
                    }
                    newBufferedWriter.write(62);
                    String str4 = readLines2.get(str2);
                    if (str4 == null || collection.contains(str2)) {
                        str4 = translateString(str3, group).replaceAll("'", "\\\\'");
                        z = true;
                    }
                    newBufferedWriter.write(str4);
                    newBufferedWriter.write("</string>\n");
                }
                newBufferedWriter.write("</resources>\n");
                newBufferedWriter.flush();
                if (newBufferedWriter != null) {
                    newBufferedWriter.close();
                }
                if (z) {
                    System.out.println("  Writing translations");
                    Files.move(createTempFile, path2, new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                    return;
                }
                Files.delete(createTempFile);
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
            throw new IllegalArgumentException("Invalid parent dir: " + path3);
        }
    }

    static String translateString(String str, String str2) throws IOException {
        if ("en".equals(str2)) {
            return str;
        }
        String str3 = LANGUAGE_CODE_MASSAGINGS.get(str2);
        if (str3 != null) {
            str2 = str3;
        }
        PrintStream printStream = System.out;
        printStream.println("  Need translation for " + str);
        CharSequence fetch = fetch(URI.create("https://www.googleapis.com/language/translate/v2?key=" + API_KEY + "&q=" + URLEncoder.encode(str, Key.STRING_CHARSET_NAME) + "&source=en&target=" + str2));
        Matcher matcher = TRANSLATE_RESPONSE_PATTERN.matcher(fetch);
        if (!matcher.find()) {
            System.err.println("No translate result");
            System.err.println(fetch);
            return str;
        }
        String replaceAll = matcher.group(1).replaceAll("&(amp;)?quot;", "\"").replaceAll("&(amp;)?#39;", "'");
        PrintStream printStream2 = System.out;
        printStream2.println("  Got translation " + replaceAll);
        return replaceAll;
    }

    private static CharSequence fetch(URI uri) throws IOException {
        BufferedReader bufferedReader;
        URLConnection openConnection = uri.toURL().openConnection();
        openConnection.connect();
        StringBuilder sb = new StringBuilder(200);
        Throwable th = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream(), StandardCharsets.UTF_8));
            char[] cArr = new char[8192];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    bufferedReader.close();
                    return sb;
                }
                sb.append(cArr, 0, read);
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
    }

    private static Map<String, String> readLines(Path path) throws IOException {
        if (!Files.exists(path, new LinkOption[0])) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap();
        for (String matcher : Files.readAllLines(path, StandardCharsets.UTF_8)) {
            Matcher matcher2 = ENTRY_PATTERN.matcher(matcher);
            if (matcher2.find()) {
                treeMap.put(matcher2.group(1), matcher2.group(2));
            }
        }
        return treeMap;
    }
}
