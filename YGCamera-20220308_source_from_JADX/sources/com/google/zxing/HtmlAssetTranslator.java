package com.google.zxing;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.xml.sax.SAXException;

public final class HtmlAssetTranslator {
    private static final Pattern COMMA = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    private HtmlAssetTranslator() {
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 3) {
            System.err.println("Usage: HtmlAssetTranslator android/assets/ (all|lang1[,lang2 ...]) (all|file1.html[ file2.html ...])");
            return;
        }
        Path path = Paths.get(strArr[0], new String[0]);
        Collection<String> parseLanguagesToTranslate = parseLanguagesToTranslate(path, strArr[1]);
        Collection<String> parseFileNamesToTranslate = parseFileNamesToTranslate(path, Arrays.asList(strArr).subList(2, strArr.length));
        for (String translateOneLanguage : parseLanguagesToTranslate) {
            translateOneLanguage(path, translateOneLanguage, parseFileNamesToTranslate);
        }
    }

    private static Collection<String> parseLanguagesToTranslate(Path path, String str) throws IOException {
        DirectoryStream<Path> newDirectoryStream;
        if (!"all".equals(str)) {
            return Arrays.asList(COMMA.split(str));
        }
        ArrayList arrayList = new ArrayList();
        Throwable th = null;
        try {
            newDirectoryStream = Files.newDirectoryStream(path, new DirectoryStream.Filter<Path>() {
                public boolean accept(Path path) {
                    String path2 = path.getFileName().toString();
                    if (!Files.isDirectory(path, new LinkOption[0]) || Files.isSymbolicLink(path) || !path2.startsWith("html-") || "html-en".equals(path2)) {
                        return false;
                    }
                    return true;
                }
            });
            for (Path fileName : newDirectoryStream) {
                arrayList.add(fileName.getFileName().toString().substring(5));
            }
            if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            return arrayList;
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

    private static Collection<String> parseFileNamesToTranslate(Path path, List<String> list) throws IOException {
        DirectoryStream<Path> newDirectoryStream;
        if (!"all".equals(list.get(0))) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Throwable th = null;
        try {
            newDirectoryStream = Files.newDirectoryStream(path.resolve("html-en"), "*.html");
            for (Path fileName : newDirectoryStream) {
                arrayList.add(fileName.getFileName().toString());
            }
            if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            return arrayList;
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

    private static void translateOneLanguage(Path path, String str, final Collection<String> collection) throws IOException {
        DirectoryStream<Path> newDirectoryStream;
        Path resolve = path.resolve("html-" + str);
        Files.createDirectories(resolve, new FileAttribute[0]);
        Path resolve2 = path.resolve("html-en");
        String translateString = StringsResourceTranslator.translateString("Translated by Google Translate.", str);
        C04942 r2 = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path path) {
                String path2 = path.getFileName().toString();
                if (path2.endsWith(".html")) {
                    return collection.isEmpty() || collection.contains(path2);
                }
                return false;
            }
        };
        Throwable th = null;
        try {
            newDirectoryStream = Files.newDirectoryStream(resolve2, r2);
            for (Path translateOneFile : newDirectoryStream) {
                translateOneFile(str, resolve, translateOneFile, translateString);
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

    private static void translateOneFile(String str, Path path, Path path2, String str2) throws IOException {
        Path resolve = path.resolve(path2.getFileName());
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path2.toFile());
            Element documentElement = parse.getDocumentElement();
            documentElement.normalize();
            LinkedList linkedList = new LinkedList();
            linkedList.add(documentElement);
            while (true) {
                if (linkedList.isEmpty()) {
                    Text createTextNode = parse.createTextNode(str2);
                    Element createElement = parse.createElement("p");
                    createElement.appendChild(createTextNode);
                    documentElement.getElementsByTagName("body").item(0).appendChild(createElement);
                    try {
                        Files.write(resolve, Collections.singleton(((DOMImplementationLS) DOMImplementationRegistry.newInstance().getDOMImplementation("LS")).createLSSerializer().writeToString(parse).replaceAll("<\\?xml[^>]+>", "<!DOCTYPE HTML>")), StandardCharsets.UTF_8, new OpenOption[0]);
                        return;
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                        throw new IllegalStateException(e);
                    }
                } else {
                    Node node = (Node) linkedList.poll();
                    if (shouldTranslate(node)) {
                        NodeList childNodes = node.getChildNodes();
                        for (int i = 0; i < childNodes.getLength(); i++) {
                            linkedList.add(childNodes.item(i));
                        }
                    }
                    if (node.getNodeType() == 3) {
                        String textContent = node.getTextContent();
                        if (!textContent.trim().isEmpty()) {
                            String translateString = StringsResourceTranslator.translateString(textContent, str);
                            node.setTextContent(String.valueOf(' ') + translateString + ' ');
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e2) {
            throw new IllegalStateException(e2);
        } catch (SAXException e3) {
            throw new IOException(e3);
        }
    }

    private static boolean shouldTranslate(Node node) {
        String textContent;
        Node namedItem;
        String textContent2;
        NamedNodeMap attributes = node.getAttributes();
        if ((attributes == null || (namedItem = attributes.getNamedItem("class")) == null || (textContent2 = namedItem.getTextContent()) == null || !textContent2.contains("notranslate")) && !"script".equalsIgnoreCase(node.getNodeName()) && (textContent = node.getTextContent()) != null) {
            for (int i = 0; i < textContent.length(); i++) {
                if (Character.isLetter(textContent.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
