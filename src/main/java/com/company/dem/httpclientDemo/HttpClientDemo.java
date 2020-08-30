package com.company.dem.httpclientDemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

public class HttpClientDemo {

    String userName = "username";
    String password = "password";
    String loginUrl = "http://passport.cnblogs.com/login.aspx";
    String dataUrl = "http://home.cnblogs.com/";

    public static void main(String[] args) {
        doGetTestOne();

    }

    public static void doGetTestOne() {


        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://www.zhihu.com/api/v3/feed/topstory/recommend");


        CloseableHttpResponse response = null;

        try {
            response = ((CloseableHttpClient) httpClient).execute(httpGet);

            HttpEntity entity = response.getEntity();
            System.out.println(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void HttpClientLogin(String userName,
                                        String password,
                                        String loginUrl,
                                        String dataUrl){

        HttpClient httpClient = new HttpClient() {
            @Override
            public HttpParams getParams() {
                return null;
            }

            @Override
            public ClientConnectionManager getConnectionManager() {
                return null;
            }

            @Override
            public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
                return null;
            }

            @Override
            public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;
            }
        };

    }
}
