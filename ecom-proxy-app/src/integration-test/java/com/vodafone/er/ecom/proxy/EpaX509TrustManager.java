package com.vodafone.er.ecom.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Optional;

/**
 * Created by Ravi Aghera
 */
public class EpaX509TrustManager implements X509TrustManager {

    private static Logger log = LoggerFactory.getLogger(EpaX509TrustManager.class);

    /*
     * The default trust manager used to verify trusted servers.
     */
    private X509TrustManager defaultTrustManager = null;
    private X509KeyManager defaultKeyManager = null;

    private void init() {
        Optional<String> kStore = Optional.of(System.getProperty("javax.net.ssl.keyStore"));
        Optional<String> kPassword = Optional.of(System.getProperty("javax.net.ssl.keyStorePassword"));

        try {
            final KeyStore keyStore = KeyStore.getInstance("JKS");
            try (final InputStream is = new FileInputStream(kStore.get())) {
                keyStore.load(is, kPassword.get().toCharArray());
            }
            final KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory
                    .getDefaultAlgorithm());
            kmf.init(keyStore, kPassword.get().toCharArray());

            final TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory
                    .getDefaultAlgorithm());
            tmf.init(keyStore);

            defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
            defaultKeyManager = (X509KeyManager) kmf.getKeyManagers()[0];

        }
        catch (GeneralSecurityException | IOException e) {
            log.error("Could not configure ssl correctly.  Check Key/TrustStore");
            throw new RuntimeException(e);
        }
    }

    /**
     * Constructor. Configures the TrustManagerFactory and gets the trust
     * manager.
     */
    public EpaX509TrustManager() {
            init();
    }

    /**
     * Given the partial or complete certificate chain provided by the peer,
     * build a certificate path to a trusted root and return if it can be
     * validated and is trusted for client SSL authentication based on the
     * authentication type.
     *
     * @see javax.net.ssl.X509TrustManager#checkClientTrusted(X509Certificate[],
     *      String)
     * @param x509Certificate
     *            Partial or complete certificate chain.
     * @param authType
     *            The authentication type.
     * @throws CertificateException
     *             Thrown if the certificate chain is not trusted by this
     *             TrustManager.
     */
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificate,
                                   String authType) throws CertificateException {

        defaultTrustManager.checkClientTrusted(x509Certificate, authType);
    }

    /**
     * Given the partial or complete certificate chain provided by the peer,
     * build a certificate path to a trusted root and return if it can be
     * validated and is trusted for server SSL authentication based on the
     * authentication type
     *
     * @see javax.net.ssl.X509TrustManager#checkServerTrusted(X509Certificate[],
     *      String)
     * @param x509Certificate
     *            Partial or complete certificate chain.
     * @param authType
     *            The authentication type.
     * @throws CertificateException
     *             Thrown if the certificate chain is not trusted by this
     *             TrustManager.
     */
    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificate,
                                   String authType) throws CertificateException {

        if (log.isDebugEnabled()) {
            log.debug("Checking if this server is trusted... ");
        }

        for (int j=0; j < x509Certificate.length; j++)
        {
            X509Certificate theCertificate = x509Certificate[j];

            if(log.isInfoEnabled())
            {
                log.info("  Server certificate information:");
                log.info("  Subject DN: " + theCertificate.getSubjectDN());
                log.info("  Issuer DN: " + theCertificate.getIssuerDN());
                log.info("  Serial number: " + theCertificate.getSerialNumber());

            }

            try {
                defaultTrustManager.checkServerTrusted(x509Certificate, authType);
            } catch (CertificateException e) {
                log.error("Error while checking server certificate.", e);
                throw e;
            }

            try{
                theCertificate.checkValidity();
            }catch(Exception e){

                log.error("checkcertificate Validity", e);
                log.error(e.getMessage());
                if(e.getMessage() != null && e.getMessage().contains("NotAfter"))
                {
                    throw new CertificateException("certificate expired");
                }
            }

        }

    }

    /**
     * Returns an array of certificate authority certificates which are trusted
     * for authenticating peers.
     *
     * @see javax.net.ssl.X509TrustManager#getAcceptedIssuers()
     * @return A non-null (possibly empty) array of acceptable CA issuer
     *         certificates.
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        log.info("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");

        return this.defaultTrustManager.getAcceptedIssuers();

    }

    public X509KeyManager getDefaultKeyManager() {
        return defaultKeyManager;
    }

    public X509TrustManager getDefaultTrustManager() {
        return defaultTrustManager;
    }
}
