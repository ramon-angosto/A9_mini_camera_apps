package androidx.browser.trusted;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

class PackageIdentityUtils {
    private static final String TAG = "PackageIdentity";

    interface SignaturesCompat {
        List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException;

        boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws IOException, PackageManager.NameNotFoundException;
    }

    private PackageIdentityUtils() {
    }

    static List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) {
        try {
            return getImpl().getFingerprintsForPackage(str, packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not get fingerprint for package.", e);
            return null;
        }
    }

    static boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) {
        try {
            return getImpl().packageMatchesToken(str, packageManager, tokenContents);
        } catch (PackageManager.NameNotFoundException | IOException e) {
            Log.e(TAG, "Could not check if package matches token.", e);
            return false;
        }
    }

    private static SignaturesCompat getImpl() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new Api28Implementation();
        }
        return new Pre28Implementation();
    }

    static class Api28Implementation implements SignaturesCompat {
        Api28Implementation() {
        }

        public List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            ArrayList arrayList = new ArrayList();
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo.hasMultipleSigners()) {
                for (Signature certificateSHA256Fingerprint : signingInfo.getApkContentsSigners()) {
                    arrayList.add(PackageIdentityUtils.getCertificateSHA256Fingerprint(certificateSHA256Fingerprint));
                }
            } else {
                arrayList.add(PackageIdentityUtils.getCertificateSHA256Fingerprint(signingInfo.getSigningCertificateHistory()[0]));
            }
            return arrayList;
        }

        public boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws PackageManager.NameNotFoundException, IOException {
            List<byte[]> fingerprintsForPackage;
            if (!tokenContents.getPackageName().equals(str) || (fingerprintsForPackage = getFingerprintsForPackage(str, packageManager)) == null) {
                return false;
            }
            if (fingerprintsForPackage.size() == 1) {
                return packageManager.hasSigningCertificate(str, tokenContents.getFingerprint(0), 1);
            }
            return tokenContents.equals(TokenContents.create(str, fingerprintsForPackage));
        }
    }

    static class Pre28Implementation implements SignaturesCompat {
        Pre28Implementation() {
        }

        public List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
            for (Signature certificateSHA256Fingerprint : packageInfo.signatures) {
                byte[] certificateSHA256Fingerprint2 = PackageIdentityUtils.getCertificateSHA256Fingerprint(certificateSHA256Fingerprint);
                if (certificateSHA256Fingerprint2 == null) {
                    return null;
                }
                arrayList.add(certificateSHA256Fingerprint2);
            }
            return arrayList;
        }

        public boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws IOException, PackageManager.NameNotFoundException {
            List<byte[]> fingerprintsForPackage;
            if (str.equals(tokenContents.getPackageName()) && (fingerprintsForPackage = getFingerprintsForPackage(str, packageManager)) != null) {
                return tokenContents.equals(TokenContents.create(str, fingerprintsForPackage));
            }
            return false;
        }
    }

    static byte[] getCertificateSHA256Fingerprint(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
