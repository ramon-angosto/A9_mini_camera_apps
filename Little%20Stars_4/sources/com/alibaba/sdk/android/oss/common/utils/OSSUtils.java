package com.alibaba.sdk.android.oss.common.utils;

import android.util.Base64;
import android.util.Pair;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.auth.HmacSHA1Signature;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.model.CopyObjectRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class OSSUtils {
    private static final List<String> SIGNED_PARAMTERS = Arrays.asList(new String[]{RequestParameters.SUBRESOURCE_ACL, RequestParameters.SUBRESOURCE_UPLOADS, RequestParameters.SUBRESOURCE_LOCATION, RequestParameters.SUBRESOURCE_CORS, RequestParameters.SUBRESOURCE_LOGGING, RequestParameters.SUBRESOURCE_WEBSITE, RequestParameters.SUBRESOURCE_REFERER, RequestParameters.SUBRESOURCE_LIFECYCLE, RequestParameters.SUBRESOURCE_DELETE, RequestParameters.SUBRESOURCE_APPEND, RequestParameters.UPLOAD_ID, RequestParameters.PART_NUMBER, RequestParameters.SECURITY_TOKEN, RequestParameters.POSITION, RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, RequestParameters.RESPONSE_HEADER_EXPIRES});

    public static void populateRequestMetadata(Map<String, String> map, ObjectMetadata objectMetadata) {
        if (objectMetadata != null) {
            Map<String, Object> rawMetadata = objectMetadata.getRawMetadata();
            if (rawMetadata != null) {
                for (Map.Entry next : rawMetadata.entrySet()) {
                    map.put(next.getKey(), next.getValue().toString());
                }
            }
            Map<String, String> userMetadata = objectMetadata.getUserMetadata();
            if (userMetadata != null) {
                for (Map.Entry next2 : userMetadata.entrySet()) {
                    String str = (String) next2.getKey();
                    String str2 = (String) next2.getValue();
                    if (str != null) {
                        str = str.trim();
                    }
                    if (str2 != null) {
                        str2 = str2.trim();
                    }
                    map.put(str, str2);
                }
            }
        }
    }

    public static void populateListObjectsRequestParameters(ListObjectsRequest listObjectsRequest, Map<String, String> map) {
        if (listObjectsRequest.getPrefix() != null) {
            map.put(RequestParameters.PREFIX, listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            map.put(RequestParameters.MARKER, listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            map.put(RequestParameters.DELIMITER, listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() != null) {
            map.put(RequestParameters.MAX_KEYS, Integer.toString(listObjectsRequest.getMaxKeys().intValue()));
        }
        if (listObjectsRequest.getEncodingType() != null) {
            map.put(RequestParameters.ENCODING_TYPE, listObjectsRequest.getEncodingType());
        }
    }

    private enum MetadataDirective {
        COPY("COPY"),
        REPLACE("REPLACE");
        
        private final String directiveAsString;

        private MetadataDirective(String str) {
            this.directiveAsString = str;
        }

        public String toString() {
            return this.directiveAsString;
        }
    }

    public static void populateCopyObjectHeaders(CopyObjectRequest copyObjectRequest, Map<String, String> map) {
        map.put(OSSHeaders.COPY_OBJECT_SOURCE, "/" + copyObjectRequest.getSourceBucketName() + "/" + HttpUtil.urlEncode(copyObjectRequest.getSourceKey(), "utf-8"));
        addDateHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        addDateHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_MATCH, copyObjectRequest.getMatchingETagConstraints());
        addStringListHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_NONE_MATCH, copyObjectRequest.getNonmatchingEtagConstraints());
        addHeader(map, OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION, copyObjectRequest.getServerSideEncryption());
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            map.put(OSSHeaders.COPY_OBJECT_METADATA_DIRECTIVE, MetadataDirective.REPLACE.toString());
            populateRequestMetadata(map, newObjectMetadata);
        }
        removeHeader(map, HttpHeaders.CONTENT_LENGTH);
    }

    public static String buildXMLFromPartEtagList(List<PartETag> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("<CompleteMultipartUpload>\n");
        for (PartETag next : list) {
            sb.append("<Part>\n");
            sb.append("<PartNumber>" + next.getPartNumber() + "</PartNumber>\n");
            sb.append("<ETag>" + next.getETag() + "</ETag>\n");
            sb.append("</Part>\n");
        }
        sb.append("</CompleteMultipartUpload>\n");
        return sb.toString();
    }

    public static void addHeader(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    public static void addDateHeader(Map<String, String> map, String str, Date date) {
        if (date != null) {
            map.put(str, DateUtil.formatRfc822Date(date));
        }
    }

    public static void addStringListHeader(Map<String, String> map, String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            map.put(str, join(list));
        }
    }

    public static void removeHeader(Map<String, String> map, String str) {
        if (str != null && map.containsKey(str)) {
            map.remove(str);
        }
    }

    public static String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : list) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next);
            z = false;
        }
        return sb.toString();
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    public static String buildCanonicalizedResource(String str, String str2, Map<String, String> map) {
        String str3 = "/";
        if (!(str == null && str2 == null)) {
            if (str2 == null) {
                str3 = str3 + str + str3;
            } else {
                str3 = str3 + str + str3 + str2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        if (map != null) {
            String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
            Arrays.sort(strArr);
            char c = '?';
            for (String str4 : strArr) {
                if (SIGNED_PARAMTERS.contains(str4)) {
                    sb.append(c);
                    sb.append(str4);
                    String str5 = map.get(str4);
                    if (!isEmptyString(str5)) {
                        sb.append("=");
                        sb.append(str5);
                    }
                    c = '&';
                }
            }
        }
        return sb.toString();
    }

    public static String paramToQueryString(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (!z) {
                sb.append("&");
            }
            sb.append(HttpUtil.urlEncode(str2, str));
            if (!isEmptyString(str3)) {
                sb.append("=");
                sb.append(HttpUtil.urlEncode(str3, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static String populateMapToBase64JsonString(Map<String, String> map) {
        return Base64.encodeToString(new JSONObject(map).toString().getBytes(), 2);
    }

    public static String sign(String str, String str2, String str3) {
        try {
            String trim = new HmacSHA1Signature().computeSignature(str2, str3).trim();
            return "OSS " + str + ":" + trim;
        } catch (Exception e) {
            throw new IllegalStateException("Compute signature failed!", e);
        }
    }

    public static boolean isCname(String str) {
        for (String endsWith : OSSConstants.DEFAULT_CNAME_EXCLUDE_LIST) {
            if (str.toLowerCase().endsWith(endsWith)) {
                return false;
            }
        }
        return true;
    }

    public static void assertTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean validateBucketName(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-z0-9][a-z0-9_\\-]{2,62}$");
    }

    public static void ensureBucketNameValid(String str) {
        if (!validateBucketName(str)) {
            throw new IllegalArgumentException("The bucket name is invalid. \nA bucket name must: \n1) be comprised of lower-case characters, numbers or dash(-); \n2) start with lower case or numbers; \n3) be between 3-63 characters long. ");
        }
    }

    public static boolean validateObjectKey(String str) {
        if (str != null && str.length() > 0 && str.length() <= 1023) {
            try {
                str.getBytes("utf-8");
                char[] charArray = str.toCharArray();
                char c = charArray[0];
                if (!(c == '/' || c == '\\')) {
                    for (char c2 : charArray) {
                        if (c2 != 9 && c2 < ' ') {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return false;
    }

    public static void ensureObjectKeyValid(String str) {
        if (!validateObjectKey(str)) {
            throw new IllegalArgumentException("The object key is invalid. \nAn object name should be: \n1) between 1 - 1023 bytes long when encoded as UTF-8 \n2) cannot contain LF or CR or unsupported chars in XML1.0, \n3) cannot begin with \"/\" or \"\\\".");
        }
    }

    public static boolean doesRequestNeedObjectKey(OSSRequest oSSRequest) {
        return !(oSSRequest instanceof ListObjectsRequest) && !(oSSRequest instanceof CreateBucketRequest) && !(oSSRequest instanceof DeleteBucketRequest) && !(oSSRequest instanceof GetBucketACLRequest);
    }

    public static void ensureRequestValid(OSSRequest oSSRequest, RequestMessage requestMessage) {
        ensureBucketNameValid(requestMessage.getBucketName());
        if (doesRequestNeedObjectKey(oSSRequest)) {
            ensureObjectKeyValid(requestMessage.getObjectKey());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r2 = r2.getMimeTypeFromExtension(r4.substring(r4.lastIndexOf(46) + 1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String determineContentType(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            if (r2 == 0) goto L_0x0003
            return r2
        L_0x0003:
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            r0 = 46
            if (r3 == 0) goto L_0x001c
            int r1 = r3.lastIndexOf(r0)
            int r1 = r1 + 1
            java.lang.String r3 = r3.substring(r1)
            java.lang.String r3 = r2.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x001c
            return r3
        L_0x001c:
            if (r4 == 0) goto L_0x002f
            int r3 = r4.lastIndexOf(r0)
            int r3 = r3 + 1
            java.lang.String r3 = r4.substring(r3)
            java.lang.String r2 = r2.getMimeTypeFromExtension(r3)
            if (r2 == 0) goto L_0x002f
            return r2
        L_0x002f:
            java.lang.String r2 = "application/octet-stream"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.OSSUtils.determineContentType(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void signRequest(RequestMessage requestMessage) throws IOException {
        OSSFederationToken oSSFederationToken;
        String str;
        if (requestMessage.isAuthorizationRequired()) {
            if (requestMessage.getCredentialProvider() != null) {
                OSSCredentialProvider credentialProvider = requestMessage.getCredentialProvider();
                boolean z = credentialProvider instanceof OSSFederationCredentialProvider;
                Pair pair = null;
                if (z) {
                    oSSFederationToken = ((OSSFederationCredentialProvider) credentialProvider).getValidFederationToken();
                    if (oSSFederationToken != null) {
                        requestMessage.getHeaders().put(OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
                    } else {
                        OSSLog.logE("Can't get a federation token");
                        throw new IOException("Can't get a federation token");
                    }
                } else if (credentialProvider instanceof OSSStsTokenCredentialProvider) {
                    oSSFederationToken = ((OSSStsTokenCredentialProvider) credentialProvider).getFederationToken();
                    requestMessage.getHeaders().put(OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
                } else {
                    oSSFederationToken = null;
                }
                String httpMethod = requestMessage.getMethod().toString();
                String str2 = requestMessage.getHeaders().get(HttpHeaders.CONTENT_MD5);
                String str3 = "";
                if (str2 == null) {
                    str2 = str3;
                }
                String str4 = requestMessage.getHeaders().get(HttpHeaders.CONTENT_TYPE);
                if (str4 != null) {
                    str3 = str4;
                }
                String str5 = requestMessage.getHeaders().get(HttpHeaders.DATE);
                ArrayList<Pair> arrayList = new ArrayList<>();
                for (String next : requestMessage.getHeaders().keySet()) {
                    if (next.toLowerCase().startsWith(OSSHeaders.OSS_PREFIX)) {
                        arrayList.add(new Pair(next.toLowerCase(), requestMessage.getHeaders().get(next)));
                    }
                }
                Collections.sort(arrayList, new Comparator<Pair<String, String>>() {
                    public int compare(Pair<String, String> pair, Pair<String, String> pair2) {
                        return ((String) pair.first).compareTo((String) pair2.first);
                    }
                });
                StringBuilder sb = new StringBuilder();
                for (Pair pair2 : arrayList) {
                    if (pair == null) {
                        sb.append(((String) pair2.first) + ":" + ((String) pair2.second));
                    } else if (((String) pair.first).equals(pair2.first)) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP + ((String) pair2.second));
                    } else {
                        sb.append("\n" + ((String) pair2.first) + ":" + ((String) pair2.second));
                    }
                    pair = pair2;
                }
                String sb2 = sb.toString();
                if (!isEmptyString(sb2)) {
                    sb2 = sb2.trim() + "\n";
                }
                String format = String.format("%s\n%s\n%s\n%s\n%s%s", new Object[]{httpMethod, str2, str3, str5, sb2, buildCanonicalizedResource(requestMessage.getBucketName(), requestMessage.getObjectKey(), requestMessage.getParameters())});
                if (z || (credentialProvider instanceof OSSStsTokenCredentialProvider)) {
                    str = sign(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), format);
                } else if (credentialProvider instanceof OSSPlainTextAKSKCredentialProvider) {
                    OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = (OSSPlainTextAKSKCredentialProvider) credentialProvider;
                    str = sign(oSSPlainTextAKSKCredentialProvider.getAccessKeyId(), oSSPlainTextAKSKCredentialProvider.getAccessKeySecret(), format);
                } else {
                    str = credentialProvider instanceof OSSCustomSignerCredentialProvider ? ((OSSCustomSignerCredentialProvider) credentialProvider).signContent(format) : "---initValue---";
                }
                OSSLog.logD("signed content: " + format.replaceAll("\n", "@") + "   ---------   signature: " + str);
                requestMessage.getHeaders().put(HttpHeaders.AUTHORIZATION, str);
                return;
            }
            throw new IllegalStateException("当前CredentialProvider为空！！！\n1. 请检查您是否在初始化OSSService时设置CredentialProvider;\n2. 如果您bucket为公共权限，请确认获取到Bucket后已经调用Bucket中接口声明ACL;");
        }
    }
}
