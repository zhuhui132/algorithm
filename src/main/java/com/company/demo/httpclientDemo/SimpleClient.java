//package com.company.demo.httpclientDemo;
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//
//public class SimpleClient {
//    public static void main(String[] args) {
//        HttpClient httpClient = new DefaultHttpClient();
//        ((DefaultHttpClient) httpClient).setProxyAuthenticationStrategy();
//
//
//    }
//
//    private void getDemo(){
//        HttpClient client = new HttpClient();
//        // 设置代理服务器地址和端口
//        client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
//        // 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
//        HttpMethod method=new GetMethod("http://java.sun.com");
//        //使用POST方法
//        //HttpMethod method = new PostMethod("http://java.sun.com");
//        client.executeMethod(method);
//
//        //打印服务器返回的状态
//        System.out.println(method.getStatusLine());
//        //打印返回的信息
//        System.out.println(method.getResponseBodyAsString());
//        //释放连接
//        method.releaseConnection();
//    }
//
//    //使用POST方式提交数据(httpClient3)
//
///**
// * httpclient使用了单独的一个HttpMethod子类来处理文件的上传，
// * 这个类就是MultipartPostMethod，
// * 该类已经封装了文件上传的细节，
// * 我们要做的仅仅是告诉它我们要上传文件的全路径即可，
// * 下面这里将给出关于两种模拟上传方式的代码
// */
//
//    /**
//     * 上传url文件到指定URL
//     * @param fileUrl 上传图片url
//     * @param postUrl 上传路径及参数,注意有些中文参数需要使用预先编码 eg : URLEncoder.encode(appName, "UTF-8")
//     * @return
//     * @throws IOException
//     */
//    public static String doUploadFile(String postUrl) throws IOException {
//        if(StringUtils.isEmpty(postUrl))
//            return null;
//        String response = "";
//        PostMethod postMethod = new PostMethod(postUrl);
//        try {
//            HttpClient client = new HttpClient();
//            client.getHttpConnectionManager().getParams()
//                    .setConnectionTimeout(50000);// 设置连接时间
//            int status = client.executeMethod(postMethod);
//            if (status == HttpStatus.SC_OK) {
//                InputStream inputStream = postMethod.getResponseBodyAsStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(
//                        inputStream));
//                StringBuffer stringBuffer = new StringBuffer();
//                String str = "";
//                while ((str = br.readLine()) != null) {
//                    stringBuffer.append(str);
//                }
//                response = stringBuffer.toString();
//            } else {
//                response = "fail";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 释放连接
//            postMethod.releaseConnection();
//        }
//        return response;
//    }
//
//}