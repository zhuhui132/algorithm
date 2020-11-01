//package com.httpclient;
//
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.apache.tools.ant.util.FileUtils;
//
//import java.io.File;
//import java.io.IOException;
//
//public class HttpClientDemo {\
//
//
//    /**
//     * 使用HttpClient发送请求、接收响应，一般需要以下步骤。
//     * HttpGet请求响应的一般步骤：
//     * 1). 创建HttpClient对象,可以使用HttpClients.createDefault()；
//     * 2). 如果是无参数的GET请求，则直接使用构造方法HttpGet(String url)创建HttpGet对象即可；
//     * 如果是带参数GET请求，则可以先使用URIBuilder(String url)创建对象，再调用addParameter(String param, String value)，或setParameter(String param, String value)来设置请求参数，并调用build()方法构建一个URI对象。只有构造方法HttpGet(URI uri)来创建HttpGet对象。
//     * 3). 创建HttpResponse，调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。通过调用getStatusLine().getStatusCode()可以获取响应状态码。
//     * 4). 释放连接。
//     *
//     * HttpPost请求响应的一般步骤：
//     * 1). 创建HttpClient对象,可以使用HttpClients.createDefault()；
//     * 2). 如果是无参数的GET请求，则直接使用构造方法HttpPost(String url)创建HttpPost对象即可；
//     * 如果是带参数POST请求，先构建HttpEntity对象并设置请求参数，然后调用setEntity(HttpEntity entity)创建HttpPost对象。
//     * 3). 创建HttpResponse，调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。通过调用getStatusLine().getStatusCode()可以获取响应状态码。
//     * 4). 释放连接。
//     * @param args
//     */
//    public static void main(String[] args) {
//        // 创建Httpclient对象
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        // 创建http GET请求
//        HttpGet httpGet = new HttpGet("http://www.baidu.com");
//        CloseableHttpResponse response = null;
//        try {
//            // 执行请求
//            response = httpclient.execute(httpGet);
//            // 判断返回状态是否为200
//            if (response.getStatusLine().getStatusCode() == 200) {
//                //请求体内容
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                //内容写入文件
//                FileUtils.writeStringToFile(new File("E:\\devtest\\baidu.html"), content, "UTF-8");
//                System.out.println("内容长度："+content.length());
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (response != null) {
//                response.close();
//            }
//            //相当于关闭浏览器
//            httpclient.close();
//        }
//    }
//}
