package com.yb.base.utils.http;

import org.apache.http.client.HttpClient;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


public class HttpClients {

    /**
     * 普通http
     */
    public final static String HTTP_TYPE_COMMON = "1";
    /**
     * https无校验
     */
    public final static String HTTP_TYPE_AUTH_NONE = "2";
    /**
     * http单向认证
     */
    public final static String HTTP_TYPE_AUTH_SINGLE = "3";
    /**
     * http双向认证
     */
    public final static String HTTP_TYPE_AUTH_TWO = "4";

    /**
     * 获取httpClient
     *
     * @param httpType
     * @return
     */
    public static HttpClient createHttpClient(String httpType) {
        if (HttpClients.HTTP_TYPE_COMMON.equals(httpType)) {
            return org.apache.http.impl.client.HttpClients.createDefault();
        } else if (HttpClients.HTTP_TYPE_AUTH_NONE.equals(httpType)) {
            return createAuthNonHttpClient();
        } else if (HttpClients.HTTP_TYPE_AUTH_SINGLE.equals(httpType)) {
            throw new UnsupportedOperationException("");
        } else if (HttpClients.HTTP_TYPE_AUTH_TWO.equals(httpType)) {
            throw new UnsupportedOperationException("");
        }
        throw new UnsupportedOperationException("");
    }

    public static HttpClient createAuthNonHttpClient() {
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(100000).build();
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        //指定信任密钥存储对象和连接套接字工厂
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, new AnyTrustStrategy()).build();
            LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registryBuilder.register("https", sslSF);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        //设置连接参数
        ConnectionConfig connConfig = ConnectionConfig.custom().setCharset(Charset.forName("utf-8")).build();
        //设置连接管理器
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
        connManager.setDefaultConnectionConfig(connConfig);
        connManager.setDefaultSocketConfig(socketConfig);
        //指定cookie存储对象
        BasicCookieStore cookieStore = new BasicCookieStore();
        return HttpClientBuilder.create().setDefaultCookieStore(cookieStore).setConnectionManager(connManager).build();
    }

    private static class AnyTrustStrategy implements TrustStrategy {

        @Override
        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            return true;
        }
    }

}
