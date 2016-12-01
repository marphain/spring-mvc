package com.marphain.demo.communication.netty.context;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.Security;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import com.marphain.demo.communication.netty.utils.IConstants;

public final class SslContextFactory
{

    private static final String PROTOCOL = "SSL";

    private SslContextFactory()
    {
        // Unused
    }

    public static SSLContext getSslContext(String keystorePath)
    {
        String algorithm = Security.getProperty("ssl.KeyManagerFactory.algorithm");
        if (algorithm == null)
        {
            // X509是一种通用的证书格式，使用ASN.1描述
            algorithm = "SunX509";
        }

        SSLContext sslContext;
        try (InputStream kmStream = new FileInputStream(keystorePath);
                InputStream tmStream = new FileInputStream(keystorePath))
        {
            // stream.mark(stream.available());

            // 获取本端证书，用于对端认证（keystore的类型有JKS、JCEKS、PKCS12、BKS、UBER)
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(kmStream, IConstants.KEYSTORE_PASS.toCharArray());
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(algorithm);
            kmf.init(ks, IConstants.KEY_PASS.toCharArray());

            // 获取本端受信任的证书，用于认证对端
            // stream.reset();
            KeyStore ts = KeyStore.getInstance("JKS");
            ts.load(tmStream, IConstants.KEYSTORE_PASS.toCharArray());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
            tmf.init(ts);

            // Initialize the SSLContext to work with our key managers.
            sslContext = SSLContext.getInstance(PROTOCOL);
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            return sslContext;
        }
        catch (Exception e)
        {
            throw new Error("Failed to initialize the server-side SSLContext", e);
        }
    }

}
