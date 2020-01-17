package com.algorithm.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;

@SuppressWarnings("all")
public class HttpsUtil {
   
   protected final Log LOG = LogFactory.getLog(HttpsUtil.class);
   private static HttpsUtil instance;
   protected Charset charset;
   private int timeOut=10000;//10s download not set timeout
   
   
   public static DefaultHttpClient getHttpsClient() {
      try {
         SSLContext ctx = SSLContext.getInstance("TLS");
         X509TrustManager tm = new X509TrustManager() {

            @Override
            public void checkClientTrusted(
                  java.security.cert.X509Certificate[] chain,
                  String authType)
                  throws java.security.cert.CertificateException {
            }

            @Override
            public void checkServerTrusted(
                  java.security.cert.X509Certificate[] chain,
                  String authType)
                  throws java.security.cert.CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
               return null;
            }

         };
         DefaultHttpClient client = new DefaultHttpClient();
         ctx.init(null, new TrustManager[] { tm }, null);
         SSLSocketFactory ssf = new SSLSocketFactory(ctx);

         ClientConnectionManager ccm = client.getConnectionManager();
         SchemeRegistry sr = ccm.getSchemeRegistry();
         // 设置要使用的端口，默认是443
         sr.register(new Scheme("https", 443, ssf));
         return client;
      } catch (Exception ex) {
         return null;
      }
   }
   
   private HttpsUtil(){}
   
   public static HttpsUtil getInstance() {
      return getInstance(Charset.defaultCharset());
   }
   
   public static HttpsUtil getInstance(Charset charset){
        if(instance == null){
            instance = new HttpsUtil();
        }
        instance.setCharset(charset);
        return instance;
    }
   
   public void setCharset(Charset charset) {
      this.charset = charset;
   }

   /**
    * post请求 
    */
    public String doPost(String url) throws Exception {
       return doPost(url, null, null);
    }
        
   public String doPost(String url, Map<String, Object> params) throws Exception {
      return doPost(url, params, null);
   }
   
   public String doPost(String url, Map<String, Object> params, Map<String, String> header) throws Exception {
      String body = null;
      try {
         // Post请求
         LOG.debug(" protocol: POST");
         LOG.debug("      url: " + url);
           HttpPost httpPost = new HttpPost(url.trim());
           RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeOut) .setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
           httpPost.setConfig(requestConfig);
           // 设置参数
           LOG.debug("   params: " + JSON.toJSONString(params));
           httpPost.setEntity(new UrlEncodedFormEntity(map2NameValuePairList(params), charset));
           // 设置Header
           if (header != null && !header.isEmpty()) {
              LOG.debug("   header: " + JSON.toJSONString(header));
              for (Iterator<Entry<String, String>> it = header.entrySet().iterator(); it.hasNext();) {
                 Map.Entry<String, String> entry = (Entry<String, String>) it.next();
                 httpPost.setHeader(new BasicHeader(entry.getKey(), entry.getValue()));
              }
           }
           // 发送请求,获取返回数据
           body = execute(httpPost);
      } catch (Exception e) {
         throw e;
      }
      LOG.debug("   result: " + body);
      return body;
   }
   
   /**
    * postJson请求 
    */
   public String doPostJson(String url, Map<String, Object> params) throws Exception {
      return doPostJson(url, params, null);
   }
   
   public String doPostJson(String url, Map<String, Object> params, Map<String, String> header) throws Exception {
      String json = null;
        if (params != null && !params.isEmpty()) {
           for (Iterator<Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Object> entry = (Entry<String, Object>) it.next();
            Object object = entry.getValue();
            if (object == null) {
               it.remove();
            }
         }
           json = JSON.toJSONString(params);
           //json = JSON.toJSON(params);
      }
      return postJson(url, json, header);
   }
   
   public String doPostJson(String url, String json) throws Exception {
      return doPostJson(url, json, null);
   }
   
   public String doPostJson(String url, String json, Map<String, String> header) throws Exception {
      return postJson(url, json, header);
   }
   
   private String postJson(String url, String json, Map<String, String> header) throws Exception {
      String body = null;
      try {
         // Post请求
         LOG.debug(" protocol: POST");
         LOG.debug("      url: " + url);
           HttpPost httpPost = new HttpPost(url.trim());
           RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeOut) .setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
           httpPost.setConfig(requestConfig);
           // 设置参数
           LOG.debug("   params: " + json);
           StringEntity entity = new StringEntity(json, ContentType.DEFAULT_TEXT.withCharset(charset));
           httpPost.setEntity(entity);
           httpPost.setHeader(new BasicHeader("Content-Type", "application/json"));
           LOG.debug("     type: JSON");
           // 设置Header
           if (header != null && !header.isEmpty()) {
              LOG.debug("   header: " + JSON.toJSONString(header));
              for (Iterator<Entry<String, String>> it = header.entrySet().iterator(); it.hasNext();) {
                 Map.Entry<String, String> entry = (Entry<String, String>) it.next();
                 httpPost.setHeader(new BasicHeader(entry.getKey(), entry.getValue()));
              }
           }
           // 发送请求,获取返回数据
           body = execute(httpPost);
      } catch (Exception e) {
         throw e;
      }
      LOG.debug("  result: " + body);
      return body;
   }

   /**
    * get请求
    */
   public String doGet(String url) throws Exception {
      return doGet(url, null, null);
   }
   
   public String doGet(String url, Map<String, String> header) throws Exception {
      return doGet(url, null, header);
   }
   
   public String doGet(String url, Map<String, Object> params, Map<String, String> header) throws Exception {
      String body = null;
      try {
         // Get请求
         LOG.debug("protocol: GET");
         HttpGet httpGet = new HttpGet(url.trim());
          RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeOut) .setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
          httpGet.setConfig(requestConfig);
         // 设置参数
         if (params != null && !params.isEmpty()) {
               String str = EntityUtils.toString(new UrlEncodedFormEntity(map2NameValuePairList(params), charset));
               String uri = httpGet.getURI().toString();
               if(uri.indexOf("?") >= 0){
                  httpGet.setURI(new URI(httpGet.getURI().toString() + "&" + str));
               }else {
                  httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str));
               }
         }
         LOG.debug("     url: " + httpGet.getURI());
         // 设置Header
           if (header != null && !header.isEmpty()) {
              LOG.debug("   header: " + header);
              for (Iterator<Entry<String, String>> it = header.entrySet().iterator(); it.hasNext();) {
                 Map.Entry<String, String> entry = (Entry<String, String>) it.next();
                 httpGet.setHeader(new BasicHeader(entry.getKey(), entry.getValue()));
              }
           }
         // 发送请求,获取返回数据
         body =  execute(httpGet);
      } catch (Exception e) {
         throw e;
      }
      LOG.debug("  result: " + body);
      return body;
   }

   /**
    * 下载文件
    */
   public void doDownload(String url, String path) throws Exception {
      download(url, null, path);
   }
   
   public void doDownload(String url, Map<String, Object> params, String path) throws Exception {
      download(url, params, path);
   }
   
   /**
    * 上传文件
    */
   public String doUpload(String url, String name, String path) throws Exception {
      Map<String, Object> params = new HashMap<String, Object>();
      params.put(name, new File(path));
      return doUpload(url, params);
   }
   
   public String doUpload(String url, Map<String, Object> params) throws Exception {
      String body = null;
      // Post请求
        HttpPost httpPost = new HttpPost(url.trim());
        // 设置参数
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        entityBuilder.setCharset(charset);
        if (params != null && !params.isEmpty()) {
           Iterator<String> it = params.keySet().iterator();
         while (it.hasNext()) {
            String key = it.next();
            Object value = params.get(key);
            if (value instanceof File) {
               FileBody fileBody = new FileBody((File) value);
                  entityBuilder.addPart(key, fileBody);
            } else {
               entityBuilder.addPart(key, new StringBody(String.valueOf(value), ContentType.DEFAULT_TEXT.withCharset(charset)));
            }
         }
        }
        HttpEntity entity = entityBuilder.build();
        httpPost.setEntity(entity);
        // 发送请求,获取返回数据
        body = execute(httpPost);
      return body;
   }
   
   private void download(String url, Map<String, Object> params, String path) throws Exception {
      // Get请求
      HttpGet httpGet = new HttpGet(url.trim());
      if (params != null && !params.isEmpty()) {
         // 设置参数
         String str = EntityUtils.toString(new UrlEncodedFormEntity(map2NameValuePairList(params)));
         String uri = httpGet.getURI().toString();
         if (uri.indexOf("?") >= 0) {
            httpGet.setURI(new URI(httpGet.getURI().toString() + "&" + str));
         } else {
            httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str));
         }
      }
        // 发送请求,下载文件
        downloadFile(httpGet, path);
   }
 
   private void downloadFile(HttpRequestBase requestBase, String path) throws Exception {
      CloseableHttpClient httpclient = HttpClients.createDefault();
      try {
         CloseableHttpResponse response = httpclient.execute(requestBase);
         try {
            HttpEntity entity = response.getEntity();
            
            if (entity != null) {
               byte[] b = EntityUtils.toByteArray(entity);
               OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(path)));
               out.write(b);
               out.flush();
               out.close();
                }
            EntityUtils.consume(entity);
         } catch (Exception e) {
            throw e;
         } finally {
            response.close();
         }
      } catch (Exception e) {
         throw e;
      } finally {
         httpclient.close();
      }
   }
 
   private String execute(HttpRequestBase requestBase) throws Exception {
      CloseableHttpClient httpclient = getHttpsClient();
      HttpParams params=httpclient.getParams();
      params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeOut);
      params.setParameter(CoreConnectionPNames.SO_TIMEOUT, timeOut);
      String body = null;
      try {
         CloseableHttpResponse response = httpclient.execute(requestBase);
         try {
            HttpEntity entity = response.getEntity();
            
            if (entity != null) {
               body = EntityUtils.toString(entity, charset.toString());
                }
            EntityUtils.consume(entity);
         } catch (Exception e) {
            throw e;
         }finally {
            response.close();
         }
      } catch (Exception e) {
         throw e;
      } finally {
         httpclient.close();
      }
      return body;
   }
   
   private List<NameValuePair> map2NameValuePairList(Map<String, Object> params) {
      if (params != null && !params.isEmpty()) {
         List<NameValuePair> list = new ArrayList<NameValuePair>();
         Iterator<String> it = params.keySet().iterator();
         while (it.hasNext()) {
            String key = it.next();
            if(params.get(key) != null) {
               String value = String.valueOf(params.get(key));
               list.add(new BasicNameValuePair(key, value));
            }
         }
         return list;
      }
      return null;
   }
   
   public void downLoad(String url, String localFileName) {
                DefaultHttpClient httpClient = new DefaultHttpClient();
               OutputStream out = null;
               InputStream in = null;
               
       try {
                    HttpGet httpGet = new HttpGet(url);
                   HttpResponse httpResponse = httpClient.execute(httpGet);
                   HttpEntity entity = httpResponse.getEntity();
                   in = entity.getContent();
       
                   long length = entity.getContentLength();
                   if (length <= 0) {
                       System.out.println("下载文件不存在！");
                       return;
                   }
       
                   System.out.println("The response value of token:" + httpResponse.getFirstHeader("token"));
       
                   File file = new File(localFileName);
                   if(!file.exists()){
                       file.createNewFile();
                   }
                   
                   out = new FileOutputStream(file);  
                   byte[] buffer = new byte[4096];
                   int readLength = 0;
                   while ((readLength=in.read(buffer)) > 0) {
                       byte[] bytes = new byte[readLength];
                       System.arraycopy(buffer, 0, bytes, 0, readLength);
                       out.write(bytes);
                   }
             
                   out.flush();
                   
               }catch (Exception e){
                   e.printStackTrace();
               }finally{
                   try {
                       if(in != null){
                           in.close();
                       }
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                   
                   try {
                       if(out != null){
                           out.close();
                       }
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
}