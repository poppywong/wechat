/**
 * */
package com.eightspace.weixin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.util.StringUtils;

import com.eightspace.server.common.log.LogManagment;

/**
 * HttpsUtil工具类
 * 
 * @author Frank
 * @date 2014-4-2
 * @since 1.0
 */
public class HttpsUtil {

    private static final String DEFAULT_CHARSET = "utf-8";

    /**
     * log
     */
    private static LogManagment log = LogManagment.getLogger(HttpsUtil.class);



    public static String doPost(String url, String method, String params, String charset, int connectTimeout,
        int readTimeout) throws Exception {
        String ctype = "application/json;charset=" + charset;
        byte[] content = {};
        if (params != null) {
            content = params.getBytes(charset);
        }
        return doPost(url, method, ctype, content, connectTimeout, readTimeout);
    }



    public static String doPost(String url, String method, String ctype, byte[] content, int connectTimeout,
        int readTimeout) {
        HttpsURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        SSLContext ctx;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
            SSLContext.setDefault(ctx);
            conn = getConnection(new URL(url), method, ctype);
            conn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            // 设置连接主机超时（单位：毫秒）
            conn.setConnectTimeout(connectTimeout);
            // 设置从主机读取数据超时（单位：毫秒）
            conn.setReadTimeout(readTimeout);
            out = conn.getOutputStream();
            out.write(content);
            rsp = getResponseAsString(conn);
        } catch (NoSuchAlgorithmException e) {
            log.error(url);
            log.error("HttpsUtil-doPost:异常", e);
        } catch (KeyManagementException e) {
            log.error(url);
            log.error("HttpsUtil-doPost:异常", e);
        } catch (MalformedURLException e) {
            log.error(url);
            log.error("HttpsUtil-doPost:异常", e);
        } catch (IOException e) {
            log.error(url);
            log.error("HttpsUtil-doPost:异常", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("HttpsUtil-doPost:流关闭异常", e);
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rsp;
    }

    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }



        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }



        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }



    private static HttpsURLConnection getConnection(URL url, String method, String ctype) throws IOException {
        HttpsURLConnection conn = ( HttpsURLConnection ) url.openConnection();
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
        conn.setRequestProperty("User-Agent", "stargate");
        conn.setRequestProperty("Content-Type", ctype);
        return conn;
    }



    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        String charset = getResponseCharset(conn.getContentType());
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), charset);
        } else {
            String msg = getStreamAsString(es, charset);
            if (StringUtils.isEmpty(msg)) {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                throw new IOException(msg);
            }
        }
    }



    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            StringWriter writer = new StringWriter();
            char[] chars = new char[256];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }
            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }



    private static String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;
        if (!StringUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtils.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }
        return charset;
    }

}
