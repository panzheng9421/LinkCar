package com.linkcar.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 */
public class HttpClientUtil {
    private static class SingletonHolder {
        private final static HttpClientUtil INSTANCE = new HttpClientUtil();
    }

    private HttpClientUtil() {
    }

    public static HttpClientUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static String get(String url) {
        CharsetHandler handler = new CharsetHandler("UTF-8");
        CloseableHttpClient client = null;
        try {
            HttpGet httpget = new HttpGet(new URI(url));
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            client = httpClientBuilder.build();
            client = (CloseableHttpClient) wrapClient();
            return Objects.requireNonNull(client).execute(httpget, handler);
        } catch (Exception e) {
            return "";
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String get(String url, Map<String, String> handlerMap) {
        CharsetHandler handler = new CharsetHandler("UTF-8");
        CloseableHttpClient client = null;
        try {
            HttpGet httpget = new HttpGet(new URI(url));
            if (!handlerMap.isEmpty()) {
                for (Map.Entry<String, String> entry : handlerMap.entrySet()) {
                    httpget.setHeader(entry.getKey(), entry.getValue());
                }
            }
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            client = httpClientBuilder.build();
            client = (CloseableHttpClient) wrapClient();
            return Objects.requireNonNull(client).execute(httpget, handler);
        } catch (Exception e) {
            return "";
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String postParams(String url, Map<String, String> params) {

        //创建HttpClientBuilder	
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient	
        CloseableHttpClient client = httpClientBuilder.build();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse res = null;
        try {

            List<NameValuePair> nvps = new ArrayList<>();
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                nvps.add(new BasicNameValuePair(key, params.get(key)));
            }
            post.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            res = client.execute(post);
            HttpEntity entity = res.getEntity();
            return EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(res).close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String post(String url, String params, String contentType) {

        //创建HttpClientBuilder	
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient	
        CloseableHttpClient client = httpClientBuilder.build();
        client = (CloseableHttpClient) wrapClient();


        HttpPost post = new HttpPost(url);
        CloseableHttpResponse res = null;
        try {
            StringEntity s = new StringEntity(params, "UTF-8");
            if (StringUtil.isEmpty(contentType)) {
                s.setContentType("application/json;charset=utf8");
            }
            s.setContentType(contentType);
            s.setContentEncoding("utf-8");
            post.setEntity(s);
            res = Objects.requireNonNull(client).execute(post);
            HttpEntity entity = res.getEntity();
            return EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(res).close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String post(String url, String params, String contentType, Map<String, String> handlerMap) {

        //创建HttpClientBuilder	
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient	
        CloseableHttpClient client = httpClientBuilder.build();
        client = (CloseableHttpClient) wrapClient();


        HttpPost post = new HttpPost(url);
        CloseableHttpResponse res = null;
        try {
            StringEntity s = new StringEntity(params, "UTF-8");
            if (StringUtil.isEmpty(contentType)) {
                s.setContentType("application/json;charset=utf8");
            }
            s.setContentType(contentType);
            s.setContentEncoding("utf-8");
            post.setEntity(s);
            if (!handlerMap.isEmpty()) {
                for (Map.Entry<String, String> entry : handlerMap.entrySet()) {
                    post.setHeader(entry.getKey(), entry.getValue());
                }
            }
            res = Objects.requireNonNull(client).execute(post);
            HttpEntity entity = res.getEntity();
            return EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(res).close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    public static String post(String urlStr, String xmlInfo) {
        StringBuilder line1 = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "text/xml");

            OutputStreamWriter out = new OutputStreamWriter(con
                    .getOutputStream());
            out.write(new String(xmlInfo.getBytes("utf-8")));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con
                    .getInputStream()));
            String line;
            for (line = br.readLine(); line != null; line = br.readLine()) {
                line1.append(line);
            }
            return new String(line1.toString().getBytes(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class CharsetHandler implements ResponseHandler<String> {
        private String charset;

        CharsetHandler(String charset) {
            this.charset = charset;
        }

        @Override
        public String handleResponse(HttpResponse response) throws IOException {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(),
                        statusLine.getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                if (!StringUtil.isEmpty(charset)) {
                    return EntityUtils.toString(entity, charset);
                } else {
                    return EntityUtils.toString(entity);
                }
            } else {
                return null;
            }
        }
    }

    private static HttpClient wrapClient() {
        try {
            SSLContext ctx = SSLContext.getInstance("TLSv1.2");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String string) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String string) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(ctx, new String[]{"TLSv1.2"}, null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();

        } catch (Exception ex) {
            return null;
        }
    }
}	
